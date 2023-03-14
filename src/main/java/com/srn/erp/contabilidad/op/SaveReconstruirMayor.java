package com.srn.erp.contabilidad.op;

import com.srn.erp.contabilidad.bm.ComproConta;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class SaveReconstruirMayor extends Operation {

  public SaveReconstruirMayor() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	  
	  if (mapaDatos.containsKey("first_time"))
		  ComproConta.borrarMayor(this.getSesion());
	  
	  Integer oid = mapaDatos.getInteger("oid");
	  
	  Integer ultOidProcesado = ComproConta.recostruirMayores(this.getSesion(),oid);
	  
	  IDataSet ds = this.getDataSetUltOidProc();
	  enviar(ds, ultOidProcesado);
	  writeCliente(ds);
	  
  }
  
	private IDataSet getDataSetUltOidProc() {
		IDataSet dataset = new TDataSet();
		dataset.create("TUltOIDProcesado");
		dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
		return dataset;
	}
	
	private void enviar(
			IDataSet ds, 
			Integer oidProcesado) throws BaseException {

		ds.append();
		ds.fieldValue("oid", oidProcesado);
	}
	
  


}
