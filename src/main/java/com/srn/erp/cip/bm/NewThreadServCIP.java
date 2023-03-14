package com.srn.erp.cip.bm;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import framework.applicarionServer.bl.Servicios.IServicios;
import framework.applicarionServer.bl.Sesion.Sesion;
import framework.applicarionServer.bl.StartUP.CargarServicios;
import framework.request.bl.Utils.BaseException;

public class NewThreadServCIP extends Thread {

	public void run() {

		
		
		
		ServerSocket srvr;
		try {
			srvr = new ServerSocket(4800);
			srvr.setSoTimeout(0);

			Socket skt = null;

			while (true) {

				skt = srvr.accept();
				skt.setSoTimeout(1000 * 120);

				ClientThreadCardPINAccess clientThread = new ClientThreadCardPINAccess(skt);
				clientThread.start();

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

	}

}
