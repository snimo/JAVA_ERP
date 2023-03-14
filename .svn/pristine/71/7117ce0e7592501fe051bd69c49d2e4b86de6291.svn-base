package com.srn.erp.excluidos.op;

import com.srn.erp.excluidos.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Tablas.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.*;

public class TraerNovedadExcluido extends Operation {

	public TraerNovedadExcluido() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		NovedadExcluido novedadexcluido = null;
		if (mapaDatos.containsKey("oid")) {
			Integer oid = mapaDatos.getInteger("oid");
			novedadexcluido = NovedadExcluido.findByOid(oid, getSesion());
		} else {
			String codigo = mapaDatos.getString("codigo");
			novedadexcluido = NovedadExcluido.findByCodigo(codigo, getSesion());
		}

		IDataSet datasetNovedadExcluido = getDataSetNovedadExcluido();

		if (novedadexcluido != null)
			cargarRegistroNovedadExcluido(datasetNovedadExcluido, novedadexcluido);

		writeCliente(datasetNovedadExcluido);
	}

	private IDataSet getDataSetNovedadExcluido() {
		IDataSet dataset = new TDataSet();
		dataset.create("TNovedadExcluido");
		dataset.fieldDef(new Field("oid_novedad", Field.INTEGER, 0));
		dataset.fieldDef(new Field("fecha", Field.DATE, 0));
		dataset.fieldDef(new Field("hora", Field.STRING, 5));
		dataset.fieldDef(new Field("oid_estado", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_lugar_hecho", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_se_retira", Field.INTEGER, 0));
		dataset.fieldDef(new Field("hora_desde", Field.STRING, 5));
		dataset.fieldDef(new Field("oid_motivo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_turno", Field.INTEGER, 0));
		dataset.fieldDef(new Field("hora_hasta", Field.STRING, 5));
		dataset.fieldDef(new Field("oid_supervisor", Field.INTEGER, 0));
		dataset.fieldDef(new Field("observacion", Field.STRING, 1000));
		dataset.fieldDef(new Field("vig_desde", Field.DATE, 0));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("vig_hasta", Field.DATE, 0));
		dataset.fieldDef(new Field("dejar_sin_efecto", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_individuo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("restriccion_acceso", Field.BOOLEAN, 0));
		return dataset;
	}

	private void cargarRegistroNovedadExcluido(IDataSet dataset, NovedadExcluido novedad) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_novedad", novedad.getOIDInteger());
		dataset.fieldValue("fecha", novedad.getFecha());
		dataset.fieldValue("hora", novedad.getHora());
		if (novedad.getEstado() != null)
			dataset.fieldValue("oid_estado", novedad.getEstado().getOIDInteger());
		else
			dataset.fieldValue("oid_estado", "");
		if (novedad.getLugar_del_hecho() != null)
			dataset.fieldValue("oid_lugar_hecho", novedad.getLugar_del_hecho().getOIDInteger());
		else
			dataset.fieldValue("oid_lugar_hecho", "");
		if (novedad.getSe_retira_en() != null)
			dataset.fieldValue("oid_se_retira", novedad.getSe_retira_en().getOIDInteger());
		else
			dataset.fieldValue("oid_se_retira", "");
		dataset.fieldValue("hora_desde", novedad.getHora_desde());
		if (novedad.getMotivo() != null)
			dataset.fieldValue("oid_motivo", novedad.getMotivo().getOIDInteger());
		else
			dataset.fieldValue("oid_motivo", "");
		if (novedad.getTurno() != null)
			dataset.fieldValue("oid_turno", novedad.getTurno().getOIDInteger());
		else
			dataset.fieldValue("oid_turno", "");
		dataset.fieldValue("hora_hasta", novedad.getHora_hasta());
		if (novedad.getSupervisor() != null)
			dataset.fieldValue("oid_supervisor", novedad.getSupervisor().getOIDInteger());
		else
			dataset.fieldValue("oid_supervisor", "");
		dataset.fieldValue("observacion", novedad.getObservacion());
		dataset.fieldValue("vig_desde", novedad.getVig_desde());
		dataset.fieldValue("activo", novedad.isActivo());
		dataset.fieldValue("vig_hasta", novedad.getVig_hasta());
		if (novedad.isDejar_sin_efecto())
			dataset.fieldValue("dejar_sin_efecto", 1);
		else
			dataset.fieldValue("dejar_sin_efecto", 0);
		dataset.fieldValue("oid_individuo", novedad.getIndividuoExcluido().getOID());
		

		dataset.fieldValue("restriccion_acceso", novedad.isRestriccionAcceso());

	}
}
