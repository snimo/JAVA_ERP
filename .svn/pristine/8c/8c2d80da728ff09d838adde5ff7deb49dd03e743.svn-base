package com.srn.erp.ventas.bm;

import java.util.List;

import com.srn.erp.ventas.da.DBConsultaPrecios;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;

public class ConsultaPrecios extends ObjetoLogico { 

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

	public ConsultaPrecios() { 
  }

  public static String NICKNAME = "ve.ConsultaPrecios";

  private Integer oid_precio_cab;
  private Integer oid_producto;
  private String cod_producto;
  private String desc_producto;
  private Double cantidad;
  private Integer oid_um;
  private String cod_um;
  private Integer oid_moneda;
  private String cod_moneda;
  private Double precio;

  public Integer getOid_precio_cab() throws BaseException { 
    supportRefresh();
    return oid_precio_cab;
  }

  public void setOid_precio_cab(Integer aOid_precio_cab) { 
    this.oid_precio_cab =  aOid_precio_cab;
  }

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

  public Integer getOid_moneda() throws BaseException { 
    supportRefresh();
    return oid_moneda;
  }

  public void setOid_moneda(Integer aOid_moneda) { 
    this.oid_moneda =  aOid_moneda;
  }

  public String getCod_moneda() throws BaseException { 
    supportRefresh();
    return cod_moneda;
  }

  public void setCod_moneda(String aCod_moneda) { 
    this.cod_moneda =  aCod_moneda;
  }

  public Double getPrecio() throws BaseException { 
    supportRefresh();
    return precio;
  }

  public void setPrecio(Double aPrecio) { 
    this.precio =  aPrecio;
  }

  public String getNickName() { 
    return NICKNAME; 
  } 

 public static ConsultaPrecios findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (ConsultaPrecios) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static ConsultaPrecios findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (ConsultaPrecios) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
 }
 
 public static List getPrecios(HashTableDatos condiciones,
			ISesion aSesion) throws BaseException {
	 return DBConsultaPrecios.getPrecios(condiciones,aSesion);
 }
 

}
