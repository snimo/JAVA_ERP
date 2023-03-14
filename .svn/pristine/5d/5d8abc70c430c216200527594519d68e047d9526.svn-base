package com.srn.erp.presupuesto.bm;

import java.util.List;

import com.srn.erp.presupuesto.da.DBGrupoTipoUPCDet;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class GrupoTipoUPCDet extends ObjetoLogico { 

  public GrupoTipoUPCDet() { 
  }
  
  

  public static String NICKNAME = "pl.GrupoTipoUPCDet";

  private GrupoTipoUPC grupo_tipo_upc;
  private TipoUPC tipo_upc;
  private Boolean activo;

  public GrupoTipoUPC getGrupo_tipo_upc() throws BaseException { 
    supportRefresh();
    return grupo_tipo_upc;
  }

  public void setGrupo_tipo_upc(GrupoTipoUPC aGrupo_tipo_upc) { 
    this.grupo_tipo_upc =  aGrupo_tipo_upc;
  }

  public TipoUPC getTipo_upc() throws BaseException { 
    supportRefresh();
    return tipo_upc;
  }

  public void setTipo_upc(TipoUPC aTipo_upc) { 
    this.tipo_upc =  aTipo_upc;
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

 public static GrupoTipoUPCDet findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (GrupoTipoUPCDet) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static GrupoTipoUPCDet findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (GrupoTipoUPCDet) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(grupo_tipo_upc, "Debe ingresar el tipo de UPC");
    Validar.noNulo(tipo_upc, "Debe ingresar el tipo de UPC");
 }

 public String getCodigo() throws BaseException {
	// TODO Auto-generated method stub
	return null;
 }

 public String getDescripcion() throws BaseException {
	// TODO Auto-generated method stub
	return null;
 }
 
 public static List getDetallesByGrupoTipoUPC(GrupoTipoUPC grupo,
     ISesion aSesion) throws BaseException {
 	return DBGrupoTipoUPCDet.getDetallesByGrupoTipoUPC(grupo,aSesion);
 }
 
 public static GrupoTipoUPCDet getGrupoTipoUPCDet(GrupoTipoUPC grupo,TipoUPC tipo,
     ISesion aSesion)
     throws BaseException {
 	return DBGrupoTipoUPCDet.getGrupoTipoUPCDet(grupo,tipo,aSesion);
 }
 
 
 
 

}
