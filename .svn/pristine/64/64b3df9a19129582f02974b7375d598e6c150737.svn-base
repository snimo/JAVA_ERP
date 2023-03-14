package com.srn.erp.ventas.op;

import com.srn.erp.ventas.bm.FacturaCab;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class ValidarFactura extends Operation {

	public ValidarFactura() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		FacturaCab factura = null;

		IDataSet ds = this.getDataSetValidarFactura();

		if (mapaDatos.containsKey("oid_cco")) {
			factura = FacturaCab.findByOid(mapaDatos.getInteger("oid_cco"),
					this.getSesion());
		} else {
			String codigoFactura = mapaDatos.getString("codigo");
			factura = FacturaCab.buscarFacturaByCodigo(codigoFactura, true,
					this.getSesion());
			if (factura == null)
				factura = FacturaCab.buscarFacturaByCodigo(codigoFactura,
						false, this.getSesion());
		}
		if (factura != null) {
			if (!factura.isFacturaNotaDebito())
				throw new ExceptionValidation(null,"El comprobante ingresado no corresponde a una factura");
			cargarRegistroFactura(ds, factura);
		}

		writeCliente(ds);
	}

	private IDataSet getDataSetValidarFactura() {
		IDataSet dataset = new TDataSet();
		dataset.create("TValFactura");
		dataset.fieldDef(new Field("oid_cco", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 50));
		dataset.fieldDef(new Field("oid_sujeto", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_sujeto", Field.STRING, 50));
		dataset.fieldDef(new Field("rs_sujeto", Field.STRING, 100));
		dataset.fieldDef(new Field("oid_moneda", Field.INTEGER, 0));
		dataset.fieldDef(new Field("total", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private void cargarRegistroFactura(IDataSet dataset, FacturaCab factura)
			throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_cco", factura.getOIDInteger());
		dataset.fieldValue("codigo", factura.getCodigo());
		dataset.fieldValue("oid_sujeto", factura.getSujeto().getOIDInteger());
		dataset.fieldValue("cod_sujeto", factura.getSujeto().getCodigo());
		dataset.fieldValue("rs_sujeto", factura.getSujeto().getRazon_social());
		dataset.fieldValue("oid_moneda", factura.getMoneda().getOIDInteger());
		dataset.fieldValue("total", factura.getTotal());
		dataset.fieldValue("activo", factura.isActivo());
	}
}
