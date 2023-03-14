package com.srn.erp.legales.op;

import com.srn.erp.legales.bm.EmpresaJuicio;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveEmpresaJuicio extends Operation {

	public SaveEmpresaJuicio() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		IDataSet dataset = mapaDatos.getDataSet("TEmpresaJuicio");
		procesarRegistros(dataset);
	}

	private void procesarRegistros(IDataSet dataset) throws BaseException {
		dataset.first();
		while (!dataset.EOF()) {
			EmpresaJuicio empresajuicio = EmpresaJuicio.findByOid(dataset.getInteger("oid_emp_jui"), getSesion());
			empresajuicio.setOID(dataset.getInteger("oid_emp_jui"));
			empresajuicio.setCodigo(dataset.getString("codigo"));
			empresajuicio.setDescripcion(dataset.getString("descripcion"));
			empresajuicio.setActivo(dataset.getBoolean("activo"));
			addTransaccion(empresajuicio);
			dataset.next();
		}
	}

}
