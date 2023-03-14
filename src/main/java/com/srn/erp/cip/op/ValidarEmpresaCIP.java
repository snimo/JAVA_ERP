package com.srn.erp.cip.op;

import com.srn.erp.cip.bm.EmpresaCIP;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class ValidarEmpresaCIP extends Operation {

	public ValidarEmpresaCIP() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		String empresa 		  = mapaDatos.getString("empresa");
		EmpresaCIP empresaCIP = EmpresaCIP.getEmpresaCIP(empresa, this.getSesion());
		IDataSet ds = this.getExisteEmpExacta();
		if (empresaCIP!=null)
			cargarRegistroExisteEmpExacta(ds,true);
		else
			cargarRegistroExisteEmpExacta(ds,false);
		writeCliente(ds);

	}

	private IDataSet getExisteEmpExacta() {
		IDataSet dataset = new TDataSet();
		dataset.create("TExisteEmpExacta");
		dataset.fieldDef(new Field("existe", Field.BOOLEAN, 0));
		return dataset;
	}

	private void cargarRegistroExisteEmpExacta(IDataSet dataset, boolean existe) throws BaseException {
		dataset.append();
		dataset.fieldValue("existe", existe);
	}
}
