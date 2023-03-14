package com.srn.erp.presupuesto.bl.Factory;

import com.srn.erp.presupuesto.bm.TipoCiclo;
import com.srn.erp.presupuesto.bm.ValorEscenario;
import com.srn.erp.presupuesto.da.DBTipoCiclo;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryTipoCiclo extends FactoryObjetoLogico { 

  public FactoryTipoCiclo() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    TipoCiclo tipociclo = (TipoCiclo) objLog;
    tipociclo.setOID(db.getInteger(DBTipoCiclo.OID_TIPO_CICLO));
    tipociclo.setCodigo(db.getString(DBTipoCiclo.CODIGO));
    tipociclo.setDescripcion(db.getString(DBTipoCiclo.DESCRIPCION));
    tipociclo.setValor_escenario(ValorEscenario.findByOidProxy(db.getInteger(DBTipoCiclo.OID_VAL_ESCENARIO),getSesion()));
    tipociclo.setActivo(db.getBoolean(DBTipoCiclo.ACTIVO));

  }
}
