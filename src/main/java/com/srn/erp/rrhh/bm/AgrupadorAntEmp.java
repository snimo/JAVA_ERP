package com.srn.erp.rrhh.bm;

import com.srn.erp.general.bm.ValorClasificadorEntidad;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;

public class AgrupadorAntEmp extends ObjetoLogico {

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean isActivo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public AgrupadorAntEmp() {
	}

	public static String NICKNAME = "rh.AgrupadorAntEmp";

	private Integer oid;
	private String cod_ant_emp;
	private ValorClasificadorEntidad valorEmpresa;

	public ValorClasificadorEntidad getValorClasifEmpresa() throws BaseException {
		supportRefresh();
		return this.valorEmpresa;
	}	

	public void setValorClasifEmp(ValorClasificadorEntidad aValClasifEmp) {
		this.valorEmpresa = aValClasifEmp;
	}

	public String getCod_ant_emp() throws BaseException {
		supportRefresh();
		if (cod_ant_emp==null)
			return "";
		else
			return cod_ant_emp;
	}

	public void setCod_ant_emp(String aCod_ant_emp) {
		this.cod_ant_emp = aCod_ant_emp;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static AgrupadorAntEmp findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (AgrupadorAntEmp) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static AgrupadorAntEmp findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (AgrupadorAntEmp) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
	}

}
