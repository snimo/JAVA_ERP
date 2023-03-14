package com.srn.erp.stock.bl.Factory;

import com.srn.erp.stock.bm.AjuStkMovCab;
import com.srn.erp.stock.bm.ComproAjusteStk;
import com.srn.erp.stock.bm.Deposito;
import com.srn.erp.stock.bm.EstadoStock;
import com.srn.erp.stock.bm.UbicacionDeposito;
import com.srn.erp.stock.da.DBAjuStkMovCab;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryAjuStkMovCab extends FactoryObjetoLogico {

  public FactoryAjuStkMovCab() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    AjuStkMovCab ajustkmovcab = (AjuStkMovCab) objLog;
    ajustkmovcab.setOID(db.getInteger(DBAjuStkMovCab.OID_AJU_MOV_CAB));
    ajustkmovcab.setComproajustkcab(ComproAjusteStk.findByOidProxy(db.getInteger(DBAjuStkMovCab.OID_AJU_STK_CAB),getSesion()));
    ajustkmovcab.setDeposito(Deposito.findByOidProxy(db.getInteger(DBAjuStkMovCab.OID_DEPOSITO),getSesion()));
    ajustkmovcab.setTipo_movi(db.getString(DBAjuStkMovCab.TIPO_MOVI));
    ajustkmovcab.setEstado_stock(EstadoStock.findByOidProxy(db.getInteger(DBAjuStkMovCab.OID_ESTADO_STOCK),getSesion()));
    ajustkmovcab.setUbicacion_deposito(UbicacionDeposito.findByOidProxy(db.getInteger(DBAjuStkMovCab.OID_UBI_DEPO),getSesion()));
    ajustkmovcab.setAfecta_stk_fisico(db.getBoolean(DBAjuStkMovCab.AFECTA_STK_FISICO));
    ajustkmovcab.setActivo(db.getBoolean(DBAjuStkMovCab.ACTIVO));

  }
}
