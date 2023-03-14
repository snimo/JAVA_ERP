package com.srn.erp.presupuesto.bm;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.presupuesto.da.DBCicloPresupuestal;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class CicloPresupuestal extends ObjetoLogico { 

  public CicloPresupuestal() { 
  }

  public static String NICKNAME = "pl.CicloPresupuestal";

  private String codigo;
  private String descripcion;
  private String observacion;
  private Integer nro_orden_visual;
  private Boolean activo;
  private TipoCiclo tipo_ciclo;
  private Date fechaInicioPlanif;
  
  public String getCodigo() throws BaseException { 
    supportRefresh();
    return codigo;
  }

  public void setCodigo(String aCodigo) { 
    this.codigo =  aCodigo;
  }
  
  public Date getFechaInicioPlanif() throws BaseException { 
    supportRefresh();
    return this.fechaInicioPlanif;
  }

  public void setFechaInicioPlanif(Date aFechaInicioPlanif) { 
    this.fechaInicioPlanif =  aFechaInicioPlanif;
  }
  

  public String getDescripcion() throws BaseException { 
    supportRefresh();
    return descripcion;
  }

  public void setDescripcion(String aDescripcion) { 
    this.descripcion =  aDescripcion;
  }

  public String getObservacion() throws BaseException { 
    supportRefresh();
    return observacion;
  }

  public void setObservacion(String aObservacion) { 
    this.observacion =  aObservacion;
  }

  public Integer getNro_orden_visual() throws BaseException { 
    supportRefresh();
    return nro_orden_visual;
  }

  public void setNro_orden_visual(Integer aNro_orden_visual) { 
    this.nro_orden_visual =  aNro_orden_visual;
  }

  public Boolean isActivo() throws BaseException { 
    supportRefresh();
    return activo;
  }

  public void setActivo(Boolean aActivo) { 
    this.activo =  aActivo;
  }

  public TipoCiclo getTipo_ciclo() throws BaseException { 
    supportRefresh();
    return tipo_ciclo;
  }

  public void setTipo_ciclo(TipoCiclo aTipo_ciclo) { 
    this.tipo_ciclo =  aTipo_ciclo;
  }

  public String getNickName() { 
    return NICKNAME; 
  } 

 public static CicloPresupuestal findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (CicloPresupuestal) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static CicloPresupuestal findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (CicloPresupuestal) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(codigo, "Debe ingresar el Código");
    Validar.noNulo(descripcion, "Debe ingresar la Descripción");
    Validar.noNulo(tipo_ciclo, "Debe ingresar el Tipo de Ciclo");
    Validar.noNulo(this.fechaInicioPlanif, "Debe ingresar la fecha de inicio de la Planificación");
 }
 
 public static List getCiclosActivosOrdenadasParaPresentar(ISesion aSesion) throws BaseException {
   return DBCicloPresupuestal.getCiclosActivosOrdenadasParaPresentar(aSesion);
 	
 }
 
 public boolean mostrarUPC(UPC upc) throws BaseException {
	 
	 Iterator iterTiposUPCHab = upc.getTiposUPCHabilitados().iterator();
	 while (iterTiposUPCHab.hasNext()) {
		 TipoHabilitadoUPC tipoHabUPC = (TipoHabilitadoUPC) iterTiposUPCHab.next();
		 TipoUPC tipoUPC = tipoHabUPC.getTipoupc();
		 
		 if (this.getTipo_ciclo().istTipoUPCAsociado(tipoUPC))
			 return true;
	 }
	 
	 return false;
 }
 

}
