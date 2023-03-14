package com.srn.erp.legales.op;

import com.srn.erp.legales.bm.EmpresaJuicio;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerEmpresaJuicio extends Operation {

	public TraerEmpresaJuicio() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		EmpresaJuicio empresajuicio = null;
		if (mapaDatos.containsKey("oid")) {
			Integer oid = mapaDatos.getInteger("oid");
			empresajuicio = EmpresaJuicio.findByOid(oid, getSesion());
		} else {
			String codigo = mapaDatos.getString("codigo");
			empresajuicio = EmpresaJuicio.findByCodigo(codigo, getSesion());
		}

		IDataSet datasetEmpresaJuicio = getDataSetEmpresaJuicio();
		if (empresajuicio != null) {
			cargarRegistroEmpresaJuicio(datasetEmpresaJuicio, empresajuicio.getOIDInteger(), empresajuicio.getCodigo(), empresajuicio.getDescripcion(), empresajuicio.isActivo());
		}
		writeCliente(datasetEmpresaJuicio);
	}

	private IDataSet getDataSetEmpresaJuicio() {
		IDataSet dataset = new TDataSet();
		dataset.create("TEmpresaJuicio");
		dataset.fieldDef(new Field("oid_emp_jui", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 20));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private void cargarRegistroEmpresaJuicio(IDataSet dataset, Integer oid_emp_jui, String codigo, String descripcion, Boolean activo) {
		dataset.append();
		dataset.fieldValue("oid_emp_jui", oid_emp_jui);
		dataset.fieldValue("codigo", codigo);
		dataset.fieldValue("descripcion", descripcion);
		dataset.fieldValue("activo", activo);
	}
}
