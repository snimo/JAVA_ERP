package com.srn.erp.presupuesto.bm;

import java.util.List;

import com.srn.erp.presupuesto.da.DBValorCompoReal;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class ValorCompoReal extends ObjetoLogico { 

  public ValorCompoReal() { 
  }

  public static String NICKNAME = "pl.ValorCompoReal";

  private String codigo;
  private String descripcion;
  private CompoPresupuestario compo_presu;
  private Boolean activo;
  private ValorCompoPresu valorCompoPresu;

  public String getCodigo() throws BaseException { 
    supportRefresh();
    return codigo;
  }

  public void setCodigo(String aCodigo) { 
    this.codigo =  aCodigo;
  }
  
  public ValorCompoPresu getValorCompoPresu() throws BaseException { 
    supportRefresh();
    return this.valorCompoPresu;
  }

  public void setValorCompoPresu(ValorCompoPresu aValorCompoPresu) { 
    this.valorCompoPresu =  aValorCompoPresu;
  }
  

  public String getDescripcion() throws BaseException { 
    supportRefresh();
    return descripcion;
  }

  public void setDescripcion(String aDescripcion) { 
    this.descripcion =  aDescripcion;
  }

  public CompoPresupuestario getCompo_presu() throws BaseException { 
    supportRefresh();
    return compo_presu;
  }

  public void setCompo_presu(CompoPresupuestario aCompo_presu) { 
    this.compo_presu =  aCompo_presu;
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

 public static ValorCompoReal findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (ValorCompoReal) getObjectByOid(NICKNAME,oid,aSesion);
  }
 
 public static ValorCompoReal findByOidProxy(Integer oid , ISesion aSesion) throws BaseException { 
   return (ValorCompoReal) getObjectByOidProxy(NICKNAME,oid,aSesion);
  } 
 

 public static ValorCompoReal findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (ValorCompoReal) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(codigo, "Debe ingresar el Código");
    Validar.noNulo(descripcion, "Debe ingresar la Descripción");
    Validar.noNulo(compo_presu, "Componente Presupuestario");
 }
 
 public static List getValoresRealesByCompoPresu(CompoPresupuestario compoPresu,
		                                             ISesion aSesion) throws BaseException {
 	return DBValorCompoReal.getValoresComponentesRealesByCompoPresu(compoPresu,aSesion);
 }
 
 public static List getValoresRealesByCompoPresuCodDesc(CompoPresupuestario compoPresu,
		 																										String codigo,
		 																										String descripcion,
     ISesion aSesion) throws BaseException {
	 return DBValorCompoReal.getValoresComponentesRealesByCompoPresuCodDesc(
			 compoPresu,
			 codigo,
			 descripcion,
			 aSesion);
 }
 
 public static ValorCompoReal getValorRealByCodigo(CompoPresupuestario compoPresu,
		 String codigo,
		 ISesion aSesion)
  throws BaseException {
	 	 return DBValorCompoReal.getPeriodoValorRealByCodigo(compoPresu,codigo,aSesion);
 }
 
 
}
