package com.srn.erp.ctasAPagar.op;

import com.srn.erp.general.bm.TipoComprobante;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveConfAnuTipoCompro extends Operation {

	public SaveConfAnuTipoCompro() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		IDataSet dataset = mapaDatos.getDataSet("TConcAnuTipoCompro");
		procesarRegistros(dataset);
	}

	private void procesarRegistros(IDataSet dataset) throws BaseException {
		dataset.first();
		while (!dataset.EOF()) {
			TipoComprobante tipoComprobante = TipoComprobante.findByOid(dataset.getInteger("oid_tc"), getSesion());
			TipoComprobante tipoComproAnulador = TipoComprobante.findByOid(dataset.getInteger("oid_tc_anulador"), this
					.getSesion());
			tipoComprobante.setTipoComprobanteAnulador(tipoComproAnulador);
			addTransaccion(tipoComprobante);
			dataset.next();
		}
	}

}
