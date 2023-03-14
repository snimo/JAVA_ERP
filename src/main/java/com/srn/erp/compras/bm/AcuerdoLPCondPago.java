package com.srn.erp.compras.bm;

import java.util.List;

import com.srn.erp.compras.da.DBAcuerdoLPCondPago;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class AcuerdoLPCondPago extends ObjetoLogico {

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public AcuerdoLPCondPago() {
	}

	public static String NICKNAME = "cp.AcuerdoLPCondPago";

	private AcuerdoLP AcuerdoLP;

	private CondicionCompra condicion_pago;

	private Double dto_1;

	private Double dto_2;

	private Double dto_3;

	private Double dto_4;

	private Double dto_5;

	private Boolean en_cascada;

	private Boolean activo;

	public AcuerdoLP getAcuerdolp() throws BaseException {
		supportRefresh();
		return AcuerdoLP;
	}

	public void setAcuerdolp(AcuerdoLP aAcuerdolp) {
		this.AcuerdoLP = aAcuerdolp;
	}

	public CondicionCompra getCondicion_pago() throws BaseException {
		supportRefresh();
		return condicion_pago;
	}

	public void setCondicion_pago(CondicionCompra aCondicion_pago) {
		this.condicion_pago = aCondicion_pago;
	}

	public Double getDto_1() throws BaseException {
		supportRefresh();
		return dto_1;
	}

	public void setDto_1(Double aDto_1) {
		if (aDto_1==null)
			this.dto_1 = new Double(0);	
			else this.dto_1 = aDto_1;
	}

	public Double getDto_2() throws BaseException {
		supportRefresh();
		return dto_2;
	}

	public void setDto_2(Double aDto_2) {
		if (aDto_2 == null)
			this.dto_2 = new Double(0);
			else this.dto_2 = aDto_2;
	}

	public Double getDto_3() throws BaseException {
		supportRefresh();
		return dto_3;
	}

	public void setDto_3(Double aDto_3) {
		if (aDto_3 == null)
			this.dto_3 = new Double(0);
		 	else this.dto_3 = aDto_3;
	}

	public Double getDto_4() throws BaseException {
		supportRefresh();
		return dto_4;
	}

	public void setDto_4(Double aDto_4) {
		if (aDto_4==null)
			this.dto_4 = new Double(0);
		else this.dto_4 = aDto_4;
	}

	public Double getDto_5() throws BaseException {
		supportRefresh();
		return dto_5;
	}

	public void setDto_5(Double aDto_5) {
		if (aDto_5 == null)
			this.dto_5 = new Double(0);
			else this.dto_5 = aDto_5;
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

	public static AcuerdoLPCondPago findByOid(Integer oid, ISesion aSesion)
			throws BaseException {
		return (AcuerdoLPCondPago) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static AcuerdoLPCondPago findByCodigo(String codigo, ISesion aSesion)
			throws BaseException {
		return (AcuerdoLPCondPago) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(AcuerdoLP, "Debe ingresar el Acuerdo de Precios");
		Validar.noNulo(condicion_pago, "Debe ingresar la condición de Compra");
		Validar.noNulo(en_cascada, "Debe ingresar si es o no en cascada");
	}

	protected void onNew() throws BaseException {
		// TODO Auto-generated method stub
		super.onNew();
		dto_1 = new Double(0);
		dto_2 = new Double(0);
		dto_3 = new Double(0);
		dto_4 = new Double(0);
		dto_5 = new Double(0);
		en_cascada = new Boolean(false);
		activo = new Boolean(false);
	}

	public static List getAcuerdosLPCondPago(AcuerdoLP acuerdoLP,ISesion aSesion) throws BaseException {
		return DBAcuerdoLPCondPago.getAcuerdosLPCondPago(acuerdoLP,aSesion);
	}

}
