package com.srn.erp.costos.op;

import java.util.Iterator;

import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.general.bm.IValorClasificadorEntidad;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.stock.bm.CostoProductoGral;
import com.srn.erp.stock.bm.ExtensionProdGen;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.bm.UnidadMedida;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerCostosProdGral extends Operation {

	private Moneda monedaDefCosto = null;
	private UnidadMedida umDefCosto = null;
	private java.util.Date fecha = null;

	private String nombreTable = null;

	public TraerCostosProdGral() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		// Manejo de tablas

		monedaDefCosto = Moneda.getMonedaDefaultCostoProducto(this.getSesion());
		umDefCosto = UnidadMedida.getUMDefaultCostoProducto(this.getSesion());
		fecha = mapaDatos.getDate("fecha");

		if (mapaDatos.containsKey("nombre_table"))
			nombreTable = mapaDatos.getString("nombre_table");

		IDataSet dsProductos = this.getDataSetProductos();

		// Obtener el clasificador de Presentacion
		ClasificadorEntidad clasifEnt = null;
		if ((mapaDatos.containsKey("oid_clasif_presen") && (mapaDatos
				.getInteger("oid_clasif_presen") != null))) {
			if (mapaDatos.getInteger("oid_clasif_presen").intValue() > 0)
				clasifEnt = ClasificadorEntidad.findByOidProxy(mapaDatos
						.getInteger("oid_clasif_presen"), this.getSesion());
		}

		Integer oidProducto = null;
		if ((mapaDatos.containsKey("oid_producto") && (mapaDatos
				.getInteger("oid_producto") != null)))
			oidProducto = mapaDatos.getInteger("oid_producto");

		// Codgo de Producto y Desc. de Producto
		String codigoProducto = null;
		if (mapaDatos.containsKey("cod_producto"))
			codigoProducto = mapaDatos.getString("cod_producto");

		String descProducto = null;
		if (mapaDatos.containsKey("desc_producto"))
			descProducto = mapaDatos.getString("desc_producto");

		HashTableDatos listaValClasif = new HashTableDatos();

		if (mapaDatos.containsKey("TClasificadorEntidad")) {
			IDataSet dsValClasif = mapaDatos.getDataSet("TClasificadorEntidad");
			dsValClasif.first();
			while (!dsValClasif.EOF()) {

				Integer oidClasifEnt = dsValClasif.getInteger("oid_clasif_ent");
				ClasificadorEntidad clasifEntidad = ClasificadorEntidad
						.findByOidProxy(oidClasifEnt, this.getSesion());

				if ((dsValClasif.getInteger("oid_valor_clasif") != null)
						&& (dsValClasif.getInteger("oid_valor_clasif")
								.intValue() > 0)) {
					ValorClasificadorEntidad valorClasifEnt = ValorClasificadorEntidad
							.findByOidProxy(dsValClasif
									.getInteger("oid_valor_clasif"), this
									.getSesion());
					listaValClasif.put(clasifEntidad, valorClasifEnt);
				}

				dsValClasif.next();
			}
		}

		HashTableDatos costosProductos = CostoProductoGral
				.getConsultaMasivaProductos(fecha,
						oidProducto, descProducto, null, codigoProducto, null,
						false, true, false, false, false, listaValClasif, this
								.getSesion());

		// Pasar la lista con clave por Producto
		HashTableDatos costosProductosPorKeyOidProd = new HashTableDatos();
		Iterator iterValCostosProd = costosProductos.values().iterator();
		while (iterValCostosProd.hasNext()) {
			CostoProductoGral costoProducto = (CostoProductoGral) iterValCostosProd
					.next();
			costosProductosPorKeyOidProd.put(costoProducto.getVal_clasif_ent()
					.getOIDInteger(), costoProducto);
		}

		Iterator iterProductos = ExtensionProdGen.getConsultaMasivaProductos(
				oidProducto, descProducto, null, codigoProducto, null, false,
				true, false, false, false, listaValClasif, this.getSesion())
				.iterator();

		while (iterProductos.hasNext()) {

			ExtensionProdGen producto = (ExtensionProdGen) iterProductos.next();
			CostoProductoGral costoProducto = (CostoProductoGral) costosProductosPorKeyOidProd
					.get(producto.getValor_clasif_ent().getOIDInteger());
			cargarProducto(dsProductos, producto, costoProducto,clasifEnt);
		}

		writeCliente(dsProductos);

	}

	private IDataSet getDataSetProductos() {
		IDataSet dataset = new TDataSet();

		if (nombreTable != null)
			dataset.create(nombreTable);
		else
			dataset.create("TProductosLP");

		dataset.fieldDef(new Field("oid_producto", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_producto", Field.INTEGER, 0));
		dataset.fieldDef(new Field("desc_producto", Field.STRING, 100));
		dataset.fieldDef(new Field("titulo", Field.STRING, 255));
		dataset.fieldDef(new Field("fec_ult_costo", Field.DATE, 255));
		dataset.fieldDef(new Field("oid_moneda_costo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cant_costo", Field.CURRENCY, 50));
		dataset.fieldDef(new Field("oid_um_costo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("costo", Field.CURRENCY, 50));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private void cargarProducto(IDataSet ds, ExtensionProdGen producto,
			CostoProductoGral costoProducto, ClasificadorEntidad clasificador)
			throws BaseException {

		ds.append();
		ds.fieldValue("oid_producto", producto.getValor_clasif_ent()
				.getOIDInteger());
		ds.fieldValue("cod_producto", producto.getValor_clasif_ent()
				.getCodigo());
		ds.fieldValue("desc_producto", producto.getValor_clasif_ent()
				.getDescripcion());

		IValorClasificadorEntidad valor = producto
				.getValorClasifEnt(clasificador);
		if (valor != null)
			ds.fieldValue("titulo", valor.getDescripcion() + " - "
					+ valor.getCodigo());
		else
			ds.fieldValue("titulo", "");

		Money costo = null;
		if (costoProducto != null) {
			ds.fieldValue("fec_ult_costo", costoProducto.getFec_ult_costo());
			ds.fieldValue("oid_moneda_costo", costoProducto.getMoneda()
					.getOIDInteger());
			ds.fieldValue("cant_costo", costoProducto.getCantidad());
			ds
					.fieldValue("oid_um_costo", costoProducto.getUm()
							.getOIDInteger());
			costo = costoProducto.getCosto();
			ds.fieldValue("costo", costo);
			ds.fieldValue("activo", new Boolean(true));
		} else {
			ds.fieldValue("fec_ult_costo", Fecha.FECHA_NULA());

			ds.fieldValue("oid_moneda_costo", this.monedaDefCosto
					.getOIDInteger());
			ds.fieldValue("cant_costo", new Money(1));
			if (producto.getUMCompra() != null)
				ds.fieldValue("oid_um_costo", producto.getUMCompra()
						.getOIDInteger());
			else
				ds.fieldValue("oid_um_costo", this.umDefCosto.getOIDInteger());
			costo = new Money(0);
			ds.fieldValue("costo", costo);
			ds.fieldValue("activo", new Boolean(true));
		}

	}

	public void corregirProdGralesSinExtension() throws BaseException {
		ClasificadorEntidad clasifProdGral = Producto
				.getClasifProductoGeneral(this.getSesion());
		Iterator iterValoresClasif = clasifProdGral.getValoresClasificador()
				.iterator();
		while (iterValoresClasif.hasNext()) {
			ValorClasificadorEntidad valClasifEnt = (ValorClasificadorEntidad) iterValoresClasif
					.next();
			ExtensionProdGen extProdgral = ExtensionProdGen
					.getExtensionProdGral(valClasifEnt, this.getSesion());
			if (extProdgral == null) {
				extProdgral = (ExtensionProdGen) ExtensionProdGen.getNew(
						ExtensionProdGen.NICKNAME, this.getSesion());
				extProdgral.setClasificador(clasifProdGral);
				extProdgral.setValor_clasif_ent(valClasifEnt);
				extProdgral.save();
			}

		}
	}

	@Override
	public void beforeExecute(MapDatos mapaDatos) throws BaseException {
		// TODO Auto-generated method stub
		super.beforeExecute(mapaDatos);

		corregirProdGralesSinExtension();
	}

}
