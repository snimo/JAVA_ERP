package com.srn.erp.contabilidad.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.compras.bm.InformeRecepcion;
import com.srn.erp.compras.bm.InformeRecepcionDet;
import com.srn.erp.contabilidad.da.DBCompoAtributo;
import com.srn.erp.contabilidad.da.DBComponente;
import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.general.bm.IEntidadClasificable;
import com.srn.erp.general.bm.IValorClasificadorEntidad;
import com.srn.erp.general.bm.ValorClasificadorEntidad;

import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoServidor;
import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.Validar;

public class Componente extends ObjetoLogico {

  public Componente() {
  }

  public static final String COMPO_STANDARD      = "STD";
  public static final String COMPO_ENTIDAD       = "ENT";
  public static final String COMPO_CLASIFICADOR  = "CLA";
  public static final String COMPO_TEXTO         = "TXT";
  public static final String COMPO_DATE          = "FEC";
  public static final String COMPO_DEC           = "DEC";
  public static final String COMPO_INT           = "INT";


  public static String NICKNAME = "cg.Componente";

  private String codigo;
  private String descripcion;
  private String tipo;
  private Boolean activo;
  private Integer nroClasificador;
  private String nombreNickName;
  private Integer longitud;
  private Integer precision;

  private List listaAtributos = new ArrayList();
  private boolean leerAtributos = true;

  public void setLongitud(Integer aLongitud) throws BaseException {
    this.longitud = aLongitud;
  }

  public Integer getLongitud() throws BaseException {
    supportRefresh();
    return longitud;
  }
  
  public void setPrecision(Integer aPrecision) throws BaseException {
    this.precision = aPrecision;
  }

  public Integer getPrecision() throws BaseException {
    supportRefresh();
    return precision;
  }
  
  
  public void setNroClasificador(Integer nroClasificador) throws BaseException {
    this.nroClasificador = nroClasificador;
  }

  public Integer getNroClasificador() throws BaseException {
    supportRefresh();
    return nroClasificador;
  }
  

  public void setNombreNickName(String aNombreNickName) throws BaseException {
    this.nombreNickName = aNombreNickName;
  }

  public String getNombreNickName() throws BaseException {
    supportRefresh();
    return nombreNickName;
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

  public String getTipo() throws BaseException {
    supportRefresh();
    return tipo;
  }

  public void setTipo(String aTipo) {
    this.tipo =  aTipo;
  }

  public Boolean isActivo() throws BaseException {
    supportRefresh();
    return activo;
  }

  public String getCampoFisicoAnaImp() throws BaseException {
    return "oid_co_"+getCodigo();
  }

  public void setActivo(Boolean aActivo) {
    this.activo =  aActivo;
  }

  public String getNickName() {
    return NICKNAME;
  }

 public static Componente findByOid(Integer oid , ISesion aSesion) throws BaseException {
   return (Componente) getObjectByOid(NICKNAME,oid,aSesion);
  }

  public static Componente findByOidProxy(Integer oid , ISesion aSesion) throws BaseException {
    return (Componente) getObjectByOidProxy(NICKNAME,oid,aSesion);
   }


 public static Componente findByCodigo(String codigo , ISesion aSesion) throws BaseException {
   return (Componente) getObjectByCodigo(NICKNAME,codigo,aSesion);
  }

 public void beforeSave() throws BaseException {
    Validar.noNulo(codigo, "Debe ingresar el código");
    Validar.noNulo(descripcion, "Debe ingresar la descripción");
    Validar.noNulo(tipo, "Debe ingresar el Tipo");

   if (isNew() && (isActivo().booleanValue() == false))
     Validar.mensajeValidacion("Debe darse de alta el componente como Activo");

   if (getTipo().equals(COMPO_CLASIFICADOR)) {
     Validar.noNulo(nroClasificador, "Debe ingresar el Clasificador");
     Validar.noNulo(nombreNickName, "Debe ingresar la Entidad");
   }
   else if (getTipo().equals(COMPO_ENTIDAD))
            Validar.noNulo(nombreNickName, "Debe ingresar la Entidad");
 }

 public void afterSave() throws BaseException {
   Iterator iterCompoAtributos = listaAtributos.iterator();
   while (iterCompoAtributos.hasNext()) {
     CompoAtributo compoAtributo = (CompoAtributo) iterCompoAtributos.next();
     compoAtributo.save();
     compoAtributo = null;
   }
   iterCompoAtributos = null;
 }


 public List getCompoAtributos() throws BaseException {

   if (leerAtributos) {
     List listaDeAtributos = DBCompoAtributo.getAtributosByCompo(this,getSesion());
     listaAtributos.addAll(listaDeAtributos);
     leerAtributos = false;
   }

   return listaAtributos;
 }

 public void addCompoAtributo(CompoAtributo compoAtributo) throws BaseException {
   compoAtributo.setCompo(this);
   listaAtributos.add(compoAtributo);
 }

 public String getTableName() throws BaseException {
   return "CGCOMPO_"+getCodigo();
 }

 public static List getAllComponentes(ISesion aSesion) throws BaseException {
   return (List) DBComponente.getAllComponentes(aSesion);
 }

 public String getListaCamposAuxiliares() throws BaseException {
   return getListaCampos(this);
 }

 public String getListaCampos() throws BaseException {
   return getListaCampos(this);
 }

 private String getListaCampos(Componente componente) throws BaseException {
   StringBuffer campos = new StringBuffer(50);
   campos.append(","+componente.getCampoFisicoAnaImp());
   Iterator iterCompoAtri = componente.getCompoAtributos().iterator();
   while (iterCompoAtri.hasNext()) {
     CompoAtributo compoAtri = (CompoAtributo)(iterCompoAtri.next());
     if (compoAtri.getAtributo().isValorCompo())
       campos.append(getListaCampos(compoAtri.getAtributo().getCompo()));
   }
   return campos.toString();
 }


 public List getListaCompoActualyAuxiliares() throws BaseException {
   return getListaCompoAuxiliares(this);
 }

 private List getListaCompoAuxiliares(Componente componente) throws BaseException {
   List listaCompoAux = new ArrayList();
   listaCompoAux.add(componente);
   Iterator iterCompoAtri = componente.getCompoAtributos().iterator();
   while (iterCompoAtri.hasNext()) {
     CompoAtributo compoAtri = (CompoAtributo)(iterCompoAtri.next());
     if (compoAtri.getAtributo().isValorCompo())
       listaCompoAux.addAll(getListaCompoAuxiliares(compoAtri.getAtributo().getCompo()));
   }
   return listaCompoAux;
 }

 public static Componente getComponente(String nickname,
                                        Integer nroClasificador,
                                        ISesion aSesion)
                                                     throws BaseException {
   return DBComponente.getComponente(nickname,nroClasificador,aSesion);
 }

 public boolean isEstandar() throws BaseException {
   if (getTipo().equals(COMPO_STANDARD))
     return true;
   else
     return false;
 }

 public boolean isEntidad() throws BaseException {
   if (getTipo().equals(COMPO_ENTIDAD))
     return true;
   else
     return false;
 }

 public boolean isClasificador() throws BaseException {
   if (getTipo().equals(COMPO_CLASIFICADOR))
     return true;
   else
     return false;
 }

 public IObjetoLogico getValorCompo(String codigo) throws BaseException {
   if (isEstandar())
     return ValorCompo.findByCodigo(this,codigo,getSesion());
   else
     if (isClasificador()) {
       ClasificadorEntidad clasifEnt =
           ClasificadorEntidad.getClasificadorEntidad(this.getNombreNickName(),
                                                      this.getNroClasificador(),
                                                      getSesion());
       return clasifEnt.getValorClasifEnt(codigo);
     }
     else if (isEntidad()) {
       return ObjetoLogico.getObjectByCodigo(this.getNombreNickName(),codigo,getSesion());
     }
     else throw new ExceptionValidation(null,"Tipo de componente desconocido");
 }

 public IObjetoLogico getValorCompo(Integer oid) throws BaseException {
	 if (oid == null) return null;
   if (isEstandar())
     return ValorCompo.findByOid(this,oid,getSesion());
   else
     if (isClasificador()) {
       ValorClasificadorEntidad valClasifEnt =
           ValorClasificadorEntidad.findByOid(oid,getSesion());
       return valClasifEnt;
     }
     else if (isEntidad()) {
       return ObjetoLogico.getObjectByOidProxy(this.getNombreNickName(),oid,getSesion());
     }
     else throw new ExceptionValidation(null,"Tipo de componente desconocido");
 }


 public static IObjetoLogico getObjectByCodigo(String nickname, String codigo,
                                               ISesion sesion) throws
     BaseException {
   IObjetoServidor os = sesion.getObjectServer(nickname);
   IObjetoLogico objLog = (IObjetoLogico) os.getObjectByCodigo(codigo);
   return objLog;
 }

 public String getCondWhereValor(IObjetoLogico objetoLogico) throws BaseException {
   ValorCompo valorCompoHijo;
   StringBuffer cond = new StringBuffer(50);
   cond.append(this.getCampoFisicoAnaImp()+
               "="+
               objetoLogico.getOIDInteger().toString());

   if (objetoLogico instanceof ValorCompo) {
     ValorCompo valorCompo = (ValorCompo) objetoLogico;
     Iterator iterCompoAtri = this.getCompoAtributos().iterator();
     while (iterCompoAtri.hasNext()) {
       CompoAtributo compoAtri = (CompoAtributo) iterCompoAtri.next();
       if (compoAtri.getAtributo().isValorCompo()) {
         valorCompoHijo =
             valorCompo.getAtributoCompo(compoAtri.getAtributo().
                                         getCampoFisico());
         if ( (valorCompoHijo == null) || (valorCompoHijo.getOIDInteger() == null))
           throw new ExceptionValidation(null,
                                         "No se ha ingresado un valor de " +
                                         compoAtri.getAtributo().
                                         getDescripcion() +
                                         " para el componente " +
                                         valorCompo.getComponente().
                                         getDescripcion() +
                                         " correspondiente al valor " +
                                         valorCompo.getCodigo() + " - " +
                                         valorCompo.getDescripcion());
         cond.append(" and " + getCondWhereValor(valorCompoHijo));
       }
   }
   }
   return cond.toString();
 }

 public String getCondWhereListaValores(IObjetoLogico objetoLogico) throws BaseException {
   ValorCompo valorCompoHijo;
   StringBuffer cond = new StringBuffer(50);
   cond.append(","+objetoLogico.getOIDInteger().toString());

   if (objetoLogico instanceof ValorCompo) {
     ValorCompo valorCompo = (ValorCompo) objetoLogico;
     Iterator iterCompoAtri = valorCompo.getComponente().getCompoAtributos().
         iterator();
     while (iterCompoAtri.hasNext()) {
       CompoAtributo compoAtri = (CompoAtributo) iterCompoAtri.next();
       if (compoAtri.getAtributo().isValorCompo()) {
         valorCompoHijo =
             valorCompo.getAtributoCompo(compoAtri.getAtributo().
                                         getCampoFisico());
         if ( (valorCompoHijo == null) || (valorCompoHijo.getOIDInteger() == null))
           throw new ExceptionValidation(null,
                                         "No se ha ingresado un valor de " +
                                         compoAtri.getAtributo().
                                         getDescripcion() +
                                         " para el componente " +
                                         valorCompo.getComponente().
                                         getDescripcion() +
                                         " correspondiente al valor " +
                                         valorCompo.getCodigo() + " - " +
                                         valorCompo.getDescripcion());
         cond.append(getCondWhereListaValores(valorCompoHijo));
       }
     }
   }
   return cond.toString();
 }

 public List getValoresCompo() throws BaseException {
   if (this.isEntidad())
     return getValoresCompoEntidades();
   else
     if (this.isEstandar())
       return getValoresStandar();
     else
       if (this.isClasificador())
         return getValoresClasificador();
       else
         throw new ExceptionValidation(null,"Tipo de componente no soportado:"+getDescripcion());
 }

 private List getValoresCompoEntidades() throws BaseException {
   return (List) ObjetoLogico.getObjects(this.getNombreNickName(),
                                         DBObjetoPersistente.SELECT_ALL,
                                         null,
                                         new ListObserver(),
                                         getSesion());
 }

 private List getValoresStandar() throws BaseException {
   return ValorCompo.getValoresCompo(this,getSesion());
 }


 private ClasificadorEntidad getClasificadorEntidad() throws BaseException {
   return ClasificadorEntidad.getClasificadorEntidad(getNombreNickName(),getNroClasificador(),getSesion());
 }

 private List getValoresClasificador() throws BaseException {
   ClasificadorEntidad clasifEntidad = getClasificadorEntidad();
   return clasifEntidad.getValoresClasificador();
 }

 
  public static Componente getCompoInfRecDet(ISesion aSesion) throws BaseException {
	return DBComponente.getComponente(COMPO_ENTIDAD,InformeRecepcionDet.NICKNAME,aSesion);
  }	

  public static Componente getCompoInfRec(ISesion aSesion) throws BaseException {
		return DBComponente.getComponente(COMPO_ENTIDAD,InformeRecepcion.NICKNAME,aSesion);
  }
  
  private static IObjetoLogico getDeducirValorCompoClasif(HashTableDatos valoresCompo,
		  Componente compo,ISesion aSesion) throws BaseException {
	  
	  // Recorrer los componente haber si esta la entidad del clasificador
	  Iterator iterCompoAsignados = 
		  valoresCompo.keySet().iterator();
	  while (iterCompoAsignados.hasNext()) {
		  Componente compoAsig = (Componente) iterCompoAsignados.next();
		  
		  if (compoAsig.isEntidad()) {
			  
			  if (compoAsig.getNombreNickName().equals(compo.getNombreNickName())) {
				  
				  ClasificadorEntidad clasifEnt = 
					  ClasificadorEntidad.getClasificadorEntidad(
						  compo.getNombreNickName(), 
						  compo.getNroClasificador(), 
						  aSesion);
				
				  IObjetoLogico objLog = (IObjetoLogico) valoresCompo.get(compoAsig);
				  
				  if (objLog instanceof IEntidadClasificable) {
					  IEntidadClasificable entidadClasif = (IEntidadClasificable) objLog;
					  IValorClasificadorEntidad valorClasifEnt = 
						  entidadClasif.getValorClasifEnt(clasifEnt);
					  if (valorClasifEnt == null)
						  return null;
					  else
						  return (IObjetoLogico)valorClasifEnt;
					  
					  //throw new ExceptionValidation(null,
					  //		  "No se encuentra asignado un valor para el clasificador "+
					  //		  clasifEnt.getDescripcion()+
					  //		  " correspondiente al "+
					  //		  compoAsig.getDescripcion()+" "+objLog.getCodigo()+"-"+objLog.getDescripcion());

					  
				  }
				  
			  }
			  
		  }

		  
	  }
	  
	  return null;
	  
  }

  
  public static IObjetoLogico getDeducirValorComponente(
		  HashTableDatos valoresCompo,
		  Componente compo,ISesion aSesion) throws BaseException {
	  
	  if (compo.isClasificador()) 
		return getDeducirValorCompoClasif(valoresCompo,compo,aSesion);
	  
	  
	  return null;
  }


}
