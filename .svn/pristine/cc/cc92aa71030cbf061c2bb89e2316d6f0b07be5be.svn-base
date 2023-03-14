package com.srn.erp.general.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.contabilidad.bm.Leyenda;
import com.srn.erp.general.da.DBTipoComprobante;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Parametros.ValorParametro;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class TipoComprobante extends ObjetoLogico {

	public TipoComprobante() {
	}

	public static String NICKNAME = "ge.TipoComprobante";

	public static String TIPO_NUM_AUTO = "AUTO";
	public static String TIPO_NUM_MANUAL = "MANUAL";

	private String TCExterno;
	private String descripcion;
	private String identificacion;
	private Leyenda leyenda;
	private Boolean activo;
	private TipoComprobante tipoComproAnulador;
	private String codigoParaCodigoBarra;
	private String descTituloAsientoLibriDiario;

	private List motivosTC = new ArrayList();
	private boolean readMotivosTC = true;

	public String getTcexterno() throws BaseException {
		supportRefresh();
		return TCExterno;
	}

	public String getDescTituAsiLibroDiario() throws BaseException {
		supportRefresh();
		return this.descTituloAsientoLibriDiario;
	}

	public TipoComprobante getTipoComproAnulador() throws BaseException {
		supportRefresh();
		return this.tipoComproAnulador;
	}

	public String getCodigoParaCodigoBarra() throws BaseException {
		supportRefresh();
		return this.codigoParaCodigoBarra;
	}

	public void setCodigoParaCodigoBarra(String aCodigoParaCodigoBarra) {
		this.codigoParaCodigoBarra = aCodigoParaCodigoBarra;
	}

	public void setDescTituAsiLibroDiario(String aDescTituAsiLibroDiario) {
		this.descTituloAsientoLibriDiario = aDescTituAsiLibroDiario;
	}

	public void setTcexterno(String aTcexterno) {
		this.TCExterno = aTcexterno;
	}

	public void setTipoComprobanteAnulador(TipoComprobante aTipoComproAnulador) {
		this.tipoComproAnulador = aTipoComproAnulador;
	}

	public String getDescripcion() throws BaseException {
		supportRefresh();
		return descripcion;
	}

	public void setDescripcion(String aDescripcion) {
		this.descripcion = aDescripcion;
	}

	public String getIdentificacion() throws BaseException {
		supportRefresh();
		return identificacion;
	}

	public void setIdentificacion(String aIdentificacion) {
		this.identificacion = aIdentificacion;
	}

	public Leyenda getLeyenda() throws BaseException {
		supportRefresh();
		return leyenda;
	}

	public void setLeyenda(Leyenda aLeyenda) {
		this.leyenda = aLeyenda;
	}

	public Boolean isActivo() throws BaseException {
		supportRefresh();
		return activo;
	}

	public void setActivo(Boolean aActivo) {
		this.activo = aActivo;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static TipoComprobante findByOid(Integer oid, ISesion aSesion)
			throws BaseException {
		return (TipoComprobante) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static TipoComprobante findByOidProxy(Integer oid, ISesion aSesion)
			throws BaseException {
		return (TipoComprobante) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static TipoComprobante findByCodigo(String codigo, ISesion aSesion)
			throws BaseException {
		return (TipoComprobante) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(TCExterno, "Debe ingresar un código de TC Externo");
		Validar.noNulo(descripcion, "Debe ingresar la Descripción");
		Validar.noNulo(identificacion, "Debe ingresar la Identificación");
		Validar.noNulo(leyenda, "Debe ingresar la Leyenda");

		if (isNew() && (isActivo().booleanValue() == false))
			Validar
					.mensajeValidacion("El Tipo de Comprobante debe ingresarse en modo activo");

	}

	/**
	 * getCodigo
	 * 
	 * @return String
	 */
	public String getCodigo() throws BaseException {
		return getTcexterno();
	}

	public List getMotivosTC() throws BaseException {
		if (readMotivosTC) {
			List listaMotivosTC = MotivoTC.getMotivosPorTC(this, getSesion());
			motivosTC.addAll(listaMotivosTC);
			readMotivosTC = false;
		}
		return motivosTC;
	}

	public void addMotivoTC(MotivoTC motivoTC) throws BaseException {
		motivoTC.setTipo_comprobate(this);
		motivosTC.add(motivoTC);
	}

	public void afterSave() throws BaseException {
		Iterator iterMotivosTC = motivosTC.iterator();
		while (iterMotivosTC.hasNext()) {
			MotivoTC motivoTC = (MotivoTC) iterMotivosTC.next();
			motivoTC.save();
			motivoTC = null;
		}
		iterMotivosTC = null;
	}

	public boolean esNotaDebitoInternoProveedor() throws BaseException {
		return IdentificacionTipoComprobante.esNotaDebitoInternoProveedor(this
				.getIdentificacion());
	}

	public boolean esNotaCreditoInternoProveedor() throws BaseException {
		return IdentificacionTipoComprobante.esNotaCreditoInternoProveedor(this
				.getIdentificacion());
	}

	public boolean esFacturacliente() throws BaseException {
		return IdentificacionTipoComprobante.esFactCliente(this
				.getIdentificacion());
	}

	public boolean esRemitocliente() throws BaseException {
		return IdentificacionTipoComprobante.esRemitoCliente(this
				.getIdentificacion());
	}

	public boolean esNotaCreditoCliente() throws BaseException {
		return IdentificacionTipoComprobante.esNotaCreditoCliente(this
				.getIdentificacion());
	}

	public boolean esRecibo() throws BaseException {
		return IdentificacionTipoComprobante.esRecibo(this.getIdentificacion());
	}

	public boolean esOrdenDePago() throws BaseException {
		return IdentificacionTipoComprobante.esOrdenDePago(this
				.getIdentificacion());
	}

	public boolean esOrdenDeCompra() throws BaseException {
		return IdentificacionTipoComprobante.esOrdenDeCompra(this
				.getIdentificacion());
	}

	public boolean esOrdenDePagoVarios() throws BaseException {
		return IdentificacionTipoComprobante.esPagosVarios(this
				.getIdentificacion());
	}

	public boolean esNotaDebitoInternaCliente() throws BaseException {
		return IdentificacionTipoComprobante.esNotaDebitoInternaCliente(this
				.getIdentificacion());
	}

	public boolean esNotaCreditoInternaCliente() throws BaseException {
		return IdentificacionTipoComprobante.esNotaCreditoInternaCliente(this
				.getIdentificacion());
	}

	public boolean esAsientoDeApertura() throws BaseException {
		return IdentificacionTipoComprobante.esAsientoDeApertura(this
				.getIdentificacion());
	}

	public boolean esAsientoCierre() throws BaseException {
		return IdentificacionTipoComprobante.esAsientoCierre(this
				.getIdentificacion());
	}
	
	public boolean esInformeRecepcion() throws BaseException {
		return IdentificacionTipoComprobante.esInformeRecepcion(this
				.getIdentificacion());
	}
	

	public boolean esOrdenDePagoVariosEfectivo() throws BaseException {
		return IdentificacionTipoComprobante.esPagosVariosEfectivo(this
				.getIdentificacion());
	}

	public static List getAllTiposComprobantes(ISesion aSesion)
			throws BaseException {
		return DBTipoComprobante.getAllTiposComprobantes(aSesion);
	}

	public static List getAllTiposComprobantesProveedor(ISesion aSesion)
			throws BaseException {
		return DBTipoComprobante.getAllTiposComprobantesProveedor(aSesion);
	}

	public static TipoComprobante getTCFacturaDefBuscador(ISesion aSesion)
			throws BaseException {
		Integer oidTC = ValorParametro.findByCodigoParametro(
				"TC_DEFAULT_BUSC_FACT", aSesion).getOidObjNeg();
		TipoComprobante tc = TipoComprobante.findByOid(oidTC, aSesion);
		return tc;
	}
	
	public static TipoComprobante getTCRemitoDefBuscador(ISesion aSesion)
	throws BaseException {
		Integer oidTC = ValorParametro.findByCodigoParametro(
		"TC_DEFAULT_BUSC_RTO", aSesion).getOidObjNeg();
		TipoComprobante tc = TipoComprobante.findByOid(oidTC, aSesion);
		return tc;
	}
	
	public static TipoComprobante getTCPedidoDefBuscador(ISesion aSesion)
	throws BaseException {
		Integer oidTC = ValorParametro.findByCodigoParametro(
		"TC_DEFAULT_BUSC_PED", aSesion).getOidObjNeg();
		TipoComprobante tc = TipoComprobante.findByOid(oidTC, aSesion);
		return tc;
	}
	
	public static List getTiposComproConMovArqueoSigno(ISesion aSesion,Integer signo) throws BaseException {
		return DBTipoComprobante.getTiposComproConMovArqueoSigno(aSesion,signo);
	}
	
	public boolean esFactProv() throws BaseException {
		return this.getIdentificacion().equals(IdentificacionTipoComprobante.COMPRO_FACTURA_PROVEEDOR);
	}
	
	public boolean esNDProv() throws BaseException {
		return this.getIdentificacion().equals(IdentificacionTipoComprobante.COMPRO_ND_PROVEEDOR);
	}
	
	public boolean esNCProv() throws BaseException {
		return this.getIdentificacion().equals(IdentificacionTipoComprobante.COMPRO_NC_PROVEEDOR);
	}
	
	public boolean esLiqTarCredito() throws BaseException {
		return this.getIdentificacion().equals(IdentificacionTipoComprobante.LIQUIDACION_TAR_CREDITO);
	}
	
	public boolean esLiqTarDebito() throws BaseException {
		return this.getIdentificacion().equals(IdentificacionTipoComprobante.LIQUIDACION_TAR_DEBITO);
	}
	
	
	
}
