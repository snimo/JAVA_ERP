package com.srn.erp.legales.bm;

import java.util.List;

import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.legales.da.DBJuicioEmpresa;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class JuicioEmpresa extends ObjetoLogico {

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public JuicioEmpresa() {
	}

	public static String NICKNAME = "leg.JuicioEmpresa";

	private Juicio juicio;
	private EmpresaJuicio empresaJuicio;
	private Boolean activo;

	public Juicio getJuicio() throws BaseException {
		supportRefresh();
		return juicio;
	}

	public void setJuicio(Juicio aJuicio) {
		this.juicio = aJuicio;
	}

	public EmpresaJuicio getEmpresaJuicio() throws BaseException {
		supportRefresh();
		return this.empresaJuicio;
	}

	public void setEmpresaJuicio(EmpresaJuicio aEmpresaJuicio) {
		this.empresaJuicio = aEmpresaJuicio;
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

	public static JuicioEmpresa findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (JuicioEmpresa) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static JuicioEmpresa findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (JuicioEmpresa) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(juicio, "Debe ingresar el Juicio");
		Validar.noNulo(empresaJuicio, "Debe ingresar la Empresa");
	}

	public static List getJuiciosEmpresa(Juicio aJuicio, ISesion aSesion) throws BaseException {
		return DBJuicioEmpresa.getJuiciosEmpresa(aJuicio, aSesion);
	}

}
