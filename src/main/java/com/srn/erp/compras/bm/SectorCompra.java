package com.srn.erp.compras.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.compras.da.DBSectorCompra;
import com.srn.erp.general.bm.IValorClasificadorEntidad;
import com.srn.erp.general.bm.Sucursal;
import com.srn.erp.stock.bm.Producto;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class SectorCompra extends ObjetoLogico {

	public SectorCompra() {
	}

	public static String NICKNAME = "cp.SectorCompra";

	private String codigo;

	private String descripcion;

	private Boolean activo;

	private Sucursal sucursal;

	private List usuariosHabReq = new ArrayList();

	private boolean readUsuariosHabReq = true;

	public String getCodigo() throws BaseException {
		supportRefresh();
		return codigo;
	}

	public void setCodigo(String aCodigo) {
		this.codigo = aCodigo;
	}

	public Sucursal getSucursal() throws BaseException {
		supportRefresh();
		return sucursal;
	}

	public void setSucursal(Sucursal aSucursal) {
		this.sucursal = aSucursal;
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

	public static SectorCompra findByOid(Integer oid, ISesion aSesion)
			throws BaseException {
		return (SectorCompra) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static SectorCompra findByOidProxy(Integer oid, ISesion aSesion)
			throws BaseException {
		return (SectorCompra) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static SectorCompra findByCodigo(String codigo, ISesion aSesion)
			throws BaseException {
		return (SectorCompra) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(codigo, "Debe ingresar el Código");
		Validar.noNulo(descripcion, "Debe ingresar la Descripción");
		Validar.noNulo(sucursal, "Debe ingresar la Sucursal");
	}

	public List getUsuariosHabReq() throws BaseException {
		if (readUsuariosHabReq) {
			List listaUsuariosHabReq = UsuarioHabilitadoRequisicion
					.getUsuariosHabReq(this, getSesion());
			usuariosHabReq.addAll(listaUsuariosHabReq);
			readUsuariosHabReq = false;
		}
		return usuariosHabReq;
	}

	public void addUsuarioHabilitadoRequisicion(
			UsuarioHabilitadoRequisicion usuHabReq) throws BaseException {
		usuHabReq.setSector_compra(this);
		usuariosHabReq.add(usuHabReq);
	}

	public void afterSave() throws BaseException {
		Iterator iterUsuHabReq = usuariosHabReq.iterator();
		while (iterUsuHabReq.hasNext()) {
			UsuarioHabilitadoRequisicion usuHabReq = (UsuarioHabilitadoRequisicion) iterUsuHabReq
					.next();
			usuHabReq.save();
			usuHabReq = null;
		}
		iterUsuHabReq = null;
	}

	public static List getSectoresCompras(Usuario usuario, ISesion aSesion)
			throws BaseException {
		return DBSectorCompra.getSectoresCompras(usuario, aSesion);
	}
	
	public static List getSectoresCompras(ISesion aSesion)
		throws BaseException {
		return DBSectorCompra.getSectoresCompras(aSesion);
	}
	
	
	public List getAutorizadoresRequisicion(Producto producto) throws BaseException {
		EsquemaAutorizCompras esquema = EsquemaAutorizCompras.getEsqVigAutorizReq(getSesion());
		if (esquema == null)
			return null;
		IValorClasificadorEntidad valClasifEnt = producto.getValorClasifEnt(esquema.getClasificadorEntidad());
		if (valClasifEnt == null)
			return null;
			//throw new ExceptionValidation(null,"El producto "+producto.getCodigo()+" - "+producto.getDescripcion()+" no tiene un valor de "+esquema.getClasificadorEntidad().getDescripcion()+ " para definir la Autorización");
		return AutorizadorRequisicion.getAutorizadoresRequisicion(esquema,this,valClasifEnt,getSesion());
	}		
			

}
