package com.srn.erp.contabilidad.op;

import com.srn.erp.contabilidad.bm.Cuenta;
import com.srn.erp.contabilidad.bm.Subdiario;
import com.srn.erp.contabilidad.bm.SubdiarioDet;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveSubdiario extends Operation { 

  public SaveSubdiario() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TSubdiario"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        Subdiario subdiario = Subdiario.findByOid(dataset.getInteger("oid_subdiario"),getSesion());
        subdiario.setOID(dataset.getInteger("oid_subdiario"));
        subdiario.setCodigo(dataset.getString("codigo"));
        subdiario.setDescripcion(dataset.getString("descripcion"));
        subdiario.setActivo(dataset.getBoolean("activo"));
        
        IDataSet dsSubDiarioDet = dataset.getDataSet("TSubdiarioDet");
        dsSubDiarioDet.first();
        while (!dsSubDiarioDet.EOF()) {
        	SubdiarioDet subdiarioDet =
        		SubdiarioDet.findByOid(dsSubDiarioDet.getInteger("oid_subdiario_det"), this.getSesion());
        	subdiarioDet.setSubdiario(subdiario);
        	subdiarioDet.setCuenta(Cuenta.findByOidProxy(dsSubDiarioDet.getInteger("oid_ana_con"), this.getSesion()));
        	subdiarioDet.setActivo(dsSubDiarioDet.getBoolean("activo"));
        	if (!subdiarioDet.isActivo())
        		subdiarioDet.delete();
        	subdiario.addSubdiarioDet(subdiarioDet);
        	dsSubDiarioDet.next();
        }
        
        addTransaccion(subdiario);
        dataset.next();
    }
  }
  
}
