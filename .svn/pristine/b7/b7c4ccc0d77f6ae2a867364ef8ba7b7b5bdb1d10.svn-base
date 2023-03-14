package com.srn.erp.Ausentismo.op;

import java.util.ArrayList;
import java.util.List;

import com.srn.erp.Ausentismo.bm.GrupoRRHH;
import com.srn.erp.Ausentismo.bm.GrupoRRHHDetalle;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerTiposDeAusentismoSeleccionado extends Operation { 

	public TraerTiposDeAusentismoSeleccionado() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
	    List<GrupoRRHH> grupos = GrupoRRHH.findByTipo("Ausencia", getSesion());

		IDataSet datasetGrupoDetalle = getDataSetGrupoDetalle();
		
		List<GrupoRRHHDetalle> grupodetalle = new ArrayList<GrupoRRHHDetalle>();
		for (GrupoRRHH grupo : grupos) {
			grupodetalle.addAll(GrupoRRHHDetalle.getSelectByOidGrupo(getSesion(),grupo.getOIDInteger()));
		}
		
		cargarRegistroGrupoDetalle(datasetGrupoDetalle, grupodetalle);
		
		writeCliente(datasetGrupoDetalle);
	}

	private IDataSet getDataSetGrupoDetalle() {
		IDataSet dataset = new TDataSet();
		dataset.create("TAusencias");
		dataset.fieldDef(new Field("oid_grupo_det", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cotab", Field.INTEGER, 0));
		dataset.fieldDef(new Field("ausencia", Field.STRING, 200));
		dataset.fieldDef(new Field("seleccionado", Field.BOOLEAN, 0));
		return dataset;
	}
	
	private void cargarRegistroGrupoDetalle(IDataSet dataset, List<GrupoRRHHDetalle> gruposDetalle) throws BaseException {
		for (GrupoRRHHDetalle tipoAusencia : gruposDetalle) {
			dataset.append();
			dataset.fieldValue("oid_grupo_det", tipoAusencia.getOIDInteger());
			dataset.fieldValue("codigo", tipoAusencia.getCod_ext_1());
			dataset.fieldValue("cotab", tipoAusencia.getCod_ext_2());
			dataset.fieldValue("ausencia", tipoAusencia.getDescripcion());
			dataset.fieldValue("seleccionado", false);
			
		}
	}
  
}
