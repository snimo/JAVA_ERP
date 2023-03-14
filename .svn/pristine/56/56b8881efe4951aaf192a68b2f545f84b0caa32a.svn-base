package com.srn.erp.cip.bm;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;

import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.mensajero.bm.MensajeONLINE;
import com.srn.erp.mensajero.bm.MotorMensONLINE;
import com.srn.erp.mensajero.bm.Ring;
import com.srn.erp.sueldos.bm.Legajo;

import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.Fecha;
import framework.request.bl.Utils.BaseException;

public class TienePermisoCIP {

	public static String MENSAJE_PERSONA_A_CACHEO1 = "*** PERSONA A CACHEO ***";

	ISesion sesion = null;
	Integer identifEquipo = null;
	Integer identifPtoAcceso = null;
	Integer identifDir = null;
	String identifLegajo = null;
	boolean puedePasar = false;
	Puerta puerta = null;
	Legajo legajo = null;
	Visita visita = null;
	String motivoPermiso = "";
	java.util.Date fecha = null;
	int horaEnMin = 0;
	private String hora;
	private boolean noInterpretarB1FC_U2DBNRO = false;
	private boolean noInterpretarHID37Bits = false;

	private boolean noEnviarMensajes = false;
	TarjetaLegajo tarjetaLegajo = null;

	private TarjetaLegajo getTarjetaLegajo() {
		return tarjetaLegajo;
	}

	public boolean isNoEnviarMensajes() {
		return noEnviarMensajes;
	}

	public void setNoEnviarMensajes(boolean noEnviarMensajes) {
		this.noEnviarMensajes = noEnviarMensajes;
	}

	public boolean isNoInterpretarB1FC_U2DBNRO() {
		return noInterpretarB1FC_U2DBNRO;
	}

	public void setNoInterpretarB1FC_U2DBNRO(boolean noInterpretarB1FC_U2DBNRO) {
		this.noInterpretarB1FC_U2DBNRO = noInterpretarB1FC_U2DBNRO;
	}

	public boolean isNoInterpretarHID37Bits() {
		return noInterpretarHID37Bits;
	}

	public void setNoInterpretarHID37bits(boolean noInterpretarHID37Bits) {
		this.noInterpretarHID37Bits = noInterpretarHID37Bits;
	}

	public String getHora() {
		return this.hora;
	}

	public void setHora(String aHora) {
		this.hora = aHora;
	}

	public TienePermisoCIP(ISesion aSesion) {
		this.sesion = aSesion;
	}

	public void setFecha(java.util.Date aFecha) throws BaseException {

		hora = UtilCIP.getHHMM(aFecha);
		horaEnMin = UtilCIP.getHoraEnMin(hora);
		this.fecha = UtilCIP.getTruncDate(aFecha);

	}

	public java.util.Date getFecha() {
		return this.fecha;
	}

	public int getHoraEnMin() {
		return this.horaEnMin;
	}

	private Puerta getPuerta() {
		return this.puerta;
	}

	public void setSession(ISesion aSesion) throws BaseException {
		this.sesion = aSesion;
	}

	public void setMotivoPermiso(String aMotivoPermiso) {
		this.motivoPermiso = aMotivoPermiso;
	}

	public void setPuedePasar(Boolean aPuedePasar) {
		this.puedePasar = aPuedePasar;
	}

	public ISesion getSesion() {
		return this.sesion;
	}

	public String getIdentifLegajo() {
		return this.identifLegajo;
	}

	public void setIdentifLegajo(String aIdentifLegajo) throws BaseException {
		this.identifLegajo = aIdentifLegajo;
	}

	public Legajo getLegajo() {
		return this.legajo;
	}

	public void setLegajo(Legajo aLegajo) {
		this.legajo = aLegajo;
	}

	public Visita getVisita() {
		return this.visita;
	}

	public void setVisita(Visita aVisita) {
		this.visita = aVisita;
	}

	public Integer getIdentifEquipo() {
		return this.identifEquipo;
	}

	public void setIdentifEquipo(Integer aIdentifEquipo) {
		this.identifEquipo = aIdentifEquipo;
	}

	public Integer getIdentifPtoAcceso() {
		return this.identifPtoAcceso;
	}

	public void setIdentifPtoAcceso(Integer aIdentifPtoAcceso) {
		this.identifPtoAcceso = aIdentifPtoAcceso;
	}

	public Integer getIdentifDir() {
		return this.identifDir;
	}

	public void setIdentifDir(Integer aIdentifDir) {
		this.identifDir = aIdentifDir;
	}

	private Puerta obtenerPuerta() throws BaseException {
		puerta = Puerta.getPuertaByIdentif(this.getIdentifEquipo(), this.getSesion());
		return puerta;
	}

	public boolean esEntrada() throws BaseException {
		if ((puerta.getIdentifEntrada().equals(this.getIdentifPtoAcceso().toString())) && (puerta.getDirPtoEnt().equals(this.getIdentifDir())))
			return true;
		else
			return false;
	}

	public boolean esSalida() throws BaseException {
		if ((puerta.getIdentifSal().equals(this.getIdentifPtoAcceso().toString())) && (puerta.getDirPtoSal().equals(this.getIdentifDir())))
			return true;
		else
			return false;
	}

	public void validar() throws BaseException {

		setMotivoPermiso("");

		if (obtenerPuerta() == null) {
			this.setMotivoPermiso("EQUIPO (" + this.getIdentifEquipo() + ")  NO  ESTA OPERATIVO");
			return;
		}

		if (this.esEntrada()) {
			if (this.getPuerta().getInterpretarNroEnt().equals(InterpretarNroValCIP.B1FC_U2DBNRO)) {
				if (isNoInterpretarB1FC_U2DBNRO() == false)
					this.setIdentifLegajo(InterpretarNroValCIP.getB1FCYU2BNRO(this.getIdentifLegajo()));
			} else if (this.getPuerta().getInterpretarNroEnt().equals(InterpretarNroValCIP.HID37BITS)) {
				if (isNoInterpretarHID37Bits() == false)
					this.setIdentifLegajo(InterpretarNroValCIP.getHID37Bits(this.getIdentifLegajo()));
			}
		} else if (this.esSalida()) {
			if (this.getPuerta().getInterpretarNroSal().equals(InterpretarNroValCIP.B1FC_U2DBNRO)) {
				if (isNoInterpretarB1FC_U2DBNRO() == false)
					this.setIdentifLegajo(InterpretarNroValCIP.getB1FCYU2BNRO(this.getIdentifLegajo()));
			} else if (this.getPuerta().getInterpretarNroSal().equals(InterpretarNroValCIP.HID37BITS)) {
				if (isNoInterpretarHID37Bits() == false)
					this.setIdentifLegajo(InterpretarNroValCIP.getHID37Bits(this.getIdentifLegajo()));
			}
		}

		if (esEntrada()) {
			validarEntrada();
		} else if (esSalida()) {
			validarSalida();
		} else {
			this.setMotivoPermiso("Movimiento Desconocido: " + " Equipo=" + this.getIdentifEquipo() + " Pto.Acceso=" + this.getIdentifPtoAcceso() + " Dir." + this.getIdentifDir());
			return;
		}
	}

	private Visita getBuscarVisita() throws BaseException {
		if (!this.getPuerta().getIdentifLegSal().equals(IdentificadoresDeLegajosCIP.NRO_TARJETA))
			return null;
		TarjetaCIP tarjetaCIP = TarjetaCIP.getTarjetaCIPActiva(this.getIdentifLegajo().toString(), this.getSesion());
		if (tarjetaCIP != null)
			return tarjetaCIP.getVisita();
		return null;
	}

	private Legajo getLegajoIntentoEntrada() throws BaseException {
		if (this.getPuerta().getIdentifLegEntrada().equals(IdentificadoresDeLegajosCIP.IDENTIF_LEGAJO))
			legajo = Legajo.getLegajoByIdentificacion(new Integer(this.getIdentifLegajo()), this.getSesion());
		else if (this.getPuerta().getIdentifLegEntrada().equals(IdentificadoresDeLegajosCIP.NRO_TARJETA)) {
			tarjetaLegajo = TarjetaLegajo.getTarjetaLegajo(this.getIdentifLegajo().toString(), this.getSesion());
			if (tarjetaLegajo != null)
				legajo = tarjetaLegajo.getLegajo();
		}
		return legajo;
	}

	private Legajo getLegajoIntentoSalida() throws BaseException {
		if (this.getPuerta().getIdentifLegSal().equals(IdentificadoresDeLegajosCIP.IDENTIF_LEGAJO))
			legajo = Legajo.getLegajoByIdentificacion(new Integer(this.getIdentifLegajo()), this.getSesion());
		else if (this.getPuerta().getIdentifLegSal().equals(IdentificadoresDeLegajosCIP.NRO_TARJETA)) {
			tarjetaLegajo = TarjetaLegajo.getTarjetaLegajo(this.getIdentifLegajo().toString(), this.getSesion());
			if (tarjetaLegajo != null)
				legajo = tarjetaLegajo.getLegajo();
		}
		return legajo;
	}

	private boolean esPuertaIngresoValida() throws BaseException {
		if (this.getLegajo().getGrupoPuertaIngreso() == null)
			return false;
		if (this.getLegajo().getGrupoPuertaIngreso().getGrupoPuertaDet(this.getPuerta()) != null)
			return true;
		return false;
	}

	private boolean esPuertaEgresoValida() throws BaseException {
		if (this.getLegajo().getGrupoPuertaEgreso() == null)
			return false;
		if (this.getLegajo().getGrupoPuertaEgreso().getGrupoPuertaDet(this.getPuerta()) != null)
			return true;
		return false;
	}

	public static String getMensCacheoSalida(Legajo legajo, Puerta puerta) throws BaseException {
		return "Legajo " + legajo.getNro_legajo() + " - " + legajo.getApellidoyNombre() + " saliendo por puerta " + puerta.getDescripcion() + " a CACHEO";
	}

	public static String getMensAccDenEntrada(Legajo legajo, Puerta puerta, String motivo) throws BaseException {
		String mensMotivo = "PASE NO HABILITADO";
		if ((motivo != null) && (motivo.length() > 0))
			mensMotivo = motivo;
		String descPuerta = "";
		if (puerta != null)
			descPuerta = puerta.getDescripcion();
		if (legajo != null)
			return "Legajo " + legajo.getNro_legajo() + " - " + legajo.getApellidoyNombre() + ". ACCESO DENEGADO al entrar por puerta " + descPuerta + ". Motivo: " + mensMotivo;
		else
			return "Legajo desconocido. ACCESO DENEGADO al entrar por puerta " + puerta.getDescripcion() + ". Motivo: " + mensMotivo;
	}

	public static String getMensCacheoEntrada(Legajo legajo, Puerta puerta) throws BaseException {
		return "Legajo " + legajo.getNro_legajo() + " - " + legajo.getApellidoyNombre() + " entrando por puerta " + puerta.getDescripcion() + " a CACHEO";
	}

	private void validarSalida() throws BaseException {

		java.util.Date fecHorActual = UtilCIP.getFechaHoraActual(this.getSesion());

		Legajo legajoInterno = getLegajoIntentoSalida();

		// *********************************************/
		// ** Verificar que no se trate de una visita **/
		// *********************************************/
		if (legajoInterno == null) {
			visita = getBuscarVisita();
			if (visita == null) {
				setMotivoPermiso("TARJETA DESCONOCIDA O NO ASIGNADA");
				setPuedePasar(false);
				return;
			}
			if (visita.puedeEgresarConTarj(this.getIdentifLegajo().toString(), this.getPuerta(), fecHorActual)) {
				setPuedePasar(true);
				return;
			} else {
				setPuedePasar(false);
				setMotivoPermiso(visita.getMensNoPuedeIngresar());
				return;
			}
		}

		// Obtener el Legajo
		if (legajoInterno == null) {
			setPuedePasar(false);
			this.setMotivoPermiso(IdentificadoresDeLegajosCIP.getDescripcion(this.getPuerta().getIdentifLegSal()) + " DESCONOCIDO");
			return;
		}

		/* Legajo Inactivo */
		if (!getLegajoIntentoSalida().isActivo().booleanValue()) {
			setPuedePasar(false);
			this.setMotivoPermiso("LEGAJO INACTIVO");
			return;
		}

		// Determinar si puede ingresar por dicha puerta
		if ((isPuertaAccesoPredio()) && (esPuertaEgresoValida() == false)) {
			setPuedePasar(false);
			this.setMotivoPermiso("PUERTA NO HABILITADA");
			return;
		}

		// Traer Novedades
		Iterator iterNov = NovedadPermisoCIP.getNovedadesPermisosCIP(this.getLegajo(), this.fecha, this.getSesion()).iterator();
		while (iterNov.hasNext()) {
			NovedadPermisoCIP novPermisoCIP = (NovedadPermisoCIP) iterNov.next();
			if (novPermisoCIP.getPermisoEgreso().equals(NovedadPermisoCIP.HAB_EGR)) {
				// COMENTADO EL 19-11-2013 Debido a que no esta manejando los
				// datos hora desde y hasta
				// SE VOLVIO LA HABILITACION 3-6-2014
				if (novPermisoCIP.estaEnHorario(this.getHoraEnMin())) {
					this.setPuedePasar(true);
					return;
				}
			} else if (novPermisoCIP.getPermisoEgreso().equals(NovedadPermisoCIP.DES_EGR)) {
				// COMENTADO EL 19-11-2013 Debido a que no esta manejando los
				// datos hora desde y hasta
				// SE VOLVIO LA HABILITACION 3-6-2014
				if (novPermisoCIP.estaEnHorario(this.getHoraEnMin())) {
					this.setPuedePasar(false);
					this.setMotivoPermiso(novPermisoCIP.getMotivo().getDescripcion().toUpperCase());
					return;
				}
			}
		}

		// Determinar si el estado del Legajo habilita el egreso
		if (this.getLegajo().getEstadoCIP() != null) {
			if (this.getLegajo().getEstadoCIP().isPermitirEgreso()) {
				if (isPararPorCacheoAlSalir())
					return;
				setPuedePasar(true);
				return;
			} else if (this.getLegajo().getEstadoCIP().isDenegarEgreso()) {
				setPuedePasar(false);
				this.setMotivoPermiso(this.getLegajo().getEstadoCIP().getLeyendaEgrDenegado());
				return;
			}
		}

		// Validar antipassback
		if ((this.getLegajo() != null) && (this.getLegajo().isIgnorarProxAntiPassBack() == false) && (this.getLegajo().getEstadoCIP() != null)
				&& (this.getLegajo().getEstadoCIP().isActivarAntiPassBack())) {
			if ((ActLAntiPassBack.isActivado(this.getSesion())) && (getLegajoIntentoSalida().isActivarAntiPassBack())) {
				if ((getLegajoIntentoSalida().getSentidoPaso() != null) && getLegajoIntentoSalida().getSentidoPaso().equals(MovimientoCIP.MOV_SAL_CIP)) {
					setPuedePasar(false);
					this.setMotivoPermiso("SALIDA YA REGISTRADA");
					return;
				}
			}
		}

		if (this.getPuerta().isLiberarSalida()) {
			if (isPararPorCacheoAlSalir())
				return;
			setPuedePasar(true);
			return;
		}

		Iterator iterAccIntPue = AccesoInternoPuerta.getAccesosInternosPuertasByLegajoPuerta(this.getPuerta(), this.getLegajo(), this.getSesion()).iterator();
		while (iterAccIntPue.hasNext()) {
			AccesoInternoPuerta accesoInternoPuerta = (AccesoInternoPuerta) iterAccIntPue.next();
			
			if ((accesoInternoPuerta.getPrecond_salida() != null) && (accesoInternoPuerta.getTipo_compo_sali() != null)) {

				if ((accesoInternoPuerta.getPrecond_salida().equals(AccesoInternoPuerta.PRECOND_EN_ZONA) && (accesoInternoPuerta.getTipo_compo_sali().equals(AccesoInternoPuerta.ACCION_PASE)))) {
					Iterator iterMovUltDia = MovimientoCIP.getMovimientosLegajoUltDia(legajoInterno, this.getSesion()).iterator();
					while (iterMovUltDia.hasNext()) {
						MovimientoCIP movimiento = (MovimientoCIP) iterMovUltDia.next();

						if ((movimiento.getZonaDestino() != null) && (getPuerta().getSalidaSaleDe() != null) && (movimiento.getZonaDestino().getOID() == getPuerta().getSalidaSaleDe().getOID())) {
							if(this.isPuedeSalirLegajoPorAccInt(accesoInternoPuerta)){
								setPuedePasar(true);
								return;
							} 
						}

						break;
					}
				}

				if ((accesoInternoPuerta.getPrecond_salida().equals(AccesoInternoPuerta.PRECOND_NINGUNA) && (accesoInternoPuerta.getTipo_compo_sali().equals(AccesoInternoPuerta.ACCION_PASE)))) {
					if(this.isPuedeSalirLegajoPorAccInt(accesoInternoPuerta)){
						setPuedePasar(true);
						return;
					} 
				}

				if ((accesoInternoPuerta.getPrecond_salida().equals(AccesoInternoPuerta.PRECOND_NINGUNA) && (accesoInternoPuerta.getTipo_compo_sali().equals(AccesoInternoPuerta.ACCION_DENEGADO)))) {
					this.setPuedePasar(false);
					String mens = "ACCESO NO HABILITADO";
					if (accesoInternoPuerta.getMensajeSalida() != null)
						mens = accesoInternoPuerta.getMensajeSalida();
					this.setMotivoPermiso(mens);
					return;
				}

				if ((accesoInternoPuerta.getPrecond_salida().equals(AccesoInternoPuerta.PRECOND_EN_PREDIO) && (accesoInternoPuerta.getTipo_compo_sali().equals(AccesoInternoPuerta.ACCION_PASE)))) {

					// Buscar el Ultimo Movimiento del Legajo y Verificar que no
					// sea externo
					Iterator iterMovUltDia = MovimientoCIP.getMovimientosLegajoUltDia(legajoInterno, this.getSesion()).iterator();
					while (iterMovUltDia.hasNext()) {
						MovimientoCIP movimiento = (MovimientoCIP) iterMovUltDia.next();
						if ((movimiento.getZonaDestino() != null) && (!movimiento.getZonaDestino().esExterna())) {
							// Entonces el ultimo movimiento esta en una zona
							// Interna
							if(this.isPuedeSalirLegajoPorAccInt(accesoInternoPuerta)){
								setPuedePasar(true);
								return;
							} 
						}
						// Solo me interesa procesa el primer registro
						break;
					}

				}

				if ((accesoInternoPuerta.getPrecond_salida().equals(AccesoInternoPuerta.PRECOND_EN_PREDIO) && (accesoInternoPuerta.getTipo_compo_sali().equals(AccesoInternoPuerta.ACCION_DENEGADO)))) {

					// Buscar el Ultimo Movimiento del Legajo y Verificar que
					// este en predio
					Iterator iterMovUltDia = MovimientoCIP.getMovimientosLegajoUltDia(legajoInterno, this.getSesion()).iterator();
					while (iterMovUltDia.hasNext()) {
						MovimientoCIP movimiento = (MovimientoCIP) iterMovUltDia.next();
						if ((movimiento.getZonaDestino() != null) && (!movimiento.getZonaDestino().esExterna())) {
							// Entonces el ultimo movimiento esta en una zona
							// Interna
							this.setPuedePasar(false);
							String mens = "ACCESO NO HABILITADO";
							if (accesoInternoPuerta.getMensajeSalida() != null)
								mens = accesoInternoPuerta.getMensajeSalida();
							this.setMotivoPermiso(mens);
							return;
						}
						// Solo me interesa procesa el primer registro
						break;
					}

				}

				if ((accesoInternoPuerta.getPrecond_salida().equals(AccesoInternoPuerta.PRECOND_FUERA_DE_PREDIO) && (accesoInternoPuerta.getTipo_compo_sali().equals(AccesoInternoPuerta.ACCION_PASE)))) {

					// Buscar el Ultimo Movimiento del Legajo y Verificar que
					// sea externo
					Iterator iterMovUltDia = MovimientoCIP.getMovimientosLegajoUltDia(legajoInterno, this.getSesion()).iterator();
					while (iterMovUltDia.hasNext()) {
						MovimientoCIP movimiento = (MovimientoCIP) iterMovUltDia.next();
						if ((movimiento.getZonaDestino() != null) && (movimiento.getZonaDestino().esExterna())) {
							// Entonces el ultimo movimiento esta en una zona
							// Interna
							if(this.isPuedeSalirLegajoPorAccInt(accesoInternoPuerta)){
								setPuedePasar(true);
								return;
							} 
						}
						// Solo me interesa procesa el primer registro
						break;
					}

				}

				if ((accesoInternoPuerta.getPrecond_salida().equals(AccesoInternoPuerta.PRECOND_FUERA_DE_PREDIO) && (accesoInternoPuerta.getTipo_compo_sali()
						.equals(AccesoInternoPuerta.ACCION_DENEGADO)))) {

					// Buscar el Ultimo Movimiento del Legajo y Verificar que no
					// sea externo
					Iterator iterMovUltDia = MovimientoCIP.getMovimientosLegajoUltDia(legajoInterno, this.getSesion()).iterator();
					while (iterMovUltDia.hasNext()) {
						MovimientoCIP movimiento = (MovimientoCIP) iterMovUltDia.next();
						if ((movimiento.getZonaDestino() != null) && (movimiento.getZonaDestino().esExterna())) {
							// Entonces el ultimo movimiento esta en una zona
							// Externa
							this.setPuedePasar(false);
							String mens = "ACCESO NO HABILITADO";
							if (accesoInternoPuerta.getMensajeSalida() != null)
								mens = accesoInternoPuerta.getMensajeSalida();
							this.setMotivoPermiso(mens);
							return;
						}
						// Solo me interesa procesa el primer registro
						break;
					}

				}
			}

		}

		// Se agrego el 9-06-2014
		// Para contemplar el caso que un empleado salga un dia posterior y
		// pueda segun su rota
		
		if (isPuertaEgresoPredio()) {
			
			java.util.Date fecDiaAnt = Fecha.getFechaDiaAnterior(fecha);
	
			LegajoRotaFecha legRotaFecha = legajo.getLegajoRotaFecha(fecha);
			LegajoRotaFecha legRotaFechaDiaAnt = legajo.getLegajoRotaFecha(fecDiaAnt);
	
			if ((legRotaFechaDiaAnt != null) && (legRotaFechaDiaAnt.getRota().isEgresoSegunHorario())) {
	
				if (legRotaFechaDiaAnt.getRota().isPuedeEgresarSegunHorario(fecDiaAnt, fecHorActual, legRotaFechaDiaAnt.getRota().getMin_sal_antes(), legRotaFechaDiaAnt.getRota().getMin_sal_despues())) {
	
					if (isPararPorCacheoAlSalir())
						return;
					this.setPuedePasar(true);
					return;
	
				} else if (legRotaFecha != null && legRotaFecha.getRota() != null && legRotaFecha.getRota().isRotaFranco()) {
					this.setPuedePasar(false);
					this.setMotivoPermiso(legRotaFechaDiaAnt.getRota().getLeyendaNoEgresa());
					return;
				}
	
			}
	
			// Traer Planificacion Rota por Fecha
			if (legRotaFecha != null) {
				if (legRotaFecha.getRota().isPermiteEgreso()) {
					if (isPararPorCacheoAlSalir())
						return;
					this.setPuedePasar(true);
					return;
				} else if (legRotaFecha.getRota().isEgresoDenegado()) {
					this.setPuedePasar(false);
					this.setMotivoPermiso(legRotaFecha.getRota().getLeyendaNoEgresa());
					return;
				} else if (legRotaFecha.getRota().isEgresoSegunHorario()) {
					if (legRotaFecha.getRota().isPuedeEgresarEnHorario(this.getHoraEnMin())) {
						// Verificar cacheo
						if (isPararPorCacheoAlSalir())
							return;
						this.setPuedePasar(true);
					} else {
						this.setPuedePasar(false);
						this.setMotivoPermiso(legRotaFecha.getRota().getLeyendaNoEgresa());
					}
					return;
				}
			}
	
			// Planificacion de la Semana
			if (this.getLegajo().getPermisoSemanal() != null) {
	
				int dia = Fecha.getDiaSemana(this.fecha);
				String tipoPermiso = this.getLegajo().getPermisoSemanal().getTipoPermisoSemanalSal(dia);
				if (tipoPermiso.equals(TiposSalidasRotas.LIBRE)) {
					// Verificar cacheo
					if (isPararPorCacheoAlSalir())
						return;
					this.setPuedePasar(true);
					return;
				} else if (tipoPermiso.equals(TiposSalidasRotas.NO_EGRESA)) {
					this.setPuedePasar(false);
					this.setMotivoPermiso(this.getLegajo().getPermisoSemanal().getLeyendaNoEgresa(dia));
					return;
				} else if (tipoPermiso.equals(TiposSalidasRotas.SEGUN_HORARIO)) {
					if (this.getLegajo().getPermisoSemanal().isPuedeEgresar(dia, this.getHoraEnMin())) {
						// Verificar *
						if (isPararPorCacheoAlSalir())
							return;
						this.setPuedePasar(true);
						return;
					} else {
						this.setPuedePasar(false);
						this.setMotivoPermiso(this.getLegajo().getPermisoSemanal().getLeyendaNoEgresa(dia));
						return;
					}
				}
	
			}
		}

	}

	private boolean isPararPorCacheoAlSalir() throws BaseException {

		if (!ActCacheo.isActivado(this.getSesion()))
			return false;

		if (!(this.getLegajo().isParaCacheoSalida(this.getPuerta(), this.fecha, !this.isNoEnviarMensajes())))
			return false;

		if (this.getPuerta().isControlCacheoSal() && this.getPuerta().isNoPermitirEgresoEnCacheo()) {
			this.setPuedePasar(false);
			this.setMotivoPermiso(TienePermisoCIP.getMotivoCacheo(this.getSesion()));

			if (!this.isNoEnviarMensajes())
				MotorMensONLINE.getMotor().enviar(
						MensajeONLINE.getNewMensajeONLINE(MensajeONLINE.TM_ONLINE, getMensCacheoSalida(this.getLegajo(), this.getPuerta()), this.getPuerta().getUsuariosAvisoCacheo(), this.getPuerta()
								.getMaquinasAvisoCacheo(), true, this.getLegajo().getNro_legajo() + ".jpg", Legajo.getPathImagenesLegajo(this.getSesion()), 100, 100, Ring.getIDRingCacheo(this
								.getSesion()), Ring.getPathArchivos(this.getSesion()), "TFAccesoPorLegajo", this.getLegajo().getOIDInteger(), "TraerLegajo"));

			return true;
		} else {
			this.setMotivoPermiso(TienePermisoCIP.getMotivoCacheo(this.getSesion()));

			if (!this.isNoEnviarMensajes())
				MotorMensONLINE.getMotor().enviar(
						MensajeONLINE.getNewMensajeONLINE(MensajeONLINE.TM_ONLINE, getMensCacheoSalida(this.getLegajo(), this.getPuerta()), this.getPuerta().getUsuariosAvisoCacheo(), this.getPuerta()
								.getMaquinasAvisoCacheo(), true, this.getLegajo().getNro_legajo() + ".jpg", Legajo.getPathImagenesLegajo(this.getSesion()), 100, 100, Ring.getIDRingCacheo(this
								.getSesion()), Ring.getPathArchivos(this.getSesion()), "TFAccesoPorLegajo", this.getLegajo().getOIDInteger(), "TraerLegajo"));

			return false;
		}

	}

	private boolean isTarjetaHabilitada() throws BaseException {

		return true;

	}

	private boolean isPararPorCacheoAlEntrar(AccesoValClasif accesoValClasif) throws BaseException {

		if (!ActCacheo.isActivado(this.getSesion()))
			return false;

		if (this.getPuerta().isControlCacheoEnt() == false) {
			return false;
		}

		if (!(this.getLegajo().isParaCacheoEntrada(this.getPuerta(), this.fecha, !this.isNoEnviarMensajes())))
			return false;

		// Comentado 11/01/2012 PORQUE ME PARECE QUE SI ESTA PLANIFICADO VA A
		// CACHEO

		/*
		 * if ((this.getLegajo() != null) &&
		 * (this.getLegajo().isCircuitoCacheo() == false) &&
		 * (this.getLegajo().getEstadoCIP() != null) &&
		 * (this.getLegajo().getEstadoCIP().isSusceptibleCacheo() == false))
		 * return false;
		 * 
		 * if ((this.getLegajo() != null) &&
		 * (this.getLegajo().isCircuitoCacheo() == false) &&
		 * (accesoValClasif!=null) && (accesoValClasif.isCacheo()==false))
		 * return false;
		 */

		if (this.getPuerta().isNoPermitirIngresoEnCacheo()) {
			this.setPuedePasar(false);
			this.setMotivoPermiso(TienePermisoCIP.getMotivoCacheo(this.getSesion()));

			if (!this.isNoEnviarMensajes())
				MotorMensONLINE.getMotor().enviar(
						MensajeONLINE.getNewMensajeONLINE(MensajeONLINE.TM_ONLINE, getMensCacheoEntrada(this.getLegajo(), this.getPuerta()), this.getPuerta().getUsuariosAvisoCacheo(), this
								.getPuerta().getMaquinasAvisoCacheo(), true, this.getLegajo().getNro_legajo() + ".jpg", Legajo.getPathImagenesLegajo(this.getSesion()), 100, 100, Ring
								.getIDRingCacheo(this.getSesion()), Ring.getPathArchivos(this.getSesion()), "TFAccesoPorLegajo", this.getLegajo().getOIDInteger(), "TraerLegajo"));

			return true;
		} else {
			this.setMotivoPermiso(TienePermisoCIP.getMotivoCacheo(this.getSesion()));

			if (!this.isNoEnviarMensajes())
				MotorMensONLINE.getMotor().enviar(
						MensajeONLINE.getNewMensajeONLINE(MensajeONLINE.TM_ONLINE, getMensCacheoEntrada(this.getLegajo(), this.getPuerta()), this.getPuerta().getUsuariosAvisoCacheo(), this
								.getPuerta().getMaquinasAvisoCacheo(), true, this.getLegajo().getNro_legajo() + ".jpg", Legajo.getPathImagenesLegajo(this.getSesion()), 100, 100, Ring
								.getIDRingCacheo(this.getSesion()), Ring.getPathArchivos(this.getSesion()), "TFAccesoPorLegajo", this.getLegajo().getOIDInteger(), "TraerLegajo"));

			return false;
		}

	}

	private boolean isPuertaAccesoPredio() throws BaseException {
		if ((this.getPuerta() != null) && (this.getPuerta().isIngresoAlPredio()))
			return true;
		else
			return false;
	}
	
	private boolean isPuertaEgresoPredio() throws BaseException {
		if ((this.getPuerta() != null) && (this.getPuerta().isEgresoDelPredio()))
			return true;
		else
			return false;
	}

	private boolean isPuertaAccesoInterno() throws BaseException {
		if ((this.getPuerta() != null) && (this.getPuerta().isIngresoAlPredio() == false))
			return true;
		else
			return false;
	}

	private void validarEntrada() throws BaseException {

		boolean anulaRotaDelDia = false;
		boolean validarAntiPBValClasif = false;
		boolean validarCacheoValClasif = false;

		int minEntAntesBase = 0;
		int minEntDespuesBase = 0;

		int minEntAntesHoy = 0;
		int minEntDespuesHoy = 0;

		int minEntAntesAyer = 0;
		int minEntDespuesAyer = 0;

		int minEntAntesManiana = 0;
		int minEntDespuesManiana = 0;

		java.util.Date fecHorActual = UtilCIP.getFechaHoraActual(this.getSesion());

		java.util.Date fecDiaAnt = Fecha.getFechaDiaAnterior(fecha);
		java.util.Date fecDiaPost = Fecha.getFechaDiaPosterior(fecha);

		// ***********************/
		// ** Obtener el Legajo **/
		// ***********************/
		Legajo legajoInterno = getLegajoIntentoEntrada();
		if (legajoInterno != null)
			legajoInterno.supportRefresh();

		// *********************************************/
		// ** Verificar que no se trate de una visita **/
		// *********************************************/
		if (legajoInterno == null) {
			visita = getVisita();
			if (visita == null) {
				setMotivoPermiso("TARJETA DESCONOCIDA");
				if (this.getPuerta().getIdentifLegEntrada().equals(IdentificadoresDeLegajosCIP.NRO_TARJETA)) {
					TarjetaCIP tarjEnc = TarjetaCIP.getTarjetaCIP(this.getIdentifLegajo().toString(), this.getSesion());
					if (tarjEnc != null) {
						if (tarjEnc.isActivo())
							this.setMotivoPermiso("TARJETA SIN ASIGNAR");
						else
							this.setMotivoPermiso("TARJETA INHABILITADA");
					}
				}
				setPuedePasar(false);
				return;
			}
			if (visita.puedeIngresarConTarj(this.getIdentifLegajo().toString(), this.getPuerta(), fecHorActual)) {
				setPuedePasar(true);
				return;
			} else {
				setPuedePasar(false);
				setMotivoPermiso(visita.getMensNoPuedeIngresar());
				return;
			}
		}

		// ***********************/
		// ** SI NO SE ENCONTRO **/
		// ***********************/
		if (legajoInterno == null) {
			setPuedePasar(false);

			this.setMotivoPermiso(IdentificadoresDeLegajosCIP.getDescripcion(this.getPuerta().getIdentifLegEntrada()) + " DESCONOCIDO");
			if (this.getPuerta().getIdentifLegEntrada().equals(IdentificadoresDeLegajosCIP.NRO_TARJETA)) {
				TarjetaCIP tarjEnc = TarjetaCIP.getTarjetaCIP(this.getIdentifLegajo().toString(), this.getSesion());
				if (tarjEnc != null) {
					if (tarjEnc.isActivo())
						this.setMotivoPermiso("TARJETA SIN ASIGNAR");
					else
						this.setMotivoPermiso("TARJETA INHABILITADA");
				}
			}

			if ((!this.isNoEnviarMensajes()) && (this.getPuerta() != null) && (this.getPuerta().isActAviAccDenegado()))
				MotorMensONLINE.getMotor().enviar(
						MensajeONLINE.getNewMensajeONLINE(MensajeONLINE.TM_ONLINE, getMensAccDenEntrada(null, this.getPuerta(), this.getMotivoPermiso()), this.getPuerta().getUsuariosAvisoAccDen(),
								this.getPuerta().getMaquinasAvisoAccDen(), true, null, Legajo.getPathImagenesLegajo(this.getSesion()), 100, 100, Ring.getIDRingAccesoDenegado(this.getSesion()),
								Ring.getPathArchivos(this.getSesion()), "TFAccesoPorLegajo", 0, "encontrarLegajo"));
			return;
		}

		/*****************************/
		/* Verificar Legajo Interno */
		/*****************************/

		if ((legajoInterno != null) && (this.getPuerta() != null)) {
			if (legajoInterno.isProhibirAcceso() == true) {
				setPuedePasar(false);
				this.setMotivoPermiso("ACCESO PROHIBIDO");
				if (!this.isNoEnviarMensajes())
					MotorMensONLINE.getMotor().enviar(
							MensajeONLINE.getNewMensajeONLINE(MensajeONLINE.TM_ONLINE, getMensAccDenEntrada(legajoInterno, this.getPuerta(), "ACCESO PROHIBIDO"), this.getPuerta()
									.getUsuariosAvisoAccDen(), this.getPuerta().getMaquinasAvisoAccDen(), true, legajoInterno.getNro_legajo() + ".jpg", Legajo.getPathImagenesLegajo(this.getSesion()),
									100, 100, Ring.getIDRingAccesoDenegado(this.getSesion()), Ring.getPathArchivos(this.getSesion()), "TFAccesoPorLegajo", legajoInterno.getOIDInteger(),
									"encontrarLegajo"));
				return;
			}
		}

		/***********************************************/
		/* Obtener los minutos entrada antes y despues */
		/***********************************************/
		if ((legajoInterno != null) && (isPuertaAccesoPredio())) {

			Iterator iterClasifLeg = legajoInterno.getClasifEntidadesActivas().iterator();
			while (iterClasifLeg.hasNext()) {
				ClasificadorEntidad clasifLeg = (ClasificadorEntidad) iterClasifLeg.next();
				ValorClasificadorEntidad valorClasifLeg = legajoInterno.getValorClasifEntProxy(clasifLeg);

				if (valorClasifLeg == null)
					continue;

				AccesoValClasif accesoValClasif = AccesoValClasif.getAccesoValClasif(valorClasifLeg, this.getSesion());

				if (accesoValClasif != null) {

					if ((accesoValClasif.getMin_ent_antes() != null) && (accesoValClasif.getMin_ent_antes() > minEntAntesBase))
						minEntAntesBase = accesoValClasif.getMin_ent_antes();

					if ((accesoValClasif.getMin_ent_despues() != null) && (accesoValClasif.getMin_ent_despues() > minEntDespuesBase))
						minEntDespuesBase = accesoValClasif.getMin_ent_despues();

					if (accesoValClasif.isAntipassback())
						validarAntiPBValClasif = true;

					if (accesoValClasif.isCacheo())
						validarCacheoValClasif = true;

				}

			}

			if (legajoInterno.getEstadoCIP() != null) {

				if (legajoInterno.getEstadoCIP().getMinEntAntEntrada() > minEntAntesBase)
					minEntAntesBase = legajoInterno.getEstadoCIP().getMinEntAntEntrada();

				if (legajoInterno.getEstadoCIP().getMinEntDesEntrada() > minEntDespuesBase)
					minEntDespuesBase = legajoInterno.getEstadoCIP().getMinEntDesEntrada();

			}

			minEntAntesHoy = minEntAntesBase;
			minEntDespuesHoy = minEntDespuesBase;

			minEntAntesAyer = minEntAntesBase;
			minEntDespuesAyer = minEntDespuesBase;

			minEntAntesManiana = minEntAntesBase;
			minEntDespuesManiana = minEntDespuesBase;

			int tempMinEntAntes = NovedadPermisoCIP.getMaximoMinEntAntes(this.fecha, legajoInterno, this.getSesion());
			int tempMinEntDespues = NovedadPermisoCIP.getMaximoMinEntDespues(this.fecha, legajoInterno, this.getSesion());
			if (tempMinEntAntes > minEntAntesHoy)
				minEntAntesHoy = tempMinEntAntes;
			if (tempMinEntDespues > minEntDespuesHoy)
				minEntDespuesHoy = tempMinEntDespues;

			tempMinEntAntes = NovedadPermisoCIP.getMaximoMinEntAntes(fecDiaAnt, legajoInterno, this.getSesion());
			tempMinEntDespues = NovedadPermisoCIP.getMaximoMinEntDespues(fecDiaAnt, legajoInterno, this.getSesion());
			if (tempMinEntAntes > minEntAntesAyer)
				minEntAntesAyer = tempMinEntAntes;
			if (tempMinEntDespues > minEntDespuesAyer)
				minEntDespuesAyer = tempMinEntDespues;

			tempMinEntAntes = NovedadPermisoCIP.getMaximoMinEntAntes(fecDiaPost, legajoInterno, this.getSesion());
			tempMinEntDespues = NovedadPermisoCIP.getMaximoMinEntDespues(fecDiaPost, legajoInterno, this.getSesion());
			if (tempMinEntAntes > minEntAntesManiana)
				minEntAntesManiana = tempMinEntAntes;
			if (tempMinEntDespues > minEntDespuesManiana)
				minEntDespuesManiana = tempMinEntDespues;

		}

		// *************************************************//
		// *** Fijarse si la puerta se encuentra restringida **/
		// *************************************************//

		if ((this.getPuerta() != null) && this.getPuerta().isRentringirEnt()) {
			setPuedePasar(false);
			this.setMotivoPermiso("PUERTA ACCESO RESTRINGIDO");
			if ((!this.isNoEnviarMensajes()) && (this.getPuerta() != null) && (this.getPuerta().isActAviAccDenegado()))
				MotorMensONLINE
						.getMotor()
						.enviar(MensajeONLINE.getNewMensajeONLINE(MensajeONLINE.TM_ONLINE, getMensAccDenEntrada(legajoInterno, this.getPuerta(), this.getMotivoPermiso()), this.getPuerta()
								.getUsuariosAvisoAccDen(), this.getPuerta().getMaquinasAvisoAccDen(), true, legajoInterno.getNro_legajo() + ".jpg", Legajo.getPathImagenesLegajo(this.getSesion()),
								100, 100, Ring.getIDRingAccesoDenegado(this.getSesion()), Ring.getPathArchivos(this.getSesion()), "TFAccesoPorLegajo", legajoInterno.getOIDInteger(), "encontrarLegajo"));
			return;
		}

		// *******************************************************/
		// ** Verificar si la puerta se encuentra deshabilitada **/
		// *******************************************************/
		if (isPuertaAccesoPredio()) {
			if (esPuertaIngresoValida() == false) {
				setPuedePasar(false);
				this.setMotivoPermiso("PUERTA NO HABILITADA");
				if ((!this.isNoEnviarMensajes()) && (this.getPuerta() != null) && (this.getPuerta().isActAviAccDenegado()))
					MotorMensONLINE.getMotor().enviar(
							MensajeONLINE.getNewMensajeONLINE(MensajeONLINE.TM_ONLINE, getMensAccDenEntrada(legajoInterno, this.getPuerta(), this.getMotivoPermiso()), this.getPuerta()
									.getUsuariosAvisoAccDen(), this.getPuerta().getMaquinasAvisoAccDen(), true, legajoInterno.getNro_legajo() + ".jpg", Legajo.getPathImagenesLegajo(this.getSesion()),
									100, 100, Ring.getIDRingAccesoDenegado(this.getSesion()), Ring.getPathArchivos(this.getSesion()), "TFAccesoPorLegajo", legajoInterno.getOIDInteger(),
									"encontrarLegajo"));
				return;
			}
		}

		/****************************************/
		/** Verificar si se encuentra inactivo **/
		/****************************************/
		if (!legajoInterno.isActivo().booleanValue()) {
			setPuedePasar(false);
			this.setMotivoPermiso("LEGAJO INACTIVO");
			if ((!this.isNoEnviarMensajes()) && (this.getPuerta() != null) && (this.getPuerta().isActAviAccDenegado()))
				MotorMensONLINE
						.getMotor()
						.enviar(MensajeONLINE.getNewMensajeONLINE(MensajeONLINE.TM_ONLINE, getMensAccDenEntrada(legajoInterno, this.getPuerta(), this.getMotivoPermiso()), this.getPuerta()
								.getUsuariosAvisoAccDen(), this.getPuerta().getMaquinasAvisoAccDen(), true, legajoInterno.getNro_legajo() + ".jpg", Legajo.getPathImagenesLegajo(this.getSesion()),
								100, 100, Ring.getIDRingAccesoDenegado(this.getSesion()), Ring.getPathArchivos(this.getSesion()), "TFAccesoPorLegajo", legajoInterno.getOIDInteger(), "encontrarLegajo"));

			return;
		}

		/************************************************************************/
		// ** Verificar que si la tarjeta esta activada y se encuentra vigente
		// **/
		/************************************************************************/
		if ((this.getPuerta() != null) && (this.getPuerta().getIdentifLegEntrada() != null) && (this.getPuerta().getIdentifLegEntrada().equals(IdentificadoresDeLegajosCIP.NRO_TARJETA))) {
			TarjetaCIP tarjetaCIP = TarjetaCIP.getTarjetaCIP(this.getIdentifLegajo().toString(), this.getSesion());

			if (tarjetaCIP != null) {
				// Validar que la terjeta NO esta deshabiloitada
				if (tarjetaCIP.isTarjetaDesHabilitada()) {
					this.setPuedePasar(false);
					this.setMotivoPermiso("TARJETA INHABILITADA");
					if ((!this.isNoEnviarMensajes()) && (this.getPuerta() != null) && (this.getPuerta().isActAviAccDenegado()))
						MotorMensONLINE.getMotor().enviar(
								MensajeONLINE.getNewMensajeONLINE(MensajeONLINE.TM_ONLINE, getMensAccDenEntrada(legajoInterno, this.getPuerta(), this.getMotivoPermiso()), this.getPuerta()
										.getUsuariosAvisoAccDen(), this.getPuerta().getMaquinasAvisoAccDen(), true, legajoInterno.getNro_legajo() + ".jpg", Legajo.getPathImagenesLegajo(this
										.getSesion()), 100, 100, Ring.getIDRingAccesoDenegado(this.getSesion()), Ring.getPathArchivos(this.getSesion()), "TFAccesoPorLegajo", legajoInterno
										.getOIDInteger(), "encontrarLegajo"));
					return;
				}
				// Si tiene vigencia verificar que se encuentra entros dos
				// fechas validas
				if (tarjetaCIP.isTiene_vig()) {
					if ((tarjetaCIP.getVig_desde() != null) && (tarjetaCIP.getVig_hasta() != null) && (tarjetaCIP.getHora_desde() != null) && (tarjetaCIP.getHora_hasta() != null)) {

						// Determinar si la fecha hora actual se encuentra
						// dentro de la vigencia
						int hora1 = UtilCIP.getParteHoraEnHoras(tarjetaCIP.getHora_desde());
						int minuto1 = UtilCIP.getParteMinutosEnMinutos(tarjetaCIP.getHora_desde());

						int hora2 = UtilCIP.getParteHoraEnHoras(tarjetaCIP.getHora_hasta());
						int minuto2 = UtilCIP.getParteMinutosEnMinutos(tarjetaCIP.getHora_hasta());

						Calendar calFecVigDesde = GregorianCalendar.getInstance();
						calFecVigDesde.setTime(tarjetaCIP.getVig_desde());
						calFecVigDesde.set(Calendar.HOUR_OF_DAY, hora1); //
						calFecVigDesde.set(Calendar.MINUTE, minuto1); //
						calFecVigDesde.set(Calendar.SECOND, 0); //
						calFecVigDesde.set(Calendar.MILLISECOND, 0);

						Calendar calFecVigHasta = GregorianCalendar.getInstance();
						calFecVigHasta.setTime(tarjetaCIP.getVig_hasta());
						calFecVigHasta.set(Calendar.HOUR_OF_DAY, hora2);
						calFecVigHasta.set(Calendar.MINUTE, minuto2);
						calFecVigHasta.set(Calendar.SECOND, 0);
						calFecVigHasta.set(Calendar.MILLISECOND, 0);

						if (!Fecha.isFechaEntre(fecHorActual, calFecVigDesde.getTime(), calFecVigHasta.getTime())) {
							this.setPuedePasar(false);
							this.setMotivoPermiso("TARJETA NO VIGENTE");
							if ((!this.isNoEnviarMensajes()) && (this.getPuerta() != null) && (this.getPuerta().isActAviAccDenegado()))
								MotorMensONLINE.getMotor().enviar(
										MensajeONLINE.getNewMensajeONLINE(MensajeONLINE.TM_ONLINE, getMensAccDenEntrada(legajoInterno, this.getPuerta(), this.getMotivoPermiso()), this.getPuerta()
												.getUsuariosAvisoAccDen(), this.getPuerta().getMaquinasAvisoAccDen(), true, legajoInterno.getNro_legajo() + ".jpg", Legajo.getPathImagenesLegajo(this
												.getSesion()), 100, 100, Ring.getIDRingAccesoDenegado(this.getSesion()), Ring.getPathArchivos(this.getSesion()), "TFAccesoPorLegajo", legajoInterno
												.getOIDInteger(), "encontrarLegajo"));
							return;
						}

					}
				}
			}
		}

		// *********************************************/
		// ** Verificar si tiene liberada la entrada **/
		// *********************************************/

		// if ((this.getPuerta()!=null) &&
		// (this.getPuerta().isIngresoAlPredio() &&
		// (legajoInterno.isLiberarIngAlPredio()))) {
		// this.setPuedePasar(true);
		// return;
		// }

		/*******************************************************************************/
		/*
		 * 22/11/2011 Se modificaron los Motivos para que contemple el Grupo de
		 * Puertas
		 */
		/*******************************************************************************/

		if (NovedadPermisoCIP.getNovedadesPermisosCIPAnuRota(legajoInterno, this.fecha, this.getSesion()).size() > 0)
			anulaRotaDelDia = true;

		// Aplicar las Novedades
		Iterator iterNov = NovedadPermisoCIP.getNovedadesPermisosCIP(legajoInterno, this.fecha, this.getSesion()).iterator();

		while (iterNov.hasNext()) {

			NovedadPermisoCIP novPermisoCIP = (NovedadPermisoCIP) iterNov.next();

			// Buscar si el grupo de puertas incluye la puerta actual
			GrupoPuertaDet grupoPuertaDet = null;
			if ((this.getPuerta() != null) && (novPermisoCIP.getGrupo_puerta() != null))
				grupoPuertaDet = GrupoPuertaDet.getGrupoPuertaDet(novPermisoCIP.getGrupo_puerta(), this.getPuerta(), this.getSesion());

			// El motivo no aplica a la puerta en cuestion
			if (grupoPuertaDet == null)
				continue;

			if (novPermisoCIP.getPermisoIngreso().equals(NovedadPermisoCIP.HAB_ING)) {
				if (novPermisoCIP.estaEnHorario(this.getHoraEnMin())) {
					this.setPuedePasar(true);
					return;
				}
			} else if (novPermisoCIP.getPermisoIngreso().equals(NovedadPermisoCIP.DES_ING)) {

				// A no ser que pueda ingresar por una rota del dia anterior o
				// posterior
				boolean ignorarDesIng = false;

				if (isPuertaAccesoPredio()) {

					if (legajoInterno.getPermisoSemanal() != null) {

						int diaPS = Fecha.getDiaSemana(this.fecha);
						java.util.Date fecDiaAntPS = Fecha.getFechaDiaAnterior(this.fecha);
						java.util.Date fecDiaPosPS = Fecha.getFechaDiaPosterior(this.fecha);
						int diaAnteriorPS = diaPS - 1;
						if (diaAnteriorPS == 0)
							diaAnteriorPS = 7;
						int diaPosteriorPS = diaPS + 1;
						if (diaPosteriorPS == 8)
							diaPosteriorPS = 1;

						String tipoPermisoAnt = legajoInterno.getPermisoSemanal().getTipoPermisoSemanalEnt(diaAnteriorPS);
						if ((tipoPermisoAnt != null) && (tipoPermisoAnt.equals(TiposEntradasRotas.SEGUN_HORARIO))) {

							if (legajoInterno.getPermisoSemanal().isPuedeIngresar(diaAnteriorPS, fecDiaAntPS, fecHorActual, minEntAntesAyer, minEntDespuesAyer)) {

								if (NovedadPermisoCIP.getNovedadesPermisosCIPAnuRota(legajoInterno, fecDiaAntPS, this.getSesion()).size() == 0)
									ignorarDesIng = true;

							}

							if (legajoInterno.puedeIngresarEntIntermedias(fecHorActual, legajoInterno.getPermisoSemanal(), fecDiaAntPS)) {

								if (NovedadPermisoCIP.getNovedadesPermisosCIPAnuRota(legajoInterno, fecDiaAntPS, this.getSesion()).size() == 0)
									ignorarDesIng = true;

							}

						}

						String tipoPermisoPos = legajoInterno.getPermisoSemanal().getTipoPermisoSemanalEnt(diaPosteriorPS);
						if ((tipoPermisoPos != null) && (tipoPermisoPos.equals(TiposEntradasRotas.SEGUN_HORARIO))) {

							if (legajoInterno.getPermisoSemanal().isPuedeIngresar(diaPosteriorPS, fecDiaPosPS, fecHorActual, minEntAntesManiana, minEntDespuesManiana)) {

								if (NovedadPermisoCIP.getNovedadesPermisosCIPAnuRota(legajoInterno, fecDiaPosPS, this.getSesion()).size() == 0)
									ignorarDesIng = true;

							}

							if (legajoInterno.puedeIngresarEntIntermedias(fecHorActual, legajoInterno.getPermisoSemanal(), fecDiaPosPS)) {

								if (NovedadPermisoCIP.getNovedadesPermisosCIPAnuRota(legajoInterno, fecDiaPosPS, this.getSesion()).size() == 0)
									ignorarDesIng = true;

							}

						}

					}

					LegajoRotaFecha legRotaFechaDiaAnt = legajo.getLegajoRotaFecha(fecDiaAnt);
					if ((legRotaFechaDiaAnt != null) && (legRotaFechaDiaAnt.getRota().isSegunHorario())) {

						if (legRotaFechaDiaAnt.getRota().isPuedeIngresarSegunHorario(fecDiaAnt, fecHorActual, minEntAntesAyer, minEntDespuesAyer)) {

							if (NovedadPermisoCIP.getNovedadesPermisosCIPAnuRota(legajoInterno, fecDiaAnt, this.getSesion()).size() == 0)
								ignorarDesIng = true;

						}
						if (puedeIngresarEntIntermedias(fecHorActual, legajo, legRotaFechaDiaAnt)) {

							if (NovedadPermisoCIP.getNovedadesPermisosCIPAnuRota(legajoInterno, fecDiaAnt, this.getSesion()).size() == 0)
								ignorarDesIng = true;

							ignorarDesIng = true;
						}

					}

					// Verificar si puede ingresar por la rota del dia posterior
					LegajoRotaFecha legRotaFechaDiaPost = legajo.getLegajoRotaFecha(fecDiaPost);
					if ((legRotaFechaDiaPost != null) && (legRotaFechaDiaPost.getRota().isSegunHorario())) {
						if (legRotaFechaDiaPost.getRota().isPuedeIngresarSegunHorario(fecDiaPost, fecHorActual, minEntAntesManiana, minEntDespuesManiana)) {

							if (NovedadPermisoCIP.getNovedadesPermisosCIPAnuRota(legajoInterno, fecDiaPost, this.getSesion()).size() == 0)
								ignorarDesIng = true;

						}
						if (puedeIngresarEntIntermedias(fecHorActual, legajo, legRotaFechaDiaPost)) {

							if (NovedadPermisoCIP.getNovedadesPermisosCIPAnuRota(legajoInterno, fecDiaPost, this.getSesion()).size() == 0)
								ignorarDesIng = true;

						}

					}

				}

				if ((ignorarDesIng == false) && (novPermisoCIP.estaEnHorario(this.getHoraEnMin()))) {
					this.setPuedePasar(false);
					this.setMotivoPermiso(novPermisoCIP.getMotivo().getDescripcion().toUpperCase());
					if ((!this.isNoEnviarMensajes()) && (this.getPuerta() != null) && (this.getPuerta().isActAviAccDenegado()))
						MotorMensONLINE.getMotor().enviar(
								MensajeONLINE.getNewMensajeONLINE(MensajeONLINE.TM_ONLINE, getMensAccDenEntrada(legajoInterno, this.getPuerta(), this.getMotivoPermiso()), this.getPuerta()
										.getUsuariosAvisoAccDen(), this.getPuerta().getMaquinasAvisoAccDen(), true, legajoInterno.getNro_legajo() + ".jpg", Legajo.getPathImagenesLegajo(this
										.getSesion()), 100, 100, Ring.getIDRingAccesoDenegado(this.getSesion()), Ring.getPathArchivos(this.getSesion()), "TFAccesoPorLegajo", legajoInterno
										.getOIDInteger(), "encontrarLegajo"));
					return;
				}

			} else if (novPermisoCIP.getPermisoIngreso().equals(NovedadPermisoCIP.NA_ING)) {

				if ((novPermisoCIP.getMotivo() != null) && (novPermisoCIP.getMotivo().getCompoExtIngreso().equals(TiposEntradasRotas.SEGUN_HORARIO))) {

					// if
					// (novPermisoCIP.getMotivo().getMinEntAnt().intValue()>minEntAntes)
					// minEntAntes = novPermisoCIP.getMotivo().getMinEntAnt();

					// if
					// (novPermisoCIP.getMotivo().getMinEntDes().intValue()>minEntDespues)
					// minEntDespues = novPermisoCIP.getMotivo().getMinEntDes();
				}

			}
		}

		/************************************************************************/
		// Verificar segun el estado de Acceso si puede o no ingresar al Predio
		/************************************************************************/

		if (isPuertaAccesoPredio()) {
			if ((legajoInterno.getEstadoCIP() != null)) {
				if (legajoInterno.getEstadoCIP().isPermitirIngreso()) {
					// Validar si tiene activado el ANTIPASBACK

					if ((legajoInterno != null) && (validarAntiPassback(legajoInterno, validarAntiPBValClasif)))
						return;

					if (isPararPorCacheoAlEntrar(null))
						return;

					setPuedePasar(true);
					return;

				} else if (legajoInterno.getEstadoCIP().isDenegarIngreso()) {
					setPuedePasar(false);
					this.setMotivoPermiso(legajoInterno.getEstadoCIP().getLeyendaIngDenegado());
					if ((!this.isNoEnviarMensajes()) && (this.getPuerta() != null) && (this.getPuerta().isActAviAccDenegado()))
						MotorMensONLINE.getMotor().enviar(
								MensajeONLINE.getNewMensajeONLINE(MensajeONLINE.TM_ONLINE, getMensAccDenEntrada(legajoInterno, this.getPuerta(), this.getMotivoPermiso()), this.getPuerta()
										.getUsuariosAvisoAccDen(), this.getPuerta().getMaquinasAvisoAccDen(), true, legajoInterno.getNro_legajo() + ".jpg", Legajo.getPathImagenesLegajo(this
										.getSesion()), 100, 100, Ring.getIDRingAccesoDenegado(this.getSesion()), Ring.getPathArchivos(this.getSesion()), "TFAccesoPorLegajo", legajoInterno
										.getOIDInteger(), "encontrarLegajo"));
					return;
				}
			}
		}

		/********************************************************************************/
		/***
		 * Verificar si puede acceder por el estado de los valores del
		 * clasificador
		 ***/
		/********************************************************************************/

		if (isPuertaAccesoPredio()) {

			if ((legajoInterno.getEstadoCIP() == null) || (legajoInterno.getEstadoCIP().isIngresoSegunPlanif())) {
				// Verificar los Valores de clasificadores haber si tienen algo
				// configurado
				Iterator iterClasifLeg = legajoInterno.getClasifEntidadesActivas().iterator();
				while (iterClasifLeg.hasNext()) {
					ClasificadorEntidad clasifLeg = (ClasificadorEntidad) iterClasifLeg.next();
					ValorClasificadorEntidad valorClasifLeg = legajoInterno.getValorClasifEntProxy(clasifLeg);

					if (valorClasifLeg == null)
						continue;

					AccesoValClasif accesoValClasif = AccesoValClasif.getAccesoValClasif(valorClasifLeg, this.getSesion());

					if (accesoValClasif != null) {

						// if ((accesoValClasif.getMin_ent_antes()!=null) &&
						// (accesoValClasif.getMin_ent_antes()>minEntAntes))
						// minEntAntes = accesoValClasif.getMin_ent_antes();

						// if ((accesoValClasif.getMin_ent_despues()!=null) &&
						// (accesoValClasif.getMin_ent_despues()>minEntDespues))
						// minEntDespues= accesoValClasif.getMin_ent_despues();

						// Controlar si permite el ingreso
						if (accesoValClasif.isPermitirIngreso()) {

							if ((legajoInterno != null) && (validarAntiPassback(legajoInterno, validarAntiPBValClasif)))
								return;

							if (isPararPorCacheoAlEntrar(accesoValClasif))
								return;

							setPuedePasar(true);

							return;

						} else if (accesoValClasif.isDenegarIngreso()) {
							setPuedePasar(false);
							this.setMotivoPermiso(accesoValClasif.getLey_no_ingreso());
							if ((!this.isNoEnviarMensajes()) && (this.getPuerta() != null) && (this.getPuerta().isActAviAccDenegado()))
								MotorMensONLINE.getMotor().enviar(
										MensajeONLINE.getNewMensajeONLINE(MensajeONLINE.TM_ONLINE, getMensAccDenEntrada(legajoInterno, this.getPuerta(), this.getMotivoPermiso()), this.getPuerta()
												.getUsuariosAvisoAccDen(), this.getPuerta().getMaquinasAvisoAccDen(), true, legajoInterno.getNro_legajo() + ".jpg", Legajo.getPathImagenesLegajo(this
												.getSesion()), 100, 100, Ring.getIDRingAccesoDenegado(this.getSesion()), Ring.getPathArchivos(this.getSesion()), "TFAccesoPorLegajo", legajoInterno
												.getOIDInteger(), "encontrarLegajo"));
							return;

						}

					}
				}
			}
		}

		// ******************************//
		// *** Validar antipassback *** //
		// ******************************//

		if (isPuertaAccesoPredio()) {

			if ((legajoInterno != null) && (validarAntiPassback(legajoInterno, validarAntiPBValClasif)))
				return;

		}

		if ((this.getPuerta() != null) && this.getPuerta().isLiberarEntrada()) {
			if (isPararPorCacheoAlEntrar(null))
				return;
			setPuedePasar(true);
			return;
		}

		// *********************************************//
		// *** Verificar si tiene acceso por puertas ***//
		// *********************************************//

		Integer maxCantHorasEnPredio = null;

		Iterator iterAccIntPue = AccesoInternoPuerta.getAccesosInternosPuertasByLegajoPuerta(this.getPuerta(), legajoInterno, this.getSesion()).iterator();
		while (iterAccIntPue.hasNext()) {
			AccesoInternoPuerta accesoInternoPuerta = (AccesoInternoPuerta) iterAccIntPue.next();
			
			if ((accesoInternoPuerta.getPrecond_entrada() != null) && (accesoInternoPuerta.getTipo_compo_entra() != null)) {

				if ((accesoInternoPuerta.getPrecond_entrada().equals(AccesoInternoPuerta.PRECOND_EN_ZONA) && (accesoInternoPuerta.getTipo_compo_entra().equals(AccesoInternoPuerta.ACCION_PASE)))) {

					Iterator iterMovUltDia = MovimientoCIP.getMovimientosLegajoUltDia(legajoInterno, this.getSesion()).iterator();
					while (iterMovUltDia.hasNext()) {
						MovimientoCIP movimiento = (MovimientoCIP) iterMovUltDia.next();

						if ((movimiento.getZonaDestino() != null) && (getPuerta().getEntradaSaleDe() != null) && (movimiento.getZonaDestino().getOID() == getPuerta().getEntradaSaleDe().getOID())) {
							if(this.isPuedeEntrarLegajoPorAccInt(accesoInternoPuerta)){
								setPuedePasar(true);
								return;
							}
						}

						break;
					}
				}

				if ((accesoInternoPuerta.getPrecond_entrada().equals(AccesoInternoPuerta.PRECOND_NINGUNA) && (accesoInternoPuerta.getTipo_compo_entra().equals(AccesoInternoPuerta.ACCION_PASE)))) {
					if(this.isPuedeEntrarLegajoPorAccInt(accesoInternoPuerta)){
						setPuedePasar(true);
						return;
					}
				}

				if ((accesoInternoPuerta.getPrecond_entrada().equals(AccesoInternoPuerta.PRECOND_NINGUNA) && (accesoInternoPuerta.getTipo_compo_entra().equals(AccesoInternoPuerta.ACCION_DENEGADO)))) {
					this.setPuedePasar(false);
					String mens = "ACCESO NO HABILITADO";
					if (accesoInternoPuerta.getMensajeEntrada() != null)
						mens = accesoInternoPuerta.getMensajeEntrada();
					this.setMotivoPermiso(mens);
					if ((!this.isNoEnviarMensajes()) && (this.getPuerta() != null) && (this.getPuerta().isActAviAccDenegado()))
						MotorMensONLINE.getMotor().enviar(
								MensajeONLINE.getNewMensajeONLINE(MensajeONLINE.TM_ONLINE, getMensAccDenEntrada(legajoInterno, this.getPuerta(), this.getMotivoPermiso()), this.getPuerta()
										.getUsuariosAvisoAccDen(), this.getPuerta().getMaquinasAvisoAccDen(), true, legajoInterno.getNro_legajo() + ".jpg", Legajo.getPathImagenesLegajo(this
										.getSesion()), 100, 100, Ring.getIDRingAccesoDenegado(this.getSesion()), Ring.getPathArchivos(this.getSesion()), "TFAccesoPorLegajo", legajoInterno
										.getOIDInteger(), "encontrarLegajo"));
					return;
				}
				if ((accesoInternoPuerta.getPrecond_entrada().equals(AccesoInternoPuerta.PRECOND_EN_PREDIO) && (accesoInternoPuerta.getTipo_compo_entra().equals(AccesoInternoPuerta.ACCION_PASE)))) {

					// Buscar el Ultimo Movimiento del Legajo y Verificar que no
					// sea externo
					Iterator iterMovUltDia = MovimientoCIP.getMovimientosLegajoUltDia(legajoInterno, this.getSesion()).iterator();
					while (iterMovUltDia.hasNext()) {
						MovimientoCIP movimiento = (MovimientoCIP) iterMovUltDia.next();
						if ((movimiento.getZonaDestino() != null) && (!movimiento.getZonaDestino().esExterna())) {
							if(this.isPuedeEntrarLegajoPorAccInt(accesoInternoPuerta)){
								setPuedePasar(true);
								return;
							}
						}
						// Solo me interesa procesa el primer registro
						break;
					}

				}

				if ((accesoInternoPuerta.getPrecond_entrada().equals(AccesoInternoPuerta.PRECOND_EN_PREDIO) && (accesoInternoPuerta.getTipo_compo_entra().equals(AccesoInternoPuerta.ACCION_DENEGADO)))) {

					// Buscar el Ultimo Movimiento del Legajo y Verificar que
					// este en predio
					Iterator iterMovUltDia = MovimientoCIP.getMovimientosLegajoUltDia(legajoInterno, this.getSesion()).iterator();
					while (iterMovUltDia.hasNext()) {
						MovimientoCIP movimiento = (MovimientoCIP) iterMovUltDia.next();
						if ((movimiento.getZonaDestino() != null) && (!movimiento.getZonaDestino().esExterna())) {
							// Entonces el ultimo movimiento esta en una zona
							// Interna
							this.setPuedePasar(false);
							String mens = "ACCESO NO HABILITADO";
							if (accesoInternoPuerta.getMensajeEntrada() != null)
								mens = accesoInternoPuerta.getMensajeEntrada();
							this.setMotivoPermiso(mens);
							if ((!this.isNoEnviarMensajes()) && (this.getPuerta() != null) && (this.getPuerta().isActAviAccDenegado()))
								MotorMensONLINE.getMotor().enviar(
										MensajeONLINE.getNewMensajeONLINE(MensajeONLINE.TM_ONLINE, getMensAccDenEntrada(legajoInterno, this.getPuerta(), this.getMotivoPermiso()), this.getPuerta()
												.getUsuariosAvisoAccDen(), this.getPuerta().getMaquinasAvisoAccDen(), true, legajoInterno.getNro_legajo() + ".jpg", Legajo.getPathImagenesLegajo(this
												.getSesion()), 100, 100, Ring.getIDRingAccesoDenegado(this.getSesion()), Ring.getPathArchivos(this.getSesion()), "TFAccesoPorLegajo", legajoInterno
												.getOIDInteger(), "encontrarLegajo"));
							return;
						}
						// Solo me interesa procesa el primer registro
						break;
					}

				}

				if ((accesoInternoPuerta.getPrecond_entrada().equals(AccesoInternoPuerta.PRECOND_FUERA_DE_PREDIO) && (accesoInternoPuerta.getTipo_compo_entra().equals(AccesoInternoPuerta.ACCION_PASE)))) {

					// Buscar el Ultimo Movimiento del Legajo y Verificar que
					// sea externo
					Iterator iterMovUltDia = MovimientoCIP.getMovimientosLegajoUltDia(legajoInterno, this.getSesion()).iterator();
					while (iterMovUltDia.hasNext()) {
						MovimientoCIP movimiento = (MovimientoCIP) iterMovUltDia.next();
						if ((movimiento.getZonaDestino() != null) && (movimiento.getZonaDestino().esExterna())) {
							// Entonces el ultimo movimiento esta en una zona
							// Interna
							if(this.isPuedeEntrarLegajoPorAccInt(accesoInternoPuerta)){
								setPuedePasar(true);
								return;
							}
						}
						// Solo me interesa procesa el primer registro
						break;
					}

				}

				if ((accesoInternoPuerta.getPrecond_entrada().equals(AccesoInternoPuerta.PRECOND_FUERA_DE_PREDIO) && (accesoInternoPuerta.getTipo_compo_entra()
						.equals(AccesoInternoPuerta.ACCION_DENEGADO)))) {

					// Buscar el Ultimo Movimiento del Legajo y Verificar que no
					// sea externo
					Iterator iterMovUltDia = MovimientoCIP.getMovimientosLegajoUltDia(legajoInterno, this.getSesion()).iterator();
					while (iterMovUltDia.hasNext()) {
						MovimientoCIP movimiento = (MovimientoCIP) iterMovUltDia.next();

						/*
						 * if
						 * (movimiento.getTiempoPermanenciaMenorAXMinutos(90)) {
						 * System.out.println("Permanencia menor a 90 minutos");
						 * }
						 */

						if ((movimiento.getZonaDestino() != null) && (movimiento.getZonaDestino().esExterna())) {
							// Entonces el ultimo movimiento esta en una zona
							// Externa
							this.setPuedePasar(false);
							String mens = "ACCESO NO HABILITADO";
							if (accesoInternoPuerta.getMensajeEntrada() != null)
								mens = accesoInternoPuerta.getMensajeEntrada();
							this.setMotivoPermiso(mens);
							if ((!this.isNoEnviarMensajes()) && (this.getPuerta() != null) && (this.getPuerta().isActAviAccDenegado()))
								MotorMensONLINE.getMotor().enviar(
										MensajeONLINE.getNewMensajeONLINE(MensajeONLINE.TM_ONLINE, getMensAccDenEntrada(legajoInterno, this.getPuerta(), this.getMotivoPermiso()), this.getPuerta()
												.getUsuariosAvisoAccDen(), this.getPuerta().getMaquinasAvisoAccDen(), true, legajoInterno.getNro_legajo() + ".jpg", Legajo.getPathImagenesLegajo(this
												.getSesion()), 100, 100, Ring.getIDRingAccesoDenegado(this.getSesion()), Ring.getPathArchivos(this.getSesion()), "TFAccesoPorLegajo", legajoInterno
												.getOIDInteger(), "encontrarLegajo"));
							return;
						}
						// Solo me interesa procesa el primer registro
						break;
					}

				}
			}

			boolean limitarA = false;

			Iterator iterCategAccesosLegEven = CategEvenAccesoLeg.getCategAccEventuales(legajoInterno, fecHorActual, this.getSesion()).iterator();
			while (iterCategAccesosLegEven.hasNext()) {
				CategEvenAccesoLeg categEvenAccesoLeg = (CategEvenAccesoLeg) iterCategAccesosLegEven.next();

				if (categEvenAccesoLeg.isLimitarA()) {

					limitarA = true;

					Iterator iterCategEvenAccesoLeg = categEvenAccesoLeg.getCategAccesosEventuales().iterator();
					while (iterCategEvenAccesoLeg.hasNext()) {
						CategEvenAccLegDet categEvenAccLegDet = (CategEvenAccLegDet) iterCategEvenAccesoLeg.next();
						if (categEvenAccLegDet.getCategoria().isTieneAccesoDeEntradaAPuerta(this.getPuerta())) {
							setPuedePasar(true);
							return;
						}
					}

				} else {
					// Se asume que si tiene acceso a esa puerta se concede
					Iterator iterCategEvenAccesoLeg = categEvenAccesoLeg.getCategAccesosEventuales().iterator();
					while (iterCategEvenAccesoLeg.hasNext()) {
						CategEvenAccLegDet categEvenAccLegDet = (CategEvenAccLegDet) iterCategEvenAccesoLeg.next();
						if (categEvenAccLegDet.getCategoria().isTieneAccesoDeEntradaAPuerta(this.getPuerta())) {
							setPuedePasar(true);
							return;
						}
					}
				}

			} // FIN (iterCategAccesosLegEven.hasNext())

			if (limitarA) {
				// No tiene acceso a ingresar por esta Puerta
				this.setPuedePasar(false);
				this.setMotivoPermiso("ACCESO NO HABILITADO");
				if ((!this.isNoEnviarMensajes()) && (this.getPuerta() != null) && (this.getPuerta().isActAviAccDenegado()))
					MotorMensONLINE.getMotor().enviar(
							MensajeONLINE.getNewMensajeONLINE(MensajeONLINE.TM_ONLINE, getMensAccDenEntrada(legajoInterno, this.getPuerta(), this.getMotivoPermiso()), this.getPuerta()
									.getUsuariosAvisoAccDen(), this.getPuerta().getMaquinasAvisoAccDen(), true, legajoInterno.getNro_legajo() + ".jpg", Legajo.getPathImagenesLegajo(this.getSesion()),
									100, 100, Ring.getIDRingAccesoDenegado(this.getSesion()), Ring.getPathArchivos(this.getSesion()), "TFAccesoPorLegajo", legajoInterno.getOIDInteger(),
									"encontrarLegajo"));
				return;
			}

			// Si tiene alguna categoria con acceso de entrada por esta puerta
			if ((this.getPuerta() != null) && (legajoInterno != null) && (this.getPuerta().getCategAccesoInternosEntradaLegajo(legajoInterno).size() > 0)) {
				setPuedePasar(true);
				return;
			}

			// Si llego hasta aca es porque es un acceso interno que no tiene
			// acceso a esta puerta
			/*
			 * this.setPuedePasar(false);
			 * this.setMotivoPermiso("ACCESO NO HABILITADO"); if
			 * ((!this.isNoEnviarMensajes()) && (this.getPuerta()!=null) &&
			 * (this.getPuerta().isActAviAccDenegado()))
			 * MotorMensONLINE.getMotor().enviar(
			 * MensajeONLINE.getNewMensajeONLINE(MensajeONLINE.TM_ONLINE,
			 * getMensAccDenEntrada(legajoInterno, this.getPuerta() ,
			 * this.getMotivoPermiso()),
			 * this.getPuerta().getUsuariosAvisoAccDen(),
			 * this.getPuerta().getMaquinasAvisoAccDen(), true,
			 * legajoInterno.getNro_legajo() + ".jpg",
			 * Legajo.getPathImagenesLegajo(this.getSesion()), 100, 100,
			 * Ring.getIDRingAccesoDenegado(this.getSesion()),
			 * Ring.getPathArchivos(this.getSesion()), "TFAccesoPorLegajo",
			 * legajoInterno.getOIDInteger(), "encontrarLegajo")); return;
			 */

		} // FIN isPuertaAccesoInterno())

		// *********************************************/
		// ** Verificar si tiene liberada la entrada **/
		// *********************************************/

		if ((this.getPuerta() != null) && (this.getPuerta().isIngresoAlPredio() && (legajoInterno.isLiberarIngAlPredio()))) {
			if (isPararPorCacheoAlEntrar(null))
				return;
			this.setPuedePasar(true);
			return;
		}

		// *************************************************//
		// *** Fijarse si la puerta se encuentra liberada **/
		// *************************************************//

		if (isPuertaAccesoPredio()) {

			// if (legajo.getEstadoCIP()!=null) {

			// if (legajo.getEstadoCIP().getMinEntAntEntrada()>minEntAntes)
			// minEntAntes = legajo.getEstadoCIP().getMinEntAntEntrada();

			// if (legajo.getEstadoCIP().getMinEntDesEntrada()>minEntDespues)
			// minEntDespues = legajo.getEstadoCIP().getMinEntDesEntrada();

			// }

			if ((this.getPuerta() != null) && this.getPuerta().isLiberarEntrada()) {
				if ((this.getPuerta().isIngresoAlPredio()) && (isPararPorCacheoAlEntrar(null)))
					return;
				setPuedePasar(true);
				return;
			}
		}

		// ********************************************//
		// *** Traer Planificacion Rota por Fecha *** //
		// ********************************************//

		if (isPuertaAccesoPredio()) {

			// VER COMO ESTA RESUELTO

			// Verificar si puede ingresar por la fecha actual
			LegajoRotaFecha legRotaFecha = legajo.getLegajoRotaFecha(fecha);
			if ((legRotaFecha != null) && (legRotaFecha.getRota().isSegunHorario()) && (anulaRotaDelDia == false)) {
				if (legRotaFecha.getRota().isPuedeIngresarSegunHorario(fecha, fecHorActual, minEntAntesHoy, minEntDespuesHoy)) {
					if (isPararPorCacheoAlEntrar(null))
						return;
					this.setPuedePasar(true);
					return;
				}
				if (puedeIngresarEntIntermedias(fecHorActual, legajo, legRotaFecha)) {
					setPuedePasar(true);
					return;
				}
			}

			// Verificar si puede ingresar por la rota del dia anterior
			LegajoRotaFecha legRotaFechaDiaAnt = legajo.getLegajoRotaFecha(fecDiaAnt);
			if ((legRotaFechaDiaAnt != null) && (legRotaFechaDiaAnt.getRota().isSegunHorario())
					&& ((NovedadPermisoCIP.getNovedadesPermisosCIPAnuRota(legajoInterno, fecDiaAnt, this.getSesion()).size() == 0))) {

				if (legRotaFechaDiaAnt.getRota().isPuedeIngresarSegunHorario(fecDiaAnt, fecHorActual, minEntAntesAyer, minEntDespuesAyer)) {
					if (isPararPorCacheoAlEntrar(null))
						return;
					this.setPuedePasar(true);
					return;
				}
				if (puedeIngresarEntIntermedias(fecHorActual, legajo, legRotaFechaDiaAnt)) {
					setPuedePasar(true);
					return;
				}

			}

			// Verificar si puede ingresar por la rota del dia posterior
			LegajoRotaFecha legRotaFechaDiaPost = legajo.getLegajoRotaFecha(fecDiaPost);
			if ((legRotaFechaDiaPost != null) && (legRotaFechaDiaPost.getRota().isSegunHorario())
					&& ((NovedadPermisoCIP.getNovedadesPermisosCIPAnuRota(legajoInterno, fecDiaPost, this.getSesion()).size() == 0))) {
				if (legRotaFechaDiaPost.getRota().isPuedeIngresarSegunHorario(fecDiaPost, fecHorActual, minEntAntesManiana, minEntDespuesManiana)) {
					if (isPararPorCacheoAlEntrar(null))
						return;
					this.setPuedePasar(true);
					return;
				}
				if (puedeIngresarEntIntermedias(fecHorActual, legajo, legRotaFechaDiaPost)) {
					setPuedePasar(true);
					return;
				}

			}

			if (legRotaFecha != null) {

				if (legRotaFecha.getRota().isPermiteIngreso() && (anulaRotaDelDia == false)) {
					if (isPararPorCacheoAlEntrar(null))
						return;
					this.setPuedePasar(true);
					return;
				} else if (legRotaFecha.getRota().isIngresoDenegado()) {
					this.setPuedePasar(false);
					this.setMotivoPermiso(legRotaFecha.getRota().getLeyendaNoIngresa());
					if ((!this.isNoEnviarMensajes()) && (this.getPuerta() != null) && (this.getPuerta().isActAviAccDenegado()))
						MotorMensONLINE.getMotor().enviar(
								MensajeONLINE.getNewMensajeONLINE(MensajeONLINE.TM_ONLINE, getMensAccDenEntrada(legajoInterno, this.getPuerta(), this.getMotivoPermiso()), this.getPuerta()
										.getUsuariosAvisoAccDen(), this.getPuerta().getMaquinasAvisoAccDen(), true, legajoInterno.getNro_legajo() + ".jpg", Legajo.getPathImagenesLegajo(this
										.getSesion()), 100, 100, Ring.getIDRingAccesoDenegado(this.getSesion()), Ring.getPathArchivos(this.getSesion()), "TFAccesoPorLegajo", legajoInterno
										.getOIDInteger(), "encontrarLegajo"));
					return;
				} else if (legRotaFecha.getRota().isSegunHorario()) {
					// Si llego a este punto no deberia poder ingresar
					// porque tiene asignado un rota y no pudo ingresar
					this.setPuedePasar(false);
					if (anulaRotaDelDia)
						this.setMotivoPermiso("Motivo que anula rota del dia");
					else
						this.setMotivoPermiso(legRotaFecha.getRota().getLeyendaNoIngresa());
					if ((!this.isNoEnviarMensajes()) && (this.getPuerta() != null) && (this.getPuerta().isActAviAccDenegado()))
						MotorMensONLINE.getMotor().enviar(
								MensajeONLINE.getNewMensajeONLINE(MensajeONLINE.TM_ONLINE, getMensAccDenEntrada(legajoInterno, this.getPuerta(), this.getMotivoPermiso()), this.getPuerta()
										.getUsuariosAvisoAccDen(), this.getPuerta().getMaquinasAvisoAccDen(), true, legajoInterno.getNro_legajo() + ".jpg", Legajo.getPathImagenesLegajo(this
										.getSesion()), 100, 100, Ring.getIDRingAccesoDenegado(this.getSesion()), Ring.getPathArchivos(this.getSesion()), "TFAccesoPorLegajo", legajoInterno
										.getOIDInteger(), "encontrarLegajo"));
					return;
				}
			}

		}

		// ************************************//
		// *** Planificacion de la Semana *** //
		// ************************************//

		if (isPuertaAccesoPredio()) {

			if (legajoInterno.getPermisoSemanal() != null) {

				int dia = Fecha.getDiaSemana(this.fecha);
				int diaAnterior = dia - 1;
				if (diaAnterior == 0)
					diaAnterior = 7;
				int diaPosterior = dia + 1;
				if (diaPosterior == 8)
					diaPosterior = 1;

				String tipoPermiso = legajoInterno.getPermisoSemanal().getTipoPermisoSemanalEnt(dia);
				if ((tipoPermiso != null) && (tipoPermiso.equals(TiposEntradasRotas.SEGUN_HORARIO)) && (anulaRotaDelDia == false)) {
					if (legajoInterno.getPermisoSemanal().isPuedeIngresar(dia, this.fecha, fecHorActual, minEntAntesHoy, minEntDespuesHoy)) {
						if (isPararPorCacheoAlEntrar(null))
							return;
						this.setPuedePasar(true);
						return;
					}

					if (legajoInterno.puedeIngresarEntIntermedias(fecHorActual, legajoInterno.getPermisoSemanal(), this.fecha)) {
						this.setPuedePasar(true);
						return;
					}

				}

				String tipoPermisoAnt = legajoInterno.getPermisoSemanal().getTipoPermisoSemanalEnt(diaAnterior);
				if ((tipoPermisoAnt != null) && (tipoPermisoAnt.equals(TiposEntradasRotas.SEGUN_HORARIO))) {
					if (legajoInterno.getPermisoSemanal().isPuedeIngresar(diaAnterior, fecDiaAnt, fecHorActual, minEntAntesAyer, minEntDespuesAyer)) {
						if (isPararPorCacheoAlEntrar(null))
							return;
						this.setPuedePasar(true);
						return;
					}
					if (legajoInterno.puedeIngresarEntIntermedias(fecHorActual, legajoInterno.getPermisoSemanal(), fecDiaAnt)) {
						this.setPuedePasar(true);
						return;
					}

				}

				String tipoPermisoPos = legajoInterno.getPermisoSemanal().getTipoPermisoSemanalEnt(diaPosterior);
				if ((tipoPermisoPos != null) && (tipoPermisoPos.equals(TiposEntradasRotas.SEGUN_HORARIO))) {
					if (legajoInterno.getPermisoSemanal().isPuedeIngresar(diaPosterior, fecDiaPost, fecHorActual, minEntAntesManiana, minEntDespuesManiana)) {
						if (isPararPorCacheoAlEntrar(null))
							return;
						this.setPuedePasar(true);
						return;
					}
					if (legajoInterno.puedeIngresarEntIntermedias(fecHorActual, legajoInterno.getPermisoSemanal(), fecDiaPost)) {
						this.setPuedePasar(true);
						return;
					}

				}

				if (tipoPermiso.equals(TiposEntradasRotas.PERMITIDO)) {
					if (isPararPorCacheoAlEntrar(null))
						return;
					this.setPuedePasar(true);
					return;
				} else if (tipoPermiso.equals(TiposEntradasRotas.DENEGADO)) {
					this.setPuedePasar(false);
					this.setMotivoPermiso(legajoInterno.getPermisoSemanal().getLeyendaNoIngresa(dia));
					if ((!this.isNoEnviarMensajes()) && (this.getPuerta() != null) && (this.getPuerta().isActAviAccDenegado()))
						MotorMensONLINE.getMotor().enviar(
								MensajeONLINE.getNewMensajeONLINE(MensajeONLINE.TM_ONLINE, getMensAccDenEntrada(legajoInterno, this.getPuerta(), this.getMotivoPermiso()), this.getPuerta()
										.getUsuariosAvisoAccDen(), this.getPuerta().getMaquinasAvisoAccDen(), true, legajoInterno.getNro_legajo() + ".jpg", Legajo.getPathImagenesLegajo(this
										.getSesion()), 100, 100, Ring.getIDRingAccesoDenegado(this.getSesion()), Ring.getPathArchivos(this.getSesion()), "TFAccesoPorLegajo", legajoInterno
										.getOIDInteger(), "encontrarLegajo"));
					return;
				} else if (tipoPermiso.equals(TiposEntradasRotas.SEGUN_HORARIO)) {

					// Si llego hasta aca es que no tiene el Horario habilitado
					this.setPuedePasar(false);
					this.setMotivoPermiso(legajoInterno.getPermisoSemanal().getLeyendaNoIngresa(dia));
					if ((!this.isNoEnviarMensajes()) && (this.getPuerta() != null) && (this.getPuerta().isActAviAccDenegado()))
						MotorMensONLINE.getMotor().enviar(
								MensajeONLINE.getNewMensajeONLINE(MensajeONLINE.TM_ONLINE, getMensAccDenEntrada(legajoInterno, this.getPuerta(), this.getMotivoPermiso()), this.getPuerta()
										.getUsuariosAvisoAccDen(), this.getPuerta().getMaquinasAvisoAccDen(), true, legajoInterno.getNro_legajo() + ".jpg", Legajo.getPathImagenesLegajo(this
										.getSesion()), 100, 100, Ring.getIDRingAccesoDenegado(this.getSesion()), Ring.getPathArchivos(this.getSesion()), "TFAccesoPorLegajo", legajoInterno
										.getOIDInteger(), "encontrarLegajo"));
					return;

				}

			}
		}

		// ****************************************************//
		// *** Si llego a este punto es porque no accede *** //
		// ****************************************************//

		if (this.isPuedePasar() == false)
			if ((!this.isNoEnviarMensajes()) && (this.getPuerta() != null) && (this.getPuerta().isActAviAccDenegado()))
				MotorMensONLINE
						.getMotor()
						.enviar(MensajeONLINE.getNewMensajeONLINE(MensajeONLINE.TM_ONLINE, getMensAccDenEntrada(legajoInterno, this.getPuerta(), this.getMotivoPermiso()), this.getPuerta()
								.getUsuariosAvisoAccDen(), this.getPuerta().getMaquinasAvisoAccDen(), true, legajoInterno.getNro_legajo() + ".jpg", Legajo.getPathImagenesLegajo(this.getSesion()),
								100, 100, Ring.getIDRingAccesoDenegado(this.getSesion()), Ring.getPathArchivos(this.getSesion()), "TFAccesoPorLegajo", legajoInterno.getOIDInteger(), "encontrarLegajo"));

	}

	private boolean validarAntiPassback(Legajo legajoInterno, boolean activarAntiPassPorValClasif) throws BaseException {
		if ((ActLAntiPassBack.isActivado(this.getSesion())) && (legajoInterno.isIgnorarProxAntiPassBack() == false)
				&& (activarAntiPassPorValClasif || legajoInterno.isActivarAntiPassBack() || (((legajoInterno.getEstadoCIP() != null) && (legajoInterno.getEstadoCIP().isActivarAntiPassBack()))))) {

			if ((legajoInterno.getSentidoPaso() != null) && legajoInterno.getSentidoPaso().equals(MovimientoCIP.MOV_ENT_CIP) && (this.getPuerta() != null)
					&& (this.getPuerta().isControlAntiPassBackEnt())) {

				setPuedePasar(false);
				this.setMotivoPermiso("ENTRADA YA REGISTRADA");
				if ((!this.isNoEnviarMensajes()) && (this.getPuerta() != null) && (this.getPuerta().isActAviAccDenegado()))
					MotorMensONLINE.getMotor().enviar(
							MensajeONLINE.getNewMensajeONLINE(MensajeONLINE.TM_ONLINE, getMensAccDenEntrada(legajoInterno, this.getPuerta(), this.getMotivoPermiso()), this.getPuerta()
									.getUsuariosAvisoAccDen(), this.getPuerta().getMaquinasAvisoAccDen(), true, legajoInterno.getNro_legajo() + ".jpg", Legajo.getPathImagenesLegajo(this.getSesion()),
									100, 100, Ring.getIDRingAccesoDenegado(this.getSesion()), Ring.getPathArchivos(this.getSesion()), "TFAccesoPorLegajo", legajoInterno.getOIDInteger(),
									"encontrarLegajo"));
				return true;

			}
		}
		return false;
	}

	private boolean puedeIngresarEntIntermedias(java.util.Date fecHorActual, Legajo legajo, LegajoRotaFecha legRotaFecha) throws BaseException {

		if ((legRotaFecha != null)
				&& (legRotaFecha.getRota() != null)
				&& (legRotaFecha.getRota().getTipo_acceso().equals(TiposEntradasRotas.SEGUN_HORARIO) && (legRotaFecha.getRota().getHorario_desde() != null) && (legRotaFecha.getRota()
						.getHorario_hasta() != null))) {

			int HorasDesde = UtilCIP.getParteHoraEnHoras(legRotaFecha.getRota().getHorario_desde());
			int MinutosDesde = UtilCIP.getParteMinutosEnMinutos(legRotaFecha.getRota().getHorario_desde());
			int cantMinutosHorDesde = UtilCIP.getHoraEnMin(legRotaFecha.getRota().getHorario_desde());

			Calendar calFecHorDesde = GregorianCalendar.getInstance();
			calFecHorDesde.setTime(legRotaFecha.getFecha()); // set cal to date
			calFecHorDesde.add(Calendar.HOUR, HorasDesde);
			calFecHorDesde.add(Calendar.MINUTE, MinutosDesde);
			java.util.Date fecHorDesde = calFecHorDesde.getTime();

			int HorasHasta = UtilCIP.getParteHoraEnHoras(legRotaFecha.getRota().getHorario_hasta());
			int MinutosHasta = UtilCIP.getParteMinutosEnMinutos(legRotaFecha.getRota().getHorario_hasta());
			int cantMinutosHorHasta = UtilCIP.getHoraEnMin(legRotaFecha.getRota().getHorario_hasta());

			Calendar calFecHorHasta = GregorianCalendar.getInstance();
			if (cantMinutosHorHasta < cantMinutosHorDesde)
				calFecHorHasta.setTime(Fecha.getFechaDiaPosterior(legRotaFecha.getFecha()));
			else
				calFecHorHasta.setTime(legRotaFecha.getFecha()); // set cal to
																	// date
			calFecHorHasta.add(Calendar.HOUR, HorasHasta);
			calFecHorHasta.add(Calendar.MINUTE, MinutosHasta);
			java.util.Date fecHorHasta = calFecHorHasta.getTime();

			if ((!fecHorActual.before(fecHorDesde)) && (!fecHorActual.after((fecHorHasta)))) {

				Iterator iterMotInterRotasAsigFij = legajo.getMotEntInterSegunLegajo(legRotaFecha.getRota()).iterator();
				while (iterMotInterRotasAsigFij.hasNext()) {
					MotivoEntradasInterRota motivoEntradasInterRota = (MotivoEntradasInterRota) iterMotInterRotasAsigFij.next();

					int HorasDesdeMot = UtilCIP.getParteHoraEnHoras(motivoEntradasInterRota.getHorario_desde());
					int MinutosDesdeMot = UtilCIP.getParteMinutosEnMinutos(motivoEntradasInterRota.getHorario_desde());
					int cantMinutosHorDesdeMot = UtilCIP.getHoraEnMin(motivoEntradasInterRota.getHorario_desde());

					Calendar calFecHorDesdeMot = GregorianCalendar.getInstance();
					calFecHorDesdeMot.setTime(legRotaFecha.getFecha());
					calFecHorDesdeMot.add(Calendar.HOUR, HorasDesdeMot);
					calFecHorDesdeMot.add(Calendar.MINUTE, MinutosDesdeMot);
					java.util.Date fecHorDesdeMot = calFecHorDesdeMot.getTime();

					int HorasHastaMot = UtilCIP.getParteHoraEnHoras(motivoEntradasInterRota.getHorario_hasta());
					int MinutosHastaMot = UtilCIP.getParteMinutosEnMinutos(motivoEntradasInterRota.getHorario_hasta());
					int cantMinutosHorHastaMot = UtilCIP.getHoraEnMin(motivoEntradasInterRota.getHorario_hasta());

					Calendar calFecHorHastaMot = GregorianCalendar.getInstance();
					if (cantMinutosHorHastaMot < cantMinutosHorDesdeMot)
						calFecHorHastaMot.setTime(Fecha.getFechaDiaPosterior(legRotaFecha.getFecha()));
					else
						calFecHorHastaMot.setTime(legRotaFecha.getFecha()); // set
																			// cal
																			// to
																			// date
					calFecHorHastaMot.add(Calendar.HOUR, HorasHastaMot);
					calFecHorHastaMot.add(Calendar.MINUTE, MinutosHastaMot);
					java.util.Date fecHorHastaMot = calFecHorHastaMot.getTime();
					if ((!fecHorActual.before(fecHorDesdeMot)) && (!fecHorActual.after((fecHorHastaMot)))) {
						setPuedePasar(true);
						return true;
					}

				}

			}
		}

		return false;

	}

	public boolean isPuedePasar() throws BaseException {
		return this.puedePasar;
	}

	public String getMotivoPermiso() throws BaseException {
		if (this.motivoPermiso == null)
			return "";
		else
			return this.motivoPermiso;
	}

	public static String getMotivoCacheo(ISesion aSesion) throws BaseException {
		return Cacheo.getMensDispCacheo(aSesion);
	}

	private boolean isHabilitarSalidaPorControlHorario(Legajo legajo, AccesoInternoPuerta acceso) throws BaseException {
		// Verificar si puede ingresar por la fecha actual
		LegajoRotaFecha legRotaFecha = legajo.getLegajoRotaFecha(this.fecha);

		if (legRotaFecha == null)
			return false;

		if (legRotaFecha.getRota().isSegunHorario()) {
			Date fecHorActual = UtilCIP.getFechaHoraActual(this.getSesion());
			if ((legRotaFecha != null) && (legRotaFecha.getRota().isSegunHorario()))
				if (legRotaFecha.getRota().isPuedeEgresarSegunHorario(this.fecha, fecHorActual, acceso.getMinEntAntFhSal(), acceso.getMinEntDesFhSal()))
					return true;

			// Verificar si puede ingresar por la rota del dia anterior
			Date fecDiaAnt = Fecha.getFechaDiaAnterior(this.fecha);
			LegajoRotaFecha legRotaFechaDiaAnt = legajo.getLegajoRotaFecha(fecDiaAnt);
			if ((legRotaFechaDiaAnt != null) && (legRotaFechaDiaAnt.getRota().isSegunHorario()))
				if (legRotaFechaDiaAnt.getRota().isPuedeEgresarSegunHorario(fecDiaAnt, fecHorActual, acceso.getMinEntAntFhSal(), acceso.getMinEntDesFhSal()))
					return true;

			// Verificar si puede ingresar por la rota del dia posterior
			Date fecDiaPost = Fecha.getFechaDiaPosterior(this.fecha);
			LegajoRotaFecha legRotaFechaDiaPost = legajo.getLegajoRotaFecha(fecDiaPost);
			if ((legRotaFechaDiaPost != null) && (legRotaFechaDiaPost.getRota().isSegunHorario()))
				if (legRotaFechaDiaPost.getRota().isPuedeEgresarSegunHorario(fecDiaPost, fecHorActual, acceso.getMinEntAntFhSal(), acceso.getMinEntDesFhSal()))
					return true;
		}

		if (legRotaFecha.getRota().isPermiteEgreso())
			return true;

		if (legRotaFecha.getRota().isEgresoDenegado())
			return false;

		return false;
	}

	private boolean isHabilitarEntradaPorControlHorario(Legajo legajo, AccesoInternoPuerta acceso) throws BaseException {
		// Verificar si puede ingresar por la fecha actual
		LegajoRotaFecha legRotaFecha = legajo.getLegajoRotaFecha(this.fecha);

		if (legRotaFecha == null)
			return false;

		if (legRotaFecha.getRota().isSegunHorario()) {
			Date fecHorActual = UtilCIP.getFechaHoraActual(this.getSesion());
			if ((legRotaFecha != null) && (legRotaFecha.getRota().isSegunHorario()))
				if (legRotaFecha.getRota().isPuedeIngresarSegunHorario(this.fecha, fecHorActual, acceso.getMinEntAntFhEnt(), acceso.getMinEntDesFhEnt()))
					return true;

			// Verificar si puede ingresar por la rota del dia anterior
			Date fecDiaAnt = Fecha.getFechaDiaAnterior(this.fecha);
			LegajoRotaFecha legRotaFechaDiaAnt = legajo.getLegajoRotaFecha(fecDiaAnt);
			if ((legRotaFechaDiaAnt != null) && (legRotaFechaDiaAnt.getRota().isSegunHorario()))
				if (legRotaFechaDiaAnt.getRota().isPuedeIngresarSegunHorario(fecDiaAnt, fecHorActual, acceso.getMinEntAntFhEnt(), acceso.getMinEntDesFhEnt()))
					return true;

			// Verificar si puede ingresar por la rota del dia posterior
			Date fecDiaPost = Fecha.getFechaDiaPosterior(this.fecha);
			LegajoRotaFecha legRotaFechaDiaPost = legajo.getLegajoRotaFecha(fecDiaPost);
			if ((legRotaFechaDiaPost != null) && (legRotaFechaDiaPost.getRota().isSegunHorario()))
				if (legRotaFechaDiaPost.getRota().isPuedeIngresarSegunHorario(fecDiaPost, fecHorActual, acceso.getMinEntAntFhEnt(), acceso.getMinEntDesFhEnt()))
					return true;
		}

		if (legRotaFecha.getRota().isPermiteIngreso())
			return true;

		if (legRotaFecha.getRota().isIngresoDenegado())
			return false;

		return false;

	}
	
	private boolean isPuedeEntrarLegajoPorAccInt(AccesoInternoPuerta accesoInternoPuerta) throws BaseException{	
		boolean puedePasar = true;
		if (accesoInternoPuerta.controlaHorarioEntrada() && puedePasar){
			if (!this.isHabilitarEntradaPorControlHorario(this.legajo, accesoInternoPuerta)) 
				puedePasar = false;	
		}
		if (accesoInternoPuerta.controlaSexoEntrada() && puedePasar){
			if (!accesoInternoPuerta.isPuedeEntrarLegajoPorSexo(this.getLegajo())) 
				puedePasar = false;
		} 
		
		return puedePasar;
	}
	
	private boolean isPuedeSalirLegajoPorAccInt(AccesoInternoPuerta accesoInternoPuerta) throws BaseException{
		boolean puedePasar = true;
		if (accesoInternoPuerta.controlaHorarioSalida() && puedePasar){
			if (!this.isHabilitarSalidaPorControlHorario(this.legajo, accesoInternoPuerta)) 
				puedePasar = false;	
		}
		if (accesoInternoPuerta.controlaSexoSalida() && puedePasar){
			if (!accesoInternoPuerta.isPuedeSalirLegajoPorSexo(this.getLegajo())) 
				puedePasar = false;
		} 
		
		return puedePasar;
	}
}
