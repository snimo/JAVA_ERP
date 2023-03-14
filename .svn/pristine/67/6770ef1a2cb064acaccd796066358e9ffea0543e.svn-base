package com.srn.erp.presupuesto.bm;

import java.util.List;

import com.srn.erp.presupuesto.da.DBGrupoUPCTipoCiclo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class GrupoUPCTipoCiclo extends ObjetoLogico { 

  public GrupoUPCTipoCiclo() { 
  }

  public static String NICKNAME = "pl.GrupoUPCTipoCiclo";

  private TipoCiclo tipo_ciclo;
  private GrupoTipoUPC grupo_tipo_upc;
  private Boolean activo;

  public TipoCiclo getTipo_ciclo() throws BaseException { 
    supportRefresh();
    return tipo_ciclo;
  }

  public void setTipo_ciclo(TipoCiclo aTipo_ciclo) { 
    this.tipo_ciclo =  aTipo_ciclo;
  }

  public GrupoTipoUPC getGrupo_tipo_upc() throws BaseException { 
    supportRefresh();
    return grupo_tipo_upc;
  }

  public void setGrupo_tipo_upc(GrupoTipoUPC aGrupo_tipo_upc) { 
    this.grupo_tipo_upc =  aGrupo_tipo_upc;
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

 public static GrupoUPCTipoCiclo findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (GrupoUPCTipoCiclo) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static GrupoUPCTipoCiclo findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (GrupoUPCTipoCiclo) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(tipo_ciclo, "Debe ingresar el tipo de Ciclo");
    Validar.noNulo(grupo_tipo_upc, "Debe ingresar un Grupo");
 }

 public String getCodigo() throws BaseException {
	// TODO Auto-generated method stub
	return null;
 }

 public String getDescripcion() throws BaseException {
	// TODO Auto-generated method stub
	return null;
 }
 
 public static List getGruposUPCByTipoCiclo(TipoCiclo aTipoCiclo,
     ISesion aSesion) throws BaseException {
 	return DBGrupoUPCTipoCiclo.getGruposUPCByTipoCiclo(aTipoCiclo,aSesion);
 }
 
 public static GrupoUPCTipoCiclo getGrupoUPCTipoCiclo(TipoCiclo tipoCiclo,
		 GrupoTipoUPC grupoTipoUPC,
		 ISesion aSesion) throws BaseException {
  return DBGrupoUPCTipoCiclo.getGrupoUPCTipoCiclo(tipoCiclo,grupoTipoUPC,aSesion);
 } 
 
 

}
