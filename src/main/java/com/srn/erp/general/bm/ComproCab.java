package com.srn.erp.general.bm;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.contabilidad.bm.CalcImportesContables;
import com.srn.erp.contabilidad.bm.ComproConta;
import com.srn.erp.contabilidad.bm.ComproContaDet;
import com.srn.erp.contabilidad.bm.IContabilizable;
import com.srn.erp.contabilidad.bm.ImportesContables;
import com.srn.erp.contabilidad.bm.RenglonAsiento;
import com.srn.erp.contabilidad.bm.RenglonesAsiento;
import com.srn.erp.ctasAPagar.bm.GrabarCtaCteProv;
import com.srn.erp.ctasAPagar.bm.ICtaCteProv;
import com.srn.erp.general.da.DBComproCab;
import com.srn.erp.impuestos.bm.ILibroIVA;
import com.srn.erp.impuestos.bm.ListadoIVACab;
import com.srn.erp.stock.bm.GrabarStock;
import com.srn.erp.stock.bm.IStockeable;
import com.srn.erp.stock.bm.StockCabecera;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Parametros.ValorParametro;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.applicarionServer.bm.Varios.CalculadorMoney;
import framework.applicarionServer.bm.Varios.Money;
import framework.applicarionServer.bm.Varios.Numerador;
import framework.applicarionServer.bm.Varios.ValorCotizacion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.XML.IDataSet;

public class ComproCab extends ObjetoLogico {

	public static String	ESTADO_ALTA			= "ALTA";

	public static String	ESTADO_ANULADO	= "ANULADO";

	public ComproCab() {
	}

	public static String			NICKNAME					= "ge.ComproCab";

	public HashTableDatos			listaCotizaciones	= new HashTableDatos();

	private boolean						contabiliza				= false;
	
	private boolean noValidarNroExt = false;

	private boolean						actuStock					= false;

	private TipoComprobante		tipoCompro;

	private String						tcExt;

	private String						letra;

	private LugarEmision			lugarEmision;

	private Integer						nroLugEmision;

	private Integer						nroExt;

	private Date							emision;

	private String						estado;

	private String						comentario;

	private Date							fecAlta;

	private Usuario						usuario;

	private Boolean						activo;

	private Talonario					talonario;

	private Date							imputac;

	private MotivoComprobante	motivoComprobante;
	
	private Sucursal 				  sucursal;
	
	private ComproCab comprobanteAnulador;
	
	private ComproCab comproCabAnulado;
	
	private String comportamiento;
	
	private Integer nroInterno;

	
	public void setNroInterno(Integer aNroInterno) throws BaseException {
		this.nroInterno = aNroInterno;
	}
	
	public Integer getNroInterno() throws BaseException {
		supportRefresh();
		return this.nroInterno;
	}
	
	public void setImputac(Date aImputac) throws BaseException {
		this.imputac = aImputac;
	}

	public Date getImputac() throws BaseException {
		supportRefresh();
		return imputac;
	}
	
	public void setComportamiento(String aComportamiento) throws BaseException {
		this.comportamiento = aComportamiento;
	}

	public String getComportamiento() throws BaseException {
		supportRefresh();
		return comportamiento;
	}
	

	public void setMotivoComprobante(MotivoComprobante aMotivoComprobante) throws BaseException {
		this.motivoComprobante = aMotivoComprobante;
	}
	
	public ComproCab getComprobanteAnulador() throws BaseException {
		supportRefresh();
		return this.comprobanteAnulador;
	}

	public void setComprobanteAnulador(ComproCab aComprobanteAnulador) throws BaseException {
		this.comprobanteAnulador = aComprobanteAnulador;
	}
	
	
	public Sucursal getSucursal() throws BaseException {
		supportRefresh();
		return sucursal;
	}

	public void setSucursal(Sucursal aSucursal) throws BaseException {
		this.sucursal = aSucursal;
	}
	

	public MotivoComprobante getMotivoComprobante() throws BaseException {
		supportRefresh();
		return motivoComprobante;
	}

	public void setTalonario(Talonario aTalonario) throws BaseException {
		this.talonario = aTalonario;
	}

	public Talonario getTalonario() throws BaseException {
		supportRefresh();
		return talonario;
	}

	public boolean isNumeracionAutomatica() throws BaseException {
		if (getTalonario() == null)
			return false;
		else
			return getTalonario().isNro_automatica().booleanValue();
	}

	public void setActivo(Boolean aActivo) throws BaseException {
		this.activo = aActivo;
	}

	public Boolean isActivo() throws BaseException {
		supportRefresh();
		return this.activo;
	}

	public void setContabiliza(boolean aContabiliza) throws BaseException {
		this.contabiliza = aContabiliza;
	}

	public void setActuStock(boolean aActuStock) throws BaseException {
		this.actuStock = aActuStock;
	}

	public boolean getContabiliza() throws BaseException {
		return contabiliza;
	}

	public boolean isActuStock() throws BaseException {
		return this.actuStock;
	}

	public TipoComprobante getTipoCompro() throws BaseException {
		supportRefresh();
		return tipoCompro;
	}

	public void setTipoCompro(TipoComprobante aTipoCompro) throws BaseException {
		this.tipoCompro = aTipoCompro;
		if (aTipoCompro != null)
			setTcExt(aTipoCompro.getCodigo());
		else
			setTcExt("");
	}

	public String getTcExt() throws BaseException {
		supportRefresh();
		return tcExt;
	}

	public void setTcExt(String aTcext) {
		this.tcExt = aTcext;
	}

	public String getLetra() throws BaseException {
		supportRefresh();
		return letra;
	}

	public void setLetra(String aLetra) {
		this.letra = aLetra;
	}

	public LugarEmision getLugarEmision() throws BaseException {
		supportRefresh();
		return lugarEmision;
	}

	public void setLugarEmision(LugarEmision aLugarEmision) throws BaseException {
		this.lugarEmision = aLugarEmision;
		if (aLugarEmision != null)
			this.nroLugEmision = aLugarEmision.getLugemi();
	}

	public Integer getNroLugEmision() throws BaseException {
		supportRefresh();
		return nroLugEmision;
	}

	public void setNrolugemision(Integer aNroLugEmision) {
		this.nroLugEmision = aNroLugEmision;
	}

	public Integer getNroExt() throws BaseException {
		supportRefresh();
		return nroExt;
	}

	public void setNroext(Integer aNroExt) {
		this.nroExt = aNroExt;
	}

	public Date getEmision() throws BaseException {
		supportRefresh();
		return emision;
	}

	public void setEmision(Date aEmision) {
		this.emision = aEmision;
	}

	public String getEstado() throws BaseException {
		supportRefresh();
		return estado;
	}

	public void setEstado(String aEstado) {
		this.estado = aEstado;
	}

	public String getComentario() throws BaseException {
		supportRefresh();
		return comentario;
	}

	public void setComentario(String aComentario) {
		this.comentario = aComentario;
	}

	public Date getFecAlta() throws BaseException {
		supportRefresh();
		return fecAlta;
	}

	public void setFecAlta(Date aFecAlta) {
		this.fecAlta = aFecAlta;
	}

	public Usuario getUsuario() throws BaseException {
		supportRefresh();
		return usuario;
	}

	public void setUsuario(Usuario aUsuario) {
		this.usuario = aUsuario;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static ComproCab findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (ComproCab) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public static ComproCab findByOidCompro(Integer oid, ISesion aSesion) throws BaseException {
		return (ComproCab) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static ComproCab findByOidProxyCompro(Integer oid, ISesion aSesion) throws BaseException {
		return (ComproCab) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}
	
	public void setNoValidarNroExt(boolean noValidarNroExt) {
		this.noValidarNroExt = noValidarNroExt;
	}
	
	private boolean isNoValidarNroExt() {
		return this.noValidarNroExt;
	}

	public void beforeSave() throws BaseException {
		if ((this.isNew() == true) && (isNumeracionAutomatica()))
			setNroext(obtenerNuevoNroExt());
		else {
			if (isNoValidarNroExt()==false)
					validarNroExtCargado();
		}
	}

	private void validarNroExtCargado() throws BaseException {
		if (getNroExt() == null)
			throw new ExceptionValidation(null, "Debe ingresar el Número del Comprobante");
		if (getNroExt() != null)
			if (!(getNroExt().intValue() > 0))
				throw new ExceptionValidation(null, "Debe ingresar el Número del Comprobante");
	}

	public void assign(ComproCab aComproCab) throws BaseException {
		this.setTipoCompro(aComproCab.getTipoCompro());
		this.setLetra(aComproCab.getLetra());
		this.setLugarEmision(aComproCab.getLugarEmision());
		this.setNroext(aComproCab.getNroExt());
		this.setEmision(aComproCab.getEmision());
		this.setImputac(aComproCab.getImputac());
		this.setEstado(aComproCab.getEstado());
		this.setComentario(aComproCab.getComentario());
		this.setActivo(aComproCab.isActivo());
		this.setTalonario(aComproCab.getTalonario());
		this.setMotivoComprobante(aComproCab.getMotivoComprobante());
		this.setNoValidarNroExt(aComproCab.isNoValidarNroExt());
		this.setNroInterno(aComproCab.getNroInterno());
	}

	public static String getLetraDefault(ISesion aSesion) throws BaseException {
		ValorParametro valorParametro = ValorParametro.findByCodigoParametro("LETRA_COMPRO_DEFAULT", aSesion);
		return valorParametro.getValorCadena();
	}

	public static LugarEmision getLugEmiDafault(ISesion aSesion) throws BaseException {
		ValorParametro valorParametro = ValorParametro.findByCodigoParametro("LUG_EMI_DEFAULT_COMPRO", aSesion);
		LugarEmision lugarEmision = LugarEmision.findByOidProxy(valorParametro.getOidObjNeg(), aSesion);
		return lugarEmision;
	}

	/**
	 * isActivo
	 * 
	 * @return Boolean
	 */

	public String getDescripcion() throws BaseException {
		return getCodigo();
	}

	/**
	 * getCodigo
	 * 
	 * @return String
	 */
	public String getCodigo() throws BaseException {
		supportRefresh();
		return getFormatoCompro(getTcExt(), getLetra(), getNroLugEmision(), getNroExt());
	}

	private Integer obtenerNuevoNroExt() throws BaseException {
		if (this.getTalonario()!=null)
			return new Integer(this.getTalonario().getProxNro());
		else
			return Numerador.getSiguienteNro(getArguNroCompro(), getSesion());
	}

	private String getArguNroCompro() throws BaseException {
		return getTcExt() + "_" + getLetra() + "_" + getNroLugEmision().toString();
	}

	protected void beforeSaveComprobante(ComproCab aComproCab) throws BaseException {

		ComproCab comproCab = null;
		if (getOIDInteger() != null)
			comproCab = ComproCab.findByOidCompro(getOIDInteger(), getSesion());
		else
			comproCab = (ComproCab) ComproCab.getNew(ComproCab.NICKNAME, getSesion());
		comproCab.assign(this);
		if (comproCab.getLugarEmision() == null)
			comproCab.setLugarEmision(getLugEmiDafault(getSesion()));
		if (comproCab.getLetra() == null)
			comproCab.setLetra(getLetraDefault(getSesion()));
		comproCab.save();

		// Actualizar los Datos principales del Comprobante
		aComproCab.setManualOID(comproCab.getOIDInteger());
		aComproCab.setTcExt(comproCab.getTcExt());
		aComproCab.setLetra(comproCab.getLetra());
		aComproCab.setLugarEmision(comproCab.getLugarEmision());
		aComproCab.setNroext(comproCab.getNroExt());
		aComproCab.setActivo(comproCab.isActivo());
		aComproCab.setNoValidarNroExt(comproCab.isNoValidarNroExt());
		
	}

	protected void afterSaveComprobante(ComproCab aComproCab) throws BaseException {

	}
	
	protected void agregarDetAsiento(ComproConta comproConta, RenglonAsiento renglonAsiento) throws BaseException {
		if (renglonAsiento.getD_H() != 0) {
			ComproContaDet detComproConta = ComproContaDet.getNewDetalle(getSesion());
			detComproConta.setCuentaImputable(renglonAsiento.getCuentaImputable());
			detComproConta.setSigno(new Integer(renglonAsiento.getD_H()));
			detComproConta.setMoneda(renglonAsiento.getMonedaOri());
			detComproConta.setImporteOriginal(renglonAsiento.getImporteOri());
			detComproConta.setCantidad(renglonAsiento.getCantidad());
			detComproConta.setComentario(renglonAsiento.getComentario());
			detComproConta.setImpoLocHist(renglonAsiento.getImpoLocHist());
			detComproConta.setImpoLocAju(renglonAsiento.getImpoLocAju());
			detComproConta.setImpoMonExt1(renglonAsiento.getImpoMonExt1());
			detComproConta.setImpoMonExt2(renglonAsiento.getImpoMonExt2());
			detComproConta.setCotizMonOri(renglonAsiento.getCotizOri());
			detComproConta.setCotizMonExt1(renglonAsiento.getCotizMonExt1());
			detComproConta.setCotizMonExt2(renglonAsiento.getCotizMonExt2());
			comproConta.addDetalle(detComproConta);
		}
		else {

			// Procesar Moneda Local
			ComproContaDet detComproConta = ComproContaDet.getNewDetalle(getSesion());
			detComproConta.setCuentaImputable(renglonAsiento.getCuentaImputable());
			detComproConta.setSigno(new Integer(renglonAsiento.get_d_h_mon_loc()));
			detComproConta.setMoneda(renglonAsiento.getMonedaOri());
			detComproConta.setImporteOriginal(renglonAsiento.getImporteOri());
			detComproConta.setCantidad(renglonAsiento.getCantidad());
			detComproConta.setComentario(renglonAsiento.getComentario());
			detComproConta.setImpoLocHist(renglonAsiento.getImpoLocHist());
			detComproConta.setImpoLocAju(new Money(0));
			detComproConta.setImpoMonExt1(new Money(0));
			detComproConta.setImpoMonExt2(new Money(0));
			detComproConta.setCotizMonOri(renglonAsiento.getCotizOri());
			detComproConta.setCotizMonExt1(renglonAsiento.getCotizMonExt1());
			detComproConta.setCotizMonExt2(renglonAsiento.getCotizMonExt2());
			comproConta.addDetalle(detComproConta);

			// Procesar Moneda Local Ajustada
			ComproContaDet detComproConta1 = ComproContaDet.getNewDetalle(getSesion());
			detComproConta1.setCuentaImputable(renglonAsiento.getCuentaImputable());
			detComproConta1.setSigno(new Integer(renglonAsiento.get_d_h_mon_loc_aju()));
			detComproConta1.setMoneda(renglonAsiento.getMonedaOri());
			detComproConta1.setImporteOriginal(renglonAsiento.getImporteOri());
			detComproConta1.setCantidad(renglonAsiento.getCantidad());
			detComproConta1.setComentario(renglonAsiento.getComentario());
			detComproConta1.setImpoLocHist(new Money(0));
			detComproConta1.setImpoLocAju(renglonAsiento.getImpoLocAju());
			detComproConta1.setImpoMonExt1(new Money(0));
			detComproConta1.setImpoMonExt2(new Money(0));
			detComproConta1.setCotizMonOri(renglonAsiento.getCotizOri());
			detComproConta1.setCotizMonExt1(renglonAsiento.getCotizMonExt1());
			detComproConta1.setCotizMonExt2(renglonAsiento.getCotizMonExt2());
			comproConta.addDetalle(detComproConta1);

			// Procesar Moneda Extranjera 1
			ComproContaDet detComproConta2 = ComproContaDet.getNewDetalle(getSesion());
			detComproConta2.setCuentaImputable(renglonAsiento.getCuentaImputable());
			detComproConta2.setSigno(new Integer(renglonAsiento.get_d_h_mon_ext_1()));
			detComproConta2.setMoneda(renglonAsiento.getMonedaOri());
			detComproConta2.setImporteOriginal(renglonAsiento.getImporteOri());
			detComproConta2.setCantidad(renglonAsiento.getCantidad());
			detComproConta2.setComentario(renglonAsiento.getComentario());
			detComproConta2.setImpoLocHist(new Money(0));
			detComproConta2.setImpoLocAju(new Money(0));
			detComproConta2.setImpoMonExt1(renglonAsiento.getImpoMonExt1());
			detComproConta2.setImpoMonExt2(new Money(0));
			detComproConta2.setCotizMonOri(renglonAsiento.getCotizOri());
			detComproConta2.setCotizMonExt1(renglonAsiento.getCotizMonExt1());
			detComproConta2.setCotizMonExt2(renglonAsiento.getCotizMonExt2());

			comproConta.addDetalle(detComproConta2);

			// Procesar Moneda Extranjera 2
			ComproContaDet detComproConta3 = ComproContaDet.getNewDetalle(getSesion());
			detComproConta3.setCuentaImputable(renglonAsiento.getCuentaImputable());
			detComproConta3.setSigno(new Integer(renglonAsiento.get_d_h_mon_ext_2()));
			detComproConta3.setMoneda(renglonAsiento.getMonedaOri());
			detComproConta3.setImporteOriginal(renglonAsiento.getImporteOri());
			detComproConta3.setCantidad(renglonAsiento.getCantidad());
			detComproConta3.setComentario(renglonAsiento.getComentario());
			detComproConta3.setImpoLocHist(new Money(0));
			detComproConta3.setImpoLocAju(new Money(0));
			detComproConta3.setImpoMonExt1(new Money(0));
			detComproConta3.setImpoMonExt2(renglonAsiento.getImpoMonExt2());
			detComproConta3.setCotizMonOri(renglonAsiento.getCotizOri());
			detComproConta3.setCotizMonExt1(renglonAsiento.getCotizMonExt1());
			detComproConta3.setCotizMonExt2(renglonAsiento.getCotizMonExt2());

			comproConta.addDetalle(detComproConta3);

		}

	}

	protected void contabilizarComprobante(IContabilizable contabilizable) throws BaseException {
		ComproConta comproConta = ComproConta.getNewComprobante(getSesion());
		comproConta.setContabilizable(contabilizable);
		RenglonesAsiento renglones = contabilizable.getRenglonesAsiento();
		if (renglones == null)
			return;
		Iterator iterRenglones = renglones.getListaRenglones().iterator();
		while (iterRenglones.hasNext()) {
			RenglonAsiento renglonAsiento = (RenglonAsiento) iterRenglones.next();
			agregarDetAsiento(comproConta, renglonAsiento);
		}
		comproConta.save();
	}

	public ComproConta getComproConta() throws BaseException {
		ComproConta comproConta = ComproConta.findByOid(getOIDInteger(), getSesion());
		return comproConta;
	}

	public StockCabecera getStockCabecera() throws BaseException {
		StockCabecera stockCabecera = StockCabecera.getStockCabecera(this, getSesion());
		return stockCabecera;
	}

	private void actuStockComprobante(IStockeable aComproCab) throws BaseException {
		GrabarStock grabarStock = new GrabarStock(getSesion());
		grabarStock.setStockeable(aComproCab);
		grabarStock.save();
	}

	public static ComproCab getComproCab(String identificador, ISesion aSesion) throws BaseException {
		DescomponerIdentifComproCab identifComproCab = new DescomponerIdentifComproCab(identificador, aSesion);
		return DBComproCab.getComproCab(identifComproCab.getTC(), identifComproCab.getLetra(),
				identifComproCab.getLugEmi(), identifComproCab.getNroExt(), aSesion);
	}
	
	public static List getComprobantes(
			String tc,
			String letra,
			Integer lugEmi,
			String identificador, 
			ISesion aSesion) throws BaseException {
		
		List comprobantes = new ArrayList();
		DescomponerIdentifComproCab identifComproCab = 
			new DescomponerIdentifComproCab(tc,letra,lugEmi,identificador, aSesion);
		
		if (identifComproCab.getComprobantes()==null)
			return comprobantes;
		else {
			Iterator iterIdentifCompro = identifComproCab.getComprobantes().iterator();
			while (iterIdentifCompro.hasNext()) {
				IdentificadorCompro identifCompro = (IdentificadorCompro) iterIdentifCompro.next();
				ComproCab compro = 
					DBComproCab.getComproCab(identifCompro.getTipoCompro(), identifCompro.getLetra(),
							identifCompro.getLugEmi(), identifCompro.getNroExt(), aSesion);
				if (compro!=null)
					comprobantes.add(compro);
			}
			return comprobantes;
		}
	}
	

	public static final String getFormatoCompro(String TC, String letra, Integer lugEmi, Integer nroExt)
			throws BaseException {

		NumberFormat formatLugEmi = new DecimalFormat("0000");
		String lugarDeEmision = formatLugEmi.format(lugEmi);

		NumberFormat formatNroExt = new DecimalFormat("00000000");
		String nroExterno = formatNroExt.format(nroExt);

		return TC + "-" + letra + "-" + lugarDeEmision + "-" + nroExterno;
	}
	
	public static final String getLugEmiNroExt(Integer lugEmi,
			                                       Integer nroExt) throws BaseException {
		NumberFormat formatLugEmi = new DecimalFormat("0000");
		String lugarDeEmision = formatLugEmi.format(lugEmi);

		NumberFormat formatNroExt = new DecimalFormat("00000000");
		String nroExterno = formatNroExt.format(nroExt);
		
		return lugarDeEmision + "-" + nroExterno;
	}

	public String getNroExtFormat8Digitos() {
		NumberFormat formatNroExt = new DecimalFormat("00000000");
		String nroExterno = formatNroExt.format(nroExt);
		return nroExterno;
	}

	public String getLugEmiFormato4Digitos() throws BaseException {
		NumberFormat formatLugEmi = new DecimalFormat("0000");
		String lugarDeEmision = formatLugEmi.format(this.getLugarEmision().getLugemi());
		return lugarDeEmision;
	}

	public void addCotizacionMoneda(Moneda moneda, ValorCotizacion valorCotizacion) throws BaseException {
		listaCotizaciones.remove(moneda);
		this.listaCotizaciones.put(moneda, valorCotizacion);
	}

	public void addCotizacionesMonedas(HashTableDatos cotizacionesMonedas) throws BaseException {

		// Recorrer las cotizaciones
		Iterator iterMonCotiz = cotizacionesMonedas.keySet().iterator();
		while (iterMonCotiz.hasNext()) {
			Moneda moneda = (Moneda) iterMonCotiz.next();
			listaCotizaciones.put(moneda, (ValorCotizacion) cotizacionesMonedas.get(moneda));
		}
	}

	public ValorCotizacion getCotizacionMoneda(Moneda aMoneda) throws BaseException {
		if (aMoneda == null)
			throw new ExceptionValidation(null, "Debe ingresar una moneda para poder obtener la cotización");
		if (aMoneda.getOID() == Moneda.getMonedaCursoLegal(getSesion()).getOID())
			return new ValorCotizacion(1);
		Iterator iterMonedas = this.listaCotizaciones.keySet().iterator();
		while (iterMonedas.hasNext()) {
			Moneda moneda = (Moneda) iterMonedas.next();
			if (moneda.getOID() == aMoneda.getOID()) {
				ValorCotizacion valor = (ValorCotizacion) this.listaCotizaciones.get(moneda);
				if (valor.doubleValue() == 0)
					throw new ExceptionValidation(null, "Debe ingresar la cotización de la moneda " + aMoneda.getDescripcion());
				return valor;
			}
		}
		throw new ExceptionValidation(null, "No se encontro cotización para la moneda " + aMoneda.getDescripcion());
	}

	public ValorCotizacion getCotizMonExt1() throws BaseException {
		Moneda moneda = Moneda.getMonedaExt1(getSesion());
		return getCotizacionMoneda(moneda);
	}

	public ValorCotizacion getCotizMonExt2() throws BaseException {
		Moneda moneda = Moneda.getMonedaExt2(getSesion());
		return getCotizacionMoneda(moneda);
	}

	public HashTableDatos getCotizaciones() throws BaseException {
		return listaCotizaciones;
	}

	protected void anularComprobante(ComproCab comprobanteAAnular) throws BaseException {

		anularAsientoContable(comprobanteAAnular);
		anularMovStock(comprobanteAAnular);
		comprobanteAAnular.setComprobanteAnulador(this);

	}

	private void anularMovStock(ComproCab comprobanteAAnular) throws BaseException {

		// Anular los Movimientos de Stock
		if (!(this instanceof IStockeable))
			return;
		if (!comprobanteAAnular.tieneMovStock())
			return;
		actuStockComprobante((IStockeable) this);

	}

	private void anularAsientoContable(ComproCab comprobanteAAnular) throws BaseException {

		// Anular el Asiento Contable
		if (!(this instanceof IContabilizable))
			return;
		if (!comprobanteAAnular.tieneAsiento())
			return;
		ComproConta comproConta = ComproConta.getNewComprobante(getSesion());
		comproConta.setContabilizable((IContabilizable) this);
		if (comprobanteAAnular.getComproConta() == null)
			return;
		RenglonesAsiento renglones = comprobanteAAnular.getComproConta().getRenglonesAsientoInvertidos();
		if (renglones == null)
			return;
		Iterator iterRenglones = comprobanteAAnular.getComproConta().getRenglonesAsientoInvertidos().getListaRenglones()
				.iterator();
		while (iterRenglones.hasNext()) {
			RenglonAsiento renglonAsiento = (RenglonAsiento) iterRenglones.next();
			agregarDetAsiento(comproConta, renglonAsiento);
		}
		comproConta.save();
	}

	public boolean tieneAsiento() throws BaseException {
		return ComproConta.tieneAsiento(this, getSesion());
	}

	public boolean tieneMovStock() throws BaseException {
		return StockCabecera.tieneMovStock(this, getSesion());
	}

	public void afterSaveNew() throws BaseException {
		// TODO Auto-generated method stub
		super.afterSaveNew();

		if (this instanceof ICtaCteProv)
			grabarCtaCteComprobante((ICtaCteProv) this);
		if (getContabiliza() && (this instanceof IContabilizable))
			contabilizarComprobante((IContabilizable) this);
		if (isActuStock() && (this instanceof IStockeable))
			actuStockComprobante((IStockeable) this);
		if (this instanceof ILibroIVA)
			actuLibroIVA((ILibroIVA) this);

	}

	private void grabarCtaCteComprobante(ICtaCteProv comprobanteCtaCteProv) throws BaseException {
		if (isGrabaCtaCte() == false)
			return;
		GrabarCtaCteProv ctaCteProv = new GrabarCtaCteProv(getSesion());
		grabarCtaCte(ctaCteProv);
		ctaCteProv.save();
	}

	protected void grabarCtaCte(GrabarCtaCteProv ctaCteProv) throws BaseException {

	}

	protected boolean isGrabaCtaCte() throws BaseException {
		return true;
	}

	private void actuLibroIVA(ILibroIVA libroIVA) throws BaseException {
		ListadoIVACab listadoIVACab = libroIVA.getLibroIVACab();
		if (listadoIVACab != null)
			listadoIVACab.save();
	}

	public ImportesContables getImportesContables(Money importe, Moneda monedaValor, Date fecha) throws BaseException {
		CalcImportesContables calcImpoConta = new CalcImportesContables(getSesion(), fecha);
		calcImpoConta.addCotizaciones(listaCotizaciones);
		return calcImpoConta.getImportesContables(importe, monedaValor);
	}

	public HashTableDatos cargarCotizaciones(IDataSet dsCotizaciones) throws BaseException {
		dsCotizaciones.first();
		while (!dsCotizaciones.EOF()) {
			Moneda moneda = Moneda.findByOidProxy(dsCotizaciones.getInteger("oid_moneda"), getSesion());
			ValorCotizacion valorCotiz = dsCotizaciones.getCotizacion("cotizacion");
			listaCotizaciones.put(moneda, valorCotiz);
			dsCotizaciones.next();
		}
		return listaCotizaciones;
	}

	private ValorCotizacion getCotizacionHoy(Integer oidMoneda) throws BaseException {
		if (Moneda.getMonedaCursoLegal(getSesion()).getOID() == oidMoneda.intValue())
			return new ValorCotizacion(1);
		else {
			if (listaCotizaciones.size() == 0)
				return null;
			
			Iterator iterMonedas = listaCotizaciones.keySet().iterator();
			while (iterMonedas.hasNext()) {
				Object key = (Object) iterMonedas.next();
				if (key instanceof Integer) {
					if (oidMoneda.intValue()== ((Integer)key).intValue())
						return (ValorCotizacion)listaCotizaciones.get(oidMoneda);
				} else if (key instanceof Moneda) {
					if (oidMoneda.intValue()== ((Moneda)key).getOID())
						return (ValorCotizacion)listaCotizaciones.get((Moneda)key);
				}
			}
			
			return null;
		}
	}

	public Money getImporteEnMonLoc(Money Importe, Moneda moneda) throws BaseException {
		if (Importe == null) return new Money(0);
		ValorCotizacion valorCotizacion = getCotizacionHoy(moneda.getOIDInteger());
		if (valorCotizacion == null)
			throw new ExceptionValidation(null, "No se puede obtener la cotización para la moneda " + moneda.getDescripcion());
		CalculadorMoney calcImporte = new CalculadorMoney(Importe);
		calcImporte.multiplicarPor(valorCotizacion);
		return calcImporte.getResultMoney();
	}

	public static ComproCab getComproCab(Talonario talonario, Integer nroExt, ISesion aSesion) throws BaseException {
		return DBComproCab.getComproCab(talonario, nroExt, aSesion);
	}
	
	public static ComproCab getComproCabActivo(Talonario talonario, Integer nroExt, ISesion aSesion) throws BaseException {
		return DBComproCab.getComproCabActivo(talonario, nroExt, aSesion);
	}
	

	protected void onNew() throws BaseException {
		// TODO Auto-generated method stub
		super.onNew();
		Sucursal sucursal = Sucursal.findByOidProxy(this.getSesion().getLogin().getOidSucursal(),this.getSesion());
		this.setSucursal(sucursal);
	}
	
	public static int getNewNroInterno(ISesion aSesion) throws BaseException {
		int nro = aSesion.getNewOIDByKey("compro_cab_nro_int");
		return nro;
	}
	
	public ComprobanteImpreso getComprobanteImpreso() throws BaseException {
		return ComprobanteImpreso.findByOid(this.getOIDInteger(), this.getSesion());
	}


}
