package com.srn.erp.presupuesto.bl.Factory;

import com.srn.erp.presupuesto.bm.EstructuraPlanificacion;
import com.srn.erp.presupuesto.bm.NodoEstructuraPlanificacion;
import com.srn.erp.presupuesto.da.DBNodoEstructuraPlanificacion;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryNodoEstructuraPlanificacion extends FactoryObjetoLogico { 

  public FactoryNodoEstructuraPlanificacion() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    NodoEstructuraPlanificacion nodoestructuraplanificacion = (NodoEstructuraPlanificacion) objLog;
    nodoestructuraplanificacion.setOID(db.getInteger(DBNodoEstructuraPlanificacion.OID_NODO_ESTRUC));
    nodoestructuraplanificacion.setEstructura_planificacion(EstructuraPlanificacion.findByOidProxy(db.getInteger(DBNodoEstructuraPlanificacion.OID_ESTRUC_PLANIF),getSesion()));
    nodoestructuraplanificacion.setNro_relacion(db.getInteger(DBNodoEstructuraPlanificacion.NRO_REL));
    nodoestructuraplanificacion.setNro_relacion_padre(db.getInteger(DBNodoEstructuraPlanificacion.NRO_REL_PADRE));
    nodoestructuraplanificacion.setNombre(db.getString(DBNodoEstructuraPlanificacion.NOMBRE));
    nodoestructuraplanificacion.setAncho(db.getInteger(DBNodoEstructuraPlanificacion.ANCHO));
    nodoestructuraplanificacion.setAlto(db.getInteger(DBNodoEstructuraPlanificacion.ALTO));
    nodoestructuraplanificacion.setColor(db.getInteger(DBNodoEstructuraPlanificacion.COLOR));
    nodoestructuraplanificacion.setOrden(db.getInteger(DBNodoEstructuraPlanificacion.ORDEN));
    nodoestructuraplanificacion.setAlineacion(db.getString(DBNodoEstructuraPlanificacion.ALINEACION));
    nodoestructuraplanificacion.setActivo(db.getBoolean(DBNodoEstructuraPlanificacion.ACTIVO));

  }
}
