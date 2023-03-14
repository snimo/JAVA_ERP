package com.srn.erp.stock.bm;

import java.util.List;

import com.srn.erp.stock.da.DBConfConsGenStockEst;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class ConfConsGenStockEst extends ObjetoLogico { 

  public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

public ConfConsGenStockEst() { 
  }

  public static String NICKNAME = "st.ConfConsGenStockEst";

  private EstadoStock estado_stock;
  private ConfConsGenStock conf_cons_stk;
  private Boolean activo;
  private Integer orden;

  public EstadoStock getEstado_stock() throws BaseException { 
    supportRefresh();
    return estado_stock;
  }

  public void setEstado_stock(EstadoStock aEstado_stock) { 
    this.estado_stock =  aEstado_stock;
  }

  public ConfConsGenStock getConf_cons_stk() throws BaseException { 
    supportRefresh();
    return conf_cons_stk;
  }

  public void setConf_cons_stk(ConfConsGenStock aConf_cons_stk) { 
    this.conf_cons_stk =  aConf_cons_stk;
  }

  public Boolean isActivo() throws BaseException { 
    supportRefresh();
    return activo;
  }

  public void setActivo(Boolean aActivo) { 
    this.activo =  aActivo;
  }

  public Integer getOrden() throws BaseException { 
    supportRefresh();
    return orden;
  }

  public void setOrden(Integer aOrden) { 
    this.orden =  aOrden;
  }

  public String getNickName() { 
    return NICKNAME; 
  } 

 public static ConfConsGenStockEst findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (ConfConsGenStockEst) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static ConfConsGenStockEst findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (ConfConsGenStockEst) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(estado_stock, "Debe ingresar el Estado de Stock");
    Validar.noNulo(conf_cons_stk, "Debe ingresar la Configuración");
    Validar.noNulo(orden, "Debe ingresar el Orden");
 }
 
 public static List getConfConsGenStockEst(ConfConsGenStock confConsGenStock,ISesion aSesion) throws BaseException {
	  return DBConfConsGenStockEst.getConfConsGenStockEst(confConsGenStock,aSesion);
 }
 

}
