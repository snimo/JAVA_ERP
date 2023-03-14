package com.srn.erp.reclutamiento.op;

import com.srn.erp.reclutamiento.bm.RecluPostulante;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerRecluNombrePostu extends Operation {

	public TraerRecluNombrePostu() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		
		IDataSet ds = this.getDataSetRecluNombrePostu();
		RecluPostulante postulante = RecluPostulante.findByOid(mapaDatos.getInteger("oid_postulante"), this.getSesion());
		cargarRegistro(ds, postulante);		
		writeCliente(ds);

	}

	private void cargarRegistro(IDataSet dataset, RecluPostulante postulante) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_postulante", postulante.getOIDInteger());
		dataset.fieldValue("nombre_postulante", postulante.getApe_y_nom());
	}

	private IDataSet getDataSetRecluNombrePostu() {
		IDataSet dataset = new TDataSet();
		dataset.create("TNombrePostu");
		dataset.fieldDef(new Field("oid_postulante", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nombre_postulante", Field.STRING, 100));
		return dataset;
	}

}
