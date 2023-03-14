package com.srn.erp.reclutamiento.op;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class SaveRecluNewNroArchPostu extends Operation { 

  public SaveRecluNewNroArchPostu() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	  IDataSet ds = this.getDataSetNewNroArchivo();
	  int nro = this.getSesion().getNewOIDByKey("ARCH_POSTULANTE");
	  cargarRegistro(ds, nro);
	  writeCliente(ds);
  } 
  
  private IDataSet getDataSetNewNroArchivo() {
	    IDataSet dataset = new TDataSet();
	    dataset.create("TArchivoPostulante");
	    dataset.fieldDef(new Field("nro_archivo", Field.INTEGER, 0));
	    return dataset;
  }

	  private void cargarRegistro(IDataSet dataset,
	                         Integer nro) {
	    dataset.append();
	    dataset.fieldValue("nro_archivo",nro);
	  }  
  
}
