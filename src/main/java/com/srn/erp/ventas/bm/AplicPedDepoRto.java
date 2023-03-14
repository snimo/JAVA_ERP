package com.srn.erp.ventas.bm;

import com.srn.erp.stock.bm.PedMercDepoDet;
import com.srn.erp.stock.bm.UnidadMedida;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Varios.CalculadorMoney;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class AplicPedDepoRto extends ObjetoLogico { 

  @Override
	public void afterSaveNew() throws BaseException {
		// TODO Auto-generated method stub
		super.afterSaveNew();
		
		// Obtener las cantidades totales enviadas hasta el momento
		CalculadorMoney calcTotalEnviada = 
			new CalculadorMoney(new Money(this.getPedido_merc_det().getCantEnviada())); 
		calcTotalEnviada.sumar(new Money(this.getCant_enviada()));
		
		
		// Determinar si el pedido queda o no pendiente de envio
		boolean pendEnvio = false;
		if (calcTotalEnviada.getResult()>=this.getPedido_merc_det().getCantidad().doubleValue()) 
			pendEnvio = false;
		else
			pendEnvio = true;
		
		// Actualizar el detalle del pedidos con las cantidades enviadas y si queda o no pendinte de envio
		this.getPedido_merc_det().actuCantidadEnviada(calcTotalEnviada.getResult(), pendEnvio);
			
		
	}

public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

public AplicPedDepoRto() { 
  }

  public static String NICKNAME = "ve.AplicPedDepoRto";

  private PedMercDepoDet pedido_merc_det;
  private RemitoDet remito_det;
  private Double cant_enviada;
  private UnidadMedida um;
  private Boolean activo;

  public PedMercDepoDet getPedido_merc_det() throws BaseException { 
    supportRefresh();
    return pedido_merc_det;
  }

  public void setPedido_merc_det(PedMercDepoDet aPedido_merc_det) { 
    this.pedido_merc_det =  aPedido_merc_det;
  }

  public RemitoDet getRemito_det() throws BaseException { 
    supportRefresh();
    return remito_det;
  }

  public void setRemito_det(RemitoDet aRemito_det) { 
    this.remito_det =  aRemito_det;
  }

  public Double getCant_enviada() throws BaseException { 
    supportRefresh();
    return cant_enviada;
  }

  public void setCant_enviada(Double aCant_enviada) { 
    this.cant_enviada =  aCant_enviada;
  }

  public UnidadMedida getUm() throws BaseException { 
    supportRefresh();
    return um;
  }

  public void setUm(UnidadMedida aUm) { 
    this.um =  aUm;
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

 public static AplicPedDepoRto findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (AplicPedDepoRto) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static AplicPedDepoRto findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (AplicPedDepoRto) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(pedido_merc_det, "Debe ingresar el Detalle del Pedido");
    Validar.noNulo(remito_det, "Debe ingresar el Detalle del Remito");
    Validar.noNulo(cant_enviada, "Debe ingresar la cantidad enviada");
    Validar.noNulo(um, "Debe ingresar la Unidad de Medida");
 }

}
