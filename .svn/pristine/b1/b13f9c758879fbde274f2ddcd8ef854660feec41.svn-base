package com.srn.erp.rrhh.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.cip.bm.Rota;
import com.srn.erp.rrhh.da.DBGrabarConsRotasCab;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class GrabarConsRotasCab extends ObjetoLogico {

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	private List detalles = new ArrayList();
	private boolean readDetalles = true;
	
	public GrabarConsRotasCab() {
	}

	public static String NICKNAME = "rh.GrabarConsRotasCab";

	private String descripcion;
	private FiltroLegCab filtro;
	private java.util.Date fec_desde;
	private java.util.Date fec_hasta;
	private Rota rota;
	private String juegos_sep_por_comas;
	private Boolean no_most_si_franco;
	private Usuario usuario;
	private java.util.Date fecha_grab;
	private String hora_grab;
	private Boolean activo;
	private Integer dias;
	private String agrupador;
	private Integer nroConsulta;

	public String getDescripcion() throws BaseException {
		supportRefresh();
		return descripcion;
	}
	
	public Integer getNroConsulta() throws BaseException {
		supportRefresh();
		return this.nroConsulta;
	}	
	
	public String getAgrupador() throws BaseException {
		supportRefresh();
		return agrupador;
	}	

	public Integer getDias() throws BaseException {
		supportRefresh();
		return this.dias;
	}

	public void setDescripcion(String aDescripcion) {
		this.descripcion = aDescripcion;
	}
	
	public void setNroConsulta(Integer aNroConsulta) {
		this.nroConsulta = aNroConsulta;
	}	
	
	public void setAgrupador(String aAgrupador) {
		this.agrupador = aAgrupador;
	}	

	public void setDias(Integer aDias) {
		this.dias = aDias;
	}

	public FiltroLegCab getFiltro() throws BaseException {
		supportRefresh();
		return filtro;
	}

	public void setFiltro(FiltroLegCab aFiltro) {
		this.filtro = aFiltro;
	}

	public java.util.Date getFec_desde() throws BaseException {
		supportRefresh();
		return fec_desde;
	}

	public void setFec_desde(java.util.Date aFec_desde) {
		this.fec_desde = aFec_desde;
	}

	public java.util.Date getFec_hasta() throws BaseException {
		supportRefresh();
		return fec_hasta;
	}

	public void setFec_hasta(java.util.Date aFec_hasta) {
		this.fec_hasta = aFec_hasta;
	}

	public Rota getRota() throws BaseException {
		supportRefresh();
		return rota;
	}

	public void setRota(Rota aRota) {
		this.rota = aRota;
	}

	public String getJuegos_sep_por_comas() throws BaseException {
		supportRefresh();
		return juegos_sep_por_comas;
	}

	public void setJuegos_sep_por_comas(String aJuegos_sep_por_comas) {
		this.juegos_sep_por_comas = aJuegos_sep_por_comas;
	}

	public Boolean isNo_most_si_franco() throws BaseException {
		supportRefresh();
		return no_most_si_franco;
	}

	public void setNo_most_si_franco(Boolean aNo_most_si_franco) {
		this.no_most_si_franco = aNo_most_si_franco;
	}

	public Usuario getUsuario() throws BaseException {
		supportRefresh();
		return usuario;
	}

	public void setUsuario(Usuario aUsuario) {
		this.usuario = aUsuario;
	}

	public java.util.Date getFecha_grab() throws BaseException {
		supportRefresh();
		return fecha_grab;
	}

	public void setFecha_grab(java.util.Date aFecha_grab) {
		this.fecha_grab = aFecha_grab;
	}

	public String getHora_grab() throws BaseException {
		supportRefresh();
		return hora_grab;
	}

	public void setHora_grab(String aHora_grab) {
		this.hora_grab = aHora_grab;
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

	public static GrabarConsRotasCab findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (GrabarConsRotasCab) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static GrabarConsRotasCab findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (GrabarConsRotasCab) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static GrabarConsRotasCab findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (GrabarConsRotasCab) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(descripcion, "Debe ingresar la Descripción de la Consulta que quiere grabar.");
		Validar.noNulo(filtro, "Debe ingresar el Filtro");
		Validar.noNulo(fec_desde, "Debe ingresar la Fecha Desde");
		Validar.noNulo(fec_hasta, "Debe ingresar la Fecha Hasta");
		Validar.noNulo(rota, "Debe ingresar la Rota");
		Validar.noNulo(usuario, "");
		Validar.noNulo(fecha_grab, "");
		Validar.noNulo(hora_grab, "");
	}

	public List getConsRotasDet() throws BaseException {
		if (this.readDetalles) {
			List listaConsDet = GrabarConsRotasDet.getConsRotasDet(this, getSesion());
			this.detalles.addAll(listaConsDet);
			this.readDetalles = false;
		}
		return this.detalles;
	}

	public void addConsultaRotaDet(GrabarConsRotasDet aGrabarConsRotasDet) throws BaseException {
		aGrabarConsRotasDet.setGrab_cons_rota(this);
		this.detalles.add(aGrabarConsRotasDet);
	}

	public void afterSave() throws BaseException {
		Iterator iterDetalles = detalles.iterator();
		while (iterDetalles.hasNext()) {
			GrabarConsRotasDet grabarConsRotasDet = (GrabarConsRotasDet) iterDetalles.next();
			grabarConsRotasDet.save();
			grabarConsRotasDet = null;
		}
		iterDetalles = null;
	}
	
	 public static List getConsRotasGrabadas(
			  Usuario usuario,
			  java.util.Date fecha,
			  Integer nroConsulta,
	          ISesion aSesion) throws BaseException {
		  return DBGrabarConsRotasCab.getConsRotasGrabadas(usuario,fecha,nroConsulta,aSesion);
	 }	
	 
	 public static List getConsRotasGrabadasFecRota(
			  Usuario usuario,
			  java.util.Date fecha,
			  Integer nroConsulta,
	          ISesion aSesion) throws BaseException {
		  return DBGrabarConsRotasCab.getConsRotasGrabadasFecRota(usuario,fecha,nroConsulta,aSesion);
	 }	 

}
