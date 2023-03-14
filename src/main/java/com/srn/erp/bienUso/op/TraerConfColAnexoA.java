package com.srn.erp.bienUso.op;

import java.util.Iterator;

import com.srn.erp.bienUso.bm.ConfColAnexoA;
import com.srn.erp.bienUso.bm.ConfColAnexoAMov;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerConfColAnexoA extends Operation {

	public TraerConfColAnexoA() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		IDataSet dsMovIniEjer = getDataSetMovAlIniEjer();
		IDataSet dsMovEjerAct = getDataSetMovEjerActual();
		
		IDataSet dsCabecera = getDataSetCab();
		cargarDataSetCab(dsCabecera);

		// Traer columnas al inicio del ejercicio
		IDataSet dsColumnasAlIniEjer = getDataSetConfColAnexoAAlIniEjer();
		Iterator iterConfColIniEjer = ConfColAnexoA.getConfColAnexoAAlIniEjer(
				getSesion()).iterator();
		while (iterConfColIniEjer.hasNext()) {
			ConfColAnexoA confColAnexoA = (ConfColAnexoA) iterConfColIniEjer
					.next();
			cargarColAlIniEjer(dsColumnasAlIniEjer, confColAnexoA);
			
			// Cargar los Movimientos
			Iterator iterConfMov = confColAnexoA.getConfColAnexoMovimientos().iterator();
			while (iterConfMov.hasNext()) {
				ConfColAnexoAMov confColAnexoAMov = (ConfColAnexoAMov) iterConfMov.next();
				cargarMovIniEjer(dsMovIniEjer,confColAnexoA,confColAnexoAMov);
			}
			
		}

		// Traer las columnas del Ejercicio
		IDataSet dsColumnasAlEjerActual = getDataSetConfColAnexoEjerActual();
		Iterator iterConfColAlEjerActual = ConfColAnexoA
				.getConfColAnexoAEnEjerActual(getSesion()).iterator();
		while (iterConfColAlEjerActual.hasNext()) {
			ConfColAnexoA confColAnexoA = (ConfColAnexoA) iterConfColAlEjerActual
					.next();
			cargarColEjerActual(dsColumnasAlEjerActual, confColAnexoA);
			
			// Cargar los Movimientos
			Iterator iterConfMov = confColAnexoA.getConfColAnexoMovimientos().iterator();
			while (iterConfMov.hasNext()) {
				ConfColAnexoAMov confColAnexoAMov = (ConfColAnexoAMov) iterConfMov.next();
				cargarMovEjerActual(dsMovEjerAct,confColAnexoA,confColAnexoAMov);
			}
			
			
		}

		writeCliente(dsCabecera);
		writeCliente(dsColumnasAlIniEjer);
		writeCliente(dsColumnasAlEjerActual);
		writeCliente(dsMovIniEjer);
		writeCliente(dsMovEjerAct);
	}

	private IDataSet getDataSetCab() {
		IDataSet dataset = new TDataSet();
		dataset.create("TCabecera");
		dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private void cargarDataSetCab(IDataSet dataset) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid", new Integer(1));
		dataset.fieldValue("activo", new Boolean(true));
	}

	private IDataSet getDataSetConfColAnexoAAlIniEjer() {
		IDataSet dataset = new TDataSet();
		dataset.create("TConfColAlIniEjer");
		dataset.fieldDef(new Field("oid_conf_anexo_a", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_padre", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 10));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
		dataset.fieldDef(new Field("nro_col", Field.INTEGER, 0));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private void cargarColAlIniEjer(IDataSet dataset, ConfColAnexoA confCol)
			throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_conf_anexo_a", confCol.getOIDInteger());
		dataset.fieldValue("oid_padre", new Integer(1));
		dataset.fieldValue("codigo", confCol.getCodigo());
		dataset.fieldValue("descripcion", confCol.getDescripcion());
		dataset.fieldValue("nro_col", confCol.getNro_col());
		dataset.fieldValue("activo", confCol.isActivo());
	}

	private IDataSet getDataSetConfColAnexoEjerActual() {
		IDataSet dataset = new TDataSet();
		dataset.create("TConfColAlEjerActual");
		dataset.fieldDef(new Field("oid_conf_anexo_a", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_padre", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 10));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
		dataset.fieldDef(new Field("nro_col", Field.INTEGER, 0));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private void cargarColEjerActual(IDataSet dataset, ConfColAnexoA confCol)
			throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_conf_anexo_a", confCol.getOIDInteger());
		dataset.fieldValue("oid_padre", new Integer(1));
		dataset.fieldValue("codigo", confCol.getCodigo());
		dataset.fieldValue("descripcion", confCol.getDescripcion());
		dataset.fieldValue("nro_col", confCol.getNro_col());
		dataset.fieldValue("activo", confCol.isActivo());
	}

	private IDataSet getDataSetMovAlIniEjer() {
		IDataSet dataset = new TDataSet();
		dataset.create("TConfMovAlIniEjer");
		dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_conf_anexo_a", Field.INTEGER, 0));
		dataset.fieldDef(new Field("tipo_mov", Field.STRING, 10));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private void cargarMovIniEjer(IDataSet dataset, ConfColAnexoA confColAnexoA, ConfColAnexoAMov confColMov)
			throws BaseException {
		dataset.append();
		dataset.fieldValue("oid", confColMov.getOIDInteger());
		dataset.fieldValue("oid_conf_anexo_a", confColAnexoA.getOIDInteger());
		dataset.fieldValue("tipo_mov", confColMov.getTipo_mov());
		dataset.fieldValue("activo",confColMov.isActivo());
	}

	private IDataSet getDataSetMovEjerActual() {
		IDataSet dataset = new TDataSet();
		dataset.create("TConfMovEjerActual");
		dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_conf_anexo_a", Field.INTEGER, 0));
		dataset.fieldDef(new Field("tipo_mov", Field.STRING, 10));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private void cargarMovEjerActual(IDataSet dataset, ConfColAnexoA confColAnexoA, ConfColAnexoAMov confColMov)
			throws BaseException {
		dataset.append();
		dataset.fieldValue("oid", confColMov.getOIDInteger());
		dataset.fieldValue("oid_conf_anexo_a", confColAnexoA.getOIDInteger());
		dataset.fieldValue("tipo_mov", confColMov.getTipo_mov());
		dataset.fieldValue("activo",confColMov.isActivo());
	}	
	
}
