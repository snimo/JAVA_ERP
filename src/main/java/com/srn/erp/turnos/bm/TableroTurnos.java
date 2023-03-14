package com.srn.erp.turnos.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.general.bm.Moneda;
import com.srn.erp.turnos.da.DBReservaTableroTurno;
import com.srn.erp.turnos.da.DBTableroHorarioTurnos;
import com.srn.erp.turnos.da.DBTableroTurnos;
import com.srn.erp.ventas.bm.Sujeto;
import com.srn.erp.ventas.da.DBSujeto;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bm.Parametros.ValorParametro;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.Validar;

public class TableroTurnos extends ObjetoLogico {

	public static final String SECU_INVI_TUR = "SECU_INVI_TUR";
	
	private List entidades = new ArrayList();
	private boolean readEntidades = true;

	private List reservas = new ArrayList();
	private boolean readReservas = true;

	@Override
	public Boolean isActivo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public TableroTurnos() {
	}

	public static String NICKNAME = "tu.TableroTurnos";

	private String descripcion;
	private java.util.Date fecha;
	private String comportamiento;
	private Boolean reglamentoActivo;
	private Boolean lectorActivo;

	public String getDescripcion() throws BaseException {
		supportRefresh();
		return descripcion;
	}

	public void setDescripcion(String aDescripcion) {
		this.descripcion = aDescripcion;
	}
	
	public Boolean isLectorActivo() throws BaseException {
		supportRefresh();
		return this.lectorActivo;
	}

	public void setLectorActivo(Boolean aLectorActivo) {
		this.lectorActivo = aLectorActivo;
	}
	

	public java.util.Date getFecha() throws BaseException {
		supportRefresh();
		return fecha;
	}

	public void setFecha(java.util.Date aFecha) {
		this.fecha = aFecha;
	}

	public String getComportamiento() throws BaseException {
		supportRefresh();
		return comportamiento;
	}

	public void setComportamiento(String aComportamiento) {
		this.comportamiento = aComportamiento;
	}
	
	public Boolean isReglamentoActivo() throws BaseException {
		supportRefresh();
		return this.reglamentoActivo;
	}

	public void setReglamentoActivo(Boolean aReglamentoActivo) {
		this.reglamentoActivo = aReglamentoActivo;
	}	

	public String getNickName() {
		return NICKNAME;
	}

	public static TableroTurnos findByOid(Integer oid, ISesion aSesion)
			throws BaseException {
		return (TableroTurnos) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static TableroTurnos findByOidProxy(Integer oid, ISesion aSesion)
			throws BaseException {
		return (TableroTurnos) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static TableroTurnos findByCodigo(String codigo, ISesion aSesion)
			throws BaseException {
		return (TableroTurnos) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(descripcion, "Debe ingresar la Descripción");
		Validar.noNulo(fecha, "Debe ingresar la fecha");
		Validar.noNulo(comportamiento, "Debe ingresar el Comportamiento");
		
		if (this.isLectorActivo()==null)
			this.setLectorActivo(true);
	}

	public List getEntidades() throws BaseException {
		if (readEntidades) {
			List listaEntidades = TableroEntidadTurnos.getEntidadesTablero(
					this, getSesion());
			entidades.addAll(listaEntidades);
			readEntidades = false;
		}
		return entidades;
	}

	public List getReservas() throws BaseException {
		if (readReservas) {
			List listaReservas = ReservaTableroTurno.getReservasTablero(this,
					getSesion());
			reservas.addAll(listaReservas);
			readReservas = false;
		}
		return reservas;
	}

	public void addEntidad(TableroEntidadTurnos tableroEntidadTurnos)
			throws BaseException {
		tableroEntidadTurnos.setTablero(this);
		entidades.add(tableroEntidadTurnos);
	}

	public void addReserva(ReservaTableroTurno reserva) throws BaseException {
		reserva.setTablero(this);
		reservas.add(reserva);
	}

	public void afterSave() throws BaseException {

		Iterator iterTablerosEntidades = this.entidades.iterator();
		while (iterTablerosEntidades.hasNext()) {
			TableroEntidadTurnos tableroEntidadTurnos = (TableroEntidadTurnos) iterTablerosEntidades
					.next();
			tableroEntidadTurnos.save();
			tableroEntidadTurnos = null;
		}
		iterTablerosEntidades = null;

		Iterator iterReservas = this.reservas.iterator();
		while (iterReservas.hasNext()) {
			ReservaTableroTurno reservaTableroTurno = (ReservaTableroTurno) iterReservas
					.next();
			reservaTableroTurno.save();
			reservaTableroTurno = null;
		}
		iterReservas = null;

	}

	public static TableroTurnos programarTablero(java.util.Date fecha,
			EstrucTableroTurnosCab estrucTablero, boolean reescribir,
			ISesion aSesion) throws BaseException {

		// Programacion del Tablero

		if (reescribir == false) {
			TableroTurnos tabExi = TableroTurnos.getTablero(fecha,
					estrucTablero.getComportamiento(), aSesion);
			if (tabExi != null)
				throw new ExceptionValidation(null,
						"Ya existe un tablero creado para la fecha "
								+ Fecha.getddmmyyyy(fecha));
		} else {
			TableroTurnos tabExi = TableroTurnos.getTablero(fecha,
					estrucTablero.getComportamiento(), aSesion);
			if (tabExi != null)
				tabExi.borrarTablero();
		}

		TableroTurnos tablero = programacionInternaTablero(fecha,
				estrucTablero, true, aSesion);

		return tablero;
	}

	public boolean isExisteTableroPrograma(java.util.Date fecha,
			String comportamiento, ISesion aSesion) throws BaseException {
		return true;
	}

	public static TableroTurnos getTablero(java.util.Date fecha,
			String comportamiento, ISesion aSesion) throws BaseException {
		return DBTableroTurnos.getTablero(fecha, comportamiento, aSesion);
	}

	public void borrarTablero() throws BaseException {
		DBTableroTurnos.borrarTablero(this, this.getSesion());
	}

	private static TableroTurnos programacionInternaTablero(
			java.util.Date fecha, EstrucTableroTurnosCab estrucTablero,
			boolean reescribir, ISesion aSesion) throws BaseException {

		int secuEntidades = 1;
		TableroTurnos tablero = (TableroTurnos) TableroTurnos.getNew(
				TableroTurnos.NICKNAME, aSesion);
		tablero.setReglamentoActivo(new Boolean(true));
		tablero.setDescripcion(TurnoGrupoEntidad.getDescripcion(estrucTablero
				.getComportamiento())
				+ " " + Fecha.getddmmyyyy(fecha));
		tablero.setFecha(fecha);
		tablero.setComportamiento(estrucTablero.getComportamiento());

		Iterator iterDetEstrucTab = estrucTablero.getDetalles().iterator();
		while (iterDetEstrucTab.hasNext()) {

			EstrucTableroTurnosDet estrucTableroTurnosDet = (EstrucTableroTurnosDet) iterDetEstrucTab
					.next();
			if (!estrucTableroTurnosDet.getParte_tablero()
					.isCorrespondeProgramar(fecha))
				continue;

			Iterator iterEntidades = estrucTableroTurnosDet.getParte_tablero()
					.getEntidades().iterator();
			while (iterEntidades.hasNext()) {
				EntidadParteTableroTurnos entidadParte = (EntidadParteTableroTurnos) iterEntidades
						.next();

				// Entidad

				TableroEntidadTurnos tableroEntidadTurnos = (TableroEntidadTurnos) TableroEntidadTurnos
						.getNew(TableroEntidadTurnos.NICKNAME, aSesion);
				tableroEntidadTurnos.setTablero(tablero);
				tableroEntidadTurnos.setSecu(secuEntidades);
				tableroEntidadTurnos.setEntidad_turno(entidadParte
						.getEntidad_turno());
				tableroEntidadTurnos.setCambiarHorarioAlPonerTurno(entidadParte.isCambiarHorarioAlPonerTurno());
				tableroEntidadTurnos.setMinutosTurno1Suj(entidadParte.getMinutosTur1Suj());
				tableroEntidadTurnos.setMinutosTurno2Suj(entidadParte.getMinutosTur2Suj());
				tableroEntidadTurnos.setMinutosTurno3Suj(entidadParte.getMinutosTur3Suj());
				tableroEntidadTurnos.setMinutosTurno4Suj(entidadParte.getMinutosTur4Suj());
				
				tablero.addEntidad(tableroEntidadTurnos);

				// Horarios
				Iterator iterHorarios = estrucTableroTurnosDet
						.getParte_tablero().getHorarios().iterator();
				while (iterHorarios.hasNext()) {
					ParteHorarioTurno parteHorarioTurno = (ParteHorarioTurno) iterHorarios
							.next();

					TableroHorarioTurnos tableroHorario = (TableroHorarioTurnos) TableroHorarioTurnos
							.getNew(TableroHorarioTurnos.NICKNAME, aSesion);
					tableroHorario.setTablero(tablero);
					tableroHorario.setEntidad_tablero(tableroEntidadTurnos);
					tableroHorario.setHorario(parteHorarioTurno.getHorario());
					tableroEntidadTurnos.addHorario(tableroHorario);

					ReservaParteTablero reserva = estrucTableroTurnosDet
							.getParte_tablero().getReserva(
									tableroEntidadTurnos.getEntidad_turno(),
									parteHorarioTurno.getHorario(), aSesion);
					if ((reserva != null) && (reserva.getMotivo() != null)) {
						ReservaTableroTurno reservaTablero = (ReservaTableroTurno) ReservaTableroTurno
								.getNew(ReservaTableroTurno.NICKNAME, aSesion);
						reservaTablero.setTablero(tablero);
						reservaTablero.setEntidad_tablero(tableroEntidadTurnos);
						reservaTablero.setHorario_tablero(tableroHorario);
						reservaTablero
								.setCompo_tipo_res(ReservaTableroTurno.TIPO_RES_MOT);
						reservaTablero.setMotivo(reserva.getMotivo());
						reservaTablero.setDesc_1(reserva.getMotivo()
								.getDescripcion());
						tablero.addReserva(reservaTablero);

					}

				}

				// Obtener las Reservas por Motivos

				++secuEntidades;
			}

		}

		return tablero;

	}

	public ReservaTableroTurno getReserva(TableroEntidadTurnos tableroEntidad,
			TableroHorarioTurnos tableroHorarios) throws BaseException {
		return ReservaTableroTurno.getReserva(this, tableroEntidad,
				tableroHorarios, this.getSesion());
	}

	public static List getTableros(java.util.Date fechaDesde,
			java.util.Date fechaHasta, String comportamiento, ISesion aSesion)
			throws BaseException {
		return DBTableroTurnos.getTableros(fechaDesde, fechaHasta,
				comportamiento, aSesion);
	}
	
	public void validarPonerTurno(String sujeto,TableroEntidadTurnos tableroEntidad, TableroHorarioTurnos tableroHorario, boolean autorizo , StringBuffer detalleErrores) throws BaseException {
		
		ReglamentoTurno reglamento = ReglamentoTurno.getReglamentoTurnoUsar(this.getComportamiento(), this.getSesion());
		if (reglamento == null) return;
		
		reglamento.validarPonerTurno(sujeto,this,tableroEntidad,tableroHorario,autorizo,detalleErrores);
		
	}
	
	public List getReservasActivasSujeto(Sujeto sujeto)
			throws BaseException {
			return DBReservaTableroTurno.getReservasActivasSujeto(this,sujeto,this.getSesion()); 
	}
	
	public List getReservasActivasSujetoMenosReserva(Sujeto sujeto , ReservaTableroTurno reserva)
		throws BaseException {
		return DBReservaTableroTurno.getReservasActivasSujetoMenosReserva(this,sujeto,reserva,this.getSesion()); 
	}
	
	
	public List getHorariosLibresActivos(TableroEntidadTurnos tableroEntidad)
		throws BaseException {
		return TableroHorarioTurnos.getHorariosLibres(this,tableroEntidad,this.getSesion());
	}
	
	public List getHorariosActivos(TableroEntidadTurnos tableroEntidad)
	throws BaseException {
		return TableroHorarioTurnos.getHorariosActivos(this,tableroEntidad,this.getSesion());
	}
	
	public List getReservasSujeto(Sujeto sujeto)
		throws BaseException {
		return ReservaTableroTurno.getReservasSujeto(this, sujeto, this.getSesion());
	}	
	
	
	
	public static int getNroMinimoInvitado(ISesion aSesion)
	throws BaseException {
		Integer nroMinimo = ValorParametro.findByCodigoParametro(
		"MIN_NRO_INVITADO_TURNOS", aSesion).getValorEntero();
		return nroMinimo.intValue();
	}
	
	public List getSujetosInvitados() throws BaseException {
		  return Sujeto.getSujetosInvitadosTablero(this,this.getSesion());
	}
	

}
