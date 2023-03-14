package com.srn.erp.presupuesto.bm;

import java.util.List;

import com.srn.erp.presupuesto.da.DBDiccionarioPlanificacion;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class DiccionarioPlanificacion extends ObjetoLogico { 

  public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public DiccionarioPlanificacion() { 
  }

  public static String NICKNAME = "pl.DiccionarioPlanificacion";

  private Integer nro_relacion;
  private Integer nro_relacion_padre;
  private String tipo_item;
  private String titulo;
  private AtributoDiccionario atributo_diccionario;
  private Integer orden;
  private Boolean activo;

  public Integer getNro_relacion() throws BaseException { 
    supportRefresh();
    return nro_relacion;
  }

  public void setNro_relacion(Integer aNro_relacion) { 
    this.nro_relacion =  aNro_relacion;
  }

  public Integer getNro_relacion_padre() throws BaseException { 
    supportRefresh();
    return nro_relacion_padre;
  }

  public void setNro_relacion_padre(Integer aNro_relacion_padre) { 
    this.nro_relacion_padre =  aNro_relacion_padre;
  }

  public String getTipo_item() throws BaseException { 
    supportRefresh();
    return tipo_item;
  }

  public void setTipo_item(String aTipo_item) { 
    this.tipo_item =  aTipo_item;
  }

  public String getTitulo() throws BaseException { 
    supportRefresh();
    return titulo;
  }

  public void setTitulo(String aTitulo) { 
    this.titulo =  aTitulo;
  }

  public AtributoDiccionario getAtributo_diccionario() throws BaseException { 
    supportRefresh();
    return atributo_diccionario;
  }

  public void setAtributo_diccionario(AtributoDiccionario aAtributo_diccionario) { 
    this.atributo_diccionario =  aAtributo_diccionario;
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

 public static DiccionarioPlanificacion findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (DiccionarioPlanificacion) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static DiccionarioPlanificacion findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (DiccionarioPlanificacion) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(tipo_item, "Debe ingresar el tipo de Item");
 }
 
 
 public static List getAllActivos(
     ISesion aSesion) throws BaseException {
	 return DBDiccionarioPlanificacion.getAllActivos(aSesion);
 }
 
 

}
