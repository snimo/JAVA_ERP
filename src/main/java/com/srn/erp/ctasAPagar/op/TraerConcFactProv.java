package com.srn.erp.ctasAPagar.op;

import java.util.Iterator;

import com.srn.erp.ctasAPagar.bm.ConcFactProv;
import com.srn.erp.ctasAPagar.bm.ConcFactProvImp;
import com.srn.erp.ctasAPagar.bm.EsqCuentaConcFactProv;
import com.srn.erp.impuestos.bm.ConceptoImpuesto;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerConcFactProv extends Operation {
	
  private String nombreTabla = null;

  public TraerConcFactProv() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    ConcFactProv concfactprov = null;

    
    if (mapaDatos.containsKey("nombreTabla"))
    	nombreTabla = mapaDatos.getString("nombreTabla");
    
    if (mapaDatos.containsKey("oid")) {
       Integer oid = mapaDatos.getInteger("oid");
       concfactprov = ConcFactProv.findByOid(oid, getSesion());
    }
    else {
       String codigo = mapaDatos.getString("codigo");
       concfactprov = ConcFactProv.findByCodigo(codigo, getSesion());
    }

    IDataSet datasetConcFactProv = getDataSetConcFactProv();
    IDataSet datasetConcFactProvImp = getDataSetConcFactProvImp();
    IDataSet datasetCtasConcFactProv = getDataSetCtasConcFactProv();

    if (concfactprov != null) {
        cargarRegistroConcFactProv(datasetConcFactProv,
                         concfactprov.getOIDInteger(),
                         concfactprov.getCodigo(),
                         concfactprov.getDescripcion(),
                         concfactprov.isActivo(),
                         concfactprov.getOrden(),
                         concfactprov.isRendicionFondoFijo(),
                         concfactprov.addCtasRendFF()
                         );

        Iterator iterConcFactProvImp =
            concfactprov.getConceptosImpuestos().iterator();
        while (iterConcFactProvImp.hasNext()) {
          ConcFactProvImp concFactProvImp =
              (ConcFactProvImp) iterConcFactProvImp.next();
          cargarRegistroConcFactProvImp(datasetConcFactProvImp,
                                        concFactProvImp.getOIDInteger(),
                                        concfactprov,
                                        concFactProvImp.getConcImpuesto(),
                                        concFactProvImp.isCalculaEnFact(),
                                        concFactProvImp.isCalculaEnOP(),
                                        concFactProvImp.isActivo());
        }
        
        Iterator iterCtasFactProvImp =
          concfactprov.getCuentasConcFactProv().iterator();
        while (iterCtasFactProvImp.hasNext()) {
        	EsqCuentaConcFactProv esqCtasConcFactProv =
            (EsqCuentaConcFactProv) iterCtasFactProvImp.next();
        	cargarRegistroCtasConcFactProv(datasetCtasConcFactProv,
        		esqCtasConcFactProv);
        }
        
        
        
    }
    
    writeCliente(datasetConcFactProv);
    writeCliente(datasetConcFactProvImp);
    writeCliente(datasetCtasConcFactProv);
    
  }

  private IDataSet getDataSetConcFactProv() {
    IDataSet dataset = new TDataSet();
    if (nombreTabla!=null)
    	dataset.create(nombreTabla);
    else
    	dataset.create("TConcFactProv");
    dataset.fieldDef(new Field("oid_conc_fact_prov", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 15));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("orden", Field.INTEGER, 0));
    dataset.fieldDef(new Field("es_rend_ff", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("add_ctas_rend_ff", Field.BOOLEAN, 0));
    return dataset;
  }

  private IDataSet getDataSetConcFactProvImp() {
    IDataSet dataset = new TDataSet();
    dataset.create("TConcFactProvImp");
    dataset.fieldDef(new Field("oid_conc_prov_imp", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_conc_fact_prov", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_conc_impu", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_conc_impu", Field.STRING, 15));
    dataset.fieldDef(new Field("desc_conc_impu", Field.STRING, 50));
    dataset.fieldDef(new Field("calcula_en_fact", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("calcula_en_op", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    return dataset;
  }
  
  private IDataSet getDataSetCtasConcFactProv() {
    IDataSet dataset = new TDataSet();
    dataset.create("TCtasConcFactProv");
    dataset.fieldDef(new Field("oid_cta_conc_fp", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_conc_fact_prov", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_ana_con", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_ana_con", Field.STRING, 100));
    dataset.fieldDef(new Field("desc_ana_con",Field.STRING, 255));
    dataset.fieldDef(new Field("activo",Field.BOOLEAN, 0));
    return dataset;
  }
  

  private void cargarRegistroConcFactProv(IDataSet dataset,
                         Integer oid_conc_fact_prov,
                         String codigo,
                         String descripcion,
                         Boolean activo,
                         Integer orden,
                         Boolean esRendFF,
                         Boolean addCtasRendFF) {
    dataset.append();
    dataset.fieldValue("oid_conc_fact_prov", oid_conc_fact_prov);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("activo", activo);
    dataset.fieldValue("orden", orden);
    dataset.fieldValue("es_rend_ff", esRendFF);
    dataset.fieldValue("add_ctas_rend_ff",addCtasRendFF);
  }

  private void cargarRegistroConcFactProvImp(IDataSet dataset,
                         Integer oid_conc_prov_imp,
                         ConcFactProv concFactProv,
                         ConceptoImpuesto conceptoImpuesto,
                         Boolean calcula_en_fact,
                         Boolean calcula_en_op,
                         Boolean activo) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid_conc_prov_imp", oid_conc_prov_imp);
    dataset.fieldValue("oid_conc_fact_prov", concFactProv.getOIDInteger());
    dataset.fieldValue("oid_conc_impu", conceptoImpuesto.getOID());
    dataset.fieldValue("cod_conc_impu", conceptoImpuesto.getCodigo());
    dataset.fieldValue("desc_conc_impu", conceptoImpuesto.getDescripcion());
    dataset.fieldValue("calcula_en_fact", calcula_en_fact);
    dataset.fieldValue("calcula_en_op", calcula_en_op);
    dataset.fieldValue("activo", activo);
  }
  
  private void cargarRegistroCtasConcFactProv(
  		IDataSet dataset,
  		EsqCuentaConcFactProv esqCuentaConcFactProv) throws BaseException {
  	dataset.append();
  	dataset.fieldValue("oid_cta_conc_fp", esqCuentaConcFactProv.getOIDInteger());
  	dataset.fieldValue("oid_conc_fact_prov", esqCuentaConcFactProv.getConc_fact_prov().getOIDInteger());
  	dataset.fieldValue("oid_ana_con",esqCuentaConcFactProv.getCuenta_contable().getOIDInteger());
  	dataset.fieldValue("cod_ana_con",esqCuentaConcFactProv.getCuenta_contable().getCodigo());
  	dataset.fieldValue("desc_ana_con",esqCuentaConcFactProv.getCuenta_contable().getDescripcion());
  	dataset.fieldValue("activo",new Boolean(true));
  }
  




}
