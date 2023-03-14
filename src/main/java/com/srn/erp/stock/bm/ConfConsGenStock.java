package com.srn.erp.stock.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.stock.da.DBConfConsGenStock;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class ConfConsGenStock extends ObjetoLogico {

	public ConfConsGenStock() {
	}

	public static String NICKNAME = "st.ConfConsGenStock";

	private List depositos = new ArrayList();
	private boolean readDepositos = true;

	private List estados = new ArrayList();
	private boolean readEstados = true;

	private List filtros = new ArrayList();
	private boolean readFiltros = true;

	private String codigo;
	private String descripcion;
	private Boolean activo;
	private String tipo_valor_fila;
	private ClasificadorEntidad clasif_ent_grupo;
	private Boolean totalizar;
	private ClasificadorEntidad clasif_ent_fila;
	private Boolean filtrarProdStockPorCodigo;
	private Boolean filtrarProdStockPorDesc;
	private Boolean consolidarStock;
	private Boolean verColTotFila;

	public String getCodigo() throws BaseException {
		supportRefresh();
		return codigo;
	}

	public void setCodigo(String aCodigo) {
		this.codigo = aCodigo;
	}
	
	public Boolean isVerColTotFila() throws BaseException {
		supportRefresh();
		return this.verColTotFila;
	}

	public void setVerColTotFila(Boolean aVerColTotFila) {
		this.verColTotFila = aVerColTotFila;
	}
	
	
	public Boolean isConsolidarStock() throws BaseException {
		supportRefresh();
		return this.consolidarStock;
	}

	public void setConsolidarStock(Boolean aConsolidarStock) {
		this.consolidarStock = aConsolidarStock;
	}
	

	public Boolean isFiltrarProdStockPorCodigo() throws BaseException {
		supportRefresh();
		return this.filtrarProdStockPorCodigo;
	}

	public void setFiltrarProdStockPorCodigo(Boolean aFiltrarProdStockPorCodigo) {
		this.filtrarProdStockPorCodigo = aFiltrarProdStockPorCodigo;
	}

	public Boolean isFiltrarProdStockPorDesc() throws BaseException {
		supportRefresh();
		return this.filtrarProdStockPorDesc;
	}

	public void setFiltrarProdStockPorDesc(Boolean aFiltrarProdStockPorDesc) {
		this.filtrarProdStockPorDesc = aFiltrarProdStockPorDesc;
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

	public String getTipo_valor_fila() throws BaseException {
		supportRefresh();
		return tipo_valor_fila;
	}

	public void setTipo_valor_fila(String aTipo_valor_fila) {
		this.tipo_valor_fila = aTipo_valor_fila;
	}

	public ClasificadorEntidad getClasif_ent_grupo() throws BaseException {
		supportRefresh();
		return clasif_ent_grupo;
	}

	public void setClasif_ent_grupo(ClasificadorEntidad aClasif_ent_grupo) {
		this.clasif_ent_grupo = aClasif_ent_grupo;
	}

	public Boolean isTotalizar() throws BaseException {
		supportRefresh();
		return totalizar;
	}

	public void setTotalizar(Boolean aTotalizar) {
		this.totalizar = aTotalizar;
	}

	public ClasificadorEntidad getClasif_ent_fila() throws BaseException {
		supportRefresh();
		return clasif_ent_fila;
	}

	public void setClasif_ent_fila(ClasificadorEntidad aClasif_ent_fila) {
		this.clasif_ent_fila = aClasif_ent_fila;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static ConfConsGenStock findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (ConfConsGenStock) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static ConfConsGenStock findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (ConfConsGenStock) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static ConfConsGenStock findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (ConfConsGenStock) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(codigo, "Debe ingresar el Código");
		Validar.noNulo(descripcion, "Debe ingresar la Descripción");
		Validar.noNulo(tipo_valor_fila, "Debe ingresar el tipo de Fila");
	}

	public List getConfDepositos() throws BaseException {
		if (this.readDepositos) {
			List listaDepositos = ConfConsGenStockDepo.getConfConsGenStockDepo(this, getSesion());
			depositos.addAll(listaDepositos);
			this.readDepositos = false;
		}
		return depositos;
	}

	public List getConfEstados() throws BaseException {
		if (this.readEstados) {
			List listaEstados = ConfConsGenStockEst.getConfConsGenStockEst(this, getSesion());
			estados.addAll(listaEstados);
			this.readEstados = false;
		}
		return estados;
	}

	public List getConfFiltros() throws BaseException {
		if (this.readFiltros) {
			List listaFiltros = ConfConsGenStockFil.getConfStockFiltros(this, getSesion());
			filtros.addAll(listaFiltros);
			this.readFiltros = false;
		}
		return filtros;
	}

	public void addConfEstado(ConfConsGenStockEst aConfConsGenStockEst) throws BaseException {
		aConfConsGenStockEst.setConf_cons_stk(this);
		estados.add(aConfConsGenStockEst);
	}

	public void addFiltro(ConfConsGenStockFil aConfConsGenStockFil) throws BaseException {
		aConfConsGenStockFil.setConf_cons_stock(this);
		filtros.add(aConfConsGenStockFil);
	}

	public void addConfDeposito(ConfConsGenStockDepo aConfConsGenStockDepo) throws BaseException {
		aConfConsGenStockDepo.setConf_cons_stk(this);
		depositos.add(aConfConsGenStockDepo);
	}

	public void afterSave() throws BaseException {

		Iterator iterConfDepositos = depositos.iterator();
		while (iterConfDepositos.hasNext()) {
			ConfConsGenStockDepo confConsGenStock = (ConfConsGenStockDepo) iterConfDepositos.next();
			confConsGenStock.save();
			confConsGenStock = null;
		}
		iterConfDepositos = null;

		Iterator iterConfEstados = estados.iterator();
		while (iterConfEstados.hasNext()) {
			ConfConsGenStockEst confConsGenStockEst = (ConfConsGenStockEst) iterConfEstados.next();
			confConsGenStockEst.save();
			confConsGenStockEst = null;
		}
		iterConfEstados = null;

		Iterator iterConfFiltros = filtros.iterator();
		while (iterConfFiltros.hasNext()) {
			ConfConsGenStockFil confConsGenStockFil = (ConfConsGenStockFil) iterConfFiltros.next();
			confConsGenStockFil.save();
			confConsGenStockFil = null;
		}
		iterConfFiltros = null;

	}

	public static List getAllActivos(ISesion aSesion) throws BaseException {
		return DBConfConsGenStock.getAllActivos(aSesion);
	}

	public List getConfStockFiltrosPorCodigo() throws BaseException {
		return ConfConsGenStockFil.getConfStockFiltrosPorCodigo(this, this.getSesion());
	}

	public List getConfStockFiltrosPorDesc() throws BaseException {
		return ConfConsGenStockFil.getConfStockFiltrosPorDesc(this, this.getSesion());

	}
	
	public int getCantEstados() throws BaseException {
		return this.getConfEstados().size();
	}
	
	public int getCantDepositos() throws BaseException {
		return this.getConfDepositos().size();
	}
	
	
	

}
