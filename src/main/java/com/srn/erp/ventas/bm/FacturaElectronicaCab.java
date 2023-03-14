package com.srn.erp.ventas.bm;

import com.srn.erp.ventas.da.DBFacturaElectronicaCab;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;

public class FacturaElectronicaCab extends ObjetoLogico {

	@Override
	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean isActivo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public FacturaElectronicaCab() {
	}

	public static String NICKNAME = "ve.FacturaElectronicaCab";

	private Boolean homologada_fe;
	private java.util.Date fechora_homologada_fe;
	private String usu_homologada_fe;
	private String cae_fe;
	private java.util.Date fec_vto_cae_fe;

	public Boolean isHomologada_fe() throws BaseException {
		supportRefresh();
		return homologada_fe;
	}

	public void setHomologada_fe(Boolean aHomologada_fe) {
		this.homologada_fe = aHomologada_fe;
	}

	public java.util.Date getFechora_homologada_fe() throws BaseException {
		supportRefresh();
		return fechora_homologada_fe;
	}

	public void setFechora_homologada_fe(java.util.Date aFechora_homologada_fe) {
		this.fechora_homologada_fe = aFechora_homologada_fe;
	}

	public String getUsu_homologada_fe() throws BaseException {
		supportRefresh();
		return usu_homologada_fe;
	}

	public void setUsu_homologada_fe(String aUsu_homologada_fe) {
		this.usu_homologada_fe = aUsu_homologada_fe;
	}

	public String getCae_fe() throws BaseException {
		supportRefresh();
		return cae_fe;
	}

	public void setCae_fe(String aCae_fe) {
		this.cae_fe = aCae_fe;
	}

	public java.util.Date getFec_vto_cae_fe() throws BaseException {
		supportRefresh();
		return fec_vto_cae_fe;
	}

	public void setFec_vto_cae_fe(java.util.Date aFec_vto_cae_fe) {
		this.fec_vto_cae_fe = aFec_vto_cae_fe;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static FacturaElectronicaCab findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (FacturaElectronicaCab) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static FacturaElectronicaCab findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (FacturaElectronicaCab) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
	}
	
	public static void actualizarFactElectronica(
				java.util.Date fecha,
				String usuario,
				String cae,
				java.util.Date vto,
				Integer oidCCO,
				ISesion aSesion) throws BaseException {
		
		
		DBFacturaElectronicaCab.actualizarFactElectronica(fecha,usuario,cae,vto,oidCCO,aSesion);
		
	}	


}
