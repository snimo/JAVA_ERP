package com.srn.erp.stock.bm;

import java.util.Date;

import com.srn.erp.stock.da.DBStockDia;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class StockDia extends ObjetoLogico { 

  public Boolean isActivo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

public StockDia() { 
  }

  public static String NICKNAME = "st.StockDia";

  private Deposito deposito;
  private Producto producto;
  private UnidadMedida uni_med;
  private Double entradas;
  private Double salidas;
  private Date fecha;

  
  public Date getFecha() throws BaseException {
	    supportRefresh();
	    return fecha;
  }
  
  public void setFecha(Date aFecha) throws BaseException {
	  this.fecha = aFecha;
  }
  
  public Deposito getDeposito() throws BaseException { 
    supportRefresh();
    return deposito;
  }

  public void setDeposito(Deposito aDeposito) { 
    this.deposito =  aDeposito;
  }

  public Producto getProducto() throws BaseException { 
    supportRefresh();
    return producto;
  }

  public void setProducto(Producto aProducto) { 
    this.producto =  aProducto;
  }

  public UnidadMedida getUni_med() throws BaseException { 
    supportRefresh();
    return uni_med;
  }

  public void setUni_med(UnidadMedida aUni_med) { 
    this.uni_med =  aUni_med;
  }

  public Double getEntradas() throws BaseException { 
    supportRefresh();
    return entradas;
  }

  public void setEntradas(Double aEntradas) { 
    this.entradas =  aEntradas;
  }

  public Double getSalidas() throws BaseException { 
    supportRefresh();
    return salidas;
  }

  public void setSalidas(Double aSalidas) { 
    this.salidas =  aSalidas;
  }

  public String getNickName() { 
    return NICKNAME; 
  } 

 public static StockDia findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (StockDia) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static StockDia findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (StockDia) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(deposito, "Debe ingresar el Depósito");
    Validar.noNulo(producto, "Debe ingresar el Producto");
    Validar.noNulo(uni_med, "Debe ingresar la Unidad de Medida");
 }
 
 public static StockDia getStockDia(Producto producto,
		   Deposito deposito,
		   java.util.Date fecha,
		   ISesion aSesion) throws BaseException {
   return DBStockDia.getStockDia(producto,deposito,fecha,aSesion);
} 

}
