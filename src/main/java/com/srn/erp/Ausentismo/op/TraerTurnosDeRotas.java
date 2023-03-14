package com.srn.erp.Ausentismo.op;

import java.util.List;

import com.srn.erp.Ausentismo.bm.GrupoRRHH;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerTurnosDeRotas extends Operation { 

	public TraerTurnosDeRotas() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		List<GrupoRRHH> tunros = null;
		tunros = GrupoRRHH.findByTipo("Rota", getSesion());

		IDataSet datasetGrupo = getDataSetGrupo();
		
		if (tunros != null) {
			cargarRegistroGrupo(datasetGrupo, tunros);
		}
		
		writeCliente(datasetGrupo);
	}

	private IDataSet getDataSetGrupo() {
		IDataSet dataset = new TDataSet();
		dataset.create("TTurnos");
		dataset.fieldDef(new Field("oid_grupo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("turno", Field.STRING, 100));
		dataset.fieldDef(new Field("seleccionado", Field.BOOLEAN, 0));
		return dataset;
	}

	private void cargarRegistroGrupo(IDataSet dataset, List<GrupoRRHH> turnos) throws BaseException {
		for (GrupoRRHH grupoRRHH : turnos) {
			dataset.append();
			dataset.fieldValue("oid_grupo", grupoRRHH.getOIDInteger());
			dataset.fieldValue("turno", grupoRRHH.getNombre());
			dataset.fieldValue("seleccionado", false);
		}
	}
	
}
