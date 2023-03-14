package com.srn.erp.legales.op;

import com.srn.erp.legales.bm.TipoReclamoLeg;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerTipoReclamoLeg extends Operation { 

  public TraerTipoReclamoLeg() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    TipoReclamoLeg tiporeclamoleg = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       tiporeclamoleg = TipoReclamoLeg.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       tiporeclamoleg = TipoReclamoLeg.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetTipoReclamoLeg = getDataSetTipoReclamoLeg();
    if (tiporeclamoleg != null) { 
        cargarRegistroTipoReclamoLeg(datasetTipoReclamoLeg, 
                         tiporeclamoleg.getOIDInteger(),
                         tiporeclamoleg.getDescripcion(),
                         tiporeclamoleg.isActivo());
    }
    writeCliente(datasetTipoReclamoLeg);
  }

  private IDataSet getDataSetTipoReclamoLeg() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TTipoReclamoLeg");
    dataset.fieldDef(new Field("oid_tipo_reclamo", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 80)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistroTipoReclamoLeg(IDataSet dataset, 
                         Integer oid_tipo_reclamo,
                         String descripcion,
                         Boolean activo) {
    dataset.append(); 
    dataset.fieldValue("oid_tipo_reclamo", oid_tipo_reclamo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("activo", activo);
  }
}
