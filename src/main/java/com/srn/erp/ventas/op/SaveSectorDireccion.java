package com.srn.erp.ventas.op;

import com.srn.erp.ventas.bm.SectorDireccion;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveSectorDireccion extends Operation {

  public SaveSectorDireccion() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet dataset = mapaDatos.getDataSet("TSectorDireccion");
    procesarRegistros(dataset);
  }

  private void procesarRegistros(IDataSet dataset) throws BaseException {
    dataset.first();
      while (!dataset.EOF()) {
        SectorDireccion sectordireccion = SectorDireccion.findByOid(dataset.getInteger("oid_sector_dir"),getSesion());
        sectordireccion.setOID(dataset.getInteger("oid_sector_dir"));
        sectordireccion.setCodigo(dataset.getString("codigo"));
        sectordireccion.setDescripcion(dataset.getString("descripcion"));
        sectordireccion.setActivo(dataset.getBoolean("activo"));
        addTransaccion(sectordireccion);
        dataset.next();
    }
  }

}
