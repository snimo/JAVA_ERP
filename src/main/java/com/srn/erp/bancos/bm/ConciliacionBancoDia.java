package com.srn.erp.bancos.bm;

import java.util.List;

import com.srn.erp.bancos.da.DBConciliacionBancoDia;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class ConciliacionBancoDia extends ObjetoLogico { 

  public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

public ConciliacionBancoDia() { 
  }

  public static String NICKNAME = "ba.ConciliacionBancoDia";

  private ConciliacionCab conciliacion;
  private ComproConciliacionBcoDia compro_conciliacion_dia;
  private Boolean activo;

  public ConciliacionCab getConciliacion() throws BaseException { 
    supportRefresh();
    return conciliacion;
  }

  public void setConciliacion(ConciliacionCab aConciliacion) { 
    this.conciliacion =  aConciliacion;
  }

  public ComproConciliacionBcoDia getCompro_conciliacion_dia() throws BaseException { 
    supportRefresh();
    return compro_conciliacion_dia;
  }

  public void setCompro_conciliacion_dia(ComproConciliacionBcoDia aCompro_conciliacion_dia) { 
    this.compro_conciliacion_dia =  aCompro_conciliacion_dia;
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

 public static ConciliacionBancoDia findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (ConciliacionBancoDia) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static ConciliacionBancoDia findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (ConciliacionBancoDia) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(conciliacion, "Debe ingresar la conciliación");
    Validar.noNulo(compro_conciliacion_dia, "Debe ingresar el Comprobante de Conciliación");
 }
 
 public static List getConciliacionesBcoDia(ConciliacionCab conciliacion,
         ISesion aSesion) throws BaseException {
	  return DBConciliacionBancoDia.getConciliacionesBcoDia(conciliacion,aSesion);
 }
 

}
