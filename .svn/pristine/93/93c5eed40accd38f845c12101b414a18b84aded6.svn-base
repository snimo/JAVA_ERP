package com.srn.erp.ventas.op;

import java.util.Iterator;

import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.bm.UnidadMedida;
import com.srn.erp.ventas.bm.AplicFacturadoRemito;
import com.srn.erp.ventas.bm.FacturaCab;
import com.srn.erp.ventas.bm.FacturaDet;
import com.srn.erp.ventas.bm.PedidoDet;
import com.srn.erp.ventas.bm.RemitoCab;
import com.srn.erp.ventas.bm.RemitoDet;

import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerDevEnBaseARemito extends Operation {

	public TraerDevEnBaseARemito() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		String tipo = mapaDatos.getString("tipo");
		Integer oidDevCab = mapaDatos.getInteger("oid_devolucion_cab");

		if (tipo.equals("FACTURA")) {
			FacturaCab factura = FacturaCab.findByOid(mapaDatos.getInteger("oid_cco"), this.getSesion());
			traerDevEnBaseAFactura(oidDevCab, factura);
		} else if (tipo.equals("REMITO")) {
			RemitoCab remito = RemitoCab.findByOid(mapaDatos.getInteger("oid_cco"), this.getSesion());
			traerDevEnBaseARemito(oidDevCab, remito);
		}

	}

	private void traerDevEnBaseAFactura(Integer oidDevCab, FacturaCab factura) throws BaseException {

		int secu = 1;
		IDataSet ds = getDataSetDevolucion();
		Iterator iterAplicFactRto = AplicFacturadoRemito.getAplicRemitosFact(factura, this.getSesion()).iterator();
		while (iterAplicFactRto.hasNext()) {
			AplicFacturadoRemito aplicFactRto = (AplicFacturadoRemito) iterAplicFactRto.next();
			if (!aplicFactRto.getRemito_det().getRemito_cab().isActivo())
				continue;
			if (!aplicFactRto.getRemito_det().isActivo())
				continue;
			if (!aplicFactRto.getFactura().isActivo())
				continue;
			cargarRegistro(ds, new Integer(++secu), oidDevCab, aplicFactRto.getRemito_det().getProducto(), aplicFactRto.getRemito_det()
					.getComentario(), new Money(aplicFactRto.getRemito_det().getCantPermitidaDevolucion()), aplicFactRto.getRemito_det()
					.getUnidad_desp(), false, false, null, "", aplicFactRto.getRemito_det(), aplicFactRto.getRemito_det().getRemito_cab()
					.getCodigo(), aplicFactRto.getFactura_det(), aplicFactRto.getFactura_det().getComprocab().getCodigo());

		}
		writeCliente(ds);

	}

	private void traerDevEnBaseARemito(Integer oidDevCab, RemitoCab remito) throws BaseException {

		int secu = 1;
		IDataSet ds = getDataSetDevolucion();
		Iterator iterDetallesRto = remito.getDetalles().iterator();
		while (iterDetallesRto.hasNext()) {
			RemitoDet remitoDet = (RemitoDet) iterDetallesRto.next();
			if (!remitoDet.isActivo())
				continue;
			if (!remitoDet.getRemito_cab().isActivo())
				continue;
			cargarRegistro(ds, new Integer(++secu), oidDevCab, remitoDet.getProducto(), 
					remitoDet.getComentario(), 
					new Money(remitoDet.getCantPermitidaDevolucion()), 
					remitoDet.getUnidad_desp(), false, false, null, "", 
					remitoDet, 
					remitoDet.getRemito_cab().getCodigo(), 
					null, 
					"");

		}
		writeCliente(ds);

	}

	private IDataSet getDataSetDevolucion() {
		IDataSet dataset = new TDataSet();
		dataset.create("TDevolucionDet");
		dataset.fieldDef(new Field("oid_devolucion_det", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_devolucion_cab", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_producto", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_producto", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_producto", Field.STRING, 100));
		dataset.fieldDef(new Field("label_motivo_devolucion", Field.STRING, 100));
		dataset.fieldDef(new Field("label_obs", Field.STRING, 20));
		dataset.fieldDef(new Field("observaciones", Field.MEMO, 0));
		dataset.fieldDef(new Field("label_cant_dev_1", Field.STRING, 50));
		dataset.fieldDef(new Field("cant_dev_1", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("oid_um_dev_1", Field.INTEGER, 0));
		dataset.fieldDef(new Field("label_emitir_nc", Field.STRING, 50));
		dataset.fieldDef(new Field("pend_emitir_nc", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("label_modif_precio", Field.STRING, 50));
		dataset.fieldDef(new Field("modif_precio", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("label_ref_pedido", Field.STRING, 50));
		dataset.fieldDef(new Field("oid_ped_det", Field.INTEGER, 0));
		dataset.fieldDef(new Field("ref_ped_det", Field.STRING, 100));
		dataset.fieldDef(new Field("label_ref_remito", Field.STRING, 50));
		dataset.fieldDef(new Field("oid_rto_det", Field.INTEGER, 0));
		dataset.fieldDef(new Field("ref_rto_det", Field.STRING, 100));
		dataset.fieldDef(new Field("label_ref_factura", Field.STRING, 50));
		dataset.fieldDef(new Field("oid_fact_det", Field.INTEGER, 0));
		dataset.fieldDef(new Field("ref_fact_det", Field.STRING, 100));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private void cargarRegistro(IDataSet dataset, Integer oidDevDet, Integer oidDevCab, Producto producto, String observacion,
			Money cantDevuela, UnidadMedida umDevolucion, boolean pendEmitirNC, boolean modifPrecio, PedidoDet pedidoDet, String refPedDet,
			RemitoDet remitoDet, String refRemDet, FacturaDet facturaDet, String refFactCab) throws BaseException {

		dataset.append();
		dataset.fieldValue("oid_devolucion_det", oidDevDet);
		dataset.fieldValue("oid_devolucion_cab", oidDevCab);
		dataset.fieldValue("oid_producto", producto.getOIDInteger());
		dataset.fieldValue("cod_producto", producto.getCodigo());
		dataset.fieldValue("desc_producto", producto.getDescripcion());
		dataset.fieldValue("label_motivo_devolucion", "Motivo Devolución");
		dataset.fieldValue("label_obs", "Obs");
		dataset.fieldValue("observaciones", observacion);
		dataset.fieldValue("label_cant_dev_1", "Cantidad");
		dataset.fieldValue("cant_dev_1", cantDevuela);
		dataset.fieldValue("oid_um_dev_1", umDevolucion.getOIDInteger());
		dataset.fieldValue("label_emitir_nc", "Emitir N.C.");
		dataset.fieldValue("pend_emitir_nc", pendEmitirNC);
		dataset.fieldValue("label_modif_precio", "Cambiar Precio");
		dataset.fieldValue("modif_precio", modifPrecio);
		dataset.fieldValue("label_ref_pedido", "Ref. Pedido");
		if (pedidoDet != null) {
			dataset.fieldValue("oid_ped_det", pedidoDet.getOIDInteger());
			dataset.fieldValue("ref_ped_det", pedidoDet.getReferencia());
		} else {
			dataset.fieldValue("oid_ped_det", "");
			dataset.fieldValue("ref_ped_det", "");
		}

		dataset.fieldValue("label_ref_remito", "Ref. Remito");
		if (remitoDet != null) {
			dataset.fieldValue("oid_rto_det", remitoDet.getOIDInteger());
			dataset.fieldValue("ref_rto_det", remitoDet.getRemito_cab().getCodigo());
		} else {
			dataset.fieldValue("oid_rto_det", "");
			dataset.fieldValue("ref_rto_det", "");
		}

		dataset.fieldValue("label_ref_factura", "Ref. Factura");
		if (facturaDet != null) {
			dataset.fieldValue("oid_fact_det", facturaDet.getOIDInteger());
			dataset.fieldValue("ref_fact_det", facturaDet.getComprocab().getCodigo());
		} else {
			dataset.fieldValue("oid_fact_det", "");
			dataset.fieldValue("ref_fact_det", "");
		}

		dataset.fieldValue("activo", true);

	}

}
