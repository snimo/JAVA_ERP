package com.srn.erp.legales.bl.Factory;

import com.srn.erp.legales.bm.AudienciaSeclo;
import com.srn.erp.legales.bm.Seclo;
import com.srn.erp.legales.da.DBAudienciaSeclo;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryAudienciaSeclo extends FactoryObjetoLogico { 

  public FactoryAudienciaSeclo() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    AudienciaSeclo audienciaseclo = (AudienciaSeclo) objLog;
    audienciaseclo.setOID(db.getInteger(DBAudienciaSeclo.OID_AUDIENCIA));
    audienciaseclo.setSeclo(Seclo.findByOidProxy(db.getInteger(DBAudienciaSeclo.OID_SECLO),getSesion()));
    audienciaseclo.setFecha(db.getDate(DBAudienciaSeclo.FECHA));
    audienciaseclo.setHora(db.getString(DBAudienciaSeclo.HORA));
    audienciaseclo.setDireccion(db.getString(DBAudienciaSeclo.DIRECCION));
    audienciaseclo.setConciliador(db.getString(DBAudienciaSeclo.CONCILIADOR));
    audienciaseclo.setTelefonos(db.getString(DBAudienciaSeclo.TELEFONOS));
    audienciaseclo.setActivo(db.getBoolean(DBAudienciaSeclo.ACTIVO));

  }
}
