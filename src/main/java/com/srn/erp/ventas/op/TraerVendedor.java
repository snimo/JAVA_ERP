package com.srn.erp.ventas.op;

import com.srn.erp.ventas.bm.Vendedor;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerVendedor extends Operation {

  public TraerVendedor() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    Vendedor vendedor = null;
    if (mapaDatos.containsKey("oid")) {
       Integer oid = mapaDatos.getInteger("oid");
       vendedor = Vendedor.findByOid(oid, getSesion());
    }
    else {
       String codigo = mapaDatos.getString("codigo");
       vendedor = Vendedor.findByCodigo(codigo, getSesion());
    }

    IDataSet datasetVendedor = getDataSetVendedor();
    if (vendedor != null) {
        cargarRegistroVendedor(datasetVendedor,
                         vendedor.getOIDInteger(),
                         vendedor.getCodigo(),
                         vendedor.getApellido(),
                         vendedor.getNombre(),
                         vendedor.isActivo(),
                         vendedor.getMail(),
                         vendedor.getTelefono());
    }
    writeCliente(datasetVendedor);
  }

  private IDataSet getDataSetVendedor() {
    IDataSet dataset = new TDataSet();
    dataset.create("TVendedor");
    dataset.fieldDef(new Field("oid_vendedor", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 20));
    dataset.fieldDef(new Field("apellido", Field.STRING, 20));
    dataset.fieldDef(new Field("nombre", Field.STRING, 20));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("mail", Field.STRING, 100));
    dataset.fieldDef(new Field("telefono", Field.STRING, 100));
    return dataset;
  }

  private void cargarRegistroVendedor(IDataSet dataset,
                         Integer oid_vendedor,
                         String codigo,
                         String apellido,
                         String nombre,
                         Boolean activo,
                         String mail,
                         String telefono) {
    dataset.append();
    dataset.fieldValue("oid_vendedor", oid_vendedor);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("apellido", apellido);
    dataset.fieldValue("nombre", nombre);
    dataset.fieldValue("activo", activo);
    dataset.fieldValue("mail", mail);
    dataset.fieldValue("telefono", telefono);
    
  }
}
