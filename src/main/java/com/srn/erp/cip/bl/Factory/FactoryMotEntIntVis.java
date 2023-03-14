package com.srn.erp.cip.bl.Factory;

import com.srn.erp.cip.bm.GrupoVisita;
import com.srn.erp.cip.bm.MotEntIntVis;
import com.srn.erp.cip.bm.MotivoEntIntermedias;
import com.srn.erp.cip.bm.Visita;
import com.srn.erp.cip.da.DBMotEntIntVis;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryMotEntIntVis extends FactoryObjetoLogico { 

  public FactoryMotEntIntVis() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    MotEntIntVis motentintvis = (MotEntIntVis) objLog;
    motentintvis.setOID(db.getInteger(DBMotEntIntVis.OID_MOT_ENT_INT));
    motentintvis.setVisita(Visita.findByOidProxy(db.getInteger(DBMotEntIntVis.OID_VISITA),getSesion()));
    motentintvis.setMotivo(MotivoEntIntermedias.findByOidProxy(db.getInteger(DBMotEntIntVis.OID_MOTIVO),getSesion()));
    motentintvis.setActivo(db.getBoolean(DBMotEntIntVis.ACTIVO));
    motentintvis.setGrupoVisita(GrupoVisita.findByOidProxy(db.getInteger(DBMotEntIntVis.OID_GRUPO_VISITA),getSesion()));
  }
}
