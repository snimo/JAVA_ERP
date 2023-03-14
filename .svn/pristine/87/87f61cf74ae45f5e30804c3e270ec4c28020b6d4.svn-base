package com.srn.erp.ctasAPagar.bm;


import com.srn.erp.stock.bm.StockValorizado;
import com.srn.erp.stock.bm.UnidadMedida;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class AplicStockValInfRecOC extends ObjetoLogico { 

  public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

public AplicStockValInfRecOC() { 
  }

  public static String NICKNAME = "cap.AplicStockValInfRecOC";

  private StockValorizado stock_valorizado;
  private ComproProvInfRecOC compro_prov_infrec_oc;
  private Double cantidad;
  private UnidadMedida unidad_medida;
  private Boolean activo;

  public StockValorizado getStock_valorizado() throws BaseException { 
    supportRefresh();
    return stock_valorizado;
  }

  public void setStock_valorizado(StockValorizado aStock_valorizado) { 
    this.stock_valorizado =  aStock_valorizado;
  }

  public ComproProvInfRecOC getCompro_prov_infrec_oc() throws BaseException { 
    supportRefresh();
    return compro_prov_infrec_oc;
  }

  public void setCompro_prov_infrec_oc(ComproProvInfRecOC aCompro_prov_infrec_oc) { 
    this.compro_prov_infrec_oc =  aCompro_prov_infrec_oc;
  }

  public Double getCantidad() throws BaseException { 
    supportRefresh();
    return cantidad;
  }

  public void setCantidad(Double aCantidad) { 
    this.cantidad =  aCantidad;
  }

  public UnidadMedida getUnidad_medida() throws BaseException { 
    supportRefresh();
    return unidad_medida;
  }

  public void setUnidad_medida(UnidadMedida aUnidad_medida) { 
    this.unidad_medida =  aUnidad_medida;
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

 public static AplicStockValInfRecOC findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (AplicStockValInfRecOC) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static AplicStockValInfRecOC findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (AplicStockValInfRecOC) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(stock_valorizado, "Debe ingresar el Stock Valorizado");
    Validar.noNulo(compro_prov_infrec_oc, "Debe ingresar el Informe / OC");
    Validar.noNulo(cantidad, "Debe ingresar la cantidad");
    Validar.noNulo(unidad_medida, "Debe ingresar la Unidad de Medida");
 }

}
