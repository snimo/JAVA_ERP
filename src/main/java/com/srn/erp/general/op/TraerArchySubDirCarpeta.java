package com.srn.erp.general.op;

import java.io.File;

import com.srn.erp.general.bm.DirectorioBaseServidor;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerArchySubDirCarpeta extends Operation {

  private int oidRama = 1;	
	
  public TraerArchySubDirCarpeta() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {

    Integer oidDirBaseServ = mapaDatos.getInteger("oid_dir_base_serv");
    DirectorioBaseServidor dirBaseServidor =
    	DirectorioBaseServidor.findByOid(oidDirBaseServ, this.getSesion());
    File dir = new File(dirBaseServidor.getDescripcion());
    
    IDataSet ds = this.getDataSet();
    if (dir == null)
    	return ;
    
    if (!dir.exists())
    	return;
    	
    enviarCarpetas(ds,dir,oidRama);
    
    writeCliente(ds);
    

    
  }
  
  private void enviarCarpetas(IDataSet ds,File dir, int oidPadre) throws BaseException {
	  File[] files = dir.listFiles();
	  for (int i=0; i<files.length;++i) {
		  if (!files[i].isDirectory()) {
			  ++oidRama;
			  cargarRegistro(ds, files[i].getName(), files[i].getPath(), oidRama,oidPadre,files[i].getParent());
		  } else {
			  ++oidRama;
			  int oidPadreDir = oidRama; 
			  cargarRegistro(ds, files[i].getName(), files[i].getPath(), oidPadreDir,oidPadre,files[i].getPath());
			  enviarCarpetas(ds,files[i],oidPadreDir);
		  }
	  }
  }

  private IDataSet getDataSet() {
    IDataSet dataset = new TDataSet();
    dataset.create("TVistaContenidoCarpeta");
    dataset.fieldDef(new Field("nombre", Field.STRING, 100));
    dataset.fieldDef(new Field("full_path", Field.STRING, 255));
    dataset.fieldDef(new Field("id", Field.INTEGER, 0));
    dataset.fieldDef(new Field("id_padre", Field.INTEGER, 0));
    dataset.fieldDef(new Field("path", Field.STRING, 500));
    return dataset;
  }

  private void cargarRegistro(IDataSet dataset,
                              String nombre,
                              String fullPath,
                              Integer id,
                              Integer idPadre,
                              String path) throws BaseException {
    dataset.append();
    dataset.fieldValue("nombre", nombre);
    dataset.fieldValue("full_path", fullPath);
    dataset.fieldValue("id", id);
    dataset.fieldValue("id_padre", idPadre);
    dataset.fieldValue("path", path);
    
  }

}
