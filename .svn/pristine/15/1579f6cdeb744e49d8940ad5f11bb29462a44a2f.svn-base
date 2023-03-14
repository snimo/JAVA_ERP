package com.srn.erp.turnos.bm;

import java.util.List;

import com.srn.erp.turnos.da.DBReservaParteTablero;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;
import framework.request.bl.Utils.Validar;

public class ReservaParteTablero extends ObjetoLogico {
	

  public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

public ReservaParteTablero() { 
  }

  public static String NICKNAME = "tu.ReservaParteTablero";

  private ParteTablero parte_tablero;
  private EntidadParteTableroTurnos parte_entidad;
  private ParteHorarioTurno parte_horario;
  private MotivoReservaTurno motivo;
  private String comentario;
  private Boolean activo;

  public ParteTablero getParte_tablero() throws BaseException { 
    supportRefresh();
    return parte_tablero;
  }

  public void setParte_tablero(ParteTablero aParte_tablero) { 
    this.parte_tablero =  aParte_tablero;
  }

  public EntidadParteTableroTurnos getParte_entidad() throws BaseException { 
    supportRefresh();
    return parte_entidad;
  }

  public void setParte_entidad(EntidadParteTableroTurnos aParte_entidad) { 
    this.parte_entidad =  aParte_entidad;
  }

  public ParteHorarioTurno getParte_horario() throws BaseException { 
    supportRefresh();
    return parte_horario;
  }

  public void setParte_horario(ParteHorarioTurno aParte_horario) { 
    this.parte_horario =  aParte_horario;
  }

  public MotivoReservaTurno getMotivo() throws BaseException { 
    supportRefresh();
    return motivo;
  }

  public void setMotivo(MotivoReservaTurno aMotivo) { 
    this.motivo =  aMotivo;
  }

  public String getComentario() throws BaseException { 
    supportRefresh();
    return comentario;
  }

  public void setComentario(String aComentario) { 
    this.comentario =  aComentario;
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

 public static ReservaParteTablero findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (ReservaParteTablero) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static ReservaParteTablero findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (ReservaParteTablero) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(parte_tablero, "Debe ingresar el Tablero");
    Validar.noNulo(parte_entidad, "Debe ingresar la Entidad");
    Validar.noNulo(parte_horario, "Debe ingresar el Horario");
    Validar.noNulo(motivo, "Debe ingresar el Motivo");
 }
 
 public static List getReservas(ParteTablero parteTablero,
         ISesion aSesion) throws BaseException {
	  return DBReservaParteTablero.getReservas(parteTablero,aSesion);
 }
 
 public static ReservaParteTablero getReserva(ParteTablero parteTablero,
		  EntidadTurno entidadTurno,
		  String horario,
         ISesion aSesion) throws BaseException {
	  return DBReservaParteTablero.getReserva(parteTablero,entidadTurno,horario,aSesion);
 }
 
 

}
