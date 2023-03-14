package com.srn.erp.tesoreria.bm;

import java.util.Date;
import java.util.List;

import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.tesoreria.da.DBMovimientoCaja;
import com.srn.erp.ventas.bm.Sujeto;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.applicarionServer.bm.Varios.Money;
import framework.applicarionServer.bm.Varios.ValorCotizacion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;

public class MovimientoCaja extends ObjetoLogico {

	public MovimientoCaja() {
	}

	public static String NICKNAME = "te.MovimientoCaja";

	private Caja caja;
	private ComproCab comprobante;
	private Date fechaCaja;
	private Valor valor;
	private Integer signo;
	private Money importe;
	private Moneda moneda;
	private TipoValor tipoValor;
	private String compoTipoValor;
	private ValorCotizacion cotizacion;
	private Money entrada;
	private Money salida;
	private Boolean activo;
	private Date fechaReal;
	private String hora;
	private Usuario usuario;
	private Sujeto sujeto;

	public Date getFechaReal() throws BaseException {
		supportRefresh();
		return fechaReal;
	}

	public void setFechaReal(Date aFecha) throws BaseException {
		this.fechaReal = aFecha;
	}
	
	public Sujeto getSujeto() throws BaseException {
		supportRefresh();
		return sujeto;
	}

	public void setSujeto(Sujeto aSujeto) throws BaseException {
		this.sujeto = aSujeto;
	}
	

	public String getHora() throws BaseException {
		supportRefresh();
		return hora;
	}

	public void setHora(String aHora) throws BaseException {
		this.hora = aHora;
	}

	public Usuario getUsuario() throws BaseException {
		supportRefresh();
		return usuario;
	}

	public void setUsuario(Usuario aUsuario) throws BaseException {
		this.usuario = aUsuario;
	}

	public Caja getCaja() throws BaseException {
		supportRefresh();
		return caja;
	}

	public void setCaja(Caja aCaja) {
		this.caja = aCaja;
	}

	public ComproCab getComprobante() throws BaseException {
		supportRefresh();
		return comprobante;
	}

	public void setComprobante(ComproCab aComprobante) {
		this.comprobante = aComprobante;
	}

	public Date getFechacaja() throws BaseException {
		supportRefresh();
		return fechaCaja;
	}

	public void setFechacaja(Date aFechacaja) {
		this.fechaCaja = aFechacaja;
	}

	public Valor getValor() throws BaseException {
		supportRefresh();
		return valor;
	}

	public void setValor(Valor aValor) {
		this.valor = aValor;
	}

	public Integer getSigno() throws BaseException {
		supportRefresh();
		return signo;
	}

	public void setSigno(Integer aSigno) {
		this.signo = aSigno;
	}

	public Money getImporte() throws BaseException {
		supportRefresh();
		return importe;
	}

	public void setImporte(Money aImporte) {
		this.importe = aImporte;
	}

	public Moneda getMoneda() throws BaseException {
		supportRefresh();
		return moneda;
	}

	public void setMoneda(Moneda aMoneda) {
		this.moneda = aMoneda;
	}

	public TipoValor getTipovalor() throws BaseException {
		supportRefresh();
		return tipoValor;
	}

	public void setTipovalor(TipoValor aTipovalor) {
		this.tipoValor = aTipovalor;
	}

	public String getCompotipovalor() throws BaseException {
		supportRefresh();
		return compoTipoValor;
	}

	public void setCompotipovalor(String aCompotipovalor) {
		this.compoTipoValor = aCompotipovalor;
	}

	public ValorCotizacion getCotizacion() throws BaseException {
		supportRefresh();
		return cotizacion;
	}

	public void setCotizacion(ValorCotizacion aCotizacion) {
		this.cotizacion = aCotizacion;
	}

	public Money getEntrada() throws BaseException {
		supportRefresh();
		return entrada;
	}

	public void setEntrada(Money aEntrada) {
		this.entrada = aEntrada;
	}

	public Money getSalida() throws BaseException {
		supportRefresh();
		return salida;
	}

	public void setSalida(Money aSalida) {
		this.salida = aSalida;
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

	public static MovimientoCaja findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (MovimientoCaja) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static MovimientoCaja findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (MovimientoCaja) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
	}

	/**
	 * getDescripcion
	 * 
	 * @return String
	 */
	public String getDescripcion() {
		return "";
	}

	/**
	 * getCodigo
	 * 
	 * @return String
	 */
	public String getCodigo() {
		return "";
	}

	public static List getMovCajaFecDesdeHasta(Caja caja, TipoValor tipoValor, Date fechaDesde, Date fechaHasta, ISesion aSesion)
			throws BaseException {
		return DBMovimientoCaja.getMovCajaFecDesdeHasta(caja, tipoValor, fechaDesde, fechaHasta, aSesion);
	}

	public static List getMovCajaValor(Valor valor, ISesion aSesion) throws BaseException {

		return DBMovimientoCaja.getMovCajaValor(valor, aSesion);
	}
	
	public static List getMovCajaByCondiciones(HashTableDatos condiciones, ISesion aSesion) throws BaseException {
		return DBMovimientoCaja.getMovCajaByCondiciones(condiciones, aSesion);
	}
	
	

}
