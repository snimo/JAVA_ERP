package com.srn.erp.tesoreria.bl.Factory;

import com.srn.erp.general.bm.Moneda;
import com.srn.erp.general.bm.TipoComprobante;
import com.srn.erp.tesoreria.bm.Caja;
import com.srn.erp.tesoreria.bm.MovCajaDiaTipoCompro;
import com.srn.erp.tesoreria.bm.TipoValor;
import com.srn.erp.tesoreria.da.DBMovCajaDiaTipoCompro;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryMovCajaDiaTipoCompro extends FactoryObjetoLogico { 

  public FactoryMovCajaDiaTipoCompro() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    MovCajaDiaTipoCompro movcajadiatipocompro = (MovCajaDiaTipoCompro) objLog;
    movcajadiatipocompro.setTipo_valor(TipoValor.findByOidProxy(db.getInteger(DBMovCajaDiaTipoCompro.OID_TIPO_VALOR),getSesion()));
    movcajadiatipocompro.setMoneda(Moneda.findByOidProxy(db.getInteger(DBMovCajaDiaTipoCompro.OID_MONEDA),getSesion()));
    movcajadiatipocompro.setTipo_comprobante(TipoComprobante.findByOidProxy(db.getInteger(DBMovCajaDiaTipoCompro.OID_TC),getSesion()));
    movcajadiatipocompro.setImporte(db.getMoney(DBMovCajaDiaTipoCompro.IMPORTE));
    movcajadiatipocompro.setCaja(Caja.findByOidProxy(db.getInteger(DBMovCajaDiaTipoCompro.CAJA),getSesion()));

  }
}
