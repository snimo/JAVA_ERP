package com.srn.erp.cip.op;

import com.srn.erp.cip.bm.Biometrico;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerBiometrico extends Operation { 

  public TraerBiometrico() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    Biometrico biometrico = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       biometrico = Biometrico.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       biometrico = Biometrico.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetBiometrico = getDataSetBiometrico();
    if (biometrico != null) { 
        cargarRegistroBiometrico(datasetBiometrico,biometrico);
    }
    writeCliente(datasetBiometrico);
  }

  private IDataSet getDataSetBiometrico() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TBiometrico");
    dataset.fieldDef(new Field("oid_biometrico", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 20)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50)); 
    dataset.fieldDef(new Field("ip", Field.STRING, 50)); 
    dataset.fieldDef(new Field("puerto", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("tipo_biometrico", Field.STRING, 20)); 
    dataset.fieldDef(new Field("nro_biometrico", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistroBiometrico(IDataSet dataset, 
                         Biometrico biometrico) throws BaseException {
    dataset.append(); 
    dataset.fieldValue("oid_biometrico", biometrico.getOIDInteger());
    dataset.fieldValue("codigo", biometrico.getCodigo());
    dataset.fieldValue("descripcion", biometrico.getDescripcion());
    dataset.fieldValue("ip", biometrico.getIp());
    dataset.fieldValue("puerto", biometrico.getPuerto());
    dataset.fieldValue("tipo_biometrico", biometrico.getTipo_biometrico());
    dataset.fieldValue("nro_biometrico", biometrico.getNro_biometrico());
    dataset.fieldValue("activo", biometrico.isActivo());
  }
}
