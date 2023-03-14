package com.srn.erp.legales.op;

import com.srn.erp.legales.bm.EstadoSeclo;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerEstadoSeclo extends Operation { 

  public TraerEstadoSeclo() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    EstadoSeclo estadoseclo = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       estadoseclo = EstadoSeclo.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       estadoseclo = EstadoSeclo.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetEstadoSeclo = getDataSetEstadoSeclo();
    if (estadoseclo != null) { 
        cargarRegistroEstadoSeclo(datasetEstadoSeclo, 
                         estadoseclo.getOIDInteger(),
                         estadoseclo.getDescripcion(),
                         estadoseclo.isActivo());
    }
    writeCliente(datasetEstadoSeclo);
  }

  private IDataSet getDataSetEstadoSeclo() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TEstadoSeclo");
    dataset.fieldDef(new Field("oid_estado_seclo", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 80)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistroEstadoSeclo(IDataSet dataset, 
                         Integer oid_estado_seclo,
                         String descripcion,
                         Boolean activo) {
    dataset.append(); 
    dataset.fieldValue("oid_estado_seclo", oid_estado_seclo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("activo", activo);
  }
}
