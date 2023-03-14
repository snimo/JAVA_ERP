package com.srn.erp.excluidos.bl.Factory;

import com.srn.erp.excluidos.bm.EstadoExcluido;
import com.srn.erp.excluidos.bm.GerenteExcluido;
import com.srn.erp.excluidos.bm.IndividuoExcluido;
import com.srn.erp.excluidos.bm.LugarHechoExcluido;
import com.srn.erp.excluidos.bm.MotivoNovedadExcluido;
import com.srn.erp.excluidos.bm.NovedadExcluido;
import com.srn.erp.excluidos.bm.PredioExcluido;
import com.srn.erp.excluidos.bm.SeRetiraEnExc;
import com.srn.erp.excluidos.bm.SupervisorExcluido;
import com.srn.erp.excluidos.bm.TurnoExcluido;
import com.srn.erp.excluidos.da.DBNovedadExcluido;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryNovedadExcluido extends FactoryObjetoLogico { 

  public FactoryNovedadExcluido() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    NovedadExcluido novedadexcluido = (NovedadExcluido) objLog;
    novedadexcluido.setOID(db.getInteger(DBNovedadExcluido.OID_NOVEDAD));
    novedadexcluido.setFecha(db.getDate(DBNovedadExcluido.FECHA));
    novedadexcluido.setHora(db.getString(DBNovedadExcluido.HORA));
    novedadexcluido.setEstado(EstadoExcluido.findByOidProxy(db.getInteger(DBNovedadExcluido.OID_ESTADO),getSesion()));
    novedadexcluido.setLugar_del_hecho(LugarHechoExcluido.findByOidProxy(db.getInteger(DBNovedadExcluido.OID_LUGAR_HECHO),getSesion()));
    novedadexcluido.setSe_retira_en(SeRetiraEnExc.findByOidProxy(db.getInteger(DBNovedadExcluido.OID_SE_RETIRA),getSesion()));
    novedadexcluido.setHora_desde(db.getString(DBNovedadExcluido.HORA_DESDE));
    novedadexcluido.setMotivo(MotivoNovedadExcluido.findByOidProxy(db.getInteger(DBNovedadExcluido.OID_MOTIVO),getSesion()));
    novedadexcluido.setTurno(TurnoExcluido.findByOidProxy(db.getInteger(DBNovedadExcluido.OID_TURNO),getSesion()));
    novedadexcluido.setHora_hasta(db.getString(DBNovedadExcluido.HORA_HASTA));
    novedadexcluido.setSupervisor(SupervisorExcluido.findByOidProxy(db.getInteger(DBNovedadExcluido.OID_SUPERVISOR),getSesion()));
    novedadexcluido.setObservacion(db.getString(DBNovedadExcluido.OBSERVACION));
    novedadexcluido.setVig_desde(db.getDate(DBNovedadExcluido.VIG_DESDE));
    novedadexcluido.setActivo(db.getBoolean(DBNovedadExcluido.ACTIVO));
    novedadexcluido.setVig_hasta(db.getDate(DBNovedadExcluido.VIG_HASTA));
    novedadexcluido.setDejar_sin_efecto(db.getBoolean(DBNovedadExcluido.DEJAR_SIN_EFECTO));
    novedadexcluido.setIndividuoExcluido(IndividuoExcluido.findByOidProxy(db.getInteger(DBNovedadExcluido.OID_INDIVIDUO),getSesion()));
    novedadexcluido.setNroActa(db.getInteger(DBNovedadExcluido.NRO_ACTA));
    novedadexcluido.setNroRevocamiento(db.getInteger(DBNovedadExcluido.NRO_REVOCAMIENTO));
    novedadexcluido.setFecRevocamiento(db.getDate(DBNovedadExcluido.FEC_REV));
    novedadexcluido.setGerenteExcluido(GerenteExcluido.findByOidProxy(db.getInteger(DBNovedadExcluido.OID_GERENTE),getSesion()));
    novedadexcluido.setIrrevocable(db.getBoolean(DBNovedadExcluido.IRREVOCABLE));
    novedadexcluido.setPredio(PredioExcluido.findByOidProxy(db.getInteger(DBNovedadExcluido.OID_PREDIO),getSesion()));
    novedadexcluido.setRestriccionAcceso(db.getBoolean(DBNovedadExcluido.RESTRICCION_ACCESO));
  }
}
