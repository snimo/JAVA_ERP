package com.srn.erp.contabilidad.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Varios.CalculadorMoney;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.Validar;

public class DriverSubreparto extends ObjetoLogico { 

  public static final String VALOR_LITERAL = "VAL_LIT";
  public static final String VALOR_CTAS    = "VAL_CTAS";
  public static final String VALOR_COMPO   = "VAL_COMPO";
  
  public static final String TS_DEUDOR = "DEUDOR";
  public static final String TS_ACREEDOR = "ACREEDOR";
  
  public DriverSubreparto() { 
  }

  public static String NICKNAME = "cg.DriverSubreparto";
  
  private List driversCuentas = new ArrayList();
  private boolean readDriversCuentas = true;
  
  private List driversComponentes = new ArrayList();
  private boolean readDriversComponentes = true;
  
  private String codigo;
  private String descripcion;
  private String tipo_valor;
  private Double valor;
  private Componente componente;
  private Boolean activo;
  private String tipoSaldo;

  public String getCodigo() throws BaseException { 
    supportRefresh();
    return codigo;
  }

  public void setCodigo(String aCodigo) { 
    this.codigo =  aCodigo;
  }
  
  public String getTipoSaldo() throws BaseException { 
	supportRefresh();
	return tipoSaldo;
  }

  public void setTipoSaldo(String aTipoSaldo) { 
	 this.tipoSaldo =  aTipoSaldo;
  }

  public String getDescripcion() throws BaseException { 
    supportRefresh();
    return descripcion;
  }

  public void setDescripcion(String aDescripcion) { 
    this.descripcion =  aDescripcion;
  }

  public String getTipo_valor() throws BaseException { 
    supportRefresh();
    return tipo_valor;
  }

  public void setTipo_valor(String aTipo_valor) { 
    this.tipo_valor =  aTipo_valor;
  }

  public Double getValor() throws BaseException { 
    supportRefresh();
    return valor;
  }

  public void setValor(Double aValor) { 
    this.valor =  aValor;
  }

  public Componente getComponente() throws BaseException { 
    supportRefresh();
    return componente;
  }

  public void setComponente(Componente aComponente) { 
    this.componente =  aComponente;
  }

  public Boolean isActivo() throws BaseException { 
    supportRefresh();
    return activo;
  }

  public void setActivo(Boolean aActivo) { 
    this.activo =  aActivo;
  }

  public String getNickName() { 
    return NICKNAME; 
  } 

 public static DriverSubreparto findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (DriverSubreparto) getObjectByOid(NICKNAME,oid,aSesion);
  } 
 
 public static DriverSubreparto findByOidProxy(Integer oid , ISesion aSesion) throws BaseException { 
	return (DriverSubreparto) getObjectByOidProxy(NICKNAME,oid,aSesion);
 } 

 public static DriverSubreparto findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (DriverSubreparto) getObjectByCodigo(NICKNAME,codigo,aSesion);
  }
 
 public List getDriversCuentas() throws BaseException {
	if (this.readDriversCuentas) {
	      List listaDriversCuentas = DriverCuentaSubreparto.getDriverCuentasSubreparto(this,getSesion());
	      driversCuentas.addAll(listaDriversCuentas);
	      readDriversCuentas = false;
	}
	return driversCuentas;
 }
 
 public List getDriversComponentes() throws BaseException {
		if (this.readDriversComponentes) {
		      List listaDriversComponentes = DriverComponente.getComponentesDriver(this,getSesion());
		      driversComponentes.addAll(listaDriversComponentes);
		      readDriversComponentes = false;
		}
		return driversComponentes;
 } 

 public void addDriverCuenta(DriverCuentaSubreparto aDriverCuentaSubreparto) throws BaseException {
	 aDriverCuentaSubreparto.setDriver(this);
	 driversCuentas.add(aDriverCuentaSubreparto);
 }
 
 public void addDriverComponente(DriverComponente aDriverComponente) throws BaseException {
	 aDriverComponente.setDriver(this);
	 driversComponentes.add(aDriverComponente);
 }
 

 public void afterSave() throws BaseException {
	 
	Iterator iterDriverCuentas = this.driversCuentas.iterator();
	    while (iterDriverCuentas.hasNext()) {
	      DriverCuentaSubreparto driverCuentaSubreparto = (DriverCuentaSubreparto) iterDriverCuentas.next();
	      driverCuentaSubreparto.save();
	      driverCuentaSubreparto = null;
	    }
	    iterDriverCuentas = null;
	
	Iterator iterDriverComponentes = this.driversComponentes.iterator();
    while (iterDriverComponentes.hasNext()) {
      DriverComponente driverComponente = (DriverComponente) iterDriverComponentes.next();
      driverComponente.save();
      driverComponente = null;
    }
    iterDriverComponentes = null;
	
	
 }
 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(codigo, "Debe ingresar el código");
    Validar.noNulo(descripcion, "Debe ingresar la Descripción");
    Validar.noNulo(tipo_valor, "Debe ingresar el Tipo de Valor");
    
    if (this.isComponentes() || this.isCuentas())
    	Validar.noNulo(tipoSaldo, "Debe ingresar el Tipo de Saldo");
    
    if (this.isComponentes()) {
    	if (this.getComponente()==null)
    		throw new ExceptionValidation(null,"Debe ingresar el Componente");
    }
    
 }
 
 public static HashTableDatos getTiposValores() throws BaseException {
	 HashTableDatos valores = new HashTableDatos();
	 valores.put(VALOR_LITERAL,"Literal");
	 valores.put(VALOR_CTAS,"Cuentas");
	 valores.put(VALOR_COMPO,"Componentes");
	 return valores; 
 }
 
  
 public Double getCantidad(java.util.Date fecDesde,
		                   java.util.Date fecHasta) throws BaseException {
	 if (this.getTipo_valor().equals(VALOR_LITERAL))
		 return Math.abs(this.getValor());
	 else 
		 if (this.getTipo_valor().equals(VALOR_CTAS))
			 return Math.abs(this.getTotalMonLocHist(fecDesde,fecHasta));		 
		 else 
			 if (this.getTipo_valor().equals(VALOR_COMPO))
				 return Math.abs(this.getTotalMonLocHist(fecDesde,fecHasta));	 
	 return new Double(0);	 
 }
 
 public boolean isCuentas() throws BaseException {
	 if (this.getTipo_valor().equals(VALOR_CTAS))
		 return true;
	 else
		 return false;
 }
 
 public boolean isComponentes() throws BaseException {
	 if (this.getTipo_valor().equals(VALOR_COMPO))
		 return true;
	 else
		 return false;
 } 
 
 private Double getTotalMonLocHist(
		 java.util.Date fecDesde,
		 java.util.Date fecHasta
		 ) throws BaseException {
	 
	 CalculadorMoney tot = new CalculadorMoney(new Money(0));
	 Iterator IterMayorDia = 
		 MayorDia.getImputacionesByDriverSubReparto(fecDesde, fecHasta, this, this.getSesion()).iterator();
	 while (IterMayorDia.hasNext()) {
		 MayorDia mayorDia = (MayorDia) IterMayorDia.next();
		 tot.sumar(new Money(mayorDia.getImpoLocHist().doubleValue()*mayorDia.getSigno()));
	 }
	 
	 if (this.isTomarSaldoDeudor()) {
		 if (tot.getResultMoney().doubleValue()>0)
			 return tot.getResultMoney().doubleValue();
		 else
			 return new Double(0);
	 } else if (this.isTomarSaldoAcreedor()) {
		 if (tot.getResultMoney().doubleValue()<0)
			 return Math.abs(tot.getResultMoney().doubleValue());
		 else
			 return new Double(0);
	 } else return new Double(0);
	 
 }
 
 public boolean isTomarSaldoDeudor() throws BaseException {
	 if (this.getTipoSaldo() == null) return false;
	 if (this.getTipoSaldo().equals(TS_DEUDOR))
		 return true;
	 else
		 return false;
 }
 
 public boolean isTomarSaldoAcreedor() throws BaseException {
	 if (this.getTipoSaldo() == null) return false;
	 if (this.getTipoSaldo().equals(TS_ACREEDOR))
		 return true;
	 else
		 return false;
 }
 

}
