package com.srn.erp.ventas.bm;

import java.util.List;

import com.srn.erp.ventas.da.DBEsquemaBonificacionVigSuj;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class EsquemaBonificacionVigSuj extends ObjetoLogico { 

  public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

public EsquemaBonificacionVigSuj() { 
  }

  public static String NICKNAME = "ve.EsquemaBonificacionVigSuj";

  private EsquemaBonificacion esquema_bonificacion;
  private Sujeto sujeto;
  private java.util.Date fec_vig_desde;
  private java.util.Date fec_vig_hasta;
  private Boolean activo;

  public EsquemaBonificacion getEsquema_bonificacion() throws BaseException { 
    supportRefresh();
    return esquema_bonificacion;
  }

  public void setEsquema_bonificacion(EsquemaBonificacion aEsquema_bonificacion) { 
    this.esquema_bonificacion =  aEsquema_bonificacion;
  }

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

 public static EsquemaBonificacionVigSuj findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (EsquemaBonificacionVigSuj) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static EsquemaBonificacionVigSuj findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (EsquemaBonificacionVigSuj) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(esquema_bonificacion, "Debe ingresar el Esquema de Bonificación");
    Validar.noNulo(sujeto, "Debe ingresar el Sujeto");
    Validar.noNulo(fec_vig_desde, "Debe ingresar la Fecha Desde");
    Validar.noNulo(fec_vig_hasta, "Debe ingresar la Fecha Hasta");
 }
 
 public static List getEsquemasBonifVigSuj(Sujeto sujeto,
         ISesion aSesion) throws BaseException {
	  return DBEsquemaBonificacionVigSuj.getEsquemasBonifVigSuj(sujeto,aSesion);
 }
 
 public static EsquemaBonificacionVigSuj getEsquemaBonifVigSuj(Sujeto sujeto,java.util.Date fecha,
         ISesion aSesion)
         throws BaseException {
	  return DBEsquemaBonificacionVigSuj.getEsquemaBonifVigSuj(sujeto,fecha,aSesion);
 }
 
 

}
