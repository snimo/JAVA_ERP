package com.srn.erp.conciTarjeta.op;

import com.srn.erp.conciTarjeta.bm.ArchLoteConciDet;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.MapDatos;

public class BajaMovManuPOSNET extends Operation {

	public BajaMovManuPOSNET() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		ArchLoteConciDet archLoteConciDet = ArchLoteConciDet.findByOid(mapaDatos.getInteger("oid_arch_lote_det"), this.getSesion());

		if (archLoteConciDet == null)
			throw new ExceptionValidation(null,"Se debe seleccionar el movimiento POSNET");
		
		if (!archLoteConciDet.isActivo())
			throw new ExceptionValidation(null,"El movimiento ya se encuentra anulado");
		
		if (archLoteConciDet.isPreconci())
			throw new ExceptionValidation(null,"No se puede anular un movimiento conciliado");
		
		if (archLoteConciDet.isConciliado())
			throw new ExceptionValidation(null,"No se puede anular un movimiento confirmado");
		
		if (archLoteConciDet.isContaAsientoACobrar())
			throw new ExceptionValidation(null,"No se puede anular un movimiento incluido en un asiento de Cobranza");
		
		archLoteConciDet.delete();
		archLoteConciDet.save();
	}

}
