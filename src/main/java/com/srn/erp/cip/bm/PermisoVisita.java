package com.srn.erp.cip.bm;

import java.util.List;

import com.srn.erp.cip.da.DBPermisoVisita;
import com.srn.erp.sueldos.bm.Legajo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.Validar;

public class PermisoVisita extends ObjetoLogico {

	public PermisoVisita() {
	}
	
	public static final String SENTIDO_E = "E";
	public static final String SENTIDO_S = "S";
	public static final String SENTIDO_A = "A"; //AMBOS
	
	public static final int PRIO_VIS_MANUAL = 10;
	public static final int PRIO_ASIG_TARJ = 100;
	
	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public static String NICKNAME = "cip.PermisoVisita";

	private Integer prioridad;
	private Visita visita;
	private String permiso;
	private java.util.Date fec_hor_desde;
	private java.util.Date fec_hor_hasta;
	private GrupoPuerta grupo_puerta;
	private Boolean activo;
	private TarjetaCIP tarjeta;
	private String sentido;
	private MotivoVisita motivoVisita;
	private String comentario;
	private Legajo visitaA;
	private Legajo autoriza;

	public Integer getPrioridad() throws BaseException {
		supportRefresh();
		return prioridad;
	}
	
	public MotivoVisita getMotivoVisita() throws BaseException {
		supportRefresh();
		return this.motivoVisita;
	}
	
	public Legajo getVisitaA() throws BaseException {
		supportRefresh();
		return this.visitaA;
	}
	
	public Legajo getAutoriza() throws BaseException {
		supportRefresh();
		return this.autoriza;
	}
	
	
	public String getComentario() throws BaseException {
		supportRefresh();
		return comentario;
	}
	
	public void setComentario(String aComentario) {
		this.comentario = aComentario;
	}
	
	public void setVisitaA(Legajo aVisita) {
		this.visitaA = aVisita;
	}
	
	public void setAutoriza(Legajo aAutoriza) {
		this.autoriza = aAutoriza;
	}
	
	public String getSentido() throws BaseException {
		supportRefresh();
		return sentido;
	}

	public void setPrioridad(Integer aPrioridad) {
		this.prioridad = aPrioridad;
	}
	
	public void setMotivoVisita(MotivoVisita aMotivoVisita) {
		this.motivoVisita = aMotivoVisita;
	}
	
	
	public void setSentido(String aSentido) {
		this.sentido = aSentido;
	}
	
	
	public TarjetaCIP getTarjetaCIP() throws BaseException {
		supportRefresh();
		return tarjeta;
	}

	public void setTarjeta(TarjetaCIP aTarjetaCIP) {
		this.tarjeta = aTarjetaCIP;
	}
	

	public Visita getVisita() throws BaseException {
		supportRefresh();
		return visita;
	}

	public void setVisita(Visita aVisita) {
		this.visita = aVisita;
	}

	public String getPermiso() throws BaseException {
		supportRefresh();
		return permiso;
	}

	public void setPermiso(String aPermiso) {
		this.permiso = aPermiso;
	}

	public java.util.Date getFec_hor_desde() throws BaseException {
		supportRefresh();
		return fec_hor_desde;
	}

	public void setFec_hor_desde(java.util.Date aFec_hor_desde) {
		this.fec_hor_desde = aFec_hor_desde;
	}

	public java.util.Date getFec_hor_hasta() throws BaseException {
		supportRefresh();
		return fec_hor_hasta;
	}

	public void setFec_hor_hasta(java.util.Date aFec_hor_hasta) {
		this.fec_hor_hasta = aFec_hor_hasta;
	}

	public GrupoPuerta getGrupo_puerta() throws BaseException {
		supportRefresh();
		return grupo_puerta;
	}

	public void setGrupo_puerta(GrupoPuerta aGrupo_puerta) {
		this.grupo_puerta = aGrupo_puerta;
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

	public static PermisoVisita findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (PermisoVisita) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static PermisoVisita findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (PermisoVisita) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(visita, "Debe ingresar la Visita");
		Validar.noNulo(permiso, "Debe ingresar el Permiso");
		Validar.noNulo(fec_hor_desde, "Debe ingresar la fecha hora desde");
		Validar.noNulo(fec_hor_hasta, "Debe ingresar la fecha hora hasta");
		Validar.noNulo(grupo_puerta, "No se pudo determinar el Grupo de Puertas habilitado para la visita");
	}
	
	  public static List getPermisosVisitaEntradas(
			  Visita visita,
			  String permiso,
			  java.util.Date fecha,
			  ISesion aSesion) throws BaseException {

		    return DBPermisoVisita.getPermisosVisitaEntradas(visita,permiso,fecha,aSesion);
		  
	  }
	  
	  public static List getPermisosVisitaSalidas(
			  Visita visita,
			  String permiso,
			  java.util.Date fecha,
			  ISesion aSesion) throws BaseException {

		    return DBPermisoVisita.getPermisosVisitaSalidas(visita,permiso,fecha,aSesion);
		  
	  }
	  
	  public static void desactivarPermisosTarjeta(TarjetaCIP tarjeta,
		      ISesion aSesion)
		  throws BaseException {
		  	DBPermisoVisita.desactivarPermisosTarjeta(tarjeta,aSesion);
	  }
	  
	  public static List getPermisosVisitaEntradasPriAlta(
			  Visita visita,
			  String permiso,
			  java.util.Date fecha,
			  ISesion aSesion) throws BaseException {

		    return DBPermisoVisita.getPermisosVisitaEntradasPriAlta(visita,permiso,fecha,aSesion);
		  
	  }
	  
	  public static List getPermisosVisitaEntradasPriBaja(
			  Visita visita,
			  String permiso,
			  java.util.Date fecha,
			  ISesion aSesion) throws BaseException {

		    return DBPermisoVisita.getPermisosVisitaEntradasPriBaja(visita,permiso,fecha,aSesion);
		  
	  }
	  
	

}
