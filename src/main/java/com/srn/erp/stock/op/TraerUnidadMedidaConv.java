package com.srn.erp.stock.op;

import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.bm.UnidadMedida;

import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerUnidadMedidaConv extends Operation {

  public TraerUnidadMedidaConv() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {

    Double cantidad     = mapaDatos.getDouble("cantidad");
    Integer oidUMOri    = mapaDatos.getInteger("oid_um_ori");
    Integer oidUMDest   = mapaDatos.getInteger("oid_um_dest");
    Integer oidProducto = mapaDatos.getInteger("oid_producto");
    
    Proveedor proveedor = null;
    if (mapaDatos.containsKey("oid_proveedor"))
    	proveedor = Proveedor.findByOidProxy(mapaDatos.getInteger("oid_proveedor"),getSesion());
    
    Producto producto = Producto.findByOidProxy(oidProducto,getSesion());
    UnidadMedida uniMedOri  = UnidadMedida.findByOidProxy(oidUMOri,getSesion());
    UnidadMedida uniMedDest = UnidadMedida.findByOidProxy(oidUMDest,getSesion());
   
    Money cantConv = producto.getConvertirUM(proveedor,cantidad,uniMedOri,uniMedDest);
    
    if (cantConv == null)
      throw new ExceptionValidation(null,"No se encontró factor de conversión "+
                                         " entra las unidades "+
                                         uniMedOri.getDescripcion()+" y "+
                                         uniMedDest.getDescripcion());
    IDataSet ds = getDataSetCantConv();
    cargarRegistroCantConv(ds,new Integer(1),cantConv.doubleValue());
    writeCliente(ds);
  }

  private IDataSet getDataSetCantConv() {
    IDataSet dataset = new TDataSet();
    dataset.create("TCantConv");
    dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cant_conv", Field.CURRENCY, 0));
    return dataset;
  }

  private void cargarRegistroCantConv(IDataSet dataset,
                                      Integer oid,
                                      Double cantidad) {
    dataset.append();
    dataset.fieldValue("oid", oid);
    dataset.fieldValue("cant_conv", cantidad);
  }

}
