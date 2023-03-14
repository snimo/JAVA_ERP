package com.srn.erp.turnos.bm;

import java.util.List;

import com.srn.erp.turnos.da.DBTurnoPlantillaHorDet;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class TurnoPlantillaHorDet extends ObjetoLogico { 

  public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

public TurnoPlantillaHorDet() { 
  }

  public static String NICKNAME = "tu.TurnoPlantillaHorDet";

  private TurnoPlantillaHorCab plantilla_horario;
  private String horario;
  private Boolean activo;

  public TurnoPlantillaHorCab getPlantilla_horario() throws BaseException { 
    supportRefresh();
    return plantilla_horario;
  }

  public void setPlantilla_horario(TurnoPlantillaHorCab aPlantilla_horario) { 
    this.plantilla_horario =  aPlantilla_horario;
  }

  public String getHorario() throws BaseException { 
    supportRefresh();
    return horario;
  }

  public void setHorario(String aHorario) { 
    this.horario =  aHorario;
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

 public static TurnoPlantillaHorDet findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (TurnoPlantillaHorDet) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static TurnoPlantillaHorDet findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (TurnoPlantillaHorDet) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(plantilla_horario, "Debe ingresar la Plantilla Horaria");
    Validar.noNulo(horario, "Debe ingresar el Horario");
 }
 
 public static List getPlantillasHorDet(TurnoPlantillaHorCab plantillaCab,
         ISesion aSesion) throws BaseException {
	  return DBTurnoPlantillaHorDet.getPlantillasHorDet(plantillaCab,aSesion);
 }
 

}
