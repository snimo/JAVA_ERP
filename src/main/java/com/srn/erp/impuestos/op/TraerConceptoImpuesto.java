package com.srn.erp.impuestos.op;

import java.util.Date;
import java.util.Iterator;

import com.srn.erp.contabilidad.bm.CuentaImputable;
import com.srn.erp.general.bm.Provincia;
import com.srn.erp.impuestos.bm.ColumnaLibroIVA;
import com.srn.erp.impuestos.bm.ConceptoImpuesto;
import com.srn.erp.impuestos.bm.Impuesto;
import com.srn.erp.impuestos.bm.TasaIVA;
import com.srn.erp.impuestos.bm.TasaImpInt;
import com.srn.erp.impuestos.bm.TasaPercIB;
import com.srn.erp.impuestos.bm.TasaPercIVA;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerConceptoImpuesto extends Operation {

  public TraerConceptoImpuesto() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    ConceptoImpuesto conceptoimpuesto = null;
    if (mapaDatos.containsKey("oid")) {
      Integer oid = mapaDatos.getInteger("oid");
      conceptoimpuesto = ConceptoImpuesto.findByOid(oid, getSesion());
    }
    else {
      String codigo = mapaDatos.getString("codigo");
      conceptoimpuesto = ConceptoImpuesto.findByCodigo(codigo, getSesion());
    }

    IDataSet datasetConceptoImpuesto = getDataSetConceptoImpuesto();
    IDataSet datasetTasasIVA = getDataSetTasasIVA();
    IDataSet datasetTasasPercIVA = getDataSetTasasPercIVA();
    IDataSet datasetTasasPercIB = getDataSetTasasPercIB();
    IDataSet datasetTasasImpInt = getDataSetTasasImpInt();


    if (conceptoimpuesto != null) {

      cargarRegistroConceptoImpuesto(datasetConceptoImpuesto,
                                     conceptoimpuesto.getOIDInteger(),
                                     conceptoimpuesto.getCodigo(),
                                     conceptoimpuesto.getDescripcion(),
                                     conceptoimpuesto.getImpuesto(),
                                     conceptoimpuesto.getColumnalibroiva(),
                                     conceptoimpuesto.getRegimen(),
                                     conceptoimpuesto.getCuentaImputable(),
                                     conceptoimpuesto.isActivo(),
                                     conceptoimpuesto.getProvincia(),
                                     conceptoimpuesto.getBaseImponible(),
                                     conceptoimpuesto.getImpuestoMinimo(),
                                     conceptoimpuesto.getColImpreCompro(),
                                     conceptoimpuesto.getCodigoAfip()
                                     );

      Iterator iterTasasIVA = conceptoimpuesto.getTasasIVA().iterator();
      while (iterTasasIVA.hasNext()) {
        TasaIVA tasaIVA = (TasaIVA) iterTasasIVA.next();
        cargarRegistroTasaIVA(datasetTasasIVA,
                              tasaIVA.getOIDInteger(),
                              tasaIVA.getConcimpuesto().getOIDInteger(),
                              tasaIVA.getFechavigencia(),
                              tasaIVA.getPorcentaje().doubleValue(),
                              tasaIVA.isActivo()
                              );
      }

      Iterator iterTasasPercIVA = conceptoimpuesto.getTasasPercIVA().iterator();
      while (iterTasasPercIVA.hasNext()) {
        TasaPercIVA tasaPercIVA = (TasaPercIVA) iterTasasPercIVA.next();
        cargarRegistroTasaPercIVA(datasetTasasPercIVA,
                                  tasaPercIVA.getOIDInteger(),
                                  tasaPercIVA.getConcimpuesto().getOIDInteger(),
                                  tasaPercIVA.getFechavigencia(),
                                  tasaPercIVA.getPorcentaje().doubleValue(),
                                  tasaPercIVA.isActivo()
                                  );
      }

      Iterator iterTasasPercIB = conceptoimpuesto.getTasasPercIB().iterator();
      while (iterTasasPercIB.hasNext()) {
          TasaPercIB tasaPercIB = (TasaPercIB) iterTasasPercIB.next();
          cargarRegistroTasaPercIB(datasetTasasPercIB,
                                   tasaPercIB.getOIDInteger(),
                                   tasaPercIB.getConceptoImpuesto().getOIDInteger(),
                                   tasaPercIB.getFecVigencia(),
                                   tasaPercIB.getPorc().doubleValue(),
                                   tasaPercIB.getProvincia().getOIDInteger(),
                                   tasaPercIB.getMontoMinimo().doubleValue(),
                                   tasaPercIB.getCategIB().getOIDInteger(),
                                   tasaPercIB.isActivo(),
                                   tasaPercIB.getCuentaImputable());
        }

        Iterator iterTasasImpInt = conceptoimpuesto.getTasasImpInt().iterator();
        while (iterTasasImpInt.hasNext()) {
            TasaImpInt tasaImpInt = (TasaImpInt) iterTasasImpInt.next();
            cargarRegistroTasaImpInt(datasetTasasImpInt,
                                     tasaImpInt.getOIDInteger(),
                                     tasaImpInt.getConceptoimpuesto().getOIDInteger(),
                                     tasaImpInt.getFecvigencia(),
                                     tasaImpInt.getPorc().doubleValue(),
                                     tasaImpInt.getMontominimo().doubleValue(),
                                     tasaImpInt.isActivo());
          }


        writeCliente(datasetConceptoImpuesto);
        writeCliente(datasetTasasIVA);
        writeCliente(datasetTasasPercIVA);
        writeCliente(datasetTasasPercIB);
        writeCliente(datasetTasasImpInt);
      }
  }

  private IDataSet getDataSetConceptoImpuesto() {
    IDataSet dataset = new TDataSet();
    dataset.create("TConceptoImpuesto");
    dataset.fieldDef(new Field("oid_conc_impu", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 15));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 30));
    dataset.fieldDef(new Field("oid_impuesto", Field.STRING, 0));
    dataset.fieldDef(new Field("oid_col_libro_iva", Field.STRING, 0));
    dataset.fieldDef(new Field("regimen", Field.STRING, 20));
    dataset.fieldDef(new Field("oid_ai",Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo_ai",Field.STRING,30));
    dataset.fieldDef(new Field("desc_ai",Field.STRING,100));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));    
    dataset.fieldDef(new Field("oid_provincia", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_provincia", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_provincia", Field.STRING, 100));
    dataset.fieldDef(new Field("base_imponible", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("impuesto_minimo", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("col_impre_compro", Field.STRING, 20));
    dataset.fieldDef(new Field("codigo_afip", Field.INTEGER, 0));
    
    return dataset;
  }

  private void cargarRegistroConceptoImpuesto(IDataSet dataset,
                         Integer oid_conc_impu,
                         String codigo,
                         String descripcion,
                         Impuesto impuesto,
                         ColumnaLibroIVA columnaLibroIVA,
                         String regimen,
                         CuentaImputable cuentaImputable,
                         Boolean activo,
                         Provincia provincia,
                         Money baseImponible,
                         Money impuestoMinimo,
                         String colImpreCompro,
                         Integer codigoAfip) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid_conc_impu", oid_conc_impu);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("oid_impuesto", impuesto.getOID());
    if (columnaLibroIVA == null)
      dataset.fieldValue("oid_col_libro_iva", 0);
    else
      dataset.fieldValue("oid_col_libro_iva", columnaLibroIVA.getOID());
    dataset.fieldValue("regimen", regimen);
    if (cuentaImputable!=null) {
      dataset.fieldValue("oid_ai", cuentaImputable.getOID());
      dataset.fieldValue("codigo_ai", cuentaImputable.getCodigoCuentaMasCodigosValCompo());
      dataset.fieldValue("desc_ai", cuentaImputable.getDescCuentaMasDescValCompo());
    }
    else {
      dataset.fieldValue("oid_ai", 0);
      dataset.fieldValue("codigo_ai", "");
      dataset.fieldValue("desc_ai", "");
    }
    dataset.fieldValue("activo", activo);
    
    if (provincia!=null) {
      dataset.fieldValue("oid_provincia", provincia.getOIDInteger());
      dataset.fieldValue("cod_provincia", provincia.getCodigo());
      dataset.fieldValue("desc_provincia", provincia.getDescripcion());
    } else {
      dataset.fieldValue("oid_provincia", new Integer(0));
      dataset.fieldValue("cod_provincia", "");
      dataset.fieldValue("desc_provincia", "");
    }
    dataset.fieldValue("base_imponible", baseImponible);
    dataset.fieldValue("impuesto_minimo", impuestoMinimo);
    dataset.fieldValue("col_impre_compro", colImpreCompro);
    dataset.fieldValue("codigo_afip", codigoAfip);
    
  }

  private IDataSet getDataSetTasasIVA() {
    IDataSet dataset = new TDataSet();
    dataset.create("TTasasIVA");
    dataset.fieldDef(new Field("oid_tasa_iva", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_conc_impu", Field.INTEGER, 0));
    dataset.fieldDef(new Field("fec_vigencia",Field.STRING, 10));
    dataset.fieldDef(new Field("porc",Field.CURRENCY, 0));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    return dataset;
  }

  private void cargarRegistroTasaIVA(IDataSet dataset,
                         Integer oidTasaIVA,
                         Integer oidConcImpu,
                         Date fecVigencia,
                         double porc,
                         Boolean activo) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid_tasa_iva", oidTasaIVA);
    dataset.fieldValue("oid_conc_impu", oidConcImpu);
    dataset.fieldValue("fec_vigencia", Fecha.getddmmyyyy(fecVigencia));
    dataset.fieldValue("porc", porc);
    dataset.fieldValue("activo", activo);
  }

  private IDataSet getDataSetTasasPercIVA() {
    IDataSet dataset = new TDataSet();
    dataset.create("TTasasPercIVA");
    dataset.fieldDef(new Field("oid_tasa_perc_iva", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_conc_impu", Field.INTEGER, 0));
    dataset.fieldDef(new Field("fec_vigencia",Field.STRING, 10));
    dataset.fieldDef(new Field("porc",Field.CURRENCY, 0));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    return dataset;
  }

  private void cargarRegistroTasaPercIVA(IDataSet dataset,
                         Integer oidTasaPercIVA,
                         Integer oidConcImpu,
                         Date fecVigencia,
                         double porc,
                         Boolean activo) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid_tasa_perc_iva", oidTasaPercIVA);
    dataset.fieldValue("oid_conc_impu", oidConcImpu);
    dataset.fieldValue("fec_vigencia", Fecha.getddmmyyyy(fecVigencia));
    dataset.fieldValue("porc", porc);
    dataset.fieldValue("activo", activo);
  }

  private IDataSet getDataSetTasasPercIB() {
    IDataSet dataset = new TDataSet();
    dataset.create("TTasasPercIB");
    dataset.fieldDef(new Field("oid_tasa_perc_ib", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_conc_impu", Field.INTEGER, 0));
    dataset.fieldDef(new Field("fec_vigencia",Field.STRING, 10));
    dataset.fieldDef(new Field("porc",Field.CURRENCY, 0));
    dataset.fieldDef(new Field("oid_provincia", Field.INTEGER, 0));
    dataset.fieldDef(new Field("monto_minimo",Field.CURRENCY, 0));
    dataset.fieldDef(new Field("oid_cat_ib", Field.INTEGER, 0));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("oid_ai", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_ai", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_ai", Field.STRING, 100));
    return dataset;
  }

  private void cargarRegistroTasaPercIB(IDataSet dataset,
                         Integer oidTasaPercIB,
                         Integer oidConcImpu,
                         Date fecVigencia,
                         double porc,
                         Integer oidProvincia,
                         double montoMinimo,
                         Integer oidCatIB,
                         Boolean activo,
                         CuentaImputable cuentaImputable) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid_tasa_perc_ib", oidTasaPercIB);
    dataset.fieldValue("oid_conc_impu", oidConcImpu);
    dataset.fieldValue("fec_vigencia", Fecha.getddmmyyyy(fecVigencia));
    dataset.fieldValue("porc", porc);
    dataset.fieldValue("oid_provincia",oidProvincia);
    dataset.fieldValue("monto_minimo",montoMinimo);
    dataset.fieldValue("oid_cat_ib",oidCatIB);
    dataset.fieldValue("activo", activo);
    if (cuentaImputable!=null) {
      dataset.fieldValue("oid_ai", cuentaImputable.getOIDInteger());
      dataset.fieldValue("cod_ai", cuentaImputable.getCodigoCuentaMasCodigosValCompo());
      dataset.fieldValue("desc_ai", cuentaImputable.getDescCuentaMasDescValCompo());
    } else {
      dataset.fieldValue("oid_ai", 0);
      dataset.fieldValue("cod_ai", "");
      dataset.fieldValue("desc_ai", "");
    }
  }

  private IDataSet getDataSetTasasImpInt() {
    IDataSet dataset = new TDataSet();
    dataset.create("TTasasImpInt");
    dataset.fieldDef(new Field("oid_imp_int", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_conc_impu", Field.INTEGER, 0));
    dataset.fieldDef(new Field("fec_vigencia",Field.STRING, 10));
    dataset.fieldDef(new Field("porc",Field.CURRENCY, 0));
    dataset.fieldDef(new Field("monto_minimo",Field.CURRENCY, 0));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    return dataset;
  }

  private void cargarRegistroTasaImpInt(IDataSet dataset,
                         Integer oidImpInt,
                         Integer oidConcImpu,
                         Date fecVigencia,
                         double porc,
                         double montoMinimo,
                         Boolean activo) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid_imp_int", oidImpInt);
    dataset.fieldValue("oid_conc_impu", oidConcImpu);
    dataset.fieldValue("fec_vigencia", Fecha.getddmmyyyy(fecVigencia));
    dataset.fieldValue("porc", porc);
    dataset.fieldValue("monto_minimo",montoMinimo);
    dataset.fieldValue("activo", activo);
  }







}
