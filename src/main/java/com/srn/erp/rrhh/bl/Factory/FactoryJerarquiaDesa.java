package com.srn.erp.rrhh.bl.Factory;

import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.rrhh.bm.AccCronoDesa;
import com.srn.erp.rrhh.bm.JerarquiaDesa;
import com.srn.erp.rrhh.bm.RankearCab;
import com.srn.erp.rrhh.da.DBJerarquiaDesa;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryJerarquiaDesa extends FactoryObjetoLogico {

	public FactoryJerarquiaDesa() {
	}

	public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
		JerarquiaDesa jerarquiadesa = (JerarquiaDesa) objLog;
		jerarquiadesa.setOID(db.getInteger(DBJerarquiaDesa.OID_JERAR_DESA));
		jerarquiadesa.setAccion(AccCronoDesa.findByOidProxy(db.getInteger(DBJerarquiaDesa.OID_ACCION_CRO), getSesion()));
		jerarquiadesa.setVal_clasif_empresa(ValorClasificadorEntidad.findByOidProxy(db.getInteger(DBJerarquiaDesa.OID_VAL_CLASIF_EMP), getSesion()));
		jerarquiadesa.setVal_clasif_sector(ValorClasificadorEntidad.findByOidProxy(db.getInteger(DBJerarquiaDesa.OID_VAL_CLASIF_SEC), getSesion()));
		jerarquiadesa.setVal_clasif_puesto(ValorClasificadorEntidad.findByOidProxy(db.getInteger(DBJerarquiaDesa.OID_VAL_CLASIF_PUE), getSesion()));
		jerarquiadesa.setActivo(db.getBoolean(DBJerarquiaDesa.ACTIVO));
		jerarquiadesa.setOrden(db.getInteger(DBJerarquiaDesa.ORDEN));
		jerarquiadesa.setCategPosible(ValorClasificadorEntidad.findByOidProxy(db.getInteger(DBJerarquiaDesa.CATEG_POSIBLE), getSesion()));
		jerarquiadesa.setCantAniosPuesto(db.getInteger(DBJerarquiaDesa.CANT_ANIOS_PUESTO));
		jerarquiadesa.setCantMesesPuesto(db.getInteger(DBJerarquiaDesa.CANT_MESES_PUESTO));
		jerarquiadesa.setRankearCab(RankearCab.findByOidProxy(db.getInteger(DBJerarquiaDesa.OID_RANKEAR), getSesion()));
		jerarquiadesa.setPuntosMinEval(db.getMoney(DBJerarquiaDesa.PTOS_MIN_EVAL));
		jerarquiadesa.setCantMinJuegosA(db.getInteger(DBJerarquiaDesa.CANT_MIN_JUEGOS_A));
		jerarquiadesa.setCantAniosHC(db.getInteger(DBJerarquiaDesa.CANT_ANIOS_HC));
		jerarquiadesa.setCantMesesHC(db.getInteger(DBJerarquiaDesa.CANT_MESES_HC));
		jerarquiadesa.setPuntosMinCalifGen(db.getMoney(DBJerarquiaDesa.PTOS_MIN_CALIF_GEN));
		jerarquiadesa.setUltMesesEvalPot(db.getInteger(DBJerarquiaDesa.ULT_MESES_EVAL_POT));
		jerarquiadesa.setPendEvalSiFaltaEvalDesemp(db.getBoolean(DBJerarquiaDesa.EVAL_PEND_SIN_EVAL));
		jerarquiadesa.setPendEvalSiFaltaJuegos(db.getBoolean(DBJerarquiaDesa.EVAL_PEND_SIN_JUE));
		jerarquiadesa.setEvalPendSinIRL(db.getBoolean(DBJerarquiaDesa.EVAL_PEND_SIN_IRL));
		jerarquiadesa.setUltMesesIRL(db.getInteger(DBJerarquiaDesa.ULT_MESES_IRL));
		jerarquiadesa.setEvalPendSinPot(db.getBoolean(DBJerarquiaDesa.EVAL_PEND_SIN_POT));
	}
}
