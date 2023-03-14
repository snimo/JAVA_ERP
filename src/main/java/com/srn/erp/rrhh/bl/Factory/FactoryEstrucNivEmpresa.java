package com.srn.erp.rrhh.bl.Factory;

import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.rrhh.bm.EstrucNivEmpresa;
import com.srn.erp.rrhh.da.DBEstrucNivEmpresa;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryEstrucNivEmpresa extends FactoryObjetoLogico {

	public FactoryEstrucNivEmpresa() {
	}

	public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
		EstrucNivEmpresa estrucnivempresa = (EstrucNivEmpresa) objLog;
		estrucnivempresa.setOID(db.getInteger(DBEstrucNivEmpresa.OID_ESTRUC_EMP));
		estrucnivempresa.setValor_clasif_empresa(ValorClasificadorEntidad.findByOidProxy(db.getInteger(DBEstrucNivEmpresa.OID_VAL_CLASIF_EMP), getSesion()));
		estrucnivempresa.setActivo(db.getBoolean(DBEstrucNivEmpresa.ACTIVO));
	}
}
