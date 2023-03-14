package com.srn.erp.Ausentismo.bl.Factory;

import com.srn.erp.Ausentismo.bm.GrupoRRHHDetalle;
import com.srn.erp.Ausentismo.da.DBGrupoRRHHDetalle;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryGrupoRRHHDetalle extends FactoryObjetoLogico { 

  public FactoryGrupoRRHHDetalle() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    GrupoRRHHDetalle grupodetalle = (GrupoRRHHDetalle) objLog;
    grupodetalle.setOID(db.getInteger(DBGrupoRRHHDetalle.OID_GRUPO_DET));
    grupodetalle.setOid_grupo(db.getInteger(DBGrupoRRHHDetalle.OID_GRUPO));
    grupodetalle.setCod_ext_1(db.getString(DBGrupoRRHHDetalle.COD_EXT_1));
    grupodetalle.setCod_ext_2(db.getString(DBGrupoRRHHDetalle.COD_EXT_2));
    grupodetalle.setDescripcion(db.getString(DBGrupoRRHHDetalle.DESCRIPCION));
    grupodetalle.setActivo(db.getBoolean(DBGrupoRRHHDetalle.ACTIVO));
  }
}
