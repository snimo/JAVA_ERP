package com.srn.erp.stock.op;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.stock.bm.Producto;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class GenerCodProdStock extends Operation {

	private HashTableDatos	listaConfigClasificadores	= new HashTableDatos();
	private ListaValClasif	listaValClasif				= new ListaValClasif();
	private List			listaClasificadores			= null;
	private List			listaProductosGenerados		= new ArrayList();
	private HashTableDatos	listaValActualesClasif		= new HashTableDatos();
	private String 			codigo						= null;
	private String 			descripcion					= null;
	
	public GenerCodProdStock() {
	}

	@Override
	public void execute(MapDatos mapaDatos) throws BaseException {
		
		codigo = mapaDatos.getString("codigo");
		descripcion = mapaDatos.getString("descripcion");
		
		if ((codigo == null) || (codigo.trim().length() == 0))
			throw new ExceptionValidation(null,"Debe ingresar el código del Producto");
		
		if ((descripcion == null) || (descripcion.trim().length() == 0))
			throw new ExceptionValidation(null,"Debe ingresar la descripción del Producto");		
		
		IDataSet dsClasif = mapaDatos.getDataSet("TClasificadores");
		dsClasif.first();
		while (!dsClasif.EOF()) {
			ClasificadorEntidad clasif = ClasificadorEntidad.findByOid(dsClasif.getInteger("oid_clasif"), this.getSesion());
			
			RenglonClasificador renglonClasificador = new RenglonClasificador();
			renglonClasificador.clasifEntidad = clasif;
			
			if (clasif.getConfGenMasProd()!=null) {
				renglonClasificador.incluirCodigo = clasif.getConfGenMasProd().isIncluir_codigo();
				renglonClasificador.ordenCodigo = clasif.getConfGenMasProd().getOrden_codigo();
				renglonClasificador.prefijoCodigo = clasif.getConfGenMasProd().getPre_codigo();
				renglonClasificador.sufijoCodigo = clasif.getConfGenMasProd().getSuf_codigo();
				renglonClasificador.incluirDescripcion = clasif.getConfGenMasProd().isIncluir_desc();
				renglonClasificador.ordenDescripcion = clasif.getConfGenMasProd().getOrden_desc();
				renglonClasificador.prefijoDescripcion = clasif.getConfGenMasProd().getPre_desc();
				renglonClasificador.sufijoDescripcion = clasif.getConfGenMasProd().getSuf_desc();
				renglonClasificador.incluirCodigoBarra = clasif.getConfGenMasProd().isIncluir_barra();
				renglonClasificador.ordenCodigoBarra = clasif.getConfGenMasProd().getOrden_barra();
				renglonClasificador.prefijoCodigoBarra = clasif.getConfGenMasProd().getPre_barra();
				renglonClasificador.sufijoCodigoBarra = clasif.getConfGenMasProd().getSuf_barra();
				renglonClasificador.incluirSinonimo = clasif.getConfGenMasProd().isIncluir_sino();
				renglonClasificador.ordenSinonimo = clasif.getConfGenMasProd().getOrden_sino();
				renglonClasificador.prefijoSinonimo = clasif.getConfGenMasProd().getPre_sino();
				renglonClasificador.sufijoSinonimo = clasif.getConfGenMasProd().getSuf_sino();
			}
			
			listaConfigClasificadores.put(clasif.getOIDInteger(), renglonClasificador);
			
			IDataSet dsValClasif = dsClasif.getDataSet("TValoresClasificador");
			dsValClasif.first();
			while (!dsValClasif.EOF()) {
				
				if (!dsValClasif.getBoolean("sel")) {
					dsValClasif.next();
					continue;
				}
					
				ValorClasificadorEntidad valor = 
					ValorClasificadorEntidad.findByOid(dsValClasif.getInteger("oid_valor_clasif"), this.getSesion());
				
				RenglonValorClasif renglonValClasif = new RenglonValorClasif();
				renglonValClasif.renglonClasificador = renglonClasificador;
				renglonValClasif.clasifEntidad = clasif;
				renglonValClasif.valorClasif = valor;
				renglonValClasif.codigoSugerido = dsValClasif.getString("codigo");
				renglonValClasif.descSugerido = dsValClasif.getString("descripcion");
				renglonValClasif.descAbrevSugerido = dsValClasif.getString("descripcion");
				renglonValClasif.sinonimoSugerido = "";
				renglonValClasif.codigoBarraSugerido = "";
				
				
				listaValClasif.add(clasif, renglonValClasif);
					
					
				
				dsValClasif.next();
			}
			
			
			dsClasif.next();
		}
				
		generarCombinaciones();
		
		enviarNuevosProductos();
		
	}
	
	private void generarCombinaciones() throws BaseException {

		listaClasificadores = Producto.getClasificadoresEntidadActivos(this.getSesion());

		if (listaClasificadores.size() == 0)
			return;

		// Obtener el Primer clasificador
		leerValoresClasif(0);
		
		

	}
	
	private void leerValoresClasif(int nroClasif) throws BaseException {

		if (listaClasificadores.size() == nroClasif) {
			
			NuevoProdStock nuevoProdStock = new NuevoProdStock();
			nuevoProdStock.codigo = getCodigoNuevoProducto();
			nuevoProdStock.descripcion = getDescripcionNuevoProducto(); 
			nuevoProdStock.descAbrev = getDescripcionNuevoProducto();
			nuevoProdStock.sinonimo = getSinonimoNuevo();
			nuevoProdStock.codigoBarra = getCodigoBarraNuevo(); 
			
			Iterator iterOidClasifEnt = listaConfigClasificadores.keySet().iterator();
			while (iterOidClasifEnt.hasNext()) {
				Integer oidClasifEnt = (Integer) iterOidClasifEnt.next();
				RenglonValorClasif valClasifEnt = (RenglonValorClasif) 	listaValActualesClasif.get(oidClasifEnt);
				
				if (valClasifEnt!=null)
					if (valClasifEnt.valorClasif!=null) 
						nuevoProdStock.addValorClasificador(valClasifEnt.valorClasif);
				
			}
			
			// Generar Nuevo Producto
			generarNuevoProducto(nuevoProdStock);

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
	
	
	
	private IDataSet getDSCodNuevosProd() { 
		    IDataSet dataset = new TDataSet(); 
		    dataset.create("TCodNuevosProd");
		    dataset.fieldDef(new Field("cod_producto", Field.STRING, 50));
		    dataset.fieldDef(new Field("descripcion", Field.STRING, 255));
		    return dataset;
	}
	
	private void cargarNuevoProducto(IDataSet ds,String codigo,String descripcion) throws BaseException {
		ds.append();
		ds.fieldValue("cod_producto", codigo);
		ds.fieldValue("descripcion", descripcion);
	}
	
	private IDataSet getDSValClasifCodNuevosProd() { 
	    IDataSet dataset = new TDataSet(); 
	    dataset.create("TValClasifCodNuevoProd");
	    dataset.fieldDef(new Field("oid_valor_clasif", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("cod_producto", Field.STRING, 50));
	    dataset.fieldDef(new Field("cod_valor_clasif", Field.STRING, 50));
	    dataset.fieldDef(new Field("desc_valor_clasif", Field.STRING, 255));
	    dataset.fieldDef(new Field("oid_clasif_ent", Field.INTEGER, 0));
	    return dataset;
	}
	
	private void cargarValorClasif(IDataSet ds,String codigoProducto,ValorClasificadorEntidad valorClasif) throws BaseException {
		ds.append();
		ds.fieldValue("oid_valor_clasif", valorClasif.getOIDInteger());
		ds.fieldValue("cod_producto", codigoProducto);
		ds.fieldValue("cod_valor_clasif", valorClasif.getCodigo());
		ds.fieldValue("desc_valor_clasif", valorClasif.getDescripcion());
		ds.fieldValue("oid_clasif_ent", valorClasif.getClasificador_entidad().getOIDInteger());
		
	}
	
	
	
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
	
	class NuevoProdStock {
		
		private String codigo;
		private String descripcion;
		private String descAbrev;
		private String sinonimo;
		private String codigoBarra;
		
		List valoresClasificador = new ArrayList();
		
		public String getCodigo() {
			return codigo;
		}
		public void setCodigo(String codigo) {
			this.codigo = codigo;
		}
		public String getDescripcion() {
			return descripcion;
		}
		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}
		public String getDescAbrev() {
			return descAbrev;
		}
		public void setDescAbrev(String descAbrev) {
			this.descAbrev = descAbrev;
		}
		public String getSinonimo() {
			return sinonimo;
		}
		public void setSinonimo(String sinonimo) {
			this.sinonimo = sinonimo;
		}
		public String getCodigoBarra() {
			return codigoBarra;
		}
		public void setCodigoBarra(String codigoBarra) {
			this.codigoBarra = codigoBarra;
		}
		
		public void addValorClasificador(ValorClasificadorEntidad valor) throws BaseException {
			this.valoresClasificador.add(valor);
		}
		
		public List getValoresClasificador() throws BaseException {
			return this.valoresClasificador;
		}
	}

	private void generarNuevoProducto(NuevoProdStock nuevoProdStock) throws BaseException {
		this.listaProductosGenerados.add(nuevoProdStock);
	}
	
	private void enviarNuevosProductos() throws BaseException {
		
		IDataSet dsNuevoProd = this.getDSCodNuevosProd();
		IDataSet dsValoresClasif = this.getDSValClasifCodNuevosProd();
		
		Iterator iterProdGenerados = 
			this.listaProductosGenerados.iterator();
		while (iterProdGenerados.hasNext()) {
			NuevoProdStock nuevoProdStock = (NuevoProdStock) iterProdGenerados.next();
			cargarNuevoProducto(dsNuevoProd, nuevoProdStock.codigo, nuevoProdStock.descripcion);
			
			Iterator iterValoresClasificador = 
				nuevoProdStock.getValoresClasificador().iterator();
			while (iterValoresClasificador.hasNext()) {
				ValorClasificadorEntidad valClasifEnt = 
					(ValorClasificadorEntidad) iterValoresClasificador.next();
				cargarValorClasif(dsValoresClasif, nuevoProdStock.codigo, valClasifEnt);
			}
		}
		
		writeCliente(dsNuevoProd);
		writeCliente(dsValoresClasif);
		
	}

	
	
	
	private String getCodigoNuevoProducto() throws BaseException {
		StringBuffer nuevoCodigo = new StringBuffer(codigo.trim());
		
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
		
		return nuevoCodigo.toString().toUpperCase();
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
		
		return nuevoCodigo.toString().toUpperCase();
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
		
		return nuevoCodigo.toString().toUpperCase();
	}
	
	private String getDescripcionNuevoProducto() throws BaseException {
		StringBuffer nuevaDescripcion = new StringBuffer(descripcion.trim());
		
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
		
		return nuevaDescripcion.toString().toUpperCase();
	}
	
	private String getDescAbrevNuevoProducto() throws BaseException {
		StringBuffer nuevaDescripcion = new StringBuffer(descripcion.trim());
		
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
		
		return nuevaDescripcion.toString().toUpperCase();
	}

	

}
