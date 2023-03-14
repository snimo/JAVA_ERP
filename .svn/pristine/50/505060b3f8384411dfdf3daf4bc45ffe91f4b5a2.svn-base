package com.srn.erp.presupuesto.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.presupuesto.da.DBRepositorioReal;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;
import framework.request.bl.XML.IDataSet;

public class RepositorioReal extends ObjetoLogico { 

  public RepositorioReal() { 
  }

  public static String NICKNAME = "pl.RepositorioReal";

  private String codigo;
  private String descripcion;
  private Boolean activo;
  private GrupoRepositorioReal grupoRepositorioReal; 
  
  private List definiciones = new ArrayList();
  private boolean readDefiniciones = true;
  

  public String getCodigo() throws BaseException { 
    supportRefresh();
    return codigo;
  }

  public void setGrupoRepositorioReal(GrupoRepositorioReal aGrupoRepositorio) { 
    this.grupoRepositorioReal =  aGrupoRepositorio;
  }
  
  public GrupoRepositorioReal getGrupoRepositorioReal() throws BaseException { 
    supportRefresh();
    return this.grupoRepositorioReal;
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

 public static RepositorioReal findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (RepositorioReal) getObjectByOid(NICKNAME,oid,aSesion);
  }
 
 public static RepositorioReal findByOidProxy(Integer oid , ISesion aSesion) throws BaseException { 
   return (RepositorioReal) getObjectByOidProxy(NICKNAME,oid,aSesion);
  } 
 

 public static RepositorioReal findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (RepositorioReal) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(codigo, "Debe ingresar el Código");
    Validar.noNulo(descripcion, "Debe ingresar la Descripción");
    Validar.noNulo(this.grupoRepositorioReal, "Debe ingresar el Grupo");
 }
 
 public List getDefinicionesRepoReal() throws BaseException {
   if (this.readDefiniciones) {
     List listaDefiniciones = DefinicionRepositorioReal.getDefinicionesRepoReal(this,getSesion());
     definiciones.addAll(listaDefiniciones);
     readDefiniciones = false;
   }
   return definiciones;
 }

 public void addDefinicionRepoReal(DefinicionRepositorioReal aDefiRepoReal) throws BaseException {
	 aDefiRepoReal.setRepositorio_real(this);
   definiciones.add(aDefiRepoReal);
 }

 public void afterSave() throws BaseException {
   Iterator iterDefiniciones = definiciones.iterator();
   while (iterDefiniciones.hasNext()) {
     DefinicionRepositorioReal defRepoReal = (DefinicionRepositorioReal) iterDefiniciones.next();
     defRepoReal.save();
     defRepoReal = null;
   }
   iterDefiniciones = null;
 }
 
 public static List getRepositoriosByGrupo(GrupoRepositorioReal aGrupoRepoReal,
     ISesion aSesion) throws BaseException {
 	return DBRepositorioReal.getRepositoriosByGrupo(aGrupoRepoReal,aSesion);
 } 
 
 public List getValoresRealesRepositorio(ISesion aSesion) throws BaseException {
	return ValorRealRepositorio.getValoresRealesRepositorio(this,this.getSesion());
 }
 
 public List getValoresRealesByFiltrosVarios(IDataSet dsTipoPeriodo,
		 																				 IDataSet dsFiltrosCompo,
		 																				 IDataSet dsValCompoReal1,
		 																				 IDataSet dsValCompoReal2,
		 																				 IDataSet dsValCompoReal3,
		 																				 IDataSet dsValCompoReal4,
		 																				 IDataSet dsValCompoReal5) throws BaseException {
	 
	return ValorRealRepositorio.getValoresRealesByFiltrosVarios(this,
			                                                        dsTipoPeriodo,
			                                                        dsFiltrosCompo,
			                                                        dsValCompoReal1,
			                                                        dsValCompoReal2,
			                                                        dsValCompoReal3,
			                                                        dsValCompoReal4,
			                                                        dsValCompoReal5,
			                                                        this.getSesion());
 }
 
 

}
