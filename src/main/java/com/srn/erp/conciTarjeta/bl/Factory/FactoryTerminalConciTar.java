package com.srn.erp.conciTarjeta.bl.Factory;

import com.srn.erp.conciTarjeta.bm.TerminalConciTar;
import com.srn.erp.conciTarjeta.bm.UniNegConciTar;
import com.srn.erp.conciTarjeta.da.DBTerminalConciTar;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryTerminalConciTar extends FactoryObjetoLogico { 

  public FactoryTerminalConciTar() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    TerminalConciTar terminalconcitar = (TerminalConciTar) objLog;
    terminalconcitar.setOID(db.getInteger(DBTerminalConciTar.OID_TERMINAL));
    terminalconcitar.setNro_terminal(db.getString(DBTerminalConciTar.NRO_TERMINAL));
    terminalconcitar.setDescripcion(db.getString(DBTerminalConciTar.DESCRIPCION));
    terminalconcitar.setUni_neg(UniNegConciTar.findByOidProxy(db.getInteger(DBTerminalConciTar.OID_UNI_NEG),getSesion()));
    terminalconcitar.setFolder_in_cielot(db.getString(DBTerminalConciTar.FOLDER_IN_CIELOT));
    terminalconcitar.setActivo(db.getBoolean(DBTerminalConciTar.ACTIVO));
    terminalconcitar.setFolderLoteProcesado(db.getString(DBTerminalConciTar.FOLDER_LOTE_PROC));
    terminalconcitar.setFolderLoteError(db.getString(DBTerminalConciTar.FOLDER_LOTE_ERROR));
  }
}
