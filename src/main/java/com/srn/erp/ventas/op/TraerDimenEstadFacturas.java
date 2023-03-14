package com.srn.erp.ventas.op;

import java.util.Iterator;

import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.general.bm.TipoComprobante;
import com.srn.erp.stock.bm.ExtensionProdGen;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.ventas.bm.CondicionPago;
import com.srn.erp.ventas.bm.Sujeto;
import com.srn.erp.ventas.bm.Vendedor;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerDimenEstadFacturas extends Operation {

  public TraerDimenEstadFacturas() {
  	
  
  	
  }

  public void execute(MapDatos mapaDatos) throws BaseException {

    IDataSet ds = this.getDataDimenEstadPed();
    cargarDimensionesFechas(ds);
    cargarDimensionesComprobantes(ds);
    cargarDimensionesClasifProductos(ds);
    cargarDimensionesClasifClientes(ds);
    writeCliente(ds);
    
  }

  
  private void cargarDimensionesFechas(IDataSet ds) {
  	cargarRegistroDimenEstadPed(ds,"01-Fechas","Año",new Integer(0),new Boolean(true),new Integer(0),"FECHA_ANEO",new Integer(1),"COL");
  	cargarRegistroDimenEstadPed(ds,"01-Fechas","Mes",new Integer(0),new Boolean(false),new Integer(0),"FECHA_MES",new Integer(2),"COL");
  	cargarRegistroDimenEstadPed(ds,"01-Fechas","Fecha",new Integer(0),new Boolean(false),new Integer(0),"FECHA_DIA",new Integer(3),"COL");
  }
  
  private void cargarDimensionesComprobantes(IDataSet ds) {
  	cargarRegistroDimenEstadPed(ds,"02-Comprobantes","Tipo de Comprobante",new Integer(0),new Boolean(false),new Integer(0),TipoComprobante.NICKNAME,new Integer(1),"ROW");
  	cargarRegistroDimenEstadPed(ds,"02-Comprobantes","Vendedor",new Integer(0),new Boolean(false),new Integer(0),Vendedor.NICKNAME,new Integer(2),"ROW");
  	cargarRegistroDimenEstadPed(ds,"02-Comprobantes","Forma de Pago",new Integer(0),new Boolean(false),new Integer(0),CondicionPago.NICKNAME,new Integer(3),"ROW");
  	cargarRegistroDimenEstadPed(ds,"02-Comprobantes","Comprobante",new Integer(0),new Boolean(false),new Integer(0),ComproCab.NICKNAME,new Integer(4),"ROW");
  	cargarRegistroDimenEstadPed(ds,"02-Comprobantes","Letra",new Integer(0),new Boolean(false),new Integer(0),"LETRA",new Integer(5),"ROW");
  	
  	
  }
  
  private void cargarDimensionesClasifProductos(IDataSet ds) throws BaseException {

  	cargarRegistroDimenEstadPed(ds,"03-Productos","SKU",new Integer(0),new Boolean(false),new Integer(0),Producto.NICKNAME,new Integer(1),"ROW");
  	int secu = 0;
  	Iterator iterClasifProductos = 
  		Producto.getClasificadoresEntidadActivos(this.getSesion()).iterator();
  	while (iterClasifProductos.hasNext()) {
  		ClasificadorEntidad clasifEntidad = (ClasificadorEntidad) iterClasifProductos.next();
  		if (!clasifEntidad.isActivo()) continue;
  		++secu;
  		cargarRegistroDimenEstadPed(ds,
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
  		cargarRegistroDimenEstadPed(ds,
  				"03-Productos",
  				clasifEntidad.getDescripcion(),
  				new Integer(0),new Boolean(false),
  				clasifEntidad.getOIDInteger(),
  				ClasificadorEntidad.NICKNAME,
  				new Integer(secu),"ROW");
  	}
  	
  	
  }
  
  private void cargarDimensionesClasifClientes(IDataSet ds) throws BaseException {

  	cargarRegistroDimenEstadPed(ds,"04-Clientes","Cliente",new Integer(0),new Boolean(false),new Integer(0),Sujeto.NICKNAME,new Integer(1),"ROW");
  	int secu = 0;
  	Iterator iterClasifClientes = 
  		Sujeto.getClasificadoresEntidad(this.getSesion()).iterator();
  	while (iterClasifClientes.hasNext()) {
  		ClasificadorEntidad clasifEntidad = (ClasificadorEntidad) iterClasifClientes.next();
  		if (!clasifEntidad.isActivo()) continue;
  		++secu;
  		cargarRegistroDimenEstadPed(ds,
  				"04-Clientes",
  				clasifEntidad.getDescripcion(),
  				new Integer(0),new Boolean(false),
  				clasifEntidad.getOIDInteger(),
  				ClasificadorEntidad.NICKNAME,
  				new Integer(secu),"ROW");
  	}
  	
  }
  
  
  

  private IDataSet getDataDimenEstadPed() {
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

  private void cargarRegistroDimenEstadPed(IDataSet dataset,
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
