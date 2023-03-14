package com.srn.erp.turnos.op;

import com.srn.erp.turnos.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Tablas.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.*;

public class TraerRelacionSujetoTurno extends Operation { 

  public TraerRelacionSujetoTurno() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    RelacionSujetoTurno relacionsujetoturno = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       relacionsujetoturno = RelacionSujetoTurno.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       relacionsujetoturno = RelacionSujetoTurno.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetRelacionSujetoTurno = getDataSetRelacionSujetoTurno();
    if (relacionsujetoturno != null) { 
        cargarRegistroRelacionSujetoTurno(datasetRelacionSujetoTurno, 
                         relacionsujetoturno.getOIDInteger(),
                         relacionsujetoturno.getCodigo(),
                         relacionsujetoturno.getDescripcion(),
                         relacionsujetoturno.getComportamiento(),
                         relacionsujetoturno.isActivo(),
                         relacionsujetoturno.isNoPermitirTurno()
                         );
    }
    writeCliente(datasetRelacionSujetoTurno);
  }

  private IDataSet getDataSetRelacionSujetoTurno() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TRelacionSujetoTurno");
    dataset.fieldDef(new Field("oid_relacion", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 20)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50)); 
    dataset.fieldDef(new Field("comportamiento", Field.STRING, 20)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    dataset.fieldDef(new Field("no_permitir_turno", Field.BOOLEAN, 0));
    return dataset;
  }

  private void cargarRegistroRelacionSujetoTurno(IDataSet dataset, 
                         Integer oid_relacion,
                         String codigo,
                         String descripcion,
                         String comportamiento,
                         Boolean activo,
                         Boolean noPermitirTurno) {
    dataset.append(); 
    dataset.fieldValue("oid_relacion", oid_relacion);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("comportamiento", comportamiento);
    dataset.fieldValue("activo", activo);
    dataset.fieldValue("no_permitir_turno", noPermitirTurno);
  }
}
