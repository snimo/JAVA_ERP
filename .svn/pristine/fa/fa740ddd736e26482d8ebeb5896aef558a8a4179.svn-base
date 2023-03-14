package com.srn.erp.proveedoresMaterials.bm;

import java.util.List;

import com.srn.erp.proveedoresMaterials.da.DBGrupoProveedor;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class GrupoProveedor extends ObjetoLogico {

	public GrupoProveedor() {
	}

	public static String NICKNAME = "ma.grupoProveedor";

	private String codigo;
	private String descripcion;
	private Integer grupoUte;
	private Integer grupoBinbaires;
	private Integer grupoAlavera;
	private Integer grupoMagic;
	private Boolean activo;

	public String getCodigo() throws BaseException {
		supportRefresh();
		return codigo;
	}

	public void setCodigo(String aCodigo) {
		this.codigo = aCodigo;
	}

	public String getDescripcion() throws BaseException {
		supportRefresh();
		return descripcion;
	}

	public void setDescripcion(String aDescripcion) {
		this.descripcion = aDescripcion;
	}

	public Integer getGrupoute() throws BaseException {
		supportRefresh();
		return grupoUte;
	}

	public void setGrupoute(Integer aGrupoute) {
		this.grupoUte = aGrupoute;
	}

	public Integer getGrupobinbaires() throws BaseException {
		supportRefresh();
		return grupoBinbaires;
	}

	public void setGrupobinbaires(Integer aGrupobinbaires) {
		this.grupoBinbaires = aGrupobinbaires;
	}

	public Integer getGrupoalavera() throws BaseException {
		supportRefresh();
		return grupoAlavera;
	}

	public void setGrupoalavera(Integer aGrupoalavera) {
		this.grupoAlavera = aGrupoalavera;
	}

	public Integer getGrupomagic() throws BaseException {
		supportRefresh();
		return grupoMagic;
	}

	public void setGrupomagic(Integer aGrupomagic) {
		this.grupoMagic = aGrupomagic;
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

	public static GrupoProveedor findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (GrupoProveedor) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static GrupoProveedor findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (GrupoProveedor) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}
	
	public static List<GrupoProveedor> findAll(ISesion aSesion) throws BaseException {
		return (List<GrupoProveedor>) DBGrupoProveedor.getAllObject(aSesion);
	}
	 
	public static GrupoProveedor findByOidBase(String base, Integer oid, ISesion aSesion) throws BaseException{
		if(base.equals("UTE")){
			return (GrupoProveedor) DBGrupoProveedor.getByUteOid(oid, aSesion);
		}else if(base.equals("BINBAIRES")){
			return (GrupoProveedor) DBGrupoProveedor.getByBinbairesOid(oid, aSesion);
		}else if(base.equals("ALAVERA")){
			return (GrupoProveedor) DBGrupoProveedor.getByAlaveraOid(oid, aSesion);
		}else if(base.equals("MAGIC")){
			return (GrupoProveedor) DBGrupoProveedor.getByMagicOid(oid, aSesion);
		}
		return null;
	}
	
	public static GrupoProveedor findByOidBase(Integer oidUte, Integer oidBinbaires, Integer oidAlavera, Integer oidMagic, ISesion aSesion) throws BaseException {
		return (GrupoProveedor) DBGrupoProveedor.getByOidBase(oidUte, oidBinbaires, oidAlavera, oidMagic, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(codigo, "Ingrese un codigo");
		Validar.noNulo(descripcion, "Ingrese una Descripcion");
		Validar.noNulo(grupoUte, "Ingrese un grupo de la empresa UTE");
		Validar.noNulo(grupoBinbaires, "Ingrese un grupo de la empresa BINBAIRES");
		Validar.noNulo(grupoAlavera, "Ingrese un grupo de la empresa ALAVERA");
		Validar.noNulo(grupoMagic, "Ingrese un grupo de la empresa MAGIC");
	}

}
