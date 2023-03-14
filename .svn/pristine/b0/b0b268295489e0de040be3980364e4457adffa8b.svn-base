package com.srn.erp.cashflow.bm;

import java.util.Iterator;
import java.util.List;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class ProgFechasCF extends ObjetoLogico { 

  public ProgFechasCF() { 
  }

  public static String NICKNAME = "cf.ProgFechasCF";

  private String codigo;
  private String descripcion;
  private java.util.Date fec_desde;
  private java.util.Date fec_hasta;
  private Boolean activo;
  private EscenarioCashFlow escenario;

  public String getCodigo() throws BaseException { 
    supportRefresh();
    return codigo;
  }

  public void setCodigo(String aCodigo) { 
    this.codigo =  aCodigo;
  }

  @Override
public void afterSaveNew() throws BaseException {
	// TODO Auto-generated method stub
	super.afterSaveNew();
	
	
	ProgramadorCashFlow programadorCF =
		new ProgramadorCashFlow(this.getSesion());
	programadorCF.setProgFechasCF(this);
	List concAProgramar = programadorCF.getConceptosAProgramar();
	
	Iterator iterConcAProg = concAProgramar.iterator(); 
	while (iterConcAProg.hasNext())  {
		VistaCashFlow vistaCF = (VistaCashFlow) iterConcAProg.next();
		vistaCF.save();
	}
	
}

public String getDescripcion() throws BaseException { 
    supportRefresh();
    return descripcion;
  }

  public void setDescripcion(String aDescripcion) { 
    this.descripcion =  aDescripcion;
  }

  public java.util.Date getFec_desde() throws BaseException { 
    supportRefresh();
    return fec_desde;
  }

  public void setFec_desde(java.util.Date aFec_desde) { 
    this.fec_desde =  aFec_desde;
  }

  public java.util.Date getFec_hasta() throws BaseException { 
    supportRefresh();
    return fec_hasta;
  }

  public void setFec_hasta(java.util.Date aFec_hasta) { 
    this.fec_hasta =  aFec_hasta;
  }

  public Boolean isActivo() throws BaseException { 
    supportRefresh();
    return activo;
  }

  public void setActivo(Boolean aActivo) { 
    this.activo =  aActivo;
  }

  public EscenarioCashFlow getEscenario() throws BaseException { 
    supportRefresh();
    return escenario;
  }

  public void setEscenario(EscenarioCashFlow aEscenario) { 
    this.escenario =  aEscenario;
  }

  public String getNickName() { 
    return NICKNAME; 
  } 

 public static ProgFechasCF findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (ProgFechasCF) getObjectByOid(NICKNAME,oid,aSesion);
  }
 
 public static ProgFechasCF findByOidProxy(Integer oid , ISesion aSesion) throws BaseException { 
	   return (ProgFechasCF) getObjectByOidProxy(NICKNAME,oid,aSesion);
	  } 
 

 public static ProgFechasCF findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (ProgFechasCF) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(codigo, "Debe ingresar el Código");
    Validar.noNulo(descripcion, "Debe ingresar la Descripción");
    Validar.noNulo(fec_desde, "Debe ingresar la Fecha Desde");
    Validar.noNulo(fec_hasta, "Debe ingresar la Fecha Hasta");
    Validar.noNulo(escenario, "Debe ingresar el Escenario");
 }

}
