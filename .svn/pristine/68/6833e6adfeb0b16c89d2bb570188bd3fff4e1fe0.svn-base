package com.srn.erp.cip.bm;

import java.util.List;

import com.srn.erp.cip.da.DBTarjetaRotaVisita;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;
import framework.request.bl.Utils.Validar;

public class TarjetaRotaVisita extends ObjetoLogico {

	public TarjetaRotaVisita() {
	}

	public static String NICKNAME = "cip.TarjetaRotaVisita";

	private TarjetaCIP tarjeta;
	private java.util.Date fecha;
	private Rota rota;
	private Boolean activo;

	public TarjetaCIP getTarjeta() throws BaseException {
		supportRefresh();
		return tarjeta;
	}

	public void setTarjeta(TarjetaCIP aTarjeta) {
		this.tarjeta = aTarjeta;
	}

	public java.util.Date getFecha() throws BaseException {
		supportRefresh();
		return fecha;
	}

	public void setFecha(java.util.Date aFecha) {
		this.fecha = aFecha;
	}

	public Rota getRota() throws BaseException {
		supportRefresh();
		return rota;
	}

	public void setRota(Rota aRota) {
		this.rota = aRota;
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

	public static TarjetaRotaVisita findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (TarjetaRotaVisita) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static TarjetaRotaVisita findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (TarjetaRotaVisita) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(tarjeta, "Debe ingresar la Tarjeta");
		Validar.noNulo(fecha, "Debe ingresar la fecha");
		Validar.noNulo(rota, "Debe ingresar la Rota");
	}

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public static List getTarjetasRotaVisita(TarjetaCIP tarjeta, java.util.Date fecha, ISesion aSesion) throws BaseException {
		return DBTarjetaRotaVisita.getTarjetasRotaVisita(tarjeta, fecha, aSesion);
	}
	
	public static TarjetaRotaVisita getTarjetaRotaVisita(
			  TarjetaCIP tarjeta,
			  java.util.Date fecha,
	          ISesion aSesion)
	          throws BaseException {
		  return DBTarjetaRotaVisita.getTarjetaRotaVisita(tarjeta,fecha,aSesion);
	}

}
