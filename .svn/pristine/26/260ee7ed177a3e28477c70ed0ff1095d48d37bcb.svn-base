package com.srn.erp.ventas.bm;

import java.sql.Date;
import java.util.List;

import com.srn.erp.general.bm.PeriodoIncDet;
import com.srn.erp.ventas.da.DBLogImpresoraFiscal;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;

public class LogImpresoraFiscal extends ObjetoLogico { 

  public Boolean isActivo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public LogImpresoraFiscal() { 
  }

  public static String NICKNAME = "ve.LogImpresoraFiscal";

  private Integer oid_cco;
  private Integer nro_impresion;
  private java.util.Date fecha;
  private String hora;
  private Integer oid_usuario;
  private String linea;
  private Integer nro_error;
  private Integer oid_sucursal;

  public Integer getOid_cco() throws BaseException { 
    supportRefresh();
    return oid_cco;
  }

  public void setOid_cco(Integer aOid_cco) { 
    this.oid_cco =  aOid_cco;
  }

  public Integer getNro_impresion() throws BaseException { 
    supportRefresh();
    return nro_impresion;
  }

  public void setNro_impresion(Integer aNro_impresion) { 
    this.nro_impresion =  aNro_impresion;
  }

  public java.util.Date getFecha() throws BaseException { 
    supportRefresh();
    return fecha;
  }

  public void setFecha(java.util.Date aFecha) { 
    this.fecha =  aFecha;
  }

  public String getHora() throws BaseException { 
    supportRefresh();
    return hora;
  }

  public void setHora(String aHora) { 
    this.hora =  aHora;
  }

  public Integer getOid_usuario() throws BaseException { 
    supportRefresh();
    return oid_usuario;
  }

  public void setOid_usuario(Integer aOid_usuario) { 
    this.oid_usuario =  aOid_usuario;
  }

  public String getLinea() throws BaseException { 
    supportRefresh();
    return linea;
  }

  public void setLinea(String aLinea) { 
    this.linea =  aLinea;
  }

  public Integer getNro_error() throws BaseException { 
    supportRefresh();
    return nro_error;
  }

  public void setNro_error(Integer aNro_error) { 
    this.nro_error =  aNro_error;
  }

  public Integer getOid_sucursal() throws BaseException { 
    supportRefresh();
    return oid_sucursal;
  }

  public void setOid_sucursal(Integer aOid_sucursal) { 
    this.oid_sucursal =  aOid_sucursal;
  }

  public String getNickName() { 
    return NICKNAME; 
  } 

 public static LogImpresoraFiscal findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (LogImpresoraFiscal) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static LogImpresoraFiscal findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (LogImpresoraFiscal) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
 }
 
 public static List getLogsByFecha(java.util.Date fechaDesde,java.util.Date fechaHasta,
     ISesion aSesion) throws BaseException {
 	return DBLogImpresoraFiscal.getLogsByFecha(fechaDesde,fechaHasta,aSesion);
 }
 

}
