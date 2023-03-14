package com.srn.erp.rrhh.bm;

import java.util.List;

import com.srn.erp.rrhh.da.DBObsLegajo;
import com.srn.erp.sueldos.bm.Legajo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;
import framework.request.bl.Utils.Validar;

public class ObsLegajo extends ObjetoLogico {

	public static final String OBS_POS_LEG = "POS";
	public static final String OBS_NEG_LEG = "NEG";
	public static final String OBS_NEU_LEG = "NEU";

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public ObsLegajo() {
	}

	public static String NICKNAME = "rh.ObsLegajo";

	private Legajo legajo;
	private TipoObsLeg tipo_obs_leg;
	private java.util.Date fecha;
	private java.util.Date fec_carga;
	private Usuario usuario_carga;
	private String observacion;
	private Boolean activo;
	private String posNegNeu;

	public Legajo getLegajo() throws BaseException {
		supportRefresh();
		return legajo;
	}

	public void setLegajo(Legajo aLegajo) {
		this.legajo = aLegajo;
	}

	public String getPosNegNeu() throws BaseException {
		supportRefresh();
		return this.posNegNeu;
	}

	public void setPosNegNeu(String aPosNegNeu) {
		this.posNegNeu = aPosNegNeu;
	}

	public TipoObsLeg getTipo_obs_leg() throws BaseException {
		supportRefresh();
		return tipo_obs_leg;
	}

	public void setTipo_obs_leg(TipoObsLeg aTipo_obs_leg) {
		this.tipo_obs_leg = aTipo_obs_leg;
	}

	public java.util.Date getFecha() throws BaseException {
		supportRefresh();
		return fecha;
	}

	public void setFecha(java.util.Date aFecha) {
		this.fecha = aFecha;
	}

	public java.util.Date getFec_carga() throws BaseException {
		supportRefresh();
		return fec_carga;
	}

	public void setFec_carga(java.util.Date aFec_carga) {
		this.fec_carga = aFec_carga;
	}

	public Usuario getUsuario_carga() throws BaseException {
		supportRefresh();
		return usuario_carga;
	}

	public void setUsuario_carga(Usuario aUsuario_carga) {
		this.usuario_carga = aUsuario_carga;
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

	public String getNickName() {
		return NICKNAME;
	}

	public static ObsLegajo findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (ObsLegajo) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static ObsLegajo findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (ObsLegajo) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(legajo, "Debe ingresar el Legajo");
		Validar.noNulo(tipo_obs_leg, "Debe ingresar el Tipo de Observación");
		Validar.noNulo(fecha, "Debe ingresar la fecha");
		Validar.noNulo(fec_carga, "Debe ingresar la Fecha de Carga");
		Validar.noNulo(usuario_carga, "Debe ingresar el Usuario");
		Validar.noNulo(observacion, "Debe ingresar la Observación");
	}

	public static List getObsLegajo(Legajo legajo, ISesion aSesion) throws BaseException {
		return DBObsLegajo.getObsLegajo(legajo, aSesion);
	}

	public static HashTableDatos getListaPosNegNeu() throws BaseException {
		HashTableDatos valores = new HashTableDatos();
		valores.put(OBS_POS_LEG,"Positivo");
		valores.put(OBS_NEG_LEG,"Negativo");
		valores.put(OBS_NEU_LEG,"Neutro");
		return valores;
	}
	
	public static ObsLegajo getUltObsLegajo(
			  Legajo legajo,
			  TipoObsLeg aTipoObsLeg,
			  java.util.Date fecDesde,
			  java.util.Date fecHasta,
	          ISesion aSesion)
	          throws BaseException {
		  return DBObsLegajo.getObsLegajo(legajo,aTipoObsLeg,fecDesde,fecHasta,aSesion);
	}	

}
