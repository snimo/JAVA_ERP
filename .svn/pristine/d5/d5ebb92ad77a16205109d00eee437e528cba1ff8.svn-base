package com.srn.erp.tesoreria.op;

import com.srn.erp.general.bm.MotivoTC;
import com.srn.erp.tesoreria.bm.MotivoHabCobCli;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveMotHabCobCli extends Operation {

  public SaveMotHabCobCli() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet dataset = mapaDatos.getDataSet("TMotHabCobCli");
    procesarRegistros(dataset);
  }

  private void procesarRegistros(IDataSet dataset) throws BaseException {
    dataset.first();
      while (!dataset.EOF()) {
      	MotivoHabCobCli motivoHabCobCli =
      		MotivoHabCobCli.getMotivoHabCobCli(MotivoTC.findByOid(dataset.getInteger("oid_motivo_tc"),getSesion()),this.getSesion());
      	
      	if (motivoHabCobCli == null)
      		motivoHabCobCli = (MotivoHabCobCli)MotivoHabCobCli.getNew(MotivoHabCobCli.NICKNAME,this.getSesion()); 
      		
      	
      	motivoHabCobCli.setMotivo_tc(MotivoTC.findByOid(dataset.getInteger("oid_motivo_tc"),getSesion()));
      	motivoHabCobCli.setHabilitado(dataset.getBoolean("habilitado"));
        
        addTransaccion(motivoHabCobCli);
        dataset.next();
    }
  }

}
