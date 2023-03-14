package com.srn.erp.turnos.op;

import com.srn.erp.turnos.bm.TableroTurnos;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class SaveActDesLectorTarjeta extends Operation {

	public SaveActDesLectorTarjeta() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		TableroTurnos tablero = TableroTurnos.findByOidProxy(mapaDatos
				.getInteger("oid_tablero"), this.getSesion());

		
		boolean estado = false;
		
		if (mapaDatos.containsKey("ACTIVAR_DESACTIVAR")) {
			if (tablero.isLectorActivo()) 
				tablero.setLectorActivo(new Boolean(false));
			else 
				tablero.setLectorActivo(new Boolean(true));
		}
		
		if (tablero.isLectorActivo())
			estado = true;
		else
			estado = false;
			

		this.addTransaccion(tablero);
		
		IDataSet ds = this.getDataSet();
		cargarRegistro(ds, estado);
		writeCliente(ds);

	}

	private IDataSet getDataSet() {
		IDataSet dataset = new TDataSet();
		dataset.create("TLectorTarjeta");
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private void cargarRegistro(IDataSet dataset, boolean estado) {
		dataset.append();
		dataset.fieldValue("activo", estado);
	}

}
