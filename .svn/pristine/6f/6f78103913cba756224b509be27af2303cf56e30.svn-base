package com.srn.erp.conciTarjeta.op;

import com.srn.erp.conciTarjeta.bm.DetTarConciEnt;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.MapDatos;

public class BajaMovManuTARJETA extends Operation {

	public BajaMovManuTARJETA() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		DetTarConciEnt detTarConciEnt = DetTarConciEnt.findByOid(mapaDatos.getInteger("oid_tar_info_det"), this.getSesion());
		
		if (detTarConciEnt == null)
			throw new ExceptionValidation(null,"No se pudo seleccionar el Movimiento");
	
		if (!detTarConciEnt.isActivo())
			throw new ExceptionValidation(null,"Movimiento de tarjeta ANULADO");
		
		if (detTarConciEnt.isPreConciliado())
			throw new ExceptionValidation(null,"No se puede dar de baja el movimiento de TARJETA porque esta CONCILIADO");
		
		if (detTarConciEnt.isConciliado())
			throw new ExceptionValidation(null,"No se puede dar de baja el movimiento de TARJETA porque esta CONFIRMADO");		
		
		detTarConciEnt.delete();
		detTarConciEnt.save();
		
	}

}
