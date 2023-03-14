package com.srn.erp.legales.bm;

import java.util.List;

import com.srn.erp.legales.da.DBJuicioCalcInt;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class JuicioCalcInt extends ObjetoLogico { 

  public JuicioCalcInt() { 
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

public static String NICKNAME = "leg.JuicioCalcInt";

  private Juicio juicio;
  private java.util.Date fec_desde;
  private java.util.Date fec_hasta;
  private String tipo_tasa;
  private Double porc;
  private Money interes;
  private Boolean activo;

  public Juicio getJuicio() throws BaseException { 
    supportRefresh();
    return juicio;
  }

  public void setJuicio(Juicio aJuicio) { 
    this.juicio =  aJuicio;
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

  public String getTipo_tasa() throws BaseException { 
    supportRefresh();
    return tipo_tasa;
  }

  public void setTipo_tasa(String aTipo_tasa) { 
    this.tipo_tasa =  aTipo_tasa;
  }

  public Double getPorc() throws BaseException { 
    supportRefresh();
    return porc;
  }

  public void setPorc(Double aPorc) { 
    this.porc =  aPorc;
  }

  public Money getInteres() throws BaseException { 
    supportRefresh();
    return interes;
  }

  public void setInteres(Money aInteres) { 
    this.interes =  aInteres;
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

 public static JuicioCalcInt findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (JuicioCalcInt) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static JuicioCalcInt findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (JuicioCalcInt) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(juicio, "Debe ingresar el Juicio");
    Validar.noNulo(fec_desde, "Debe ingresar la fecha Desde");
    Validar.noNulo(fec_hasta, "Debe ingresar la fecha Hasta");
    Validar.noNulo(tipo_tasa, "Debe ingresar el Tipo de Tasa");
    Validar.noNulo(porc, "Debe ingresar el Porcentaje");
    Validar.noNulo(interes, "Debe ingresar el Interes");
 }
 
 public static List getCalcInteres(
		  Juicio aJuicio,
         ISesion aSesion) throws BaseException {
	  return DBJuicioCalcInt.getCalcInteres(aJuicio,aSesion);
 }  
  

}
