package com.srn.erp.compras.op;

import com.srn.erp.compras.bm.OrdenDeCompraDet;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveMarcarOCDetPendNoRecep extends Operation {

  public SaveMarcarOCDetPendNoRecep() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet dataset = mapaDatos.getDataSet("TDetOCSel");
    procesarRegistros(dataset);
  }

  private void procesarRegistros(IDataSet dataset) throws BaseException {

      dataset.first();
      while (!dataset.EOF()) {
        Integer oidOCDetEnt = dataset.getInteger("oid_oc_det_ent");
        OrdenDeCompraDet ocDet = OrdenDeCompraDet.findByOid(oidOCDetEnt, this.getSesion());
        
        if (ocDet.isPendienteRecepcion())
        	ocDet.setPendienteRecepcion(false);
        ocDet.save();
        dataset.next();
      }

   }
  


}
