package com.srn.erp.cip.bm;

import java.util.Calendar;
import java.util.List;

import com.srn.erp.cip.da.DBMovimientoCIP;
import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.sueldos.bm.Legajo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Parametros.ValorParametro;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class MovimientoCIP extends ObjetoLogico {

	public static String MOV_ENT_CIP = "E";
	public static String MOV_SAL_CIP = "S";

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public MovimientoCIP() {
	}

	public static String NICKNAME = "cip.MovimientoCIP";

	private Legajo legajo;
	private Puerta puerta;
	private java.util.Date fecha;
	private String hora;
	private Integer hora_en_min;
	private String sentido;
	private Boolean activo;
	private java.util.Date fecHor;
	private ZonaCIP zonaOrigen;
	private ZonaCIP zonaDestino;

	public ZonaCIP getZonaOrigen() throws BaseException {
		supportRefresh();
		return this.zonaOrigen;
	}

	public void setZonaOrigen(ZonaCIP aZonaOrigen) {
		this.zonaOrigen = aZonaOrigen;
	}
	
	public ZonaCIP getZonaDestino() throws BaseException {
		supportRefresh();
		return this.zonaDestino;
	}

	public void setZonaDestino(ZonaCIP aZonaDestino) {
		this.zonaDestino = aZonaDestino;
	}
	
	
	
	public Legajo getLegajo() throws BaseException {
		supportRefresh();
		return legajo;
	}

	public void setLegajo(Legajo aLegajo) {
		this.legajo = aLegajo;
	}
	
	public java.util.Date getFecHor() throws BaseException {
		supportRefresh();
		return this.fecHor;
	}

	public void setFecHora(java.util.Date aFecHora) {
		this.fecHor = aFecHora;
	}
	

	public Puerta getPuerta() throws BaseException {
		supportRefresh();
		return puerta;
	}

	public void setPuerta(Puerta aPuerta) {
		this.puerta = aPuerta;
	}

	public java.util.Date getFecha() throws BaseException {
		supportRefresh();
		return fecha;
	}

	public void setFecha(java.util.Date aFecha) {
		this.fecha = aFecha;
	}

	public String getHora() throws BaseException {
		supportRefresh();
		return hora;
	}

	public void setHora(String aHora) {
		this.hora = aHora;
	}

	public Integer getHora_en_min() throws BaseException {
		supportRefresh();
		return hora_en_min;
	}

	public void setHora_en_min(Integer aHora_en_min) {
		this.hora_en_min = aHora_en_min;
	}

	public String getSentido() throws BaseException {
		supportRefresh();
		return sentido;
	}

	public void setSentido(String aSentido) {
		this.sentido = aSentido;
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

	public static MovimientoCIP findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (MovimientoCIP) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static MovimientoCIP findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (MovimientoCIP) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(legajo, "Debe ingresar el Legajo");
		Validar.noNulo(puerta, "Debe ingresar la Puerta");
		Validar.noNulo(fecha, "Debe ingresar la Fecha");
		Validar.noNulo(hora, "Debe ingresar la Hora");
		Validar.noNulo(hora_en_min, "Debe ingresar los Minutos");
		Validar.noNulo(sentido, "Debe ingresar el sendito");
	}

	public boolean isMovEntrada() throws BaseException {
		if (this.getSentido().equals(MOV_ENT_CIP))
			return true;
		else
			return false;
	}

	public boolean isMovSalida() throws BaseException {
		if (this.getSentido().equals(MOV_SAL_CIP))
			return true;
		else
			return false;
	}

	public static List getMovimientosCIP(java.util.Date fecDesde, java.util.Date fecHasta, ClasificadorEntidad titulo, List listaLegajos,
			List listaValoresClasif, ISesion aSesion) throws BaseException {
		return DBMovimientoCIP.getMovimientosCIP(fecDesde, fecHasta, titulo, listaLegajos, listaValoresClasif, aSesion);
	}
	
	public static List getMovimientosLegajoUltDia(
			Legajo legajo,
			ISesion aSesion) throws BaseException {

		return DBMovimientoCIP.getMovimientosLegajoUltDia(legajo,aSesion);
		
	}

	
	public boolean getTiempoPermanenciaMenorAXMinutos(long minutos) throws BaseException {
				
		String horaTexto = this.getHora().substring(0,2);
		String minutosTexto = this.getHora().substring(3,5);		
		
		Calendar previous = Calendar.getInstance();
		previous.setTime(this.getFecha());
		previous.set(Calendar.HOUR, new Integer(horaTexto));
		previous.set(Calendar.MINUTE, new Integer(minutosTexto));
		previous.set(Calendar.SECOND, 0);
		previous.set(Calendar.MILLISECOND, 0);
					
		Calendar now = Calendar.getInstance();
		now.setTime(UtilCIP.getFechaHoraActual(this.getSesion()));		
		
		long diff = now.getTimeInMillis() - previous.getTimeInMillis();
		if(diff <= minutos * 60 * 1000)
		{
		    return true;
		}
		return false;
	}
	
	public static Integer getMaxHorasPermanencia(ISesion aSesion)
	throws BaseException {
		try {
			Integer horas = ValorParametro.findByCodigoParametro(
					"TIE_VAL_HOR_PERM_PRE", aSesion).getValorEntero();
			return horas;
		}
		catch(Exception e) {
			return 24;
		}
	}	
	
	
	

}


