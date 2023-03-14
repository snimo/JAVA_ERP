package com.srn.erp.schedule.bm;

import java.util.Date;
import java.util.Iterator;

import framework.applicarionServer.bl.Configuracion.DefOperacion;
import framework.applicarionServer.bl.Seguridad.Login;
import framework.applicarionServer.bl.Servicios.IServicios;
import framework.applicarionServer.bl.Servicios.Servicios;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Sesion.Sesion;
import framework.applicarionServer.bm.Seguridad.EncriptarCadena;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;
import framework.schedule.bm.IServicioSchedule;
import framework.schedule.bm.JobBase;
import framework.schedule.bm.TriggerBase;

public class AdministradorSchedule {

	
	public static void programarJobs(IServicios servicios, ISesion sesion) throws BaseException {
		
		IServicioSchedule servSchedule = servicios.getServicioSchedule();
		servSchedule.inicializar();

		ISesion sesionTemp = null;
		if (sesion!=null)
			sesionTemp = sesion;
		else
			sesionTemp = getTempSession(servicios);

		int cantJobsProg = 0;
		Iterator iterProgamacionJobs = 
			ProgramarJobSchedule.getProgramacionActivo(sesionTemp).iterator();
		while (iterProgamacionJobs.hasNext()) {
			ProgramarJobSchedule programaJobSchedule = (ProgramarJobSchedule) iterProgamacionJobs.next();
			++cantJobsProg;
			DefOperacion defOper = Servicios.getServicios()
				.getServDiccOperacion().getDiccionarioOperacion()
				.getDefOperacion(programaJobSchedule.getJob().getOperacion());
			
			Class clase = null;
			try {
				clase = Class.forName(defOper.getClase());
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			JobBase job = servSchedule.addJob(
					programaJobSchedule.getJob().getDescripcion(), 
					programaJobSchedule.getJob().getGrupo().getDescripcion(), clase);
			
			
			
			TriggerBase trigger = servSchedule.addTrigerBase(programaJobSchedule.getTrigger().getDescripcion());
			trigger.setTipo(programaJobSchedule.getTrigger().getTipo());
			trigger.setStartTime(new Date());
			trigger.setHora(programaJobSchedule.getTrigger().getHora());
			trigger.setMinutos(programaJobSchedule.getTrigger().getMinutos());
			trigger.setSegundos(programaJobSchedule.getTrigger().getSegundos());
			servSchedule.programar(job, trigger);
			
		}

		if (sesion == null)
			sesionTemp.FreeConnection();
		if (cantJobsProg>0)
			servSchedule.start();
		
		
	}
	
	private static Sesion getTempSession(IServicios servicios) throws BaseException {
		Sesion sesionTemp = new Sesion();
		sesionTemp.setServicios(servicios);
		Usuario usuario = Usuario.getUsuarioSistema(sesionTemp);
		if (usuario != null) {
			Login login = new Login();
			login.setUsuario(usuario);
			login.setAplicacion(usuario.getAplicacionDefault());
			login.setLogin(usuario.getLogin());
			login.setPassword(EncriptarCadena.getCadenaEncriptada(usuario.getClave()));
			sesionTemp.setLogin(login);
		}
		return sesionTemp; 
	}
	
	

}
