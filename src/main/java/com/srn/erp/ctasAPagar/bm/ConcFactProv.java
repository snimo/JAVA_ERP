package com.srn.erp.ctasAPagar.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.ctasAPagar.da.DBConcFactProv;
import com.srn.erp.general.bm.Moneda;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.applicarionServer.bm.Parametros.ValorParametro;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class ConcFactProv extends ObjetoLogico {

  public ConcFactProv() {
  }

  public static String NICKNAME = "cap.ConcFactProv";

  private String codigo;
  private String descripcion;
  private Boolean activo;
  private Integer orden;
  private Boolean es_rend_ff;
  private Boolean addCtasRendFF;

  private List conceptosImpuestos = new ArrayList();
  private boolean readConceptosImpuestos = true;
  
  private List cuentasConcFactProv = new ArrayList();
  private boolean readCuentasConcFactProv = true;
  

  public String getCodigo() throws BaseException {
    supportRefresh();
    return codigo;
  }

  public void setCodigo(String aCodigo) {
    this.codigo =  aCodigo;
  }
  
  public Boolean addCtasRendFF() throws BaseException {
	    supportRefresh();
	    return this.addCtasRendFF;
  }

  public void setAddCtasRendFF(Boolean aAddCtasRendFF) {
	this.addCtasRendFF =  aAddCtasRendFF;
  }
  
  
  public Boolean isRendicionFondoFijo() throws BaseException {
	    supportRefresh();
	    return this.es_rend_ff;
  }

  public void setEsRendicionFondoFijo(Boolean aEsRendFondoFijo) {
	    this.es_rend_ff =  aEsRendFondoFijo;
  }

  public String getDescripcion() throws BaseException {
    supportRefresh();
    return descripcion;
  }

  public void setDescripcion(String aDescripcion) {
    this.descripcion =  aDescripcion;
  }

  public Boolean isActivo() throws BaseException {
    supportRefresh();
    return activo;
  }

  public void setActivo(Boolean aActivo) {
    this.activo =  aActivo;
  }

  public Integer getOrden() throws BaseException {
    supportRefresh();
    return orden;
  }

  public void setOrden(Integer aOrden) {
    this.orden =  aOrden;
  }

  public String getNickName() {
    return NICKNAME;
  }

 public static ConcFactProv findByOid(Integer oid , ISesion aSesion) throws BaseException {
   return (ConcFactProv) getObjectByOid(NICKNAME,oid,aSesion);
  }

 public static ConcFactProv findByOidProxy(Integer oid , ISesion aSesion) throws BaseException {
    return (ConcFactProv) getObjectByOidProxy(NICKNAME,oid,aSesion);
 }

 public static ConcFactProv findByCodigo(String codigo , ISesion aSesion) throws BaseException {
   return (ConcFactProv) getObjectByCodigo(NICKNAME,codigo,aSesion);
  }

 public void beforeSave() throws BaseException {
    Validar.noNulo(codigo, "Debe ingresar el Código");
    Validar.noNulo(descripcion, "Debe ingresar la Descripción");
    Validar.noNulo(orden, "Debe ingresar el Orden");

   if (isNew() && (isActivo().booleanValue() == false))
     Validar.mensajeValidacion("El concepto factura debe ingresarse en modo activo");

 }

 public List getConceptosImpuestos() throws BaseException {
   if (readConceptosImpuestos) {
     List listaPeriodosIncDet =
         ConcFactProvImp.getConcFactProvImpByConcFactProv(this,getSesion());
     conceptosImpuestos.addAll(listaPeriodosIncDet);
     readConceptosImpuestos = false;
   }
   return conceptosImpuestos;
 }
 
 public List getCuentasConcFactProv() throws BaseException {
   if (this.readCuentasConcFactProv) {
     List listaCuentasConcFactProv =
         EsqCuentaConcFactProv.getEsqCuentasConcFactProv(this,getSesion());
     this.cuentasConcFactProv.addAll(listaCuentasConcFactProv);
     this.readCuentasConcFactProv = false;
   }
   return this.cuentasConcFactProv;
 }
 

 public void addConceptoImpuesto(ConcFactProvImp concFactProvImp) throws BaseException {
   concFactProvImp.setConcFactProv(this);
   conceptosImpuestos.add(concFactProvImp);
 }
 
 public void addCuentaConcFactProv(EsqCuentaConcFactProv esqCuentaConcFactProv) throws BaseException {
	 esqCuentaConcFactProv.setConc_fact_prov(this);
   cuentasConcFactProv.add(esqCuentaConcFactProv);
 }
 

 public void afterSave() throws BaseException {
  
	 Iterator iterConcFactProvImpu = conceptosImpuestos.iterator();
   while (iterConcFactProvImpu.hasNext()) {
     ConcFactProvImp concFactProvImp = (ConcFactProvImp) iterConcFactProvImpu.next();
     concFactProvImp.save();
     concFactProvImp = null;
   }
   iterConcFactProvImpu = null;
   
	 Iterator iterCuentasConcFactProv = this.cuentasConcFactProv.iterator();
   while (iterCuentasConcFactProv.hasNext()) {
     EsqCuentaConcFactProv esqCuentaConcFactProv = (EsqCuentaConcFactProv) iterCuentasConcFactProv.next();
     esqCuentaConcFactProv.save();
     esqCuentaConcFactProv = null;
   }
   iterCuentasConcFactProv = null;   
   
 }

 public static List getConceptosFactProv(ISesion aSesion) throws BaseException {
   return DBConcFactProv.getConceptosFactProv(aSesion);
 }
 
 public static ConcFactProv getConcFactProvDefProd(ISesion aSesion) throws BaseException {
	   Integer oidConcFactProv =
	       ValorParametro.findByCodigoParametro("CONC_FACT_PROV_DEF_PROD",aSesion).getOidObjNeg();
	   ConcFactProv concFactProv = ConcFactProv.findByOid(oidConcFactProv,aSesion);
	   return concFactProv;
 }
 
 
 public static List getConceptosFactProvRendFondoFijo(ISesion aSesion) throws BaseException {
	    return DBConcFactProv.getConceptosFactProvRendFondoFijo(aSesion);
 }
 
 public static List getAllConceptosFactProv(ISesion aSesion) throws BaseException {
	    return DBConcFactProv.getAllConceptosFactProv(aSesion);
}
 
 
 

}
