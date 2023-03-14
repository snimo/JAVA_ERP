package com.srn.erp.rrhh.bl.Factory;

import com.srn.erp.rrhh.bm.AparatoRRHH;
import com.srn.erp.rrhh.bm.EnfermedadRRHH;
import com.srn.erp.rrhh.bm.FamiliarRRHH;
import com.srn.erp.rrhh.bm.MedicoRRHH;
import com.srn.erp.rrhh.bm.MotVisFalRRHH;
import com.srn.erp.rrhh.bm.PrestMedidoRRHH;
import com.srn.erp.rrhh.bm.ServicioMedicoRRHH;
import com.srn.erp.rrhh.da.DBServicioMedicoRRHH;
import com.srn.erp.sueldos.bm.Legajo;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryServicioMedicoRRHH extends FactoryObjetoLogico {

	public FactoryServicioMedicoRRHH() {
	}

	public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
		ServicioMedicoRRHH serviciomedicorrhh = (ServicioMedicoRRHH) objLog;
		serviciomedicorrhh.setOID(db.getInteger(DBServicioMedicoRRHH.OID_SERV_MEDICO));
		serviciomedicorrhh.setTipo_serv_med(db.getString(DBServicioMedicoRRHH.TIPO_SERV_MED));
		serviciomedicorrhh.setNro_nov_sist_ext(db.getInteger(DBServicioMedicoRRHH.NRO_NOV_SIST_EXT));
		serviciomedicorrhh.setFec_inicio(db.getDate(DBServicioMedicoRRHH.FEC_INICIO));
		serviciomedicorrhh.setFec_final(db.getDate(DBServicioMedicoRRHH.FEC_FINAL));
		serviciomedicorrhh.setDias(db.getInteger(DBServicioMedicoRRHH.DIAS));
		serviciomedicorrhh.setMotivo_visita_fallo(MotVisFalRRHH.findByOidProxy(db.getInteger(DBServicioMedicoRRHH.OID_MOT_VIS_FALL), getSesion()));
		serviciomedicorrhh.setAparato(AparatoRRHH.findByOidProxy(db.getInteger(DBServicioMedicoRRHH.OID_APARATO), getSesion()));
		serviciomedicorrhh.setEnfermedad(EnfermedadRRHH.findByOidProxy(db.getInteger(DBServicioMedicoRRHH.OID_ENFERMEDAD), getSesion()));
		serviciomedicorrhh.setPrestador_medico(PrestMedidoRRHH.findByOidProxy(db.getInteger(DBServicioMedicoRRHH.OID_PREST_MED), getSesion()));
		serviciomedicorrhh.setSintoma(db.getString(DBServicioMedicoRRHH.SINTOMA));
		serviciomedicorrhh.setObservacion(db.getString(DBServicioMedicoRRHH.OBSERVACION));
		serviciomedicorrhh.setJustifica(db.getBoolean(DBServicioMedicoRRHH.JUSTIFICA));
		serviciomedicorrhh.setActivo(db.getBoolean(DBServicioMedicoRRHH.ACTIVO));
		serviciomedicorrhh.setLegajo(Legajo.findByOidProxy(db.getInteger(DBServicioMedicoRRHH.OID_LEGAJO), getSesion()));
		serviciomedicorrhh.setFecAteMed(db.getDate(DBServicioMedicoRRHH.FEC_ATE_MED));
		serviciomedicorrhh.setMedico(MedicoRRHH.findByOidProxy(db.getInteger(DBServicioMedicoRRHH.OID_MEDICO), getSesion()));
		serviciomedicorrhh.setFamiliar(FamiliarRRHH.findByOidProxy(db.getInteger(DBServicioMedicoRRHH.OID_FAMILIAR), getSesion()));
		serviciomedicorrhh.setFecAccidente(db.getDate(DBServicioMedicoRRHH.FEC_ACCIDENTE));
		serviciomedicorrhh.setDescAccidente(db.getString(DBServicioMedicoRRHH.DESC_ACCIDENTE));
		serviciomedicorrhh.setFecControl(db.getDate(DBServicioMedicoRRHH.FEC_CONTROL));
	}
}
