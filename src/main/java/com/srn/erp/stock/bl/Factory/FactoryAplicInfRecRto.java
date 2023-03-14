package com.srn.erp.stock.bl.Factory;

import com.srn.erp.compras.bm.InformeRecepcionDet;
import com.srn.erp.stock.bm.AplicInfRecRto;
import com.srn.erp.stock.bm.UnidadMedida;
import com.srn.erp.stock.da.DBAplicInfRecRto;
import com.srn.erp.ventas.bm.RemitoDet;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryAplicInfRecRto extends FactoryObjetoLogico { 

  public FactoryAplicInfRecRto() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    AplicInfRecRto aplicinfrecrto = (AplicInfRecRto) objLog;
    aplicinfrecrto.setOID(db.getInteger(DBAplicInfRecRto.OID_APLIC_INF_RTO));
    aplicinfrecrto.setInf_rec_det(InformeRecepcionDet.findByOidProxy(db.getInteger(DBAplicInfRecRto.OID_INF_REC_DET),getSesion()));
    aplicinfrecrto.setRemito_det(RemitoDet.findByOidProxy(db.getInteger(DBAplicInfRecRto.OID_REMITO_DET),getSesion()));
    aplicinfrecrto.setCantidad(db.getDouble(DBAplicInfRecRto.CANTIDAD));
    aplicinfrecrto.setUm(UnidadMedida.findByOidProxy(db.getInteger(DBAplicInfRecRto.OID_UM),getSesion()));
    aplicinfrecrto.setActivo(db.getBoolean(DBAplicInfRecRto.ACTIVO));

  }
}
