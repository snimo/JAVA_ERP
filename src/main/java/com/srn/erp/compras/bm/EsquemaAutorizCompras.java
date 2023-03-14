package com.srn.erp.compras.bm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.general.bm.Cotizacion;
import com.srn.erp.general.bm.IEntidadClasificable;
import com.srn.erp.general.bm.IValorClasificadorEntidad;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.general.bm.TipoCambio;
import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.stock.bm.ExtensionProdGen;
import com.srn.erp.stock.bm.Producto;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bm.Parametros.ValorParametro;
import framework.applicarionServer.bm.Varios.CalculadorMoney;
import framework.applicarionServer.bm.Varios.Money;
import framework.applicarionServer.bm.Varios.ValorCotizacion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.Validar;

public class EsquemaAutorizCompras extends ObjetoLogico {

	public EsquemaAutorizCompras() {
	}

	public static String				NICKNAME												= "cp.EsquemaAutorizCompras";

	private String							codigo;

	private String							descripcion;

	private String							ambito_esquema;

	private Boolean							activo;

	private ClasificadorEntidad	clasifEntidad;

	private List								autorizadoresRequisiciones			= new ArrayList();

	private boolean							readAutorizadoresRequisiciones	= true;

	private List								autorizadoresCompras						= new ArrayList();

	private boolean							readAutorizadoresCompras				= true;
	
	private boolean							usarClasificador;
	
	private String nombreNickName;

	public String getCodigo() throws BaseException {
		supportRefresh();
		return codigo;
	}

	public void setCodigo(String aCodigo) {
		this.codigo = aCodigo;
	}
	
	public String getNombreNickName() throws BaseException {
		supportRefresh();
		return this.nombreNickName;
	}

	public void setNombreNickName(String aNombreNickName) {
		this.nombreNickName = aNombreNickName;
	}
	
	
	public boolean isUsarClasificador() throws BaseException {
		supportRefresh();
		return this.usarClasificador;
	}

	public void setUsarClasificador(boolean aUsarClasificador) {
		this.usarClasificador = aUsarClasificador;
	}
	

	public ClasificadorEntidad getClasificadorEntidad() throws BaseException {
		supportRefresh();
		return clasifEntidad;
	}

	public void setClasificadorEntidad(ClasificadorEntidad aClasifEntidad) {
		this.clasifEntidad = aClasifEntidad;
	}

	public String getDescripcion() throws BaseException {
		supportRefresh();
		return descripcion;
	}

	public void setDescripcion(String aDescripcion) {
		this.descripcion = aDescripcion;
	}

	public String getAmbito_esquema() throws BaseException {
		supportRefresh();
		return ambito_esquema;
	}

	public void setAmbito_esquema(String aAmbito_esquema) {
		this.ambito_esquema = aAmbito_esquema;
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

	public static EsquemaAutorizCompras findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (EsquemaAutorizCompras) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static EsquemaAutorizCompras findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (EsquemaAutorizCompras) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static EsquemaAutorizCompras findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (EsquemaAutorizCompras) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(codigo, "Debe ingresar el código");
		Validar.noNulo(descripcion, "Debe ingresar la Descripción");
		Validar.noNulo(ambito_esquema, "Debe ingresar el Ambito");
		//Validar.noNulo(clasifEntidad, "Debe ingresar el Clasificador");
		if (this.getAmbito_esquema().equals(EsquemaAutorizCompras.getAmbitoCompras())) {
			Validar.noNulo(nombreNickName, "Debe ingresar el Tipo de Producto");
		}

	}

	public List getAutorizadoresRequiciones() throws BaseException {
		if (readAutorizadoresRequisiciones) {
			List listaAutorizReq = AutorizadorRequisicion.getAutorizadoresRequisicion(this, getSesion());
			autorizadoresRequisiciones.addAll(listaAutorizReq);
			readAutorizadoresRequisiciones = false;
		}
		return autorizadoresRequisiciones;
	}

	public List getAutorizadoresCompras() throws BaseException {
		if (readAutorizadoresCompras) {
			List lista = AutorizadorCompra.getAutorizadoresCompras(this, getSesion());
			autorizadoresCompras.addAll(lista);
			readAutorizadoresCompras = false;
		}
		return autorizadoresCompras;
	}

	public void addAutorizadorRequisicion(AutorizadorRequisicion autorizadorRequisicion) throws BaseException {
		autorizadorRequisicion.setEsquema_autorizacion(this);
		autorizadoresRequisiciones.add(autorizadorRequisicion);
	}

	public void addAutorizadorCompra(AutorizadorCompra autorizadorCompra) throws BaseException {
		autorizadorCompra.setEsquema_autoriz(this);
		autorizadoresCompras.add(autorizadorCompra);
	}

	public void afterSave() throws BaseException {

		Iterator iterAutoriradoresReq = autorizadoresRequisiciones.iterator();
		while (iterAutoriradoresReq.hasNext()) {
			AutorizadorRequisicion autorizadorRequisicion = (AutorizadorRequisicion) iterAutoriradoresReq.next();
			autorizadorRequisicion.save();
			autorizadorRequisicion = null;
		}
		iterAutoriradoresReq = null;

		Iterator iterAutoriradoresCompra = autorizadoresCompras.iterator();
		while (iterAutoriradoresCompra.hasNext()) {
			AutorizadorCompra autorizadorCompra = (AutorizadorCompra) iterAutoriradoresCompra.next();
			autorizadorCompra.save();
			autorizadorCompra = null;
		}
		iterAutoriradoresCompra = null;

	}

	public static EsquemaAutorizCompras getEsqVigAutorizReq(ISesion aSesion) throws BaseException {
		Integer oidEsquema = ValorParametro.findByCodigoParametro("ESQUEMA_AUTORIZ_REQ_VIG", aSesion).getOidObjNeg();
		EsquemaAutorizCompras esquema = EsquemaAutorizCompras.findByOid(oidEsquema, aSesion);
		return esquema;
	}

	public static String getAmbitoCompras(ISesion aSesion) throws BaseException {

		ValorParametro valorParametro = ValorParametro.findByCodigoParametro("AMBITO_AUTORIZ_OC", aSesion);
		return valorParametro.getValorCadena();
	}

	public static String getAmbitoRequisiciones(ISesion aSesion) throws BaseException {
		ValorParametro valorParametro = ValorParametro.findByCodigoParametro("AMBITO_AUTORIZ_REQ", aSesion);
		return valorParametro.getValorCadena();
	}

	public Collection getRolesAutorizMontoOC(OrdenDeCompraCab oc) throws BaseException {

		
		
		HashTableDatos acumPorTipoProducto = new HashTableDatos();
		// Acumular montos por clasificacion de los productos
		
		if (this.isUsarClasificador()==false) 
			// Crear los roles 
			return getRolesAutorizOC(oc.getTotMontoOC(),oc.getMoneda(),oc.getCotizacion(), oc.getSectorCompra());
		
		
		Iterator iterDetOC = oc.getDetallesOC().iterator();
		while (iterDetOC.hasNext()) {
			OrdenDeCompraDet ocDet = (OrdenDeCompraDet) iterDetOC.next();
			
			IEntidadClasificable entidad = null;
			
			if (this.getNombreNickName().equals(Producto.NICKNAME))
				entidad = ocDet.getProducto();
			else if (this.getNombreNickName().equals(ExtensionProdGen.NICKNAME))
				entidad = ocDet.getProducto().getValorClasifProdGen();
			
			IValorClasificadorEntidad valorclasif = this.getClasificadorEntidad().getValorClasificador(entidad);
			if (valorclasif == null)
				throw new ExceptionValidation(null, "No se pudo clasificar el producto " + ocDet.getProducto().getCodigo()
						+ " - " + ocDet.getProducto().getDescripcion() + " en el esquema de Autorizaciones "
						+ this.getDescripcion());

			// Aculumar los Montos por ValorClasificador (rama de clasificacion del producto)
			Money totAcum = (Money) acumPorTipoProducto.get(new Integer(valorclasif.getOID()));
			if (totAcum == null)
				totAcum = new Money(0);
			CalculadorMoney acumular = new CalculadorMoney(totAcum);
			acumular.sumar(new Money(ocDet.getTotal().doubleValue()));
			acumPorTipoProducto.put(new Integer(valorclasif.getOID()), acumular.getResultMoney());
		}
		return getRolesAutorizOC(oc.getMoneda(), oc.getCotizacion(), acumPorTipoProducto, oc.getSectorCompra());
	}
	
	public Collection getRolesAutorizOC(
			Money totalOC,
			Moneda moneda,
			ValorCotizacion cotizacion,
			SectorCompra sector) throws BaseException {
		HashTableDatos rolesAutorizadores = new HashTableDatos();
		// Obtener el Autorizador de compras
		AutorizadorCompra autorizCompra = this.getAutorizacionCompra();
		
		if (autorizCompra == null)
			throw new ExceptionValidation(null,"No se encuentra configurado un autorizador de compras");
			
		Money impoEnMonVal = getImporteEnMonVal(autorizCompra, moneda, cotizacion, totalOC);
		AutorizacionMontoCompra autorizMontoCpra = autorizCompra.getAutorizMonCpraByMonto(impoEnMonVal, getSesion());
		if (autorizMontoCpra == null)
			throw new ExceptionValidation(null, "No se pudo encontrar un rango para el monto " + impoEnMonVal.doubleValue()
					+ " en el esquema " + this.getDescripcion());

		// Roles Autorizadores
		Iterator iterRolesAutorizOC = autorizMontoCpra.getRolesAutorizacionComprasBySector(sector, getSesion())
				.iterator();
		while (iterRolesAutorizOC.hasNext()) {
			RolAutorizadorOC rolAutorizadorOC = (RolAutorizadorOC) iterRolesAutorizOC.next();
			if (rolesAutorizadores.get(rolAutorizadorOC.getOIDInteger()) == null)
				rolesAutorizadores.put(rolAutorizadorOC.getOIDInteger(), rolAutorizadorOC);
		}
	
	return rolesAutorizadores.values();
	}

	public Collection getRolesAutorizOC(Moneda moneda, ValorCotizacion cotizacion, HashTableDatos montoAcumPorTipoProd,
			SectorCompra sector) throws BaseException {

		HashTableDatos rolesAutorizadores = new HashTableDatos();
		Iterator iterOidValEnt = montoAcumPorTipoProd.keySet().iterator();
		while (iterOidValEnt.hasNext()) {
			Integer oidValorClasif = (Integer) iterOidValEnt.next();
			ValorClasificadorEntidad valClasifEnt = ValorClasificadorEntidad.findByOid(oidValorClasif, getSesion());
			Money montoAcum = (Money) montoAcumPorTipoProd.get(oidValorClasif);

			// Buscar el autorizador correspondiente al clasificador del Articulo
			AutorizadorCompra autorizCompra = this.getAutorizacionCompraByValorClasif(valClasifEnt);
			if (autorizCompra == null)
				throw new ExceptionValidation(null,
						"No se pudo encontrar un rago de montos para autorizar la OC para la clasificación del producto: "+
						valClasifEnt.getClasificador_entidad().getDescripcion()+" - "+ valClasifEnt.getDescripcion() + " según el Esquema " + this.getDescripcion());

			// Llevar el monto acumulador a la moneda de la Validacion
			Money impoEnMonVal = getImporteEnMonVal(autorizCompra, moneda, cotizacion, montoAcum);

			AutorizacionMontoCompra autorizMontoCpra = autorizCompra.getAutorizMonCpraByMonto(impoEnMonVal, getSesion());
			if (autorizMontoCpra == null)
				throw new ExceptionValidation(null, "No se pudo encontrar un rango para el monto " + impoEnMonVal.doubleValue()
						+ " en el esquema " + this.getDescripcion() + " para la clasif. de producto "
						+ valClasifEnt.getDescripcion());

			// Roles Autorizadores
			Iterator iterRolesAutorizOC = autorizMontoCpra.getRolesAutorizacionComprasBySector(sector, getSesion())
					.iterator();
			while (iterRolesAutorizOC.hasNext()) {
				RolAutorizadorOC rolAutorizadorOC = (RolAutorizadorOC) iterRolesAutorizOC.next();
				if (rolesAutorizadores.get(rolAutorizadorOC.getOIDInteger()) == null)
					rolesAutorizadores.put(rolAutorizadorOC.getOIDInteger(), rolAutorizadorOC);
			}
		}
		return rolesAutorizadores.values();
	}

	private Money getImporteEnMonVal(AutorizadorCompra autorizCompra, Moneda moneda, ValorCotizacion cotizacion,
			Money montoAcum) throws BaseException {
		Money impoEnMonVal = null;
		if (autorizCompra.getMoneda().getOID() == moneda.getOID())
			impoEnMonVal = montoAcum;
		else {
			CalculadorMoney calcImpoMonloc = new CalculadorMoney(montoAcum);
			calcImpoMonloc.multiplicarPor(cotizacion);
			if (autorizCompra.getMoneda().isMonedaCursoLegal() == true)
				impoEnMonVal = calcImpoMonloc.getResultMoney();
			else {
				ValorCotizacion valorCotiz = Cotizacion.getCotizacionNotFoundCero(Fecha.getFechaActual(), TipoCambio
						.getTipoCambioDefaultConta(this.getSesion()), autorizCompra.getMoneda(), this.getSesion());
				if (valorCotiz == null)
					throw new ExceptionValidation(null, "No se pudo encontrar cotización para la moneda "
							+ autorizCompra.getMoneda().getDescripcion() + " en el día de la fecha y el tipo de cambio "
							+ TipoCambio.getTipoCambioDefaultConta(this.getSesion()).getDescripcion());
				calcImpoMonloc.dividirPor(valorCotiz);
				impoEnMonVal = calcImpoMonloc.getResultMoney();
			}
		}
		return impoEnMonVal;
	}

	public AutorizadorCompra getAutorizacionCompraByValorClasif(ValorClasificadorEntidad valClasifEnt)
			throws BaseException {
		return AutorizadorCompra.getAutorizacionCompraByValorClasif(this, valClasifEnt, this.getSesion());
	}
	
	public AutorizadorCompra getAutorizacionCompra() throws BaseException {
		return AutorizadorCompra.getAutorizacionCompra(this, this.getSesion());
	}
	
	public static String getAmbitoCompras() throws BaseException {
		return "COMPRAS";
	}

}
