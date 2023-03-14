package com.srn.erp.estadisticaRaciones.bm;

import java.util.List;

import com.srn.erp.estadisticaRaciones.da.DBEmpresaRaciones;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;

public class EmpresaRaciones extends ObjetoLogico { 

  public EmpresaRaciones() { 
  }

  public static String NICKNAME = "est.EmpresaRaciones";

  private Integer oid;
  private String codigo;
  private String descripcion;
  private Boolean activo;

  public Integer getOid() throws BaseException { 
    supportRefresh();
    return oid;
  }

  public void setOid(Integer aOid) { 
    this.oid =  aOid;
  }

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

 public static EmpresaRaciones findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (EmpresaRaciones) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static EmpresaRaciones findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (EmpresaRaciones) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
 }
 
 public static List getEmpresas(
         ISesion aSesion) throws BaseException {
	  return DBEmpresaRaciones.getEmpresas(aSesion);
 }  

}
