package com.srn.erp.bancos.bm;

import java.util.List;

import com.srn.erp.bancos.da.DBConciliacionDet;
import com.srn.erp.contabilidad.bm.CuentaImputable;
import com.srn.erp.tesoreria.bm.MovimientoCtaBancaria;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Varios.CalculadorMoney;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class ConciliacionDet extends ObjetoLogico { 

  public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean isActivo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

public ConciliacionDet() { 
  }

  public static String NICKNAME = "ba.ConciliacionDet";

  private ConciliacionCab conciliacion_cab;
  private MovimientoCtaBancaria movimiento_cuenta;
  private Boolean conciliado;
  private java.util.Date fecha;
  private Double a_conciliar;
  private String tipo_mov;
  private CuentaImputable cuenta_contable;
  private Integer nro_valor;
  private Boolean nuevo_mov;
  private Double extracto;
  private String observacion;
  private Boolean esSaldoInicial = false;

  public Boolean getEsSaldoInicial() {
	return esSaldoInicial;
}

public void setEsSaldoInicial(Boolean esSaldoInicial) {
	this.esSaldoInicial = esSaldoInicial;
}

public ConciliacionCab getConciliacion_cab() throws BaseException { 
    supportRefresh();
    return conciliacion_cab;
  }

  public void setConciliacion_cab(ConciliacionCab aConciliacion_cab) { 
    this.conciliacion_cab =  aConciliacion_cab;
  }

  public MovimientoCtaBancaria getMovimiento_cuenta() throws BaseException { 
    supportRefresh();
    return movimiento_cuenta;
  }

  public void setMovimiento_cuenta(MovimientoCtaBancaria aMovimiento_cuenta) { 
    this.movimiento_cuenta =  aMovimiento_cuenta;
  }

  public Boolean isConciliado() throws BaseException { 
    supportRefresh();
    return conciliado;
  }

  public void setConciliado(Boolean aConciliado) { 
    this.conciliado =  aConciliado;
  }

  public java.util.Date getFecha() throws BaseException { 
    supportRefresh();
    return fecha;
  }

  public void setFecha(java.util.Date aFecha) { 
    this.fecha =  aFecha;
  }

  public Double getA_conciliar() throws BaseException { 
    supportRefresh();
    return a_conciliar;
  }
  
  public Double getA_conciliar_Positivo() throws BaseException { 
	    supportRefresh();
	    if (this.getA_conciliar().doubleValue()>0)
	    	return this.getA_conciliar();
	    else {
	    	CalculadorMoney calc = new CalculadorMoney(new Money(this.getA_conciliar()));
	    	calc.multiplicarPor(new Money(-1));
	    	return calc.getResult();
	    }
	  }  

  public void setA_conciliar(Double aA_conciliar) { 
    this.a_conciliar =  aA_conciliar;
  }

  public String getTipo_mov() throws BaseException { 
    supportRefresh();
    return tipo_mov;
  }

  public void setTipo_mov(String aTipo_mov) { 
    this.tipo_mov =  aTipo_mov;
  }

  public CuentaImputable getCuenta_contable() throws BaseException { 
    supportRefresh();
    return cuenta_contable;
  }

  public void setCuenta_contable(CuentaImputable aCuenta_contable) { 
    this.cuenta_contable =  aCuenta_contable;
  }

  public Integer getNro_valor() throws BaseException { 
    supportRefresh();
    return nro_valor;
  }

  public void setNro_valor(Integer aNro_valor) { 
    this.nro_valor =  aNro_valor;
  }

  public Boolean isNuevo_mov() throws BaseException { 
    supportRefresh();
    return nuevo_mov;
  }

  public void setNuevo_mov(Boolean aNuevo_mov) { 
    this.nuevo_mov =  aNuevo_mov;
  }

  public Double getExtracto() throws BaseException { 
    supportRefresh();
    return extracto;
  }

  public void setExtracto(Double aExtracto) { 
    this.extracto =  aExtracto;
  }

  public String getObservacion() throws BaseException { 
    supportRefresh();
    return observacion;
  }

  public void setObservacion(String aObservacion) { 
    this.observacion =  aObservacion;
  }

  public String getNickName() { 
    return NICKNAME; 
  } 

 public static ConciliacionDet findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (ConciliacionDet) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static ConciliacionDet findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (ConciliacionDet) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(conciliacion_cab, "Debe ingresar la Conciliación");
    if ((!this.esSaldoInicial) && (!this.isNuevo_mov()))
    	Validar.noNulo(movimiento_cuenta, "Debe ingresar el Movimiento de la Cuenta Bancaria");
    if (!this.esSaldoInicial)
    	Validar.noNulo(fecha, "Debe ingresar la Fecha");
    Validar.noNulo(a_conciliar, "Debe ingresar el Importe a conciliar");
    if (!this.esSaldoInicial)
    	Validar.noNulo(tipo_mov, "Debe ingresar el tipo de Movimiento");
    if (this.isNuevo_mov())
    	Validar.noNulo(cuenta_contable, "Debe ingresar la Cuenta Imputable");
    Validar.noNulo(nuevo_mov, "Debe ingresar si es un Nuevo Movimiento");
 }
 
 public static List getConciliacionesDet(ConciliacionCab conciliacion,
         ISesion aSesion) throws BaseException {
	  return DBConciliacionDet.getConciliacionesDet(conciliacion,aSesion);
 }
 

}
