package com.srn.erp.produccion.op;

import java.util.Iterator;

import com.srn.erp.produccion.bm.RecetaCab;
import com.srn.erp.produccion.bm.RecetaDet;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerDetallesRecetaProd extends Operation { 

  public TraerDetallesRecetaProd() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 

	Integer oidRecetaCab = mapaDatos.getInteger("oid_receta_cab");
	RecetaCab recetaCab = RecetaCab.findByOidProxy(oidRecetaCab, this.getSesion()); 
	  
	IDataSet ds = this.getDataSetDetRecProd();
	Iterator iterRecetasDet = 
		recetaCab.getRecetasDet().iterator();
	while (iterRecetasDet.hasNext()) {
		RecetaDet recetaDet = (RecetaDet) iterRecetasDet.next();
		if (!recetaDet.isActivo()) continue;
		cargarRegistroRecetaDet(ds, recetaDet);
	}
	writeCliente(ds);
	
  }

  private IDataSet getDataSetDetRecProd() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TTempRecetaDet");
    dataset.fieldDef(new Field("oid_rec_det", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_rec_cab", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_producto", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_producto", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_producto", Field.STRING, 100));
    dataset.fieldDef(new Field("cantidad", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("oid_um", Field.INTEGER, 0));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("orden", Field.INTEGER, 0));
    return dataset;
  }

  private void cargarRegistroRecetaDet(
		  IDataSet dataset, 
          RecetaDet recetaDet) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid_rec_det", recetaDet.getOIDInteger());
    dataset.fieldValue("oid_rec_cab", recetaDet.getReceta_cab().getOIDInteger());
    dataset.fieldValue("oid_producto", recetaDet.getProducto().getOIDInteger());
    dataset.fieldValue("cod_producto", recetaDet.getProducto().getCodigo());
    dataset.fieldValue("desc_producto", recetaDet.getProducto().getDescripcion());
    dataset.fieldValue("cantidad", recetaDet.getCantidad());
    dataset.fieldValue("oid_um", recetaDet.getOid_um().getOIDInteger());
    dataset.fieldValue("activo", recetaDet.isActivo());
    dataset.fieldValue("orden", recetaDet.getOrden());
  }
}
