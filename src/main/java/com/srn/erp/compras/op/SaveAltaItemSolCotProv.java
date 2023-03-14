package com.srn.erp.compras.op;

import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.compras.bm.SolicitudCotizDetPorProv;
import com.srn.erp.compras.bm.SolicitudCotizProvCab;
import com.srn.erp.compras.bm.SolicitudCotizProvDet;
import com.srn.erp.compras.bm.SolicitudCotizProveedor;
import com.srn.erp.general.bm.InformarComprobante;
import com.srn.erp.general.bm.Talonario;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.bm.UnidadMedida;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveAltaItemSolCotProv extends Operation {

	SolicitudCotizProvCab solCotProvCab = null;
	SolicitudCotizProveedor solCotizProv1 = null;
	SolicitudCotizProveedor solCotizProv2 = null;
	SolicitudCotizProveedor solCotizProv3 = null;

	public SaveAltaItemSolCotProv() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		IDataSet dataset = mapaDatos.getDataSet("TInput");
		grabarSolCotProv(dataset);
	}

	private void grabarSolCotProv(IDataSet dataset) throws BaseException {
		dataset.first();
		while (!dataset.EOF()) {
			if (dataset.getString("usar").equals("NUEVA"))
				solCotProvCab = (SolicitudCotizProvCab) SolicitudCotizProvCab.getNew(SolicitudCotizProvCab.NICKNAME, this.getSesion());
			else
				solCotProvCab = SolicitudCotizProvCab.findByOid(dataset.getInteger("oid_sol_cot_prov"), this.getSesion());

			solCotProvCab.setContabiliza(false);

			Talonario talonario = SolicitudCotizProvCab.getSolCotProvCabAltaItem(this.getSesion());
			solCotProvCab.setTalonario(talonario);
			solCotProvCab.setTipoCompro(talonario.getTipo_comprobante());
			solCotProvCab.setLetra(talonario.getLetra());
			solCotProvCab.setLugarEmision(talonario.getLugar_emision());
			solCotProvCab.setNroext(talonario.getNro_actual());
			solCotProvCab.setEmision(dataset.getDate("fec_emision"));
			solCotProvCab.setObs_detalladas(dataset.getString("observacion"));
			solCotProvCab.setFec_tope_ent_sol(dataset.getDate("fec_cot_req"));
			solCotProvCab.setActivo(true);

			
			// Por el proveedor Nro. 1
			if ((dataset.getInteger("oid_proveedor_1")!=null) && 
				(dataset.getInteger("oid_proveedor_1").intValue()>0)) {
				Proveedor proveedor = Proveedor.findByOidProxy(dataset.getInteger("oid_proveedor_1"), this.getSesion());
				solCotizProv1 = 
					SolicitudCotizProveedor.getSolicitudCotizProveedor(solCotProvCab,proveedor,this.getSesion());
				if (solCotizProv1 == null)
					solCotizProv1 = (SolicitudCotizProveedor) SolicitudCotizProveedor.getNew(SolicitudCotizProveedor.NICKNAME, this.getSesion());
				solCotizProv1.setSolicitud_cotizacion(solCotProvCab);
				solCotizProv1.setProveedor(proveedor);
				solCotProvCab.addCotizacionProveedor(solCotizProv1);
			}
			
			// Por el proveedor Nro. 2
			if ((dataset.getInteger("oid_proveedor_2")!=null) && 
				(dataset.getInteger("oid_proveedor_2").intValue()>0)) {
				Proveedor proveedor = Proveedor.findByOidProxy(dataset.getInteger("oid_proveedor_2"), this.getSesion());
				solCotizProv2 = 
					SolicitudCotizProveedor.getSolicitudCotizProveedor(solCotProvCab,proveedor,this.getSesion());
				if (solCotizProv2 == null)
					solCotizProv2 = (SolicitudCotizProveedor) SolicitudCotizProveedor.getNew(SolicitudCotizProveedor.NICKNAME, this.getSesion());
				solCotizProv2.setSolicitud_cotizacion(solCotProvCab);
				solCotizProv2.setProveedor(proveedor);
				solCotProvCab.addCotizacionProveedor(solCotizProv2);
			}

			// Por el proveedor Nro. 3
			if ((dataset.getInteger("oid_proveedor_3")!=null) && 
				(dataset.getInteger("oid_proveedor_3").intValue()>0)) {
				Proveedor proveedor = Proveedor.findByOidProxy(dataset.getInteger("oid_proveedor_3"), this.getSesion());
				solCotizProv3 = 
					SolicitudCotizProveedor.getSolicitudCotizProveedor(solCotProvCab,proveedor,this.getSesion());
				if (solCotizProv3 == null)
					solCotizProv3 = (SolicitudCotizProveedor) SolicitudCotizProveedor.getNew(SolicitudCotizProveedor.NICKNAME, this.getSesion());
				solCotizProv3.setSolicitud_cotizacion(solCotProvCab);
				solCotizProv3.setProveedor(proveedor);
				solCotProvCab.addCotizacionProveedor(solCotizProv3);
			}
			
			
			// Recorrer los items
			int nroItem = SolicitudCotizProvDet.getUltimoNroItem(this.getSesion(), solCotProvCab);
			IDataSet dsItems = dataset.getDataSet("TItemsSolCotProv");
			dsItems.first();
			while (!dsItems.EOF()) {
				++nroItem;
				SolicitudCotizProvDet solCotizProvDet = (SolicitudCotizProvDet) SolicitudCotizProvDet.getNew(
						SolicitudCotizProvDet.NICKNAME, this.getSesion());
				solCotizProvDet.setSolicitud_cotiz_proveedor(solCotProvCab);
				solCotizProvDet.setNro_item(nroItem);
				solCotizProvDet.setProducto(Producto.findByOidProxy(dsItems.getInteger("oid_producto"), getSesion()));
				solCotizProvDet.setFec_entrega(dsItems.getDate("fec_requerido"));
				solCotizProvDet.setCant_requerida(dsItems.getDouble("cantidad"));
				solCotizProvDet.setUnidad_medida(UnidadMedida.findByOidProxy(dsItems.getInteger("oid_um"), getSesion()));
				solCotizProvDet.setObs_sol_cotiz(dsItems.getString("observacion"));
				solCotizProvDet.setAnulado(false);
				
				if (solCotizProv1!=null) {
					SolicitudCotizDetPorProv solCotizDetPorProv =
						(SolicitudCotizDetPorProv)SolicitudCotizDetPorProv.getNew(SolicitudCotizDetPorProv.NICKNAME, this.getSesion());
					solCotizDetPorProv.setSolicitud_cotiz_prov(solCotizProv1);
					solCotizDetPorProv.setSolicitud_cotiz_det(solCotizProvDet);
					solCotizDetPorProv.setCant_a_cotizar(dsItems.getDouble("cantidad"));
					solCotizDetPorProv.setOid_um_cpra(UnidadMedida.findByOidProxy(dsItems.getInteger("oid_um"), getSesion()));
					solCotizDetPorProv.setCotizar(true);
					solCotizDetPorProv.setObs_art_prov("");
					solCotizDetPorProv.setSolicitudCotizacion(solCotProvCab);
					solCotProvCab.addCotizacionProductoProveedor(solCotizDetPorProv);
				}
				
				if (solCotizProv2!=null) {
					SolicitudCotizDetPorProv solCotizDetPorProv =
						(SolicitudCotizDetPorProv)SolicitudCotizDetPorProv.getNew(SolicitudCotizDetPorProv.NICKNAME, this.getSesion());
					solCotizDetPorProv.setSolicitud_cotiz_prov(solCotizProv2);
					solCotizDetPorProv.setSolicitud_cotiz_det(solCotizProvDet);
					solCotizDetPorProv.setCant_a_cotizar(dsItems.getDouble("cantidad"));
					solCotizDetPorProv.setOid_um_cpra(UnidadMedida.findByOidProxy(dsItems.getInteger("oid_um"), getSesion()));
					solCotizDetPorProv.setCotizar(true);
					solCotizDetPorProv.setObs_art_prov("");
					solCotizDetPorProv.setSolicitudCotizacion(solCotProvCab);
					solCotProvCab.addCotizacionProductoProveedor(solCotizDetPorProv);
				}
				
				if (solCotizProv3!=null) {
					SolicitudCotizDetPorProv solCotizDetPorProv =
						(SolicitudCotizDetPorProv)SolicitudCotizDetPorProv.getNew(SolicitudCotizDetPorProv.NICKNAME, this.getSesion());
					solCotizDetPorProv.setSolicitud_cotiz_prov(solCotizProv3);
					solCotizDetPorProv.setSolicitud_cotiz_det(solCotizProvDet);
					solCotizDetPorProv.setCant_a_cotizar(dsItems.getDouble("cantidad"));
					solCotizDetPorProv.setOid_um_cpra(UnidadMedida.findByOidProxy(dsItems.getInteger("oid_um"), getSesion()));
					solCotizDetPorProv.setCotizar(true);
					solCotizDetPorProv.setObs_art_prov("");
					solCotizDetPorProv.setSolicitudCotizacion(solCotProvCab);
					solCotProvCab.addCotizacionProductoProveedor(solCotizDetPorProv);
				}
				
				solCotProvCab.addProductoACotizar(solCotizProvDet);
				dsItems.next();
			}
			
			// Por los Proveedores
			

			addTransaccion(solCotProvCab);

			dataset.next();
		}
	}

	protected void afterSave() throws BaseException {

		InformarComprobante infoCompro = 
			new InformarComprobante(solCotProvCab.getOIDInteger(), solCotProvCab.getDescripcion());

		writeCliente(infoCompro.getDataSetInfoCompro());

	}

}
