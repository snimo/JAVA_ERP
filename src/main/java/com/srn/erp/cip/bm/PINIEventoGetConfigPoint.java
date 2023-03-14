package com.srn.erp.cip.bm;

import framework.request.bl.Utils.BaseException;

public class PINIEventoGetConfigPoint extends PINIEventoBase {

	private static final String ID = "ID";
	private static final String POINT = "POINT";
	private static final String CONFIG = "CONFIG";
	
	private static final String CTIMEOUT = "CTIMEOUT";
	private static final String OTIMEOUT = "OTIMEOUT";
	private static final String ALARMTIME = "ALARMTIME";
	private static final String DIR = "DIR";
	private static final String BENABLE = "BENABLE";
	private static final String PENABLE = "PENABLE";
	private static final String BIOCHECK = "BIOCHECK";
	private static final String TYPE = "TYPE";
	private static final String READER = "READER";
	private static final String VOFFLINE = "VOFFLINE";
	
	private int valor_ID 	= -1;
	private Integer valor_POINT = -1;
	
	public void inicializar() {

		valor_ID = -1;
		valor_POINT = -1;
		
	}

	public void addParametro(String clave, String valor) {
		if (clave.equals(ID))
			valor_ID = new Integer(valor);
		else
		if (clave.equals(POINT))
			valor_POINT = new Integer(valor);		
	}

	public void internalRun(PINIAccess response) throws BaseException {
		
		// Pasa al modo ONINE
		
		Puerta puerta = Puerta.getPuertaByIdentif(valor_ID, this.getSession());
		
		if (puerta.getIdentifEntrada().equals(valor_POINT.toString())) {
			response.setSeccion(PINIEventoGetConfigPoint.CONFIG);
			response.addClave(PINIEventoGetConfigPoint.CTIMEOUT, puerta.getCTimeOutEnt().toString());
			response.addClave(PINIEventoGetConfigPoint.OTIMEOUT, puerta.getOTimeOutEnt().toString());
			response.addClave(PINIEventoGetConfigPoint.ALARMTIME, puerta.getAlarmTimeEnt().toString());
			response.addClave(PINIEventoGetConfigPoint.DIR, puerta.getDirPtoEnt().toString());
			response.addClave(PINIEventoGetConfigPoint.TYPE, puerta.getTipoPtoEnt().toString());
			if (puerta.getProtocoloEntrada().equals(ProtocolosCIP.WIEGAND26))
				response.addClave(PINIEventoGetConfigPoint.READER, "11"); // 11
			else
				if (puerta.getProtocoloEntrada().equals(ProtocolosCIP.WIEGAND37))
					response.addClave(PINIEventoGetConfigPoint.READER, "64"); // 11
				else if (puerta.getProtocoloEntrada().equals(ProtocolosCIP.WIEGAND32))
					response.addClave(PINIEventoGetConfigPoint.READER, "10"); // 10
				else
					if (puerta.getProtocoloEntrada().equals(ProtocolosCIP.NOHABILITADO))
						response.addClave(PINIEventoGetConfigPoint.READER, "0"); // 
					else					
						if (puerta.getProtocoloEntrada().equals(ProtocolosCIP.ABA))
							response.addClave(PINIEventoGetConfigPoint.READER, "1"); // 
						else						
							if (puerta.getProtocoloEntrada().equals(ProtocolosCIP.GEMPLUS))
								response.addClave(PINIEventoGetConfigPoint.READER, "3"); // 
							else							
								if (puerta.getProtocoloEntrada().equals(ProtocolosCIP.MANUAL))
									response.addClave(PINIEventoGetConfigPoint.READER, "4"); // 
								else							
									if (puerta.getProtocoloEntrada().equals(ProtocolosCIP.MONEDA))
										response.addClave(PINIEventoGetConfigPoint.READER, "6"); //			
								else								
									if (puerta.getProtocoloEntrada().equals(ProtocolosCIP.MAGNETICA))
										response.addClave(PINIEventoGetConfigPoint.READER, "12"); //			
								else									
									if (puerta.getProtocoloEntrada().equals(ProtocolosCIP.CODEBAR))
										response.addClave(PINIEventoGetConfigPoint.READER, "128"); //			
								else									
									response.addClave(PINIEventoGetConfigPoint.READER, "11"); // 11
			response.addClave(PINIEventoGetConfigPoint.BENABLE, puerta.getBenableEnt().toString());
			response.addClave(PINIEventoGetConfigPoint.PENABLE, puerta.getPenableEnt().toString());
			response.addClave(PINIEventoGetConfigPoint.VOFFLINE, puerta.getModoOFFLineEnt().toString());			
		} else if (puerta.getIdentifSal().equals(valor_POINT.toString())) { 
			response.setSeccion(PINIEventoGetConfigPoint.CONFIG);
			response.addClave(PINIEventoGetConfigPoint.CTIMEOUT, puerta.getCTimeOutSal().toString());
			response.addClave(PINIEventoGetConfigPoint.OTIMEOUT, puerta.getOTimeOutSal().toString());
			response.addClave(PINIEventoGetConfigPoint.ALARMTIME, puerta.getAlarmTimeSal().toString());
			response.addClave(PINIEventoGetConfigPoint.DIR, puerta.getDirPtoSal().toString());
			response.addClave(PINIEventoGetConfigPoint.TYPE, puerta.getTipoPtoSal().toString());
			if (puerta.getProtocoloSalida().equals(ProtocolosCIP.WIEGAND26))
				response.addClave(PINIEventoGetConfigPoint.READER, "11");
			else
				if (puerta.getProtocoloSalida().equals(ProtocolosCIP.WIEGAND37))
					response.addClave(PINIEventoGetConfigPoint.READER, "64");
				else if (puerta.getProtocoloSalida().equals(ProtocolosCIP.WIEGAND32))
					response.addClave(PINIEventoGetConfigPoint.READER, "10");
				else
					if (puerta.getProtocoloEntrada().equals(ProtocolosCIP.NOHABILITADO))
						response.addClave(PINIEventoGetConfigPoint.READER, "0"); // 
					else					
						if (puerta.getProtocoloEntrada().equals(ProtocolosCIP.ABA))
							response.addClave(PINIEventoGetConfigPoint.READER, "1"); // 
						else						
							if (puerta.getProtocoloEntrada().equals(ProtocolosCIP.GEMPLUS))
								response.addClave(PINIEventoGetConfigPoint.READER, "3"); // 
							else							
								if (puerta.getProtocoloEntrada().equals(ProtocolosCIP.MANUAL))
									response.addClave(PINIEventoGetConfigPoint.READER, "4"); // 
								else							
									if (puerta.getProtocoloEntrada().equals(ProtocolosCIP.MONEDA))
										response.addClave(PINIEventoGetConfigPoint.READER, "6"); //			
								else								
									if (puerta.getProtocoloEntrada().equals(ProtocolosCIP.MAGNETICA))
										response.addClave(PINIEventoGetConfigPoint.READER, "12"); //			
								else									
									if (puerta.getProtocoloEntrada().equals(ProtocolosCIP.CODEBAR))
										response.addClave(PINIEventoGetConfigPoint.READER, "128"); //			
								else					
									response.addClave(PINIEventoGetConfigPoint.READER, "11");			
			response.addClave(PINIEventoGetConfigPoint.BENABLE, puerta.getBenableSal().toString());
			response.addClave(PINIEventoGetConfigPoint.PENABLE, puerta.getPenableSal().toString());
			response.addClave(PINIEventoGetConfigPoint.VOFFLINE, puerta.getModoOFFLineSal().toString());			
		} else {
			response.setSeccion(PINIEventoGetConfigPoint.CONFIG);
			response.addClave(PINIEventoGetConfigPoint.CTIMEOUT, "30");
			response.addClave(PINIEventoGetConfigPoint.OTIMEOUT, "5");
			response.addClave(PINIEventoGetConfigPoint.ALARMTIME, "5");
			response.addClave(PINIEventoGetConfigPoint.DIR, "1");
			response.addClave(PINIEventoGetConfigPoint.BENABLE, "1");
			response.addClave(PINIEventoGetConfigPoint.PENABLE, "1");
			response.addClave(PINIEventoGetConfigPoint.BIOCHECK, "0");
			response.addClave(PINIEventoGetConfigPoint.TYPE, "2");
			response.addClave(PINIEventoGetConfigPoint.READER, "11");
			response.addClave(PINIEventoGetConfigPoint.VOFFLINE, "2");
		}
		
	}

}
