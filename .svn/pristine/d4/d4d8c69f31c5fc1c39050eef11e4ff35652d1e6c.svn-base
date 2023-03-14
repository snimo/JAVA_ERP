package com.srn.erp.compras.bm;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.compras.da.DBInformeControlCalidad;
import com.srn.erp.contabilidad.bm.Componente;
import com.srn.erp.contabilidad.bm.Cuenta;
import com.srn.erp.contabilidad.bm.CuentaImputable;
import com.srn.erp.contabilidad.bm.IContabilizable;
import com.srn.erp.contabilidad.bm.RenglonAsiento;
import com.srn.erp.contabilidad.bm.RenglonesAsiento;
import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.stock.bm.ConfMovStkTalonario;
import com.srn.erp.stock.bm.IStockeable;
import com.srn.erp.stock.bm.MovStockTalonarioDeposito;
import com.srn.erp.stock.bm.RenglonMovStock;
import com.srn.erp.stock.bm.RenglonesStock;
import com.srn.erp.stock.bm.TipoConfMovStkTalonario;

import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Parametros.ValorParametro;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.HashTableDatos;

public class InformeControlCalidad extends ComproCab implements
		IContabilizable, IStockeable {

	private ComproCab comprobante;
	AnuladorInfCC anuladorInfCC;
	private List detallesInfCC = new ArrayList();

	private boolean readDetallesInfCC = true;

	public void setComprobante(ComproCab aComprobante) {
		this.comprobante = aComprobante;
	}
	
	public AnuladorInfCC getAnuladorInfCC() throws BaseException {
		return anuladorInfCC;
	}

	public ComproCab getComprobante() throws BaseException {
		// TODO Auto-generated method stub
		return this.comprobante;
	}

	public InformeControlCalidad() {
	}

	public static String NICKNAME = "cp.InformeControlCalidad";

	public String getNickName() {
		return NICKNAME;
	}

	public static InformeControlCalidad findByOid(Integer oid, ISesion aSesion)
			throws BaseException {
		return (InformeControlCalidad) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static InformeControlCalidad findByOidProxy(Integer oid,
			ISesion aSesion) throws BaseException {
		return (InformeControlCalidad) getObjectByOidProxy(NICKNAME, oid,
				aSesion);
	}

	public void beforeSave() throws BaseException {

		if (this.isNew()) {
			this.setComprobante(this);
			this.setEstado(ComproCab.ESTADO_ALTA);
			this.setActivo(new Boolean(true));
		}
		beforeSaveComprobante(this);

	}

	public static boolean getContabilizarInformeCC(ISesion aSesion)
			throws BaseException {
		ValorParametro valorParamContabilizaInfRec = ValorParametro
				.findByCodigoParametro("CONTABILIZA_INF_CC", aSesion);
		return valorParamContabilizaInfRec.getBoolean();
	}

	public List getDetallesInfCC() throws BaseException {
		if (readDetallesInfCC) {
			List listaDetallesInfCC = InformeControlCalidadDet
					.getDetallesInfCC(this, getSesion());
			detallesInfCC.addAll(listaDetallesInfCC);
			readDetallesInfCC = false;
		}
		return detallesInfCC;
	}

	public void addDetalleInfCC(
			InformeControlCalidadDet informeControlCalidadDet)
			throws BaseException {
		informeControlCalidadDet.setInforme_cc(this);
		detallesInfCC.add(informeControlCalidadDet);
	}

	public void afterSave() throws BaseException {
		Iterator iterInformesControlCalidadDet = detallesInfCC.iterator();
		while (iterInformesControlCalidadDet.hasNext()) {
			InformeControlCalidadDet infCCDet = (InformeControlCalidadDet) iterInformesControlCalidadDet
					.next();
			infCCDet.save();
			infCCDet = null;
		}
		iterInformesControlCalidadDet = null;

		afterSaveComprobante(this);
	}

	public static List getInformesCC(HashTableDatos aCondiciones,
			ISesion aSesion) throws BaseException {
		return DBInformeControlCalidad.getInformesCC(aCondiciones, aSesion);
	}

	public static InformeControlCalidad getInformeCC(String identificador,
			ISesion aSesion) throws BaseException {
		ComproCab comproCab = ComproCab.getComproCab(identificador, aSesion);
		if (comproCab == null)
			throw new ExceptionValidation(null,
					"Informe de Control de Calidad inexistente");
		InformeControlCalidad infCC = InformeControlCalidad.findByOid(comproCab
				.getOIDInteger(), aSesion);
		if (infCC == null)
			throw new ExceptionValidation(null,
					"Informe de Control de calidad inexistente");
		return infCC;
	}

	public Date getImputacion() throws BaseException {
		// TODO Auto-generated method stub
		return this.getImputac();
	}

	public RenglonesAsiento getRenglonesAsiento() throws BaseException {

		Componente compoInfRecDet = Componente.getCompoInfRecDet(getSesion());
		Componente compoInfRec = Componente.getCompoInfRec(getSesion());
		Cuenta cuentaProvision = Cuenta.getCuentaProvisionCompras(getSesion());

		RenglonesAsiento renglones = new RenglonesAsiento();
		Iterator iterDetalles = detallesInfCC.iterator();
		while (iterDetalles.hasNext()) {

			// Verificar que se encuentre asignada la cuenta compras
			InformeControlCalidadDet infCCDet = (InformeControlCalidadDet) iterDetalles
					.next();

			// Si no hay rechazos no contabilizar el Item
			if (infCCDet.getCant_mal_uc().doubleValue() == 0)
				continue;

			if (infCCDet.getInforme_recepcion_det().getProducto()
					.getCuenta_cpra() == null)
				throw new ExceptionValidation(null,
						"No se encuentra configurada la cuenta compras para el producto "
								+ infCCDet.getInforme_recepcion_det()
										.getProducto().getCodigo()
								+ " - "
								+ infCCDet.getInforme_recepcion_det()
										.getProducto().getDescripcion());
			Cuenta cuentaCompras = infCCDet.getInforme_recepcion_det()
					.getProducto().getCuenta_cpra();

			// Acreditar las compras
			RenglonAsiento renglonCompra = renglones.addRenglonAsiento();
			renglonCompra.setD_H(RenglonAsiento.HABER);
			CuentaImputable imputableCompras = InformeRecepcion
					.getImputableCompras(cuentaCompras, infCCDet
							.getInforme_recepcion_det(), compoInfRecDet,
							getSesion());

			renglonCompra.setCuentaImputable(imputableCompras);
			Moneda monedaOC = infCCDet.getInforme_recepcion_det()
					.getOrdenDeCompraDet().getOrden_de_compra().getMoneda();
			renglonCompra.setMonedaOri(monedaOC);
			renglonCompra.setImporteOri(infCCDet.getImpoRechazoMonOri());
			renglonCompra.setComentario("");
			renglonCompra.setImpoLocHist(infCCDet.getImpoRechazoMonLoc());
			renglonCompra.setImpoLocAju(infCCDet.getImpoRechazoMonLoc());
			renglonCompra.setImpoMonExt1(infCCDet.getImpoRechazoMonExt1());
			renglonCompra.setImpoMonExt2(infCCDet.getImpoRechazoMonExt2());
			renglonCompra.setCotizOri(infCCDet.getInforme_recepcion_det()
					.getValorCotizMonOri());
			renglonCompra.setCotizMonExt1(infCCDet.getInforme_recepcion_det()
					.getValorCotizMonExt1());
			renglonCompra.setCotizMonExt2(infCCDet.getInforme_recepcion_det()
					.getValorCotizMonExt2());

			// Debitar las cuenta Provision
			RenglonAsiento renglonProvision = renglones.addRenglonAsiento();
			renglonProvision.setD_H(RenglonAsiento.DEBE);
			CuentaImputable imputableProvision = InformeRecepcion
					.getCuentaImputableProvision(cuentaProvision, compoInfRec,
							infCCDet.getInforme_recepcion_det()
									.getInforme_recepcion(), getSesion());
			renglonProvision.setCuentaImputable(imputableProvision);
			renglonProvision.setMonedaOri(monedaOC);
			renglonProvision.setImporteOri(infCCDet.getImpoRechazoMonOri());
			renglonProvision.setComentario("");
			renglonProvision.setImpoLocHist(infCCDet.getImpoRechazoMonLoc());
			renglonProvision.setImpoLocAju(infCCDet.getImpoRechazoMonLoc());
			renglonProvision.setImpoMonExt1(infCCDet.getImpoRechazoMonExt1());
			renglonProvision.setImpoMonExt2(infCCDet.getImpoRechazoMonExt2());
			renglonProvision.setCotizOri(infCCDet.getInforme_recepcion_det()
					.getValorCotizMonOri());
			renglonProvision.setCotizMonExt1(infCCDet
					.getInforme_recepcion_det().getValorCotizMonExt1());
			renglonProvision.setCotizMonExt2(infCCDet
					.getInforme_recepcion_det().getValorCotizMonExt2());

		}

		if (renglones.getListaRenglones().size() == 0)
			return null;
		else
			return renglones;
	}

	public RenglonesStock getRenglonesStock() throws BaseException {
		RenglonesStock renglonesStock = new RenglonesStock();
		Iterator iterDetInfCC = detallesInfCC.iterator();
		while (iterDetInfCC.hasNext()) {
			InformeControlCalidadDet infCCDet = (InformeControlCalidadDet) iterDetInfCC
					.next();
			if (infCCDet.getInforme_recepcion_det().getProducto()
					.isStockeable().booleanValue())
				armarMovStock(renglonesStock, infCCDet);
		}
		return renglonesStock;
	}

	private void armarMovStockCCOk(ConfMovStkTalonario confMovStockTal,
			RenglonesStock renglonesStock, InformeControlCalidadDet infCCDet)
			throws BaseException {

		TipoConfMovStkTalonario tipoMovStk = confMovStockTal
				.getTipoConfMovStkCCOK();
		if (tipoMovStk == null)
			throw new ExceptionValidation(null,
					"No se encuentra configurado un movimiento de Stock de Control de Calidad OK "
							+ "para el talonario "
							+ infCCDet.getInforme_cc().getTalonario()
									.getDescripcion());

		Iterator iterMovStock = tipoMovStk.getMoviStockTalonarios().iterator();
		while (iterMovStock.hasNext()) {
			MovStockTalonarioDeposito movStkTalDepo = (MovStockTalonarioDeposito) iterMovStock
					.next();
			RenglonMovStock renglonMovStk = renglonesStock.addRenglonMovStock();
			renglonMovStk.setComproCab(this);
			renglonMovStk.setDeposito(movStkTalDepo.getDeposito());
			renglonMovStk.setUbicacionDeposito(movStkTalDepo
					.getUbiDepoHabTalDefault(
							infCCDet.getInforme_recepcion_det().getProducto())
					.getUbicacion_deposito());
			renglonMovStk.setEstadoStock(movStkTalDepo.getEstado_stock());
			renglonMovStk.setPartida(null);
			renglonMovStk.setSerie(null);
			renglonMovStk.setProducto(infCCDet.getInforme_recepcion_det()
					.getProducto());
			renglonMovStk.setFecha(getImputac());

			renglonMovStk.setCantidad(infCCDet.getCant_ok_us());
			renglonMovStk.setSigno(movStkTalDepo.getSignoStock());
			renglonMovStk.setUnidadMedida(infCCDet.getInforme_recepcion_det()
					.getUnidadMedidaStock());
			renglonMovStk.setAfectaStockFisico(movStkTalDepo
					.isAfectaStockFisico());
			renglonMovStk.setActivo(new Boolean(true));
		}

	}

	private void armarMovStockCCMal(ConfMovStkTalonario confMovStockTal,
			RenglonesStock renglonesStock, InformeControlCalidadDet infCCDet)
			throws BaseException {

		TipoConfMovStkTalonario tipoMovStk = confMovStockTal
				.getTipoConfMovStkCCMal();
		if (tipoMovStk == null)
			throw new ExceptionValidation(null,
					"No se encuentra configurado un movimiento de Stock de Rechazo por Control de Calidad "
							+ "para el talonario "
							+ infCCDet.getInforme_cc().getTalonario()
									.getDescripcion());

		Iterator iterMovStock = tipoMovStk.getMoviStockTalonarios().iterator();
		while (iterMovStock.hasNext()) {
			MovStockTalonarioDeposito movStkTalDepo = (MovStockTalonarioDeposito) iterMovStock
					.next();
			RenglonMovStock renglonMovStk = renglonesStock.addRenglonMovStock();
			renglonMovStk.setComproCab(this);
			renglonMovStk.setDeposito(movStkTalDepo.getDeposito());
			renglonMovStk.setUbicacionDeposito(movStkTalDepo
					.getUbiDepoHabTalDefault(
							infCCDet.getInforme_recepcion_det().getProducto())
					.getUbicacion_deposito());
			renglonMovStk.setEstadoStock(movStkTalDepo.getEstado_stock());
			renglonMovStk.setPartida(null);
			renglonMovStk.setSerie(null);
			renglonMovStk.setProducto(infCCDet.getInforme_recepcion_det()
					.getProducto());
			renglonMovStk.setFecha(getImputac());

			renglonMovStk.setCantidad(infCCDet.getCant_mal_us());
			renglonMovStk.setSigno(movStkTalDepo.getSignoStock());
			renglonMovStk.setUnidadMedida(infCCDet.getInforme_recepcion_det()
					.getUnidadMedidaStock());
			renglonMovStk.setAfectaStockFisico(movStkTalDepo
					.isAfectaStockFisico());
			renglonMovStk.setActivo(new Boolean(true));
		}

	}

    private void armarMovStock(RenglonesStock renglonesStock,
			InformeControlCalidadDet infCCDet) throws BaseException {

		ConfMovStkTalonario confMovStockTal = 
			infCCDet.getInforme_cc().getTalonario().getConfMovStock();

		if (confMovStockTal == null)
			throw new ExceptionValidation(null,
					"Falta configurar los movimientos de Stock para el talonario "
							+ infCCDet.getInforme_cc().getTalonario().getDescripcion());
		
		if (infCCDet.getCant_ok_us().doubleValue()>0)
			armarMovStockCCOk(confMovStockTal,renglonesStock,infCCDet);
		
		if (infCCDet.getCant_mal_us().doubleValue()>0)
			armarMovStockCCMal(confMovStockTal,renglonesStock,infCCDet);		
				
	}
    
    public void anular() throws BaseException {
    	
		// Anular los Detalles
		Iterator iterDetalles = getDetallesInfCC().iterator();
		while (iterDetalles.hasNext()) {
			InformeControlCalidadDet infCCDet = (InformeControlCalidadDet) iterDetalles.next();
			infCCDet.setForDelete();
			infCCDet.save();
		}
    	
    	
		anuladorInfCC = (AnuladorInfCC) AnuladorInfCC.getNew(AnuladorInfCC.NICKNAME,getSesion());
		anuladorInfCC.setControl_calidad(this);
		anuladorInfCC.generarComproAnulacion();
		anuladorInfCC.save();
	}    

}