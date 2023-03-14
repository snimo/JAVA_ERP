package com.srn.erp.general.op;

import java.io.File;

import com.srn.erp.compras.bm.OrdenDeCompraCab;
import com.srn.erp.ventas.bm.CotizacionCab;
import com.srn.erp.ventas.bm.FacturaCab;
import com.srn.erp.ventas.bm.PedidoCab;
import com.srn.erp.ventas.bm.RemitoCab;

import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerHelpArchImpreRepo extends Operation {

  public TraerHelpArchImpreRepo() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {

    IDataSet dataset = getDataArch();
    traerArchEnCarpeta(dataset,"Ordenes de Compra",OrdenDeCompraCab.getCarpetaRTMOC((this.getSesion())));
    traerArchEnCarpeta(dataset,"Facturas / ND / NC Clientes",FacturaCab.getCarpetaRTMFacturas((this.getSesion())));
    traerArchEnCarpeta(dataset,"Pedidos",PedidoCab.getCarpetaRTMPedidos((this.getSesion())));
    traerArchEnCarpeta(dataset,"Presupuestos Clientes",CotizacionCab.getCarpetaRTMPresupuestos((this.getSesion())));
    traerArchEnCarpeta(dataset,"Remitos",RemitoCab.getCarpetaRTMRemitos((this.getSesion())));

    
    
    writeCliente(dataset);
  }
  
  private void traerArchEnCarpeta(IDataSet ds,String titulo,String carpeta) throws BaseException {
		
	    File dir = new File(carpeta.trim());
	    String[] children = dir.list();
	    
	    if (children!=null) {
	    	 for (int i=0; i<children.length; i++) {
	             // Get filename of file or directory
	             String filename = children[i];
	             if (!((new File(carpeta.trim() + File.separatorChar + filename.trim())).isDirectory()))
	            	 cargarRegistro(ds, titulo , filename);
	        }    	
	    	
	    }	  
  }
  


  private IDataSet getDataArch() {
    IDataSet dataset = new TDataSet();
    dataset.create("THelpArchivos");
    dataset.fieldDef(new Field("grupo", Field.STRING, 100));
    dataset.fieldDef(new Field("archivo", Field.STRING, 100));
    return dataset;
  }

  private void cargarRegistro(
                     IDataSet dataset,
                     String grupo,
                     String archivo) throws BaseException  {
                   dataset.append();
                   dataset.fieldValue("grupo", grupo);
                   dataset.fieldValue("archivo", archivo);
  }



}
