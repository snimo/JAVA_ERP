package com.srn.erp.general.bm;

import java.util.Iterator;
import java.util.List;

import com.srn.erp.general.da.DBComentarioGeneral;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;

public class ComentarioGeneral extends ObjetoLogico {

	public ComentarioGeneral() {
	}

	public static String	NICKNAME	= "ge.ComentarioGeneral";

	private Integer				oidObjeto;

	private String				clave;

	private Integer				secu;

	private String				comentario;

	public Integer getOidObjeto() throws BaseException {
		supportRefresh();
		return oidObjeto;
	}

	public void setOidObjeto(Integer aOidObjeto) {
		this.oidObjeto = aOidObjeto;
	}

	public String getClave() throws BaseException {
		supportRefresh();
		return clave;
	}

	public void setClave(String aClave) {
		this.clave = aClave;
	}

	public Integer getSecu() throws BaseException {
		supportRefresh();
		return secu;
	}

	public void setSecu(Integer aSecu) {
		this.secu = aSecu;
	}

	public void setComentario(String aComentario) {
		this.comentario = aComentario;
	}
	
	public String getComentario() throws BaseException {
		supportRefresh();
		return comentario;
	}
	

	public String getNickName() {
		return NICKNAME;
	}

	public static ComentarioGeneral findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (ComentarioGeneral) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static ComentarioGeneral findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (ComentarioGeneral) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
	}

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean isActivo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public static String getComentariosConcatenados(Integer oidObjNeg,String clave,ISesion aSesion) throws BaseException {
		StringBuffer comen = new StringBuffer();
		List comentariosGenerales = DBComentarioGeneral.getComentariosGeneral(oidObjNeg,clave, aSesion); 
		Iterator iterLineaComen = 
			comentariosGenerales.iterator();
		while (iterLineaComen.hasNext()) {
			ComentarioGeneral comentarioGeneral = (ComentarioGeneral) iterLineaComen.next();
			comen.append(comentarioGeneral.getComentario());
		}
		return comen.toString();
	}
	
	public static void borrarComentario(Integer oid, String clave, ISesion aSesion) throws BaseException {
		DBComentarioGeneral.borrarComentario(oid,clave,aSesion);
	}

}
