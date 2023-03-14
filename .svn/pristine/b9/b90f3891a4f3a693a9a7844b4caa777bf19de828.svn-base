package com.srn.erp.ventas.bm;

import java.util.List;

import com.srn.erp.ventas.da.DBObsCodifPedidoCab;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class ObsCodifPedidoCab extends ObjetoLogico { 

  public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

public ObsCodifPedidoCab() { 
  }

  public static String NICKNAME = "ve.ObsCodifPedidoCab";

  private PedidoCab pedido;
  private Integer orden;
  private ObsCodifVtas obs_codificada;
  private Boolean activo;

  public PedidoCab getPedido() throws BaseException { 
    supportRefresh();
    return pedido;
  }

  public void setPedido(PedidoCab aPedido) { 
    this.pedido =  aPedido;
  }

  public Integer getOrden() throws BaseException { 
    supportRefresh();
    return orden;
  }

  public void setOrden(Integer aOrden) { 
    this.orden =  aOrden;
  }

  public ObsCodifVtas getObs_codificada() throws BaseException { 
    supportRefresh();
    return obs_codificada;
  }

  public void setObs_codificada(ObsCodifVtas aObs_codificada) { 
    this.obs_codificada =  aObs_codificada;
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

 public static ObsCodifPedidoCab findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (ObsCodifPedidoCab) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static ObsCodifPedidoCab findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (ObsCodifPedidoCab) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(pedido, "Debe ingresar el Pedido");
    Validar.noNulo(orden, "Debe ingresar el Nro. de Orden");
    Validar.noNulo(obs_codificada, "Debe ingresar la Observación");
 }
 
 public static List getObsCodificasPedido(PedidoCab pedido,
         ISesion aSesion) throws BaseException {
	  return DBObsCodifPedidoCab.getObsCodificasPedido(pedido,aSesion);
 }

 

}
