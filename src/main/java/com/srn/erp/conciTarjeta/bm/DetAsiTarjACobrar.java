package com.srn.erp.conciTarjeta.bm;

import java.util.List;

import com.srn.erp.conciTarjeta.da.DBDetAsiTarjACobrar;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.Validar;

public class DetAsiTarjACobrar extends ObjetoLogico {

	public DetAsiTarjACobrar() {
	}

	public static String NICKNAME = "ctar.DetAsiTarjACobrar";

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	private Integer orden;
	private CabAsiTarjACobrar cab_asi_acob;
	private String cuenta;
	private String compo1;
	private String compo2;
	private Double debe;
	private Double haber;
	private Boolean activo;

	public Integer getOrden() throws BaseException {
		supportRefresh();
		return orden;
	}

	public void setOrden(Integer aOrden) {
		this.orden = aOrden;
	}

	public CabAsiTarjACobrar getCab_asi_acob() throws BaseException {
		supportRefresh();
		return cab_asi_acob;
	}

	public void setCab_asi_acob(CabAsiTarjACobrar aCab_asi_acob) {
		this.cab_asi_acob = aCab_asi_acob;
	}

	public String getCuenta() throws BaseException {
		supportRefresh();
		return cuenta;
	}

	public void setCuenta(String aCuenta) {
		this.cuenta = aCuenta;
	}

	public String getCompo1() throws BaseException {
		supportRefresh();
		return compo1;
	}

	public void setCompo1(String aCompo1) {
		this.compo1 = aCompo1;
	}

	public String getCompo2() throws BaseException {
		supportRefresh();
		return compo2;
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

	public static DetAsiTarjACobrar findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (DetAsiTarjACobrar) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static DetAsiTarjACobrar findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (DetAsiTarjACobrar) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(cab_asi_acob, "Debe ingresar la Cabecera del Asiento");
		Validar.noNulo(cuenta, "Debe ingresar la Cuenta");
	}

	public static List getDetallesAsiento(CabAsiTarjACobrar cabAsiento, ISesion aSesion) throws BaseException {
		return DBDetAsiTarjACobrar.getDetallesAsiento(cabAsiento, aSesion);
	}

	public double getImporte() throws BaseException {
		if ((this.getDebe() != null) && (this.getDebe().doubleValue() != 0))
			return Math.abs(this.getDebe().doubleValue());
		if ((this.getHaber() != null) && (this.getHaber().doubleValue() != 0))
			return Math.abs(this.getHaber().doubleValue());
		return 0;
	}

	public String getD_H() throws BaseException {
		if ((this.getDebe() != null) && (this.getDebe().doubleValue() != 0)) {
			if (this.getDebe().doubleValue() >= 0)
				return "D";
			else
				return "H";
		}
		if ((this.getHaber() != null) && (this.getHaber().doubleValue() != 0)) {
			if (this.getHaber().doubleValue() >= 0)
				return "H";
			else
				return "D";
		}
		return "D";
	}

	public static double getSaldoAUnaFecha(Object aCondiciones, ISesion aSesion) throws BaseException {
		return DBDetAsiTarjACobrar.getSaldoAUnaFecha(aCondiciones, aSesion);
	}

	public static List getDetAsiACob(EmpresaConciTar empresa,String cuenta, java.util.Date fecDesde, java.util.Date fecHasta, ISesion aSesion) throws BaseException {
		return DBDetAsiTarjACobrar.getDetAsiACob(empresa,cuenta, fecDesde, fecHasta, aSesion);
	}

}
