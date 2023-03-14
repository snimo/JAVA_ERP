package com.srn.erp.legales.bm;

import java.util.List;

import com.srn.erp.legales.da.DBEmpresaJuicio;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ObjetoObservado;
import framework.request.bl.Utils.Validar;

public class EmpresaJuicio extends ObjetoLogico {

	public EmpresaJuicio() {
	}

	public static String NICKNAME = "leg.EmpresaJuicio";

	private String codigo;
	private String descripcion;
	private Boolean activo;

	public String getCodigo() throws BaseException {
		supportRefresh();
		return codigo;
	}

	public void setCodigo(String aCodigo) {
		this.codigo = aCodigo;
	}

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

	public static EmpresaJuicio findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (EmpresaJuicio) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static EmpresaJuicio findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (EmpresaJuicio) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static EmpresaJuicio findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (EmpresaJuicio) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(codigo, "Debe ingresar el Código");
	}

	public static List getAll(ISesion aSesion) throws BaseException {
		return DBEmpresaJuicio.getaAll(aSesion);
	}
	
	public static EmpresaJuicio getEmpresaJuicio(
			  String descripcion,
	          ISesion aSesion)
	          throws BaseException {
		  return DBEmpresaJuicio.getEmpresaJuicio(descripcion,aSesion);
	}	
	

}
