package com.srn.erp.contabilidad.bm;

import java.util.Date;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.contabilidad.da.DBValorCompo;

import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.Validar;

public class ValorCompo extends ObjetoLogico {

  Hashtable valoresAtributos = new Hashtable();

  public ValorCompo() {
  }

  public static String NICKNAME = "cg.ValorCompo";

  private String codigo;
  private String descripcion;
  private Boolean activo;
  private Componente componente;

  public Iterator getIterKeysAtributos() throws BaseException {
    return valoresAtributos.keySet().iterator();
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

 public static ValorCompo findByOid(Integer oid , ISesion aSesion) throws BaseException {
   return (ValorCompo) getObjectByOid(NICKNAME,oid,aSesion);
  }

  public static ValorCompo findByOid(Componente componente,Integer oid , ISesion aSesion) throws BaseException {
    ValorCompo vc = DBValorCompo.getValorCompoByOid(componente,oid,aSesion);
    if (vc == null)
      vc = (ValorCompo) ValorCompo.getNew(ValorCompo.NICKNAME, aSesion);
    vc.setComponente(componente);
    return vc;
   }


  public static ValorCompo findByOidProxy(Integer oid , ISesion aSesion) throws BaseException {
    return (ValorCompo) getObjectByOidProxy(NICKNAME,oid,aSesion);
   }

  public static ValorCompo findByCodigo(Componente componente,
                                        String codigo ,
                                        ISesion aSesion) throws BaseException {
     ValorCompo vc = DBValorCompo.getValorCompoByCodigo(componente,codigo,aSesion);
     if (vc != null)
         vc.setComponente(componente);
     return vc;
  }


 public static ValorCompo findByCodigo(String codigo , ISesion aSesion) throws BaseException {
   return (ValorCompo) getObjectByCodigo(NICKNAME,codigo,aSesion);
  }

 public void beforeSave() throws BaseException {

    Validar.noNulo(codigo, "Debe ingresar el código");
    Validar.noNulo(descripcion, "Debe ingresar la descripción");
    if (isNew() && (isActivo().booleanValue() == false))
       Validar.mensajeValidacion("Debe darse de alta el componente como Activo");

 }

 public Componente getComponente() {
   return componente;
 }

 public void setComponente(Componente aComponente) {
   this.componente = aComponente;
 }

 public ValorCompo getAtributoCompo(String atributeName) {
   return (ValorCompo) (IObjetoLogico)(valoresAtributos.get(atributeName));
 }

 public Integer getAtributoInteger(String atributeName) {
   return (Integer)(valoresAtributos.get(atributeName));
 }

 public String getAtributoString(String atributeName) {
   return (String)(valoresAtributos.get(atributeName));
 }

 public Double getAtributoDouble(String atributeName) {
   return (Double)(valoresAtributos.get(atributeName));
 }

 public Date getAtributoDate(String atributeName) {
   return (Date)(valoresAtributos.get(atributeName));
 }

 public void addAtributo(String atributeName, Object valor) {
   valoresAtributos.put(atributeName,valor);
 }


 public String getCondWhereValoresCompo() throws BaseException {
   return getCondWhereValor(this);
 }

 private String getCondWhereValor(ValorCompo valorCompo) throws BaseException {
   ValorCompo valorCompoHijo;
   StringBuffer cond = new StringBuffer(50);
   cond.append(valorCompo.getComponente().getCampoFisicoAnaImp()+
               "="+
               valorCompo.getOIDInteger().toString());

   Iterator iterCompoAtri = valorCompo.getComponente().getCompoAtributos().iterator();
   while (iterCompoAtri.hasNext()) {
     CompoAtributo compoAtri = (CompoAtributo) iterCompoAtri.next();
     if (compoAtri.getAtributo().isValorCompo()) {
       valorCompoHijo =
           valorCompo.getAtributoCompo(compoAtri.getAtributo().getCampoFisico());
       if ((valorCompoHijo==null) || (valorCompoHijo.getOIDInteger()==null))
         throw new ExceptionValidation(null,"No se ha ingresado un valor de "+
                                       compoAtri.getAtributo().getDescripcion()+
                                       " para el componente "+valorCompo.getComponente().getDescripcion()+
                                      " correspondiente al valor "+
                                      valorCompo.getCodigo()+" - "+valorCompo.getDescripcion());
       cond.append(" and "+getCondWhereValor(valorCompoHijo));
     }
   }
   return cond.toString();
 }

 public String getCondWhereValorSinCompoAtri() throws BaseException {
   StringBuffer cond = new StringBuffer(50);
   cond.append(this.getComponente().getCampoFisicoAnaImp()+
               "="+
               this.getOIDInteger().toString());
   return cond.toString();
 }


 public String getCondWhereListaValores() throws BaseException {
   return getCondWhereListaValores(this);
 }

 private String getCondWhereListaValores(ValorCompo valorCompo) throws BaseException {
   ValorCompo valorCompoHijo;
   StringBuffer cond = new StringBuffer(50);
   cond.append(","+valorCompo.getOIDInteger().toString());

   Iterator iterCompoAtri = valorCompo.getComponente().getCompoAtributos().iterator();
   while (iterCompoAtri.hasNext()) {
     CompoAtributo compoAtri = (CompoAtributo) iterCompoAtri.next();
     if (compoAtri.getAtributo().isValorCompo()) {
       valorCompoHijo =
           valorCompo.getAtributoCompo(compoAtri.getAtributo().getCampoFisico());
       if ((valorCompoHijo==null) || (valorCompoHijo.getOIDInteger()==null))
         throw new ExceptionValidation(null,"No se ha ingresado un valor de "+
                                       compoAtri.getAtributo().getDescripcion()+
                                       " para el componente "+valorCompo.getComponente().getDescripcion()+
                                      " correspondiente al valor "+
                                      valorCompo.getCodigo()+" - "+valorCompo.getDescripcion());
       cond.append(getCondWhereListaValores(valorCompoHijo));
     }
   }
   return cond.toString();
 }

 public String getDescValoresComponentes() throws BaseException {
   return getDescValoresComponentes(this);
 }

 private String getDescValoresComponentes(ValorCompo valorCompo) throws BaseException {
   ValorCompo valorCompoHijo;
   StringBuffer cond = new StringBuffer(50);
   cond.append("-"+valorCompo.getDescripcion());

   Iterator iterCompoAtri = valorCompo.getComponente().getCompoAtributos().iterator();
   while (iterCompoAtri.hasNext()) {
     CompoAtributo compoAtri = (CompoAtributo) iterCompoAtri.next();
     if (compoAtri.getAtributo().isValorCompo()) {
       valorCompoHijo =
           valorCompo.getAtributoCompo(compoAtri.getAtributo().getCampoFisico());
       if ((valorCompoHijo==null) || (valorCompoHijo.getOIDInteger()==null))
         throw new ExceptionValidation(null,"No se ha ingresado un valor de "+
                                       compoAtri.getAtributo().getDescripcion()+
                                       " para el componente "+valorCompo.getComponente().getDescripcion()+
                                      " correspondiente al valor "+
                                      valorCompo.getCodigo()+" - "+valorCompo.getDescripcion());
       cond.append(getDescValoresComponentes(valorCompoHijo));
     }
   }
   return cond.toString();
 }

 public static List getValoresCompo(Componente componente,
                                    ISesion aSesion) throws BaseException {
    return DBValorCompo.getValoresCompo(componente,aSesion);
 }







}
