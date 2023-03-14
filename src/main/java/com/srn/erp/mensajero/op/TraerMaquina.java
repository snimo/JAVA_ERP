package com.srn.erp.mensajero.op;

import com.srn.erp.mensajero.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Tablas.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.*;

public class TraerMaquina extends Operation {

	public TraerMaquina() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		Maquina maquina = null;
		if (mapaDatos.containsKey("oid")) {
			Integer oid = mapaDatos.getInteger("oid");
			maquina = Maquina.findByOid(oid, getSesion());
		} else {
			String codigo = mapaDatos.getString("codigo");
			maquina = Maquina.findByCodigo(codigo, getSesion());
		}

		IDataSet datasetMaquina = getDataSetMaquina();
		if (maquina != null) {
			cargarRegistroMaquina(datasetMaquina, maquina);
		}
		writeCliente(datasetMaquina);
	}

	private IDataSet getDataSetMaquina() {
		IDataSet dataset = new TDataSet();
		dataset.create("TMaquina");
		dataset.fieldDef(new Field("oid_maquina", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nombre", Field.STRING, 100));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 255));
		dataset.fieldDef(new Field("es_ip_dinamica", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("ip", Field.STRING, 100));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private void cargarRegistroMaquina(IDataSet dataset, Maquina maquina) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_maquina", maquina.getOIDInteger());
		dataset.fieldValue("nombre", maquina.getNombre());
		dataset.fieldValue("descripcion", maquina.getDescripcion());
		dataset.fieldValue("es_ip_dinamica", maquina.isEs_ip_dinamica());
		dataset.fieldValue("ip", maquina.getIp());
		dataset.fieldValue("activo", maquina.isActiva());
	}
}
