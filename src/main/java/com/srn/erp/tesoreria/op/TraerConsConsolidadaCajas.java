package com.srn.erp.tesoreria.op;

import java.util.Iterator;

import com.srn.erp.general.bm.Sucursal;
import com.srn.erp.tesoreria.bm.Caja;
import com.srn.erp.tesoreria.bm.GrupoCajas;
import com.srn.erp.tesoreria.bm.GrupoCajasDet;
import com.srn.erp.tesoreria.bm.SaldoEfectivo;
import com.srn.erp.tesoreria.bm.SaldoTipoValor;
import com.srn.erp.tesoreria.bm.TipoValor;

import framework.applicarionServer.bl.Presentacion.Grilla;
import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bm.Varios.CalculadorMoney;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerConsConsolidadaCajas extends Operation {

	public TraerConsConsolidadaCajas() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		GrupoCajas grupoCajas = GrupoCajas.findByOidProxy(mapaDatos.getInteger("oid_grupo_caja"), this.getSesion());

		if (mapaDatos.containsKey("estructura")) 
			enviarEstructura(grupoCajas);
			else if (mapaDatos.containsKey("consulta")) 
					enviarConsulta(grupoCajas);
			
		

	}

	private void enviarConsulta(GrupoCajas grupoCajas) throws BaseException {
		IDataSet dsConsultas = getDataSetConsulta(grupoCajas);
		enviarDatosConsulta(dsConsultas,grupoCajas);
		writeCliente(dsConsultas);
	}
	
	private void enviarDatosConsulta(IDataSet dsConsultas,GrupoCajas grupoCajas) throws BaseException {
		Iterator iterTipoValores =
			TipoValor.getTiposValoresConMoviEnCaja(this.getSesion()).iterator();
		while (iterTipoValores.hasNext()) {
			TipoValor tipoValor = (TipoValor) iterTipoValores.next();
			HashTableDatos saldosPorCaja = new HashTableDatos();
			HashTableDatos acumPorSuc = new HashTableDatos();
			// Procesarlo para las cajas involucradas
			Iterator iterGrupoCajasDet = 
				grupoCajas.getGrupoCajasDet().iterator();
			while (iterGrupoCajasDet.hasNext()) {
				GrupoCajasDet grupoCajasDet = (GrupoCajasDet) iterGrupoCajasDet.next();
				if (!grupoCajasDet.isActivo()) continue;
				Caja caja = grupoCajasDet.getCaja();
				
				
				
				Money saldoFinal = new Money(0);
				
				if (tipoValor.isEfectivo()) {
					SaldoEfectivo saldoEfectivo = (SaldoEfectivo) caja.getSaldoEfectivo(tipoValor); 
					if (saldoEfectivo!=null)
						saldoFinal = saldoEfectivo.getSaldo();
				} else {
					SaldoTipoValor saldoTipoValor = caja.getSaldoTipoValorAHoy(tipoValor);
					if (saldoTipoValor!=null)
						saldoFinal = saldoTipoValor.getSaldo_final();
				}
				
				if (saldoFinal == null)
					saldoFinal = new Money(0);
				saldosPorCaja.put(caja.getOIDInteger(), saldoFinal);
				
				// Acumular por sucursal
				Sucursal sucu = caja.getUnidadorganizativa().getSucursal();
				CalculadorMoney totPorSuc = (CalculadorMoney)acumPorSuc.get(sucu.getOIDInteger());
				if (totPorSuc == null) {
					totPorSuc = new CalculadorMoney(new Money(0));
					acumPorSuc.put(sucu.getOIDInteger(), totPorSuc);
				}
				totPorSuc.sumar(saldoFinal);
				
			}
			
			// Enviar el renglon
			dsConsultas.append();
			dsConsultas.fieldValue("desc_moneda", tipoValor.getMoneda().getDescripcion());
			dsConsultas.fieldValue("tipo_de_valor", tipoValor.getDescripcion());
			dsConsultas.fieldValue("oid_tipo_valor", tipoValor.getOIDInteger());

			// Recorrer los campos de cajas
			Iterator iterSucursales = Sucursal.getSucursales(grupoCajas, this.getSesion()).iterator();
			while (iterSucursales.hasNext()) {
				Sucursal sucursal = (Sucursal) iterSucursales.next();
				
				// Armar un campo respetando el mismo criterio
				Iterator iterCajas = 
					sucursal.getCajas().iterator();
				while (iterCajas.hasNext()) {
					Caja caja = (Caja) iterCajas.next();
					if (grupoCajas.getGrupoCajasDet(caja)==null) continue;
					Money totCaja = (Money)saldosPorCaja.get(caja.getOIDInteger());
					dsConsultas.fieldValue("caja_"+caja.getOIDInteger(), totCaja);
				}
				
				if (sucursal.getCantCajasGrupo(grupoCajas)>1) {
					CalculadorMoney calcTotSuc = (CalculadorMoney)acumPorSuc.get(sucursal.getOIDInteger());
					if (calcTotSuc == null)
						calcTotSuc = new CalculadorMoney(new Money(0));
					dsConsultas.fieldValue("tot_suc_"+sucursal.getOIDInteger(), calcTotSuc.getResultMoney());					
				}
				
				
			}
			
			
			
		}
	}

	
	private void enviarEstructura(GrupoCajas grupoCajas) throws BaseException {

		IDataSet dsBandas = this.getDataSetBandas();
		IDataSet dsColumnas = this.getDataSetColGrilla();
		IDataSet dsCamposTabla = this.getDataSetCampos();

		
		HashTableDatos bandIndexSuc = new HashTableDatos();
		int bandaIndex = 1;
		
		// Traer las Bandas
		cargarBanda(dsBandas, -1, "", 160);
		Iterator iterSucursales = Sucursal.getSucursales(grupoCajas, this.getSesion()).iterator();
		while (iterSucursales.hasNext()) {
			Sucursal sucursal = (Sucursal) iterSucursales.next();
			int anchoBanda = 0;
			int cantCajas = sucursal.getCantCajasGrupo(grupoCajas);
			if (cantCajas == 1)
				anchoBanda = 100;
			else
				anchoBanda = (cantCajas + 1) * 100; // Contemplar columna del
			bandIndexSuc.put(sucursal.getOIDInteger(),bandaIndex);
			++bandaIndex;
			cargarBanda(dsBandas, sucursal.getOIDInteger(), sucursal.getDescripcion(), anchoBanda);
		}
		
		// Traer las Columnas
		// Primer columna del Tipo de Valores

		
  		cargaColGrilla(dsColumnas,
  				new Integer(1000),
  				Grilla.TIPO_COL_ESTANDAR,
  				"Monedas",
  				"desc_moneda",
  				new Integer(-1),
  				new Integer(110),
  				new Boolean(true),
  				new Boolean(true),
  				"",
  				new Boolean(false),
  				"",
  				new Boolean(true),
  				new Integer(1)
  				);
		
		
  		cargaColGrilla(dsColumnas,
  				new Integer(1000),
  				Grilla.TIPO_COL_ESTANDAR,
  				"Tipo de Valores",
  				"tipo_de_valor",
  				new Integer(0),
  				new Integer(110),
  				new Boolean(true),
  				new Boolean(true),
  				"",
  				new Boolean(false),
  				"",
  				new Boolean(false),
  				new Integer(0)
  				);
		

		iterSucursales = Sucursal.getSucursales(grupoCajas, this.getSesion()).iterator();
		int bandIndex = 0;
		while (iterSucursales.hasNext()) {
			Sucursal sucursal = (Sucursal) iterSucursales.next();
			Iterator iterCajas = 
				sucursal.getCajas().iterator();
			while (iterCajas.hasNext()) {
				Caja caja = (Caja) iterCajas.next();
				
				if (grupoCajas.getGrupoCajasDet(caja)==null) continue;
				
				bandIndex = (Integer)bandIndexSuc.get(caja.getSucursal().getOIDInteger());
		  		cargaColGrilla(dsColumnas,
		  				new Integer(1000),
		  				Grilla.TIPO_COL_ESTANDAR,
		  				caja.getDescripcion(),
		  				"caja_"+caja.getOIDInteger(),
		  				bandIndex,
		  				new Integer(110),
		  				new Boolean(true),
		  				new Boolean(true),
		  				"###,###,###,###.##",
		  				new Boolean(false),
		  				"",
		  				new Boolean(false),
		  				new Integer(0)
		  				);
			}
			
			if (sucursal.getCantCajasGrupo(grupoCajas)>1)
		  		cargaColGrilla(dsColumnas,
		  				new Integer(1000),
		  				Grilla.TIPO_COL_ESTANDAR,
		  				" Tot. "+sucursal.getDescripcion(),
		  				"tot_suc_"+sucursal.getOIDInteger(),
		  				bandIndex,
		  				new Integer(110),
		  				new Boolean(true),
		  				new Boolean(true),
		  				"###,###,###,###.##",
		  				new Boolean(false),
		  				"",
		  				new Boolean(false),
		  				new Integer(0)
		  				);
			
		}
		
		// Crear estructura de la Tabla
	  	cargaCampoTab(dsCamposTabla,
	  			new Integer(1),
	  			Field.STRING,
	  			"desc_moneda",
	  			new Integer(50),
	  			new Boolean(false));
	  	
	  	cargaCampoTab(dsCamposTabla,
	  			new Integer(2),
	  			Field.STRING,
	  			"tipo_de_valor",
	  			new Integer(50),
	  			new Boolean(false));
	  	
	  	cargaCampoTab(dsCamposTabla,
	  			new Integer(3),
	  			Field.INTEGER,
	  			"oid_tipo_valor",
	  			new Integer(0),
	  			new Boolean(false));
	  	
	  	
	  	// Recorrer los campos de cajas
	  	int secuCampo = 3;
		iterSucursales = Sucursal.getSucursales(grupoCajas, this.getSesion()).iterator();
		while (iterSucursales.hasNext()) {
			Sucursal sucursal = (Sucursal) iterSucursales.next();
			
			// Armar un campo respetando el mismo criterio
			Iterator iterCajas = 
				sucursal.getCajas().iterator();
			while (iterCajas.hasNext()) {
				Caja caja = (Caja) iterCajas.next();
				if (grupoCajas.getGrupoCajasDet(caja)==null) continue;
			  	cargaCampoTab(dsCamposTabla,
			  			new Integer(secuCampo),
			  			Field.CURRENCY,
			  			"caja_"+caja.getOIDInteger(),
			  			new Integer(0),
			  			new Boolean(false));
			  	
			  	++secuCampo;
				
			}
			
			if (sucursal.getCantCajasGrupo(grupoCajas)>1)
			  	cargaCampoTab(dsCamposTabla,
			  			new Integer(secuCampo),
			  			Field.CURRENCY,
			  			"tot_suc_"+sucursal.getOIDInteger(),
			  			new Integer(0),
			  			new Boolean(false));
				
			
			
		}
	  	
	  	
	
  		

		writeCliente(dsBandas);
		writeCliente(dsColumnas);
		writeCliente(dsCamposTabla);

	}

	private IDataSet getDataSetBandas() {
		IDataSet dataset = new TDataSet();
		dataset.create("TBandas");
		dataset.fieldDef(new Field("secu", Field.INTEGER, 0));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 15));
		dataset.fieldDef(new Field("width", Field.INTEGER, 0));
		return dataset;
	}

	private void cargarBanda(IDataSet dataset, Integer secu, String descripcion, Integer aWidth) throws BaseException {
		dataset.append();
		dataset.fieldValue("secu", secu);
		dataset.fieldValue("descripcion", descripcion);
		dataset.fieldValue("width", aWidth);
	}

	private IDataSet getDataSetColGrilla() throws BaseException {
		IDataSet dataset = new TDataSet();
		dataset.create("TColGrilla");

		// Aspectos Fisicos
		dataset.fieldDef(new Field("secu", Field.INTEGER, 0));
		dataset.fieldDef(new Field("tipo_columna", Field.STRING, 50));
		dataset.fieldDef(new Field("titulo", Field.STRING, 50));
		dataset.fieldDef(new Field("field_name", Field.STRING, 50));
		dataset.fieldDef(new Field("band_index", Field.INTEGER, 0));
		dataset.fieldDef(new Field("ancho_col", Field.INTEGER, 0));
		dataset.fieldDef(new Field("read_only", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("can_focus", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("formato", Field.STRING, 50));
		dataset.fieldDef(new Field("evento_help", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("script_help", Field.STRING, 5000));
		dataset.fieldDef(new Field("agrupar", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("nro_agrupador", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nombre_columna", Field.STRING, 50));

		return dataset;

	}
	
	private void cargaColGrilla(IDataSet dataset, 
			Integer secu, 
			String tipoColumna, 
			String titulo, 
			String fieldName,
			Integer bandIndex, 
			Integer anchoCol, 
			Boolean readonly, 
			Boolean canFocus, 
			String formato, 
			Boolean eventoHelp,
			String scriptHelp, 
			Boolean agrupar, 
			Integer nroAgrupador) {

		dataset.append();
		dataset.fieldValue("secu", secu);
		dataset.fieldValue("tipo_columna", tipoColumna);
		dataset.fieldValue("titulo", titulo);
		dataset.fieldValue("field_name", fieldName);
		dataset.fieldValue("band_index", bandIndex);
		dataset.fieldValue("ancho_col", anchoCol);
		dataset.fieldValue("read_only", readonly);
		dataset.fieldValue("can_focus", canFocus);
		dataset.fieldValue("formato", formato);
		dataset.fieldValue("evento_help", eventoHelp);
		dataset.fieldValue("script_help", scriptHelp);
		dataset.fieldValue("agrupar", agrupar);
		dataset.fieldValue("nro_agrupador", nroAgrupador);
		dataset.fieldValue("nombre_columna", fieldName);
	}
	
	private IDataSet getDataSetCampos() {
		IDataSet dataset = new TDataSet();
		dataset.create("TCamposTabla");

		// Aspectos Fisicos
		dataset.fieldDef(new Field("secu", Field.INTEGER, 0));
		dataset.fieldDef(new Field("tipo", Field.STRING, 50));
		dataset.fieldDef(new Field("nombre_fisico", Field.STRING, 50));
		dataset.fieldDef(new Field("longitud", Field.INTEGER, 0));
		dataset.fieldDef(new Field("primaryKey", Field.BOOLEAN, 0));

		return dataset;
	}
	
	private IDataSet getDataSetConsulta(GrupoCajas grupoCajas) throws BaseException {
		IDataSet dataset = new TDataSet();
		dataset.create("TConsulta");

		// Aspectos Fisicos
		dataset.fieldDef(new Field("desc_moneda", Field.STRING, 50));
		dataset.fieldDef(new Field("tipo_de_valor", Field.STRING, 50));
		dataset.fieldDef(new Field("oid_tipo_valor", Field.INTEGER, 0));
		
		Iterator iterSucursales = Sucursal.getSucursales(grupoCajas, this.getSesion()).iterator();
		while (iterSucursales.hasNext()) {
			Sucursal sucursal = (Sucursal) iterSucursales.next();
			
			Iterator iterCajas = 
				sucursal.getCajas().iterator();
			while (iterCajas.hasNext()) {
				Caja caja = (Caja) iterCajas.next();
				if (grupoCajas.getGrupoCajasDet(caja)==null) continue;
				dataset.fieldDef(new Field("caja_"+caja.getOIDInteger(), Field.CURRENCY, 0));
			}
			if (sucursal.getCantCajasGrupo(grupoCajas)>1)
				dataset.fieldDef(new Field("tot_suc_"+sucursal.getOIDInteger(), Field.CURRENCY, 0));

			
		}
		
		return dataset;
	}
	
	
	private void cargaCampoTab(
			IDataSet dataset, 
			Integer secu, 
			String tipo, 
			String nombreFisico, 
			Integer longitud,
			Boolean primaryKey) {

		dataset.append();
		dataset.fieldValue("secu", secu);
		dataset.fieldValue("tipo", tipo);
		dataset.fieldValue("nombre_fisico", nombreFisico);
		dataset.fieldValue("longitud", longitud);
		dataset.fieldValue("primaryKey", primaryKey);


	}
  
	

}
