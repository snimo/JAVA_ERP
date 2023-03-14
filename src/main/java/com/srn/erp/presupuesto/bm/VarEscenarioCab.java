package com.srn.erp.presupuesto.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class VarEscenarioCab extends ObjetoLogico { 

  public VarEscenarioCab() { 
  }

  public static String NICKNAME = "pl.VarEscenarioCab";

  private String codigo;
  private String descripcion;
  private TipoPeriodo tipo_periodo;
  private Boolean activo;
  
  private List variablesEscenarioDet = new ArrayList();
  private boolean readVarEscenarioDet = true;
  

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

    public TipoPeriodo getTipo_periodo() throws BaseException { 
    supportRefresh();
    return tipo_periodo;
  }

  public void setTipo_periodo(TipoPeriodo aTipo_periodo) { 
    this.tipo_periodo =  aTipo_periodo;
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

 public static VarEscenarioCab findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (VarEscenarioCab) getObjectByOid(NICKNAME,oid,aSesion);
  }
 
 public static VarEscenarioCab findByOidProxy(Integer oid , ISesion aSesion) throws BaseException { 
   return (VarEscenarioCab) getObjectByOidProxy(NICKNAME,oid,aSesion);
  } 
 

 public static VarEscenarioCab findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (VarEscenarioCab) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(codigo, "Debe ingresar el Código");
    Validar.noNulo(descripcion, "Debe ingresar la Descripción");
 }
 
 public List getVariablesEscenarioDet() throws BaseException {
   if (this.readVarEscenarioDet) {
     List listaVariablesEscenarioDet = VarEscenarioDet.getVariablesEscenarioDet(this,getSesion());
     variablesEscenarioDet.addAll(listaVariablesEscenarioDet);
     this.readVarEscenarioDet = false;
   }
   return variablesEscenarioDet;
 }
 
 public List getVariablesEscenarioDetOrderByNroInt() throws BaseException {
   if (this.readVarEscenarioDet) {
     List listaVariablesEscenarioDet = VarEscenarioDet.getVariablesEscenarioDetOrderByNroInt(this,getSesion());
     variablesEscenarioDet.addAll(listaVariablesEscenarioDet);
     this.readVarEscenarioDet = false;
   }
   return variablesEscenarioDet;
 }
 

 public void addVariableEscenarioDet(VarEscenarioDet aVarEscenarioDet) throws BaseException {
	 aVarEscenarioDet.setVar_escenario_cab(this);
   variablesEscenarioDet.add(aVarEscenarioDet);
 }

 public void afterSave() throws BaseException {
   Iterator iterVarEsceDet = variablesEscenarioDet.iterator();
   while (iterVarEsceDet.hasNext()) {
     VarEscenarioDet varEsceDet = (VarEscenarioDet) iterVarEsceDet.next();
     varEsceDet.save();
     varEsceDet = null;
   }
   iterVarEsceDet = null;
 }
 
 public boolean tienePeriodos() throws BaseException {
	 if (this.getTipo_periodo()==null)
		 return false;
	 else
		 return true;
 }
 

}
