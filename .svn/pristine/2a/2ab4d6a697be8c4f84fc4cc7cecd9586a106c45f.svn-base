package com.srn.erp.rrhh.bm;

import java.util.List;

import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.rrhh.da.DBCategPosibleLeg;
import com.srn.erp.sueldos.bm.Legajo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class CategPosibleLeg extends ObjetoLogico {

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public CategPosibleLeg() {
	}

	public static String NICKNAME = "rh.CategPosibleLeg";

	private Legajo legajo;
	private ValorClasificadorEntidad categ_posible;
	private java.util.Date fec_desde;
	private java.util.Date fec_hasta;
	private Boolean activo;
	private RankearCab rankear;

	public Legajo getLegajo() throws BaseException {
		supportRefresh();
		return legajo;
	}

	public RankearCab getRankearCab() throws BaseException {
		supportRefresh();
		return this.rankear;
	}

	public void setRankearCab(RankearCab aRankearCab) throws BaseException {
		this.rankear = aRankearCab;
	}

	public void setLegajo(Legajo aLegajo) {
		this.legajo = aLegajo;
	}

	public ValorClasificadorEntidad getCateg_posible() throws BaseException {
		supportRefresh();
		return categ_posible;
	}

	public void setCateg_posible(ValorClasificadorEntidad aCateg_posible) {
		this.categ_posible = aCateg_posible;
	}

	public java.util.Date getFec_desde() throws BaseException {
		supportRefresh();
		return fec_desde;
	}

	public void setFec_desde(java.util.Date aFec_desde) {
		this.fec_desde = aFec_desde;
	}

	public java.util.Date getFec_hasta() throws BaseException {
		supportRefresh();
		return fec_hasta;
	}

	public void setFec_hasta(java.util.Date aFec_hasta) {
		this.fec_hasta = aFec_hasta;
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

	public static CategPosibleLeg findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (CategPosibleLeg) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static CategPosibleLeg findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (CategPosibleLeg) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(legajo, "Debe ingresar el Legajo");
		Validar.noNulo(categ_posible, "Debe ingresar la Categoría");
		Validar.noNulo(fec_desde, "Debe ingresar la Fecha Desde");
		Validar.noNulo(fec_hasta, "Debe ingresar la Fecha Hasta");
	}

	public static List getCategPosibleLeg(Legajo aLegajo, ISesion aSesion) throws BaseException {
		return DBCategPosibleLeg.getCategPosibleLeg(aLegajo, aSesion);
	}

	public static CategPosibleLeg getCategPosibleLeg(Legajo aLegajo, java.util.Date fecha, ISesion aSesion) throws BaseException {
		return DBCategPosibleLeg.getCategPosibleLeg(aLegajo, fecha, aSesion);
	}

}
