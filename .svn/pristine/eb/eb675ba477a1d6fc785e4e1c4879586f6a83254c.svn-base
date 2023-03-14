package com.srn.erp.rrhh.bl.Factory;

import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.rrhh.bm.AccCronoDesa;
import com.srn.erp.rrhh.bm.EstadoAccCroDesa;
import com.srn.erp.rrhh.da.DBEstadoAccCroDesa;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryEstadoAccCroDesa extends FactoryObjetoLogico {

	public FactoryEstadoAccCroDesa() {
	}

	public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
		EstadoAccCroDesa estadoacccrodesa = (EstadoAccCroDesa) objLog;
		estadoacccrodesa.setOID(db.getInteger(DBEstadoAccCroDesa.OID_ESTADO_ACC_CRO));
		estadoacccrodesa.setAccion(AccCronoDesa.findByOidProxy(db.getInteger(DBEstadoAccCroDesa.OID_ACCION_CRO), getSesion()));
		estadoacccrodesa.setValor_clasif_estado(ValorClasificadorEntidad.findByOidProxy(db.getInteger(DBEstadoAccCroDesa.OID_VAL_CLASIF_EST), getSesion()));
		estadoacccrodesa.setActivo(db.getBoolean(DBEstadoAccCroDesa.ACTIVO));

	}
}
