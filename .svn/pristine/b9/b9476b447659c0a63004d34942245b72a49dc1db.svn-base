package com.srn.erp.stock.op;

import com.srn.erp.stock.bm.Deposito;
import com.srn.erp.stock.bm.ProdHabUbiDepo;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.bm.Transporte;
import com.srn.erp.stock.bm.UbicacionDeposito;
import com.srn.erp.ventas.bm.Sujeto;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveUbicacionDeposito extends Operation {

  public SaveUbicacionDeposito() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet dataset = mapaDatos.getDataSet("TDeposito");
    dataset.first();
    if (dataset.EOF()) return;
    setRefreshObjNeg(dataset.getInteger("oid_deposito"));
    procesarRegistros(dataset);
  }

  private void procesarRegistros(IDataSet dataset) throws BaseException {
    IDataSet datasetUbiDepo = dataset.getDataSet("TUbicacionDeposito");
    if (datasetUbiDepo == null) return;
    datasetUbiDepo.first();
      while (!datasetUbiDepo.EOF()) {
        UbicacionDeposito ubicaciondeposito = UbicacionDeposito.findByOid(datasetUbiDepo.getInteger("oid_ubi_depo"),getSesion());
        ubicaciondeposito.setOID(datasetUbiDepo.getInteger("oid_ubi_depo"));
        ubicaciondeposito.setCodigo(datasetUbiDepo.getString("codigo"));
        ubicaciondeposito.setOid(datasetUbiDepo.getInteger("oid"));
        ubicaciondeposito.setDescripcion(datasetUbiDepo.getString("descripcion"));
        ubicaciondeposito.setDeposito(Deposito.findByOid(datasetUbiDepo.getInteger("oid_deposito"),getSesion()));
        ubicaciondeposito.setOid_padre(datasetUbiDepo.getInteger("oid_padre"));
        ubicaciondeposito.setSecu(datasetUbiDepo.getInteger("secu"));
        ubicaciondeposito.setSolo_sku_habi(datasetUbiDepo.getBoolean("solo_sku_habi"));
        ubicaciondeposito.setSujeto(Sujeto.findByOid(datasetUbiDepo.getInteger("oid_sujeto"),getSesion()));
        ubicaciondeposito.setTransporte(Transporte.findByOid(datasetUbiDepo.getInteger("oid_transporte"),getSesion()));
        ubicaciondeposito.setDeposito_destino(Deposito.findByOid(datasetUbiDepo.getInteger("oid_depo_dest"),getSesion()));
        ubicaciondeposito.setAllow_almacenar(datasetUbiDepo.getBoolean("allow_almacenar"));
        ubicaciondeposito.setTipo(datasetUbiDepo.getString("tipo"));
        ubicaciondeposito.setActivo(datasetUbiDepo.getBoolean("activo"));
        ubicaciondeposito.setEsUbicacionPorDefecto(datasetUbiDepo.getBoolean("ubi_default"));

        IDataSet dsProdHab = datasetUbiDepo.getDataSet("TProductosHabilitados");
        dsProdHab.first();
        while (!dsProdHab.EOF()) {
          ProdHabUbiDepo prodHab = ProdHabUbiDepo.findByOid(dsProdHab.getInteger("oid_um_ubi_depo"),getSesion());
          prodHab.setUbicacion_deposito(ubicaciondeposito);
          prodHab.setProducto(Producto.findByOid(dsProdHab.getInteger("oid_producto"),getSesion()));
          if (dsProdHab.getBoolean("activo").booleanValue()==false) prodHab.delete();
          ubicaciondeposito.addProductoHabilitado(prodHab);
          dsProdHab.next();
        }


        addTransaccion(ubicaciondeposito);
        datasetUbiDepo.next();
    }
  }

}
