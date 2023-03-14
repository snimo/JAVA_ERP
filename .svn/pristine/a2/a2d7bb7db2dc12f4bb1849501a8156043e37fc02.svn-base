package com.srn.erp.compras.bl.Factory;

import com.srn.erp.compras.bm.SectorCompra;
import com.srn.erp.compras.da.DBSectorCompra;
import com.srn.erp.general.bm.Sucursal;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactorySectorCompra extends FactoryObjetoLogico {

	public FactorySectorCompra() {
	}

	public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db)
			throws BaseException {
		SectorCompra sectorcompra = (SectorCompra) objLog;
		sectorcompra.setOID(db.getInteger(DBSectorCompra.OID));
		sectorcompra.setCodigo(db.getString(DBSectorCompra.CODIGO));
		sectorcompra.setDescripcion(db.getString(DBSectorCompra.DESCRIPCION));
		sectorcompra.setActivo(db.getBoolean(DBSectorCompra.ACTIVO));
		sectorcompra.setSucursal(Sucursal.findByOidProxy(db.getInteger(DBSectorCompra.OID_SUCURSAL),getSesion()));
	}
}
