package com.srn.erp.Ausentismo.bl.Factory;

import com.srn.erp.Ausentismo.bm.GrupoRRHHGeneralCodigo;
import com.srn.erp.Ausentismo.bm.GrupoRRHHGeneralDesc;
import com.srn.erp.Ausentismo.da.DBGrupoRRHHGeneralCodigo;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryGrupoRRHHGeneralCodigo extends FactoryObjetoLogico { 

  public FactoryGrupoRRHHGeneralCodigo() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    GrupoRRHHGeneralCodigo gruporrhhgeneralcodigo = (GrupoRRHHGeneralCodigo) objLog;
    gruporrhhgeneralcodigo.setOID(db.getInteger(DBGrupoRRHHGeneralCodigo.OID_GRUPO_GRAL_COD));
    gruporrhhgeneralcodigo.setGrupogeneraldesc(GrupoRRHHGeneralDesc.findByOid(db.getInteger(DBGrupoRRHHGeneralCodigo.OID_GRUPO_GRAL_DESC),getSesion()));
    gruporrhhgeneralcodigo.setTipotabla(db.getString(DBGrupoRRHHGeneralCodigo.TIPO_TABLA));
    gruporrhhgeneralcodigo.setCodigoexternoelemento(db.getString(DBGrupoRRHHGeneralCodigo.COD_EXT_ELEMENTO));
    gruporrhhgeneralcodigo.setActivo(db.getBoolean(DBGrupoRRHHGeneralCodigo.ACTIVO));

  }
}