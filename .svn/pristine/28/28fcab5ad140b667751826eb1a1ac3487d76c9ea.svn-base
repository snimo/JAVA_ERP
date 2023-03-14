package com.srn.erp.conciTarjeta.bm;

import java.util.List;

import com.srn.erp.conciTarjeta.da.DBTarjModeloLiq;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class TarjModeloLiq extends ObjetoLogico {
	
	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public TarjModeloLiq() {
	}

	public static String NICKNAME = "ctar.TarjModeloLiq";

	private TarjetaConciTar tarjeta;
	private EmpresaConciTar empresa;
	private CabModeloLiq modelo_liquidacion;
	private Boolean activo;

	public TarjetaConciTar getTarjeta() throws BaseException {
		supportRefresh();
		return tarjeta;
	}

	public void setTarjeta(TarjetaConciTar aTarjeta) {
		this.tarjeta = aTarjeta;
	}

	public EmpresaConciTar getEmpresa() throws BaseException {
		supportRefresh();
		return empresa;
	}

	public void setEmpresa(EmpresaConciTar aEmpresa) {
		this.empresa = aEmpresa;
	}

	public CabModeloLiq getModelo_liquidacion() throws BaseException {
		supportRefresh();
		return modelo_liquidacion;
	}

	public void setModelo_liquidacion(CabModeloLiq aModelo_liquidacion) {
		this.modelo_liquidacion = aModelo_liquidacion;
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

	public static TarjModeloLiq findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (TarjModeloLiq) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static TarjModeloLiq findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (TarjModeloLiq) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(tarjeta, "Debe ingresar la Tarjeta");
		Validar.noNulo(empresa, "Debe seleccionar la Empresa");
		Validar.noNulo(modelo_liquidacion, "Debe ingresar el Modelo");
	}

	public static List getTarjetaModLiq(TarjetaConciTar tarjeta, ISesion aSesion) throws BaseException {
		return DBTarjModeloLiq.getTarjetaModLiq(tarjeta, aSesion);
	}

}
