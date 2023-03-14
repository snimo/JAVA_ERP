package com.srn.erp.presupuesto.bm;

import java.util.List;

import com.srn.erp.presupuesto.da.DBPeriodoPresupuestario;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class PeriodoPresupuestario extends ObjetoLogico { 

  public PeriodoPresupuestario() { 
  }

  public static String NICKNAME = "pl.PeriodoPresupuestario";

  private String codigo;
  private String descripcion;
  private Boolean activo;
  private TipoPeriodo tipo_periodo;
  private java.util.Date fec_desde;
  private java.util.Date fec_hasta;

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

  public TipoPeriodo getTipo_periodo() throws BaseException { 
    supportRefresh();
    return tipo_periodo;
  }

  public void setTipo_periodo(TipoPeriodo aTipo_periodo) { 
    this.tipo_periodo =  aTipo_periodo;
  }

  public java.util.Date getFec_desde() throws BaseException { 
    supportRefresh();
    return fec_desde;
  }

  public void setFec_desde(java.util.Date aFec_desde) { 
    this.fec_desde =  aFec_desde;
  }

  public java.util.Date getFec_hasta() throws BaseException { 
    supportRefresh();
    return fec_hasta;
  }

  public void setFec_hasta(java.util.Date aFec_hasta) { 
    this.fec_hasta =  aFec_hasta;
  }

  public String getNickName() { 
    return NICKNAME; 
  } 

 public static PeriodoPresupuestario findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (PeriodoPresupuestario) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static PeriodoPresupuestario findByOidProxy(Integer oid , ISesion aSesion) throws BaseException { 
   return (PeriodoPresupuestario) getObjectByOidProxy(NICKNAME,oid,aSesion);
  } 
 
 
 public static PeriodoPresupuestario findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (PeriodoPresupuestario) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(codigo, "Debe ingresar el código");
    Validar.noNulo(descripcion, "Debe ingresar la Descripción");
    Validar.noNulo(tipo_periodo, "Debe ingresar el tipo de Período");
    Validar.noNulo(fec_desde, "Debe ingresar la fecha desde");
    Validar.noNulo(fec_hasta, "Debe ingresar la fecha hasta");
 }
 
 public static List getPeriodosPresupuestados(TipoPeriodo tipoPeriodo,
 		java.util.Date fechaDesde,java.util.Date fechaHasta,
 		ISesion aSesion) throws BaseException {
 	return DBPeriodoPresupuestario.getPeriodosPresupuestados(tipoPeriodo,fechaDesde,fechaHasta,aSesion);
 }
 
 public static PeriodoPresupuestario getPeriodoPresupuestario(TipoPeriodo tipoPeriodo,
 		String codigo,
     ISesion aSesion)
     throws BaseException {
 	return DBPeriodoPresupuestario.getPeriodoPresupuestario(tipoPeriodo,codigo,aSesion);
 }
 
 public static PeriodoPresupuestario getPeriodoPresupuestario(TipoPeriodo tipoPeriodo,
 		java.util.Date fecha,
     ISesion aSesion)
     throws BaseException {
 	return DBPeriodoPresupuestario.getPeriodoPresupuestario(tipoPeriodo,fecha,aSesion);
 }
 
 
 

}
