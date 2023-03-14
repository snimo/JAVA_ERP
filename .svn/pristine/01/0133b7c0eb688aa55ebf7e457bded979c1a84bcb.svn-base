package com.srn.erp.turnos.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.Fecha;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class ParteTablero extends ObjetoLogico {
	
  private List horarios = new ArrayList();
  private boolean readHorarios = true;
  
  private List entidades = new ArrayList();
  private boolean readEntidades = true;
	  
  private List reservas = new ArrayList();
  private boolean readReservas = true;
	

  public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

  public ParteTablero() { 
  }

  public static String NICKNAME = "tu.ParteTablero";

  private String descripcion;
  private Boolean lunes;
  private Boolean martes;
  private Boolean miercoles;
  private Boolean jueves;
  private Boolean viernes;
  private Boolean sabado;
  private Boolean domingo;
  private Boolean activo;

  public String getDescripcion() throws BaseException { 
    supportRefresh();
    return descripcion;
  }

  public void setDescripcion(String aDescripcion) { 
    this.descripcion =  aDescripcion;
  }

  public Boolean isLunes() throws BaseException { 
    supportRefresh();
    return lunes;
  }

  public void setLunes(Boolean aLunes) { 
    this.lunes =  aLunes;
  }

  public Boolean isMartes() throws BaseException { 
    supportRefresh();
    return martes;
  }

  public void setMartes(Boolean aMartes) { 
    this.martes =  aMartes;
  }

  public Boolean isMiercoles() throws BaseException { 
    supportRefresh();
    return miercoles;
  }

  public void setMiercoles(Boolean aMiercoles) { 
    this.miercoles =  aMiercoles;
  }

  public Boolean isJueves() throws BaseException { 
    supportRefresh();
    return jueves;
  }

  public void setJueves(Boolean aJueves) { 
    this.jueves =  aJueves;
  }

  public Boolean isViernes() throws BaseException { 
    supportRefresh();
    return viernes;
  }

  public void setViernes(Boolean aViernes) { 
    this.viernes =  aViernes;
  }

  public Boolean isSabado() throws BaseException { 
    supportRefresh();
    return sabado;
  }

  public void setSabado(Boolean aSabado) { 
    this.sabado =  aSabado;
  }

  public Boolean isDomingo() throws BaseException { 
    supportRefresh();
    return domingo;
  }

  public void setDomingo(Boolean aDomingo) { 
    this.domingo =  aDomingo;
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

 public static ParteTablero findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (ParteTablero) getObjectByOid(NICKNAME,oid,aSesion);
  } 
 
 public static ParteTablero findByOidProxy(Integer oid , ISesion aSesion) throws BaseException { 
	   return (ParteTablero) getObjectByOidProxy(NICKNAME,oid,aSesion);
	  } 

 public static ParteTablero findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (ParteTablero) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(descripcion, "Debe ingresar la Descripción");
 }
 
 public List getHorarios() throws BaseException {
	if (readHorarios) {
	    List listaHorarios = ParteHorarioTurno.getHorarios(this,getSesion());
	    this.horarios.addAll(listaHorarios);
	    readHorarios = false;
	}
	return this.horarios;
 }
 
 public List getEntidades() throws BaseException {
	if (readEntidades) {
		List listaEntidades = EntidadParteTableroTurnos.getEntidades(this,getSesion());
		this.entidades.addAll(listaEntidades);
		readEntidades = false;
	}
	return this.entidades;
 }
 
 public List getReservas() throws BaseException {
	 if (readReservas) {
		List listaReservas = ReservaParteTablero.getReservas(this,getSesion());
		this.reservas.addAll(listaReservas);
		readReservas = false;
	 }
	return this.reservas;
 } 
 
 public void addHorario(ParteHorarioTurno parteHorarioTurno) throws BaseException {
	 parteHorarioTurno.setParte_tablero(this);
	 this.horarios.add(parteHorarioTurno);
 }
 
 public void addReserva(ReservaParteTablero reserva) throws BaseException {
	 reserva.setParte_tablero(this);
	 this.reservas.add(reserva);
 }
 
 public void addEntidad(EntidadParteTableroTurnos entidadParteTablero) throws BaseException {
	 entidadParteTablero.setParte_tablero(this);
	 this.entidades.add(entidadParteTablero);
 } 

 public void afterSave() throws BaseException {
	
	 Iterator iterHorarios = this.horarios.iterator();
	 while (iterHorarios.hasNext()) {
	  ParteHorarioTurno parteHorarioTurno = (ParteHorarioTurno) iterHorarios.next();
	  parteHorarioTurno.save();
	  parteHorarioTurno = null;
	 }
	 iterHorarios = null;
	 
	 Iterator iterEntidades = this.entidades.iterator();
	 while (iterEntidades.hasNext()) {
	  EntidadParteTableroTurnos entidadParteTableroTurno = (EntidadParteTableroTurnos) iterEntidades.next();
	  entidadParteTableroTurno.save();
	  entidadParteTableroTurno = null;
	 }
	 iterEntidades = null;
	 
	 Iterator iterReservas = this.reservas.iterator();
	 while (iterReservas.hasNext()) {
	  ReservaParteTablero reservaParteTablero = (ReservaParteTablero) iterReservas.next();
	  reservaParteTablero.save();
	  reservaParteTablero = null;
	 }
	 iterReservas = null;
	 
 }
 
  public EntidadParteTableroTurnos getEntidadParteTablero(
		  EntidadTurno entidadTurno,
        ISesion aSesion)
        throws BaseException {
	  return EntidadParteTableroTurnos.getEntidadParteTablero(this,entidadTurno,this.getSesion());
  }
  
  public ReservaParteTablero getReserva(
		  EntidadTurno entidadTurno,
		  String horario,
         ISesion aSesion) throws BaseException {
	  return ReservaParteTablero.getReserva(this,entidadTurno,horario,this.getSesion());
 }
  
  public ParteHorarioTurno getHorario(String horario) throws BaseException {
	  return ParteHorarioTurno.getHorario(this,horario,this.getSesion());
 }
  
  public boolean isCorrespondeProgramar(java.util.Date fecha) throws BaseException {
	  
	  int dia = Fecha.getDiaSemana(fecha);
	  if ((dia == 1) && (this.isDomingo()))
		  return true;
	  else
		  if ((dia == 2) && (this.isLunes()))
			  return true;
		  else
			  if ((dia == 3) && (this.isMartes()))
				  return true;
			  else
				  if ((dia == 4) && (this.isMiercoles()))
					  return true;
				  else
					  if ((dia == 5) && (this.isJueves()))
						  return true;
					  else
						  if ((dia == 6) && (this.isViernes()))
							  return true;
						  else
							  if ((dia == 7) && (this.isSabado()))
								  return true;
							  else
								  return false;
  }
 
 

}
