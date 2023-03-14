package com.srn.erp.contabilidad.bm;

import java.util.List;

import com.srn.erp.contabilidad.da.DBDriverCuentaComponente;

import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class DriverCuentaComponente extends ObjetoLogico {

	public DriverCuentaComponente() {
	}

	public static String NICKNAME = "cg.DriverCuentaComponente";

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	private DriverCuentaSubreparto driver_cta;
	private Componente componente;
	private IObjetoLogico valor_componente;
	private Boolean activo;

	public DriverCuentaSubreparto getDriver_cta() throws BaseException {
		supportRefresh();
		return driver_cta;
	}

	public void setDriver_cta(DriverCuentaSubreparto aDriver_cta) {
		this.driver_cta = aDriver_cta;
	}

	public Componente getComponente() throws BaseException {
		supportRefresh();
		return componente;
	}

	public void setComponente(Componente aComponente) {
		this.componente = aComponente;
	}

	public IObjetoLogico getValor_componente() throws BaseException {
		supportRefresh();
		return valor_componente;
	}

	public void setValor_componente(IObjetoLogico aValor_componente) {
		this.valor_componente = aValor_componente;
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

	public static DriverCuentaComponente findByOid(Integer oid, ISesion aSesion)
			throws BaseException {
		return (DriverCuentaComponente) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static DriverCuentaComponente findByCodigo(String codigo,
			ISesion aSesion) throws BaseException {
		return (DriverCuentaComponente) getObjectByCodigo(NICKNAME, codigo,
				aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(driver_cta, "Debe ingresar la Cuenta Subreparto");
		Validar.noNulo(componente, "Debe ingresar el componente");
		Validar
				.noNulo(valor_componente,
						"Debe ingresar el Valor de Componente");
	}

	public static List getDriverComponentesCta(
			DriverCuentaSubreparto driverCuenta, ISesion aSesion)
			throws BaseException {
		return DBDriverCuentaComponente.getDriverComponentesCta(driverCuenta,
				aSesion);
	}

	public static DriverCuentaComponente getDriverCuentaComponente(
			DriverCuentaSubreparto driverCuenta, Componente componente,
			ISesion aSesion) throws BaseException {
		return DBDriverCuentaComponente.getDriverCuentaComponente(driverCuenta,
				componente, aSesion);
	}

}
