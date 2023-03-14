package com.srn.erp.compras.op;

import com.srn.erp.compras.bm.CondicionCompra;
import com.srn.erp.compras.bm.CondicionCompraDet;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveCondicionCompra extends Operation {

  public SaveCondicionCompra() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet dataset = mapaDatos.getDataSet("TCondicionCompra");
    procesarRegistros(dataset);
  }

  private void procesarRegistros(IDataSet dataset) throws BaseException {
    dataset.first();
      while (!dataset.EOF()) {
        CondicionCompra condicioncompra = CondicionCompra.findByOid(dataset.getInteger("oid_cond_compra"),getSesion());
        condicioncompra.setOID(dataset.getInteger("oid_cond_compra"));
        condicioncompra.setCodigo(dataset.getString("codigo"));
        condicioncompra.setDescripcion(dataset.getString("descripcion"));
        condicioncompra.setVtofijo(dataset.getBoolean("vto_fijo"));
        condicioncompra.setActivo(dataset.getBoolean("activo"));
        IDataSet dataSetCondCompraDet = dataset.getDataSet("TCondicionCompraDet");
        dataSetCondCompraDet.first();
        while (!dataSetCondCompraDet.EOF()) {
          CondicionCompraDet condicioncompraDet = CondicionCompraDet.findByOid(dataSetCondCompraDet.getInteger("oid_cond_cp_det"),getSesion());
          condicioncompraDet.setCondicioncompra(condicioncompra);
          condicioncompraDet.setNrocuota(dataSetCondCompraDet.getInteger("nro_cuota"));
          condicioncompraDet.setCantidad(dataSetCondCompraDet.getInteger("cantidad"));
          condicioncompraDet.setUnidadvenc(dataSetCondCompraDet.getString("unidad_cuota_venc"));
          condicioncompraDet.setPorcentaje(dataSetCondCompraDet.getDouble("porc"));
          condicioncompraDet.setActivo(dataSetCondCompraDet.getBoolean("activo"));
          condicioncompra.addCondicionCompraDet(condicioncompraDet);
          dataSetCondCompraDet.next();
        }
        addTransaccion(condicioncompra);
        dataset.next();
    }
  }

}
