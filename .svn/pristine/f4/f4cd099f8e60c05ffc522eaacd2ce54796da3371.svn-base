package com.srn.erp.rrhh.op;

import com.srn.erp.rrhh.bm.Competencia;
import com.srn.erp.rrhh.bm.EvaluacionLegajoCab;
import com.srn.erp.rrhh.bm.ModeloEvalCompe;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerVerDescCompetencia extends Operation {

	public TraerVerDescCompetencia() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		IDataSet dsCompe = this.getDataSetCompetencia();
		
		Integer oidCompetencia = mapaDatos.getInteger("oid_competencia");
		Integer oidEvalCab = mapaDatos.getInteger("oid_eval_cab");

		EvaluacionLegajoCab evaluacionLegajoCab = EvaluacionLegajoCab.findByOid(oidEvalCab, this.getSesion());
		Competencia competencia = Competencia.findByOidProxy(oidCompetencia, this.getSesion());

		ModeloEvalCompe modeloEvalCompe = evaluacionLegajoCab.getModeloEvalCompe(competencia);
		
		if (modeloEvalCompe!=null) 
			cargarRegistroCompetencia(dsCompe,
									  modeloEvalCompe.getCompetencia().getOIDInteger(),
									  modeloEvalCompe.getTitulo_compe(),
									  modeloEvalCompe.getDefinicion_compe());
		
		writeCliente(dsCompe);	

	}

	private IDataSet getDataSetCompetencia() {
		IDataSet dataset = new TDataSet();
		dataset.create("TCompetencia");
		dataset.fieldDef(new Field("oid_competencia", Field.INTEGER, 0));
		dataset.fieldDef(new Field("titulo", Field.STRING, 100));
		dataset.fieldDef(new Field("definicion", Field.STRING, 4000));
		return dataset;
	}

	private void cargarRegistroCompetencia(IDataSet dataset, Integer oidCompetencia, String titulo, String definicion) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_competencia", oidCompetencia);
		dataset.fieldValue("titulo", titulo);
		dataset.fieldValue("definicion", definicion);
	}

}
