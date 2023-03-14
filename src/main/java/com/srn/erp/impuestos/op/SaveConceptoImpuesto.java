package com.srn.erp.impuestos.op;

import com.srn.erp.contabilidad.bm.CuentaImputable;
import com.srn.erp.general.bm.Provincia;
import com.srn.erp.impuestos.bm.CategoriaIB;
import com.srn.erp.impuestos.bm.ColumnaLibroIVA;
import com.srn.erp.impuestos.bm.ConceptoImpuesto;
import com.srn.erp.impuestos.bm.Impuesto;
import com.srn.erp.impuestos.bm.TasaIVA;
import com.srn.erp.impuestos.bm.TasaImpInt;
import com.srn.erp.impuestos.bm.TasaPercIB;
import com.srn.erp.impuestos.bm.TasaPercIVA;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveConceptoImpuesto extends Operation {

  public SaveConceptoImpuesto() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet dataset = mapaDatos.getDataSet("TConceptoImpuesto");
    procesarRegistros(dataset);
  }

  private void procesarRegistros(IDataSet dataset) throws BaseException {
    dataset.first();
      while (!dataset.EOF()) {
        ConceptoImpuesto conceptoimpuesto = ConceptoImpuesto.findByOid(dataset.getInteger("oid_conc_impu"),getSesion());
        conceptoimpuesto.setOID(dataset.getInteger("oid_conc_impu"));
        conceptoimpuesto.setCodigo(dataset.getString("codigo"));
        conceptoimpuesto.setDescripcion(dataset.getString("descripcion"));
        conceptoimpuesto.setImpuesto(Impuesto.findByOidProxy(dataset.getInteger("oid_impuesto"),getSesion()));
        conceptoimpuesto.setColumnalibroiva(ColumnaLibroIVA.findByOidProxy(dataset.getInteger("oid_col_libro_iva"),getSesion()));
        conceptoimpuesto.setRegimen(dataset.getString("regimen"));
        conceptoimpuesto.setCuentaImputable(CuentaImputable.findByOidProxy(dataset.getInteger("oid_ai"),getSesion()));
        conceptoimpuesto.setProvincia(Provincia.findByOidProxy(dataset.getInteger("oid_provincia"),getSesion()));
        conceptoimpuesto.setActivo(dataset.getBoolean("activo"));
        conceptoimpuesto.setBaseImponible(dataset.getMoney("base_imponible"));
        conceptoimpuesto.setImpuestoMinimo(dataset.getMoney("impuesto_minimo"));
        conceptoimpuesto.setColImpreCompro(dataset.getString("col_impre_compro"));
        conceptoimpuesto.setCodigoAfip(dataset.getInteger("codigo_afip"));
        
        addTransaccion(conceptoimpuesto);

        IDataSet dataSetTasasIVA = dataset.getDataSet("TTasasIVA");
        dataSetTasasIVA.first();
        while (!dataSetTasasIVA.EOF()) {
          TasaIVA tasaIVA = TasaIVA.findByOid(dataSetTasasIVA.getInteger(
              "oid_tasa_iva"),
             getSesion());
          tasaIVA.setConcimpuesto(conceptoimpuesto);
          tasaIVA.setFechavigencia(dataSetTasasIVA.getDate("fec_vigencia"));
          tasaIVA.setPorcentaje(dataSetTasasIVA.getDouble("porc"));
          tasaIVA.setActivo(dataSetTasasIVA.getBoolean("activo"));
          conceptoimpuesto.addTasaIVA(tasaIVA);
          dataSetTasasIVA.next();
        }

        IDataSet dataSetTasasPercIVA = dataset.getDataSet("TTasasPercIVA");
        dataSetTasasPercIVA.first();
        while (!dataSetTasasPercIVA.EOF()) {
          TasaPercIVA tasaPercIVA = TasaPercIVA.findByOid(dataSetTasasPercIVA.getInteger(
              "oid_tasa_perc_iva"),
             getSesion());
          tasaPercIVA.setConcimpuesto(conceptoimpuesto);
          tasaPercIVA.setFechavigencia(dataSetTasasPercIVA.getDate("fec_vigencia"));
          tasaPercIVA.setPorcentaje(dataSetTasasPercIVA.getDouble("porc"));
          tasaPercIVA.setActivo(dataSetTasasPercIVA.getBoolean("activo"));
          conceptoimpuesto.addTasaPercIVA(tasaPercIVA);
          dataSetTasasPercIVA.next();
        }

        IDataSet dataSetTasasPercIB = dataset.getDataSet("TTasaPercIB");
        dataSetTasasPercIB.first();
        while (!dataSetTasasPercIB.EOF()) {
          TasaPercIB tasaPercIB = TasaPercIB.findByOid(dataSetTasasPercIB.getInteger(
              "oid_tasa_perc_ib"),
             getSesion());
          tasaPercIB.setConceptoImpuesto(conceptoimpuesto);
          tasaPercIB.setFecVigencia(dataSetTasasPercIB.getDate("fec_vigencia"));
          tasaPercIB.setPorc(dataSetTasasPercIB.getDouble("porc"));
          tasaPercIB.setProvincia(
                 Provincia.findByOidProxy(dataSetTasasPercIB.getInteger("oid_provincia"),
                                          getSesion()));
          tasaPercIB.setMontoMinimo(dataSetTasasPercIB.getDouble("monto_minimo"));
          tasaPercIB.setCategIB(
                 CategoriaIB.findByOidProxy(dataSetTasasPercIB.getInteger("oid_cat_ib"),
                                          getSesion()));
          tasaPercIB.setCuentaImputable(
                  CuentaImputable.findByOidProxy(dataSetTasasPercIB.getInteger("oid_ai"),
                                           getSesion()));
          
          tasaPercIB.setActivo(dataSetTasasPercIB.getBoolean("activo"));
          conceptoimpuesto.addTasaPercIB(tasaPercIB);
          dataSetTasasPercIB.next();
        }

        IDataSet dataSetTasasImpInt = dataset.getDataSet("TTasasImpInt");
        dataSetTasasImpInt.first();
        while (!dataSetTasasImpInt.EOF()) {
          TasaImpInt tasaImpInt = TasaImpInt.findByOid(dataSetTasasImpInt.getInteger(
              "oid_imp_int"),
             getSesion());
          tasaImpInt.setConceptoimpuesto(conceptoimpuesto);
          tasaImpInt.setFecvigencia(dataSetTasasImpInt.getDate("fec_vigencia"));
          tasaImpInt.setPorc(dataSetTasasImpInt.getDouble("porc"));
          tasaImpInt.setMontominimo(dataSetTasasImpInt.getDouble("monto_minimo"));
          tasaImpInt.setActivo(dataSetTasasImpInt.getBoolean("activo"));
          conceptoimpuesto.addTasaImpInt(tasaImpInt);
          dataSetTasasImpInt.next();
        }
        dataset.next();
    }
  }

}
