package com.srn.erp.cip.bl.Factory;

import com.srn.erp.cip.bm.CIPFichadaOficina;
import com.srn.erp.cip.bm.MotivoFichadaCIP;
import com.srn.erp.cip.bm.PuntoFichadaCIP;
import com.srn.erp.cip.da.DBCIPFichadaOficina;
import com.srn.erp.sueldos.bm.Legajo;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryCIPFichadaOficina extends FactoryObjetoLogico { 

  public FactoryCIPFichadaOficina() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    CIPFichadaOficina cipfichadaoficina = (CIPFichadaOficina) objLog;
    cipfichadaoficina.setOID(db.getInteger(DBCIPFichadaOficina.OID_IN_OUT_OFIC));
    cipfichadaoficina.setLegajo(Legajo.findByOidProxy(db.getInteger(DBCIPFichadaOficina.OID_LEGAJO),getSesion()));
    cipfichadaoficina.setFec_hor(db.getDateTime(DBCIPFichadaOficina.FEC_HOR));
    cipfichadaoficina.setSentido(db.getString(DBCIPFichadaOficina.SENTIDO));
    cipfichadaoficina.setOid_pto_fichada(PuntoFichadaCIP.findByOidProxy(db.getInteger(DBCIPFichadaOficina.PUNTO_FICHADA),getSesion()));
    cipfichadaoficina.setMotivo_fichada(MotivoFichadaCIP.findByOidProxy(db.getInteger(DBCIPFichadaOficina.OID_MOTIVO_FICHADA),getSesion()));
    cipfichadaoficina.setObservacion(db.getString(DBCIPFichadaOficina.OBSERVACION));
    cipfichadaoficina.setActivo(db.getBoolean(DBCIPFichadaOficina.ACTIVO));

  }
}
