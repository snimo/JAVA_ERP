package com.srn.erp.compras.op;

import java.util.Iterator;

import com.srn.erp.compras.bm.PrecioCompraPorClasifArt;
import com.srn.erp.stock.bm.ProductoProveedor;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveCocinaPreciosProvPorValClasif extends Operation {

	public SaveCocinaPreciosProvPorValClasif() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		procesarRegistros();
	}

	private void procesarRegistros() throws BaseException {

		Iterator iterPrecioCompra = PrecioCompraPorClasifArt.getAllActivos(this.getSesion()).iterator();
		while (iterPrecioCompra.hasNext()) {
			PrecioCompraPorClasifArt precioCompraPorClasifArt = (PrecioCompraPorClasifArt) iterPrecioCompra.next();

			// Grabar el producto
			ProductoProveedor productoProveedor = (ProductoProveedor) ProductoProveedor
					.getNew(ProductoProveedor.NICKNAME, this.getSesion());
			productoProveedor.setClasifProdGeneral(precioCompraPorClasifArt.getValor_clasif_art().getClasificador_entidad());
			productoProveedor.setValClasifProdGeneral(precioCompraPorClasifArt.getValor_clasif_art());
			productoProveedor.setProveedor(precioCompraPorClasifArt.getAcuerdo_lp().getProveedor());
			productoProveedor.setPrioridadCompra(1);
			productoProveedor.setCod_prod_prov(null);
			productoProveedor.setUmcpra(precioCompraPorClasifArt.getUnidad_medida());
			productoProveedor.setLote_minimo(null);
			productoProveedor.setMultiplo(null);
			productoProveedor.setLt_ent_dias(null);
			productoProveedor.setTipoAcuerdo(precioCompraPorClasifArt.getAcuerdo_lp().getTipo_acuerdo());
			productoProveedor.setMoneda(precioCompraPorClasifArt.getMoneda());
			productoProveedor.setCosto(precioCompraPorClasifArt.getPrecioUnitario());
			productoProveedor.setFecVig(precioCompraPorClasifArt.getFechaVigencia());
			productoProveedor.setActivo(true);
			productoProveedor.setPrecioCompraPorClasifArt(precioCompraPorClasifArt);
			productoProveedor.save();

		}

	}

}
