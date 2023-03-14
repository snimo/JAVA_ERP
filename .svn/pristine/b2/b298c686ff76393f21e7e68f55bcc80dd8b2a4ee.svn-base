package com.srn.erp.legales.op;

import com.srn.erp.legales.bm.Abogado;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveAbogado extends Operation { 

  public SaveAbogado() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TAbogado"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        Abogado abogado = Abogado.findByOid(dataset.getInteger("oid_abogado"),getSesion());
        abogado.setOID(dataset.getInteger("oid_abogado"));
        abogado.setApellido(dataset.getString("apellido"));
        abogado.setNombre(dataset.getString("nombre"));
        abogado.setTelefonos(dataset.getString("telefonos"));
        abogado.setMail(dataset.getString("mail"));
        abogado.setDireccion(dataset.getString("direccion"));
        abogado.setEstudio(dataset.getString("estudio"));
        abogado.setActivo(dataset.getBoolean("activo"));
        abogado.setCUIT(dataset.getString("cuit"));
        addTransaccion(abogado);
        dataset.next();
    }
  }
  
}
