package com.srn.erp.stock.bm;

import java.util.List;

import com.srn.erp.stock.da.DBComproAjusteStkDetAnu;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class ComproAjusteStkDetAnu extends ObjetoLogico { 

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

	public ComproAjusteStkDetAnu() { 
  }

  public static String NICKNAME = "st.ComproAjusteStkDetAnu";

  private ComproAjusteStkAnu compro_aju_stk_anu;
  private ComproAjusteStkDet compro_aju_stk_det;

  public ComproAjusteStkAnu getCompro_aju_stk_anu() throws BaseException { 
    supportRefresh();
    return compro_aju_stk_anu;
  }

  public void setCompro_aju_stk_anu(ComproAjusteStkAnu aCompro_aju_stk_anu) { 
    this.compro_aju_stk_anu =  aCompro_aju_stk_anu;
  }

  public ComproAjusteStkDet getCompro_aju_stk_det() throws BaseException { 
    supportRefresh();
    return compro_aju_stk_det;
  }

  public void setCompro_aju_stk_det(ComproAjusteStkDet aCompro_aju_stk_det) { 
    this.compro_aju_stk_det =  aCompro_aju_stk_det;
  }

  public String getNickName() { 
    return NICKNAME; 
  } 

 public static ComproAjusteStkDetAnu findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (ComproAjusteStkDetAnu) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static ComproAjusteStkDetAnu findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (ComproAjusteStkDetAnu) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(compro_aju_stk_anu, "Debe ingresar el Comprobante de Anulación");
    Validar.noNulo(compro_aju_stk_det, "Debe ingresar el Detalle del comprobante");
 }
 
 public static List getDetalles(ComproAjusteStkAnu compro,
     ISesion aSesion) throws BaseException {
 	return DBComproAjusteStkDetAnu.getDetalles(compro,aSesion);
 }
 

}
