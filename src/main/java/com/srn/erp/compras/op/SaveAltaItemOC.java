package com.srn.erp.compras.op;

import com.srn.erp.compras.bm.CondCompraImportacion;
import com.srn.erp.compras.bm.CondicionCompra;
import com.srn.erp.compras.bm.LugarEntrega;
import com.srn.erp.compras.bm.OrdenDeCompraCab;
import com.srn.erp.compras.bm.OrdenDeCompraDet;
import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.compras.bm.RequisicionDet;
import com.srn.erp.compras.bm.SectorCompra;
import com.srn.erp.compras.bm.ViaDespacho;
import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.general.bm.InformarComprobante;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.general.bm.Talonario;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.bm.UnidadMedida;
import com.srn.erp.ventas.bm.PedidoCab;
import com.srn.erp.ventas.bm.PedidoDet;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bm.Varios.Porcentaje;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class SaveAltaItemOC extends Operation {

	OrdenDeCompraCab ordendecompracab = null;
	
	public SaveAltaItemOC() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		
		IDataSet dataset = mapaDatos.getDataSet("TInput");
		String tipo = mapaDatos.getString("TIPO");
		procesarRegistros(dataset, tipo , mapaDatos);
	}

	private void procesarRegistros(IDataSet dataset, String tipo , MapDatos mapaDatos)
			throws BaseException {
		dataset.first();
		while (!dataset.EOF()) {

			Integer nroRenglon = 1;
			
			if (dataset.getString("usar").equals("NUEVA")) {
				ordendecompracab = (OrdenDeCompraCab) OrdenDeCompraCab.getNew(
						OrdenDeCompraCab.NICKNAME, this.getSesion());
				ordendecompracab.setOID(new Integer(-1));
				ordendecompracab.setActivo(new Boolean(true));

				// Set datos del comprobante
				ordendecompracab.setContabiliza(false);

				Talonario talonario = OrdenDeCompraCab.getTalonatioDefOC(this
						.getSesion());

				ordendecompracab.setTalonario(talonario);
				ordendecompracab.setTipoCompro(talonario.getTipo_comprobante());
				ordendecompracab.setLetra(talonario.getLetra());
				ordendecompracab.setLugarEmision(talonario.getLugar_emision());
				ordendecompracab.setEmision(Fecha.getFechaActual());
				ordendecompracab.setComentario(dataset.getString("comentario"));
				ordendecompracab.setCotizacion(dataset
						.getCotizacion("cotizacion"));

				// Set Datos de la Orden de Compra
				Proveedor proveedor = Proveedor.findByOidProxy(dataset
						.getInteger("oid_proveedor"), getSesion());
				ordendecompracab.setProveedor(proveedor);
				ordendecompracab.setAgrupaItemsImpresion(dataset
						.getBoolean("agrupa_items_impre"));
				ordendecompracab.setVia_despacho(ViaDespacho.findByOidProxy(
						dataset.getInteger("oid_via_despacho"), getSesion()));
				ordendecompracab
						.setCond_compra_importacion(CondCompraImportacion
								.findByOidProxy(dataset
										.getInteger("oid_cond_compra"),
										getSesion()));
				ordendecompracab.setDto_1_1(dataset.getDouble("dto_1"));
				ordendecompracab.setDto_1_2(dataset.getDouble("dto_2"));
				ordendecompracab.setDto_1_3(dataset.getDouble("dto_3"));
				ordendecompracab.setCond_pago_1(CondicionCompra.findByOidProxy(
						dataset.getInteger("oid_cond_pago"), getSesion()));
				ordendecompracab.setMoneda(Moneda.findByOidProxy(dataset
						.getInteger("oid_moneda"), getSesion()));
				ordendecompracab.setSectorCompra(SectorCompra.findByOidProxy(
						dataset.getInteger("oid_sector"), getSesion()));
				ordendecompracab.setTipo(OrdenDeCompraCab.TIPO_OC_MANUAL);
				ordendecompracab.setTomar_precio_de(dataset
						.getString("fuente_origen"));
				ordendecompracab.setDtoEnCasacada(dataset
						.getBoolean("en_cascada"));
				ordendecompracab.setPorcRecargo(dataset
						.getPorcentaje("porc_recar"));
				ordendecompracab.setLugarEntrega(LugarEntrega.findByOidProxy(
						dataset.getInteger("oid_lugar_entrega"), getSesion()));

			} else {
				ordendecompracab = OrdenDeCompraCab.findByOid(dataset
						.getInteger("oid_cco"), getSesion());
				ordendecompracab.setComentario(dataset.getString("comentario"));
				nroRenglon = new Integer(
						ordendecompracab.getMaxNroRenglon() + 1);
			}

			if (tipo.equals("ITEM"))
				agregarItemOC(ordendecompracab, dataset, nroRenglon);
			else if (tipo.equals("CANASTA")) {
				IDataSet dsItemsPedido = mapaDatos.getDataSet("TItemsPedido");
				dsItemsPedido.first();
				while (!dsItemsPedido.EOF()) {
					agregarItemCanastaOC(ordendecompracab, dsItemsPedido, nroRenglon);
					dsItemsPedido.next();
				}
				
			}

			dataset.next();
			addTransaccion(ordendecompracab);

		}
		
		
	}
	
	private void agregarItemCanastaOC(OrdenDeCompraCab ordendecompracab,
			IDataSet dataset, Integer nroRenglon) throws BaseException {

		// Agregar el Item de la Orden de Compra
		OrdenDeCompraDet ocDet = (OrdenDeCompraDet) OrdenDeCompraDet.getNew(
				OrdenDeCompraDet.NICKNAME, this.getSesion());
		ocDet.setOID(new Integer(-1));
		ocDet.setOrden_de_compra(ordendecompracab);
		Producto producto = Producto.findByOidProxy(dataset
				.getInteger("oid_producto"), getSesion());
		ocDet.setProducto(producto);
		ocDet.setDesc_adic_sku(dataset.getString("desc_adic_producto"));
		ocDet.setAnulado(new Boolean(false));
		UnidadMedida um = UnidadMedida.findByOidProxy(dataset
				.getInteger("oid_um"), getSesion());
		ocDet.setUnidad_compra(um);
		ocDet.setCant_comprada_uc(dataset.getDouble("cantidad"));
		ocDet.setMoneda(ordendecompracab.getMoneda());
		ocDet.setPrecio(dataset.getDouble("precio"));
		ocDet.setPrecio_neto_bonif(dataset.getDouble("precio"));
		ocDet.setTotal(dataset.getDouble("total"));
		ocDet.setNro_item(nroRenglon);
		ocDet.setComentario("");
		ocDet.setDto1(dataset.getDouble("dto_1"));
		ocDet.setDto2(dataset.getDouble("dto_2"));
		ocDet.setDto3(dataset.getDouble("dto_3"));
		ocDet.setEnCascada(dataset.getBoolean("en_cascada"));
		ocDet.setPorcRecar(new Porcentaje(0));
		ocDet.setTipoRecarDto("");
		ocDet.setPorcDtoRecar(new Porcentaje(0));
		ocDet.setFecRequerida(dataset.getDate("fec_requerida"));
		ocDet.setFuente_precio_sug(dataset.getString("fuente_origen"));

		if (producto == null)
			throw new ExceptionValidation(null, "Debe ingresar el producto");
		if (producto.isStockeable().booleanValue()) {
			if (producto.getUm_stk() == null)
				throw new ExceptionValidation(null, "El producto "
						+ producto.getCodigo() + " - "
						+ producto.getDescripcion()
						+ " no tiene definido una unidad de Stock Principal");
			ocDet.setUm_stock(producto.getUm_stk());
			ocDet.setCant_comprada_us(producto.getConvertirUM(
					ordendecompracab.getProveedor(),
					dataset.getDouble("cantidad"), um, producto.getUm_stk()).doubleValue());
		}

		if (dataset.getString("asociar_a").equals("COMPO_P")) {
			ocDet.setPedidoCab(PedidoCab.findByOidProxy(dataset
					.getInteger("oid_cco_referencia"), getSesion()));
			ocDet.setPedidoDet(null);
			ocDet.setRequisicionDet(null);
		} else if (dataset.getString("asociar_a").equals("ITEM_P")) {
			ocDet.setPedidoCab(PedidoCab.findByOidProxy(dataset
					.getInteger("oid_cco_referencia"), getSesion()));
			ocDet.setPedidoDet(PedidoDet.findByOidProxy(dataset
					.getInteger("oid_cco_referencia_det"), getSesion()));
			ocDet.setRequisicionDet(null);
		} else if (dataset.getString("asociar_a").equals("ITEM_R")) {
			ocDet.setPedidoCab(null);
			ocDet.setPedidoDet(null);
			ocDet.setRequisicionDet(RequisicionDet.findByOidProxy(dataset
					.getInteger("oid_cco_referencia_det"), getSesion()));
		}

		ordendecompracab.addDetalleOC(ocDet);

	}
	
	
	

	private void agregarItemOC(OrdenDeCompraCab ordendecompracab,
			IDataSet dataset, Integer nroRenglon) throws BaseException {

		// Agregar el Item de la Orden de Compra
		OrdenDeCompraDet ocDet = (OrdenDeCompraDet) OrdenDeCompraDet.getNew(
				OrdenDeCompraDet.NICKNAME, this.getSesion());
		ocDet.setOID(new Integer(-1));
		ocDet.setOrden_de_compra(ordendecompracab);
		Producto producto = Producto.findByOidProxy(dataset
				.getInteger("oid_producto"), getSesion());
		ocDet.setProducto(producto);
		ocDet.setDesc_adic_sku(dataset.getString("desc_adic_producto"));
		ocDet.setAnulado(new Boolean(false));
		UnidadMedida um = UnidadMedida.findByOidProxy(dataset
				.getInteger("oid_um"), getSesion());
		ocDet.setUnidad_compra(um);
		ocDet.setCant_comprada_uc(dataset.getDouble("cantidad"));
		ocDet.setMoneda(Moneda.findByOidProxy(dataset.getInteger("oid_moneda"),
				getSesion()));
		ocDet.setPrecio(dataset.getDouble("precio"));
		ocDet.setPrecio_neto_bonif(dataset.getDouble("precio_neto"));
		ocDet.setTotal(dataset.getDouble("total"));
		ocDet.setNro_item(nroRenglon);
		ocDet.setComentario("");
		ocDet.setDto1(dataset.getDouble("dto_1"));
		ocDet.setDto2(dataset.getDouble("dto_2"));
		ocDet.setDto3(dataset.getDouble("dto_3"));
		ocDet.setEnCascada(dataset.getBoolean("en_cascada"));
		ocDet.setPorcRecar(dataset.getPorcentaje("porc_recar"));
		ocDet.setTipoRecarDto(dataset.getString("tipo_recar_dto"));
		ocDet.setPorcDtoRecar(dataset.getPorcentaje("porc_dto_recar"));
		ocDet.setFecRequerida(dataset.getDate("fec_requerida"));

		if (producto == null)
			throw new ExceptionValidation(null, "Debe ingresar el producto");
		if (producto.isStockeable().booleanValue()) {
			if (producto.getUm_stk() == null)
				throw new ExceptionValidation(null, "El producto "
						+ producto.getCodigo() + " - "
						+ producto.getDescripcion()
						+ " no tiene definido una unidad de Stock Principal");
			ocDet.setUm_stock(producto.getUm_stk());
			ocDet.setCant_comprada_us(producto.getConvertirUM(
					ordendecompracab.getProveedor(),
					dataset.getDouble("cantidad"), um, producto.getUm_stk())
					.doubleValue());
		}

		if (dataset.getString("asociar_a").equals("COMPO_P")) {
			ocDet.setPedidoCab(PedidoCab.findByOidProxy(dataset
					.getInteger("oid_cco_referencia"), getSesion()));
			ocDet.setPedidoDet(null);
			ocDet.setRequisicionDet(null);
		} else if (dataset.getString("asociar_a").equals("ITEM_P")) {
			ocDet.setPedidoCab(PedidoCab.findByOidProxy(dataset
					.getInteger("oid_cco_referencia"), getSesion()));
			ocDet.setPedidoDet(PedidoDet.findByOidProxy(dataset
					.getInteger("oid_cco_referencia_det"), getSesion()));
			ocDet.setRequisicionDet(null);
		} else if (dataset.getString("asociar_a").equals("ITEM_R")) {
			ocDet.setPedidoCab(null);
			ocDet.setPedidoDet(null);
			ocDet.setRequisicionDet(RequisicionDet.findByOidProxy(dataset
					.getInteger("oid_cco_referencia_det"), getSesion()));
		}

		ordendecompracab.addDetalleOC(ocDet);

	}
	

	  private IDataSet getEstrucDataSetInfoCompro() {
	    IDataSet dataset = new TDataSet();
	    dataset.create("TInfoComprobanteGenerado");
	    dataset.fieldDef(new Field("oid_cco", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("desc_comprobante", Field.STRING, 100));
	    return dataset;
	  }

	  public void cargarInfoCompro(IDataSet dataset,OrdenDeCompraCab ordendecompracab) throws BaseException {
		    dataset.append();
		    dataset.fieldValue("oid_cco", ordendecompracab.getOIDInteger());
		    dataset.fieldValue("desc_comprobante", ordendecompracab.getDescripcion());
	  }

	@Override
	protected void afterSave() throws BaseException {
		// TODO Auto-generated method stub
		super.afterSave();
		
		if (ordendecompracab!=null) {
			InformarComprobante infoCompro = 
				new InformarComprobante(ordendecompracab.getOIDInteger(), 
					ordendecompracab.getDescripcion());
			writeCliente(infoCompro.getDataSetInfoCompro());
		}
		
	}
	  
	  
	  
	

}
