package com.srn.erp.excluidos.op;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.cip.bm.UtilCIP;
import com.srn.erp.excluidos.bm.AlturaExcluido;
import com.srn.erp.excluidos.bm.CaracterExcluido;
import com.srn.erp.excluidos.bm.CargoLegajoExcluido;
import com.srn.erp.excluidos.bm.ColorCabelloExcluido;
import com.srn.erp.excluidos.bm.ColorExcluido;
import com.srn.erp.excluidos.bm.ComplexionExcluido;
import com.srn.erp.excluidos.bm.EdadExcluido;
import com.srn.erp.excluidos.bm.EstadoExcluido;
import com.srn.erp.excluidos.bm.ExcluidoConsMas;
import com.srn.erp.excluidos.bm.IndividuoExcluido;
import com.srn.erp.excluidos.bm.MarcaExcluido;
import com.srn.erp.excluidos.bm.MotivoNovedadExcluido;
import com.srn.erp.excluidos.bm.NovedadExcluido;
import com.srn.erp.excluidos.bm.RasgoExcluido;
import com.srn.erp.excluidos.bm.RazaExcluido;
import com.srn.erp.excluidos.bm.SectorLegajoExcluido;
import com.srn.erp.excluidos.bm.TipoBarba;
import com.srn.erp.excluidos.bm.TipoCabelloExcluido;
import com.srn.erp.excluidos.bm.TipoNariz;
import com.srn.erp.excluidos.bm.VehiculoExcluido;
import com.srn.erp.general.bm.Nacionalidad;
import com.srn.erp.ventas.bm.TipoDocumento;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerConsMasivaExcluidos extends Operation {

	public TraerConsMasivaExcluidos() {
	}
	
	public void traerProxRegistros(MapDatos mapaDatos) throws BaseException {
		
		if (!(mapaDatos.getInteger("cant_reg_lote").intValue()>0))
			throw new ExceptionValidation(null,"La cantidad de registros a traer debe ser mayor a cero");
		
		HashTableDatos condiciones = new HashTableDatos();
		Integer nroDesde = mapaDatos.getInteger("cant_reg_cons").intValue()+1;
		Integer nroHasta = nroDesde.intValue()+mapaDatos.getInteger("cant_reg_lote").intValue()-1;
		Integer nroLote = mapaDatos.getInteger("nro_lote");
		Integer cantRegTotales = mapaDatos.getInteger("cant_reg_totales");
		
		
		condiciones.put("NRO_ORDEN_DESDE", nroDesde);
		condiciones.put("NRO_ORDEN_HASTA", nroHasta);
		condiciones.put("NRO_LOTE", nroLote);
		
		IDataSet ds = this.getDataSetConsMasiva("TProxConsultaIndividuo");
		IDataSet dsControlador = this.getDSControladorConsMasExc();
		
		boolean esFinDeArchivo = false;
		Iterator iterIndiExc =
			IndividuoExcluido.getConsultaMasiva(condiciones, this.getSesion()).iterator();
		while (iterIndiExc.hasNext()) {
			IndividuoExcluido individuoExcluido = (IndividuoExcluido) iterIndiExc.next();
			cargarRegistroIndividuo(ds,individuoExcluido);
		}

		
		if ((mapaDatos.getInteger("cant_reg_cons").intValue()+mapaDatos.getInteger("cant_reg_lote").intValue())<cantRegTotales)
			esFinDeArchivo = false;
		else
			esFinDeArchivo = true;
		
		int cantRegCons = mapaDatos.getInteger("cant_reg_cons").intValue()+mapaDatos.getInteger("cant_reg_lote");
		if (cantRegCons>cantRegTotales)
			cantRegCons = cantRegTotales; 
		
		cargarRegControlador(nroLote,cantRegTotales, mapaDatos.getInteger("cant_reg_lote"),esFinDeArchivo,0,0,cantRegCons,dsControlador);
		
		writeCliente(ds);
		writeCliente(dsControlador);
		
	}
	
	
	public void prepararConsulta(MapDatos mapaDatos) throws BaseException {

		
		java.util.Date fechaABorrar = Fecha.getFechaMasDias(UtilCIP.getFechaHoraActual(this.getSesion()),-3);
		
		ExcluidoConsMas.borrarConsultasViejas(fechaABorrar, this.getSesion());
		
		IDataSet dsControlador = getDSControladorConsMasExc();
		
		java.util.Date fecha = Fecha.getFechaActual();
		Integer nroLote = this.getSesion().getNewOIDByKey(ExcluidoConsMas.NRO_LOTE_CONS_EXC);
		HashTableDatos condiciones = new HashTableDatos();
		
		
		IDataSet dsIndi = mapaDatos.getDataSet("TIndividuoExcluido");
		IDataSet dsMotivos = mapaDatos.getDataSet("TMotivosNovedades");
		IDataSet dsEstados = mapaDatos.getDataSet("TEstados"); 
		
		setCondIndividuo(dsIndi,condiciones);
		setCondMotivos(dsMotivos,condiciones);
		setEstados(dsEstados,condiciones);
		
		
		
		int secu = 0;
		Iterator iterIndiExc =
			IndividuoExcluido.getConsultaMasiva(condiciones, this.getSesion()).iterator();
		while (iterIndiExc.hasNext()) {
			++secu;
			IndividuoExcluido individuo = (IndividuoExcluido) iterIndiExc.next();
			procesarIndividuo(individuo,fecha , nroLote, secu);
		}
		
		cargarRegControlador(nroLote,secu, ExcluidoConsMas.getCantRegLote(this.getSesion()),false,0,0,0,dsControlador);
		
		writeCliente(dsControlador);
		
		
	}
	
	private void setEstados(IDataSet dsEstados,HashTableDatos condiciones) throws BaseException {
		List listaEstados = new ArrayList();
		dsEstados.first();
		while (!dsEstados.EOF()) {
			if (!dsEstados.getBoolean("sel")) {
				dsEstados.next();
				continue;
			}
			EstadoExcluido estado =
				EstadoExcluido.findByOidProxy(dsEstados.getInteger("oid"), this.getSesion());
			listaEstados.add(estado);
			dsEstados.next();
		}
		if (listaEstados.size()>0)
			condiciones.put("LISTA_ESTADOS", listaEstados);		
	}
	
	private void setCondMotivos(IDataSet dsMotivos,HashTableDatos condiciones) throws BaseException {
		List listaMotivos = new ArrayList();
		dsMotivos.first();
		while (!dsMotivos.EOF()) {
			if (!dsMotivos.getBoolean("sel")) {
				dsMotivos.next();
				continue;
			}
			MotivoNovedadExcluido motivo =
				MotivoNovedadExcluido.findByOidProxy(dsMotivos.getInteger("oid"), this.getSesion());
			listaMotivos.add(motivo);
			dsMotivos.next();
		}
		if (listaMotivos.size()>0)
			condiciones.put("LISTA_MOTIVOS", listaMotivos);
	}
	
	private void setCondIndividuo(IDataSet dsIndi,HashTableDatos condiciones) throws BaseException {
		dsIndi.first();
		while (!dsIndi.EOF()) {
			
			TipoDocumento tipoDocu = TipoDocumento.findByOidProxy(
					                  dsIndi.getInteger("oid_tipo_documento"),
					                  this.getSesion());
			if (tipoDocu!=null) condiciones.put(TipoDocumento.NICKNAME, tipoDocu);
			
			String nroDocu = dsIndi.getString("nro_documento");
			if ((nroDocu!=null) && (!nroDocu.trim().equals(""))) condiciones.put("NRO_DOCU", nroDocu);
			
			String tipo = dsIndi.getString("tipo");
			if ((tipo!=null) && (!tipo.trim().equals(""))) condiciones.put("TIPO", tipo);
			
			Boolean soloNovActivasSinVigHasta = dsIndi.getBoolean("sin_vigencia_hasta");
			if (((soloNovActivasSinVigHasta!=null)) && (soloNovActivasSinVigHasta.booleanValue())) condiciones.put("SIN_VIGENCIA_HASTA", "");
			
			IndividuoExcluido individuoExc = null;
			try {
				individuoExc = IndividuoExcluido.findByOid(
	                  							dsIndi.getInteger("oid_individuo"),
	                  							this.getSesion());
			} catch(Exception e) {
				throw new ExceptionValidation(null,"Número interno de individuo inexistente.");
			}
			
			if (individuoExc!=null) condiciones.put(IndividuoExcluido.NICKNAME, individuoExc);
			
			String apellido = dsIndi.getString("apellido");
			if ((apellido!=null) && (!apellido.trim().equals(""))) condiciones.put("APELLIDO", apellido);
			
			String nombre = dsIndi.getString("nombre");
			if ((nombre!=null) && (!nombre.trim().equals(""))) condiciones.put("NOMBRE", nombre);
			
			String apodo = dsIndi.getString("apodo");
			if ((apodo!=null) && (!apodo.trim().equals(""))) condiciones.put("APODO", apodo);
			
			Nacionalidad nacionalidad = Nacionalidad.findByOidProxy(
	                  dsIndi.getInteger("oid_nacionalidad"),
	                  this.getSesion());
			if (nacionalidad!=null) condiciones.put(Nacionalidad.NICKNAME, nacionalidad);
			
			String legajo = dsIndi.getString("legajo");
			if ((legajo!=null) && (!legajo.trim().equals(""))) condiciones.put("LEGAJO", legajo);
			
			SectorLegajoExcluido sector = SectorLegajoExcluido.findByOidProxy(
	                  dsIndi.getInteger("oid_sector"),
	                  this.getSesion());
			if (sector!=null) condiciones.put(SectorLegajoExcluido.NICKNAME, sector);			
			
			CargoLegajoExcluido cargo = CargoLegajoExcluido.findByOidProxy(
	                  dsIndi.getInteger("oid_cargo"),
	                  this.getSesion());
			if (cargo!=null) condiciones.put(CargoLegajoExcluido.NICKNAME, cargo);			

			String tipoCondicion = dsIndi.getString("tipo_condicion");
			if ((tipoCondicion!=null) && (!tipoCondicion.trim().equals(""))) condiciones.put("TIPO_CONDICION",tipoCondicion);
			
			String sexo = dsIndi.getString("sexo");
			if ((sexo!=null) && (!sexo.trim().equals(""))) condiciones.put("SEXO",sexo);
			
			java.util.Date fecAltaDesde = dsIndi.getDate("fec_alta_desde");
			if (fecAltaDesde!=null) condiciones.put("FEC_ALTA_DESDE",fecAltaDesde);
			
			java.util.Date fecAltaHasta = dsIndi.getDate("fec_alta_hasta");
			if (fecAltaHasta!=null) condiciones.put("FEC_ALTA_HASTA",fecAltaHasta);			
			
			String ordenarPor = dsIndi.getString("ordenar_por");
			if (ordenarPor!=null) condiciones.put("ordenar_por",ordenarPor);			
			
			RazaExcluido raza = RazaExcluido.findByOidProxy(
	                  dsIndi.getInteger("oid_raza"),
	                  this.getSesion());
			if (raza!=null) condiciones.put(RazaExcluido.NICKNAME, raza);
			
			AlturaExcluido altura = AlturaExcluido.findByOidProxy(
	                  dsIndi.getInteger("oid_altura"),
	                  this.getSesion());
			if (altura!=null) condiciones.put(AlturaExcluido.NICKNAME, altura);
			
			boolean conActaRevo = false;
			if (dsIndi.getBoolean("con_acta_revocacion")!=null)
				conActaRevo = dsIndi.getBoolean("con_acta_revocacion");
			condiciones.put("con_acta_revocacion", new Boolean(conActaRevo));
			
			ComplexionExcluido complexion = ComplexionExcluido.findByOidProxy(
	                  dsIndi.getInteger("oid_complexion"),
	                  this.getSesion());
			if (complexion!=null) condiciones.put(ComplexionExcluido.NICKNAME, complexion);			
			
			RasgoExcluido rasgo = RasgoExcluido.findByOidProxy(
	                  dsIndi.getInteger("oid_rasgo"),
	                  this.getSesion());
			if (rasgo!=null) condiciones.put(RasgoExcluido.NICKNAME, rasgo);			
			
			MarcaExcluido marcaExcluido = MarcaExcluido.findByOidProxy(
	                  dsIndi.getInteger("oid_marca"),
	                  this.getSesion());
			if (marcaExcluido!=null) condiciones.put(MarcaExcluido.NICKNAME, marcaExcluido);			
			
			EdadExcluido edad = EdadExcluido.findByOidProxy(
	                  dsIndi.getInteger("oid_edad"),
	                  this.getSesion());
			if (edad!=null) condiciones.put(EdadExcluido.NICKNAME, edad);
			
			ColorCabelloExcluido colorCabello = ColorCabelloExcluido.findByOidProxy(
	                  dsIndi.getInteger("oid_color"),
	                  this.getSesion());
			if (colorCabello!=null) condiciones.put(ColorCabelloExcluido.NICKNAME, colorCabello);			
			
			CaracterExcluido caracter = CaracterExcluido.findByOidProxy(
	                  dsIndi.getInteger("oid_caracter"),
	                  this.getSesion());
			if (caracter!=null) condiciones.put(CaracterExcluido.NICKNAME, caracter);
			
			TipoBarba tipoBarba = TipoBarba.findByOidProxy(
	                  dsIndi.getInteger("oid_tipo_barba"),
	                  this.getSesion());
			if (tipoBarba!=null) condiciones.put(TipoBarba.NICKNAME, tipoBarba);
			
			TipoCabelloExcluido tipoCabello = TipoCabelloExcluido.findByOidProxy(
	                  dsIndi.getInteger("oid_tipo_cabello"),
	                  this.getSesion());
			if (tipoCabello!=null) condiciones.put(TipoCabelloExcluido.NICKNAME, tipoCabello);
			
			TipoNariz tipoNariz = TipoNariz.findByOidProxy(
	                  dsIndi.getInteger("oid_tipo_nariz"),
	                  this.getSesion());
			if (tipoNariz!=null) condiciones.put(TipoNariz.NICKNAME, tipoNariz);
			
			Integer anteojos = dsIndi.getInteger("anteojos");
			if (anteojos!=null) condiciones.put("ANTEOJOS", anteojos);
			
			String marcas = dsIndi.getString("marcas");
			if ((marcas!=null) && (!marcas.trim().equals(""))) condiciones.put("MARCAS", marcas);
			
			String rasgos = dsIndi.getString("rasgos");
			if ((rasgos!=null) && (!rasgos.trim().equals(""))) condiciones.put("RASGOS", rasgos);
			
			IndividuoExcluido indiRelacion = IndividuoExcluido.findByOidProxy(
	                  dsIndi.getInteger("oid_ind_relacion"),
	                  this.getSesion());
			if (indiRelacion!=null) condiciones.put("OID_INDI_RELACIONADO", indiRelacion);			
			
			String dominio = dsIndi.getString("dominio");
			if ((dominio!=null) && (!dominio.trim().equals(""))) condiciones.put("DOMINIO", dominio);
			
			String marca = dsIndi.getString("marca");
			if ((marca!=null) && (!marca.trim().equals(""))) condiciones.put("MARCA_AUTO", marca);
			
			String modeloAuto = dsIndi.getString("modelo");
			if ((modeloAuto!=null) && (!modeloAuto.trim().equals(""))) condiciones.put("MODELO_AUTO", modeloAuto);

			ColorExcluido colorAuto = ColorExcluido.findByOidProxy(
	                  dsIndi.getInteger("oid_color_vehiculo"),
	                  this.getSesion());			
			if ((colorAuto!=null)) condiciones.put(ColorExcluido.NICKNAME, colorAuto);
			
			String observacion = dsIndi.getString("observacion");
			if ((observacion!=null) && (!observacion.trim().equals(""))) condiciones.put("OBSERVACION", observacion);
			
			Integer nroActa =  dsIndi.getInteger("nro_acta");
			if ((nroActa!=null) && (nroActa.intValue()!=0)) condiciones.put("NRO_ACTA", nroActa);
			
			Integer nroActaRevo =  dsIndi.getInteger("nro_acta_revo");
			if ((nroActaRevo!=null) && (nroActaRevo.intValue()!=0)) condiciones.put("NRO_ACTA_REVO", nroActaRevo);
			
			String comportamientoEstado = dsIndi.getString("comportamiento_estado");
			if ((comportamientoEstado!=null) && (!comportamientoEstado.trim().equals(""))) condiciones.put("COMPOR_ESTADO", comportamientoEstado);
			
			dsIndi.next();
		}
		
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		
		if (mapaDatos.containsKey("prep_cons_exc"))
			prepararConsulta(mapaDatos);
		else if (mapaDatos.containsKey("prox_registros"))
			traerProxRegistros(mapaDatos);
		
	}
	
	private void procesarIndividuo(IndividuoExcluido individuo  , java.util.Date fecha , Integer nroLote , int secu) throws BaseException {
		ExcluidoConsMas exluidoCons =
			(ExcluidoConsMas)ExcluidoConsMas.getNew(ExcluidoConsMas.NICKNAME, this.getSesion());
		exluidoCons.setIndividuo(individuo);
		exluidoCons.setActivo(true);
		exluidoCons.setFecha(fecha);
		exluidoCons.setNro_lote(nroLote);
		exluidoCons.setNro_orden(secu);
		this.addTransaccion(exluidoCons);		
	}
	
	private IDataSet getDSControladorConsMasExc() {
		IDataSet dataset = new TDataSet();
		dataset.create("TControladorConsMas");
		dataset.fieldDef(new Field("nro_lote", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cant_reg_totales", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cant_reg_lote", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cargo_todos", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("primer_reg_lote", Field.INTEGER, 0));
		dataset.fieldDef(new Field("ultimo_reg_lote", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cant_reg_cons", Field.INTEGER, 0));
		return dataset;
	}
	
	private void cargarRegControlador(
			Integer nroLote,
			Integer cantReg,
			Integer cantRegLote,
			Boolean cargo_todos, 
			Integer primerRegLote,
			Integer ultimoRegLote,
			Integer cantRegCons,
			IDataSet ds) throws BaseException {
		ds.append();
		
		ds.fieldValue("nro_lote", nroLote);
		ds.fieldValue("cant_reg_totales", cantReg);
		
		if (cantRegLote==10000000)
			ds.fieldValue("cant_reg_lote", ExcluidoConsMas.getCantRegLote(this.getSesion()));
		else
			ds.fieldValue("cant_reg_lote", cantRegLote);
		
		ds.fieldValue("cant_reg_lote", cantRegLote);
		ds.fieldValue("cargo_todos", cargo_todos);
		ds.fieldValue("primer_reg_lote", primerRegLote);
		ds.fieldValue("ultimo_reg_lote", ultimoRegLote);
		ds.fieldValue("cant_reg_cons", cantRegCons);
		
	}

	private IDataSet getDataSetConsMasiva(String table) {
		IDataSet dataset = new TDataSet();
		dataset.create(table);
		dataset.fieldDef(new Field("oid_individuo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("desc_estado", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_tipo_docu", Field.STRING, 50));
		dataset.fieldDef(new Field("nro_documento", Field.STRING, 50));
		dataset.fieldDef(new Field("tipo_individuo", Field.STRING, 50));
		dataset.fieldDef(new Field("apellido", Field.STRING, 100));
		dataset.fieldDef(new Field("nombre", Field.STRING, 100));
		dataset.fieldDef(new Field("apodo", Field.STRING, 100));
		dataset.fieldDef(new Field("nacionalidad", Field.STRING, 100));
		dataset.fieldDef(new Field("sexo", Field.STRING, 100));
		dataset.fieldDef(new Field("raza", Field.STRING, 100));
		dataset.fieldDef(new Field("altura", Field.STRING, 100));
		dataset.fieldDef(new Field("complexion", Field.STRING, 100));
		dataset.fieldDef(new Field("edad", Field.STRING, 100));
		dataset.fieldDef(new Field("color", Field.STRING, 100));
		dataset.fieldDef(new Field("tipo_barba", Field.STRING, 100));
		dataset.fieldDef(new Field("cabello", Field.STRING, 100));
		dataset.fieldDef(new Field("nariz", Field.STRING, 100));
		dataset.fieldDef(new Field("anteojos", Field.STRING, 100));
		dataset.fieldDef(new Field("marcas", Field.STRING, 100));
		dataset.fieldDef(new Field("rasgos", Field.STRING, 100));
		dataset.fieldDef(new Field("legajo", Field.STRING, 100));
		dataset.fieldDef(new Field("sector", Field.STRING, 100));
		dataset.fieldDef(new Field("cargo", Field.STRING, 100));
		dataset.fieldDef(new Field("condicion", Field.STRING, 100));
		dataset.fieldDef(new Field("dominio", Field.STRING, 100));
		dataset.fieldDef(new Field("marca_vehiculo", Field.STRING, 100));
		dataset.fieldDef(new Field("modelo", Field.STRING, 100));
		dataset.fieldDef(new Field("color_auto", Field.STRING, 100));
		dataset.fieldDef(new Field("nro_acta", Field.STRING, 100));
		dataset.fieldDef(new Field("fec_acta", Field.DATE, 0));
		dataset.fieldDef(new Field("nro_acta_revo", Field.STRING, 100));
		dataset.fieldDef(new Field("fec_acta_revo", Field.DATE, 0));
		dataset.fieldDef(new Field("readmitido", Field.STRING, 2));
		dataset.fieldDef(new Field("venc_estado", Field.STRING, 100));
		dataset.fieldDef(new Field("obs_principal", Field.STRING, 100));
		dataset.fieldDef(new Field("caracter", Field.STRING, 100));
		dataset.fieldDef(new Field("nro_registro", Field.STRING, 50));
		dataset.fieldDef(new Field("color_estado", Field.STRING, 10));
		dataset.fieldDef(new Field("desc_est_y_nro_reg", Field.STRING, 100));
		dataset.fieldDef(new Field("motivo", Field.STRING, 100));
		dataset.fieldDef(new Field("leyenda_rest_ingreso", Field.STRING, 100));
		
		return dataset;
	}
	
	

	private void cargarRegistroIndividuo(IDataSet dataset, IndividuoExcluido individuo) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_individuo", individuo.getOIDInteger());
		if (individuo.getEstado() != null)
			dataset.fieldValue("desc_estado", individuo.getEstado().getDescripcion());
		else
			dataset.fieldValue("desc_estado", "");
		if (individuo.getTipo_documento() != null)
			dataset.fieldValue("desc_tipo_docu", individuo.getTipo_documento().getDescripcion());
		else
			dataset.fieldValue("desc_tipo_docu", "");
		dataset.fieldValue("nro_documento", individuo.getNro_documento());
		dataset.fieldValue("tipo_individuo", individuo.getTipo());
		dataset.fieldValue("apellido", individuo.getApellido());
		dataset.fieldValue("nombre", individuo.getNombre());
		dataset.fieldValue("apodo", individuo.getApodo());
		if (individuo.getNacionalidad() != null)
			dataset.fieldValue("nacionalidad", individuo.getNacionalidad().getDescripcion());
		else
			dataset.fieldValue("nacionalidad", "");
		dataset.fieldValue("sexo", individuo.getSexo());
		if (individuo.getRaza() != null)
			dataset.fieldValue("raza", individuo.getRaza().getDescripcion());
		else
			dataset.fieldValue("raza", "");
		if (individuo.getAltura() != null)
			dataset.fieldValue("altura", individuo.getAltura().getDescripcion());
		else
			dataset.fieldValue("altura", "");
		if (individuo.getComplexion() != null)
			dataset.fieldValue("complexion", individuo.getComplexion().getDescripcion());
		else
			dataset.fieldValue("complexion", "");
		if (individuo.getEdad() != null)
			dataset.fieldValue("edad", individuo.getEdad().getDescripcion());
		else
			dataset.fieldValue("edad", "");
		if (individuo.getColor() != null)
			dataset.fieldValue("color", individuo.getColor().getDescripcion());
		else
			dataset.fieldValue("color", "");
		if (individuo.getTipo_barba() != null)
			dataset.fieldValue("tipo_barba", individuo.getTipo_barba().getDescripcion());
		else
			dataset.fieldValue("tipo_barba", "");
		if (individuo.getTipo_cabello() != null)
			dataset.fieldValue("cabello", individuo.getTipo_cabello().getDescripcion());
		else
			dataset.fieldValue("cabello", "");
		if (individuo.getTipo_nariz() != null)
			dataset.fieldValue("nariz", individuo.getTipo_nariz().getDescripcion());
		else
			dataset.fieldValue("nariz", "");
		if (individuo.isAnteojos().booleanValue())
			dataset.fieldValue("anteojos", "SI");
		else
			dataset.fieldValue("anteojos", "NO");
		
		if (individuo.getMarca()!=null)
			dataset.fieldValue("marcas", individuo.getMarca().getDescripcion());
		else
			dataset.fieldValue("marcas", "");
		
		if (individuo.getRasgo()!=null)
			dataset.fieldValue("rasgos", individuo.getRasgo().getDescripcion());
		else
			dataset.fieldValue("rasgos", "");
		
		dataset.fieldValue("legajo", individuo.getNro_legajo());
		if (individuo.getSector() != null)
			dataset.fieldValue("sector", individuo.getSector().getDescripcion());
		else
			dataset.fieldValue("sector", "");
		if (individuo.getCargo() != null)
			dataset.fieldValue("cargo", individuo.getCargo().getDescripcion());
		else
			dataset.fieldValue("cargo", "");
		
		if (individuo.getTipo_condicion()==null)
			dataset.fieldValue("condicion", "");
		else
		if (individuo.getTipo_condicion().equals(IndividuoExcluido.COND_ACTIVA))
			dataset.fieldValue("condicion", "Activo");
		else if (individuo.getTipo_condicion().equals(IndividuoExcluido.COND_PASIVA))
			dataset.fieldValue("condicion", "Pasivo");
		else
			dataset.fieldValue("condicion", "");
		
		VehiculoExcluido vehi = individuo.getUltVehiculoCargado();
		if (vehi!=null) {
			dataset.fieldValue("dominio", vehi.getDominio());
			dataset.fieldValue("marca_vehiculo", vehi.getMarca());
			dataset.fieldValue("modelo", vehi.getModelo());
			if (vehi.getColor()!=null)
				dataset.fieldValue("color_auto", vehi.getColor().getDescripcion());
			else
				dataset.fieldValue("color_auto", "");
		} else {
			dataset.fieldValue("dominio", "");
			dataset.fieldValue("marca_vehiculo", "");
			dataset.fieldValue("modelo", "");
			dataset.fieldValue("color_auto", "");
		}
		
		NovedadExcluido novedad = individuo.getNovedadExcluido();
		if (novedad==null) {
			dataset.fieldValue("nro_acta", "");
			dataset.fieldValue("fec_acta", "");
			dataset.fieldValue("nro_acta_revo", "");
			dataset.fieldValue("fec_acta_revo", "");
			dataset.fieldValue("readmitido", "");
			dataset.fieldValue("venc_estado", "");
		} else {
			boolean cargoNroActa = false;
			if (novedad.getnroActa()==null)
				dataset.fieldValue("nro_acta", "");
			else if (novedad.getnroActa().intValue()==0)
				dataset.fieldValue("nro_acta", "");
			else {
				cargoNroActa = true;
				dataset.fieldValue("nro_acta",novedad.getnroActa());
			}
			
			if (cargoNroActa==false)
				dataset.fieldValue("fec_acta", Fecha.FECHA_NULA());
			else
				dataset.fieldValue("fec_acta", novedad.getVig_desde());
			
			if (novedad.getnroRevocamiento()==null)
				dataset.fieldValue("nro_acta_revo", "");
			else if (novedad.getnroRevocamiento().intValue()==0)
				dataset.fieldValue("nro_acta_revo", "");
			else
				dataset.fieldValue("nro_acta_revo", novedad.getnroRevocamiento());
			dataset.fieldValue("fec_acta_revo", novedad.getFecRevocamiento());
			if (novedad.isDejar_sin_efecto())
				dataset.fieldValue("readmitido", "SI");
			else
				dataset.fieldValue("readmitido", "NO");
			dataset.fieldValue("venc_estado", novedad.getDescVencimiento());
		}
		dataset.fieldValue("obs_principal", individuo.getObsPrincipal());
		if (individuo.getCaracter()!=null)
			dataset.fieldValue("caracter", individuo.getCaracter().getDescripcion());
		else
			dataset.fieldValue("caracter", "");
		dataset.fieldValue("nro_registro", individuo.getNroPrincipal());
		if (individuo.getEstado()!=null)
			dataset.fieldValue("color_estado", individuo.getEstado().getColor());
		else
			dataset.fieldValue("color_estado", "");
		
		
		dataset.fieldValue("desc_est_y_nro_reg", individuo.getNroPrincipal2());
		String motivo = "";
		if ((novedad!=null) && (novedad.getMotivo()!=null))
			motivo = novedad.getMotivo().getDescripcion();
		dataset.fieldValue("motivo", motivo);
		dataset.fieldValue("leyenda_rest_ingreso", individuo.isRestriccionAcceso()?"Restricción acceso":"");
		
	}
}
