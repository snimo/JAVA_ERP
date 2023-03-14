package com.srn.erp.stock.bm;

import java.util.List;

import com.srn.erp.stock.da.DBConsultaStock;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;

public class ConsultaStock extends ObjetoLogico {

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean isActivo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public ConsultaStock() {
	}

	public static String NICKNAME = "st.ConsultaStock";

	private Integer oid_producto;
	private String cod_producto;
	private String desc_producto;
	private Double cantidad;
	private Integer oid_um;
	private Integer oid_deposito;

	public Integer getOid_producto() throws BaseException {
		supportRefresh();
		return oid_producto;
	}

	public void setOid_producto(Integer aOid_producto) {
		this.oid_producto = aOid_producto;
	}

	public String getCod_producto() throws BaseException {
		supportRefresh();
		return cod_producto;
	}

	public void setCod_producto(String aCod_producto) {
		this.cod_producto = aCod_producto;
	}

	public String getDesc_producto() throws BaseException {
		supportRefresh();
		return desc_producto;
	}

	public void setDesc_producto(String aDesc_producto) {
		this.desc_producto = aDesc_producto;
	}

	public Double getCantidad() throws BaseException {
		supportRefresh();
		return cantidad;
	}

	public void setCantidad(Double aCantidad) {
		this.cantidad = aCantidad;
	}

	public Integer getOid_um() throws BaseException {
		supportRefresh();
		return oid_um;
	}

	public void setOid_um(Integer aOid_um) {
		this.oid_um = aOid_um;
	}

	public Integer getOid_deposito() throws BaseException {
		supportRefresh();
		return oid_deposito;
	}

	public void setOid_deposito(Integer aOid_deposito) {
		this.oid_deposito = aOid_deposito;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static ConsultaStock findByOid(Integer oid, ISesion aSesion)
			throws BaseException {
		return (ConsultaStock) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static ConsultaStock findByCodigo(String codigo, ISesion aSesion)
			throws BaseException {
		return (ConsultaStock) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
	}

	public static List getConsultaMasivaProductos(Integer oidProducto,String descProducto,
			String codigoProducto, HashTableDatos listaValoresClasif,
			Deposito deposito, java.util.Date fechaHasta, List estadosStock,
			ISesion aSesion) throws BaseException {

		return DBConsultaStock.getConsultaMasivaProductos(oidProducto,descProducto,
				codigoProducto, listaValoresClasif, deposito, fechaHasta,
				estadosStock, aSesion);

	}
	
	public static List getConsultaSaldosEstadosStock(
			List listaDepositos, 
			List listaEstados, 
			HashTableDatos filtrosPorDescClasif,
			String filtroPorDescProdStock,
			HashTableDatos filtrosPorValorClasif,
			Producto producto,
			ISesion aSesion)
			throws BaseException {

		return DBConsultaStock.getConsultaSaldosEstadosStock(
				listaDepositos,
				listaEstados,
				filtrosPorDescClasif,
				filtroPorDescProdStock,
				filtrosPorValorClasif,
				producto,
				aSesion);
	}
	

}
