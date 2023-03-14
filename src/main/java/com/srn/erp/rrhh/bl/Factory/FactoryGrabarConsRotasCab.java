package com.srn.erp.rrhh.bl.Factory;

import com.srn.erp.cip.bm.Rota;
import com.srn.erp.rrhh.bm.FiltroLegCab;
import com.srn.erp.rrhh.bm.GrabarConsRotasCab;
import com.srn.erp.rrhh.da.DBGrabarConsRotasCab;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;

public class FactoryGrabarConsRotasCab extends FactoryObjetoLogico { 

  public FactoryGrabarConsRotasCab() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    GrabarConsRotasCab grabarconsrotascab = (GrabarConsRotasCab) objLog;
    grabarconsrotascab.setOID(db.getInteger(DBGrabarConsRotasCab.OID_GRAB_CONS_ROTA));
    grabarconsrotascab.setDescripcion(db.getString(DBGrabarConsRotasCab.DESCRIPCION));
    grabarconsrotascab.setFiltro(FiltroLegCab.findByOidProxy(db.getInteger(DBGrabarConsRotasCab.OID_FILTRO_CAB),getSesion()));
    grabarconsrotascab.setFec_desde(db.getDate(DBGrabarConsRotasCab.FEC_DESDE));
    grabarconsrotascab.setFec_hasta(db.getDate(DBGrabarConsRotasCab.FEC_HASTA));
    grabarconsrotascab.setRota(Rota.findByOidProxy(db.getInteger(DBGrabarConsRotasCab.OID_ROTA),getSesion()));
    grabarconsrotascab.setJuegos_sep_por_comas(db.getString(DBGrabarConsRotasCab.JUEGOS_SEP_POR_COMAS));
    grabarconsrotascab.setNo_most_si_franco(db.getBoolean(DBGrabarConsRotasCab.NO_MOST_SI_FRANCO));
    grabarconsrotascab.setUsuario(Usuario.findByOidProxy(db.getInteger(DBGrabarConsRotasCab.OID_USUARIO),getSesion()));
    grabarconsrotascab.setFecha_grab(db.getDate(DBGrabarConsRotasCab.FECHA_GRAB));
    grabarconsrotascab.setHora_grab(db.getString(DBGrabarConsRotasCab.HORA_GRAB));
    grabarconsrotascab.setActivo(db.getBoolean(DBGrabarConsRotasCab.ACTIVO));
    grabarconsrotascab.setDias(db.getInteger(DBGrabarConsRotasCab.DIAS));
    grabarconsrotascab.setAgrupador(db.getString(DBGrabarConsRotasCab.AGRUPADOR));
    grabarconsrotascab.setNroConsulta(db.getInteger(DBGrabarConsRotasCab.NRO_CONSULTA));

  }
}
