package com.srn.erp.compras.bm;

import java.util.List;

import com.srn.erp.compras.da.DBSolicitudCotizDetPorProv;
import com.srn.erp.compras.da.DBSolicitudCotizProveedor;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;
import framework.request.bl.Utils.Validar;

public class SolicitudCotizProveedor extends ObjetoLogico {

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean isActivo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public SolicitudCotizProveedor() {
	}

	public static String NICKNAME = "cp.SolicitudCotizProveedor";

	private SolicitudCotizProvCab solicitud_cotizacion;
	private Proveedor proveedor;
	private Boolean impresa;
	private Usuario usuario_impresion;
	private java.util.Date fec_impresion;
	private java.util.Date fec_envio_sol;
	private Boolean enviada;
	private Boolean conf_recep_sol;
	private java.util.Date fec_recep_conf_sol;
	private Boolean prov_ent_sol;
	private java.util.Date fec_rec_sol_cotiz;
	private Boolean presu_recibido;
	private java.util.Date fec_presu_recibido;

	public SolicitudCotizProvCab getSolicitud_cotizacion() throws BaseException {
		supportRefresh();
		return solicitud_cotizacion;
	}

	public void setSolicitud_cotizacion(SolicitudCotizProvCab aSolicitud_cotizacion) {
		this.solicitud_cotizacion = aSolicitud_cotizacion;
	}

	public Proveedor getProveedor() throws BaseException {
		supportRefresh();
		return proveedor;
	}

	public void setProveedor(Proveedor aProveedor) {
		this.proveedor = aProveedor;
	}

	public Boolean isImpresa() throws BaseException {
		supportRefresh();
		return impresa;
	}

	public void setImpresa(Boolean aImpresa) {
		this.impresa = aImpresa;
	}

	public Usuario getUsuario_impresion() throws BaseException {
		supportRefresh();
		return usuario_impresion;
	}

	public void setUsuario_impresion(Usuario aUsuario_impresion) {
		this.usuario_impresion = aUsuario_impresion;
	}

	public java.util.Date getFec_impresion() throws BaseException {
		supportRefresh();
		return fec_impresion;
	}

	public void setFec_impresion(java.util.Date aFec_impresion) {
		this.fec_impresion = aFec_impresion;
	}

	public java.util.Date getFec_envio_sol() throws BaseException {
		supportRefresh();
		return fec_envio_sol;
	}

	public void setFec_envio_sol(java.util.Date aFec_envio_sol) {
		this.fec_envio_sol = aFec_envio_sol;
	}

	public Boolean isEnviada() throws BaseException {
		supportRefresh();
		return enviada;
	}

	public void setEnviada(Boolean aEnviada) {
		this.enviada = aEnviada;
	}

	public Boolean isConf_recep_sol() throws BaseException {
		supportRefresh();
		return conf_recep_sol;
	}

	public void setConf_recep_sol(Boolean aConf_recep_sol) {
		this.conf_recep_sol = aConf_recep_sol;
	}

	public java.util.Date getFec_recep_conf_sol() throws BaseException {
		supportRefresh();
		return fec_recep_conf_sol;
	}

	public void setFec_recep_conf_sol(java.util.Date aFec_recep_conf_sol) {
		this.fec_recep_conf_sol = aFec_recep_conf_sol;
	}

	public Boolean isProv_ent_sol() throws BaseException {
		supportRefresh();
		return prov_ent_sol;
	}

	public void setProv_ent_sol(Boolean aProv_ent_sol) {
		this.prov_ent_sol = aProv_ent_sol;
	}

	public java.util.Date getFec_rec_sol_cotiz() throws BaseException {
		supportRefresh();
		return fec_rec_sol_cotiz;
	}

	public void setFec_rec_sol_cotiz(java.util.Date aFec_rec_sol_cotiz) {
		this.fec_rec_sol_cotiz = aFec_rec_sol_cotiz;
	}

	public Boolean isPresu_recibido() throws BaseException {
		supportRefresh();
		return presu_recibido;
	}

	public void setPresu_recibido(Boolean aPresu_recibido) {
		this.presu_recibido = aPresu_recibido;
	}

	public java.util.Date getFec_presu_recibido() throws BaseException {
		supportRefresh();
		return fec_presu_recibido;
	}

	public void setFec_presu_recibido(java.util.Date aFec_presu_recibido) {
		this.fec_presu_recibido = aFec_presu_recibido;
	}

	protected void onNew() throws BaseException {
		// TODO Auto-generated method stub
		super.onNew();

		impresa = new Boolean(false);
		enviada = new Boolean(false);
		conf_recep_sol = new Boolean(false);
		prov_ent_sol = new Boolean(false);
		presu_recibido = new Boolean(false);

	}

	public String getNickName() {
		return NICKNAME;
	}

	public static SolicitudCotizProveedor findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (SolicitudCotizProveedor) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static SolicitudCotizProveedor findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (SolicitudCotizProveedor) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static SolicitudCotizProveedor findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (SolicitudCotizProveedor) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(solicitud_cotizacion, "Debe ingresar la solicitud de Cotización");
		Validar.noNulo(proveedor, "Debe ingresar el Proveedor");
		Validar.noNulo(impresa, "Debe ingresar si se encuentra o no impresa");
		Validar.noNulo(enviada, "Debe ingresar si se envió la solicitud");
		Validar.noNulo(conf_recep_sol, "Debe ingresar si se recepciona la solicitud");
		Validar.noNulo(prov_ent_sol, "Debe indicar si el proveedor entrego la solicitud");
		Validar.noNulo(presu_recibido, "Debe indicar si se recibió el presupuesto");
	}

	public static List getSolicitudesCotizProveedor(SolicitudCotizProvCab solicitudCotizacion, ISesion aSesion) throws BaseException {
		return DBSolicitudCotizProveedor.getSolicitudesCotizProveedor(solicitudCotizacion, aSesion);
	}

	public static SolicitudCotizProveedor getSolicitudCotizProveedor(SolicitudCotizProvCab solCotizProvCab, Proveedor proveedor,
			ISesion aSesion) throws BaseException {
		return DBSolicitudCotizProveedor.getSolicitudCotizProveedor(solCotizProvCab, proveedor, aSesion);
	}
	
	 public List getSolicitudesCotizDetPorProveedores() throws BaseException {
		  return SolicitudCotizDetPorProv.getSolicitudesCotizDetPorProveedores(this,this.getSesion());
	 }  
	

}
