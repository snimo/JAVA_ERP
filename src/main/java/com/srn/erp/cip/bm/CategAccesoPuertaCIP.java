package com.srn.erp.cip.bm;

import java.util.List;

import com.srn.erp.cip.da.DBCategAccesoPuertaCIP;
import com.srn.erp.sueldos.bm.Legajo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class CategAccesoPuertaCIP extends ObjetoLogico {

	public CategAccesoPuertaCIP() {
	}

	public static String NICKNAME = "cip.CategAccesoPuertaCIP";

	private CategAccesoCIP categoria;
	private Puerta puerta;
	private Boolean hab_entrada;
	private Boolean hab_salida;

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	private Boolean activo;

	public CategAccesoCIP getCategoria() throws BaseException {
		supportRefresh();
		return categoria;
	}

	public void setCategoria(CategAccesoCIP aCategoria) {
		this.categoria = aCategoria;
	}

	public Puerta getPuerta() throws BaseException {
		supportRefresh();
		return puerta;
	}

	public void setPuerta(Puerta aPuerta) {
		this.puerta = aPuerta;
	}

	public Boolean isHab_entrada() throws BaseException {
		supportRefresh();
		return hab_entrada;
	}

	public void setHab_entrada(Boolean aHab_entrada) {
		this.hab_entrada = aHab_entrada;
	}

	public Boolean isHab_salida() throws BaseException {
		supportRefresh();
		return hab_salida;
	}

	public void setHab_salida(Boolean aHab_salida) {
		this.hab_salida = aHab_salida;
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

	public static CategAccesoPuertaCIP findByOid(Integer oid, ISesion aSesion)
			throws BaseException {
		return (CategAccesoPuertaCIP) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static CategAccesoPuertaCIP findByCodigo(String codigo,
			ISesion aSesion) throws BaseException {
		return (CategAccesoPuertaCIP) getObjectByCodigo(NICKNAME, codigo,
				aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(categoria, "Debe ingresar la Categoría");
		Validar.noNulo(puerta, "Debe ingresar la Puerta");
	}

	public static CategAccesoPuertaCIP getCategAccesoPuerta(
			CategAccesoCIP categoria, Puerta puerta, ISesion aSesion)
			throws BaseException {

		return DBCategAccesoPuertaCIP.getCategAccesoPuerta(categoria, puerta,
				aSesion);
	}

	public static List getCategAccesoPuertas(CategAccesoCIP categoria,
			ISesion aSesion) throws BaseException {
		return DBCategAccesoPuertaCIP.getCategAccesoPuerta(categoria, aSesion);
	}
	
	public static CategAccesoPuertaCIP getCategAccesoEntradaPuerta(
			CategAccesoCIP categoria, Puerta puerta, ISesion aSesion)
			throws BaseException {
		return DBCategAccesoPuertaCIP.getCategAccesoEntradaPuerta(categoria,puerta,aSesion);
	}
	
	public static CategAccesoPuertaCIP getCategAccesoSalidaPuerta(
			CategAccesoCIP categoria, Puerta puerta, ISesion aSesion)
			throws BaseException {
		return DBCategAccesoPuertaCIP.getCategAccesoSalidaPuerta(categoria,puerta,aSesion);
	}
	
	
	public static List getCategAccesoEntradaByPuertaLegajo(Legajo legajo,Puerta puerta,
			ISesion aSesion) throws BaseException {
		return DBCategAccesoPuertaCIP.getCategAccesoEntradaByPuertaLegajo(legajo,puerta,aSesion);
	}
	
	public static List getCategAccesoHabilitadasLeg(
			Legajo legajo,
			ISesion aSesion) throws BaseException {
		return DBCategAccesoPuertaCIP.getCategAccesoHabilitadasLeg(legajo,aSesion); 
	}
	
	
	

}
