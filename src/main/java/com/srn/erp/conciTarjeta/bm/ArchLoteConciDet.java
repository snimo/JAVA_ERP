package com.srn.erp.conciTarjeta.bm;

import java.util.Iterator;
import java.util.List;

import com.srn.erp.conciTarjeta.da.DBArchLoteConciDet;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.applicarionServer.bm.Varios.CalculadorMoney;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.Validar;

public class ArchLoteConciDet extends ObjetoLogico {

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return "Fecha:" + Fecha.getddmmyyyy(this.getFecOperDate()) + " " + this.getTarjeta() + " Nro. " + this.getNro_tarjeta() + " Lote "
				+ this.getNro_lote().toString() + " importe " + this.getMonto();
	}

	public ArchLoteConciDet() {
	}

	public static String NICKNAME = "ctar.ArchLoteConciDet";

	private ArchLoteConciCab arch_lot_cab;
	private String modo_transmision;
	private String tipo_operacion;
	private String fecha_oper;
	private String hora_oper;
	private String tipo_tarjeta;
	private String tarjeta;
	private String nro_tarjeta;
	private String banda_manual;
	private String cod_autoriz;
	private String ticket;
	private String moneda;
	private Double Monto;
	private String tipo_cta_deb;
	private String plan_y_cuota;
	private String cod_comercio;
	private String nro_terminal;
	private String ticket_sec;
	private String codigo_lista;
	private Double monto_sec;
	private String fecha_sec;
	private String factura;
	private String nro_host;
	private Integer nro_lote;
	private Boolean activo;
	private Boolean presentado;
	private EmpresaConciTar empresa;
	private UniNegConciTar unidad_negocio;
	private java.util.Date fecOperDate;
	private java.util.Date fecCierre;
	private java.util.Date fecPresenCupo;
	private boolean conciliado;
	private java.util.Date fecConciliado;
	private boolean liquidado;
	private java.util.Date fecLiquidado;
	private boolean preContabilizado;
	private java.util.Date fecPreContabilizado;
	private boolean contabilizado;
	private java.util.Date fecContabilizado;
	private TarjetaConciTar tarjetaConciliacion;
	private Integer ultNrosTarjeta;
	private Integer nroConciliacion;
	private Boolean marcarPreconci;
	private Boolean preconci;
	private Usuario usuarioMarcaPreconci;
	private Usuario usuarioPreconci;
	private java.util.Date fecPreconci;
	private CabConciAutomatica cabConciAut;
	private Boolean preconciDudoso;
	private Boolean altaManual;
	private CabAsiTarjACobrar asientoACobrar;
	private Boolean contaAsiACobrar;
	private String tarjetaOri;
	private Boolean marcaAsiACob;
	private Boolean cuponPerdido;
	private Boolean marcaAsiLiq;
	private CabAsiLiquiTarj cabAsiLiqTarj;
	private Integer nroLiquidacion;
	private Boolean contaAsiLiq;
	private String refSistExt;
	private String refSistExt1;
	private Usuario usuMarcaAsiCob;
	private Usuario usuMarcaAsiLiq;
	
	public Usuario getUsuarioMarcaAsiCob() throws BaseException {
		supportRefresh();
		return this.usuMarcaAsiCob;
	}
	
	public void setNroUsuarioMarcaAsiCob(Usuario aUsuario) throws BaseException {
		this.usuMarcaAsiCob = aUsuario;
	}
	
	public void setNroUsuarioMarcaAsiLiq(Usuario aUsuario) throws BaseException {
		this.usuMarcaAsiLiq = aUsuario;
	}

	public Usuario getUsuarioMarcaAsiLiq() throws BaseException {
		supportRefresh();
		return this.usuMarcaAsiLiq;
	}
	

	public Boolean isMarcaAsiLiq() throws BaseException {
		supportRefresh();
		return this.marcaAsiLiq;
	}

	public String getRefSistExt() throws BaseException {
		supportRefresh();
		if (this.refSistExt != null)
			return this.refSistExt;
		else
			return "";
	}

	public String getRefSistExt1() throws BaseException {
		supportRefresh();
		if (this.refSistExt1 != null)
			return this.refSistExt1;
		else
			return "";
	}

	public Boolean isContaAsiLiq() throws BaseException {
		supportRefresh();
		if (this.contaAsiLiq != null)
			return this.contaAsiLiq;
		else
			return false;
	}

	public Integer getNroLiquidacion() throws BaseException {
		supportRefresh();
		return this.nroLiquidacion;
	}

	public void setNroLiquidacion(Integer aNroLiquidacion) throws BaseException {
		this.nroLiquidacion = aNroLiquidacion;
	}

	public void setContaAsiLiq(Boolean aContaAsiLiq) throws BaseException {
		this.contaAsiLiq = aContaAsiLiq;
	}

	public void setRefSistExt(String aRefSistExt) throws BaseException {
		this.refSistExt = aRefSistExt;
	}

	public void setRefSistExt1(String aRefSistExt1) throws BaseException {
		this.refSistExt1 = aRefSistExt1;
	}

	public void setMarcaAsiLiq(Boolean aMarcaAsiLiq) throws BaseException {
		this.marcaAsiLiq = aMarcaAsiLiq;
	}

	public CabAsiLiquiTarj getCabAsiLiquiTarj() throws BaseException {
		supportRefresh();
		return this.cabAsiLiqTarj;
	}

	public void setCabAsiLiquiTarj(CabAsiLiquiTarj aCabAsiLiquiTarj) throws BaseException {
		this.cabAsiLiqTarj = aCabAsiLiquiTarj;
	}

	public CabAsiTarjACobrar getAsientoACobrar() throws BaseException {
		supportRefresh();
		return this.asientoACobrar;
	}

	public Boolean isMarcaAsiACobrar() throws BaseException {
		supportRefresh();
		if (this.marcaAsiACob != null)
			return this.marcaAsiACob;
		else
			return false;
	}

	public Boolean isCuponPerdido() throws BaseException {
		supportRefresh();
		return this.cuponPerdido;
	}

	public String getTarjetaOri() throws BaseException {
		supportRefresh();
		if (this.tarjetaOri != null)
			return this.tarjetaOri;
		else
			return "";
	}

	public Boolean isContaAsientoACobrar() throws BaseException {
		supportRefresh();
		if (this.contaAsiACobrar != null)
			return this.contaAsiACobrar;
		else
			return false;
	}

	public void setTarjetaOri(String aTarjetaOri) {
		this.tarjetaOri = aTarjetaOri;
	}

	public void setMarcaAsiACobrar(Boolean aMarcaAsiACobrar) {
		this.marcaAsiACob = aMarcaAsiACobrar;
	}

	public void setAsientoACobrar(CabAsiTarjACobrar aCabAsiTarjACobrar) {
		this.asientoACobrar = aCabAsiTarjACobrar;
	}

	public void setCuponPerdido(Boolean aCuponPerdido) {
		this.cuponPerdido = aCuponPerdido;
	}

	public void setContaAsiACobrar(Boolean aContaAsiACobrar) {
		this.contaAsiACobrar = aContaAsiACobrar;
	}

	public java.util.Date getFecPresenCupo() throws BaseException {
		supportRefresh();
		return this.fecPresenCupo;
	}

	public Usuario getUsuarioPreconci() throws BaseException {
		supportRefresh();
		return this.usuarioPreconci;
	}

	public Boolean isPreconciDudoso() throws BaseException {
		supportRefresh();
		if (preconciDudoso == null)
			return false;
		else
			return this.preconciDudoso;
	}

	public Boolean isAltaManual() throws BaseException {
		supportRefresh();
		if (this.altaManual == null)
			return false;
		else
			return this.altaManual;
	}

	public void setPreconciDudoso(Boolean aPreconciDudoso) {
		this.preconciDudoso = aPreconciDudoso;
	}

	public void setUsuarioPreconci(Usuario aUsuarioPreconci) {
		this.usuarioPreconci = aUsuarioPreconci;
	}

	public void setAltaManual(Boolean aAltaManual) {
		this.altaManual = aAltaManual;
	}

	public CabConciAutomatica getCabConciAut() throws BaseException {
		supportRefresh();
		return this.cabConciAut;
	}

	public java.util.Date getFecPreconci() throws BaseException {
		supportRefresh();
		return this.fecPreconci;
	}

	public Usuario getUsuarioMarcaPreconci() throws BaseException {
		supportRefresh();
		return this.usuarioMarcaPreconci;
	}

	public void setUsuarioMarcaPreconci(Usuario aUsuario) {
		this.usuarioMarcaPreconci = aUsuario;
	}

	public void setCabConciAut(CabConciAutomatica aCabConciAutomatica) {
		this.cabConciAut = aCabConciAutomatica;
	}

	public void setFecPreconci(java.util.Date aFecPreconci) {
		this.fecPreconci = aFecPreconci;
	}

	public Boolean isMarcarPreconci() throws BaseException {
		supportRefresh();
		return this.marcarPreconci;
	}

	public Boolean isPreconci() throws BaseException {
		supportRefresh();
		return this.preconci;
	}

	public void setPreconci(Boolean aPreconci) {
		this.preconci = aPreconci;
	}

	public Integer getUltimosNrosTarjeta() throws BaseException {
		supportRefresh();
		return this.ultNrosTarjeta;
	}

	public Integer getNroConciliacion() throws BaseException {
		supportRefresh();
		if (nroConciliacion == null)
			return 0;
		else
			return this.nroConciliacion;
	}

	public void setNroConciliacion(Integer aNroConciliacion) {
		this.nroConciliacion = aNroConciliacion;
	}

	public void setMarcarPreconci(Boolean aMarcarPreconci) {
		this.marcarPreconci = aMarcarPreconci;
	}

	public void setFecPresenCupo(java.util.Date aFecPresenCupo) {
		this.fecPresenCupo = aFecPresenCupo;
	}

	public void setUltimosNrosTarjeta(Integer aUltNrosTarjeta) {
		this.ultNrosTarjeta = aUltNrosTarjeta;
	}

	public TarjetaConciTar getTarjetaConciTar() throws BaseException {
		supportRefresh();
		return this.tarjetaConciliacion;
	}

	public void setTarjetaConciliacion(TarjetaConciTar aTarjetaConciliacion) {
		this.tarjetaConciliacion = aTarjetaConciliacion;
	}

	public boolean isConciliado() throws BaseException {
		supportRefresh();
		return this.conciliado;
	}

	public void setConciliado(boolean aConciliado) {
		this.conciliado = aConciliado;
	}

	public java.util.Date getFecConciliado() throws BaseException {
		supportRefresh();
		return this.fecConciliado;
	}

	public void setFecConciliado(java.util.Date aFecConciliado) {
		this.fecConciliado = aFecConciliado;
	}

	public boolean isLiquidado() throws BaseException {
		this.supportRefresh();
		return this.liquidado;
	}

	public void setLiquidado(boolean aLiquidado) {
		this.liquidado = aLiquidado;
	}

	public java.util.Date getFecLiquidado() throws BaseException {
		this.supportRefresh();
		return this.fecLiquidado;
	}

	public void setFecLiquidado(java.util.Date aFecLiquidado) throws BaseException {
		this.fecLiquidado = aFecLiquidado;
	}

	public boolean isPreContabilizado() throws BaseException {
		this.supportRefresh();
		return this.preContabilizado;
	}

	public void setPreContabilizado(boolean aPrecontabilizado) {
		this.preContabilizado = aPrecontabilizado;
	}

	public java.util.Date getFecPreContabilizado() throws BaseException {
		this.supportRefresh();
		return this.fecPreContabilizado;
	}

	public void setFecPreContabilizado(java.util.Date aFecPreContabilizado) {
		this.fecPreContabilizado = aFecPreContabilizado;
	}

	public boolean isContabilizado() throws BaseException {
		this.supportRefresh();
		return this.conciliado;
	}

	public void setContabilizado(boolean aContabilizado) throws BaseException {
		this.contabilizado = aContabilizado;
	}

	public java.util.Date getFecContabilizado() throws BaseException {
		this.supportRefresh();
		return this.fecContabilizado;
	}

	public void setFecContabilizado(java.util.Date aFeccontabilizado) {
		this.fecContabilizado = aFeccontabilizado;
	}

	public ArchLoteConciCab getArch_lot_cab() throws BaseException {
		supportRefresh();
		return arch_lot_cab;
	}

	public void setArch_lot_cab(ArchLoteConciCab aArch_lot_cab) {
		this.arch_lot_cab = aArch_lot_cab;
	}

	public String getModo_transmision() throws BaseException {
		supportRefresh();
		return modo_transmision;
	}

	public void setModo_transmision(String aModo_transmision) {
		this.modo_transmision = aModo_transmision;
	}

	public String getTipo_operacion() throws BaseException {
		supportRefresh();
		return tipo_operacion;
	}

	public void setTipo_operacion(String aTipo_operacion) {
		this.tipo_operacion = aTipo_operacion;
	}

	public String getFecha_oper() throws BaseException {
		supportRefresh();
		return fecha_oper;
	}

	public void setFecha_oper(String aFecha_oper) {
		this.fecha_oper = aFecha_oper;
	}

	public java.util.Date getFecCierre() throws BaseException {
		supportRefresh();
		return this.fecCierre;
	}

	public void setFecCierre(java.util.Date aFecCierre) {
		this.fecCierre = aFecCierre;
	}

	public java.util.Date getFecOperDate() throws BaseException {
		supportRefresh();
		return this.fecOperDate;
	}

	public void setFecOperDate(java.util.Date aFecOperDate) {
		this.fecOperDate = aFecOperDate;
	}

	public String getHora_oper() throws BaseException {
		supportRefresh();
		return hora_oper;
	}

	public void setHora_oper(String aHora_oper) {
		this.hora_oper = aHora_oper;
	}

	public String getTipo_tarjeta() throws BaseException {
		supportRefresh();
		return tipo_tarjeta;
	}

	public void setTipo_tarjeta(String aTipo_tarjeta) {
		this.tipo_tarjeta = aTipo_tarjeta;
	}

	public String getTarjeta() throws BaseException {
		supportRefresh();
		return tarjeta;
	}

	public void setTarjeta(String aTarjeta) {
		this.tarjeta = aTarjeta;
	}

	public String getNro_tarjeta() throws BaseException {
		supportRefresh();
		return nro_tarjeta;
	}

	public void setNro_tarjeta(String aNro_tarjeta) {
		this.nro_tarjeta = aNro_tarjeta;
	}

	public String getBanda_manual() throws BaseException {
		supportRefresh();
		return banda_manual;
	}

	public void setBanda_manual(String aBanda_manual) {
		this.banda_manual = aBanda_manual;
	}

	public String getCod_autoriz() throws BaseException {
		supportRefresh();
		return cod_autoriz;
	}

	public void setCod_autoriz(String aCod_autoriz) {
		this.cod_autoriz = aCod_autoriz;
	}

	public String getTicket() throws BaseException {
		supportRefresh();
		return ticket;
	}

	public void setTicket(String aTicket) {
		this.ticket = aTicket;
	}

	public String getMoneda() throws BaseException {
		supportRefresh();
		return moneda;
	}

	public void setMoneda(String aMoneda) {
		this.moneda = aMoneda;
	}

	public Double getMonto() throws BaseException {
		supportRefresh();
		return Monto;
	}

	public void setMonto(Double aMonto) {
		this.Monto = aMonto;
	}

	public String getTipo_cta_deb() throws BaseException {
		supportRefresh();
		return tipo_cta_deb;
	}

	public void setTipo_cta_deb(String aTipo_cta_deb) {
		this.tipo_cta_deb = aTipo_cta_deb;
	}

	public String getPlan_y_cuota() throws BaseException {
		supportRefresh();
		return plan_y_cuota;
	}

	public void setPlan_y_cuota(String aPlan_y_cuota) {
		this.plan_y_cuota = aPlan_y_cuota;
	}

	public String getCod_comercio() throws BaseException {
		supportRefresh();
		return cod_comercio;
	}

	public void setCod_comercio(String aCod_comercio) {
		this.cod_comercio = aCod_comercio;
	}

	public String getNro_terminal() throws BaseException {
		supportRefresh();
		return nro_terminal;
	}

	public void setNro_terminal(String aNro_terminal) {
		this.nro_terminal = aNro_terminal;
	}

	public String getTicket_sec() throws BaseException {
		supportRefresh();
		return ticket_sec;
	}

	public void setTicket_sec(String aTicket_sec) {
		this.ticket_sec = aTicket_sec;
	}

	public String getCodigo_lista() throws BaseException {
		supportRefresh();
		return codigo_lista;
	}

	public void setCodigo_lista(String aCodigo_lista) {
		this.codigo_lista = aCodigo_lista;
	}

	public Double getMonto_sec() throws BaseException {
		supportRefresh();
		return monto_sec;
	}

	public void setMonto_sec(Double aMonto_sec) {
		this.monto_sec = aMonto_sec;
	}

	public String getFecha_sec() throws BaseException {
		supportRefresh();
		return fecha_sec;
	}

	public void setFecha_sec(String aFecha_sec) {
		this.fecha_sec = aFecha_sec;
	}

	public String getFactura() throws BaseException {
		supportRefresh();
		return factura;
	}

	public void setFactura(String aFactura) {
		this.factura = aFactura;
	}

	public String getNro_host() throws BaseException {
		supportRefresh();
		return nro_host;
	}

	public void setNro_host(String aNro_host) {
		this.nro_host = aNro_host;
	}

	public Integer getNro_lote() throws BaseException {
		supportRefresh();
		return nro_lote;
	}

	public void setNro_lote(Integer aNro_lote) {
		this.nro_lote = aNro_lote;
	}

	public Boolean isActivo() throws BaseException {
		supportRefresh();
		return activo;
	}

	public void setActivo(Boolean aActivo) {
		this.activo = aActivo;
	}

	public Boolean isPresentado() throws BaseException {
		supportRefresh();
		if (presentado != null)
			return presentado;
		else
			return false;
	}

	public void setPresentado(Boolean aPresentado) {
		this.presentado = aPresentado;
	}

	public EmpresaConciTar getEmpresa() throws BaseException {
		supportRefresh();
		return empresa;
	}

	public void setEmpresa(EmpresaConciTar aEmpresa) {
		this.empresa = aEmpresa;
	}

	public UniNegConciTar getUnidad_negocio() throws BaseException {
		supportRefresh();
		return unidad_negocio;
	}

	public void setUnidad_negocio(UniNegConciTar aUnidad_negocio) {
		this.unidad_negocio = aUnidad_negocio;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static ArchLoteConciDet findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (ArchLoteConciDet) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static ArchLoteConciDet findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (ArchLoteConciDet) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static ArchLoteConciDet findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (ArchLoteConciDet) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {

		Validar.noNulo(this.tarjetaConciliacion, "Debe ingresar la Tarjeta");
		Validar.noNulo(this.Monto, "Debe ingresar el Monto");
		Validar.noNulo(this.fecCierre, "Debe ingresar la Fecha de Cierre");
		if ((this.Monto != null) && (Monto.doubleValue() == 0))
			Validar.noNulo(this.Monto, "El monto no puede ser cero");

	}

	public static List getArchLoteconciDet(ArchLoteConciCab archLoteConciCab, ISesion aSesion) throws BaseException {
		return DBArchLoteConciDet.getArchLoteconciDet(archLoteConciCab, aSesion);
	}

	public static List getAllByCondiciones(HashTableDatos condiciones, ISesion aSesion) throws BaseException {
		return DBArchLoteConciDet.getAllByCondiciones(condiciones, aSesion);
	}

	public static void actuMarcaPresentado(ArchLoteConciDet archLoteConciDet, boolean presentado, ISesion aSesion) throws BaseException {
		DBArchLoteConciDet.actuMarcaPresentado(archLoteConciDet, presentado, aSesion);

	}

	public void invertirMarcaPresentado() throws BaseException {
		if ((this.isPresentado()) && ((this.isMarcaAsiACobrar()) || (this.isContaAsientoACobrar())))
			throw new ExceptionValidation(null,
					"No se puede desmarcar un CUPON presentado si se encuentra marcado para contabilizar o contabilizado. ");
		ArchLoteConciDet.actuMarcaPresentado(this, !this.isPresentado(), this.getSesion());
	}

	public static void anularDetallesDelArchivo(ArchLoteConciCab archLoteConciCab, ISesion aSesion) throws BaseException {
		DBArchLoteConciDet.anularDetallesDelArchivo(archLoteConciCab, aSesion);
	}

	public static void marcarComoPreconci(ArchLoteConciDet archLoteConciDet, ISesion aSesion) throws BaseException {
		DBArchLoteConciDet.marcarComoPreconci(archLoteConciDet, aSesion);
	}

	public void marcarComoPreconci() throws BaseException {
		DBArchLoteConciDet.marcarComoPreconci(this, this.getSesion());
	}

	public void marcarComoPerdido() throws BaseException {
		DBArchLoteConciDet.marcarComoPerdido(this, this.getSesion());
	}

	public void marcarComoNoPerdido() throws BaseException {
		DBArchLoteConciDet.marcarComoNoPerdido(this, this.getSesion());
	}

	public void marcarComoNoPreconci() throws BaseException {
		DBArchLoteConciDet.marcarComoNoPreconci(this, this.getSesion());
	}

	public static List getMarcadosPorEmpresaUsu(EmpresaConciTar empresa, Usuario usuario, ISesion aSesion) throws BaseException {
		return DBArchLoteConciDet.getMarcadosPorEmpresaUsu(empresa, usuario, aSesion);
	}

	public static void generarPreconciliacion(ArchLoteConciDet archLoteConciDet, Integer nroConciliacion, ISesion aSesion)
			throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put("NRO_CONCILIACION", nroConciliacion);
		DBArchLoteConciDet.generarPreconciliacion(archLoteConciDet, condiciones, aSesion);
	}

	public void generarPreconciliacion(Integer nroConciliacion, CabConciAutomatica cabConciAut, boolean dudoso) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put("NRO_CONCILIACION", nroConciliacion);
		if (cabConciAut != null)
			condiciones.put(CabConciAutomatica.NICKNAME, cabConciAut);
		condiciones.put("DUDOSO", new Boolean(dudoso));
		DBArchLoteConciDet.generarPreconciliacion(this, condiciones, this.getSesion());
	}

	public static List getPreconciliadosPorEmpresaUsu(EmpresaConciTar empresa, Usuario usuario, ISesion aSesion) throws BaseException {
		return DBArchLoteConciDet.getPreconciliadosPorEmpresaUsu(empresa, usuario, aSesion);
	}

	public void marcarComoConciliado() throws BaseException {
		ObjetoLogico.getObjects(ArchLoteConciDet.NICKNAME, DBArchLoteConciDet.MARCAR_COMO_CONCILIADO, this, null, this.getSesion());
	}

	public static ArchLoteConciDet getArchLoteConciDet(EmpresaConciTar empresa, String tipoOperacion, String tipoTarjeta,
			java.util.Date fechaOrigen, String tarjeta, Integer nroTarjeta, Double monto, Integer nroLote, Integer diasTolerancia,
			ISesion aSesion) throws BaseException {

		return DBArchLoteConciDet.getArchLoteConciDet(empresa, tipoOperacion, tipoTarjeta, fechaOrigen, tarjeta, nroTarjeta, monto,
				nroLote, diasTolerancia, aSesion);
	}

	public static ArchLoteConciDet getArchLoteConciDet(EmpresaConciTar empresa, String tipoOperacion, String tipoTarjeta,
			java.util.Date fechaOrigen, String tarjeta, Integer nroTarjeta, Double monto, Integer diasTolerancia, ISesion aSesion)
			throws BaseException {

		return DBArchLoteConciDet.getArchLoteConciDet(empresa, tipoOperacion, tipoTarjeta, fechaOrigen, tarjeta, nroTarjeta, monto,
				diasTolerancia, aSesion);
	}

	public static ArchLoteConciDet getArchLoteConciDet(EmpresaConciTar empresa, String tipoOperacion, String tipoTarjeta,
			java.util.Date fechaOrigen, String tarjeta, Double monto, Integer diasTolerancia, ISesion aSesion) throws BaseException {

		return DBArchLoteConciDet.getArchLoteConciDet(empresa, tipoOperacion, tipoTarjeta, fechaOrigen, tarjeta, monto, diasTolerancia,
				aSesion);
	}

	public static List getPreconciliadosPorEmpresayNroConci(EmpresaConciTar empresa, Integer nroConciliacion, ISesion aSesion)
			throws BaseException {
		return DBArchLoteConciDet.getPreconciliadosPorEmpresayNroConci(empresa, nroConciliacion, aSesion);
	}

	public boolean anularConfirmacion(List cuponesPOSNETS, List cuponesTarjetas) throws BaseException {

		// Validaciones
		CalculadorMoney totalizadorPOSNET = new CalculadorMoney(new Money(0));
		CalculadorMoney totalizadorTARJETA = new CalculadorMoney(new Money(0));

		this.supportRefresh();

		if (!this.isActivo())
			throw new ExceptionValidation(null, "El movimiento " + this.getDescripcion() + "se encuentra anulado");

		if (!this.isPreconci())
			throw new ExceptionValidation(null, "El movimiento " + this.getDescripcion() + " NO se encuentra conciliado");

		if (this.getNroConciliacion() == null)
			throw new ExceptionValidation(null, "El movimiento " + this.getDescripcion() + " NO se encuentra conciliado");

		if (!this.isConciliado())
			throw new ExceptionValidation(null, "El movimiento " + this.getDescripcion() + " NO se encuentra confirmado");

		int nroConciliacion = -1;
		if (this.getNroConciliacion() != null)
			nroConciliacion = this.getNroConciliacion();

		// Desconciliar el Movimiento

		totalizadorPOSNET.sumar(new Money(this.getMonto()));

		this.setConciliado(false);
		this.setFecConciliado(null);
		this.save();

		cuponesPOSNETS.add(ArchLoteConciDet.findByOidProxy(this.getOIDInteger(), this.getSesion()));

		// Desconciliar otros movimientos que tengan ese número de conciliacion
		Iterator iterArchLoteConciDet = ArchLoteConciDet.getConciliadosPorEmpresayNroConci(this.getEmpresa(), nroConciliacion,
				this.getSesion()).iterator();
		while (iterArchLoteConciDet.hasNext()) {
			ArchLoteConciDet archLoteConciDet = (ArchLoteConciDet) iterArchLoteConciDet.next();
			if (archLoteConciDet.getOID() != this.getOID()) {
				if (!archLoteConciDet.isActivo())
					throw new ExceptionValidation(null, "El movimiento POSNET " + archLoteConciDet.getDescripcion()
							+ "se encuentra anulado");
				if (!archLoteConciDet.isPreconci())
					throw new ExceptionValidation(null, "El movimiento POSNET " + archLoteConciDet.getDescripcion()
							+ " NO se encuentra conciliado");
				if (archLoteConciDet.getNroConciliacion() == null)
					throw new ExceptionValidation(null, "El movimiento POSNET " + archLoteConciDet.getDescripcion()
							+ " NO se encuentra conciliado");

				archLoteConciDet.setConciliado(false);
				archLoteConciDet.setFecConciliado(null);

				totalizadorPOSNET.sumar(new Money(archLoteConciDet.getMonto()));

				archLoteConciDet.save();
				cuponesPOSNETS.add(ArchLoteConciDet.findByOidProxy(archLoteConciDet.getOIDInteger(), this.getSesion()));
			}
		}

		// Buscar los Movimientos en las Tarjertas con ese Número de
		// Conciliacion
		Iterator iterDetTarConciEnt = DetTarConciEnt.getTarjConciliadas(this.getEmpresa(), nroConciliacion, this.getSesion()).iterator();
		while (iterDetTarConciEnt.hasNext()) {
			DetTarConciEnt detTarConciEnt = (DetTarConciEnt) iterDetTarConciEnt.next();
			if (!detTarConciEnt.isActivo())
				throw new ExceptionValidation(null, "El movimiento TARJETA " + detTarConciEnt.getDesc() + "se encuentra anulado");
			if (!detTarConciEnt.isPreConciliado())
				throw new ExceptionValidation(null, "El movimiento TARJETA " + detTarConciEnt.getDesc() + " NO se encuentra conciliado");
			if (detTarConciEnt.getNroConciliacion() == null)
				throw new ExceptionValidation(null, "El movimiento TARJETA " + detTarConciEnt.getDesc() + " NO se encuentra conciliado");
			detTarConciEnt.setConciliado(false);
			detTarConciEnt.setFecConciliado(null);
			totalizadorTARJETA.sumar(detTarConciEnt.getImporte());
			detTarConciEnt.save();
			cuponesTarjetas.add(DetTarConciEnt.findByOidProxy(detTarConciEnt.getOIDInteger(), this.getSesion()));
		}

		// Verificar que la anulacion de la conciliacion coincidad los importes
		// del POSNET y las tarjetas

		totalizadorPOSNET.restar(totalizadorTARJETA.getResultMoney());
		if (totalizadorPOSNET.getResultMoney().doubleValue() != 0)
			throw new ExceptionValidation(null, "No se puede anular la conciliación debido a que existen una diferencia de "
					+ totalizadorPOSNET.getResultMoney().doubleValue() + " entre los Mov. del POSNET y las TARJETAS");

		return true;
	}

	public boolean anularPreconciliacion(List cuponesPOSNETS, List cuponesTarjetas) throws BaseException {

		// Validaciones
		CalculadorMoney totalizadorPOSNET = new CalculadorMoney(new Money(0));
		CalculadorMoney totalizadorTARJETA = new CalculadorMoney(new Money(0));

		this.supportRefresh();

		if (!this.isActivo())
			throw new ExceptionValidation(null, "El movimiento " + this.getDescripcion() + "se encuentra anulado");

		if (!this.isPreconci())
			throw new ExceptionValidation(null, "El movimiento " + this.getDescripcion() + " NO se encuentra conciliado");

		if (this.getNroConciliacion() == null)
			throw new ExceptionValidation(null, "El movimiento " + this.getDescripcion() + " NO se encuentra conciliado");

		int nroConciliacion = -1;
		if (this.getNroConciliacion() != null)
			nroConciliacion = this.getNroConciliacion();

		// Desconciliar el Movimiento

		totalizadorPOSNET.sumar(new Money(this.getMonto()));

		this.setPreconci(false);
		this.setFecPreconci(null);
		this.setPreconciDudoso(false);
		this.setCabConciAut(null);
		this.setNroConciliacion(null);
		this.setConciliado(false);
		this.setFecConciliado(null);
		this.setMarcarPreconci(false);
		this.save();

		cuponesPOSNETS.add(ArchLoteConciDet.findByOidProxy(this.getOIDInteger(), this.getSesion()));

		// Desconciliar otros movimientos que tengan ese número de conciliacion
		Iterator iterArchLoteConciDet = ArchLoteConciDet.getConciliadosPorEmpresayNroConci(this.getEmpresa(), nroConciliacion,
				this.getSesion()).iterator();
		while (iterArchLoteConciDet.hasNext()) {
			ArchLoteConciDet archLoteConciDet = (ArchLoteConciDet) iterArchLoteConciDet.next();
			if (archLoteConciDet.getOID() != this.getOID()) {
				if (!archLoteConciDet.isActivo())
					throw new ExceptionValidation(null, "El movimiento POSNET " + archLoteConciDet.getDescripcion()
							+ "se encuentra anulado");
				if (!archLoteConciDet.isPreconci())
					throw new ExceptionValidation(null, "El movimiento POSNET " + archLoteConciDet.getDescripcion()
							+ " NO se encuentra conciliado");
				if (archLoteConciDet.getNroConciliacion() == null)
					throw new ExceptionValidation(null, "El movimiento POSNET " + archLoteConciDet.getDescripcion()
							+ " NO se encuentra conciliado");
				archLoteConciDet.setPreconci(false);
				archLoteConciDet.setFecPreconci(null);
				archLoteConciDet.setPreconciDudoso(false);
				archLoteConciDet.setCabConciAut(null);
				archLoteConciDet.setNroConciliacion(null);
				archLoteConciDet.setConciliado(false);
				archLoteConciDet.setFecConciliado(null);
				archLoteConciDet.setMarcarPreconci(false);

				totalizadorPOSNET.sumar(new Money(archLoteConciDet.getMonto()));

				archLoteConciDet.save();
				cuponesPOSNETS.add(ArchLoteConciDet.findByOidProxy(archLoteConciDet.getOIDInteger(), this.getSesion()));
			}
		}

		// Buscar los Movimientos en las Tarjertas con ese Número de
		// Conciliacion
		Iterator iterDetTarConciEnt = DetTarConciEnt.getTarjConciliadas(this.getEmpresa(), nroConciliacion, this.getSesion()).iterator();
		while (iterDetTarConciEnt.hasNext()) {
			DetTarConciEnt detTarConciEnt = (DetTarConciEnt) iterDetTarConciEnt.next();
			if (!detTarConciEnt.isActivo())
				throw new ExceptionValidation(null, "El movimiento TARJETA " + detTarConciEnt.getDesc() + "se encuentra anulado");
			if (!detTarConciEnt.isPreConciliado())
				throw new ExceptionValidation(null, "El movimiento TARJETA " + detTarConciEnt.getDesc() + " NO se encuentra conciliado");
			if (detTarConciEnt.getNroConciliacion() == null)
				throw new ExceptionValidation(null, "El movimiento TARJETA " + detTarConciEnt.getDesc() + " NO se encuentra conciliado");
			detTarConciEnt.setPreConciliado(false);
			detTarConciEnt.setFecPreconci(null);
			detTarConciEnt.setPreconciDudoso(false);
			detTarConciEnt.setCabConciAut(null);
			detTarConciEnt.setNroConciliacion(null);
			detTarConciEnt.setConciliado(false);
			detTarConciEnt.setFecConciliado(null);
			detTarConciEnt.setMarcarPreconci(false);
			totalizadorTARJETA.sumar(detTarConciEnt.getImporte());
			detTarConciEnt.save();
			cuponesTarjetas.add(DetTarConciEnt.findByOidProxy(detTarConciEnt.getOIDInteger(), this.getSesion()));
		}

		// Verificar que la anulacion de la conciliacion coincidad los importes
		// del POSNET y las tarjetas

		totalizadorPOSNET.restar(totalizadorTARJETA.getResultMoney());
		if (totalizadorPOSNET.getResultMoney().doubleValue() != 0)
			throw new ExceptionValidation(null, "No se puede anular la conciliación debido a que existen una diferencia de "
					+ totalizadorPOSNET.getResultMoney().doubleValue() + " entre los Mov. del POSNET y las TARJETAS");

		return true;
	}

	public boolean anulacionConciliacionAutomatica(List cuponesPOSNETS, List cuponesTarjetas) throws BaseException {

		// Validaciones
		CalculadorMoney totalizadorPOSNET = new CalculadorMoney(new Money(0));
		CalculadorMoney totalizadorTARJETA = new CalculadorMoney(new Money(0));

		this.supportRefresh();

		if (!this.isActivo())
			throw new ExceptionValidation(null, "El movimiento " + this.getDescripcion() + "se encuentra anulado");

		if (!this.isPreconci())
			throw new ExceptionValidation(null, "El movimiento " + this.getDescripcion() + " NO se encuentra conciliado");

		if (this.getNroConciliacion() == null)
			throw new ExceptionValidation(null, "El movimiento " + this.getDescripcion() + " NO se encuentra conciliado");

		if (this.getCabConciAut() == null)
			throw new ExceptionValidation(null, "El movimiento seleccionado no corresponde a una conciliación Automática");

		CabConciAutomatica cabConciAutomatica = CabConciAutomatica.findByOidProxy(this.getCabConciAut().getOIDInteger(), this.getSesion());
		cabConciAutomatica.delete();
		cabConciAutomatica.save();

		totalizadorPOSNET.sumar(new Money(this.getMonto()));

		this.setPreconci(false);
		this.setFecPreconci(null);
		this.setPreconciDudoso(false);
		this.setCabConciAut(null);
		this.setNroConciliacion(null);
		this.setConciliado(false);
		this.setFecConciliado(null);
		this.setMarcarPreconci(false);
		this.save();

		cuponesPOSNETS.add(ArchLoteConciDet.findByOidProxy(this.getOIDInteger(), this.getSesion()));

		// Desconciliar otros movimientos que tengan ese número de conciliacion
		Iterator iterArchLoteConciDet = ArchLoteConciDet.getConciliadosPorConciAutomatica(this.getEmpresa(), cabConciAutomatica,
				this.getSesion()).iterator();

		while (iterArchLoteConciDet.hasNext()) {
			ArchLoteConciDet archLoteConciDet = (ArchLoteConciDet) iterArchLoteConciDet.next();
			if (archLoteConciDet.getOID() != this.getOID()) {

				if (!archLoteConciDet.isActivo())
					throw new ExceptionValidation(null, "El movimiento POSNET " + archLoteConciDet.getDescripcion()
							+ "se encuentra anulado");
				if (!archLoteConciDet.isPreconci())
					throw new ExceptionValidation(null, "El movimiento POSNET " + archLoteConciDet.getDescripcion()
							+ " NO se encuentra conciliado");
				if (archLoteConciDet.getNroConciliacion() == null)
					throw new ExceptionValidation(null, "El movimiento POSNET " + archLoteConciDet.getDescripcion()
							+ " NO se encuentra conciliado");
				if (archLoteConciDet.getCabConciAut() == null)
					throw new ExceptionValidation(null, "El movimiento POSNET " + archLoteConciDet.getDescripcion()
							+ " NO se encuentra procesado para una conciliación automática");

				archLoteConciDet.setPreconci(false);
				archLoteConciDet.setFecPreconci(null);
				archLoteConciDet.setPreconciDudoso(false);
				archLoteConciDet.setCabConciAut(null);
				archLoteConciDet.setNroConciliacion(null);
				archLoteConciDet.setConciliado(false);
				archLoteConciDet.setFecConciliado(null);
				archLoteConciDet.setMarcarPreconci(false);

				totalizadorPOSNET.sumar(new Money(archLoteConciDet.getMonto()));

				archLoteConciDet.save();
				cuponesPOSNETS.add(ArchLoteConciDet.findByOidProxy(archLoteConciDet.getOIDInteger(), this.getSesion()));
			}
		}

		// Buscar los Movimientos en las Tarjertas con ese Número de
		// Conciliacion
		Iterator iterDetTarConciEnt = DetTarConciEnt.getTarjConciliadasAutomaticamente(this.getEmpresa(), cabConciAutomatica,
				this.getSesion()).iterator();

		while (iterDetTarConciEnt.hasNext()) {
			DetTarConciEnt detTarConciEnt = (DetTarConciEnt) iterDetTarConciEnt.next();
			if (!detTarConciEnt.isActivo())
				throw new ExceptionValidation(null, "El movimiento TARJETA " + detTarConciEnt.getDesc() + "se encuentra anulado");
			if (!detTarConciEnt.isPreConciliado())
				throw new ExceptionValidation(null, "El movimiento TARJETA " + detTarConciEnt.getDesc() + " NO se encuentra conciliado");
			if (detTarConciEnt.getNroConciliacion() == null)
				throw new ExceptionValidation(null, "El movimiento TARJETA " + detTarConciEnt.getDesc() + " NO se encuentra conciliado");
			if (detTarConciEnt.getCabConciAut() == null)
				throw new ExceptionValidation(null, "El movimiento TARJETA " + detTarConciEnt.getDesc()
						+ " NO se encuentra procesado por una conciliación automática");

			detTarConciEnt.setPreConciliado(false);
			detTarConciEnt.setFecPreconci(null);
			detTarConciEnt.setPreconciDudoso(false);
			detTarConciEnt.setCabConciAut(null);
			detTarConciEnt.setNroConciliacion(null);
			detTarConciEnt.setConciliado(false);
			detTarConciEnt.setFecConciliado(null);
			detTarConciEnt.setMarcarPreconci(false);

			totalizadorTARJETA.sumar(detTarConciEnt.getImporte());
			detTarConciEnt.save();
			cuponesTarjetas.add(DetTarConciEnt.findByOidProxy(detTarConciEnt.getOIDInteger(), this.getSesion()));

		}

		// Verificar que la anulacion de la conciliacion coincidad los importes
		// del POSNET y las tarjetas

		totalizadorPOSNET.restar(totalizadorTARJETA.getResultMoney());
		if (totalizadorPOSNET.getResultMoney().doubleValue() != 0)
			throw new ExceptionValidation(null, "No se puede anular la conciliación debido a que existen una diferencia de "
					+ totalizadorPOSNET.getResultMoney().doubleValue() + " entre los Mov. del POSNET y las TARJETAS");

		return true;
	}

	public static List getConciliadosPorEmpresayNroConci(EmpresaConciTar empresa, Integer nroConciliacion, ISesion aSesion)
			throws BaseException {
		return DBArchLoteConciDet.getConciliadosPorEmpresayNroConci(empresa, nroConciliacion, aSesion);
	}

	public static List getConciliadosPorConciAutomatica(EmpresaConciTar empresa, CabConciAutomatica cabConciAut, ISesion aSesion)
			throws BaseException {
		return DBArchLoteConciDet.getConciliadosPorConciAutomatica(empresa, cabConciAut, aSesion);
	}

	public void marcarAsientoParaCobranza() throws BaseException {

		if (this.isMarcaAsiACobrar())
			throw new ExceptionValidation(null, "El cupon ya se encuentra marcado para Asiento de Cobranza.");

		if (!this.isActivo())
			throw new ExceptionValidation(null, "El cupon se encuentra dado de baja.");

		if (!this.isPresentado())
			throw new ExceptionValidation(null, "El cupon debe estar marcado como presentado.");

		DBArchLoteConciDet.marcarAsientoParaCobranza(this, this.getSesion());
	}

	public void marcarAsientoParaLiquidacion() throws BaseException {

		if (this.isMarcaAsiLiq())
			throw new ExceptionValidation(null, "El cupon ya se encuentra marcado para Asiento de Liquidación.");

		if (!this.isActivo())
			throw new ExceptionValidation(null, "El cupon se encuentra dado de baja.");

		DBArchLoteConciDet.marcarAsientoParaLiquidacion(this, this.getSesion());
	}

	public void desmarcarAsientoParaCobranza() throws BaseException {

		if (!this.isMarcaAsiACobrar())
			throw new ExceptionValidation(null, "El cupon ya se encuentra desmarcado.");

		if (!this.isActivo())
			throw new ExceptionValidation(null, "El cupon se encuentra dado de baja.");

		if (this.isContaAsientoACobrar())
			throw new ExceptionValidation(null,
					"El cupon no se puede desmarcar debido a que se encuentra contabilizado el asiento de cobranza.");

		DBArchLoteConciDet.desmarcarAsientoParaCobranza(this, this.getSesion());
	}

	public void desmarcarAsientoParaLiquidacion() throws BaseException {

		if (!this.isMarcaAsiLiq())
			throw new ExceptionValidation(null, "El cupon ya se encuentra desmarcado.");

		if (!this.isActivo())
			throw new ExceptionValidation(null, "El cupon se encuentra dado de baja.");

		if (this.isContaAsiLiq())
			throw new ExceptionValidation(null,
					"El cupon no se puede desmarcar debido a que se encuentra contabilizado el asiento de liquidación.");

		DBArchLoteConciDet.desmarcarAsientoParaLiquidacion(this, this.getSesion());
	}

	public static void desmarcarAsientoParaCobranza(ArchLoteConciDet archLoteConciDet, ISesion aSesion) throws BaseException {
		ObjetoLogico.getObjects(ArchLoteConciDet.NICKNAME, DBArchLoteConciDet.DESMARCAR_ASI_PARA_COB, archLoteConciDet, null, aSesion);
	}

	public String getEstadoAsientoCobranza() throws BaseException {
		String estado = "";
		if ((this.isContaAsientoACobrar() != null) && (this.isContaAsientoACobrar().booleanValue()))
			return "Contabilizado";
		else if ((this.isMarcaAsiACobrar() != null) && (this.isMarcaAsiACobrar().booleanValue()))
			return "Marcado";
		return estado;
	}

	public String getEstadoAsientoLiquidacion() throws BaseException {
		String estado = "";
		if ((this.isContaAsiLiq() != null) && (this.isContaAsiLiq().booleanValue()))
			return "Contabilizado";
		else if ((this.isMarcaAsiLiq() != null) && (this.isMarcaAsiLiq().booleanValue()))
			return "Marcado";
		return estado;
	}

	public static List getArchLoteDetMarcadosAsiACobNoConta(EmpresaConciTar empresa, boolean soloMisMarcados,ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(EmpresaConciTar.NICKNAME, empresa);
		if (soloMisMarcados)
			condiciones.put("SOLO_MIS_MARCADOS", "");
		return DBArchLoteConciDet.getArchLoteDetMarcadosAsiACobNoConta(condiciones, aSesion);
	}

	public static List getArchLoteDetContaConSegunNroAsi(Integer nroAsiCobranza, ISesion aSesion) throws BaseException {
		return DBArchLoteConciDet.getArchLoteDetContaConSegunNroAsi(nroAsiCobranza, aSesion);
	}

	public static List getArchLoteDetNoContaLiq(EmpresaConciTar empresa, CabModeloLiq cabModeloLiq, boolean misMarcados ,ISesion aSesion) throws BaseException {
		return DBArchLoteConciDet.getArchLoteDetNoContaLiq(empresa, cabModeloLiq, misMarcados , aSesion);
	}

	public static List getArchLoteDetAsiLiq(CabAsiLiquiTarj cabAsiLiquiTarj, ISesion aSesion) throws BaseException {
		return DBArchLoteConciDet.getArchLoteDetAsiLiq(cabAsiLiquiTarj, aSesion);
	}

	public static List getArchLoteDetContaLiqSegunNroAsi(Integer nroAsiLiquidacion, ISesion aSesion) throws BaseException {
		return DBArchLoteConciDet.getArchLoteDetContaLiqSegunNroAsi(nroAsiLiquidacion, aSesion);
	}

	public static List getArchLoteDetByAsiCob(CabAsiTarjACobrar cabAsiTarjACobrar, ISesion aSesion) throws BaseException {
		return DBArchLoteConciDet.getArchLoteDetByAsiCob(cabAsiTarjACobrar, aSesion);
	}

	public static List getArchLoteDetByAsiLiq(CabAsiLiquiTarj aCabAsiLiquiTarj, ISesion aSesion) throws BaseException {
		return DBArchLoteConciDet.getArchLoteDetByAsiLiq(aCabAsiLiquiTarj, aSesion);
	}

}
