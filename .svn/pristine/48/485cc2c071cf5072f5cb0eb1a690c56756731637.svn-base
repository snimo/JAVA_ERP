package com.srn.erp.rrhh.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.rrhh.da.DBEstrucNivEmpresa;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class EstrucNivEmpresa extends ObjetoLogico {

	public EstrucNivEmpresa() {
	}

	public static String NICKNAME = "rh.EstrucNivEmpresa";

	private ValorClasificadorEntidad valor_clasif_empresa;
	private Boolean activo;

	private List sectores = new ArrayList();
	private boolean readSectores = true;

	public ValorClasificadorEntidad getValor_clasif_empresa() throws BaseException {
		supportRefresh();
		return valor_clasif_empresa;
	}

	public void setValor_clasif_empresa(ValorClasificadorEntidad aValor_clasif_empresa) {
		this.valor_clasif_empresa = aValor_clasif_empresa;
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

	public static EstrucNivEmpresa findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (EstrucNivEmpresa) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static EstrucNivEmpresa findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (EstrucNivEmpresa) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static EstrucNivEmpresa findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (EstrucNivEmpresa) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(valor_clasif_empresa, "Debe ingresar la Empresa");
	}

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public static List getEmpresasActivas(ISesion aSesion) throws BaseException {
		return DBEstrucNivEmpresa.getEmpresasActivas(aSesion);
	}

	public static List getEmpresas(ISesion aSesion) throws BaseException {
		return DBEstrucNivEmpresa.getEmpresas(aSesion);
	}

	public List getSectores() throws BaseException {
		if (this.readSectores) {
			List listaSectores = EstrucNivSector.getSectoresActivos(this, getSesion());
			sectores.addAll(listaSectores);
			this.readSectores = false;
		}
		return sectores;
	}
	
	public List getSectoresConInactivos() throws BaseException {
		if (this.readSectores) {
			List listaSectores = EstrucNivSector.getSectores(this, getSesion());
			sectores.addAll(listaSectores);
			this.readSectores = false;
		}
		return sectores;
	}	

	public void addSector(EstrucNivSector aEstrucNivSector) throws BaseException {
		aEstrucNivSector.setOid_estruc_emp(this);
		sectores.add(aEstrucNivSector);
	}

	public void afterSave() throws BaseException {

		Iterator iterEstrucSec = sectores.iterator();
		while (iterEstrucSec.hasNext()) {
			EstrucNivSector estrucNivSector = (EstrucNivSector) iterEstrucSec.next();
			estrucNivSector.save();
			estrucNivSector = null;
		}
		iterEstrucSec = null;

	}

	public static EstrucNivEmpresa getEstrucNivEmpresa(ValorClasificadorEntidad valorClasifEntEmp, ISesion aSesion) throws BaseException {
		return DBEstrucNivEmpresa.getEstrucNivEmpresa(valorClasifEntEmp, aSesion);
	}

}
