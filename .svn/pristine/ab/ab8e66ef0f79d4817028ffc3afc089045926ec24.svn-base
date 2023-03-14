package com.srn.erp.conciTarjeta.op;

import com.srn.erp.conciTarjeta.bm.ArchLoteConciCab;
import com.srn.erp.conciTarjeta.bm.ArchLoteConciDet;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;

public class AnuImpArchPOSNET extends Operation {

	public AnuImpArchPOSNET() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		Integer oidArchLotCab = mapaDatos.getInteger("oid_arch_lot_cab");

		ArchLoteConciCab archLoteConciCab = ArchLoteConciCab.findByOid(oidArchLotCab, this.getSesion());
		archLoteConciCab.delete();
		archLoteConciCab.save();

		ArchLoteConciDet.anularDetallesDelArchivo(archLoteConciCab, this.getSesion());

	}

}
