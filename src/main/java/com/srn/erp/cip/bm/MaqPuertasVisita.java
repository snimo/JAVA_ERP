package com.srn.erp.cip.bm;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class MaqPuertasVisita extends ObjetoLogico {

	public MaqPuertasVisita() {
	}

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public static String NICKNAME = "cip.MaqPuertasVisita";

	private String maquina;
	private Puerta puerta_entrada;
	private Puerta puerta_salida;
	private Boolean activo;
	private GrupoPuerta grupoPuerta; 

	public String getMaquina() throws BaseException {
		supportRefresh();
		return maquina;
	}

	public void setMaquina(String aMaquina) {
		this.maquina = aMaquina;
	}
	
	public GrupoPuerta getGrupoPuerta() throws BaseException {
		supportRefresh();
		return grupoPuerta;
	}

	public void setGrupoPuerta(GrupoPuerta aGrupoPuerta) {
		this.grupoPuerta = aGrupoPuerta;
	}
	

	public Puerta getPuerta_entrada() throws BaseException {
		supportRefresh();
		return puerta_entrada;
	}

	public void setPuerta_entrada(Puerta aPuerta_entrada) {
		this.puerta_entrada = aPuerta_entrada;
	}

	public Puerta getPuerta_salida() throws BaseException {
		supportRefresh();
		return puerta_salida;
	}

	public void setPuerta_salida(Puerta aPuerta_salida) {
		this.puerta_salida = aPuerta_salida;
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

	public static MaqPuertasVisita findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (MaqPuertasVisita) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static MaqPuertasVisita findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (MaqPuertasVisita) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(maquina, "Debe ingresar la Máquina");
	}

}
