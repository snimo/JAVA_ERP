package com.srn.erp.cashflow.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.cashflow.da.DBCajaSaldoIniCF;
import com.srn.erp.tesoreria.bm.Caja;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class CajaSaldoIniCF extends ObjetoLogico {

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}
	
	private List tipoValores = new ArrayList();
	private boolean readTipoValores = true;
	
	public CajaSaldoIniCF() {
	}

	public static String NICKNAME = "cf.CajaSaldoIniCF";

	private EscenarioCashFlow escenarioCF;
	private Caja caja;
	private Boolean activo;

	public EscenarioCashFlow getEscenariocf() throws BaseException {
		supportRefresh();
		return escenarioCF;
	}

	public void setEscenariocf(EscenarioCashFlow aEscenariocf) {
		this.escenarioCF = aEscenariocf;
	}

	public Caja getCaja() throws BaseException {
		supportRefresh();
		return caja;
	}

	public void setCaja(Caja aCaja) {
		this.caja = aCaja;
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

	public static CajaSaldoIniCF findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (CajaSaldoIniCF) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static CajaSaldoIniCF findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (CajaSaldoIniCF) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static CajaSaldoIniCF findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (CajaSaldoIniCF) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(escenarioCF, "Debe ingresar el Escenario");
		Validar.noNulo(caja, "Debe ingresar la Caja");
	}

	public static List getCajasSaldoIniCF(EscenarioCashFlow escenario, ISesion aSesion) throws BaseException {
		return DBCajaSaldoIniCF.getCajasSaldoIniCF(escenario, aSesion);
	}
	
	public List getTiposValores() throws BaseException {
		 if (this.readTipoValores) {
		     List listaTiposValores = TipoValorSICajaCF.getTiposValoresSICaja(this,getSesion());
		     this.tipoValores.addAll(listaTiposValores);
		     this.readTipoValores = false;
		  }
		  return this.tipoValores;
	}
	
	public void addTipoValor(TipoValorSICajaCF aTipoValor) throws BaseException {
		aTipoValor.setSaldo_inicial_caja(this);
		this.tipoValores.add(aTipoValor);
	}
	

	public void afterSave() throws BaseException {
		
		Iterator iterTiposValores = this.tipoValores.iterator();
		while (iterTiposValores.hasNext()) {
		      TipoValorSICajaCF tipoValorSICaja = (TipoValorSICajaCF) iterTiposValores.next();
		      tipoValorSICaja.save();
		      tipoValorSICaja = null;
		}
		iterTiposValores = null;
		
	}
	
	

}
