package com.srn.erp.tesoreria.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.general.bm.MotivoComprobante;
import com.srn.erp.general.bm.MotivoTC;
import com.srn.erp.general.bm.PeriodoIncDet;
import com.srn.erp.tesoreria.da.DBMotivoHabIngVar;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class MotivoHabIngVar extends ObjetoLogico {
	
  private List cuentasHabIngVar = new ArrayList();
  private boolean readCuentasHabIngVar = true;
	

	public MotivoHabIngVar() {
	}

	public static String			NICKNAME	= "te.MotivoHabIngVar";

	private MotivoTC	motivo_tc;

	private Boolean						habilitado;

	public MotivoTC getMotivo_tc() throws BaseException {
		supportRefresh();
		return motivo_tc;
	}

	public void setMotivo_tc(MotivoTC aMotivo_tc) {
		this.motivo_tc = aMotivo_tc;
	}

	public Boolean isHabilitado() throws BaseException {
		supportRefresh();
		return habilitado;
	}

	public void setHabilitado(Boolean aHabilitado) {
		this.habilitado = aHabilitado;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static MotivoHabIngVar findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (MotivoHabIngVar) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static MotivoHabIngVar findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (MotivoHabIngVar) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static MotivoHabIngVar findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (MotivoHabIngVar) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(motivo_tc, "Debe ingresar el Motivo");
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
	
  public static MotivoHabIngVar getMotivoHabIngVar(MotivoTC motivoTC,
      ISesion aSesion)
      throws BaseException {
  	return DBMotivoHabIngVar.getMotivoHabIngVar(motivoTC,aSesion);
  }
  
  public List getCuentasHabIngVar() throws BaseException {
    if (this.readCuentasHabIngVar) {
      List listaCuentasHabIngVar = CuentaImputableIngVar.getCuentasHabIngVar(this,getSesion());
      this.cuentasHabIngVar.addAll(listaCuentasHabIngVar);
      readCuentasHabIngVar = false;
    }
    return this.cuentasHabIngVar;
  }

  public void addCuentaHabIngVar(CuentaImputableIngVar aCuentaImputableIngVar) throws BaseException {
  	aCuentaImputableIngVar.setMotivo_hab_ing_var(this);
  	this.cuentasHabIngVar.add(aCuentaImputableIngVar);
  }

  public void afterSave() throws BaseException {
    Iterator iterCuentasHabIngVar = this.cuentasHabIngVar.iterator();
    while (iterCuentasHabIngVar.hasNext()) {
    	CuentaImputableIngVar cuentaImputableIngVar = 
    		(CuentaImputableIngVar) iterCuentasHabIngVar.next();
    	cuentaImputableIngVar.save();
    	cuentaImputableIngVar = null;
    }
    iterCuentasHabIngVar = null;
  }
  
	

}
