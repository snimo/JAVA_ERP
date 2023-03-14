package com.srn.erp.cip.op;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.cip.bm.MovVisitaCIP;
import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.general.bm.ValorClasificadorEntidad;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerMovimVisCIP extends Operation { 

  public TraerMovimVisCIP() { 
  }
  
  HashTableDatos planificacionDeVisitas = new HashTableDatos();

  public void execute(MapDatos mapaDatos) throws BaseException {
	  
	  // Tomar los parametros
	  java.util.Date fecDesde = mapaDatos.getDate("fec_desde");
	  java.util.Date fecHasta = mapaDatos.getDate("fec_hasta");
	  
	  if (fecDesde == null)
		  throw new ExceptionValidation(null,"Debe ingresar la fecha desde");
	  
	  if (fecHasta == null)
		  throw new ExceptionValidation(null,"Debe ingresar la fecha hasta");	  
	  
	  Integer oidGrupoClasif = null;
	  ClasificadorEntidad clasifEntTitulo = null;
	  if (mapaDatos.containsKey("oid_clasif_agrupador")) {
		  oidGrupoClasif = mapaDatos.getInteger("oid_clasif_agrupador");
		  clasifEntTitulo = ClasificadorEntidad.findByOidProxy(oidGrupoClasif, this.getSesion()); 
	  }
	  
	  List listaVisitas = new ArrayList();
	  List listaValoresClasif = new ArrayList();
	  
	  IDataSet dsVisitas = mapaDatos.getDataSet("TVisitasAPlanif");
	  dsVisitas.first();
	  while (!dsVisitas.EOF()) {
		  listaVisitas.add(dsVisitas.getInteger("oid_visita"));
		  dsVisitas.next();
	  }
	  
	  IDataSet dsValoresClasif = mapaDatos.getDataSet("TValoresClasificador");
	  dsValoresClasif.first();
	  while (!dsValoresClasif.EOF()) {
		  ValorClasificadorEntidad valorClasifEnt =
			  ValorClasificadorEntidad.findByOid(dsValoresClasif.getInteger("oid_valor_clasif"), this.getSesion());
		  listaValoresClasif.add(valorClasifEnt);
		  dsValoresClasif.next();
	  }	  
	  
	  IDataSet dsMovCIP = this.getDataSetMovCIP();
	  Iterator iterMovCIP = 
		  MovVisitaCIP.getMovimientosCIP(fecDesde, fecHasta, clasifEntTitulo, listaVisitas, listaValoresClasif, this.getSesion()).iterator();
	  while (iterMovCIP.hasNext()) {
		  MovVisitaCIP movCIP = (MovVisitaCIP) iterMovCIP.next();
		  cargarRegMov(movCIP,clasifEntTitulo,dsMovCIP);
		  movCIP = null;
	  }
	  writeCliente(dsMovCIP);
	  
  }
  
  private IDataSet getDataSetMovCIP() throws BaseException {
	 IDataSet dataset = new TDataSet(); 
	 dataset.create("TMovimientos");
	 dataset.fieldDef(new Field("oid_mov", Field.INTEGER, 0));
	 dataset.fieldDef(new Field("oid_visita", Field.INTEGER, 0));
	 dataset.fieldDef(new Field("visita", Field.STRING, 50));
	 dataset.fieldDef(new Field("ape_y_nom", Field.STRING, 100));
	 dataset.fieldDef(new Field("oid_puerta", Field.INTEGER, 0));
	 dataset.fieldDef(new Field("puerta", Field.STRING, 50));
	 dataset.fieldDef(new Field("fecha", Field.DATE, 0));
	 dataset.fieldDef(new Field("hora", Field.STRING, 8));
	 dataset.fieldDef(new Field("sentido",Field.STRING, 1));
	 dataset.fieldDef(new Field("titulo",Field.STRING, 50));
	 dataset.fieldDef(new Field("zona_origen", Field.STRING, 100));
	 dataset.fieldDef(new Field("zona_destino", Field.STRING, 100));
	 dataset.fieldDef(new Field("tarjeta", Field.STRING, 50));
	 return dataset;
  }
  
  private void cargarRegMov(MovVisitaCIP mov,ClasificadorEntidad clasifEntTitu,IDataSet ds) throws BaseException {
	ds.append();
	ds.fieldValue("oid_mov", mov.getOIDInteger());
	ds.fieldValue("oid_visita", mov.getVisita().getOIDInteger());
	ds.fieldValue("visita", mov.getVisita().getNroDocumento());
	ds.fieldValue("ape_y_nom", mov.getVisita().getApeyNom());
	ds.fieldValue("oid_puerta", mov.getPuerta().getOIDInteger());
	ds.fieldValue("puerta", mov.getPuerta().getDescripcion());
	ds.fieldValue("fecha", mov.getFecha());
	ds.fieldValue("hora", mov.getHora());
	ds.fieldValue("sentido",mov.getSentido());
	String titulo = "";
	if (clasifEntTitu!=null) {
		ValorClasificadorEntidad valClasif =
			mov.getVisita().getValorClasifEnt(clasifEntTitu);
		if (valClasif!=null)
			titulo = valClasif.getDescripcion();
	}
	ds.fieldValue("titulo",titulo);
	
	if (mov.getZona_origen()!=null)
		ds.fieldValue("zona_origen", mov.getZona_origen().getDescripcion());
	else
		ds.fieldValue("zona_origen", "");
			
	if (mov.getZona_destino()!=null)
		ds.fieldValue("zona_destino", mov.getZona_destino().getDescripcion());
	else
		ds.fieldValue("zona_destino", "");
	if (mov.getTarjeta()!=null)
		ds.fieldValue("tarjeta", mov.getTarjeta().getNro_tarjeta());
	else
		ds.fieldValue("tarjeta", "");
	
  }

}
