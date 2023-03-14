package com.srn.erp.pagos.bm;

import java.util.List;

import com.srn.erp.contabilidad.bm.Cuenta;
import com.srn.erp.pagos.da.DBRendicionFFUniOrgCta;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class RendicionFFUniOrgCta extends ObjetoLogico {

	public RendicionFFUniOrgCta() {
	}

	public static String			NICKNAME	= "pag.RendicionFFUniOrgCta";

	private RendicionFFUniOrg	unidad_organizativa_ff;

	private Cuenta		cuenta;

	private Boolean						activo;

	public RendicionFFUniOrg getUnidad_organizativa_ff() throws BaseException {
		supportRefresh();
		return unidad_organizativa_ff;
	}

	public void setUnidad_organizativa_ff(RendicionFFUniOrg aUnidad_organizativa_ff) {
		this.unidad_organizativa_ff = aUnidad_organizativa_ff;
	}

	public Cuenta getCuenta() throws BaseException {
		supportRefresh();
		return cuenta;
	}

	public void setCuenta(Cuenta aCuenta) {
		this.cuenta = aCuenta;
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

	public static RendicionFFUniOrgCta findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (RendicionFFUniOrgCta) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static RendicionFFUniOrgCta findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (RendicionFFUniOrgCta) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(unidad_organizativa_ff, "Debe ingresar la Unidad Organizativa");
		Validar.noNulo(cuenta, "Debe ingresar la Cuenta Contable");
	}

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static List getRendicionFFUniOrgCta(RendicionFFUniOrg rendFFUniOrg,
      ISesion aSesion) throws BaseException {
  	return DBRendicionFFUniOrgCta.getRendicionFFUniOrgCta(rendFFUniOrg,aSesion);
  }	

}
