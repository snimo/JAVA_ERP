package com.srn.erp.compras.bm;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.compras.da.DBInformeRecepcion;
import com.srn.erp.contabilidad.bm.CalcImportesContables;
import com.srn.erp.contabilidad.bm.Componente;
import com.srn.erp.contabilidad.bm.Cuenta;
import com.srn.erp.contabilidad.bm.CuentaImputable;
import com.srn.erp.contabilidad.bm.IContabilizable;
import com.srn.erp.contabilidad.bm.ImportesContables;
import com.srn.erp.contabilidad.bm.RenglonAsiento;
import com.srn.erp.contabilidad.bm.RenglonesAsiento;
import com.srn.erp.ctasAPagar.bm.ComproProveedorBase;
import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.general.bm.TipoCambio;
import com.srn.erp.stock.bm.ConfMovStkTalonario;
import com.srn.erp.stock.bm.IStockeable;
import com.srn.erp.stock.bm.MovStockTalonarioDeposito;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.bm.RenglonMovStock;
import com.srn.erp.stock.bm.RenglonesStock;
import com.srn.erp.stock.bm.TipoConfMovStkTalonario;

import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Parametros.ValorParametro;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.Validar;

public class InformeRecepcion extends ComproCab implements IStockeable, IContabilizable {

	public static final String TIPO_RTO_PROVEEDOR = "RTOPROV";
	public static final String TIPO_RTO_INT_DEPO = "RTOIDE";

	private List detallesInfRec = new ArrayList();

	private boolean readDetallesInfRec = true;

	private AnuladorInfRec anuladorInfRec = null;

	public AnuladorInfRec getAnuladorInfRec() throws BaseException {
		return anuladorInfRec;
	}

	private Proveedor proveedor = null;

	private ComproProveedorBase facturaProveedor;

	private TipoCambio tipoCambio;

	private String tipo;

	private String referencia;

	public Proveedor getProveedor() throws BaseException {
		supportRefresh();
		return this.proveedor;
	}

	public void setProveedor(Proveedor aProveedor) throws BaseException {
		this.proveedor = aProveedor;
	}

	public String getReferencia() throws BaseException {
		supportRefresh();
		return this.referencia;
	}

	public void setTipo(String aTipo) throws BaseException {
		this.tipo = aTipo;
	}

	public String getTipo() throws BaseException {
		supportRefresh();
		return this.tipo;
	}

	public void setReferencia(String aReferencia) throws BaseException {
		this.referencia = aReferencia;
	}

	public ComproProveedorBase getComproProveedor() throws BaseException {
		supportRefresh();
		return this.facturaProveedor;
	}

	public void setComproProveedor(ComproProveedorBase aComproProveedor) throws BaseException {
		this.facturaProveedor = aComproProveedor;
	}

	public InformeRecepcion() {
	}

	private ComproCab comprobante;

	public static String NICKNAME = "cp.InformeRecepcion";

	private String remito_prov;

	public String getRemito_prov() throws BaseException {
		supportRefresh();
		return remito_prov;
	}

	public void setRemito_prov(String aRemito_prov) {
		this.remito_prov = aRemito_prov;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public void setTipoCambio(TipoCambio tipoCambio) throws BaseException {
		this.tipoCambio = tipoCambio;
	}

	public TipoCambio getTipoCambio() throws BaseException {
		supportRefresh();
		return tipoCambio;
	}

	public static InformeRecepcion findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (InformeRecepcion) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static InformeRecepcion findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (InformeRecepcion) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public void setComprobante(ComproCab aComprobante) {
		this.comprobante = aComprobante;
	}

	public void beforeSave() throws BaseException {

		if (this.getTipo().equals(InformeRecepcion.TIPO_RTO_PROVEEDOR))
			if (this.getComproProveedor() == null)
				Validar.noNulo(remito_prov, "Debe ingresar el Remito del Proveedor");

		Validar.noNulo(tipo, "Debe ingresar el Tipo de Remito");

		if (this.getTipo().equals(InformeRecepcion.TIPO_RTO_PROVEEDOR))
			Validar.noNulo(proveedor, "Debe ingresar el Proveedor");

		if (this.isNew()) {
			this.setComprobante(this);
			this.setEstado(ComproCab.ESTADO_ALTA);
			this.setActivo(new Boolean(true));
		}
		beforeSaveComprobante(this);

	}

	@Override
	protected void beforeSaveNew() throws BaseException {
		// TODO Auto-generated method stub
		super.beforeSaveNew();
		if (this.getTipo().equals(InformeRecepcion.TIPO_RTO_PROVEEDOR)) {
			InformeRecepcion infec = this.getProveedor().getInformeRecepcion(this.getRemito_prov());
			if (infec != null)
				throw new ExceptionValidation(null, "Remito de proveedor ya igresado. Verifique el Nro. de Remito de Proveedor. Informe de Recepción:"+infec.getCodigo());
		}

	}

	public List getDetallesInfRec() throws BaseException {
		if (readDetallesInfRec) {
			List listaDetallesInfRec = InformeRecepcionDet.getDetallesInfRec(this, getSesion());
			detallesInfRec.addAll(listaDetallesInfRec);
			readDetallesInfRec = false;
		}
		return detallesInfRec;
	}

	public List getDetallesInfRecPendFact() throws BaseException {
		List detPendFact = new ArrayList();
		Iterator iterDetalles = getDetallesInfRec().iterator();
		while (iterDetalles.hasNext()) {
			InformeRecepcionDet infRecDet = (InformeRecepcionDet) iterDetalles.next();
			if (infRecDet.isAnulado().booleanValue())
				continue;
			if (infRecDet.isPendFacturar().booleanValue()) {
				detPendFact.add(infRecDet);
			}
		}
		return detPendFact;
	}

	public void addDetalleInfRec(InformeRecepcionDet informeRecepcionDet) throws BaseException {
		informeRecepcionDet.setInforme_recepcion(this);
		detallesInfRec.add(informeRecepcionDet);
	}

	public void afterSave() throws BaseException {
		Iterator iterInformesRecepcionDet = detallesInfRec.iterator();
		while (iterInformesRecepcionDet.hasNext()) {
			InformeRecepcionDet informeRecepcionDet = (InformeRecepcionDet) iterInformesRecepcionDet.next();
			informeRecepcionDet.save();
			informeRecepcionDet = null;
		}
		iterInformesRecepcionDet = null;
		afterSaveComprobante(this);
	}

	public static List getInformesRecepcion(HashTableDatos aCondiciones, ISesion aSesion) throws BaseException {
		return DBInformeRecepcion.getInformesRecepcion(aCondiciones, aSesion);
	}

	/**
	 * Actualizar el Stock
	 */
	public RenglonesStock getRenglonesStock() throws BaseException {
		RenglonesStock renglonesStock = new RenglonesStock();
		Iterator iterInfRecDet = detallesInfRec.iterator();
		while (iterInfRecDet.hasNext()) {
			InformeRecepcionDet informeRecepcionDet = (InformeRecepcionDet) iterInfRecDet.next();
			if (informeRecepcionDet.getProducto().isStockeable().booleanValue())
				armarMovStock(renglonesStock, informeRecepcionDet);
		}
		return renglonesStock;
	}

	private void armarMovStock(RenglonesStock renglonresStock, InformeRecepcionDet informeRecepcionDet) throws BaseException {

		ConfMovStkTalonario confMovStockTal = informeRecepcionDet.getInforme_recepcion().getTalonario().getConfMovStock();

		if (confMovStockTal == null)
			throw new ExceptionValidation(null, "Falta configurar los movimientos de Stock para el talonario "
					+ informeRecepcionDet.getInforme_recepcion().getTalonario().getDescripcion());

		// Ubicar el tipo de Movimiento a realizar
		TipoConfMovStkTalonario tipoMovStk = null;
		if (informeRecepcionDet.getProducto().isSistema_calidad().booleanValue()) {
			tipoMovStk = confMovStockTal.getTipoConfMovStkTalonarioControlCalidad();
			if (tipoMovStk == null)
				throw new ExceptionValidation(null, "Falta definir un tipo de movimiento de tipo control de calidad para el talonario "
						+ informeRecepcionDet.getInforme_recepcion().getTalonario().getDescripcion());
		} else {
			tipoMovStk = confMovStockTal.getTipoConfMovStkTalonarioInfRec();
			if (tipoMovStk == null)
				throw new ExceptionValidation(null,
						"Falta definir un tipo de movimiento de tipo recepción de mercadería para el talonario "
								+ informeRecepcionDet.getInforme_recepcion().getTalonario().getDescripcion());
		}

		Iterator iterMovStock = tipoMovStk.getMoviStockTalonarios().iterator();
		while (iterMovStock.hasNext()) {
			MovStockTalonarioDeposito movStkTalDepo = (MovStockTalonarioDeposito) iterMovStock.next();
			RenglonMovStock renglonMovStk = renglonresStock.addRenglonMovStock();
			renglonMovStk.setComproCab(this);
			renglonMovStk.setDeposito(movStkTalDepo.getDeposito());
			renglonMovStk.setUbicacionDeposito(movStkTalDepo.getUbiDepoHabTalDefault(informeRecepcionDet.getProducto())
					.getUbicacion_deposito());
			renglonMovStk.setEstadoStock(movStkTalDepo.getEstado_stock());
			renglonMovStk.setPartida(null);
			renglonMovStk.setSerie(null);
			renglonMovStk.setProducto(informeRecepcionDet.getProducto());
			renglonMovStk.setFecha(getImputac());

			renglonMovStk.setCantidad(informeRecepcionDet.getCant_rec_en_us());
			renglonMovStk.setSigno(movStkTalDepo.getSignoStock());
			renglonMovStk.setUnidadMedida(informeRecepcionDet.getUnidadMedidaStock());
			renglonMovStk.setAfectaStockFisico(movStkTalDepo.isAfectaStockFisico());
			renglonMovStk.setActivo(new Boolean(true));
			renglonMovStk.setOidCCODet(informeRecepcionDet.getOIDInteger());
			
		}

	}

	public boolean isActuStock() throws BaseException {
		return true;
	}

	public ComproCab getComprobante() throws BaseException {
		// TODO Auto-generated method stub
		return this.comprobante;
	}

	public Date getImputacion() throws BaseException {
		// TODO Auto-generated method stub
		return this.getImputac();
	}

	private CuentaImputable getCuentaImputableCompras(InformeRecepcionDet infRecDet, Componente compoInfRecDet) throws BaseException {
		Producto producto = infRecDet.getProducto();
		Cuenta cuentaCompras = producto.getCuenta_cpra();
		if (cuentaCompras == null)
			throw new ExceptionValidation(null, "Falta configurar la cuenta compras para el producto " + producto.getCodigo() + " - "
					+ producto.getDescripcion());
		return getImputableCompras(cuentaCompras, infRecDet, compoInfRecDet, getSesion());
	}

	public static CuentaImputable getImputableCompras(Cuenta cuentaCompras, InformeRecepcionDet infRecDet, Componente compoInfRecDet,
			ISesion aSesion) throws BaseException {
		HashTableDatos valCompo = new HashTableDatos();
		valCompo.put(compoInfRecDet, infRecDet);
		return CuentaImputable.getImputable(cuentaCompras, valCompo, aSesion);
	}

	public static CuentaImputable getCuentaImputableProvision(Cuenta cuentaProvision, Componente compoInfRec, InformeRecepcion infRec,
			ISesion aSesion) throws BaseException {
		if (cuentaProvision == null)
			throw new ExceptionValidation(null, "Falta configurar la cuenta provision");
		HashTableDatos valCompo = new HashTableDatos();
		valCompo.put(compoInfRec, infRec);
		return CuentaImputable.getImputable(cuentaProvision, valCompo, aSesion);
	}

	public RenglonesAsiento getRenglonesAsiento() throws BaseException {

		Componente compoInfRecDet = Componente.getCompoInfRecDet(getSesion());
		Componente compoInfRec = Componente.getCompoInfRec(getSesion());
		Cuenta cuentaProvision = Cuenta.getCuentaProvisionCompras(getSesion());

		RenglonesAsiento renglones = new RenglonesAsiento();
		Iterator iterDetalles = detallesInfRec.iterator();
		while (iterDetalles.hasNext()) {

			// Verificar que se encuentre asignada la cuenta compras
			InformeRecepcionDet informeRecepcionDet = (InformeRecepcionDet) iterDetalles.next();
			if (informeRecepcionDet.getProducto().getCuenta_cpra() == null)
				throw new ExceptionValidation(null, "No se encuentra configurada la cuenta compras para el producto "
						+ informeRecepcionDet.getProducto().getCodigo() + " - " + informeRecepcionDet.getProducto().getDescripcion());

			// Debitar la cuenta compras
			RenglonAsiento renglonCompra = renglones.addRenglonAsiento();
			renglonCompra.setD_H(RenglonAsiento.DEBE);
			Moneda monedaOC = informeRecepcionDet.getOrdenDeCompraDet().getOrden_de_compra().getMoneda();
			renglonCompra.setCuentaImputable(getCuentaImputableCompras(informeRecepcionDet, compoInfRecDet));
			renglonCompra.setMonedaOri(monedaOC);
			renglonCompra.setImporteOri(informeRecepcionDet.getValoriz_mon_ori());
			renglonCompra.setComentario("");
			renglonCompra.setImpoLocHist(informeRecepcionDet.getValoriz_mon_local());
			renglonCompra.setImpoLocAju(informeRecepcionDet.getValoriz_mon_local());
			renglonCompra.setImpoMonExt1(informeRecepcionDet.getValoriz_mon_ext1());
			renglonCompra.setImpoMonExt2(informeRecepcionDet.getValoriz_mon_ext2());
			renglonCompra.setCotizOri(getCotizacionMoneda(monedaOC));
			renglonCompra.setCotizMonExt1(informeRecepcionDet.getValorCotizMonExt1());
			renglonCompra.setCotizMonExt2(informeRecepcionDet.getValorCotizMonExt2());

			// Acreditar la cuenta Provision
			RenglonAsiento renglonProvision = renglones.addRenglonAsiento();
			renglonProvision.setD_H(RenglonAsiento.HABER);
			renglonProvision.setCuentaImputable(getCuentaImputableProvision(cuentaProvision, compoInfRec, this, getSesion()));
			renglonProvision.setMonedaOri(monedaOC);
			renglonProvision.setImporteOri(informeRecepcionDet.getValoriz_mon_ori());
			renglonProvision.setComentario("");
			renglonProvision.setImpoLocHist(informeRecepcionDet.getValoriz_mon_local());
			renglonProvision.setImpoLocAju(informeRecepcionDet.getValoriz_mon_local());
			renglonProvision.setImpoMonExt1(informeRecepcionDet.getValoriz_mon_ext1());
			renglonProvision.setImpoMonExt2(informeRecepcionDet.getValoriz_mon_ext2());
			renglonProvision.setCotizOri(getCotizacionMoneda(monedaOC));
			renglonProvision.setCotizMonExt1(informeRecepcionDet.getValorCotizMonExt1());
			renglonProvision.setCotizMonExt2(informeRecepcionDet.getValorCotizMonExt2());

		}

		return renglones;
	}

	public ImportesContables getImporteContable(Moneda monedaOC, Money importeOC) throws BaseException {
		CalcImportesContables impoContable = new CalcImportesContables(getSesion(), getImputacion());
		impoContable.setTipoCambio(getTipoCambio());
		impoContable.addCotizaciones(getCotizaciones());
		return impoContable.getImportesContables(importeOC, monedaOC);
	}

	public static boolean getContabilizarInformeRecepcion(ISesion aSesion) throws BaseException {
		ValorParametro valorParamContabilizaInfRec = ValorParametro.findByCodigoParametro("CONTABILIZA_INF_REC", aSesion);
		return valorParamContabilizaInfRec.getBoolean();
	}

	public static InformeRecepcion getInformeRecepcion(String identificador, ISesion aSesion) throws BaseException {
		ComproCab comproCab = ComproCab.getComproCab(identificador, aSesion);
		if (comproCab == null)
			throw new ExceptionValidation(null, "Informe de Recepción inexistente");
		InformeRecepcion infRec = InformeRecepcion.findByOid(comproCab.getOIDInteger(), aSesion);
		if (infRec == null)
			throw new ExceptionValidation(null, "Informe de Recepción inexistente");
		return infRec;
	}

	public void anular() throws BaseException {

		// Anular los Detalles
		Iterator iterDetalles = getDetallesInfRec().iterator();
		while (iterDetalles.hasNext()) {
			InformeRecepcionDet infRecDet = (InformeRecepcionDet) iterDetalles.next();
			infRecDet.delete();
			infRecDet.save();
		}

		anuladorInfRec = (AnuladorInfRec) AnuladorInfRec.getNew(AnuladorInfRec.NICKNAME, getSesion());
		anuladorInfRec.setInforme_recepcion(this);
		anuladorInfRec.generarComproAnulacion();
		anuladorInfRec.save();
	}

	public static List getInformesRecepcionPendFact(HashTableDatos condiciones, ISesion aSesion) throws BaseException {
		return DBInformeRecepcion.getInformesRecepcionPendFact(condiciones, aSesion);
	}

	public OrdenDeCompraCab getOrdenDeCompra() throws BaseException {
		Iterator iterDetInfRec = this.getDetallesInfRec().iterator();
		while (iterDetInfRec.hasNext()) {
			InformeRecepcionDet infRecDet = (InformeRecepcionDet) iterDetInfRec.next();
			if (infRecDet.getOrdenDeCompraDet() != null)
				return infRecDet.getOrdenDeCompraDet().getOrden_de_compra();
		}
		return null;
	}

	public static InformeRecepcion getInformeRecepcion(String nroRtoProvedor, Proveedor proveedor, ISesion aSesion) throws BaseException {
		return DBInformeRecepcion.getInformeRecepcion(nroRtoProvedor, proveedor, aSesion);
	}

	public static HashTableDatos getTiposInfRecepcion() throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(InformeRecepcion.TIPO_RTO_PROVEEDOR, "Remito Proveedor");
		condiciones.put(InformeRecepcion.TIPO_RTO_INT_DEPO, "Remito Interno Depósito");
		return condiciones;
	}
	
	public String getRemitosInternos() throws BaseException {
		HashTableDatos condigosIncluidos = new HashTableDatos();
		StringBuffer remitosInternos = new StringBuffer("");
		Iterator iterInfRecDet = 
			this.getDetallesInfRec().iterator();
		while (iterInfRecDet.hasNext()) {
			InformeRecepcionDet infRecDet = (InformeRecepcionDet) iterInfRecDet.next();
			if (infRecDet.isAnulado()) continue;
			if (infRecDet.getRemitoDet()==null) continue; 
			String codigo = infRecDet.getRemitoDet().getRemito_cab().getCodigo();
			if (condigosIncluidos.get(codigo)==null) {
				condigosIncluidos.put(codigo, "");
				if (remitosInternos.length()>0)
					remitosInternos.append(",");
				remitosInternos.append(codigo);
			}
			
		}
		return remitosInternos.toString();
	}

}
