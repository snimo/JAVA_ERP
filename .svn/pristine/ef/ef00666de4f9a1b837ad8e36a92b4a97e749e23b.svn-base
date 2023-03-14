package com.srn.erp.ctasACobrar.bm;

import java.util.List;

import com.srn.erp.ctacte.bm.TipoCtaCteClie;
import com.srn.erp.ctasACobrar.da.DBAplicClieVto;
import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.ventas.bm.Sujeto;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.applicarionServer.bm.Varios.Money;
import framework.applicarionServer.bm.Varios.ValorCotizacion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class AplicClieVto extends ObjetoLogico {

	public AplicClieVto() {
	}

	public static String NICKNAME = "cac.AplicClieVto";

	private ComproCab comprobante;
	private Sujeto sujeto;
	private Moneda moneda;
	private Money importe;
	private java.util.Date imputac;
	private java.util.Date emision;
	private Integer dias_base;
	private Integer dias_vto;
	private TranClieVto tran_vto;
	private ComproCab compro_ori;
	private TranClieVto tran_vto_ori;
	private ValorCotizacion cotiz_mon_ori;
	private ValorCotizacion cotiz_mon_ext1;
	private ValorCotizacion cotiz_mon_ext2;
	private TipoCtaCteClie tipo_cta_cte;

	public ComproCab getComprobante() throws BaseException {
		supportRefresh();
		return comprobante;
	}

	public void setComprobante(ComproCab aComprobante) {
		this.comprobante = aComprobante;
	}

	public Sujeto getSujeto() throws BaseException {
		supportRefresh();
		return sujeto;
	}

	public void setSujeto(Sujeto aSujeto) {
		this.sujeto = aSujeto;
	}

	public Moneda getMoneda() throws BaseException {
		supportRefresh();
		return moneda;
	}

	public void setMoneda(Moneda aMoneda) {
		this.moneda = aMoneda;
	}

	public Money getImporte() throws BaseException {
		supportRefresh();
		return importe;
	}

	public void setImporte(Money aImporte) {
		this.importe = aImporte;
	}

	public java.util.Date getImputac() throws BaseException {
		supportRefresh();
		return imputac;
	}

	public void setImputac(java.util.Date aImputac) {
		this.imputac = aImputac;
	}

	public java.util.Date getEmision() throws BaseException {
		supportRefresh();
		return emision;
	}

	public void setEmision(java.util.Date aEmision) {
		this.emision = aEmision;
	}

	public Integer getDias_base() throws BaseException {
		supportRefresh();
		return dias_base;
	}

	public void setDias_base(Integer aDias_base) {
		this.dias_base = aDias_base;
	}

	public Integer getDias_vto() throws BaseException {
		supportRefresh();
		return dias_vto;
	}

	public void setDias_vto(Integer aDias_vto) {
		this.dias_vto = aDias_vto;
	}

	public TranClieVto getTran_vto() throws BaseException {
		supportRefresh();
		return tran_vto;
	}

	public void setTran_vto(TranClieVto aTran_vto) {
		this.tran_vto = aTran_vto;
	}

	public ComproCab getCompro_ori() throws BaseException {
		supportRefresh();
		return compro_ori;
	}

	public void setCompro_ori(ComproCab aCompro_ori) {
		this.compro_ori = aCompro_ori;
	}

	public TranClieVto getTran_vto_ori() throws BaseException {
		supportRefresh();
		return tran_vto_ori;
	}

	public void setTran_vto_ori(TranClieVto aTran_vto_ori) {
		this.tran_vto_ori = aTran_vto_ori;
	}

	public ValorCotizacion getCotiz_mon_ori() throws BaseException {
		supportRefresh();
		return cotiz_mon_ori;
	}

	public void setCotiz_mon_ori(ValorCotizacion aCotiz_mon_ori) {
		this.cotiz_mon_ori = aCotiz_mon_ori;
	}

	public ValorCotizacion getCotiz_mon_ext1() throws BaseException {
		supportRefresh();
		return cotiz_mon_ext1;
	}

	public void setCotiz_mon_ext1(ValorCotizacion aCotiz_mon_ext1) {
		this.cotiz_mon_ext1 = aCotiz_mon_ext1;
	}

	public ValorCotizacion getCotiz_mon_ext2() throws BaseException {
		supportRefresh();
		return cotiz_mon_ext2;
	}

	public void setCotiz_mon_ext2(ValorCotizacion aCotiz_mon_ext2) {
		this.cotiz_mon_ext2 = aCotiz_mon_ext2;
	}

	public TipoCtaCteClie getTipo_cta_cte() throws BaseException {
		supportRefresh();
		return tipo_cta_cte;
	}

	public void setTipo_cta_cte(TipoCtaCteClie aTipo_cta_cte) {
		this.tipo_cta_cte = aTipo_cta_cte;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static AplicClieVto findByOid(Integer oid, ISesion aSesion)
			throws BaseException {
		return (AplicClieVto) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static AplicClieVto findByCodigo(String codigo, ISesion aSesion)
			throws BaseException {
		return (AplicClieVto) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(comprobante, "Debe ingresar el comprobante");
		Validar.noNulo(sujeto, "Debe ingresar el Sujeto");
		Validar.noNulo(moneda, "Debe ingresar la Moneda");
		Validar.noNulo(importe, "Debe ingresar el Importe");
	}

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean isActivo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static List getAplicacionesClienteVto(AplicacionComproClie aplicacionComproClie,
	          ISesion aSesion) throws BaseException {
		  return DBAplicClieVto.getAplicacionesClienteVto(aplicacionComproClie,aSesion);
	}
	
	public static List getAplicacionesActivasCompro(ComproCab aComproCab, ISesion aSesion) throws BaseException {
		return DBAplicClieVto.getAplicacionesActivasCompro(aComproCab,aSesion);
	}

	public static List getAplicacionesActivasDelCompro(ComproCab aComproCab, ISesion aSesion) throws BaseException {
		return DBAplicClieVto.getAplicacionesActivasDelCompro(aComproCab,aSesion);
	}
	
	

}
