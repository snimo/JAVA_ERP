package com.srn.erp.stock.bm;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.general.bm.Talonario;
import com.srn.erp.stock.da.DBComproAjusteStk;
import com.srn.erp.ventas.bm.RemitoCabAnulacion;
import com.srn.erp.ventas.bm.RemitoDet;

import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.Validar;

public class ComproAjusteStk extends ComproCab implements IStockeable {

	//public static final String AJUSTE_STOCK = "AJUSTK";

	private ComproAjusteStkAnu comprobanteAnulacion = null;
	
	private List detalles = new ArrayList();

	private boolean readDetalle = true;

	private List detallesAjuMovStkCab = new ArrayList();

	private boolean readDetallesAjuMovStkCab = true;

	public ComproAjusteStk() {
	}

	public static String NICKNAME = "st.ComproAjusteStk";

	private String tipo_aju_stk;

	private Talonario talonario;

	private ConfMovStkTalonario conf_mov_stk_tal;

	private TipoConfMovStkTalonario tipo_conf_mov;

	private CompoStkTalonarioAjuStk compoTalAjuStk;

	private ComproCab comprobante;

	public void setComprobante(ComproCab aComprobante) {
		this.comprobante = aComprobante;
	}

	public ComproCab getComprobante() {
		return comprobante;
	}

	public void setCompoStkTalAjuStk(CompoStkTalonarioAjuStk compoTalAjuStk)
			throws BaseException {
		this.compoTalAjuStk = compoTalAjuStk;
	}

	public CompoStkTalonarioAjuStk getCompoStkTalonarioAjuStk()
			throws BaseException {
		supportRefresh();
		return compoTalAjuStk;
	}

	public String getTipo_aju_stk() throws BaseException {
		supportRefresh();
		return tipo_aju_stk;
	}

	public void setTipo_aju_stk(String aTipo_aju_stk) {
		this.tipo_aju_stk = aTipo_aju_stk;
	}

	public Talonario getTalonario() throws BaseException {
		supportRefresh();
		return talonario;
	}

	public void setTalonario(Talonario aTalonario) throws BaseException {
		super.setTalonario(aTalonario);
		this.talonario = aTalonario;
	}

	public ConfMovStkTalonario getConf_mov_stk_tal() throws BaseException {
		supportRefresh();
		return conf_mov_stk_tal;
	}

	public void setConf_mov_stk_tal(ConfMovStkTalonario aConf_mov_stk_tal) {
		this.conf_mov_stk_tal = aConf_mov_stk_tal;
	}

	public TipoConfMovStkTalonario getTipo_conf_mov() throws BaseException {
		supportRefresh();
		return tipo_conf_mov;
	}

	public void setTipo_conf_mov(TipoConfMovStkTalonario aTipo_conf_mov) {
		this.tipo_conf_mov = aTipo_conf_mov;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static ComproAjusteStk findByOid(Integer oid, ISesion aSesion)
			throws BaseException {
		return (ComproAjusteStk) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static ComproAjusteStk findByOidProxy(Integer oid, ISesion aSesion)
			throws BaseException {
		return (ComproAjusteStk) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(tipo_aju_stk, "Debe ingresar el Tipo de Movimiento");
		Validar.noNulo(talonario, "Debe ingresar el Talonario");
		if (this.isNew()) {
			this.setComprobante(this);
			this.setEstado(ComproCab.ESTADO_ALTA);
			this.setActivo(new Boolean(true));
			this.prepararAjusteStkMovCab();
		}
		beforeSaveComprobante(this);
	}

	/**
	 * isActivo
	 * 
	 * @return Boolean
	 */
	/**
	 * getDescripcion
	 * 
	 * @return String
	 */
	public String getDescripcion() {
		return "";
	}

	private void prepararAjusteStkMovCab() throws BaseException {

		Iterator iterMovStock = getTipo_conf_mov().getMoviStockTalonarios()
				.iterator();
		while (iterMovStock.hasNext()) {
			MovStockTalonarioDeposito movStkTalDepo = (MovStockTalonarioDeposito) iterMovStock
					.next();
			AjuStkMovCab ajuStkMovCab = (AjuStkMovCab) AjuStkMovCab.getNew(
					AjuStkMovCab.NICKNAME, getSesion());
			ajuStkMovCab.setComproajustkcab(this);
			ajuStkMovCab.setDeposito(movStkTalDepo.getDeposito());
			ajuStkMovCab.setTipo_movi(movStkTalDepo.getTipo_movimiento());
			ajuStkMovCab.setEstado_stock(movStkTalDepo.getEstado_stock());
			// Se guarda en NULL porque luego las ubicaciones se definen a nivel
			// detalle
			ajuStkMovCab.setUbicacion_deposito(null);
			ajuStkMovCab.setAfecta_stk_fisico(movStkTalDepo
					.isAfectaStockFisico());
			ajuStkMovCab.setActivo(new Boolean(true));
			addDetAjuStkMovCab(ajuStkMovCab);
		}

	}

	/**
	 * getCodigo
	 * 
	 * @return String
	 */
	public static Hashtable getTipos() throws BaseException {
		Hashtable tipos = new Hashtable();
		tipos.put(TipoConfMovStkTalonario.AJUSTE_STOCK, "Ajuste de Stock");
		return tipos;
	}
	
	public static Hashtable getTiposTransfInternas() throws BaseException {
		Hashtable tipos = new Hashtable();
		tipos.put(TipoConfMovStkTalonario.TRANSFERENCIA_INTERNAS, "Transferencia Interna");
		return tipos;
	}
	
	public static Hashtable getAllTipos() throws BaseException {
		Hashtable tipos = new Hashtable();
		tipos.put(TipoConfMovStkTalonario.TRANSFERENCIA_INTERNAS, "Transferencia Interna");
		tipos.put(TipoConfMovStkTalonario.AJUSTE_STOCK, "Ajuste de Stock");
		return tipos;
	}
	
	
	
	public String getDescTipoOper(String codigo) throws BaseException {
	  return (String) getTipos().get(codigo);	
	}
	
	public String getDescOperacion() throws BaseException {
		return getDescTipoOper(this.getTipo_aju_stk());
	}
	
	public void afterSave() throws BaseException {

		Iterator iterDetalles = detalles.iterator();
		while (iterDetalles.hasNext()) {
			ComproAjusteStkDet comproAjuStkDet = (ComproAjusteStkDet) iterDetalles
					.next();
			comproAjuStkDet.save();
			comproAjuStkDet = null;
		}
		iterDetalles = null;

		Iterator iterDetAjuStkMovCab = detallesAjuMovStkCab.iterator();
		while (iterDetAjuStkMovCab.hasNext()) {
			AjuStkMovCab ajuStkMovCab = (AjuStkMovCab) iterDetAjuStkMovCab
					.next();
			ajuStkMovCab.save();
			ajuStkMovCab = null;
		}
		iterDetAjuStkMovCab = null;

		afterSaveComprobante(this);
	}

	public void addDetalle(ComproAjusteStkDet comproAjuStkDet)
			throws BaseException {
		this.detalles.add(comproAjuStkDet);
		comproAjuStkDet.setAjuste_stock_cab(this);
	}

	public void addDetAjuStkMovCab(AjuStkMovCab ajuStkMovCab)
			throws BaseException {
		this.detallesAjuMovStkCab.add(ajuStkMovCab);
		ajuStkMovCab.setComproajustkcab(this);
	}

	public List getDetalles() throws BaseException {
		if (readDetalle == true) {
			detalles.addAll(ComproAjusteStkDet.getDetallesComproAjuStk(this,
					getSesion()));
			readDetalle = false;
			return detalles;
		} else
			return detalles;
	}

	public List getDetallesAjuStkMovCab() throws BaseException {
		if (readDetallesAjuMovStkCab == true) {
			detallesAjuMovStkCab.addAll(AjuStkMovCab.getAjustesStkMovCab(this,
					getSesion()));
			readDetallesAjuMovStkCab = false;
			return detallesAjuMovStkCab;
		} else
			return detallesAjuMovStkCab;
	}

	/**
	 * Actualizar el Stock
	 */
	public RenglonesStock getRenglonesStock() throws BaseException {
		RenglonesStock renglonesStock = new RenglonesStock();
		Iterator iterDetAju = detalles.iterator();
		while (iterDetAju.hasNext()) {
			ComproAjusteStkDet detAjuStk = (ComproAjusteStkDet) iterDetAju
					.next();
			if (detAjuStk.getProducto().isStockeable().booleanValue())
				armarMovStock(renglonesStock, detAjuStk);
		}
		return renglonesStock;
	}

	private void armarMovStock(RenglonesStock renglonresStock,
			ComproAjusteStkDet comproAjuStkDet) throws BaseException {
		if (comproAjuStkDet.getProducto().isLlevaPartida().booleanValue()
				|| comproAjuStkDet.getProducto().isLlevaSerie().booleanValue())
			armarMovStockPartidaSerie(renglonresStock, comproAjuStkDet);
		else
			armarMovStockSinPartidaNiSerie(renglonresStock, comproAjuStkDet);
	}

	private void armarMovStockSinPartidaNiSerie(RenglonesStock renglonresStock,
			ComproAjusteStkDet comproAjuStkDet) throws BaseException {
		if (comproAjuStkDet.getDetallesAjuStkMovDet().isEmpty())
			armarMovStockSinPartNiSerieConMovCabecera(renglonresStock,
					comproAjuStkDet);
		else
			armarMovStockSinPartNiSerieConMovDetalle(renglonresStock,
					comproAjuStkDet);

	}

	private void armarMovStockSinPartNiSerieConMovDetalle(
			RenglonesStock renglonresStock, ComproAjusteStkDet comproAjuStkDet)
			throws BaseException {
		if (comproAjuStkDet.getDetallesAjuStkMovDet().isEmpty())
			throw new ExceptionValidation(null,
					"No se ingresaron movimientos de Stock para el producto "
							+ comproAjuStkDet.getProducto().getCodigo() + " - "
							+ comproAjuStkDet.getProducto().getDescripcion());

		Iterator iterMovStock = comproAjuStkDet.getDetallesAjuStkMovDet()
				.iterator();
		while (iterMovStock.hasNext()) {
			AjuStkMovDet ajuStkMovDet = (AjuStkMovDet) iterMovStock.next();
			RenglonMovStock renglonMovStk = renglonresStock
					.addRenglonMovStock();
			renglonMovStk.setComproCab(this);
			renglonMovStk.setDeposito(ajuStkMovDet.getDeposito());
			renglonMovStk.setUbicacionDeposito(ajuStkMovDet
					.getUbicacion_deposito());
			renglonMovStk.setEstadoStock(ajuStkMovDet.getEstado_stock());
			renglonMovStk.setPartida(null);
			renglonMovStk.setSerie(null);
			renglonMovStk.setProducto(comproAjuStkDet.getProducto());
			renglonMovStk.setFecha(getEmision());
			renglonMovStk.setCantidad(comproAjuStkDet.getCantidad());
			renglonMovStk.setSigno(new Integer(ajuStkMovDet.getSigno()));
			renglonMovStk.setUnidadMedida(comproAjuStkDet.getUm_carga());
			renglonMovStk.setAfectaStockFisico(ajuStkMovDet
					.isAfecta_stk_fisico());
			renglonMovStk.setActivo(new Boolean(true));
		}

	}

	private void armarMovStockSinPartNiSerieConMovCabecera(
			RenglonesStock renglonresStock, ComproAjusteStkDet comproAjuStkDet)
			throws BaseException {
		if (detallesAjuMovStkCab.isEmpty())
			throw new ExceptionValidation(null,
					"No se han ingresado los movimientos de Stock para el siguiente artículo "
							+ comproAjuStkDet.getProducto().getCodigo() + " - "
							+ comproAjuStkDet.getProducto().getDescripcion());
		// Validar carga datos Principales
		Iterator iterMovStockSug = detallesAjuMovStkCab.iterator();
		while (iterMovStockSug.hasNext()) {
			AjuStkMovCab ajuStkMovCab = (AjuStkMovCab) iterMovStockSug.next();
			RenglonMovStock renglonMovStk = renglonresStock
					.addRenglonMovStock();
			renglonMovStk.setComproCab(this);
			renglonMovStk.setDeposito(ajuStkMovCab.getDeposito());
			renglonMovStk.setUbicacionDeposito(ajuStkMovCab
					.getUbicacion_deposito());
			renglonMovStk.setEstadoStock(ajuStkMovCab.getEstado_stock());
			renglonMovStk.setPartida(null);
			renglonMovStk.setSerie(null);
			renglonMovStk.setProducto(comproAjuStkDet.getProducto());
			renglonMovStk.setFecha(getEmision());
			renglonMovStk.setCantidad(comproAjuStkDet.getCantidad());
			renglonMovStk.setSigno(new Integer(ajuStkMovCab.getSigno()));
			renglonMovStk.setUnidadMedida(comproAjuStkDet.getUm_carga());
			renglonMovStk.setAfectaStockFisico(ajuStkMovCab
					.isAfecta_stk_fisico());
			renglonMovStk.setActivo(new Boolean(true));
		}

	}

	private void armarMovStockPartidaSerie(RenglonesStock renglonresStock,
			ComproAjusteStkDet comproAjuStkDet) throws BaseException {
		Iterator iterPartidasSeries = comproAjuStkDet.getDetallesPartSerie()
				.iterator();
		while (iterPartidasSeries.hasNext()) {
			AjuStkPartSerie ajuStkPartSerie = (AjuStkPartSerie) iterPartidasSeries
					.next();
			if (comproAjuStkDet.getDetallesAjuStkMovDet().isEmpty())
				armarMovStockPartSerConMovCabecera(renglonresStock,
						comproAjuStkDet, ajuStkPartSerie);
			else
				armarMovStockPartSerConMovDetalle(renglonresStock,
						comproAjuStkDet, ajuStkPartSerie);
		}

	}

	private void armarMovStockPartSerConMovCabecera(
			RenglonesStock renglonresStock, ComproAjusteStkDet comproAjuStkDet,
			AjuStkPartSerie ajuStkPartSerie) throws BaseException {
		if (detallesAjuMovStkCab.isEmpty())
			throw new ExceptionValidation(null,
					"No se han ingresado los movimientos de Stock para el siguiente artículo "
							+ comproAjuStkDet.getProducto().getCodigo() + " - "
							+ comproAjuStkDet.getProducto().getDescripcion());
		// Validar carga datos Principales
		Iterator iterMovStockSug = detallesAjuMovStkCab.iterator();
		while (iterMovStockSug.hasNext()) {
			AjuStkMovCab ajuStkMovCab = (AjuStkMovCab) iterMovStockSug.next();
			RenglonMovStock renglonMovStk = renglonresStock
					.addRenglonMovStock();
			renglonMovStk.setComproCab(this);
			renglonMovStk.setDeposito(ajuStkMovCab.getDeposito());
			renglonMovStk.setUbicacionDeposito(ajuStkMovCab
					.getUbicacion_deposito());
			renglonMovStk.setEstadoStock(ajuStkMovCab.getEstado_stock());
			renglonMovStk.setPartida(ajuStkPartSerie.getPartida());
			renglonMovStk.setSerie(ajuStkPartSerie.getSerie());
			renglonMovStk.setProducto(comproAjuStkDet.getProducto());
			renglonMovStk.setFecha(getEmision());
			renglonMovStk.setCantidad(ajuStkPartSerie.getCantidad());
			renglonMovStk.setSigno(new Integer(ajuStkMovCab.getSigno()));
			renglonMovStk.setUnidadMedida(comproAjuStkDet.getUm_carga());
			renglonMovStk.setAfectaStockFisico(ajuStkMovCab
					.isAfecta_stk_fisico());
			renglonMovStk.setActivo(new Boolean(true));
		}
	}

	private void armarMovStockPartSerConMovDetalle(
			RenglonesStock renglonresStock, ComproAjusteStkDet comproAjuStkDet,
			AjuStkPartSerie ajuStkPartSerie) throws BaseException {
		if (comproAjuStkDet.getDetallesAjuStkMovDet().isEmpty())
			throw new ExceptionValidation(null,
					"No se ingresaron movimientos de Stock para el producto "
							+ comproAjuStkDet.getProducto().getCodigo() + " - "
							+ comproAjuStkDet.getProducto().getDescripcion());
		Iterator iterMovStock = comproAjuStkDet.getDetallesAjuStkMovDet()
				.iterator();
		while (iterMovStock.hasNext()) {
			AjuStkMovDet ajuStkMovDet = (AjuStkMovDet) iterMovStock.next();
			RenglonMovStock renglonMovStk = renglonresStock
					.addRenglonMovStock();
			renglonMovStk.setComproCab(this);
			renglonMovStk.setDeposito(ajuStkMovDet.getDeposito());
			renglonMovStk.setUbicacionDeposito(ajuStkMovDet
					.getUbicacion_deposito());
			renglonMovStk.setEstadoStock(ajuStkMovDet.getEstado_stock());
			renglonMovStk.setPartida(ajuStkPartSerie.getPartida());
			renglonMovStk.setSerie(ajuStkPartSerie.getSerie());
			renglonMovStk.setProducto(comproAjuStkDet.getProducto());
			renglonMovStk.setFecha(getEmision());
			renglonMovStk.setCantidad(ajuStkPartSerie.getCantidad());
			renglonMovStk.setSigno(new Integer(ajuStkMovDet.getSigno()));
			renglonMovStk.setUnidadMedida(comproAjuStkDet.getUm_carga());
			renglonMovStk.setAfectaStockFisico(ajuStkMovDet
					.isAfecta_stk_fisico());
			renglonMovStk.setActivo(new Boolean(true));
		}

	}
	
	public static List getComproAjuStk(
			Integer nroExtDesde, 
			Integer nroExtHasta, 
			java.util.Date fecDesde,
			java.util.Date fecHasta, 
			Producto producto, 
			String comportamiento,
			ISesion aSesion) throws BaseException {
		return DBComproAjusteStk.getComproAjuStk(nroExtDesde, nroExtHasta, fecDesde, fecHasta, producto ,comportamiento, aSesion);
	}
	
	public void anular() throws BaseException {

		// Anular los Detalles
		Iterator iterDetalles = getDetalles().iterator();
		while (iterDetalles.hasNext()) {
			ComproAjusteStkDet detalle = (ComproAjusteStkDet) iterDetalles.next();
			detalle.delete();
			detalle.save();
		}

		comprobanteAnulacion = (ComproAjusteStkAnu) ComproAjusteStkAnu.getNew(ComproAjusteStkAnu.NICKNAME, getSesion());
		comprobanteAnulacion.setComproajustestk(this);
		comprobanteAnulacion.generarComproAnulacion();
		comprobanteAnulacion.save();
		
	}
	
	

}
