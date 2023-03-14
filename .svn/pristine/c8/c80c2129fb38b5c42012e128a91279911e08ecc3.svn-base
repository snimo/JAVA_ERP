package com.srn.erp.conciTarjeta.bm;

import java.util.List;

import com.srn.erp.conciTarjeta.da.DBTipoArchConciTar;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class TipoArchConciTar extends ObjetoLogico {

	public TipoArchConciTar() {
	}

	public static String NICKNAME = "ctar.TipoArchConciTar";

	private String codigo;
	private String descripcion;
	private String comportamiento;
	private String ant_ult_folder_emp;
	private String ult_folder_tipo;
	private Boolean activo;
	private String codArchImpTarj;

	public String getCodigo() throws BaseException {
		supportRefresh();
		return codigo;
	}

	public String getCodArchImpTarj() throws BaseException {
		supportRefresh();
		return this.codArchImpTarj;
	}

	public void setCodigo(String aCodigo) {
		this.codigo = aCodigo;
	}

	public void setCodArchImpTarj(String aCodArchImpTarj) {
		this.codArchImpTarj = aCodArchImpTarj;
	}

	public String getDescripcion() throws BaseException {
		supportRefresh();
		return descripcion;
	}

	public void setDescripcion(String aDescripcion) {
		this.descripcion = aDescripcion;
	}

	public String getComportamiento() throws BaseException {
		supportRefresh();
		return comportamiento;
	}

	public void setComportamiento(String aComportamiento) {
		this.comportamiento = aComportamiento;
	}

	public String getAnt_ult_folder_emp() throws BaseException {
		supportRefresh();
		return ant_ult_folder_emp;
	}

	public void setAnt_ult_folder_emp(String aAnt_ult_folder_emp) {
		this.ant_ult_folder_emp = aAnt_ult_folder_emp;
	}

	public String getUlt_folder_tipo() throws BaseException {
		supportRefresh();
		return ult_folder_tipo;
	}

	public void setUlt_folder_tipo(String aUlt_folder_tipo) {
		this.ult_folder_tipo = aUlt_folder_tipo;
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

	public static TipoArchConciTar findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (TipoArchConciTar) getObjectByOid(NICKNAME, oid, aSesion);
	}
	
	public static TipoArchConciTar findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (TipoArchConciTar) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}	

	public static TipoArchConciTar findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (TipoArchConciTar) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(this.codigo, "Debe ingresar el Código");
		Validar.noNulo(this.descripcion, "Debe ingresar la Descripción");
		Validar.noNulo(this.comportamiento, "Debe ingresar el Comportamiento");
	}

	public static List getAllActivos(ISesion aSesion) throws BaseException {
		return DBTipoArchConciTar.getAllActivos(aSesion);
	}

}
