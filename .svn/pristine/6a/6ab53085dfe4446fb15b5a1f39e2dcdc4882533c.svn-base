package com.srn.erp.compras.op;

import com.srn.erp.compras.bm.LugarEntrega;
import com.srn.erp.general.bm.Pais;
import com.srn.erp.general.bm.Provincia;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveLugarEntrega extends Operation { 

  public SaveLugarEntrega() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TLugarEntrega"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        LugarEntrega lugarentrega = LugarEntrega.findByOid(dataset.getInteger("oid_lug_entrega"),getSesion());
        lugarentrega.setOID(dataset.getInteger("oid_lug_entrega"));
        lugarentrega.setCodigo(dataset.getString("codigo"));
        lugarentrega.setDescripcion(dataset.getString("descripcion"));
        lugarentrega.setActivo(dataset.getBoolean("activo"));
        lugarentrega.setDireccion(dataset.getString("direccion"));
        lugarentrega.setLocalidad(dataset.getString("localidad"));
        lugarentrega.setProvincia(Provincia.findByOidProxy(dataset.getInteger("oid_provincia"),getSesion()));
        lugarentrega.setPais(Pais.findByOidProxy(dataset.getInteger("oid_pais"),getSesion()));
        lugarentrega.setCodigoPostal(dataset.getString("codigo_postal"));
        lugarentrega.setTelefonos(dataset.getString("telefonos"));
        addTransaccion(lugarentrega);
        dataset.next();
    }
  }
  
}
