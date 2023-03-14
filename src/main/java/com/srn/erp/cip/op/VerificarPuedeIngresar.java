package com.srn.erp.cip.op;

import com.srn.erp.sueldos.bm.Legajo;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class VerificarPuedeIngresar extends Operation {

	public VerificarPuedeIngresar() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		Legajo legajo = Legajo.findByCodigo(mapaDatos.getString("codigo"), this.getSesion());
		IDataSet ds = this.getVerifPuedeIngresar();
		writeCliente(ds);

	}

	private IDataSet getVerifPuedeIngresar() {
		IDataSet dataset = new TDataSet();
		dataset.create("TPuedeIngresar");
		dataset.fieldDef(new Field("oid_legajo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("legajo", Field.STRING, 50));
		dataset.fieldDef(new Field("puede_ingresar", Field.STRING, 2));
		dataset.fieldDef(new Field("motivo", Field.STRING, 50));
		return dataset;
	}

	private void cargarRegistroBiometrico(IDataSet dataset, Legajo legajo, String puedeIngresar, String motivo) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_legajo", legajo.getOIDInteger());
		dataset.fieldValue("legajo", legajo.getCodigo());
		dataset.fieldValue("puede_ingresar", puedeIngresar);
		dataset.fieldValue("motivo", motivo);
	}
}
