package com.srn.erp.bienUso.op;

import com.srn.erp.bienUso.bm.ConfColAnexoA;
import com.srn.erp.bienUso.bm.ConfColAnexoAMov;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveConfColAnexoA extends Operation { 

  public SaveConfColAnexoA() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TCabecera");
    dataset.first();
    while (!dataset.EOF()) {
      procesarRegistros(dataset);
      dataset.next();
    }
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
	  
	IDataSet dsConfColIniEjer = dataset.getDataSet("TConfColAlIniEjer");
	dsConfColIniEjer.first();
	while (!dsConfColIniEjer.EOF()) {
		ConfColAnexoA confColAnexoA = ConfColAnexoA.findByOid(dsConfColIniEjer.getInteger("oid_conf_anexo_a"),getSesion());
		confColAnexoA.setCodigo(dsConfColIniEjer.getString("codigo"));
		confColAnexoA.setDescripcion(dsConfColIniEjer.getString("descripcion"));
		confColAnexoA.setNro_col(dsConfColIniEjer.getInteger("nro_col"));
		confColAnexoA.setActivo(dsConfColIniEjer.getBoolean("activo"));
		confColAnexoA.setTipo_ejercicio(ConfColAnexoA.TE_AL_INICIO);
		
		IDataSet dsMovIniEjer = dsConfColIniEjer.getDataSet("TConfMovAlIniEjer");
		dsMovIniEjer.first();
		while (!dsMovIniEjer.EOF()) {
			ConfColAnexoAMov confColAnexoAMov = ConfColAnexoAMov.findByOid(dsMovIniEjer.getInteger("oid"),getSesion());
			confColAnexoAMov.setConf_col_aneoxo(confColAnexoA);
			confColAnexoAMov.setTipo_mov(dsMovIniEjer.getString("tipo_mov"));
			confColAnexoAMov.setActivo(dsMovIniEjer.getBoolean("activo"));
			if (!confColAnexoAMov.isActivo().booleanValue())
				confColAnexoAMov.delete();
			confColAnexoA.addConfColAnexoAMov(confColAnexoAMov);
			dsMovIniEjer.next();
		}
		addTransaccion(confColAnexoA);
		dsConfColIniEjer.next();
	}
	 
	IDataSet dsConfColEjerActual = dataset.getDataSet("TConfColAlEjerActual");
	dsConfColEjerActual.first();
	while (!dsConfColEjerActual.EOF()) {
		ConfColAnexoA confColAnexoA = ConfColAnexoA.findByOid(dsConfColEjerActual.getInteger("oid_conf_anexo_a"),getSesion());
		confColAnexoA.setCodigo(dsConfColEjerActual.getString("codigo"));
		confColAnexoA.setDescripcion(dsConfColEjerActual.getString("descripcion"));
		confColAnexoA.setNro_col(dsConfColEjerActual.getInteger("nro_col"));
		confColAnexoA.setTipo_ejercicio(ConfColAnexoA.TE_EJER_ACTUAL);
		confColAnexoA.setActivo(dsConfColEjerActual.getBoolean("activo"));
		
		IDataSet dsMovEjerAct = dsConfColEjerActual.getDataSet("TConfMovEjerActual");
		dsMovEjerAct.first();
		while (!dsMovEjerAct.EOF()) {
			ConfColAnexoAMov confColAnexoAMov = ConfColAnexoAMov.findByOid(dsMovEjerAct.getInteger("oid"),getSesion());
			confColAnexoAMov.setConf_col_aneoxo(confColAnexoA);
			confColAnexoAMov.setTipo_mov(dsMovEjerAct.getString("tipo_mov"));
			confColAnexoAMov.setActivo(dsMovEjerAct.getBoolean("activo"));
			confColAnexoA.addConfColAnexoAMov(confColAnexoAMov);
			if (!confColAnexoAMov.isActivo().booleanValue())
				confColAnexoAMov.delete();			
			dsMovEjerAct.next();
		}
		addTransaccion(confColAnexoA);
		dsConfColEjerActual.next();
	}	
	
	    
  }
  
}
