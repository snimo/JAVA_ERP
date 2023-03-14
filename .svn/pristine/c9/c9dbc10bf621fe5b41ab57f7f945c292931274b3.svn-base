package com.srn.erp.rrhh.bm;

import java.util.List;

import com.srn.erp.cip.bm.Rota;
import com.srn.erp.rrhh.da.DBGrabarConsRotasDet;
import com.srn.erp.sueldos.bm.Legajo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class GrabarConsRotasDet extends ObjetoLogico { 

  public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

public GrabarConsRotasDet() { 
  }

  public static String NICKNAME = "rh.GrabarConsRotasDet";

  private GrabarConsRotasCab grab_cons_rota;
  private Legajo legajo;
  private java.util.Date fecha;
  private String rota;
  private Rota turno;
  private Boolean activo;

  public GrabarConsRotasCab getGrab_cons_rota() throws BaseException { 
    supportRefresh();
    return grab_cons_rota;
  }

  public void setGrab_cons_rota(GrabarConsRotasCab aGrab_cons_rota) { 
    this.grab_cons_rota =  aGrab_cons_rota;
  }

  public Legajo getLegajo() throws BaseException { 
    supportRefresh();
    return legajo;
  }

  public void setLegajo(Legajo aLegajo) { 
    this.legajo =  aLegajo;
  }

  public java.util.Date getFecha() throws BaseException { 
    supportRefresh();
    return fecha;
  }

  public void setFecha(java.util.Date aFecha) { 
    this.fecha =  aFecha;
  }

  public String getRota() throws BaseException { 
    supportRefresh();
    if (rota!=null)
    	return rota;
    else
    	return "";
  }

  public void setRota(String aRota) { 
    this.rota =  aRota;
  }

  public Rota getTurno() throws BaseException { 
    supportRefresh();
    return turno;
  }

  public void setTurno(Rota aTurno) { 
    this.turno =  aTurno;
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

 public static GrabarConsRotasDet findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (GrabarConsRotasDet) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static GrabarConsRotasDet findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (GrabarConsRotasDet) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(grab_cons_rota, "Debe ingresar la Grabación");
    Validar.noNulo(legajo, "Debe ingresar el Legajo");
    Validar.noNulo(fecha, "Debe ingresar la Fecha");
 }
 
 public static List getConsRotasDet(GrabarConsRotasCab grabarConsRotasCab,
            ISesion aSesion) throws BaseException {
		  return DBGrabarConsRotasDet.getConsRotasDet(grabarConsRotasCab,aSesion);
 }
 
 public static List getConsRotasDetByUsuFecha(
		 	 Usuario usuario,
			 java.util.Date fecha,
			 ISesion aSesion) throws BaseException {
	 
	 return DBGrabarConsRotasDet.getConsRotasDetByUsuFecha(usuario, fecha, aSesion);
 } 

}
