package com.srn.erp.excluidos.op;

import com.srn.erp.excluidos.bm.EstadoExcluido;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class PuedeModifNroActaExc extends Operation {

	public PuedeModifNroActaExc() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		IDataSet ds = this.getDataSet();
		EstadoExcluido estado = EstadoExcluido.findByOid(mapaDatos.getInteger("oid_estado"),this.getSesion());
		if ((estado.isPermiteModifNro()!=null) && (estado.isPermiteModifNro().booleanValue()))
			cargarRegistro(ds, true);
		else
			cargarRegistro(ds, false);
		writeCliente(ds);
	}

	private IDataSet getDataSet() {
		IDataSet dataset = new TDataSet();
		dataset.create("TPuedeModifNroActaExc");
		dataset.fieldDef(new Field("puede", Field.BOOLEAN, 0));
		return dataset;
	}

	private void cargarRegistro(IDataSet dataset, Boolean puedeModif) throws BaseException {
		dataset.append();
		dataset.fieldValue("puede", puedeModif);
	}
}
