package com.srn.erp.rrhh.bl.Factory;

import com.srn.erp.rrhh.bm.FiltroLegCab;
import com.srn.erp.rrhh.da.DBFiltroLegCab;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryFiltroLegCab extends FactoryObjetoLogico { 

  public FactoryFiltroLegCab() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    FiltroLegCab filtrolegcab = (FiltroLegCab) objLog;
    filtrolegcab.setOID(db.getInteger(DBFiltroLegCab.OID_FILTRO_CAB));
    filtrolegcab.setDescripcion(db.getString(DBFiltroLegCab.DESCRIPCION));
    filtrolegcab.setAplic_cons_rotas(db.getBoolean(DBFiltroLegCab.APLIC_CONS_ROTAS));
    filtrolegcab.setActivo(db.getBoolean(DBFiltroLegCab.ACTIVO));
    filtrolegcab.setAplic_busq_leg(db.getBoolean(DBFiltroLegCab.APLIC_BUSQ_LEG));

  }
}
