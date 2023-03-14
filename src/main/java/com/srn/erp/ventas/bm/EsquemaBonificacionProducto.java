package com.srn.erp.ventas.bm;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.stock.bm.Producto;
import com.srn.erp.ventas.da.DBEsquemaBonificacionProducto;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class EsquemaBonificacionProducto extends ObjetoLogico { 

  public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}
	
  private List esquemasBonifProdDet = new ArrayList();
  private boolean readEsquemasBonifProdDet = true;
	

  public EsquemaBonificacionProducto() { 
  }

  public static String NICKNAME = "ve.EsquemaBonificacionProducto";

  private EsquemaBonificacion esquema_bonificacion;
  private Producto producto;
  private Boolean activo;

  public EsquemaBonificacion getEsquema_bonificacion() throws BaseException { 
    supportRefresh();
    return esquema_bonificacion;
  }

  public void setEsquema_bonificacion(EsquemaBonificacion aEsquema_bonificacion) { 
    this.esquema_bonificacion =  aEsquema_bonificacion;
  }

  public Producto getProducto() throws BaseException { 
    supportRefresh();
    return producto;
  }

  public void setProducto(Producto aProducto) { 
    this.producto =  aProducto;
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

 public static EsquemaBonificacionProducto findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (EsquemaBonificacionProducto) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static EsquemaBonificacionProducto findByOidProxy(Integer oid , ISesion aSesion) throws BaseException { 
	return (EsquemaBonificacionProducto) getObjectByOidProxy(NICKNAME,oid,aSesion); 
 } 
 
 
 public static EsquemaBonificacionProducto findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (EsquemaBonificacionProducto) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(esquema_bonificacion, "Debe ingresar el esquema de Bonificación");
    Validar.noNulo(producto, "Debe ingresar el Producto");
 }
 
 public static List getEsquemasBonifProducto(EsquemaBonificacion esquemaBonificacion,
         ISesion aSesion) throws BaseException {
	  return DBEsquemaBonificacionProducto.getEsquemasBonifProducto(esquemaBonificacion,aSesion);
 } 
 
 public List getEsquemasBonifProdDet() throws BaseException {
   if (readEsquemasBonifProdDet) {
	   List listaEsquemasBonifProdDet = EsquemaBonifProdDet.getEsquemasBonifProdDet(this,getSesion());
	   esquemasBonifProdDet.addAll(listaEsquemasBonifProdDet);
	   readEsquemasBonifProdDet = false;
   }
   return esquemasBonifProdDet;
 }

 public void addEsquemaBonifProdDet(EsquemaBonifProdDet aEsquemaBonificacionProductoDet) throws BaseException {
	 aEsquemaBonificacionProductoDet.setEsquema_bonif_producto(this);
	 esquemasBonifProdDet.add(aEsquemaBonificacionProductoDet);
 }

 public void afterSave() throws BaseException {
	Iterator iterEsqBonifProdDet = esquemasBonifProdDet.iterator();
	while (iterEsqBonifProdDet.hasNext()) {
	  EsquemaBonifProdDet esquemaBonificacionProductoDet = (EsquemaBonifProdDet) iterEsqBonifProdDet.next();
	  esquemaBonificacionProductoDet.save();
	  esquemaBonificacionProductoDet = null;
	  }
	iterEsqBonifProdDet = null;
  }
 
 public static EsquemaBonificacionProducto getEsquemaBonifPro(EsquemaBonificacion esquemaBonificacion,
		   Producto producto,
		   ISesion aSesion)
 throws BaseException {
	 return DBEsquemaBonificacionProducto.getEsquemaBonifPro(esquemaBonificacion,producto,aSesion);
 }
 
 public EsquemaBonifProdDet getEsquemaBonifProdDetVigAFecha(Date fecha) throws BaseException {
	 return EsquemaBonifProdDet.getEsquemasBonifProdDetVigAFecha(this,fecha,getSesion());
 }
 
 

}
