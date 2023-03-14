package com.srn.erp.conciTarjeta.op;

import com.srn.erp.conciTarjeta.bm.ArchLoteConciDet;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.MapDatos;

public class MarcarDesmarcarPreConci extends Operation {

	public MarcarDesmarcarPreConci() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		Integer oidArchLoteDet = mapaDatos.getInteger("oid_arch_lote_det");
		ArchLoteConciDet archLoteConciDet = ArchLoteConciDet.findByOid(oidArchLoteDet, this.getSesion());
		if (archLoteConciDet == null)
			throw new ExceptionValidation(null,"No se encontró el cupon seleccionado");
		if (archLoteConciDet.isConciliado())
			throw new ExceptionValidation(null, "El cupon no puede marcarse porque se encuentra confirmado.");
		if (archLoteConciDet.isPreconci())
			throw new ExceptionValidation(null, "El cupón no puede marcarse porque se encuentra conciliado");

		if (mapaDatos.containsKey("marcar"))
			archLoteConciDet.marcarComoPreconci();
		else
			archLoteConciDet.marcarComoNoPreconci();
	}

}
