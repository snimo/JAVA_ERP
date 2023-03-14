package com.srn.erp.cip.op;

import com.srn.erp.cip.bm.GrupoPuerta;
import com.srn.erp.cip.bm.MotivosNovCIP;
import com.srn.erp.cip.bm.NovedadPermisoCIP;
import com.srn.erp.sueldos.bm.Legajo;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;

public class SaveInhabIngEgrLeg extends Operation {

	public SaveInhabIngEgrLeg() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		Legajo legajo = Legajo.findByOidProxy(mapaDatos.getInteger("oid_legajo"), this.getSesion());
		String habilitar = mapaDatos.getString("habilitar");
		GrupoPuerta puntoAcceso = GrupoPuerta.findByOidProxy(mapaDatos.getInteger("oid_punto_acceso"), this.getSesion());
		java.util.Date fecha = mapaDatos.getDate("fecha");
		String horaDesde = mapaDatos.getString("hora_desde");
		String horaHasta = mapaDatos.getString("hora_hasta");
		String observacion = mapaDatos.getString("observacion");
		MotivosNovCIP motivoNovCIP = MotivosNovCIP.findByOidProxy(mapaDatos.getInteger("oid_motivo"), this.getSesion());

		// Grabar el permiso
		NovedadPermisoCIP novedadPermisoCIP = (NovedadPermisoCIP) NovedadPermisoCIP.getNew(NovedadPermisoCIP.NICKNAME, this.getSesion());
		novedadPermisoCIP.setLegajo(legajo);
		novedadPermisoCIP.setFecha(fecha);
		novedadPermisoCIP.setMotivo(motivoNovCIP);
		novedadPermisoCIP.setHora_desde(horaDesde);
		novedadPermisoCIP.setHora_hasta(horaHasta);
		novedadPermisoCIP.setObservacion(observacion);
		novedadPermisoCIP.setGrupo_puerta(puntoAcceso);
		Usuario usuario = Usuario.findByOidProxy(this.getSesion().getLogin().getUsuario().getOIDInteger(), this.getSesion());
		novedadPermisoCIP.setUsu_asig_permiso(usuario);
		novedadPermisoCIP.setFec_usu_asig_perm(Fecha.getFechaActual());
		novedadPermisoCIP.setHor_usu_asig_perm(Fecha.getHoraActual());
		novedadPermisoCIP.setPesoNovedad(NovedadPermisoCIP.PESO_NOVEDAD_MANUAL);
		
		if (!(habilitar.equals(NovedadPermisoCIP.AMBOS))) {
			
			if (habilitar.equals(NovedadPermisoCIP.DES_ING)) {
				novedadPermisoCIP.setPermisoIngreso(habilitar);
				novedadPermisoCIP.setPermisoEgreso(NovedadPermisoCIP.NA_EGR);
			} else {
				novedadPermisoCIP.setPermisoIngreso(NovedadPermisoCIP.NA_ING);
				novedadPermisoCIP.setPermisoEgreso(habilitar);
			}
		} else {
			novedadPermisoCIP.setPermisoIngreso(NovedadPermisoCIP.DES_ING);
			novedadPermisoCIP.setPermisoEgreso(NovedadPermisoCIP.DES_EGR);
		}
		novedadPermisoCIP.setActivo(new Boolean(true));
		this.addTransaccion(novedadPermisoCIP);

	}

}
