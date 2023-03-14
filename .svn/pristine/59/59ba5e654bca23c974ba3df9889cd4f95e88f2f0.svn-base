package com.srn.erp.stock.op;

import com.srn.erp.stock.bm.MovStockTalonarioDeposito;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.bm.UbicacionDeposito;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class ValidarUbiDepoHabiMovi extends Operation {

	public ValidarUbiDepoHabiMovi() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		boolean ok = false;
		IDataSet dsValUbiDepo = getDataSetValidarUbiDepo();
		Producto producto = null;
		String cod_ubi_depo = mapaDatos.getString("cod_ubi_depo");
		MovStockTalonarioDeposito movStkTalDepo = MovStockTalonarioDeposito
				.findByOid(mapaDatos.getInteger("oid_mov_stk_tal"), getSesion());
		if (movStkTalDepo == null)
			throw new ExceptionValidation(null, "Movimiento inexistente");
		UbicacionDeposito ubicacionDeposito = movStkTalDepo.getDeposito()
				.getUbicacionDeposito(cod_ubi_depo);

		if (ubicacionDeposito == null)
			throw new ExceptionValidation(null,
					"Ubicación Depósito inexistente");

		if (mapaDatos.containsKey("oid_producto") && (mapaDatos.getInteger("oid_producto").intValue()!=0))
			producto = Producto.findByOid(mapaDatos.getInteger("oid_producto"),
					getSesion());

		if (producto != null)
			ok = movStkTalDepo
					.getUbiHabMovProducto(ubicacionDeposito, producto);
		else
			ok = movStkTalDepo.getUbicacionHabilitadaMov(ubicacionDeposito);

		cargarUbicacionDeposito(dsValUbiDepo, ubicacionDeposito);

		writeCliente(dsValUbiDepo);

	}

	private void cargarUbicacionDeposito(IDataSet ds,
			UbicacionDeposito ubicacionDeposito) throws BaseException {
		ds.append();
		ds.fieldValue("oid", ubicacionDeposito.getOIDInteger());
		ds.fieldValue("codigo", ubicacionDeposito.getCodigo());
		ds.fieldValue("descripcion", ubicacionDeposito.getDescripcion());
	}

	private IDataSet getDataSetValidarUbiDepo() {
		IDataSet dataset = new TDataSet();
		dataset.create("TValUbiDepoMov");
		dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 30));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
		return dataset;
	}

}
