package com.srn.erp.turnos.bm;

import java.util.Iterator;
import java.util.List;

import com.srn.erp.turnos.da.DBReglamentoTurno;
import com.srn.erp.turnos.da.DBRelaConcSujTur;
import com.srn.erp.ventas.bm.Sujeto;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bl.Utils.Util;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.Validar;

public class ReglamentoTurno extends ObjetoLogico {

	public ReglamentoTurno() {
	}

	public static String NICKNAME = "tu.ReglamentoTurno";

	private String codigo;
	private String descripcion;
	private String comportamiento;
	private Boolean activo;
	private Boolean usar;
	private Boolean reglaJugadorInactivo;
	private Boolean reglaJugadorSuspension;
	private Boolean regla1TurnoActivo;
	private Boolean reglaDeudaCategoria;
	private Boolean reglaDeudaGeneral;
	private Money montoDeudaGeneral;
	private Boolean reglaAntiguedadDeuda;
	private int diasAntiguedadDeuda;
	private Boolean reglaTurnoSegunCateg;
	private Boolean reglaTurnoSegunRela;
	private Boolean reglaDeudaConcepto;
	private Boolean reglaConcSufCateg;
	

	public String getCodigo() throws BaseException {
		supportRefresh();
		return codigo;
	}

	public void setCodigo(String aCodigo) {
		this.codigo = aCodigo;
	}
	
	public Boolean isReglaTurnoSegunCategoria() throws BaseException {
		supportRefresh();
		return this.reglaTurnoSegunCateg;
	}

	public void setReglaTurnoSegunCategoria(Boolean aReglaTurnoSegunCategoria) {
		this.reglaTurnoSegunCateg = aReglaTurnoSegunCategoria;
	}
	
	public Boolean isReglaConcSufCateg() throws BaseException {
		supportRefresh();
		return this.reglaConcSufCateg;
	}

	public void setReglaConcSufCateg(Boolean aReglaConcSufCateg) {
		this.reglaConcSufCateg = aReglaConcSufCateg;
	}
	
	
	public Boolean isReglaDeudaConcepto() throws BaseException {
		supportRefresh();
		return this.reglaDeudaConcepto;
	}

	public void setReglaDeudaConcepto(Boolean aReglaDeudaConcepto) {
		this.reglaDeudaConcepto = aReglaDeudaConcepto;
	}
	
	
	public Boolean isReglaTurnoSegunRelacion() throws BaseException {
		supportRefresh();
		return this.reglaTurnoSegunRela;
	}

	public void setReglaTurnoSegunRelacion(Boolean aReglaTurnoSegunRelacion) {
		this.reglaTurnoSegunRela = aReglaTurnoSegunRelacion;
	}
	
	
	
	public Boolean isReglaDeudaCategoria() throws BaseException {
		supportRefresh();
		return this.reglaDeudaCategoria;
	}

	public void setReglaDeudaCategoria(Boolean aReglaDeudaCategoria) {
		this.reglaDeudaCategoria = aReglaDeudaCategoria;
	}
	
	public Boolean isReglaDeudaGeneral() throws BaseException {
		supportRefresh();
		return this.reglaDeudaGeneral;
	}

	public void setReglaDeudaGeneral(Boolean aReglaDeudaGeneral) {
		this.reglaDeudaGeneral = aReglaDeudaGeneral;
	}
	
	public Money getMontoDeudaGral() throws BaseException {
		supportRefresh();
		if (montoDeudaGeneral == null)
			return new Money(0);
		else
			return this.montoDeudaGeneral;
	}

	public void setMontoDeudaGral(Money aMontoDeudaGral) {
		this.montoDeudaGeneral = aMontoDeudaGral;
	}
	
	public Boolean isReglaAntiguedadDeuda() throws BaseException {
		supportRefresh();
		return this.reglaAntiguedadDeuda;
	}

	public void setReglaAntiguedadDeuda(Boolean aReglaAntiguedadDeuda) {
		this.reglaAntiguedadDeuda = aReglaAntiguedadDeuda;
	}
	
	public int getDiasAntDeuda() throws BaseException {
		supportRefresh();
		return this.diasAntiguedadDeuda;
	}

	public void setDiasAntiguedadDeuda(Integer aDiasAntiguedadDeuda) {
		this.diasAntiguedadDeuda = aDiasAntiguedadDeuda;
	}	
		
	
	public Boolean isUsar() throws BaseException {
		supportRefresh();
		return this.usar;
	}

	public void setUsar(Boolean aUsar) {
		this.usar = aUsar;
	}
	
	public Boolean isReglaUnturnoActivo() throws BaseException {
		supportRefresh();
		return this.regla1TurnoActivo;
	}

	public void setReglaUnTurnoActivo(Boolean aReglaUnTurnoActivo) {
		this.regla1TurnoActivo = aReglaUnTurnoActivo;
	}
	

	public Boolean isReglaJugadorSuspension() throws BaseException {
		supportRefresh();
		return this.reglaJugadorSuspension;
	}

	public void setReglaJugadorSuspension(Boolean aReglaJugadorSuspension) {
		this.reglaJugadorSuspension = aReglaJugadorSuspension;
	}

	public Boolean isReglaJugadorInactivo() throws BaseException {
		supportRefresh();
		return this.reglaJugadorInactivo;
	}

	public void setReglaJugadorInactivo(Boolean aReglaJugadorInactivo) {
		this.reglaJugadorInactivo = aReglaJugadorInactivo;
	}

	public String getDescripcion() throws BaseException {
		supportRefresh();
		return descripcion;
	}

	public void setDescripcion(String aDescripcion) {
		this.descripcion = aDescripcion;
	}

	public String getComportamiento() throws BaseException {
		supportRefresh();
		return comportamiento;
	}

	public void setComportamiento(String aComportamiento) {
		this.comportamiento = aComportamiento;
	}

	public Boolean isActivo() throws BaseException {
		supportRefresh();
		return activo;
	}

	public void setActivo(Boolean aActivo) {
		this.activo = aActivo;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static ReglamentoTurno findByOid(Integer oid, ISesion aSesion)
			throws BaseException {
		return (ReglamentoTurno) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static ReglamentoTurno findByCodigo(String codigo, ISesion aSesion)
			throws BaseException {
		return (ReglamentoTurno) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(codigo, "Debe ingresar el Código");
		Validar.noNulo(descripcion, "Debe ingresar la Descripción");
		Validar.noNulo(comportamiento, "Debe ingresar el Tipo");
	}

	public static ReglamentoTurno getReglamentoTurnoUsar(String comportamiento,
			ISesion aSesion) throws BaseException {
		return DBReglamentoTurno
				.getReglamentoTurnoUsar(comportamiento, aSesion);
	}

	public void validarPonerTurno(String sujeto, TableroTurnos tablero,
			TableroEntidadTurnos tableroEntidad,
			TableroHorarioTurnos tableroHorario, boolean autorizo , StringBuffer detalleErrores) throws BaseException {
		
		if (!tablero.isReglamentoActivo()) return;

		if (tablero.getComportamiento().equals(TurnoGrupoEntidad.TIPO_TENIS))
			validarReglamentoTenis(sujeto, tablero, tableroEntidad,
					tableroHorario,autorizo,detalleErrores);

	}

	private void validarReglamentoTenis(String sujeto, TableroTurnos tablero,
			TableroEntidadTurnos tableroEntidad,
			TableroHorarioTurnos tableroHorario, boolean autorizo,
			StringBuffer detalleErrores) throws BaseException {

		if (autorizo == true)
			return;
		
		// Validar que el sujeto exista
		Sujeto sujTurno = Sujeto.findByCodigo(sujeto, this.getSesion());
		if (sujTurno == null)
			throw new ExceptionValidation(null, "Código inexistente");

		// Regla de jugadores inactivos
		if (this.isReglaJugadorInactivo().booleanValue()) {
			if (!sujTurno.isActivo().booleanValue())
				detalleErrores.append(
						 sujTurno.getCodigo() + " - "
						+ sujTurno.getDescripcion() + " se encuentra inactivo."+Util.ENTER());
		}

		// No permitir que un jugador juege con una suspension activo
		if (this.isReglaJugadorSuspension()) {
			if (sujTurno.isSuspendidoParaTurno()) {
				if ((sujTurno.getFecSuspendidoDesde()!=null) && (sujTurno.getFecSuspendidoHasta()!=null)) {
					if (tablero.getFecha().after(Fecha.getFechaDiaAnterior(sujTurno.getFecSuspendidoDesde())) && 
							tablero.getFecha().before(Fecha.getFechaDiaPosterior(sujTurno.getFecSuspendidoHasta()))) {
						detalleErrores.append(
								sujTurno.getCodigo() + " - "
								+ sujTurno.getDescripcion()+" tiene una suspensión. Motivo:"+ sujTurno.getMotivoTurnoSuspension()+Util.ENTER());
					}
					
				}
			}
		}
		
		// Un jugador no puede tener mas de un turno activo al mismo tiempo
		if (this.isReglaUnturnoActivo()) {
			
			ReservaTableroTurno reservaActual = tablero.getReserva(tableroEntidad, tableroHorario);
			
			List reservasActivas = tablero.getReservasActivasSujetoMenosReserva(sujTurno,reservaActual);
			if (reservasActivas.size()>0) {
				StringBuffer mensajeLeyAct = new StringBuffer();
				Iterator iterReserActivas = reservasActivas.iterator();
				while (iterReserActivas.hasNext()) {
					ReservaTableroTurno reserva = (ReservaTableroTurno) iterReserActivas.next();
					mensajeLeyAct.append(" Cancha:"+reserva.getEntidad_tablero().getEntidad_turno().getCodigo()+" Horario:"+reserva.getHorario_tablero().getHorario());
				}
				detalleErrores.append(sujTurno.getCodigo() + " - "+sujTurno.getDescripcion()+" ya tiene las siguiente reservas "+mensajeLeyAct.toString()+Util.ENTER());
			}
		}
		
		// Validar si la categoria esta permitida
		if (this.isReglaTurnoSegunCategoria()) {
				if (sujTurno.getCategoriaSujetoTurno()!=null) {
					if (sujTurno.getCategoriaSujetoTurno().isNoPermitirTurno()==true)
						detalleErrores.append(
								sujTurno.getCodigo() + " - "+
								sujTurno.getDescripcion()+
								" pertenece a la categoría "+ sujTurno.getCategoriaSujetoTurno().getDescripcion()+Util.ENTER());
				}
		}
		
		// Validar si la relacion esta permitida
		if (this.isReglaTurnoSegunRelacion()) {
				if (sujTurno.getRelacionSujetoTurno()!=null) {
					if (sujTurno.getRelacionSujetoTurno().isNoPermitirTurno()==true)
						detalleErrores.append(
								sujTurno.getCodigo() + " - "+
								sujTurno.getDescripcion()+
								" pertenece a la relación "+ sujTurno.getRelacionSujetoTurno().getDescripcion()+Util.ENTER());
				}
		}
		
		
		DeudaSujetoTurno deudaSujeto = new DeudaSujetoTurno(this.getSesion());
		deudaSujeto.setComportamiento(tablero.getComportamiento());
		deudaSujeto.setNroSocio(new Integer(sujTurno.getCodigo()));
		deudaSujeto.setFecha(tablero.getFecha());
		
		boolean calcDeudaSuj = false;
		double montoDeudaSuj = 0.0;
		
		// Validar control deuda segun montos configurados por categoria
		if (this.isReglaDeudaCategoria()) {
			if (sujTurno.getCategoriaSujetoTurno()!=null) {
				Money monMaxCateg = new Money(0);
				if (sujTurno.getCategoriaSujetoTurno().getMontoMaxDeuda()!=null)
					monMaxCateg = sujTurno.getCategoriaSujetoTurno().getMontoMaxDeuda();
				
					montoDeudaSuj = deudaSujeto.getDeuda();
					calcDeudaSuj = true;
					
					if (montoDeudaSuj>monMaxCateg.doubleValue()) {
						detalleErrores.append(sujTurno.getCodigo() + " - "+
								sujTurno.getDescripcion()+
								" tiene un deuda de "+
								montoDeudaSuj+" que supera a "+
								monMaxCateg.doubleValue()+
								" que es el máximo permitido para la categoria "+
								sujTurno.getCategoriaSujetoTurno().getDescripcion()+Util.ENTER());
					}
					
				
				//
				
			}
		}
		
		// Validar la deuda General
		if (this.isReglaDeudaGeneral()) {
				Money monMaxCateg = new Money(0);
				
				if (calcDeudaSuj==false) {
					montoDeudaSuj = deudaSujeto.getDeuda();
					calcDeudaSuj = true;
				}
				
				if (montoDeudaSuj>this.getMontoDeudaGral().doubleValue()) 
					detalleErrores.append(sujTurno.getCodigo() + " - "+
								sujTurno.getDescripcion()+
								" tiene un deuda de "+
								montoDeudaSuj+" que supera a "+
								this.getMontoDeudaGral().doubleValue()+
								" que es el máxima deuda permitida "+Util.ENTER());
				
		}
		
		// Validar antiguedad de la deuda
		if (this.isReglaAntiguedadDeuda()) {
				
			if (calcDeudaSuj==false) {
				montoDeudaSuj = deudaSujeto.getDeuda();
				calcDeudaSuj = true;
			}
			
			java.util.Date fechaLimite = Fecha.getFechaMasDias(tablero.getFecha(), this.getDiasAntDeuda()*-1);
			
			Iterator iterMov = deudaSujeto.getDetMov().iterator();
			while (iterMov.hasNext()) {
				ItemDeudaSujetoTurno itemDeuda = (ItemDeudaSujetoTurno) iterMov.next();
				if (itemDeuda.getFecha().before(fechaLimite)) {
					detalleErrores.append(sujTurno.getCodigo() + " - "+
							sujTurno.getDescripcion()+
							" tiene un concepto impago "+itemDeuda.getCodMov()+"-"+itemDeuda.getNroMov()+" "+itemDeuda.getConcepto()+"-"+GrupoConceptoTurno.getDescConcSistClubes(itemDeuda.getConcepto(), this.getSesion())+" ("+Fecha.getddmmyyyy(itemDeuda.getFecha())+") por un monto de "+itemDeuda.getSaldoPendPago()+
							" que venció hace más de "+this.getDiasAntDeuda()+" días."+Util.ENTER());
				}
				
			}
				
		}
		
		// Validar Deuda por conceptos
		if (this.isReglaDeudaConcepto()) {
				
			if (calcDeudaSuj==false) {
				montoDeudaSuj = deudaSujeto.getDeuda();
				calcDeudaSuj = true;
			}
			
			Iterator iterGruposConc = deudaSujeto.getGruposConceptos().iterator();
			while (iterGruposConc.hasNext()) {
				ItemDeudaGrupo itemDeudaGrupo = (ItemDeudaGrupo) iterGruposConc.next();
				//itemDeudaGrupo.validarDeuda(detalleErrores);
				itemDeudaGrupo.validarPeriodosAtraso(tablero.getFecha(),detalleErrores);
			}
				
		}
		
		// Validar que tenga conceptos suficientes habilitados
		if (this.isReglaConcSufCateg()) {
			
			if (sujTurno.getCategoriaSujetoTurno().isTieneConcHabilitados()) {
				
				if (sujTurno.getConcHabCategTurnos(tablero.getComportamiento()).isEmpty())
					detalleErrores.append(sujTurno.getCodigo() + " - "+
							sujTurno.getDescripcion()+
							" no tiene los coneptos permitidos para poder poner un turno"+Util.ENTER());
					
			}
				
				
		}
		
		
		
		
		
		
		
		

	}

}
