package com.srn.erp.cip.bm;

import java.util.List;

import com.srn.erp.cip.da.DBCategAccesoEstado;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class CategAccesoEstado extends ObjetoLogico {

	public CategAccesoEstado() {
	}

	public static String NICKNAME = "cip.CategAccesoEstado";

	private EstadoCIP estado;
	private CategAccesoCIP categoria;
	private Boolean activo;

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public EstadoCIP getEstado() throws BaseException {
		supportRefresh();
		return estado;
	}

	public void setEstado(EstadoCIP aEstado) {
		this.estado = aEstado;
	}

	public CategAccesoCIP getCategoria() throws BaseException {
		supportRefresh();
		return categoria;
	}

	public void setCategoria(CategAccesoCIP aCategoria) {
		this.categoria = aCategoria;
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

	public static CategAccesoEstado findByOid(Integer oid, ISesion aSesion)
			throws BaseException {
		return (CategAccesoEstado) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static CategAccesoEstado findByCodigo(String codigo, ISesion aSesion)
			throws BaseException {
		return (CategAccesoEstado) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(estado, "Debe ingresar el Estado");
		Validar.noNulo(categoria, "Debe ingresar la Categoría");
	}

	public static List getCategAccesoEstados(EstadoCIP estado, ISesion aSesion)
			throws BaseException {
		return DBCategAccesoEstado.getCategAccesoEstados(estado, aSesion);
	}

	public static CategAccesoEstado getCategAccesoEstado(EstadoCIP estado,
			CategAccesoCIP categoria, ISesion aSesion) throws BaseException {
		return DBCategAccesoEstado.getCategAccesoEstado(estado, categoria,
				aSesion);
	}

}
