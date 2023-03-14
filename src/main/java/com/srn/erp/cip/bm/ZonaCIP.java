package com.srn.erp.cip.bm;

import com.srn.erp.mensajero.bm.GrupoMaquina;
import com.srn.erp.mensajero.bm.GrupoUsuMens;
import com.srn.erp.mensajero.bm.Ring;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Parametros.ValorParametro;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.Validar;

public class ZonaCIP extends ObjetoLogico {

	public ZonaCIP() {
	}
	
	public static final String EST_ZONA_NORMAL = "NORMAL";
	public static final String EST_NH_PASE = "NO_PASE";
	public static final String EST_1 = "EST_1";
	public static final String EST_2 = "EST_2";
	public static final String EST_3 = "EST_3";
	
	public static String NICKNAME = "cip.ZonaCIP";

	private String codigo;
	private Boolean activo;
	private String color;
	private String descripcion;
	private TipoZona oid_tipo_zona;
	private Integer capacidad_max;
	private Integer alarma_de_cap;
	private Boolean bloquear_exc_cap;
	private String estado_zona;
	private String ubicacion;
	private GrupoUsuMens grupo_usu_alar;
	private GrupoMaquina grupo_maq_alar;
	private String mens_alar_cap_max;
	private Ring ring_max_cap;
	private boolean esExterna;
 	private boolean controlaAntiEnt;
 	private boolean controlaAntiSal;

	public boolean esExterna() throws BaseException {
		supportRefresh();
		return esExterna;
	}
	
	public boolean isControlaAntiEnt() throws BaseException {
		supportRefresh();
		return this.controlaAntiEnt;
	}
	
	public boolean isControlaAntiSal() throws BaseException {
		supportRefresh();
		return this.controlaAntiSal;
	}
	  
	public void setEsExterna(boolean aEsExterna) {
		this.esExterna =  aEsExterna;
	}
	
	public void setControlaAntiEnt(boolean aControlaAntiEnt) {
		this.controlaAntiEnt =  aControlaAntiEnt;
	}
	
	public void setControlaAntiSal(boolean aControlaAntiSal) {
		this.controlaAntiSal =  aControlaAntiSal;
	}

	public String getCodigo() throws BaseException {
		supportRefresh();
		return codigo;
	}

	public void setCodigo(String aCodigo) {
		this.codigo = aCodigo;
	}

	public Boolean isActivo() throws BaseException {
		supportRefresh();
		return activo;
	}

	public void setActivo(Boolean aActivo) {
		this.activo = aActivo;
	}

	public String getColor() throws BaseException {
		supportRefresh();
		return color;
	}

	public void setColor(String aColor) {
		this.color = aColor;
	}

	public String getDescripcion() throws BaseException {
		supportRefresh();
		return descripcion;
	}

	public void setDescripcion(String aDescripcion) {
		this.descripcion = aDescripcion;
	}

	public TipoZona getOid_tipo_zona() throws BaseException {
		supportRefresh();
		return oid_tipo_zona;
	}

	public void setOid_tipo_zona(TipoZona aOid_tipo_zona) {
		this.oid_tipo_zona = aOid_tipo_zona;
	}

	public Integer getCapacidad_max() throws BaseException {
		supportRefresh();
		return capacidad_max;
	}

	public void setCapacidad_max(Integer aCapacidad_max) {
		this.capacidad_max = aCapacidad_max;
	}

	public Integer getAlarma_de_cap() throws BaseException {
		supportRefresh();
		return alarma_de_cap;
	}

	public void setAlarma_de_cap(Integer aAlarma_de_cap) {
		this.alarma_de_cap = aAlarma_de_cap;
	}

	public Boolean isBloquear_exc_cap() throws BaseException {
		supportRefresh();
		return bloquear_exc_cap;
	}

	public void setBloquear_exc_cap(Boolean aBloquear_exc_cap) {
		this.bloquear_exc_cap = aBloquear_exc_cap;
	}

	public String getEstado_zona() throws BaseException {
		supportRefresh();
		return estado_zona;
	}

	public void setEstado_zona(String aEstado_zona) {
		this.estado_zona = aEstado_zona;
	}

	public String getUbicacion() throws BaseException {
		supportRefresh();
		return ubicacion;
	}

	public void setUbicacion(String aUbicacion) {
		this.ubicacion = aUbicacion;
	}

	public GrupoUsuMens getGrupo_usu_alar() throws BaseException {
		supportRefresh();
		return grupo_usu_alar;
	}

	public void setGrupo_usu_alar(GrupoUsuMens aGrupo_usu_alar) {
		this.grupo_usu_alar = aGrupo_usu_alar;
	}

	public GrupoMaquina getGrupo_maq_alar() throws BaseException {
		supportRefresh();
		return grupo_maq_alar;
	}

	public void setGrupo_maq_alar(GrupoMaquina aGrupo_maq_alar) {
		this.grupo_maq_alar = aGrupo_maq_alar;
	}

	public String getMens_alar_cap_max() throws BaseException {
		supportRefresh();
		return mens_alar_cap_max;
	}

	public void setMens_alar_cap_max(String aMens_alar_cap_max) {
		this.mens_alar_cap_max = aMens_alar_cap_max;
	}

	public Ring getRing_max_cap() throws BaseException {
		supportRefresh();
		return ring_max_cap;
	}

	public void setRing_max_cap(Ring aRing_max_cap) {
		this.ring_max_cap = aRing_max_cap;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static ZonaCIP findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (ZonaCIP) getObjectByOid(NICKNAME, oid, aSesion);
	}
	
	public static ZonaCIP findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (ZonaCIP) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}
	

	public static ZonaCIP findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (ZonaCIP) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(codigo, "Debe ingresar el Código");
		Validar.noNulo(oid_tipo_zona, "Debe ingresar el Tipo Zona");
		Validar.noNulo(this.estado_zona, "Debe ingresar el estado de la Zona");
	}
	
	public static HashTableDatos getEstados(ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(EST_ZONA_NORMAL,"Normal");
		condiciones.put(EST_NH_PASE,"No habilitar Pase");
		condiciones.put(EST_1 , ZonaCIP.getDescNomEst1Zona(aSesion));
		condiciones.put(EST_2 , ZonaCIP.getDescNomEst2Zona(aSesion));
		condiciones.put(EST_3 , ZonaCIP.getDescNomEst3Zona(aSesion));
		return condiciones;
	}
	
	public static String getDescNomEst1Zona(ISesion aSesion)
	throws BaseException {
		return ValorParametro.findByCodigoParametro(
				"NOM_EST_1_ZONA", aSesion).getValorCadena();
	}
	
	public static String getDescNomEst2Zona(ISesion aSesion)
	throws BaseException {
		return ValorParametro.findByCodigoParametro(
				"NOM_EST_2_ZONA", aSesion).getValorCadena();
	}
	
	public static String getDescNomEst3Zona(ISesion aSesion)
	throws BaseException {
		return ValorParametro.findByCodigoParametro(
				"NOM_EST_3_ZONA", aSesion).getValorCadena();
	}
	
	


}
