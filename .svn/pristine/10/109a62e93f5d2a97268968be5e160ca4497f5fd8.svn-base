package com.srn.erp.compras.bm;

import java.util.List;

import com.srn.erp.compras.da.DBMotivoRechazoInfCC;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class MotivoRechazoInfCC extends ObjetoLogico {

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public MotivoRechazoInfCC() {
	}

	public static String NICKNAME = "cp.MotivoRechazoInfCC";

	private InformeControlCalidadDet inf_cc_det;

	private Double cant_mal_uc;

	private Double cant_mal_us;

	private Boolean activo;

	private MotivoRechazoCC motivoRechazoCC;

	public void setMotivoRechazoCC(MotivoRechazoCC aMotivoRechazoCC)
			throws BaseException {
		this.motivoRechazoCC = aMotivoRechazoCC;
	}

	public MotivoRechazoCC getMotivoRechazoCC() throws BaseException {
		supportRefresh();
		return this.motivoRechazoCC;
	}

	public InformeControlCalidadDet getInf_cc_det() throws BaseException {
		supportRefresh();
		return inf_cc_det;
	}

	public void setInf_cc_det(InformeControlCalidadDet aInf_cc_det) {
		this.inf_cc_det = aInf_cc_det;
	}

	public Double getCant_mal_uc() throws BaseException {
		supportRefresh();
		return cant_mal_uc;
	}

	public void setCant_mal_uc(Double aCant_mal_uc) {
		this.cant_mal_uc = aCant_mal_uc;
	}

	public Double getCant_mal_us() throws BaseException {
		supportRefresh();
		return cant_mal_us;
	}

	public void setCant_mal_us(Double aCant_mal_us) {
		this.cant_mal_us = aCant_mal_us;
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

	public static MotivoRechazoInfCC findByOid(Integer oid, ISesion aSesion)
			throws BaseException {
		return (MotivoRechazoInfCC) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static MotivoRechazoInfCC findByOidProxy(Integer oid, ISesion aSesion)
			throws BaseException {
		return (MotivoRechazoInfCC) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static MotivoRechazoInfCC findByCodigo(String codigo, ISesion aSesion)
			throws BaseException {
		return (MotivoRechazoInfCC) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(inf_cc_det, "Debe ingresar un detalle de Inf. de CC");
	}

	public static List getMotivosRechazoInfCCDet(InformeControlCalidadDet aInfCCDet,
			ISesion aSesion) throws BaseException {
		return DBMotivoRechazoInfCC.getMotivosRechazoInfCCDet(aInfCCDet,aSesion);
	}
	
}
