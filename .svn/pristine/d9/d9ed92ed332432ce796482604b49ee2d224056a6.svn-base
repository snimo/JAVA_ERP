package com.srn.erp.bienUso.bl.Factory;

import com.srn.erp.bienUso.bm.ComposicionValorOrigen;
import com.srn.erp.bienUso.bm.SubBienVidaUtil;
import com.srn.erp.bienUso.da.DBComposicionValorOrigen;
import com.srn.erp.contabilidad.bm.ComproContaDet;
import com.srn.erp.general.bm.Moneda;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryComposicionValorOrigen extends FactoryObjetoLogico { 

  public FactoryComposicionValorOrigen() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ComposicionValorOrigen composicionvalororigen = (ComposicionValorOrigen) objLog;
    composicionvalororigen.setOID(db.getInteger(DBComposicionValorOrigen.OID_COMP_VO));
    composicionvalororigen.setCompro_conta_det(ComproContaDet.findByOidProxy(db.getInteger(DBComposicionValorOrigen.OID_DCO),getSesion()));
    composicionvalororigen.setSubbienVidaUtil(SubBienVidaUtil.findByOidProxy(db.getInteger(DBComposicionValorOrigen.OID_BIEN_VU),getSesion()));
    composicionvalororigen.setPorcentaje(db.getDouble(DBComposicionValorOrigen.PORC));
    composicionvalororigen.setImpo_valor(db.getDouble(DBComposicionValorOrigen.IMPO_VALOR));
    composicionvalororigen.setMoneda(Moneda.findByOidProxy(db.getInteger(DBComposicionValorOrigen.OID_MONEDA),getSesion()));
    composicionvalororigen.setFecImputac(db.getDate(DBComposicionValorOrigen.FEC_IMPUTAC));
  }
}
