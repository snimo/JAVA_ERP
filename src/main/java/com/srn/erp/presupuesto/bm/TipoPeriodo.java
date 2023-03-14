package com.srn.erp.presupuesto.bm;

import java.util.Date;
import java.util.List;

import com.srn.erp.presupuesto.da.DBTipoPeriodo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class TipoPeriodo extends ObjetoLogico { 

  public TipoPeriodo() { 
  }

  public static String NICKNAME = "pl.TipoPeriodo";

  private String codigo;
  private String descripcion;
  private Boolean activo;
  private Integer nroInterno;

  public String getCodigo() throws BaseException { 
    supportRefresh();
    return codigo;
  }

  public void setCodigo(String aCodigo) { 
    this.codigo =  aCodigo;
  }
  
  public Integer getNroInterno() throws BaseException { 
    supportRefresh();
    return this.nroInterno;
  }

  public void setNroInterno(Integer aNroInterno) { 
    this.nroInterno =  aNroInterno;
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

 public static TipoPeriodo findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (TipoPeriodo) getObjectByOid(NICKNAME,oid,aSesion);
  }
 
 public static TipoPeriodo findByOidProxy(Integer oid , ISesion aSesion) throws BaseException { 
   return (TipoPeriodo) getObjectByOidProxy(NICKNAME,oid,aSesion);
  } 
 

 public static TipoPeriodo findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (TipoPeriodo) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(codigo, "Debe ingresar el Código");
 }
 
 public static List getAllTiposPediodos(ISesion aSesion) throws BaseException {
 	return DBTipoPeriodo.getAllTiposPediodos(aSesion);
 }
 
 public List getPeriodos(Date fechaDesde,Date fechaHasta) throws BaseException {
	 return PeriodoPresupuestario.getPeriodosPresupuestados(this,fechaDesde,fechaHasta,this.getSesion());
 }
 
 public static TipoPeriodo getTipoPeriodo(Integer aNroInterno,
			ISesion aSesion)
	throws BaseException {
	return DBTipoPeriodo.getTipoPeriodo(aNroInterno,aSesion);
 }
 
 public PeriodoPresupuestario getPeriodo(Date fecha) throws BaseException {
	 return PeriodoPresupuestario.getPeriodoPresupuestario(this,fecha,this.getSesion());
 }
 
 
 
 

}
