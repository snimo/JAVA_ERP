package com.srn.erp.cip.op;

import java.util.Iterator;

import com.srn.erp.sueldos.bm.Legajo;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerLegajosCIP extends Operation { 

	
  private String nombreTabla = null;
  
  public TraerLegajosCIP() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	  
	if (mapaDatos.containsKey("nombre_table"))
		nombreTabla = mapaDatos.getString("nombre_table"); 
	  
    IDataSet dsLegajos = this.getDataSetLegajosCIP();
    Iterator iterLegajosCIP = 
    	Legajo.getAllLegajos(this.getSesion()).iterator();
    while (iterLegajosCIP.hasNext()) {
    	Legajo legajo = (Legajo) iterLegajosCIP.next();
    	cargarRegistroLegajoCIP(dsLegajos, legajo);
    }
    writeCliente(dsLegajos);
  }

  private IDataSet getDataSetLegajosCIP() { 
    IDataSet dataset = new TDataSet();
    
    if (nombreTabla!=null)
    	dataset.create(nombreTabla);
    else
    	dataset.create("TLegajos");
    dataset.fieldDef(new Field("oid_legajo", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("legajo", Field.STRING, 50));
    dataset.fieldDef(new Field("ape_y_nom", Field.STRING, 100));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistroLegajoCIP
  					(IDataSet dataset, 
  					 Legajo aLegajo) throws BaseException {
    dataset.append(); 
    dataset.fieldValue("oid_legajo", aLegajo.getOIDInteger());
    dataset.fieldValue("legajo", aLegajo.getCodigo());
    dataset.fieldValue("ape_y_nom", aLegajo.getApellidoyNombre().trim());
    dataset.fieldValue("activo", aLegajo.isActivo());
  }
  
}
