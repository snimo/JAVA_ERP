package com.srn.erp.rrhh.bl.Factory;

import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.rrhh.bm.AccCronoDesa;
import com.srn.erp.rrhh.bm.CronogramaDesa;
import com.srn.erp.rrhh.bm.RankearCab;
import com.srn.erp.rrhh.da.DBAccCronoDesa;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryAccCronoDesa extends FactoryObjetoLogico {

	public FactoryAccCronoDesa() {
	}

	public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
		AccCronoDesa acccronodesa = (AccCronoDesa) objLog;
		acccronodesa.setOID(db.getInteger(DBAccCronoDesa.OID_ACCION_CRO));
		acccronodesa.setCronograma(CronogramaDesa.findByOidProxy(db.getInteger(DBAccCronoDesa.OID_CRONOGRAMA), getSesion()));
		acccronodesa.setOrden(db.getInteger(DBAccCronoDesa.ORDEN));
		acccronodesa.setAccion(db.getString(DBAccCronoDesa.ACCION));
		acccronodesa.setRevision(db.getString(DBAccCronoDesa.REVISION));
		acccronodesa.setObservaciones(db.getString(DBAccCronoDesa.OBSERVACIONES));
		acccronodesa.setActivo(db.getBoolean(DBAccCronoDesa.ACTIVO));
		acccronodesa.setCategoriaPosible(ValorClasificadorEntidad.findByOidProxy(db.getInteger(DBAccCronoDesa.OID_CATEG_POSIBLE), this.getSesion()));
		acccronodesa.setRankear(RankearCab.findByOidProxy(db.getInteger(DBAccCronoDesa.OID_RANKEAR), this.getSesion()));
		acccronodesa.setSector(db.getString(DBAccCronoDesa.SECTOR));
		acccronodesa.setParametros(db.getString(DBAccCronoDesa.PARAMETROS));
	}
}
