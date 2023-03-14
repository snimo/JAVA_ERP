package com.srn.erp.rrhh.bl.Factory;

import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.rrhh.bm.EstrucNivEmpresa;
import com.srn.erp.rrhh.bm.EstrucNivSector;
import com.srn.erp.rrhh.da.DBEstrucNivSector;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryEstrucNivSector extends FactoryObjetoLogico {

	public FactoryEstrucNivSector() {
	}

	public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
		EstrucNivSector estrucnivsector = (EstrucNivSector) objLog;
		estrucnivsector.setOID(db.getInteger(DBEstrucNivSector.OID_ESTRUC_SEC));
		estrucnivsector.setOid_estruc_emp(EstrucNivEmpresa.findByOidProxy(db.getInteger(DBEstrucNivSector.OID_ESTRUC_EMP), getSesion()));
		estrucnivsector.setValor_clasif_sector(ValorClasificadorEntidad.findByOidProxy(db.getInteger(DBEstrucNivSector.OID_VAL_CLASIF_SEC), getSesion()));
		estrucnivsector.setActivo(db.getBoolean(DBEstrucNivSector.ACTIVO));

	}
}
