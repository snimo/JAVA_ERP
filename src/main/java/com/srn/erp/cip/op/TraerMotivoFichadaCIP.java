package com.srn.erp.cip.op;

import com.srn.erp.cip.bm.MotivoFichadaCIP;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerMotivoFichadaCIP extends Operation { 

  public TraerMotivoFichadaCIP() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    MotivoFichadaCIP motivofichadacip = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       motivofichadacip = MotivoFichadaCIP.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       motivofichadacip = MotivoFichadaCIP.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetMotivoFichadaCIP = getDataSetMotivoFichadaCIP();
    if (motivofichadacip != null) { 
        cargarRegistroMotivoFichadaCIP(datasetMotivoFichadaCIP, 
                         motivofichadacip.getOIDInteger(),
                         motivofichadacip.getDescripcion(),
                         motivofichadacip.isEntrada(),
                         motivofichadacip.isRequiere_obs_ent(),
                         motivofichadacip.isSalida(),
                         motivofichadacip.isRequiere_obs_sal(),
                         motivofichadacip.getOrden_entrada(),
                         motivofichadacip.getOrden_salida(),
                         motivofichadacip.isActivo());
    }
    writeCliente(datasetMotivoFichadaCIP);
  }

  private IDataSet getDataSetMotivoFichadaCIP() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TMotivoFichadaCIP");
    dataset.fieldDef(new Field("oid_motivo_fichada", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50)); 
    dataset.fieldDef(new Field("entrada", Field.BOOLEAN, 0)); 
    dataset.fieldDef(new Field("requiere_obs_ent", Field.BOOLEAN, 0)); 
    dataset.fieldDef(new Field("salida", Field.BOOLEAN, 0)); 
    dataset.fieldDef(new Field("requiere_obs_sal", Field.BOOLEAN, 0)); 
    dataset.fieldDef(new Field("orden_entrada", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("orden_salida", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistroMotivoFichadaCIP(IDataSet dataset, 
                         Integer oid_motivo_fichada,
                         String descripcion,
                         Boolean entrada,
                         Boolean requiere_obs_ent,
                         Boolean salida,
                         Boolean requiere_obs_sal,
                         Integer orden_entrada,
                         Integer orden_salida,
                         Boolean activo) {
    dataset.append(); 
    dataset.fieldValue("oid_motivo_fichada", oid_motivo_fichada);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("entrada", entrada);
    dataset.fieldValue("requiere_obs_ent", requiere_obs_ent);
    dataset.fieldValue("salida", salida);
    dataset.fieldValue("requiere_obs_sal", requiere_obs_sal);
    dataset.fieldValue("orden_entrada", orden_entrada);
    dataset.fieldValue("orden_salida", orden_salida);
    dataset.fieldValue("activo", activo);
  }
}
