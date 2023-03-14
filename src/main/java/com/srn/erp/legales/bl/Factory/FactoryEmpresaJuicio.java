package com.srn.erp.legales.bl.Factory;

import com.srn.erp.legales.bm.EmpresaJuicio;
import com.srn.erp.legales.da.DBEmpresaJuicio;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryEmpresaJuicio extends FactoryObjetoLogico {

	public FactoryEmpresaJuicio() {
	}

	public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
		EmpresaJuicio empresajuicio = (EmpresaJuicio) objLog;
		empresajuicio.setOID(db.getInteger(DBEmpresaJuicio.OID_EMP_JUI));
		empresajuicio.setCodigo(db.getString(DBEmpresaJuicio.CODIGO));
		empresajuicio.setDescripcion(db.getString(DBEmpresaJuicio.DESCRIPCION));
		empresajuicio.setActivo(db.getBoolean(DBEmpresaJuicio.ACTIVO));

	}
}
