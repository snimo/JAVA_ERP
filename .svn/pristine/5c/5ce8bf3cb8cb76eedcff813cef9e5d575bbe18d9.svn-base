package com.srn.erp.compras.op;

import java.util.Iterator;

import com.srn.erp.compras.bm.AcuerdoLP;
import com.srn.erp.compras.bm.PrecioCompraPorClasifArt;
import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.compras.bm.TipoAcuerdo;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.general.bm.ValorClasifEntProdGen;
import com.srn.erp.stock.bm.UnidadMedida;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveAcuerdoLPProdGral extends Operation {

	public SaveAcuerdoLPProdGral() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		IDataSet dataset = mapaDatos.getDataSet("TAcuerdoLP");
		procesarRegistros(dataset);
	}

	private void procesarRegistros(IDataSet dataset) throws BaseException {
		dataset.first();
		while (!dataset.EOF()) {
			AcuerdoLP acuerdolp = AcuerdoLP.findByOid(dataset.getInteger("oid_acuerdo_lp"), getSesion());
			acuerdolp.setTipo_acuerdo(TipoAcuerdo.findByOidProxy(dataset.getInteger("oid_tipo_acuerdo"), getSesion()));
			acuerdolp.setProveedor(Proveedor.findByOidProxy(dataset.getInteger("oid_proveedor"), getSesion()));
			acuerdolp.setActivo(dataset.getBoolean("activo"));
			acuerdolp.setDescripcion(dataset.getString("descripcion"));

			IDataSet dsPreciosCompraClasifArt = dataset.getDataSet("TDetProductos");
			dsPreciosCompraClasifArt.first();
			while (!dsPreciosCompraClasifArt.EOF()) {
				ValorClasifEntProdGen valorClasif = ValorClasifEntProdGen.findByOidProxy(dsPreciosCompraClasifArt
								.getInteger("oid_producto"), this.getSesion());
				
				// Verificar se si esta anulando un precio vigente a hoy
				if ((dsPreciosCompraClasifArt.getBoolean("actual_activo")==false) &&
						(dsPreciosCompraClasifArt.getInteger("actual_oid_precio_clasif")!=null) &&
						(dsPreciosCompraClasifArt.getInteger("actual_oid_precio_clasif").intValue()>0)) {
					PrecioCompraPorClasifArt precioCompra = 
						PrecioCompraPorClasifArt.findByOid(dsPreciosCompraClasifArt.getInteger("actual_oid_precio_clasif"), this.getSesion()); 
					precioCompra.delete();
					acuerdolp.addPrecioClasifArt(precioCompra);
				}
				
				// Anular todos los productos
				if (dsPreciosCompraClasifArt.getBoolean("activo")==false) {

					Iterator itersPreciosCompraABorrar =
						PrecioCompraPorClasifArt.getPreciosCompraPorClasifArt(
								acuerdolp.getOIDInteger(),
								valorClasif,
								this.getSesion()).iterator();
					
					while (itersPreciosCompraABorrar.hasNext()) {
						PrecioCompraPorClasifArt precioABorrar = 
							(PrecioCompraPorClasifArt) itersPreciosCompraABorrar.next();
						precioABorrar.delete();
						acuerdolp.addPrecioClasifArt(precioABorrar);
					}
					
					dsPreciosCompraClasifArt.next();	 
					continue;
				}
				
				if (((dsPreciosCompraClasifArt.getMoney("nueva_precio") != null) && (dsPreciosCompraClasifArt.getMoney("nueva_precio").doubleValue()>0)))
					acuerdolp.addPrecioClasifArt(valorClasif.getClasificador_entidad(), 
								valorClasif,
								dsPreciosCompraClasifArt.getMoney("nueva_cantidad"),
								UnidadMedida.findByOidProxy(
										dsPreciosCompraClasifArt.getInteger("nueva_oid_um"),
										this.getSesion()),
								dsPreciosCompraClasifArt.getMoney("nueva_precio"),
								Moneda.findByOidProxy(dsPreciosCompraClasifArt.getInteger("nueva_oid_moneda"), 
										this.getSesion()), 
								dsPreciosCompraClasifArt.getBoolean("nueva_activo"),
								dsPreciosCompraClasifArt.getDate("nueva_fecha")
								);

				dsPreciosCompraClasifArt.next();
			}

			addTransaccion(acuerdolp);
			dataset.next();
		}
	}

}
