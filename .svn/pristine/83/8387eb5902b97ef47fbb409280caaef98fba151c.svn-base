
package com.srn.erp.rrhh.bl.Factory;

import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.rrhh.bm.DetConsPlanDesa;
import com.srn.erp.rrhh.bm.EstadoDesarrollo;
import com.srn.erp.rrhh.bm.GradoLegajo;
import com.srn.erp.rrhh.da.DBDetConsPlanDesa;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryDetConsPlanDesa extends FactoryObjetoLogico {

	public FactoryDetConsPlanDesa() {
	}

	public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
		DetConsPlanDesa detConsPlanDesa = (DetConsPlanDesa) objLog;
		detConsPlanDesa.setOidCronograma(db.getInteger(DBDetConsPlanDesa.OID_CRONOGRAMA));
		detConsPlanDesa.setCronograma(db.getString(DBDetConsPlanDesa.DESC_CRONOGRAMA));
		detConsPlanDesa.setOidAccion(db.getInteger(DBDetConsPlanDesa.OID_ACCION));
		detConsPlanDesa.setAccion(db.getString(DBDetConsPlanDesa.DESC_ACCION));
		detConsPlanDesa.setOidLegajo(db.getInteger(DBDetConsPlanDesa.OID_LEGAJO));
		detConsPlanDesa.setLegajo(db.getString(DBDetConsPlanDesa.LEGAJO));
		detConsPlanDesa.setApellido(db.getString(DBDetConsPlanDesa.APELLIDO));
		detConsPlanDesa.setNombre(db.getString(DBDetConsPlanDesa.NOMBRE));
		detConsPlanDesa.setValClasifEmp(ValorClasificadorEntidad.findByOidProxy(db.getInteger(DBDetConsPlanDesa.OID_VAL_CLASIF_EMP), this.getSesion()));
		detConsPlanDesa.setValClasifSec(ValorClasificadorEntidad.findByOidProxy(db.getInteger(DBDetConsPlanDesa.OID_VAL_CLASIF_SEC), this.getSesion()));
		detConsPlanDesa.setValClasifPue(ValorClasificadorEntidad.findByOidProxy(db.getInteger(DBDetConsPlanDesa.OID_VAL_CLASIF_PUE), this.getSesion()));
		detConsPlanDesa.setFecIngreso(db.getDate(DBDetConsPlanDesa.FEC_INGRESO));
		detConsPlanDesa.setOrden(db.getInteger(DBDetConsPlanDesa.ORDEN));
		detConsPlanDesa.setGradoLegajo(GradoLegajo.findByOidProxy(db.getInteger(DBDetConsPlanDesa.OID_GRADO_LEGAJO), this.getSesion()));
		detConsPlanDesa.setEstadoDesarrollo(EstadoDesarrollo.findByOidProxy(db.getInteger(DBDetConsPlanDesa.OID_EST_DESA), this.getSesion()));
		detConsPlanDesa.setPosibleCategoria(ValorClasificadorEntidad.findByOidProxy(db.getInteger(DBDetConsPlanDesa.OID_CATEG_POSIBLE), this.getSesion()));
		detConsPlanDesa.setFecAntReconocida(db.getDate(DBDetConsPlanDesa.FEC_ANT_RECO));
		detConsPlanDesa.setCantMinJuegosA(db.getInteger(DBDetConsPlanDesa.CANT_MIN_JUEGOS_A));
		detConsPlanDesa.setCantAniosHC(db.getInteger(DBDetConsPlanDesa.CANT_ANIOS_HC));
		detConsPlanDesa.setCantMesesHC(db.getInteger(DBDetConsPlanDesa.CANT_MESES_HC));
		detConsPlanDesa.setUltMesesEvalPot(db.getInteger(DBDetConsPlanDesa.ULT_MESES_EVAL_POT));
		detConsPlanDesa.setPendEvalSiFaltaEvalDesemp(db.getBoolean(DBDetConsPlanDesa.EVAL_PEND_SIN_EVAL));
		detConsPlanDesa.setPendEvalSiFaltaJuego(db.getBoolean(DBDetConsPlanDesa.EVAL_PEND_SIN_JUE));
		detConsPlanDesa.setPendEvalSinIRL(db.getBoolean(DBDetConsPlanDesa.EVAL_PEND_SIN_IRL));
		detConsPlanDesa.setUltMesesIRL(db.getInteger(DBDetConsPlanDesa.ULT_MESES_IRL));
		detConsPlanDesa.setDesapSiIRLNeg(db.getBoolean(DBDetConsPlanDesa.DESA_SI_IRL_NEG));
		detConsPlanDesa.setPendEvalSinPot(db.getBoolean(DBDetConsPlanDesa.EVAL_PEND_SIN_POT));
	}
}
