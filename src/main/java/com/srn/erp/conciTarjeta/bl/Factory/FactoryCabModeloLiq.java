package com.srn.erp.conciTarjeta.bl.Factory;

import com.srn.erp.conciTarjeta.bm.CabModeloLiq;
import com.srn.erp.conciTarjeta.da.DBCabModeloLiq;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryCabModeloLiq extends FactoryObjetoLogico {

	public FactoryCabModeloLiq() {
	}

	public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
		CabModeloLiq cabmodeloliq = (CabModeloLiq) objLog;
		cabmodeloliq.setOID(db.getInteger(DBCabModeloLiq.OID_MODELO_LIQ));
		cabmodeloliq.setCodigo(db.getString(DBCabModeloLiq.CODIGO));
		cabmodeloliq.setDescripcion(db.getString(DBCabModeloLiq.DESCRIPCION));
		cabmodeloliq.setActivo(db.getBoolean(DBCabModeloLiq.ACTIVO));
		cabmodeloliq.setComenAsiento(db.getString(DBCabModeloLiq.COMEN_ASIENTO));
	}
}
