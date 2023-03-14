package com.srn.erp.ventas.bl.Factory;

import com.srn.erp.tesoreria.bm.TipoValor;
import com.srn.erp.tesoreria.bm.Valor;
import com.srn.erp.ventas.bm.CobranzaVtaMostrador;
import com.srn.erp.ventas.bm.FacturaCab;
import com.srn.erp.ventas.da.DBCobranzaVtaMostrador;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryCobranzaVtaMostrador extends FactoryObjetoLogico { 

  public FactoryCobranzaVtaMostrador() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    CobranzaVtaMostrador cobranzavtamostrador = (CobranzaVtaMostrador) objLog;
    cobranzavtamostrador.setOID(db.getInteger(DBCobranzaVtaMostrador.OID_COB_VTA_MOS));
    cobranzavtamostrador.setTipo_valor(TipoValor.findByOidProxy(db.getInteger(DBCobranzaVtaMostrador.OID_TIPO_VALOR),getSesion()));
    cobranzavtamostrador.setValor(Valor.findByOidProxy(db.getInteger(DBCobranzaVtaMostrador.OID_VALOR),getSesion()));
    cobranzavtamostrador.setCotizacion(db.getValorCotizacion(DBCobranzaVtaMostrador.COTIZACION));
    cobranzavtamostrador.setImpo_mon_tv(db.getMoney(DBCobranzaVtaMostrador.IMPO_MON_TV));
    cobranzavtamostrador.setImpo_mon_fact(db.getMoney(DBCobranzaVtaMostrador.IMPO_MON_FACT));
    cobranzavtamostrador.setFacturaCab(FacturaCab.findByOidProxy(db.getInteger(DBCobranzaVtaMostrador.OID_CCO_FACT),getSesion()));

  }
}
