package com.srn.erp.rrhh.bm;

import java.util.List;

import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.rrhh.da.DBJerarquiaDesa;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class JerarquiaDesa extends ObjetoLogico {

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public JerarquiaDesa() {
	}

	public static String NICKNAME = "rh.JerarquiaDesa";

	private AccCronoDesa accion;
	private ValorClasificadorEntidad val_clasif_empresa;
	private ValorClasificadorEntidad val_clasif_sector;
	private ValorClasificadorEntidad val_clasif_puesto;
	private Boolean activo;
	private Integer orden;
	private ValorClasificadorEntidad categPosible;
	private Integer cantAniosPuesto;
	private Integer cantMesesPuesto;
	private RankearCab rankear;
	private Money puntosMinEval;
	private Money puntosMinCalifGen;
	private Integer cantMinJuegosA;
	private Integer cantAniosHC;
	private Integer cantMesesHC;
	private Integer ultMesesEvalPot;
	private Boolean evalPendSinEvalDesemp;
	private Boolean evalPendSinJuegos;
	private Boolean evalPendSinIRL;
	private Boolean evalPendSinPot;
	private Integer ultMesesIRL;

	public Integer getUltMesesEvalPot() throws BaseException {
		supportRefresh();
		return this.ultMesesEvalPot;
	}	
	
	public Integer getUltMesesIRL() throws BaseException {
		supportRefresh();
		return this.ultMesesIRL;
	}	
	
	public Boolean isEvalPendSinIRL() throws BaseException {
		supportRefresh();
		return this.evalPendSinIRL;
	}	
	
	public Boolean isEvalPendSinPot() throws BaseException {
		supportRefresh();
		return this.evalPendSinPot;
	}	
	
	public void setUltMesesEvalPot(Integer aUltMesesEvalPot) {
		this.ultMesesEvalPot = aUltMesesEvalPot;
	}
	
	public void setUltMesesIRL(Integer aUltMesesIRL) {
		this.ultMesesIRL = aUltMesesIRL;
	}	
	
	public void setEvalPendSinIRL(Boolean aEvalPendSinIRL) {
		this.evalPendSinIRL = aEvalPendSinIRL;
	}	
	
	public void setEvalPendSinPot(Boolean aEvalPendSinPot) {
		this.evalPendSinPot = aEvalPendSinPot;
	}	
	
	public Boolean isPendEvalSiFaltaEvalDesemp() throws BaseException {
		supportRefresh();
		return this.evalPendSinEvalDesemp;
	}	
	
	public void setPendEvalSiFaltaEvalDesemp(Boolean aPendEvalSiFaltaEvalDesep) {
		this.evalPendSinEvalDesemp = aPendEvalSiFaltaEvalDesep;
	}	
	
	public Boolean isPendEvalSiFaltaJuegos() throws BaseException {
		supportRefresh();
		return this.evalPendSinJuegos;
	}	
	
	public void setPendEvalSiFaltaJuegos(Boolean aPendEvalSiFaltaJuegos) {
		this.evalPendSinJuegos = aPendEvalSiFaltaJuegos;
	}	
	
	
	public AccCronoDesa getAccion() throws BaseException {
		supportRefresh();
		return accion;
	}
	
	public Integer getCantAniosHC() throws BaseException {
		supportRefresh();
		return this.cantAniosHC;
	}
	
	public Integer getCantMesesHC() throws BaseException {
		supportRefresh();
		return this.cantMesesHC;
	}
	
	
	public Integer getCantMinJuegosA() throws BaseException {
		supportRefresh();
		return this.cantMinJuegosA;
	}
	
	
	public Money getPuntosMinEval() throws BaseException {
		supportRefresh();
		return this.puntosMinEval;
	}
	
	public Money getPuntosMinCalifGen() throws BaseException {
		supportRefresh();
		return this.puntosMinCalifGen;
	}	
	

	public RankearCab getRankearCab() throws BaseException {
		supportRefresh();
		return this.rankear;
	}

	public ValorClasificadorEntidad getCategPosible() throws BaseException {
		supportRefresh();
		return this.categPosible;
	}

	public Integer getOrden() throws BaseException {
		supportRefresh();
		return orden;
	}

	public Integer getCantAniosPuesto() throws BaseException {
		supportRefresh();
		return this.cantAniosPuesto;
	}

	public Integer getCantMesesPuesto() throws BaseException {
		supportRefresh();
		return this.cantMesesPuesto;
	}

	public void setAccion(AccCronoDesa aAccion) {
		this.accion = aAccion;
	}
	
	public void setCantAniosHC(Integer aCantAniosHC) {
		this.cantAniosHC = aCantAniosHC;
	}
	
	public void setCantMesesHC(Integer aCantMesesHC) {
		this.cantMesesHC = aCantMesesHC;
	}

	public void setCantMinJuegosA(Integer aCantMinJuegosA) {
		this.cantMinJuegosA = aCantMinJuegosA;
	}
	
	public void setRankearCab(RankearCab aRankearCab) {
		this.rankear = aRankearCab;
	}

	public void setPuntosMinEval(Money aPuntosMinEval) {
		this.puntosMinEval = aPuntosMinEval;
	}
	
	public void setPuntosMinCalifGen(Money aPuntosMinCalifGen) {
		this.puntosMinCalifGen = aPuntosMinCalifGen;
	}	
	
	public void setCantAniosPuesto(Integer aCantAniosPuesto) {
		this.cantAniosPuesto = aCantAniosPuesto;
	}

	public void setCantMesesPuesto(Integer aCantMesesPuesto) {
		this.cantMesesPuesto = aCantMesesPuesto;
	}

	public void setCategPosible(ValorClasificadorEntidad aCategPosible) {
		this.categPosible = aCategPosible;
	}

	public void setOrden(Integer aOrden) {
		this.orden = aOrden;
	}

	public ValorClasificadorEntidad getVal_clasif_empresa() throws BaseException {
		supportRefresh();
		return val_clasif_empresa;
	}

	public void setVal_clasif_empresa(ValorClasificadorEntidad aVal_clasif_empresa) {
		this.val_clasif_empresa = aVal_clasif_empresa;
	}

	public ValorClasificadorEntidad getVal_clasif_sector() throws BaseException {
		supportRefresh();
		return val_clasif_sector;
	}

	public void setVal_clasif_sector(ValorClasificadorEntidad aVal_clasif_sector) {
		this.val_clasif_sector = aVal_clasif_sector;
	}

	public ValorClasificadorEntidad getVal_clasif_puesto() throws BaseException {
		supportRefresh();
		return val_clasif_puesto;
	}

	public void setVal_clasif_puesto(ValorClasificadorEntidad aVal_clasif_puesto) {
		this.val_clasif_puesto = aVal_clasif_puesto;
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

	public static JerarquiaDesa findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (JerarquiaDesa) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static JerarquiaDesa findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (JerarquiaDesa) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(accion, "Debe ingresar la Acción");
		Validar.noNulo(val_clasif_empresa, "Debe ingresar la Empresa");
		Validar.noNulo(val_clasif_sector, "Debe ingresar el Sector");
		Validar.noNulo(val_clasif_puesto, "Debe ingresar el Puesto");
	}

	public static List getJerarquiasDesa(AccCronoDesa aAccCronoDesa, ISesion aSesion) throws BaseException {
		return DBJerarquiaDesa.getJerarquiasDesa(aAccCronoDesa, aSesion);
	}

	public static JerarquiaDesa getJerarquiaDesa(AccCronoDesa accCronoDesa, ValorClasificadorEntidad valorClasifEmp, ValorClasificadorEntidad valorClasifSec, ValorClasificadorEntidad valorClasifPue,
			ISesion aSesion) throws BaseException {
		return DBJerarquiaDesa.getJerarquiaDesa(accCronoDesa, valorClasifEmp, valorClasifSec, valorClasifPue, aSesion);
	}

}
