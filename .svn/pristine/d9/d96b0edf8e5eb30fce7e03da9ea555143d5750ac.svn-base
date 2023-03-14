package com.srn.erp.stock.bm;

import java.util.List;

import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.stock.da.DBConfConsGenStockFil;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.Validar;

public class ConfConsGenStockFil extends ObjetoLogico {

	public ConfConsGenStockFil() {
	}

	public static String NICKNAME = "st.ConfConsGenStockFil";

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	private ConfConsGenStock conf_cons_stock;
	private ClasificadorEntidad clasificador_entidad;
	private Boolean filtra_por_codigo;
	private Boolean filtra_por_desc;
	private Boolean activo;
	private Integer orden_por_desc;
	private Integer orden_por_codigo;

	public ConfConsGenStock getConf_cons_stock() throws BaseException {
		supportRefresh();
		return conf_cons_stock;
	}

	public void setConf_cons_stock(ConfConsGenStock aConf_cons_stock) {
		this.conf_cons_stock = aConf_cons_stock;
	}

	public Integer getOrdenPorCodigo() throws BaseException {
		supportRefresh();
		return this.orden_por_codigo;
	}

	public void setOrdenPorCodigo(Integer aOrdenPorCodigo) {
		this.orden_por_codigo = aOrdenPorCodigo;
	}

	public Integer getOrdenPorDesc() throws BaseException {
		supportRefresh();
		return this.orden_por_desc;
	}

	public void setOrdenPorDesc(Integer aOrdenPorDesc) {
		this.orden_por_desc = aOrdenPorDesc;
	}

	public ClasificadorEntidad getClasificador_entidad() throws BaseException {
		supportRefresh();
		return clasificador_entidad;
	}

	public void setClasificador_entidad(ClasificadorEntidad aClasificador_entidad) {
		this.clasificador_entidad = aClasificador_entidad;
	}

	public Boolean isFiltra_por_codigo() throws BaseException {
		supportRefresh();
		return filtra_por_codigo;
	}

	public void setFiltra_por_codigo(Boolean aFiltra_por_codigo) {
		this.filtra_por_codigo = aFiltra_por_codigo;
	}

	public Boolean isFiltra_por_desc() throws BaseException {
		supportRefresh();
		return filtra_por_desc;
	}

	public void setFiltra_por_desc(Boolean aFiltra_por_desc) {
		this.filtra_por_desc = aFiltra_por_desc;
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

	public static ConfConsGenStockFil findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (ConfConsGenStockFil) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static ConfConsGenStockFil findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (ConfConsGenStockFil) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(conf_cons_stock, "Debe ingresar la Configuración");
		Validar.noNulo(clasificador_entidad, "Debe ingresar el Clasificador de Entidad");
	}

	public static List getConfStockFiltros(ConfConsGenStock confConsStk, ISesion aSesion) throws BaseException {
		return DBConfConsGenStockFil.getConfStockFiltros(confConsStk, aSesion);
	}

	public static List getConfStockFiltrosPorCodigo(ConfConsGenStock confConsStk, ISesion aSesion) throws BaseException {
		return DBConfConsGenStockFil.getConfStockFiltrosPorCodigo(confConsStk, aSesion);
	}
	
	public static List getConfStockFiltrosPorDesc(ConfConsGenStock confConsStk, ISesion aSesion) throws BaseException {
		return DBConfConsGenStockFil.getConfStockFiltrosPorDesc(confConsStk, aSesion);
	}
	

}
