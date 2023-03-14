package com.srn.erp.presupuesto.bm;

import java.util.List;

import com.srn.erp.presupuesto.da.DBDefinicionRepositorioReal;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class DefinicionRepositorioReal extends ObjetoLogico { 

  public DefinicionRepositorioReal() { 
  }
  
  public static final String TIPO_COMPO = "COMPONENTE";
  public static final String TIPO_PERI = "TIPO_PERIODO";
  public static final String TIPO_METRICA = "METRICA";

  public static String NICKNAME = "pl.DefinicionRepositorioReal";

  private String descripcion;
  private RepositorioReal repositorio_real;
  private CompoPresupuestario compo_presupuestario;
  private TipoPeriodo tipo_periodo;
  private Metrica metrica;
  private Integer orden;
  private String tipo;
  private Boolean activo;
  private boolean obligatorio;

  public String getDescripcion() throws BaseException { 
    supportRefresh();
    return descripcion;
  }

  public void setDescripcion(String aDescripcion) { 
    this.descripcion =  aDescripcion;
  }
  
  public boolean isObligatorio() throws BaseException { 
    supportRefresh();
    return this.obligatorio;
  }

  public void setObligatorio(boolean aObligatorio) { 
    this.obligatorio =  aObligatorio;
  }
  

  public RepositorioReal getRepositorio_real() throws BaseException { 
    supportRefresh();
    return repositorio_real;
  }

  public void setRepositorio_real(RepositorioReal aRepositorio_real) { 
    this.repositorio_real =  aRepositorio_real;
  }

  public CompoPresupuestario getCompo_presupuestario() throws BaseException { 
    supportRefresh();
    return compo_presupuestario;
  }

  public void setCompo_presupuestario(CompoPresupuestario aCompo_presupuestario) { 
    this.compo_presupuestario =  aCompo_presupuestario;
  }

  public TipoPeriodo getTipo_periodo() throws BaseException { 
    supportRefresh();
    return tipo_periodo;
  }

  public void setTipo_periodo(TipoPeriodo aTipo_periodo) { 
    this.tipo_periodo =  aTipo_periodo;
  }

  public Metrica getMetrica() throws BaseException { 
    supportRefresh();
    return metrica;
  }

  public void setMetrica(Metrica aMetrica) { 
    this.metrica =  aMetrica;
  }

  public Integer getOrden() throws BaseException { 
    supportRefresh();
    return orden;
  }

  public void setOrden(Integer aOrden) { 
    this.orden =  aOrden;
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

  public void setActivo(Boolean aActivo) { 
    this.activo =  aActivo;
  }

  public String getNickName() { 
    return NICKNAME; 
  } 

 public static DefinicionRepositorioReal findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (DefinicionRepositorioReal) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static DefinicionRepositorioReal findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (DefinicionRepositorioReal) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(descripcion, "Debe ingresar la Descripción");
    Validar.noNulo(repositorio_real, "Debe ingresar el Repositorio");
    Validar.noNulo(orden, "Debe ingresar el Nro. de Orden");
    Validar.noNulo(tipo, "Debe ingresar el Tipo");
 }

 public String getCodigo() throws BaseException {
	// TODO Auto-generated method stub
	return null;
 }
 
 public static List getDefinicionesRepoReal(RepositorioReal repoReal,
     ISesion aSesion) throws BaseException {
 	return DBDefinicionRepositorioReal.getDefinicionesRepoReal(repoReal,aSesion);
 }
 
 public boolean isComponente() throws BaseException {
	 return this.getTipo().equals(TIPO_COMPO);
 }
 
 public boolean isMetrica() throws BaseException {
	 return this.getTipo().equals(TIPO_METRICA);
 }
 
 public boolean isTipoPeriodo() throws BaseException {
	 return this.getTipo().equals(TIPO_PERI);
 }
 
 
 

}
