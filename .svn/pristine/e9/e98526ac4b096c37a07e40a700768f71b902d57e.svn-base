package com.srn.erp.cip.bl.Factory;

import com.srn.erp.cip.bm.TipoZona;
import com.srn.erp.cip.bm.ZonaCIP;
import com.srn.erp.cip.da.DBZonaCIP;
import com.srn.erp.mensajero.bm.GrupoMaquina;
import com.srn.erp.mensajero.bm.GrupoUsuMens;
import com.srn.erp.mensajero.bm.Ring;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryZonaCIP extends FactoryObjetoLogico { 

  public FactoryZonaCIP() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ZonaCIP zonacip = (ZonaCIP) objLog;
    zonacip.setOID(db.getInteger(DBZonaCIP.OID_ZONA));
    zonacip.setCodigo(db.getString(DBZonaCIP.CODIGO));
    zonacip.setActivo(db.getBoolean(DBZonaCIP.ACTIVO));
    zonacip.setColor(db.getString(DBZonaCIP.COLOR));
    zonacip.setDescripcion(db.getString(DBZonaCIP.DESCRIPCION));
    zonacip.setOid_tipo_zona(TipoZona.findByOidProxy(db.getInteger(DBZonaCIP.OID_TIPO_ZONA),getSesion()));
    zonacip.setCapacidad_max(db.getInteger(DBZonaCIP.CAPACIDAD_MAX));
    zonacip.setAlarma_de_cap(db.getInteger(DBZonaCIP.ALARMA_DE_CAP));
    zonacip.setBloquear_exc_cap(db.getBoolean(DBZonaCIP.BLOQUEAR_EXC_CAP));
    zonacip.setEstado_zona(db.getString(DBZonaCIP.ESTADO_ZONA));
    zonacip.setUbicacion(db.getString(DBZonaCIP.UBICACION));
    zonacip.setGrupo_usu_alar(GrupoUsuMens.findByOidProxy(db.getInteger(DBZonaCIP.OID_GRUPO_USU_ALAR),getSesion()));
    zonacip.setGrupo_maq_alar(GrupoMaquina.findByOidProxy(db.getInteger(DBZonaCIP.OID_GRUPO_MAQ_ALAR),getSesion()));
    zonacip.setMens_alar_cap_max(db.getString(DBZonaCIP.MENS_ALAR_CAP_MAX));
    zonacip.setRing_max_cap(Ring.findByOidProxy(db.getInteger(DBZonaCIP.OID_RING_MAX_CAP),getSesion()));
    zonacip.setEsExterna(db.getBoolean(DBZonaCIP.ES_EXTERNA));
    zonacip.setControlaAntiEnt(db.getBoolean(DBZonaCIP.CONTROLA_ANTI_ENT));
    zonacip.setControlaAntiSal(db.getBoolean(DBZonaCIP.CONTROLA_ANTI_SAL));
  }
}
