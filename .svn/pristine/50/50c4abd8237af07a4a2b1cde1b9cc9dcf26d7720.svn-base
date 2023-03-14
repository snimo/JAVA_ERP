package com.srn.erp.excluidos.op;

import com.srn.erp.excluidos.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Tablas.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.*;

public class TraerSeRetiraEnExc extends Operation { 

  public TraerSeRetiraEnExc() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    SeRetiraEnExc excseretiraen = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       excseretiraen = excseretiraen.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       excseretiraen = excseretiraen.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetexcSeRetiraEn = getDataSetexcSeRetiraEn();
    if (excseretiraen != null) { 
        cargarRegistroexcSeRetiraEn(datasetexcSeRetiraEn, 
                         excseretiraen.getOIDInteger(),
                         excseretiraen.getCodigo(),
                         excseretiraen.getDescripcion(),
                         excseretiraen.isActivo());
    }
    writeCliente(datasetexcSeRetiraEn);
  }

  private IDataSet getDataSetexcSeRetiraEn() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TexcSeRetiraEn");
    dataset.fieldDef(new Field("oid_se_retira", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 20)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistroexcSeRetiraEn(IDataSet dataset, 
                         Integer oid_se_retira,
                         String codigo,
                         String descripcion,
                         Boolean activo) {
    dataset.append(); 
    dataset.fieldValue("oid_se_retira", oid_se_retira);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("activo", activo);
  }
}
