package com.srn.erp.stock.bl.Factory;

import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.stock.bm.ConfGenMasProd;
import com.srn.erp.stock.da.DBConfGenMasProd;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryConfGenMasProd extends FactoryObjetoLogico { 

  public FactoryConfGenMasProd() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ConfGenMasProd confgenmasprod = (ConfGenMasProd) objLog;
    confgenmasprod.setOID(db.getInteger(DBConfGenMasProd.OID_GEN_MASIVA));
    confgenmasprod.setClasificador(ClasificadorEntidad.findByOidProxy(db.getInteger(DBConfGenMasProd.OID_CLASIFICADOR),getSesion()));
    confgenmasprod.setIncluir_codigo(db.getBoolean(DBConfGenMasProd.INCLUIR_CODIGO));
    confgenmasprod.setOrden_codigo(db.getInteger(DBConfGenMasProd.ORDEN_CODIGO));
    confgenmasprod.setPre_codigo(db.getString(DBConfGenMasProd.PRE_CODIGO));
    confgenmasprod.setSuf_codigo(db.getString(DBConfGenMasProd.SUF_CODIGO));
    confgenmasprod.setIncluir_desc(db.getBoolean(DBConfGenMasProd.INCLUIR_DESC));
    confgenmasprod.setOrden_desc(db.getInteger(DBConfGenMasProd.ORDEN_DESC));
    confgenmasprod.setPre_desc(db.getString(DBConfGenMasProd.PRE_DESC));
    confgenmasprod.setSuf_desc(db.getString(DBConfGenMasProd.SUF_DESC));
    confgenmasprod.setIncluir_sino(db.getBoolean(DBConfGenMasProd.INCLUIR_SINO));
    confgenmasprod.setOrden_sino(db.getInteger(DBConfGenMasProd.ORDEN_SINO));
    confgenmasprod.setPre_sino(db.getString(DBConfGenMasProd.PRE_SINO));
    confgenmasprod.setSuf_sino(db.getString(DBConfGenMasProd.SUF_SINO));
    confgenmasprod.setIncluir_barra(db.getBoolean(DBConfGenMasProd.INCLUIR_BARRA));
    confgenmasprod.setOrden_barra(db.getInteger(DBConfGenMasProd.ORDEN_BARRA));
    confgenmasprod.setPre_barra(db.getString(DBConfGenMasProd.PRE_BARRA));
    confgenmasprod.setSuf_barra(db.getString(DBConfGenMasProd.SUF_BARRA));

  }
}
