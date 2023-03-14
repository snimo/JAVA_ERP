package com.srn.erp.presupuesto.bl.Factory;

import com.srn.erp.presupuesto.bm.CompoPresupuestario;
import com.srn.erp.presupuesto.bm.DefinicionRepositorioReal;
import com.srn.erp.presupuesto.bm.Metrica;
import com.srn.erp.presupuesto.bm.RepositorioReal;
import com.srn.erp.presupuesto.bm.TipoPeriodo;
import com.srn.erp.presupuesto.da.DBDefinicionRepositorioReal;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryDefinicionRepositorioReal extends FactoryObjetoLogico { 

  public FactoryDefinicionRepositorioReal() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    DefinicionRepositorioReal definicionrepositorioreal = (DefinicionRepositorioReal) objLog;
    definicionrepositorioreal.setOID(db.getInteger(DBDefinicionRepositorioReal.OID_REPO_DET));
    definicionrepositorioreal.setDescripcion(db.getString(DBDefinicionRepositorioReal.DESCRIPCION));
    definicionrepositorioreal.setRepositorio_real(RepositorioReal.findByOidProxy(db.getInteger(DBDefinicionRepositorioReal.OID_REPO_REAL),getSesion()));
    definicionrepositorioreal.setCompo_presupuestario(CompoPresupuestario.findByOidProxy(db.getInteger(DBDefinicionRepositorioReal.OID_COMPO_PRESU),getSesion()));
    definicionrepositorioreal.setTipo_periodo(TipoPeriodo.findByOidProxy(db.getInteger(DBDefinicionRepositorioReal.OID_TIPO_PERI),getSesion()));
    definicionrepositorioreal.setMetrica(Metrica.findByOidProxy(db.getInteger(DBDefinicionRepositorioReal.OID_METRICA),getSesion()));
    definicionrepositorioreal.setOrden(db.getInteger(DBDefinicionRepositorioReal.ORDEN));
    definicionrepositorioreal.setTipo(db.getString(DBDefinicionRepositorioReal.TIPO));
    definicionrepositorioreal.setActivo(db.getBoolean(DBDefinicionRepositorioReal.ACTIVO));
    definicionrepositorioreal.setObligatorio(db.getBoolean(DBDefinicionRepositorioReal.OBLIGATORIO).booleanValue());
  }
}
