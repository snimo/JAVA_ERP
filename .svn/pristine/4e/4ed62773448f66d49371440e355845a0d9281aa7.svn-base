package com.srn.erp.stock.op;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.general.bm.Cotizacion;
import com.srn.erp.general.bm.IValorClasificadorEntidad;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.general.bm.Precio;
import com.srn.erp.general.bm.TipoCambio;
import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.stock.bm.CostoProductoGral;
import com.srn.erp.stock.bm.Deposito;
import com.srn.erp.stock.bm.EstadoStock;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.bm.SaldoStkProdPorEstado;
import com.srn.erp.ventas.bm.ListaPrecios;
import com.srn.erp.ventas.bm.PrecioEnLP;

import framework.applicarionServer.bm.Varios.CalculadorMoney;
import framework.applicarionServer.bm.Varios.Money;
import framework.applicarionServer.bm.Varios.ValorCotizacion;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerEstrucFactTableValStk extends Operation {

	TipoCambio tipoCambio = null;
	HashTableDatos cotizaciones = null;
	
  public TraerEstrucFactTableValStk() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
  	
  	if (mapaDatos.containsKey("TRAER_ESTRUCTURA"))
  		enviarEstructura(mapaDatos);
  	else if (mapaDatos.containsKey("LLENAR_DIMENSIONES"))
			enviarDatosDimensiones(mapaDatos);  	
  	else if (mapaDatos.containsKey("LLENAR_FACT_TABLE"))
  						enviarDatosFactTable(mapaDatos);
  	
  	
  }
  
  private void enviarConsultaCubo(MapDatos mapaDatos) throws BaseException {

  	IDataSet dsDepositos = mapaDatos.getDataSet("TSelDepositos");
  	IDataSet dsEstadosStock = mapaDatos.getDataSet("TSelEstadosStock");
  	IDataSet dsSelClasifArt = mapaDatos.getDataSet("TSelClasifArt");
  	
  	java.util.Date fecha = mapaDatos.getDate("fecha");
  	Moneda moneda = (Moneda) Moneda.findByOid(mapaDatos.getInteger("oid_moneda"),this.getSesion());
  	String formaValorizacion = (String) mapaDatos.getString("forma_valorizacion");
  	
  	ListaPrecios lp = null;
  	if ((mapaDatos.getInteger("oid_lp")!=null) && (mapaDatos.getInteger("oid_lp").intValue()>0))
  	   lp = ListaPrecios.findByOid(mapaDatos.getInteger("oid_lp"),this.getSesion());
  	
  	IDataSet dsFactTable = getDataSetFactTable(dsSelClasifArt);
  	
  	
  	// Armar Lista de Depositos
  	List listaDepositos = new ArrayList();
  	dsDepositos.first();
  	while (!dsDepositos.EOF()) {
  		Deposito deposito = Deposito.findByOidProxy(dsDepositos.getInteger("oid_deposito"),this.getSesion());
  		listaDepositos.add(deposito);
  		dsDepositos.next();
  	}
  	
  	// Armar Lista de Estados
  	List listaEstados = new ArrayList();
  	dsEstadosStock.first();
  	while (!dsEstadosStock.EOF()) {
  		EstadoStock estadoStock = EstadoStock.findByOidProxy(dsEstadosStock.getInteger("oid_estado"),this.getSesion());
  		listaEstados.add(estadoStock);
  		dsEstadosStock.next();
  	}
  	
  	Iterator iterSaldosPorEstado = 
  		(Iterator)SaldoStkProdPorEstado.getSaldosPorEstados(listaDepositos,listaEstados,this.getSesion()).iterator();
  	while (iterSaldosPorEstado.hasNext()) {
  		SaldoStkProdPorEstado saldoStock = (SaldoStkProdPorEstado) iterSaldosPorEstado.next();
  		cargarValorizacion(
  				dsFactTable,
  				saldoStock,
  				dsSelClasifArt,
  				fecha,
  				moneda,
  				formaValorizacion,
  				lp);
  	}
  	
  	
  	writeCliente(dsFactTable);
  	  	  
  }
  
  	private void enviarDatosDimensiones(MapDatos mapaDatos) throws BaseException {
	  	
	  	IDataSet dsSelClasifArt = mapaDatos.getDataSet("TSelClasifArt");
	  	enviarDimensionDepositos();
	  	enviarDimensionEstadosStock();  	
	  	enviarDimensiones(dsSelClasifArt);
	  	
	}
  
  
  
  
  private void enviarDatosFactTable(MapDatos mapaDatos) throws BaseException {
  	
  	String tipoConsulta = (String) mapaDatos.getString("tipo_consulta");
  	
  	if (tipoConsulta.equals("CUBO"))
  		enviarConsultaCubo(mapaDatos);
  	
  	
  }
  
  private void enviarDimensiones(IDataSet dsDimensiones) throws BaseException {
  	
  	dsDimensiones.first();
  	while (!dsDimensiones.EOF()) {
      enviarDimensionClasificador(dsDimensiones.getInteger("oid_clasificador"));
  		dsDimensiones.next(); 
  	}  	
  	
  }
  
  private void enviarDimensionClasificador(Integer oidClasificador) throws BaseException {
  	  	
  	ClasificadorEntidad clasifEntidad = ClasificadorEntidad.findByOid(oidClasificador,this.getSesion());
  	IDataSet ds = this.getDataSetClasificador(clasifEntidad);
  	Iterator iterValClasif = 
  		clasifEntidad.getValoresClasificador().iterator();
  	while (iterValClasif.hasNext()) {
  		ValorClasificadorEntidad valClasifEnt = (ValorClasificadorEntidad) iterValClasif.next();
  		cargarValClasif(ds,valClasifEnt);
  	}
  	writeCliente(ds);
  	
  }
  
  
  private void enviarDimensionEstadosStock() throws BaseException {
  	IDataSet ds = this.getDataSetEstadosStock();
  	Iterator iterEstadosStock = 
  		EstadoStock.getAll(this.getSesion()).iterator();
  	while (iterEstadosStock.hasNext()) {
  		EstadoStock estadoStock = (EstadoStock) iterEstadosStock.next();
  		cargarRegistroEstadoStock(ds,estadoStock);
  	}
  	writeCliente(ds);
  }
  
  
  private void enviarDimensionDepositos() throws BaseException {
  	IDataSet ds = this.getDataSetDepositos();
  	Iterator iterDepositos = 
  		Deposito.getDepositos(this.getSesion()).iterator();
  	while (iterDepositos.hasNext()) {
  		Deposito deposito = (Deposito) iterDepositos.next();
  		cargarRegistroDeposito(ds,deposito);
  	}
  	writeCliente(ds);
  }
  
  
  
  
  private Money getImpoMonedaConsulta(
		  String formaValorizacion,
		  Producto producto,
  		  ListaPrecios listaPrecio,
  		  Date fecha,
  		  Moneda moneda,
  		  Money cantidad) throws BaseException {
  	
	Money valorUnitario         = new Money(0);
	Moneda monedaValorUnitario  = null; 

	if (formaValorizacion.equals("LP")) {
		PrecioEnLP precioEnLP = producto.getPrecioListaSinIVA(listaPrecio,null,fecha);
		if (precioEnLP==null) return new Money(0);
		valorUnitario = precioEnLP.getPrecioUnitario();
		monedaValorUnitario = precioEnLP.getMoneda();
	} else
		if (formaValorizacion.equals("CP")) {
			if (producto.getValorClasifProdGen()==null) return new Money(0); 
			CostoProductoGral costo =
				producto.getValorClasifProdGen().getCostoVigenteAFecha(fecha);
			if (costo == null) return new Money(0);
			valorUnitario = costo.getCostoUnidario();
			monedaValorUnitario = costo.getMoneda();
		}
		else
			if (formaValorizacion.equals("PC")) {
				Precio precio = producto.getPrecioCompra(null, fecha);
				if (precio==null) return new Money(0); 
				valorUnitario = precio.getImporte();
				monedaValorUnitario = precio.getMoneda();
			}
			
  	
	if ((valorUnitario == null) || (monedaValorUnitario == null))
		return new Money(0);
	
  	CalculadorMoney calcImpoMonOri = new CalculadorMoney(valorUnitario); 
  	calcImpoMonOri.multiplicarPor(cantidad);
  	
  	ValorCotizacion valorCotizacion = (ValorCotizacion) cotizaciones.get(monedaValorUnitario.getOIDInteger());
  	if (valorCotizacion == null)
  		throw new ExceptionValidation(null,
  				"No se pudo encontrar cotización para la moneda "+
  				monedaValorUnitario.getDescripcion()+
  				" en la fecha ingresada");
  	
  	ValorCotizacion valorCotizacionDest = (ValorCotizacion) cotizaciones.get(moneda.getOIDInteger());
  	if (valorCotizacionDest == null)
  		throw new ExceptionValidation(null,
  				"No se pudo encontrar cotización para la moneda "+
  				moneda.getDescripcion()+
  				" en la fecha ingresada");  	
  	
  	return Cotizacion.convertir(calcImpoMonOri.getResultMoney(),valorCotizacion,valorCotizacionDest);
  	
  	
  	
  }
  
  private void cargarValorizacion(IDataSet dsFactTable,
  		                          SaldoStkProdPorEstado saldo,
  		                          IDataSet dsClasificadores,
  		                          java.util.Date fecha,
  		                          Moneda moneda,
  		                          String formaValorizacion,
  		                          ListaPrecios lp) throws BaseException {

  	if (saldo.getSaldo().doubleValue()<=0) return;
  	
  	dsFactTable.append();
  	dsFactTable.fieldValue("oid_producto", saldo.getProducto().getOIDInteger());
  	dsFactTable.fieldValue("cod_producto", saldo.getProducto().getCodigo());
  	dsFactTable.fieldValue("desc_producto", saldo.getProducto().getDescripcion());
  	dsFactTable.fieldValue("cantidad", saldo.getSaldo());
  	
  	Money valorizado = 
  		getImpoMonedaConsulta(formaValorizacion,saldo.getProducto(),lp , fecha , moneda , new Money(saldo.getSaldo().doubleValue()));
  	
  	dsFactTable.fieldValue("valorizado", valorizado.doubleValue(2));
  	dsFactTable.fieldValue("oid_depo", saldo.getDeposito().getOIDInteger());
  	dsFactTable.fieldValue("oid_estado", saldo.getEstado_stock().getOIDInteger());
    
  	dsClasificadores.first();
    while (!dsClasificadores.EOF()) {
    	ClasificadorEntidad clasif = 
    		ClasificadorEntidad.findByOidProxy(dsClasificadores.getInteger("oid_clasificador"),this.getSesion()); 
    	IValorClasificadorEntidad valorClasif = 
    		saldo.getProducto().getValorClasifEnt(clasif);
    	if (valorClasif!=null)
    		dsFactTable.fieldValue("oid_clasif_"+clasif.getOIDInteger(), valorClasif.getOID());
    	else
    		dsFactTable.fieldValue("oid_clasif_"+clasif.getOIDInteger(), 0);
    	dsClasificadores.next();
    }
  	
  	
  }
  
  private void enviarEstructura(MapDatos mapaDatos) throws BaseException {
  	
  	int secu = 0;
  	IDataSet ds = getDataSetCamposEstrucFactTable();
  	
  	++secu;
    cargarRegistroFactTable(ds,
        new Integer(secu),
        Field.INTEGER,
        "oid_producto",
        new Integer(0),
        new Boolean(false));

  	
    ++secu;
    cargarRegistroFactTable(ds,
          new Integer(secu),
          Field.STRING,
          "cod_producto",
          new Integer(50),
          new Boolean(false));
    	
  	++secu;
    cargarRegistroFactTable(ds,
          new Integer(secu),
          Field.STRING,
          "desc_producto",
          new Integer(255),
          new Boolean(false));
    
  	++secu;
    cargarRegistroFactTable(ds,
          new Integer(secu),
          Field.INTEGER,
          "oid_depo",
          new Integer(0),
          new Boolean(false));
    
    ++secu;
    cargarRegistroFactTable(ds,
          new Integer(secu),
          Field.INTEGER,
          "oid_estado",
          new Integer(0),
          new Boolean(false));
    	
  	// Tratar clasificadores de Articulos
  	IDataSet dsDimenClasifArt = mapaDatos.getDataSet("TSelClasifArt");
  	dsDimenClasifArt.first();
  	while (!dsDimenClasifArt.EOF()) {
  		++secu;
  		tratarClasificador(ds,secu,dsDimenClasifArt.getInteger("oid_clasificador"));
  		dsDimenClasifArt.next();
  	}

  	++secu;
    cargarRegistroFactTable(ds,
        new Integer(secu),
        Field.DOUBLE,
        "cantidad",
        new Integer(0),
        new Boolean(false));

  	++secu;
    cargarRegistroFactTable(ds,
        new Integer(secu),
        Field.CURRENCY,
        "valorizado",
        new Integer(0),
        new Boolean(false));
  	
  	
  	writeCliente(ds);
  	
  	
  }

  private IDataSet getDataSetFactTable(IDataSet dsDimensiones) throws BaseException {
    IDataSet dataset = new TDataSet();
    dataset.create("TFactTable");
    
    dataset.fieldDef(new Field("oid_producto", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_producto", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_producto", Field.STRING, 255));
    dataset.fieldDef(new Field("cantidad", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("valorizado", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("oid_depo", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_estado", Field.INTEGER, 0));
    
    dsDimensiones.first();
    while (!dsDimensiones.EOF()) {
  		dataset.fieldDef(new Field("oid_clasif_"+dsDimensiones.getInteger("oid_clasificador"), Field.INTEGER, 0));
    	dsDimensiones.next();
    }
    
    return dataset;
  }

  
  private void tratarClasificador(IDataSet ds,int secu,Integer oidClasificador) {
  	
  	cargarRegistroFactTable(ds,
  			                   new Integer(secu),
  			                   Field.INTEGER,
  			                   "oid_clasif_"+oidClasificador.toString(),
  			                   new Integer(0),
  			                   new Boolean(false));
  			
  }

  private IDataSet getDataSetCamposEstrucFactTable() {
    IDataSet dataset = new TDataSet();
    dataset.create("TCamposFactTable");
    
    // Aspectos Fisicos
    dataset.fieldDef(new Field("secu", Field.INTEGER, 0));
    dataset.fieldDef(new Field("tipo", Field.STRING, 50));
    dataset.fieldDef(new Field("nombre_fisico", Field.STRING, 50));
    dataset.fieldDef(new Field("longitud", Field.INTEGER, 0));
    dataset.fieldDef(new Field("primaryKey", Field.BOOLEAN, 0));
    
    return dataset;
  }
  
  private IDataSet getDataSetDepositos() {
    IDataSet dataset = new TDataSet();
    dataset.create("TDepositos");
    
    // Aspectos Fisicos
    dataset.fieldDef(new Field("oid_deposito", Field.INTEGER, 0));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
    
    return dataset;
  }
  
  private IDataSet getDataSetEstadosStock() {
    IDataSet dataset = new TDataSet();
    dataset.create("TEstadosStock");
    
    // Aspectos Fisicos
    dataset.fieldDef(new Field("oid_estado", Field.INTEGER, 0));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
    
    return dataset;
  }
  
  
  private IDataSet getDataSetClasificador(ClasificadorEntidad clasifEnt) {
  	
    IDataSet dataset = new TDataSet();
    dataset.create("TClasif_"+clasifEnt.getOIDInteger());
    
    // Aspectos Fisicos
    dataset.fieldDef(new Field("oid_clasif", Field.INTEGER, 0));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 200));
    
    return dataset;
  }
  
  private void cargarValClasif(IDataSet ds,ValorClasificadorEntidad valorClasif) throws BaseException {
    ds.append();
    ds.fieldValue("oid_val_clasif", valorClasif.getOIDInteger());
    ds.fieldValue("desc_val_clasif", valorClasif.getDescripcion());
  }
  
  
  
  private void cargarRegistroEstadoStock(IDataSet ds,EstadoStock estadoStock) throws BaseException {
    ds.append();
    ds.fieldValue("oid_estado", estadoStock.getOIDInteger());
    ds.fieldValue("descripcion", estadoStock.getDescripcion());
  }
  
  private void cargarRegistroDeposito(IDataSet ds,Deposito deposito) throws BaseException {
    ds.append();
    ds.fieldValue("oid_deposito", deposito.getOIDInteger());
    ds.fieldValue("descripcion", deposito.getDescripcion());
  }
  
  
  private void cargarRegistroFactTable(IDataSet dataset,
  																 		 Integer secu,
  																 		 String tipo,
  																 		 String nombreFisico,
  																 		 Integer longitud,
  																 		 Boolean primaryKey) {
    dataset.append();
    dataset.fieldValue("secu", secu);
    dataset.fieldValue("tipo", tipo);
    dataset.fieldValue("nombre_fisico", nombreFisico);
    dataset.fieldValue("longitud", longitud);
    dataset.fieldValue("primaryKey", primaryKey);
    
  }

	public void beforeExecute(MapDatos mapaDatos) throws BaseException {
		// TODO Auto-generated method stub
		super.beforeExecute(mapaDatos);
		
		tipoCambio = TipoCambio.getTipoCambioValorizStock(this.getSesion());
		if (mapaDatos.containsKey("fecha")) {
			cotizaciones = Cotizacion.getListaCotizacionesPorOidMoneda(mapaDatos.getDate("fecha"),tipoCambio,this.getSesion());
		}

	}
  
  
}
