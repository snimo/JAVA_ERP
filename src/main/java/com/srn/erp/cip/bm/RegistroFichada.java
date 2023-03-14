package com.srn.erp.cip.bm;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class RegistroFichada {

	private Integer secu;
	private Integer oidLegajo;
	private String legajo;
	private String apellidoNombre;
	private Integer cantSalInt;
	private Long tiempoSalidas;
	private Integer cantEntInt;
	private Long tiempoPermanencia;
	private Date fecHorEntrada;
	private Date fecHorSalida;
	private List<CIPFichadaOficina> fichadas = new ArrayList<CIPFichadaOficina>();

	public Long getTiempoSalidas() {
		return tiempoSalidas;
	}

	public void setTiempoSalidas(Long tiempoSalidas) {
		this.tiempoSalidas = tiempoSalidas;
	}

	public Long getTiempoPermanencia() {
		return tiempoPermanencia;
	}

	public void setTiempoPermanencia(Long tiempoPermanencia) {
		this.tiempoPermanencia = tiempoPermanencia;
	}

	public Integer getOidLegajo() {
		return oidLegajo;
	}

	public void setOidLegajo(Integer oidLegajo) {
		this.oidLegajo = oidLegajo;
	}

	public String getLegajo() {
		return legajo;
	}

	public void setLegajo(String legajo) {
		this.legajo = legajo;
	}

	public String getApellidoNombre() {
		return apellidoNombre;
	}

	public void setApellidoNombre(String apellidoNombre) {
		this.apellidoNombre = apellidoNombre;
	}

	public Integer getCantSalInt() {
		return cantSalInt;
	}

	public void setCantSalInt(Integer cantSalInt) {
		this.cantSalInt = cantSalInt;
	}

	public Integer getCantEntInt() {
		return cantEntInt;
	}

	public void setCantEntInt(Integer cantEntInt) {
		this.cantEntInt = cantEntInt;
	}

	public Date getFecHorEntrada() {
		return fecHorEntrada;
	}

	public void setFecHorEntrada(Date fecHorEntrada) {
		this.fecHorEntrada = fecHorEntrada;
	}

	public Date getFecHorSalida() {
		return fecHorSalida;
	}

	public void setFecHorSalida(Date fecHorSalida) {
		this.fecHorSalida = fecHorSalida;
	}

	public Integer getSecu() {
		return secu;
	}

	public void setSecu(Integer secu) {
		this.secu = secu;
	}

	public List<CIPFichadaOficina> getFichadas() {
		return fichadas;
	}

	public void setFichadas(List<CIPFichadaOficina> fichadas) {
		this.fichadas = fichadas;
	}

	public String getHoraMinTiempoPermanencia() {
		if (this.tiempoPermanencia != null) {

			long hora = this.tiempoPermanencia / 3600;
			long min = this.tiempoPermanencia % 3600 / 60;
			long seg = this.tiempoPermanencia % 3600 % 60;

			return this.getFormatoHorMinSeg(hora) + ":" + this.getFormatoHorMinSeg(min) + ":" + this.getFormatoHorMinSeg(seg);

		}

		return "";
	}

	public String getHoraMinFecDesde() {
		if (this.getFecHorEntrada() != null) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(this.getFecHorEntrada());

			int hora = calendar.get(Calendar.HOUR_OF_DAY);
			int min = calendar.get(Calendar.MINUTE);
			int seg = calendar.get(Calendar.SECOND);

			return this.getFormatoHorMinSeg(new Long(hora)) + ":" + this.getFormatoHorMinSeg(new Long(min)) + ":" + this.getFormatoHorMinSeg(new Long(seg));
		}

		return "";
	}

	public String getHoraMinFecHasta() {
		if (this.getFecHorSalida() != null) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(this.getFecHorSalida());

			int hora = calendar.get(Calendar.HOUR_OF_DAY);
			int min = calendar.get(Calendar.MINUTE);
			int seg = calendar.get(Calendar.SECOND);

			return this.getFormatoHorMinSeg(new Long(hora)) + ":" + this.getFormatoHorMinSeg(new Long(min)) + ":" + this.getFormatoHorMinSeg(new Long(seg));
		}

		return "";
	}

	public String getHoraMinPermanenciaJornada() {
		Long segJornada = this.getCantSegPermanenciaJornada();
		if (segJornada > 0) {
			long hora = segJornada / 3600;
			long min = segJornada % 3600 / 60;
			long seg = segJornada % 3600 % 60;
			return this.getFormatoHorMinSeg(hora) + ":" + this.getFormatoHorMinSeg(min) + ":" + this.getFormatoHorMinSeg(seg);
		} else {
			return "";
		}
	}

	private long getCantSegPermanenciaJornada() {
		if (this.fecHorEntrada != null && this.fecHorSalida != null) {
			Calendar calendar1 = Calendar.getInstance();
			Calendar calendar2 = Calendar.getInstance();

			calendar1.setTime(this.fecHorEntrada);
			calendar2.setTime(this.fecHorSalida);

			return (calendar2.getTimeInMillis() - calendar1.getTimeInMillis()) / 1000;
		} else {
			return 0;
		}
	}

	public Long getMinTiempoSal() {
		if (this.tiempoSalidas != null) {
			return this.tiempoSalidas / 60;
		}

		return this.tiempoSalidas;
	}

	private String getFormatoHorMinSeg(Long num) {
		if (num < 10) {
			return "0" + num;
		}

		return num.toString();
	}

	public String getOKPermanenciaJornada(Integer cantMinPersJD, Integer cantMInPersJH) {
		Long segJornada = this.getCantSegPermanenciaJornada() / 60;
		if (segJornada >= cantMinPersJD && segJornada <= cantMInPersJH) {
			return "";
		} else {
			return "?";
		}
	}

	public String getOkCantSal(Integer cantSalD, Integer cantSalH) {
		if (this.cantSalInt >= cantSalD && this.cantSalInt <= cantSalH) {
			return "";
		} else {
			return "?";
		}
	}

	public String getOKCantMinAfu(Integer cantMinAfuD, Integer cantTMInAfuH) {
		Long min = this.getMinTiempoSal();
		if (min >= cantMinAfuD && min <= cantTMInAfuH) {
			return "";
		} else {
			return "?";
		}
	}

	public String getOKPermOfic(Integer cantPermOficD, Integer cantPermOficH) {
		Long min = this.tiempoPermanencia / 60;
		if (min >= cantPermOficD && min <= cantPermOficH) {
			return "";
		} else {
			return "?";
		}
	}

}
