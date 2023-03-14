package com.srn.erp.pagos.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.contabilidad.bm.CuentaImputable;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class ConceptoOPVarias extends ObjetoLogico { 

  public ConceptoOPVarias() { 
  }

  public static String NICKNAME = "pag.ConceptoOPVarias";

  private String codigo;
  private String descripcion;
  private CuentaImputable cuenta_imputable;
  private Boolean activo;
  
  private List unidadesOrganizativas = new ArrayList();
  private boolean readUnidadesOrganzativas = true;
  

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

  public CuentaImputable getCuenta_imputable() throws BaseException { 
    supportRefresh();
    return cuenta_imputable;
  }

  public void setCuenta_imputable(CuentaImputable aCuenta_imputable) { 
    this.cuenta_imputable =  aCuenta_imputable;
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

 public static ConceptoOPVarias findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (ConceptoOPVarias) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static ConceptoOPVarias findByOidProxy(Integer oid , ISesion aSesion) throws BaseException { 
   return (ConceptoOPVarias) getObjectByOidProxy(NICKNAME,oid,aSesion);
  } 
 
 
 public static ConceptoOPVarias findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (ConceptoOPVarias) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(codigo, "Debe ingresar el Código");
    Validar.noNulo(cuenta_imputable, "Debe ingresar la Cuenta Contable");
 }
 
 public List getUnidadesOrganizativas() throws BaseException {
   if (this.readUnidadesOrganzativas) {
     List listaUniOrg = ConceptoOPVariasHab.getUnidadesOrganizativas(this,getSesion());
     this.unidadesOrganizativas.addAll(listaUniOrg);
     this.readUnidadesOrganzativas = false;
   }
   return unidadesOrganizativas;
 }

 public void addUnidadOrganizativa(ConceptoOPVariasHab conceptoOPVariasHab) throws BaseException {
	 conceptoOPVariasHab.setConcepto_pv(this);
   this.unidadesOrganizativas.add(conceptoOPVariasHab);
 }

 public void afterSave() throws BaseException {
   Iterator iterConcOPVariasHab = this.unidadesOrganizativas.iterator();
   while (iterConcOPVariasHab.hasNext()) {
     ConceptoOPVariasHab concOPVariasHab = (ConceptoOPVariasHab) iterConcOPVariasHab.next();
     concOPVariasHab.save();
     concOPVariasHab = null;
   }
   iterConcOPVariasHab = null;
 }
 
	
 

}
