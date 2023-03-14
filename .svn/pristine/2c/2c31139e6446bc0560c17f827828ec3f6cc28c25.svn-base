package com.srn.erp.compras.op;

import com.srn.erp.compras.bm.LugarEntrega;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerLugarEntrega extends Operation { 

  public TraerLugarEntrega() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    LugarEntrega lugarentrega = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       lugarentrega = LugarEntrega.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       lugarentrega = LugarEntrega.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetLugarEntrega = getDataSetLugarEntrega();
    if (lugarentrega != null) 
        cargarRegistroLugarEntrega(datasetLugarEntrega,lugarentrega); 
   
    writeCliente(datasetLugarEntrega);
  }

  private IDataSet getDataSetLugarEntrega() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TLugarEntrega");
    dataset.fieldDef(new Field("oid_lug_entrega", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 20)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    dataset.fieldDef(new Field("direccion", Field.STRING, 100));
    dataset.fieldDef(new Field("localidad", Field.STRING, 50));
    dataset.fieldDef(new Field("oid_provincia", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_provincia", Field.STRING, 20));
    dataset.fieldDef(new Field("desc_provincia", Field.STRING, 50));
    dataset.fieldDef(new Field("oid_pais", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_pais", Field.STRING, 20));
    dataset.fieldDef(new Field("desc_pais", Field.STRING, 50));
    dataset.fieldDef(new Field("codigo_postal", Field.STRING, 20));
    dataset.fieldDef(new Field("telefonos", Field.STRING, 50));
    return dataset;
  }

  private void cargarRegistroLugarEntrega(IDataSet dataset, 
                         LugarEntrega lugarEntrega) throws BaseException {
    dataset.append(); 
    dataset.fieldValue("oid_lug_entrega", lugarEntrega.getOIDInteger());
    dataset.fieldValue("codigo", lugarEntrega.getCodigo());
    dataset.fieldValue("descripcion", lugarEntrega.getDescripcion());
    dataset.fieldValue("activo", lugarEntrega.isActivo());
    dataset.fieldValue("direccion", lugarEntrega.getDireccion());
    dataset.fieldValue("localidad", lugarEntrega.getLocalidad());
    if (lugarEntrega.getProvincia()!=null) {
      dataset.fieldValue("oid_provincia", lugarEntrega.getProvincia().getOID());
      dataset.fieldValue("cod_provincia", lugarEntrega.getProvincia().getCodigo());
      dataset.fieldValue("desc_provincia", lugarEntrega.getProvincia().getDescripcion());
    } else {
      dataset.fieldValue("oid_provincia", 0);
      dataset.fieldValue("cod_provincia", "");
      dataset.fieldValue("desc_provincia", "");
    }
    if (lugarEntrega.getPais()!=null) {
      dataset.fieldValue("oid_pais", lugarEntrega.getPais().getOID());
      dataset.fieldValue("cod_pais", lugarEntrega.getPais().getCodigo());
      dataset.fieldValue("desc_pais", lugarEntrega.getPais().getDescripcion());
    } else {
      dataset.fieldValue("oid_pais", 0);
      dataset.fieldValue("cod_pais", "");
      dataset.fieldValue("desc_pais", "");
    }
    dataset.fieldValue("codigo_postal", lugarEntrega.getCodigoPostal());
    dataset.fieldValue("telefonos", lugarEntrega.getTelefonos());
    
  }
}
