package com.srn.erp.presupuesto.bm;

import java.util.List;

import com.srn.erp.presupuesto.da.DBTipoHabilitadoUPC;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class TipoHabilitadoUPC extends ObjetoLogico { 

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

	public TipoHabilitadoUPC() { 
  }

  public static String NICKNAME = "pl.TipoHabilitadoUPC";

  private UPC UPC;
  private TipoUPC tipoUPC;
  private Boolean habilitado;

  public UPC getUpc() throws BaseException { 
    supportRefresh();
    return UPC;
  }

  public void setUpc(UPC aUpc) { 
    this.UPC =  aUpc;
  }

  public TipoUPC getTipoupc() throws BaseException { 
    supportRefresh();
    return tipoUPC;
  }

  public void setTipoupc(TipoUPC aTipoupc) { 
    this.tipoUPC =  aTipoupc;
  }

  public Boolean isHabilitado() throws BaseException { 
    supportRefresh();
    return habilitado;
  }

  public void setHabilitado(Boolean aHabilitado) { 
    this.habilitado =  aHabilitado;
  }

  public String getNickName() { 
    return NICKNAME; 
  } 

 public static TipoHabilitadoUPC findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (TipoHabilitadoUPC) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static TipoHabilitadoUPC findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (TipoHabilitadoUPC) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(UPC, "Debe ingresar la Unidad de Presentación");
    Validar.noNulo(tipoUPC, "Debe ingresar el Tipo de UPC");
 }
 
 public static List getTiposHabilitadosUPC(UPC upc,
     ISesion aSesion) throws BaseException {
 	return DBTipoHabilitadoUPC.getTiposHabilitadosUPC(upc,aSesion);
 }
 
 public static TipoHabilitadoUPC getTipoHabilitadoUPC(UPC upc,TipoUPC tipoUPC,
     ISesion aSesion)
     throws BaseException {
 	return DBTipoHabilitadoUPC.getTipoHabilitadoUPC(upc,tipoUPC,aSesion);
 }
 
  

}
