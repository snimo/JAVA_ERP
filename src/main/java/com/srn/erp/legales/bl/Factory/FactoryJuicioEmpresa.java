package com.srn.erp.legales.bl.Factory;

import com.srn.erp.legales.bm.EmpresaJuicio;
import com.srn.erp.legales.bm.Juicio;
import com.srn.erp.legales.bm.JuicioEmpresa;
import com.srn.erp.legales.da.DBEmpresaJuicio;
import com.srn.erp.legales.da.DBJuicioEmpresa;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryJuicioEmpresa extends FactoryObjetoLogico {

	public FactoryJuicioEmpresa() {
	}

	public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
		JuicioEmpresa juicioempresa = (JuicioEmpresa) objLog;
		juicioempresa.setOID(db.getInteger(DBJuicioEmpresa.OID_JUI_EMP));
		juicioempresa.setJuicio(Juicio.findByOidProxy(db.getInteger(DBJuicioEmpresa.OID_JUICIO), getSesion()));
		juicioempresa.setEmpresaJuicio(EmpresaJuicio.findByOidProxy(db.getInteger(DBEmpresaJuicio.OID_EMP_JUI), getSesion()));
		juicioempresa.setActivo(db.getBoolean(DBJuicioEmpresa.ACTIVO));

	}
}
