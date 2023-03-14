package com.srn.erp.tesoreria.bl.Factory;

import com.srn.erp.ctasACobrar.bm.TranClieVto;
import com.srn.erp.tesoreria.bm.FacturasRecibo;
import com.srn.erp.tesoreria.bm.Recibo;
import com.srn.erp.tesoreria.da.DBFacturasRecibo;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryFacturasRecibo extends FactoryObjetoLogico { 

  public FactoryFacturasRecibo() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    FacturasRecibo facturasrecibo = (FacturasRecibo) objLog;
    facturasrecibo.setOID(db.getInteger(DBFacturasRecibo.OID_FACT_EN_RECIBO));
    facturasrecibo.setRecibo(Recibo.findByOidProxy(db.getInteger(DBFacturasRecibo.OID_RECIBO),getSesion()));
    facturasrecibo.setImpo_mon_ori(db.getMoney(DBFacturasRecibo.IMPO_MON_ORI));
    facturasrecibo.setImpo_mon_loc(db.getMoney(DBFacturasRecibo.IMPO_MON_LOC));
    facturasrecibo.setSaldo_mon_ori(db.getMoney(DBFacturasRecibo.SALDO_MON_ORI));
    facturasrecibo.setImpo_dto_mon_ori(db.getMoney(DBFacturasRecibo.IMPO_DTO_MON_ORI));
    facturasrecibo.setSaldo_mon_loc(db.getMoney(DBFacturasRecibo.SALDO_MON_LOC));
    facturasrecibo.setImpo_dto_mon_loc(db.getMoney(DBFacturasRecibo.IMPO_DTO_MON_LOC));
    facturasrecibo.setImpo_cob_mon_ori(db.getMoney(DBFacturasRecibo.IMPO_COB_MON_ORI));
    facturasrecibo.setImpo_cob_mon_loc(db.getMoney(DBFacturasRecibo.IMPO_COB_MON_LOC));
    facturasrecibo.setCotizacion(db.getValorCotizacion(DBFacturasRecibo.COTIZACION));
    facturasrecibo.setImpoCobMonRec(db.getMoney(DBFacturasRecibo.IMPO_COB_MON_REC));
    facturasrecibo.setTranClieVto(TranClieVto.findByOidProxy(db.getInteger(DBFacturasRecibo.OID_TRAN_VTO),getSesion()));
  }
}
