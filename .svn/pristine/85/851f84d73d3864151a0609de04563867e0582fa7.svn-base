package com.srn.erp.mensajero.op;

import com.srn.erp.mensajero.bm.Maquina;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveMaquina extends Operation {

	public SaveMaquina() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		IDataSet dataset = mapaDatos.getDataSet("TMaquina");
		procesarRegistros(dataset);
	}

	private void procesarRegistros(IDataSet dataset) throws BaseException {
		dataset.first();
		while (!dataset.EOF()) {
			Maquina maquina = Maquina.findByOid(dataset.getInteger("oid_maquina"), getSesion());
			maquina.setOID(dataset.getInteger("oid_maquina"));
			maquina.setNombre(dataset.getString("nombre"));
			maquina.setDescripcion(dataset.getString("descripcion"));
			maquina.setEs_ip_dinamica(dataset.getBoolean("es_ip_dinamica"));
			maquina.setIp(dataset.getString("ip"));
			maquina.setActiva(dataset.getBoolean("activo"));
			addTransaccion(maquina);
			dataset.next();
		}
	}

}
