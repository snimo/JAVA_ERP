package com.srn.erp.costos.bm;

import java.util.Hashtable;
import java.util.List;

import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.general.bm.IEntidadClasificable;
import com.srn.erp.general.bm.ValorClasificadorEntidad;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class CentroCostos extends ObjetoLogico implements IEntidadClasificable {

	public CentroCostos() {
	}

	public static String NICKNAME = "co.CentroCostos";

	private String codigo;
	private String descripcion;
	private Boolean activo;

	private Hashtable listaOidValClasif = new Hashtable();

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

	public static CentroCostos findByOid(Integer oid, ISesion aSesion)
			throws BaseException {
		return (CentroCostos) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static CentroCostos findByCodigo(String codigo, ISesion aSesion)
			throws BaseException {
		return (CentroCostos) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(codigo, "Debe ingresar el código");
		Validar.noNulo(descripcion, "Debe ingresar la Descripción");
	}

	public void addOidValorClasif(Integer nroClasif, Integer aValor) {
		if (aValor == null)
			listaOidValClasif.put(nroClasif, new Integer(0));
		else
			listaOidValClasif.put(nroClasif, aValor);
	}

	public Integer getOidValorClasif(Integer nroClasif) throws BaseException {
		supportRefresh();
		if (listaOidValClasif.get(nroClasif) != null)
			return (Integer) listaOidValClasif.get(nroClasif);
		else
			return new Integer(0);
	}

	public ValorClasificadorEntidad getValorClasifEnt(
			ClasificadorEntidad clasifEnt) throws BaseException {
		ValorClasificadorEntidad valClasifEnt = null;
		Integer oidValClasifEnt = (Integer) listaOidValClasif.get(clasifEnt
				.getNroClasif());
		if (oidValClasifEnt != null)
			valClasifEnt = ValorClasificadorEntidad.findByOid(oidValClasifEnt,
					getSesion());
		return valClasifEnt;
	}

	public List getClasifEntidadesActivas() throws BaseException {
		return ClasificadorEntidad.getClasificadoresEntidadActivos(
				CentroCostos.NICKNAME, true, getSesion());
	}

	public static List getClasificadoresEntidadActivos(ISesion aSesion)
			throws BaseException {
		return ClasificadorEntidad.getClasificadoresEntidad(
				CentroCostos.NICKNAME, true, aSesion);
	}

}
