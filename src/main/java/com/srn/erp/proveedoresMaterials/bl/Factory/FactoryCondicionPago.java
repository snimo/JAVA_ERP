package com.srn.erp.proveedoresMaterials.bl.Factory;

import framework.applicarionServer.bl.ObjetosAplicacion.*;
import framework.applicarionServer.bl.Persistencia.*;
import framework.request.bl.Utils.*;
import com.srn.erp.proveedoresMaterials.bm.CondicionPago;
import com.srn.erp.proveedoresMaterials.da.DBCondicionPago;

public class FactoryCondicionPago extends FactoryObjetoLogico {

	public FactoryCondicionPago() {
	}

	public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
		CondicionPago condicionpago = (CondicionPago) objLog;
		condicionpago.setOID(db.getInteger(DBCondicionPago.OID_CONDICION_PAGO));
		condicionpago.setCodigo(db.getString(DBCondicionPago.CODIGO));
		condicionpago.setDescripcion(db.getString(DBCondicionPago.DESCRIPCION));
		condicionpago.setActivo(db.getBoolean(DBCondicionPago.ACTIVO));

	}
}
