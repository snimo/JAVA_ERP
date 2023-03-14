package com.srn.erp.turnos.op;

import com.srn.erp.turnos.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Tablas.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.*;

public class TraerMotivoReservaTurno extends Operation { 

  public TraerMotivoReservaTurno() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    MotivoReservaTurno motivoreservaturno = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       motivoreservaturno = MotivoReservaTurno.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       motivoreservaturno = MotivoReservaTurno.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetMotivoReservaTurno = getDataSetMotivoReservaTurno();
    if (motivoreservaturno != null) { 
        cargarRegistroMotivoReservaTurno(datasetMotivoReservaTurno, 
                         motivoreservaturno.getOIDInteger(),
                         motivoreservaturno.getCodigo(),
                         motivoreservaturno.getDescripcion(),
                         motivoreservaturno.isActivo());
    }
    writeCliente(datasetMotivoReservaTurno);
  }

  private IDataSet getDataSetMotivoReservaTurno() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TMotivoReservaTurno");
    dataset.fieldDef(new Field("oid_motivo", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 50)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 255)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistroMotivoReservaTurno(IDataSet dataset, 
                         Integer oid_motivo,
                         String codigo,
                         String descripcion,
                         Boolean activo) {
    dataset.append(); 
    dataset.fieldValue("oid_motivo", oid_motivo);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("activo", activo);
  }
}
