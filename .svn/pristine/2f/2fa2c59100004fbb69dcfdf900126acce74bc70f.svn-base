package com.srn.erp.stock.bm;

import com.srn.erp.compras.bm.InformeRecepcionDet;
import com.srn.erp.ventas.bm.RemitoDet;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Varios.CalculadorMoney;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class AplicInfRecRto extends ObjetoLogico { 

  @Override
	public void afterSaveNew() throws BaseException {
		// TODO Auto-generated method stub
		super.afterSaveNew();
		
		CalculadorMoney calcTotRecep = new CalculadorMoney(new Money(this.getRemito_det().getCantRecep()));
		calcTotRecep.sumar(new Money(this.getCantidad()));
		Double nuevaCantRecep = calcTotRecep.getResult(); 
		
		// Determinar el detalle del pedido si esta pendiente de entrega
		boolean pendRecep = true;
		if (nuevaCantRecep.doubleValue()>=this.getRemito_det().getCant_desp()) 
			pendRecep = false;
		this.getRemito_det().aplicarCantidadRecepcionada(this.getRemito_det(), nuevaCantRecep,pendRecep, this.getSesion());
		
	}

public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

public AplicInfRecRto() { 
  }

  public static String NICKNAME = "st.AplicInfRecRto";

  private InformeRecepcionDet inf_rec_det;
  private RemitoDet remito_det;
  private Double cantidad;
  private UnidadMedida um;
  private Boolean activo;

  public InformeRecepcionDet getInf_rec_det() throws BaseException { 
    supportRefresh();
    return inf_rec_det;
  }

  public void setInf_rec_det(InformeRecepcionDet aInf_rec_det) { 
    this.inf_rec_det =  aInf_rec_det;
  }

  public RemitoDet getRemito_det() throws BaseException { 
    supportRefresh();
    return remito_det;
  }

  public void setRemito_det(RemitoDet aRemito_det) { 
    this.remito_det =  aRemito_det;
  }

  public Double getCantidad() throws BaseException { 
    supportRefresh();
    return cantidad;
  }

  public void setCantidad(Double aCantidad) { 
    this.cantidad =  aCantidad;
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

 public static AplicInfRecRto findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (AplicInfRecRto) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static AplicInfRecRto findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (AplicInfRecRto) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(inf_rec_det, "Debe ingresar el Informe de Recepción");
    Validar.noNulo(remito_det, "Debe ingresar el Remito");
    Validar.noNulo(cantidad, "Debe ingresar la cantidad");
    Validar.noNulo(um, "Debe ingresar la Unidad de Medida");
 }

}
