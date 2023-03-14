package com.srn.erp.compras.bm;

import java.util.List;

import com.srn.erp.compras.da.DBAutorizacionOC;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class AutorizacionOC extends ObjetoLogico {

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public AutorizacionOC() {
	}

	public static String					NICKNAME	= "cp.AutorizacionOC";

	private Integer								decision_autoriz;

	private OrdenDeCompraCab			orden_de_compra;

	private Usuario								usuario;

	private java.util.Date				fec_dec_autoriz;

	private String								comentario;

	private String								desc_motivo;

	private Boolean								activo;

	private String								tipo_motivo;

	private OrdenDeCompraDet			detalle_oc;

	private RolAutorizadorCompras	rol_autorizador;

	private java.util.Date				fec_alta;

	public Integer getDecision_autoriz() throws BaseException {
		supportRefresh();
		return decision_autoriz;
	}

	public void setDecision_autoriz(Integer aDecision_autoriz) {
		this.decision_autoriz = aDecision_autoriz;
	}

	public OrdenDeCompraCab getOrden_de_compra() throws BaseException {
		supportRefresh();
		return orden_de_compra;
	}

	public void setOrden_de_compra(OrdenDeCompraCab aOrden_de_compra) {
		this.orden_de_compra = aOrden_de_compra;
	}

	public Usuario getUsuario() throws BaseException {
		supportRefresh();
		return usuario;
	}

	public void setUsuario(Usuario aUsuario) {
		this.usuario = aUsuario;
	}

	public java.util.Date getFec_dec_autoriz() throws BaseException {
		supportRefresh();
		return fec_dec_autoriz;
	}

	public void setFec_dec_autoriz(java.util.Date aFec_dec_autoriz) {
		this.fec_dec_autoriz = aFec_dec_autoriz;
	}

	public String getComentario() throws BaseException {
		supportRefresh();
		return comentario;
	}

	public void setComentario(String aComentario) {
		this.comentario = aComentario;
	}

	public String getDesc_motivo() throws BaseException {
		supportRefresh();
		return desc_motivo;
	}

	public void setDesc_motivo(String aDesc_motivo) {
		this.desc_motivo = aDesc_motivo;
	}

	public Boolean isActivo() throws BaseException {
		supportRefresh();
		return activo;
	}

	public void setActivo(Boolean aActivo) {
		this.activo = aActivo;
	}

	public String getTipo_motivo() throws BaseException {
		supportRefresh();
		return tipo_motivo;
	}

	public void setTipo_motivo(String aTipo_motivo) {
		this.tipo_motivo = aTipo_motivo;
	}

	public OrdenDeCompraDet getDetalle_oc() throws BaseException {
		supportRefresh();
		return detalle_oc;
	}

	public void setDetalle_oc(OrdenDeCompraDet aDetalle_oc) {
		this.detalle_oc = aDetalle_oc;
	}

	public RolAutorizadorCompras getRol_autorizador() throws BaseException {
		supportRefresh();
		return rol_autorizador;
	}

	public void setRol_autorizador(RolAutorizadorCompras aRol_autorizador) {
		this.rol_autorizador = aRol_autorizador;
	}

	public java.util.Date getFec_alta() throws BaseException {
		supportRefresh();
		return fec_alta;
	}

	public void setFec_alta(java.util.Date aFec_alta) {
		this.fec_alta = aFec_alta;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static AutorizacionOC findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (AutorizacionOC) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static AutorizacionOC findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (AutorizacionOC) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(decision_autoriz, "Debe ingresar la Decisión");
		Validar.noNulo(orden_de_compra, "Debe ingresar la Orden de Compra");
		Validar.noNulo(tipo_motivo, "Debe ingresar el Motivo de Autorización");
		Validar.noNulo(rol_autorizador, "Debe ingresar el Rol autorizador");
		Validar.noNulo(fec_alta, "Debe ingresar la fecha ");
	}

	public static List getAutorizacionesOC(OrdenDeCompraCab ocCab, ISesion aSesion) throws BaseException {
		return DBAutorizacionOC.getAutorizacionOC(ocCab, aSesion);
	}

	public String getRolAutorizador() throws BaseException {
		StringBuffer roles = new StringBuffer("");
		supportRefresh();
		roles.append(" (");
		if (isPendAutorizar())
			roles.append("?");
		else if (isAutorizado())
			roles.append("Ok");
		else if (isRechazado())
			roles.append("X");
		roles.append(") " + this.getRol_autorizador().getDescripcion() + " - ");
		return roles.toString();
	}

	public boolean isPendAutorizar() throws BaseException {
		if (this.getDecision_autoriz().intValue() == OrdenDeCompraCab.PEND_AUTORIZ)
			return true;
		else
			return false;
	}

	public boolean isAutorizado() throws BaseException {
		if (this.getDecision_autoriz().intValue() == OrdenDeCompraCab.AUTORIZADA)
			return true;
		else
			return false;
	}

	public boolean isRechazado() throws BaseException {
		if (this.getDecision_autoriz().intValue() == OrdenDeCompraCab.RECHAZADA)
			return true;
		else
			return false;
	}
	
	public String getLeyendaDecisionAutoriz() throws BaseException {
		if (this.isPendAutorizar())
			return "Pendiente";
		else if (this.isAutorizado())
				return "Autorizado";
		else if (this.isRechazado())
				return "Rechazado";
		else return "";
	}
	

	
	
}
