package com.srn.erp.stock.op;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.compras.bm.OrdenDeCompraDet;
import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.general.bm.IValorClasificadorEntidad;
import com.srn.erp.stock.bm.ConfConsGenStock;
import com.srn.erp.stock.bm.ConfConsGenStockDepo;
import com.srn.erp.stock.bm.ConfConsGenStockEst;
import com.srn.erp.stock.bm.ConsultaStock;
import com.srn.erp.stock.bm.EstadoStock;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.ventas.bm.PedidoDet;

import framework.applicarionServer.bl.Presentacion.Grilla;
import framework.applicarionServer.bm.Varios.CalculadorMoney;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerConsGenStock extends Operation {

	
	List listaConfDepo = null;
	
	class Fila {
		Integer oidProducto;
		Double cantPedidos;
		Double cantOC;
		String titulo = "";
		String subTitulo = "";
		String codigo = "";
		HashTableDatos saldoPorDepo = new HashTableDatos();
		CalculadorMoney total = new CalculadorMoney(new Money(0));
		
		public Fila(
				String titulo,
				String subTitulo,
				String codigo,
				Double cantPedidos,
				Double cantOC) {
			this.titulo = titulo;
			this.subTitulo = subTitulo;
			this.codigo = codigo;
			this.cantOC = cantOC;
			this.cantPedidos = cantPedidos;
		}
		
		public void addCantDepo(Integer oidDepo, double cantidad) {
			total.sumar(new Money(cantidad));
			CalculadorMoney calcSaldo = (CalculadorMoney)saldoPorDepo.get(oidDepo);
			if (calcSaldo == null) {
				calcSaldo = new CalculadorMoney(new Money(cantidad));
				saldoPorDepo.put(oidDepo, calcSaldo);
				return;
			} else 
				calcSaldo.sumar(new Money(cantidad));
		}
		
		public double getSaldoDepo(Integer oidDepo) {
			CalculadorMoney calcSaldo = (CalculadorMoney) saldoPorDepo.get(oidDepo);
			if (calcSaldo == null)
				return 0;
			else
				return calcSaldo.getResult();
		}
		
		public double getCantOC() {
			return this.cantOC;
		}
		
		public double getCantPedidos() {
			return this.cantPedidos;
		}
		
		public double getLibre() {
			return this.total.getResult() + this.cantOC - this.cantPedidos;
		}
				
				
	}
	
	private HashTableDatos filasConsulta = new HashTableDatos();
	
	private Fila getFila(String titulo,String subTitulo,String codigo) throws BaseException {
		String clave = getClave(titulo,subTitulo,codigo);
		return (Fila)filasConsulta.get(clave);
	}
	
	private String getClave(String titulo,String subTitulo,String codigo) {
		return titulo + "_" + subTitulo + "-" + codigo; 
	}

	public TraerConsGenStock() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		ConfConsGenStock confConsGenStock = ConfConsGenStock.findByOid(mapaDatos.getInteger("oid_conf_cons_gen_stock"), this.getSesion());
		listaConfDepo = confConsGenStock.getConfDepositos();
		Collections.sort(listaConfDepo);
		
		if (mapaDatos.containsKey("ESTRUCTURA"))
			procesarEstructura(mapaDatos);
		else if (mapaDatos.containsKey("DATOS"))
				procesarDatos(mapaDatos);

	}
	
	private void procesarDatos(MapDatos mapaDatos) throws BaseException {
		
		ConfConsGenStock confConsGenStock = ConfConsGenStock.findByOid(mapaDatos.getInteger("oid_conf_cons_gen_stock"), this.getSesion());
		IDataSet ds = getDataSetConsulta(confConsGenStock);

		if ((confConsGenStock.getCantEstados()==1) || (confConsGenStock.isConsolidarStock()))
			consultaConUnEstado(confConsGenStock,mapaDatos,ds);
		else 
			consultaConMasDeUnEstado(confConsGenStock,mapaDatos,ds);
		writeCliente(ds);

		
	}
	
	private void consultaConMasDeUnEstado(ConfConsGenStock confConsGenStock,MapDatos mapaDatos, IDataSet ds) throws BaseException {

		List listaDepositos = new ArrayList();
		List listaEstados = new ArrayList();
		
		Iterator iterConfDepo = 
			listaConfDepo.iterator();
		while (iterConfDepo.hasNext()) {
			ConfConsGenStockDepo confConsGenStockDepo = (ConfConsGenStockDepo) iterConfDepo.next();
			listaDepositos.add(confConsGenStockDepo.getDeposito());
		}
		
		Iterator iterConfEst = 
			confConsGenStock.getConfEstados().iterator();
		while (iterConfEst.hasNext()) {
			ConfConsGenStockEst confConsGenStockEst = (ConfConsGenStockEst) iterConfEst.next();
			listaEstados.add(confConsGenStockEst.getEstado_stock());
		}
		
		
		// Definir el contenido de la fila
		
		String titulo = "";
		String subTitulo = "";
		String codigo = "";
		Integer oidProducto = null;
		Double cantPedidos = null;
		Double cantOC = null;
		
		
		Iterator iterEstados = 
			listaEstados.iterator();
		while (iterEstados.hasNext()) {
			EstadoStock estadoStock = (EstadoStock) iterEstados.next();

			
			List listaParaFiltrar = new ArrayList();
			listaParaFiltrar.add(estadoStock);
			Iterator iterConsSaldosStock = 
				ConsultaStock.getConsultaSaldosEstadosStock(listaDepositos,listaParaFiltrar,null,null,null,null,this.getSesion()).iterator();
			
			while (iterConsSaldosStock.hasNext()) {
				ConsultaStock consultaStock = (ConsultaStock) iterConsSaldosStock.next();
				
				titulo = "";
				subTitulo = "";
				codigo = "";
				oidProducto = null;

				if (confConsGenStock.getTipo_valor_fila().equals("PRODUCTO")) {
					subTitulo = estadoStock.getDescripcion();
					oidProducto = consultaStock.getOid_producto();
					Producto producto = Producto.findByOidProxy(oidProducto, this.getSesion());
					codigo = producto.getCodigo();
					titulo = producto.getDescripcion() + " - " + producto.getCodigo(); 
				} else if (confConsGenStock.getTipo_valor_fila().equals("CLASIFICADOR")) {
					subTitulo = estadoStock.getDescripcion();
					oidProducto = consultaStock.getOid_producto();
					Producto producto = Producto.findByOidProxy(oidProducto, this.getSesion());
					IValorClasificadorEntidad valorClasif = 
						producto.getValorClasifEnt(confConsGenStock.getClasif_ent_fila());
					if (valorClasif!=null) {
						titulo = valorClasif.getDescripcion();
						codigo = valorClasif.getCodigo();
					}
					else
						titulo = "";
					
				}
				
				// Verificar si existe la fila, caso contrario Crearla
				Fila fila = getFila(titulo, subTitulo, codigo);
				if (fila == null) {
					// Obtener la cantidad de Pedidos y OC
					
					if (oidProducto!=null) {
						cantOC = OrdenDeCompraDet.getCantProdOCPendRecep(Producto.findByOidProxy(oidProducto, this.getSesion()), this.getSesion());
						cantPedidos = PedidoDet.getCantProdPedidosPendEnt(Producto.findByOidProxy(oidProducto, this.getSesion()), this.getSesion());
					} else {
						cantOC = 0.0;
						cantPedidos = 0.0;
					}
					
					fila = new Fila(titulo,subTitulo,codigo,cantPedidos,cantOC);
					fila.oidProducto = oidProducto;
					filasConsulta.put(getClave(titulo,subTitulo,codigo), fila);
				}
				fila.addCantDepo(consultaStock.getOid_deposito(),consultaStock.getCantidad());
				
			}
			
			
			
		}
		
		cargarRegistrosConsulta(ds);
		
		
		
	}
	
	private void consultaConUnEstado(ConfConsGenStock confConsGenStock,MapDatos mapaDatos, IDataSet ds) throws BaseException {
		
		List listaDepositos = new ArrayList();
		List listaEstados = new ArrayList();
		
		Iterator iterConfDepo = 
			listaConfDepo.iterator();
		while (iterConfDepo.hasNext()) {
			ConfConsGenStockDepo confConsGenStockDepo = (ConfConsGenStockDepo) iterConfDepo.next();
			listaDepositos.add(confConsGenStockDepo.getDeposito());
		}
		
		Iterator iterConfEst = 
			confConsGenStock.getConfEstados().iterator();
		while (iterConfEst.hasNext()) {
			ConfConsGenStockEst confConsGenStockEst = (ConfConsGenStockEst) iterConfEst.next();
			listaEstados.add(confConsGenStockEst.getEstado_stock());
		}
		
		
		HashTableDatos filtrosClasifPorDesc = new HashTableDatos();
		String filtroPorDescProdStock = null;
		HashTableDatos filtrosClasifPorObj = new HashTableDatos();
		Producto productoFiltro = null; 
		
		// Tomar Filtros
		IDataSet dsBuscarPorDesc = mapaDatos.getDataSet("TBuscarPorDescripcion");
		dsBuscarPorDesc.first();
		while (!dsBuscarPorDesc.EOF()) {
			String descripcion = dsBuscarPorDesc.getString("descripcion");
			if ((descripcion!=null) && (descripcion.length()>0)) {
				if (dsBuscarPorDesc.getString("tipo").equals(ClasificadorEntidad.NICKNAME)) {
					ClasificadorEntidad clasifEnt = ClasificadorEntidad.findByOidProxy(dsBuscarPorDesc.getInteger("oid_clasif_ent"), this.getSesion());
					filtrosClasifPorDesc.put(clasifEnt, descripcion);
				} else if (dsBuscarPorDesc.getString("tipo").equals(Producto.NICKNAME)) 
					filtroPorDescProdStock = descripcion;
			}
			
			dsBuscarPorDesc.next();
		}
		
		IDataSet dsBuscarPorCodigo = mapaDatos.getDataSet("TBuscarPorCodigo");
		dsBuscarPorCodigo.first();
		while (!dsBuscarPorCodigo.EOF()) {

			Integer oidValor = dsBuscarPorCodigo.getInteger("oid_valor");
			if ((oidValor!=null) && (oidValor.intValue()>0)) {
				if (dsBuscarPorCodigo.getString("tipo").equals(ClasificadorEntidad.NICKNAME)) {
					ClasificadorEntidad clasifEnt = ClasificadorEntidad.findByOidProxy(dsBuscarPorCodigo.getInteger("oid_clasif_ent"), this.getSesion());
					filtrosClasifPorObj.put(clasifEnt, oidValor);
				} else if (dsBuscarPorDesc.getString("tipo").equals(Producto.NICKNAME)) 
					productoFiltro = Producto.findByOidProxy(oidValor, this.getSesion());
			}
			
			
			dsBuscarPorCodigo.next();
		}
		
		
		
		// Definir el contenido de la fila
		
		String titulo = "";
		String subTitulo = "";
		String codigo = "";
		Integer oidProducto = null;
		Double cantOC = null;
		Double cantPedidos = null;
		
		Iterator iterConsSaldosStock = 
			ConsultaStock.getConsultaSaldosEstadosStock(
					listaDepositos,
					listaEstados,
					filtrosClasifPorDesc,
					filtroPorDescProdStock,
					filtrosClasifPorObj,
					productoFiltro,
					this.getSesion()).iterator();
		while (iterConsSaldosStock.hasNext()) {
			ConsultaStock consultaStock = (ConsultaStock) iterConsSaldosStock.next();

			titulo = "";
			subTitulo = "";
			codigo = "";

			//confConsGenStock.
			if (confConsGenStock.getTipo_valor_fila().equals("PRODUCTO")) {
				subTitulo = consultaStock.getDesc_producto();
				codigo = consultaStock.getCod_producto();
				if (confConsGenStock.getClasif_ent_grupo()!=null) {
					oidProducto = consultaStock.getOid_producto();
					Producto producto = Producto.findByOidProxy(oidProducto, this.getSesion());
					IValorClasificadorEntidad valorClasif = 
						producto.getValorClasifEnt(confConsGenStock.getClasif_ent_grupo());
					if (valorClasif!=null)
						titulo = valorClasif.getDescripcion();
				}
			} else if (confConsGenStock.getTipo_valor_fila().equals("CLASIFICADOR")) {
				oidProducto = consultaStock.getOid_producto();
				Producto producto = Producto.findByOidProxy(oidProducto, this.getSesion());
				IValorClasificadorEntidad valorClasif = 
					producto.getValorClasifEnt(confConsGenStock.getClasif_ent_fila());
				if (valorClasif!=null) {
					subTitulo = valorClasif.getDescripcion();
					codigo = valorClasif.getCodigo();
				}
				else
					subTitulo = "";
				
				valorClasif = 
					producto.getValorClasifEnt(confConsGenStock.getClasif_ent_grupo());
				if (valorClasif!=null)
					titulo = valorClasif.getDescripcion();
				
				
			}
			
			// Verificar si existe la fila, caso contrario Crearla
			Fila fila = getFila(titulo, subTitulo, codigo);
			if (fila == null) {
				
				if (oidProducto!=null) {
					cantOC = OrdenDeCompraDet.getCantProdOCPendRecep(Producto.findByOidProxy(oidProducto, this.getSesion()), this.getSesion());
					cantPedidos = PedidoDet.getCantProdPedidosPendEnt(Producto.findByOidProxy(oidProducto, this.getSesion()), this.getSesion());
				} else {
					cantOC = 0.0;
					cantPedidos = 0.0;
				}		
				
				fila = new Fila(titulo,subTitulo,codigo,cantPedidos,cantOC);
				fila.oidProducto = oidProducto;
				filasConsulta.put(getClave(titulo,subTitulo,codigo), fila);
			}
			fila.addCantDepo(consultaStock.getOid_deposito(),consultaStock.getCantidad());
			
		}
		
		cargarRegistrosConsulta(ds);
		
		
	}
	
	private void procesarEstructura(MapDatos mapaDatos) throws BaseException {

		ConfConsGenStock confConsGenStock = ConfConsGenStock.findByOid(mapaDatos.getInteger("oid_conf_cons_gen_stock"), this.getSesion());

		IDataSet dsCampos = getDataSetCampos();
		IDataSet dsColGrillas = getDataSetColGrilla();
		IDataSet dsCantDepo = getDataSetCantDepo();

		enviarCampos(dsCampos,dsColGrillas,  confConsGenStock);

		cargaCantDepo(dsCantDepo, confConsGenStock.getCantDepositos() , confConsGenStock.isTotalizar() , confConsGenStock.isVerColTotFila());
		
		writeCliente(dsCampos);
		writeCliente(dsColGrillas);
		writeCliente(dsCantDepo);

	}

	private void enviarCampos(IDataSet dsCampos, IDataSet dsColGrillas,ConfConsGenStock confConsGenStock) throws BaseException {
	
		// Enviar campos de Tablas
		cargaCampoTab(dsCampos, 1, Field.INTEGER, "renglon", 0, true);
		cargaCampoTab(dsCampos, 2, Field.STRING, "titulo", 100, false);
		cargaCampoTab(dsCampos, 3, Field.STRING, "subtitulo", 100, false);
		cargaCampoTab(dsCampos, 4, Field.STRING, "cod_subtitulo", 100, false);
		
		cargaCampoTab(dsCampos, 5, Field.CURRENCY, "cant_oc", 0, false);
		cargaCampoTab(dsCampos, 6, Field.CURRENCY, "cant_pedidos", 0, false);
		cargaCampoTab(dsCampos, 7, Field.CURRENCY, "libre", 0, false);
		cargaCampoTab(dsCampos, 8, Field.INTEGER, "oid_producto", 0, false);
		
		int secu = 8;

		++secu;
		cargaCampoTab(dsCampos, secu, Field.CURRENCY, "total", 0, false);

		++secu;
		cargaCampoTab(dsCampos, secu, Field.STRING, "tipo_titulo", 0, false);

		++secu;
		cargaCampoTab(dsCampos, secu, Field.INTEGER, "oid_valor_titulo", 0, false);

		++secu;
		cargaCampoTab(dsCampos, secu, Field.STRING, "tipo_subtitulo", 0, false);

		++secu;
		cargaCampoTab(dsCampos, secu, Field.INTEGER, "oid_valor_subtit", 0, false);

		Iterator iterConfDepositos = listaConfDepo.iterator();
		while (iterConfDepositos.hasNext()) {
			++secu;
			ConfConsGenStockDepo confConsGenStockDepo = (ConfConsGenStockDepo) iterConfDepositos.next();
			cargaCampoTab(dsCampos, secu, Field.CURRENCY, "depo_" + confConsGenStockDepo.getDeposito().getOIDInteger(), 0, false);
		}
		
		// Enviar Columnas de Grillas
	  	cargaColGrilla(dsColGrillas,
	  			new Integer(1),
	  			Grilla.TIPO_COL_ESTANDAR,
	  			"Título",
	  			"titulo",
	  			new Integer(0),
	  			new Integer(300),
	  			new Boolean(true),
	  			new Boolean(true),
	  			"",
	  			new Boolean(false),
	  			"",
	  			new Boolean(true),
	  			new Integer(0),
	  			"ASC"
	  			);
	  	
	  	cargaColGrilla(dsColGrillas,
	  			new Integer(2),
	  			Grilla.TIPO_COL_ESTANDAR,
	  			"Descripción",
	  			"subtitulo",
	  			new Integer(0),
	  			new Integer(300),
	  			new Boolean(true),
	  			new Boolean(true),
	  			"",
	  			new Boolean(false),
	  			"",
	  			new Boolean(false),
	  			new Integer(0),
	  			"ASC"
	  			);
	  	
	  	cargaColGrilla(dsColGrillas,
	  			new Integer(3),
	  			Grilla.TIPO_COL_ESTANDAR,
	  			"Código",
	  			"cod_subtitulo",
	  			new Integer(0),
	  			new Integer(100),
	  			new Boolean(true),
	  			new Boolean(true),
	  			"",
	  			new Boolean(false),
	  			"",
	  			new Boolean(false),
	  			new Integer(0),
	  			""
	  			);
	  	

	  	secu = 3;
		Iterator iterConfDeposito = listaConfDepo.iterator();
		while (iterConfDeposito.hasNext()) {
			++secu;
			ConfConsGenStockDepo confConsGenStockDepo = (ConfConsGenStockDepo) iterConfDeposito.next();
		  	cargaColGrilla(dsColGrillas,
		  			secu,
		  			Grilla.TIPO_COL_ESTANDAR,
		  			confConsGenStockDepo.getDeposito().getDescripcion(),
		  			"depo_"+confConsGenStockDepo.getDeposito().getOIDInteger(),
		  			new Integer(1),
		  			new Integer(50),
		  			new Boolean(true),
		  			new Boolean(true),
		  			"###,###,###,###.##",
		  			new Boolean(false),
		  			"",
		  			new Boolean(false),
		  			new Integer(0),
		  			""
		  			);
		}
		
		++secu;		
		cargaColGrilla(dsColGrillas,
	  			secu,
	  			Grilla.TIPO_COL_ESTANDAR,
	  			"Stock",
	  			"total",
	  			new Integer(2),
	  			new Integer(50),
	  			new Boolean(true),
	  			new Boolean(true),
	  			"###,###,###,###.##",
	  			new Boolean(false),
	  			"",
	  			new Boolean(false),
	  			new Integer(0),
	  			""
	  			);
		
		++secu;		
		cargaColGrilla(dsColGrillas,
	  			secu,
	  			Grilla.TIPO_COL_ESTANDAR,
	  			"Pedidos",
	  			"cant_pedidos",
	  			new Integer(2),
	  			new Integer(50),
	  			new Boolean(true),
	  			new Boolean(true),
	  			"###,###,###,###.##",
	  			new Boolean(false),
	  			"",
	  			new Boolean(false),
	  			new Integer(0),
	  			""
	  			);
		
		++secu;		
		cargaColGrilla(dsColGrillas,
	  			secu,
	  			Grilla.TIPO_COL_ESTANDAR,
	  			"O.C.",
	  			"cant_oc",
	  			new Integer(2),
	  			new Integer(50),
	  			new Boolean(true),
	  			new Boolean(true),
	  			"###,###,###,###.##",
	  			new Boolean(false),
	  			"",
	  			new Boolean(false),
	  			new Integer(0),
	  			""
	  			);
		
		++secu;		
		cargaColGrilla(dsColGrillas,
	  			secu,
	  			Grilla.TIPO_COL_ESTANDAR,
	  			"Libre",
	  			"libre",
	  			new Integer(2),
	  			new Integer(50),
	  			new Boolean(true),
	  			new Boolean(true),
	  			"###,###,###,###.##",
	  			new Boolean(false),
	  			"",
	  			new Boolean(false),
	  			new Integer(0),
	  			""
	  			);

		
	  	


	}

	private IDataSet getDataSetCampos() {
		IDataSet dataset = new TDataSet();
		dataset.create("TCamposTabla");

		// Aspectos Fisicos
		dataset.fieldDef(new Field("secu", Field.INTEGER, 0));
		dataset.fieldDef(new Field("tipo", Field.STRING, 50));
		dataset.fieldDef(new Field("nombre_fisico", Field.STRING, 50));
		dataset.fieldDef(new Field("longitud", Field.INTEGER, 0));
		dataset.fieldDef(new Field("primaryKey", Field.BOOLEAN, 0));

		return dataset;
	}

	private void cargaCampoTab(IDataSet dataset, Integer secu, String tipo, String nombreFisico, Integer longitud, Boolean primaryKey) {

		dataset.append();
		dataset.fieldValue("secu", secu);
		dataset.fieldValue("tipo", tipo);
		dataset.fieldValue("nombre_fisico", nombreFisico);
		dataset.fieldValue("longitud", longitud);
		dataset.fieldValue("primaryKey", primaryKey);

	}

	private IDataSet getDataSetColGrilla() throws BaseException {
		IDataSet dataset = new TDataSet();
		dataset.create("TColGrilla");

		// Aspectos Fisicos
		dataset.fieldDef(new Field("secu", Field.INTEGER, 0));
		dataset.fieldDef(new Field("tipo_columna", Field.STRING, 50));
		dataset.fieldDef(new Field("titulo", Field.STRING, 50));
		dataset.fieldDef(new Field("field_name", Field.STRING, 50));
		dataset.fieldDef(new Field("band_index", Field.INTEGER, 0));
		dataset.fieldDef(new Field("ancho_col", Field.INTEGER, 0));
		dataset.fieldDef(new Field("read_only", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("can_focus", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("formato", Field.STRING, 50));
		dataset.fieldDef(new Field("evento_help", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("script_help", Field.STRING, 5000));
		dataset.fieldDef(new Field("agrupar", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("nro_agrupador", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nombre_columna", Field.STRING, 50));
		dataset.fieldDef(new Field("sort", Field.STRING, 50));

		return dataset;

	}
	
	private IDataSet getDataSetCantDepo() throws BaseException {
		IDataSet dataset = new TDataSet();
		dataset.create("TCantDepo");
		// Aspectos Fisicos
		dataset.fieldDef(new Field("cantidad", Field.INTEGER, 0));
		dataset.fieldDef(new Field("tot_por_grupo", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("ver_col_tot_fila", Field.BOOLEAN, 0));
		return dataset;

	}
	
	private void cargaCantDepo(IDataSet dataset, 
			Integer cantidad,Boolean totPorGrupo, Boolean verTotColFila) {

		dataset.append();
		dataset.fieldValue("cantidad", cantidad);
		dataset.fieldValue("tot_por_grupo", totPorGrupo);
		dataset.fieldValue("ver_col_tot_fila", verTotColFila);
		
	}
  
	
	
	
	private IDataSet getDataSetConsulta(ConfConsGenStock confConsGenStock) throws BaseException {
		IDataSet dataset = new TDataSet();
		dataset.create("TConsulta");

		// Aspectos Fisicos
		dataset.fieldDef(new Field("oid_producto", Field.INTEGER, 0));
		dataset.fieldDef(new Field("titulo", Field.STRING, 100));
		dataset.fieldDef(new Field("subtitulo", Field.STRING, 100));
		dataset.fieldDef(new Field("cod_subtitulo", Field.STRING, 100));
		dataset.fieldDef(new Field("cant_oc", Field.DOUBLE, 0));
		dataset.fieldDef(new Field("cant_pedidos", Field.DOUBLE, 0));
		dataset.fieldDef(new Field("libre", Field.DOUBLE, 0));
		
		Iterator iterConfDepositos = listaConfDepo.iterator();
		while (iterConfDepositos.hasNext()) {
			ConfConsGenStockDepo confConsGenStockDepo = (ConfConsGenStockDepo) iterConfDepositos.next();
			dataset.fieldDef(new Field("depo_"+confConsGenStockDepo.getDeposito().getOIDInteger(), Field.CURRENCY, 0));
		}
		dataset.fieldDef(new Field("total", Field.CURRENCY, 0));
		return dataset;

	}
	
	private void cargarRegistrosConsulta(IDataSet ds) throws BaseException {
		Iterator iterFilas = 
			filasConsulta.values().iterator();
		while (iterFilas.hasNext()) {
			Fila fila = (Fila) iterFilas.next();
			
			ds.append();
			ds.fieldValue("oid_producto", fila.oidProducto);
			ds.fieldValue("titulo", fila.titulo);
			ds.fieldValue("subtitulo", fila.subTitulo);
			ds.fieldValue("cod_subtitulo", fila.codigo);
			
			ds.fieldValue("cant_oc", fila.getCantOC());
			ds.fieldValue("cant_pedidos", fila.getCantPedidos());
			ds.fieldValue("libre", fila.getLibre());
			

			Iterator iterConfDepositos = listaConfDepo.iterator();
			while (iterConfDepositos.hasNext()) {
				ConfConsGenStockDepo confConsGenStockDepo = (ConfConsGenStockDepo) iterConfDepositos.next();
				ds.fieldValue("depo_"+confConsGenStockDepo.getDeposito().getOIDInteger(), fila.getSaldoDepo(confConsGenStockDepo.getDeposito().getOIDInteger()));
			}
			
			ds.fieldValue("total", fila.total.getResult());
			
			
		}
	}
	
	
	private void cargaColGrilla(IDataSet dataset, 
			Integer secu, 
			String tipoColumna, 
			String titulo, 
			String fieldName,
			Integer bandIndex, 
			Integer anchoCol, 
			Boolean readonly, 
			Boolean canFocus, 
			String formato, 
			Boolean eventoHelp,
			String scriptHelp, 
			Boolean agrupar, 
			Integer nroAgrupador,
			String sort) {

		dataset.append();
		dataset.fieldValue("secu", secu);
		dataset.fieldValue("tipo_columna", tipoColumna);
		dataset.fieldValue("titulo", titulo);
		dataset.fieldValue("field_name", fieldName);
		dataset.fieldValue("band_index", bandIndex);
		dataset.fieldValue("ancho_col", anchoCol);
		dataset.fieldValue("read_only", readonly);
		dataset.fieldValue("can_focus", canFocus);
		dataset.fieldValue("formato", formato);
		dataset.fieldValue("evento_help", eventoHelp);
		dataset.fieldValue("script_help", scriptHelp);
		dataset.fieldValue("agrupar", agrupar);
		dataset.fieldValue("nro_agrupador", nroAgrupador);
		dataset.fieldValue("nombre_columna", fieldName);
		dataset.fieldValue("sort", sort);
		
	}
  
	

}
