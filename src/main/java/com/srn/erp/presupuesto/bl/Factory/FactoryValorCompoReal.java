package com.srn.erp.presupuesto.bl.Factory;

import com.srn.erp.presupuesto.bm.CompoPresupuestario;
import com.srn.erp.presupuesto.bm.ValorCompoPresu;
import com.srn.erp.presupuesto.bm.ValorCompoReal;
import com.srn.erp.presupuesto.da.DBValorCompoReal;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryValorCompoReal extends FactoryObjetoLogico { 

  public FactoryValorCompoReal() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ValorCompoReal valorcomporeal = (ValorCompoReal) objLog;
    valorcomporeal.setOID(db.getInteger(DBValorCompoReal.OID_VALOR_REAL));
    valorcomporeal.setCodigo(db.getString(DBValorCompoReal.CODIGO));
    valorcomporeal.setDescripcion(db.getString(DBValorCompoReal.DESCRIPCION));
    valorcomporeal.setCompo_presu(CompoPresupuestario.findByOidProxy(db.getInteger(DBValorCompoReal.OID_COMPO_PRESU),getSesion()));
    valorcomporeal.setActivo(db.getBoolean(DBValorCompoReal.ACTIVO));
    valorcomporeal.setValorCompoPresu(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorCompoReal.OID_VALOR_COMPO),this.getSesion()));
  }
}
