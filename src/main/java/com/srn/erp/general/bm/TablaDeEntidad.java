package com.srn.erp.general.bm;

public class TablaDeEntidad {
	
	public TablaDeEntidad(String nombreNickname,String nombreTablaFisica) {
		this.nombreNickName = nombreNickname;
		this.nombreTablaFisica = nombreTablaFisica;
	}
	
	private String nombreNickName;
	private String nombreTablaFisica;
	
	public String getNombreNickName() {
		return nombreNickName;
	}
	public void setNombreNickName(String nombreNickName) {
		this.nombreNickName = nombreNickName;
	}
	public String getNombreTablaFisica() {
		return nombreTablaFisica;
	}
	public void setNombreTablaFisica(String nombreTablaFisica) {
		this.nombreTablaFisica = nombreTablaFisica;
	}
	

}
