package com.srn.erp.cip.op;

import java.util.Iterator;

import com.srn.erp.cip.bm.GrupoPuerta;
import com.srn.erp.cip.bm.MotivoVisita;
import com.srn.erp.cip.bm.PermisoVisita;
import com.srn.erp.cip.bm.UtilCIP;
import com.srn.erp.cip.bm.Visita;
import com.srn.erp.sueldos.bm.Legajo;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class FuncIngManualVisita extends Operation {

	public FuncIngManualVisita() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		if (mapaDatos.containsKey("MOTIVOS_HABILITADOS"))
			traerMotivos(mapaDatos);
		else
			if (mapaDatos.containsKey("ALTA_VISITA_MANU"))
				altaVisitaManual(mapaDatos);
			
	}
	
	private void altaVisitaManual(MapDatos mapaDatos) throws BaseException {
		
		Visita visita = Visita.findByOidProxy(mapaDatos.getInteger("oid_visita"), this.getSesion());
		PermisoVisita permisoVisita = (PermisoVisita) PermisoVisita.getNew(PermisoVisita.NICKNAME, this.getSesion());
		permisoVisita.setPrioridad(PermisoVisita.PRIO_VIS_MANUAL);
		permisoVisita.setVisita(visita);
		permisoVisita.setPermiso(Visita.HAB_PERMI);
		
		// Calcular la Fecha Hora Desde
		java.util.Date fecha = mapaDatos.getDate("fecha");
		String horaDesde = mapaDatos.getString("hora_desde"); 
		String horaHasta = mapaDatos.getString("hora_hasta");
		
		int horasDesde   = UtilCIP.getParteHoraEnHoras(horaDesde);
		int minutosDesde = UtilCIP.getParteMinutosEnMinutos(horaDesde);

		int horasHasta   = UtilCIP.getParteHoraEnHoras(horaHasta);
		int minutosHasta = UtilCIP.getParteMinutosEnMinutos(horaHasta);
		
		java.util.Date fecTrunc = Fecha.getFechaTruncada(fecha);
		java.util.Date fecDesde = Fecha.getFechaMasMinutos(fecTrunc, (horasDesde*60)+minutosDesde);
		java.util.Date fecHasta = Fecha.getFechaMasMinutos(fecTrunc, (horasHasta*60)+minutosHasta);
		
		permisoVisita.setGrupo_puerta(GrupoPuerta.findByOidProxy(mapaDatos.getInteger("oid_punto_acceso"), this.getSesion()));
		permisoVisita.setFec_hor_desde(fecDesde);
		permisoVisita.setFec_hor_hasta(fecHasta);
		permisoVisita.setSentido(PermisoVisita.SENTIDO_E);
		permisoVisita.setTarjeta(null);
		if (mapaDatos.containsKey("oid_motivo"))
			permisoVisita.setMotivoVisita(MotivoVisita.findByOidProxy(mapaDatos.getInteger("oid_motivo"), this.getSesion()));
		if (mapaDatos.containsKey("oid_visita_a"))
			permisoVisita.setVisitaA(Legajo.findByOidProxy(mapaDatos.getInteger("oid_visita_a"), this.getSesion()));
		if (mapaDatos.containsKey("oid_autoriza"))
			permisoVisita.setAutoriza(Legajo.findByOidProxy(mapaDatos.getInteger("oid_autoriza"), this.getSesion()));
		permisoVisita.setActivo(true);
		this.addTransaccion(permisoVisita);
	}
	
	private void traerMotivos(MapDatos mapaDatos) throws BaseException {
		IDataSet dsMotivos = this.getDataSetMotivos();
		Iterator iterMotVisitas = MotivoVisita.getMotivosIngesoManual(this.getSesion()).iterator();
		while (iterMotVisitas.hasNext()) {
			MotivoVisita motivoVisita = (MotivoVisita) iterMotVisitas.next();
			cargarRegistroMotivo(dsMotivos, motivoVisita);
		}
		writeCliente(dsMotivos);
	}
	
	private IDataSet getDataSetMotivos() { 
		IDataSet dataset = new TDataSet(); 
		dataset.create("TMotivos");
		dataset.fieldDef(new Field("oid", Field.INTEGER, 0)); 
		dataset.fieldDef(new Field("codigo", Field.STRING, 20)); 
		dataset.fieldDef(new Field("descripcion", Field.STRING, 50)); 
		return dataset;
	}

	private void cargarRegistroMotivo(
			IDataSet dataset, 
		    MotivoVisita motivo) throws BaseException {
		    dataset.append(); 
		    dataset.fieldValue("oid", motivo.getOIDInteger());
		    dataset.fieldValue("codigo", motivo.getCodigo());
		    dataset.fieldValue("descripcion", motivo.getDescripcion());
	}
	
	
}
