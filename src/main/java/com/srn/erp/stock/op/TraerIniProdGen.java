package com.srn.erp.stock.op;

import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.stock.bm.Producto;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerIniProdGen extends Operation { 

  public TraerIniProdGen() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
  	IDataSet dsClasif = this.getDSGenProdClasif();
  	ClasificadorEntidad clasif = Producto.getClasifProductoGeneral(this.getSesion());
  	cargarGenProdClasif(dsClasif, clasif);
  	writeCliente(dsClasif);
  }

  private IDataSet getDSGenProdClasif() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TClasifProdGeneral");
    dataset.fieldDef(new Field("oid_clasificador", Field.INTEGER, 0));
    dataset.fieldDef(new Field("nro_clasificador", Field.INTEGER, 0));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 255));
    return dataset;
  }

  private void cargarGenProdClasif(IDataSet dataset, 
                                   ClasificadorEntidad clasificador) throws BaseException {
	  
	dataset.append();
	dataset.fieldValue("oid_clasificador", clasificador.getOIDInteger());
	dataset.fieldValue("nro_clasificador", clasificador.getNroClasif());
	dataset.fieldValue("descripcion", clasificador.getDescripcion());
  }  
  
}
