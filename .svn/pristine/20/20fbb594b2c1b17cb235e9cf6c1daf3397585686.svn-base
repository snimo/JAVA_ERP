package com.srn.erp.presupuesto.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.presupuesto.da.DBGrupoTipoUPC;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class GrupoTipoUPC extends ObjetoLogico { 

  public GrupoTipoUPC() { 
  }
  
  private List detalles = new ArrayList();
  private boolean readDetalles = true;
    
  public static String NICKNAME = "pl.GrupoTipoUPC";

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

 public static GrupoTipoUPC findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (GrupoTipoUPC) getObjectByOid(NICKNAME,oid,aSesion);
  }
 
 public static GrupoTipoUPC findByOidProxy(Integer oid , ISesion aSesion) throws BaseException { 
   return (GrupoTipoUPC) getObjectByOidProxy(NICKNAME,oid,aSesion);
  } 
 

 public static GrupoTipoUPC findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (GrupoTipoUPC) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(codigo, "Debe ingresar el Código");
    Validar.noNulo(descripcion, "Debe ingresar la Descripción");
 }
 
 public List getDetalles() throws BaseException {
   if (this.readDetalles) {
     List listaDetalles = GrupoTipoUPCDet.getDetallesByGrupoTipoUPC(this,getSesion());
     detalles.addAll(listaDetalles);
     readDetalles = false;
   }
   return detalles;
 }

 public void addDetalle(GrupoTipoUPCDet grupoTipoUPCDet) throws BaseException {
	 grupoTipoUPCDet.setGrupo_tipo_upc(this);
	 detalles.add(grupoTipoUPCDet);
 }

 public void afterSave() throws BaseException {
   Iterator iterDetalles = detalles.iterator();
   while (iterDetalles.hasNext()) {
  	 GrupoTipoUPCDet detalle = (GrupoTipoUPCDet) iterDetalles.next();
  	 detalle.save();
  	 detalle = null;
   }
   iterDetalles = null;
 }
 
 public GrupoTipoUPCDet getGrupoTipoUPCDet(TipoUPC tipo) throws BaseException {
	 return GrupoTipoUPCDet.getGrupoTipoUPCDet(this,tipo,this.getSesion());
 }
 
 public static List getAllGruposTipoUPC(ISesion aSesion) throws BaseException {
 	return DBGrupoTipoUPC.getAllGruposTipoUPC(aSesion);
 }
 
 

}
