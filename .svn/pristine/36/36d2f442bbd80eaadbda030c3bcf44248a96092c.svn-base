package com.srn.erp.cip.op;

import com.srn.erp.cip.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.IDataSet;

public class SaveTipoDocumentacionCIP extends Operation {

	public SaveTipoDocumentacionCIP() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		IDataSet dataset = mapaDatos.getDataSet("TTipoDocumentacionCIP");
		procesarRegistros(dataset);
	}

	private void procesarRegistros(IDataSet dataset) throws BaseException {
		dataset.first();
		while (!dataset.EOF()) {
			TipoDocumentacionCIP tipodocumentacioncip = TipoDocumentacionCIP.findByOid(dataset.getInteger("oid_tipo_docu"), getSesion());
			tipodocumentacioncip.setOID(dataset.getInteger("oid_tipo_docu"));
			tipodocumentacioncip.setCodigo(dataset.getString("codigo"));
			tipodocumentacioncip.setDescripcion(dataset.getString("descripcion"));
			tipodocumentacioncip.setActivo(dataset.getBoolean("activo"));
			addTransaccion(tipodocumentacioncip);
			dataset.next();
		}
	}

}
