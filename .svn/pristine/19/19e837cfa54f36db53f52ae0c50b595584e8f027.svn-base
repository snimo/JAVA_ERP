package com.srn.erp.reclutamiento.bm;

import java.util.List;

import com.srn.erp.reclutamiento.da.DBRecluProcDefEnBusq;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class RecluProcDefEnBusq extends ObjetoLogico { 

  public RecluProcDefEnBusq() { 
  }

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

public static String NICKNAME = "rs.RecluProcDefEnBusq";

  private RecluBusqueda busqueda;
  private Integer orden;
  private RecluProceso proceso;
  private java.util.Date fecha_asigno;
  private Boolean activo;
  private RecluConceptoProceso conceptoProceso;
  private RecluTipoFormuProceso tipoFormulario;

  public RecluBusqueda getBusqueda() throws BaseException { 
    supportRefresh();
    return busqueda;
  }
  
  public RecluTipoFormuProceso getTipoFormulario() throws BaseException { 
	    supportRefresh();
	    return this.tipoFormulario;
	  }  
  
  public RecluConceptoProceso getConceptoProceso() throws BaseException { 
	    supportRefresh();
	    return this.conceptoProceso;
  }  

  public void setBusqueda(RecluBusqueda aBusqueda) { 
    this.busqueda =  aBusqueda;
  }
  
  public void setTipoFormulario(RecluTipoFormuProceso aRecluTipoFormuProceso) { 
	    this.tipoFormulario =  aRecluTipoFormuProceso;
	  }  
  
  public void setConceptoProceso(RecluConceptoProceso aRecluConceptoProceso) { 
	    this.conceptoProceso =  aRecluConceptoProceso;	 
  }  

  public Integer getOrden() throws BaseException { 
    supportRefresh();
    return orden;
  }

  public void setOrden(Integer aOrden) { 
    this.orden =  aOrden;
  }

  public RecluProceso getProceso() throws BaseException { 
    supportRefresh();
    return proceso;
  }

  public void setProceso(RecluProceso aProceso) { 
    this.proceso =  aProceso;
  }

  public java.util.Date getFecha_asigno() throws BaseException { 
    supportRefresh();
    return fecha_asigno;
  }

  public void setFecha_asigno(java.util.Date aFecha_asigno) { 
    this.fecha_asigno =  aFecha_asigno;
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

 public static RecluProcDefEnBusq findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (RecluProcDefEnBusq) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static RecluProcDefEnBusq findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (RecluProcDefEnBusq) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(busqueda, "Debe ingresar la Búsqueda");
    Validar.noNulo(orden, "Debe ingresar el Orden");
    Validar.noNulo(proceso, "Debe ingresar el Proceso");
    Validar.noNulo(fecha_asigno, "Debe ingresar la Fecha");
 }
 
 public static List getProcesosDefEnBusqueda(RecluBusqueda aRecluBusqueda,
         ISesion aSesion) throws BaseException {
	  return DBRecluProcDefEnBusq.getProcesosDefEnBusqueda(aRecluBusqueda,aSesion);
 }
 
 

}
