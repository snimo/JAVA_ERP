package com.srn.erp.cip.bm;

import java.util.ArrayList;
import java.util.List;

public class PINIAccess {

	private String seccion;
	private List claves = new ArrayList();
	
	public static final String ACK = "ACK";
	public static final String NACK = "NACK";
	public static final String NTMY = "NTMY";
	

	public void setSeccion(String aSeccion) {
		this.seccion = aSeccion;
	}

	public String getSeccion() {
		return this.seccion;
	}
	
	public void clear() {
		setSeccion("");
		claves.clear();
	}

	public void addClave(String clave, String valor) {
		claves.add(new PINIClaveValor(clave, valor));
	}
	
	public String getPKT() {
		
		int i = 0;
		StringBuffer pkt = new StringBuffer("<["+this.seccion+"]");
		for (i=0;i<claves.size();++i) {
			PINIClaveValor claveValor = (PINIClaveValor) claves.get(i);
			pkt.append(claveValor.getClave()+"="+claveValor.getValor()+";");
		}
		pkt.append("CRC="+_CalcularCRC().toString()+";>");
		return pkt.toString(); 
	}

	public Integer _CalcularCRC()  {
		int i , j;
		int crc = 0;
		int ascII = 0;
		crc = (int) '[';
		
		for (i=0;i<this.getSeccion().length();++i) {
			ascII = (int) this.getSeccion().charAt(i);
			crc = crc ^ ascII; 
		}
		crc = crc ^ ']';
		
		for (j=0;j<claves.size();++j) {
			PINIClaveValor claveValor = (PINIClaveValor) claves.get(j);
			for (i=0;i<claveValor.getClave().length();++i) {
				ascII = (int) claveValor.getClave().charAt(i);
				crc = crc ^ ascII; 
			}			
			crc = crc ^ '=';
			for (i=0;i<claveValor.getValor().length();++i) {
				ascII = (int) claveValor.getValor().charAt(i);
				crc = crc ^ ascII; 
			}			
			crc = crc ^ ';';
		}		
		return crc;
	}

}
