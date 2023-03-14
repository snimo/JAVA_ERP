package com.srn.erp.presupuesto.bm;

import java.util.List;

import com.srn.erp.presupuesto.da.DBUPCNodoEstructura;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class UPCNodoEstructura extends ObjetoLogico { 

  public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public UPCNodoEstructura() { 
  }

  public static String NICKNAME = "pl.UPCNodoEstructura";

  private Integer orden;
  private NodoEstructuraPlanificacion nodo_estructura;
  private UPC upc;
  private Boolean activo;

  public Integer getOrden() throws BaseException { 
    supportRefresh();
    return orden;
  }

  public void setOrden(Integer aOrden) { 
    this.orden =  aOrden;
  }

  public NodoEstructuraPlanificacion getNodo_estructura() throws BaseException { 
    supportRefresh();
    return nodo_estructura;
  }

  public void setNodo_estructura(NodoEstructuraPlanificacion aNodo_estructura) { 
    this.nodo_estructura =  aNodo_estructura;
  }

  public UPC getUpc() throws BaseException { 
    supportRefresh();
    return upc;
  }

  public void setUpc(UPC aUpc) { 
    this.upc =  aUpc;
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

 public static UPCNodoEstructura findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (UPCNodoEstructura) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static UPCNodoEstructura findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (UPCNodoEstructura) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(orden, "Debe ingresar el Nro. de Orden");
    Validar.noNulo(nodo_estructura, "Debe ingresar el Nodo");
    Validar.noNulo(upc, "Debe ingresar la UPC");
 }
 
 public static List getUPCsByNodo(NodoEstructuraPlanificacion nodo,
     ISesion aSesion) throws BaseException {
 	return DBUPCNodoEstructura.getUPCsByNodo(nodo,aSesion);
 }
  

}
