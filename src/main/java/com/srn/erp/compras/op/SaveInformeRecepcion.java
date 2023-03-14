package com.srn.erp.compras.op;

import com.srn.erp.compras.bm.InformeRecepcion;
import com.srn.erp.compras.bm.InformeRecepcionDet;
import com.srn.erp.compras.bm.OrdenDeCompraDet;
import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.contabilidad.bm.ComproConta;
import com.srn.erp.ctasAPagar.bm.ComproProveedor;
import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.general.bm.InformarComprobante;
import com.srn.erp.general.bm.LugarEmision;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.general.bm.Talonario;
import com.srn.erp.general.bm.TipoComprobante;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.bm.UnidadMedida;
import com.srn.erp.ventas.bm.RemitoDet;

import framework.applicarionServer.bm.Varios.ValorCotizacion;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveInformeRecepcion extends Operation {

	InformeRecepcion informeRecepcion = null;
	ComproCab comprobante = null;

	public SaveInformeRecepcion() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		IDataSet dataset = mapaDatos.getDataSet("TInformeRecepcion");
		IDataSet datasetCotiz = null;
		if (mapaDatos.containsKey("TCotizaciones"))
			datasetCotiz = mapaDatos.getDataSet("TCotizaciones");
		procesarInformeRecepcion(dataset, datasetCotiz);
	}

	private void procesarInformeRecepcion(IDataSet dataset, IDataSet dsCotiz) throws BaseException {
		int nroItem = 0;
		dataset.first();
		while (!dataset.EOF()) {
			informeRecepcion = InformeRecepcion.findByOid(dataset.getInteger("oid_inf_rec"), getSesion());

			if (dataset.getBoolean("activo").booleanValue() == false) {
				anularInformeRecepcion(informeRecepcion);
				dataset.next();
				continue;
			}

			// Set datos del comrobante
			informeRecepcion.setContabiliza(InformeRecepcion.getContabilizarInformeRecepcion(getSesion()));
			informeRecepcion.setTalonario(Talonario.findByOidProxy(dataset.getInteger("oid_talonario"), getSesion()));
			informeRecepcion.setTipoCompro(TipoComprobante.findByOidProxy(dataset.getInteger("oid_tc"), getSesion()));
			informeRecepcion.setLetra(dataset.getString("letra"));
			informeRecepcion.setLugarEmision(LugarEmision.findByOidProxy(dataset.getInteger("oid_lug_emi"), getSesion()));
			informeRecepcion.setNroext(dataset.getInteger("nro_ext"));
			informeRecepcion.setEmision(dataset.getDate("fec_emision"));
			informeRecepcion.setImputac(dataset.getDate("fec_emision"));
			informeRecepcion.setComentario(dataset.getString("comentario"));
			informeRecepcion.setReferencia(dataset.getString("referencia"));
			informeRecepcion.setTipo(dataset.getString("tipo"));
			informeRecepcion.addCotizacionesMonedas(cargarCotizaciones(dsCotiz));
			informeRecepcion.setTipoCambio(ComproConta.getTipoCambioContable(getSesion()));
			comprobante = informeRecepcion;

			// Por lo datos de la cabecera del Comprobante
			informeRecepcion.setProveedor(Proveedor.findByOidProxy(dataset.getInteger("oid_prov"), getSesion()));
			informeRecepcion.setRemito_prov(dataset.getString("remito_prov"));
			if ((dataset.getInteger("oid_cco_fact_prov") != null) && (dataset.getInteger("oid_cco_fact_prov").intValue() > 0))
				informeRecepcion.setComproProveedor(ComproProveedor.findByOidProxy(dataset.getInteger("oid_cco_fact_prov"), this
						.getSesion()));

			IDataSet dsInfRecDet = dataset.getDataSet("TInformeRecepcionDet");
			dsInfRecDet.first();
			while (!dsInfRecDet.EOF()) {
				InformeRecepcionDet infRecDet = InformeRecepcionDet.findByOid(dsInfRecDet.getInteger("oid_inf_rec_det"), getSesion());
				if ((dsInfRecDet.getDouble("cant_recep_us").doubleValue() == 0)
						&& (dsInfRecDet.getDouble("cant_recep_uc").doubleValue() == 0)) {
					dsInfRecDet.next();
					continue;
				}
				infRecDet.setNro_item(new Integer(++nroItem));
				infRecDet.setProducto(Producto.findByOidProxy(dsInfRecDet.getInteger("oid_producto"), getSesion()));
				infRecDet.setCant_recibida(dsInfRecDet.getDouble("cant_recep_us"));
				infRecDet.setUnidad_medida_recibido(UnidadMedida.findByOidProxy(dsInfRecDet.getInteger("oid_um_stk"), getSesion()));
				infRecDet.setCant_rec_en_us(dsInfRecDet.getDouble("cant_recep_us"));
				infRecDet.setUnidadMedidaStock(UnidadMedida.findByOidProxy(dsInfRecDet.getInteger("oid_um_stk"), getSesion()));
				infRecDet.setCant_rec_en_uc(dsInfRecDet.getDouble("cant_recep_uc"));
				infRecDet.setUnidadMedidaCompra(UnidadMedida.findByOidProxy(dsInfRecDet.getInteger("oid_um_cpra"), getSesion()));
				infRecDet.setComentario(dsInfRecDet.getString("comentario"));
				infRecDet.setOrdenDeCompraDet(OrdenDeCompraDet.findByOidProxy(dsInfRecDet.getInteger("oid_oc_det"), getSesion()));
				infRecDet.setRemitoDet(RemitoDet.findByOidProxy(dsInfRecDet.getInteger("oid_remito_det"), getSesion()));
				if (dsInfRecDet.getDouble("cant_recep_uc").doubleValue() > 0)
					infRecDet.setPendFact(new Boolean(true));
				informeRecepcion.addDetalleInfRec(infRecDet);
				dsInfRecDet.next();
			}

			addTransaccion(informeRecepcion);
			dataset.next();
		}
	}

	@Override
	public void beforeExecute(MapDatos mapaDatos) throws BaseException {
		// TODO Auto-generated method stub
		super.beforeExecute(mapaDatos);

		if (!mapaDatos.containsKey("TInformeRecepcion")) {
			throw new ExceptionValidation(null, "No llego la tabla cabecera del Informe de Recepción. Se cancela la grabación.");
		}

	}

	private void anularInformeRecepcion(InformeRecepcion informeRecepcion) throws BaseException {
		informeRecepcion.setForDelete();
		addTransaccion(informeRecepcion);
	}

	protected void afterSave() throws BaseException {

		if (informeRecepcion != null)
			if (informeRecepcion.getAnuladorInfRec() != null)
				comprobante = informeRecepcion.getAnuladorInfRec();

		if (comprobante != null) {
			InformarComprobante infoCompro = new InformarComprobante(comprobante.getOIDInteger(), comprobante.getDescripcion());
			writeCliente(infoCompro.getDataSetInfoCompro());
		}

	}

	private HashTableDatos cargarCotizaciones(IDataSet dsCotizaciones) throws BaseException {
		HashTableDatos listaCotizaciones = new HashTableDatos();
		dsCotizaciones.first();
		while (!dsCotizaciones.EOF()) {
			Moneda moneda = Moneda.findByOidProxy(dsCotizaciones.getInteger("oid_moneda"), getSesion());
			ValorCotizacion valorCotiz = dsCotizaciones.getCotizacion("cotizacion");
			listaCotizaciones.put(moneda, valorCotiz);
			dsCotizaciones.next();
		}
		return listaCotizaciones;
	}

}
