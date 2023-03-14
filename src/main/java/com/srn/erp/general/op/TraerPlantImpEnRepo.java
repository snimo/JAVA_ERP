package com.srn.erp.general.op;

import java.io.File;
import java.util.Date;

import com.srn.erp.general.bm.Empresa;
import com.srn.erp.general.bm.Pais;
import com.srn.erp.general.bm.Provincia;
import com.srn.erp.impuestos.bm.CategoriaIB;
import com.srn.erp.impuestos.bm.CategoriaIVA;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerPlantImpEnRepo extends Operation {

  public TraerPlantImpEnRepo() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	  
	String carpeta = mapaDatos.getString("carpeta");
	
    File dir = new File(carpeta.trim());
    String[] children = dir.list();
    
    IDataSet ds = this.getDataSet();
    if (children!=null) {
    	 for (int i=0; i<children.length; i++) {
             // Get filename of file or directory
             String filename = children[i];
             if (!((new File(carpeta + File.separatorChar + filename)).isDirectory()))
            	 cargarRegistro(ds, filename);
        }    	
    	
    }
    
    writeCliente(ds);
    
  }
    
	
  private IDataSet getDataSet() {
    IDataSet dataset = new TDataSet();
    dataset.create("TArchivosRepositorio");
    dataset.fieldDef(new Field("archivo", Field.STRING, 255));
    return dataset;
  }

  private void cargarRegistro(IDataSet dataset,
                         	  String archivo) throws BaseException {
    dataset.append();
    dataset.fieldValue("archivo", archivo);
  }
}
