package com.srn.erp.compras.bm;

import java.util.List;

import com.srn.erp.compras.da.DBUsuarioHabilitadoRequisicion;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class UsuarioHabilitadoRequisicion extends ObjetoLogico {

	public Boolean isActivo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public UsuarioHabilitadoRequisicion() {
	}

	public static String NICKNAME = "cp.UsuarioHabilitadoRequisicion";

	private SectorCompra sector_compra;

	private Usuario usuario;

	public SectorCompra getSector_compra() throws BaseException {
		supportRefresh();
		return sector_compra;
	}

	public void setSector_compra(SectorCompra aSector_compra) {
		this.sector_compra = aSector_compra;
	}

	public Usuario getUsuario() throws BaseException {
		supportRefresh();
		return usuario;
	}

	public void setUsuario(Usuario aUsuario) {
		this.usuario = aUsuario;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static UsuarioHabilitadoRequisicion findByOid(Integer oid,
			ISesion aSesion) throws BaseException {
		return (UsuarioHabilitadoRequisicion) getObjectByOid(NICKNAME, oid,
				aSesion);
	}

	public static UsuarioHabilitadoRequisicion findByCodigo(String codigo,
			ISesion aSesion) throws BaseException {
		return (UsuarioHabilitadoRequisicion) getObjectByCodigo(NICKNAME,
				codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(sector_compra, "Debe ingresar el Sector de Compra");
		Validar.noNulo(usuario, "Debe ingresar el Usuario");
	}

	public static List getUsuariosHabReq(SectorCompra sectorCompra,
			ISesion aSesion) throws BaseException {
		return DBUsuarioHabilitadoRequisicion.getUsuariosHabReq(sectorCompra,aSesion);
	}

}
