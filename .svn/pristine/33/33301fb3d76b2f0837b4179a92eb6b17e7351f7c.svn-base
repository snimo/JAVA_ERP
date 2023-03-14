package com.srn.erp.cip.bm;

import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import org.aspectj.weaver.patterns.ThisOrTargetAnnotationPointcut;

import scala.Array;
import framework.applicarionServer.bl.Seguridad.Login;
import framework.applicarionServer.bl.Servicios.IServicios;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Sesion.Sesion;
import framework.applicarionServer.bl.StartUP.CargarServicios;
import framework.applicarionServer.bm.Parametros.ValorParametro;
import framework.applicarionServer.bm.Seguridad.EncriptarCadena;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;

public class ClientThreadCardPINAccess extends Thread {
	
	Socket clientSocket = null;
	InputStream is = null;
	OutputStream ou = null;
	PINIAccess piniAccessResp = new PINIAccess();
	PINIEngine piniEngine = new PINIEngine();
	ISesion sesion;
//	String path;

	public void setSession(ISesion aSesion) {
		this.sesion = aSesion;
	}

	public ISesion getSesion() throws BaseException {
		return this.sesion;
	}

	public ClientThreadCardPINAccess(Socket aClientSocket) {
		this.clientSocket = aClientSocket;
	}

	public void setSocket(Socket aClientSocket) {
		this.clientSocket = aClientSocket;
	}

	private void inicializar() throws BaseException {
		piniEngine.setPuertoPlacaTeleComandos(4810);
	}
	
	private  void ejecutar() throws BaseException{
		
		String mensRecibido = null;
		byte[] buf = this.getBuffer();
		
		inicializar();
		
		IServicios servicios = (IServicios) CargarServicios.getServletContext().getAttribute(IServicios.ID_SERVICIOS);
		Sesion sesionTemp = new Sesion();
		this.setSession(sesionTemp);
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
		
//		this.path = ValorParametro.findByCodigoParametro("PATH_LOGGER_MENS_PLACA", this.getSesion()).getValorCadena();

		
		try {

			is = clientSocket.getInputStream();
			ou = clientSocket.getOutputStream();
			ou.flush();

//			System.out.println("CREANDO THREAD");
			
			try {
				piniEngine.setSession(this.getSesion());
			} catch (BaseException e) {
			};

			try {
					while(true){
						
				   /****************************LOGICA PARA PRECESAR MENSAJES ENVIADOS EN DOS PARTES*******/
						boolean encontroFin = false;
						mensRecibido = "";
						while((!encontroFin)){
							is.read(buf, 0, buf.length);
								String aux = new String(buf).trim();
								if((aux.indexOf(">") != -1))
									encontroFin = true;
								
								if(aux.startsWith("<"))
									mensRecibido = aux;
								else 
									mensRecibido = mensRecibido + aux;
								
								buf = this.getBuffer();
						}
					
					/************************************************************************************/
					mensRecibido = mensRecibido.substring(0, mensRecibido.indexOf(">") + 1);
					
					//System.out.println("PLACA: " +  mensRecibido);
					
					if(!mensRecibido.isEmpty()){
//						Logger logger = Logger.getLogger();
//						logger.grabarMensaje("PLACA: " + mensRecibido, this.path);
						piniEngine.setPKT(mensRecibido);
						piniEngine.setPINIAccess(piniAccessResp);
						
						try {
							piniEngine.run();
						} catch (BaseException e) {
							e.printStackTrace();
						}
						
						String response = piniAccessResp.getPKT();
						//System.out.println("SERVER: " +  response);
						
//						logger.grabarMensaje("SERVER: " +  piniAccessResp.getPKT(), this.path);
						byte[] matriz = piniAccessResp.getPKT().getBytes();
						ou.write(matriz);
						ou.flush();
						
//						piniEngine.afterEnvioMensaje();
	
						matriz = null;
						
						if (piniEngine!=null)
							piniEngine.afterEnvioMensaje();
					}
				}
					

			} catch (InterruptedIOException iioe) {
				iioe.printStackTrace();
			}
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			} 
		} catch (IOException ioe) {
		
		}
		
		cerrar();
		
		try {
			sesionTemp.FreeConnection();
		} catch (BaseException e) {
			e.printStackTrace();
		}
		
		return;
		
	}

	private byte[] getBuffer() {
		return new byte [1024];
	}

	public void run() {
		try {
			ejecutar();
		} catch(BaseException e){
			
		}

	}

	private void cerrar() {
		try {
			if (is != null)
				is.close();
			if (ou != null)
				ou.close();
			if (clientSocket != null)
				clientSocket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
