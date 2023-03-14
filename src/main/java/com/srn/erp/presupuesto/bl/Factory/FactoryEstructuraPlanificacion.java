package com.srn.erp.presupuesto.bl.Factory;

import com.srn.erp.presupuesto.bm.EstructuraPlanificacion;
import com.srn.erp.presupuesto.bm.GrupoEstructuraPlanif;
import com.srn.erp.presupuesto.da.DBEstructuraPlanificacion;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryEstructuraPlanificacion extends FactoryObjetoLogico { 

  public FactoryEstructuraPlanificacion() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    EstructuraPlanificacion estructuraplanificacion = (EstructuraPlanificacion) objLog;
    estructuraplanificacion.setOID(db.getInteger(DBEstructuraPlanificacion.OID_ESTRUC_PLANIF));
    estructuraplanificacion.setCodigo(db.getString(DBEstructuraPlanificacion.CODIGO));
    estructuraplanificacion.setDescripcion(db.getString(DBEstructuraPlanificacion.DESCRIPCION));
    estructuraplanificacion.setActivo(db.getBoolean(DBEstructuraPlanificacion.ACTIVO));
    estructuraplanificacion.setGrupoEstructuraPlanif(GrupoEstructuraPlanif.findByOidProxy(db.getInteger(DBEstructuraPlanificacion.OID_GRUPO_ESTRUCTURA_PLANIF),this.getSesion()));
  }
}
