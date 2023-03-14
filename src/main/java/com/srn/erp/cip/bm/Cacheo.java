package com.srn.erp.cip.bm;

import java.util.List;

import com.srn.erp.cip.da.DBCacheo;
import com.srn.erp.sueldos.bm.Legajo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Parametros.ValorParametro;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.Validar;

public class Cacheo extends ObjetoLogico {

	public static String CACHEO_NO_ING = "CACHEO_NO_ING";
	public static String CACHEO_ING = "CACHEO_ING";

	public static String CACHEO_NO_EGR = "CACHEO_NO_EGR";
	public static String CACHEO_EGR = "CACHEO_EGR";

	@Override
	protected void onNew() throws BaseException {
		// TODO Auto-generated method stub
		super.onNew();
		this.setRealizado(false);
		this.setLevantado(false);
		this.setNo_realizado(true);
		this.setActivo(true);
	}

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public Cacheo() {
	}

	public static String NICKNAME = "cip.Cacheo";

	private Legajo legajo;
	private java.util.Date fec_planif_cacheo;
	private java.util.Date fec_cacheo;
	private Boolean realizado;
	private Boolean activo;
	private Usuario usuario_cacheo;
	private String hora_cacheo;
	private java.util.Date fec_levantado;
	private Boolean levantado;
	private Boolean no_realizado;
	private String obs_cacheo;
	private String hora_levantado;
	private String ent_o_sal;
	private ResultadoCacheo est_res_cacheo;
	private Usuario usuario_levanto;
	private CacheoPersona cacheoPersona;
	private GrupoPuerta grupoPuerta;
	private Boolean intentoDePase;
	private FechaPlanifCacheo fecPlanifCacheo;

	public Legajo getLegajo() throws BaseException {
		supportRefresh();
		return legajo;
	}

	public void setLegajo(Legajo aLegajo) {
		this.legajo = aLegajo;
	}

	public FechaPlanifCacheo getFechaPlanifCacheo() throws BaseException {
		supportRefresh();
		return this.fecPlanifCacheo;
	}

	public void setFechaPlanifacheo(FechaPlanifCacheo aFechaPlanifCacheo) {
		this.fecPlanifCacheo = aFechaPlanifCacheo;
	}

	public Boolean isIntentoDePase() throws BaseException {
		supportRefresh();
		if (intentoDePase == null)
			return false;
		else
			return this.intentoDePase;
	}

	public void setIntentoDePase(Boolean aIntentoDePase) {
		this.intentoDePase = aIntentoDePase;
	}

	public GrupoPuerta getGrupoPuerta() throws BaseException {
		supportRefresh();
		return this.grupoPuerta;
	}

	public void setGrupoPuerta(GrupoPuerta aGrupoPuerta) {
		this.grupoPuerta = aGrupoPuerta;
	}

	public CacheoPersona getCacheoPersona() throws BaseException {
		supportRefresh();
		return cacheoPersona;
	}

	public void setCacheoPersona(CacheoPersona aCacheoPersona) {
		this.cacheoPersona = aCacheoPersona;
	}

	public java.util.Date getFec_planif_cacheo() throws BaseException {
		supportRefresh();
		return fec_planif_cacheo;
	}

	public void setFec_planif_cacheo(java.util.Date aFec_planif_cacheo) {
		this.fec_planif_cacheo = aFec_planif_cacheo;
	}

	public java.util.Date getFec_cacheo() throws BaseException {
		supportRefresh();
		return fec_cacheo;
	}

	public void setFec_cacheo(java.util.Date aFec_cacheo) {
		this.fec_cacheo = aFec_cacheo;
	}

	public Boolean isRealizado() throws BaseException {
		supportRefresh();
		return realizado;
	}

	public void setRealizado(Boolean aRealizado) {
		this.realizado = aRealizado;
	}

	public Boolean isActivo() throws BaseException {
		supportRefresh();
		return activo;
	}

	public void setActivo(Boolean aActivo) {
		this.activo = aActivo;
	}

	public Usuario getUsuario_cacheo() throws BaseException {
		supportRefresh();
		return usuario_cacheo;
	}

	public void setUsuario_cacheo(Usuario aUsuario_cacheo) {
		this.usuario_cacheo = aUsuario_cacheo;
	}

	public String getHora_cacheo() throws BaseException {
		supportRefresh();
		return hora_cacheo;
	}

	public void setHora_cacheo(String aHora_cacheo) {
		this.hora_cacheo = aHora_cacheo;
	}

	public java.util.Date getFec_levantado() throws BaseException {
		supportRefresh();
		return fec_levantado;
	}

	public void setFec_levantado(java.util.Date aFec_levantado) {
		this.fec_levantado = aFec_levantado;
	}

	public Boolean isLevantado() throws BaseException {
		supportRefresh();
		return levantado;
	}

	public void setLevantado(Boolean aLevantado) {
		this.levantado = aLevantado;
	}

	public Boolean isNo_realizado() throws BaseException {
		supportRefresh();
		return no_realizado;
	}

	public void setNo_realizado(Boolean aNo_realizado) {
		this.no_realizado = aNo_realizado;
	}

	public String getObs_cacheo() throws BaseException {
		supportRefresh();
		return obs_cacheo;
	}

	public void setObs_cacheo(String aObs_cacheo) {
		this.obs_cacheo = aObs_cacheo;
	}

	public String getHora_levantado() throws BaseException {
		supportRefresh();
		return hora_levantado;
	}

	public void setHora_levantado(String aHora_levantado) {
		this.hora_levantado = aHora_levantado;
	}

	public String getEnt_o_sal() throws BaseException {
		supportRefresh();
		return ent_o_sal;
	}

	public String getDesc_Ent_o_sal() throws BaseException {
		supportRefresh();
		if (ent_o_sal.equals("E"))
			return "Entrada";
		else if (ent_o_sal.equals("S"))
			return "Salida";
		return "";
	}

	public void setEnt_o_sal(String aEnt_o_sal) {
		this.ent_o_sal = aEnt_o_sal;
	}

	public ResultadoCacheo getEst_res_cacheo() throws BaseException {
		supportRefresh();
		return est_res_cacheo;
	}

	public void setEst_res_cacheo(ResultadoCacheo aEst_res_cacheo) {
		this.est_res_cacheo = aEst_res_cacheo;
	}

	public Usuario getUsuario_levanto() throws BaseException {
		supportRefresh();
		return usuario_levanto;
	}

	public void setUsuario_levanto(Usuario aUsuario_levanto) {
		this.usuario_levanto = aUsuario_levanto;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static Cacheo findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (Cacheo) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static Cacheo findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (Cacheo) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(legajo, "Debe ingresar el Legajo");
		Validar.noNulo(fec_planif_cacheo, "Debe ingresar la Fecha Planificada");
		Validar.noNulo(ent_o_sal, "Debe ingresar si es entrada o salida");
		Validar.noNulo(this.grupoPuerta, "Debe ingresar el grupo de puertas");
	}

	public static List getCacheos(java.util.Date fecDesde, java.util.Date fecHasta, ISesion aSesion) throws BaseException {
		return DBCacheo.getCacheos(fecDesde, fecHasta, aSesion);
	}

	public static HashTableDatos getTiposCacheoIngresos() throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(CACHEO_NO_ING, "No permitir ingreso");
		condiciones.put(CACHEO_ING, "Permitir ingreso");
		return condiciones;
	}

	public static HashTableDatos getTiposCacheoEgresos() throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(CACHEO_NO_EGR, "No permitir egreso");
		condiciones.put(CACHEO_EGR, "Permitir egreso");
		return condiciones;
	}

	public static Cacheo getCacheoPend(Integer oidLegajo, java.util.Date fecha, String entSal, ISesion aSesion) throws BaseException {
		return DBCacheo.getCacheoPend(oidLegajo, fecha, entSal, aSesion);
	}

	public static List getCacheoPendAHoy(Legajo legajo, java.util.Date fechaHasta, GrupoPuerta grupoPuerta, ISesion aSesion)
			throws BaseException {

		return DBCacheo.getCacheoPendAHoy(legajo, fechaHasta, grupoPuerta, aSesion);

	}

	public void marcarIntentoDePaso() throws BaseException {
		DBCacheo.marcarIntentoDePaso(this, this.getSesion());
	}

	public String getDescPuntoAcceso() throws BaseException {
		if (this.getGrupoPuerta() != null)
			return this.getGrupoPuerta().getDescripcion();
		else
			return "";
	}
	
	public static String getMensDispCacheo(ISesion aSesion)
	throws BaseException {
		return ValorParametro.findByCodigoParametro(
				"MENS_DISP_CACHEO", aSesion).getValorCadena();
	}
	

}
