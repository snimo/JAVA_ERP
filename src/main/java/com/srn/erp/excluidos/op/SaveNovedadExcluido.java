package com.srn.erp.excluidos.op;

import com.srn.erp.excluidos.bm.EstadoExcluido;
import com.srn.erp.excluidos.bm.LugarHechoExcluido;
import com.srn.erp.excluidos.bm.MotivoNovedadExcluido;
import com.srn.erp.excluidos.bm.NovedadExcluido;
import com.srn.erp.excluidos.bm.SeRetiraEnExc;
import com.srn.erp.excluidos.bm.SupervisorExcluido;
import com.srn.erp.excluidos.bm.TurnoExcluido;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveNovedadExcluido extends Operation {

	public SaveNovedadExcluido() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		IDataSet dataset = mapaDatos.getDataSet("TNovedadExcluido");
		procesarRegistros(dataset);
	}

	private void procesarRegistros(IDataSet dataset) throws BaseException {
		dataset.first();
		while (!dataset.EOF()) {
			NovedadExcluido novedadexcluido = NovedadExcluido.findByOid(dataset.getInteger("oid_novedad"), getSesion());
			novedadexcluido.setOID(dataset.getInteger("oid_novedad"));
			novedadexcluido.setFecha(dataset.getDate("fecha"));
			novedadexcluido.setHora(dataset.getString("hora"));
			novedadexcluido.setEstado(EstadoExcluido.findByOidProxy(dataset.getInteger("oid_estado"),this.getSesion()));
			novedadexcluido.setLugar_del_hecho(LugarHechoExcluido.findByOidProxy(dataset.getInteger("oid_lugar_hecho"),this.getSesion()));
			novedadexcluido.setSe_retira_en(SeRetiraEnExc.findByOidProxy(dataset.getInteger("oid_se_retira"),this.getSesion()));
			novedadexcluido.setHora_desde(dataset.getString("hora_desde"));
			novedadexcluido.setMotivo(MotivoNovedadExcluido.findByOidProxy(dataset.getInteger("oid_motivo"),this.getSesion()));
			novedadexcluido.setTurno(TurnoExcluido.findByOidProxy(dataset.getInteger("oid_turno"),this.getSesion()));
			novedadexcluido.setHora_hasta(dataset.getString("hora_hasta"));
			novedadexcluido.setSupervisor(SupervisorExcluido.findByOidProxy(dataset.getInteger("oid_supervisor"),this.getSesion()));
			novedadexcluido.setObservacion(dataset.getString("observacion"));
			novedadexcluido.setVig_desde(dataset.getDate("vig_desde"));
			novedadexcluido.setActivo(dataset.getBoolean("activo"));
			novedadexcluido.setVig_hasta(dataset.getDate("vig_hasta"));
			novedadexcluido.setRestriccionAcceso(dataset.getBoolean("restriccion_acceso"));
			if (dataset.getInteger("dejar_sin_efecto").intValue()==1)
				novedadexcluido.setDejar_sin_efecto(true);
			else
				novedadexcluido.setDejar_sin_efecto(false);
			addTransaccion(novedadexcluido);
			dataset.next();
		}
	}

}
