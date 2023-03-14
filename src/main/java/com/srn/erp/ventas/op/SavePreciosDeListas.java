package com.srn.erp.ventas.op;

import java.util.Date;

import com.srn.erp.general.bm.Moneda;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.bm.UnidadMedida;
import com.srn.erp.ventas.bm.ListaPrecios;
import com.srn.erp.ventas.bm.ListaPreciosDet;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SavePreciosDeListas extends Operation {

  public SavePreciosDeListas() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {

    IDataSet dataset  = mapaDatos.getDataSet("TInput");
    dataset.first();
    Producto producto =
        Producto.findByOid(dataset.getInteger("oid_producto"),
                           getSesion());

    IDataSet preciosLista = dataset.getDataSet("TPreciosLista");
    preciosLista.first();
    while (!preciosLista.EOF()) {
      ListaPreciosDet preciosListaDet =
          ListaPreciosDet.findByOid(preciosLista.getInteger("oid_precio_det"),
                                    getSesion());
      if (preciosLista.getMoney("precio").doubleValue()>0) {
        ListaPrecios listaPrecios =
            ListaPrecios.findByOidProxy(preciosLista.getInteger("oid_precio_cab"),
                                        getSesion());
        preciosListaDet.setLista_precio(listaPrecios);
        preciosListaDet.setProducto(producto);
        preciosListaDet.setUnidad_medida(UnidadMedida.findByOidProxy(preciosLista.getInteger("oid_um"),getSesion()));
        preciosListaDet.setCantidad(preciosLista.getDouble("cantidad"));
        preciosListaDet.setMoneda(Moneda.findByOidProxy(preciosLista.getInteger("oid_moneda"),getSesion()));
        preciosListaDet.setPrecio(preciosLista.getMoney("precio"));
        preciosListaDet.setActivo(new Boolean(true));
        preciosListaDet.setFecUltAct(Fecha.getFechaActual());
        addTransaccion(preciosListaDet);
      }
      else {
        preciosListaDet.delete();
        addTransaccion(preciosListaDet);
      }

      preciosLista.next();
    }


  }

}
