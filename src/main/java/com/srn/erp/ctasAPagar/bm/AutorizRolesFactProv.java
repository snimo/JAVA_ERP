package com.srn.erp.ctasAPagar.bm;

import java.util.List;

import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.compras.bm.RolAutorizadorCompras;
import com.srn.erp.ctacte.bm.TipoCtaCteProv;
import com.srn.erp.ctasAPagar.da.DBAutorizRolesFactProv;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class AutorizRolesFactProv extends ObjetoLogico {

	public static final int PEND_AUTORIZ = 0;
	public static final int AUTORIZ = 1;
	public static final int RECHAZADO = 2;
	
	public AutorizRolesFactProv() {
	}
	
	public static final String AUTORIZ_PAGO = "Autorizar Pago";

	public static String					NICKNAME	= "cap.AutorizRolesFactProv";

	private AutorizacionFactProv	autorizacion_fact_prov;

	private RolAutorizadorCompras	rol_autorizador;

	private java.util.Date				fec_lta;

	private String								tipo_autoriz;

	private java.util.Date				fecha_resp_aut;

	private Double								porc_aut_rec;

	private Double								monto_aut_rec;

	private Integer								estado;
	
	private String motivoAutorizacion;
	
	private Usuario usuario;

	public AutorizacionFactProv getAutorizacion_fact_prov() throws BaseException {
		supportRefresh();
		return autorizacion_fact_prov;
	}

	public void setMotivoAutorizacion(String aMotivoAutorizacion) {
		this.motivoAutorizacion = aMotivoAutorizacion;
	}
	
	public Usuario getUsuario() throws BaseException {
		supportRefresh();
		return usuario;
	}

	public void setUsuario(Usuario aUsuario) {
		this.usuario = aUsuario;
	}	
	
	public String getMotivoAutorizacion() throws BaseException {
		supportRefresh();
		return this.motivoAutorizacion;
	}

	public void setAutorizacion_fact_prov(AutorizacionFactProv aAutorizacion_fact_prov) {
		this.autorizacion_fact_prov = aAutorizacion_fact_prov;
	}
	

	public RolAutorizadorCompras getRol_autorizador() throws BaseException {
		supportRefresh();
		return rol_autorizador;
	}

	public void setRol_autorizador(RolAutorizadorCompras aRol_autorizador) {
		this.rol_autorizador = aRol_autorizador;
	}

	public java.util.Date getFec_lta() throws BaseException {
		supportRefresh();
		return fec_lta;
	}

	public void setFec_lta(java.util.Date aFec_lta) {
		this.fec_lta = aFec_lta;
	}

	public String getTipo_autoriz() throws BaseException {
		supportRefresh();
		return tipo_autoriz;
	}

	public void setTipo_autoriz(String aTipo_autoriz) {
		this.tipo_autoriz = aTipo_autoriz;
	}

	public java.util.Date getFecha_resp_aut() throws BaseException {
		supportRefresh();
		return fecha_resp_aut;
	}

	public void setFecha_resp_aut(java.util.Date aFecha_resp_aut) {
		this.fecha_resp_aut = aFecha_resp_aut;
	}

	public Double getPorc_aut_rec() throws BaseException {
		supportRefresh();
		return porc_aut_rec;
	}

	public void setPorc_aut_rec(Double aPorc_aut_rec) {
		this.porc_aut_rec = aPorc_aut_rec;
	}

	public Double getMonto_aut_rec() throws BaseException {
		supportRefresh();
		return monto_aut_rec;
	}

	public void setMonto_aut_rec(Double aMonto_aut_rec) {
		this.monto_aut_rec = aMonto_aut_rec;
	}

	public Integer getEstado() throws BaseException {
		supportRefresh();
		return estado;
	}

	public void setEstado(Integer aEstado) {
		this.estado = aEstado;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static AutorizRolesFactProv findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (AutorizRolesFactProv) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static AutorizRolesFactProv findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (AutorizRolesFactProv) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(autorizacion_fact_prov, "Debe ingresar el Autorizador Fact. Proveedor");
		Validar.noNulo(rol_autorizador, "Debe ingresar el Rol Autorizador");
		Validar.noNulo(fec_lta, "Debe ingresar la Fecha");
		Validar.noNulo(tipo_autoriz, "Debe ingresar el tipo de Autorización");
		Validar.noNulo(estado, "Debe ingresar el Estado de Autorización");
	}

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

	public static List getAutorizRolesFactProv(Proveedor proveedor, TipoCtaCteProv tipoCtaCteProv, java.util.Date fecha,
			ISesion aSesion) throws BaseException {
		return DBAutorizRolesFactProv.getAutorizRolesFactProv(proveedor, tipoCtaCteProv, fecha, aSesion);
	}

	public void afterSave() throws BaseException {
		// TODO Auto-generated method stub
		super.afterSave();
		
		// Analizar como queda el estado de la autorizacion
		 
	}
	
	public static List getAutorizRolesFactProv(AutorizacionFactProv autorizFactProv,ISesion aSesion) throws BaseException {
		return DBAutorizRolesFactProv.getAutorizRolesFactProv(autorizFactProv, aSesion);
	}
	

}
