package com.srn.erp.excluidos.bm;

import java.util.List;

import com.srn.erp.excluidos.da.DBSeguExcEstAlgunaVez;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;
import framework.request.bl.Utils.Validar;

public class SeguExcEstAlgunaVez extends ObjetoLogico {

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public SeguExcEstAlgunaVez() {
	}

	public static String NICKNAME = "exc.SeguExcEstAlgunaVez";

	private SeguPerfilExcluido perfil;
	private EstadoExcluido estado;
	private Boolean visualiza;
	private Boolean alta;
	private Boolean baja;
	private Boolean modifica;
	private Boolean activo;

	public SeguPerfilExcluido getPerfil() throws BaseException {
		supportRefresh();
		return perfil;
	}

	public void setPerfil(SeguPerfilExcluido aPerfil) {
		this.perfil = aPerfil;
	}

	public EstadoExcluido getEstado() throws BaseException {
		supportRefresh();
		return estado;
	}

	public void setEstado(EstadoExcluido aEstado) {
		this.estado = aEstado;
	}

	public Boolean isVisualiza() throws BaseException {
		supportRefresh();
		return visualiza;
	}

	public void setVisualiza(Boolean aVisualiza) {
		this.visualiza = aVisualiza;
	}

	public Boolean isAlta() throws BaseException {
		supportRefresh();
		return alta;
	}

	public void setAlta(Boolean aAlta) {
		this.alta = aAlta;
	}

	public Boolean isBaja() throws BaseException {
		supportRefresh();
		return baja;
	}

	public void setBaja(Boolean aBaja) {
		this.baja = aBaja;
	}

	public Boolean isModifica() throws BaseException {
		supportRefresh();
		return modifica;
	}

	public void setModifica(Boolean aModifica) {
		this.modifica = aModifica;
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

	public static SeguExcEstAlgunaVez findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (SeguExcEstAlgunaVez) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static SeguExcEstAlgunaVez findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (SeguExcEstAlgunaVez) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(perfil, "Debe ingresar el Perfil");
		Validar.noNulo(estado, "Debe ingresar el Estado");
	}
	
	public static List getExcAlgunaVez(
			  SeguPerfilExcluido seguPerfilExcluido,
	          ISesion aSesion) throws BaseException {
		  return DBSeguExcEstAlgunaVez.getExcAlgunaVez(seguPerfilExcluido,aSesion);
	}
	
	  public static SeguExcEstAlgunaVez getExcEstAlgunaVez(
			  SeguPerfilExcluido seguPerfilExcluido,
			  EstadoExcluido estado,
	          ISesion aSesion)
	          throws BaseException {
		  
		  return DBSeguExcEstAlgunaVez.getExcEstAlgunaVez(seguPerfilExcluido,estado,aSesion);
		  
	  }	

}
