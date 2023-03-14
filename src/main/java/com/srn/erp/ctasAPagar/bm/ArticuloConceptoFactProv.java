package com.srn.erp.ctasAPagar.bm;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class ArticuloConceptoFactProv extends ObjetoLogico { 

  public ArticuloConceptoFactProv() { 
  }

  public static String NICKNAME = "cap.ArticuloConceptoFactProv";

  private ComproProvInfRecOC detalle_infrecdet_ocdet;
  private ComproProveedorDet proveedor_det;
  private Double impo_mon_ori;
  private Boolean activo;

  public ComproProvInfRecOC getDetalle_infrecdet_ocdet() throws BaseException { 
    supportRefresh();
    return detalle_infrecdet_ocdet;
  }

  public void setDetalle_infrecdet_ocdet(ComproProvInfRecOC aDetalle_infrecdet_ocdet) { 
    this.detalle_infrecdet_ocdet =  aDetalle_infrecdet_ocdet;
  }

  public ComproProveedorDet getProveedor_det() throws BaseException { 
    supportRefresh();
    return proveedor_det;
  }

  public void setProveedor_det(ComproProveedorDet aProveedor_det) { 
    this.proveedor_det =  aProveedor_det;
  }

  public Double getImpo_mon_ori() throws BaseException { 
    supportRefresh();
    return impo_mon_ori;
  }

  public void setImpo_mon_ori(Double aImpo_mon_ori) { 
    this.impo_mon_ori =  aImpo_mon_ori;
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

 public static ArticuloConceptoFactProv findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (ArticuloConceptoFactProv) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static ArticuloConceptoFactProv findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (ArticuloConceptoFactProv) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(detalle_infrecdet_ocdet, "Debe ingresar el detalle de Artículo");
    Validar.noNulo(proveedor_det, "Debe ingresar el Concepto Proveedor");
    Validar.noNulo(impo_mon_ori, "Debe ingresar el importe");
 }

public String getCodigo() throws BaseException {
	// TODO Auto-generated method stub
	return null;
}

public String getDescripcion() throws BaseException {
	// TODO Auto-generated method stub
	return null;
}

}
