package com.srn.erp.compras.op;

import java.util.Iterator;

import com.srn.erp.compras.bm.CondicionCompra;
import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.compras.bm.SectorCompra;
import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.general.bm.TipoComprobante;
import com.srn.erp.stock.bm.ExtensionProdGen;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.ventas.bm.Sujeto;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerDimenEstadCompras extends Operation {

	HashTableDatos preciosCompraClasif = new HashTableDatos();

	public TraerDimenEstadCompras() {
	}

	  public void execute(MapDatos mapaDatos) throws BaseException {

		    IDataSet ds = this.getDataDimenEstadOC();
		    cargarDimensionesFechas(ds);
		    cargarDimensionesComprobantes(ds);
		    cargarDimensionesClasifProductos(ds);
		    cargarDimensionesClasifProveedores(ds);
		    writeCliente(ds);
		    
		  }

		  
		  private void cargarDimensionesFechas(IDataSet ds) {
		  	cargarRegistroDimenEstadOC(ds,"01-Fechas","Año",new Integer(0),new Boolean(true),new Integer(0),"FECHA_ANEO",new Integer(1),"COL");
		  	cargarRegistroDimenEstadOC(ds,"01-Fechas","Mes",new Integer(0),new Boolean(false),new Integer(0),"FECHA_MES",new Integer(2),"COL");
		  	cargarRegistroDimenEstadOC(ds,"01-Fechas","Fecha",new Integer(0),new Boolean(false),new Integer(0),"FECHA_DIA",new Integer(3),"COL");
		  }
		  
		  private void cargarDimensionesComprobantes(IDataSet ds) {
		  	cargarRegistroDimenEstadOC(ds,"02-Comprobantes","Tipo de Comprobante",new Integer(0),new Boolean(false),new Integer(0),TipoComprobante.NICKNAME,new Integer(1),"ROW");
		  	cargarRegistroDimenEstadOC(ds,"02-Comprobantes","Sector",new Integer(0),new Boolean(false),new Integer(0),SectorCompra.NICKNAME,new Integer(2),"ROW");
		  	cargarRegistroDimenEstadOC(ds,"02-Comprobantes","Condición de Pago",new Integer(0),new Boolean(false),new Integer(0),CondicionCompra.NICKNAME,new Integer(3),"ROW");
		  	cargarRegistroDimenEstadOC(ds,"02-Comprobantes","Comprobante",new Integer(0),new Boolean(false),new Integer(0),ComproCab.NICKNAME,new Integer(4),"ROW");
		  	
		  }
		  
		  private void cargarDimensionesClasifProductos(IDataSet ds) throws BaseException {

		  	cargarRegistroDimenEstadOC(ds,"03-Productos","SKU",new Integer(0),new Boolean(false),new Integer(0),Producto.NICKNAME,new Integer(1),"ROW");
		  	int secu = 0;
		  	Iterator iterClasifProductos = 
		  		Producto.getClasificadoresEntidadActivos(this.getSesion()).iterator();
		  	while (iterClasifProductos.hasNext()) {
		  		ClasificadorEntidad clasifEntidad = (ClasificadorEntidad) iterClasifProductos.next();
		  		++secu;
		  		cargarRegistroDimenEstadOC(ds,
		  				"03-Productos",
		  				clasifEntidad.getDescripcion(),
		  				new Integer(0),new Boolean(false),
		  				clasifEntidad.getOIDInteger(),
		  				ClasificadorEntidad.NICKNAME,
		  				new Integer(secu),"ROW");
		  	}
		  	
		  	Iterator iterClasifProductosGral = 
		  		ExtensionProdGen.getClasificadoresEntidadActivos(this.getSesion()).iterator();
		  	while (iterClasifProductosGral.hasNext()) {
		  		ClasificadorEntidad clasifEntidad = (ClasificadorEntidad) iterClasifProductosGral.next();
		  		if (!clasifEntidad.isActivo()) continue;
		  		++secu;
		  		cargarRegistroDimenEstadOC(ds,
		  				"03-Productos",
		  				clasifEntidad.getDescripcion(),
		  				new Integer(0),new Boolean(false),
		  				clasifEntidad.getOIDInteger(),
		  				ClasificadorEntidad.NICKNAME,
		  				new Integer(secu),"ROW");
		  	}
		  	
		  	
		  }
		  
		  private void cargarDimensionesClasifProveedores(IDataSet ds) throws BaseException {

		  	cargarRegistroDimenEstadOC(ds,"04-Proveedores","Proveedor",new Integer(0),new Boolean(false),new Integer(0),Proveedor.NICKNAME,new Integer(1),"ROW");
		  	int secu = 0;
		  	Iterator iterClasifProveedores = 
		  		Proveedor.getClasificadoresEntidad(this.getSesion()).iterator();
		  	while (iterClasifProveedores.hasNext()) {
		  		ClasificadorEntidad clasifEntidad = (ClasificadorEntidad) iterClasifProveedores.next();
		  		if (!clasifEntidad.isActivo()) continue;
		  		++secu;
		  		cargarRegistroDimenEstadOC(ds,
		  				"04-Proveedores",
		  				clasifEntidad.getDescripcion(),
		  				new Integer(0),new Boolean(false),
		  				clasifEntidad.getOIDInteger(),
		  				ClasificadorEntidad.NICKNAME,
		  				new Integer(secu),"ROW");
		  	}
		  	
		  }
		  
		  
		  

		  private IDataSet getDataDimenEstadOC() {
		    IDataSet dataset = new TDataSet();
		    dataset.create("TDimensiones");
		    dataset.fieldDef(new Field("titulo", Field.STRING, 100));
		    dataset.fieldDef(new Field("subtitulo", Field.STRING, 100));
		    dataset.fieldDef(new Field("orden", Field.INTEGER, 0));
		    dataset.fieldDef(new Field("seleccionado", Field.BOOLEAN, 0));
		    dataset.fieldDef(new Field("oid_clasificador", Field.INTEGER, 0));
		    dataset.fieldDef(new Field("identificador", Field.STRING, 20));
		    dataset.fieldDef(new Field("orden_interno", Field.INTEGER, 0));
		    dataset.fieldDef(new Field("ubicacion", Field.STRING, 20));
		    return dataset;
		  }

		  private void cargarRegistroDimenEstadOC(IDataSet dataset,
		                         									 String  titulo,
		                         									 String subtitulo,
		                         									 Integer orden,
		                         									 Boolean seleccionado,
		                         									 Integer oidClasificador,
		                         									 String identificador,
		                         									 Integer ordenInterno,
		                         									 String ubicacion) {
		    dataset.append();
		    dataset.fieldValue("titulo", titulo);
		    dataset.fieldValue("subtitulo", subtitulo);
		    dataset.fieldValue("orden", orden);
		    dataset.fieldValue("seleccionado", seleccionado);
		    dataset.fieldValue("oid_clasificador", oidClasificador);
		    dataset.fieldValue("identificador", identificador);
		    dataset.fieldValue("orden_interno", ordenInterno);
		    dataset.fieldValue("ubicacion", ubicacion);
		  }

}
