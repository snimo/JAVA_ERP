package com.srn.erp.legales.bl.Factory;

import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.legales.bm.RequeridoSeclo;
import com.srn.erp.legales.bm.Seclo;
import com.srn.erp.legales.da.DBRequeridoSeclo;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryRequeridoSeclo extends FactoryObjetoLogico {

	public FactoryRequeridoSeclo() {
	}

	public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
		RequeridoSeclo requeridoseclo = (RequeridoSeclo) objLog;
		requeridoseclo.setOID(db.getInteger(DBRequeridoSeclo.OID_SECLO_REQUE));
		requeridoseclo.setSeclo(Seclo.findByOidProxy(db.getInteger(DBRequeridoSeclo.OID_SECLO), getSesion()));
		requeridoseclo.setValor_clasif_empresa(ValorClasificadorEntidad.findByOidProxy(db.getInteger(DBRequeridoSeclo.OID_VAL_CLASIF_EMP), getSesion()));
		requeridoseclo.setActivo(db.getBoolean(DBRequeridoSeclo.ACTIVO));

	}
}
