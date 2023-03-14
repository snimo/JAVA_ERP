package com.srn.erp.ventas.op;

import com.srn.erp.ventas.bm.SectorDireccion;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerSectorDireccion extends Operation {

  public TraerSectorDireccion() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    SectorDireccion sectordireccion = null;
    if (mapaDatos.containsKey("oid")) {
       Integer oid = mapaDatos.getInteger("oid");
       sectordireccion = SectorDireccion.findByOid(oid, getSesion());
    }
    else {
       String codigo = mapaDatos.getString("codigo");
       sectordireccion = SectorDireccion.findByCodigo(codigo, getSesion());
    }

    IDataSet datasetSectorDireccion = getDataSetSectorDireccion();
    if (sectordireccion != null) {
        cargarRegistroSectorDireccion(datasetSectorDireccion,
                         sectordireccion.getOIDInteger(),
                         sectordireccion.getCodigo(),
                         sectordireccion.getDescripcion(),
                         sectordireccion.isActivo());
    }
    writeCliente(datasetSectorDireccion);
  }

  private IDataSet getDataSetSectorDireccion() {
    IDataSet dataset = new TDataSet();
    dataset.create("TSectorDireccion");
    dataset.fieldDef(new Field("oid_sector_dir", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 20));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    return dataset;
  }

  private void cargarRegistroSectorDireccion(IDataSet dataset,
                         Integer oid_sector_dir,
                         String codigo,
                         String descripcion,
                         Boolean activo) {
    dataset.append();
    dataset.fieldValue("oid_sector_dir", oid_sector_dir);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("activo", activo);
  }
}
