package com.srn.erp.presupuesto.bm;

import java.util.List;

import com.srn.erp.presupuesto.da.DBTipoUPC;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class TipoUPC extends ObjetoLogico { 

  public TipoUPC() { 
  }

  public static String NICKNAME = "pl.TipoUPC";

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

 public static TipoUPC findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (TipoUPC) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static TipoUPC findByOidProxy(Integer oid , ISesion aSesion) throws BaseException { 
   return (TipoUPC) getObjectByOidProxy(NICKNAME,oid,aSesion);
  } 
 
 public static TipoUPC findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (TipoUPC) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(codigo, "Debe ingresar el código");
    Validar.noNulo(descripcion, "Debe ingresar la descripción");
 }
 
 public static List getAllActivos(ISesion aSesion) throws BaseException {
 	return DBTipoUPC.getAllActivos(aSesion);
 }
 
 public boolean isActivadaForUPC(UPC upc) throws BaseException {
	 TipoHabilitadoUPC tipoHabUPC = TipoHabilitadoUPC.getTipoHabilitadoUPC(upc,this,this.getSesion());
	 if (tipoHabUPC!=null)
		 return true;
	 else
		 return false;
 }
 

}
