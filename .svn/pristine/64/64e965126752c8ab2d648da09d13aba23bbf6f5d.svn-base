package com.srn.erp.rrhh.bm;

import java.util.List;

import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.rrhh.da.DBEstrucNivPuesto;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;
import framework.request.bl.Utils.Validar;

public class EstrucNivPuesto extends ObjetoLogico {

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public EstrucNivPuesto() {
	}

	public static String NICKNAME = "rh.EstrucNivPuesto";

	private EstrucNivSector oid_estruc_sector;
	private ValorClasificadorEntidad valor_clasif_puesto;
	private Boolean activo;

	public EstrucNivSector getOid_estruc_sector() throws BaseException {
		supportRefresh();
		return oid_estruc_sector;
	}

	public void setOid_estruc_sector(EstrucNivSector aOid_estruc_sector) {
		this.oid_estruc_sector = aOid_estruc_sector;
	}

	public ValorClasificadorEntidad getValor_clasif_puesto() throws BaseException {
		supportRefresh();
		return valor_clasif_puesto;
	}

	public void setValor_clasif_puesto(ValorClasificadorEntidad aValor_clasif_puesto) {
		this.valor_clasif_puesto = aValor_clasif_puesto;
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

	public static EstrucNivPuesto findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (EstrucNivPuesto) getObjectByOid(NICKNAME, oid, aSesion);
	}
	
	public static EstrucNivPuesto findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (EstrucNivPuesto) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}	

	public static EstrucNivPuesto findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (EstrucNivPuesto) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(oid_estruc_sector, "Debe ingresar el Sector");
		Validar.noNulo(valor_clasif_puesto, "Debe ingresar el Puesto");
	}

	public static List getPuestosActivos(EstrucNivSector estrucNivSector, ISesion aSesion) throws BaseException {
		return DBEstrucNivPuesto.getPuestosActivos(estrucNivSector, aSesion);
	}
	
	public static List getPuestos(EstrucNivSector estrucNivSector, ISesion aSesion) throws BaseException {
		return DBEstrucNivPuesto.getPuestos(estrucNivSector, aSesion);
	}	
	
	public static EstrucNivPuesto getEstrucNivPuesto(
			  EstrucNivSector aEstrucNivSector,
			  ValorClasificadorEntidad valClasifEnt,
	          ISesion aSesion)
	          throws BaseException {
		  return DBEstrucNivPuesto.getEstrucNivPuesto(aEstrucNivSector,valClasifEnt,aSesion);
	}	

}
