package com.srn.erp.ventas.bm;

import java.util.Iterator;
import java.util.List;

import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.general.bm.ValorClasifEntProdGen;
import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.ventas.da.DBConfProdGralPorLP;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class ConfProdGralPorLP extends ObjetoLogico {

	public ConfProdGralPorLP() {
	}

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

	public static String NICKNAME = "ve.ConfProdGralPorLP";

	private ListaPrecios lista_precios;
	private ClasificadorEntidad clasificador;
	private Money porc_rent_sug;
	private ValorClasificadorEntidad valor_clasif_ent;

	public ListaPrecios getLista_precios() throws BaseException {
		supportRefresh();
		return lista_precios;
	}

	public void setLista_precios(ListaPrecios aLista_precios) {
		this.lista_precios = aLista_precios;
	}

	public ClasificadorEntidad getClasificador() throws BaseException {
		supportRefresh();
		return clasificador;
	}

	public void setClasificador(ClasificadorEntidad aClasificador) {
		this.clasificador = aClasificador;
	}

	public Money getPorc_rent_sug() throws BaseException {
		supportRefresh();
		return porc_rent_sug;
	}

	public void setPorc_rent_sug(Money aPorc_rent_sug) {
		this.porc_rent_sug = aPorc_rent_sug;
	}

	public ValorClasificadorEntidad getValor_clasif_ent() throws BaseException {
		supportRefresh();
		return valor_clasif_ent;
	}

	public void setValor_clasif_ent(ValorClasificadorEntidad aValor_clasif_ent) {
		this.valor_clasif_ent = aValor_clasif_ent;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static ConfProdGralPorLP findByOid(Integer oid, ISesion aSesion)
			throws BaseException {
		return (ConfProdGralPorLP) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static ConfProdGralPorLP findByCodigo(String codigo, ISesion aSesion)
			throws BaseException {
		return (ConfProdGralPorLP) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(lista_precios, "Debe ingresar la Lista de Precios");
		Validar.noNulo(clasificador, "Debe ingresar el clasificador");
		Validar.noNulo(valor_clasif_ent,
				"Debe ingresar el Valor de clasificador");
	}

	public static ConfProdGralPorLP getConfProdPorLP(
			ValorClasificadorEntidad valClasifEnt, ListaPrecios lp,
			ISesion aSesion) throws BaseException {
		return DBConfProdGralPorLP.getConfProdPorLP(valClasifEnt, lp, aSesion);
	}
	
	public ConfProdGralPorLP getConfProdPorLP(ListaPrecios lp) throws BaseException {
		return DBConfProdGralPorLP.getConfProdPorLP(this.getValor_clasif_ent(), lp, this.getSesion());
	}	

	public static List getConfProdPorValorClasif(
			ValorClasificadorEntidad valClasifEnt, ISesion aSesion)
			throws BaseException {
		return DBConfProdGralPorLP.getConfProdPorValorClasif(valClasifEnt,
				aSesion);
	}
	
	public void afterSave() throws BaseException {

		super.afterSave();
		
		/* Lo comento porque no me parece necesario */
		
		/*
		ValorClasifEntProdGen valClasifEntProdGral = ValorClasifEntProdGen.findByOid(this.getValor_clasif_ent().getOIDInteger(), this.getSesion());
		
		if (valClasifEntProdGral!=null) {
			
			Iterator iterProductos = valClasifEntProdGral.getProductos().iterator();
			while (iterProductos.hasNext()) {
				Producto producto = (Producto) iterProductos.next();
				ConfProdPorLP confProdPorLP = producto.getConfProdPorLP(this.getLista_precios());
				if (confProdPorLP == null)
					confProdPorLP = (ConfProdPorLP) ConfProdPorLP.getNew(ConfProdPorLP.NICKNAME, this.getSesion()); 
				confProdPorLP.setProducto(producto);
				confProdPorLP.setLista_precios(this.getLista_precios());
				if (this.getPorc_rent_sug()!=null)
					confProdPorLP.setPorc_rent_sug(this.getPorc_rent_sug().doubleValue());
				else
					confProdPorLP.setPorc_rent_sug(null);
				confProdPorLP.save();
			}
			
		}*/

		
	}
		
	

}
