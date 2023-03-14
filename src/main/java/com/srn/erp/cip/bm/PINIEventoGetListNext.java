package com.srn.erp.cip.bm;

import java.util.Iterator;
import java.util.List;

import framework.request.bl.Utils.BaseException;

public class PINIEventoGetListNext extends PINIEventoBase {

	private static final String ID = "ID";
	private static final String REG = "REG";
	private static final String LIST = "LIST";
	
	private static final String RCOUNT = "RCOUNT";
	private static final String OFFSET = "OFFSET";
	private static final String R1 = "R1";
	private static final String R2 = "R2";
	private static final String R3 = "R3";
	private static final String R4 = "R4";
	private static final String R5 = "R5";
	
	private int valor_ID 	= -1;
	private int valor_REG   = -1;
	private int valor_OFFSET = -1;
	
	public void inicializar() {
		valor_ID  = -1;
		valor_REG = -1;
		valor_OFFSET = -1;
	}

	public void addParametro(String clave, String valor) {
		if (clave.equals(ID))
			valor_ID = new Integer(valor);
		else
		if (clave.equals(REG))
			valor_REG = new Integer(valor);		
		else
			if (clave.equals(OFFSET))
				valor_OFFSET = new Integer(valor);		
	}

	public void internalRun(PINIAccess response) throws BaseException {
		String puerta = String.valueOf(valor_ID);
		
		int nroDesde = valor_OFFSET;
		int nroHasta = valor_OFFSET+5-1;
		 

		List listaBanca = 
			ListaBlanca.getLoteListaBlanca(puerta, nroDesde, nroHasta, this.getSession());
		int cantReg = listaBanca.size();
		if (cantReg==0) {
			response.setSeccion(PINIEventoGetListNext.LIST);
			response.addClave(PINIEventoGetListNext.RCOUNT, "0");			
		} else {
			int i=1;
			Iterator iterListaBlanca = 
				listaBanca.iterator();
			response.setSeccion(PINIEventoGetListNext.LIST);
			if (cantReg>5)
				response.addClave(PINIEventoGetListNext.RCOUNT,"5");
			else
				response.addClave(PINIEventoGetListNext.RCOUNT,new Integer(cantReg).toString());
			while (iterListaBlanca.hasNext()) {
				ListaBlancaSimple listaBlanca = (ListaBlancaSimple) iterListaBlanca.next();
				if (i==1)
					response.addClave(PINIEventoGetListNext.R1, listaBlanca.getNro_a_validar().toString());
				else if (i==2)
					response.addClave(PINIEventoGetListNext.R2, listaBlanca.getNro_a_validar().toString());
				else if (i==3)
					response.addClave(PINIEventoGetListNext.R3, listaBlanca.getNro_a_validar().toString());				
				else if (i==4)
					response.addClave(PINIEventoGetListNext.R4, listaBlanca.getNro_a_validar().toString());				
				else if (i==5)
					response.addClave(PINIEventoGetListNext.R5, listaBlanca.getNro_a_validar().toString());				
				++i;
			}
		}
		
		//System.out.println(response.getPKT());
		
		
		
		
		
		
		// Pasa al modo ONINE
		
		/*Puerta puerta = Puerta.getPuertaByIdentif(valor_ID, this.getSession());
		
		int nroDesde = valor_OFFSET;
		int nroHasta = valor_OFFSET+5-1;
		 

		List listaBanca = 
			ListaBlanca.getListaBlanca(puerta, nroDesde, nroHasta, this.getSession());
		int cantReg = listaBanca.size();
		if (cantReg==0) {
			response.setSeccion(PINIEventoGetListNext.LIST);
			response.addClave(PINIEventoGetListNext.RCOUNT, "0");			
		} else {
			int i=1;
			Iterator iterListaBlanca = 
				listaBanca.iterator();
			response.setSeccion(PINIEventoGetListNext.LIST);
			if (cantReg>5)
				response.addClave(PINIEventoGetListNext.RCOUNT,"5");
			else
				response.addClave(PINIEventoGetListNext.RCOUNT,new Integer(cantReg).toString());
			while (iterListaBlanca.hasNext()) {
				ListaBlanca listaBlanca = (ListaBlanca) iterListaBlanca.next();
				if (i==1)
					response.addClave(PINIEventoGetListNext.R1, listaBlanca.getNro_a_validar().toString());
				else if (i==2)
					response.addClave(PINIEventoGetListNext.R2, listaBlanca.getNro_a_validar().toString());
				else if (i==3)
					response.addClave(PINIEventoGetListNext.R3, listaBlanca.getNro_a_validar().toString());				
				else if (i==4)
					response.addClave(PINIEventoGetListNext.R4, listaBlanca.getNro_a_validar().toString());				
				else if (i==5)
					response.addClave(PINIEventoGetListNext.R5, listaBlanca.getNro_a_validar().toString());				
				++i;
			}
		}*/
		
		
		/*
		if (valor_OFFSET==1) {
			response.setSeccion(PINIEventoGetListNext.LIST);
			response.addClave(PINIEventoGetListNext.RCOUNT, "5");
			response.addClave(PINIEventoGetListNext.R1, "33242");
			response.addClave(PINIEventoGetListNext.R2, "30434");
			response.addClave(PINIEventoGetListNext.R3, "16137");
			response.addClave(PINIEventoGetListNext.R4, "4");
			response.addClave(PINIEventoGetListNext.R5, "5");
		} else if (valor_OFFSET==6) {
			response.setSeccion(PINIEventoGetListNext.LIST);
			response.addClave(PINIEventoGetListNext.RCOUNT, "5");
			response.addClave(PINIEventoGetListNext.R1, "1");
			response.addClave(PINIEventoGetListNext.R2, "2");
			response.addClave(PINIEventoGetListNext.R3, "3");
			response.addClave(PINIEventoGetListNext.R4, "4");
			response.addClave(PINIEventoGetListNext.R5, "33279");			
		} else if ((valor_OFFSET>=11) && (valor_OFFSET<=1000)) {
			response.setSeccion(PINIEventoGetListNext.LIST);
			response.addClave(PINIEventoGetListNext.RCOUNT, "5");
			response.addClave(PINIEventoGetListNext.R1, "1");
			response.addClave(PINIEventoGetListNext.R2, "2");
			response.addClave(PINIEventoGetListNext.R3, "3");
			response.addClave(PINIEventoGetListNext.R4, "4");
			response.addClave(PINIEventoGetListNext.R5, "33279");
		}
		else if (valor_OFFSET>1000) {
			response.setSeccion(PINIEventoGetListNext.LIST);
			response.addClave(PINIEventoGetListNext.RCOUNT, "0");
		}*/		
	}

}
