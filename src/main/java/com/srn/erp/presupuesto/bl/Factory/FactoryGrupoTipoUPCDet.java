package com.srn.erp.presupuesto.bl.Factory;

import com.srn.erp.presupuesto.bm.GrupoTipoUPC;
import com.srn.erp.presupuesto.bm.GrupoTipoUPCDet;
import com.srn.erp.presupuesto.bm.TipoUPC;
import com.srn.erp.presupuesto.da.DBGrupoTipoUPCDet;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryGrupoTipoUPCDet extends FactoryObjetoLogico { 

  public FactoryGrupoTipoUPCDet() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    GrupoTipoUPCDet grupotipoupcdet = (GrupoTipoUPCDet) objLog;
    grupotipoupcdet.setOID(db.getInteger(DBGrupoTipoUPCDet.OID_GRUPO_DET));
    grupotipoupcdet.setGrupo_tipo_upc(GrupoTipoUPC.findByOidProxy(db.getInteger(DBGrupoTipoUPCDet.OID_GRUPO_TIPO_UPC),getSesion()));
    grupotipoupcdet.setTipo_upc(TipoUPC.findByOidProxy(db.getInteger(DBGrupoTipoUPCDet.OID_TIPO_UPC),getSesion()));
    grupotipoupcdet.setActivo(db.getBoolean(DBGrupoTipoUPCDet.ACTIVO));
  }
}
