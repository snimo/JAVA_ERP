package com.srn.erp.impuestos.bm;

import java.util.Hashtable;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class Impuesto extends ObjetoLogico {

  public Impuesto() {
  }

  public static final String CODIGO_IVA          =  "IVA";
  public static final String CODIGO_PERC_IVA     =  "PERC_IVA";
  public static final String CODIGO_PERC_IB_BA      =  "PI_BA";
  public static final String CODIGO_PERC_IB_CF      =  "PI_CF";
  public static final String CODIGO_RET_IVA      =  "RET_IVA";
  public static final String CODIGO_RET_GAN      =  "RET_GAN";
  public static final String CODIGO_RET_IB       =  "RET_IB";
  public static final String CODIGO_RET_SUS       = "RET_SUS";
  public static final String CODIGO_IMP_INT      =  "IMP_INT";
  public static final String CODIGO_IMP_INT_C      =  "IMP_INT_C";
  public static final String CODIGO_RET_IVA_P      =  "RET_IVA_P";
  public static final String CODIGO_RET_GAN_P      =  "RET_GAN_P";
  public static final String CODIGO_RET_IB_P       =  "RET_IB_P";
  public static final String CODIGO_RET_SUS_P       = "RET_SUS_P";
    

  public static final String DESC_IVA          =  "IVA Ventas";
  public static final String DESC_PERC_IVA     =  "Percepción IVA Ventas";
  public static final String DESC_PERC_IB_BA      =  "Percepción IB Ventas Buenos Aires";
  public static final String DESC_PERC_IB_CF      =  "Percepción IB Ventas Capital Federal";
  
  public static final String DESC_RET_IVA      =  "Retención IVA Cobranzas";
  public static final String DESC_RET_GAN      =  "Retención Ganancias Cobranzas";
  public static final String DESC_RET_IB       =  "Retención IB Cobranzas";
  public static final String DESC_RET_SUS      =  "Retención S.U.S. Cobranzas";
  
  public static final String DESC_RET_IVA_P      =  "Retención IVA Pagos";
  public static final String DESC_RET_GAN_P      =  "Retención Ganancias Pagos";
  public static final String DESC_RET_IB_P       =  "Retención IB Pagos";
  public static final String DESC_RET_SUS_P      =  "Retención S.U.S. Pagos";
  
  
  public static final String DESC_IMP_INT      =  "Impuestos Internos Ventas";
  public static final String DESC_IMP_INT_C      =  "Impuestos Internos Compras";
  
  public static final String CODIGO_IVA_C          =  "IVA_C";
  public static final String CODIGO_PERC_IVA_C     =  "PERC_IVA_C";
  
  
  public static final String CODIGO_PERC_IB_C      =  "PERC_IB_C";
  
  
  public static final String DESC_IVA_C          =  "IVA Compras";
  public static final String DESC_PERC_IVA_C     =  "Percepción IVA Compras";
  public static final String DESC_PERC_IB_C      =  "Percepción IB Compras";
  
  public static final String DESC_PERC_IB_BA_C      =  "Perc. IB Bs. As. Compras";
  public static final String DESC_PERC_IB_CF_C      =  "Perc. IB C.F. Compras";
  
  
  
  

  public static String NICKNAME = "im.Impuesto";

  private String codigo;
  private String descripcion;
  private String compo;
  private Boolean activo;
  private Boolean ventas;
  private Boolean compras;
  
  public Boolean isVentas() throws BaseException {
	  supportRefresh();
	  return this.ventas;
  }
  
  public void setVentas(Boolean aVentas) throws BaseException {
	  this.ventas = aVentas;
  }
  
  public Boolean isCompras() throws BaseException {
	  supportRefresh();
	  return this.compras;
  }
  
  public void setCompras(Boolean aCompras) throws BaseException {
	  this.compras = aCompras;
  }
  

  public boolean isIVA() throws BaseException {
    return getCompo().equals(CODIGO_IVA);
  }
  
  public boolean isPercIB() throws BaseException {
    return getCompo().equals(CODIGO_PERC_IB_BA) || getCompo().equals(CODIGO_PERC_IB_CF);
  }
  
  public boolean isPercIBBsAs() throws BaseException {
    return getCompo().equals(CODIGO_PERC_IB_BA);
  }
  
  public boolean isPercIBCapFed() throws BaseException {
    return getCompo().equals(CODIGO_PERC_IB_CF);
  }
  
  public boolean isPercIBCompras() throws BaseException {
    return (getCompo().equals(CODIGO_PERC_IB_C));
  }
  
  public boolean isIVACompras() throws BaseException {
    return getCompo().equals(CODIGO_IVA_C);
  }
  
  
  public boolean isPercIVA() throws BaseException {
	return getCompo().equals(CODIGO_PERC_IVA);
  }
  
  public boolean isPercIVACompras() throws BaseException {
  	return getCompo().equals(CODIGO_PERC_IVA_C);
    }
  
  public boolean isImpInterno() throws BaseException {
	  return getCompo().equals(CODIGO_IMP_INT);
  }
  
  public boolean isImpInternoCompras() throws BaseException {
  	return getCompo().equals(CODIGO_IMP_INT_C);
  }  
  

  public String getCodigo() throws BaseException {
    supportRefresh();
    return codigo;
  }

  public void setCodigo(String aCodigo) {
    this.codigo =  aCodigo;
  }

  public String getDescripcion() throws BaseException {
    supportRefresh();
    return descripcion;
  }

  public void setDescripcion(String aDescripcion) {
    this.descripcion =  aDescripcion;
  }

  public String getCompo() throws BaseException {
    supportRefresh();
    return compo;
  }

  public void setCompo(String aCompo) {
    this.compo =  aCompo;
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

 public static Impuesto findByOid(Integer oid , ISesion aSesion) throws BaseException {
   return (Impuesto) getObjectByOid(NICKNAME,oid,aSesion);
  }

  public static Impuesto findByOidProxy(Integer oid , ISesion aSesion) throws BaseException {
    return (Impuesto) getObjectByOidProxy(NICKNAME,oid,aSesion);
   }


 public static Impuesto findByCodigo(String codigo , ISesion aSesion) throws BaseException {
   return (Impuesto) getObjectByCodigo(NICKNAME,codigo,aSesion);
  }

 public void beforeSave() throws BaseException {

   Validar.noNulo(codigo, "Debe ingresar un Código");
   Validar.noNulo(descripcion, "Debe ingresar la Descripción");
   Validar.noNulo(compo, "Debe ingresar el Comportamiento");

   if (isNew() && (isActivo().booleanValue() == false))
     Validar.mensajeValidacion("El impuesto debe ingresarse en modo activo");

 }

 public static Hashtable getListaComportamiento() throws BaseException {
   Hashtable lista = new Hashtable();
   lista.put(CODIGO_IVA,DESC_IVA);
   lista.put(CODIGO_PERC_IVA,DESC_PERC_IVA);
   lista.put(CODIGO_PERC_IB_BA,DESC_PERC_IB_BA);
   lista.put(CODIGO_PERC_IB_CF,DESC_PERC_IB_CF);
   lista.put(CODIGO_PERC_IB_C,DESC_PERC_IB_C);
   lista.put(CODIGO_RET_IVA,DESC_RET_IVA);
   lista.put(CODIGO_RET_GAN,DESC_RET_GAN);
   lista.put(CODIGO_RET_SUS, DESC_RET_SUS);
   lista.put(CODIGO_RET_IB,DESC_RET_IB);
   lista.put(CODIGO_IMP_INT,DESC_IMP_INT);
   lista.put(CODIGO_IMP_INT_C,DESC_IMP_INT_C);
   lista.put(CODIGO_IVA_C,DESC_IVA_C);
   lista.put(CODIGO_PERC_IVA_C,DESC_PERC_IVA_C);
   lista.put(CODIGO_RET_IVA_P,DESC_RET_IVA_P);
   lista.put(CODIGO_RET_GAN_P,DESC_RET_GAN_P);
   lista.put(CODIGO_RET_SUS_P, DESC_RET_SUS_P);
   lista.put(CODIGO_RET_IB_P,DESC_RET_IB_P);
   
   return lista;
 }

 public boolean isRetGan() throws BaseException {
   return getCompo().equals(CODIGO_RET_GAN);
 }
 
 public boolean isRetIVAPagos() throws BaseException {
   return getCompo().equals(CODIGO_RET_IVA_P);
 }
 
 public boolean isRetGanPagos() throws BaseException {
   return getCompo().equals(CODIGO_RET_GAN_P);
 }
 
 public boolean isRetIBPagos() throws BaseException {
   return getCompo().equals(CODIGO_RET_IB_P);
 }
 
 
 

 public boolean isRetencion() throws BaseException {
   return (getCompo().equals(CODIGO_RET_GAN)) || (getCompo().equals(CODIGO_RET_IB)) || (getCompo().equals(CODIGO_RET_IVA));
 }

}
