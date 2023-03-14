package com.srn.erp.stock.bm;

import framework.applicarionServer.bl.ObjetosAplicacion.*;
import framework.request.bl.Utils.*;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;

import java.util.List;

import com.srn.erp.stock.da.DBInventarioDet;

public class InventarioDet extends ObjetoLogico { 

  @Override
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

public InventarioDet() { 
  }

  public static String NICKNAME = "st.InventarioDet";

  private InventarioCab inventario_cab;
  private Producto producto;
  private Double fisico;
  private Double conteo;
  private Boolean sin_stock;
  private Double aju_stock;
  private String observacion;

  public InventarioCab getInventario_cab() throws BaseException { 
    supportRefresh();
    return inventario_cab;
  }

  public void setInventario_cab(InventarioCab aInventario_cab) { 
    this.inventario_cab =  aInventario_cab;
  }

  public Producto getProducto() throws BaseException { 
    supportRefresh();
    return producto;
  }

  public void setProducto(Producto aProducto) { 
    this.producto =  aProducto;
  }

  public Double getFisico() throws BaseException { 
    supportRefresh();
    return fisico;
  }

  public void setFisico(Double aFisico) { 
    this.fisico =  aFisico;
  }

  public Double getConteo() throws BaseException { 
    supportRefresh();
    return conteo;
  }

  public void setConteo(Double aConteo) { 
    this.conteo =  aConteo;
  }

  public Boolean isSin_stock() throws BaseException { 
    supportRefresh();
    return sin_stock;
  }

  public void setSin_stock(Boolean aSin_stock) { 
    this.sin_stock =  aSin_stock;
  }

  public Double getAju_stock() throws BaseException { 
    supportRefresh();
    return aju_stock;
  }

  public void setAju_stock(Double aAju_stock) { 
    this.aju_stock =  aAju_stock;
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

 public static InventarioDet findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (InventarioDet) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static InventarioDet findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (InventarioDet) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(inventario_cab, "Debe ingresar la Cabecera");
    Validar.noNulo(producto, "Debe ingresar el Producto");
 }
 
 public static List getDetallesByInventario(InventarioCab inventario, ISesion aSesion) throws BaseException {
		return DBInventarioDet.getDetallesByInventario(inventario,aSesion);
}
 

}
