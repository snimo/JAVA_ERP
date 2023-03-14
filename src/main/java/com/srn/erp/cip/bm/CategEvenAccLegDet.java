package com.srn.erp.cip.bm;

import java.util.List;

import com.srn.erp.cip.da.DBCategEvenAccLegDet;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class CategEvenAccLegDet extends ObjetoLogico {

	public CategEvenAccLegDet() {
	}

	public static String NICKNAME = "cip.CategEvenAccLegDet";

	private CategEvenAccesoLeg categ_eventual_leg;
	private CategAccesoCIP categoria;
	private Boolean activo;

	public CategEvenAccesoLeg getCateg_eventual_leg() throws BaseException {
		supportRefresh();
		return categ_eventual_leg;
	}

	public void setCateg_eventual_leg(CategEvenAccesoLeg aCateg_eventual_leg) {
		this.categ_eventual_leg = aCateg_eventual_leg;
	}

	public CategAccesoCIP getCategoria() throws BaseException {
		supportRefresh();
		return categoria;
	}

	public void setCategoria(CategAccesoCIP aCategoria) {
		this.categoria = aCategoria;
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

	public static CategEvenAccLegDet findByOid(Integer oid, ISesion aSesion)
			throws BaseException {
		return (CategEvenAccLegDet) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static CategEvenAccLegDet findByCodigo(String codigo, ISesion aSesion)
			throws BaseException {
		return (CategEvenAccLegDet) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(categ_eventual_leg,
				"Debe ingresar la Categoría del Legajo");
		Validar.noNulo(categoria, "Debe ingresar la categoría");
	}

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static List getCategEventualesDet(CategEvenAccesoLeg categEvenAccesoLeg,
	          ISesion aSesion) throws BaseException {
		  return DBCategEvenAccLegDet.getCategEventualesDet(categEvenAccesoLeg,aSesion);
	}
	

}
