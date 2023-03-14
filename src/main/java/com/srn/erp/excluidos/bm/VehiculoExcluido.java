package com.srn.erp.excluidos.bm;

import java.util.List;

import com.srn.erp.excluidos.da.DBVehiculoExcluido;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class VehiculoExcluido extends ObjetoLogico {

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public VehiculoExcluido() {
	}

	public static String NICKNAME = "exc.VehiculoExcluido";

	private String modelo;
	private String dominio;
	private ColorExcluido color;
	private Boolean activo;
	private String marca;
	private PredioExcluido predio;

	public String getModelo() throws BaseException {
		supportRefresh();
		return modelo;
	}
	
	public PredioExcluido getPredio() throws BaseException {
		supportRefresh();
		return predio;
	}
	

	public void setModelo(String aModelo) {
		this.modelo = aModelo;
	}
	
	public void setPredio(PredioExcluido aPredio) {
		this.predio = aPredio;
	}
	
	
	public String getMarca() throws BaseException {
		supportRefresh();
		return marca;
	}

	public void setMarca(String aMarca) {
		this.marca = aMarca;
	}
	

	public String getDominio() throws BaseException {
		supportRefresh();
		return dominio;
	}

	public void setDominio(String aDominio) {
		this.dominio = aDominio;
	}

	public ColorExcluido getColor() throws BaseException {
		supportRefresh();
		return color;
	}

	public void setColor(ColorExcluido aColor) {
		this.color = aColor;
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

	public static VehiculoExcluido findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (VehiculoExcluido) getObjectByOid(NICKNAME, oid, aSesion);
	}
	
	public static VehiculoExcluido findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (VehiculoExcluido) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}
	

	public static VehiculoExcluido findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (VehiculoExcluido) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(this.dominio, "Debe ingresar el Dominio");
		Validar.noNulo(this.predio, "Debe ingresar el Predio del Vehículo");
	}

	public static List getVehiculos(IndividuoExcluido aIndividuo, ISesion aSesion) throws BaseException {
		return DBVehiculoExcluido.getVehiculos(aIndividuo, aSesion);
	}
	
	public static VehiculoExcluido getVehiculoExcluido(String dominio, ISesion aSesion) throws BaseException {
		return DBVehiculoExcluido.getVehiculoExcluido(dominio,aSesion);
	}
	

}
