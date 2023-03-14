package com.srn.erp.presupuesto.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.presupuesto.da.DBCompoPresupuestario;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class CompoPresupuestario extends ObjetoLogico { 

	// El componente estandar se utiliza para la creacion de componentes	
	public static String TIPO_COMPO_ESTANDAR = "ESTANDAR";
	public static String TIPO_COMPO_PERIODO = "PERIODO";
	public static String TIPO_COMPO_PRODUCTO = "PRODUCTO";
	public static String TIPO_COMPO_CUENTA = "CUENTA";
	
	private List defAtributos = new ArrayList();
  private boolean readDefAtributos = true;
	
	
	
  public CompoPresupuestario() { 
  }

  public static String NICKNAME = "pl.CompoPresupuestario";

  private String codigo;
  private String descripcion;
  private String tipo;
  private Integer nro_interno_compo;
  private GrupoComponente grupo_compo;
  private Boolean activo;

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

  public Integer getNro_interno_compo() throws BaseException { 
    supportRefresh();
    return nro_interno_compo;
  }

  public void setNro_interno_compo(Integer aNro_interno_compo) { 
    this.nro_interno_compo =  aNro_interno_compo;
  }

  public GrupoComponente getGrupo_compo() throws BaseException { 
    supportRefresh();
    return grupo_compo;
  }

  public void setGrupo_compo(GrupoComponente aGrupo_compo) { 
    this.grupo_compo =  aGrupo_compo;
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

 public static CompoPresupuestario findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (CompoPresupuestario) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static CompoPresupuestario findByOidProxy(Integer oid , ISesion aSesion) throws BaseException { 
   return (CompoPresupuestario) getObjectByOidProxy(NICKNAME,oid,aSesion);
  } 
 
 
 public static CompoPresupuestario findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (CompoPresupuestario) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(codigo, "Debe ingresar el código");
    Validar.noNulo(descripcion, "Debe ingresar la Descripción");
    Validar.noNulo(grupo_compo, "Debe ingresar el Grupo");
 }
 
 public List getDefAtributos() throws BaseException {
   if (this.readDefAtributos) {
     List listaDefAtributos = AtriCompoPresu.getAtriCompoPresu(this,getSesion());
     this.defAtributos.addAll(listaDefAtributos);
     this.readDefAtributos = false;
   }
   return defAtributos;
 }

 public void addAtriCompoPresu(AtriCompoPresu atriCompoPresu) throws BaseException {
	 atriCompoPresu.setCompo_presu(this);
   defAtributos.add(atriCompoPresu);
 }

 public void afterSave() throws BaseException {
   Iterator iterAtriCompoPresu = this.defAtributos.iterator();
   while (iterAtriCompoPresu.hasNext()) {
     AtriCompoPresu atriCompoPresu = (AtriCompoPresu) iterAtriCompoPresu.next();
     atriCompoPresu.save();
     atriCompoPresu = null;
   }
   iterAtriCompoPresu = null;
 }
 
 public static List getComponentesByGrupo(GrupoComponente grupoComponente,
     ISesion aSesion) throws BaseException {
 	return DBCompoPresupuestario.getComponentesByGrupo(grupoComponente,aSesion);
 }
 
 public ValorCompoPresu getValorByCodigo(String codigo) throws BaseException {
	 return ValorCompoPresu.getValorBycodigo(this,codigo,this.getSesion());
 }
 
 public ValorCompoReal getValorRealbyCodigo(String codigo) throws BaseException {
	 return ValorCompoReal.getValorRealByCodigo(this,codigo,this.getSesion());
 }
 
 public List getValores() throws BaseException {
	 return ValorCompoPresu.getValoresCompoPresu(this,this.getSesion());
 }
 
 public List getValores(List listaValoresCompoPresu) throws BaseException {
	 return ValorCompoPresu.getValoresCompoPresu(this,listaValoresCompoPresu,this.getSesion());
 }
 
 
 public static String getNombreFisicoCampoOID() {
	 return DBCompoPresupuestario.OID_COMPO_PRESU;
 }
 
 
 
 public static String getTableName() {
	 return "plCompoPresu";
 }
 
 
}
