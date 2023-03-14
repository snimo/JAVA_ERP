package com.srn.erp.ctasACobrar.op;

import java.util.Iterator;
import java.util.List;

import com.srn.erp.ctacte.bm.TipoCtaCteClie;
import com.srn.erp.ctasACobrar.bm.ConsultaCtaCteClie;
import com.srn.erp.general.bm.Cotizacion;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.general.bm.TipoCambio;
import com.srn.erp.tesoreria.bm.TipoValor;
import com.srn.erp.tesoreria.bm.Valor;
import com.srn.erp.ventas.bm.Sujeto;

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

public class TraerCtaCteResuClie extends Operation {

	Sujeto sujeto = null;
	TipoCtaCteClie tipoCta = null;
	java.util.Date fecha = null;
	ConsultaResCtaCte consulta = new ConsultaResCtaCte();
	boolean incluirDeudaFinan = false;
	List listaMonedas = null;
	List tiposValores= null;
	
	/* Clase Integral para manejar la consulta */
	
	class ConsultaResCtaCte {
		
		HashTableDatos listaRenglones = new HashTableDatos();
		HashTableDatos listaMonedas = new HashTableDatos();
		HashTableDatos listaTV = new HashTableDatos();

		public void addMoneda(Moneda moneda) throws BaseException {
			if (listaMonedas.get(moneda.getOIDInteger())==null)
				listaMonedas.put(moneda.getOIDInteger(),moneda);
				
		}
		
		public void addTV(TipoValor tipoValor) throws BaseException {
			if (listaTV.get(tipoValor.getOIDInteger())==null)
				listaTV.put(tipoValor.getOIDInteger(),tipoValor);
		}
		
		
		
		public void add(Sujeto sujeto,
				        Moneda moneda,
				        Money saldo) throws BaseException {
			
			addMoneda(moneda);
			
			RenglonConsulta renglonConsulta = 
				(RenglonConsulta)listaRenglones.get(sujeto.getOIDInteger());
			
			if (renglonConsulta == null) {
				renglonConsulta = new RenglonConsulta();
				renglonConsulta.sujeto = sujeto;
				listaRenglones.put(sujeto.getOIDInteger(),renglonConsulta);
			} 
				
			renglonConsulta.addSaldoMoneda(moneda,saldo);
			
		}
		
		public void add(Sujeto sujeto,
		        TipoValor tipoValor,
		        Money saldo) throws BaseException {
	
			addTV(tipoValor);
	
			RenglonConsulta renglonConsulta = 
				(RenglonConsulta)listaRenglones.get(sujeto.getOIDInteger());
	
			if (renglonConsulta == null) {
				renglonConsulta = new RenglonConsulta();
				renglonConsulta.sujeto = sujeto;
				listaRenglones.put(sujeto.getOIDInteger(),renglonConsulta);
			} 
		
			renglonConsulta.addSaldoTV(tipoValor,saldo);
	
		}
		
		
	}
	
	/* Clase Interna para manear el rengon de la cosulta */
	
	class RenglonConsulta {
		
		public HashTableDatos saldosPorMoneda = new HashTableDatos();
		public HashTableDatos saldosPorTV = new HashTableDatos();
		public Sujeto sujeto;
		
		public void addSaldoMoneda(Moneda moneda,
				                       Money saldo) throws BaseException {
			
			
			Money nuevoSaldo = (Money)saldosPorMoneda.get(moneda.getOIDInteger());
			if (nuevoSaldo == null) {
				saldosPorMoneda.put(
						moneda.getOIDInteger(),
						saldo);
			} else {
				CalculadorMoney calcNuevoSaldo = new CalculadorMoney(nuevoSaldo);
				calcNuevoSaldo.sumar(saldo);
				saldosPorMoneda.put(
						moneda.getOIDInteger(),
						calcNuevoSaldo.getResultMoney());
				
			}
			
			
		}
		
		public void addSaldoTV(TipoValor tipoValor, Money saldo) throws BaseException {

			Money nuevoSaldo = (Money) saldosPorTV.get(tipoValor.getOIDInteger());
			if (nuevoSaldo == null) {
				saldosPorTV.put(tipoValor.getOIDInteger(), saldo);
			} else {
				CalculadorMoney calcNuevoSaldo = new CalculadorMoney(nuevoSaldo);
				calcNuevoSaldo.sumar(saldo);
				saldosPorTV.put(tipoValor.getOIDInteger(), calcNuevoSaldo.getResultMoney());

			}

		}
		
		
		public boolean isSinDeuda() {
			
			Iterator iterSaldosPorMon = saldosPorMoneda.values().iterator();
			while (iterSaldosPorMon.hasNext()) {
				Money saldo = (Money) iterSaldosPorMon.next();
				if (saldo.doubleValue()!=0)
					return false;
			}
			
			Iterator iterSaldosPorTV = saldosPorTV.values().iterator();
			while (iterSaldosPorTV.hasNext()) {
				Money saldo = (Money) iterSaldosPorTV.next();
				if (saldo.doubleValue()!=0)
					return false;
			}
			
			return true;
		}
		
		
		public Money getSaldo(Moneda moneda) throws BaseException {
			Money saldo = (Money)saldosPorMoneda.get(moneda.getOIDInteger());
			if (saldo == null)
				return new Money(0);
			else
				return saldo;
		}
		
		public Money getSaldo(TipoValor tipoValor) throws BaseException {
			Money saldo = (Money)saldosPorTV.get(tipoValor.getOIDInteger());
			if (saldo == null)
				return new Money(0);
			else
				return saldo;
		}
		
		
		
	}
		
	  
	
  public TraerCtaCteResuClie() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
  	
  	listaMonedas = Moneda.getAll(this.getSesion());
  	tiposValores= TipoValor.getTiposValoresDeudaFinanciera(this.getSesion());
  	
  	if (mapaDatos.containsKey("incluir_deuda_finan"))
  		incluirDeudaFinan = mapaDatos.getBoolean("incluir_deuda_finan");
  	
  	if (mapaDatos.containsKey("oid_sujeto") && (mapaDatos.getInteger("oid_sujeto").intValue()>0)) 
  		sujeto = Sujeto.findByOid(mapaDatos.getInteger("oid_sujeto"),this.getSesion());
  	
  	if (mapaDatos.containsKey("oid_tipo_cta") && (mapaDatos.getInteger("oid_tipo_cta").intValue()>0)) 
  		tipoCta = TipoCtaCteClie.findByOid(mapaDatos.getInteger("oid_tipo_cta"),this.getSesion());
  	
  	if (mapaDatos.containsKey("fecha")) 
  		fecha = mapaDatos.getDate("fecha");
  	
  	
  	if (mapaDatos.containsKey("ESTRUCTURA"))
  		enviarEstructura();
  	else if (mapaDatos.containsKey("CONSULTA")) {
  					traerCtaCte();
  					if (incluirDeudaFinan)
  						traerValoresFinancieros(sujeto);
  					enviarConsulta();
  	}
  	
  }
  
  private void enviarEstructura() throws BaseException {
  	
  	IDataSet dsColGrilla = getDataSetColGrilla();
  	IDataSet dsCamposTabla = getDataSetCampos();
  	
  	cargaColGrilla(dsColGrilla,
  			new Integer(1),
  			Grilla.TIPO_COL_ESTANDAR,
  			"Cód. Cliente",
  			"cod_sujeto",
  			new Integer(0),
  			new Integer(200),
  			new Boolean(true),
  			new Boolean(true),
  			"",
  			new Boolean(false),
  			"",
  			new Boolean(false),
  			new Integer(0)
  			);
  	
  	cargaColGrilla(dsColGrilla,
  			new Integer(2),
  			Grilla.TIPO_COL_ESTANDAR,
  			"Razón Social",
  			"rs_sujeto",
  			new Integer(0),
  			new Integer(500),
  			new Boolean(true),
  			new Boolean(true),
  			"",
  			new Boolean(false),
  			"",
  			new Boolean(false),
  			new Integer(0)
  			);
  	
  	int secu = 3;
  	Iterator iterMonedas = Moneda.getAll(this.getSesion()).iterator();
  	while (iterMonedas.hasNext()) {
  		Moneda moneda = (Moneda) iterMonedas.next();
  		
    	cargaColGrilla(dsColGrilla,
    			new Integer(secu),
    			Grilla.TIPO_COL_ESTANDAR,
    			"Cta.Cte. "+moneda.getDescripcion(),
    			"saldo_"+moneda.getOIDInteger(),
    			new Integer(1),
    			new Integer(80),
    			new Boolean(true),
    			new Boolean(true),
    			"###,###,###,###.##",
    			new Boolean(false),
    			"",
    			new Boolean(false),
    			new Integer(0)
    			);
    	
    	cargaCampoTab(dsCamposTabla,
    			new Integer(secu+1),
    			Field.CURRENCY,
    			"saldo_"+moneda.getOIDInteger(),
    			new Integer(0),
    			new Boolean(false));
    	
    	
  		++secu;
  	}
  	
  	cargaCampoTab(dsCamposTabla,
  			new Integer(1),
  			Field.INTEGER,
  			"oid_sujeto",
  			new Integer(0),
  			new Boolean(true));
  	
  	cargaCampoTab(dsCamposTabla,
  			new Integer(2),
  			Field.STRING,
  			"cod_sujeto",
  			new Integer(50),
  			new Boolean(false));
  	
  	cargaCampoTab(dsCamposTabla,
  			new Integer(3),
  			Field.STRING,
  			"rs_sujeto",
  			new Integer(100),
  			new Boolean(false));
  	
  	
  	// Procesar los tipos de Valores
  	Iterator iterTiposValores = 
  		TipoValor.getAllTiposValores(this.getSesion()).iterator();
  	while (iterTiposValores.hasNext()) {
  		TipoValor tipoValor = (TipoValor) iterTiposValores.next();
  		if (tipoValor.isDeudaFinanciera().booleanValue()==false) continue;
  		
  		if (incluirDeudaFinan==false) continue;
  		
    	cargaCampoTab(dsCamposTabla,
    			new Integer(secu+1),
    			Field.CURRENCY,
    			"tv_"+tipoValor.getOIDInteger(),
    			new Integer(0),
    			new Boolean(false));
    	
    	cargaColGrilla(dsColGrilla,
    			new Integer(secu),
    			Grilla.TIPO_COL_ESTANDAR,
    			tipoValor.getDescripcion()+"("+tipoValor.getMoneda().getSimbolo()+")",
    			"tv_"+tipoValor.getOIDInteger(),
    			new Integer(1),
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

  	if (incluirDeudaFinan) {

  		cargaColGrilla(dsColGrilla,
			new Integer(1000),
			Grilla.TIPO_COL_ESTANDAR,
			"Deuda Total ("+Moneda.getMonedaTotalResuCtaCteClie(this.getSesion()).getSimbolo()+")",
			"deuda_total",
			new Integer(1),
			new Integer(110),
			new Boolean(true),
			new Boolean(true),
			"###,###,###,###.##",
			new Boolean(false),
			"",
			new Boolean(false),
			new Integer(0)
			);
  		
  	  	cargaCampoTab(dsCamposTabla,
  	  			new Integer(1000),
  	  			Field.CURRENCY,
  	  			"deuda_total",
  	  			new Integer(100),
  	  			new Boolean(false));
  		
  	}
  	
  	
  	
  	writeCliente(dsColGrilla);
  	writeCliente(dsCamposTabla);
  	
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
  
  private void enviarConsulta() throws BaseException {

  	IDataSet dsConsulta = this.getDataSetCtaCte();
  	IDataSet dsMonedas = getDataSetMonedas();


  	HashTableDatos cotizaciones = Cotizacion.getListaCotizacionesPorOidMoneda(Fecha.getFechaActual(), TipoCambio.getTipoCambioCtaCteClie(this.getSesion()), this.getSesion());
  	Iterator iterRenglones = consulta.listaRenglones.values().iterator();
  	while (iterRenglones.hasNext()) {
  		RenglonConsulta renglon = (RenglonConsulta) iterRenglones.next();
  		if (renglon.isSinDeuda()) continue;
  		enviarRenglonConsulta(dsConsulta,renglon,cotizaciones , Moneda.getMonedaTotalResuCtaCteClie(this.getSesion()));
  	}
  	
  	Iterator iterMonedas = Moneda.getAll(this.getSesion()).iterator();
  	while (iterMonedas.hasNext()) {
  		
  		Moneda moneda = (Moneda) iterMonedas.next();
  		dsMonedas.append();
  		dsMonedas.fieldValue("oid", moneda.getOIDInteger());
  		dsMonedas.fieldValue("codigo", moneda.getCodigo());
  		dsMonedas.fieldValue("descripcion", moneda.getDescripcion());
  		
  		Moneda monedaInc = (Moneda)consulta.listaMonedas.get(moneda.getOIDInteger());
  		if (monedaInc == null)
  			dsMonedas.fieldValue("mostrar", new Boolean(false));
  		else
  			dsMonedas.fieldValue("mostrar", new Boolean(true));
  		
  	}
  	
  	writeCliente(dsConsulta);
  	writeCliente(dsMonedas);
  	
  }
  
  private void enviarRenglonConsulta(IDataSet dsConsulta,
  		                             RenglonConsulta renglonConsulta,
  		                             HashTableDatos cotizaciones,
  		                             Moneda monedaTotal) throws BaseException {
  
	CalculadorMoney totalDeuda = new CalculadorMoney(new Money(0));  
	  	
  	dsConsulta.append();
  	dsConsulta.fieldValue("oid_sujeto", renglonConsulta.sujeto.getOIDInteger());
  	dsConsulta.fieldValue("cod_sujeto", renglonConsulta.sujeto.getCodigo());
  	dsConsulta.fieldValue("rs_sujeto", renglonConsulta.sujeto.getRazon_social());
  	
    for (int i = 0;i<listaMonedas.size();++i) {
    	Moneda moneda = (Moneda)listaMonedas.get(i);
    	dsConsulta.fieldValue("saldo_"+moneda.getOIDInteger(),renglonConsulta.getSaldo(moneda));
    	if (renglonConsulta.getSaldo(moneda).doubleValue()!=0)
    		totalDeuda.sumar(Cotizacion.getImporteEnMoneda(
    				cotizaciones, 
    				renglonConsulta.getSaldo(moneda), 
    				moneda,
    				monedaTotal));
    	
    }
    
    Iterator iterTiposValo = tiposValores.iterator();
    while (iterTiposValo.hasNext()) {
    	TipoValor tipoValor = (TipoValor) iterTiposValo.next();
    	dsConsulta.fieldValue("tv_"+tipoValor.getOIDInteger(),renglonConsulta.getSaldo(tipoValor));
    	if (renglonConsulta.getSaldo(tipoValor).doubleValue()!=0)
    		totalDeuda.sumar(Cotizacion.getImporteEnMoneda(
    				cotizaciones, 
    				renglonConsulta.getSaldo(tipoValor), 
    				tipoValor.getMoneda(),
    				monedaTotal));
    	
    }
    
    dsConsulta.fieldValue("deuda_total",totalDeuda.getResultMoney());
  	
  	
  }
  
  
  
  private void traerCtaCte() throws BaseException {
  	
    List listVtosCtaCte = ConsultaCtaCteClie.getVtosCtaCteBySujeto(sujeto,
                                                                   fecha,
                                                                   tipoCta,
                                                                   null,
                                                                   getSesion());
    Iterator iterVtosCtaCte = listVtosCtaCte.iterator();
    while (iterVtosCtaCte.hasNext()) {

      // Hacer un corte de control por Comprobante y Fecha de Vencimiento
      ConsultaCtaCteClie consultaCtaCteClie = (ConsultaCtaCteClie)iterVtosCtaCte.next();
      consulta.add(
      		consultaCtaCteClie.getSujeto(),
      		consultaCtaCteClie.getMoneda(),
      		consultaCtaCteClie.getSaldoCuota());
      
    }
  	
  	
  }
  
  
  private void traerValoresFinancieros(Sujeto sujeto) throws BaseException {
	  	
	    List listValoresEnCartera = 
	    	Valor.getValoresEnCaja(null, 
	    						   sujeto, 
	    						   TipoValor.getTiposValoresDeudaFinanciera(this.getSesion()),
	    						   this.getSesion());
	    
		java.util.Date fecha = Valor.getFechaDeudaFinan(this.getSesion());
		
	    Iterator iterValFinan = listValoresEnCartera.iterator();
	    while (iterValFinan.hasNext()) {

	      // Hacer un corte de control por Comprobante y Fecha de Vencimiento
	      Valor valor = (Valor)iterValFinan.next();
	      
	      if ((valor.getFechavto().after(fecha))) 
	    	  consulta.add(
	    			  valor.getSujeto(),
	    			  valor.getTipovalor(),
	    			  valor.getImporte());
	      
	    }
	  	
	  	
	  }
  
  
  private IDataSet getDataSetCtaCte() throws BaseException {
    IDataSet dataset = new TDataSet();
    dataset.create("TConsulta");
    dataset.fieldDef(new Field("oid_sujeto",Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_sujeto",Field.STRING, 50));
    dataset.fieldDef(new Field("rs_sujeto",Field.STRING, 100));
    
    for (int i = 0;i<listaMonedas.size();++i) {
    	Moneda moneda = (Moneda)listaMonedas.get(i);
    	dataset.fieldDef(new Field("saldo_"+moneda.getOIDInteger(),Field.CURRENCY, 0));
    }
    
    for (int i = 0;i<tiposValores.size();++i) {
    	TipoValor tv = (TipoValor)tiposValores.get(i);
    	dataset.fieldDef(new Field("tv_"+tv.getOIDInteger(),Field.CURRENCY, 0));
    }
    
    dataset.fieldDef(new Field("deuda_total",Field.CURRENCY, 0));
    
    return dataset;
  	
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
	
	private IDataSet getDataSetMonedas() {
		IDataSet dataset = new TDataSet();
		dataset.create("TMonedas");

		// Aspectos Fisicos
		dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 50));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
		dataset.fieldDef(new Field("mostrar", Field.BOOLEAN, 0));
		

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
