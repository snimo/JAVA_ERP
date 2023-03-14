package com.srn.erp.bienUso.bl.Factory;

import com.srn.erp.bienUso.bm.Bien;
import com.srn.erp.bienUso.bm.SubBien;
import com.srn.erp.bienUso.da.DBSubBien;
import com.srn.erp.general.bm.Periodo;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactorySubBien extends FactoryObjetoLogico { 

  public FactorySubBien() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    SubBien subbien = (SubBien) objLog;
    subbien.setOID(db.getInteger(DBSubBien.OID_BIEN_ALTA));
    subbien.setBien_uso(Bien.findByOidProxy(db.getInteger(DBSubBien.OID_BIEN_USO),getSesion()));
    subbien.setNro_alta(db.getInteger(DBSubBien.NRO_ALTA));
    subbien.setDescripcion(db.getString(DBSubBien.DESCRIPCION));
    subbien.setSigue_bien_ppal(db.getBoolean(DBSubBien.SIGUE_BIEN_PPAL));
    subbien.setPeri_ini_amort(Periodo.findByOidProxy(db.getInteger(DBSubBien.OID_PERI_INI_AMORT),getSesion()));
    subbien.setActivo(db.getBoolean(DBSubBien.ACTIVO));

  }
}
