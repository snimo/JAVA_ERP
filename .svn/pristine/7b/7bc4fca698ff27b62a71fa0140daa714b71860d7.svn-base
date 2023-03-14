package com.srn.erp.cip.op;

import java.util.Iterator;

import com.srn.erp.cip.bm.Cacheo;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerCacheosPlanif extends Operation { 

  public TraerCacheosPlanif() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	  
	  java.util.Date fecDesde = mapaDatos.getDate("fec_desde");
	  java.util.Date fecHasta = mapaDatos.getDate("fec_hasta");
	  
	  IDataSet dsCacheo = this.getDataSetCacheo();
	  Iterator iterCacheos = 
		  Cacheo.getCacheos(fecDesde, fecHasta, this.getSesion()).iterator();
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
    dataset.fieldDef(new Field("estado", Field.STRING, 100));
    dataset.fieldDef(new Field("read_only", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("oid_grupo_puerta", Field.INTEGER, 0));
    
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
    if (!cacheo.isRealizado())
    	dataset.fieldValue("estado", "");
    else {
    	dataset.fieldValue("estado", Fecha.getddmmyyyy(cacheo.getFec_cacheo())+" "+cacheo.getHora_cacheo());
    }
    dataset.fieldValue("read_only", cacheo.isRealizado());
    dataset.fieldValue("oid_grupo_puerta", cacheo.getGrupoPuerta().getOIDInteger());
  }
}
