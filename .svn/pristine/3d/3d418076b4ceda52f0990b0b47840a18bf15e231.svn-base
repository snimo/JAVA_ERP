package com.srn.erp.bancos.bm;

import java.util.List;

import com.srn.erp.bancos.da.DBNotaBancariaDet;
import com.srn.erp.contabilidad.bm.CuentaImputable;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class NotaBancariaDet extends ObjetoLogico {

	public NotaBancariaDet() {
	}

	public static String		NICKNAME	= "ba.NotaBancariaDet";

	private NotaBancaria		nota_bancaria;

	private CuentaImputable	cuenta_imputable;

	private Money						debe;

	private Money						haber;

	private String					comentario;

	public NotaBancaria getNota_bancaria() throws BaseException {
		supportRefresh();
		return nota_bancaria;
	}

	public void setNota_bancaria(NotaBancaria aNota_bancaria) {
		this.nota_bancaria = aNota_bancaria;
	}

	public CuentaImputable getCuenta_imputable() throws BaseException {
		supportRefresh();
		return cuenta_imputable;
	}

	public void setCuenta_imputable(CuentaImputable aCuenta_imputable) {
		this.cuenta_imputable = aCuenta_imputable;
	}

	public Money getDebe() throws BaseException {
		supportRefresh();
		return debe;
	}

	public void setDebe(Money aDebe) {
		this.debe = aDebe;
	}

	public Money getHaber() throws BaseException {
		supportRefresh();
		return haber;
	}

	public void setHaber(Money aHaber) {
		this.haber = aHaber;
	}

	public String getComentario() throws BaseException {
		supportRefresh();
		return comentario;
	}

	public void setComentario(String aComentario) {
		this.comentario = aComentario;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static NotaBancariaDet findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (NotaBancariaDet) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static NotaBancariaDet findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (NotaBancariaDet) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(nota_bancaria, "Debe ingresar la Nota Bancaria");
		Validar.noNulo(cuenta_imputable, "Debe ingresar la Cuenta Imputable");
	}

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean isActivo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public static List getDetallesByNotaBancaria(NotaBancaria notaBancaria, ISesion aSesion) throws BaseException {
		return DBNotaBancariaDet.getDetallesByNotaBancaria(notaBancaria,aSesion);
	}
	
	public boolean isDebito() throws BaseException {
		if ((this.getDebe()!=null) && (this.getDebe().doubleValue()>0))
			return true;
		else
			return false;
	}
	
	public boolean isCredito() throws BaseException {
		if ((this.getHaber()!=null) && (this.getHaber().doubleValue()>0))
			return true;
		else
			return false;
	}
	
	
}
