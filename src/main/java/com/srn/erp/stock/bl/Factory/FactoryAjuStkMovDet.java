package com.srn.erp.stock.bl.Factory;

import com.srn.erp.stock.bm.AjuStkMovDet;
import com.srn.erp.stock.bm.ComproAjusteStkDet;
import com.srn.erp.stock.bm.Deposito;
import com.srn.erp.stock.bm.EstadoStock;
import com.srn.erp.stock.bm.UbicacionDeposito;
import com.srn.erp.stock.da.DBAjuStkMovDet;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryAjuStkMovDet extends FactoryObjetoLogico {

  public FactoryAjuStkMovDet() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    AjuStkMovDet ajustkmovdet = (AjuStkMovDet) objLog;
    ajustkmovdet.setOID(db.getInteger(DBAjuStkMovDet.OID_AJU_STK_MOV));
    ajustkmovdet.setDet_compro_aju_stk(ComproAjusteStkDet.findByOidProxy(db.getInteger(DBAjuStkMovDet.OID_AJU_STK_DET),getSesion()));
    ajustkmovdet.setDeposito(Deposito.findByOidProxy(db.getInteger(DBAjuStkMovDet.OID_DEPOSITO),getSesion()));
    ajustkmovdet.setTipo_movi(db.getString(DBAjuStkMovDet.TIPO_MOVI));
    ajustkmovdet.setEstado_stock(EstadoStock.findByOidProxy(db.getInteger(DBAjuStkMovDet.OID_ESTADO_STOCK),getSesion()));
    ajustkmovdet.setUbicacion_deposito(UbicacionDeposito.findByOidProxy(db.getInteger(DBAjuStkMovDet.OID_UBI_DEPO),getSesion()));
    ajustkmovdet.setAfecta_stk_fisico(db.getBoolean(DBAjuStkMovDet.AFECTA_STK_FISICO));
    ajustkmovdet.setActivo(db.getBoolean(DBAjuStkMovDet.ACTIVO));

  }
}
