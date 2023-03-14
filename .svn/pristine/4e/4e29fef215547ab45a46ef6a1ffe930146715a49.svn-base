package com.srn.erp.rrhh.bm;

import java.util.List;

import com.srn.erp.rrhh.da.DBMotivoTipoNov;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class MotivoTipoNov extends ObjetoLogico {

	public MotivoTipoNov() {
	}

	public static String NICKNAME = "rh.MotivoTipoNov";

	private TipoNovedad tipo_novedad;
	private String codigo;
	private String descripcion;
	private Boolean activo;

	public TipoNovedad getTipo_novedad() throws BaseException {
		supportRefresh();
		return tipo_novedad;
	}

	public void setTipo_novedad(TipoNovedad aTipo_novedad) {
		this.tipo_novedad = aTipo_novedad;
	}

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

	public static MotivoTipoNov findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (MotivoTipoNov) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static MotivoTipoNov findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (MotivoTipoNov) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static MotivoTipoNov findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (MotivoTipoNov) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(tipo_novedad, "Debe ingresar el Tipo de Novedad");
		Validar.noNulo(codigo, "Debe ingresar el Código");
		Validar.noNulo(descripcion, "Debe ingresar la Descripción");
	}

	public static List getMotivosTipoMov(TipoNovedad aTipoNovedad, ISesion aSesion) throws BaseException {
		return DBMotivoTipoNov.getMotivosTipoMov(aTipoNovedad, aSesion);
	}

	public static MotivoTipoNov getMotivoTipoNov(TipoNovedad tipoNovedad, String codigo, ISesion aSesion) throws BaseException {
		return DBMotivoTipoNov.getMotivoTipoNov(tipoNovedad, codigo, aSesion);
	}

	public static List getAll(ISesion aSesion) throws BaseException {
		return DBMotivoTipoNov.getAll(aSesion);
	}
	
	public static List getAllActivos(ISesion aSesion) throws BaseException {
		return DBMotivoTipoNov.getAllActivos(aSesion);
	}
	

}
