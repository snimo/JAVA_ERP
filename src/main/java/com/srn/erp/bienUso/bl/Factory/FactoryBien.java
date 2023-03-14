package com.srn.erp.bienUso.bl.Factory;

import com.srn.erp.bienUso.bm.Bien;
import com.srn.erp.bienUso.bm.GrupoBien;
import com.srn.erp.bienUso.da.DBBien;
import com.srn.erp.contabilidad.bm.CuentaImputable;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryBien extends FactoryObjetoLogico { 

  public FactoryBien() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    Bien bien = (Bien) objLog;
    bien.setOID(db.getInteger(DBBien.OID_BIEN_USO));
    bien.setCodigo(db.getString(DBBien.CODIGO));
    bien.setDescripcion(db.getString(DBBien.DESCRIPCION));
    bien.setAmortizable(db.getBoolean(DBBien.AMORTIZABLE));
    bien.setEstado(db.getString(DBBien.ESTADO));
    bien.setFec_alta(db.getDate(DBBien.FEC_ALTA));
    bien.setGrupo_bien_uso(GrupoBien.findByOidProxy(db.getInteger(DBBien.OID_GRUPO_BIEN_USO),getSesion()));
    bien.setAi_vo(CuentaImputable.findByOidProxy(db.getInteger(DBBien.OID_AI_VO),getSesion()));
    bien.setAi_aa(CuentaImputable.findByOidProxy(db.getInteger(DBBien.OID_AI_AA),getSesion()));
    bien.setAi_rvo(CuentaImputable.findByOidProxy(db.getInteger(DBBien.OID_AI_RVO),getSesion()));
    bien.setAi_raa(CuentaImputable.findByOidProxy(db.getInteger(DBBien.OID_AI_RAA),getSesion()));
    bien.setActivo(db.getBoolean(DBBien.ACTIVO));

  }
}
