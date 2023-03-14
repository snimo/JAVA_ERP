package com.srn.erp.reclutamiento.op;

import com.srn.erp.reclutamiento.bm.RecluBusqueda;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerRecluEstaBusqAbierta extends Operation {

	public TraerRecluEstaBusqAbierta() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		Integer oidBusqueda = mapaDatos.getInteger("oid_busqueda");
		RecluBusqueda busqueda = RecluBusqueda.findByOid(oidBusqueda, this.getSesion());
		IDataSet dsBusqActiva = this.getDataSetEstaBusqAbierta();
		cargarRegistroBusqAbierta(dsBusqActiva, busqueda.getEstado_busqueda().equals(RecluBusqueda.getEstadoBusqAbierta()));
		writeCliente(dsBusqActiva);
	}

	private IDataSet getDataSetEstaBusqAbierta() {
		IDataSet dataset = new TDataSet();
		dataset.create("TEstaBusquedaAbierta");
		dataset.fieldDef(new Field("abierta", Field.BOOLEAN, 0));
		return dataset;
	}

	private void cargarRegistroBusqAbierta(IDataSet dataset, boolean abierta) throws BaseException {
		dataset.append();
		dataset.fieldValue("abierta", abierta);
	}

}
