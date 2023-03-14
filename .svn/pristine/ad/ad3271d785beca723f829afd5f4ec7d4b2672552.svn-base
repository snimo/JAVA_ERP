package com.srn.erp.turnos.op;

import com.srn.erp.ventas.bm.Sujeto;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerSujetoTurno extends Operation {

	public TraerSujetoTurno() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		IDataSet ds = this.getDataSet();

		Sujeto sujeto = null;
		if (mapaDatos.containsKey("oid")) {
			Integer oid = mapaDatos.getInteger("oid");
			sujeto = Sujeto.findByOid(oid, getSesion());
		} else {
			String codigo = mapaDatos.getString("codigo");
			sujeto = Sujeto.findByCodigo(codigo, getSesion());
		}
		
		if (sujeto!=null)
			cargarRegistroEntidadTurno(ds, sujeto);

		writeCliente(ds);
	}

	private IDataSet getDataSet() {
		IDataSet dataset = new TDataSet();
		dataset.create("TSujetosTurnos");
		dataset.fieldDef(new Field("oid_sujeto", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 20));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 80));
		dataset.fieldDef(new Field("oid_turno_categ", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_turno_relacion", Field.INTEGER, 0));
		dataset.fieldDef(new Field("suspend_para_turno", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("fec_susp_desde", Field.DATE, 0));
		dataset.fieldDef(new Field("fec_susp_hasta", Field.DATE, 0));
		dataset.fieldDef(new Field("motivo_turno_susp", Field.STRING, 255));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private void cargarRegistroEntidadTurno(IDataSet dataset, Sujeto sujeto)
			throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_sujeto", sujeto.getOIDInteger());
		dataset.fieldValue("codigo", sujeto.getCodigo());
		dataset.fieldValue("descripcion", sujeto.getRazon_social());
		if (sujeto.getCategoriaSujetoTurno() != null)
			dataset.fieldValue("oid_turno_categ", sujeto
					.getCategoriaSujetoTurno().getOIDInteger());
		else
			dataset.fieldValue("oid_turno_categ", new Integer(0));
		if (sujeto.getRelacionSujetoTurno() != null)
			dataset.fieldValue("oid_turno_relacion", sujeto
					.getRelacionSujetoTurno().getOIDInteger());
		else
			dataset.fieldValue("oid_turno_relacion", new Integer(0));
		dataset
				.fieldValue("suspend_para_turno", sujeto
						.isSuspendidoParaTurno());
		dataset.fieldValue("fec_susp_desde", sujeto.getFecSuspendidoDesde());
		dataset.fieldValue("fec_susp_hasta", sujeto.getFecSuspendidoHasta());
		dataset.fieldValue("motivo_turno_susp", sujeto.getMotivoTurnoSuspension());
		dataset.fieldValue("activo", sujeto.isActivo());
	}
}
