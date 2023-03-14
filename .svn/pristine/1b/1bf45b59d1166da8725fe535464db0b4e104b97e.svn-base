package com.srn.erp.impuestos.bm;

import java.util.List;

import com.srn.erp.impuestos.da.DBLiberacionImpuestoSujeto;
import com.srn.erp.ventas.bm.Sujeto;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Varios.Porcentaje;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.Validar;

public class LiberacionImpuestoSujeto extends ObjetoLogico { 

  public LiberacionImpuestoSujeto() { 
  }

  public static String NICKNAME = "im.LiberacionImpuestoSujeto";

  private Sujeto sujeto;
  private java.util.Date fec_vig_desde;
  private java.util.Date fec_vig_hasta;
  private Porcentaje porc_lib;
  private Porcentaje nuevo_porc;
  private String tipo_impuesto;
  private Boolean activo;

  public Sujeto getSujeto() throws BaseException { 
    supportRefresh();
    return sujeto;
  }

  public void setSujeto(Sujeto aSujeto) { 
    this.sujeto =  aSujeto;
  }

  public java.util.Date getFec_vig_desde() throws BaseException { 
    supportRefresh();
    return fec_vig_desde;
  }

  public void setFec_vig_desde(java.util.Date aFec_vig_desde) { 
    this.fec_vig_desde =  aFec_vig_desde;
  }

  public java.util.Date getFec_vig_hasta() throws BaseException { 
    supportRefresh();
    return fec_vig_hasta;
  }

  public void setFec_vig_hasta(java.util.Date aFec_vig_hasta) { 
    this.fec_vig_hasta =  aFec_vig_hasta;
  }

  public Porcentaje getPorc_lib() throws BaseException { 
    supportRefresh();
    return porc_lib;
  }

  public void setPorc_lib(Porcentaje aPorc_lib) { 
    this.porc_lib =  aPorc_lib;
  }

  public Porcentaje getNuevo_porc() throws BaseException { 
    supportRefresh();
    return nuevo_porc;
  }

  public void setNuevo_porc(Porcentaje aNuevo_porc) { 
    this.nuevo_porc =  aNuevo_porc;
  }

  public String getTipo_impuesto() throws BaseException { 
    supportRefresh();
    return tipo_impuesto;
  }

  public void setTipo_impuesto(String aTipo_impuesto) { 
    this.tipo_impuesto =  aTipo_impuesto;
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

 public static LiberacionImpuestoSujeto findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (LiberacionImpuestoSujeto) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public String getCodigo() throws BaseException {
	// TODO Auto-generated method stub
	return null;
}

public String getDescripcion() throws BaseException {
	// TODO Auto-generated method stub
	return null;
}

public static LiberacionImpuestoSujeto findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (LiberacionImpuestoSujeto) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(sujeto, "Debe ingresar el Sujeto");
    Validar.noNulo(fec_vig_desde, "Debe ingresar la fecha desde");
    Validar.noNulo(fec_vig_hasta, "Debe ingresar la fecha hasta");
    Validar.noNulo(tipo_impuesto, "Debe ingresar el Tipo de Impuesto");
    
    if ((this.getPorc_lib()!=null) && (this.getNuevo_porc()!=null)) {
    	if ((this.getPorc_lib().doubleValue()>0) && 
    	   (this.getNuevo_porc().doubleValue()>0))
    		throw new ExceptionValidation(null,"Debe ingresar el Porcentaje de Liberación o el Nuevo porcentaje. No se permite ingresar ambos.");
    	
    }
    
 }
 
 public static List getLiberacionesSujeto(Sujeto sujeto,
     ISesion aSesion) throws BaseException {
 	return DBLiberacionImpuestoSujeto.getLiberacionesSujeto(sujeto,aSesion);
 }
 
 public static LiberacionImpuestoSujeto getLiberacionImpuestoSujeto(
 		Sujeto sujeto,
 		java.util.Date fecha,
     ISesion aSesion)
     throws BaseException {
 	return DBLiberacionImpuestoSujeto.getLiberacionImpuestoSujeto(sujeto,fecha,aSesion);
 }
 

}
