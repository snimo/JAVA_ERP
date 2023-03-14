package com.srn.erp.turnos.bm;

import java.util.List;

import com.srn.erp.turnos.da.DBParteHorarioTurno;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class ParteHorarioTurno extends ObjetoLogico { 

  public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

public ParteHorarioTurno() { 
  }

  public static String NICKNAME = "tu.ParteHorarioTurno";

  private ParteTablero parte_tablero;
  private String horario;
  private Boolean activo;

  public ParteTablero getParte_tablero() throws BaseException { 
    supportRefresh();
    return parte_tablero;
  }

  public void setParte_tablero(ParteTablero aParte_tablero) { 
    this.parte_tablero =  aParte_tablero;
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

 public static ParteHorarioTurno findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (ParteHorarioTurno) getObjectByOid(NICKNAME,oid,aSesion);
  } 
 
 public static ParteHorarioTurno findByOidProxy(Integer oid , ISesion aSesion) throws BaseException { 
  return (ParteHorarioTurno) getObjectByOidProxy(NICKNAME,oid,aSesion);
 } 

 public static ParteHorarioTurno findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (ParteHorarioTurno) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(parte_tablero, "Debe ingresar el Tablero");
    Validar.noNulo(horario, "Debe ingresar el Horario");
 }
 
 public static List getHorarios(ParteTablero parteTablero,
         ISesion aSesion) throws BaseException {
	  return DBParteHorarioTurno.getHorarios(parteTablero,aSesion);
 }
 
 public static ParteHorarioTurno getHorario(ParteTablero parteTablero,
		  String horario,
         ISesion aSesion) throws BaseException {
	  return DBParteHorarioTurno.getHorario(parteTablero,horario,aSesion);
 }
 

}
