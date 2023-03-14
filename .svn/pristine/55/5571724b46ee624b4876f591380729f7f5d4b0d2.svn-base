package com.srn.erp.cip.bm;

import java.util.Date;
import java.util.List;

import com.srn.erp.cip.da.DBNovedadPermisoCIP;
import com.srn.erp.sueldos.bm.Legajo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.Validar;

public class NovedadPermisoCIP extends ObjetoLogico {

	public static final String HAB_ING = "HAB_ING";
	public static final String DES_ING = "DES_ING";
	public static final String NA_ING = "NA_ING";

	public static final String HAB_EGR = "HAB_EGR";
	public static final String DES_EGR = "DES_EGR";
	public static final String NA_EGR = "NA_EGR";
			

	public static final String AMBOS = "AMBOS";

	public static final int PESO_NOVEDAD_MANUAL = 100;
	
	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void beforeSaveNew() throws BaseException {
		// TODO Auto-generated method stub
		super.beforeSaveNew();

		if (this.hora_desde == null)
			throw new ExceptionValidation(null, "Debe ingresar la fecha desde");

		if (this.hora_hasta == null)
			throw new ExceptionValidation(null, "Debe ingresar la fecha hasta");

		// Calcular a Minutos
		this.setHora_desde_en_min(UtilCIP.getHoraEnMin(this.hora_desde));
		this.setHora_hasta_en_min(UtilCIP.getHoraEnMin(this.hora_hasta));

	}

	public NovedadPermisoCIP() {
	}

	public static String NICKNAME = "cip.NovedadPermisoCIP";

	private MotivosNovCIP motivo;
	private java.util.Date fecha;
	private Legajo legajo;
	private String hora_desde;
	private String hora_hasta;
	private Integer hora_desde_en_min;
	private Integer hora_hasta_en_min;
	private GrupoPuerta grupo_puerta;
	private String observacion;
	private Boolean activo;
	private String permisoIngreso;
	private String permisoEgreso;
	private java.util.Date fec_usu_asig_perm;
	private Usuario usu_asig_permiso;
	private String hor_usu_asig_perm;
	private Boolean esNovExt;
	private String identifNovExt;
	private Integer pesoNovedad;

	public MotivosNovCIP getMotivo() throws BaseException {
		supportRefresh();
		return motivo;
	}

	public void setMotivo(MotivosNovCIP aMotivo) {
		this.motivo = aMotivo;
	}
	
	public Integer getPesoNovedad() throws BaseException {
		supportRefresh();
		return this.pesoNovedad;
	}

	public void setPesoNovedad(Integer aPesoNovedad) {
		this.pesoNovedad = aPesoNovedad;
	}
	
	
	public Boolean isNovedadExterna() throws BaseException {
		supportRefresh();
		return this.esNovExt;
	}

	public void setEsNovedadExterna(Boolean aNovExt) {
		this.esNovExt = aNovExt;
	}
	
	public String getIdentifNovExt() throws BaseException {
		supportRefresh();
		return this.identifNovExt;
	}

	public void setIdentifNovExt(String aIdentifNovExt) {
		this.identifNovExt = aIdentifNovExt; 
	}	
	

	public java.util.Date getFecha() throws BaseException {
		supportRefresh();
		return fecha;
	}

	public void setFecha(java.util.Date aFecha) {
		this.fecha = aFecha;
	}

	public Legajo getLegajo() throws BaseException {
		supportRefresh();
		return legajo;
	}

	public void setLegajo(Legajo aLegajo) {
		this.legajo = aLegajo;
	}

	public String getHora_desde() throws BaseException {
		supportRefresh();
		return hora_desde;
	}

	public void setHora_desde(String aHora_desde) {
		this.hora_desde = aHora_desde;
	}

	public String getHora_hasta() throws BaseException {
		supportRefresh();
		return hora_hasta;
	}

	public void setHora_hasta(String aHora_hasta) {
		this.hora_hasta = aHora_hasta;
	}

	public Integer getHora_desde_en_min() throws BaseException {
		supportRefresh();
		return hora_desde_en_min;
	}

	public void setHora_desde_en_min(Integer aHora_desde_en_min) {
		this.hora_desde_en_min = aHora_desde_en_min;
	}

	public Integer getHora_hasta_en_min() throws BaseException {
		supportRefresh();
		return hora_hasta_en_min;
	}

	public void setHora_hasta_en_min(Integer aHora_hasta_en_min) {
		this.hora_hasta_en_min = aHora_hasta_en_min;
	}

	public GrupoPuerta getGrupo_puerta() throws BaseException {
		supportRefresh();
		return grupo_puerta;
	}

	public void setGrupo_puerta(GrupoPuerta aGrupo_puerta) {
		this.grupo_puerta = aGrupo_puerta;
	}

	public String getObservacion() throws BaseException {
		supportRefresh();
		return observacion;
	}

	public void setObservacion(String aObservacion) {
		this.observacion = aObservacion;
	}

	public Boolean isActivo() throws BaseException {
		supportRefresh();
		return activo;
	}

	public void setActivo(Boolean aActivo) {
		this.activo = aActivo;
	}

	public String getPermisoIngreso() throws BaseException {
		supportRefresh();
		if (permisoIngreso==null)
			return "";
		else
			return permisoIngreso;
	}

	public void setPermisoIngreso(String aPermisoIngreso) {
		this.permisoIngreso = aPermisoIngreso;
	}

	public String getPermisoEgreso() throws BaseException {
		supportRefresh();
		if (permisoEgreso==null)
			return "";
		else
			return permisoEgreso;
	}

	public void setPermisoEgreso(String aPermisoEgreso) {
		this.permisoEgreso = aPermisoEgreso;
	}

	public java.util.Date getFec_usu_asig_perm() throws BaseException {
		supportRefresh();
		return fec_usu_asig_perm;
	}

	public void setFec_usu_asig_perm(java.util.Date aFec_usu_asig_perm) {
		this.fec_usu_asig_perm = aFec_usu_asig_perm;
	}

	public Usuario getUsu_asig_permiso() throws BaseException {
		supportRefresh();
		return usu_asig_permiso;
	}

	public void setUsu_asig_permiso(Usuario aUsu_asig_permiso) {
		this.usu_asig_permiso = aUsu_asig_permiso;
	}

	public String getHor_usu_asig_perm() throws BaseException {
		supportRefresh();
		return hor_usu_asig_perm;
	}

	public void setHor_usu_asig_perm(String aHor_usu_asig_perm) {
		this.hor_usu_asig_perm = aHor_usu_asig_perm;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static NovedadPermisoCIP findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (NovedadPermisoCIP) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static NovedadPermisoCIP findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (NovedadPermisoCIP) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(motivo, "Debe ingresar el Motivo");
		Validar.noNulo(fecha, "Debe ingresar la Fecha");
		Validar.noNulo(legajo, "Debe ingresar el Legajo");
		Validar.noNulo(hora_desde, "Debe ingresar la Hora Desde");
		Validar.noNulo(hora_hasta, "Debe ingresar la Hora Hasta");
		Validar.noNulo(grupo_puerta, "Debe ingresar el Punto de Acceso");
		Validar.noNulo(permisoIngreso, "Debe ingresar el Permiso de Ingreso");
		Validar.noNulo(permisoEgreso, "Debe ingresar el Permiso de Egreso");
		Validar.noNulo(fec_usu_asig_perm, "Fecha de alta de Usuario");
		Validar.noNulo(usu_asig_permiso, "Debe ingresar el Usuario");
		Validar.noNulo(hor_usu_asig_perm, "Debe ingresar la Hora de la Novedad");
	}

	public HashTableDatos getTiposNovPermisos() throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(HAB_ING, "Ingreso Habilitado");
		condiciones.put(DES_ING, "Ingreso denegado");
		condiciones.put(NA_ING, "No Aplica Ingreso");

		condiciones.put(HAB_EGR, "Egreso habilitado");
		condiciones.put(DES_EGR, "Egreso denegado");
		condiciones.put(NA_EGR, "No Aplica Egreso");

		return condiciones;
	}

	public boolean isIngresoHabilitado() throws BaseException {
		if (this.getPermisoIngreso().equals(HAB_ING))
			return true;
		else
			return false;
	}

	public boolean isIngresoDeshabilitado() throws BaseException {
		if (this.getPermisoIngreso().equals(DES_ING))
			return true;
		else
			return false;
	}

	public boolean isNAIngreso() throws BaseException {
		if (this.getPermisoIngreso().equals(NA_ING))
			return true;
		else
			return false;
	}

	public boolean isEgresoHabilitado() throws BaseException {
		if (this.getPermisoEgreso().equals(HAB_EGR))
			return true;
		else
			return false;
	}

	public boolean isEgresoDeshabilitado() throws BaseException {
		if (this.getPermisoEgreso().equals(DES_EGR))
			return true;
		else
			return false;
	}

	public boolean isNAEgreso() throws BaseException {
		if (this.getPermisoEgreso().equals(NA_EGR))
			return true;
		else
			return false;
	}

	public static HashTableDatos getHabilitaciones() throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(HAB_ING, "Ingreso");
		condiciones.put(HAB_EGR, "Egreso");
		return condiciones;
	}

	public static HashTableDatos getHabilitacionesYAmbos() throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(HAB_ING, "Ingreso");
		condiciones.put(HAB_EGR, "Egreso");
		condiciones.put(AMBOS, "Ambos (Ingreso y Egreso)");
		return condiciones;
	}

	public static HashTableDatos getInhabilitacionesYAmbos() throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(DES_ING, "Ingreso");
		condiciones.put(DES_EGR, "Egreso");
		condiciones.put(AMBOS, "Ambos (Ingreso y Egreso)");
		return condiciones;
	}

	public static List getNovedadesPermisosCIP(Legajo legajo, java.util.Date fecha, ISesion aSesion) throws BaseException {
		return DBNovedadPermisoCIP.getNovedadesPermisosCIP(legajo, fecha, aSesion);
	}

	public String getLeyendaPermisoNovedad() throws BaseException {

		StringBuffer leyenda = new StringBuffer("");

		if ((this.getPermisoIngreso()!=null) && (this.getPermisoIngreso().equals(NovedadPermisoCIP.HAB_ING)))
			leyenda.append("Puede ingresar ");
		else if ((this.getPermisoIngreso()!=null) && (this.getPermisoIngreso().equals(NovedadPermisoCIP.DES_ING)))
			leyenda.append("NO puede ingresar ");
		else if ((this.getPermisoIngreso()!=null) && (this.getPermisoIngreso().equals(NovedadPermisoCIP.NA_ING)))
			leyenda.append("Ingreso según Rota ");

		if ((this.getPermisoEgreso()!=null) && (this.getPermisoEgreso().equals(NovedadPermisoCIP.HAB_EGR))) {
			if (leyenda.length() != 0)
				leyenda.append("y ");
			leyenda.append("Puede salir ");
		} else if  ((this.getPermisoEgreso()!=null) && (this.getPermisoEgreso().equals(NovedadPermisoCIP.DES_EGR))) {
			if (leyenda.length() != 0)
				leyenda.append(" y ");
			leyenda.append("NO puede salir ");
		} else if  ((this.getPermisoEgreso()!=null) && (this.getPermisoEgreso().equals(NovedadPermisoCIP.NA_EGR))) {
			if (leyenda.length() != 0)
				leyenda.append(" y ");
			leyenda.append("Egreso según Rota ");			
		}

		
		String horaDesde = "";
		String horaHasta = "";
		
		if (this.getHora_desde()!=null)
			horaDesde = this.getHora_desde();
		
		if (this.getHora_hasta()!=null)
			horaHasta = this.getHora_hasta();
		
		if (
			((this.getPermisoIngreso()!=null) && (this.getPermisoIngreso().equals(NovedadPermisoCIP.HAB_ING)))
			||
			((this.getPermisoIngreso()!=null) && (this.getPermisoIngreso().equals(NovedadPermisoCIP.DES_ING)))
			||
			((this.getPermisoIngreso()!=null) && (this.getPermisoIngreso().equals(NovedadPermisoCIP.DES_EGR)))
			||
			((this.getPermisoEgreso()!=null) && (this.getPermisoEgreso().equals(NovedadPermisoCIP.HAB_EGR)))
			)			
			leyenda.append("de " + horaDesde + " a " + horaHasta);
		
		if (this.getMotivo().isAnulaRotaDelDia()) {
			leyenda.append(" (Anular Rota) ");
		}

		return leyenda.toString();

	}

	public boolean estaEnHorario(int horaEnMin) throws BaseException {
		if (((horaEnMin >= this.getHora_desde_en_min().intValue()) && (horaEnMin <= this.getHora_hasta_en_min().intValue())))
			return true;
		else
			return false;
	}
	
	public static List getNovedadesPermisosCIPAnuRota(
			  Legajo legajo,
			  java.util.Date fecha,
			  ISesion aSesion) throws BaseException {
		  return DBNovedadPermisoCIP.getNovedadesPermisosCIPAnuRota(legajo,fecha,aSesion);
	}
	
	public static int getMaximoMinEntAntes(
			java.util.Date fecha,
			Legajo legajo,
			ISesion aSesion) throws BaseException {

		return DBNovedadPermisoCIP.getMaximoMinEntAntes(fecha,legajo,aSesion);

	}
	
	public static int getMaximoMinEntDespues(
			java.util.Date fecha,
			Legajo legajo,
			ISesion aSesion) throws BaseException {
		
		return DBNovedadPermisoCIP.getMaximoMinEntDespues(fecha,legajo,aSesion);


	}

	public static List<NovedadPermisoCIP> getNovedadesByLegFechaDesdeFechaHasta(Legajo legajo, Date fecDesde, Date fecHasta, ISesion sesion) throws BaseException {
		return DBNovedadPermisoCIP.getNovedadesByLegFechaDesdeFechaHasta(legajo,fecDesde, fecHasta, sesion);
	}

	public static List<NovedadPermisoCIP> getNovedadesByFechaDesdeFechaHasta(Date fecDesde, Date fecHasta, ISesion sesion) throws BaseException {
		return DBNovedadPermisoCIP.getNovedadesByFechaDesdeFechaHasta(fecDesde, fecHasta, sesion);
	}
	
	

}
