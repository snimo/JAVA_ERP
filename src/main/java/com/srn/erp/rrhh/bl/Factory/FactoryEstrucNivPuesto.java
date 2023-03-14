package com.srn.erp.rrhh.bl.Factory;

import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.rrhh.bm.EstrucNivPuesto;
import com.srn.erp.rrhh.bm.EstrucNivSector;
import com.srn.erp.rrhh.da.DBEstrucNivPuesto;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryEstrucNivPuesto extends FactoryObjetoLogico {

	public FactoryEstrucNivPuesto() {
	}

	public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
		EstrucNivPuesto estrucnivpuesto = (EstrucNivPuesto) objLog;
		estrucnivpuesto.setOID(db.getInteger(DBEstrucNivPuesto.OID_ESTRUC_PUE));
		estrucnivpuesto.setOid_estruc_sector(EstrucNivSector.findByOidProxy(db.getInteger(DBEstrucNivPuesto.OID_ESTRUC_SEC), getSesion()));
		estrucnivpuesto.setValor_clasif_puesto(ValorClasificadorEntidad.findByOidProxy(db.getInteger(DBEstrucNivPuesto.OID_VAL_CLASIF_PUE), getSesion()));
		estrucnivpuesto.setActivo(db.getBoolean(DBEstrucNivPuesto.ACTIVO));

	}
}
