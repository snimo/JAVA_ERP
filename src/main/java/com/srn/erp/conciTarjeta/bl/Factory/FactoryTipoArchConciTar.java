package com.srn.erp.conciTarjeta.bl.Factory;

import framework.applicarionServer.bl.ObjetosAplicacion.*;
import framework.applicarionServer.bl.Persistencia.*;
import framework.request.bl.Utils.*;
import com.srn.erp.conciTarjeta.bm.TipoArchConciTar;
import com.srn.erp.conciTarjeta.da.DBTipoArchConciTar;

public class FactoryTipoArchConciTar extends FactoryObjetoLogico { 

  public FactoryTipoArchConciTar() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    TipoArchConciTar tipoarchconcitar = (TipoArchConciTar) objLog;
    tipoarchconcitar.setOID(db.getInteger(DBTipoArchConciTar.OID_TIPO_ARCHIVO));
    tipoarchconcitar.setCodigo(db.getString(DBTipoArchConciTar.CODIGO));
    tipoarchconcitar.setDescripcion(db.getString(DBTipoArchConciTar.DESCRIPCION));
    tipoarchconcitar.setComportamiento(db.getString(DBTipoArchConciTar.COMPORTAMIENTO));
    tipoarchconcitar.setAnt_ult_folder_emp(db.getString(DBTipoArchConciTar.ANT_ULT_FOLDER_EMP));
    tipoarchconcitar.setUlt_folder_tipo(db.getString(DBTipoArchConciTar.ULT_FOLDER_TIPO));
    tipoarchconcitar.setActivo(db.getBoolean(DBTipoArchConciTar.ACTIVO));
    tipoarchconcitar.setCodArchImpTarj(db.getString(DBTipoArchConciTar.COD_ARCH_IMP_TARJ));
  }
}
