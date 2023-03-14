package com.srn.erp.reclutamiento.op;

import com.srn.erp.reclutamiento.bm.RecluBusqueda;
import com.srn.erp.reclutamiento.bm.RecluPuesto;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerRecluPuestoBusqueda extends Operation {

	public TraerRecluPuestoBusqueda() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		
		Integer oidBusqueda = mapaDatos.getInteger("oid_busqueda_act");
		RecluBusqueda busqueda = RecluBusqueda.findByOidProxy(oidBusqueda, this.getSesion());
		
		IDataSet ds = this.getDataSetPuestoBusqueda();
		cargarRegistro(ds, busqueda.getPuesto());
		writeCliente(ds);
		
	}

	private IDataSet getDataSetPuestoBusqueda() {
		IDataSet dataset = new TDataSet();
		dataset.create("TPuestoBusqueda");
		dataset.fieldDef(new Field("oid_puesto", Field.INTEGER, 0));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 255));
		return dataset;
	}

	private void cargarRegistro(IDataSet dataset, RecluPuesto puesto) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_puesto", puesto.getOIDInteger());
		dataset.fieldValue("descripcion", puesto.getDescripcion());
	}
}
