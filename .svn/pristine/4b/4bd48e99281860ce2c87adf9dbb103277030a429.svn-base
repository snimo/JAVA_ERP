package com.srn.erp.compras.op;

import com.srn.erp.compras.bm.CondicionVenta;
import com.srn.erp.compras.bm.CondicionVentaDet;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveCondicionVenta extends Operation {

  public SaveCondicionVenta() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet dataset = mapaDatos.getDataSet("TCondicionVenta");
    procesarRegistros(dataset);
  }

  private void procesarRegistros(IDataSet dataset) throws BaseException {
    dataset.first();
      while (!dataset.EOF()) {
        CondicionVenta condicionVenta = CondicionVenta.findByOid(dataset.getInteger("oid_cond_venta"),getSesion());
        condicionVenta.setOID(dataset.getInteger("oid_cond_venta"));
        condicionVenta.setCodigo(dataset.getString("codigo"));
        condicionVenta.setDescripcion(dataset.getString("descripcion"));
        condicionVenta.setVtofijo(dataset.getBoolean("vto_fijo"));
        condicionVenta.setPorcDto(dataset.getPorcentaje("porc_dto"));
        condicionVenta.setPorcRecar(dataset.getPorcentaje("porc_recar"));
        condicionVenta.setActivo(dataset.getBoolean("activo"));
        IDataSet dataSetCondVentaDet = dataset.getDataSet("TCondicionVentaDet");
        dataSetCondVentaDet.first();
        while (!dataSetCondVentaDet.EOF()) {
          CondicionVentaDet condicionVentaDet = CondicionVentaDet.findByOid(dataSetCondVentaDet.getInteger("oid_cond_vta_det"),getSesion());
          condicionVentaDet.setCondicionVenta(condicionVenta);
          condicionVentaDet.setNrocuota(dataSetCondVentaDet.getInteger("nro_cuota"));
          condicionVentaDet.setCantidad(dataSetCondVentaDet.getInteger("cantidad"));
          condicionVentaDet.setUnidadvenc(dataSetCondVentaDet.getString("unidad_cuota_venc"));
          condicionVentaDet.setPorcentaje(dataSetCondVentaDet.getDouble("porc"));
          condicionVentaDet.setActivo(dataSetCondVentaDet.getBoolean("activo"));
          condicionVenta.addCondicionVentaDet(condicionVentaDet);
          dataSetCondVentaDet.next();
        }
        addTransaccion(condicionVenta);
        dataset.next();
    }
  }

}
