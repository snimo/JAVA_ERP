package com.srn.erp.general.op;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.implementacion.bm.TablaGeneral;

import framework.applicarionServer.bl.Persistencia.CampoTablaPersistente;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class EjecutarConsGral extends Operation {

  public EjecutarConsGral() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {

    String select = mapaDatos.getString("select");
    
    List listCampos = TablaGeneral.getMetaData(select, this.getSesion());
    IDataSet ds = this.getDSEstrucTabla(listCampos);
    
    PreparedStatement ps = 
    	TablaGeneral.getPreparedStatementTablaGral(select, this.getSesion());
    try {
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			cargarReg(ds,rs,listCampos);
		}
		rs.close();
		
		ps.close();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    
    			
    
    
    writeCliente(ds);
  }
  
  private IDataSet getDSEstrucTabla(List campos) throws BaseException {
	IDataSet dataset = new TDataSet(); 
	dataset.create("TConsulta");
	    
	Iterator iterCampos = campos.iterator();
	while (iterCampos.hasNext()) {
		CampoTablaPersistente campoTabla = (CampoTablaPersistente) iterCampos.next();
		dataset.fieldDef(new Field(campoTabla.getCampoFisico(), campoTabla.getDescTipo(), 0));
	}
	
	return dataset;
  }
  
  private void cargarReg(
		  IDataSet ds,
		  ResultSet rs,
		  List campos) throws SQLException , BaseException {
	  
   	    ds.append();
	  
		Iterator iterCampos = campos.iterator();
		while (iterCampos.hasNext()) {
			CampoTablaPersistente campoTabla = (CampoTablaPersistente) iterCampos.next();
			ds.fieldValue(campoTabla.getCampoFisico(), rs.getString(campoTabla.getCampoFisico()));
		}
	  
  }
  
  

  
}
