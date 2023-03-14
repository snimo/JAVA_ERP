package com.srn.erp.ctasAPagar.bl.Factory;

import com.srn.erp.ctasAPagar.bm.EsquemaAutorizFactMonto;
import com.srn.erp.ctasAPagar.bm.EsquemaAutorizFactProv;
import com.srn.erp.ctasAPagar.da.DBEsquemaAutorizFactMonto;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryEsquemaAutorizFactMonto extends FactoryObjetoLogico {

	public FactoryEsquemaAutorizFactMonto() {
	}

	public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
		EsquemaAutorizFactMonto esquemaautorizfactmonto = (EsquemaAutorizFactMonto) objLog;
		esquemaautorizfactmonto.setOID(db.getInteger(DBEsquemaAutorizFactMonto.OID_ESQ_AUT_MON));
		esquemaautorizfactmonto.setEsquema_autoriz_factura(EsquemaAutorizFactProv.findByOidProxy(db
				.getInteger(DBEsquemaAutorizFactMonto.OID_ESQ_AUT_FACT), getSesion()));
		esquemaautorizfactmonto.setOrden(db.getInteger(DBEsquemaAutorizFactMonto.ORDEN));
		esquemaautorizfactmonto.setMonto_desde(db.getMoney(DBEsquemaAutorizFactMonto.MONTO_DESDE));
		esquemaautorizfactmonto.setMonto_hasta(db.getMoney(DBEsquemaAutorizFactMonto.MONTO_HASTA));
	}
}
