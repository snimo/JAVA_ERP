package com.srn.erp.cip.bl.Factory;

import com.srn.erp.cip.bm.Rota;
import com.srn.erp.cip.da.DBRota;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryRota extends FactoryObjetoLogico { 

  public FactoryRota() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    Rota rotas = (Rota) objLog;
    rotas.setOID(db.getInteger(DBRota.OID_ROTA));
    rotas.setCodigo(db.getString(DBRota.CODIGO));
    rotas.setDescripcion(db.getString(DBRota.DESCRIPCION));
    rotas.setHorario_desde(db.getString(DBRota.HORARIO_DESDE));
    rotas.setHorario_hasta(db.getString(DBRota.HORARIO_HASTA));
    rotas.setMin_ent_antes(db.getInteger(DBRota.MIN_ENT_ANTES));
    rotas.setActivo(db.getBoolean(DBRota.ACTIVO));
    rotas.setMin_ent_desp(db.getInteger(DBRota.MIN_ENT_DESP));
    rotas.setMin_sal_antes(db.getInteger(DBRota.MIN_SAL_ANTES));
    rotas.setTipo_acceso(db.getString(DBRota.TIPO_ACCESO));
    rotas.setTipo_egreso(db.getString(DBRota.TIPO_EGRESO));
    rotas.setMin_sal_despues(db.getInteger(DBRota.MIN_SAL_DESPUES));
    rotas.setLeyendaNoIngresa(db.getString(DBRota.LEY_NO_INGRESA));
    rotas.setLeyendaNoEgresa(db.getString(DBRota.LEY_NO_EGRESA));
  }
}
