package com.srn.erp.compras.op;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.compras.bm.ImpresionItemResumenOC;
import com.srn.erp.compras.bm.ManejadorImpresionResumenOC;
import com.srn.erp.compras.bm.OrdenDeCompraCab;
import com.srn.erp.compras.bm.OrdenDeCompraDet;
import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.general.bm.Empresa;
import com.srn.erp.general.bm.EtiquetaIdioma;
import com.srn.erp.general.bm.IValorClasificadorEntidad;
import com.srn.erp.general.bm.Idioma;
import com.srn.erp.general.bm.LabelTranslator;
import com.srn.erp.general.bm.Sucursal;
import com.srn.erp.stock.bm.UnidadMedida;

import framework.applicarionServer.bm.Varios.CalculadorMoney;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class ImpresionOC extends Operation {

	ClasificadorEntidad clasifEnt1 = null;
	ClasificadorEntidad clasifEnt2 = null;
	int secu = 0;

	
	class CodValClasifArt2 implements Comparable {
		String valor;
		
		public int compareTo(Object arg0) {

			return valor.compareTo(((CodValClasifArt2)arg0).valor);

		}
		
	}
	
	class RenglonProdGral {

		IValorClasificadorEntidad producto = null;
		String descAdicSKU = null;
		java.util.Date fecReq;
		Double precio = null;
		Double porcDto1 = null;
		Double precioNeto = null;
		
		List listaLabels = new ArrayList();
		List renglonesProdGralClasifArt1 = new ArrayList();
		boolean isFullLabels = false;
		
		private CodValClasifArt2 findLabel(String label) throws BaseException {
			Iterator iterLabels = 
				listaLabels.iterator();
			while (iterLabels.hasNext()) {
				CodValClasifArt2 codValClasif = (CodValClasifArt2) iterLabels.next();
				if (codValClasif.valor.equals(label)) return codValClasif; 
			}
			return null;
		}

		public void agregarCantidades(OrdenDeCompraDet ocDet)
				throws BaseException {
			
			// Agregar la Etiqueta
			IValorClasificadorEntidad valorClasifArt2 = ocDet.getProducto().getValorClasifEnt(clasifEnt2);
			String codigoLabel = "";
			if (valorClasifArt2 != null)
				codigoLabel = valorClasifArt2.getCodigo();
			
			CodValClasifArt2 codValClasifArt2 = findLabel(codigoLabel);
			if (codValClasifArt2 == null) {
				codValClasifArt2 = new CodValClasifArt2();
				codValClasifArt2.valor = codigoLabel;
				listaLabels.add(codValClasifArt2);
			}
			
			if (listaLabels.size() == 9)
				isFullLabels = true;
			
				
			boolean encontro = false;
			RenglonProdGralClasifArt1 renglonProdGralClasifArt1 = null;
			Iterator iterRenglonesProdGralClasifArt1 = renglonesProdGralClasifArt1
					.iterator();
			while (iterRenglonesProdGralClasifArt1.hasNext()) {
				renglonProdGralClasifArt1 = (RenglonProdGralClasifArt1) iterRenglonesProdGralClasifArt1
						.next();
				if (renglonProdGralClasifArt1.esIgualA(ocDet)) {
					renglonProdGralClasifArt1.agregarCantidades(ocDet);
					encontro = true;
					break;
				}
			}

			if (!encontro) {
				renglonProdGralClasifArt1 = new RenglonProdGralClasifArt1();
				renglonProdGralClasifArt1.valorClasifArt1 = ocDet.getProducto()
						.getValorClasifEnt(clasifEnt1);
				renglonProdGralClasifArt1.cantidad = new Double(0);
				renglonProdGralClasifArt1.precio = ocDet.getPrecio();
				renglonProdGralClasifArt1.total = ocDet.getTotal();
				renglonProdGralClasifArt1.precioNeto = ocDet.getPrecio_neto_bonif();
				renglonProdGralClasifArt1.porcDto1 = ocDet.getDto1();
				renglonProdGralClasifArt1.um = ocDet.getUnidad_compra();
				renglonProdGralClasifArt1.agregarCantidades(ocDet);
				renglonesProdGralClasifArt1.add(renglonProdGralClasifArt1);
			}
			
			// Acumular las cantidades en el renglon
			
			

		}
		
		public boolean isLabelEnRenglon(String labelValClasif2) throws BaseException {
			if (findLabel(labelValClasif2)!=null)
				return true;
			else
				return false;
		}

	}

	class RenglonProdGralClasifArt1 {

		IValorClasificadorEntidad valorClasifArt1 = null;
		Double cantidad = null;
		Double precio = null;
		Double precioNeto = null;
		Double porcDto1 = null;
		Double total = null;
		UnidadMedida um;
		HashTableDatos listaCantidades = new HashTableDatos();

		private boolean esIgualA(OrdenDeCompraDet ocDet) throws BaseException {

			boolean condValClasifArt1 = false;
			if ((ocDet.getProducto().getValorClasifEnt(clasifEnt1) == null)
					&& (this.valorClasifArt1 == null))
				condValClasifArt1 = true;
			else if ((ocDet.getProducto().getValorClasifEnt(clasifEnt1) != null)
					&& (this.valorClasifArt1 != null)
					&& (ocDet.getProducto().getValorClasifEnt(clasifEnt1)
							.getOID() == this.valorClasifArt1.getOID())) {
				condValClasifArt1 = true;
			}

			boolean condPrecio = false;
			if ((ocDet.getPrecio() == null) && (this.precio == null))
				condPrecio = true;
			else if ((ocDet.getPrecio() != null)
					&& (this.precio != null)
					&& (ocDet.getPrecio().doubleValue() == this.precio
							.doubleValue())) {
				condPrecio = true;
			}
			

			if (condValClasifArt1 && condPrecio)
				return true;
			else
				return false;
		}
		
		private void agregarCantidades(OrdenDeCompraDet ocDet) throws BaseException {

			// Acummlar las cantidades y cambiar el Total
			if (cantidad == null)
				cantidad = new Double(0);
			
			CalculadorMoney acumCant = new CalculadorMoney(new Money(ocDet.getCant_comprada_uc()));
			acumCant.sumar(new Money(cantidad));
			cantidad = acumCant.getResultMoney().doubleValue(); 
			
			if (precioNeto == 0)
				precioNeto = new Double(0);
			CalculadorMoney impTotal = new CalculadorMoney(new Money(precioNeto));
			impTotal.multiplicarPor(acumCant.getResultMoney());
			total = impTotal.getResult();
			
			// Agregar las cantidades en el valor de clasificador 2 que corresponda
			String codValClasif2 = "";
			IValorClasificadorEntidad valClasif2 = ocDet.getProducto().getValorClasifEnt(clasifEnt2);
			if (valClasif2!= null)
				codValClasif2 = valClasif2.getCodigo(); 
			if (listaCantidades.get(codValClasif2)==null)
				listaCantidades.put(codValClasif2, ocDet.getCant_comprada_uc());
			else {
				Double cant = (Double) listaCantidades.get(codValClasif2);
				CalculadorMoney acumCant1 = new CalculadorMoney(new Money(cant));
				acumCant1.sumar(new Money(ocDet.getCant_comprada_uc()));
				listaCantidades.put(codValClasif2, new Double(acumCant1.getResultMoney().doubleValue()));
			}
				
		}

	}

	CalculadorMoney totAcumItems = new CalculadorMoney(new Money(0));

	private LabelTranslator lt = null;

	public ImpresionOC() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		if ((mapaDatos.getString("tipo_formato_oc").equals(""))
				|| (mapaDatos.getString("tipo_formato_oc").equals("1")))
			impresionEstandar(mapaDatos);
		else if (mapaDatos.getString("tipo_formato_oc").equals("2"))
			impresionMatricial(mapaDatos);
		else
			impresionEstandar(mapaDatos);

	}

	private void impresionEstandar(MapDatos mapaDatos) throws BaseException {

		IDataSet dsOC = getDataSetOrdenDeCompra();
		IDataSet dsProductoOC = getDataSetProductosOC();
		IDataSet dsLabels = getDataSetLabels();

		lt = new LabelTranslator(this.getSesion());
		lt.setNickName(OrdenDeCompraCab.NICKNAME);
		lt.setIdioma(Idioma.getIdiomaLocal(this.getSesion()));

		OrdenDeCompraCab ordenDeCompra = OrdenDeCompraCab.findByOid(mapaDatos
				.getInteger("oid_cco"), getSesion());
		if (ordenDeCompra.getProveedor().getIdioma() != null)
			lt.setIdioma(ordenDeCompra.getProveedor().getIdioma());

		cargarRegistroOrdenDeCompra(dsOC, ordenDeCompra);

		if (ordenDeCompra.isAgrupaItemsImpresion().booleanValue())
			impresionItemsAgrupados(dsProductoOC, ordenDeCompra);
		else
			impresionItemsNoAgrupados(dsProductoOC, ordenDeCompra);

		cargarEtiquetas(dsLabels);

		writeCliente(dsOC);
		writeCliente(dsProductoOC);
		writeCliente(dsLabels);

	}

	private void impresionMatricial(MapDatos mapaDatos) throws BaseException {

		clasifEnt1 = ClasificadorEntidad
				.getClasif1ImpOCMatriz(this.getSesion());
		clasifEnt2 = ClasificadorEntidad
				.getClasif2ImpOCMatriz(this.getSesion());

		IDataSet dsOC = getDataSetOrdenDeCompra();
		IDataSet dsProdGral = getDataSetProductosGral();
		IDataSet dsLabels = getDataSetLabels();
		IDataSet dsProdMatriz = getDataSetProductosMatricial();

		lt = new LabelTranslator(this.getSesion());
		lt.setNickName(OrdenDeCompraCab.NICKNAME);
		lt.setIdioma(Idioma.getIdiomaLocal(this.getSesion()));

		OrdenDeCompraCab ordenDeCompra = OrdenDeCompraCab.findByOid(mapaDatos
				.getInteger("oid_cco"), getSesion());
		if (ordenDeCompra.getProveedor().getIdioma() != null)
			lt.setIdioma(ordenDeCompra.getProveedor().getIdioma());

		cargarRegistroOrdenDeCompra(dsOC, ordenDeCompra);

		impresionItemsProdGral(dsProdGral, dsProdMatriz , ordenDeCompra);

		cargarEtiquetas(dsLabels);

		writeCliente(dsOC);
		writeCliente(dsProdGral);
		writeCliente(dsLabels);
		writeCliente(dsProdMatriz);

	}

	private void impresionItemsProdGral(
			IDataSet dsProdGral,
			IDataSet dsProdMatriz,
			OrdenDeCompraCab ordenDeCompra) throws BaseException {

		List renglones = new ArrayList();

		Iterator iterDetOC = ordenDeCompra.getDetallesOC().iterator();
		while (iterDetOC.hasNext()) {
			OrdenDeCompraDet ocDet = (OrdenDeCompraDet) iterDetOC.next();
			if (ocDet.isAnulado())
				continue;
			RenglonProdGral renglonProdGral = findRenglonProdGral(ocDet,
					renglones);
			renglonProdGral.agregarCantidades(ocDet);

		}
		
		// Devolver los Productos Generales
		
		Iterator iterRenglones = 
			renglones.iterator();
		while (iterRenglones.hasNext()) {
			RenglonProdGral renglonProdgral = (RenglonProdGral) iterRenglones.next();
			Collections.sort(renglonProdgral.listaLabels);
			Integer oidClave = ++secu;
			cargarRegistroProdGral(dsProdGral,oidClave,renglonProdgral,ordenDeCompra.getOIDInteger());
			
			
			// Devolver
			Iterator iterRenglonesProdGralClasifArt1 =
				renglonProdgral.renglonesProdGralClasifArt1.iterator();
			while (iterRenglonesProdGralClasifArt1.hasNext()) {
				RenglonProdGralClasifArt1  renglonProdGralClasifArt1 = (RenglonProdGralClasifArt1) iterRenglonesProdGralClasifArt1.next();
				cargarRenglonProdGralClasifArt1(dsProdMatriz, renglonProdgral, renglonProdGralClasifArt1, oidClave);
			}
			
		}
		
	}

	private RenglonProdGral findRenglonProdGral(OrdenDeCompraDet ocDet,
			List renglones) throws BaseException {

		Iterator iterRenglones = renglones.iterator();
		while (iterRenglones.hasNext()) {
			RenglonProdGral renglonProdGral = (RenglonProdGral) iterRenglones
					.next();

			if (ocDet.getProducto().getValorClasifProdGen() == null)
				throw new ExceptionValidation(null,"Falta definir el producto general para el producto de stock "+ocDet.getProducto().getCodigo()+" - "+ocDet.getProducto().getDescripcion());
			
			boolean condProducto = false;
			if ((renglonProdGral.producto.getOID() == ocDet.getProducto().getValorClasifProdGen().getOID()))
				condProducto = true;

			boolean condComentario = false;
			if ((ocDet.getDesc_adic_sku() == null)
					&& (renglonProdGral.descAdicSKU == null))
				condComentario = true;
			else if ((ocDet.getDesc_adic_sku() != null)
					&& (renglonProdGral.descAdicSKU != null)
					&& (ocDet.getDesc_adic_sku()
							.equals(renglonProdGral.descAdicSKU)))
				condComentario = true;

			boolean condFecha = false;
			if ((ocDet.getFecRequerida() == null)
					&& (renglonProdGral.fecReq == null))
				condFecha = true;
			else if ((ocDet.getFecRequerida() != null)
					&& (renglonProdGral.fecReq != null)
					&& (ocDet.getFecRequerida().equals(renglonProdGral.fecReq)))
				condFecha = true;

			boolean condPrecio = false;
			if ((ocDet.getPrecio() == null)
					&& (renglonProdGral.precio == null))
				condPrecio = true;
			else if ((ocDet.getPrecio() != null)
					&& (renglonProdGral.precio != null)
					&& (ocDet.getPrecio().equals(renglonProdGral.precio)))
				condPrecio = true;
			
			boolean condDto1 = false;
			if ((ocDet.getDto1() == null)
					&& (renglonProdGral.porcDto1 == null))
				condDto1 = true;
			else if ((ocDet.getDto1() != null)
					&& (renglonProdGral.porcDto1 != null)
					&& (ocDet.getDto1().equals(renglonProdGral.porcDto1)))
				condDto1 = true;
			
			boolean condPrecioNeto = false;
			if ((ocDet.getPrecio_neto_bonif() == null)
					&& (renglonProdGral.precioNeto == null))
				condPrecioNeto = true;
			else if ((ocDet.getPrecio_neto_bonif() != null)
					&& (renglonProdGral.precioNeto != null)
					&& (ocDet.getPrecio_neto_bonif().equals(renglonProdGral.precioNeto)))
				condPrecioNeto = true;
			
			if ((condProducto) && (condComentario) && (condFecha) && (condPrecio) && (condDto1) && (condPrecioNeto)) {
				// clave existente
				String codValClasif2 = "";
				if (ocDet.getProducto().getValorClasifEnt(clasifEnt2)!=null)
					codValClasif2  = ocDet.getProducto().getValorClasifEnt(clasifEnt2).getCodigo();
				if (!((renglonProdGral.isFullLabels && (!renglonProdGral.isLabelEnRenglon(codValClasif2)))))
					return renglonProdGral;
			}

		}

		RenglonProdGral renglon = new RenglonProdGral();
		renglon.producto = ocDet.getProducto().getValorClasifProdGen();
		renglon.descAdicSKU = ocDet.getDesc_adic_sku();
		renglon.fecReq = ocDet.getFecRequerida();
		renglon.precio = ocDet.getPrecio();
		renglon.porcDto1 = ocDet.getDto1();
		renglon.precioNeto = ocDet.getPrecio_neto_bonif();
		
		renglones.add(renglon);

		return renglon;

	}

	private void impresionItemsAgrupados(IDataSet dsProductoOC,
			OrdenDeCompraCab ordenDeCompra) throws BaseException {
		ManejadorImpresionResumenOC impresionResumen = new ManejadorImpresionResumenOC();
		Iterator iterDetOC = ordenDeCompra.getDetallesOC().iterator();
		while (iterDetOC.hasNext()) {
			OrdenDeCompraDet ocDet = (OrdenDeCompraDet) iterDetOC.next();

			if (ocDet.isAnulado())
				continue;

			String codArtProv = "";
			if (ocDet.getProducto().getProductoProveedor(
					ordenDeCompra.getProveedor()) != null)
				codArtProv = ocDet.getProducto().getProductoProveedor(
						ordenDeCompra.getProveedor()).getCodigo();

			String lugarEntrega = "";
			if (ordenDeCompra.getLugarEntrega() != null)
				lugarEntrega = ordenDeCompra.getLugarEntrega()
						.getDireccionCompleta();

			impresionResumen.addItem(ocDet.getOIDInteger(), ordenDeCompra
					.getOIDInteger(), ocDet.getNro_item(), codArtProv, ocDet
					.getProducto().getCodigo(), ocDet.getProducto()
					.getDescripcion(), ocDet.getDesc_adic_sku(), ocDet
					.getUnidad_compra().getCodigo(), ocDet
					.getCant_comprada_uc(), ocDet.getPrecio(), ocDet.getDto1(),
					ocDet.getDto2(), ocDet.getDto3(), new Double(0), ocDet
							.getPrecio_neto_bonif(), ocDet.getTotal(), ocDet
							.getFecRequerida(), lugarEntrega);

		}

		// Imprimir los Items resumenes
		Iterator iterItems = impresionResumen.getItems().values().iterator();
		while (iterItems.hasNext()) {
			ImpresionItemResumenOC impresionItem = (ImpresionItemResumenOC) iterItems
					.next();

			totAcumItems.sumar(new Money(impresionItem.getTotal()));

			cargarRegistroProductoOC(dsProductoOC, impresionItem.getOidOCDet(),
					impresionItem.getOicOC(), impresionItem.getNroItem(),
					impresionItem.getCodArtProv(), impresionItem
							.getCodProducto(), impresionItem.getDescProducto(),
					impresionItem.getDescAdicional(), impresionItem
							.getUnidadMedida(), impresionItem.getCantidad(),
					impresionItem.getPrecio(), impresionItem.getDto1(),
					impresionItem.getDto2(), impresionItem.getDto3(),
					impresionItem.getDtoGeneral(), impresionItem
							.getPrecioNeto(), impresionItem.getTotal(),
					impresionItem.getFecRequerida(), impresionItem
							.getLugarEntrega(), totAcumItems.getResultMoney());

		}

	}

	private void impresionItemsNoAgrupados(IDataSet dsProductoOC,
			OrdenDeCompraCab ordenDeCompra) throws BaseException {
		Iterator iterDetOC = ordenDeCompra.getDetallesOC().iterator();
		while (iterDetOC.hasNext()) {
			OrdenDeCompraDet ocDet = (OrdenDeCompraDet) iterDetOC.next();

			if (ocDet.isAnulado())
				continue;

			String codArtProv = "";
			if (ocDet.getProducto().getProductoProveedor(
					ordenDeCompra.getProveedor()) != null)
				codArtProv = ocDet.getProducto().getProductoProveedor(
						ordenDeCompra.getProveedor()).getCodigo();

			String lugarEntrega = "";
			if (ordenDeCompra.getLugarEntrega() != null)
				lugarEntrega = ordenDeCompra.getLugarEntrega()
						.getDireccionCompleta();

			totAcumItems.sumar(new Money(ocDet.getTotal()));

			cargarRegistroProductoOC(dsProductoOC, ocDet.getOIDInteger(),
					ordenDeCompra.getOIDInteger(), ocDet.getNro_item(),
					codArtProv, ocDet.getProducto().getCodigo(), ocDet
							.getProducto().getDescripcion(), ocDet
							.getDesc_adic_sku(), ocDet.getUnidad_compra()
							.getCodigo(), ocDet.getCant_comprada_uc(), ocDet
							.getPrecio(), ocDet.getDto1(), ocDet.getDto2(),
					ocDet.getDto3(), new Double(0), ocDet
							.getPrecio_neto_bonif(), ocDet.getTotal(), ocDet
							.getFecRequerida(), lugarEntrega, totAcumItems
							.getResultMoney());

		}

	}

	private void cargarRegistroOrdenDeCompra(IDataSet dataset,
			OrdenDeCompraCab oc) throws BaseException {

		dataset.append();
		dataset.fieldValue("oid_cco", oc.getOIDInteger());
		dataset.fieldValue("comprobante", oc.getCodigo());
		dataset.fieldValue("tc", oc.getTcExt());
		dataset.fieldValue("letra", oc.getLetra());
		dataset.fieldValue("lug_emi", oc.getNroLugEmision());
		dataset.fieldValue("nro_ext", oc.getNroExt());
		dataset.fieldValue("fecha", oc.getEmision());
		dataset.fieldValue("cod_prov", oc.getProveedor().getCodigo());
		dataset.fieldValue("razon_social_prov", oc.getProveedor()
				.getRazonsocial());
		dataset.fieldValue("moneda", oc.getMoneda().getDescripcion());
		dataset.fieldValue("cotizacion", oc.getCotizacion());

		if (oc.getCond_pago_1() != null)
			dataset.fieldValue("cond_pago", oc.getCond_pago_1()
					.getDescripcion());
		else
			dataset.fieldValue("cond_pago", "");
		if (oc.getVia_despacho() != null)
			dataset.fieldValue("via_despacho", oc.getVia_despacho()
					.getDescripcion());
		else
			dataset.fieldValue("via_despacho", "");
		if (oc.getCond_compra_importacion() != null)
			dataset.fieldValue("cond_compra", oc.getCond_compra_importacion()
					.getDescripcion());
		else
			dataset.fieldValue("cond_compra", "");
		dataset.fieldValue("comentario", oc.getComentario());

		// Obtener Datos de la Razon Social
		dataset.fieldValue("razon_social_empresa", Empresa.getEmpresa(
				getSesion()).getRazon_social());

		// Obtener los Datos de la Sucursal
		Sucursal sucursal = Sucursal.getSucursal(getSesion());
		dataset.fieldValue("razon_social_sucursal", sucursal.getDescripcion());
		dataset.fieldValue("direccion_sucursal", sucursal.getCalle_y_nro());
		dataset.fieldValue("localidad_sucursal", sucursal.getLocalidad());
		if (sucursal.getProvincia() != null)
			dataset.fieldValue("provincia_sucursal", sucursal.getProvincia()
					.getDescripcion());
		else
			dataset.fieldValue("provincia_sucursal", "");
		if (sucursal.getPais() != null)
			dataset.fieldValue("pais_sucursal", sucursal.getPais()
					.getDescripcion());
		else
			dataset.fieldValue("pais_sucursal", "");
		dataset.fieldValue("telefonos_sucursal", sucursal.getTelefonos());
		dataset.fieldValue("usuario_oc", oc.getUsuario().getApellidoyNombre());

		// Agregar Datos Proveedor
		dataset.fieldValue("codigo_proveedor", oc.getProveedor().getCodigo());
		dataset.fieldValue("razon_social_proveedor", oc.getProveedor()
				.getRazonsocial());
		dataset.fieldValue("direccion_proveedor", oc.getProveedor()
				.getDireccion());
		dataset.fieldValue("localidad_proveedor", oc.getProveedor()
				.getLocalidad());
		if (oc.getProveedor().getProvincia() != null)
			dataset.fieldValue("provincia_proveedor", oc.getProveedor()
					.getProvincia().getDescripcion());
		else
			dataset.fieldValue("provincia_proveedor", "");
		if (oc.getProveedor().getPais() != null)
			dataset.fieldValue("pais_proveedor", oc.getProveedor().getPais()
					.getDescripcion());
		else
			dataset.fieldValue("pais_proveedor", "");
		dataset.fieldValue("telefonos_proveedor", "");

		// Facturar a
		dataset.fieldValue("facturar_a", Empresa.getEmpresa(getSesion())
				.getRazon_social());
		dataset.fieldValue("sucursal_cp", sucursal.getCodigo_postal());
		dataset.fieldValue("path_logo", Empresa.getEmpresa(getSesion())
				.getArchivo_logo());
		if (oc.getLugarEntrega() != null)
			dataset.fieldValue("domicilio_entrega", oc.getLugarEntrega()
					.getDireccionCompleta());
		else
			dataset.fieldValue("domicilio_entrega", "");
		dataset.fieldValue("total", oc.getTotMontoOC());
		dataset.fieldValue("oid_sucursal", oc.getSucursal().getOID());
		dataset.fieldValue("leyenda_no_autorizada", oc
				.getLeyendaImpresionEstadoAutoriz());
		dataset.fieldValue("nro_ver_ext", oc.getComprobanteImpreso()
				.getVersion_externa());
	}

	private void cargarRegistroProductoOC(IDataSet dataset, Integer oidOCCDet,
			Integer oidOC, Integer nro, String codArtProv, String codArt,
			String descArt, String descAdic, String um, Double cantidad,
			Double precio, Double porcBonif1, Double porcBonif2,
			Double porcBonif3, Double porcBonifResumen, Double precioBonif,
			Double total, java.util.Date fecRequerida, String lugarEntrega,
			Money acumTotal) throws BaseException {

		dataset.append();
		dataset.fieldValue("oid_cco_det", oidOCCDet);
		dataset.fieldValue("oid_cco", oidOC);
		dataset.fieldValue("nro", nro);
		dataset.fieldValue("cod_art_prov", codArtProv);
		dataset.fieldValue("cod_art", codArt);
		dataset.fieldValue("desc_art", descArt);
		dataset.fieldValue("desc_adic", descAdic);
		dataset.fieldValue("um", um);
		dataset.fieldValue("cantidad", cantidad);
		dataset.fieldValue("precio", precio);
		dataset.fieldValue("porc_bonif1", porcBonif1);
		dataset.fieldValue("porc_bonif2", porcBonif2);
		dataset.fieldValue("porc_bonif3", porcBonif3);
		dataset.fieldValue("porc_bonif_resumen", porcBonifResumen);
		dataset.fieldValue("precio_bonif", precioBonif);
		dataset.fieldValue("total", total);
		dataset.fieldValue("fec_requerida", fecRequerida);
		dataset.fieldValue("lugar_entrega", lugarEntrega);
		dataset.fieldValue("acum_total", acumTotal);

	}

	private IDataSet getDataSetOrdenDeCompra() {
		IDataSet dataset = new TDataSet();
		dataset.create("TOCCab");
		dataset.fieldDef(new Field("oid_cco", Field.INTEGER, 0));
		dataset.fieldDef(new Field("comprobante", Field.STRING, 50));
		dataset.fieldDef(new Field("tc", Field.STRING, 10));
		dataset.fieldDef(new Field("letra", Field.STRING, 1));
		dataset.fieldDef(new Field("lug_emi", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nro_ext", Field.INTEGER, 0));
		dataset.fieldDef(new Field("fecha", Field.DATE, 0));
		dataset.fieldDef(new Field("cod_prov", Field.STRING, 50));
		dataset.fieldDef(new Field("razon_social_prov", Field.STRING, 100));
		dataset.fieldDef(new Field("moneda", Field.STRING, 20));
		dataset.fieldDef(new Field("cotizacion", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("cond_pago", Field.STRING, 100));
		dataset.fieldDef(new Field("via_despacho", Field.STRING, 100));
		dataset.fieldDef(new Field("cond_compra", Field.STRING, 100));
		dataset.fieldDef(new Field("comentario", Field.STRING, 5000));

		// Agregar datos Empresa
		dataset.fieldDef(new Field("razon_social_empresa", Field.STRING, 100));

		// Agregar Datos Sucursal
		dataset.fieldDef(new Field("razon_social_sucursal", Field.STRING, 100));
		dataset.fieldDef(new Field("direccion_sucursal", Field.STRING, 100));
		dataset.fieldDef(new Field("localidad_sucursal", Field.STRING, 100));
		dataset.fieldDef(new Field("provincia_sucursal", Field.STRING, 100));
		dataset.fieldDef(new Field("pais_sucursal", Field.STRING, 100));
		dataset.fieldDef(new Field("telefonos_sucursal", Field.STRING, 100));
		dataset.fieldDef(new Field("usuario_oc", Field.STRING, 100));

		// Agregar Datos Proveedor
		dataset.fieldDef(new Field("codigo_proveedor", Field.STRING, 50));
		dataset
				.fieldDef(new Field("razon_social_proveedor", Field.STRING, 100));
		dataset.fieldDef(new Field("direccion_proveedor", Field.STRING, 100));
		dataset.fieldDef(new Field("localidad_proveedor", Field.STRING, 100));
		dataset.fieldDef(new Field("provincia_proveedor", Field.STRING, 100));
		dataset.fieldDef(new Field("pais_proveedor", Field.STRING, 100));
		dataset.fieldDef(new Field("telefonos_proveedor", Field.STRING, 100));

		// Facturar a
		dataset.fieldDef(new Field("facturar_a", Field.STRING, 100));
		dataset.fieldDef(new Field("sucursal_cp", Field.STRING, 50));
		dataset.fieldDef(new Field("path_logo", Field.STRING, 500));
		dataset.fieldDef(new Field("domicilio_entrega", Field.STRING, 8000));
		dataset.fieldDef(new Field("total", Field.CURRENCY, 0));

		dataset.fieldDef(new Field("oid_sucursal", Field.INTEGER, 0));
		dataset.fieldDef(new Field("leyenda_no_autorizada", Field.STRING, 100));
		dataset.fieldDef(new Field("nro_ver_ext", Field.INTEGER, 0));

		return dataset;
	}

	private IDataSet getDataSetProductosOC() {
		IDataSet dataset = new TDataSet();
		dataset.create("TOCDet");
		dataset.fieldDef(new Field("oid_cco_det", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_cco", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nro", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_art_prov", Field.STRING, 50));
		dataset.fieldDef(new Field("cod_art", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_art", Field.STRING, 100));
		dataset.fieldDef(new Field("desc_adic", Field.STRING, 5000));
		dataset.fieldDef(new Field("um", Field.STRING, 10));
		dataset.fieldDef(new Field("cantidad", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("precio", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("porc_bonif1", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("porc_bonif2", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("porc_bonif3", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("porc_bonif_resumen", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("precio_bonif", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("total", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("fec_requerida", Field.DATE, 0));
		dataset.fieldDef(new Field("lugar_entrega", Field.MEMO, 0));
		dataset.fieldDef(new Field("acum_total", Field.CURRENCY, 0));

		return dataset;
	}
	
	private IDataSet getDataSetProductosGral() {
		IDataSet dataset = new TDataSet();
		dataset.create("TProductoGral");
		dataset.fieldDef(new Field("secu", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_prod_gral", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_prod_gral", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_prod_gral", Field.STRING, 255));
		dataset.fieldDef(new Field("desc_prod_adic", Field.MEMO, 0));
		dataset.fieldDef(new Field("label_col_1", Field.STRING, 20));
		dataset.fieldDef(new Field("label_col_2", Field.STRING, 20));
		dataset.fieldDef(new Field("label_col_3", Field.STRING, 20));
		dataset.fieldDef(new Field("label_col_4", Field.STRING, 20));
		dataset.fieldDef(new Field("label_col_5", Field.STRING, 20));
		dataset.fieldDef(new Field("label_col_6", Field.STRING, 20));
		dataset.fieldDef(new Field("label_col_7", Field.STRING, 20));
		dataset.fieldDef(new Field("label_col_8", Field.STRING, 20));
		dataset.fieldDef(new Field("label_col_9", Field.STRING, 20));
		dataset.fieldDef(new Field("oid_cco", Field.INTEGER, 0));
		dataset.fieldDef(new Field("fec_requerida", Field.DATE, 0));
		return dataset;
	}
	
	private IDataSet getDataSetProductosMatricial() {
		IDataSet dataset = new TDataSet();
		dataset.create("TProductoMatricial");
		dataset.fieldDef(new Field("oid_secu_det", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_secu", Field.INTEGER, 0));
		dataset.fieldDef(new Field("desc_val_clasif_art_2", Field.STRING, 50));
		dataset.fieldDef(new Field("label_col_1", Field.STRING, 20));
		dataset.fieldDef(new Field("label_col_2", Field.STRING, 20));
		dataset.fieldDef(new Field("label_col_3", Field.STRING, 20));
		dataset.fieldDef(new Field("label_col_4", Field.STRING, 20));
		dataset.fieldDef(new Field("label_col_5", Field.STRING, 20));
		dataset.fieldDef(new Field("label_col_6", Field.STRING, 20));
		dataset.fieldDef(new Field("label_col_7", Field.STRING, 20));
		dataset.fieldDef(new Field("label_col_8", Field.STRING, 20));
		dataset.fieldDef(new Field("label_col_9", Field.STRING, 20));
		dataset.fieldDef(new Field("cantidad", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("um", Field.STRING, 20));
		dataset.fieldDef(new Field("precio", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("total", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("acum_total", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("dto_1", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("precio_neto", Field.CURRENCY, 0));
		
		return dataset;
	}
	
	private void cargarRenglonProdGralClasifArt1(IDataSet ds,
			RenglonProdGral renglonProdGral,
			RenglonProdGralClasifArt1 renglonProdGralClasifArt1,
			Integer clave) throws BaseException {
		
		ds.append();
		ds.fieldValue("oid_secu_det", new Integer(++secu));
		ds.fieldValue("oid_secu", clave);
		ds.fieldValue("desc_val_clasif_art_2", renglonProdGralClasifArt1.valorClasifArt1.getDescripcion());
		
		for (int i=1;i<=9;++i) {
			
			if (renglonProdGral.listaLabels.size()<i)			
				ds.fieldValue("label_col_"+i, "");
			else {
				String codValClasif2 = ((CodValClasifArt2)renglonProdGral.listaLabels.get(i-1)).valor;
				Double cant = (Double)renglonProdGralClasifArt1.listaCantidades.get(codValClasif2);
				if (cant!=null)
					ds.fieldValue("label_col_"+i, cant);
				else
					ds.fieldValue("label_col_"+i, "");
			}
		}
		
		totAcumItems.sumar(new Money(renglonProdGralClasifArt1.total));
		
		ds.fieldValue("cantidad", renglonProdGralClasifArt1.cantidad);
		ds.fieldValue("um", renglonProdGralClasifArt1.um.getLabelImpresion());
		ds.fieldValue("precio", renglonProdGralClasifArt1.precio);
		ds.fieldValue("total", renglonProdGralClasifArt1.total);
		ds.fieldValue("acum_total" ,  totAcumItems.getResult());
		ds.fieldValue("dto_1" ,  renglonProdGralClasifArt1.porcDto1);
		ds.fieldValue("precio_neto" ,  renglonProdGralClasifArt1.precioNeto);
		
		
	}
	
	
	
	private void cargarRegistroProdGral(IDataSet dsProdGral,
			     Integer secu,
			     RenglonProdGral renglonProdGral,
			     Integer oidCCO) throws BaseException {
	
		
		dsProdGral.append();
		
		dsProdGral.fieldValue("secu", new Integer(secu));
		dsProdGral.fieldValue("oid_prod_gral", renglonProdGral.producto.getOID());
		dsProdGral.fieldValue("cod_prod_gral", renglonProdGral.producto.getCodigo());
		dsProdGral.fieldValue("desc_prod_gral", renglonProdGral.producto.getDescripcion());
		dsProdGral.fieldValue("desc_prod_adic", renglonProdGral.descAdicSKU);
		for (int i=1;i<=9;++i) {
			
			if (renglonProdGral.listaLabels.size()<i)			
				dsProdGral.fieldValue("label_col_"+i, "");
			else
				dsProdGral.fieldValue("label_col_"+i, ((CodValClasifArt2)renglonProdGral.listaLabels.get(i-1)).valor);
		}
		dsProdGral.fieldValue("oid_cco", oidCCO);
		dsProdGral.fieldValue("fec_requerida", renglonProdGral.fecReq);
		
	}

	private IDataSet getDataSetLabels() throws BaseException {
		IDataSet dataset = new TDataSet();
		dataset.create("TLabels");
		dataset.fieldDef(new Field("etiqueta", Field.STRING, 100));
		dataset.fieldDef(new Field("descripcion", Field.MEMO, 0));
		return dataset;
	}

	private void cargarEtiqueta(IDataSet ds, String etiqueta, String descripcion)
			throws BaseException {
		ds.append();
		ds.fieldValue("etiqueta", etiqueta);
		ds.fieldValue("descripcion", descripcion);
	}

	private void cargarEtiquetas(IDataSet ds) throws BaseException {
		Iterator iterEtiquetas = EtiquetaIdioma.getEtiquetasComprobante(
				OrdenDeCompraCab.NICKNAME, this.getSesion()).iterator();
		while (iterEtiquetas.hasNext()) {
			EtiquetaIdioma etiquetaIdioma = (EtiquetaIdioma) iterEtiquetas
					.next();
			String descripcion = lt.getEtiqueta(etiquetaIdioma.getEtiqueta());
			cargarEtiqueta(ds, etiquetaIdioma.getEtiqueta(), descripcion);
		}
	}

}
