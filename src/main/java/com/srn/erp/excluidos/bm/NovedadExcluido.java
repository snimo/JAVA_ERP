package com.srn.erp.excluidos.bm;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.srn.erp.cip.bm.UtilCIP;
import com.srn.erp.excluidos.da.DBNovedadExcluido;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.Fecha;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.Validar;

public class NovedadExcluido extends ObjetoLogico {

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public NovedadExcluido() {
	}

	public static String NICKNAME = "exc.NovedadExcluido";

	private java.util.Date fecha;
	private String hora;
	private EstadoExcluido estado;
	private LugarHechoExcluido lugar_del_hecho;
	private SeRetiraEnExc se_retira_en;
	private String hora_desde;
	private MotivoNovedadExcluido motivo;
	private TurnoExcluido turno;
	private String hora_hasta;
	private SupervisorExcluido supervisor;
	private String observacion;
	private java.util.Date vig_desde;
	private Boolean activo;
	private java.util.Date vig_hasta;
	private Boolean dejar_sin_efecto;
	private IndividuoExcluido individuo;
	private Integer nroActa;
	private Integer nroRevocamiento;
	private Date fecRevocamiento;
	private GerenteExcluido gerente;
	private Boolean irrevocable;
	private PredioExcluido predio;
	private Boolean restriccionAcceso;

	public java.util.Date getFecha() throws BaseException {
		supportRefresh();
		return fecha;
	}
	
	public PredioExcluido getPredio() throws BaseException {
		supportRefresh();
		return this.predio;
	}
	

	public void setFecha(java.util.Date aFecha) {
		this.fecha = aFecha;
	}
	
	public void setPredio(PredioExcluido aPredio) {
		this.predio = aPredio;
	}	

	public Boolean isIrrevocable() throws BaseException {
		supportRefresh();
		if (this.irrevocable == null)
			return false;
		else
			return this.irrevocable;
	}

	public void setIrrevocable(Boolean aIrrevocable) {
		this.irrevocable = aIrrevocable;
	}

	public GerenteExcluido getGerenteExcluido() throws BaseException {
		supportRefresh();
		return this.gerente;
	}

	public void setGerenteExcluido(GerenteExcluido aGerente) {
		this.gerente = aGerente;
	}

	public java.util.Date getFecRevocamiento() throws BaseException {
		supportRefresh();
		return this.fecRevocamiento;
	}

	public void setFecRevocamiento(java.util.Date aFecRevocamiento) {
		this.fecRevocamiento = aFecRevocamiento;
	}

	public Integer getnroActa() throws BaseException {
		supportRefresh();
		return this.nroActa;
	}

	public void setNroActa(Integer aNroActa) {
		this.nroActa = aNroActa;
	}

	public Integer getnroRevocamiento() throws BaseException {
		supportRefresh();
		return this.nroRevocamiento;
	}

	public void setNroRevocamiento(Integer aNroRevocamiento) {
		this.nroRevocamiento = aNroRevocamiento;
	}

	public IndividuoExcluido getIndividuoExcluido() throws BaseException {
		supportRefresh();
		return this.individuo;
	}

	public void setIndividuoExcluido(IndividuoExcluido aIndividuoExcluido) {
		this.individuo = aIndividuoExcluido;
	}

	public String getHora() throws BaseException {
		supportRefresh();
		return hora;
	}

	public void setHora(String aHora) {
		this.hora = aHora;
	}

	public EstadoExcluido getEstado() throws BaseException {
		supportRefresh();
		return estado;
	}

	public void setEstado(EstadoExcluido aEstado) {
		this.estado = aEstado;
	}

	public LugarHechoExcluido getLugar_del_hecho() throws BaseException {
		supportRefresh();
		return lugar_del_hecho;
	}

	public void setLugar_del_hecho(LugarHechoExcluido aLugar_del_hecho) {
		this.lugar_del_hecho = aLugar_del_hecho;
	}

	public SeRetiraEnExc getSe_retira_en() throws BaseException {
		supportRefresh();
		return se_retira_en;
	}

	public void setSe_retira_en(SeRetiraEnExc aSe_retira_en) {
		this.se_retira_en = aSe_retira_en;
	}

	public String getHora_desde() throws BaseException {
		supportRefresh();
		return hora_desde;
	}

	public void setHora_desde(String aHora_desde) {
		this.hora_desde = aHora_desde;
	}

	public MotivoNovedadExcluido getMotivo() throws BaseException {
		supportRefresh();
		return motivo;
	}

	public void setMotivo(MotivoNovedadExcluido aMotivo) {
		this.motivo = aMotivo;
	}

	public TurnoExcluido getTurno() throws BaseException {
		supportRefresh();
		return turno;
	}

	public void setTurno(TurnoExcluido aTurno) {
		this.turno = aTurno;
	}

	public String getHora_hasta() throws BaseException {
		supportRefresh();
		return hora_hasta;
	}

	public void setHora_hasta(String aHora_hasta) {
		this.hora_hasta = aHora_hasta;
	}

	public SupervisorExcluido getSupervisor() throws BaseException {
		supportRefresh();
		return supervisor;
	}

	public void setSupervisor(SupervisorExcluido aSupervisor) {
		this.supervisor = aSupervisor;
	}

	public String getObservacion() throws BaseException {
		supportRefresh();
		String result = "";
		if (observacion == null)
			return "";
		else {
			result = observacion.replaceAll("\n", "¬c¬n");
			result = result.replaceAll("\r", "");
			return result;
		}
	}

	public void setObservacion(String aObservacion) {
		this.observacion = aObservacion;
	}

	public java.util.Date getVig_desde() throws BaseException {
		supportRefresh();
		return vig_desde;
	}

	public void setVig_desde(java.util.Date aVig_desde) {
		this.vig_desde = aVig_desde;
	}

	public Boolean isActivo() throws BaseException {
		supportRefresh();
		return activo;
	}

	public void setActivo(Boolean aActivo) {
		this.activo = aActivo;
	}

	public java.util.Date getVig_hasta() throws BaseException {
		supportRefresh();
		return vig_hasta;
	}

	public void setVig_hasta(java.util.Date aVig_hasta) {
		this.vig_hasta = aVig_hasta;
	}

	public Boolean isDejar_sin_efecto() throws BaseException {
		supportRefresh();
		if (dejar_sin_efecto == null)
			return false;
		else
			return dejar_sin_efecto;
	}

	public void setDejar_sin_efecto(Boolean aDejar_sin_efecto) {
		this.dejar_sin_efecto = aDejar_sin_efecto;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static NovedadExcluido findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (NovedadExcluido) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static NovedadExcluido findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (NovedadExcluido) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static NovedadExcluido findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (NovedadExcluido) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(estado, "Debe ingresar el Estado");
		Validar.noNulo(predio, "Debe ingresar el Predio de la Novedad");
	}

	public static List getNovedadesExcluido(IndividuoExcluido individuo, ISesion aSesion) throws BaseException {
		return DBNovedadExcluido.getNovedadesExcluido(individuo, aSesion);
	}

	public boolean isVigente() throws BaseException {

		java.util.Date fechaActual = UtilCIP.getFechaHoraActual(this.getSesion());
		java.util.Date fecVigHastaConHora = getFechaVigHastaConHora();
		java.util.Date fecVigDesdeConHora = getFechaVigDesdeConHora();

		if (fecVigHastaConHora == null)
			return true;

		if (fecVigDesdeConHora == null) {
			if (fechaActual.before(fecVigHastaConHora))
				return true;
		} else {
			if ((fechaActual.before(fecVigHastaConHora)) && (fechaActual.after(fecVigDesdeConHora)))
				return true;
		}

		return false;

	}

	public java.util.Date getFechaVigDesdeConHora() throws BaseException {
		if (this.getVig_desde() == null)
			return null;
		Calendar cal = Calendar.getInstance();
		cal.setTime(this.getVig_desde());
		if (this.getHora_desde() == null) {
			cal.set(Calendar.HOUR_OF_DAY, 0);
			cal.set(Calendar.MINUTE, 0);
			cal.set(Calendar.SECOND, 0);
			cal.set(Calendar.MILLISECOND, 0);
			return cal.getTime();
		} else {
			Integer hora = 0;
			try {
				hora = new Integer(this.getHora_desde().substring(0, 2));
			} catch (Exception e) {

			}
			Integer min = 0;
			try {
				min = new Integer(this.getHora_desde().substring(3, 5));
			} catch (Exception e) {

			}
			cal.set(Calendar.HOUR_OF_DAY, hora);
			cal.set(Calendar.MINUTE, min);
			cal.set(Calendar.SECOND, 0);
			cal.set(Calendar.MILLISECOND, 0);
		}
		return cal.getTime();
	}

	public java.util.Date getFechaVigHastaConHora() throws BaseException {
		if (this.getVig_hasta() == null)
			return null;
		Calendar cal = Calendar.getInstance();
		cal.setTime(this.getVig_hasta());
		if (this.getHora_hasta() == null) {
			cal.set(Calendar.HOUR_OF_DAY, 0);
			cal.set(Calendar.MINUTE, 0);
			cal.set(Calendar.SECOND, 0);
			cal.set(Calendar.MILLISECOND, 0);
			return cal.getTime();
		} else {
			Integer hora = 0;
			try {
				hora = new Integer(this.getHora_hasta().substring(0, 2));
			} catch (Exception e) {

			}
			Integer min = 0;
			try {
				min = new Integer(this.getHora_hasta().substring(3, 5));
			} catch (Exception e) {

			}
			cal.set(Calendar.HOUR_OF_DAY, hora);
			cal.set(Calendar.MINUTE, min);
			cal.set(Calendar.SECOND, 0);
			cal.set(Calendar.MILLISECOND, 0);
		}
		return cal.getTime();
	}

	public String getDescVencimiento() throws BaseException {
		StringBuffer descVenc = new StringBuffer("");
		if (this.getVig_desde() != null) {
			descVenc.append("Del " + Fecha.getddmmyyyy(this.getVig_desde()));
			descVenc.append(" " + this.getHora_desde() + " ");
		}
		if (this.getVig_hasta() != null) {
			descVenc.append("al " + Fecha.getddmmyyyy(this.getVig_hasta()));
			descVenc.append(" " + this.getHora_hasta() );
		} else {
			descVenc.append("");
		}

		return descVenc.toString();
	}

	public static List getNovedadesEstadoyNroActa(EstadoExcluido estado, Integer nroActa, ISesion aSesion) throws BaseException {
		return DBNovedadExcluido.getNovedadesEstadoyNroActa(estado, nroActa, aSesion);
	}

	public static List getNovedadesDistIndEstadoyNroActa(Integer oidIndividuo, EstadoExcluido estado, Integer nroActa, ISesion aSesion)
			throws BaseException {
		return DBNovedadExcluido.getNovedadesDistIndEstadoyNroActa(oidIndividuo, estado, nroActa, aSesion);
	}
	
	public String getTiempo() throws BaseException {

		if (this.getVig_hasta() == null)
			return "Indefinido";
		else {
			// Hacer la diferencia entre fechas
			java.util.Date fecDesde = this.getVig_desde();
			if (fecDesde == null)
				return "Indefinido";
			int dias = Fecha.fechasDiferenciaEnDias(fecDesde, this.getVig_hasta());
			int aneos = dias / 365;
			
			if (aneos >= 80)
				return "Definitivo";
			
			if (aneos >= 1) {

				dias = dias - (aneos * 365);

				String descMeses = "";
				int meses = dias / 31;
				if (meses == 1)
					descMeses = " y 1 mes";
				if (meses > 1)
					descMeses = " y " + meses + " meses";

				if (aneos == 1)
					return aneos + " año" + descMeses;
				if (aneos > 1)
					return aneos + " años" + descMeses;

			}

			int meses = dias / 31;
			if (meses == 1)
				return meses + " mes";
			if (meses > 1)
				return meses + " meses";

			if (dias == 1)
				return "1 día";
			return dias + " días";

		}
		

	}	

	public String getCondicion() throws BaseException {

		if (isDejar_sin_efecto().booleanValue())
			return "Levantada";

		if (!isVigente())
			return "Vencida";

		if (this.getVig_hasta() == null)
			return "Indefinido";
		else {
			// Hacer la diferencia entre fechas
			java.util.Date fecDesde = null;
			// fecDesde = this.getVig_desde();
			// if (fecDesde == null)
			fecDesde = UtilCIP.getFechaHoraActual(this.getSesion());
			int dias = Fecha.fechasDiferenciaEnDias(fecDesde, this.getVig_hasta());
			int aneos = dias / 365;
			if (aneos >= 1) {

				dias = dias - (aneos * 365);

				String descMeses = "";
				int meses = dias / 31;
				if (meses == 1)
					descMeses = " y 1 mes";
				if (meses > 1)
					descMeses = " y " + meses + " meses";

				if (aneos == 1)
					return aneos + " año" + descMeses;
				if (aneos > 1) {
					if (aneos>80)
						return "Definitivo";
					return aneos + " años" + descMeses;
				}

			}

			int meses = dias / 31;
			if (meses == 1)
				return meses + " mes";
			if (meses > 1)
				return meses + " meses";

			if (dias == 1)
				return "1 día";
			return dias + " días";

		}

	}

	public static List getNovedadesByCondiciones(HashTableDatos condiciones, ISesion aSesion) throws BaseException {
		return DBNovedadExcluido.getNovedadesByCondiciones(condiciones, aSesion);
	}

	public Boolean isRestriccionAcceso() {
		return restriccionAcceso;
	}

	public void setRestriccionAcceso(Boolean restriccionAcceso) {
		this.restriccionAcceso = restriccionAcceso;
	}

}
