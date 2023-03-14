package com.srn.erp.tesoreria.bm;

import java.util.List;

import com.srn.erp.general.bm.Moneda;
import com.srn.erp.tesoreria.da.DBSaldoEfectivo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Varios.CalculadorMoney;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;

public class SaldoEfectivo extends ObjetoLogico { 

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

  public SaldoEfectivo() { 
  }

  public static String NICKNAME = "ba.SaldoEfectivo";

  private Integer oid;
  private Caja caja;
  private Moneda moneda;
  private Money saldo;
  private TipoValor tipo_valor;
  private Money entradas;
  private Money salidas;

  public Integer getOid() throws BaseException { 
    supportRefresh();
    return oid;
  }

  public void setOid(Integer aOid) { 
    this.oid =  aOid;
  }

  public Caja getCaja() throws BaseException { 
    supportRefresh();
    return caja;
  }

  public void setCaja(Caja aCaja) { 
    this.caja =  aCaja;
  }
  
  public Money getEntradas() throws BaseException { 
	supportRefresh();
	return this.entradas;
  }

  public void setEntradas(Money aEntradas) { 
	this.entradas =  aEntradas;
  }  
  
  public Money getSalidas() throws BaseException { 
	supportRefresh();
	return this.salidas;
  }

  public void setSalidas(Money aSalidas) { 
	this.salidas =  aSalidas;
  }  

  public Moneda getMoneda() throws BaseException { 
    supportRefresh();
    return moneda;
  }

  public void setMoneda(Moneda aMoneda) { 
    this.moneda =  aMoneda;
  }

  public Money getSaldo() throws BaseException { 
    supportRefresh();
    CalculadorMoney saldo = new CalculadorMoney(new Money(0));
    saldo.sumar(this.getEntradas());
    saldo.restar(this.getSalidas());
    return saldo.getResultMoney();
  }

  public void setSaldo(Money aSaldo) { 
    this.saldo =  aSaldo;
  }

  public TipoValor getTipo_valor() throws BaseException { 
    supportRefresh();
    return tipo_valor;
  }

  public void setTipo_valor(TipoValor aTipo_valor) { 
    this.tipo_valor =  aTipo_valor;
  }

  public String getNickName() { 
    return NICKNAME; 
  } 

 public static SaldoEfectivo findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (SaldoEfectivo) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static SaldoEfectivo findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (SaldoEfectivo) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
 }
 
 public static List getSaldosEfectivo(Caja caja,
         ISesion aSesion) throws BaseException {
	  return DBSaldoEfectivo.getSaldosEfectivo(caja,aSesion);
 }
 
 public static SaldoEfectivo getSaldoEfectivo(
		 Caja caja,
		 TipoValor tipoValor,
         ISesion aSesion) throws BaseException {
	  return (SaldoEfectivo) DBSaldoEfectivo.getSaldoEfectivo(caja,tipoValor,aSesion);
 } 
 

}
