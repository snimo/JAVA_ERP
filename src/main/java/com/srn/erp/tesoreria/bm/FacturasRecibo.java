package com.srn.erp.tesoreria.bm;

import java.util.List;

import com.srn.erp.ctasACobrar.bm.TranClieVto;
import com.srn.erp.tesoreria.da.DBFacturasRecibo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Varios.Money;
import framework.applicarionServer.bm.Varios.ValorCotizacion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class FacturasRecibo extends ObjetoLogico {

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

	public FacturasRecibo() {
	}

	public static String NICKNAME = "te.FacturasRecibo";

	private Recibo recibo;

	private Money impo_mon_ori;

	private Money impo_mon_loc;

	private Money saldo_mon_ori;

	private Money impo_dto_mon_ori;

	private Money saldo_mon_loc;

	private Money impo_dto_mon_loc;

	private Money impo_cob_mon_ori;

	private Money impo_cob_mon_loc;
	
	private Money impo_cob_mon_rec;

	private ValorCotizacion cotizacion;
	
	private TranClieVto oid_tran_vto;

	public Recibo getRecibo() throws BaseException {
		supportRefresh();
		return recibo;
	}

	public void setRecibo(Recibo aRecibo) {
		this.recibo = aRecibo;
	}
	
	public TranClieVto getTranClieVto() throws BaseException {
		supportRefresh();
		return this.oid_tran_vto;
	}

	public void setTranClieVto(TranClieVto aTranClieVto) {
		this.oid_tran_vto = aTranClieVto;
	}
	
	
	public Money getImpoCobMonRec() throws BaseException {
		supportRefresh();
		return impo_cob_mon_rec;
	}

	public void setImpoCobMonRec(Money aImpoCobMonRec) {
		this.impo_cob_mon_rec = aImpoCobMonRec;
	}	

		public Money getImpo_mon_ori() throws BaseException {
		supportRefresh();
		return impo_mon_ori;
	}

	public void setImpo_mon_ori(Money aImpo_mon_ori) {
		this.impo_mon_ori = aImpo_mon_ori;
	}

	public Money getImpo_mon_loc() throws BaseException {
		supportRefresh();
		return impo_mon_loc;
	}

	public void setImpo_mon_loc(Money aImpo_mon_loc) {
		this.impo_mon_loc = aImpo_mon_loc;
	}

	public Money getSaldo_mon_ori() throws BaseException {
		supportRefresh();
		return saldo_mon_ori;
	}

	public void setSaldo_mon_ori(Money aSaldo_mon_ori) {
		this.saldo_mon_ori = aSaldo_mon_ori;
	}

	public Money getImpo_dto_mon_ori() throws BaseException {
		supportRefresh();
		return impo_dto_mon_ori;
	}

	public void setImpo_dto_mon_ori(Money aImpo_dto_mon_ori) {
		this.impo_dto_mon_ori = aImpo_dto_mon_ori;
	}

	public Money getSaldo_mon_loc() throws BaseException {
		supportRefresh();
		return saldo_mon_loc;
	}

	public void setSaldo_mon_loc(Money aSaldo_mon_loc) {
		this.saldo_mon_loc = aSaldo_mon_loc;
	}

	public Money getImpo_dto_mon_loc() throws BaseException {
		supportRefresh();
		return impo_dto_mon_loc;
	}

	public void setImpo_dto_mon_loc(Money aImpo_dto_mon_loc) {
		this.impo_dto_mon_loc = aImpo_dto_mon_loc;
	}

	public Money getImpo_cob_mon_ori() throws BaseException {
		supportRefresh();
		return impo_cob_mon_ori;
	}

	public void setImpo_cob_mon_ori(Money aImpo_cob_mon_ori) {
		this.impo_cob_mon_ori = aImpo_cob_mon_ori;
	}

	public Money getImpo_cob_mon_loc() throws BaseException {
		supportRefresh();
		return impo_cob_mon_loc;
	}

	public void setImpo_cob_mon_loc(Money aImpo_cob_mon_loc) {
		this.impo_cob_mon_loc = aImpo_cob_mon_loc;
	}

	public ValorCotizacion getCotizacion() throws BaseException {
		supportRefresh();
		return cotizacion;
	}

	public void setCotizacion(ValorCotizacion aCotizacion) {
		this.cotizacion = aCotizacion;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static FacturasRecibo findByOid(Integer oid, ISesion aSesion)
			throws BaseException {
		return (FacturasRecibo) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static FacturasRecibo findByCodigo(String codigo, ISesion aSesion)
			throws BaseException {
		return (FacturasRecibo) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(recibo, "Debe ingresar un Recibo");
		Validar.noNulo(this.oid_tran_vto, "Debe ingresar un Comprobante Cliente");
	}

	public static List getFacturasEnRecibo(Recibo recibo, ISesion aSesion)
			throws BaseException {
		return DBFacturasRecibo.getFacturasEnRecibo(recibo, aSesion);

	}

}
