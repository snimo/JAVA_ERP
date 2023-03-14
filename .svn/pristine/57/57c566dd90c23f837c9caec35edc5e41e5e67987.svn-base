package com.srn.erp.cip.op;

import java.util.Iterator;

import com.srn.erp.cip.bm.CacheoPersona;
import com.srn.erp.cip.bm.PersonalSeguridad;
import com.srn.erp.sueldos.bm.Legajo;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerCacheosRealizados extends Operation { 

  public TraerCacheosRealizados() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	  
	  Legajo legajo = null;
	  java.util.Date fecDesde = null;
	  java.util.Date fecHasta = null;
	  PersonalSeguridad personaSeguridad = null;
	  
	  if (mapaDatos.containsKey("fec_desde"))
		  fecDesde = (java.util.Date) mapaDatos.getDate("fec_desde");	  
	  
	  if (mapaDatos.containsKey("fec_hasta"))
		  fecHasta = (java.util.Date) mapaDatos.getDate("fec_hasta");
	  
	  if (mapaDatos.containsKey("oid_legajo"))
		  legajo = Legajo.findByOidProxy(mapaDatos.getInteger("oid_legajo"), this.getSesion());	  

	  if (mapaDatos.containsKey("oid_pers_segu"))
		  personaSeguridad = PersonalSeguridad.findByOidProxy(mapaDatos.getInteger("oid_pers_segu"), this.getSesion());	  
	  
	  IDataSet dsCacheo = this.getDataSetCacheo();
	  
	  Iterator iterCacheos = 
		  CacheoPersona.getCacheosPersonas(fecDesde, fecHasta, legajo, personaSeguridad , this.getSesion()).iterator();
	  while (iterCacheos.hasNext()) {
		  CacheoPersona cacheoPersona = (CacheoPersona) iterCacheos.next();
		  cargarRegistro(dsCacheo, cacheoPersona);
	  }
	  writeCliente(dsCacheo);
  }

  private IDataSet getDataSetCacheo() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TCacheos");
    dataset.fieldDef(new Field("oid_cacheo_pers", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_pers_segu", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_legajo", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_legajo", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_legajo", Field.STRING, 100));
    dataset.fieldDef(new Field("fecha", Field.DATE, 0));
    dataset.fieldDef(new Field("hora", Field.STRING, 5));
    dataset.fieldDef(new Field("observacion", Field.STRING, 255));
    dataset.fieldDef(new Field("oid_res_cacheo", Field.INTEGER, 0));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    return dataset;
  }

  private void cargarRegistro(IDataSet dataset, 
                         	  CacheoPersona cacheoPersona) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid_cacheo_pers", cacheoPersona.getOIDInteger());
    if (cacheoPersona.getPersonalSeguridad()!=null)
    	dataset.fieldValue("oid_pers_segu", cacheoPersona.getPersonalSeguridad().getOIDInteger());
    else
    	dataset.fieldValue("oid_pers_segu", "");
    dataset.fieldValue("oid_legajo", cacheoPersona.getLegajo().getOIDInteger());
    dataset.fieldValue("cod_legajo", cacheoPersona.getLegajo().getCodigo());
    dataset.fieldValue("desc_legajo", cacheoPersona.getLegajo().getApellidoyNombre());
    dataset.fieldValue("fecha", cacheoPersona.getFecha());
    dataset.fieldValue("hora", cacheoPersona.getHora());
    dataset.fieldValue("observacion", cacheoPersona.getObservacion());
    if (cacheoPersona.getResultadoCacheo()!=null)
    	dataset.fieldValue("oid_res_cacheo", cacheoPersona.getResultadoCacheo().getOIDInteger());
    else
    	dataset.fieldValue("oid_res_cacheo", "");
    dataset.fieldValue("activo", cacheoPersona.isActivo());
  }
}
