package com.srn.erp.cashflow.op;

import com.srn.erp.cashflow.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Tablas.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.*;

public class TraerProgFechasCF extends Operation { 

  public TraerProgFechasCF() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    ProgFechasCF progfechascf = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       progfechascf = ProgFechasCF.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       progfechascf = ProgFechasCF.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetProgFechasCF = getDataSetProgFechasCF();
    if (progfechascf != null) { 
        cargarRegistroProgFechasCF(datasetProgFechasCF, 
                         progfechascf.getOIDInteger(),
                         progfechascf.getCodigo(),
                         progfechascf.getDescripcion(),
                         progfechascf.getFec_desde(),
                         progfechascf.getFec_hasta(),
                         progfechascf.getEscenario(),
                         progfechascf.isActivo()
                         );
    }
    writeCliente(datasetProgFechasCF);
  }

  private IDataSet getDataSetProgFechasCF() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TProgFechasCF");
    dataset.fieldDef(new Field("oid_prog_cf", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 20)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100)); 
    dataset.fieldDef(new Field("fec_desde", Field.STRING, 0)); 
    dataset.fieldDef(new Field("fec_hasta", Field.STRING, 0)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    dataset.fieldDef(new Field("oid_escenario", Field.INTEGER, 0));
    return dataset;
  }

  private void cargarRegistroProgFechasCF(IDataSet dataset, 
                         Integer oid_prog_cf,
                         String codigo,
                         String descripcion,
                         java.util.Date fec_desde,
                         java.util.Date fec_hasta,
                         EscenarioCashFlow escenario,
                         Boolean activo) {
    dataset.append(); 
    dataset.fieldValue("oid_prog_cf", oid_prog_cf);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("fec_desde", fec_desde);
    dataset.fieldValue("fec_hasta", fec_hasta);
    dataset.fieldValue("activo", activo);
    dataset.fieldValue("oid_escenario", escenario.getOIDInteger());
  }
}
