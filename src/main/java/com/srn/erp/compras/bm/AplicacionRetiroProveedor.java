package com.srn.erp.compras.bm;

import com.srn.erp.stock.bm.UnidadMedida;
import com.srn.erp.ventas.bm.RemitoDet;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Varios.CalculadorMoney;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class AplicacionRetiroProveedor extends ObjetoLogico { 

  public void afterSaveNew() throws BaseException {
		// TODO Auto-generated method stub
		super.afterSaveNew();
		
		if (this.getControl_calidad_det()!=null) {
			
			// Calcular las cantidades retiradas en unidades de Stock
			CalculadorMoney calcCantRetiraUS = new CalculadorMoney(new Money(this.getCant_um_stk().doubleValue()));
			if (this.getControl_calidad_det().getCant_ret_prov_us()!=null)
				calcCantRetiraUS.sumar(new Money(this.getControl_calidad_det().getCant_ret_prov_us().doubleValue()));
			this.getControl_calidad_det().setCant_ret_prov_us(new Double(calcCantRetiraUS.getResultMoney().doubleValue()));
			
			// Calcular la cantidades retiradas en unidades de compra
			CalculadorMoney calcCantRetiraUC = new CalculadorMoney(new Money(this.getCant_um_cpra().doubleValue()));
			if (this.getControl_calidad_det().getCant_ret_prov_uc()!=null)
				calcCantRetiraUC.sumar(new Money(this.getControl_calidad_det().getCant_ret_prov_uc().doubleValue()));
			this.getControl_calidad_det().setCant_ret_prov_uc(new Double(calcCantRetiraUC.getResultMoney().doubleValue()));
			this.getControl_calidad_det().save();
		}
		
	}

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

	public AplicacionRetiroProveedor() { 
  }

  public static String NICKNAME = "cp.AplicacionRetiroProveedor";

  private InformeControlCalidadDet control_calidad_det;
  private RemitoDet remito_det;
  private Double cant_um_stk;
  private UnidadMedida oid_um_stk;
  private Double cant_um_cpra;
  private UnidadMedida oid_um_cpra;

  public InformeControlCalidadDet getControl_calidad_det() throws BaseException { 
    supportRefresh();
    return control_calidad_det;
  }

  public void setControl_calidad_det(InformeControlCalidadDet aControl_calidad_det) { 
    this.control_calidad_det =  aControl_calidad_det;
  }

  public RemitoDet getRemito_det() throws BaseException { 
    supportRefresh();
    return remito_det;
  }

  public void setRemito_det(RemitoDet aRemito_det) { 
    this.remito_det =  aRemito_det;
  }

  public Double getCant_um_stk() throws BaseException { 
    supportRefresh();
    return cant_um_stk;
  }

  public void setCant_um_stk(Double aCant_um_stk) { 
    this.cant_um_stk =  aCant_um_stk;
  }

  public UnidadMedida getOid_um_stk() throws BaseException { 
    supportRefresh();
    return oid_um_stk;
  }

  public void setOid_um_stk(UnidadMedida aOid_um_stk) { 
    this.oid_um_stk =  aOid_um_stk;
  }

  public Double getCant_um_cpra() throws BaseException { 
    supportRefresh();
    return cant_um_cpra;
  }

  public void setCant_um_cpra(Double aCant_um_cpra) { 
    this.cant_um_cpra =  aCant_um_cpra;
  }

  public UnidadMedida getOid_um_cpra() throws BaseException { 
    supportRefresh();
    return oid_um_cpra;
  }

  public void setOid_um_cpra(UnidadMedida aOid_um_cpra) { 
    this.oid_um_cpra =  aOid_um_cpra;
  }

  public String getNickName() { 
    return NICKNAME; 
  } 

 public static AplicacionRetiroProveedor findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (AplicacionRetiroProveedor) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static AplicacionRetiroProveedor findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (AplicacionRetiroProveedor) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(control_calidad_det, "Debe ingresar el Detalle del Inf. CC");
    Validar.noNulo(remito_det, "Debe ingresar el Detalle del Remito");
    Validar.noNulo(cant_um_stk, "Debe ingresar la cant. en U.M. de Stock");
    Validar.noNulo(oid_um_stk, "Unidad de Medida de Stock");
    Validar.noNulo(cant_um_cpra, "Debe ingresar la cant. en U.M. Compra");
 }

}
