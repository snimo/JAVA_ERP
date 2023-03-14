package com.srn.erp.tesoreria.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.contabilidad.bm.CuentaImputable;
import com.srn.erp.tesoreria.da.DBCuentaImputableIngVar;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class CuentaImputableIngVar extends ObjetoLogico {
	
  private List unidadesOrganizativas = new ArrayList();
  private boolean readUnidadesOrganiativas = true;

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public CuentaImputableIngVar() {
	}

	public static String		NICKNAME	= "te.CuentaImputableIngVar";

	private MotivoHabIngVar	motivo_hab_ing_var;

	private CuentaImputable	cuenta_imputable;

	private Boolean					activo;

	public MotivoHabIngVar getMotivo_hab_ing_var() throws BaseException {
		supportRefresh();
		return motivo_hab_ing_var;
	}

	public void setMotivo_hab_ing_var(MotivoHabIngVar aMotivo_hab_ing_var) {
		this.motivo_hab_ing_var = aMotivo_hab_ing_var;
	}

	public Boolean isActivo() throws BaseException {
		supportRefresh();
		return this.activo;
	}

	public void setActivo(Boolean aActivo) {
		this.activo = aActivo;
	}

	public CuentaImputable getCuenta_imputable() throws BaseException {
		supportRefresh();
		return cuenta_imputable;
	}

	public void setCuenta_imputable(CuentaImputable aCuenta_imputable) {
		this.cuenta_imputable = aCuenta_imputable;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static CuentaImputableIngVar findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (CuentaImputableIngVar) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static CuentaImputableIngVar findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (CuentaImputableIngVar) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static CuentaImputableIngVar findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (CuentaImputableIngVar) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(motivo_hab_ing_var, "Debe ingresar el Motivo");
		Validar.noNulo(cuenta_imputable, "Debe ingresar la cuenta contable");
	}

	public static List getCuentasHabIngVar(MotivoHabIngVar motHabIngVar, ISesion aSesion) throws BaseException {
		return DBCuentaImputableIngVar.getCuentasHabIngVar(motHabIngVar, aSesion);
	}
	
  public List getUniOrgCtaIngVar() throws BaseException {
    if (this.readUnidadesOrganiativas) {
      List listaUniOrg = UniOrgCtasIngVar.getUniOrgCtaIngVar(this,getSesion());
      this.unidadesOrganizativas.addAll(listaUniOrg);
      readUnidadesOrganiativas = false;
    }
    return unidadesOrganizativas;
  }

  public void addUniOrgCtaIngVar(UniOrgCtasIngVar uniOrgCtaIngVar) throws BaseException {
  	uniOrgCtaIngVar.setCuenta_iv(this);
  	unidadesOrganizativas.add(uniOrgCtaIngVar);
  }

  public void afterSave() throws BaseException {
    Iterator iterUniOrgCtaIngVar = this.unidadesOrganizativas.iterator();
    while (iterUniOrgCtaIngVar.hasNext()) {
    	UniOrgCtasIngVar uniOrgCtasIngVar = (UniOrgCtasIngVar) iterUniOrgCtaIngVar.next();
    	uniOrgCtasIngVar.save();
    	uniOrgCtasIngVar = null;
    }
    iterUniOrgCtaIngVar = null;
  }
	

}
