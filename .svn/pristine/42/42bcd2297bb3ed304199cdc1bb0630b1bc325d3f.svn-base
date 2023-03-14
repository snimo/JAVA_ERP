package com.srn.erp.cip.bm;

import java.util.List;

import com.srn.erp.cip.da.DBCategAccValClasif;
import com.srn.erp.general.bm.ValorClasificadorEntidad;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class CategAccValClasif extends ObjetoLogico { 

  public CategAccValClasif() { 
  }

  public static String NICKNAME = "cip.CategAccValClasif";

  public String getCodigo() throws BaseException {
	// TODO Auto-generated method stub
	return null;
}

public String getDescripcion() throws BaseException {
	// TODO Auto-generated method stub
	return null;
}

private CategAccesoCIP categoria;
  private Boolean activo;
  private ValorClasificadorEntidad val_clasif_ent;

  public CategAccesoCIP getCategoria() throws BaseException { 
    supportRefresh();
    return categoria;
  }

  public void setCategoria(CategAccesoCIP aCategoria) { 
    this.categoria =  aCategoria;
  }

  public Boolean isActivo() throws BaseException { 
    supportRefresh();
    return activo;
  }

  public void setActivo(Boolean aActivo) { 
    this.activo =  aActivo;
  }

  public ValorClasificadorEntidad getVal_clasif_ent() throws BaseException { 
    supportRefresh();
    return val_clasif_ent;
  }

  public void setVal_clasif_ent(ValorClasificadorEntidad aVal_clasif_ent) { 
    this.val_clasif_ent =  aVal_clasif_ent;
  }

  public String getNickName() { 
    return NICKNAME; 
  } 

 public static CategAccValClasif findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (CategAccValClasif) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static CategAccValClasif findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (CategAccValClasif) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(categoria, "Debe ingresar la Categoría");
    Validar.noNulo(val_clasif_ent, "Debe ingresar el Valor del Clasificador");
 }
 
 public static List getCategAccPorValClasif(ValorClasificadorEntidad valor,
         ISesion aSesion) throws BaseException {
	  return DBCategAccValClasif.getCategoriasAcceso(valor, aSesion);
 }
 
 public static CategAccValClasif getCategAccPorValClasif(
		  ValorClasificadorEntidad valor,
		  CategAccesoCIP categoria,
         ISesion aSesion) throws BaseException {
	  return DBCategAccValClasif.getCategAccValClasif(categoria,valor,aSesion);
 }
 
 public static List getCategoriasAccesoActivas(
         ISesion aSesion) throws BaseException {
	  return DBCategAccValClasif.getCategoriasAccesoActivas(aSesion);
 }
 
 
 

}
