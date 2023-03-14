package com.srn.erp.reclutamiento.bm;

import java.util.List;

import com.srn.erp.reclutamiento.da.DBRecluWarnEstBusqCandi;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class RecluWarnEstBusqCandi extends ObjetoLogico { 

  @Override
	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

public RecluWarnEstBusqCandi() { 
  }

  public static String NICKNAME = "rs.RecluWarnEstBusqCandi";

  private RecluEstCandidatoBusq estado_busqueda;
  private RecluEstadoProceso estado_proceso;
  private Boolean activo;

  public RecluEstCandidatoBusq getEstado_busqueda() throws BaseException { 
    supportRefresh();
    return estado_busqueda;
  }

  public void setEstado_busqueda(RecluEstCandidatoBusq aEstado_busqueda) { 
    this.estado_busqueda =  aEstado_busqueda;
  }

  public RecluEstadoProceso getEstado_proceso() throws BaseException { 
    supportRefresh();
    return estado_proceso;
  }

  public void setEstado_proceso(RecluEstadoProceso aEstado_proceso) { 
    this.estado_proceso =  aEstado_proceso;
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

 public static RecluWarnEstBusqCandi findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (RecluWarnEstBusqCandi) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static RecluWarnEstBusqCandi findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (RecluWarnEstBusqCandi) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(estado_busqueda, "Debe ingresar el Estado de Búsqueda");
    Validar.noNulo(estado_proceso, "Debe ingresar el Estado del Proceso");
 }
 
 public static List getWarnEstBusqCandi(RecluEstCandidatoBusq estadoBusqCandi,
         ISesion aSesion) throws BaseException {
	  return DBRecluWarnEstBusqCandi.getWarnEstBusqCandi(estadoBusqCandi,aSesion);
 } 

}
