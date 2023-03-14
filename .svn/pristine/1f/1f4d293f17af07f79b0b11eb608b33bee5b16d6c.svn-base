package com.srn.erp.ventas.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.general.bm.Talonario;
import com.srn.erp.stock.bm.IStockeable;
import com.srn.erp.stock.bm.MovStockTalonarioDeposito;
import com.srn.erp.stock.bm.RenglonMovStock;
import com.srn.erp.stock.bm.RenglonesStock;
import com.srn.erp.ventas.da.DBIngresoDevolucionStockCab;

import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;

public class IngresoDevolucionStockCab extends ComproCab implements IStockeable {

	private ComproCab comprobante;
	private Talonario talonarioOrigen;
	private AnuIngDevStkCab anulacionDevCab;

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return super.getDescripcion();
	}

	public IngresoDevolucionStockCab() {
	}

	public static String NICKNAME = "ve.IngresoDevolucionStockCab";

	private List detallesDev = new ArrayList();
	private boolean readDetallesDev = true;

	public String getNickName() {
		return NICKNAME;
	}

	public Talonario getTalonarioOrigen() throws BaseException {
		this.supportRefresh();
		return this.talonarioOrigen;
	}

	public void setTalonarioOrigen(Talonario aTalonarioOrigen) throws BaseException {
		this.talonarioOrigen = aTalonarioOrigen;
	}

	public void beforeSave() throws BaseException {

		if (this.isNew()) {
			this.setComprobante(this);
			this.setEstado(ComproCab.ESTADO_ALTA);
			this.setActivo(new Boolean(true));
		}

		beforeSaveComprobante(this);

		validarDatos();

	}

	private void validarDatos() throws BaseException {

	}

	public void setComprobante(ComproCab aComprobante) {
		this.comprobante = aComprobante;
	}

	public List getDetallesDev() throws BaseException {
		if (this.readDetallesDev) {
			List listaDetallesDev = IngStockDevVtasDet.getIngresoDevolucionesDet(this, getSesion());
			detallesDev.addAll(listaDetallesDev);
			readDetallesDev = false;
		}
		return detallesDev;
	}

	public void addDetalleDev(IngStockDevVtasDet aIngStockDevVtasDet) throws BaseException {
		aIngStockDevVtasDet.setIngresodevolucionstockcab(this);
		detallesDev.add(aIngStockDevVtasDet);
	}

	public void afterSave() throws BaseException {
		Iterator iterDevolucionesDet = detallesDev.iterator();
		while (iterDevolucionesDet.hasNext()) {
			IngStockDevVtasDet devVtasDet = (IngStockDevVtasDet) iterDevolucionesDet.next();
			devVtasDet.save();
			devVtasDet = null;
		}
		iterDevolucionesDet = null;
	}

	public static IngresoDevolucionStockCab findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (IngresoDevolucionStockCab) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static IngresoDevolucionStockCab findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (IngresoDevolucionStockCab) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public RenglonesStock getRenglonesStock() throws BaseException {

		RenglonesStock renglonesStock = new RenglonesStock();

		if (this.detallesDev == null)
			return renglonesStock;

		Iterator iterIngDev = this.detallesDev.iterator();
		while (iterIngDev.hasNext()) {
			IngStockDevVtasDet ingDevVtasDet = (IngStockDevVtasDet) iterIngDev.next();

			Iterator iterMovStkTal = ingDevVtasDet.getMovimiento_stock().getMoviStockTalonarios().iterator();
			while (iterMovStkTal.hasNext()) {
				MovStockTalonarioDeposito movStkTalDep = (MovStockTalonarioDeposito) iterMovStkTal.next();
				RenglonMovStock renglonMovStk = renglonesStock.addRenglonMovStock();
				renglonMovStk.setComproCab(this);
				renglonMovStk.setDeposito(movStkTalDep.getDeposito());
				if (movStkTalDep.getUbiDepoHabTalDefault() == null)
					throw new ExceptionValidation(null, "Falta Definir la ubicación Default para el Mov. de Stock "
							+ ingDevVtasDet.getMovimiento_stock().getDescripcion());
				renglonMovStk.setUbicacionDeposito(movStkTalDep.getUbiDepoHabTalDefault().getUbicacion_deposito());
				renglonMovStk.setEstadoStock(movStkTalDep.getEstado_stock());
				renglonMovStk.setPartida(null);
				renglonMovStk.setSerie(null);
				renglonMovStk.setFecha(this.getEmision());
				renglonMovStk.setCantidad(ingDevVtasDet.getCantidad());
				renglonMovStk.setSigno(movStkTalDep.getSignoStock());
				renglonMovStk.setUnidadMedida(ingDevVtasDet.getUnidad_medida());
				renglonMovStk.setAfectaStockFisico(movStkTalDep.isAfectaStockFisico());
				renglonMovStk.setActivo(new Boolean(true));
				renglonMovStk.setProducto(ingDevVtasDet.getDevolucion_det().getProducto());

			}

		}

		return renglonesStock;
	}

	public ComproCab getComprobante() throws BaseException {
		return comprobante;
	}

	public static List getHelpIngDevStock(Integer nroExtDesde, Integer nroExtHasta, java.util.Date fecDesde, java.util.Date fecHasta,
			Talonario talonario, Integer nroIngDev, ISesion aSesion) throws BaseException {
		return DBIngresoDevolucionStockCab.getHelpIngDevStock(nroExtDesde, nroExtHasta, fecDesde, fecHasta, talonario, nroIngDev, aSesion);
	}

	public void anular() throws BaseException {

		anulacionDevCab = (AnuIngDevStkCab) anulacionDevCab.getNew(AnuIngDevStkCab.NICKNAME,getSesion());
		anulacionDevCab.setIngreso_devolucion_stk_cab(this);
		anulacionDevCab.generarComproAnulacion();
		anulacionDevCab.save();

	}

}
