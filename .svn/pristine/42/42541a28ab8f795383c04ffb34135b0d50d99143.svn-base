package com.srn.erp.legales.bm;

import java.util.List;

import com.srn.erp.legales.da.DBTipoReclamoLeg;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ObjetoObservado;

public class TipoReclamoLeg extends ObjetoLogico {

	public TipoReclamoLeg() {
	}

	public static String NICKNAME = "leg.TipoReclamoLeg";

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	private String descripcion;
	private Boolean activo;

	public String getDescripcion() throws BaseException {
		supportRefresh();
		return descripcion;
	}

	public void setDescripcion(String aDescripcion) {
		this.descripcion = aDescripcion;
	}

	public Boolean isActivo() throws BaseException {
		supportRefresh();
		return activo;
	}

	public void setActivo(Boolean aActivo) {
		this.activo = aActivo;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static TipoReclamoLeg findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (TipoReclamoLeg) getObjectByOid(NICKNAME, oid, aSesion);
	}
	
	public static TipoReclamoLeg findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (TipoReclamoLeg) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}
	

	public static TipoReclamoLeg findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (TipoReclamoLeg) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
	}
	
	public static TipoReclamoLeg getTipoReclamoLeg(
			  String descripcion,
	          ISesion aSesion)
	          throws BaseException {
		  return DBTipoReclamoLeg.getTipoReclamoLeg(descripcion,aSesion);
	}
	
	public static List getAllTiposReclamos(ISesion aSesion) throws BaseException {
		return DBTipoReclamoLeg.getAllTiposReclamos(aSesion);
	}
	
	

}
