package com.srn.erp.payroll.bm;

import java.util.Hashtable;
import java.util.List;

import com.srn.erp.payroll.da.DBPayEmpresa;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class PayEmpresa extends ObjetoLogico { 

  public PayEmpresa() { 
  }

	public static String NICKNAME = "admRRHH.payEmpresa";

	private String nombre;
	private String empresa;

	public String getNombre() throws BaseException {
		supportRefresh();
		return nombre;
	}

	public void setNombre(String aNombre) {
		this.nombre = aNombre;
	}

	public String getEmpresa() throws BaseException {
		supportRefresh();
		return empresa;
	}

	public void setEmpresa(String aEmpresa) {
		this.empresa = aEmpresa;
	}

	public String getNickName() {
		return NICKNAME;
	}

	@SuppressWarnings("unchecked")
	public static List<PayEmpresa> findAllEmpresas(ISesion aSesion,
			Hashtable<String, Object> hashTable) throws BaseException {
		return (List<PayEmpresa>) DBPayEmpresa.getObjectAllEmpresas(aSesion,
				hashTable);
	}

	@SuppressWarnings("unchecked")
	public static List<PayEmpresa> findByNombre(ISesion aSesion,
			Hashtable<String, Object> hashTable) throws BaseException {
		return (List<PayEmpresa>) DBPayEmpresa.getObjectByNombre(aSesion,
				hashTable);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(nombre, "");
		Validar.noNulo(empresa, "");
	}

	public String getCodigo() throws BaseException {
		supportRefresh();
		return empresa.toString();
	}

	public String getDescripcion() throws BaseException {
		supportRefresh();
		return nombre;
	}

	@Override
	public Boolean isActivo() throws BaseException {
		return true;
	}

}
