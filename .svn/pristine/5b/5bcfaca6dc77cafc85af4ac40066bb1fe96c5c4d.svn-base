package com.srn.erp.ventas.op;

import java.util.Iterator;

import com.srn.erp.ventas.bm.FacturaCab;
import com.srn.erp.ventas.bm.FacturaDet;

import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerDetFactura extends Operation {

  public TraerDetFactura() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
  	
  	Integer oidCCOFact = mapaDatos.getInteger("oid_cco");
  	FacturaCab facturaCab = FacturaCab.findByOid(oidCCOFact,this.getSesion());
  	
  	IDataSet ds = this.getDataSetFacturaDet();
  	
  	Iterator iterDetFact = facturaCab.getItemsFactura().iterator();
  	while (iterDetFact.hasNext()) {
  		FacturaDet facturaDet = (FacturaDet) iterDetFact.next();
  		if (facturaDet.isAnulado().booleanValue()==true) continue;
  		cargarRegistro(ds,facturaDet);
  	}
  	
  	writeCliente(ds);
  	
  	
  	
  }

  private IDataSet getDataSetFacturaDet() {
    IDataSet dataset = new TDataSet();
    dataset.create("TFacturasDet");
    dataset.fieldDef(new Field("oid_cco_det", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_cco", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_producto", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_producto", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_producto", Field.STRING, 255));
    dataset.fieldDef(new Field("cant_fact", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("cant_nc", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("precio", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("sel", Field.BOOLEAN, 0));
    return dataset;
  }

  private void cargarRegistro(IDataSet dataset,
                         			FacturaDet facturaDet) throws BaseException {
  	dataset.append();
  	dataset.fieldValue("oid_cco_det", facturaDet.getOIDInteger());
  	dataset.fieldValue("oid_cco", facturaDet.getComprocab().getOIDInteger());
  	dataset.fieldValue("oid_producto", facturaDet.getProducto().getOIDInteger());
  	dataset.fieldValue("cod_producto", facturaDet.getProducto().getCodigo());  			
  	dataset.fieldValue("desc_producto", facturaDet.getProducto().getDescripcion());
  	dataset.fieldValue("cant_fact", facturaDet.getCantidad());
  	dataset.fieldValue("cant_nc", new Money(0));
  	dataset.fieldValue("precio", facturaDet.getPrecio_ingresado());
  	dataset.fieldValue("sel", new Boolean(true));
  }
}
