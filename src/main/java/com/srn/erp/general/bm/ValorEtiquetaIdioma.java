package com.srn.erp.general.bm;

import com.srn.erp.general.da.DBValorEtiquetaIdioma;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;
import framework.request.bl.Utils.Validar;

public class ValorEtiquetaIdioma extends ObjetoLogico { 

  public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public ValorEtiquetaIdioma() { 
  }

  public static String NICKNAME = "ge.ValorEtiquetaIdioma";

  private EtiquetaIdioma etiqueta_idioma;
  private String descripcion;
  private Idioma idioma;
  private Boolean activo;

  public EtiquetaIdioma getEtiqueta_idioma() throws BaseException { 
    supportRefresh();
    return etiqueta_idioma;
  }

  public void setEtiqueta_idioma(EtiquetaIdioma aEtiqueta_idioma) { 
    this.etiqueta_idioma =  aEtiqueta_idioma;
  }

  public String getDescripcion() throws BaseException { 
    supportRefresh();
    return descripcion;
  }

  public void setDescripcion(String aDescripcion) { 
    this.descripcion =  aDescripcion;
  }

  public Idioma getIdioma() throws BaseException { 
    supportRefresh();
    return idioma;
  }

  public void setIdioma(Idioma aIdioma) { 
    this.idioma =  aIdioma;
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

 public static ValorEtiquetaIdioma findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (ValorEtiquetaIdioma) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static ValorEtiquetaIdioma findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (ValorEtiquetaIdioma) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(etiqueta_idioma, "Debe ingresar la etiqueta");
    Validar.noNulo(idioma, "Debe ingresar el Idioma");
 }
 
 public static ValorEtiquetaIdioma getValorEtiquetaIdioma(EtiquetaIdioma etiquetaIdioma,
     Idioma idioma,
     ISesion aSesion) throws BaseException {
 	return DBValorEtiquetaIdioma.getValorEtiquetaIdioma(etiquetaIdioma,idioma,aSesion);
 }
 

}
