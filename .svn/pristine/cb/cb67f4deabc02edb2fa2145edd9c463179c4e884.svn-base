package com.srn.erp.ctasAPagar.op;

import com.srn.erp.contabilidad.bm.Cuenta;
import com.srn.erp.ctasAPagar.bm.ConcFactProv;
import com.srn.erp.ctasAPagar.bm.ConcFactProvImp;
import com.srn.erp.ctasAPagar.bm.EsqCuentaConcFactProv;
import com.srn.erp.impuestos.bm.ConceptoImpuesto;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveConcFactProv extends Operation {

  public SaveConcFactProv() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet dataset = mapaDatos.getDataSet("TConcFactProv");
    procesarRegistros(dataset);
  }

  private void procesarRegistros(IDataSet dataset) throws BaseException {
    dataset.first();
      while (!dataset.EOF()) {
        ConcFactProv concfactprov = ConcFactProv.findByOid(dataset.getInteger("oid_conc_fact_prov"),getSesion());
        concfactprov.setOID(dataset.getInteger("oid_conc_fact_prov"));
        concfactprov.setCodigo(dataset.getString("codigo"));
        concfactprov.setDescripcion(dataset.getString("descripcion"));
        concfactprov.setActivo(dataset.getBoolean("activo"));
        concfactprov.setOrden(dataset.getInteger("orden"));
        concfactprov.setEsRendicionFondoFijo(dataset.getBoolean("es_rend_ff"));
        concfactprov.setAddCtasRendFF(dataset.getBoolean("add_ctas_rend_ff"));
        
        
        IDataSet dataSetConcFactProvImp = dataset.getDataSet("TConcFactProvImp");
        dataSetConcFactProvImp.first();
        while (!dataSetConcFactProvImp.EOF()) {
          ConcFactProvImp concFactProvImp =
              ConcFactProvImp.findByOid(
                 dataSetConcFactProvImp.getInteger("oid_conc_prov_imp"),getSesion());
          concFactProvImp.setConcFactProv(concfactprov);
          concFactProvImp.setConcImpuesto(ConceptoImpuesto.findByOidProxy(dataSetConcFactProvImp.getInteger("oid_conc_impu"),getSesion()));
          concFactProvImp.setCalculaEnFact(dataSetConcFactProvImp.getBoolean("calcula_en_fact"));
          concFactProvImp.setCalculaEnOP(dataSetConcFactProvImp.getBoolean("calcula_en_op"));
          concFactProvImp.setActivo(dataSetConcFactProvImp.getBoolean("activo"));
          concfactprov.addConceptoImpuesto(concFactProvImp);
          dataSetConcFactProvImp.next();
        }
        
        IDataSet dataSetCtasFactProv = dataset.getDataSet("TCtasConcFactProv");
        dataSetCtasFactProv.first();
        while (!dataSetCtasFactProv.EOF()) {
          EsqCuentaConcFactProv esqCtasConcFactProv =
          	EsqCuentaConcFactProv.findByOid(dataSetCtasFactProv.getInteger("oid_cta_conc_fp"),getSesion());
          esqCtasConcFactProv.setConc_fact_prov(concfactprov);
          esqCtasConcFactProv.setCuenta_contable(Cuenta.findByOidProxy(dataSetCtasFactProv.getInteger("oid_ana_con"),getSesion()));
          if (dataSetCtasFactProv.getBoolean("activo").booleanValue()==false)
          	esqCtasConcFactProv.delete();
          concfactprov.addCuentaConcFactProv(esqCtasConcFactProv);
          dataSetCtasFactProv.next();
        }
        
        
        
        addTransaccion(concfactprov);
        dataset.next();
    }
  }

}
