package com.srn.erp.ventas.bl.Factory;

import com.srn.erp.ventas.bm.ObsCodifPedidoCab;
import com.srn.erp.ventas.bm.ObsCodifVtas;
import com.srn.erp.ventas.bm.PedidoCab;
import com.srn.erp.ventas.da.DBObsCodifPedidoCab;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryObsCodifPedidoCab extends FactoryObjetoLogico { 

  public FactoryObsCodifPedidoCab() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ObsCodifPedidoCab obscodifpedidocab = (ObsCodifPedidoCab) objLog;
    obscodifpedidocab.setOID(db.getInteger(DBObsCodifPedidoCab.OID_OBS_CODIF));
    obscodifpedidocab.setPedido(PedidoCab.findByOidProxy(db.getInteger(DBObsCodifPedidoCab.OID_CCO_PED),getSesion()));
    obscodifpedidocab.setOrden(db.getInteger(DBObsCodifPedidoCab.ORDEN));
    obscodifpedidocab.setObs_codificada(ObsCodifVtas.findByOidProxy(db.getInteger(DBObsCodifPedidoCab.OID_OBS_COD),getSesion()));
    obscodifpedidocab.setActivo(db.getBoolean(DBObsCodifPedidoCab.ACTIVO));

  }
}
