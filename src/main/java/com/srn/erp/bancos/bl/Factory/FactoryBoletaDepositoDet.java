package com.srn.erp.bancos.bl.Factory;

import com.srn.erp.bancos.bm.BoletaDeposito;
import com.srn.erp.bancos.bm.BoletaDepositoDet;
import com.srn.erp.bancos.da.DBBoletaDepositoDet;
import com.srn.erp.tesoreria.bm.Caja;
import com.srn.erp.tesoreria.bm.TipoValor;
import com.srn.erp.tesoreria.bm.Valor;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryBoletaDepositoDet extends FactoryObjetoLogico { 

  public FactoryBoletaDepositoDet() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    BoletaDepositoDet boletadepositodet = (BoletaDepositoDet) objLog;
    boletadepositodet.setOID(db.getInteger(DBBoletaDepositoDet.OID_BOL_DEP_DET));
    boletadepositodet.setBoleta_deposito(BoletaDeposito.findByOidProxy(db.getInteger(DBBoletaDepositoDet.OID_BOLETA_DEP),getSesion()));
    boletadepositodet.setTipo_valor(TipoValor.findByOidProxy(db.getInteger(DBBoletaDepositoDet.OID_TIPO_VALOR),getSesion()));
    boletadepositodet.setValor(Valor.findByOidProxy(db.getInteger(DBBoletaDepositoDet.OID_VALOR),getSesion()));
    boletadepositodet.setImporte(db.getMoney(DBBoletaDepositoDet.IMPORTE));
    boletadepositodet.setCaja(Caja.findByOidProxy(db.getInteger(DBBoletaDepositoDet.OID_CAJA),getSesion()));
    boletadepositodet.setImpoMonValor(db.getMoney(DBBoletaDepositoDet.IMPO_MON_VALOR));
    boletadepositodet.setCotizacion(db.getCotizacion(DBBoletaDepositoDet.COTIZACION));
  }
}
