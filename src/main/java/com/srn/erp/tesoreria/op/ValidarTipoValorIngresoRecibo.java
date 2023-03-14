package com.srn.erp.tesoreria.op;

import com.srn.erp.general.bm.Moneda;
import com.srn.erp.tesoreria.bm.TipoValor;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class ValidarTipoValorIngresoRecibo extends Operation {

	public ValidarTipoValorIngresoRecibo() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		String codigoTipoValor = mapaDatos.getString("codigo_tipo_valor");
		TipoValor tipoValor = TipoValor.findByCodigo(codigoTipoValor,
				getSesion());

		if (tipoValor == null)
			throw new ExceptionValidation(null,
					"Código de Tipo de valor inexistente:" + codigoTipoValor);

		
		if (!tipoValor.isIngresoRecibo())
			throw new ExceptionValidation(null,"Código de Tipo de Valor no válido:" + codigoTipoValor);
		
		IDataSet dsTipoValor = getDataSetTipoValor();

		cargarRegistroTipoValor(dsTipoValor, tipoValor.getOIDInteger(),
				tipoValor.getCodigo(), tipoValor.getDescripcion(), tipoValor
						.getCompo(), tipoValor.getMoneda(), tipoValor
						.isActivo());

		writeCliente(dsTipoValor);

	}

	private IDataSet getDataSetTipoValor() {
		IDataSet dataset = new TDataSet();
		dataset.create("TValTipoValor");
		dataset.fieldDef(new Field("oid_tipo_valor", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 10));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 30));
		dataset.fieldDef(new Field("compo", Field.STRING, 10));
		dataset.fieldDef(new Field("oid_moneda", Field.STRING, 0));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private void cargarRegistroTipoValor(IDataSet dataset,
			Integer oid_tipo_valor, String codigo, String descripcion,
			String compo, Moneda moneda, Boolean activo) {
		dataset.append();
		dataset.fieldValue("oid_tipo_valor", oid_tipo_valor);
		dataset.fieldValue("codigo", codigo);
		dataset.fieldValue("descripcion", descripcion);
		dataset.fieldValue("compo", compo);
		dataset.fieldValue("oid_moneda", moneda.getOID());
		dataset.fieldValue("activo", activo);
	}

}
