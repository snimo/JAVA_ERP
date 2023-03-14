package com.srn.erp.cip.op;

import java.util.Iterator;

import com.srn.erp.cip.bm.IdentificadoresDeLegajosCIP;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerIdentificadoresDeLeg extends Operation {

	public TraerIdentificadoresDeLeg() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		IDataSet ds = this.getDataSetIdentificadoresLegajo();
		Iterator iterIdentifLegajo = IdentificadoresDeLegajosCIP.getIdentificadores().keySet().iterator();
		while (iterIdentifLegajo.hasNext()) {
			String codigo = (String) iterIdentifLegajo.next();
			String descripcion = (String) IdentificadoresDeLegajosCIP.getIdentificadores().get(codigo);
			cargarRegistro(ds, codigo, descripcion);
		}
		writeCliente(ds);

	}

	private IDataSet getDataSetIdentificadoresLegajo() {
		IDataSet dataset = new TDataSet();
		dataset.create("TIdentifLeg");
		dataset.fieldDef(new Field("codigo", Field.STRING, 50));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
		return dataset;
	}

	private void cargarRegistro(IDataSet dataset, String codigo, String descripcion) throws BaseException {
		dataset.append();
		dataset.fieldValue("codigo", codigo);
		dataset.fieldValue("descripcion", descripcion);
	}

}
