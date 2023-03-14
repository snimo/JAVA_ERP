package com.srn.erp.general.bm;

import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;

public class Memo {
	
	ISesion sesion;
	
	public Memo(ISesion aSesion) {
		this.sesion = aSesion;
	}
	
	public Memo(Integer oid,String clave,ISesion aSesion) {
		this.oid = oid;
		this.clave = clave;
		this.sesion = aSesion;
	}
	
	private String comentario = null;
	private Integer oid;
	private String clave;
	
	public void setComentario(String aComentario) {
		this.comentario = aComentario;
	}
	
	public String getComentario() throws BaseException {
		if (comentario == null) 
		  comentario = ComentarioGeneral.getComentariosConcatenados(getOid(),getClave(),sesion);
		return comentario;
	}
	
	private String getComentarioFormDB() throws BaseException {
		return ComentarioGeneral.getComentariosConcatenados(getOid(),getClave(),sesion);
	}
	
	public void setOid(Integer aOid) {
		this.oid = aOid;
	}
	
	public Integer getOid() {
		return this.oid;
	}
	
	public void setClave(String aClave) {
		this.clave = aClave;
	}
	
	public String getClave() {
		return this.clave;
	}	
	
	public void save() throws BaseException {
		
		// Borrar comentario actual
		String comenFromDB = getComentarioFormDB();
		String comenActual = this.getComentario();
		
		if ((comenFromDB!=null) && (comenActual!=null)) 
			if (comenFromDB.equals(comenActual)) return;
		
		ComentarioGeneral.borrarComentario(this.getOid(),this.getClave(),this.sesion);
		
		if (this.comentario == null) return;
		
		// Descomponer en linea de 255 caracteres
		int letras = 0;
		int nroLinea = 0;
		StringBuffer linea = new StringBuffer("");
		for(int i=0;i<this.comentario.length();++i) {
			
			if (letras>=254) {
				// Grabar el comentario
				++nroLinea;
				ComentarioGeneral comentarioGeneral = (ComentarioGeneral)ComentarioGeneral.getNew(ComentarioGeneral.NICKNAME,this.sesion);
				comentarioGeneral.setOidObjeto(this.getOid());
				comentarioGeneral.setClave(this.getClave());
				comentarioGeneral.setSecu(new Integer(nroLinea));
				comentarioGeneral.setComentario(linea.toString());
				System.out.println(linea.toString());
				comentarioGeneral.save();
				linea = new StringBuffer("");
				letras = 0;
			}
			
			++letras;
			if (letras<255) {
				linea.append(this.comentario.charAt(i));
			}
		}
		
		if (linea.length()>0) {
			++nroLinea;
			ComentarioGeneral comentarioGeneral = (ComentarioGeneral)ComentarioGeneral.getNew(ComentarioGeneral.NICKNAME,this.sesion);
			comentarioGeneral.setOidObjeto(this.getOid());
			comentarioGeneral.setClave(this.getClave());
			comentarioGeneral.setSecu(new Integer(nroLinea));
			comentarioGeneral.setComentario(linea.toString());
			comentarioGeneral.save();
		}
		
	}
	
	

}
