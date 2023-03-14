package com.srn.erp.conciTarjeta.op;

import com.srn.erp.conciTarjeta.bm.DetTarConciEnt;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.MapDatos;

public class MarcarDesmarcarPreConci2 extends Operation {

	public MarcarDesmarcarPreConci2() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		Integer oidTarInfoDet = mapaDatos.getInteger("oid_tar_info_det");
		DetTarConciEnt detTarConciEnt = DetTarConciEnt.findByOid(oidTarInfoDet, this.getSesion());
		if (detTarConciEnt == null)
			throw new ExceptionValidation(null,"No se encontró el cupon seleccionado");
		if (detTarConciEnt.isConciliado())
			throw new ExceptionValidation(null, "El cupon no puede marcarse porque se encuentra confirmado.");
		if (detTarConciEnt.isPreConciliado())
			throw new ExceptionValidation(null, "El cupón no puede marcarse porque se encuentra conciliado");

		if (mapaDatos.containsKey("marcar"))
			detTarConciEnt.marcarComoPreconci();
		else
			detTarConciEnt.marcarComoNoPreconci();
	}

}
