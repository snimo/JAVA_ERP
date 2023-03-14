package com.srn.erp.produccion.op;

import com.srn.erp.produccion.bm.*;
import com.srn.erp.produccion.da.DBRecetaCab;
import com.srn.erp.stock.bm.Producto;

import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Tablas.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.*;

public class ValidadorRecFabProd extends Operation { 

  public ValidadorRecFabProd() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
	  
	Integer oidProducto = mapaDatos.getInteger("oid_producto");
	String alternativa = mapaDatos.getString("alternativa");
	
	Producto producto = Producto.findByOidProxy(oidProducto, this.getSesion());
	RecetaCab receta = RecetaCab.getRecetaByProductoAlternativa(producto,alternativa,this.getSesion());
	
	IDataSet ds = this.getDataSetReceta();
	if (receta!=null) 
		cargarRegistroReceta(ds, receta);	
	writeCliente(ds);
	
		  
  }
	
	

  private IDataSet getDataSetReceta() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TValReceta");
    dataset.fieldDef(new Field("oid", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 50)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistroReceta(IDataSet dataset, 
                         RecetaCab receta) throws BaseException {
    dataset.append(); 
    dataset.fieldValue("oid", receta.getOIDInteger());
    dataset.fieldValue("codigo", receta.getAlternativa());
    dataset.fieldValue("descripcion", receta.getAlternativa());
    dataset.fieldValue("activo", receta.isActivo());
  }
}
