package com.srn.erp.cubo.bm;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.Validar;
import framework.xlook.bm.Select;

public class FactTableCubo extends ObjetoLogico { 

  public FactTableCubo() { 
  }
  
  public static final String TIPO_SELECT = "SELECT";
  public static final String TIPO_OPER = "OPERACION";

  public static String NICKNAME = "cu.FactTableCubo";

  private String codigo;
  private String descripcion;
  private Select select;
  private String tipo_fact_table;
  private String nombre_oper;
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

  public Select getSelect() throws BaseException { 
    supportRefresh();
    return select;
  }

  public void setSelect(Select aSelect) { 
    this.select =  aSelect;
  }

  public String getTipo_fact_table() throws BaseException { 
    supportRefresh();
    return tipo_fact_table;
  }

  public void setTipo_fact_table(String aTipo_fact_table) { 
    this.tipo_fact_table =  aTipo_fact_table;
  }

  public String getNombre_oper() throws BaseException { 
    supportRefresh();
    return nombre_oper;
  }

  public void setNombre_oper(String aNombre_oper) { 
    this.nombre_oper =  aNombre_oper;
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

 public static FactTableCubo findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (FactTableCubo) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static FactTableCubo findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (FactTableCubo) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(codigo, "Debe ingresar el Código");
    Validar.noNulo(descripcion, "Debe ingresar la Descripción");
    Validar.noNulo(tipo_fact_table, "Debe ingresar el Tipo de Tabla");
    
    if (getTipo_fact_table().equals(FactTableCubo.TIPO_OPER))
    	Validar.noNulo(nombre_oper,"Debe ingresar una operación");
    
    if (getTipo_fact_table().equals(FactTableCubo.TIPO_SELECT))
    	Validar.noNulo(select,"Debe ingresar una Select");    
    	
    
 }
 
 public static HashTableDatos getTipos() throws BaseException {
	 HashTableDatos condiciones = new HashTableDatos();
	 condiciones.put(TIPO_SELECT,"Select");
	 condiciones.put(TIPO_OPER,"Operación");
	 return condiciones;
 }

}
