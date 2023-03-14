package com.srn.erp.cashflow.bl.Factory;

import com.srn.erp.cashflow.bm.EscenarioCashFlow;
import com.srn.erp.cashflow.da.DBEscenarioCashFlow;
import com.srn.erp.general.bm.Moneda;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryEscenarioCashFlow extends FactoryObjetoLogico {

	public FactoryEscenarioCashFlow() {
	}

	public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
		EscenarioCashFlow escenariocashflow = (EscenarioCashFlow) objLog;
		escenariocashflow.setOID(db.getInteger(DBEscenarioCashFlow.OID_ESCENARIO));
		escenariocashflow.setCodigo(db.getString(DBEscenarioCashFlow.CODIGO));
		escenariocashflow.setDescripcion(db.getString(DBEscenarioCashFlow.DESCRIPCION));
		escenariocashflow.setActivo(db.getBoolean(DBEscenarioCashFlow.ACTIVO));
		escenariocashflow.setVerDeudaClientes(db.getBoolean(DBEscenarioCashFlow.VER_DEUDA_CLIENTES));
		escenariocashflow.setMoneda(Moneda.findByOidProxy(db.getInteger(DBEscenarioCashFlow.OID_MONEDA), this.getSesion()));
	}
}
