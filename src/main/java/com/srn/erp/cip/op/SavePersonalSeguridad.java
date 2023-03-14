package com.srn.erp.cip.op;

import com.srn.erp.cip.bm.PersonalSeguridad;
import com.srn.erp.ventas.bm.TipoDocumento;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SavePersonalSeguridad extends Operation {

	public SavePersonalSeguridad() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		IDataSet dataset = mapaDatos.getDataSet("TPersonalSeguridad");
		procesarRegistros(dataset);
	}

	private void procesarRegistros(IDataSet dataset) throws BaseException {
		dataset.first();
		while (!dataset.EOF()) {
			PersonalSeguridad personalseguridad = PersonalSeguridad.findByOid(dataset.getInteger("oid_pers_secu"), getSesion());
			personalseguridad.setCodigo(dataset.getString("codigo"));
			personalseguridad.setActivo(dataset.getBoolean("activo"));
			personalseguridad.setApellido(dataset.getString("apellido"));
			personalseguridad.setNombre(dataset.getString("nombre"));
			personalseguridad.setTipo_documento(TipoDocumento.findByOidProxy(dataset.getInteger("oid_tipo_docu"),this.getSesion()));
			personalseguridad.setCacheo_seg(dataset.getBoolean("cacheo_seg"));
			personalseguridad.setNro_docu(dataset.getString("nro_docu"));
			addTransaccion(personalseguridad);
			dataset.next();
		}
	}

}
