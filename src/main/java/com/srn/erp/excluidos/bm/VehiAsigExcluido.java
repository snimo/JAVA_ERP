package com.srn.erp.excluidos.bm;

import java.util.List;

import com.srn.erp.excluidos.da.DBVehiAsigExcluido;
import com.srn.erp.general.bm.Periodo;
import com.srn.erp.general.da.DBPeriodo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;
import framework.request.bl.Utils.Validar;

public class VehiAsigExcluido extends ObjetoLogico {

	public VehiAsigExcluido() {
	}

	public static String NICKNAME = "exc.VehiAsigExcluido";

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	private IndividuoExcluido individuo;
	private VehiculoExcluido vehiculo;
	private Boolean activo;
	private PredioExcluido predio;

	public IndividuoExcluido getIndividuo() throws BaseException {
		supportRefresh();
		return individuo;
	}
	
	public PredioExcluido getPredioExcluido() throws BaseException {
		supportRefresh();
		return predio;
	}	
	

	public void setIndividuo(IndividuoExcluido aIndividuo) {
		this.individuo = aIndividuo;
	}
	
	public void setPredio(PredioExcluido aPredioExcluido) {
		this.predio = aPredioExcluido;
	}
	

	public VehiculoExcluido getVehiculo() throws BaseException {
		supportRefresh();
		return vehiculo;
	}

	public void setVehiculo(VehiculoExcluido aVehiculo) {
		this.vehiculo = aVehiculo;
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

	public static VehiAsigExcluido findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (VehiAsigExcluido) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static VehiAsigExcluido findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (VehiAsigExcluido) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(individuo, "Debe ingresar el Individuo");
		Validar.noNulo(vehiculo, "Debe ingresar el Vehículo");
		Validar.noNulo(predio, "Debe ingresar el predio en los vehículos");
		
	}

	public static List getVehiAsigExcluido(IndividuoExcluido individuo, ISesion aSesion) throws BaseException {
		return DBVehiAsigExcluido.getVehiAsigExcluido(individuo, aSesion);
	}

	public static VehiAsigExcluido getVehiculoAsigExc(IndividuoExcluido individuo, VehiculoExcluido vehiculoExcluido, ISesion aSesion)
			throws BaseException {
		return DBVehiAsigExcluido.getVehiculoAsigExc(individuo, vehiculoExcluido, aSesion);
	}

}
