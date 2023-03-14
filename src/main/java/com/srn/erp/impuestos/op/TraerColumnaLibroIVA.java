package com.srn.erp.impuestos.op;

import com.srn.erp.impuestos.bm.ColumnaLibroIVA;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerColumnaLibroIVA extends Operation {

  public TraerColumnaLibroIVA() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    ColumnaLibroIVA columnalibroiva = null;
    if (mapaDatos.containsKey("oid")) {
       Integer oid = mapaDatos.getInteger("oid");
       columnalibroiva = ColumnaLibroIVA.findByOid(oid, getSesion());
    }
    else {
       String codigo = mapaDatos.getString("codigo");
       columnalibroiva = ColumnaLibroIVA.findByCodigo(codigo, getSesion());
    }

    IDataSet datasetColumnaLibroIVA = getDataSetColumnaLibroIVA();
    if (columnalibroiva != null) {
        cargarRegistroColumnaLibroIVA(datasetColumnaLibroIVA,
                         columnalibroiva.getOIDInteger(),
                         columnalibroiva.getCodigo(),
                         columnalibroiva.getDescripcion(),
                         columnalibroiva.getColumna(),
                         columnalibroiva.isActivo(),
                         columnalibroiva.isUsarIVAVentas(),
                         columnalibroiva.isUsarIVACompras()
                         );
    }
    writeCliente(datasetColumnaLibroIVA);
  }

  private IDataSet getDataSetColumnaLibroIVA() {
    IDataSet dataset = new TDataSet();
    dataset.create("TColumnaLibroIVA");
    dataset.fieldDef(new Field("oid_col_libro_iva", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 15));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 30));
    dataset.fieldDef(new Field("columna", Field.INTEGER, 0));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("usar_iva_vtas", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("usar_iva_cpras", Field.BOOLEAN, 0));    
    return dataset;
  }

  private void cargarRegistroColumnaLibroIVA(IDataSet dataset,
                         Integer oid_col_libro_iva,
                         String codigo,
                         String descripcion,
                         Integer columna,
                         Boolean activo,
                         Boolean usarIVAVtas,
                         Boolean usarIVACpras) {
    dataset.append();
    dataset.fieldValue("oid_col_libro_iva", oid_col_libro_iva);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("columna", columna);
    dataset.fieldValue("activo", activo);
    dataset.fieldValue("usar_iva_vtas", usarIVAVtas);
    dataset.fieldValue("usar_iva_cpras", usarIVACpras);    
    
  }
}
