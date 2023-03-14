package com.srn.erp.general.bm;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.srn.erp.schedule.bm.AdministradorSchedule;

import framework.applicarionServer.bl.Servicios.IServicios;
import framework.request.bl.Utils.BaseException;
import framework.schedule.bm.IServicioSchedule;

public class InicializarERP implements ServletContextListener {

	public void contextInitialized(ServletContextEvent e) {

		
		
		try {

			// Como hago para acceder
			ServletContext sc = e.getServletContext();
			IServicios servicios = (IServicios) sc.getAttribute(IServicios.ID_SERVICIOS);
			if (servicios != null)
				AdministradorSchedule.programarJobs(servicios,null);

		}

		catch (BaseException error) {
			error.printStackTrace();
		}

	}

	public void contextDestroyed(ServletContextEvent e) {
		
		// Liberar Servicios
		ServletContext sc = e.getServletContext();
		IServicios servicios = (IServicios) sc.getAttribute(IServicios.ID_SERVICIOS);
		if (servicios != null) {
			IServicioSchedule servSchedule = servicios.getServicioSchedule();
			servSchedule.stop();
		}
				
		
	}

}
