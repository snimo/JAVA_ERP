package com.srn.erp.compras.op;

import com.srn.erp.compras.bm.CondCompraProv;
import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.general.bm.Moneda;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerDatosIniOC extends Operation {

	public TraerDatosIniOC() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		Proveedor proveedor = Proveedor.findByOid(mapaDatos.getInteger("oid_proveedor"), getSesion());
		IDataSet ds = this.getDataSetDatosIniCompra();
		cargarRegistroDatosIniCompra(ds, proveedor);
		writeCliente(ds);
	}

	private IDataSet getDataSetDatosIniCompra() {
		IDataSet dataset = new TDataSet();
		dataset.create("TDatosIniOC");
		dataset.fieldDef(new Field("oid_proveedor", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_moneda", Field.INTEGER, 0));
		dataset.fieldDef(new Field("tomar_precio", Field.STRING, 10));
		dataset.fieldDef(new Field("oid_cond_pago", Field.INTEGER, 0));
		dataset.fieldDef(new Field("dto_1", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("dto_2", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("dto_3", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("en_cascada", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("porc_recargo", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("oid_via_despacho", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_cond_compra", Field.INTEGER, 0));
		dataset.fieldDef(new Field("permitir_cambiar_tp", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("dto_en_cascada",Field.BOOLEAN, 0));
		return dataset;
	}

	private void cargarRegistroDatosIniCompra(IDataSet dataset, Proveedor proveedor) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_proveedor", proveedor.getOIDInteger());
		if (proveedor.getMonedaoc() != null)
			dataset.fieldValue("oid_moneda", proveedor.getMonedaoc().getOIDInteger());
		else
			dataset.fieldValue("oid_moneda", Moneda.getMonedaCursoLegal(this.getSesion()).getOIDInteger());
		dataset.fieldValue("tomar_precio", proveedor.getTomarPrecioOC());

		CondCompraProv condCompraProv = proveedor.getCondPagoDefaultProv();
		if (condCompraProv != null) {
			dataset.fieldValue("oid_cond_pago", condCompraProv.getCondcompra().getOIDInteger());
			dataset.fieldValue("dto_1", condCompraProv.getDescuento());
			dataset.fieldValue("dto_2", 0);
			dataset.fieldValue("dto_3", 0);
			dataset.fieldValue("en_cascada", new Boolean(true));
			dataset.fieldValue("porc_recargo", condCompraProv.getRecargo());
		}
		else {
			dataset.fieldValue("oid_cond_pago", 0);
			dataset.fieldValue("dto_1", 0);
			dataset.fieldValue("dto_2", 0);
			dataset.fieldValue("dto_3", 0);
			dataset.fieldValue("en_cascada", new Boolean(true));
			dataset.fieldValue("porc_recargo", 0);
		}
		if (proveedor.getViaDespacho() != null)
			dataset.fieldValue("oid_via_despacho", proveedor.getViaDespacho().getOIDInteger());
		else
			dataset.fieldValue("oid_via_despacho", 0);

		if (proveedor.getCondCompraImpo() != null)
			dataset.fieldValue("oid_cond_compra", proveedor.getCondCompraImpo().getOIDInteger());
		else
			dataset.fieldValue("oid_cond_compra", 0);
		dataset.fieldValue("permitir_cambiar_tp", proveedor.isPermitirCambioTomarPrecioOC());
		dataset.fieldValue("dto_en_cascada", proveedor.isDtoEnCascada());
	}

}
