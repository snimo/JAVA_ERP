package com.srn.erp.cubo.bm;

import com.srn.erp.general.bm.ClasificadorEntidad;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.Validar;
import framework.xlook.bm.Select;

public class DimensionCubo extends ObjetoLogico {
	
	
  public static final String TIPO_SELECT = "SELECT";
  public static final String TIPO_OPER = "OPERACION";
  public static final String TIPO_CLASIF = "CLASIFICADOR";
	

  public DimensionCubo() { 
  }

  public static String NICKNAME = "cu.DimensionCubo";

  private String codigo;
  private String descripcion;
  private String tipo_dimension;
  private Select select;
  private String nombre_oper;
  private ClasificadorEntidad clasificador_entidad;
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

  public String getTipo_dimension() throws BaseException { 
    supportRefresh();
    return tipo_dimension;
  }

  public void setTipo_dimension(String aTipo_dimension) { 
    this.tipo_dimension =  aTipo_dimension;
  }

  public Select getSelect() throws BaseException { 
    supportRefresh();
    return select;
  }

  public void setSelect(Select aSelect) { 
    this.select =  aSelect;
  }

  public String getNombre_oper() throws BaseException { 
    supportRefresh();
    return nombre_oper;
  }

  public void setNombre_oper(String aNombre_oper) { 
    this.nombre_oper =  aNombre_oper;
  }

  public ClasificadorEntidad getClasificador_entidad() throws BaseException { 
    supportRefresh();
    return clasificador_entidad;
  }

  public void setClasificador_entidad(ClasificadorEntidad aClasificador_entidad) { 
    this.clasificador_entidad =  aClasificador_entidad;
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

 public static DimensionCubo findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (DimensionCubo) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static DimensionCubo findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (DimensionCubo) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(codigo, "Debe ingresar el Código");
    Validar.noNulo(descripcion, "Debe ingresar la Descripción");
    Validar.noNulo(tipo_dimension, "Debe ingresar el Tipo Dimensión");
    
    
    if (getTipo_dimension().equals(DimensionCubo.TIPO_CLASIF))
    	Validar.noNulo(clasificador_entidad,"Debe ingresar un clasificador");
    
    if (getTipo_dimension().equals(DimensionCubo.TIPO_OPER))
    	Validar.noNulo(nombre_oper,"Debe ingresar una Operación");
    
    if (getTipo_dimension().equals(DimensionCubo.TIPO_SELECT))
    	Validar.noNulo(select,"Debe ingresar una sentencia SELECT ");    
    	
 }
 
 public static HashTableDatos getTipos() throws BaseException {
	 HashTableDatos condiciones = new HashTableDatos();
	 condiciones.put(TIPO_SELECT,"Select");
	 condiciones.put(TIPO_OPER,"Operación");
	 condiciones.put(TIPO_CLASIF,"Clasificado");
	 
	 return condiciones;
 }
 

}
