package com.srn.erp.cip.op;

import com.srn.erp.cip.bm.EmpresaCIP;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerEmpresaCIP extends Operation { 

  public TraerEmpresaCIP() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    EmpresaCIP empresacip = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       empresacip = EmpresaCIP.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       empresacip = EmpresaCIP.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetEmpresaCIP = getDataSetEmpresaCIP();
    if (empresacip != null) { 
        cargarRegistroEmpresaCIP(datasetEmpresaCIP, 
                         empresacip.getOIDInteger(),
                         empresacip.getRazon_social(),
                         empresacip.isActivo());
    }
    writeCliente(datasetEmpresaCIP);
  }

  private IDataSet getDataSetEmpresaCIP() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TEmpresaCIP");
    dataset.fieldDef(new Field("oid_empresa", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("razon_social", Field.STRING, 100)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistroEmpresaCIP(IDataSet dataset, 
                         Integer oid_empresa,
                         String razon_social,
                         Boolean activo) {
    dataset.append(); 
    dataset.fieldValue("oid_empresa", oid_empresa);
    dataset.fieldValue("razon_social", razon_social);
    dataset.fieldValue("activo", activo);
  }
}
