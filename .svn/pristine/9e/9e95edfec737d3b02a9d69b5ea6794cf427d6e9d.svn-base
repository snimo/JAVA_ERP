package com.srn.erp.presupuesto.bl.Factory;

import com.srn.erp.presupuesto.bm.CompoPresupuestario;
import com.srn.erp.presupuesto.bm.GrupoComponente;
import com.srn.erp.presupuesto.da.DBCompoPresupuestario;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryCompoPresupuestario extends FactoryObjetoLogico { 

  public FactoryCompoPresupuestario() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    CompoPresupuestario compopresupuestario = (CompoPresupuestario) objLog;
    compopresupuestario.setOID(db.getInteger(DBCompoPresupuestario.OID_COMPO_PRESU));
    compopresupuestario.setCodigo(db.getString(DBCompoPresupuestario.CODIGO));
    compopresupuestario.setDescripcion(db.getString(DBCompoPresupuestario.DESCRIPCION));
    compopresupuestario.setTipo(db.getString(DBCompoPresupuestario.TIPO));
    compopresupuestario.setNro_interno_compo(db.getInteger(DBCompoPresupuestario.NRO_INTERNO_COMPO));
    compopresupuestario.setGrupo_compo(GrupoComponente.findByOidProxy(db.getInteger(DBCompoPresupuestario.OID_GRUPO_COMPO),getSesion()));
    compopresupuestario.setActivo(db.getBoolean(DBCompoPresupuestario.ACTIVO));

  }
}
