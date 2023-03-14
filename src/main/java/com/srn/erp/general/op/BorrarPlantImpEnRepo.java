package com.srn.erp.general.op;

import java.io.File;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;

public class BorrarPlantImpEnRepo extends Operation {

  public BorrarPlantImpEnRepo() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	  
	String carpeta = mapaDatos.getString("carpeta").trim();
	String nomArch = mapaDatos.getString("archivo").trim();
	
	File file = new File(carpeta + File.separatorChar + nomArch);
	if (file!=null) file.delete();
    
    
  }
}
