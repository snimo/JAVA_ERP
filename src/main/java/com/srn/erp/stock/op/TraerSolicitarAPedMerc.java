package com.srn.erp.stock.op;

import com.srn.erp.stock.bm.SolicitarAPedMerc;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerSolicitarAPedMerc extends Operation { 

  public TraerSolicitarAPedMerc() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    SolicitarAPedMerc solicitarapedmerc = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       solicitarapedmerc = SolicitarAPedMerc.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       solicitarapedmerc = SolicitarAPedMerc.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetSolicitarAPedMerc = getDataSetSolicitarAPedMerc();
    if (solicitarapedmerc != null) { 
        cargarRegistroSolicitarAPedMerc(datasetSolicitarAPedMerc, 
                         solicitarapedmerc.getOIDInteger(),
                         solicitarapedmerc.getCodigo(),
                         solicitarapedmerc.getDescripcion(),
                         solicitarapedmerc.isActivo());
    }
    writeCliente(datasetSolicitarAPedMerc);
  }

  private IDataSet getDataSetSolicitarAPedMerc() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TSolicitarAPedMerc");
    dataset.fieldDef(new Field("oid_sol_ped_merc", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 20)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistroSolicitarAPedMerc(IDataSet dataset, 
                         Integer oid_sol_ped_merc,
                         String codigo,
                         String descripcion,
                         Boolean activo) {
    dataset.append(); 
    dataset.fieldValue("oid_sol_ped_merc", oid_sol_ped_merc);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("activo", activo);
  }
}
