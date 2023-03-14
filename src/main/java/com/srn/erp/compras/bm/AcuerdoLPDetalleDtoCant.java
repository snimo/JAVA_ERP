package com.srn.erp.compras.bm;

import java.util.List;

import com.srn.erp.compras.da.DBAcuerdoLPDetalleDtoCant;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class AcuerdoLPDetalleDtoCant extends ObjetoLogico {

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public AcuerdoLPDetalleDtoCant() {
	}

	public static String NICKNAME = "cp.AcuerdoLPDetalleDtoCant";

	private AcuerdoLPDetalleDto acu_lp_det_dto;

	private Double cant_desde;

	private Double cant_hasta;

	private Double dto_1;

	private Double dto_2;

	private Double dto_3;

	private Double dto_4;

	private Double dto_5;

	private Boolean en_cascada;

	private Boolean activo;

	public AcuerdoLPDetalleDto getAcu_lp_det_dto() throws BaseException {
		supportRefresh();
		return acu_lp_det_dto;
	}

	public void setAcu_lp_det_dto(AcuerdoLPDetalleDto aAcu_lp_det_dto) {
		this.acu_lp_det_dto = aAcu_lp_det_dto;
	}

	public Double getCant_desde() throws BaseException {
		supportRefresh();
		return cant_desde;
	}

	public void setCant_desde(Double aCant_desde) {
		this.cant_desde = aCant_desde;
	}

	public Double getCant_hasta() throws BaseException {
		supportRefresh();
		return cant_hasta;
	}

	public void setCant_hasta(Double aCant_hasta) {
		this.cant_hasta = aCant_hasta;
	}

	public void setDto_1(Double aDto_1) {
		if (aDto_1 == null)
			this.dto_1 = new Double(0);
		else
			this.dto_1 = aDto_1;
	}

	public Double getDto_1() throws BaseException {
		supportRefresh();
		return dto_1;
	}

	public Double getDto_2() throws BaseException {
		supportRefresh();
		return dto_2;
	}

	public void setDto_2(Double aDto_2) {
		if (aDto_2 == null)
			this.dto_2 = new Double(0);
		else
			this.dto_2 = aDto_2;
	}

	public Double getDto_3() throws BaseException {
		supportRefresh();
		return dto_3;
	}

	public void setDto_3(Double aDto_3) {
		if (aDto_3 == null)
			this.dto_3 = new Double(0);
		else
			this.dto_3 = aDto_3;
	}

	public Double getDto_4() throws BaseException {
		supportRefresh();
		return dto_4;
	}

	public void setDto_4(Double aDto_4) {
		if (aDto_4 == null)
			this.dto_4 = new Double(0);
		else
			this.dto_4 = aDto_4;
	}

	public Double getDto_5() throws BaseException {
		supportRefresh();
		return dto_5;
	}

	public void setDto_5(Double aDto_5) {
		if (aDto_5 == null)
			this.dto_5 = new Double(0);
		else
			this.dto_5 = aDto_5;
	}

	public Boolean isEn_cascada() throws BaseException {
		supportRefresh();
		return en_cascada;
	}

	public void setEn_cascada(Boolean aEn_cascada) {
		this.en_cascada = aEn_cascada;
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

	public static AcuerdoLPDetalleDtoCant findByOid(Integer oid, ISesion aSesion)
			throws BaseException {
		return (AcuerdoLPDetalleDtoCant) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static AcuerdoLPDetalleDtoCant findByCodigo(String codigo,
			ISesion aSesion) throws BaseException {
		return (AcuerdoLPDetalleDtoCant) getObjectByCodigo(NICKNAME, codigo,
				aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(acu_lp_det_dto, "Debe ingresar el acuerdo detalle Dto.");
		Validar.noNulo(cant_desde, "Debe ingresar la cantidad desde");
		Validar.noNulo(cant_hasta, "Debe ingresar la cantidad hasta");
		Validar.noNulo(en_cascada, "Debe ingresar si es o no en cascada");
	}

	public static List getAcuerdosLPDetallesDtoCant(
			AcuerdoLPDetalleDto acuerdoLPDetDto, ISesion aSesion)
			throws BaseException {
		return DBAcuerdoLPDetalleDtoCant.getAcuerdosLPDetallesDtoCant(
				acuerdoLPDetDto, aSesion);
	}

}
