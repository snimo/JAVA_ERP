package com.srn.erp.excluidos.bm;

import java.util.List;

import com.srn.erp.excluidos.da.DBPredioExcluido;
import com.srn.erp.general.bm.Moneda;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Parametros.ValorParametro;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class PredioExcluido extends ObjetoLogico { 

  public PredioExcluido() { 
  }

  public static String NICKNAME = "exc.PredioExcluido";

  private String codigo;
  private String descripcion;
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

 public static PredioExcluido findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (PredioExcluido) getObjectByOid(NICKNAME,oid,aSesion);
  } 
 
 public static PredioExcluido findByOidProxy(Integer oid , ISesion aSesion) throws BaseException { 
	   return (PredioExcluido) getObjectByOidProxy(NICKNAME,oid,aSesion);
	  } 

 public static PredioExcluido findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (PredioExcluido) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(codigo, "Debe ingresar el Código");
    Validar.noNulo(descripcion, "Debe ingresar la Descripción");
 }
 
 public static List getAllActivos(ISesion aSesion) throws BaseException {
	  return DBPredioExcluido.getAllActivos(aSesion);
 }
 
public static PredioExcluido getPredioDefaultExcluido(ISesion aSesion)
	throws BaseException {
		Integer oidMoneda = ValorParametro.findByCodigoParametro(
				"PREDIO_EXC_DEFAULT", aSesion).getOidObjNeg();
		PredioExcluido predio = PredioExcluido.findByOid(oidMoneda, aSesion);
		return predio;
}
 

}
