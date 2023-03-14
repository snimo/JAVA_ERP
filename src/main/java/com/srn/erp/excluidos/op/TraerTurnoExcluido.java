package com.srn.erp.excluidos.op;

import com.srn.erp.excluidos.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Tablas.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.*;

public class TraerTurnoExcluido extends Operation {

	public TraerTurnoExcluido() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		TurnoExcluido turnoexcluido = null;
		if (mapaDatos.containsKey("oid")) {
			Integer oid = mapaDatos.getInteger("oid");
			turnoexcluido = TurnoExcluido.findByOid(oid, getSesion());
		} else {
			String codigo = mapaDatos.getString("codigo");
			turnoexcluido = TurnoExcluido.findByCodigo(codigo, getSesion());
		}

		IDataSet datasetTurnoExcluido = getDataSetTurnoExcluido();
		
		if (turnoexcluido != null) 
			cargarRegistroTurnoExcluido(datasetTurnoExcluido, turnoexcluido);
		
		writeCliente(datasetTurnoExcluido);
	}

	private IDataSet getDataSetTurnoExcluido() {
		IDataSet dataset = new TDataSet();
		dataset.create("TTurnoExcluido");
		dataset.fieldDef(new Field("oid_turno", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 20));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private void cargarRegistroTurnoExcluido(IDataSet dataset, TurnoExcluido turno) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_turno", turno.getOIDInteger());
		dataset.fieldValue("codigo", turno.getCodigo());
		dataset.fieldValue("descripcion", turno.getDescripcion());
		dataset.fieldValue("activo", turno.isActivo());
	}
}
