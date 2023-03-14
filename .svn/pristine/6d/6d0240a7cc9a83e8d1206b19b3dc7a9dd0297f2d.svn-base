package com.srn.erp.rrhh.op;

import com.srn.erp.rrhh.bm.TipoObsLeg;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveTipoObsLeg extends Operation {

	public SaveTipoObsLeg() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		IDataSet dataset = mapaDatos.getDataSet("TTipoObsLeg");
		procesarRegistros(dataset);
	}

	private void procesarRegistros(IDataSet dataset) throws BaseException {
		dataset.first();
		while (!dataset.EOF()) {
			TipoObsLeg tipoobsleg = TipoObsLeg.findByOid(dataset.getInteger("oid_tipo_obs_leg"), getSesion());
			tipoobsleg.setOID(dataset.getInteger("oid_tipo_obs_leg"));
			tipoobsleg.setCodigo(dataset.getString("codigo"));
			tipoobsleg.setDescripcion(dataset.getString("descripcion"));
			tipoobsleg.setActivo(dataset.getBoolean("activo"));
			addTransaccion(tipoobsleg);
			dataset.next();
		}
	}

}
