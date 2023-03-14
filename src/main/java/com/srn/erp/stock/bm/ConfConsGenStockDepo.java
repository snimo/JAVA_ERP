package com.srn.erp.stock.bm;

import java.util.List;

import com.srn.erp.stock.da.DBConfConsGenStockDepo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class ConfConsGenStockDepo extends ObjetoLogico implements Comparable {

	public ConfConsGenStockDepo() {
	}

	public static String NICKNAME = "st.ConfConsGenStockDepo";

	private Deposito deposito;

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	private ConfConsGenStock conf_cons_stk;
	private Boolean activo;
	private Integer orden;

	public Deposito getDeposito() throws BaseException {
		supportRefresh();
		return deposito;
	}

	public void setDeposito(Deposito aDeposito) {
		this.deposito = aDeposito;
	}

	public ConfConsGenStock getConf_cons_stk() throws BaseException {
		supportRefresh();
		return conf_cons_stk;
	}

	public void setConf_cons_stk(ConfConsGenStock aConf_cons_stk) {
		this.conf_cons_stk = aConf_cons_stk;
	}

	public Boolean isActivo() throws BaseException {
		supportRefresh();
		return activo;
	}

	public void setActivo(Boolean aActivo) {
		this.activo = aActivo;
	}

	public Integer getOrden() throws BaseException {
		supportRefresh();
		return orden;
	}

	public void setOrden(Integer aOrden) {
		this.orden = aOrden;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static ConfConsGenStockDepo findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (ConfConsGenStockDepo) getObjectByOid(NICKNAME, oid, aSesion);
	}
	
	public static ConfConsGenStockDepo findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (ConfConsGenStockDepo) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static ConfConsGenStockDepo findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (ConfConsGenStockDepo) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(deposito, "Debe ingresar el Depósito");
		Validar.noNulo(conf_cons_stk, "Debe ingresar la Configuración");
		Validar.noNulo(orden, "Debe ingresar el Orden");
	}

	public static List getConfConsGenStockDepo(ConfConsGenStock confConsGenStock, ISesion aSesion) throws BaseException {
		return DBConfConsGenStockDepo.getConfConsGenStockDepo(confConsGenStock, aSesion);
	}
	
	public int compareTo(Object arg0)  {

		try {
			return this.getOrden().compareTo(((ConfConsGenStockDepo)arg0).getOrden());
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			return 0;
		}

	}
	

}
