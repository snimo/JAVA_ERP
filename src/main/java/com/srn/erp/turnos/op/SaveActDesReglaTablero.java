package com.srn.erp.turnos.op;

import com.srn.erp.turnos.bm.TableroTurnos;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class SaveActDesReglaTablero extends Operation {

	public SaveActDesReglaTablero() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		IDataSet ds = this.getDataSet();
		
		TableroTurnos tablero = TableroTurnos.findByOidProxy(mapaDatos
				.getInteger("oid_tablero"), this.getSesion());

		if (tablero == null) {
			writeCliente(ds);
			return;
		}
		
		boolean estado = false;
		
		if (mapaDatos.containsKey("ACTIVAR_DESACTIVAR")) {
			if (tablero.isReglamentoActivo()) 
				tablero.setReglamentoActivo(new Boolean(false));
			else 
				tablero.setReglamentoActivo(new Boolean(true));
		}
		
		if (tablero.isReglamentoActivo())
			estado = true;
		else
			estado = false;
			

		this.addTransaccion(tablero);
		
		
		cargarRegistro(ds, estado);
		writeCliente(ds);
		
		if (tablero.isLectorActivo())
			estado = true;
		else
			estado = false;
		
		IDataSet dsLector = this.getDataSetLector();
		cargarRegistro(dsLector, estado);
		writeCliente(dsLector);
		

	}

	private IDataSet getDataSet() {
		IDataSet dataset = new TDataSet();
		dataset.create("TEstadoReglaTablero");
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private void cargarRegistro(IDataSet dataset, boolean estado) {
		dataset.append();
		dataset.fieldValue("activo", estado);
	}
	
	private IDataSet getDataSetLector() {
		IDataSet dataset = new TDataSet();
		dataset.create("TLectorTarjeta");
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private void cargarRegistroLector(IDataSet dataset, boolean estado) {
		dataset.append();
		dataset.fieldValue("activo", estado);
	}
	

}
