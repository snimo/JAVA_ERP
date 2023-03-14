package com.srn.erp.general.bm;

import java.util.List;

import com.srn.erp.general.da.DBEtiquetaIdioma;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;
import framework.request.bl.Utils.Validar;

public class EtiquetaIdioma extends ObjetoLogico { 

  public EtiquetaIdioma() { 
  }

  public static String NICKNAME = "ge.EtiquetaIdioma";

  private String nickname;
  private String etiqueta;
  private Boolean activo;
  private String descripcion;

  public String getNickname() throws BaseException { 
    supportRefresh();
    return nickname;
  }

  public void setNickname(String aNickname) { 
    this.nickname =  aNickname;
  }
  
  public void setDescripcion(String aDescripcion) { 
    this.descripcion =  aDescripcion;
  }
  

  public String getEtiqueta() throws BaseException { 
    supportRefresh();
    return etiqueta;
  }

  public void setEtiqueta(String aEtiqueta) { 
    this.etiqueta =  aEtiqueta;
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

 public static EtiquetaIdioma findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (EtiquetaIdioma) getObjectByOid(NICKNAME,oid,aSesion);
  }
 
 public static EtiquetaIdioma findByOidProxy(Integer oid , ISesion aSesion) throws BaseException { 
   return (EtiquetaIdioma) getObjectByOidProxy(NICKNAME,oid,aSesion);
  } 
 

 public static EtiquetaIdioma findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (EtiquetaIdioma) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public String getCodigo() throws BaseException {
	// TODO Auto-generated method stub
	return null;
}

 public String getDescripcion() throws BaseException {
	// TODO Auto-generated method stub
	return this.descripcion;
 }

 public void beforeSave() throws BaseException { 
    Validar.noNulo(nickname, "Debe ingresar el NickName");
    Validar.noNulo(etiqueta, "Debe ingresar la Etiqueta");
 }
 
 public static List getEtiquetasComprobante(String nickname,
     ISesion aSesion) throws BaseException {
 	return DBEtiquetaIdioma.getEtiquetasComprobante(nickname,aSesion);
 }
 
 public static EtiquetaIdioma getEtiquetaIdioma(String aNickName,
		 String aLabel,			
		 ISesion aSesion)
 throws BaseException {
	 return DBEtiquetaIdioma.getEtiquetaIdioma(aNickName,aLabel,aSesion);
 }
 
 public ValorEtiquetaIdioma getValorEtiqueta(Idioma aIdioma) throws BaseException {
	 return ValorEtiquetaIdioma.getValorEtiquetaIdioma(this,aIdioma,this.getSesion());
 }
 
 

}
