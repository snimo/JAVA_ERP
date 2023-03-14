package com.srn.erp.compras.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.compras.da.DBRequisicionCab;
import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.general.bm.Talonario;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.bm.UnidadMedida;

import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bm.Parametros.ValorParametro;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.Validar;

public class RequisicionCab extends ComproCab {

	private ComproCab comprobante;

	private List requisicionesDet = new ArrayList();

	private boolean readRequisicionesDet = true;

	// Si el producto no esta clasificado no permitir ingresarlo en la
	// requisicion
	public static final int COMP_AUTORIZ_REQUI_1 = 1;

	// Si el producto no se encuentra clasificado que ingrese como autorizado
	public static final int COMP_AUTORIZ_REQUI_2 = 2;

	// Si el producto no se encuentra clasificado que ingrese como no
	// autorizado, a un rol parametrizado
	public static final int COMP_AUTORIZ_REQUI_3 = 3;

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return this.getCodigo();
	}

	public ComproCab getComprobante() throws BaseException {
		return comprobante;
	}

	public RequisicionCab() {
	}

	public static String NICKNAME = "cp.RequisicionCab";

	private Usuario usuario;

	private SectorCompra sectorCompra;

	private AnuladorRequisicionCab anuladorRequisicionCab;

	public Usuario getUsuario() throws BaseException {
		supportRefresh();
		return usuario;
	}

	public void setUsuario(Usuario aUsuario) {
		this.usuario = aUsuario;
	}

	public SectorCompra getSectorCompra() throws BaseException {
		supportRefresh();
		return sectorCompra;
	}

	public void setSectorCompra(SectorCompra aSectorCompra) {
		this.sectorCompra = aSectorCompra;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static RequisicionCab findByOid(Integer oid, ISesion aSesion)
			throws BaseException {
		return (RequisicionCab) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static RequisicionCab findByOidProxy(Integer oid, ISesion aSesion)
			throws BaseException {
		return (RequisicionCab) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(usuario, "Debe ingresar el Usuario Emisor");
		Validar.noNulo(sectorCompra, "Debe ingresar el Sector Compra");
		if (this.isNew()) {
			this.setComprobante(this);
			this.setEstado(ComproCab.ESTADO_ALTA);
			this.setActivo(new Boolean(true));
		}
		beforeSaveComprobante(this);
	}

	public void setComprobante(ComproCab aComprobante) {
		this.comprobante = aComprobante;
	}

	public List getRequisicionesDet() throws BaseException {
		if (readRequisicionesDet) {
			List listaRequisicionesDet = RequisicionDet.getRequisicionesDet(
					this, getSesion());
			requisicionesDet.addAll(listaRequisicionesDet);
			readRequisicionesDet = false;
		}
		return requisicionesDet;
	}

	public void addRequisicionDet(RequisicionDet requisicionDet)
			throws BaseException {
		requisicionDet.setRequisicion(this);
		requisicionesDet.add(requisicionDet);
	}

	public void afterSave() throws BaseException {
		grabarDetalleRequisiciones();
	}

	private void grabarDetalleRequisiciones() throws BaseException {
		Iterator iterRequisicionesDet = requisicionesDet.iterator();
		while (iterRequisicionesDet.hasNext()) {
			RequisicionDet requisicionDet = (RequisicionDet) iterRequisicionesDet
					.next();
			grabarRolesAutorizadores(requisicionDet);
			requisicionDet.save();
			requisicionDet = null;
		}
		iterRequisicionesDet = null;

	}

	private void grabarRolesAutorizadores(RequisicionDet requisicionDet)
			throws BaseException {

		// Eliminar los roles autorizadores que estan pendientes de autorizacion
		RequisicionDetAutorizacion reqDetAutoriz = null;
		Iterator iterAutorizadoresRoles = requisicionDet
				.getAutorizacionesReqDet().iterator();
		while (iterAutorizadoresRoles.hasNext()) {
			reqDetAutoriz = (RequisicionDetAutorizacion) iterAutorizadoresRoles
					.next();
			if (reqDetAutoriz.getDecision_autoriz().intValue() == RequisicionDetAutorizacion.PEND_AUTORIZ
					.intValue())
				reqDetAutoriz.delete();
		}

		boolean requiereAutoriz = false;

		// Grabar los nuevos Roles Autorizantes
		List listaRolesAutorizadores = getSectorCompra()
				.getAutorizadoresRequisicion(requisicionDet.getProducto());
		if (RequisicionCab.getComportamientoAutorizRequi(this.getSesion()) == RequisicionCab.COMP_AUTORIZ_REQUI_1) {
			if ((listaRolesAutorizadores == null)
					|| (listaRolesAutorizadores.size() == 0))
				throw new ExceptionValidation(null,
						"No se puede determinar el Rol autorizador para el producto "
								+ requisicionDet.getProducto().getCodigo()
								+ "- "
								+ requisicionDet.getProducto().getDescripcion()
								+ " requerido por el sector "
								+ getSectorCompra().getDescripcion());

			requiereAutoriz = requiereAutorizacionRequiCompo1(reqDetAutoriz,
					listaRolesAutorizadores, requisicionDet);
		} else if (RequisicionCab.getComportamientoAutorizRequi(this
				.getSesion()) == RequisicionCab.COMP_AUTORIZ_REQUI_2) {
			requiereAutoriz = requiereAutorizacionRequiCompo2(reqDetAutoriz,
					listaRolesAutorizadores, requisicionDet);
		} else if (RequisicionCab.getComportamientoAutorizRequi(this
				.getSesion()) == RequisicionCab.COMP_AUTORIZ_REQUI_3)
			requiereAutoriz = requiereAutorizacionRequiCompo3(reqDetAutoriz,
					listaRolesAutorizadores, requisicionDet);

		if (!requiereAutoriz)
			requisicionDet
					.setDecision_autoriz(RequisicionDetAutorizacion.AUTORIZADO);
		else
			requisicionDet
					.setDecision_autoriz(RequisicionDetAutorizacion.PEND_AUTORIZ);

	}

	private boolean requiereAutorizacionRequiCompo2(
			RequisicionDetAutorizacion reqDetAutoriz,
			List listaRolesAutorizadores, RequisicionDet requisicionDet)
			throws BaseException {

		boolean requiereAutoriz = false;

		if ((listaRolesAutorizadores == null)
				|| (listaRolesAutorizadores.size() == 0))
			return false;

		Iterator iterRolesAutorizadores = listaRolesAutorizadores.iterator();
		while (iterRolesAutorizadores.hasNext()) {
			AutorizadorRequisicion autorizadorRequisicion = (AutorizadorRequisicion) iterRolesAutorizadores
					.next();
			Usuario usuario = Usuario.findByOid(this.getSesion().getLogin()
					.getUsuario().getOIDInteger(), getSesion());
			// Si el usuario pertenece al rol autorizador no se solicita
			// autorizacion
			if (autorizadorRequisicion.getRol_autorizador().tieneElRol(usuario)) {

				reqDetAutoriz = 
					RequisicionDetAutorizacion.getAutorizadorRequisicionDet(
							requisicionDet,
							autorizadorRequisicion.getRol_autorizador(),
							this.getSesion());
				
				if (reqDetAutoriz == null)
					reqDetAutoriz = (RequisicionDetAutorizacion) RequisicionDetAutorizacion
						.getNew(RequisicionDetAutorizacion.NICKNAME,
								getSesion());
				reqDetAutoriz.setRequesicion_detalle(requisicionDet);
				reqDetAutoriz.setRolAutorizador(autorizadorRequisicion.getRol_autorizador());
				reqDetAutoriz
						.setDecision_autoriz(RequisicionDetAutorizacion.AUTORIZADO);
				reqDetAutoriz.setUsuario(usuario);
				reqDetAutoriz.setFec_decision(Fecha.getFechaActual());
				reqDetAutoriz.setComentario("");
				reqDetAutoriz.setTipo_autorizacion(autorizadorRequisicion
						.getTipoAutoriz());
				requisicionDet.addAutorizacionRequisicionDet(reqDetAutoriz);
				continue;

			} else {

				reqDetAutoriz = 
					RequisicionDetAutorizacion.getAutorizadorRequisicionDet(
							requisicionDet,
							autorizadorRequisicion.getRol_autorizador(),
							this.getSesion());
				
				if (reqDetAutoriz == null)
					reqDetAutoriz = (RequisicionDetAutorizacion) RequisicionDetAutorizacion
						.getNew(RequisicionDetAutorizacion.NICKNAME,
								getSesion());
				
				reqDetAutoriz.setRequesicion_detalle(requisicionDet);
				reqDetAutoriz.setRolAutorizador(autorizadorRequisicion
						.getRol_autorizador());
				reqDetAutoriz
						.setDecision_autoriz(RequisicionDetAutorizacion.PEND_AUTORIZ);
				reqDetAutoriz.setUsuario(null);
				reqDetAutoriz.setFec_decision(Fecha.getFechaActual());
				reqDetAutoriz.setComentario("");
				reqDetAutoriz.setTipo_autorizacion(autorizadorRequisicion
						.getTipoAutoriz());
				requisicionDet.addAutorizacionRequisicionDet(reqDetAutoriz);
				requiereAutoriz = true;
			}
		}

		return requiereAutoriz;

	}

	private boolean requiereAutorizacionRequiCompo1(
			RequisicionDetAutorizacion reqDetAutoriz,
			List listaRolesAutorizadores, RequisicionDet requisicionDet)
			throws BaseException {

		boolean requiereAutorizacion = false;

		Iterator iterRolesAutorizadores = listaRolesAutorizadores.iterator();
		while (iterRolesAutorizadores.hasNext()) {
			AutorizadorRequisicion autorizadorRequisicion = (AutorizadorRequisicion) iterRolesAutorizadores
					.next();
			Usuario usuario = Usuario.findByOid(this.getSesion().getLogin()
					.getUsuario().getOIDInteger(), getSesion());
			// Si el usuario pertenece al rol autorizador no se solicita
			// autorizacion
			if (autorizadorRequisicion.getRol_autorizador().tieneElRol(usuario))
				continue;
			reqDetAutoriz = (RequisicionDetAutorizacion) RequisicionDetAutorizacion
					.getNew(RequisicionDetAutorizacion.NICKNAME, getSesion());
			reqDetAutoriz.setRequesicion_detalle(requisicionDet);
			reqDetAutoriz.setRolAutorizador(autorizadorRequisicion
					.getRol_autorizador());
			reqDetAutoriz
					.setDecision_autoriz(RequisicionDetAutorizacion.PEND_AUTORIZ);
			reqDetAutoriz.setUsuario(null);
			reqDetAutoriz.setFec_decision(Fecha.getFechaActual());
			reqDetAutoriz.setComentario("");
			reqDetAutoriz.setTipo_autorizacion(autorizadorRequisicion
					.getTipoAutoriz());
			requisicionDet.addAutorizacionRequisicionDet(reqDetAutoriz);
			requiereAutorizacion = true;
		}
		return requiereAutorizacion;
	}

	private boolean requiereAutorizacionRequiCompo3(
			RequisicionDetAutorizacion reqDetAutoriz,
			List listaRolesAutorizadores, RequisicionDet requisicionDet)
			throws BaseException {

		boolean requiereAutorizacion = false;

		if ((listaRolesAutorizadores == null)
				|| (listaRolesAutorizadores.size() == 0)) {
			reqDetAutoriz = (RequisicionDetAutorizacion) RequisicionDetAutorizacion
					.getNew(RequisicionDetAutorizacion.NICKNAME, getSesion());
			reqDetAutoriz.setRequesicion_detalle(requisicionDet);
			reqDetAutoriz.setRolAutorizador(RequisicionCab
					.getRolAutorizRequiProdSinClasif(getSesion()));
			reqDetAutoriz
					.setDecision_autoriz(RequisicionDetAutorizacion.PEND_AUTORIZ);
			reqDetAutoriz.setUsuario(null);
			reqDetAutoriz.setFec_decision(Fecha.getFechaActual());
			reqDetAutoriz.setComentario("");
			reqDetAutoriz
					.setTipo_autorizacion(AutorizadorRequisicion.TIPO_AUTORIZ_SUFICIENTE);
			requisicionDet.addAutorizacionRequisicionDet(reqDetAutoriz);
			return true;
		}

		Iterator iterRolesAutorizadores = listaRolesAutorizadores.iterator();
		while (iterRolesAutorizadores.hasNext()) {
			AutorizadorRequisicion autorizadorRequisicion = (AutorizadorRequisicion) iterRolesAutorizadores
					.next();
			Usuario usuario = Usuario.findByOid(this.getSesion().getLogin()
					.getUsuario().getOIDInteger(), getSesion());
			// Si el usuario pertenece al rol autorizador no se solicita
			// autorizacion
			if (autorizadorRequisicion.getRol_autorizador().tieneElRol(usuario))
				continue;

			reqDetAutoriz = (RequisicionDetAutorizacion) RequisicionDetAutorizacion
					.getNew(RequisicionDetAutorizacion.NICKNAME, getSesion());
			reqDetAutoriz.setRequesicion_detalle(requisicionDet);
			reqDetAutoriz.setRolAutorizador(autorizadorRequisicion
					.getRol_autorizador());
			reqDetAutoriz
					.setDecision_autoriz(RequisicionDetAutorizacion.PEND_AUTORIZ);
			reqDetAutoriz.setUsuario(null);
			reqDetAutoriz.setFec_decision(Fecha.getFechaActual());
			reqDetAutoriz.setComentario("");
			reqDetAutoriz.setTipo_autorizacion(autorizadorRequisicion
					.getTipoAutoriz());
			requisicionDet.addAutorizacionRequisicionDet(reqDetAutoriz);
			requiereAutorizacion = true;
		}

		return requiereAutorizacion;

	}

	public static List getRequisiciones(Integer nroExtDesde,
			Integer nroExtHasta, java.util.Date fecDesde,
			java.util.Date fecHasta, Usuario usuario,
			SectorCompra sectorCompra, ISesion aSesion) throws BaseException {
		return DBRequisicionCab.getRequisicionesCab(nroExtDesde, nroExtHasta,
				fecDesde, fecHasta, usuario, sectorCompra, aSesion);
	}

	public void anular() throws BaseException {

		// Anular los Detalles
		Iterator iterDetalles = this.getRequisicionesDet().iterator();
		while (iterDetalles.hasNext()) {
			RequisicionDet requisicionDet = (RequisicionDet) iterDetalles
					.next();
			requisicionDet.delete();
			requisicionDet.save();
		}

		anuladorRequisicionCab = (AnuladorRequisicionCab) AnuladorRequisicionCab
				.getNew(AnuladorRequisicionCab.NICKNAME, getSesion());
		anuladorRequisicionCab.setRequisicionCab(this);
		anuladorRequisicionCab.generarComproAnulacion();
		anuladorRequisicionCab.save();

	}

	public static UnidadMedida getUniMedSug(Producto producto)
			throws BaseException {
		if (producto.getUm_stk() != null)
			return producto.getUm_stk();
		else if (producto.getUm_stk_alt() != null)
			return producto.getUm_stk_alt();
		else if (producto.getUm_cpra() != null)
			return producto.getUm_cpra();
		else if (producto.getUm_vta() != null)
			return producto.getUm_vta();
		else
			return null;
	}

	public static EsquemaHabilitacionProducto getEsqHabProd(ISesion aSesion)
			throws BaseException {
		ValorParametro valorParametro = ValorParametro.findByCodigoParametro(
				"ESQ_HAB_PROD_REQUI", aSesion);
		EsquemaHabilitacionProducto esqHabProd = EsquemaHabilitacionProducto
				.findByOid(valorParametro.getOidObjNeg(), aSesion);
		return esqHabProd;
	}

	public static int getComportamientoAutorizRequi(ISesion aSesion)
			throws BaseException {
		ValorParametro valorParametro = ValorParametro.findByCodigoParametro(
				"COMP_AUTORIZ_REQUI", aSesion);
		return valorParametro.getValorEntero().intValue();
	}

	public static RolAutorizadorCompras getRolAutorizRequiProdSinClasif(
			ISesion aSesion) throws BaseException {
		ValorParametro valorParametro = ValorParametro.findByCodigoParametro(
				"ROL_AUT_PROD_NO_CLASIF_REQUI", aSesion);
		RolAutorizadorCompras rolAutorizCompras = RolAutorizadorCompras
				.findByOid(valorParametro.getOidObjNeg(), aSesion);
		return rolAutorizCompras;
	}
	
	public static Talonario getTalonatioDefaultRequisiciones(ISesion aSesion) throws BaseException {
		return Talonario.getTalonatioDefaultRequisiciones(aSesion);
	}
	
	public int getMaxNroRenglon() throws BaseException {
		return RequisicionDet.getMaxNroRenglon(this.getSesion(), this);
	}
	
	

}
