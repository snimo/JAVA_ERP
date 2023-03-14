package com.srn.erp.ventas.bm;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.general.bm.Empresa;
import com.srn.erp.general.bm.IValorClasificadorEntidad;
import com.srn.erp.general.bm.Sucursal;
import com.srn.erp.general.bm.UnidadOrganizativa;
import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.bm.UnidadMedida;
import com.srn.erp.ventas.da.DBListaPrecios;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Parametros.ValorParametro;
import framework.applicarionServer.bm.Varios.CalculadorMoney;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.Validar;

public class ListaPrecios extends ObjetoLogico {

	public ListaPrecios() {
	}

	public static String		NICKNAME									= "ve.ListaPrecios";

	private String					codigo;

	private String					descripcion;

	private String					comentario;

	private java.util.Date	fec_Vig_Desde;

	private java.util.Date	fec_Vig_Hasta;

	private Boolean					activo;

	private Boolean					incluyeIVA;

	private List						unidadesOrganizativas			= new ArrayList();

	private boolean					readUnidadesOrganizativas	= true;

	public void setCodigo(String aCodigo) {
		this.codigo = aCodigo;
	}

	public String getCodigo() throws BaseException {
		supportRefresh();
		return codigo;
	}

	public void setIncluyeIVA(Boolean aIncluyeIVA) {
		this.incluyeIVA = aIncluyeIVA;
	}

	public Boolean isIncluyeIVA() throws BaseException {
		supportRefresh();
		return this.incluyeIVA;
	}

	public String getDescripcion() throws BaseException {
		supportRefresh();
		return descripcion;
	}

	public void setDescripcion(String aDescripcion) {
		this.descripcion = aDescripcion;
	}

	public String getComentario() throws BaseException {
		supportRefresh();
		return comentario;
	}

	public void setComentario(String aComentario) {
		this.comentario = aComentario;
	}

	public java.util.Date getFec_vig_desde() throws BaseException {
		supportRefresh();
		return fec_Vig_Desde;
	}

	public void setFec_vig_desde(java.util.Date aFec_vig_desde) {
		this.fec_Vig_Desde = aFec_vig_desde;
	}

	public java.util.Date getFec_vig_hasta() throws BaseException {
		supportRefresh();
		return fec_Vig_Hasta;
	}

	public void setFec_vig_hasta(java.util.Date aFec_vig_hasta) {
		this.fec_Vig_Hasta = aFec_vig_hasta;
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

	public static ListaPrecios findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (ListaPrecios) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static ListaPrecios findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (ListaPrecios) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static ListaPrecios findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (ListaPrecios) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(codigo, "Debe ingresar el código");
		Validar.noNulo(descripcion, "Debe ingresar la descripción");
		Validar.noNulo(fec_Vig_Desde, "Debe ingresar la Fecha de Vigencia Desde");
		Validar.noNulo(fec_Vig_Hasta, "Debe ingresar la Fecha de Vigencia Hasta");
	}

	public static List getListaPrecios(boolean soloVigentes, boolean soloHabilitadas, ISesion aSesion)
			throws BaseException {
		return DBListaPrecios.getListaPrecios(soloVigentes, soloHabilitadas, aSesion);
	}

	public boolean isVigenteAFecha(java.util.Date aFecha) throws BaseException {
		if (getFec_vig_desde()==null) return false;
		if (getFec_vig_hasta()==null) return false;
		return ((getFec_vig_desde().getTime() <= aFecha.getTime()) && (getFec_vig_hasta().getTime() >= aFecha.getTime()));
	}

	public List getUnidadesOrganizativas() throws BaseException {
		if (readUnidadesOrganizativas) {
			List listaUniOrg = ListaPreciosPorUniOrg.getUniOrgPorLP(this, getSesion());
			unidadesOrganizativas.addAll(listaUniOrg);
			readUnidadesOrganizativas = false;
		}
		return unidadesOrganizativas;
	}

	public void addUnidadOrganizativa(ListaPreciosPorUniOrg listaPreciosPorUniOrg) throws BaseException {
		listaPreciosPorUniOrg.setLista_precios(this);
		unidadesOrganizativas.add(listaPreciosPorUniOrg);
	}

	public void afterSave() throws BaseException {
		Iterator iterListaPreciosPorUniOrg = unidadesOrganizativas.iterator();
		while (iterListaPreciosPorUniOrg.hasNext()) {
			ListaPreciosPorUniOrg listaPreciosPorUniOrg = (ListaPreciosPorUniOrg) iterListaPreciosPorUniOrg.next();
			listaPreciosPorUniOrg.save();
			listaPreciosPorUniOrg = null;
		}
		iterListaPreciosPorUniOrg = null;
	}

	public static List getListaPreciosHabUniOrg(UnidadOrganizativa uniOrg, java.util.Date aFecha, ISesion aSesion)
			throws BaseException {
		List lista = new ArrayList();
		HashTableDatos listaPrecios = new HashTableDatos();
		List listaUniOrgPorLP = ListaPreciosPorUniOrg.getUniOrgPorLP(uniOrg, aSesion);
		Iterator iterLPHabUniOrg = listaUniOrgPorLP.iterator();
		while (iterLPHabUniOrg.hasNext()) {
			ListaPreciosPorUniOrg listaPreciosPorUniOrg = (ListaPreciosPorUniOrg) iterLPHabUniOrg.next();
			Integer oidListaPrecio = listaPreciosPorUniOrg.getLista_precios().getOIDInteger();
			ListaPrecios lp = listaPreciosPorUniOrg.getLista_precios();
			if (!lp.isVigenteAFecha(aFecha))
				continue;
			if (listaPrecios.get(oidListaPrecio) == null)
				listaPrecios.put(lp.getOIDInteger(), lp);
		}
		lista.addAll(listaPrecios.values());
		return lista;
	}

	public static List getListasPreciosVigentesCliente(ISesion aSesion, java.util.Date aFecha, Sujeto sujeto)
			throws BaseException {

		List listasPreciosHabilitadas = new ArrayList();

		Integer oidSucursal = aSesion.getLogin().getOidSucursal();
		Sucursal sucursal = Sucursal.findByOid(oidSucursal, aSesion);

		Integer oidEmpresa = aSesion.getLogin().getOidEmpresa();
		Empresa empresa = Empresa.findByOid(oidEmpresa, aSesion);

		// Obtener para cada Unidad Organizacional las Listas de Precios Habilitadas
		// List listaUniOrg = sucursal.getUniOrgHabilitadas(empresa);
		// Iterator iterUniOrg = listaUniOrg.iterator();
		// while (iterUniOrg.hasNext()) {
		// UnidadOrganizativa uniOrg = (UnidadOrganizativa) iterUniOrg.next();
		// List listaPreciosDeUniOrg = getListaPreciosHabUniOrg(uniOrg,aFecha,aSesion);
		// listasPreciosHabilitadas.addAll(listaPreciosDeUniOrg);
		// }

		// Controlar que no se dupliquen las listas de Precios
		HashTableDatos listaPreciosUnica = new HashTableDatos();
		Iterator iterListaPreciosUnica = listasPreciosHabilitadas.iterator();
		while (iterListaPreciosUnica.hasNext()) {
			ListaPrecios listaPrecios = (ListaPrecios) iterListaPreciosUnica.next();
			if (listaPreciosUnica.get(listaPrecios.getOIDInteger()) == null)
				listaPreciosUnica.put(listaPrecios.getOIDInteger(), listaPrecios);
		}

		// Incluir si fuese necesario las Listas de Precios del Cliente
		List listasDePreciosAsigClie = sujeto.getListasDePreciosVigentes(aFecha);
		Iterator iterListaPreciosVigAsigClie = listasDePreciosAsigClie.iterator();
		while (iterListaPreciosVigAsigClie.hasNext()) {
			ListaPrecios listaPreciosAsigClie = (ListaPrecios) iterListaPreciosVigAsigClie.next();
			if (listaPreciosUnica.get(listaPreciosAsigClie.getOIDInteger()) == null)
				listaPreciosUnica.put(listaPreciosAsigClie.getOIDInteger(), listaPreciosAsigClie);
		}

		// Devolver lista de Precios Unica
		List lista = new ArrayList();
		lista.addAll(listaPreciosUnica.values());

		return lista;
	}

	public List getDetallesPreciosProductos() throws BaseException {
		return ListaPreciosDet.getDetallesListaPrecios(this, getSesion());
	}

	public static ClasificadorEntidad getClasifNro1EstrucLP(ISesion aSesion) throws BaseException {
		Integer oidClasifEntidad = ValorParametro.findByCodigoParametro("CLASIF_TIT_LP_PROD_GRAL", aSesion).getOidObjNeg();
		ClasificadorEntidad clasifEntidad = ClasificadorEntidad.findByOid(oidClasifEntidad, aSesion);
		return clasifEntidad;
	}

	public static ListaPrecios getLPDefaultVtaAlPublico(ISesion aSesion) throws BaseException {
		Integer oid = ValorParametro.findByCodigoParametro("LP_DEFAULT_VTA_PUB", aSesion).getOidObjNeg();
		ListaPrecios listaPrecios = ListaPrecios.findByOid(oid, aSesion);
		return listaPrecios;
	}

	public static ClasificadorEntidad getClasifNro2EstrucLP(ISesion aSesion) throws BaseException {
		Integer oidClasifEntidad = ValorParametro.findByCodigoParametro("CLASIF_ART_2_ESTRUC_LP", aSesion).getOidObjNeg();
		ClasificadorEntidad clasifEntidad = ClasificadorEntidad.findByOid(oidClasifEntidad, aSesion);
		return clasifEntidad;
	}

	public static DefEstrucLPCab getDefEstrucCabLPDefault(ISesion aSesion) throws BaseException {
		Integer oidDefEstrucLPCab = ValorParametro.findByCodigoParametro("ESTRUC_LP_CAB_DEFAULT", aSesion).getOidObjNeg();
		DefEstrucLPCab defEstrucLPCab = DefEstrucLPCab.findByOid(oidDefEstrucLPCab, aSesion);
		return defEstrucLPCab;
	}

	public static UnidadMedida getUMDefault(ISesion aSesion) throws BaseException {
		Integer oidUM = ValorParametro.findByCodigoParametro("UM_DEFULT_LP", aSesion).getOidObjNeg();
		UnidadMedida unidadMedida = UnidadMedida.findByOid(oidUM, aSesion);
		return unidadMedida;
	}

	public List getListaDefEstrucLPNotInListaPrecios() throws BaseException {
		return DefEstrucLPDet.getListaDefEstrucLPNotInListaPrecios(this, this.getDefEstrucCabLPDefault(this.getSesion()),
				this.getSesion());
	}

	public ListaPreciosDet getListaPreciosDet(Producto producto) throws BaseException {
		return ListaPreciosDet.getListaPrecioDetByListaProducto(this, producto, null, this.getSesion());
	}

	public PrecioEnLP getPrecioListaSinIVA(Producto producto, Date fecVigImpu) throws BaseException {

		PrecioEnLP listaPreciosDet = this.getPrecioLista(producto);
		if (listaPreciosDet != null) {
			PrecioEnLP precio = new PrecioEnLP();
			precio.setMoneda(listaPreciosDet.getMoneda());
			if (this.isIncluyeIVA().booleanValue() == false)
				precio.setPrecio(listaPreciosDet.getPrecio());
			else {
				Money precioConIVA = listaPreciosDet.getPrecio();
				CalculadorMoney montoSinIVA = new CalculadorMoney(precioConIVA);
				montoSinIVA.restar(producto.getMontoIVADePrecioIVAInluido(fecVigImpu, precioConIVA));
				precio.setPrecio(montoSinIVA.getResultMoney());
			}
			precio.setUm(listaPreciosDet.getUm());
			precio.setCantidad(new Money(listaPreciosDet.getCantidad().doubleValue()));
			return precio;
		}

		ClasificadorEntidad clasifArt2 = getClasifNro2EstrucLP(this.getSesion());

		PrecioPorEstrucLP precioPorEstruc = getPrecioPorClasifArt(producto.getValorClasifEnt(clasifArt2));

		if (precioPorEstruc != null) {
			PrecioEnLP precio = new PrecioEnLP();
			precio.setMoneda(precioPorEstruc.getMoneda());
			precio.setPrecio(new Money(precioPorEstruc.getPrecio().doubleValue()));

			if (this.isIncluyeIVA().booleanValue() == false)
				precio.setPrecio(new Money(precioPorEstruc.getPrecio().doubleValue()));
			else {
				Money precioConIVA = new Money(precioPorEstruc.getPrecio().doubleValue());
				CalculadorMoney montoSinIVA = new CalculadorMoney(precioConIVA);
				montoSinIVA.restar(producto.getMontoIVADePrecioIVAInluido(fecVigImpu, precioConIVA));
				precio.setPrecio(montoSinIVA.getResultMoney());
			}

			precio.setUm(precioPorEstruc.getUnidad_medida());
			precio.setCantidad(new Money(precioPorEstruc.getCantidad().doubleValue()));
			return precio;
		}

		return null;

	}

	public PrecioEnLP getPrecioListaConIVA(Producto producto, Date fecVigImpu) throws BaseException {

		PrecioEnLP listaPreciosDet = this.getPrecioLista(producto);
		if (listaPreciosDet != null) {
			PrecioEnLP precio = new PrecioEnLP();
			precio.setMoneda(listaPreciosDet.getMoneda());
			if (this.isIncluyeIVA().booleanValue() == true)
				precio.setPrecio(listaPreciosDet.getPrecio());
			else {
				Money precioSinIVA = listaPreciosDet.getPrecio();
				precio.setPrecio(producto.getPrecioConsumidorFinal(fecVigImpu, precioSinIVA));
			}
			precio.setUm(listaPreciosDet.getUm());
			precio.setCantidad(new Money(listaPreciosDet.getCantidad().doubleValue()));
			return precio;
		}

		ClasificadorEntidad clasifArt2 = getClasifNro2EstrucLP(this.getSesion());

		PrecioPorEstrucLP precioPorEstruc = getPrecioPorClasifArt(producto.getValorClasifEnt(clasifArt2));

		if (precioPorEstruc != null) {
			PrecioEnLP precio = new PrecioEnLP();
			precio.setMoneda(precioPorEstruc.getMoneda());
			precio.setPrecio(new Money(precioPorEstruc.getPrecio().doubleValue()));

			if (this.isIncluyeIVA().booleanValue() == true)
				precio.setPrecio(new Money(precioPorEstruc.getPrecio().doubleValue()));
			else {
				Money precioSinIVA = new Money(precioPorEstruc.getPrecio().doubleValue());
				precio.setPrecio(producto.getPrecioConsumidorFinal(fecVigImpu, precioSinIVA));
			}

			precio.setUm(precioPorEstruc.getUnidad_medida());
			precio.setCantidad(new Money(precioPorEstruc.getCantidad().doubleValue()));
			return precio;
		}

		return null;

	}

	public PrecioEnLP getPrecioLista(Producto producto) throws BaseException {

		ListaPreciosDet listaPreciosDet = producto.getListaPreciosDet(this);
		if (listaPreciosDet != null) {
			PrecioEnLP precio = new PrecioEnLP();
			precio.setMoneda(listaPreciosDet.getMoneda());
			precio.setPrecio(listaPreciosDet.getPrecio());
			precio.setUm(listaPreciosDet.getUnidad_medida());
			precio.setCantidad(new Money(listaPreciosDet.getCantidad().doubleValue()));
			return precio;
		}

		// ClasificadorEntidad clasifArt1 =
		// getClasifNro1EstrucLP(this.getSesion());

		ClasificadorEntidad clasifArt2 = getClasifNro2EstrucLP(this.getSesion());

		PrecioPorEstrucLP precioPorEstruc = getPrecioPorClasifArt(producto.getValorClasifEnt(clasifArt2));

		if (precioPorEstruc != null) {
			PrecioEnLP precio = new PrecioEnLP();
			precio.setMoneda(precioPorEstruc.getMoneda());
			precio.setPrecio(new Money(precioPorEstruc.getPrecio().doubleValue()));
			precio.setUm(precioPorEstruc.getUnidad_medida());
			precio.setCantidad(new Money(precioPorEstruc.getCantidad().doubleValue()));
			return precio;
		}

		return null;

	}

	public PrecioPorEstrucLP getPrecioPorClasifArt(IValorClasificadorEntidad valClasifEnt1)
			throws BaseException {

		if (valClasifEnt1 == null)
			return null;
		else
			return PrecioPorEstrucLP.getPrecioEstrucLPBYClasificadores(this, valClasifEnt1, this.getSesion());
	}

	public static ListaPrecios getListaPreciosDefaultFactRtos(ISesion aSesion) throws BaseException {
		Integer oidLP = ValorParametro.findByCodigoParametro("LP_DEFAULT_FACT_RTO", aSesion).getOidObjNeg();
		ListaPrecios lp = ListaPrecios.findByOid(oidLP, aSesion);
		return lp;
	}
	
	public void validarPrecioEnLP(Producto producto) throws BaseException {

		PrecioEnLP precio = producto.getPrecioLista(this , null);

		if ((precio == null) && (producto.isPrecioNoDefLP() == false)
				&& (FacturaCab.isPermitirFactVtaMosSinPrecio(this.getSesion()) == false))
			throw new ExceptionValidation(null, "No se pudo obtener el Precio para el producto " + producto.getDescripcion()
					+ " y la lista de precios " + this.getDescripcion());

	}
	
	  public static List getTodasLasListas(ISesion aSesion) throws BaseException {
		  return DBListaPrecios.getTodasLasListas(aSesion);
	  }
	  
	  public List getPreciosClasifArtPorLP(List valoresClasificador) throws BaseException {
		return PrecioPorEstrucLP.getPreciosClasifArtPorLP(this,valoresClasificador,this.getSesion());
	  }
	  
	  public List getValoresClasifProdGralNotInLP()
		throws BaseException {
			return ValorClasificadorEntidad.getValoresClasifProdGralNotInLP(this,this.getSesion()); 
	  }
	  
	  

}