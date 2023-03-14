package com.srn.erp.cip.op;

import java.util.Iterator;

import com.srn.erp.cip.bm.Cacheo;
import com.srn.erp.cip.bm.GrupoPuerta;
import com.srn.erp.cip.bm.LegajoRotaFecha;
import com.srn.erp.sueldos.bm.Legajo;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerCacheosPendAHoy extends Operation { 

  public TraerCacheosPendAHoy() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	  
	  Legajo legajo = null;
	  java.util.Date fecHasta = null;
	  GrupoPuerta grupoPuerta = null;
	  
	  if (mapaDatos.containsKey("fec_hasta"))
		  fecHasta = (java.util.Date) mapaDatos.getDate("fec_hasta");
	  
	  if (mapaDatos.containsKey("oid_legajo"))
		  legajo = Legajo.findByOidProxy(mapaDatos.getInteger("oid_legajo"), this.getSesion());	  

	  if (mapaDatos.containsKey("oid_grupo_puerta"))
		  grupoPuerta = GrupoPuerta.findByOidProxy(mapaDatos.getInteger("oid_grupo_puerta"), this.getSesion());	  
	  
	  IDataSet dsCacheo = this.getDataSetCacheo();
	  Iterator iterCacheos = 
		  Cacheo.getCacheoPendAHoy(legajo, fecHasta, grupoPuerta,this.getSesion()).iterator();
	  while (iterCacheos.hasNext()) {
		  Cacheo cacheo = (Cacheo) iterCacheos.next();
		  cargarRegistro(dsCacheo, cacheo);
	  }
	  writeCliente(dsCacheo);
  }

  private IDataSet getDataSetCacheo() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TCacheos");
    dataset.fieldDef(new Field("oid_cacheo", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_legajo", Field.INTEGER, 0));
    dataset.fieldDef(new Field("nro_legajo", Field.STRING, 50));
    dataset.fieldDef(new Field("ape_y_nom", Field.STRING, 100));
    dataset.fieldDef(new Field("fec_planif_cacheo", Field.DATE, 0));
    dataset.fieldDef(new Field("ent_o_sal", Field.STRING, 1));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("oid_grupo_puerta", Field.INTEGER, 0));
    dataset.fieldDef(new Field("rota", Field.STRING, 100));
    
    
    return dataset;
  }

  private void cargarRegistro(IDataSet dataset, 
                         	  Cacheo cacheo) throws BaseException {
    dataset.append(); 
    dataset.fieldValue("oid_cacheo", cacheo.getOIDInteger());
    dataset.fieldValue("oid_legajo", cacheo.getLegajo().getOIDInteger());
    dataset.fieldValue("nro_legajo", cacheo.getLegajo().getNro_legajo());
    dataset.fieldValue("ape_y_nom", cacheo.getLegajo().getApellidoyNombre());
    dataset.fieldValue("fec_planif_cacheo", cacheo.getFec_planif_cacheo());
    dataset.fieldValue("ent_o_sal", cacheo.getEnt_o_sal());
    dataset.fieldValue("activo", cacheo.isActivo());
    dataset.fieldValue("oid_grupo_puerta", cacheo.getGrupoPuerta().getOIDInteger());
    LegajoRotaFecha legRotaFec =
    	LegajoRotaFecha.getLegajoRotaFecha(cacheo.getLegajo(),cacheo.getFec_planif_cacheo(),this.getSesion());
    if (legRotaFec!=null)
    	dataset.fieldValue("rota", legRotaFec.getRota().getDescripcion());
    else
    	dataset.fieldValue("rota", "");
  }
}
