package com.srn.erp.ventas.bm;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.contabilidad.bm.IContabilizable;
import com.srn.erp.contabilidad.bm.RenglonesAsiento;
import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.general.bm.Talonario;
import com.srn.erp.stock.bm.IStockeable;
import com.srn.erp.stock.bm.RenglonesStock;

import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.Fecha;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.Validar;

public class PedidoCabAnulacion extends ComproCab implements IContabilizable, IStockeable {

	public PedidoCabAnulacion() {
	}

	private List					detalles		= new ArrayList();

	private boolean				readDetalle	= true;

	private ComproCab			comprobante;

	public static String	NICKNAME		= "ve.PedidoCabAnulacion";

	private PedidoCab			pedido_cab;

	public PedidoCab getPedido_cab() throws BaseException {
		supportRefresh();
		return pedido_cab;
	}

	public void setPedido_cab(PedidoCab aPedido_cab) {
		this.pedido_cab = aPedido_cab;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static PedidoCabAnulacion findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (PedidoCabAnulacion) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static PedidoCabAnulacion findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (PedidoCabAnulacion) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(pedido_cab, "Debe ingresar el Pedido");
		
			beforeSaveComprobante(this);
			if (this.isNew()) {
				this.setComprobante(this);
				this.setEstado(ComproCab.ESTADO_ALTA);
  		}
		
	}

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public RenglonesAsiento getRenglonesAsiento() throws BaseException {
		// TODO Auto-generated method stub
		// return getInforme_recepcion().getComproConta().getRenglonesAsientoInvertidos();
		return null;
	}

	public ComproCab getComprobante() throws BaseException {
		// TODO Auto-generated method stub
		return this;
	}

	public Date getImputacion() throws BaseException {
		// TODO Auto-generated method stub
		return getImputac();
	}

	public RenglonesStock getRenglonesStock() throws BaseException {
		return this.getPedido_cab().getStockCabecera().getRenglonesStockInvertidos(this);
	}

	public void addDetalle(PedidoDetAnulacion pedidoDetAnulacion) throws BaseException {
		this.detalles.add(pedidoDetAnulacion);
		pedidoDetAnulacion.setPedido_cab_anu(this);
	}

	public List getDetalles() throws BaseException {
		if (readDetalle == true) {
			detalles.addAll(PedidoDetAnulacion.getDetalles(this, getSesion()));
			readDetalle = false;
		}
		return detalles;
	}

	public void afterSave() throws BaseException {

		Iterator iterDetalles = this.detalles.iterator();
		while (iterDetalles.hasNext()) {
			PedidoDetAnulacion pedidoDetAnulacion = (PedidoDetAnulacion) iterDetalles.next();
			pedidoDetAnulacion.save();
			pedidoDetAnulacion = null;
		}
		iterDetalles = null;

		afterSaveComprobante(this);

		anularComprobante(this.getPedido_cab());

	}

	public void generarComproAnulacion() throws BaseException {

		// Set datos del comrobante
		setContabiliza(true);
		Talonario talonarioAnulacion = this.getPedido_cab().getTalonario().getTalonarioAnulacion();
		if (talonarioAnulacion == null)
			throw new ExceptionValidation(null, "No existe talonario de anulación para el talonario "
					+ this.getPedido_cab().getTalonario().getDescripcion());
		setTalonario(talonarioAnulacion);
		setTipoCompro(talonarioAnulacion.getTipo_comprobante());
		setLetra(talonarioAnulacion.getLetra());
		setLugarEmision(talonarioAnulacion.getLugar_emision());
		setNroext(new Integer(0));
		setEmision(Fecha.getFechaActual());
		setImputac(Fecha.getFechaActual());
		setComentario("");
		setActivo(new Boolean(true));

		Iterator iterPedidoDet = this.getPedido_cab().getDetalles().iterator();
		while (iterPedidoDet.hasNext()) {
			PedidoDet pedidoDet = (PedidoDet) iterPedidoDet.next();
			if (pedidoDet.isAnulado().booleanValue())
				continue;
			PedidoDetAnulacion pedidoDetAnulacion = (PedidoDetAnulacion) PedidoDetAnulacion.getNew(PedidoDetAnulacion.NICKNAME,
					getSesion());
			pedidoDetAnulacion.setPedido_cab_anu(this);
			pedidoDetAnulacion.setPedido_det(pedidoDet);
			addDetalle(pedidoDetAnulacion);
		}

	}
	
	public void setComprobante(ComproCab aComprobante) {
		this.comprobante = aComprobante;
	}
	

}
