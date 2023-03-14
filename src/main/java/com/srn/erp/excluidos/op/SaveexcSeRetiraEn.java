package com.srn.erp.excluidos.op;

import com.srn.erp.excluidos.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.IDataSet;

public class SaveexcSeRetiraEn extends Operation {

	public SaveexcSeRetiraEn() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		IDataSet dataset = mapaDatos.getDataSet("TexcSeRetiraEn");
		procesarRegistros(dataset);
	}

	private void procesarRegistros(IDataSet dataset) throws BaseException {
		dataset.first();
		while (!dataset.EOF()) {
			SeRetiraEnExc excseretiraen = SeRetiraEnExc.findByOid(dataset.getInteger("oid_se_retira"), getSesion());
			excseretiraen.setOID(dataset.getInteger("oid_se_retira"));
			excseretiraen.setCodigo(dataset.getString("codigo"));
			excseretiraen.setDescripcion(dataset.getString("descripcion"));
			excseretiraen.setActivo(dataset.getBoolean("activo"));
			addTransaccion(excseretiraen);
			dataset.next();
		}
	}

}
