package com.srn.erp.presupuesto.bl.Factory;

import com.srn.erp.presupuesto.bm.GrupoTipoUPC;
import com.srn.erp.presupuesto.bm.GrupoUPCTipoCiclo;
import com.srn.erp.presupuesto.bm.TipoCiclo;
import com.srn.erp.presupuesto.da.DBGrupoUPCTipoCiclo;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryGrupoUPCTipoCiclo extends FactoryObjetoLogico { 

  public FactoryGrupoUPCTipoCiclo() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    GrupoUPCTipoCiclo grupoupctipociclo = (GrupoUPCTipoCiclo) objLog;
    grupoupctipociclo.setOID(db.getInteger(DBGrupoUPCTipoCiclo.OID_GRUPO_UPC_TIPO));
    grupoupctipociclo.setTipo_ciclo(TipoCiclo.findByOidProxy(db.getInteger(DBGrupoUPCTipoCiclo.OID_TIPO_CICLO),getSesion()));
    grupoupctipociclo.setGrupo_tipo_upc(GrupoTipoUPC.findByOidProxy(db.getInteger(DBGrupoUPCTipoCiclo.OID_GRUPO_TIPO_UPC),getSesion()));
    grupoupctipociclo.setActivo(db.getBoolean(DBGrupoUPCTipoCiclo.ACTIVO));

  }
}
