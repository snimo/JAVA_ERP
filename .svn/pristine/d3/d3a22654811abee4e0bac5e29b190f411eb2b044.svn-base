package com.srn.erp.conciTarjeta.op;

import java.util.Iterator;

import com.srn.erp.conciTarjeta.bm.EmpresaConciTar;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerEmpresasConciTar extends Operation {

	public TraerEmpresasConciTar() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		IDataSet datasetEmpresaConciTar = getDataSetEmpresaConciTar();
		
		Iterator iterEmpConciTar = 
			EmpresaConciTar.getAllActivos(this.getSesion()).iterator();
		while (iterEmpConciTar.hasNext()) {
			EmpresaConciTar empresaConciTar = (EmpresaConciTar) iterEmpConciTar.next();
			cargarRegistroEmpresaConciTar(datasetEmpresaConciTar,empresaConciTar);
		}
		
		writeCliente(datasetEmpresaConciTar);
	}

	private IDataSet getDataSetEmpresaConciTar() {
		IDataSet dataset = new TDataSet();
		dataset.create("TEmpresaConciTar");
		dataset.fieldDef(new Field("oid_empresa", Field.INTEGER, 0));
		dataset.fieldDef(new Field("razon_social", Field.STRING, 100));
		dataset.fieldDef(new Field("cuit", Field.STRING, 50));
		dataset.fieldDef(new Field("cod_comercio", Field.STRING, 50));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private void cargarRegistroEmpresaConciTar(IDataSet dataset, EmpresaConciTar empresaConciTar) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_empresa", empresaConciTar.getOIDInteger());
		dataset.fieldValue("razon_social", empresaConciTar.getRazon_social());
		dataset.fieldValue("cuit", empresaConciTar.getCuit());
		dataset.fieldValue("cod_comercio", empresaConciTar.getCodComercio());
		dataset.fieldValue("activo", empresaConciTar.isActivo());
	}
}
