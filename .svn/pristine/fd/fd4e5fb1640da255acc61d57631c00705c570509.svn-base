package com.srn.erp.produccion.op;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.produccion.bm.AlternativaFabricacion;
import com.srn.erp.produccion.bm.OperAlterFab;
import com.srn.erp.produccion.bm.RecetaDet;
import com.srn.erp.stock.bm.Producto;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerAlternativaFabricacion extends Operation {

	private List listaRecetasEnviadas = new ArrayList();

	public TraerAlternativaFabricacion() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		Integer oid = mapaDatos.getInteger("oid");
		Producto producto = Producto.findByOid(oid, this.getSesion());

		IDataSet datasetProducto = this.getDataSetProducto();
		IDataSet datasetAlternativaFabricacion = getDataSetAlternativaFabricacion();
		IDataSet datasetRecetasDet = this.getDataSetDetRecProd();
		IDataSet datasetOperAltFab = this.getDataSetOperAlterFab();
		
		cargarRegistroProducto(datasetProducto, producto);

		Iterator iterAlterFab = AlternativaFabricacion.getAlternativasFabricacion(producto, this.getSesion()).iterator();
		while (iterAlterFab.hasNext()) {

			AlternativaFabricacion alternativaFab = (AlternativaFabricacion) iterAlterFab.next();

			cargarRegistroAlternativaFabricacion(datasetAlternativaFabricacion, alternativaFab);

			Iterator iterRecetasDet = alternativaFab.getReceta().getRecetasDet().iterator();
			while (iterRecetasDet.hasNext()) {
				RecetaDet recetaDet = (RecetaDet) iterRecetasDet.next();
				if (!recetaDet.isActivo())
					continue;

				if (listaRecetasEnviadas.contains(recetaDet.getOIDInteger()))
					continue;
				else
					listaRecetasEnviadas.add(recetaDet.getOIDInteger());

				cargarRegistroRecetaDet(datasetRecetasDet, recetaDet);
			}
			
			Iterator iterOperAltFab = 
				alternativaFab.getOperAltFab().iterator();
			while (iterOperAltFab.hasNext()) {
				OperAlterFab operAltFab = (OperAlterFab) iterOperAltFab.next();
				if (!operAltFab.isActivo()) continue;
				cargarRegistroOperAlterFab(datasetOperAltFab, operAltFab);
			}

		}

		writeCliente(datasetProducto);
		writeCliente(datasetAlternativaFabricacion);
		writeCliente(datasetRecetasDet);
		writeCliente(datasetOperAltFab);

	}

	private IDataSet getDataSetAlternativaFabricacion() {
		IDataSet dataset = new TDataSet();
		dataset.create("TAlternativaFabricacion");
		dataset.fieldDef(new Field("oid_alter_fabri", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_producto", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_producto", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_producto", Field.STRING, 255));
		dataset.fieldDef(new Field("oid_rec_cab", Field.INTEGER, 0));
		dataset.fieldDef(new Field("alternativa", Field.STRING, 100));
		dataset.fieldDef(new Field("alternativa_receta", Field.STRING, 100));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private IDataSet getDataSetProducto() {
		IDataSet dataset = new TDataSet();
		dataset.create("TProducto");
		dataset.fieldDef(new Field("oid_producto", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 50));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 255));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private void cargarRegistroAlternativaFabricacion(IDataSet dataset, AlternativaFabricacion alternativa) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_alter_fabri", alternativa.getOIDInteger());
		dataset.fieldValue("oid_producto", alternativa.getReceta().getProduco().getOIDInteger());
		dataset.fieldValue("cod_producto", alternativa.getReceta().getProduco().getCodigo());
		dataset.fieldValue("desc_producto", alternativa.getReceta().getProduco().getDescripcion());
		dataset.fieldValue("oid_rec_cab", alternativa.getReceta().getOIDInteger());
		dataset.fieldValue("alternativa", alternativa.getAlternativa());
		dataset.fieldValue("alternativa_receta", alternativa.getReceta().getAlternativa());
		dataset.fieldValue("activo", alternativa.isActivo());
	}

	private void cargarRegistroProducto(IDataSet dataset, Producto producto) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_producto", producto.getOIDInteger());
		dataset.fieldValue("codigo", producto.getCodigo());
		dataset.fieldValue("descripcion", producto.getDescripcion());
		dataset.fieldValue("activo", new Boolean(true));
	}

	private IDataSet getDataSetDetRecProd() {
		IDataSet dataset = new TDataSet();
		dataset.create("TRecetaDet");
		dataset.fieldDef(new Field("oid_rec_det", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_rec_cab", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_producto", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_producto", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_producto", Field.STRING, 100));
		dataset.fieldDef(new Field("cantidad", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("oid_um", Field.INTEGER, 0));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("orden", Field.INTEGER, 0));
		return dataset;
	}

	private void cargarRegistroRecetaDet(IDataSet dataset, RecetaDet recetaDet) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_rec_det", recetaDet.getOIDInteger());
		dataset.fieldValue("oid_rec_cab", recetaDet.getReceta_cab().getOIDInteger());
		dataset.fieldValue("oid_producto", recetaDet.getProducto().getOIDInteger());
		dataset.fieldValue("cod_producto", recetaDet.getProducto().getCodigo());
		dataset.fieldValue("desc_producto", recetaDet.getProducto().getDescripcion());
		dataset.fieldValue("cantidad", recetaDet.getCantidad());
		dataset.fieldValue("oid_um", recetaDet.getOid_um().getOIDInteger());
		dataset.fieldValue("activo", recetaDet.isActivo());
		dataset.fieldValue("orden", recetaDet.getOrden());
	}

	private IDataSet getDataSetOperAlterFab() {
		IDataSet dataset = new TDataSet();
		dataset.create("TOperAlterFab");
		dataset.fieldDef(new Field("oid_oper_fabri", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_alter_fabri", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_proceso", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_operacion", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_tipo_estacion", Field.INTEGER, 0));
		dataset.fieldDef(new Field("tiempo_std", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("comportamiento", Field.STRING, 20));
		dataset.fieldDef(new Field("oid_rel", Field.STRING, 50));
		dataset.fieldDef(new Field("oid_rel_padre", Field.STRING, 50));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("observacion", Field.STRING, 1000));
		dataset.fieldDef(new Field("cod_proceso", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_proceso", Field.STRING, 100));
		dataset.fieldDef(new Field("cod_operacion", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_operacion", Field.STRING, 100));
		dataset.fieldDef(new Field("cod_tipo_estacion", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_tipo_estacion", Field.STRING, 100));
		dataset.fieldDef(new Field("oid_um_tiempo", Field.INTEGER, 0));
		return dataset;
	}

	private void cargarRegistroOperAlterFab(IDataSet dataset, OperAlterFab operAlternativaFab) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_oper_fabri", operAlternativaFab.getOIDInteger());
		dataset.fieldValue("oid_alter_fabri", operAlternativaFab.getAlternativa_fabricacion().getOIDInteger());
		dataset.fieldValue("oid_proceso", operAlternativaFab.getProceso().getOIDInteger());
		dataset.fieldValue("oid_operacion", operAlternativaFab.getOperacion().getOIDInteger());
		dataset.fieldValue("oid_tipo_estacion", operAlternativaFab.getTipo_estacion().getOIDInteger());
		dataset.fieldValue("tiempo_std", operAlternativaFab.getTiempo_std());
		dataset.fieldValue("comportamiento", operAlternativaFab.getComportamiento());
		dataset.fieldValue("oid_rel", operAlternativaFab.getOid_rel());
		dataset.fieldValue("oid_rel_padre", operAlternativaFab.getOid_rel_padre());
		dataset.fieldValue("activo", operAlternativaFab.isActivo());
		dataset.fieldValue("observacion", operAlternativaFab.getObservacion());
		dataset.fieldValue("cod_proceso", operAlternativaFab.getProceso().getCodigo());
		dataset.fieldValue("desc_proceso", operAlternativaFab.getProceso().getDescripcion());
		dataset.fieldValue("cod_operacion", operAlternativaFab.getOperacion().getCodigo());
		dataset.fieldValue("desc_operacion", operAlternativaFab.getOperacion().getDescripcion());
		dataset.fieldValue("cod_tipo_estacion", operAlternativaFab.getTipo_estacion().getCodigo());
		dataset.fieldValue("desc_tipo_estacion", operAlternativaFab.getTipo_estacion().getDescripcion());
		dataset.fieldValue("oid_um_tiempo", operAlternativaFab.getUMTiempoProduccion().getOIDInteger());
		
		
	}

}
