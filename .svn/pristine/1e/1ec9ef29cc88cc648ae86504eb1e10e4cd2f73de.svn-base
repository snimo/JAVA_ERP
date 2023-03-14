package com.srn.erp.conciTarjeta.op;

import com.srn.erp.conciTarjeta.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.IDataSet;

public class SaveTerminalConciTar extends Operation { 

  public SaveTerminalConciTar() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TTerminalConciTar"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        TerminalConciTar terminalconcitar = TerminalConciTar.findByOid(dataset.getInteger("oid_terminal"),getSesion());
        terminalconcitar.setOID(dataset.getInteger("oid_terminal"));
        terminalconcitar.setNro_terminal(dataset.getString("nro_terminal"));
        terminalconcitar.setDescripcion(dataset.getString("descripcion"));
        terminalconcitar.setUni_neg(UniNegConciTar.findByOidProxy(dataset.getInteger("oid_uni_neg"),this.getSesion()));
        terminalconcitar.setFolder_in_cielot(dataset.getString("Folder_IN_CieLot"));
        terminalconcitar.setActivo(dataset.getBoolean("activo"));
        terminalconcitar.setFolderLoteProcesado(dataset.getString("folder_arch_proc"));
        terminalconcitar.setFolderLoteError(dataset.getString("folder_lote_error"));
        addTransaccion(terminalconcitar);
        dataset.next();
    }
  }
  
}
