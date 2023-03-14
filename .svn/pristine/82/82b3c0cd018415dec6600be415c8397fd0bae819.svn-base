package com.srn.erp.ventas.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.ventas.da.DBDefEstrucLPDet;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class DefEstrucLPCab extends ObjetoLogico { 

  public DefEstrucLPCab() { 
  }

  public static String NICKNAME = "ve.DefEstrucLPCab";

  private String codigo;
  private String descripcion;
  private Boolean activo;
  
  private List listaDefEstrucLP = new ArrayList();
  private boolean readlistaDefEstrucLP = true;
  

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

 public static DefEstrucLPCab findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (DefEstrucLPCab) getObjectByOid(NICKNAME,oid,aSesion);
  }
 
 public static DefEstrucLPCab findByOidProxy(Integer oid , ISesion aSesion) throws BaseException { 
   return (DefEstrucLPCab) getObjectByOidProxy(NICKNAME,oid,aSesion);
  } 
 

 public static DefEstrucLPCab findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (DefEstrucLPCab) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(codigo, "Debe ingresar el Código");
    Validar.noNulo(descripcion, "Debe ingresar la Descripción");
 }
 
 public List getDefEstrucLPDet() throws BaseException {
   if (this.readlistaDefEstrucLP) {
     List templistaDefEstrucLP = DefEstrucLPDet.getDefEstrucLP(this,getSesion());
     this.listaDefEstrucLP.addAll(templistaDefEstrucLP);
     this.readlistaDefEstrucLP = false;
   }
   return listaDefEstrucLP;
 }

 public void addDefEstrucLPDet(DefEstrucLPDet aDefEstrucLPDet) throws BaseException {
	 aDefEstrucLPDet.setDef_estruc_lp(this);
   this.listaDefEstrucLP.add(aDefEstrucLPDet);
 }

 public void afterSave() throws BaseException {
   Iterator iterDefEstrucLPDet = this.listaDefEstrucLP.iterator();
   while (iterDefEstrucLPDet.hasNext()) {
  	 DefEstrucLPDet defEstrucLPDet = (DefEstrucLPDet) iterDefEstrucLPDet.next();
  	 defEstrucLPDet.save();
  	 defEstrucLPDet = null;
   }
   iterDefEstrucLPDet = null;
 }
 
 public DefEstrucLPDet getDefEstrucLPDet(ValorClasificadorEntidad valClasifEnt1,
		 																		 ValorClasificadorEntidad valClasifEnt2,
		 																		 ISesion aSesion)
 throws BaseException {
	 return DBDefEstrucLPDet.getDefEstrucLPDet(this,valClasifEnt1,valClasifEnt2,aSesion);
 } 
 
 

}
