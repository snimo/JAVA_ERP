package com.srn.erp.produccion.op;

import com.srn.erp.produccion.bm.RecetaCab;
import com.srn.erp.produccion.bm.RecetaDet;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.bm.UnidadMedida;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveReceta extends Operation {

	Producto producto = null;

	public SaveReceta() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		IDataSet dataset = mapaDatos.getDataSet("TRecetaCab");
		procesarRegistros(dataset);
	}

	private void procesarRegistros(IDataSet dataset) throws BaseException {
		dataset.first();
		while (!dataset.EOF()) {
			producto = Producto.findByOidProxy(dataset
					.getInteger("oid_producto"), getSesion());
			setRefreshObjNeg(producto.getOIDInteger());

			IDataSet dsAlternativa = dataset.getDataSet("TAlternativas");
			dsAlternativa.first();
			while (!dsAlternativa.EOF()) {
				String alternativa = dsAlternativa.getString("alternativa");

				RecetaCab recetaCab = null;
				if (dsAlternativa.getInteger("oid_rec_cab_ori").intValue() > 0)
					recetaCab = RecetaCab.findByOid(dsAlternativa
							.getInteger("oid_rec_cab_ori"), this.getSesion());
				else {
					recetaCab = RecetaCab.getRecetaByProductoAlternativa(
							producto, alternativa, this.getSesion());
					if (recetaCab == null)
						recetaCab = (RecetaCab) RecetaCab.getNew(
								RecetaCab.NICKNAME, this.getSesion());
				}

				recetaCab.setProduco(Producto.findByOidProxy(dataset
						.getInteger("oid_producto"), getSesion()));
				recetaCab.setBase_calculo(dsAlternativa.getDouble("cantidad"));
				recetaCab.setOid_um(UnidadMedida.findByOidProxy(dsAlternativa
						.getInteger("oid_um"), getSesion()));
				recetaCab.setAlternativa(alternativa);
				recetaCab.setActivo(dsAlternativa.getBoolean("activo"));
				if (!recetaCab.isActivo())
					recetaCab.delete();
				
				this.addTransaccion(recetaCab);

				IDataSet dsRecetaDet = dsAlternativa.getDataSet("TRecetaDet");
				dsRecetaDet.first();
				while (!dsRecetaDet.EOF()) {
					RecetaDet recetadet = RecetaDet.findByOid(dsRecetaDet
							.getInteger("oid_rec_det"), getSesion());
					recetadet.setReceta_cab(recetaCab);
					recetadet.setProducto(Producto.findByOidProxy(dsRecetaDet
							.getInteger("oid_producto"), getSesion()));
					recetadet.setOid_um(UnidadMedida.findByOidProxy(dsRecetaDet
							.getInteger("oid_um"), getSesion()));
					recetadet.setOrden(dsRecetaDet.getInteger("orden"));
					recetadet.setCantidad(dsRecetaDet.getDouble("cantidad"));
					recetadet.setActivo(dsRecetaDet.getBoolean("activo"));
					recetaCab.addRecetaDet(recetadet);

					dsRecetaDet.next();
				}

				dsAlternativa.next();
			}

			dataset.next();
		}
	}

}
