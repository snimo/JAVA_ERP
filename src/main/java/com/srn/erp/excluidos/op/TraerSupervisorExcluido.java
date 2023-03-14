package com.srn.erp.excluidos.op;

import com.srn.erp.excluidos.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Tablas.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.*;

public class TraerSupervisorExcluido extends Operation {

	public TraerSupervisorExcluido() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		SupervisorExcluido supervisorexcluido = null;
		if (mapaDatos.containsKey("oid")) {
			Integer oid = mapaDatos.getInteger("oid");
			supervisorexcluido = SupervisorExcluido.findByOid(oid, getSesion());
		} else {
			String codigo = mapaDatos.getString("codigo");
			supervisorexcluido = SupervisorExcluido.findByCodigo(codigo, getSesion());
		}

		IDataSet datasetSupervisorExcluido = getDataSetSupervisorExcluido();
		if (supervisorexcluido != null) {
			cargarRegistroSupervisorExcluido(datasetSupervisorExcluido, supervisorexcluido.getOIDInteger(), supervisorexcluido.getCodigo(),
					supervisorexcluido.getDescripcion(), supervisorexcluido.isActivo());
		}
		writeCliente(datasetSupervisorExcluido);
	}

	private IDataSet getDataSetSupervisorExcluido() {
		IDataSet dataset = new TDataSet();
		dataset.create("TSupervisorExcluido");
		dataset.fieldDef(new Field("oid_supervisor", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 20));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private void cargarRegistroSupervisorExcluido(IDataSet dataset, Integer oid_supervisor, String codigo, String descripcion,
			Boolean activo) {
		dataset.append();
		dataset.fieldValue("oid_supervisor", oid_supervisor);
		dataset.fieldValue("codigo", codigo);
		dataset.fieldValue("descripcion", descripcion);
		dataset.fieldValue("activo", activo);
	}
}
