package com.srn.erp.stock.op;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.general.bm.IValorClasificadorEntidad;
import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.impuestos.bm.ConceptoImpuesto;
import com.srn.erp.stock.bm.ConceptoImpuestoProducto;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.bm.TipoProducto;
import com.srn.erp.stock.bm.UnidadMedida;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bm.Varios.Money;
import framework.applicarionServer.bm.Varios.Porcentaje;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class GenerarProductos extends Operation {

	public GenerarProductos() {
	}

	ListaValClasif	listaValClasif						= new ListaValClasif();

	HashTableDatos	listaValActualesClasif		= new HashTableDatos();

	List						listaClasificadores				= null;

	List						listaProductosGenerados		= new ArrayList();

	HashTableDatos	listaConfigClasificadores	= new HashTableDatos();
	
	private TipoProducto tipoProducto = null;
	private Boolean comprable;
	private Boolean vendible;
	private Boolean stockeable;
	private Boolean prodPropio;
	private Boolean importado;
	private UnidadMedida umCompra;
	private UnidadMedida umVenta;
	private UnidadMedida umStock;
	private UnidadMedida umStockAlt;
	private UnidadMedida umProduccion;
	private Integer leadTimeEntrega;
	private Porcentaje porcCumpliOC;
	private ConceptoImpuesto conceptoImpuesto = null;
	private Date fecVigIVA = null;

	class RenglonClasificador implements Comparable {

		public static final int			SORT_BY_ORDEN_CODIGO			= 1;

		public static final int			SORT_BY_ORDEN_DESCRIPCION	= 2;
		
		public static final int			SORT_BY_ORDEN_CODIGO_BARRA	= 3;
		
		public static final int			SORT_BY_ORDEN_SINONIMO	= 4;
		
		
		

		public ClasificadorEntidad	clasifEntidad							= null;

		public boolean							incluirCodigo;

		public int									ordenCodigo;

		public String								prefijoCodigo;

		public String								sufijoCodigo;

		public boolean							incluirDescripcion;

		public int									ordenDescripcion;

		public String								prefijoDescripcion;

		public String								sufijoDescripcion;
		
		public boolean							incluirCodigoBarra;
		
		public int									ordenCodigoBarra;
		
		public String								prefijoCodigoBarra;
		
		public String								sufijoCodigoBarra;
		
		public boolean							incluirSinonimo;
		
		public int									ordenSinonimo;
		
		public String								prefijoSinonimo;
		
		public String								sufijoSinonimo;

		public int									tipoOrden									= 1;

		public int compareTo(Object arg0) {

			if (tipoOrden == SORT_BY_ORDEN_CODIGO) {
				RenglonClasificador aElemento = (RenglonClasificador) arg0;
				if (aElemento.ordenCodigo < this.ordenCodigo)
					return 1;
				else if (aElemento.ordenCodigo > this.ordenCodigo)
					return -1;
				else
					return 0;
			} 
			else 
			if (tipoOrden == SORT_BY_ORDEN_DESCRIPCION) {
				RenglonClasificador aElemento = (RenglonClasificador) arg0;
				if (aElemento.ordenDescripcion < this.ordenDescripcion)
					return 1;
				else if (aElemento.ordenDescripcion > this.ordenDescripcion)
					return -1;
				else
					return 0;
			} 
			else 
				if (tipoOrden == SORT_BY_ORDEN_CODIGO_BARRA) {
					RenglonClasificador aElemento = (RenglonClasificador) arg0;
					if (aElemento.ordenCodigoBarra < this.ordenCodigoBarra)
						return 1;
					else if (aElemento.ordenCodigoBarra > this.ordenCodigoBarra)
						return -1;
					else
						return 0;
				} 
				else 
					if (tipoOrden == SORT_BY_ORDEN_SINONIMO) {
						RenglonClasificador aElemento = (RenglonClasificador) arg0;
						if (aElemento.ordenSinonimo < this.ordenSinonimo)
							return 1;
						else if (aElemento.ordenSinonimo > this.ordenSinonimo)
							return -1;
						else
							return 0;
					} 
			else return 0;

		}

	}

	class RenglonValorClasif {
		public RenglonClasificador			renglonClasificador;

		public ClasificadorEntidad			clasifEntidad	= null;

		public ValorClasificadorEntidad	valorClasif;

		public String										codigoSugerido;

		public String										descSugerido;

		public String										descAbrevSugerido;

		public String										sinonimoSugerido;

		public String										codigoBarraSugerido;

	}

	class ListaValClasif extends HashTableDatos {

		List	listaValoresClasif	= null;

		public void add(ClasificadorEntidad clasificador, RenglonValorClasif renglonValClasif) {
			List listaValoresClasif = (List) this.get(clasificador.getOIDInteger());
			if (listaValoresClasif == null) {
				listaValoresClasif = new ArrayList();
				listaValoresClasif.add(renglonValClasif);
				this.put(clasificador.getOIDInteger(), listaValoresClasif);
			}
			else {
				listaValoresClasif.add(renglonValClasif);
			}
		}

		public List getValoresClasificador(ClasificadorEntidad clasif) {
			List lista = (List) this.get(clasif.getOIDInteger());
			if (lista != null)
				return lista;
			else
				return new ArrayList();
		}

	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		IDataSet dataset = mapaDatos.getDataSet("TGenProd");
		procesarRegistros(dataset);

		IDataSet dsProductosGenerados = getDataConsMasivaProductos("TProductos");

		Iterator iterProductosGenerados = listaProductosGenerados.iterator();
		while (iterProductosGenerados.hasNext()) {
			Producto producto = (Producto) iterProductosGenerados.next();
			cargarRegistro(dsProductosGenerados, producto);
		}

		writeCliente(dsProductosGenerados);

	}

	private void procesarRegistros(IDataSet dataset) throws BaseException {

		ClasificadorEntidad clasificador = null;
		ValorClasificadorEntidad valorClasificador = null;

		dataset.first();
		while (!dataset.EOF()) {

			// 
			
			tipoProducto = TipoProducto.findByOidProxy(dataset.getInteger("oid_tipo_producto"),this.getSesion());
			comprable = dataset.getBoolean("comprable");
			vendible = dataset.getBoolean("vendible");
			stockeable = dataset.getBoolean("stockeable");
			prodPropio = dataset.getBoolean("prod_propia");
			importado = dataset.getBoolean("importado");
			
			umCompra = UnidadMedida.findByOidProxy(dataset.getInteger("oid_um_compras"),this.getSesion());
			umVenta = UnidadMedida.findByOidProxy(dataset.getInteger("oid_um_vtas"),this.getSesion());
			umStock = UnidadMedida.findByOidProxy(dataset.getInteger("oid_um_stock"),this.getSesion());
			umStockAlt = UnidadMedida.findByOidProxy(dataset.getInteger("oid_um_stock_alt"),this.getSesion());
			umProduccion = UnidadMedida.findByOidProxy(dataset.getInteger("oid_produccion"),this.getSesion());
			
			leadTimeEntrega = dataset.getInteger("lt_entrega");
			porcCumpliOC = dataset.getPorcentaje("porc_cump_oc");
			
			conceptoImpuesto = ConceptoImpuesto.findByOidProxy(dataset.getInteger("oid_conc_impu"),this.getSesion());
			fecVigIVA = dataset.getDate("fec_vig_iva");
			
			// Clasificadores
			IDataSet dsClasif = dataset.getDataSet("TGenProdClasif");
			dsClasif.first();
			while (!dsClasif.EOF()) {

				clasificador = ClasificadorEntidad.findByOidProxy(dsClasif.getInteger("oid_clasif_prod"), this.getSesion());

				RenglonClasificador renglonClasificador = new RenglonClasificador();
				renglonClasificador.clasifEntidad = clasificador;
				
				renglonClasificador.incluirCodigo = dsClasif.getBoolean("incluir_codigo").booleanValue();
				if (dsClasif.getInteger("orden_incluir_codigo") != null)
					renglonClasificador.ordenCodigo = dsClasif.getInteger("orden_incluir_codigo").intValue();
				else
					renglonClasificador.ordenCodigo = 0;
				if (dsClasif.getString("prefijo_codigo") != null)
					renglonClasificador.prefijoCodigo = dsClasif.getString("prefijo_codigo");
				else
					renglonClasificador.prefijoCodigo = "";
				if (dsClasif.getString("sufijo_codigo") != null)
					renglonClasificador.sufijoCodigo = dsClasif.getString("sufijo_codigo");
				else
					renglonClasificador.sufijoCodigo = "";

				renglonClasificador.incluirDescripcion = dsClasif.getBoolean("incluir_descripcion").booleanValue();
				if (dsClasif.getInteger("orden_incluir_descripcion") != null)
					renglonClasificador.ordenDescripcion = dsClasif.getInteger("orden_incluir_descripcion").intValue();
				else
					renglonClasificador.ordenDescripcion = 0;
				if (dsClasif.getString("prefijo_descripcion") != null)
					renglonClasificador.prefijoDescripcion = dsClasif.getString("prefijo_descripcion");
				else
					renglonClasificador.prefijoDescripcion = "";
				if (dsClasif.getString("sufijo_descripcion") != null)
					renglonClasificador.sufijoDescripcion = dsClasif.getString("sufijo_descripcion");
				else
					renglonClasificador.sufijoDescripcion = "";

				renglonClasificador.incluirCodigoBarra = dsClasif.getBoolean("incluir_codigo_barra").booleanValue();
				if (dsClasif.getInteger("orden_codigo_barra") != null)
					renglonClasificador.ordenCodigoBarra = dsClasif.getInteger("orden_codigo_barra").intValue();
				else
					renglonClasificador.ordenCodigoBarra = 0;
				if (dsClasif.getString("prefijo_codigo_barra") != null)
					renglonClasificador.prefijoCodigoBarra = dsClasif.getString("prefijo_codigo_barra");
				else
					renglonClasificador.prefijoCodigoBarra = "";
				if (dsClasif.getString("sufijo_codigo_barra") != null)
					renglonClasificador.sufijoCodigoBarra = dsClasif.getString("sufijo_codigo_barra");
				else
					renglonClasificador.sufijoCodigoBarra = "";
								
				renglonClasificador.incluirSinonimo = dsClasif.getBoolean("incluir_sinonimo").booleanValue();
				if (dsClasif.getInteger("orden_sinonimo") != null)
					renglonClasificador.ordenSinonimo = dsClasif.getInteger("orden_sinonimo").intValue();
				else
					renglonClasificador.ordenSinonimo = 0;
				if (dsClasif.getString("prefijo_sinonimo") != null)
					renglonClasificador.prefijoSinonimo = dsClasif.getString("prefijo_sinonimo");
				else
					renglonClasificador.prefijoSinonimo = "";
				if (dsClasif.getString("sufijo_sinonimo") != null)
					renglonClasificador.sufijoSinonimo = dsClasif.getString("sufijo_sinonimo");
				else
					renglonClasificador.sufijoSinonimo = "";
				
				listaConfigClasificadores.put(clasificador.getOIDInteger(), renglonClasificador);

				// Procesar los Valores de los Clasificadores
				IDataSet dsValClasif = dsClasif.getDataSet("TGenProdValClasif");
				dsValClasif.first();
				while (!dsValClasif.EOF()) {

					if (dsValClasif.getBoolean("sel").booleanValue() == false) {
						dsValClasif.next();
						continue;
					}

					// Valor del clasificador
					valorClasificador = ValorClasificadorEntidad.findByOidProxy(dsValClasif.getInteger("oid_val_clasif"), this
							.getSesion());

					RenglonValorClasif renglonValClasif = new RenglonValorClasif();
					renglonValClasif.renglonClasificador = renglonClasificador;
					renglonValClasif.clasifEntidad = clasificador;
					renglonValClasif.valorClasif = valorClasificador;
					renglonValClasif.codigoSugerido = dsValClasif.getString("sug_codigo");
					renglonValClasif.descSugerido = dsValClasif.getString("sug_descripcion");
					renglonValClasif.descAbrevSugerido = dsValClasif.getString("sug_desc_abrev");
					renglonValClasif.sinonimoSugerido = dsValClasif.getString("sug_sinonimo");
					renglonValClasif.codigoBarraSugerido = dsValClasif.getString("sug_cod_barra");

					listaValClasif.add(clasificador, renglonValClasif);

					dsValClasif.next();
				}

				dsClasif.next();
			}

			dataset.next();
		}

		generarCombinaciones();
	}

	private void generarCombinaciones() throws BaseException {

		listaClasificadores = Producto.getClasificadoresEntidad(this.getSesion());

		if (listaClasificadores.size() == 0)
			return;

		// Obtener el Primer clasificador
		leerValoresClasif(0);

	}

	private void generarNuevoProducto(Producto producto) throws BaseException {
		this.listaProductosGenerados.add(producto);
	}

	private String getCodigoNuevoProducto() throws BaseException {
		StringBuffer nuevoCodigo = new StringBuffer("");
		
		Iterator iterClasif = listaConfigClasificadores.keySet().iterator();
		while (iterClasif.hasNext()) {
			Integer oidClasif = (Integer) iterClasif.next();
			RenglonClasificador renglonClasificador = (RenglonClasificador) listaConfigClasificadores.get(oidClasif);
			renglonClasificador.tipoOrden = RenglonClasificador.SORT_BY_ORDEN_CODIGO;
		}
		
		// Obtener la lista de Clasificadores
		List lista = new ArrayList();
		lista.addAll(listaConfigClasificadores.values());
		Collections.sort(lista);
		
		// Iterar por los clasificador que incluyan codigo en el orden correspondiente
		Iterator iterLista = lista.iterator();
		while (iterLista.hasNext()) {
			RenglonClasificador renglonClasificador = (RenglonClasificador) iterLista.next();
			
			if (renglonClasificador.incluirCodigo) {
				
				if (renglonClasificador.prefijoCodigo!=null)
					nuevoCodigo.append(renglonClasificador.prefijoCodigo);
			
				// Agregar el codigo del Valor del Clasificador
				RenglonValorClasif renglonValClasif = 
					(RenglonValorClasif)listaValActualesClasif.get(renglonClasificador.clasifEntidad.getOIDInteger());
				
				if (renglonValClasif!=null) 
					if (renglonValClasif.codigoSugerido!=null)
						nuevoCodigo.append(renglonValClasif.codigoSugerido);
				
				if (renglonClasificador.sufijoCodigo!=null)
					nuevoCodigo.append(renglonClasificador.sufijoCodigo);
				
			}
			
		}
		
		return nuevoCodigo.toString();
	}
	
	private String getCodigoBarraNuevo() throws BaseException {
		StringBuffer nuevoCodigo = new StringBuffer("");
		
		Iterator iterClasif = listaConfigClasificadores.keySet().iterator();
		while (iterClasif.hasNext()) {
			Integer oidClasif = (Integer) iterClasif.next();
			RenglonClasificador renglonClasificador = (RenglonClasificador) listaConfigClasificadores.get(oidClasif);
			renglonClasificador.tipoOrden = RenglonClasificador.SORT_BY_ORDEN_CODIGO_BARRA;
		}
		
		// Obtener la lista de Clasificadores
		List lista = new ArrayList();
		lista.addAll(listaConfigClasificadores.values());
		Collections.sort(lista);
		
		// Iterar por los clasificador que incluyan codigo en el orden correspondiente
		Iterator iterLista = lista.iterator();
		while (iterLista.hasNext()) {
			RenglonClasificador renglonClasificador = (RenglonClasificador) iterLista.next();
			
			if (renglonClasificador.incluirCodigoBarra) {
				
				if (renglonClasificador.prefijoCodigoBarra!=null)
					nuevoCodigo.append(renglonClasificador.prefijoCodigoBarra);
			
				// Agregar el codigo del Valor del Clasificador
				RenglonValorClasif renglonValClasif = 
					(RenglonValorClasif)listaValActualesClasif.get(renglonClasificador.clasifEntidad.getOIDInteger());
				
				if (renglonValClasif!=null) 
					if (renglonValClasif.codigoBarraSugerido!=null)
						nuevoCodigo.append(renglonValClasif.codigoBarraSugerido);
				
				if (renglonClasificador.sufijoCodigoBarra!=null)
					nuevoCodigo.append(renglonClasificador.sufijoCodigoBarra);
				
			}
			
		}
		
		return nuevoCodigo.toString();
	}
	
	private String getSinonimoNuevo() throws BaseException {
		StringBuffer nuevoCodigo = new StringBuffer("");
		
		Iterator iterClasif = listaConfigClasificadores.keySet().iterator();
		while (iterClasif.hasNext()) {
			Integer oidClasif = (Integer) iterClasif.next();
			RenglonClasificador renglonClasificador = (RenglonClasificador) listaConfigClasificadores.get(oidClasif);
			renglonClasificador.tipoOrden = RenglonClasificador.SORT_BY_ORDEN_SINONIMO;
		}
		
		// Obtener la lista de Clasificadores
		List lista = new ArrayList();
		lista.addAll(listaConfigClasificadores.values());
		Collections.sort(lista);
		
		// Iterar por los clasificador que incluyan codigo en el orden correspondiente
		Iterator iterLista = lista.iterator();
		while (iterLista.hasNext()) {
			RenglonClasificador renglonClasificador = (RenglonClasificador) iterLista.next();
			
			if (renglonClasificador.incluirSinonimo) {
				
				if (renglonClasificador.prefijoSinonimo!=null)
					nuevoCodigo.append(renglonClasificador.prefijoSinonimo);
			
				// Agregar el codigo del Valor del Clasificador
				RenglonValorClasif renglonValClasif = 
					(RenglonValorClasif)listaValActualesClasif.get(renglonClasificador.clasifEntidad.getOIDInteger());
				
				if (renglonValClasif!=null) 
					if (renglonValClasif.sinonimoSugerido!=null)
						nuevoCodigo.append(renglonValClasif.sinonimoSugerido);
				
				if (renglonClasificador.sufijoSinonimo!=null)
					nuevoCodigo.append(renglonClasificador.sufijoSinonimo);
				
			}
			
		}
		
		return nuevoCodigo.toString();
	}
	
	private String getDescripcionNuevoProducto() throws BaseException {
		StringBuffer nuevaDescripcion = new StringBuffer("");
		
		Iterator iterClasif = listaConfigClasificadores.keySet().iterator();
		while (iterClasif.hasNext()) {
			Integer oidClasif = (Integer) iterClasif.next();
			RenglonClasificador renglonClasificador = (RenglonClasificador) listaConfigClasificadores.get(oidClasif);
			renglonClasificador.tipoOrden = RenglonClasificador.SORT_BY_ORDEN_DESCRIPCION;
		}
		
		// Obtener la lista de Clasificadores
		List lista = new ArrayList();
		lista.addAll(listaConfigClasificadores.values());
		Collections.sort(lista);
		
		// Iterar por los clasificador que incluyan codigo en el orden correspondiente
		Iterator iterLista = lista.iterator();
		while (iterLista.hasNext()) {
			RenglonClasificador renglonClasificador = (RenglonClasificador) iterLista.next();
			
			if (renglonClasificador.incluirDescripcion) {
				
				if (renglonClasificador.prefijoDescripcion!=null)
					nuevaDescripcion.append(renglonClasificador.prefijoDescripcion);
			
				// Agregar el codigo del Valor del Clasificador
				RenglonValorClasif renglonValClasif = 
					(RenglonValorClasif)listaValActualesClasif.get(renglonClasificador.clasifEntidad.getOIDInteger());
				
				if (renglonValClasif!=null) 
					if (renglonValClasif.descSugerido!=null)
						nuevaDescripcion.append(renglonValClasif.descSugerido);
				
				if (renglonClasificador.sufijoDescripcion!=null)
					nuevaDescripcion.append(renglonClasificador.sufijoDescripcion);
				
			}
			
		}
		
		return nuevaDescripcion.toString();
	}
	
	private String getDescAbrevNuevoProducto() throws BaseException {
		StringBuffer nuevaDescripcion = new StringBuffer("");
		
		Iterator iterClasif = listaConfigClasificadores.keySet().iterator();
		while (iterClasif.hasNext()) {
			Integer oidClasif = (Integer) iterClasif.next();
			RenglonClasificador renglonClasificador = (RenglonClasificador) listaConfigClasificadores.get(oidClasif);
			renglonClasificador.tipoOrden = RenglonClasificador.SORT_BY_ORDEN_DESCRIPCION;
		}
		
		// Obtener la lista de Clasificadores
		List lista = new ArrayList();
		lista.addAll(listaConfigClasificadores.values());
		Collections.sort(lista);
		
		// Iterar por los clasificador que incluyan codigo en el orden correspondiente
		Iterator iterLista = lista.iterator();
		while (iterLista.hasNext()) {
			RenglonClasificador renglonClasificador = (RenglonClasificador) iterLista.next();
			
			if (renglonClasificador.incluirDescripcion) {
				
				if (renglonClasificador.prefijoDescripcion!=null)
					nuevaDescripcion.append(renglonClasificador.prefijoDescripcion);
			
				// Agregar el codigo del Valor del Clasificador
				RenglonValorClasif renglonValClasif = 
					(RenglonValorClasif)listaValActualesClasif.get(renglonClasificador.clasifEntidad.getOIDInteger());
				
				if (renglonValClasif!=null) 
					if (renglonValClasif.descAbrevSugerido!=null)
						nuevaDescripcion.append(renglonValClasif.descAbrevSugerido);
				
				if (renglonClasificador.sufijoDescripcion!=null)
					nuevaDescripcion.append(renglonClasificador.sufijoDescripcion);
				
			}
			
		}
		
		return nuevaDescripcion.toString();
	}

	
	
	private void leerValoresClasif(int nroClasif) throws BaseException {

		if (listaClasificadores.size() == nroClasif) {
			// Dar de Alta los Valores
			Producto producto = (Producto) Producto.getNew(Producto.NICKNAME, this.getSesion());
			producto.setCodigo(getCodigoNuevoProducto());
			producto.setDescripcion(getDescripcionNuevoProducto());
			producto.setDesc_abrev(getDescAbrevNuevoProducto());
			producto.setTipoproducto(tipoProducto);
			producto.setComprable(comprable);
			producto.setVendible(vendible);
			producto.setStockeable(stockeable);
			producto.setProd_propia(prodPropio);
			producto.setImportado(importado);
			producto.setSinonimo(getSinonimoNuevo());
			producto.setCodigo_barra(getCodigoBarraNuevo());
			producto.setUm_cpra(umCompra);
			producto.setUm_vta(umVenta);
			producto.setUm_stk(umStock);
			producto.setUm_stk_alt(umStockAlt);
			producto.setUm_prod(umProduccion);
			producto.setLt_entrega(leadTimeEntrega);
			producto.setActivo(new Boolean(true));
			
			if (porcCumpliOC!=null)
				producto.setPorc_cump_oc(new Money(porcCumpliOC.doubleValue()));
			
			if (conceptoImpuesto!=null) {
				ConceptoImpuestoProducto concImpuProd = 
					(ConceptoImpuestoProducto) ConceptoImpuestoProducto.getNew(ConceptoImpuestoProducto.NICKNAME,this.getSesion());
				concImpuProd.setProducto(producto);
				concImpuProd.setFecha_vigencia(fecVigIVA);
				concImpuProd.setConcepto_impuesto(conceptoImpuesto);
				producto.addConceptoImpuesto(concImpuProd);
			}
			
			Iterator iterOidClasifEnt = listaConfigClasificadores.keySet().iterator();
			while (iterOidClasifEnt.hasNext()) {
				Integer oidClasifEnt = (Integer) iterOidClasifEnt.next();
				RenglonValorClasif valClasifEnt = (RenglonValorClasif) 	listaValActualesClasif.get(oidClasifEnt);
				
				if (valClasifEnt!=null)
					if (valClasifEnt.valorClasif!=null) 
						producto.addOidValorClasif(
								valClasifEnt.clasifEntidad.getNroClasif(),
								valClasifEnt.valorClasif.getOIDInteger());
				
			}
			
			// Generar Nuevo Producto
			generarNuevoProducto(producto);

			return;
		}

		ClasificadorEntidad clasif = (ClasificadorEntidad) listaClasificadores.get(nroClasif);

		List valores = listaValClasif.getValoresClasificador(clasif);
		if (valores.size() == 0) {
			listaValActualesClasif.remove(clasif.getOIDInteger());
			leerValoresClasif(nroClasif + 1);
		}
		else {
			Iterator iterValClasif = valores.iterator();
			while (iterValClasif.hasNext()) {
				RenglonValorClasif valClasifEnt = (RenglonValorClasif) iterValClasif.next();
				listaValActualesClasif.put(clasif.getOIDInteger(), valClasifEnt);
				leerValoresClasif(nroClasif + 1);
			}
		}
	}

	private IDataSet getDataConsMasivaProductos(String nombreTabla) throws BaseException {
		IDataSet dataset = new TDataSet();
		dataset.create(nombreTabla);
		dataset.fieldDef(new Field("oid_producto", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_producto", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_producto", Field.STRING, 100));
		dataset.fieldDef(new Field("desc_abrev_producto", Field.STRING, 100));
		dataset.fieldDef(new Field("oid_tipo_producto", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_tipo_producto", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_tipo_producto", Field.STRING, 100));
		dataset.fieldDef(new Field("comprable", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("vendible", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("stockeable", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("prod_propia", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("importado", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("sinonimo", Field.STRING, 50));
		dataset.fieldDef(new Field("codigo_barra", Field.STRING, 50));
		dataset.fieldDef(new Field("oid_um_compra", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_um_compra", Field.STRING, 50));
		dataset.fieldDef(new Field("porc_cump_oc", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("oid_um_vta", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_um_vta", Field.STRING, 50));
		dataset.fieldDef(new Field("lead_time_ent_vta", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_impu_iva", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_impu_iva", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_impu_iva", Field.STRING, 100));
		dataset.fieldDef(new Field("fec_vig_imp_vtas", Field.DATE, 0));
		dataset.fieldDef(new Field("oid_um_stk_ppal", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_um_stk_ppal", Field.STRING, 50));
		dataset.fieldDef(new Field("oid_um_stk_alt", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_um_stk_alt", Field.STRING, 50));
		dataset.fieldDef(new Field("oid_um_stk_prod", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_um_stk_prod", Field.STRING, 50));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));

		Iterator iterClasifEnt = Producto.getClasificadoresEntidad(this.getSesion()).iterator();
		while (iterClasifEnt.hasNext()) {
			ClasificadorEntidad clasifEnt = (ClasificadorEntidad) iterClasifEnt.next();

			dataset.fieldDef(new Field("oid_clasif_" + clasifEnt.getOIDInteger(), Field.INTEGER, 0));
			dataset.fieldDef(new Field("cod_clasif_" + clasifEnt.getOIDInteger(), Field.STRING, 50));
			dataset.fieldDef(new Field("desc_clasif_" + clasifEnt.getOIDInteger(), Field.STRING, 100));

		}

		return dataset;
	}

	private void cargarRegistro(IDataSet dataset, Producto producto) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_producto", producto.getOIDInteger());
		dataset.fieldValue("cod_producto", producto.getCodigo());
		dataset.fieldValue("desc_producto", producto.getDescripcion());
		dataset.fieldValue("desc_abrev_producto", producto.getDesc_abrev());
		if (producto.getTipoproducto() != null) {
			dataset.fieldValue("oid_tipo_producto", producto.getTipoproducto().getOIDInteger());
			dataset.fieldValue("cod_tipo_producto", producto.getTipoproducto().getCodigo());
			dataset.fieldValue("desc_tipo_producto", producto.getTipoproducto().getDescripcion());
		}
		else {
			dataset.fieldValue("oid_tipo_producto", new Integer(0));
			dataset.fieldValue("cod_tipo_producto", "");
			dataset.fieldValue("desc_tipo_producto", "");
		}
		dataset.fieldValue("comprable", producto.isComprable());
		dataset.fieldValue("vendible", producto.isVendible());
		dataset.fieldValue("stockeable", producto.isStockeable());
		dataset.fieldValue("prod_propia", producto.isProd_propia());
		dataset.fieldValue("importado", producto.isImportado());
		dataset.fieldValue("sinonimo", producto.getSinonimo());
		dataset.fieldValue("codigo_barra", producto.getCodigo_barra());

		if (producto.getUm_cpra() != null) {
			dataset.fieldValue("oid_um_compra", producto.getUm_cpra().getOIDInteger());
			dataset.fieldValue("cod_um_compra", producto.getUm_cpra().getCodigo());
		}
		else {
			dataset.fieldValue("oid_um_compra", new Integer(0));
			dataset.fieldValue("cod_um_compra", "");
		}

		dataset.fieldValue("porc_cump_oc", producto.getPorc_cump_oc());

		if (producto.getUm_vta() != null) {
			dataset.fieldValue("oid_um_vta", producto.getUm_vta().getOIDInteger());
			dataset.fieldValue("cod_um_vta", producto.getUm_vta().getCodigo());
		}
		else {
			dataset.fieldValue("oid_um_vta", new Integer(0));
			dataset.fieldValue("cod_um_vta", "");
		}

		dataset.fieldValue("lead_time_ent_vta", producto.getLeadTimeVta());

		ConceptoImpuestoProducto concImpuIVAProducto = producto.getFirstConceptoImpuestoProducto();

		if (concImpuIVAProducto != null) {
			dataset.fieldValue("oid_impu_iva", concImpuIVAProducto.getConcepto_impuesto().getOIDInteger());
			dataset.fieldValue("cod_impu_iva", concImpuIVAProducto.getConcepto_impuesto().getCodigo());
			dataset.fieldValue("desc_impu_iva", concImpuIVAProducto.getConcepto_impuesto().getDescripcion());
			dataset.fieldValue("fec_vig_imp_vtas", concImpuIVAProducto.getFecha_vigencia());
		}
		else {
			dataset.fieldValue("oid_impu_iva", new Integer(0));
			dataset.fieldValue("cod_impu_iva", "");
			dataset.fieldValue("desc_impu_iva", "");
			dataset.fieldValue("fec_vig_imp_vtas", Fecha.FECHA_NULA());

		}

		if (producto.getUm_stk() != null) {
			dataset.fieldValue("oid_um_stk_ppal", producto.getUm_stk().getOIDInteger());
			dataset.fieldValue("cod_um_stk_ppal", producto.getUm_stk().getCodigo());
		}
		else {
			dataset.fieldValue("oid_um_stk_ppal", new Integer(0));
			dataset.fieldValue("cod_um_stk_ppal", "");
		}

		if (producto.getUm_stk() != null) {
			dataset.fieldValue("oid_um_stk_alt", producto.getUm_stk().getOIDInteger());
			dataset.fieldValue("cod_um_stk_alt", producto.getUm_stk().getCodigo());
		}
		else {
			dataset.fieldValue("oid_um_stk_alt", new Integer(0));
			dataset.fieldValue("cod_um_stk_alt", "");
		}

		if (producto.getUm_prod() != null) {
			dataset.fieldValue("oid_um_stk_prod", producto.getUm_prod().getOIDInteger());
			dataset.fieldValue("cod_um_stk_prod", producto.getUm_prod().getCodigo());
		}
		else {
			dataset.fieldValue("oid_um_stk_prod", new Integer(0));
			dataset.fieldValue("cod_um_stk_prod", "");
		}

		dataset.fieldValue("activo", producto.isActivo());

		Iterator iterClasifEnt = Producto.getClasificadoresEntidad(this.getSesion()).iterator();
		while (iterClasifEnt.hasNext()) {
			ClasificadorEntidad clasifEnt = (ClasificadorEntidad) iterClasifEnt.next();

			IValorClasificadorEntidad valClasifEnt = producto.getValorClasifEnt(clasifEnt);

			if (valClasifEnt != null) {
				dataset.fieldValue("oid_clasif_" + clasifEnt.getOIDInteger(), valClasifEnt.getOID());
				dataset.fieldValue("cod_clasif_" + clasifEnt.getOIDInteger(), valClasifEnt.getCodigo());
				dataset.fieldValue("desc_clasif_" + clasifEnt.getOIDInteger(), valClasifEnt.getDescripcion());
			}
			else {
				dataset.fieldValue("oid_clasif_" + clasifEnt.getOIDInteger(), new Integer(0));
				dataset.fieldValue("cod_clasif_" + clasifEnt.getOIDInteger(), "");
				dataset.fieldValue("desc_clasif_" + clasifEnt.getOIDInteger(), "");
			}

		}

	}

}
