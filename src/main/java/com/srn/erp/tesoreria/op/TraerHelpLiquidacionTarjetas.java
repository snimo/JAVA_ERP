package com.srn.erp.tesoreria.op;

import java.util.Iterator;
import java.util.List;

import com.srn.erp.tesoreria.bm.ConceptoLiqTarjeta;
import com.srn.erp.tesoreria.bm.LiquidacionTarCab;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerHelpLiquidacionTarjetas extends Operation {

	public TraerHelpLiquidacionTarjetas() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		IDataSet ds = this.getDataHelpLiqTarjetas();
		tratarHelpLiquidacionTarjetas(ds, mapaDatos);
		writeCliente(ds);
	}

	private void tratarHelpLiquidacionTarjetas(IDataSet dataSet, MapDatos mapaDatos) throws BaseException {

		Integer nroExtDesde = null;
		Integer nroExtHasta = null;
		java.util.Date fecDesde = null;
		java.util.Date fecHasta = null;
		ConceptoLiqTarjeta concepto = null;

		if (mapaDatos.containsKey("nro_ext_desde"))
			nroExtDesde = mapaDatos.getInteger("nro_ext_desde");
		if (mapaDatos.containsKey("nro_ext_hasta"))
			nroExtHasta = mapaDatos.getInteger("nro_ext_hasta");
		if (mapaDatos.containsKey("fec_desde"))
			fecDesde = mapaDatos.getDate("fec_desde");
		if (mapaDatos.containsKey("fec_hasta"))
			fecHasta = mapaDatos.getDate("fec_hasta");
		if (mapaDatos.containsKey("oid_conc_liq_tar"))
			concepto = ConceptoLiqTarjeta.findByOidProxy(mapaDatos.getInteger("oid_conc_liq_tar"), getSesion());

		List liquidacionTarjetas = LiquidacionTarCab.getHelpLiquidacionTarjetasCab(nroExtDesde, nroExtHasta, concepto, fecDesde, fecHasta,
				this.getSesion());

		Iterator iterLiqTar = liquidacionTarjetas.iterator();
		while (iterLiqTar.hasNext()) {
			LiquidacionTarCab liqTarCab = (LiquidacionTarCab) iterLiqTar.next();
			cargarRegistro(dataSet, liqTarCab);
		}

	}

	private IDataSet getDataHelpLiqTarjetas() {
		IDataSet dataset = new TDataSet();
		dataset.create("THelpLiquidacionTarjetas");
		dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_cco", Field.INTEGER, 0));
		dataset.fieldDef(new Field("comprobante", Field.STRING, 50));
		dataset.fieldDef(new Field("fec_emision", Field.DATE, 0));
		dataset.fieldDef(new Field("concepto", Field.STRING, 100));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private void cargarRegistro(IDataSet dataset, LiquidacionTarCab liquidacionTarjeta) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid", liquidacionTarjeta.getOIDInteger());
		dataset.fieldValue("oid_cco", liquidacionTarjeta.getOIDInteger());
		dataset.fieldValue("comprobante", liquidacionTarjeta.getCodigo());
		dataset.fieldValue("fec_emision", liquidacionTarjeta.getEmision());
		dataset.fieldValue("concepto", liquidacionTarjeta.getConcepto_liq_tar().getDescripcion());
		dataset.fieldValue("activo", liquidacionTarjeta.isActivo());

	}
}
