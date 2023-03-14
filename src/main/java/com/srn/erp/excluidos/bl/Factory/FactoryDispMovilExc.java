package com.srn.erp.excluidos.bl.Factory;

import com.srn.erp.excluidos.bm.DispMovilExc;
import com.srn.erp.excluidos.bm.GrupoImportacionExcluido;
import com.srn.erp.excluidos.da.DBDispMovilExc;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryDispMovilExc extends FactoryObjetoLogico { 

  public FactoryDispMovilExc() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    DispMovilExc dispmovilexc = (DispMovilExc) objLog;
    dispmovilexc.setOID(db.getInteger(DBDispMovilExc.OID_DISP_MOVIL));
    dispmovilexc.setCodigo(db.getString(DBDispMovilExc.CODIGO));
    dispmovilexc.setDescripcion(db.getString(DBDispMovilExc.DESCRIPCION));
    dispmovilexc.setGrupo_importacion(GrupoImportacionExcluido.findByOidProxy(db.getInteger(DBDispMovilExc.OID_GRUPO_IMP_EXC),getSesion()));
    dispmovilexc.setFec_hor_ult_sinc_ol(db.getString(DBDispMovilExc.FEC_HOR_ULT_SINC_OL));
    dispmovilexc.setForzar_sinc_all(db.getBoolean(DBDispMovilExc.FORZAR_SINC_ALL));
    dispmovilexc.setUlt_nro_lote_inf(db.getInteger(DBDispMovilExc.ULT_NRO_LOTE_INF));
    dispmovilexc.setActivo(db.getBoolean(DBDispMovilExc.ACTIVO));
    dispmovilexc.setForzarSiempresSinc(db.getBoolean(DBDispMovilExc.FORZAR_SIEMPRE_SINC));
    

  }
}
