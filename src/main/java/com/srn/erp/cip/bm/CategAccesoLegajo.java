package com.srn.erp.cip.bm;

import java.util.List;

import com.srn.erp.cip.da.DBCategAccesoLegajo;
import com.srn.erp.sueldos.bm.Legajo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class CategAccesoLegajo extends ObjetoLogico {

	public CategAccesoLegajo() {
	}

	public static String NICKNAME = "cip.CategAccesoLegajo";

	private CategAccesoCIP categoria;
	private Legajo legajo;
	private Boolean activo;

	public CategAccesoCIP getCategoria() throws BaseException {
		supportRefresh();
		return categoria;
	}

	public void setCategoria(CategAccesoCIP aCategoria) {
		this.categoria = aCategoria;
	}

	public Legajo getLegajo() throws BaseException {
		supportRefresh();
		return legajo;
	}

	public void setLegajo(Legajo aLegajo) {
		this.legajo = aLegajo;
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

	public static CategAccesoLegajo findByOid(Integer oid, ISesion aSesion)
			throws BaseException {
		return (CategAccesoLegajo) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static CategAccesoLegajo findByCodigo(String codigo, ISesion aSesion)
			throws BaseException {
		return (CategAccesoLegajo) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(categoria, "Debe ingresar la Categoría");
		Validar.noNulo(legajo, "Debe ingresar el Legajo");
	}

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public static List getCategAccesosLegajo(Legajo aLegajo, ISesion aSesion)
			throws BaseException {
		return DBCategAccesoLegajo.getCategAccesosLegajo(aLegajo, aSesion);
	}

	public static CategAccesoLegajo getCategAccesoLegajo(CategAccesoCIP aCategAccesoCIP, Legajo legajo, ISesion aSesion)
			throws BaseException {
		return DBCategAccesoLegajo.getCategAccesoLegajo(aCategAccesoCIP,legajo, aSesion);
	}

}
