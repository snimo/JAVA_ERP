package com.srn.erp.bienUso.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.bienUso.da.DBBienImputacion;
import com.srn.erp.contabilidad.bm.CuentaImputable;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class BienImputacion extends ObjetoLogico { 

  public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

public BienImputacion() { 
  }

  public static String NICKNAME = "bu.BienImputacion";

  private Bien bien_uso;
  private java.util.Date vigencia_desde;
  private CuentaImputable cuenta_imputable;
  private Double porc;
  private Boolean activo;

  public Bien getBien_uso() throws BaseException { 
    supportRefresh();
    return bien_uso;
  }

  public void setBien_uso(Bien aBien_uso) { 
    this.bien_uso =  aBien_uso;
  }

  public java.util.Date getVigencia_desde() throws BaseException { 
    supportRefresh();
    return vigencia_desde;
  }

  public void setVigencia_desde(java.util.Date aVigencia_desde) { 
    this.vigencia_desde =  aVigencia_desde;
  }

  public CuentaImputable getCuenta_imputable() throws BaseException { 
    supportRefresh();
    return cuenta_imputable;
  }

  public void setCuenta_imputable(CuentaImputable aCuenta_imputable) { 
    this.cuenta_imputable =  aCuenta_imputable;
  }

  public Double getPorc() throws BaseException { 
    supportRefresh();
    return porc;
  }

  public void setPorc(Double aPorc) { 
    this.porc =  aPorc;
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

 public static BienImputacion findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (BienImputacion) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static BienImputacion findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (BienImputacion) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(bien_uso, "Debe ingresar el Bien");
    Validar.noNulo(vigencia_desde, "Debe ingresar la Vigencia Desde");
    Validar.noNulo(cuenta_imputable, "Debe ingresar la Cuenta Imputable");
    Validar.noNulo(porc, "Debe ingresar el Porcentaje");
 }
 
 public static List getImputaciones(Bien aBien,
         ISesion aSesion) throws BaseException {
   return DBBienImputacion.getImputaciones(aBien,aSesion);
 }  
 
 public static List getImputacionesVigentes(Bien aBien,
		  java.util.Date fecha,
         ISesion aSesion) throws BaseException {
	return DBBienImputacion.getImputacionesVigentes(aBien,fecha,aSesion);
 }  
 
 public static BienImputacion getPrimerBienImputacionVigente(Bien aBien,
		 													 java.util.Date aFecha,
		 													 ISesion aSesion) 
 															 throws BaseException {
	 BienImputacion bienImputacion = null;
	 List imputacionesVigentes = getImputacionesVigentes(aBien,aFecha,aSesion);
	 Iterator iterImputacionesVigentes = imputacionesVigentes.iterator();
	 while (iterImputacionesVigentes.hasNext()) {
		 bienImputacion = (BienImputacion) iterImputacionesVigentes.next();
		 break;
	 }
	 return bienImputacion;
 }
 
 
 public static List getImputacionesVigentesAFecha(Bien aBien,
		  java.util.Date fecha,
         ISesion aSesion) throws BaseException {
   BienImputacion bienImputacion = getPrimerBienImputacionVigente(aBien,fecha,aSesion);
   if (bienImputacion!=null)
     return DBBienImputacion.getImputacionesVigentesAFecha(aBien,bienImputacion.getVigencia_desde(),aSesion);
   else
	 return new ArrayList();  
 }  
 
  
 
}
