package com.srn.erp.excluidos.op;

import com.srn.erp.excluidos.bm.SupervisorExcluido;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveSupervisorExcluido extends Operation {

	public SaveSupervisorExcluido() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		IDataSet dataset = mapaDatos.getDataSet("TSupervisorExcluido");
		procesarRegistros(dataset);
	}

	private void procesarRegistros(IDataSet dataset) throws BaseException {
		dataset.first();
		while (!dataset.EOF()) {
			SupervisorExcluido supervisorexcluido = SupervisorExcluido.findByOid(dataset.getInteger("oid_supervisor"), getSesion());
			supervisorexcluido.setOID(dataset.getInteger("oid_supervisor"));
			supervisorexcluido.setCodigo(dataset.getString("codigo"));
			supervisorexcluido.setDescripcion(dataset.getString("descripcion"));
			supervisorexcluido.setActivo(dataset.getBoolean("activo"));
			addTransaccion(supervisorexcluido);
			dataset.next();
		}
	}

}
