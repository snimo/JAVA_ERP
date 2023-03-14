package com.srn.erp.rrhh.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.rrhh.da.DBEstrucNivSector;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;
import framework.request.bl.Utils.Validar;

public class EstrucNivSector extends ObjetoLogico {

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public EstrucNivSector() {
	}

	public static String NICKNAME = "rh.EstrucNivSector";

	private EstrucNivEmpresa oid_estruc_emp;
	private ValorClasificadorEntidad valor_clasif_sector;
	private Boolean activo;
	
	private List puestos = new ArrayList();
	private boolean readPuestos = true;
	

	public EstrucNivEmpresa getOid_estruc_emp() throws BaseException {
		supportRefresh();
		return oid_estruc_emp;
	}

	public void setOid_estruc_emp(EstrucNivEmpresa aOid_estruc_emp) {
		this.oid_estruc_emp = aOid_estruc_emp;
	}

	public ValorClasificadorEntidad getValor_clasif_sector() throws BaseException {
		supportRefresh();
		return valor_clasif_sector;
	}

	public void setValor_clasif_sector(ValorClasificadorEntidad aValor_clasif_sector) {
		this.valor_clasif_sector = aValor_clasif_sector;
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

	public static EstrucNivSector findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (EstrucNivSector) getObjectByOid(NICKNAME, oid, aSesion);
	}
	
	public static EstrucNivSector findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (EstrucNivSector) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}
	

	public static EstrucNivSector findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (EstrucNivSector) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(oid_estruc_emp, "Debe ingresar la Empresa");
		Validar.noNulo(valor_clasif_sector, "Debe ingresar el Sector");
	}

	public static List getSectoresActivos(EstrucNivEmpresa estrucNivEmpresa, ISesion aSesion) throws BaseException {
		return DBEstrucNivSector.getSectoresActivos(estrucNivEmpresa, aSesion);
	}

	public static List getSectores(EstrucNivEmpresa estrucNivEmpresa, ISesion aSesion) throws BaseException {
		return DBEstrucNivSector.getSectoresActivosAll(estrucNivEmpresa, aSesion);
	}	
	
	public List getPuestos() throws BaseException {
		if (this.readPuestos) {
			List listaPuestos = EstrucNivPuesto.getPuestosActivos(this, getSesion());
			puestos.addAll(listaPuestos);
			this.readPuestos = false;
		}
		return puestos;
	}
	
	public List getPuestosConInactivos() throws BaseException {
		if (this.readPuestos) {
			List listaPuestos = EstrucNivPuesto.getPuestos(this, getSesion());
			puestos.addAll(listaPuestos);
			this.readPuestos = false;
		}
		return puestos;
	}	
	
	public void addPuesto(EstrucNivPuesto aEstrucNivPuesto) throws BaseException {
		aEstrucNivPuesto.setOid_estruc_sector(this);
		puestos.add(aEstrucNivPuesto);
	}
	
	public void afterSave() throws BaseException {

		Iterator iterEstrucPue = puestos.iterator();
		while (iterEstrucPue.hasNext()) {
			EstrucNivPuesto estrucNivPuesto = (EstrucNivPuesto) iterEstrucPue.next();
			estrucNivPuesto.save();
			estrucNivPuesto = null;
		}
		iterEstrucPue = null;
		
	}
	
	public static EstrucNivSector getEstrucNivSector(
			  EstrucNivEmpresa estrucNivEmpresa,
			  ValorClasificadorEntidad valClasifSec,
	          ISesion aSesion)
	          throws BaseException {
		  return DBEstrucNivSector.getEstrucNivSector(estrucNivEmpresa,valClasifSec,aSesion);
	}
	
	

}
