package com.srn.erp.ctasAPagar.bm;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.compras.bm.AutorizadorRequisicion;
import com.srn.erp.compras.bm.OrdenDeCompraCab;
import com.srn.erp.ctasAPagar.da.DBAutorizacionFactProv;
import com.srn.erp.general.bm.ComproCab;

import com.srn.erp.general.bm.Cotizacion;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.applicarionServer.bm.Varios.CalculadorMoney;
import framework.applicarionServer.bm.Varios.Money;
import framework.applicarionServer.bm.Varios.ValorCotizacion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;

public class AutorizacionFactProv extends ObjetoLogico {

	private List		autorizacionRolesFP			= new ArrayList();

	private boolean	readAutorizacionRolesFP	= true;
	public boolean noEjecutarAfterSave = false;

	private void refreshRolesAutorizFP() throws BaseException {
		readAutorizacionRolesFP = true;
		autorizacionRolesFP.clear();
	}

	public void afterSaveNew() throws BaseException {
		// TODO Auto-generated method stub
		super.afterSaveNew();

		// Grabar los Roles autorizantes de la factura
		generarRolesAutorizantes();
	}

	public AutorizacionFactProv() {

	}

	/*private void generarRolesAutorizantesFacturas() throws BaseException {

		EsquemaAutorizFactProv esquemaAutorizacion = ComproProveedor.getEsquemaAutorizFactProv(getSesion());
		Money totalFactura = this.getTranprovVto().getTranprov().getImporte();
		CalculadorMoney calcTotFactMonLoc = new CalculadorMoney(totalFactura);
		calcTotFactMonLoc.multiplicarPor(new Money(-1));
		calcTotFactMonLoc.multiplicarPor(this.getTranprovVto().getTranprov().getCotizmonedaori());
		Money totFacturaMonLoc = calcTotFactMonLoc.getResultMoney();

		ValorCotizacion valorCotiz = Cotizacion.getCotizacion(new Date(), esquemaAutorizacion.getMoneda(), getSesion());

		CalculadorMoney calcImpoMonEsq = new CalculadorMoney(totFacturaMonLoc);
		calcImpoMonEsq.dividirPor(valorCotiz);
		Money impoMonEsq = calcImpoMonEsq.getResultMoney();

		EsquemaAutorizFactMonto esqAutorizFactMonto = esquemaAutorizacion.getEsqAutorizFactMonto(impoMonEsq);
		if (esqAutorizFactMonto == null)
			throw new ExceptionValidation(null, "Debe ingresar un rango de autorizacion para el importe de la factura ");

		ComproProveedor comproProveedor = (ComproProveedor) ComproProveedor.findByOid(this.getTranprovVto().getTranprov()
				.getComprobante().getOIDInteger(), getSesion());

		List listaRolesAutorizadores = esqAutorizFactMonto.getEsquemasAutorizSectoresRoles(comproProveedor
				.getSectorCompra(), this.getSesion());
		if (listaRolesAutorizadores.size() == 0)
			throw new ExceptionValidation(null, "Se deben cargar los roles autorizantes");

		Iterator iterEsqAutFactSec = listaRolesAutorizadores.iterator();
		while (iterEsqAutFactSec.hasNext()) {
			EsquemaAutorizFactSector esqAutorizFactSec = (EsquemaAutorizFactSector) iterEsqAutFactSec.next();

			AutorizRolesFactProv autorizadorRol = (AutorizRolesFactProv) AutorizRolesFactProv.getNew(
					AutorizRolesFactProv.NICKNAME, getSesion());
			autorizadorRol.setAutorizacion_fact_prov(this);
			autorizadorRol.setRol_autorizador(esqAutorizFactSec.getRol_autotizador());
			autorizadorRol.setFec_lta(Fecha.getFechaActual());
			autorizadorRol.setTipo_autoriz(esqAutorizFactSec.getTipo_autoriz());
			autorizadorRol.setEstado(new Integer(OrdenDeCompraCab.PEND_AUTORIZ));
			autorizadorRol.setMotivoAutorizacion(AutorizRolesFactProv.AUTORIZ_PAGO);
			autorizadorRol.save();

		}

	}
	
	private void generarRolesAutorizantesAnticipos() throws BaseException {

		EsquemaAutorizFactProv esquemaAutorizacion = ComproProveedor.getEsquemaAutorizFactProv(getSesion());
		ComproAnticipoProveedor comproAnticipoProv = (ComproAnticipoProveedor)ComproAnticipoProveedor.findByOidCompro(this.getComproCab().getOIDInteger(),getSesion()); 
		Money totFacturaMonLoc = comproAnticipoProv.getTotMonedaLoc();

		ValorCotizacion valorCotiz = Cotizacion.getCotizacion(new Date(), esquemaAutorizacion.getMoneda(), getSesion());

		CalculadorMoney calcImpoMonEsq = new CalculadorMoney(totFacturaMonLoc);
		calcImpoMonEsq.dividirPor(valorCotiz);
		Money impoMonEsq = calcImpoMonEsq.getResultMoney();

		EsquemaAutorizFactMonto esqAutorizFactMonto = esquemaAutorizacion.getEsqAutorizFactMonto(impoMonEsq);
		if (esqAutorizFactMonto == null)
			throw new ExceptionValidation(null, "No se ha encontrado un rango de autorizacion para el monto "+impoMonEsq.doubleValue());

		List listaRolesAutorizadores = esqAutorizFactMonto.getEsquemasAutorizSectoresRoles(comproAnticipoProv
				.getSectorCompra(), this.getSesion());
		if (listaRolesAutorizadores.size() == 0)
			throw new ExceptionValidation(null, "Se deben cargar los roles autorizantes");

		Iterator iterEsqAutFactSec = listaRolesAutorizadores.iterator();
		while (iterEsqAutFactSec.hasNext()) {
			EsquemaAutorizFactSector esqAutorizFactSec = (EsquemaAutorizFactSector) iterEsqAutFactSec.next();

			AutorizRolesFactProv autorizadorRol = (AutorizRolesFactProv) AutorizRolesFactProv.getNew(
					AutorizRolesFactProv.NICKNAME, getSesion());
			autorizadorRol.setAutorizacion_fact_prov(this);
			autorizadorRol.setRol_autorizador(esqAutorizFactSec.getRol_autotizador());
			autorizadorRol.setFec_lta(Fecha.getFechaActual());
			autorizadorRol.setTipo_autoriz(esqAutorizFactSec.getTipo_autoriz());
			autorizadorRol.setEstado(new Integer(OrdenDeCompraCab.PEND_AUTORIZ));
			autorizadorRol.setMotivoAutorizacion(AutorizRolesFactProv.AUTORIZ_PAGO);
			autorizadorRol.save();

		}

	}*/
	
	private void generarRolesAutorizantes() throws BaseException {

		EsquemaAutorizFactProv esquemaAutorizacion = ComproProveedor.getEsquemaAutorizFactProv(getSesion());
		ComproProveedorBase comproProveedorBase = (ComproProveedorBase)ComproProveedorBase.findByOidCompro(this.getComproCab().getOIDInteger(),getSesion()); 
		Money totFacturaMonLoc = comproProveedorBase.getTotMonedaLoc();

		
		ValorCotizacion valorCotiz = Cotizacion.getCotizacion(Fecha.getFechaActual(), esquemaAutorizacion.getMoneda(), getSesion());

		CalculadorMoney calcImpoMonEsq = new CalculadorMoney(totFacturaMonLoc);
		calcImpoMonEsq.dividirPor(valorCotiz);
		Money impoMonEsq = calcImpoMonEsq.getResultMoney();

		EsquemaAutorizFactMonto esqAutorizFactMonto = esquemaAutorizacion.getEsqAutorizFactMonto(impoMonEsq);
		if (esqAutorizFactMonto == null)
			throw new ExceptionValidation(null, "No se ha encontrado un rango de autorizacion para el monto "+impoMonEsq.doubleValue());

		List listaRolesAutorizadores = esqAutorizFactMonto.getEsquemasAutorizSectoresRoles(comproProveedorBase.getSectorCompra(), this.getSesion());
		if (listaRolesAutorizadores.size() == 0)
			throw new ExceptionValidation(null, "Se deben cargar los roles autorizantes");

		Iterator iterEsqAutFactSec = listaRolesAutorizadores.iterator();
		while (iterEsqAutFactSec.hasNext()) {
			EsquemaAutorizFactSector esqAutorizFactSec = (EsquemaAutorizFactSector) iterEsqAutFactSec.next();

			AutorizRolesFactProv autorizadorRol = (AutorizRolesFactProv) AutorizRolesFactProv.getNew(
					AutorizRolesFactProv.NICKNAME, getSesion());
			autorizadorRol.setAutorizacion_fact_prov(this);
			autorizadorRol.setRol_autorizador(esqAutorizFactSec.getRol_autotizador());
			autorizadorRol.setFec_lta(Fecha.getFechaActual());
			autorizadorRol.setTipo_autoriz(esqAutorizFactSec.getTipo_autoriz());
			autorizadorRol.setEstado(new Integer(OrdenDeCompraCab.PEND_AUTORIZ));
			autorizadorRol.setMotivoAutorizacion(AutorizRolesFactProv.AUTORIZ_PAGO);
			autorizadorRol.save();

		}

	}	
	

	public static String		NICKNAME	= "cap.AutorizacionFactProv";

	private TranProvVto			tranProvVto;

	private Money						porcAutoriz;

	private Money						montoAutoriz;

	private Usuario					usuario;

	private java.util.Date	fecAutoriz;

	private Boolean					activo;

	private Integer					estado;
	
	private ComproCab       comproCab;

	public TranProvVto getTranprovVto() throws BaseException {
		supportRefresh();
		return tranProvVto;
	}

	public void setTranprovVto(TranProvVto aTranprovVto) {
		this.tranProvVto = aTranprovVto;
	}
	
	public ComproCab getComproCab() throws BaseException {
		supportRefresh();
		return this.comproCab;
	}

	public void setComproCab(ComproCab aComproCab) {
		this.comproCab = aComproCab;
	}
	

	public Integer getEstado() throws BaseException {
		supportRefresh();
		return estado;
	}

	public void setEstado(Integer aEstado) {
		this.estado = aEstado;
	}

	public Money getPorcautoriz() throws BaseException {
		supportRefresh();
		return porcAutoriz;
	}

	public void setPorcautoriz(Money aPorcautoriz) {
		this.porcAutoriz = aPorcautoriz;
	}

	public Money getMontoautoriz() throws BaseException {
		supportRefresh();
		return montoAutoriz;
	}

	public void setMontoautoriz(Money aMontoautoriz) {
		this.montoAutoriz = aMontoautoriz;
	}

	public Usuario getUsuario() throws BaseException {
		supportRefresh();
		return usuario;
	}

	public void setUsuario(Usuario aUsuario) {
		this.usuario = aUsuario;
	}

	public java.util.Date getFecautoriz() throws BaseException {
		supportRefresh();
		return fecAutoriz;
	}

	public void setFecautoriz(java.util.Date aFecautoriz) {
		this.fecAutoriz = aFecautoriz;
	}

	public Boolean getActivo() throws BaseException {
		supportRefresh();
		return activo;
	}

	public void setActivo(Boolean aActivo) {
		this.activo = aActivo;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static AutorizacionFactProv findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (AutorizacionFactProv) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static AutorizacionFactProv findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (AutorizacionFactProv) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static AutorizacionFactProv findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (AutorizacionFactProv) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void desAutorizar() throws BaseException {
		setPorcautoriz(new Money(0));
		setMontoautoriz(new Money(0));
	}

	public void beforeSave() throws BaseException {
		
	}

	/**
	 * isActivo
	 * 
	 * @return Boolean
	 */
	public Boolean isActivo() {
		return null;
	}

	/**
	 * getDescripcion
	 * 
	 * @return String
	 */
	public String getDescripcion() {
		return "";
	}

	/**
	 * getCodigo
	 * 
	 * @return String
	 */
	public String getCodigo() {
		return "";
	}

	public static AutorizacionFactProv getAutorizByTranProvVto(TranProvVto tranProvVto, ISesion sesion)
			throws BaseException {
		return DBAutorizacionFactProv.getAutorizFactProv(tranProvVto, sesion);
	}

	public List getAutorizFPRoles() throws BaseException {
		if (this.readAutorizacionRolesFP) {
			List listaAutorizFPRoles = AutorizRolesFactProv.getAutorizRolesFactProv(this, getSesion());
			autorizacionRolesFP.addAll(listaAutorizFPRoles);
			readAutorizacionRolesFP = false;
		}
		return autorizacionRolesFP;
	}

	public void addRolAutorizadorFactProv(AutorizRolesFactProv autorizRolesFactProv) throws BaseException {
		autorizRolesFactProv.setAutorizacion_fact_prov(this);
		autorizacionRolesFP.add(autorizRolesFactProv);
	}

	public void afterSave() throws BaseException {

		
		if (noEjecutarAfterSave == true) return;
		
		Iterator iterRoles = autorizacionRolesFP.iterator();
		while (iterRoles.hasNext()) {
			AutorizRolesFactProv autorizRolesFactProv = (AutorizRolesFactProv) iterRoles.next();
			autorizRolesFactProv.save();
			autorizRolesFactProv = null;
		}
		iterRoles = null;

		verSiSeCambiaEstadoAutorizacion();
		
		

	}

	private void verSiSeCambiaEstadoAutorizacion() throws BaseException {

		
		// Verificar estado de detalles
		boolean todosLosRolesAutorizaron = true;

		refreshRolesAutorizFP();
		List listaRoles = this.getAutorizFPRoles();
		if (listaRoles.size() == 0) return;
		Iterator iterRolesAutoriz = listaRoles.iterator();
		while (iterRolesAutoriz.hasNext()) {
			AutorizRolesFactProv autorizRolesFactProv = (AutorizRolesFactProv) iterRolesAutoriz.next();

			if ((autorizRolesFactProv.getEstado().intValue() == OrdenDeCompraCab.RECHAZADA)) {
				AutorizacionFactProv autorizFactProv = AutorizacionFactProv.findByOid(this.getOIDInteger(), getSesion());
				autorizFactProv.setEstado(new Integer(OrdenDeCompraCab.RECHAZADA));
				autorizFactProv.setFecautoriz(Fecha.getFechaActual());
				autorizFactProv.noEjecutarAfterSave = true;
				autorizFactProv.save();
				return;
			}

			if ((autorizRolesFactProv.getEstado().intValue() == OrdenDeCompraCab.AUTORIZADA)
					&& (autorizRolesFactProv.getTipo_autoriz().equals(AutorizadorRequisicion.TIPO_AUTORIZ_SUFICIENTE))) {
				AutorizacionFactProv autorizFactProv = AutorizacionFactProv.findByOid(this.getOIDInteger(), getSesion());
				autorizFactProv.setEstado(new Integer(OrdenDeCompraCab.AUTORIZADA));
				autorizFactProv.setFecautoriz(Fecha.getFechaActual());
				autorizFactProv.noEjecutarAfterSave = true;
				autorizFactProv.save();
				return;
			}

			if (autorizRolesFactProv.getEstado().intValue() != OrdenDeCompraCab.AUTORIZADA) {
				todosLosRolesAutorizaron = false;
			}

		}

	if ((todosLosRolesAutorizaron) && ((this.getPorcautoriz()!=null) && (this.getPorcautoriz().doubleValue()==100))) {
			AutorizacionFactProv autorizFactProv = AutorizacionFactProv.findByOid(this.getOIDInteger(), getSesion());
			autorizFactProv.setEstado(new Integer(OrdenDeCompraCab.AUTORIZADA));
			autorizFactProv.setFecautoriz(Fecha.getFechaActual());
			autorizFactProv.noEjecutarAfterSave = true;
			autorizFactProv.save();		
		} else {
			AutorizacionFactProv autorizFactProv = AutorizacionFactProv.findByOid(this.getOIDInteger(), getSesion());
			autorizFactProv.setEstado(new Integer(OrdenDeCompraCab.PEND_AUTORIZ));
			autorizFactProv.setFecautoriz(Fecha.getFechaActual());
			autorizFactProv.noEjecutarAfterSave = true;
			autorizFactProv.save();		
		}
	}

	
	public ComproCab getComprobanteAutoriz() throws BaseException {
		if (this.getTranprovVto()!=null)
			return this.getTranprovVto().getTranprov().getComprobante();
		return this.getComproCab();
	}
	
	public boolean isPagoAutorizado() throws BaseException {
		if (this.getEstado().intValue() == OrdenDeCompraCab.AUTORIZADA)
			return true;
		if ((this.getMontoautoriz().doubleValue()>0) && (isAutorizadaPorRoles()))
			return true;
		return false;
	}
	
	private boolean isAutorizadaPorRoles() throws BaseException {
		
		boolean todosLosRolesAutorizaron = true;
		Iterator iterRolesAutoriz =
			this.getAutorizFPRoles().iterator();
		while (iterRolesAutoriz.hasNext()) {
			AutorizRolesFactProv autorizRolesFactProv = (AutorizRolesFactProv) iterRolesAutoriz.next();

			if ((autorizRolesFactProv.getEstado().intValue() == OrdenDeCompraCab.RECHAZADA)) 
				return false;

			if ((autorizRolesFactProv.getEstado().intValue() == OrdenDeCompraCab.AUTORIZADA)
					&& (autorizRolesFactProv.getTipo_autoriz().equals(AutorizadorRequisicion.TIPO_AUTORIZ_SUFICIENTE))) 
				return true;

			if (autorizRolesFactProv.getEstado().intValue() != OrdenDeCompraCab.AUTORIZADA) 
				todosLosRolesAutorizaron = false;
		}
		
		return todosLosRolesAutorizaron;
			
	}

}
