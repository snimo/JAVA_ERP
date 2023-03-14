package com.srn.erp.legales.op;

import com.srn.erp.legales.bm.Juicio;
import com.srn.erp.sueldos.bm.Legajo;

import framework.applicarionServer.bm.Parametros.ValorParametro;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerMensSiLegTieneEmbargo extends Operation {

	public TraerMensSiLegTieneEmbargo() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		Legajo legajo = Legajo.findByOidProxy(mapaDatos.getInteger("oid_legajo"), this.getSesion());

		double embargo = 0;
		ValorParametro valorParam = null;
		try {
			valorParam = ValorParametro.findByCodigoParametro("VER_AVISO_LEGAJO_CON_EMBARGO", this.getSesion());
		} catch (Exception e) {}
		if (valorParam != null) {
			if (valorParam.getBoolean()) {
				try {
					embargo = Juicio.getTotalEmbargoEmpleado(legajo, this.getSesion());
				} catch (Exception e) {
				}
			}
		}

		IDataSet datasetMensEmbargo = this.getDataSetMensEmbargoJuicio();
		if (embargo != 0)
			cargarRegistro(datasetMensEmbargo, "El empleado seleccionado tiene embargos por " + embargo + " pesos");
		writeCliente(datasetMensEmbargo);
	}

	private IDataSet getDataSetMensEmbargoJuicio() {
		IDataSet dataset = new TDataSet();
		dataset.create("TMensEmbargoJuicio");
		dataset.fieldDef(new Field("mensaje", Field.STRING, 255));
		return dataset;
	}

	private void cargarRegistro(IDataSet dataset, String mensaje) {
		dataset.append();
		dataset.fieldValue("mensaje", mensaje);
	}
}
