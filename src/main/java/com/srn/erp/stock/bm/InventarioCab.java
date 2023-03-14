package com.srn.erp.stock.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.general.bm.Talonario;
import com.srn.erp.stock.da.DBInventarioCab;

import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class InventarioCab extends ComproCab implements IStockeable {

	private List detalles = new ArrayList();
	private boolean readDetalles = true;
	private EstadoStock estadoLibre = null;

	private ComproCab comprobante;

	public void setComprobante(ComproCab aComprobante) {
		this.comprobante = aComprobante;
	}

	public ComproCab getComprobante() {
		return comprobante;
	}

	public EstadoStock getEstadoLibre() throws BaseException {
		if (this.estadoLibre == null)
			estadoLibre = EstadoStock.getEstadoStockLibre(this.getSesion());
		return estadoLibre;
	}

	public InventarioCab() {
	}

	public static String NICKNAME = "st.InventarioCab";

	private Deposito deposito;
	private java.util.Date fec_inventario;

	public Deposito getDeposito() throws BaseException {
		supportRefresh();
		return deposito;
	}

	public void setDeposito(Deposito aDeposito) {
		this.deposito = aDeposito;
	}

	public java.util.Date getFec_inventario() throws BaseException {
		supportRefresh();
		return fec_inventario;
	}

	public void setFec_inventario(java.util.Date aFec_inventario) {
		this.fec_inventario = aFec_inventario;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static InventarioCab findByOid(Integer oid, ISesion aSesion)
			throws BaseException {
		return (InventarioCab) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static InventarioCab findByOidProxy(Integer oid, ISesion aSesion)
			throws BaseException {
		return (InventarioCab) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static InventarioCab findByCodigo(String codigo, ISesion aSesion)
			throws BaseException {
		return (InventarioCab) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(deposito, "Debe ingresar el Depósito");
		Validar.noNulo(fec_inventario, "Debe ingresar la fecha de Inventario");

		if (this.isNew()) {
			this.setComprobante(this);
			this.setEstado(ComproCab.ESTADO_ALTA);
			this.setActivo(new Boolean(true));
		}
		beforeSaveComprobante(this);

	}

	public RenglonesStock getRenglonesStock() throws BaseException {
		RenglonesStock renglonesStock = new RenglonesStock();
		Iterator iterDetalles = detalles.iterator();
		while (iterDetalles.hasNext()) {
			InventarioDet inventarioDet = (InventarioDet) iterDetalles.next();
			armarMovStock(renglonesStock, inventarioDet);
		}
		return renglonesStock;
	}

	private void armarMovStock(RenglonesStock renglonesStock,
			InventarioDet inventarioDet) throws BaseException {

		if (inventarioDet.getAju_stock() == null)
			return;

		if (inventarioDet.getAju_stock().doubleValue() == 0)
			return;

		RenglonMovStock renglonMovStk = renglonesStock.addRenglonMovStock();
		renglonMovStk.setComproCab(this);
		renglonMovStk.setDeposito(this.getDeposito());
		renglonMovStk.setUbicacionDeposito(this.getDeposito().getUbicacionDepositoDefault());
		renglonMovStk.setEstadoStock(getEstadoLibre());
		renglonMovStk.setPartida(null);
		renglonMovStk.setSerie(null);
		renglonMovStk.setProducto(inventarioDet.getProducto());
		renglonMovStk.setFecha(getEmision());

		// Definir si el ajuste debe set positivo o negativo
		int signo = 1;
		double ajuste = inventarioDet.getAju_stock();
		if (ajuste < 0) {
			ajuste = ajuste * -1;
			signo = -1;
		}
		renglonMovStk.setCantidad(new Double(ajuste));
		renglonMovStk.setSigno(new Integer(signo));
		renglonMovStk.setUnidadMedida(inventarioDet.getProducto().getUm_stk());
		renglonMovStk.setAfectaStockFisico(new Boolean(true));
		renglonMovStk.setActivo(new Boolean(true));

	}

	public List getDetalles() throws BaseException {
		if (this.readDetalles) {
			List listaDetalles = InventarioDet.getDetallesByInventario(this,
					getSesion());
			this.detalles.addAll(listaDetalles);
			this.readDetalles = false;
		}
		return this.detalles;
	}

	public void addDetalle(InventarioDet aInventarioDet) throws BaseException {
		aInventarioDet.setInventario_cab(this);
		detalles.add(aInventarioDet);
	}

	public void afterSave() throws BaseException {
		Iterator iterDetalles = this.detalles.iterator();
		while (iterDetalles.hasNext()) {
			InventarioDet inventarioDet = (InventarioDet) iterDetalles.next();
			inventarioDet.save();
			inventarioDet = null;
		}
		iterDetalles = null;
	}
	
	public static Talonario getTalonarioInventario(ISesion aSesion) throws BaseException {
		return Talonario.getTalonatioInventario(aSesion);
	}
	
	public static List getInventarioCab(
			Integer nroExtDesde, 
			Integer nroExtHasta, 
			java.util.Date fecDesde,
			java.util.Date fecHasta, 
			Producto producto, ISesion aSesion) throws BaseException {
		return DBInventarioCab.getComproCab(nroExtDesde, nroExtHasta, fecDesde, fecHasta, producto , aSesion);
	}
	

}
