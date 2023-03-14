package com.srn.erp.compras.bm;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.compras.da.DBRequisicionDet;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.bm.UnidadMedida;
import com.srn.erp.ventas.bm.PedidoCab;
import com.srn.erp.ventas.bm.PedidoDet;
import com.srn.erp.ventas.bm.Sujeto;
import com.srn.erp.ventas.da.DBPedidoDet;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.applicarionServer.bm.Varios.CalculadorMoney;
import framework.applicarionServer.bm.Varios.NumeroBase;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.Validar;

public class RequisicionDet extends ObjetoLogico {

	public RequisicionDet() {
	}

	public static String NICKNAME = "cp.RequisicionDet";

	private RequisicionCab requisicion;

	private Producto producto;

	private Integer renglon;

	private Double cant_solicitada;

	private UnidadMedida unidad_medida_req;

	private Double can_comprada;

	private java.util.Date fec_requerida;

	private java.util.Date fec_entrega;

	private Integer decision_autoriz;

	private Boolean anulada;

	private Boolean solo_cotizar;

	private String comentario;

	private String desc_adic_sku;

	private Boolean pend_sol_cotiz;

	private java.util.Date fec_emision;

	private Proveedor proveedor;

	private Boolean pendCompra;

	private String nicknameTipoComproRef;

	private Integer oidComproRef;

	private Integer oidComproRefDet;

	public void setPendCompra(Boolean aPendCompra) {
		this.pendCompra = aPendCompra;
	}

	public void setNickNameTipoComproRef(String aNicknameTipoComproRef)
			throws BaseException {
		this.nicknameTipoComproRef = aNicknameTipoComproRef;
	}

	public void setOidComproRef(Integer aOidComproRef) throws BaseException {
		if ((aOidComproRef != null) && (aOidComproRef.intValue() == 0))
			this.oidComproRef = null;
		else
			this.oidComproRef = aOidComproRef;
	}

	public void setOidComproRefDet(Integer aOidComproRefDet)
			throws BaseException {
		if ((aOidComproRefDet != null) && (aOidComproRefDet.intValue() == 0))
			this.oidComproRefDet = null;
		else
			this.oidComproRefDet = aOidComproRefDet;
	}

	public Integer getOidComproRefDet() throws BaseException {
		this.supportRefresh();
		return this.oidComproRefDet;
	}

	public Integer getOidComproRef() throws BaseException {
		this.supportRefresh();
		return this.oidComproRef;
	}

	public String getNickNameTipoComproRef() throws BaseException {
		this.supportRefresh();
		return this.nicknameTipoComproRef;
	}

	public Boolean getPendCompra() throws BaseException {
		supportRefresh();
		return this.pendCompra;
	}

	private List autorizacionesReqDet = new ArrayList();
	private boolean readAutorizacionesReqDet = true;

	public RequisicionCab getRequisicion() throws BaseException {
		supportRefresh();
		return requisicion;
	}

	public void setRequisicion(RequisicionCab aRequisicion) {
		this.requisicion = aRequisicion;
	}

	public Producto getProducto() throws BaseException {
		supportRefresh();
		return producto;
	}

	public void setProducto(Producto aProducto) {
		this.producto = aProducto;
	}

	public Integer getRenglon() throws BaseException {
		supportRefresh();
		return renglon;
	}

	public void setRenglon(Integer aRenglon) {
		this.renglon = aRenglon;
	}

	public Double getCant_solicitada() throws BaseException {
		supportRefresh();
		return cant_solicitada;
	}

	public void setProveedor(Proveedor aProveedor) {
		this.proveedor = aProveedor;
	}

	public Proveedor getProveedor() throws BaseException {
		supportRefresh();
		return proveedor;
	}

	public void setCant_solicitada(Double aCant_solicitada) {
		this.cant_solicitada = aCant_solicitada;
	}

	public UnidadMedida getUnidad_medida_req() throws BaseException {
		supportRefresh();
		return unidad_medida_req;
	}

	public void setUnidad_medida_req(UnidadMedida aUnidad_medida_req) {
		this.unidad_medida_req = aUnidad_medida_req;
	}

	public Double getCan_comprada() throws BaseException {
		supportRefresh();
		return can_comprada;
	}

	public void setCan_comprada(Double aCan_comprada) {
		this.can_comprada = aCan_comprada;
	}

	public java.util.Date getFec_requerida() throws BaseException {
		supportRefresh();
		return fec_requerida;
	}

	public void setFec_requerida(java.util.Date aFec_requerida) {
		this.fec_requerida = aFec_requerida;
	}

	public java.util.Date getFec_entrega() throws BaseException {
		supportRefresh();
		return fec_entrega;
	}

	public void setFec_entrega(java.util.Date aFec_entrega) {
		this.fec_entrega = aFec_entrega;
	}

	public Integer getDecision_autoriz() throws BaseException {
		supportRefresh();
		return decision_autoriz;
	}

	public void setDecision_autoriz(Integer aDecision_autoriz) {
		this.decision_autoriz = aDecision_autoriz;
	}

	public Boolean isAnulada() throws BaseException {
		supportRefresh();
		return anulada;
	}

	public void setAnulada(Boolean aAnulada) {
		this.anulada = aAnulada;
	}

	public Boolean isSolo_cotizar() throws BaseException {
		supportRefresh();
		return solo_cotizar;
	}

	public void setSolo_cotizar(Boolean aSolo_cotizar) {
		this.solo_cotizar = aSolo_cotizar;
	}

	public String getComentario() throws BaseException {
		supportRefresh();
		return comentario;
	}

	public void setComentario(String aComentario) {
		this.comentario = aComentario;
	}

	public String getDesc_adic_sku() throws BaseException {
		supportRefresh();
		return desc_adic_sku;
	}

	public void setDesc_adic_sku(String aDesc_adic_sku) {
		this.desc_adic_sku = aDesc_adic_sku;
	}

	public Boolean isPend_sol_cotiz() throws BaseException {
		supportRefresh();
		return pend_sol_cotiz;
	}

	public void setPend_sol_cotiz(Boolean aPend_sol_cotiz) {
		this.pend_sol_cotiz = aPend_sol_cotiz;
	}

	public java.util.Date getFec_emision() throws BaseException {
		supportRefresh();
		return fec_emision;
	}

	public void setFec_emision(java.util.Date aFec_emision) {
		this.fec_emision = aFec_emision;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static RequisicionDet findByOid(Integer oid, ISesion aSesion)
			throws BaseException {
		return (RequisicionDet) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static RequisicionDet findByOidProxy(Integer oid, ISesion aSesion)
			throws BaseException {
		return (RequisicionDet) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static RequisicionDet findByCodigo(String codigo, ISesion aSesion)
			throws BaseException {
		return (RequisicionDet) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(requisicion, "Debe ingresar la Solicitud de Compra");
		Validar.noNulo(producto, "Debe ingresar el Producto");
		Validar.noNulo(renglon, "Debe ingresar el Nro. de Renglon");
		Validar.noNulo(cant_solicitada, "Debe ingresar la cantidad solicitada");
		Validar.noNulo(unidad_medida_req, "Debe ingresar la Unidad de Medida");
		Validar.noNulo(can_comprada, "Debe ingresar la cantidad comprada");
		Validar.noNulo(fec_requerida, "Debe ingresar la Fecha Requerida");
		Validar.noNulo(decision_autoriz, "Debe ingresar la Decisión");
		Validar.noNulo(anulada, "Debe ingresar el estado de Anulación");
		Validar.noNulo(solo_cotizar, "Debe ingresar si se cotiza o no");
		Validar.noNulo(pend_sol_cotiz, "Debe ingresar si esta pend. Cotiz.");
		Validar.noNulo(fec_emision, "Debe ingresar la Fecha de Emisión");
	}

	public void onNew() throws BaseException {
		setCan_comprada(new Double(0));
		setCant_solicitada(new Double(0));
		setFec_entrega(null);
		setPendCompra(new Boolean(false));
		setAnulada(new Boolean(false));
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

	public static List getRequisicionesDet(RequisicionCab requisicionCab,
			ISesion aSesion) throws BaseException {
		return DBRequisicionDet.getRequisicionesDet(requisicionCab, aSesion);
	}

	public List getAutorizacionesReqDet() throws BaseException {
		if (readAutorizacionesReqDet) {
			List listaAutorizReqDet = RequisicionDetAutorizacion
					.getAutorizadoresRequisicionDet(this, getSesion());
			autorizacionesReqDet.addAll(listaAutorizReqDet);
			readAutorizacionesReqDet = false;
		}
		return autorizacionesReqDet;
	}

	public void addAutorizacionRequisicionDet(
			RequisicionDetAutorizacion reqDetAutorizacion) throws BaseException {
		reqDetAutorizacion.setRequesicion_detalle(this);
		autorizacionesReqDet.add(reqDetAutorizacion);
	}

	public void afterSave() throws BaseException {
		Iterator iterAutorizacionesReqDet = autorizacionesReqDet.iterator();
		while (iterAutorizacionesReqDet.hasNext()) {
			RequisicionDetAutorizacion reqDetAutorizacion = (RequisicionDetAutorizacion) iterAutorizacionesReqDet
					.next();
			reqDetAutorizacion.save();
			reqDetAutorizacion = null;
		}
		iterAutorizacionesReqDet = null;
	}

	public void autorizar() throws BaseException {

		if (isAutorizado())
			throw new ExceptionValidation(null, "El Nro. item "
					+ getRenglon().toString() + " Producto:"
					+ getProducto().getCodigo() + "-"
					+ getProducto().getDescripcion() + " del Comprobante:"
					+ getRequisicion().getCodigo()
					+ " ya se encuentra autorizado.");
		/*
		 * else if (isRechazado()) throw new ExceptionValidation(null,
		 * "El Nro. item " + getRenglon().toString() + " Producto:" +
		 * getProducto().getCodigo() + "-" + getProducto().getDescripcion() +
		 * " del Comprobante:" + getRequisicion().getCodigo() +
		 * " se encuentra rechazado.");
		 */

		boolean todosLosItemsAutoriz = true;
		Iterator iterAutorizaciones = getAutorizacionesReqDet().iterator();
		while (iterAutorizaciones.hasNext()) {
			RequisicionDetAutorizacion reqDetAutoriz = (RequisicionDetAutorizacion) iterAutorizaciones
					.next();
			if (!reqDetAutoriz.autorizar())
				todosLosItemsAutoriz = false;
		}
		if (todosLosItemsAutoriz)
			setDecision_autoriz(RequisicionDetAutorizacion.AUTORIZADO);
	}

	public void rechazar() throws BaseException {

		if (isRechazado())
			throw new ExceptionValidation(null, "El Nro. item "
					+ getRenglon().toString() + " Producto:"
					+ getProducto().getCodigo() + "-"
					+ getProducto().getDescripcion() + " del Comprobante:"
					+ getRequisicion().getCodigo()
					+ " ya se encuentra rechazado.");

		boolean rechazar = false;
		Iterator iterAutorizaciones = getAutorizacionesReqDet().iterator();
		while (iterAutorizaciones.hasNext()) {
			RequisicionDetAutorizacion reqDetAutoriz = (RequisicionDetAutorizacion) iterAutorizaciones
					.next();
			if (reqDetAutoriz.rechazar())
				rechazar = true;
		}
		if (rechazar)
			setDecision_autoriz(RequisicionDetAutorizacion.RECHAZADO);
	}

	public boolean isAutorizado() throws BaseException {
		supportRefresh();
		if (getDecision_autoriz().intValue() == RequisicionDetAutorizacion.AUTORIZADO
				.intValue())
			return true;
		else
			return false;
	}

	public boolean isRechazado() throws BaseException {
		supportRefresh();
		if (getDecision_autoriz().intValue() == RequisicionDetAutorizacion.RECHAZADO
				.intValue())
			return true;
		else
			return false;
	}

	public boolean isPendAutoriz() throws BaseException {
		supportRefresh();
		if (getDecision_autoriz().intValue() == RequisicionDetAutorizacion.PEND_AUTORIZ
				.intValue())
			return true;
		else
			return false;
	}

	public void marcarSiEstaPendCompra() throws BaseException {
		if (isSolo_cotizar().booleanValue() == false) {
			if (getCant_solicitada().doubleValue() > getCan_comprada()
					.doubleValue())
				setPendCompra(new Boolean(true));
			else
				setPendCompra(new Boolean(false));
		}
	}

	public void aplicarCantComprada(AplicRequiDet aplicRequiDet)
			throws BaseException {
		CalculadorMoney calcCantComprada = new CalculadorMoney(new NumeroBase(
				getCan_comprada()));
		calcCantComprada
				.sumar(new NumeroBase(aplicRequiDet.getCant_comprada()));
		setCan_comprada(new Double(calcCantComprada.getResultNroBase()
				.doubleValue()));
	}

	public void desaplicarCantComprada(AplicRequiDet aplicRequiDet)
			throws BaseException {
		CalculadorMoney calcCantComprada = new CalculadorMoney(new NumeroBase(
				getCan_comprada()));
		calcCantComprada
				.restar(new NumeroBase(aplicRequiDet.getCant_comprada()));
		setCan_comprada(new Double(calcCantComprada.getResultNroBase()
				.doubleValue()));
	}

	public void marcarSiNoEstaPendDeCompra() throws BaseException {
		if (getCant_solicitada().doubleValue() > getCan_comprada()
				.doubleValue())
			setPendCompra(new Boolean(true));
		else
			setPendCompra(new Boolean(false));
	}

	public Double getcantPendCompra() throws BaseException {

		if (this.isAnulada())
			return new Double(0);
		
		if (!this.getRequisicion().isActivo())
			return new Double(0);
		
		if (!getPendCompra().booleanValue())
			return new Double(0);
		else {
			CalculadorMoney calcCantPendCompra = new CalculadorMoney(
					new NumeroBase(getCant_solicitada()));
			calcCantPendCompra.restar(new NumeroBase(getCan_comprada()));
			return new Double(calcCantPendCompra.getResultMoney().doubleValue());
		}
	}

	public String getRolesAutorizadores() throws BaseException {
		StringBuffer roles = new StringBuffer("");
		supportRefresh();
		Iterator iterAutReqDet = this.getAutorizacionesReqDet().iterator();
		while (iterAutReqDet.hasNext()) {
			RequisicionDetAutorizacion reqDetAutoriz = (RequisicionDetAutorizacion) iterAutReqDet
					.next();
			roles.append(" (");
			if (reqDetAutoriz.isPendAutorizar())
				roles.append("?");
			else if (reqDetAutoriz.isAutorizado())
				roles.append("Ok");
			else if (reqDetAutoriz.isRechazado())
				roles.append("X");
			roles.append(") "
					+ reqDetAutoriz.getRolAutorizadorCompras().getDescripcion()
					+ " - ");
		}
		return roles.toString();
	}

	public static List getRequisicionesPendCompra(Producto producto,
			ISesion aSesion) throws BaseException {
		return DBRequisicionDet.getRequisicionesPendCompra(producto, aSesion);
	}

	public String getReferencia() throws BaseException {
		StringBuffer ref = new StringBuffer("");
		if ((this.getNickNameTipoComproRef() != null)
				&& (this.getOidComproRef() != null)
				&& (this.getOidComproRef().intValue() > 0)) {

			if (this.getNickNameTipoComproRef().equals(PedidoCab.NICKNAME)) {
				PedidoCab pedido = PedidoCab.findByOidProxy(this
						.getOidComproRef(), this.getSesion());
				ref.append(pedido.getCodigo());

				if ((this.getOidComproRefDet() != null)
						&& (this.getOidComproRefDet().intValue() > 0)) {

					PedidoDet pedidoDet = PedidoDet.findByOidProxy(this
							.getOidComproRefDet(), this.getSesion());

					if (pedidoDet != null)
						ref.append("/" + pedidoDet.getNroRenglon());

				}

			}

		}
		return ref.toString();
	}

	public boolean isAutorizable(Usuario usuario) throws BaseException {
		Iterator iterAutReqDet = this.getAutorizacionesReqDet().iterator();
		while (iterAutReqDet.hasNext()) {
			RequisicionDetAutorizacion reqDetAutoriz = (RequisicionDetAutorizacion) iterAutReqDet
					.next();
			if (reqDetAutoriz.getRolAutorizadorCompras().tieneElRol(usuario))
				return true;
		}
		return false;
	}

	public static int getMaxNroRenglon(ISesion aSesion,
			RequisicionCab requisicion) throws BaseException {

		return DBRequisicionDet.getMaxNroRenglon(aSesion, requisicion);

	}
	
	  public static List getAllDetalles(
		  		Proveedor proveedor,
		  		Integer nroDesde,
		  		Integer nroHasta,
		  		java.util.Date fecDesde,
		  		java.util.Date fecHasta,
		  		java.util.Date fecEntDesde,
		  		java.util.Date fecEntHasta,
		  		Producto producto,
		      ISesion aSesion) throws BaseException {
		  	return DBRequisicionDet.getAllDetalles(
		  			proveedor,
		  			nroDesde,
		  			nroHasta,
		  			fecDesde,
		  			fecHasta,
		  			fecEntDesde,
		  			fecEntHasta,
		  			producto,
		  			aSesion);
		  }
	

}
