package com.srn.erp.compras.op;

import java.util.Iterator;

import com.srn.erp.compras.bm.AcuerdoLP;
import com.srn.erp.compras.bm.AcuerdoLPCondPago;
import com.srn.erp.compras.bm.AcuerdoLPDetalle;
import com.srn.erp.compras.bm.AcuerdoLPDetalleDto;
import com.srn.erp.compras.bm.AcuerdoLPDetalleDtoCant;
import com.srn.erp.compras.bm.CondicionCompra;
import com.srn.erp.compras.bm.PrecioCompraPorClasifArt;
import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.compras.bm.TipoAcuerdo;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.bm.UnidadMedida;
import com.srn.erp.ventas.bm.DefEstrucLPCab;
import com.srn.erp.ventas.bm.DefEstrucLPDet;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerAcuerdoLP extends Operation {

	HashTableDatos preciosCompraClasif = new HashTableDatos();

	public TraerAcuerdoLP() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		AcuerdoLP acuerdolp = null;
		if (mapaDatos.containsKey("oid")) {
			Integer oid = mapaDatos.getInteger("oid");
			acuerdolp = AcuerdoLP.findByOid(oid, getSesion());
		} else {
			String codigo = mapaDatos.getString("codigo");
			acuerdolp = AcuerdoLP.findByCodigo(codigo, getSesion());
		}

		IDataSet datasetAcuerdoLP = getDataSetAcuerdoLP();
		IDataSet datasetAcuerdoLPCondPago = getDataSetAcuerdoLPCondPago();
		IDataSet datasetAcuerdoLPDetalle = getDataSetAcuerdoLPDetalle();
		IDataSet datasetAcuerdoLPDetalleDto = getDataSetAcuerdoLPDetalleDto();
		IDataSet datasetAcuerdoLPDetallaDtoCant = getDataSetAcuerdoLPDetalleDtoCant();
		IDataSet datasetPreciosCompraClasif = getDataSetDefEstrucLPDet();

		if (acuerdolp != null) {
			cargarRegistroAcuerdoLP(datasetAcuerdoLP,
					acuerdolp.getOIDInteger(), acuerdolp.getTipo_acuerdo(),
					acuerdolp.getProveedor(), 
					acuerdolp.isActivo(),
					acuerdolp.getDescripcion());

			// EnviarPreciosCompraClasif
			enviarPreciosCompraClasif(datasetPreciosCompraClasif, acuerdolp);

			// Devolver condiciones de Pago
			Iterator iterCondPagoAcuerdo = acuerdolp.getCondPagoAcuerdo()
					.iterator();
			while (iterCondPagoAcuerdo.hasNext()) {
				AcuerdoLPCondPago acuerdoLPCondPago = (AcuerdoLPCondPago) iterCondPagoAcuerdo
						.next();
				cargarRegistroAcuerdoLPCondPago(datasetAcuerdoLPCondPago,
						acuerdoLPCondPago.getOIDInteger(), acuerdolp,
						acuerdoLPCondPago.getCondicion_pago(),
						acuerdoLPCondPago.getDto_1(), acuerdoLPCondPago
								.getDto_2(), acuerdoLPCondPago.getDto_3(),
						acuerdoLPCondPago.getDto_4(), acuerdoLPCondPago
								.getDto_5(), acuerdoLPCondPago.isEn_cascada(),
						acuerdoLPCondPago.isActivo());
			}

			// Devolver Detalles
			Iterator iterAcuerdoLPDetalles = acuerdolp.getAcuerdosLPDetalles()
					.iterator();
			while (iterAcuerdoLPDetalles.hasNext()) {
				AcuerdoLPDetalle acuerdoLPDetalle = (AcuerdoLPDetalle) iterAcuerdoLPDetalles
						.next();

				Iterator iterAcuerdosDetallesDtos = acuerdoLPDetalle
						.getAcuerdosDetallesDtos().iterator();
				while (iterAcuerdosDetallesDtos.hasNext()) {
					AcuerdoLPDetalleDto acuerdoLPDetalleDto = (AcuerdoLPDetalleDto) iterAcuerdosDetallesDtos
							.next();
					cargarRegistroAcuerdoLPDetalleDto(
							datasetAcuerdoLPDetalleDto, acuerdoLPDetalleDto
									.getOIDInteger(), acuerdoLPDetalle,
							acuerdoLPDetalleDto.getCondicion_pago(),
							acuerdoLPDetalleDto.getDto_1(), acuerdoLPDetalleDto
									.getDto_2(),
							acuerdoLPDetalleDto.getDto_3(), acuerdoLPDetalleDto
									.getDto_4(),
							acuerdoLPDetalleDto.getDto_5(), acuerdoLPDetalleDto
									.getTipo_dto(), acuerdoLPDetalleDto
									.isEn_cascada(), acuerdoLPDetalleDto
									.isActivo());

					Iterator iterDtosPorCantidades = acuerdoLPDetalleDto
							.getDtosPorCantidades().iterator();
					while (iterDtosPorCantidades.hasNext()) {
						AcuerdoLPDetalleDtoCant dtoPorCant = (AcuerdoLPDetalleDtoCant) iterDtosPorCantidades
								.next();
						cargarRegistroAcuerdoLPDetalleDtoCant(
								datasetAcuerdoLPDetallaDtoCant, dtoPorCant
										.getOIDInteger(), acuerdoLPDetalleDto,
								dtoPorCant.getCant_desde(), dtoPorCant
										.getCant_hasta(),
								dtoPorCant.getDto_1(), dtoPorCant.getDto_2(),
								dtoPorCant.getDto_3(), dtoPorCant.getDto_4(),
								dtoPorCant.getDto_5(), dtoPorCant
										.isEn_cascada(), dtoPorCant.isActivo());
					}
				}

				cargarRegistroAcuerdoLPDetalle(datasetAcuerdoLPDetalle,
						acuerdoLPDetalle.getOIDInteger(), acuerdolp,
						acuerdoLPDetalle.getProducto(), acuerdoLPDetalle
								.getVigencia_desde(), acuerdoLPDetalle
								.getVigencia_hasta(), acuerdoLPDetalle
								.getCantidad(), acuerdoLPDetalle
								.getUnidad_medida(), acuerdoLPDetalle
								.getMoneda(), acuerdoLPDetalle.getPrecio(),
						acuerdoLPDetalle.getComentario(), acuerdoLPDetalle
								.isActivo(), acuerdoLPDetalle.getCodProdProv(),
						acuerdoLPDetalle.getDescProdProv());
			}

		}
		writeCliente(datasetAcuerdoLP);
		writeCliente(datasetAcuerdoLPCondPago);
		writeCliente(datasetAcuerdoLPDetalle);
		writeCliente(datasetAcuerdoLPDetalleDto);
		writeCliente(datasetAcuerdoLPDetallaDtoCant);
		writeCliente(datasetPreciosCompraClasif);
	}

	private void enviarPreciosCompraClasif(IDataSet ds, AcuerdoLP acuerdolp)
			throws BaseException {

		/*cargaraValoresPrecioCompraClasif(acuerdolp);

		int secu = 1;
		Iterator iterDefEstrucLPDet = acuerdolp.getDefEstrucLP()
				.getDefEstrucLPDet().iterator();
		while (iterDefEstrucLPDet.hasNext()) {
			DefEstrucLPDet defEstrucLPDet = (DefEstrucLPDet) iterDefEstrucLPDet
					.next();
			if (defEstrucLPDet.isActivo().booleanValue() == false)
				continue;

			cargarRegistroDefEstrucLPDet(ds, new Integer(secu), acuerdolp
					.getOIDInteger(), defEstrucLPDet);

			++secu;
		}*/

	}

	private void cargarRegistroDefEstrucLPDet(IDataSet dataset, Integer secu,
			Integer oidAcuerdoLP, DefEstrucLPDet defEstrucLPDet)
			throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_precio_clasif", secu);
		dataset.fieldValue("oid_acuerdo_lp", oidAcuerdoLP);
		dataset.fieldValue("oid_def_estruc_lp", defEstrucLPDet
				.getDef_estruc_lp().getOIDInteger());
		dataset.fieldValue("oid_clasif_art_1", defEstrucLPDet
				.getValor_clasif_art_1().getOIDInteger());
		dataset.fieldValue("cod_clasif_art_1", defEstrucLPDet
				.getValor_clasif_art_1().getCodigo());
		dataset.fieldValue("desc_clasif_art_1", defEstrucLPDet
				.getValor_clasif_art_1().getDescripcion());
		dataset.fieldValue("oid_clasif_art_2", defEstrucLPDet
				.getValor_clasif_art_2().getOIDInteger());
		dataset.fieldValue("cod_clasif_art_2", defEstrucLPDet
				.getValor_clasif_art_2().getCodigo());
		dataset.fieldValue("desc_clasif_art_2", defEstrucLPDet
				.getValor_clasif_art_2().getDescripcion());
		dataset.fieldValue("orden", defEstrucLPDet.getOrden());
		dataset.fieldValue("activo", defEstrucLPDet.isActivo());
		dataset.fieldValue("oid_clasificador_1", defEstrucLPDet
				.getValor_clasif_art_1().getClasificador_entidad()
				.getOIDInteger());
		dataset.fieldValue("oid_clasificador_2", defEstrucLPDet
				.getValor_clasif_art_2().getClasificador_entidad()
				.getOIDInteger());

		PrecioCompraPorClasifArt pc = (PrecioCompraPorClasifArt) this.preciosCompraClasif
				.get(defEstrucLPDet.getValor_clasif_art_2().getOIDInteger());

		if (pc != null) {
			dataset.fieldValue("cantidad", pc.getCantidad());
			dataset.fieldValue("oid_um", pc.getUnidad_medida().getOIDInteger());
			dataset.fieldValue("precio", pc.getPrecio());
			dataset.fieldValue("oid_moneda", pc.getMoneda().getOIDInteger());
		} else {
			dataset.fieldValue("cantidad", "");
			dataset.fieldValue("oid_um", "");
			dataset.fieldValue("precio", "");
			dataset.fieldValue("oid_moneda", "");
		}

	}

	private IDataSet getDataSetAcuerdoLP() {
		IDataSet dataset = new TDataSet();
		dataset.create("TAcuerdoLP");
		dataset.fieldDef(new Field("oid_acuerdo_lp", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_tipo_acuerdo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_proveedor", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_proveedor", Field.STRING, 30));
		dataset.fieldDef(new Field("rs_proveedor", Field.STRING, 100));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
		return dataset;
	}

	private void cargarRegistroAcuerdoLP(IDataSet dataset,
			Integer oid_acuerdo_lp, TipoAcuerdo tipoAcuerdo,
			Proveedor proveedor, 
			Boolean activo,
			String descripcion)
			throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_acuerdo_lp", oid_acuerdo_lp);
		dataset.fieldValue("oid_tipo_acuerdo", tipoAcuerdo.getOIDInteger());
		dataset.fieldValue("oid_proveedor", proveedor.getOIDInteger());
		dataset.fieldValue("cod_proveedor", proveedor.getCodigo());
		dataset.fieldValue("rs_proveedor", proveedor.getRazonsocial());
		dataset.fieldValue("activo", activo);
		dataset.fieldValue("descripcion", descripcion);
	}

	private IDataSet getDataSetAcuerdoLPCondPago() {
		IDataSet dataset = new TDataSet();
		dataset.create("TAcuerdoLPCondPago");
		dataset.fieldDef(new Field("oid_acu_lp_dtos", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_acuerdo_lp", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_cond_compra", Field.INTEGER, 0));
		dataset.fieldDef(new Field("dto_1", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("dto_2", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("dto_3", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("dto_4", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("dto_5", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("en_cascada", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private IDataSet getDataSetDefEstrucLPDet() {
		IDataSet dataset = new TDataSet();
		dataset.create("TDefEstrucLPDet");
		dataset.fieldDef(new Field("oid_precio_clasif", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_acuerdo_lp", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_def_estruc_lp", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_clasif_art_1", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_clasif_art_1", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_clasif_art_1", Field.STRING, 100));
		dataset.fieldDef(new Field("oid_clasif_art_2", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_clasif_art_2", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_clasif_art_2", Field.STRING, 100));
		dataset.fieldDef(new Field("orden", Field.INTEGER, 0));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("oid_clasificador_1", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_clasificador_2", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cantidad", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("oid_um", Field.INTEGER, 0));
		dataset.fieldDef(new Field("precio", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("oid_moneda", Field.INTEGER, 0));

		return dataset;
	}

	private void cargarRegistroAcuerdoLPCondPago(IDataSet dataset,
			Integer oid_acu_lp_dtos, AcuerdoLP acueroLP,
			CondicionCompra condPago, Double dto_1, Double dto_2, Double dto_3,
			Double dto_4, Double dto_5, Boolean en_cascada, Boolean activo) {
		dataset.append();
		dataset.fieldValue("oid_acu_lp_dtos", oid_acu_lp_dtos);
		dataset.fieldValue("oid_acuerdo_lp", acueroLP.getOIDInteger());
		dataset.fieldValue("oid_cond_compra", condPago.getOIDInteger());
		dataset.fieldValue("dto_1", dto_1);
		dataset.fieldValue("dto_2", dto_2);
		dataset.fieldValue("dto_3", dto_3);
		dataset.fieldValue("dto_4", dto_4);
		dataset.fieldValue("dto_5", dto_5);
		dataset.fieldValue("en_cascada", en_cascada);
		dataset.fieldValue("activo", activo);
	}

	private IDataSet getDataSetAcuerdoLPDetalle() {
		IDataSet dataset = new TDataSet();
		dataset.create("TAcuerdoLPDetalle");
		dataset.fieldDef(new Field("oid_acu_lp_det", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_acuerdo_lp", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_producto", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_producto", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_producto", Field.STRING, 100));
		dataset.fieldDef(new Field("vigencia_desde", Field.DATE, 0));
		dataset.fieldDef(new Field("vigencia_hasta", Field.DATE, 0));
		dataset.fieldDef(new Field("cantidad", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("oid_um", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("oid_moneda", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("precio", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("comentario", Field.STRING, 255));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("cod_prod_prov", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_prod_prov", Field.STRING, 255));
		return dataset;
	}

	private void cargarRegistroAcuerdoLPDetalle(IDataSet dataset,
			Integer oid_acu_lp_det, AcuerdoLP acuerdoLP, Producto producto,
			java.util.Date vigencia_desde, java.util.Date vigencia_hasta,
			Double cantidad, UnidadMedida unidadMedida, Moneda moneda,
			Money precio, String comentario, Boolean activo,
			String codProdProv, String descProdProv) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_acu_lp_det", oid_acu_lp_det);
		dataset.fieldValue("oid_acuerdo_lp", acuerdoLP.getOIDInteger());
		if (producto != null) {
			dataset.fieldValue("oid_producto", producto.getOIDInteger());
			dataset.fieldValue("cod_producto", producto.getCodigo());
			dataset.fieldValue("desc_producto", producto.getDescripcion());
		} else {
			dataset.fieldValue("oid_producto", 0);
			dataset.fieldValue("cod_producto", "");
			dataset.fieldValue("desc_producto", "");
		}
		dataset.fieldValue("vigencia_desde", Fecha.getddmmyyyy(vigencia_desde));
		dataset.fieldValue("vigencia_hasta", Fecha.getddmmyyyy(vigencia_hasta));
		dataset.fieldValue("cantidad", cantidad);
		dataset.fieldValue("oid_um", unidadMedida.getOIDInteger());
		dataset.fieldValue("oid_moneda", moneda.getOIDInteger());
		dataset.fieldValue("precio", precio);
		if (comentario != null)
			dataset.fieldValue("comentario", comentario);
		else
			dataset.fieldValue("comentario", "");
		dataset.fieldValue("activo", activo);
		dataset.fieldValue("cod_prod_prov", codProdProv);
		if (descProdProv != null)
			dataset.fieldValue("desc_prod_prov", descProdProv);
		else
			dataset.fieldValue("desc_prod_prov", "");

	}

	private IDataSet getDataSetAcuerdoLPDetalleDto() {
		IDataSet dataset = new TDataSet();
		dataset.create("TAcuerdoLPDetalleDto");
		dataset.fieldDef(new Field("oid_acu_lp_det_dto", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_acu_lp_det", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_cond_compra", Field.INTEGER, 0));
		dataset.fieldDef(new Field("dto_1", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("dto_2", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("dto_3", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("dto_4", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("dto_5", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("tipo_dto", Field.STRING, 10));
		dataset.fieldDef(new Field("en_cascada", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private void cargarRegistroAcuerdoLPDetalleDto(IDataSet dataset,
			Integer oid_acu_lp_det_dto, AcuerdoLPDetalle acu_lp_det,
			CondicionCompra cond_compra, Double dto_1, Double dto_2,
			Double dto_3, Double dto_4, Double dto_5, String tipo_dto,
			Boolean en_cascada, Boolean activo) {
		dataset.append();
		dataset.fieldValue("oid_acu_lp_det_dto", oid_acu_lp_det_dto);
		dataset.fieldValue("oid_acu_lp_det", acu_lp_det.getOIDInteger());
		dataset.fieldValue("oid_cond_compra", cond_compra.getOIDInteger());
		dataset.fieldValue("dto_1", dto_1);
		dataset.fieldValue("dto_2", dto_2);
		dataset.fieldValue("dto_3", dto_3);
		dataset.fieldValue("dto_4", dto_4);
		dataset.fieldValue("dto_5", dto_5);
		dataset.fieldValue("tipo_dto", tipo_dto);
		dataset.fieldValue("en_cascada", en_cascada);
		dataset.fieldValue("activo", activo);
	}

	private IDataSet getDataSetAcuerdoLPDetalleDtoCant() {
		IDataSet dataset = new TDataSet();
		dataset.create("TAcuerdoLPDetalleDtoCant");
		dataset.fieldDef(new Field("oid_dto_cant", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_acu_lp_det_dto", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cant_desde", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("cant_hasta", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("dto_1", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("dto_2", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("dto_3", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("dto_4", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("dto_5", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("en_cascada", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private void cargarRegistroAcuerdoLPDetalleDtoCant(IDataSet dataset,
			Integer oid_dto_cant, AcuerdoLPDetalleDto acu_lp_det_dto,
			Double cant_desde, Double cant_hasta, Double dto_1, Double dto_2,
			Double dto_3, Double dto_4, Double dto_5, Boolean en_cascada,
			Boolean activo) {
		dataset.append();
		dataset.fieldValue("oid_dto_cant", oid_dto_cant);
		dataset
				.fieldValue("oid_acu_lp_det_dto", acu_lp_det_dto
						.getOIDInteger());
		dataset.fieldValue("cant_desde", cant_desde);
		dataset.fieldValue("cant_hasta", cant_hasta);
		dataset.fieldValue("dto_1", dto_1);
		dataset.fieldValue("dto_2", dto_2);
		dataset.fieldValue("dto_3", dto_3);
		dataset.fieldValue("dto_4", dto_4);
		dataset.fieldValue("dto_5", dto_5);
		dataset.fieldValue("en_cascada", en_cascada);
		dataset.fieldValue("activo", activo);
	}

	private void cargaraValoresPrecioCompraClasif(AcuerdoLP acuerdoLP)
			throws BaseException {
		Iterator iterPreciosCompra = acuerdoLP.getPreciosCompraPorClasifArt()
				.iterator();
		while (iterPreciosCompra.hasNext()) {
			PrecioCompraPorClasifArt precioCompra = (PrecioCompraPorClasifArt) iterPreciosCompra
					.next();
			if (precioCompra.isActivo()==false) continue;
			this.preciosCompraClasif.put(precioCompra.getValor_clasif_art()
					.getOIDInteger(), precioCompra);
		}

	}

}
