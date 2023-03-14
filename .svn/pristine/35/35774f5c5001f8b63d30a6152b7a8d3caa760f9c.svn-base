package com.srn.erp.ventas.op;

import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.bm.UnidadMedida;

import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerCostoConvAUMVta extends Operation {

  public TraerCostoConvAUMVta() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	  
	  
	  
	Producto producto = Producto.findByOid(mapaDatos.getInteger("oid_producto"), this.getSesion());
	Money costo = mapaDatos.getMoney("costo");
	Money cantCosto = mapaDatos.getMoney("cant_costo");
	UnidadMedida umCosto = UnidadMedida.findByOidProxy(mapaDatos.getInteger("oid_um_costo"), this.getSesion());
	Money cantVenta = mapaDatos.getMoney("cant_venta");
	UnidadMedida umVenta = UnidadMedida.findByOidProxy(mapaDatos.getInteger("oid_um_venta"), this.getSesion());
	
	IDataSet dsCostoEnUMVta = getDataSet();
	
	Money costoEnUMVta = producto.getCostoConvAUMVta(costo,cantCosto,umCosto,cantVenta,umVenta);
	cargarRegistro(dsCostoEnUMVta, costoEnUMVta);
    writeCliente(dsCostoEnUMVta);
    
  }

  private IDataSet getDataSet() {
    IDataSet dataset = new TDataSet();
    dataset.create("TCostoEnUMVta");
    dataset.fieldDef(new Field("costo", Field.CURRENCY, 0));
    return dataset;
  }

  private void cargarRegistro(IDataSet dataset,
                         Money costo) {
    dataset.append();
    dataset.fieldValue("costo", costo);
  }
  
}
