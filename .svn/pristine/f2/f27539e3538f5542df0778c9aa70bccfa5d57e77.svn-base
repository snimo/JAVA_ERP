package com.srn.erp.compras.bm;

import java.util.Hashtable;
import java.util.List;

import com.srn.erp.compras.da.DBRequisicionDetAutorizacion;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;
import framework.request.bl.Utils.Validar;

public class RequisicionDetAutorizacion extends ObjetoLogico {

	public static final Integer PEND_AUTORIZ = new Integer(0);

	public static final Integer AUTORIZADO = new Integer(1);

	public static final Integer RECHAZADO = new Integer(2);

	public Boolean isActivo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public RequisicionDetAutorizacion() {
	}

	public static String NICKNAME = "cp.RequisicionDetAutorizacion";

	private RequisicionDet requesicion_detalle;

	private Usuario usuario;

	private Integer decision_autoriz;

	private java.util.Date fec_decision;

	private String comentario;

	private String tipo_autorizacion;

	private RolAutorizadorCompras rolAutorizador;

	public RequisicionDet getRequesicion_detalle() throws BaseException {
		supportRefresh();
		return requesicion_detalle;
	}

	public void setRequesicion_detalle(RequisicionDet aRequesicion_detalle) {
		this.requesicion_detalle = aRequesicion_detalle;
	}

	public RolAutorizadorCompras getRolAutorizadorCompras()
			throws BaseException {
		supportRefresh();
		return rolAutorizador;
	}

	public void setRolAutorizador(RolAutorizadorCompras aRolAutorizadorCompras) {
		this.rolAutorizador = aRolAutorizadorCompras;
	}

	public Usuario getUsuario() throws BaseException {
		supportRefresh();
		return usuario;
	}

	public void setUsuario(Usuario aUsuario) {
		this.usuario = aUsuario;
	}

	public Integer getDecision_autoriz() throws BaseException {
		supportRefresh();
		return decision_autoriz;
	}

	public void setDecision_autoriz(Integer aDecision_autoriz) {
		this.decision_autoriz = aDecision_autoriz;
	}

	public java.util.Date getFec_decision() throws BaseException {
		supportRefresh();
		return fec_decision;
	}

	public void setFec_decision(java.util.Date aFec_decision) {
		this.fec_decision = aFec_decision;
	}

	public String getComentario() throws BaseException {
		supportRefresh();
		return comentario;
	}

	public void setComentario(String aComentario) {
		this.comentario = aComentario;
	}

	public String getTipo_autorizacion() throws BaseException {
		supportRefresh();
		return tipo_autorizacion;
	}

	public void setTipo_autorizacion(String aTipo_autorizacion) {
		this.tipo_autorizacion = aTipo_autorizacion;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static RequisicionDetAutorizacion findByOid(Integer oid,
			ISesion aSesion) throws BaseException {
		return (RequisicionDetAutorizacion) getObjectByOid(NICKNAME, oid,
				aSesion);
	}

	public static RequisicionDetAutorizacion findByCodigo(String codigo,
			ISesion aSesion) throws BaseException {
		return (RequisicionDetAutorizacion) getObjectByCodigo(NICKNAME, codigo,
				aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(requesicion_detalle,
				"Debe ingresar la Requesición Detalle");
		Validar.noNulo(decision_autoriz, "Debe ingresar el estado de Decisión");
		Validar.noNulo(tipo_autorizacion,
				"Debe ingresar el tipo de Autorización");
	}

	public static List getAutorizadoresRequisicionDet(
			RequisicionDet requisicionDet, ISesion aSesion)
			throws BaseException {
		return DBRequisicionDetAutorizacion.getAutorizadoresRequisicionDet(
				requisicionDet, aSesion);
	}

	
	public static Hashtable getEstados() throws BaseException {
		Hashtable estados = new Hashtable();
		estados.put(PEND_AUTORIZ, "Pend. Autorización");
		estados.put(AUTORIZADO, "Autorizado");
		estados.put(RECHAZADO, "Rechazado");
		return estados;
	}
	
	
	public boolean autorizar() throws BaseException {
		Integer oidUsuario = getSesion().getLogin().getUsuario().getOIDInteger();
		Usuario usuario = Usuario.findByOidProxy(oidUsuario,getSesion());
		if (isAutorizado())
			return true;
		else if (isPendAutorizar()) {  
			if (getRolAutorizadorCompras().tieneElRol(usuario)) {
				setDecision_autoriz(AUTORIZADO);
				setFec_decision(Fecha.getFechaActual());
				return true;
				}	
			 else return false;
			 }
		else if (isRechazado()) {
			if (getRolAutorizadorCompras().tieneElRol(usuario)) {
				setDecision_autoriz(AUTORIZADO);
				setFec_decision(Fecha.getFechaActual());
				return true;
				}
			else
				return false;
		}
			return false; // Se encuentra rechazado
	}
	
	
	
	
	public boolean rechazar() throws BaseException {
		Integer oidUsuario = getSesion().getLogin().getUsuario().getOIDInteger();
		Usuario usuario = Usuario.findByOidProxy(oidUsuario,getSesion());
		if (isPendAutorizar() || isAutorizado()) {  
			if (getRolAutorizadorCompras().tieneElRol(usuario)) {
				setDecision_autoriz(RECHAZADO);
				setFec_decision(Fecha.getFechaActual());
				return true;
				}	
			 else return false;
			 }
		else return true; // Se encuentra rechazado
	}	
	
	public boolean isAutorizado() throws BaseException {
		supportRefresh();
		if (getDecision_autoriz().intValue()==AUTORIZADO.intValue())
			return true;
		else
			return false;
	}
	
	public boolean isRechazado() throws BaseException {
		supportRefresh();
		if (getDecision_autoriz().intValue()==RECHAZADO.intValue())
			return true;
		else
			return false;
	}
	
	
	public boolean isPendAutorizar() throws BaseException {
		supportRefresh();
		if (getDecision_autoriz().intValue()==PEND_AUTORIZ.intValue())
			return true;
		else
			return false;
	}
	
	public boolean isNecesario() throws BaseException {
		if (this.getTipo_autorizacion().equals(AutorizadorRequisicion.TIPO_AUTORIZ_NECESARIO))
			return true;
		else
			return false;
	}
	
	
	public boolean isSuficiente() throws BaseException {
		if (this.getTipo_autorizacion().equals(AutorizadorRequisicion.TIPO_AUTORIZ_SUFICIENTE))
			return true;
		else
			return false;
	}
	
	public static String getDescAutoriz(int estadoAutoriz) throws BaseException {
		
		if (PEND_AUTORIZ.intValue() == estadoAutoriz)
			return "Pend. Autorizar";
		else if (AUTORIZADO.intValue() == estadoAutoriz)
			return "Autorizado";
		else if (RECHAZADO.intValue() == estadoAutoriz)
			return "Rechazado";
		else
			return "?";
	}
	
	public static RequisicionDetAutorizacion getAutorizadorRequisicionDet(
			RequisicionDet requisicionDet,
			RolAutorizadorCompras rolAutorizCompras,
			ISesion aSesion)
			throws BaseException {		
		return DBRequisicionDetAutorizacion.getAutorizadorRequisicionDet(requisicionDet,rolAutorizCompras,aSesion);
	}	
	
	

}
