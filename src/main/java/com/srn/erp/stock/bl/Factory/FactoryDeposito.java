package com.srn.erp.stock.bl.Factory;

import com.srn.erp.general.bm.Pais;
import com.srn.erp.general.bm.Provincia;
import com.srn.erp.stock.bm.Deposito;
import com.srn.erp.stock.da.DBDeposito;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryDeposito extends FactoryObjetoLogico {

	public FactoryDeposito() {
	}

	public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
		Deposito deposito = (Deposito) objLog;
		deposito.setOID(db.getInteger(DBDeposito.OID_DEPOSITO));
		deposito.setCodigo(db.getString(DBDeposito.CODIGO));
		deposito.setDescripcion(db.getString(DBDeposito.DESCRIPCION));
		deposito.setActivo(db.getBoolean(DBDeposito.ACTIVO));
		deposito.setCompoDepo(db.getString(DBDeposito.COMPO_DEPO));
		deposito.setCalleyNro(db.getString(DBDeposito.CALLE_Y_NRO));
		deposito.setLocalidad(db.getString(DBDeposito.LOCALIDAD));
		deposito.setCodigoPostal(db.getString(DBDeposito.CODIGO_POSTAL));
		deposito.setPais(Pais.findByOidProxy(db.getInteger(DBDeposito.OID_PAIS), this.getSesion()));
		deposito.setProvincia(Provincia.findByOidProxy(db.getInteger(DBDeposito.OID_PROVINCIA), this.getSesion()));
	}
}
