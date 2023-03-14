package com.srn.erp.impuestos.op;

import java.util.Iterator;

import com.srn.erp.contabilidad.bm.CuentaImputable;
import com.srn.erp.impuestos.bm.ConceptoImpuesto;
import com.srn.erp.impuestos.bm.Impuesto;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerConcImpuPercIBVtas extends Operation {

  private String nombreTabla = "";

  public TraerConcImpuPercIBVtas() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {

    nombreTabla = mapaDatos.getString("nombreTabla");
    IDataSet datasetConceptoImpuesto = getDataSetConceptosImpuestos();

    Iterator iterConcImpu =
        ConceptoImpuesto.getConcImpPercIBVtas(getSesion()).iterator();
    while (iterConcImpu.hasNext()) {
      ConceptoImpuesto conceptoImpuesto = (ConceptoImpuesto) iterConcImpu.next();
      cargarRegistroConceptoImpuesto(datasetConceptoImpuesto,
                                     conceptoImpuesto.getOIDInteger(),
                                     conceptoImpuesto.getCodigo(),
                                     conceptoImpuesto.getDescripcion(),
                                     conceptoImpuesto.getImpuesto(),
                                     conceptoImpuesto.getCuentaImputable(),
                                     conceptoImpuesto.isActivo());

    }

    writeCliente(datasetConceptoImpuesto);
  }

  private IDataSet getDataSetConceptosImpuestos() {
    IDataSet dataset = new TDataSet();
    dataset.create(nombreTabla);
    dataset.fieldDef(new Field("oid_conc_impu", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 15));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
    dataset.fieldDef(new Field("oid_impuesto", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_ai", Field.INTEGER, 0));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    return dataset;
  }


  private void cargarRegistroConceptoImpuesto(IDataSet dataset,
                         Integer oid_conc_impuesto,
                         String codigo,
                         String descripcion,
                         Impuesto impuesto,
                         CuentaImputable cuentaImputable,
                         Boolean activo) {
    dataset.append();
    dataset.fieldValue("oid_conc_impu", oid_conc_impuesto);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    if (impuesto!=null)
      dataset.fieldValue("oid_impuesto", impuesto.getOID());
    else
      dataset.fieldValue("oid_impuesto", 0);
    if (cuentaImputable!=null)
      dataset.fieldValue("oid_ai",cuentaImputable.getOIDInteger());
    else
      dataset.fieldValue("oid_ai",0);
    dataset.fieldValue("activo", activo);
  }


}
