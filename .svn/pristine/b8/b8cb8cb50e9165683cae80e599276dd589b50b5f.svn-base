package com.srn.erp.proveedoresMaterials.op;

import java.util.List;

import com.srn.erp.impuestos.bm.SujetoImpositivo;
import com.srn.erp.proveedoresMaterials.bm.ProveedorMaterialsControl;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.MapDatos;

public class ValidarCUITProveedorMaterialControl extends Operation {

	@Override
	public void execute(MapDatos mapaDatos) throws BaseException {
		if (mapaDatos.containsKey("cuit")) {
			String cuit = mapaDatos.getString("cuit");
			
			if(cuit.length() != 13){
				throw new ExceptionValidation(null, "El Cuit no contiene 13 caracteres incluyendo '-'");
			}
			
			List<ProveedorMaterialsControl> proveedorUte = ProveedorMaterialsControl.findByCuitUte(cuit, getSesion());
			List<ProveedorMaterialsControl> proveedorBinbaires = ProveedorMaterialsControl.findByCuitBinbaires(cuit, getSesion());
			List<ProveedorMaterialsControl> proveedorAlavera = ProveedorMaterialsControl.findByCuitAlavera(cuit, getSesion());
			List<ProveedorMaterialsControl> proveedorMagic = ProveedorMaterialsControl.findByCuitMagic(cuit, getSesion());

			if (!proveedorUte.isEmpty()) {
				throw new ExceptionValidation(null, "Ya se encuentra un provedor con ese Cuit cargado");
			} else if (!proveedorBinbaires.isEmpty()) {
				throw new ExceptionValidation(null, "Ya se encuentra un provedor con ese Cuit cargado");
			} else if (!proveedorAlavera.isEmpty()) {
				throw new ExceptionValidation(null, "Ya se encuentra un provedor con ese Cuit cargado");
			} else if (!proveedorMagic.isEmpty()) {
				throw new ExceptionValidation(null, "Ya se encuentra un provedor con ese Cuit cargado");
			}
			
			SujetoImpositivo.validarCUIT(cuit.replaceAll("-", ""));
			
		} else {
			throw new ExceptionValidation(null, "Cargue un Cuit Valido");
		}

	}

}
