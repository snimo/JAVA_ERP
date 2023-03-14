package com.srn.erp.compras.bm;

import java.util.List;

import com.srn.erp.compras.da.DBRolAutorizadorOC;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class RolAutorizadorOC extends ObjetoLogico { 

  public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean isActivo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

public RolAutorizadorOC() { 
  }

  public static String NICKNAME = "cp.RolAutorizadorOC";

  private AutorizacionMontoCompra autorizacion_monto;
  private RolAutorizadorCompras rol_autorizador;
  private String tipo_autoriz;
  private SectorCompra sector_emisor;

  public AutorizacionMontoCompra getAutorizacion_monto() throws BaseException { 
    supportRefresh();
    return autorizacion_monto;
  }

  public void setAutorizacion_monto(AutorizacionMontoCompra aAutorizacion_monto) { 
    this.autorizacion_monto =  aAutorizacion_monto;
  }

  public RolAutorizadorCompras getRol_autorizador() throws BaseException { 
    supportRefresh();
    return rol_autorizador;
  }

  public void setRol_autorizador(RolAutorizadorCompras aRol_autorizador) { 
    this.rol_autorizador =  aRol_autorizador;
  }

  public String getTipo_autoriz() throws BaseException { 
    supportRefresh();
    return tipo_autoriz;
  }

  public void setTipo_autoriz(String aTipo_autoriz) { 
    this.tipo_autoriz =  aTipo_autoriz;
  }

  public SectorCompra getSector_emisor() throws BaseException { 
    supportRefresh();
    return sector_emisor;
  }

  public void setSector_emisor(SectorCompra aSector_emisor) { 
    this.sector_emisor =  aSector_emisor;
  }

  public String getNickName() { 
    return NICKNAME; 
  } 

 public static RolAutorizadorOC findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (RolAutorizadorOC) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static RolAutorizadorOC findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (RolAutorizadorOC) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(autorizacion_monto, "Debe ingresar la autorización");
    Validar.noNulo(rol_autorizador, "Debe ingresar el rol autorizador de Compras");
    Validar.noNulo(tipo_autoriz, "Debe ingresar el tipo de Autorización");
 }
 
 public static List getRolesAutorizacionCompras(AutorizacionMontoCompra autorizacionMontoCompra,
         ISesion aSesion) throws BaseException {
	  return DBRolAutorizadorOC.getRolesAutorizacionCompras(autorizacionMontoCompra,aSesion);
 }
 
 public static List getRolesAutorizacionCompras(AutorizacionMontoCompra autorizacionMontoCompra,
			SectorCompra sectorEmisor, ISesion aSesion) throws BaseException {
		return DBRolAutorizadorOC.getRolesAutorizacionCompras(autorizacionMontoCompra,sectorEmisor,aSesion);
	} 
 
}
