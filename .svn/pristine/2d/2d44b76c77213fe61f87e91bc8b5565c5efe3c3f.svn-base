package com.srn.erp.cip.bm;

import java.util.List;

import com.srn.erp.cip.da.DBTarjetaLegajo;
import com.srn.erp.sueldos.bm.Legajo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.Validar;

public class TarjetaLegajo extends ObjetoLogico {

	public TarjetaLegajo() {
	}

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public static String NICKNAME = "cip.TarjetaLegajo";

	private String tipo_tarjeta;
	private String nro_tarjeta;
	private Legajo legajo;
	private Boolean activo;
	private Integer orden;

	public String getTipo_tarjeta() throws BaseException {
		supportRefresh();
		return tipo_tarjeta;
	}

	public void setTipo_tarjeta(String aTipo_tarjeta) {
		this.tipo_tarjeta = aTipo_tarjeta;
	}

	public Integer getOrden() throws BaseException {
		supportRefresh();
		return orden;
	}

	public void setOrden(Integer aOrden) {
		this.orden = aOrden;
	}

	public String getNro_tarjeta() throws BaseException {
		supportRefresh();
		return nro_tarjeta;
	}

	public void setNro_tarjeta(String aNro_tarjeta) throws ExceptionValidation {
		if (aNro_tarjeta!=null) {
			try {
			int pasadoANro = Integer.parseInt(aNro_tarjeta);
			this.nro_tarjeta = pasadoANro+"";
			} catch (Exception e) {
				//throw new ExceptionValidation(null,"La tarjeta debe ser un valor numérico");
			}
		} else
			this.nro_tarjeta = aNro_tarjeta;
	}

	public Legajo getLegajo() throws BaseException {
		supportRefresh();
		return legajo;
	}

	public void setLegajo(Legajo aLegajo) {
		this.legajo = aLegajo;
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

	public static TarjetaLegajo findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (TarjetaLegajo) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static TarjetaLegajo findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (TarjetaLegajo) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(tipo_tarjeta, "Debe ingresar el tipod e Tarjeta");
		Validar.noNulo(nro_tarjeta, "Debe ingresar el Número de Tarjeta");
		Validar.noNulo(legajo, "Debe ingresar el Legajo");
		Validar.noNulo(orden, "Debe ingresar el número de Orden");
	}

	public static List getTarjetasLegajo(Legajo legajo, ISesion aSesion) throws BaseException {
		return DBTarjetaLegajo.getTarjetasLegajo(legajo, aSesion);
	}

	public static TarjetaLegajo getTarjetaLegajo(String nroTarjeta, ISesion aSesion) throws BaseException {
		return (TarjetaLegajo) DBTarjetaLegajo.getTarjetaLegajo(nroTarjeta, aSesion);
	}

	public static List getTarjetasActivas(ISesion aSesion) throws BaseException {
		return DBTarjetaLegajo.getTarjetasActivas(aSesion);
	}

	public static void borrarListaBlanca(Puerta puerta, ISesion aSesion) throws BaseException {

		DBTarjetaLegajo.borrarListaBlanca(puerta, aSesion);

	}
	
	public static TarjetaLegajo getTarjetaLegajo(Legajo legajo, ISesion aSesion) throws BaseException {
		return TarjetaLegajo.getTarjetaLegajo(legajo,aSesion);
	}
	

}
