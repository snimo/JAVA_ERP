package com.srn.erp.ventas.bm;

import java.util.List;

import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.ventas.da.DBDefEstrucLPDet;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;
import framework.request.bl.Utils.Validar;

public class DefEstrucLPDet extends ObjetoLogico { 

  public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public DefEstrucLPDet() { 
  }

  public static String NICKNAME = "ve.DefEstrucLPDet";

  private DefEstrucLPCab def_estruc_lp;
  private ValorClasificadorEntidad valor_clasif_art_1;
  private ValorClasificadorEntidad valor_clasif_art_2;
  private Integer orden;
  private Boolean activo;

  public DefEstrucLPCab getDef_estruc_lp() throws BaseException { 
    supportRefresh();
    return def_estruc_lp;
  }

  public void setDef_estruc_lp(DefEstrucLPCab aDef_estruc_lp) { 
    this.def_estruc_lp =  aDef_estruc_lp;
  }

  public ValorClasificadorEntidad getValor_clasif_art_1() throws BaseException { 
    supportRefresh();
    return valor_clasif_art_1;
  }

  public void setValor_clasif_art_1(ValorClasificadorEntidad aValor_clasif_art_1) { 
    this.valor_clasif_art_1 =  aValor_clasif_art_1;
  }

  public ValorClasificadorEntidad getValor_clasif_art_2() throws BaseException { 
    supportRefresh();
    return valor_clasif_art_2;
  }

  public void setValor_clasif_art_2(ValorClasificadorEntidad aValor_clasif_art_2) { 
    this.valor_clasif_art_2 =  aValor_clasif_art_2;
  }

  public Integer getOrden() throws BaseException { 
    supportRefresh();
    return orden;
  }

  public void setOrden(Integer aOrden) { 
    this.orden =  aOrden;
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

 public static DefEstrucLPDet findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (DefEstrucLPDet) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static DefEstrucLPDet findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (DefEstrucLPDet) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(def_estruc_lp, "Debe ingresar la Estructura de la LP");
    Validar.noNulo(orden, "Debe ingresar el Nro. de Orden");
 }
 
 public static List getDefEstrucLP(DefEstrucLPCab defEstrucLPCab,
     ISesion aSesion) throws BaseException {
 	return DBDefEstrucLPDet.getDefEstrucLP(defEstrucLPCab,aSesion);
 }
 
 public static List getListaDefEstrucLPNotInListaPrecios(ListaPrecios listaPrecios,
		 																										 DefEstrucLPCab defEstrucLPCab,
     ISesion aSesion) throws BaseException {
 	return DBDefEstrucLPDet.getListaDefEstrucLPNotInListaPrecios(listaPrecios,defEstrucLPCab,aSesion);
 }
 
 public static DefEstrucLPDet getDefEstrucLPDet(DefEstrucLPCab defEstrucLPCab,
		 ValorClasificadorEntidad valClasifEnt1,
		 ValorClasificadorEntidad valClasifEnt2,
		 ISesion aSesion)
 throws BaseException {
	 return DBDefEstrucLPDet.getDefEstrucLPDet(defEstrucLPCab,valClasifEnt1,valClasifEnt2,aSesion);
 } 
  
  

}
