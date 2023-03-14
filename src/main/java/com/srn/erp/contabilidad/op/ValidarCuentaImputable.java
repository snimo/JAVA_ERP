package com.srn.erp.contabilidad.op;

import com.srn.erp.contabilidad.bm.CuentaImputable;
import com.srn.erp.ctasAPagar.bm.ConcFactProv;
import com.srn.erp.general.bm.MotivoComprobante;
import com.srn.erp.pagos.bm.MotivoPago;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class ValidarCuentaImputable extends Operation {

	String	nombreTabla	= null;

	public ValidarCuentaImputable() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		if (mapaDatos.containsKey("tableName"))
			nombreTabla = mapaDatos.getString("tableName");

		String codigoImputacion = "";
		if (mapaDatos.containsKey("codigo"))
			codigoImputacion = mapaDatos.getString("codigo");
		else
			codigoImputacion = mapaDatos.getString("codigoImputacion");
		
		CuentaImputable imputable = null;
		if (!codigoImputacion.equals("")) {

			imputable = CuentaImputable.getImputable(codigoImputacion, getSesion());

			validarRestIngVar(imputable, mapaDatos);
			validarRestRendFF(imputable, mapaDatos);
			validarRestConcFactProv(imputable, mapaDatos);
			validarRestModuloBancos(imputable, mapaDatos);
			validarRestOPVarias(imputable, mapaDatos);
			validarRestRendFFyConcCta(imputable, mapaDatos);
		}
		

		IDataSet dataset = getDataSetImputable();

		if (imputable != null)
			cargarRegistroCuentaImputable(dataset, imputable.getOIDInteger(), imputable.getCodigoCuentaMasCodigosValCompo(),
					imputable.getDescripcion(), imputable.isActivo());

		writeCliente(dataset);
	}

	private IDataSet getDataSetImputable() {
		IDataSet dataset = new TDataSet();

		if (this.nombreTabla != null)
			dataset.create(nombreTabla);
		else
			dataset.create("TValidarImputable");
		dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 50));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 255));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private void cargarRegistroCuentaImputable(IDataSet dataset, Integer oid, String codigo, String descripcion,
			Boolean activo) {
		dataset.append();
		dataset.fieldValue("oid", oid);
		dataset.fieldValue("codigo", codigo);
		dataset.fieldValue("descripcion", descripcion);
		dataset.fieldValue("activo", activo);
	}

	private void validarRestIngVar(CuentaImputable imputable, MapDatos mapaDatos) throws BaseException {
		if ((imputable != null) && (mapaDatos.containsKey("RESTRINGIR_CUENTAS"))) {

			// Si la restriccion corresponde a Ingresos Varios
			String restringir = mapaDatos.getString("RESTRINGIR_CUENTAS");
			if (restringir.equals("ING_VAR")) {

				MotivoComprobante motCompro = MotivoComprobante.findByOidProxy(mapaDatos.getInteger("oid_motivo"), this
						.getSesion());

				if (imputable.isCuentaImputableHabIngVar(motCompro, this.getSesion()) == false)
					throw new ExceptionValidation(null,
							"La cuenta ingresada no se encuentra habilitada para ser utilizada en Ingresos Varios");

			}
		}

	}


	private void validarRestModuloBancos(CuentaImputable imputable, MapDatos mapaDatos) throws BaseException {
		
		if ((imputable != null) && (mapaDatos.containsKey("RESTRINGIR_CUENTAS"))) {

			// Si la restriccion corresponde a Ingresos Varios
			String restringir = mapaDatos.getString("RESTRINGIR_CUENTAS");
			if (restringir.equals("MODULO_BANCOS")) {

				if (imputable.isCuentaImputableHabModuloBancos(this.getSesion()) == false)
					throw new ExceptionValidation(null,
							"La cuenta ingresada no se encuentra habilitada para ser utilizada en el Módulo de Bancos");

			}
		}

	}
	
	private void validarRestOPVarias(CuentaImputable imputable, MapDatos mapaDatos) throws BaseException {
		
		if ((imputable != null) && (mapaDatos.containsKey("RESTRINGIR_CUENTAS"))) {

			// Si la restriccion corresponde a Ingresos Varios
			String restringir = mapaDatos.getString("RESTRINGIR_CUENTAS");
			if (restringir.equals("OP_VARIAS")) {

				MotivoPago motivoPago = 
					MotivoPago.findByOidProxy(mapaDatos.getInteger("oid_motivo_op"), this.getSesion());
				
				if (motivoPago.getCtaHabMotPago(imputable.getCuenta())==null)
					throw new ExceptionValidation(null,
							"La cuenta ingresada no se encuentra habilitada para ser utilizada en una Orden de Pago Varias para el motivo "+motivoPago.getDescripcion());

			}
		}

	}
	
	
	
	private void validarRestRendFF(CuentaImputable imputable, MapDatos mapaDatos) throws BaseException {
		if ((imputable != null) && (mapaDatos.containsKey("RESTRINGIR_CUENTAS"))) {

			// Si la restriccion corresponde a Ingresos Varios
			String restringir = mapaDatos.getString("RESTRINGIR_CUENTAS");
			if (restringir.equals("REND_FONDO_FIJO")) {

				if (imputable.isCuentaImputableHabRendFF(this.getSesion()) == false)
					throw new ExceptionValidation(null,
							"La cuenta ingresada no se encuentra habilitada para ser utilizada en Rendición de Fondo Fijo");

			}
		}

	}
	
	private void validarRestRendFFyConcCta(CuentaImputable imputable, MapDatos mapaDatos) throws BaseException {
		
		
		if ((imputable != null) && (mapaDatos.containsKey("RESTRINGIR_CUENTAS"))) {

			boolean habEnConcepto = false;
			boolean habRendFF = false;
			
			String restringir = mapaDatos.getString("RESTRINGIR_CUENTAS");
			if (restringir.equals("CONC_COMPRO_PROV_O_REND_FONDO_FIJO")) {

				ConcFactProv concFactProv = ConcFactProv.findByOidProxy(mapaDatos.getInteger("oid_concepto"), this.getSesion());

				if (imputable.isCuentaImputableHabConcFactProv(this.getSesion(),concFactProv))
					habEnConcepto = true;
				
				if (imputable.isCuentaImputableHabRendFF(this.getSesion()))
					habRendFF = true;
				
				if ((habEnConcepto == false) && (habRendFF == false))
					throw new ExceptionValidation(null,"La cuenta ingresada no se encuentra habilitada para ser utilizada en Rendición de Fondo Fijo");

			}
			
			
		}

		
		
		if ((imputable != null) && (mapaDatos.containsKey("RESTRINGIR_CUENTAS"))) {

			// Si la restriccion corresponde a Ingresos Varios
			String restringir = mapaDatos.getString("RESTRINGIR_CUENTAS");
			if (restringir.equals("REND_FONDO_FIJO")) {

				if (imputable.isCuentaImputableHabRendFF(this.getSesion()) == false)
					throw new ExceptionValidation(null,
							"La cuenta ingresada no se encuentra habilitada para ser utilizada en Rendición de Fondo Fijo");

			}
		}

	}
	

	private void validarRestConcFactProv(CuentaImputable imputable, MapDatos mapaDatos) throws BaseException {
		if ((imputable != null) && (mapaDatos.containsKey("RESTRINGIR_CUENTAS"))) {

			// Si la restriccion corresponde a Ingresos Varios
			String restringir = mapaDatos.getString("RESTRINGIR_CUENTAS");
			if (restringir.equals("CONC_COMPRO_PROV")) {

				ConcFactProv concFactProv = ConcFactProv.findByOidProxy(mapaDatos.getInteger("oid_concepto"), this.getSesion());

				if (imputable.isCuentaImputableHabConcFactProv(this.getSesion(),concFactProv) == false)
					throw new ExceptionValidation(null,
							"La cuenta ingresada no se encuentra habilitada para ser utilizada en el concepto "+concFactProv.getDescripcion());

			}
		}

	}

}
