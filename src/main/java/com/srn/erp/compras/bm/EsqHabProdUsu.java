package com.srn.erp.compras.bm;

import java.util.List;

import com.srn.erp.compras.da.DBEsqHabProdUsu;
import com.srn.erp.general.bm.IValorClasificadorEntidad;
import com.srn.erp.general.bm.ValorClasificadorEntidad;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class EsqHabProdUsu extends ObjetoLogico {

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean isActivo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public EsqHabProdUsu() {
	}

	public static String								NICKNAME	= "cp.EsqHabProdUsu";

	private EsquemaHabilitacionProducto	esquema_habilitacion;

	private ValorClasificadorEntidad		valor_clasificador;

	private Usuario											usuario;

	public EsquemaHabilitacionProducto getEsquema_habilitacion() throws BaseException {
		supportRefresh();
		return esquema_habilitacion;
	}

	public void setEsquema_habilitacion(EsquemaHabilitacionProducto aEsquema_habilitacion) {
		this.esquema_habilitacion = aEsquema_habilitacion;
	}

	public ValorClasificadorEntidad getValor_clasificador() throws BaseException {
		supportRefresh();
		return valor_clasificador;
	}

	public void setValor_clasificador(ValorClasificadorEntidad aValor_clasificador) {
		this.valor_clasificador = aValor_clasificador;
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

	public static EsqHabProdUsu findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (EsqHabProdUsu) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static EsqHabProdUsu findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (EsqHabProdUsu) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(esquema_habilitacion, "Debe ingresar el Esquema");
		Validar.noNulo(valor_clasificador, "Debe ingresar un valor de clasificador");
		Validar.noNulo(usuario, "Debe ingresar un usuario");
	}

	public static List getHabilitacionesProductoUsuario(EsquemaHabilitacionProducto esquemaHabilitacionProducto,
			ISesion aSesion) throws BaseException {
		return DBEsqHabProdUsu.getHabilitacionesProductoUsuario(esquemaHabilitacionProducto, aSesion);
	}

	public static EsqHabProdUsu getEsqHabProdUsu(EsquemaHabilitacionProducto esqHabProd,
			IValorClasificadorEntidad valorClasif, Usuario usuario, ISesion aSesion) throws BaseException {
		return DBEsqHabProdUsu.getEsqHabProdUsu(esqHabProd, valorClasif, usuario, aSesion);
	}

}
