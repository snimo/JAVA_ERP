package com.srn.erp.stock.bm;

import java.util.List;

import com.srn.erp.stock.da.DBConsSalEstStkPorAgrupDepo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;

public class ConsSalEstStkPorAgrupDepo extends ObjetoLogico { 

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

	public ConsSalEstStkPorAgrupDepo() { 
  }

  public static String NICKNAME = "st.ConsSalEstStkPorAgrupDepo";

  private Integer oid_producto;
  private String cod_producto;
  private String desc_producto;
  private Double cantidad;
  private Integer oid_um;
  private String cod_um;
  private Integer oid_estado_stock;

  public Integer getOid_producto() throws BaseException { 
    supportRefresh();
    return oid_producto;
  }

  public void setOid_producto(Integer aOid_producto) { 
    this.oid_producto =  aOid_producto;
  }

  public String getCod_producto() throws BaseException { 
    supportRefresh();
    return cod_producto;
  }

  public void setCod_producto(String aCod_producto) { 
    this.cod_producto =  aCod_producto;
  }

  public String getDesc_producto() throws BaseException { 
    supportRefresh();
    return desc_producto;
  }

  public void setDesc_producto(String aDesc_producto) { 
    this.desc_producto =  aDesc_producto;
  }

  public Double getCantidad() throws BaseException { 
    supportRefresh();
    return cantidad;
  }

  public void setCantidad(Double aCantidad) { 
    this.cantidad =  aCantidad;
  }

  public Integer getOid_um() throws BaseException { 
    supportRefresh();
    return oid_um;
  }

  public void setOid_um(Integer aOid_um) { 
    this.oid_um =  aOid_um;
  }

  public String getCod_um() throws BaseException { 
    supportRefresh();
    return cod_um;
  }

  public void setCod_um(String aCod_um) { 
    this.cod_um =  aCod_um;
  }

  public Integer getOid_estado_stock() throws BaseException { 
    supportRefresh();
    return oid_estado_stock;
  }

  public void setOid_estado_stock(Integer aOid_estado_stock) { 
    this.oid_estado_stock =  aOid_estado_stock;
  }

  public String getNickName() { 
    return NICKNAME; 
  } 

 public static ConsSalEstStkPorAgrupDepo findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (ConsSalEstStkPorAgrupDepo) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static ConsSalEstStkPorAgrupDepo findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (ConsSalEstStkPorAgrupDepo) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
 }
 
 public static List getConsSalEstadoStkPorAgrupDepo(
		 AgrupadorDeposito agrupadorDeposito,
		 EstadoStock estadoStock,
		 HashTableDatos condiciones,
		 ISesion aSesion) throws BaseException {
  return DBConsSalEstStkPorAgrupDepo.getConsSalStkPorAgrupDepo(agrupadorDeposito,
  		                                                         estadoStock,
  		                                                         condiciones
  		                                                         ,aSesion);
 } 

}
