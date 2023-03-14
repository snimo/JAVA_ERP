package com.srn.erp.turnos.op;

import java.util.Iterator;

import com.srn.erp.turnos.bm.TurnoPlantillaHorCab;
import com.srn.erp.turnos.bm.TurnoPlantillaHorDet;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerPlantillaHorariosTurno extends Operation {

	public TraerPlantillaHorariosTurno() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		TurnoPlantillaHorCab turnoplantillahorcab = null;
		if (mapaDatos.containsKey("oid")) {
			Integer oid = mapaDatos.getInteger("oid");
			turnoplantillahorcab = TurnoPlantillaHorCab.findByOid(oid,
					getSesion());
		} else {
			String codigo = mapaDatos.getString("codigo");
			turnoplantillahorcab = TurnoPlantillaHorCab.findByCodigo(codigo,
					getSesion());
		}

		IDataSet datasetTurnoPlantillaHorCab = getDataSetTurnoPlantillaHorCab();
		IDataSet datasetTurnoPlantillahorDet = getDataSetTurnoPlantillaHorDet();
		
		if (turnoplantillahorcab != null) {
			
			cargarRegistroTurnoPlantillaHorCab(datasetTurnoPlantillaHorCab,
					turnoplantillahorcab.getOIDInteger(), turnoplantillahorcab
							.getDescripcion(), turnoplantillahorcab.isActivo());
			
			Iterator iterHorDet = turnoplantillahorcab.getHorariosDet().iterator();
			while (iterHorDet.hasNext()) {
				TurnoPlantillaHorDet turnoPlantillaHorDet = (TurnoPlantillaHorDet) iterHorDet.next();
				cargarRegistroTurnoPlantillaHorDet(datasetTurnoPlantillahorDet, 
						turnoPlantillaHorDet.getOIDInteger(), 
						turnoplantillahorcab, 
						turnoPlantillaHorDet.getHorario(), turnoPlantillaHorDet.isActivo());
			}
			
			
		}
		writeCliente(datasetTurnoPlantillaHorCab);
		writeCliente(datasetTurnoPlantillahorDet);
		
	}

	private IDataSet getDataSetTurnoPlantillaHorCab() {
		IDataSet dataset = new TDataSet();
		dataset.create("TTurnoPlantillaHorCab");
		dataset.fieldDef(new Field("oid_plant_hor", Field.INTEGER, 0));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private void cargarRegistroTurnoPlantillaHorCab(IDataSet dataset,
			Integer oid_plant_hor, String descripcion, Boolean activo) {
		dataset.append();
		dataset.fieldValue("oid_plant_hor", oid_plant_hor);
		dataset.fieldValue("descripcion", descripcion);
		dataset.fieldValue("activo", activo);
	}

	private IDataSet getDataSetTurnoPlantillaHorDet() {
		IDataSet dataset = new TDataSet();
		dataset.create("TTurnoPlantillaHorDet");
		dataset.fieldDef(new Field("oid_plant_hor_det", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_plant_hor", Field.INTEGER, 0));
		dataset.fieldDef(new Field("horario", Field.STRING, 5));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private void cargarRegistroTurnoPlantillaHorDet(IDataSet dataset,
			Integer oid_plant_hor_det, TurnoPlantillaHorCab turnoPlantillaHorCab,
			String horario, Boolean activo) {
		dataset.append();
		dataset.fieldValue("oid_plant_hor_det", oid_plant_hor_det);
		dataset.fieldValue("oid_plant_hor", turnoPlantillaHorCab.getOIDInteger());
		dataset.fieldValue("horario", horario);
		dataset.fieldValue("activo", activo);
	}

}
