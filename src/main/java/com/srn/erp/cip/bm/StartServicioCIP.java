package com.srn.erp.cip.bm;

import framework.applicarionServer.bl.Servicios.IServicios;
import framework.applicarionServer.bl.Sesion.Sesion;
import framework.applicarionServer.bl.StartUP.CargarServicios;
import framework.cip.bm.IStartServCIP;
import framework.request.bl.Utils.BaseException;

public class StartServicioCIP implements IStartServCIP {

	public StartServicioCIP() {
	}

	public void start() throws BaseException {
		
		cargarListaBlanca();
		
		
		NewThreadServCIP newThreadServCIP = new NewThreadServCIP();
		newThreadServCIP.start();
		
	}
	
	private void cargarListaBlanca() throws BaseException {
		
		IServicios servicios = (IServicios) CargarServicios.getServletContext().getAttribute(IServicios.ID_SERVICIOS);
		Sesion sesionTemp = new Sesion();
		sesionTemp.setServicios(servicios);
		try {
			ListaBlanca.generarListaBlanca(sesionTemp);
		} catch (BaseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			sesionTemp.FreeConnection();
		} catch (BaseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}		
		
	}


}
