package com.srn.erp.general.bm;

import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;

public class LabelTranslator {
	
	ISesion sesion = null;
	Idioma idioma = null;
	String nickName = null;
	
	public  LabelTranslator(ISesion aSesion) {
		this.sesion = aSesion;
	}
	
	public void setIdioma(Idioma aIdioma) {
		this.idioma = aIdioma;
	}
	
	public Idioma getIdioma() {
		return this.idioma;
	}
	
	public void setNickName(String aNickName) {
		this.nickName = aNickName;
	}
	
	public String getNickName() {
		return this.nickName;
	}
	
	public String getEtiqueta(String aEtiqueta) throws BaseException {
		EtiquetaIdioma etiquetaIdioma = 
			EtiquetaIdioma.getEtiquetaIdioma(this.getNickName(),aEtiqueta,this.sesion);
		if (etiquetaIdioma!=null) {
			ValorEtiquetaIdioma valorEtiquetaIdioma = 
				etiquetaIdioma.getValorEtiqueta(this.getIdioma());
			if (valorEtiquetaIdioma!=null) return valorEtiquetaIdioma.getDescripcion();
		}
		return "";
	}

}
