package com.srn.erp.ctasAPagar.op;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.compras.bm.CondicionCompra;
import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.compras.bm.SectorCompra;
import com.srn.erp.contabilidad.bm.Cuenta;
import com.srn.erp.ctacte.bm.TipoCtaCteProv;
import com.srn.erp.ctasAPagar.bm.ConcFactProv;
import com.srn.erp.ctasAPagar.bm.EstadisticaComproProv;
import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.general.bm.Cotizacion;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.general.bm.TipoCambio;
import com.srn.erp.general.bm.TipoComprobante;
import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.stock.bm.Producto;

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

public class TraerEstrucFactTableEstadComproProv extends Operation {

  HashTableDatos fechas = new HashTableDatos();
	
  public TraerEstrucFactTableEstadComproProv() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
  	
  	if (mapaDatos.containsKey("TRAER_ESTRUCTURA"))
  		enviarEstructura(mapaDatos);
  	else if (mapaDatos.containsKey("LLENAR_FACT_TABLE"))
  		enviarDatosFactTable(mapaDatos);
  	else if (mapaDatos.containsKey("LLENAR_DIMENSION"))
		enviarDatosDimension(mapaDatos);
  	
  	
  }
  
  private void enviarDatosDimension(MapDatos mapaDatos) throws BaseException {
	  	
	  	IDataSet dsDimensiones = mapaDatos.getDataSet("TDimensiones");
	  	enviarDimensiones(dsDimensiones);
	  	
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
  		TipoCambio.getTipoCambioCtaCteProv(this.getSesion());  	
  	
  	Iterator  iterEstadComproProv = EstadisticaComproProv.getEstadisticaComproProv(
  			mapaDatos.getDate("fec_desde"),
  			mapaDatos.getDate("fec_hasta"),
  			this.getSesion()).iterator();
  	while (iterEstadComproProv.hasNext()) {
  		EstadisticaComproProv estadisticaComproProv = (EstadisticaComproProv) iterEstadComproProv.next();
  		cargarEstadComproProv(dsFactTable,dsDimensiones,estadisticaComproProv,moneda,tipoCambio);
  	}
  	
  	writeCliente(dsFactTable);
  	
  	
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
  			if (dsDimensiones.getString("identificador").equals(SectorCompra.NICKNAME))
  				enviarDimensionSectorCompra();
    		else
    			if (dsDimensiones.getString("identificador").equals(TipoComprobante.NICKNAME))
    				enviarDimensionTipoComprobante();
      		else
      			if (dsDimensiones.getString("identificador").equals(CondicionCompra.NICKNAME))
      				enviarDimensionCondPago();
          		else
          			if (dsDimensiones.getString("identificador").equals(TipoCtaCteProv.NICKNAME))
          				enviarDimensionTipoCtaCteProv();
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
  		CondicionCompra.getAllCondCompra(this.getSesion()).iterator();
  	while (iterCondPago.hasNext()) {
  		CondicionCompra condPago = (CondicionCompra) iterCondPago.next();
  		cargarRegistroCondPago(ds,condPago);
  	}
  	writeCliente(ds);
  }
  
  private void enviarDimensionTipoCtaCteProv() throws BaseException {
	  	IDataSet ds = this.getDataSetTipoCtaCteProv();
	  	Iterator iterTipoCtaCteProv = TipoCtaCteProv.getTipoCtaCteProv(this.getSesion()).iterator();
	  	while (iterTipoCtaCteProv.hasNext()) {
	  		TipoCtaCteProv tipoCtaCte = (TipoCtaCteProv) iterTipoCtaCteProv.next();
	  		cargarRegistroTipoCtaCteProv(ds,tipoCtaCte);
	  	}
	  	writeCliente(ds);
	  }
  
  
  
  private void enviarDimensionSectorCompra() throws BaseException {
  	IDataSet dsSectorCompra = this.getDataSetSectorCompra();
  	Iterator iterSectoresCompra = SectorCompra.getSectoresCompras(this.getSesion()).iterator();
  	while (iterSectoresCompra.hasNext()) {
  		SectorCompra sectorCompra = (SectorCompra) iterSectoresCompra.next();
  		cargarRegistroSectorCompra(dsSectorCompra,sectorCompra);
  	}
  	writeCliente(dsSectorCompra);
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
  
  private void cargarEstadComproProv(IDataSet dsFactTable,
  		                     IDataSet dsDimensiones,
  		                     EstadisticaComproProv estad,
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
          				if (dsDimensiones.getString("identificador").equals(SectorCompra.NICKNAME))
          					dsFactTable.fieldValue("oid_sector_compra",estad.getOid_Sector_Compra());
          				else
            				if (dsDimensiones.getString("identificador").equals(CondicionCompra.NICKNAME))
            					dsFactTable.fieldValue("oid_cond_pago",estad.getOid_cond_pago());
            				else
              				if (dsDimensiones.getString("identificador").equals(ComproCab.NICKNAME)) {
              					 dsFactTable.fieldValue("oid_cco",estad.getOid_cco());
              					 dsFactTable.fieldValue("comprobante",estad.getComprobante());
              				}
              				else
                				if (dsDimensiones.getString("identificador").equals(TipoCtaCteProv.NICKNAME))
                					dsFactTable.fieldValue("oid_tipo_cta_prov",estad.getOidTipoCtaCte());
                				else
                    				if (dsDimensiones.getString("identificador").equals(ConcFactProv.NICKNAME))
                    					dsFactTable.fieldValue("desc_conc_fact_prov",estad.getDescConcepto());
                    				else
                        				if (dsDimensiones.getString("identificador").equals(Cuenta.NICKNAME))
                        					dsFactTable.fieldValue("desc_cuenta",estad.getCodCuenta()+" - "+estad.getDescCuenta());
                        				else
                    					if (dsDimensiones.getString("identificador").equals(Proveedor.NICKNAME))
                    						dsFactTable.fieldValue("proveedor",estad.getNombreProveedoryCodigo());
  						
  		
  		dsDimensiones.next();
  	}
  	
  	CalculadorMoney calcImpo = new CalculadorMoney(new Money(getImpoEnMoneda(
  			estad.getEmision(),
  			estad.getImporte(), 
  			estad.getOid_moneda(),
  			estad.getCotizacion(),
  			moneda.getOIDInteger(),
  			tipoCambio)));
  	calcImpo.multiplicarPor(new Money(estad.getSigno()));
  	
  	dsFactTable.fieldValue("importe",calcImpo.getResult());
  	
  	
  	
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
          				if (dsDimensiones.getString("identificador").equals(SectorCompra.NICKNAME))
          					tratarSectorCompra(ds,secu);
          				else
            				if (dsDimensiones.getString("identificador").equals(CondicionCompra.NICKNAME))
            					tratarCondCompra(ds,secu);
            				else
              				if (dsDimensiones.getString("identificador").equals(ComproCab.NICKNAME)) 
              					tratarComprobante(ds,secu);
                				else
                  				if (dsDimensiones.getString("identificador").equals(TipoCtaCteProv.NICKNAME)) 
                  					tratarTipoCtaCteProv(ds,secu);
                    				else
                          				if (dsDimensiones.getString("identificador").equals(ConcFactProv.NICKNAME)) 
                          					tratarConfFactProv(ds,secu);
                            				else
                                  				if (dsDimensiones.getString("identificador").equals(Cuenta.NICKNAME)) 
                                  					tratarCuenta(ds,secu);
                                    				else                    					                            					
                                    					if (dsDimensiones.getString("identificador").equals(Proveedor.NICKNAME)) 
                                    						tratarProveedor(ds,secu);
              					
  		}
  		dsDimensiones.next();
  	}
  	
  	++secu;
  	tratarMetrica(ds,secu,"importe");
  	
  	writeCliente(ds);
  	
  	
  }

  private void tratarMetrica(IDataSet ds,int secu, String nombreMetrica) {

  	cargarRegistroFactTable(ds,
        new Integer(secu),
        Field.CURRENCY,
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

  
  private void tratarProveedor(IDataSet ds,int secu) {

  	cargarRegistroFactTable(ds,
        new Integer(secu),
        Field.STRING,
        "proveedor",
        new Integer(150),
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
  
  
  private void tratarTipoCtaCteProv(IDataSet ds,int secu) {

	  	cargarRegistroFactTable(ds,
	        new Integer(secu),
	        Field.INTEGER,
	        "oid_tipo_cta_prov",
	        new Integer(0),
	        new Boolean(false));
	  	
  }
  
  private void tratarConfFactProv(IDataSet ds,int secu) {

	  	cargarRegistroFactTable(ds,
	        new Integer(secu),
	        Field.STRING,
	        "desc_conc_fact_prov",
	        new Integer(50),
	        new Boolean(false));
	  	
  }
  
  private void tratarCuenta(IDataSet ds,int secu) {

	  	cargarRegistroFactTable(ds,
	        new Integer(secu),
	        Field.STRING,
	        "desc_cuenta",
	        new Integer(100),
	        new Boolean(false));
	  	
}
  
  
  
  
  private void tratarSectorCompra(IDataSet ds,int secu) {

	  	cargarRegistroFactTable(ds,
	        new Integer(secu),
	        Field.INTEGER,
	        "oid_sector_compra",
	        new Integer(0),
	        new Boolean(false));
	  	
  }
  
  private void tratarCondCompra(IDataSet ds,int secu) {

	  	cargarRegistroFactTable(ds,
	        new Integer(secu),
	        Field.INTEGER,
	        "oid_cond_pago",
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
          				if (dsDimensiones.getString("identificador").equals(SectorCompra.NICKNAME))
          					dataset.fieldDef(new Field("oid_sector_compra", Field.INTEGER, 0));
          				else
            				if (dsDimensiones.getString("identificador").equals(CondicionCompra.NICKNAME))
            					dataset.fieldDef(new Field("oid_cond_pago", Field.INTEGER, 0));
            				else
              				if (dsDimensiones.getString("identificador").equals(ComproCab.NICKNAME)) {
              					dataset.fieldDef(new Field("oid_cco", Field.INTEGER, 0));
              					dataset.fieldDef(new Field("comprobante", Field.STRING, 50));
              				}
              				else
                				if (dsDimensiones.getString("identificador").equals(TipoCtaCteProv.NICKNAME))
                					dataset.fieldDef(new Field("oid_tipo_cta_prov", Field.INTEGER, 0));
                  				else
                    				if (dsDimensiones.getString("identificador").equals(ConcFactProv.NICKNAME))
                    					dataset.fieldDef(new Field("desc_conc_fact_prov", Field.STRING, 50));
                    				else
                    					if (dsDimensiones.getString("identificador").equals(Cuenta.NICKNAME))
                    						dataset.fieldDef(new Field("desc_cuenta", Field.STRING, 100));
                    					else                					
                    						if (dsDimensiones.getString("identificador").equals(Proveedor.NICKNAME))
                    							dataset.fieldDef(new Field("proveedor", Field.STRING, 150));
  			
  		}

    	dsDimensiones.next();
    }
    
    
    // Definir los campos de la Fact Table
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
  
  private IDataSet getDataSetSectorCompra() {
    IDataSet dataset = new TDataSet();
    dataset.create("TSectorCompras");
    
    // Aspectos Fisicos
    dataset.fieldDef(new Field("oid_sector_compra", Field.INTEGER, 0));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
    
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
  
  private IDataSet getDataSetTipoCtaCteProv() {
	    IDataSet dataset = new TDataSet();
	    dataset.create("TTipoCtaCte");
	    
	    // Aspectos Fisicos
	    dataset.fieldDef(new Field("oid_tipo_cta_cte", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
	    
	    return dataset;
	  }  
  
  
  private IDataSet getDataSetClasificador(ClasificadorEntidad clasifEnt) {
  	
    IDataSet dataset = new TDataSet();
    dataset.create("TClasif_"+clasifEnt.getOIDInteger());
    
    // Aspectos Fisicos
    dataset.fieldDef(new Field("oid_clasif", Field.INTEGER, 0));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
    
    return dataset;
  }
  
  private void cargarValClasif(IDataSet ds,ValorClasificadorEntidad valorClasif) throws BaseException {
    ds.append();
    ds.fieldValue("oid_val_clasif", valorClasif.getOIDInteger());
    ds.fieldValue("desc_val_clasif", valorClasif.getDescripcion());
  }
  
  
  
  private void cargarRegistroSectorCompra(IDataSet dsSectorCompra,SectorCompra sectorCompra) throws BaseException {
    dsSectorCompra.append();
    dsSectorCompra.fieldValue("oid_sector_compra", sectorCompra.getOIDInteger());
    dsSectorCompra.fieldValue("descripcion", sectorCompra.getDescripcion());
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
  
  private void cargarRegistroTipoCtaCteProv(IDataSet ds,TipoCtaCteProv tipoCtaCte) throws BaseException {
	  	ds.append();
	  	ds.fieldValue("oid_tipo_cta_cte", tipoCtaCte.getOIDInteger());
	  	ds.fieldValue("descripcion", tipoCtaCte.getDescripcion());
  }
  
  private void cargarRegistroCondPago(IDataSet dsCondPago,CondicionCompra condPago) throws BaseException {
  	dsCondPago.append();
  	dsCondPago.fieldValue("oid_cond_pago", condPago.getOIDInteger());
  	dsCondPago.fieldValue("descripcion", condPago.getDescripcion());
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
  
  
}
