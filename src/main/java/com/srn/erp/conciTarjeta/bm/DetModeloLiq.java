package com.srn.erp.conciTarjeta.bm;

import java.util.List;

import com.srn.erp.conciTarjeta.da.DBDetModeloLiq;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class DetModeloLiq extends ObjetoLogico {

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public DetModeloLiq() {
	}

	public static String NICKNAME = "ctar.DetModeloLiq";

	private CabModeloLiq modelo;
	private Integer orden;
	private String cuenta;
	private String desc_cuenta;
	private String compo1;
	private String compo2;
	private Double debe;
	private Double haber;
	private Boolean activo;
	private String codImpuesto;
	private Money porcImp;

	public CabModeloLiq getModelo() throws BaseException {
		supportRefresh();
		return modelo;
	}
	
	public Money getPorcImp() throws BaseException {
		supportRefresh();
		return this.porcImp;		
	}

	public void setModelo(CabModeloLiq aModelo) {
		this.modelo = aModelo;
	}
	
	public void setPorcImp(Money aPorcImp) {
		this.porcImp = aPorcImp;
	}	

	public Integer getOrden() throws BaseException {
		supportRefresh();
		return orden;
	}

	public void setOrden(Integer aOrden) {
		this.orden = aOrden;
	}

	public String getCuenta() throws BaseException {
		supportRefresh();
		return cuenta;
	}

	public void setCuenta(String aCuenta) {
		this.cuenta = aCuenta;
	}

	public String getDesc_cuenta() throws BaseException {
		supportRefresh();
		return desc_cuenta;
	}

	public void setDesc_cuenta(String aDesc_cuenta) {
		this.desc_cuenta = aDesc_cuenta;
	}

	public String getCompo1() throws BaseException {
		supportRefresh();
		return compo1;
	}

	public void setCompo1(String aCompo1) {
		this.compo1 = aCompo1;
	}
	
	public void setCodImpuesto(String aCodImpuesto) {
		this.codImpuesto = aCodImpuesto;
	}	

	public String getCompo2() throws BaseException {
		supportRefresh();
		return compo2;
	}
	
	public String getCodImpuesto() throws BaseException {
		supportRefresh();
		return this.codImpuesto;
	}	

	public void setCompo2(String aCompo2) {
		this.compo2 = aCompo2;
	}

	public Double getDebe() throws BaseException {
		supportRefresh();
		return debe;
	}

	public void setDebe(Double aDebe) {
		this.debe = aDebe;
	}

	public Double getHaber() throws BaseException {
		supportRefresh();
		return haber;
	}

	public void setHaber(Double aHaber) {
		this.haber = aHaber;
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

	public static DetModeloLiq findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (DetModeloLiq) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static DetModeloLiq findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (DetModeloLiq) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(modelo, "Debe ingresar el Modelo");
		Validar.noNulo(cuenta, "Debe ingresar la cuenta");
	}

	public static List getDetallesModLiq(CabModeloLiq cabModeloLiq, ISesion aSesion) throws BaseException {
		return DBDetModeloLiq.getDetallesModLiq(cabModeloLiq, aSesion);
	}

}
