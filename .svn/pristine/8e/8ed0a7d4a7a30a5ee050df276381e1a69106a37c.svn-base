package com.srn.erp.proveedoresMaterials.bm;

import java.util.List;

import com.srn.erp.proveedoresMaterials.da.DBGrupoProveedorBase;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;

public class GrupoProveedorBase extends ObjetoLogico {

	public GrupoProveedorBase() {
	}

	public static String NICKNAME = "ma.grupoProveedorBase";

	private String nombre;

	public String getNombre() throws BaseException {
		supportRefresh();
		return nombre;
	}

	public void setNombre(String aNombre) {
		this.nombre = aNombre;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static GrupoProveedorBase findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (GrupoProveedorBase) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static GrupoProveedorBase findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (GrupoProveedorBase) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}
	
	public static GrupoProveedorBase findByIdUte(Integer id, ISesion aSesion) throws BaseException {
		return (GrupoProveedorBase) DBGrupoProveedorBase.getByCuitUte(id, aSesion);
	}
	
	public static GrupoProveedorBase findByIdBinbaires(Integer id, ISesion aSesion) throws BaseException {
		return (GrupoProveedorBase) DBGrupoProveedorBase.getByCuitBinbaires(id, aSesion);
	}
	
	public static GrupoProveedorBase findByIdAlavera(Integer id, ISesion aSesion) throws BaseException {
		return (GrupoProveedorBase) DBGrupoProveedorBase.getByCuitAlavera(id, aSesion);
	}
	
	public static GrupoProveedorBase findByIdMagic(Integer id, ISesion aSesion) throws BaseException {
		return (GrupoProveedorBase) DBGrupoProveedorBase.getByCuitMagic(id, aSesion);
	}
	
	public static List<GrupoProveedorBase> findAllUte(ISesion aSesion) throws BaseException {
		return (List<GrupoProveedorBase>) DBGrupoProveedorBase.getAllUte(aSesion);
	}
	
	public static List<GrupoProveedorBase> findAllBinbaires(ISesion aSesion) throws BaseException {
		return (List<GrupoProveedorBase>) DBGrupoProveedorBase.getAllBinbaires(aSesion);
	}
	
	public static List<GrupoProveedorBase> findAllAlavera(ISesion aSesion) throws BaseException {
		return (List<GrupoProveedorBase>) DBGrupoProveedorBase.getAllAlavera(aSesion);
	}
	
	public static List<GrupoProveedorBase> findAllMagic(ISesion aSesion) throws BaseException {
		return (List<GrupoProveedorBase>) DBGrupoProveedorBase.getAllMagic(aSesion);
	}

	public void beforeSave() throws BaseException {
	}

	@Override
	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean isActivo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

}
