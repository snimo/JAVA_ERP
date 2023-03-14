package com.srn.erp.general.op;

import java.util.Iterator;

import com.srn.erp.implementacion.bm.TablaGeneral;

import framework.applicarionServer.bl.Persistencia.CampoTablaPersistente;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerEstrucCamposSelect extends Operation {

  public TraerEstrucCamposSelect() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {

    String select = mapaDatos.getString("select");
    
    IDataSet ds = this.getDSEstrucTabla();
    
    Iterator iterCampos =
    	TablaGeneral.getMetaData(select, this.getSesion()).iterator();
    while (iterCampos.hasNext()) {
    	CampoTablaPersistente campoTablaSelect = (CampoTablaPersistente) iterCampos.next();
    	cargarRegCampoPers(ds,
    			new Integer(1),
    			campoTablaSelect.getDescTipo(),
    			campoTablaSelect.getCampoFisico(),
    			new Integer(campoTablaSelect.getSize()),
    			new Boolean(false));
    			
    }
    
    
    writeCliente(ds);
  }
  
  private IDataSet getDSEstrucTabla() throws BaseException {
	IDataSet dataset = new TDataSet(); 
	dataset.create("TEstrucTabla");
	    
	dataset.fieldDef(new Field("secu", Field.INTEGER, 0));
	dataset.fieldDef(new Field("tipo", Field.STRING, 50));
	dataset.fieldDef(new Field("nombre_fisico", Field.STRING, 50));
	dataset.fieldDef(new Field("longitud", Field.INTEGER, 0));
	dataset.fieldDef(new Field("primaryKey", Field.BOOLEAN, 0));
	
	return dataset;
  }
  
  private void cargarRegCampoPers(
		  IDataSet ds,
		  Integer secu,
		  String tipo,
		  String nombreFisico,
		  Integer longitud,
		  Boolean pk) throws BaseException {
	  
	  ds.append();
	  ds.fieldValue("secu", secu);
	  ds.fieldValue("tipo", tipo);
	  ds.fieldValue("nombre_fisico", nombreFisico);
	  ds.fieldValue("longitud", longitud);
	  ds.fieldValue("primaryKey", pk);
	  
	  
  }
  
  

  
}
