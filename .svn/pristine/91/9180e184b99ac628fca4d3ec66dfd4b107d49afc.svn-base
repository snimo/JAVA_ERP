package com.srn.erp.cip.bm;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import framework.request.bl.Utils.BaseException;

public class ProcesadorFichadasOficina {

	private Date fechaDesde;
	private Date fechaHasta;
	private Date fechaAuxHasta;
	private Integer cantSegNuevaJornada;
	private Date fechaActual;
	private Integer secu;

	public Date getFechaDesde() {
		return fechaDesde;
	}

	public void setFechaDesde(Date fechaDesde) {
		this.fechaDesde = fechaDesde;
	}

	public Date getFechaHasta() {
		return fechaHasta;
	}

	public void setFechaHasta(Date fechaHasta) {
		this.fechaHasta = fechaHasta;
	}

	public Integer getCantSegNuevaJornada() {
		return cantSegNuevaJornada;
	}

	public void setCantSegNuevaJornada(Integer cantSegNuevaJornada) {
		this.cantSegNuevaJornada = cantSegNuevaJornada;
	}

	public Date getFechaActual() {
		return fechaActual;
	}

	public void setFechaActual(Date fechaActual) {
		this.fechaActual = fechaActual;
	}

	public Integer getSecu() {
		return secu;
	}

	public void setSecu(Integer secu) {
		this.secu = secu;
	}

	public ProcesadorFichadasOficina(Date fechaDesde, Date fechaHasta, Date fechaActual, Integer cantMinNuevaJornada, Date fechaAuxHasta) throws BaseException {
		this.fechaDesde = fechaDesde;
		this.fechaHasta = fechaHasta;
		this.secu = 1;
		this.fechaActual = fechaActual;
		this.fechaAuxHasta = fechaAuxHasta;
		this.cantSegNuevaJornada = cantMinNuevaJornada * 60;
	}

	public List<RegistroFichada> procesarFichadas(List<CIPFichadaOficina> fichadas) throws BaseException {
		Map<String, List<CIPFichadaOficina>> mapa = this.agruparFichadasPorLeg(fichadas);

		for (Entry<String, List<CIPFichadaOficina>> e : mapa.entrySet()) {
			this.ordenarFichadasPorFechaAsc(e.getValue());
			this.ordenarFichadasPorOIDAsc(e.getValue());
		}

		return this.getRegistros(mapa);
	}

	private List<RegistroFichada> getRegistros(Map<String, List<CIPFichadaOficina>> mapa) throws BaseException {
		List<RegistroFichada> registros = new ArrayList<RegistroFichada>();

		for (Entry<String, List<CIPFichadaOficina>> e : mapa.entrySet()) {
			registros.addAll(this.crearRegistros(e.getValue()));
		}

		return registros;
	}

	private List<RegistroFichada> crearRegistros(List<CIPFichadaOficina> fichadasByLeg) throws BaseException {
		List<RegistroFichada> registros = new ArrayList<RegistroFichada>();
		List<JornadaFichada> jornadas = this.crearJornadas(fichadasByLeg);
		for (JornadaFichada jornada : jornadas) {
			if (this.isJornadaValida(jornada)) {
				RegistroFichada registro = new RegistroFichada();
				registro.setApellidoNombre(jornada.getLegajo().getApellidoyNombre());
				registro.setLegajo(jornada.getLegajo().getNro_legajo());
				registro.setOidLegajo(jornada.getLegajo().getOIDInteger());
				registro.setFecHorEntrada(jornada.getFecHorEnt());
				registro.setFecHorSalida(jornada.getFecHorSal());
				registro.setSecu(this.secu);

				if (jornada.getFichadaEnt() != null)
					registro.getFichadas().add(jornada.getFichadaEnt());
				if (jornada.getFichadaSal() != null)
					registro.getFichadas().add(jornada.getFichadaSal());

				Boolean encontroEntrada = true;
				long tiempoPermanencia = 0;
				long tiempoSalida = 0;
				Integer cantSalInt = 0;
				Integer cantEntInt = 0;
				Date marcaFechaEnt = jornada.getFecHorEnt();
				Date marcaFechaSal = jornada.getFecHorSal();

				if (jornada.getFichadasInt().size() > 0) {
					for (int i = 0; i < jornada.getFichadasInt().size(); i++) {
						CIPFichadaOficina fichada = jornada.getFichadasInt().get(i);
						// calculo las fichadas dentro de la jornada 1ero busco
						// una
						// salida
						if (encontroEntrada && fichada.getSentido().equals(CIPFichadaOficina.SALIDA)
								&& this.isSalidaIntVal(i < jornada.getFichadasInt().size() - 1 ? jornada.getFichadasInt().get(i + 1) : null)) {
							cantSalInt = cantSalInt + 1;
							marcaFechaSal = fichada.getFec_hor();
							tiempoPermanencia = tiempoPermanencia + this.getDifSegEntreFechas(marcaFechaEnt, marcaFechaSal);
							encontroEntrada = false;
							registro.getFichadas().add(fichada);
						} else if ((!encontroEntrada) && fichada.getSentido().equals(CIPFichadaOficina.ENTRADA)) {

							if (!this.isIgnorarUltFichadaEnt(i, jornada.getFichadasInt().size(), jornada)) {
								cantEntInt = cantEntInt + 1;
								marcaFechaEnt = fichada.getFec_hor();
								tiempoSalida = tiempoSalida + this.getDifSegEntreFechas(marcaFechaSal, marcaFechaEnt);
							} else {
								registro.setFecHorSalida(marcaFechaSal);
							}

							encontroEntrada = true;
							registro.getFichadas().add(fichada);
						}

					}

					registro.setTiempoPermanencia(encontroEntrada && (!jornada.isIgnorarFinJornada()) ? tiempoPermanencia
							+ this.getDifSegEntreFechas(marcaFechaEnt, jornada.getFecHorSal() != null ? jornada.getFecHorSal() : this.getFechaUsandoFechaHasta()) : tiempoPermanencia);

					registro.setTiempoSalidas((!encontroEntrada) ? tiempoSalida
							+ this.getDifSegEntreFechas(marcaFechaSal, jornada.getFecHorSal() != null ? jornada.getFecHorSal() : this.getFechaUsandoFechaHasta()) : tiempoSalida);
					registro.setCantSalInt(cantSalInt);
					registro.setCantEntInt(cantEntInt);

				} else {
					registro.setFecHorSalida(null);
					registro.setTiempoPermanencia(tiempoPermanencia);
					registro.setTiempoSalidas(tiempoSalida);
					registro.setCantSalInt(cantSalInt);
					registro.setCantEntInt(cantEntInt);
				}

				this.ordenarFichadasPorFechaAsc(registro.getFichadas());
				this.ordenarFichadasPorOIDAsc(registro.getFichadas());

				registros.add(registro);
				this.secu++;
			}

		}

		return registros;
	}

	private boolean isIgnorarUltFichadaEnt(int i, int size, JornadaFichada jornada) {
		if (i + 1 == size && jornada.isIgnorarUltEnt()) {
			return true;
		}

		return false;
	}

	/**
	 * Valida si la jornada se encuentra entre las fechas solicitadas
	 */
	private boolean isJornadaValida(JornadaFichada jornada) throws BaseException {
		if ((jornada.getFecHorSal() == null || (jornada.getFecHorSal() != null && jornada.getFecHorSal().after(this.fechaDesde)))
				&& (jornada.getFecHorEnt() != null && jornada.getFecHorEnt().before(this.fechaHasta))) {
			return true;
		}

		return false;
	}

	/**
	 * Valida si la fichada posterior es salida
	 */
	private boolean isSalidaIntVal(CIPFichadaOficina fichadaPost) throws BaseException {
		if (fichadaPost != null && fichadaPost.getSentido().equals(CIPFichadaOficina.SALIDA))
			return false;

		return true;
	}

	/**
	 * Es importante aclarar que siempre se recupera un dia antes de la
	 * fechaDesde y un dia despues de la fechaHasta
	 * */
	private List<JornadaFichada> crearJornadas(List<CIPFichadaOficina> fichadasByLeg) throws BaseException {
		List<JornadaFichada> jornadas = new ArrayList<JornadaFichada>();
		Boolean buscarEntJornada = true;
		JornadaFichada jornada = null;
		// Boolean isPrimeraEnt = true;
		CIPFichadaOficina ficEntAux = null;

		for (int i = 0; i < fichadasByLeg.size(); i++) {
			CIPFichadaOficina fichada = fichadasByLeg.get(i);
			Boolean existeFichPost = (i < fichadasByLeg.size() - 1);
			
			if (buscarEntJornada && fichada.getSentido().equals(CIPFichadaOficina.ENTRADA)) {
				jornada = new JornadaFichada();
				jornada.setLegajo(fichada.getLegajo());
				jornada.setFichadaEnt(fichada);
				buscarEntJornada = false;
				ficEntAux = fichada;

			} else if ((!buscarEntJornada) && fichada.getSentido().equals(CIPFichadaOficina.SALIDA) && this.isJornadaSalida(jornada, fichada, ficEntAux, existeFichPost, existeFichPost ? fichadasByLeg.get(i + 1) : null)) {
				jornada.setFichadaSal(fichada);
				jornadas.add(jornada);
				buscarEntJornada = true;
			} else {
				// aca guarda las fichadas intermedias
				if (jornada != null) {
					jornada.getFichadasInt().add(fichada);
					if (fichada.getSentido().equals(CIPFichadaOficina.ENTRADA))
						ficEntAux = fichada;
				}

			}

		}

		if (jornada != null && jornada.getFecHorSal() == null) {
			jornadas.add(jornada);
			
			// Mi utima fichada fue una entrada
			if (this.getDifSegEntreFechas(ficEntAux.getFec_hor(), this.getFechaUsandoFechaAuxHasta()) >= this.cantSegNuevaJornada)
				jornada.setIgnorarFinJornada(true);
			
			//Mi ultima fichada fue una salida
			if (this.getDifSegEntreFechas(jornada.getFecHorEnt(), this.getFechaUsandoFechaAuxHasta()) >= this.cantSegNuevaJornada)
				jornada.setIgnorarUltEnt(true);
		}

		return jornadas;
	}

	private boolean isJornadaSalida(JornadaFichada jornada, CIPFichadaOficina fichada, CIPFichadaOficina ficEntAux, Boolean existeFichPost, CIPFichadaOficina fichadaPost) throws BaseException {
		if(this.isSalidaJornadaCombinacionEntSal(jornada, fichada, ficEntAux)) // la combinacion entrada salida tiene que estar primero en la validacion
			return true;
		else if(this.isSalidaJornadaCombinacionSalEnt(fichada, fichadaPost))
			return true;
		else if(this.isSalidaJornadaCombinacionSalFecha(jornada, existeFichPost))
			return true;
		else
			return false;
		
	}

	private boolean isSalidaJornadaCombinacionSalFecha(JornadaFichada jornada, Boolean existeFichPost) throws BaseException {
		if((!existeFichPost) && jornada != null && this.getDifSegEntreFechas(jornada.getFecHorEnt(), this.getFechaUsandoFechaAuxHasta()) >= this.cantSegNuevaJornada)
			return true;
		else 
			return false;
	}

	private boolean isSalidaJornadaCombinacionEntSal(JornadaFichada jornada, CIPFichadaOficina fichada, CIPFichadaOficina fichadaEnt) throws BaseException {
		if (fichadaEnt != null && this.getDifSegEntreFechas(fichadaEnt.getFec_hor(), fichada.getFec_hor()) >= this.cantSegNuevaJornada) {
			if (jornada != null)
				jornada.setIgnorarUltEnt(true);

			return true;
		} else {
			return false;
		}
	}

	private boolean isSalidaJornadaCombinacionSalEnt(CIPFichadaOficina fichada, CIPFichadaOficina fichadaPost) throws BaseException {
		if (fichadaPost != null && fichadaPost.getSentido().equals(CIPFichadaOficina.ENTRADA)
				&& this.getDifSegEntreFechas(fichada.getFec_hor(), fichadaPost.getFec_hor()) >= this.cantSegNuevaJornada)
			return true;
		else
			return false;

	}

	// private boolean isEntradaJornada(CIPFichadaOficina fichada,
	// CIPFichadaOficina fichadaAnt, Boolean isPrimeraEnt) throws BaseException
	// {
	// if (isPrimeraEnt) // siempre tomo la primer entrada
	// return true;
	// else if (fichadaAnt != null &&
	// fichadaAnt.getSentido().equals(CIPFichadaOficina.SALIDA) &&
	// this.getDifSegEntreFechas(fichadaAnt.getFec_hor(), fichada.getFec_hor())
	// >= this.cantSegNuevaJornada)
	// return true;
	// else
	// return false;
	//
	// }

	public long getDifSegEntreFechas(Date fechaMenor, Date fechaMayor) throws BaseException {
		Calendar calendar1 = Calendar.getInstance();
		Calendar calendar2 = Calendar.getInstance();

		calendar1.setTime(fechaMenor);
		calendar2.setTime(fechaMayor);

		return (calendar2.getTimeInMillis() - calendar1.getTimeInMillis()) / 1000;

	}

	private Map<String, List<CIPFichadaOficina>> agruparFichadasPorLeg(List<CIPFichadaOficina> fichadas) throws BaseException {
		Map<String, List<CIPFichadaOficina>> mapa = new HashMap<String, List<CIPFichadaOficina>>();
		for (CIPFichadaOficina fichada : fichadas) {
			if (mapa.get(fichada.getLegajo().getOIDInteger().toString()) == null)
				mapa.put(fichada.getLegajo().getOIDInteger().toString(), new ArrayList<CIPFichadaOficina>());
			mapa.get(fichada.getLegajo().getOIDInteger().toString()).add(fichada);
		}

		return mapa;
	}

	private void ordenarFichadasPorFechaAsc(List<CIPFichadaOficina> fichadas) {
		Collections.sort(fichadas, new Comparator<CIPFichadaOficina>() {
			@Override
			public int compare(CIPFichadaOficina f1, CIPFichadaOficina f2) {
				try {
					return f1.getFec_hor().compareTo(f2.getFec_hor());
				} catch (BaseException e) {
					e.printStackTrace();
				}

				return 0;
			}
		});

	}

	private void ordenarFichadasPorOIDAsc(List<CIPFichadaOficina> fichadas) {
		Collections.sort(fichadas, new Comparator<CIPFichadaOficina>() {
			@Override
			public int compare(CIPFichadaOficina f1, CIPFichadaOficina f2) {
				return f1.getOIDInteger().compareTo(f2.getOIDInteger());

			}
		});

	}
	
	private Date getFechaUsandoFechaHasta(){
		return this.fechaHasta.before(this.fechaActual) ? this.fechaHasta: this.fechaActual;
	}
	
	private Date getFechaUsandoFechaAuxHasta(){
		return this.fechaAuxHasta.before(this.fechaActual) ? this.fechaAuxHasta: this.fechaActual;
	}
	
}
