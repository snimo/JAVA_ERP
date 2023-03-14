package com.srn.erp.cip.bm;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;

public class TelecomandoCIP {

	
	public static TelecomandoCIP teleComandoCIP; 
	
	private String IP;
	private Integer puerto;
	
	HashTableDatos servSockets = new HashTableDatos();
	
	public String getIP() {
		return IP;
	}

	public void setIP(String ip) {
		IP = ip;
	}
	
	public Integer getPuerto() {
		return puerto;
	}

	public void setPuerto(Integer puerto) {
		this.puerto = puerto;
	}

	public boolean resetPlaca(String IP, Integer puerto, Integer IDEquipo) throws BaseException {
		boolean devResPlaca = false;
		try {
		Socket socket = getSocket(IP,puerto,true);
		if (socket==null) return false;
		
		
		try {
			PrintWriter out = null;
			out = new PrintWriter(socket.getOutputStream(), true);
			PINIAccess pini = new PINIAccess();
			pini.setSeccion("TELECOMMAND");
			pini.addClave("ID", IDEquipo.toString());
			pini.addClave("TELTYPE", "3");
			out.print(pini.getPKT());
			out.flush();
			//Thread.sleep(1000);
			devResPlaca = true;
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			devResPlaca = false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			devResPlaca = false;
		}
		}
		catch(Exception e) {
			devResPlaca = false;
			return devResPlaca;
		}
		return devResPlaca;
	}
	
	public static TelecomandoCIP getTelecomandoCIP() throws BaseException {
		if (teleComandoCIP == null)
			teleComandoCIP = new TelecomandoCIP();
		return teleComandoCIP;
	}
	
	public Socket getSocket(String ip,Integer puerto, boolean reintento) throws BaseException {
		// Obtener el Socket correspondiente
		
		try {
		
		Socket socket = 
			(Socket)servSockets.get(ip+"_"+puerto.toString());
		
		if (socket==null) {
			try {
				socket = new Socket(ip, puerto);
				socket.setKeepAlive(true);
				servSockets.put(ip+"_"+puerto.toString(),socket);
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		// Si no esta conectado, entonces borrar de la lista
		if (!isConnected(socket)) { 
			servSockets.remove(ip+"_"+puerto.toString());
			if (reintento) {
				socket = getSocket(ip,puerto, false);
			}
			else
				socket = null;
			
		}
		return socket;
		}
		catch(Exception e) {
			return null;
		}
			
	}
	
	private boolean isConnected(Socket socket) throws BaseException {
		try {
			if (socket==null) return false;
			socket.getOutputStream().write("PRUEBA".getBytes());
			socket.getOutputStream().flush();
			socket.getOutputStream().write("PRUEBA".getBytes());
			socket.getOutputStream().flush();			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			try {
				socket.getOutputStream().close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				socket.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return false;
		}
		return true;
	}
	
	public boolean abrirPuerta(String IP, Integer puerto, Integer IDEquipo,String media,Integer point) throws BaseException {
		boolean devResPlaca = false;
		try {
		Socket socket = getSocket(IP,puerto,true);
		if (socket==null) return false;
		
		
		try {
			PrintWriter out = null;
			out = new PrintWriter(socket.getOutputStream(), true);
			PINIAccess pini = new PINIAccess();
			pini.setSeccion("TELECOMMAND");
			pini.addClave("ID", IDEquipo.toString());
			pini.addClave("TELTYPE", "1");
			pini.addClave("MEDIA", media);
			pini.addClave("POINT", point.toString());
			out.print(pini.getPKT());
			out.flush();
			//Thread.sleep(1000);
			devResPlaca = true;
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			devResPlaca = false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			devResPlaca = false;
		}
		}
		catch(Exception e) {
			devResPlaca = false;
			return devResPlaca;
		}
		return devResPlaca;
	}	
	
	
}
