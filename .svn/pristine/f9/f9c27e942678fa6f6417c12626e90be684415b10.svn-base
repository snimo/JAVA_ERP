package com.srn.erp.cip.op;

import com.srn.erp.cip.bm.PersonalSeguridad;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerPersonalSeguridad extends Operation {

	public TraerPersonalSeguridad() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		PersonalSeguridad personalseguridad = null;
		if (mapaDatos.containsKey("oid")) {
			Integer oid = mapaDatos.getInteger("oid");
			personalseguridad = PersonalSeguridad.findByOid(oid, getSesion());
		} else {
			String codigo = mapaDatos.getString("codigo");
			personalseguridad = PersonalSeguridad.findByCodigo(codigo, getSesion());
		}

		IDataSet datasetPersonalSeguridad = getDataSetPersonalSeguridad();
		if (personalseguridad != null) 
			cargarRegistroPersonalSeguridad(datasetPersonalSeguridad, personalseguridad);
		
		writeCliente(datasetPersonalSeguridad);
	}

	private IDataSet getDataSetPersonalSeguridad() {
		IDataSet dataset = new TDataSet();
		dataset.create("TPersonalSeguridad");
		dataset.fieldDef(new Field("oid_pers_secu", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 20));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("apellido", Field.STRING, 50));
		dataset.fieldDef(new Field("nombre", Field.STRING, 50));
		dataset.fieldDef(new Field("oid_tipo_docu", Field.STRING, 0));
		dataset.fieldDef(new Field("cacheo_seg", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("nro_docu", Field.STRING, 50));
		return dataset;
	}

	private void cargarRegistroPersonalSeguridad(IDataSet dataset, PersonalSeguridad persSeg) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_pers_secu", persSeg.getOIDInteger());
		dataset.fieldValue("codigo", persSeg.getCodigo());
		dataset.fieldValue("activo", persSeg.isActivo());
		dataset.fieldValue("apellido", persSeg.getApellido());
		dataset.fieldValue("nombre", persSeg.getNombre());
		if (persSeg.getTipo_documento()!=null)
			dataset.fieldValue("oid_tipo_docu", persSeg.getTipo_documento().getOIDInteger());
		else
			dataset.fieldValue("oid_tipo_docu", "");
		dataset.fieldValue("cacheo_seg", persSeg.isCacheo_seg());
		dataset.fieldValue("nro_docu", persSeg.getNro_docu());
	}
}
