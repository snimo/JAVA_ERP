package com.srn.erp.cip.op;

import java.util.Iterator;

import com.srn.erp.cip.bm.PermisoVisita;
import com.srn.erp.cip.bm.TarjetaCIP;
import com.srn.erp.cip.bm.TarjetaLegajo;
import com.srn.erp.cip.bm.UtilCIP;
import com.srn.erp.cip.bm.Visita;
import com.srn.erp.ventas.bm.TipoDocumento;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class FuncAltaVisita extends Operation { 

  public FuncAltaVisita() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    String tipo = mapaDatos.getString("tipo");
    procesar(tipo,mapaDatos); 
  } 

  private void procesar(String tipo,MapDatos mapaDatos) throws BaseException {
	  if (tipo.equals("VALIDAR_NRO_TARJ"))
		  validarNroTarjeta(mapaDatos);
	  else
	  if (tipo.equals("VISITAS_POR_NRODOCU"))
		  visitasPorNroDocu(mapaDatos);
	  else
	  if (tipo.equals("DETERMINAR_BOTONERA"))
		  determinarBotonera(mapaDatos);	  
  }
  
  private void determinarBotonera(MapDatos mapaDatos) throws BaseException {
	  
	  String nroTarjeta = mapaDatos.getString("nro_tarjeta");
	  Integer oidTipoDocu = mapaDatos.getInteger("oid_tipo_docu");
	  String nroDocumento = mapaDatos.getString("nro_documento");
	  if (nroDocumento == null)
		  nroDocumento = ""; 
	  
	  boolean ingreso = false;
	  boolean devolvio = false;
	  boolean perdio = false;
	  boolean egreso = false;
	  boolean asignar = false;
	  boolean esAltaVisita = false;
	  
	  IDataSet dsBotonera = getDataSetBotonera();
	  
	  // Asignar la tarjeta
	  TarjetaCIP tarjetaCIP = null;
	  if ((nroTarjeta!=null) && (nroTarjeta.trim().length()!=0))
		  tarjetaCIP = TarjetaCIP.getTarjetaCIP(nroTarjeta, this.getSesion());
	  
	  // Obtener el Tipo de Documento
	  TipoDocumento tipoDocu = null;
	  if ((oidTipoDocu!=null) && (oidTipoDocu.intValue()>0))
		  tipoDocu = TipoDocumento.findByOidProxy(oidTipoDocu, this.getSesion());
	  
	  // Obtener el Nro. de Documento
	  Visita visita = Visita.getVisita(tipoDocu, nroDocumento, this.getSesion());
	  if (visita!=null)
		  esAltaVisita = false;
	  else
		  esAltaVisita = true;

	  // Determinar si corresponde habilitar el boton de asignar Tarjeta
	  if (tarjetaCIP!=null) {
		  if ((tarjetaCIP.isParaVisita()) && (!tarjetaCIP.isTarjetaDesHabilitada()) && (nroDocumento.length()>0) && (!tarjetaCIP.isTarjetaAsignada()))
			  asignar = true;
	  }
	  
	  // Determinal el Boton Ingreso
	  if (visita!=null) {
		  if (visita.isActivo()) {
			  if (visita.getZonaActual()==null) {
				  if (visita.isTieneTarjetaAsignada())
					  ingreso = true;
			  }
			  else
				  if (visita.getZonaActual().esExterna())
					  if (visita.isTieneTarjetaAsignada())
						  ingreso = true;
		  }
	  }
	  
	  // Determinal el Boton Egreso
	  if (visita!=null) {
		  if (visita.isActivo()) {
			  if ((visita.getZonaActual()!=null) && (!visita.getZonaActual().esExterna())) {
				  egreso = true;
			  }
		  }
	  }

	  // Determinar si la puede devolver
	  if (tarjetaCIP!=null) {
		  if ((tarjetaCIP.isTarjetaAsignada()) && (tarjetaCIP.getVisita()!=null))
			  if (visita!=null) { 
				if (visita.getZonaActual()==null) {
					devolvio = true;
					perdio = true;
				}
				else if (visita.getZonaActual().esExterna()) {
					devolvio = true;
					perdio = true;
				}
			  }
	  }
	  
	  
	  cargarBotonera(dsBotonera, ingreso, devolvio, perdio, egreso, asignar);
	  writeCliente(dsBotonera);
	  
  }
  
  private void visitasPorNroDocu(MapDatos mapaDatos) throws BaseException {
	  IDataSet ds = getDataSetVisitasPorNroDocu();
	  IDataSet dsNov = getDataSetNovedadesCIP();
	  Visita visita = null;
	  
	  java.util.Date fecHorActual = UtilCIP.getFechaHoraActual(this.getSesion());
	  
	  if (mapaDatos.containsKey("nro_documento")) {
		  boolean yaTieneTarjAsig = false;
		  String nroDocumento = mapaDatos.getString("nro_documento");
		  int regInfo = 0;
		  String nroTarjeta = "";
		  Iterator iterVisitas = 
			  Visita.getVisitasPorNroDocu(nroDocumento, this.getSesion()).iterator();
		  while (iterVisitas.hasNext()) {
			  visita = (Visita) iterVisitas.next();
			  if (visita.isTieneTarjetaAsignada()) {
				  yaTieneTarjAsig = true;
				  nroTarjeta = visita.getTarjetaAsignada().getNro_tarjeta();
			  }
			  else {
				  ++regInfo;
				  cargarVisitaPorNroDocu(ds, visita, false, false, false, false, false);
			  }
		  }
		  if ((yaTieneTarjAsig) && (regInfo==0)) {
			  throw new ExceptionValidation(null,"La visita ya tiene asignada la tarjeta "+nroTarjeta);
		  }
		  
	  } else if (mapaDatos.containsKey("oid_visita")) {
		  visita = Visita.findByOidProxy(mapaDatos.getInteger("oid_visita"), this.getSesion());
		  cargarVisitaPorNroDocu(ds, visita, false, false, false, false, false);
		  
	  }
	  
	  if (visita!=null) {
		  
		  
		// Obtener las Novedades
			Iterator iterPermisosVis = visita.getPermisosHabIngVisita(fecHorActual).iterator();
			while (iterPermisosVis.hasNext()) {
				PermisoVisita permiso = (PermisoVisita) iterPermisosVis.next();
				
				
				if (permiso.getSentido().equals(PermisoVisita.SENTIDO_E)) {
					String horaDesde = Fecha.getFormatoHoraMin(permiso.getFec_hor_desde());
					String horaHasta = Fecha.getFormatoHoraMin(permiso.getFec_hor_hasta());
					if (permiso.getPermiso().equals(Visita.HAB_PERMI)) {
						String novedad = "Puede ingresar en el Horario de "+horaDesde+" a "+horaHasta;
						cargarNovedad(dsNov, novedad,  "Eliminar" , permiso.getOIDInteger());
					}
				}
				
			}		  
		  
	  }
	  
	  writeCliente(ds);
	  writeCliente(dsNov);
  }
  
  private void validarNroTarjeta(MapDatos mapaDatos) throws BaseException {
	  Visita visita =  getVisitaPorNroTarjeta(mapaDatos.getString("nro_tarjeta"));
	  TarjetaCIP tarjetaCIP = TarjetaCIP.getTarjetaCIP(mapaDatos.getString("nro_tarjeta"), this.getSesion());
	  
	  if (tarjetaCIP==null)
		  throw new ExceptionValidation(null,"Tarjeta Inexistente.");
	  if (tarjetaCIP.isTarjetaDesHabilitada()) {
		  String motDes = "";
		  if (tarjetaCIP.getMotivo_baja_tarjeta()!=null)
			  motDes = tarjetaCIP.getMotivo_baja_tarjeta().getDescripcion();
		  throw new ExceptionValidation(null,"La tarjeta se encuentra deshabilitada. "+motDes);
	  }
	  if (!tarjetaCIP.isActivo()) 
		  throw new ExceptionValidation(null,"La tarjeta se encuentra inhactiva");
	  if (!tarjetaCIP.isParaVisita()) 
		  throw new ExceptionValidation(null,"La tarjeta no es para Visitas");
	  if (!tarjetaCIP.isVigentaAFecHora(UtilCIP.getFechaHoraActual(this.getSesion())))
		  throw new ExceptionValidation(null,"Tarjeta con vigencia vencida.");
	  
	  Integer oidTarjeta = null;
	  boolean asignada = false;
	  if (tarjetaCIP!=null) {
		  oidTarjeta = tarjetaCIP.getOIDInteger();
		  visita = tarjetaCIP.getVisita();
		  asignada = tarjetaCIP.isTarjetaAsignada();
	  }
	  
	  IDataSet dsResAsig = getDataSetResTarAsig();
	  cargarRegistroTarjAsig(dsResAsig, asignada , oidTarjeta , visita);
	  writeCliente(dsResAsig);
  }
  
  private Visita getVisitaPorNroTarjeta(String nroTarjeta) throws BaseException {
	  TarjetaCIP tarjetaCIP = TarjetaCIP.getTarjetaCIP(nroTarjeta, this.getSesion());
	  if (tarjetaCIP == null) throw new ExceptionValidation(null,"Nro. de Tarjeta Inexistente.");
	  if (!tarjetaCIP.isParaVisita()) throw new ExceptionValidation(null,"La tarjeta ingresada no corresponde a una tarjeta de Visita.");
	  TarjetaLegajo tarjetaLegajo = TarjetaLegajo.getTarjetaLegajo(nroTarjeta, this.getSesion());
	  if (tarjetaLegajo !=null) throw new ExceptionValidation(null,
			  "La tarjeta asignada se encuentra asignada al Legajo "+
			  tarjetaLegajo.getLegajo().getNro_legajo()+
			  " "+
			  tarjetaLegajo.getLegajo().getApellidoyNombre());
	  if (tarjetaCIP.getLegajo()!=null)
		  throw new ExceptionValidation(null,
				  "La tarjeta asignada se encuentra asignada al Legajo "+
				  tarjetaCIP.getLegajo().getNro_legajo()+
				  " "+
				  tarjetaCIP.getLegajo().getApellidoyNombre());	  
	  if (tarjetaCIP.getCliente()!=null)
		  throw new ExceptionValidation(null,
				  "La tarjeta asignada se encuentra asignada al Cliente "+
				  tarjetaCIP.getCliente().getCodigo()+
				  " "+
				  tarjetaCIP.getCliente().getRazon_social());	
	  
	  return tarjetaCIP.getVisita();
  }
  
  private IDataSet getDataSetResTarAsig() {
	    IDataSet dataset = new TDataSet();
	    dataset.create("TTarjAsig");
	    dataset.fieldDef(new Field("tarj_asig", Field.BOOLEAN, 0));
	    dataset.fieldDef(new Field("oid_tarjeta", Field.BOOLEAN, 0));
	    dataset.fieldDef(new Field("oid_visita", Field.INTEGER, 0));
	    return dataset;
  }
  
  private IDataSet getDataSetVisitasPorNroDocu() {
	    IDataSet dataset = new TDataSet();
	    dataset.create("TVisitasPorNroDocu");
	    dataset.fieldDef(new Field("oid_visita", Field.BOOLEAN, 0));
	    dataset.fieldDef(new Field("oid_tipo_docu", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("cod_tipo_docu",  Field.STRING, 50));
	    dataset.fieldDef(new Field("nro_documento", Field.STRING, 50));
	    dataset.fieldDef(new Field("empresa", Field.STRING, 100));
	    dataset.fieldDef(new Field("oid_empresa", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("asignar", Field.BOOLEAN, 0));
	    dataset.fieldDef(new Field("ingresar", Field.BOOLEAN, 0));
	    dataset.fieldDef(new Field("devolvio", Field.BOOLEAN, 0));
	    dataset.fieldDef(new Field("perdio", Field.BOOLEAN, 0));
	    dataset.fieldDef(new Field("egreso", Field.BOOLEAN, 0));
	    dataset.fieldDef(new Field("ape_y_nom", Field.STRING, 100));
	    dataset.fieldDef(new Field("oid_visita_a", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("oid_autoriza", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("oid_motivo", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("fec_hor_ent_sal_predio", Field.STRING, 100));
	    dataset.fieldDef(new Field("zona_actual", Field.STRING, 100));
	    dataset.fieldDef(new Field("categ_acc_int", Field.STRING, 100));
	    return dataset;
  }
  
  private IDataSet getDataSetBotonera() {
	    IDataSet dataset = new TDataSet();
	    dataset.create("TBotoneraVisita");
	    dataset.fieldDef(new Field("ingreso", Field.BOOLEAN, 0));
	    dataset.fieldDef(new Field("devolvio", Field.BOOLEAN, 0));
	    dataset.fieldDef(new Field("perdio",  Field.BOOLEAN, 0));
	    dataset.fieldDef(new Field("egreso", Field.BOOLEAN, 0));
	    dataset.fieldDef(new Field("asignar", Field.BOOLEAN, 0));
	    return dataset;
  }
  
  private IDataSet getDataSetNovedadesCIP() {
	    IDataSet dataset = new TDataSet();
	    dataset.create("TNovedadesVisita");
	    dataset.fieldDef(new Field("novedad", Field.STRING, 1000));
	    dataset.fieldDef(new Field("accion", Field.STRING, 20));
	    dataset.fieldDef(new Field("oid_permiso_visita", Field.INTEGER, 0));
	    return dataset;
  }
  
  private void cargarNovedad(IDataSet dsBotonera,
		  String novedad,
		  String accion,
		  Integer oidPermiso) throws BaseException {
	  dsBotonera.append();
	  dsBotonera.fieldValue("novedad", novedad);
	  dsBotonera.fieldValue("accion", accion);
	  dsBotonera.fieldValue("oid_permiso_visita", oidPermiso);
  }
  
  private void cargarBotonera(IDataSet dsBotonera,
		  boolean ingreso,
		  boolean devolvio,
		  boolean perdio,
		  boolean egreso,
		  boolean asignar) throws BaseException {
	  dsBotonera.append();
	  dsBotonera.fieldValue("ingreso", ingreso);
	  dsBotonera.fieldValue("devolvio", devolvio);
	  dsBotonera.fieldValue("perdio",  perdio);
	  dsBotonera.fieldValue("egreso", egreso);
	  dsBotonera.fieldValue("asignar", asignar);
  }
  
  private void cargarVisitaPorNroDocu(
		  IDataSet ds,
		  Visita visita,
		  boolean asignar,
		  boolean ingresar,
		  boolean devolvio,
		  boolean perdio,
		  boolean egreso) throws BaseException {
	  
	  ds.append();
	  ds.fieldValue("oid_visita", visita.getOID());
	  if (visita.getTipoDocumento()!=null) {
		  ds.fieldValue("oid_tipo_docu", visita.getTipoDocumento().getOID());
		  ds.fieldValue("cod_tipo_docu", visita.getTipoDocumento().getCodigo());
	  } else {
		  ds.fieldValue("oid_tipo_docu", "");
		  ds.fieldValue("cod_tipo_docu", "");
	  }
	  ds.fieldValue("nro_documento", visita.getNroDocumento());
	  if (visita.getEmpresaCIP()!=null) {
		  ds.fieldValue("empresa", visita.getEmpresaCIP().getRazon_social());
		  ds.fieldValue("oid_empresa", visita.getEmpresaCIP().getOIDInteger());
	  } else {
		  ds.fieldValue("empresa", "");
		  ds.fieldValue("oid_empresa", "");
	  }
	  ds.fieldValue("asignar", asignar);
	  ds.fieldValue("ingresar", ingresar);
	  ds.fieldValue("devolvio", devolvio);
	  ds.fieldValue("perdio", perdio);
	  ds.fieldValue("egreso", egreso);
	  ds.fieldValue("ape_y_nom", visita.getApeyNom());
	  if (visita.getVisitaA()!=null)
		  ds.fieldValue("oid_visita_a", visita.getVisitaA().getOIDInteger());
	  else
		  ds.fieldValue("oid_visita_a", "");
	  if (visita.getAutoriza()!=null)
		  ds.fieldValue("oid_autoriza", visita.getAutoriza().getOIDInteger());
	  else
		  ds.fieldValue("oid_autoriza", "");
	  if (visita.getMotivoVisita()!=null)
		  ds.fieldValue("oid_motivo" , visita.getMotivoVisita().getOID());
	  else
		  ds.fieldValue("oid_motivo" , "");
	  if (visita!=null)
		  ds.fieldValue("fec_hor_ent_sal_predio" , visita.getFecHorUltEntSalPredio());
	  else
		  ds.fieldValue("fec_hor_ent_sal_predio" , "");
	  if ((visita!=null) && (visita.getZonaActual()!=null))
		  ds.fieldValue("zona_actual" , visita.getZonaActual().getDescripcion());
	  else
		  ds.fieldValue("zona_actual" , "");
	  if (visita.getCategoriaAcceso()!=null)
		  ds.fieldValue("categ_acc_int", visita.getCategoriaAcceso().getDescripcion());
	  else
		  ds.fieldValue("categ_acc_int", "");
  }
  

  private void cargarRegistroTarjAsig(
		  IDataSet dataset,
	      boolean asignada,
	      Integer oidTarjeta,
	      Visita visita) {
	    dataset.append();
	    dataset.fieldValue("tarj_asig", asignada);
	    dataset.fieldValue("oid_tarjeta", oidTarjeta);
	    if (visita!=null)
	    	dataset.fieldValue("oid_visita", visita.getOID());
	    else
	    	dataset.fieldValue("oid_visita", "");
  }  
  
}
