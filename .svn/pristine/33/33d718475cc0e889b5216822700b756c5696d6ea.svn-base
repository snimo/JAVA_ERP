package com.srn.erp.cip.op;

import java.util.Iterator;

import com.srn.erp.cip.bm.EquivalenciaRotasCIP;
import com.srn.erp.cip.bm.MotivoEntIntermedias;
import com.srn.erp.cip.bm.MotivoEntradasInterRota;
import com.srn.erp.cip.bm.Rota;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerRota extends Operation {

	public TraerRota() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		Rota rota = null;
		if (mapaDatos.containsKey("oid")) {
			Integer oid = mapaDatos.getInteger("oid");
			rota = Rota.findByOid(oid, getSesion());
		} else {
			String codigo = mapaDatos.getString("codigo");
			rota = Rota.findByCodigo(codigo, getSesion());
		}

		IDataSet datasetRotas = getDataSetRotas();
		IDataSet dsEquivRotas = getDataSetEquivalenciaRotasCIP();
		IDataSet dsMotivEntInter = getDataSetMotivoEntradasInterRota();

		if (rota != null) {
			cargarRegistroRotas(datasetRotas, rota);
			Iterator iterEquivRotas = rota.getEquivalenciasRotas().iterator();
			while (iterEquivRotas.hasNext()) {
				EquivalenciaRotasCIP equivalenciaRota = (EquivalenciaRotasCIP) iterEquivRotas
						.next();
				cargarRegistroEquivalenciaRotasCIP(dsEquivRotas,
						equivalenciaRota);
			}

			Iterator iterMoticosEntInter = rota.getMotivosEntradasIntermedias()
					.iterator();
			while (iterMoticosEntInter.hasNext()) {
				MotivoEntradasInterRota motivoEntradasInterRota = (MotivoEntradasInterRota) iterMoticosEntInter
						.next();
				cargarRegistroMotivoEntradasInterRota(dsMotivEntInter,
						motivoEntradasInterRota.getOIDInteger(), rota,
						motivoEntradasInterRota.getMotivo(),
						motivoEntradasInterRota.getHorario_desde(),
						motivoEntradasInterRota.getHorario_hasta(),
						motivoEntradasInterRota.isActivo(),
						motivoEntradasInterRota.getAsignacion());
			}

		}

		writeCliente(datasetRotas);
		writeCliente(dsEquivRotas);
		writeCliente(dsMotivEntInter);

	}

	private IDataSet getDataSetRotas() {
		IDataSet dataset = new TDataSet();
		dataset.create("TRotas");
		dataset.fieldDef(new Field("oid_rota", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 50));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
		dataset.fieldDef(new Field("horario_desde", Field.STRING, 5));
		dataset.fieldDef(new Field("horario_hasta", Field.STRING, 5));
		dataset.fieldDef(new Field("min_ent_antes", Field.INTEGER, 0));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("min_ent_desp", Field.INTEGER, 0));
		dataset.fieldDef(new Field("min_sal_antes", Field.INTEGER, 0));
		dataset.fieldDef(new Field("tipo_acceso", Field.STRING, 20));
		dataset.fieldDef(new Field("tipo_egreso", Field.STRING, 20));
		dataset.fieldDef(new Field("min_sal_despues", Field.INTEGER, 0));
		dataset.fieldDef(new Field("ley_no_ingresa", Field.STRING, 20));
		dataset.fieldDef(new Field("ley_no_egresa", Field.STRING, 20));

		return dataset;
	}

	private void cargarRegistroRotas(IDataSet dataset, Rota rota)
			throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_rota", rota.getOIDInteger());
		dataset.fieldValue("codigo", rota.getCodigo());
		dataset.fieldValue("descripcion", rota.getDescripcion());
		dataset.fieldValue("horario_desde", rota.getHorario_desde());
		dataset.fieldValue("horario_hasta", rota.getHorario_hasta());
		dataset.fieldValue("min_ent_antes", rota.getMin_ent_antes());
		dataset.fieldValue("activo", rota.isActivo());
		dataset.fieldValue("min_ent_desp", rota.getMin_ent_desp());
		dataset.fieldValue("min_sal_antes", rota.getMin_sal_antes());
		dataset.fieldValue("tipo_acceso", rota.getTipo_acceso());
		dataset.fieldValue("tipo_egreso", rota.getTipo_egreso());
		dataset.fieldValue("min_sal_despues", rota.getMin_sal_despues());
		dataset.fieldValue("ley_no_ingresa", rota.getLeyendaNoIngresa());
		dataset.fieldValue("ley_no_egresa", rota.getLeyendaNoEgresa());

	}

	private IDataSet getDataSetEquivalenciaRotasCIP() {
		IDataSet dataset = new TDataSet();
		dataset.create("TEquivalenciaRotasCIP");
		dataset.fieldDef(new Field("oid_rota_equiv", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_rota", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo_externo", Field.STRING, 50));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private void cargarRegistroEquivalenciaRotasCIP(IDataSet dataset,
			EquivalenciaRotasCIP equivalenciaRota) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_rota_equiv", equivalenciaRota.getOIDInteger());
		dataset.fieldValue("oid_rota", equivalenciaRota.getRota()
				.getOIDInteger());
		dataset.fieldValue("codigo_externo", equivalenciaRota
				.getCodigo_externo());
		dataset.fieldValue("activo", equivalenciaRota.isActivo());
	}

	private IDataSet getDataSetMotivoEntradasInterRota() {
		IDataSet dataset = new TDataSet();
		dataset.create("TMotivoEntradasInterRota");
		dataset.fieldDef(new Field("oid_mot_rota", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_rota", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_motivo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("horario_desde", Field.STRING, 5));
		dataset.fieldDef(new Field("horario_hasta", Field.STRING, 5));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("asignacion", Field.STRING, 20));
		return dataset;
	}

	private void cargarRegistroMotivoEntradasInterRota(IDataSet dataset,
			Integer oid_mot_rota, Rota rota, MotivoEntIntermedias motivo,
			String horario_desde, String horario_hasta, Boolean activo,
			String asignacion) {
		dataset.append();
		dataset.fieldValue("oid_mot_rota", oid_mot_rota);
		dataset.fieldValue("oid_rota", rota.getOIDInteger());
		dataset.fieldValue("oid_motivo", motivo.getOIDInteger());
		dataset.fieldValue("horario_desde", horario_desde);
		dataset.fieldValue("horario_hasta", horario_hasta);
		dataset.fieldValue("activo", activo);
		dataset.fieldValue("asignacion", asignacion);
	}

}
