package com.srn.erp.cashflow.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.cashflow.da.DBEscenarioCashFlow;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.general.bm.PeriodoIncDet;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class EscenarioCashFlow extends ObjetoLogico {

	public EscenarioCashFlow() {
	}

	public static String NICKNAME = "cf.EscenarioCashFlow";

	private String codigo;
	private String descripcion;
	private Boolean activo;
	private Boolean verDeudaCliente;
	private Moneda moneda;
	
	private List saldoIniCtasBancarias = new ArrayList();
	private boolean readSaldoIniCtasBancarias = true;

	private List saldoIniCajas = new ArrayList();
	private boolean readSaldoIniCajas = true;
	
	private List saldoIniCtasConta = new ArrayList();
	private boolean readSaldoIniCtasConta = true;
	
	private List cajasHabDeudaFinan = new ArrayList();
	private boolean readCajasHabDeudaFinan = true;
	
	
	public String getCodigo() throws BaseException {
		supportRefresh();
		return codigo;
	}

	public void setCodigo(String aCodigo) {
		this.codigo = aCodigo;
	}
	
	public Moneda getMoneda() throws BaseException {
		supportRefresh();
		return this.moneda;
	}

	public void setMoneda(Moneda aMoneda) {
		this.moneda = aMoneda;
	}
	
	
	public Boolean isVerDeudaClientes() throws BaseException {
		supportRefresh();
		return this.verDeudaCliente;
	}

	public void setVerDeudaClientes(Boolean aVerDeudaClientes) {
		this.verDeudaCliente = aVerDeudaClientes;
	}
	

	public String getDescripcion() throws BaseException {
		supportRefresh();
		return descripcion;
	}

	public void setDescripcion(String aDescripcion) {
		this.descripcion = aDescripcion;
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

	public static EscenarioCashFlow findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (EscenarioCashFlow) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static EscenarioCashFlow findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (EscenarioCashFlow) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static EscenarioCashFlow findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (EscenarioCashFlow) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(codigo, "Debe ingresar el Código");
		Validar.noNulo(descripcion, "Debe ingresar la Descripción");
		Validar.noNulo(moneda, "Debe ingresar la Moneda");
	}

	public static List getEscenariosCF(ISesion aSesion) throws BaseException {
		return DBEscenarioCashFlow.getEscenariosCF(aSesion);
	}
	
	public List getSaldoInicialCtasBancarias() throws BaseException {
		 if (readSaldoIniCtasBancarias) {
		     List listaSaldoIniCtasBancarias = CtaBcoSaldoIniCF.getCtasBcoSaldoIni(this,getSesion());
		     this.saldoIniCtasBancarias.addAll(listaSaldoIniCtasBancarias);
		     readSaldoIniCtasBancarias = false;
		  }
		  return saldoIniCtasBancarias;
	}
	
	public List getSaldoInicialCtasContables() throws BaseException {
		 if (readSaldoIniCtasConta) {
		     List listaSaldoIniCtasContables = CtaSaldoIniCf.getCtasContablesSICaja(this,getSesion());
		     this.saldoIniCtasConta.addAll(listaSaldoIniCtasContables);
		     this.readSaldoIniCtasConta = false;
		  }
		  return saldoIniCtasConta;
	}
	
	
	public List getSaldoInicialCajas() throws BaseException {
		 if (readSaldoIniCajas) {
		     List listaSaldoIniCajas = CajaSaldoIniCF.getCajasSaldoIniCF(this,getSesion());
		     this.saldoIniCajas.addAll(listaSaldoIniCajas);
		     readSaldoIniCajas = false;
		  }
		  return this.saldoIniCajas;
	}
	
	public List getCajasHabDeudaFinan() throws BaseException {
		 if (this.readCajasHabDeudaFinan) {
		     List listaCajasHabDeudaFinan = CajasHabDeudaFinanCF.getCajasHabDeudaFinan(this,getSesion());
		     this.cajasHabDeudaFinan.addAll(listaCajasHabDeudaFinan);
		     readCajasHabDeudaFinan = false;
		  }
		  return this.cajasHabDeudaFinan;
	}

	public void addCtaBcoSaldoIni(CtaBcoSaldoIniCF aCtaBcoSaldoIni) throws BaseException {
		aCtaBcoSaldoIni.setEscenariocf(this);
		saldoIniCtasBancarias.add(aCtaBcoSaldoIni);
	}
	
	public void addCajaHabDeudaFinan(CajasHabDeudaFinanCF aCajaHabDeudaFinan) throws BaseException {
		aCajaHabDeudaFinan.setEscenario_cf(this);
		cajasHabDeudaFinan.add(aCajaHabDeudaFinan);
	}
	
	
	public void addCtaContableSaldoIni(CtaSaldoIniCf aCtaContableSaldoIni) throws BaseException {
		aCtaContableSaldoIni.setEscenario(this);
		saldoIniCtasConta.add(aCtaContableSaldoIni);
	}
	
	
	public void addSaldoInicialCaja(CajaSaldoIniCF aCajaSaldoIniCF) throws BaseException {
		aCajaSaldoIniCF.setEscenariocf(this);
		saldoIniCajas.add(aCajaSaldoIniCF);
	}
	

	public void afterSave() throws BaseException {
		
		Iterator iterCtaBcoSaldoIni = this.saldoIniCtasBancarias.iterator();
		while (iterCtaBcoSaldoIni.hasNext()) {
		      CtaBcoSaldoIniCF ctaBcoSaldoIni = (CtaBcoSaldoIniCF) iterCtaBcoSaldoIni.next();
		      ctaBcoSaldoIni.save();
		      ctaBcoSaldoIni = null;
		}
		iterCtaBcoSaldoIni = null;
		
		Iterator iterCajaSaldoIni = this.saldoIniCajas.iterator();
		while (iterCajaSaldoIni.hasNext()) {
		      CajaSaldoIniCF cajaSaldoIniCF = (CajaSaldoIniCF) iterCajaSaldoIni.next();
		      cajaSaldoIniCF.save();
		      cajaSaldoIniCF = null;
		}
		iterCajaSaldoIni = null;
		
		Iterator iterCtasContableSI = this.saldoIniCtasConta.iterator();
		while (iterCtasContableSI.hasNext()) {
		      CtaSaldoIniCf ctaSaldoIniCF = (CtaSaldoIniCf) iterCtasContableSI.next();
		      ctaSaldoIniCF.save();
		      ctaSaldoIniCF = null;
		}
		iterCtasContableSI = null;
		
		Iterator iterCajaHabDeudaFinan = this.cajasHabDeudaFinan.iterator();
		while (iterCajaHabDeudaFinan.hasNext()) {
		      CajasHabDeudaFinanCF cajaHabDeudaFinan = (CajasHabDeudaFinanCF) iterCajaHabDeudaFinan.next();
		      cajaHabDeudaFinan.save();
		      cajaHabDeudaFinan = null;
		}
		iterCajaHabDeudaFinan = null;
		
		
	}
	

}
