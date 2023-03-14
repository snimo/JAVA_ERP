package com.srn.erp.reclutamiento.bm;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;

public class RecluResultBusqCandi extends ObjetoLogico { 

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

public RecluResultBusqCandi() { 
  }

  public static String NICKNAME = "rs.RecluResultBusqCandi";

  private Integer nro_lote;
  private Integer oid_obj_neg;
  private java.util.Date fec_alta;
  private Boolean activo;
  private Integer nroOrden;

  public Integer getNro_lote() throws BaseException { 
    supportRefresh();
    return nro_lote;
  }
  
  public Integer getNro_Orden() throws BaseException { 
	    supportRefresh();
	    return this.nroOrden;
	  }  

  public void setNro_lote(Integer aNro_lote) { 
    this.nro_lote =  aNro_lote;
  }
  
  public void setNro_Orden(Integer aNro_Orden) { 
	    this.nroOrden =  aNro_Orden;
	  }  

  public Integer getOid_obj_neg() throws BaseException { 
    supportRefresh();
    return oid_obj_neg;
  }

  public void setOid_obj_neg(Integer aOid_obj_neg) { 
    this.oid_obj_neg =  aOid_obj_neg;
  }

  public java.util.Date getFec_alta() throws BaseException { 
    supportRefresh();
    return fec_alta;
  }

  public void setFec_alta(java.util.Date aFec_alta) { 
    this.fec_alta =  aFec_alta;
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

 public static RecluResultBusqCandi findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (RecluResultBusqCandi) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static RecluResultBusqCandi findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (RecluResultBusqCandi) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
 }

}
