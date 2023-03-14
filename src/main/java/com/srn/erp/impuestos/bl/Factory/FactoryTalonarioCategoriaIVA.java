package com.srn.erp.impuestos.bl.Factory;

import com.srn.erp.general.bm.Talonario;
import com.srn.erp.impuestos.bm.CategoriaIVA;
import com.srn.erp.impuestos.bm.TalonarioCategoriaIVA;
import com.srn.erp.impuestos.da.DBTalonarioCategoriaIVA;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryTalonarioCategoriaIVA extends FactoryObjetoLogico {

  public FactoryTalonarioCategoriaIVA() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    TalonarioCategoriaIVA talonariocategoriaiva = (TalonarioCategoriaIVA) objLog;
    talonariocategoriaiva.setOID(db.getInteger(DBTalonarioCategoriaIVA.OID_TAL_CAT_IVA));
    talonariocategoriaiva.setCategoria_iva(CategoriaIVA.findByOidProxy(db.getInteger(DBTalonarioCategoriaIVA.OID_CAT_IVA),getSesion()));
    talonariocategoriaiva.setTalonario(Talonario.findByOidProxy(db.getInteger(DBTalonarioCategoriaIVA.OID_TALONARIO),getSesion()));
  }
}
