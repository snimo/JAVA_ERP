package com.srn.erp.cip.bm;

import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;

public class InterpretarNroValCIP {

	public static final String DIRECTO = "DIRECTO";
	public static final String B1FC_U2DBNRO = "1BFCU2BNRO";
	public static final String HID37BITS = "HID37BITS";

	public static HashTableDatos getInterpretar() throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(DIRECTO, "Directo");
		condiciones.put(B1FC_U2DBNRO, "1FC 2y3Nro");
		condiciones.put(HID37BITS, "HID37BITS");
		return condiciones;
	}

	public static String getB1FCYU2BNRO(String nroAVal) {
		String by = Integer.toBinaryString(new Integer(nroAVal));
		int nueNro = 0;
		if (by.length() <= 16)
			nueNro = new Integer(nroAVal);
		else {
			int base = 2;
			Integer nroTar = Integer.parseInt(by.substring(by.length() - 16, by.length()), base);
			String nroTarS = "";
			Integer fc = Integer.parseInt(by.substring(0, by.length() - 16), base);
			if (nroTar.toString().length() < 5) {
				int j = 1;
				for (j = 1; j <= (5 - nroTar.toString().length()); ++j)
					nroTarS = nroTarS + "0";
				nroTarS = nroTarS + nroTar.toString();
			} else
				nroTarS = nroTar.toString();
			nueNro = new Integer(fc.toString() + nroTarS.toString());
		}
		return (new Integer(nueNro)).toString();
	}

	public static String getBinarioFromHEX(String inputHex) {

		String[] hex = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F" };
		String[] binary = { "0000", "0001", "0010", "0011", "0100", "0101", "0110", "0111", "1000", "1001", "1010", "1011", "1100", "1101", "1110", "1111" };

		String userInput = inputHex;
		String result = "";
		for (int i = 0; i < userInput.length(); i++) {
			char temp = userInput.charAt(i);
			String temp2 = "" + temp + "";
			for (int j = 0; j < hex.length; j++) {
				if (temp2.equalsIgnoreCase(hex[j])) {
					result = result + binary[j];
				}
			}
		}
		return result;
	}

	public static String getHID37Bits(String nroAVal) {

		String binario = getBinarioFromHEX(nroAVal);

		// Empezando de Atras para adelante tomar los 17 bits

		String nroTarjeta = "";
		String fc = "";

		int c = 0;
		boolean pr = true;
		for (int j = binario.length() - 1; j >= 0; --j) {

			if ((pr != true) && (c <= 17)) {
				nroTarjeta = binario.charAt(j) + nroTarjeta;
			}

			pr = false;

			if ((c > 17) && (c <= 32)) {
				fc = binario.charAt(j) + fc;
			}

			++c;

		}
		
		String facility = new Integer(Integer.parseInt(fc, 2)).toString();
		String nroTarj = new Integer(Integer.parseInt(nroTarjeta, 2)).toString();
		
		int j=5-nroTarj.length();
		int i = 0;
		while (i<j) {
			nroTarj = '0'+nroTarj;
			++i;
		}

		return facility + nroTarj;

	}

	public static String firstHex(int dec) {
		String numeroHex = "";
		if (dec < 16) {
			switch (dec) {
			case 10:
				numeroHex = "A";
				break;
			case 11:
				numeroHex = "B";
				break;
			case 12:
				numeroHex = "C";
				break;
			case 13:
				numeroHex = "D";
				break;
			case 14:
				numeroHex = "E";
				break;
			case 15:
				numeroHex = "F";
				break;
			default:
				numeroHex = Integer.toString(dec);
				break;
			}
			return numeroHex;
		} else {
			return "false";
		}
	}

	public static String getHid37BitsInverso(String aNroTarjeta) {

		String cadenaNroTarjeta = aNroTarjeta;
		StringBuffer nroEnHexa = new StringBuffer("");
		
		int nroTarj = 0;
		String nroTarjeta = "";
		String fc = "";
		
		for (int i = cadenaNroTarjeta.length()-1; i >= 0; --i) {
			
			++nroTarj;
			
			if ((nroTarj>=1) && (nroTarj<=5)) {
				nroTarjeta = cadenaNroTarjeta.charAt(i) + nroTarjeta ;
			}
			
			if (nroTarj>5) {
				fc = cadenaNroTarjeta.charAt(i) + fc ;
			}
			
		}	
		
		// Recorrer el Nro. de Tarjeta y pasarlo a HEXA
		String binarioNroTarj = Integer.toBinaryString(new Integer(nroTarjeta));
		if (binarioNroTarj.length()<17) {
			int agregarCerozIzq = 17-binarioNroTarj.length();
			for(int z=1;z<=agregarCerozIzq;++z) {
				binarioNroTarj = "0"+binarioNroTarj; 
			}
		}
		
		// Recorrer el Faciliti CODE y pasarlo e HEX
		String binarioFC = Integer.toBinaryString(new Integer(fc));
		if (binarioFC.length()<15) {
			int agregarCerozIzq = 15-binarioFC.length();
			for(int z=1;z<=agregarCerozIzq;++z) {
				binarioFC = "0"+binarioFC; 
			}
		}
		
		String nroFinalDecimal = "0001100"+ binarioFC + binarioNroTarj + "1";
		String valorHexaFinal = "";
		
		// Leer todos los decimales
		String cada4Digitos = "";
		int contarDig = 0;
		
		boolean procesarHexa = false;
		
		for(int i=nroFinalDecimal.length()-1;i>=0;--i) {

			if ((contarDig>=0) && (contarDig<=3)) {
				cada4Digitos = nroFinalDecimal.charAt(i) + cada4Digitos ;
				
				if (contarDig==3) {
					valorHexaFinal = getHEXFromBinario(cada4Digitos) + valorHexaFinal;
					contarDig = 0;
					cada4Digitos = "";
					continue;
				}
			} 
			
			++contarDig;
			
		}
		
		if (!(cada4Digitos.equals("")) && (cada4Digitos.length()<4)) {
			int agregarCerozIzq = 4-cada4Digitos.length();
			for(int z=1;z<=agregarCerozIzq;++z) 
				cada4Digitos = "0"+cada4Digitos;	
		}
		
		if (!(cada4Digitos.equals(""))) {
			
			// Procesar cada4Digitos
			
			valorHexaFinal = getHEXFromBinario(cada4Digitos) + valorHexaFinal;
		}
		
		return valorHexaFinal;
		
		
		
	}
	
	 public static String getHEXFromBinario(String inputHex) {
			
		 String[]hex={"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};  
		 String[]binary={"0000","0001","0010","0011","0100","0101","0110","0111","1000","1001","1010","1011","1100","1101","1110","1111"};  
		   
		 String result="";  
		  
		  for(int j=0;j<binary.length;j++)  
		  {  
		   if(inputHex.equalsIgnoreCase(binary[j]))  
		   {  
		    result=result+hex[j];  
		    break;
		   }  
		  }  
		 return result;
	}	 
	

	public static Integer getB1FCYU2BNROInverso(String nro) {
		String nroTarjeta = "";
		String facCode = "";
		int i = 0;
		for (i = nro.length() - 1; i >= 0; --i) {
			if (nroTarjeta.length() <= 4)
				nroTarjeta = nro.charAt(i) + nroTarjeta;
			else
				facCode = nro.charAt(i) + facCode;
		}

		String binarioTarjeta = Integer.toBinaryString(new Integer(nroTarjeta));
		if (binarioTarjeta.length() < 16) {
			String agregarCeros = "";
			for (int j = 1; j <= (16 - binarioTarjeta.length()); ++j) {
				agregarCeros = agregarCeros + "0";
			}
			binarioTarjeta = agregarCeros + binarioTarjeta;
		}

		if (facCode.length() == 0)
			facCode = "0";

		String nuevoBinario = Integer.toBinaryString(new Integer(facCode)) + binarioTarjeta;
		return Integer.parseInt(nuevoBinario, 2);
	}

}
