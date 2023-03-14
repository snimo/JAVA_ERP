package com.srn.erp.compras.op;

import java.util.Iterator;

import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.compras.bm.SolicitudCotizDetPorProv;
import com.srn.erp.compras.bm.SolicitudCotizProvCab;
import com.srn.erp.compras.bm.SolicitudCotizProvDet;
import com.srn.erp.compras.bm.SolicitudCotizProveedor;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.bm.UnidadMedida;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerSolicitudCotizProvCab extends Operation {

	public TraerSolicitudCotizProvCab() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		SolicitudCotizProvCab solicitudcotizprovcab = null;
		if (mapaDatos.containsKey("oid")) {
			Integer oid = mapaDatos.getInteger("oid");
			solicitudcotizprovcab = SolicitudCotizProvCab.findByOid(oid,
					getSesion());
		}

		IDataSet datasetSolicitudCotizProvCab = getDataSetSolicitudCotizProvCab();
		IDataSet datasetSolicitudCotizProveedor = getDataSetSolicitudCotizProveedor();
		IDataSet datasetSolicitudCotizProductos = getDataSetSolicitudCotizProvDet();
		IDataSet datasetSolicitudCotizPorPorv = getDataSetSolicitudCotizDetPorProv();

		if (solicitudcotizprovcab != null) {

			cargarRegistroSolicitudCotizProvCab(datasetSolicitudCotizProvCab,
					solicitudcotizprovcab);

			// Proveedores Invitados a Cotizar
			Iterator iterSolCotizProv = solicitudcotizprovcab
					.getCotizacionesProveedores().iterator();
			while (iterSolCotizProv.hasNext()) {
				SolicitudCotizProveedor solicitudCotizProv = (SolicitudCotizProveedor) iterSolCotizProv
						.next();
				cargarRegistroSolicitudCotizProveedor(
						datasetSolicitudCotizProveedor, solicitudCotizProv
								.getOIDInteger(), solicitudcotizprovcab,
						solicitudCotizProv.getProveedor(), solicitudCotizProv
								.isImpresa(), solicitudCotizProv
								.getUsuario_impresion(), solicitudCotizProv
								.getFec_impresion(), solicitudCotizProv
								.getFec_envio_sol(), solicitudCotizProv
								.isEnviada(), solicitudCotizProv
								.isConf_recep_sol(), solicitudCotizProv
								.getFec_recep_conf_sol(), solicitudCotizProv
								.isProv_ent_sol(), solicitudCotizProv
								.getFec_rec_sol_cotiz(), solicitudCotizProv
								.isPresu_recibido(), solicitudCotizProv
								.getFec_presu_recibido());
			}

			// Productos a Cotizar
			Iterator iterProductosACotizar = solicitudcotizprovcab
					.getProductosACotizar().iterator();
			while (iterProductosACotizar.hasNext()) {
				SolicitudCotizProvDet solicitudCotizProvDet = (SolicitudCotizProvDet) iterProductosACotizar
						.next();
				cargarRegistroSolicitudCotizProvDet(
						datasetSolicitudCotizProductos, solicitudCotizProvDet
								.getOIDInteger(), solicitudcotizprovcab,
						solicitudCotizProvDet.getNro_item(),
						solicitudCotizProvDet.getProducto(),
						solicitudCotizProvDet.getDesc_adic_sku(),
						solicitudCotizProvDet.getFec_entrega(),
						solicitudCotizProvDet.getCant_requerida(),
						solicitudCotizProvDet.getUnidad_medida(),
						solicitudCotizProvDet.getObs_sol_cotiz(),
						solicitudCotizProvDet.isAnulado());
			}
			
			// Detalles de Cotizaciones por Proveedores
			Iterator iterProdCotizProv = solicitudcotizprovcab.getProductosCotizProveedores().iterator();
			while (iterProdCotizProv.hasNext()) {
				SolicitudCotizDetPorProv solCotizDetPorProv = (SolicitudCotizDetPorProv) iterProdCotizProv.next();
				cargarRegistroSolicitudCotizDetPorProv(datasetSolicitudCotizPorPorv,solCotizDetPorProv.getOIDInteger(),
						solCotizDetPorProv.getSolicitudCotizacion(),solCotizDetPorProv.getSolicitud_cotiz_prov(),solCotizDetPorProv.getSolicitud_cotiz_det(),
						solCotizDetPorProv.getCant_a_cotizar(),solCotizDetPorProv.getOid_um_cpra(),solCotizDetPorProv.isCotizar(),
						solCotizDetPorProv.getObs_art_prov());
			}
			

		}
		writeCliente(datasetSolicitudCotizProvCab);
		writeCliente(datasetSolicitudCotizProveedor);
		writeCliente(datasetSolicitudCotizProductos);
		writeCliente(datasetSolicitudCotizPorPorv);
	}

	private IDataSet getDataSetSolicitudCotizProvCab() {
		IDataSet dataset = new TDataSet();
		dataset.create("TSolicitudCotizProvCab");
		dataset.fieldDef(new Field("oid_talonario",Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_tc",Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_tc",Field.STRING, 20));
		dataset.fieldDef(new Field("letra",Field.STRING, 1));
		dataset.fieldDef(new Field("oid_lug_emi",Field.INTEGER, 0));
		dataset.fieldDef(new Field("lug_emi",Field.INTEGER, 0));
		dataset.fieldDef(new Field("nro_ext",Field.INTEGER, 0));
		dataset.fieldDef(new Field("fec_emision",Field.DATE, 0));
		dataset.fieldDef(new Field("comentario",Field.STRING, 255));
		dataset.fieldDef(new Field("oid_cco_sol_cotiz", Field.INTEGER, 0));
		dataset.fieldDef(new Field("fec_tope_ent_sol", Field.DATE, 0));
		dataset.fieldDef(new Field("obs_detalladas", Field.STRING, 5000));
		dataset.fieldDef(new Field("activo",Field.BOOLEAN, 0));
		return dataset;
	}

	private void cargarRegistroSolicitudCotizProvCab(IDataSet dataset,
			SolicitudCotizProvCab solCotizProvCab) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_talonario",solCotizProvCab.getTalonario().getOIDInteger());
		dataset.fieldValue("oid_tc",solCotizProvCab.getTipoCompro().getOIDInteger());
		dataset.fieldValue("cod_tc",solCotizProvCab.getTipoCompro().getCodigo());
		dataset.fieldValue("letra",solCotizProvCab.getLetra());
		dataset.fieldValue("oid_lug_emi",solCotizProvCab.getLugarEmision().getOIDInteger());
		dataset.fieldValue("lug_emi",solCotizProvCab.getLugarEmision().getLugemi());
		dataset.fieldValue("nro_ext",solCotizProvCab.getNroExt());
		dataset.fieldValue("fec_emision",Fecha.getddmmyyyy(solCotizProvCab.getEmision()));
		dataset.fieldValue("comentario",solCotizProvCab.getComentario());	
		dataset.fieldValue("oid_cco_sol_cotiz",solCotizProvCab.getOIDInteger());
		dataset.fieldValue("fec_tope_ent_sol", Fecha.getddmmyyyy(solCotizProvCab.getFec_tope_ent_sol()));
		dataset.fieldValue("obs_detalladas", solCotizProvCab.getObs_detalladas());
		dataset.fieldValue("activo",solCotizProvCab.isActivo());
	}

	private IDataSet getDataSetSolicitudCotizProveedor() {
		IDataSet dataset = new TDataSet();
		dataset.create("TSolicitudCotizProveedor");
		dataset.fieldDef(new Field("oid_sol_cotiz_prov", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_cco_sol_cotiz", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_proveedor", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_proveedor", Field.STRING, 50));
		dataset.fieldDef(new Field("rs_proveedor", Field.STRING, 100));
		dataset.fieldDef(new Field("impresa", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("oid_usu_imp", Field.INTEGER, 0));
		dataset.fieldDef(new Field("fec_impresion", Field.DATE, 0));
		dataset.fieldDef(new Field("fec_envio_sol", Field.DATE, 0));
		dataset.fieldDef(new Field("enviada", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("conf_recep_sol", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("fec_recep_conf_sol", Field.DATE, 0));
		dataset.fieldDef(new Field("prov_ent_sol", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("fec_rec_sol_cotiz", Field.DATE, 0));
		dataset.fieldDef(new Field("presu_recibido", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("fec_presu_recibido", Field.DATE, 0));
		return dataset;
	}

	private void cargarRegistroSolicitudCotizProveedor(IDataSet dataset,
			Integer oid_sol_cotiz_prov, SolicitudCotizProvCab sol_cotiz,
			Proveedor proveedor, Boolean impresa, Usuario usu_imp,
			java.util.Date fec_impresion, java.util.Date fec_envio_sol,
			Boolean enviada, Boolean conf_recep_sol,
			java.util.Date fec_recep_conf_sol, Boolean prov_ent_sol,
			java.util.Date fec_rec_sol_cotiz, Boolean presu_recibido,
			java.util.Date fec_presu_recibido) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_sol_cotiz_prov", oid_sol_cotiz_prov);
		dataset.fieldValue("oid_cco_sol_cotiz", sol_cotiz.getOIDInteger());
		dataset.fieldValue("oid_proveedor", proveedor.getOIDInteger());
		dataset.fieldValue("cod_proveedor", proveedor.getCodigo());
		dataset.fieldValue("rs_proveedor", proveedor.getRazonsocial());
		dataset.fieldValue("impresa", impresa);
		if (usu_imp != null)
			dataset.fieldValue("oid_usu_imp", usu_imp.getOIDInteger());
		else
			dataset.fieldValue("oid_usu_imp", new Integer(0));
		if (fec_impresion != null)
			dataset.fieldValue("fec_impresion",Fecha.getddmmyyyy(fec_impresion));
		else
			dataset.fieldValue("fec_impresion",Fecha.FECHA_NULA());
		if (fec_envio_sol != null)
			dataset.fieldValue("fec_envio_sol",Fecha.getddmmyyyy(fec_envio_sol));
		else
			dataset.fieldValue("fec_envio_sol", Fecha.FECHA_NULA());
		dataset.fieldValue("enviada", enviada);
		dataset.fieldValue("conf_recep_sol", conf_recep_sol);
		if (fec_recep_conf_sol != null)
			dataset.fieldValue("fec_recep_conf_sol", Fecha.getddmmyyyy(fec_recep_conf_sol));
		else
			dataset.fieldValue("fec_recep_conf_sol", Fecha.FECHA_NULA());
		dataset.fieldValue("prov_ent_sol", prov_ent_sol);
		if (fec_rec_sol_cotiz != null)
			dataset.fieldValue("fec_rec_sol_cotiz", fec_rec_sol_cotiz);
		else
			dataset.fieldValue("fec_rec_sol_cotiz", Fecha.FECHA_NULA());
		dataset.fieldValue("presu_recibido", presu_recibido);
		if (fec_presu_recibido != null)
			dataset.fieldValue("fec_presu_recibido",Fecha.getddmmyyyy(fec_presu_recibido));
		else
			dataset.fieldValue("fec_presu_recibido", Fecha.FECHA_NULA());

	}

	private IDataSet getDataSetSolicitudCotizProvDet() {
		IDataSet dataset = new TDataSet();
		dataset.create("TSolicitudCotizProvDet");
		dataset.fieldDef(new Field("oid_sol_cotiz_det", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_cco_sol_cotiz", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nro_item", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_producto", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_producto", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_producto", Field.STRING, 100));
		dataset.fieldDef(new Field("desc_adic_sku", Field.STRING, 255));
		dataset.fieldDef(new Field("fec_ent", Field.DATE, 0));
		dataset.fieldDef(new Field("cant_requerida", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("oid_um", Field.INTEGER, 0));
		dataset.fieldDef(new Field("obs_sol_cotiz", Field.MEMO, 0));
		dataset.fieldDef(new Field("anulado", Field.BOOLEAN, 0));
		return dataset;
	}

	private void cargarRegistroSolicitudCotizProvDet(IDataSet dataset,
			Integer oid_sol_cotiz_det, SolicitudCotizProvCab sol_cotiz,
			Integer nro_item, Producto producto, String desc_adic_sku,
			java.util.Date fec_ent, Double cant_requerida, UnidadMedida uniMed,
			String obs_sol_cotiz, Boolean anulado) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_sol_cotiz_det", oid_sol_cotiz_det);
		dataset.fieldValue("oid_cco_sol_cotiz", sol_cotiz.getOIDInteger());
		dataset.fieldValue("nro_item", nro_item);
		dataset.fieldValue("oid_producto", producto.getOIDInteger());
		dataset.fieldValue("cod_producto", producto.getCodigo());
		dataset.fieldValue("desc_producto", producto.getDescripcion());
		if (desc_adic_sku!=null)
		  dataset.fieldValue("desc_adic_sku", desc_adic_sku);
		else
		  dataset.fieldValue("desc_adic_sku", "");
		dataset.fieldValue("fec_ent",Fecha.getddmmyyyy(fec_ent));
		dataset.fieldValue("cant_requerida", cant_requerida);
		dataset.fieldValue("oid_um", uniMed.getOIDInteger());
		if (obs_sol_cotiz!=null)
		  dataset.fieldValue("obs_sol_cotiz", obs_sol_cotiz);
		else
		  dataset.fieldValue("obs_sol_cotiz", "");
		dataset.fieldValue("anulado", anulado);
	}

	private IDataSet getDataSetSolicitudCotizDetPorProv() {
		IDataSet dataset = new TDataSet();
		dataset.create("TSolicitudCotizDetPorProv");
		dataset.fieldDef(new Field("oid_cotiz_det_prov", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_cco_sol_cotiz", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_sol_cotiz_prov", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_sol_cotiz_det", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cant_a_cotizar", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("oid_um_cpra", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cotizar", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("obs_art_prov", Field.MEMO, 0));
		return dataset;
	}

	private void cargarRegistroSolicitudCotizDetPorProv(IDataSet dataset,
			Integer oid_cotiz_det_prov,
			SolicitudCotizProvCab solicitudCotizacion,
			SolicitudCotizProveedor sol_cotiz_prov,
			SolicitudCotizProvDet sol_cotiz_det, Double cant_a_cotizar,
			UnidadMedida um_cpra, Boolean cotizar, String obs_art_prov) {
		dataset.append();
		dataset.fieldValue("oid_cotiz_det_prov", oid_cotiz_det_prov);
		dataset.fieldValue("oid_cco_sol_cotiz", solicitudCotizacion.getOIDInteger());
		dataset.fieldValue("oid_sol_cotiz_prov", sol_cotiz_prov.getOIDInteger());
		dataset.fieldValue("oid_sol_cotiz_det", sol_cotiz_det.getOIDInteger());
		dataset.fieldValue("cant_a_cotizar", cant_a_cotizar);
		dataset.fieldValue("oid_um_cpra", um_cpra.getOIDInteger());
		dataset.fieldValue("cotizar", cotizar);
		if (obs_art_prov!=null)
		  dataset.fieldValue("obs_art_prov", obs_art_prov);
		else
		  dataset.fieldValue("obs_art_prov", "");
			
	}

}
