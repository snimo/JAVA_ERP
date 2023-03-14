package com.srn.erp.stock.bm;

import java.util.Iterator;
import java.util.List;

import com.srn.erp.general.bm.ValorClasifEntProdGen;
import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.stock.da.DBSeguimientoStock;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.Validar;

public class SeguimientoStock extends ObjetoLogico {

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

	public SeguimientoStock() {
	}

	public static String NICKNAME = "st.SeguimientoStock";

	private Producto producto;
	private AgrupadorDeposito agrupador_deposito;
	private Money punto_pedido;
	private Money stock_deseado;
	private ValorClasificadorEntidad valClasifEnt;

	public Producto getProducto() throws BaseException {
		supportRefresh();
		return producto;
	}

	public void setProducto(Producto aProducto) {
		this.producto = aProducto;
	}

	public ValorClasificadorEntidad getValClasifEnt() throws BaseException {
		supportRefresh();
		return this.valClasifEnt;
	}

	public void setValClasifEnt(ValorClasificadorEntidad aValClasifEnt) {
		this.valClasifEnt = aValClasifEnt;
	}

	public AgrupadorDeposito getAgrupador_deposito() throws BaseException {
		supportRefresh();
		return agrupador_deposito;
	}

	public void setAgrupador_deposito(AgrupadorDeposito aAgrupador_deposito) {
		this.agrupador_deposito = aAgrupador_deposito;
	}

	public Money getPunto_pedido() throws BaseException {
		supportRefresh();
		return punto_pedido;
	}

	public void setPunto_pedido(Money aPunto_pedido) {
		this.punto_pedido = aPunto_pedido;
	}

	public Money getStock_deseado() throws BaseException {
		supportRefresh();
		return stock_deseado;
	}

	public void setStock_deseado(Money aStock_deseado) {
		this.stock_deseado = aStock_deseado;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static SeguimientoStock findByOid(Integer oid, ISesion aSesion)
			throws BaseException {
		return (SeguimientoStock) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static SeguimientoStock findByCodigo(String codigo, ISesion aSesion)
			throws BaseException {
		return (SeguimientoStock) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {

		if ((producto == null) && (valClasifEnt == null))
			throw new ExceptionValidation(null, "Debe ingresar un producto");

		Validar.noNulo(agrupador_deposito,
				"Debe ingresar el Agrupador Deposito");
		Validar.noNulo(punto_pedido, "Debe ingresar el Punto de Pedido");
		Validar.noNulo(stock_deseado, "Debe ingresar el Stock deseado");
	}

	public static List getSeguimientosStock(Producto producto, ISesion aSesion)
			throws BaseException {
		return DBSeguimientoStock.getSeguimientosStock(producto, aSesion);
	}

	public static List getSeguimientosStock(
			ValorClasificadorEntidad valClasifEnt, ISesion aSesion)
			throws BaseException {
		return DBSeguimientoStock.getSeguimientosStock(valClasifEnt, aSesion);
	}

	public void afterSave() throws BaseException {

		super.afterSave();

	}

	@Override
	public void afterSaveNew() throws BaseException {
		// TODO Auto-generated method stub
		super.afterSaveNew();
		
		/*
		
		// Dar de alta a nivel producto de Stock
		if (this.getValClasifEnt()!=null) {
			
			ValorClasifEntProdGen valClasifEntProdGral = ValorClasifEntProdGen.findByOid(this.getValClasifEnt().getOIDInteger(), this.getSesion());
			
			Iterator iterProductos = valClasifEntProdGral.getProductos().iterator();
			while (iterProductos.hasNext()) {
				Producto producto = (Producto) iterProductos.next();
				
				SeguimientoStock seguiStock = (SeguimientoStock) SeguimientoStock.getNew(SeguimientoStock.NICKNAME, this.getSesion());
				seguiStock.setProducto(producto);
				seguiStock.setAgrupador_deposito(this.getAgrupador_deposito());
				seguiStock.setPunto_pedido(this.getPunto_pedido());
				seguiStock.setStock_deseado(this.getStock_deseado());
				seguiStock.setValClasifEnt(null);
				producto.addSeguimientoStock(seguiStock);
				
				producto.save();
				
				
			}
			
			
		}*/
		
	}

	@Override
	public void afterSaveDelete() throws BaseException {
		// TODO Auto-generated method stub
		super.afterSaveDelete();
		
		/*
		// Dar de alta a nivel producto de Stock
		if (this.getValClasifEnt()!=null) {
			
			ValorClasifEntProdGen valClasifEntProdGral = ValorClasifEntProdGen.findByOid(this.getValClasifEnt().getOIDInteger(), this.getSesion());
			
			Iterator iterProductos = valClasifEntProdGral.getProductos().iterator();
			while (iterProductos.hasNext()) {
				Producto producto = (Producto) iterProductos.next();
				
				SeguimientoStock seguiStock = SeguimientoStock.getSeguimientoStock(producto, this.getAgrupador_deposito(),this.getSesion());
				if (seguiStock!=null) {
					seguiStock.delete();
					seguiStock.save();
				}
				
				
				
				
			}
			
			
		}*/
		
		
		
	}

	@Override
	public void afterSaveModified() throws BaseException {
		// TODO Auto-generated method stub
		super.afterSaveModified();
		
		// Dar de alta a nivel producto de Stock
		if (this.getValClasifEnt()!=null) {
			
			ValorClasifEntProdGen valClasifEntProdGral = ValorClasifEntProdGen.findByOid(this.getValClasifEnt().getOIDInteger(), this.getSesion());
			
			Iterator iterProductos = valClasifEntProdGral.getProductos().iterator();
			while (iterProductos.hasNext()) {
				Producto producto = (Producto) iterProductos.next();
				
				SeguimientoStock seguiStock = SeguimientoStock.getSeguimientoStock(producto, this.getAgrupador_deposito(),this.getSesion());
				if (seguiStock == null)
					seguiStock = (SeguimientoStock) SeguimientoStock.getNew(SeguimientoStock.NICKNAME, this.getSesion()); 
				seguiStock.setProducto(producto);
				seguiStock.setAgrupador_deposito(this.getAgrupador_deposito());
				seguiStock.setPunto_pedido(this.getPunto_pedido());
				seguiStock.setStock_deseado(this.getStock_deseado());
				seguiStock.setValClasifEnt(null);
				producto.addSeguimientoStock(seguiStock);
				
				producto.save();
				
				
			}
			
			
		}
		
	}
	
	  public static SeguimientoStock getSeguimientoStock(
			  Producto producto,
			  AgrupadorDeposito agrupadorDeposito,
	          ISesion aSesion) throws BaseException {
		  HashTableDatos condiciones = new HashTableDatos();
		  condiciones.put(Producto.NICKNAME, producto);
		  condiciones.put(AgrupadorDeposito.NICKNAME, agrupadorDeposito);
		  
		  return DBSeguimientoStock.getSeguimientoStock(producto,agrupadorDeposito,aSesion);
	  }
	

}
