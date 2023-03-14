package com.srn.erp.cip.op;

import com.srn.erp.cip.bm.EmpresaCIP;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class SaveAltaEmpresaCIP extends Operation { 

  public SaveAltaEmpresaCIP() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    String empresa = mapaDatos.getString("empresa");
    if (empresa == null)
    	throw new ExceptionValidation(null,"Debe ingresar la empresa");
    if (empresa.trim().length() == 0)
    	throw new ExceptionValidation(null,"Debe ingresar la empresa");
    EmpresaCIP empresaCIP = EmpresaCIP.getEmpresaCIP(empresa, this.getSesion());
    if (empresaCIP == null) {
    	empresaCIP = (EmpresaCIP) EmpresaCIP.getNew(EmpresaCIP.NICKNAME, this.getSesion());
    	empresaCIP.setRazon_social(empresa);
    	empresaCIP.setActivo(true);
    	empresaCIP.save();
    }
    
    IDataSet dsEmpresa = this.getDataSetAltaEmpresa();
    if (empresaCIP!=null)
    	cargarEmpresa(dsEmpresa, empresaCIP.getOIDInteger(), empresaCIP.getRazon_social());
    writeCliente(dsEmpresa);
    
    
  } 
  
  private IDataSet getDataSetAltaEmpresa() {
	    IDataSet dataset = new TDataSet();
	    dataset.create("TAltaEmpresa");
	    dataset.fieldDef(new Field("oid_empresa", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("empresa", Field.STRING, 100));
	    return dataset;
  }

  private void cargarEmpresa(
		  IDataSet dataset,
	      Integer oidEmpresa,
	      String empresa) {
	    dataset.append();
	    dataset.fieldValue("oid_empresa", oidEmpresa);
	    dataset.fieldValue("empresa", empresa);
  }
  

  
}
