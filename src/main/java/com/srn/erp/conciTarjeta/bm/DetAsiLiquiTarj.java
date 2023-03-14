package com.srn.erp.conciTarjeta.bm;

import java.util.List;

import com.srn.erp.conciTarjeta.da.DBDetAsiLiquiTarj;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.Validar;

public class DetAsiLiquiTarj extends ObjetoLogico {

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public DetAsiLiquiTarj() {
	}

	public static String NICKNAME = "ctar.DetAsiLiquiTarj";

	private CabAsiLiquiTarj cabAsiLiqTarj;
	private Integer orden;
	private String cuenta;
	private String desc_cuenta;
	private String compo1;
	private String compo2;
	private Double debe;
	private Double haber;
	private Boolean activo;
	private String comentario;
	private String codImpuesto;
	private Double porcImpuesto;
	private Double baseImpuesto;

	public CabAsiLiquiTarj getCabasiliqtarj() throws BaseException {
		supportRefresh();
		return cabAsiLiqTarj;
	}

	public String getCodImpuesto() throws BaseException {
		supportRefresh();
		return this.codImpuesto;
	}

	public Double getPorcImpuesto() throws BaseException {
		supportRefresh();
		return this.porcImpuesto;
	}

	public Double getBaseImpuesto() throws BaseException {
		supportRefresh();
		return this.baseImpuesto;
	}

	public void setCodImpuesto(String aCodImpuesto) throws BaseException {
		this.codImpuesto = aCodImpuesto;
	}

	public void setBaseImpuesto(Double aBaseImpuesto) throws BaseException {
		this.baseImpuesto = aBaseImpuesto;
	}

	public void setPorcImpuesto(Double aPorcImpuesto) throws BaseException {
		this.porcImpuesto = aPorcImpuesto;
	}

	public String getComentario() throws BaseException {
		supportRefresh();
		if (comentario != null)
			return comentario;
		else
			return "";
	}

	public void setCabasiliqtarj(CabAsiLiquiTarj aCabasiliqtarj) {
		this.cabAsiLiqTarj = aCabasiliqtarj;
	}

	public void setComentario(String aComentario) {
		this.comentario = aComentario;
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

	public static DetAsiLiquiTarj findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (DetAsiLiquiTarj) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static DetAsiLiquiTarj findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (DetAsiLiquiTarj) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(cabAsiLiqTarj, "Debe ingresar la Cabecera");
		Validar.noNulo(cuenta, "Debe ingresar la Cuenta");
	}

	public static List getDetAsiLiquiTarj(CabAsiLiquiTarj aCabAsiLiquiTarj, ISesion aSesion) throws BaseException {
		return DBDetAsiLiquiTarj.getDetAsiLiquiTarj(aCabAsiLiquiTarj, aSesion);
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
		return DBDetAsiLiquiTarj.getSaldoAUnaFecha(aCondiciones, aSesion);
	}

	public static List getDetAsiLiqTarj(EmpresaConciTar empresa, String cuenta, java.util.Date fecDesde, java.util.Date fecHasta, ISesion aSesion)
			throws BaseException {
		return DBDetAsiLiquiTarj.getDetAsiLiqTarj(empresa,cuenta, fecDesde, fecHasta, aSesion);
	}

}
