package com.srn.erp.cip.op;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.cip.bm.LegajoRotaFecha;
import com.srn.erp.cip.bm.Rota;
import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.sueldos.bm.Legajo;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerPlanifRotasLegajo extends Operation { 

  public TraerPlanifRotasLegajo() { 
  }
  
  HashTableDatos planificacionDeLegajos = new HashTableDatos();

  public void execute(MapDatos mapaDatos) throws BaseException {
	  
	  List listaLegajos = new ArrayList();
	  List listaValoresClasif = new ArrayList();
	  
	  ClasificadorEntidad clasificadorEntidad = null;
	  if (mapaDatos.containsKey("inicializar")) {
		  if (mapaDatos.getDate("fecha")==null)
			  throw new ExceptionValidation(null,"Debe ingresar la Fecha de Planificación");
		  if (mapaDatos.getInteger("dias")==null)
			  throw new ExceptionValidation(null,"Debe ingresar los días a Planificar");		  
		  inicializarPlanifRotas(mapaDatos.getDate("fecha"),mapaDatos.getInteger("dias"));
	  }
	  else if (mapaDatos.containsKey("datosPlanif")) {
		  
		  if (mapaDatos.containsKey("oid_clasif_agrupador")) {
			  clasificadorEntidad = 
				  ClasificadorEntidad.findByOidProxy(mapaDatos.getInteger("oid_clasif_agrupador"), this.getSesion()); 
		  }
		  
		  IDataSet dsLegajos = mapaDatos.getDataSet("TLegajosAPlanif");
		  dsLegajos.first();
		  while (!dsLegajos.EOF()) {
			  listaLegajos.add(dsLegajos.getInteger("oid_legajo"));
			  dsLegajos.next();
		  }
		  
		  IDataSet dsValoresClasif = mapaDatos.getDataSet("TValoresClasificador");
		  dsValoresClasif.first();
		  while (!dsValoresClasif.EOF()) {
			  ValorClasificadorEntidad valorClasifEnt =
				  ValorClasificadorEntidad.findByOid(dsValoresClasif.getInteger("oid_valor_clasif"), this.getSesion());
			  listaValoresClasif.add(valorClasifEnt);
			  dsValoresClasif.next();
		  }
		  
		  
		  
		  traerDatosPlanif(mapaDatos.getDate("fecha"),mapaDatos.getInteger("dias"),clasificadorEntidad,listaLegajos,listaValoresClasif);
	  }
  }
  
  private void cargarPlanificacion(java.util.Date fecha,int dias) throws BaseException {

	  // Traer la planificacion de Rotas de los legajos seleccionados
	  java.util.Date fecDesde = fecha;
	  java.util.Date fecHasta = Fecha.getFechaMasDias(fecha, dias);
	  
	  Iterator iterLegRotFec = 
		  LegajoRotaFecha.getLegajosFechaRotas(fecDesde, fecHasta, this.getSesion()).iterator();
	  while (iterLegRotFec.hasNext()) {
		  LegajoRotaFecha legajoRotaFecha = (LegajoRotaFecha) iterLegRotFec.next();
		  HashTableDatos fechasRotas = 
			  (HashTableDatos) planificacionDeLegajos.get(legajoRotaFecha.getLegajo().getOIDInteger());
		  if (fechasRotas == null) {
			  fechasRotas = new HashTableDatos();
			  planificacionDeLegajos.put(legajoRotaFecha.getLegajo().getOIDInteger(), fechasRotas);
		  }
		  fechasRotas.put(Fecha.getddmmyyyy(legajoRotaFecha.getFecha()), legajoRotaFecha.getRota());
	  }
  }
  
  private void traerDatosPlanif(
		  java.util.Date fecha,
		  int dias,
		  ClasificadorEntidad clasificador,
		  List listaLegajos,
		  List listaValoresClasif) throws BaseException {
	
	  IDataSet ds = getDataSetPlanifRotas(fecha,dias);
	  
	  cargarPlanificacion(fecha,dias);
	  
	  Iterator iterLegByCond = 
		  Legajo.getLegajosByCondiciones(listaLegajos,listaValoresClasif,this.getSesion()).iterator();
	  while (iterLegByCond.hasNext()) {
		  Legajo legajo = (Legajo) iterLegByCond.next();
		  cargarPlanifLegajo(ds,legajo,fecha,dias,clasificador);
	  }
	  
	  writeCliente(ds);
	  
	  
  }
  
  private String getCodRota(Legajo legajo, java.util.Date fecha) throws BaseException {
	  
	  HashTableDatos fechas = (HashTableDatos)planificacionDeLegajos.get(legajo.getOIDInteger());
	  if (fechas==null) return "";
	  Rota rota = (Rota)fechas.get(Fecha.getddmmyyyy(fecha));
	  if (rota == null) return "";
	  return rota.getCodigo();
  }
  
  private void cargarPlanifLegajo(
		  	IDataSet ds,
		  	Legajo legajo,
		  	java.util.Date fecha,
		  	int dias,
		  	ClasificadorEntidad clasificador) throws BaseException {
	  
	  ds.append();
	  ds.fieldValue("oid_legajo", legajo.getOIDInteger());
	  ds.fieldValue("cod_legajo", legajo.getCodigo());
	  ds.fieldValue("ape_y_nom", legajo.getApellidoyNombre());
	  
	  if (clasificador!=null) {
		  ValorClasificadorEntidad valClasifEnt = 
			  legajo.getValorClasifEnt(clasificador);
		  if (valClasifEnt!=null)
			  ds.fieldValue("agrupador", valClasifEnt.getDescripcion());
		  else
			  ds.fieldValue("agrupador", "Sin Clasificar");
	  } else
		  ds.fieldValue("agrupador", "");
	  
	  java.util.Date fechaPlanif = Fecha.getFechaDiaAnterior(fecha);
	  
	  for (int i=1;i<=dias;++i) {
		  fechaPlanif = Fecha.getFechaMasDias(fechaPlanif, 1);
		  ds.fieldValue("_"+Fecha.getddmmyyyy(fechaPlanif).replaceAll("/", "_"),getCodRota(legajo,fechaPlanif));
	  }
	  
  }
  
  private void inicializarPlanifRotas(java.util.Date fecha,int dias) throws BaseException {
	  
	  IDataSet ds = getDataSetIniPlanif();
	  
	  cargarCamposTablas(ds,"oid_legajo","INTEGER",0,"");
	  cargarCamposTablas(ds,"cod_legajo","STRING",50,"");
	  cargarCamposTablas(ds,"ape_y_nom","STRING",255,"");
	  cargarCamposTablas(ds,"agrupador","STRING",255,"");
	  
	  
	  java.util.Date fechaPlanif = Fecha.getFechaDiaAnterior(fecha);
	  
	  for (int i=1;i<=dias;++i) {
		  fechaPlanif = Fecha.getFechaMasDias(fechaPlanif, 1);
		  cargarCamposTablas(ds,"_"+Fecha.getddmmyyyy(fechaPlanif).replaceAll("/", "_"),"STRING",50,Fecha.getddmmyyyy(fechaPlanif));
	  }
	  
	  writeCliente(ds);
  }

  private IDataSet getDataSetPlanifRotas(java.util.Date fecha, int cantDias) throws BaseException { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TPlanifRotas");
    dataset.fieldDef(new Field("oid_legajo", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_legajo", Field.STRING, 50));
    dataset.fieldDef(new Field("ape_y_nom", Field.STRING, 255));
    dataset.fieldDef(new Field("agrupador", Field.STRING, 255));
    
    java.util.Date fechaPlanif = Fecha.getFechaDiaAnterior(fecha);
    for (int i=1;i<=cantDias;++i) {
    	fechaPlanif = Fecha.getFechaMasDias(fechaPlanif, 1);
    	dataset.fieldDef(new Field("_"+Fecha.getddmmyyyy(fechaPlanif).replaceAll("/","_"), Field.STRING, 50));
    }
    
    return dataset;
  }
  
  private IDataSet getDataSetIniPlanif() throws BaseException {
	 IDataSet dataset = new TDataSet(); 
	 dataset.create("TCamposTablasPlanif");
	 dataset.fieldDef(new Field("campo", Field.STRING, 50));
	 dataset.fieldDef(new Field("tipo", Field.STRING, 100));
	 dataset.fieldDef(new Field("longitud", Field.INTEGER, 0));
	 dataset.fieldDef(new Field("nombre", Field.STRING, 50));
	 return dataset;
  }
  
  private void cargarCamposTablas(IDataSet ds,String campo,String tipo,Integer longitud,String nombre) throws BaseException {
	ds.append();
	ds.fieldValue("campo", campo);
	ds.fieldValue("tipo", tipo);
	ds.fieldValue("longitud", longitud);
	ds.fieldValue("nombre", nombre);
  }

  private void cargarRegistroRotas(IDataSet dataset, 
                         Rota rota) throws BaseException {
    dataset.append(); 
    dataset.fieldValue("oid_rota", rota.getOIDInteger());
    dataset.fieldValue("codigo", rota.getCodigo());
    dataset.fieldValue("descripcion", rota.getDescripcion());
    dataset.fieldValue("horario_desde", rota.getHorario_desde());
    dataset.fieldValue("horario_hasta", rota.getHorario_hasta());
    dataset.fieldValue("min_ent_antes", rota.getMin_ent_antes());
    dataset.fieldValue("activo", rota.isActivo());
    dataset.fieldValue("min_ent_desp", rota.getMin_ent_desp());
    dataset.fieldValue("min_sal_antes", rota.getMin_sal_antes());
    dataset.fieldValue("tipo_acceso", rota.getTipo_acceso());
    dataset.fieldValue("tipo_egreso", rota.getTipo_egreso());
    dataset.fieldValue("min_sal_despues", rota.getMin_sal_despues());
  }
}
