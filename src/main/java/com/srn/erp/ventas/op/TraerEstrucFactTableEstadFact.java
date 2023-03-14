package com.srn.erp.ventas.op;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.general.bm.Cotizacion;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.general.bm.TipoCambio;
import com.srn.erp.general.bm.TipoComprobante;
import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.ventas.bm.CondicionPago;
import com.srn.erp.ventas.bm.EstadisticaFacturas;
import com.srn.erp.ventas.bm.Sujeto;
import com.srn.erp.ventas.bm.Vendedor;

import framework.applicarionServer.bl.Utils.Fecha;
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

public class TraerEstrucFactTableEstadFact extends Operation {

  HashTableDatos fechas = new HashTableDatos();

  public TraerEstrucFactTableEstadFact() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
  	
  	if (mapaDatos.containsKey("TRAER_ESTRUCTURA"))
  		enviarEstructura(mapaDatos);
  	else if (mapaDatos.containsKey("LLENAR_FACT_TABLE"))
  						enviarDatosFactTable(mapaDatos);
  	else if (mapaDatos.containsKey("LLENAR_DIMENSION"))
			enviarDatosDimension(mapaDatos);
  	
  	
  }
  
  private List getListaClasif(IDataSet ds) throws BaseException {
  	List clasificadores = new ArrayList(); 
  	ds.first();
  	while (!ds.EOF()) {
  		
  		if (ds.getBoolean("seleccionado").booleanValue()==false) {
  			ds.next();
  			continue;
  		}
  		
  		if (!(ds.getString("identificador").equals(ClasificadorEntidad.NICKNAME))) {
  			ds.next();
  			continue;
  		}
  		
  		ClasificadorEntidad clasif = 
  			ClasificadorEntidad.findByOidProxy(ds.getInteger("oid_clasificador"),
  																				 this.getSesion());
  		
  		clasificadores.add(clasif);
  		
  		ds.next();
  	}
  	return clasificadores;
  }
  
  private void enviarDatosFactTable(MapDatos mapaDatos) throws BaseException {
  	
  	IDataSet dsDimensiones = mapaDatos.getDataSet("TDimensiones");
  	IDataSet dsFactTable = getDataSetFactTable(dsDimensiones);
  	Moneda moneda = Moneda.findByOidProxy(mapaDatos.getInteger("oid_moneda"), this.getSesion());
  	
  	
  	TipoCambio tipoCambio = 
  		TipoCambio.getTipoCambioVentaMostrador(this.getSesion());
  	 
  	Iterator  iterEstadFacturas = EstadisticaFacturas.getEstadisticaFacturas(
  			mapaDatos.getDate("fec_desde"),
  			mapaDatos.getDate("fec_hasta"),
  			getListaClasif(dsDimensiones),
  			this.getSesion()).iterator();
  	while (iterEstadFacturas.hasNext()) {
  		EstadisticaFacturas estadisticaFactura = (EstadisticaFacturas) iterEstadFacturas.next();
  		cargarEstadFact(dsFactTable,dsDimensiones,estadisticaFactura,moneda,tipoCambio);
  	}
  	
  	
  	
  	writeCliente(dsFactTable);
  	
  	
  }
  
  private double getImpoEnMoneda(
		  java.util.Date fecha,
		  double importe,
		  Integer oidMonOri,
		  double cotizacion,
		  Integer oidMonDest,
		  TipoCambio tipoCambio) throws BaseException {
	if (oidMonOri.intValue() == oidMonDest.intValue())
		return importe;
	
	// Llevar a Pesos a la Fecha de origen del movimiento
	Money impoEnMonLocal =
		Cotizacion.getImporteMonedaLocal(new ValorCotizacion(cotizacion), new Money(importe));
	
	// Obtener la cotizaciones de la Moneda destino a la fecha del movimiento original
	Moneda monedaDest = Moneda.findByOidProxy(oidMonDest, this.getSesion());
	
	ValorCotizacion valCotizDest = null;
	valCotizDest = (ValorCotizacion)fechas.get(fecha.toString());
	
	if (valCotizDest == null) {
		valCotizDest =
			Cotizacion.getCotizacion(fecha, tipoCambio, monedaDest, this.getSesion());
		if (valCotizDest!=null)
			fechas.put(fecha.toString(), valCotizDest);
	}
	
	if (valCotizDest == null)
		throw new ExceptionValidation(null,"No se pudo encontra la cotización para la moneda "+monedaDest.getDescripcion()+" a la fecha "+Fecha.getddmmyyyy(fecha));

	CalculadorMoney calcPrecio = new CalculadorMoney(impoEnMonLocal);
	calcPrecio.dividirPor(valCotizDest);
	
	return calcPrecio.getResult();  
	
  }
  
  private void enviarDatosDimension(MapDatos mapaDatos) throws BaseException {
	  	
	  	IDataSet dsDimensiones = mapaDatos.getDataSet("TDimensiones");
	  	enviarDimensiones(dsDimensiones);
	  	
	  }
  
  
  private void enviarDimensiones(IDataSet dsDimensiones) throws BaseException {
  	dsDimensiones.first();
  	while (!dsDimensiones.EOF()) {
  		
  		if (dsDimensiones.getBoolean("seleccionado").booleanValue()==false) {
  			dsDimensiones.next();
  			continue;
  		}
  		
  		if (dsDimensiones.getString("identificador").equals("FECHA_MES"))
  			enviarDimensionMes();
  		else
  			if (dsDimensiones.getString("identificador").equals(Vendedor.NICKNAME))
  				enviarDimensionVendedores();
    		else
    			if (dsDimensiones.getString("identificador").equals(TipoComprobante.NICKNAME))
    				enviarDimensionTipoComprobante();
      		else
      			if (dsDimensiones.getString("identificador").equals(CondicionPago.NICKNAME))
      				enviarDimensionCondPago();
        		else
        			if (dsDimensiones.getString("identificador").equals(ClasificadorEntidad.NICKNAME))
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
  
  private void enviarDimensionTipoComprobante() throws BaseException {
  	IDataSet ds = this.getDataSetTipoComprobante();
  	Iterator iterTipoCompro = 
  		TipoComprobante.getAllTiposComprobantes(this.getSesion()).iterator();
  	while (iterTipoCompro.hasNext()) {
  		TipoComprobante tipoCompro = (TipoComprobante) iterTipoCompro.next();
  		cargarRegistroTipoComprobante(ds,tipoCompro);
  	}
  	writeCliente(ds);
  }
  
  private void enviarDimensionCondPago() throws BaseException {
  	IDataSet ds = this.getDataSetCondPago();
  	Iterator iterCondPago = 
  		CondicionPago.getCondicionesDePago(this.getSesion()).iterator();
  	while (iterCondPago.hasNext()) {
  		CondicionPago condPago = (CondicionPago) iterCondPago.next();
  		cargarRegistroCondPago(ds,condPago);
  	}
  	writeCliente(ds);
  }
  
  private void enviarDimensionVendedores() throws BaseException {
  	IDataSet dsVendedores = this.getDataSetVendedores();
  	Iterator iterVendedores = Vendedor.getAllVendedores(this.getSesion()).iterator();
  	while (iterVendedores.hasNext()) {
  		Vendedor vendedor = (Vendedor) iterVendedores.next();
  		cargarRegistroVendedor(dsVendedores,vendedor);
  	}
  	writeCliente(dsVendedores);
  }
  
  private void enviarDimensionMes() {
  	IDataSet dsMeses = this.getDataSetMeses();
  	
  	dsMeses.append();
  	dsMeses.fieldValue("nro_mes",1);
  	dsMeses.fieldValue("descripcion","01-Enero");
  	
  	dsMeses.append();
  	dsMeses.fieldValue("nro_mes",2);
  	dsMeses.fieldValue("descripcion","02-Febrero");
  	
  	dsMeses.append();
  	dsMeses.fieldValue("nro_mes",3);
  	dsMeses.fieldValue("descripcion","03-Marzo");
  	
  	dsMeses.append();
  	dsMeses.fieldValue("nro_mes",4);
  	dsMeses.fieldValue("descripcion","04-Abril");
  	
  	dsMeses.append();
  	dsMeses.fieldValue("nro_mes",5);
  	dsMeses.fieldValue("descripcion","05-Mayo");
  	
  	dsMeses.append();
  	dsMeses.fieldValue("nro_mes",6);
  	dsMeses.fieldValue("descripcion","06-Junio");
  	
  	dsMeses.append();
  	dsMeses.fieldValue("nro_mes",7);
  	dsMeses.fieldValue("descripcion","07-Julio");
  	
  	dsMeses.append();
  	dsMeses.fieldValue("nro_mes",8);
  	dsMeses.fieldValue("descripcion","08-Agosto");
  	
  	dsMeses.append();
  	dsMeses.fieldValue("nro_mes",9);
  	dsMeses.fieldValue("descripcion","09-Septiembre");
  	
  	dsMeses.append();
  	dsMeses.fieldValue("nro_mes",10);
  	dsMeses.fieldValue("descripcion","10-Octubre");

  	dsMeses.append();
  	dsMeses.fieldValue("nro_mes",11);
  	dsMeses.fieldValue("descripcion","11-Noviembre");
  	
  	dsMeses.append();
  	dsMeses.fieldValue("nro_mes",12);
  	dsMeses.fieldValue("descripcion","12-Diciembre");
  	
  	
  	writeCliente(dsMeses);
  }
  
  private void cargarEstadFact(IDataSet dsFactTable,
  		                        IDataSet dsDimensiones,
  		                        EstadisticaFacturas estad,
  		                        Moneda moneda,
  		                        TipoCambio tipoCambio) throws BaseException {

  	dsFactTable.append();
  	dsDimensiones.first();
  	while (!dsDimensiones.EOF()) {
  		
  		if ((dsDimensiones.getBoolean("seleccionado")==null) || (dsDimensiones.getBoolean("seleccionado").booleanValue()==false)) {
  			  dsDimensiones.next();
  			  continue;
  		}
  		
  		if (dsDimensiones.getString("identificador").equals(ClasificadorEntidad.NICKNAME))
  				dsFactTable.fieldValue("oid_clasif_"+dsDimensiones.getString("oid_clasificador"),
  						estad.getOidValorClasif(dsDimensiones.getInteger("oid_clasificador")));
  			else
  				if (dsDimensiones.getString("identificador").equals("FECHA_ANEO"))
  					dsFactTable.fieldValue("aneo",Fecha.getAnio(estad.getEmision()));
  				else
    				if (dsDimensiones.getString("identificador").equals("FECHA_MES"))
    					dsFactTable.fieldValue("mes",Fecha.getMes(estad.getEmision()));
    				else
      				if (dsDimensiones.getString("identificador").equals("FECHA_DIA"))
      					dsFactTable.fieldValue("fecha",estad.getEmision());
      				else
        				if (dsDimensiones.getString("identificador").equals(TipoComprobante.NICKNAME))
        					dsFactTable.fieldValue("oid_tc",estad.getOid_tc());
        				else
          				if (dsDimensiones.getString("identificador").equals(Vendedor.NICKNAME))
          					dsFactTable.fieldValue("oid_vendedor",estad.getOid_vendedor());
          				else
            				if (dsDimensiones.getString("identificador").equals(CondicionPago.NICKNAME))
            					dsFactTable.fieldValue("oid_cond_pago",estad.getOid_cond_pago());
            				else
              				if (dsDimensiones.getString("identificador").equals(ComproCab.NICKNAME)) {
              					 dsFactTable.fieldValue("oid_cco",estad.getOid_cco());
              					 dsFactTable.fieldValue("comprobante",estad.getComprobante());
              				}
              				else
                				if (dsDimensiones.getString("identificador").equals(Producto.NICKNAME))
                					dsFactTable.fieldValue("sku",estad.getDescProductoyCodigo());
                				else
                  				if (dsDimensiones.getString("identificador").equals(Sujeto.NICKNAME))
                  					dsFactTable.fieldValue("cliente",estad.getNombreClienteyCodigo());
                  				else
                    				if (dsDimensiones.getString("identificador").equals("LETRA"))
                    					dsFactTable.fieldValue("letra",estad.getLetra());
  		
  						
  		
  		dsDimensiones.next();
  	}
  	
  	dsFactTable.fieldValue("cantidad",estad.getCant()*estad.getSigno());
  	
  	
  	
  	dsFactTable.fieldValue("importe",getImpoEnMoneda(
  			estad.getEmision(),
  			estad.getPrecio()*estad.getSigno(), 
  			estad.getOid_moneda(),
  			estad.getCotizacion(),
  			moneda.getOIDInteger(),
  			tipoCambio));
  	
  }
  
  private void enviarEstructura(MapDatos mapaDatos) throws BaseException {
  	
  	IDataSet ds = getDataSetCamposEstrucFactTable();
  	
  	IDataSet dsDimensiones = mapaDatos.getDataSet("TDimensiones");
  	
  	int secu = 0;
  	dsDimensiones.first();
  	while (!dsDimensiones.EOF()) {
  		if (dsDimensiones.getBoolean("seleccionado").booleanValue()) {
  			++secu;
  			if (dsDimensiones.getString("identificador").equals(ClasificadorEntidad.NICKNAME))
  				tratarClasificador(ds,secu,dsDimensiones.getInteger("oid_clasificador"));
  			else
  				if (dsDimensiones.getString("identificador").equals("FECHA_ANEO"))
  					tratarAneo(ds,secu);
  				else
    				if (dsDimensiones.getString("identificador").equals("FECHA_MES"))
    					tratarMes(ds,secu);
    				else
      				if (dsDimensiones.getString("identificador").equals("FECHA_DIA"))
      					tratarDia(ds,secu);
      				else
        				if (dsDimensiones.getString("identificador").equals(TipoComprobante.NICKNAME))
        					tratarTipoComprobante(ds,secu);
        				else
          				if (dsDimensiones.getString("identificador").equals(Vendedor.NICKNAME))
          					tratarVendedor(ds,secu);
          				else
            				if (dsDimensiones.getString("identificador").equals(CondicionPago.NICKNAME))
            					tratarFormaPago(ds,secu);
            				else
              				if (dsDimensiones.getString("identificador").equals(ComproCab.NICKNAME)) 
              					tratarComprobante(ds,secu);
                				else
                  				if (dsDimensiones.getString("identificador").equals(Producto.NICKNAME)) 
                  					tratarSKU(ds,secu);
                    				else
                      				if (dsDimensiones.getString("identificador").equals(Sujeto.NICKNAME)) 
                      					tratarCliente(ds,secu);
                      				else
                        				if (dsDimensiones.getString("identificador").equals("LETRA")) 
                        					tratarLetra(ds,secu);

              					
  		}
  		dsDimensiones.next();
  	}
  	
  	++secu;
  	tratarMetricaFloat(ds,secu,"cantidad");
  	
  	++secu;
  	tratarMetricaCurrency(ds,secu,"importe");
  	
  	writeCliente(ds);
  	
  	
  }

  private void tratarMetricaCurrency(IDataSet ds,int secu, String nombreMetrica) {

  	cargarRegistroFactTable(ds,
        new Integer(secu),
        Field.CURRENCY,
        nombreMetrica,
        new Integer(50),
        new Boolean(false));
  	
  }
  
  private void tratarMetricaFloat(IDataSet ds,int secu, String nombreMetrica) {

	  	cargarRegistroFactTable(ds,
	        new Integer(secu),
	        Field.DOUBLE,
	        nombreMetrica,
	        new Integer(50),
	        new Boolean(false));
	  	
	  }
  
  
  
  private void tratarComprobante(IDataSet ds,int secu) {

  	cargarRegistroFactTable(ds,
        new Integer(secu),
        Field.INTEGER,
        "oid_cco",
        new Integer(0),
        new Boolean(false));
  	
  	cargarRegistroFactTable(ds,
        new Integer(secu),
        Field.STRING,
        "comprobante",
        new Integer(50),
        new Boolean(false));
  	
  	
  }
  
  private void tratarSKU(IDataSet ds,int secu) {

  	cargarRegistroFactTable(ds,
        new Integer(secu),
        Field.STRING,
        "sku",
        new Integer(150),
        new Boolean(false));
  	
  	
  }

  
  private void tratarCliente(IDataSet ds,int secu) {

  	cargarRegistroFactTable(ds,
        new Integer(secu),
        Field.STRING,
        "cliente",
        new Integer(150),
        new Boolean(false));
  	
  	
  }
  
  private void tratarLetra(IDataSet ds,int secu) {

  	cargarRegistroFactTable(ds,
        new Integer(secu),
        Field.STRING,
        "letra",
        new Integer(5),
        new Boolean(false));
  	
  	
  }
  
  
  

  private void tratarFormaPago(IDataSet ds,int secu) {

  	cargarRegistroFactTable(ds,
        new Integer(secu),
        Field.INTEGER,
        "oid_cond_pago",
        new Integer(0),
        new Boolean(false));
  	
  }
  
  private void tratarTipoComprobante(IDataSet ds,int secu) {

  	cargarRegistroFactTable(ds,
        new Integer(secu),
        Field.INTEGER,
        "oid_tc",
        new Integer(0),
        new Boolean(false));
  	
  }  
  
  private void tratarVendedor(IDataSet ds,int secu) {

  	cargarRegistroFactTable(ds,
        new Integer(secu),
        Field.INTEGER,
        "oid_vendedor",
        new Integer(0),
        new Boolean(false));
  	
  }
  
  
  private void tratarMes(IDataSet ds,int secu) {

  	cargarRegistroFactTable(ds,
        new Integer(secu),
        Field.INTEGER,
        "mes",
        new Integer(0),
        new Boolean(false));
  	
  }
  
  private void tratarDia(IDataSet ds,int secu) {

  	cargarRegistroFactTable(ds,
        new Integer(secu),
        Field.STRING,
        "fecha",
        new Integer(10),
        new Boolean(false));
  	
  }
  
  
  
  private void tratarAneo(IDataSet ds,int secu) {

  	cargarRegistroFactTable(ds,
        new Integer(secu),
        Field.INTEGER,
        "aneo",
        new Integer(0),
        new Boolean(false));
  	
  }
  
  private IDataSet getDataSetFactTable(IDataSet dsDimensiones) throws BaseException {
    IDataSet dataset = new TDataSet();
    dataset.create("TFactTable");
    
    dsDimensiones.first();
    while (!dsDimensiones.EOF()) {

  		if ((dsDimensiones.getBoolean("seleccionado")!=null) && 
  				 (dsDimensiones.getBoolean("seleccionado").booleanValue())) {
  			if (dsDimensiones.getString("identificador").equals(ClasificadorEntidad.NICKNAME))
  				dataset.fieldDef(new Field("oid_clasif_"+dsDimensiones.getInteger("oid_clasificador"), Field.INTEGER, 0));
  			else
  				if (dsDimensiones.getString("identificador").equals("FECHA_ANEO"))
  					dataset.fieldDef(new Field("aneo", Field.INTEGER, 0));
  				else
    				if (dsDimensiones.getString("identificador").equals("FECHA_MES"))
    					dataset.fieldDef(new Field("mes", Field.INTEGER, 0));
    				else
      				if (dsDimensiones.getString("identificador").equals("FECHA_DIA"))
      					dataset.fieldDef(new Field("fecha", Field.DATE, 0));
      				else
        				if (dsDimensiones.getString("identificador").equals(TipoComprobante.NICKNAME))
        					dataset.fieldDef(new Field("oid_tc", Field.INTEGER, 0));
        				else
          				if (dsDimensiones.getString("identificador").equals(Vendedor.NICKNAME))
          					dataset.fieldDef(new Field("oid_vendedor", Field.INTEGER, 0));
          				else
            				if (dsDimensiones.getString("identificador").equals(CondicionPago.NICKNAME))
            					dataset.fieldDef(new Field("oid_cond_pago", Field.INTEGER, 0));
            				else
              				if (dsDimensiones.getString("identificador").equals(ComproCab.NICKNAME)) {
              					dataset.fieldDef(new Field("oid_cco", Field.INTEGER, 0));
              					dataset.fieldDef(new Field("comprobante", Field.STRING, 50));
              				}
              				else
                				if (dsDimensiones.getString("identificador").equals(Producto.NICKNAME))
                					dataset.fieldDef(new Field("sku", Field.STRING, 150));
                				else
                  				if (dsDimensiones.getString("identificador").equals(Sujeto.NICKNAME))
                  					dataset.fieldDef(new Field("cliente", Field.STRING, 150));
                  				else
                    				if (dsDimensiones.getString("identificador").equals("LETRA"))
                    					dataset.fieldDef(new Field("letra", Field.STRING, 5));
  			
  		}

    	dsDimensiones.next();
    }
    
    
    // Definir los campos de la Fact Table
    dataset.fieldDef(new Field("cantidad", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("importe", Field.CURRENCY, 0));
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
  
  private IDataSet getDataSetMeses() {
    IDataSet dataset = new TDataSet();
    dataset.create("TMeses");
    
    // Aspectos Fisicos
    dataset.fieldDef(new Field("nro_mes", Field.INTEGER, 0));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
    
    return dataset;
  }
  
  private IDataSet getDataSetVendedores() {
    IDataSet dataset = new TDataSet();
    dataset.create("TVendedores");
    
    // Aspectos Fisicos
    dataset.fieldDef(new Field("oid_vendedor", Field.INTEGER, 0));
    dataset.fieldDef(new Field("nombre_y_apellido", Field.STRING, 100));
    
    return dataset;
  }
  
  private IDataSet getDataSetTipoComprobante() {
    IDataSet dataset = new TDataSet();
    dataset.create("TTipoComprobante");
    
    // Aspectos Fisicos
    dataset.fieldDef(new Field("oid_tc", Field.INTEGER, 0));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
    
    return dataset;
  }
  
  private IDataSet getDataSetCondPago() {
    IDataSet dataset = new TDataSet();
    dataset.create("TCondPago");
    
    // Aspectos Fisicos
    dataset.fieldDef(new Field("oid_cond_pago", Field.INTEGER, 0));
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
  
  
  
  private void cargarRegistroVendedor(IDataSet dsVendedor,Vendedor vendedor) throws BaseException {
    dsVendedor.append();
    dsVendedor.fieldValue("oid_vendedor", vendedor.getOIDInteger());
    dsVendedor.fieldValue("nombre_y_apellido", vendedor.getNombreyApellido());
  }
  
  
  private void cargarRegistroTipoComprobante(IDataSet dsVendedor,TipoComprobante tipoComprobante) throws BaseException {
    dsVendedor.append();
    dsVendedor.fieldValue("oid_tc", tipoComprobante.getOIDInteger());
    dsVendedor.fieldValue("descripcion", tipoComprobante.getDescripcion());
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
  
  private void cargarRegistroCondPago(IDataSet dsCondPago,CondicionPago condPago) throws BaseException {
  	dsCondPago.append();
  	dsCondPago.fieldValue("oid_cond_pago", condPago.getOIDInteger());
  	dsCondPago.fieldValue("descripcion", condPago.getDescripcion());
  }
  
  
}
