package com.srn.erp.payroll.bm;

import java.util.List;

import com.srn.erp.payroll.da.DBPayRotas;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;

public class PayRotas extends ObjetoLogico {

	public PayRotas() {
	}

	public static String NICKNAME = "admRRHH.payRotas";

	private String tracodigo;
	private String tradescrip;
	private String trahoraini;
	private String trahorafin;

	public String getTracodigo() throws BaseException {
		supportRefresh();
		return tracodigo;
	}

	public void setTracodigo(String aTracodigo) {
		this.tracodigo = aTracodigo;
	}

	public String getTradescrip() throws BaseException {
		supportRefresh();
		return tradescrip;
	}

	public void setTradescrip(String aTradescrip) {
		this.tradescrip = aTradescrip;
	}

	public String getTrahoraini() throws BaseException {
		supportRefresh();
		return trahoraini;
	}

	public void setTrahoraini(String aTrahoraini) {
		this.trahoraini = aTrahoraini;
	}

	public String getTrahorafin() throws BaseException {
		supportRefresh();
		return trahorafin;
	}

	public void setTrahorafin(String aTrahorafin) {
		this.trahorafin = aTrahorafin;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static PayRotas findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (PayRotas) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static PayRotas findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (PayRotas) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}
	
	public static List<PayRotas> findAll(ISesion aSesion) throws BaseException {
		return (List<PayRotas>) DBPayRotas.findAll(aSesion);
	}

	public void beforeSave() throws BaseException {
	}

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean isActivo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

}
