package com.srn.erp.cip.op;

import com.srn.erp.cip.bm.PuntoFichadaCIP;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerPuntoFichadaCIP extends Operation { 

  public TraerPuntoFichadaCIP() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    PuntoFichadaCIP puntofichadacip = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       puntofichadacip = PuntoFichadaCIP.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       puntofichadacip = PuntoFichadaCIP.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetPuntoFichadaCIP = getDataSetPuntoFichadaCIP();
    if (puntofichadacip != null) { 
        cargarRegistroPuntoFichadaCIP(datasetPuntoFichadaCIP, 
                         puntofichadacip.getOIDInteger(),
                         puntofichadacip.getCodigo(),
                         puntofichadacip.getDescripcion(),
                         puntofichadacip.isActivo(),
                         puntofichadacip.isAntipassbackEnt(),
                         puntofichadacip.isAntipassbackSal()
                         );
    }
    writeCliente(datasetPuntoFichadaCIP);
  }

  private IDataSet getDataSetPuntoFichadaCIP() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TPuntoFichadaCIP");
    dataset.fieldDef(new Field("oid_pto_fichada", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 50)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("antipassback_ent", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("antipassback_sal", Field.BOOLEAN, 0));    
    return dataset;
  }

  private void cargarRegistroPuntoFichadaCIP(IDataSet dataset, 
                         Integer oid_pto_fichada,
                         String codigo,
                         String descripcion,
                         Boolean activo,
                         Boolean antipassbackEnt,
                         Boolean antipassbackSal) {
    dataset.append(); 
    dataset.fieldValue("oid_pto_fichada", oid_pto_fichada);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("activo", activo);
    dataset.fieldValue("antipassback_ent", antipassbackEnt);
    dataset.fieldValue("antipassback_sal", antipassbackSal);    
  }
}
