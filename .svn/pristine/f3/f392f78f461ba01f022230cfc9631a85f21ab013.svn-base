package com.srn.erp.ctasAPagar.op;

import java.util.Hashtable;
import java.util.Iterator;

import com.srn.erp.ctasAPagar.bm.ConcFactProv;
import com.srn.erp.ctasAPagar.bm.ConcFactProvImp;
import com.srn.erp.impuestos.bm.Impuesto;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerDetallesFactProv extends Operation {

  public TraerDetallesFactProv() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    ConcFactProv concfactprov = null;

    int oid = 0;
    Hashtable impuestos = new Hashtable();

    IDataSet datasetDetallesFactProv = getDataSetDetallesFactProv();
    Iterator iterConcFactProv =
        ConcFactProv.getConceptosFactProv(getSesion()).iterator();
    while (iterConcFactProv.hasNext()) {
      ConcFactProv concFactProv = (ConcFactProv) iterConcFactProv.next();
      impuestos.clear();
      Iterator iterConcImpuestos =
          concFactProv.getConceptosImpuestos().iterator();
      while (iterConcImpuestos.hasNext()) {
        ConcFactProvImp
         concFactProvImp =
            (ConcFactProvImp) iterConcImpuestos.next();
        if (concFactProvImp.isActivo().booleanValue())
           impuestos.put(concFactProvImp.getConcImpuesto().getImpuesto().getCompo(),
                         concFactProvImp);
      }
      
      
      // Traer el concepto por Defecto
      ConcFactProvImp concPercIB = (ConcFactProvImp)impuestos.get(Impuesto.CODIGO_PERC_IB_C);
      if (concPercIB == null)
    	  concPercIB = (ConcFactProvImp)impuestos.get(Impuesto.CODIGO_PERC_IB_C);
      
      cargarRegistroDetalleFactProv(datasetDetallesFactProv,
                                    new Integer(++oid),
                                    concFactProv,
                                    (ConcFactProvImp)impuestos.get(Impuesto.CODIGO_IVA_C),
                                    (ConcFactProvImp)impuestos.get(Impuesto.CODIGO_PERC_IVA_C),
                                    concPercIB,
                                    (ConcFactProvImp)impuestos.get(Impuesto.CODIGO_IMP_INT_C),
                                    (ConcFactProvImp)impuestos.get(Impuesto.CODIGO_RET_IVA),
                                    (ConcFactProvImp)impuestos.get(Impuesto.CODIGO_RET_GAN),
                                    (ConcFactProvImp)impuestos.get(Impuesto.CODIGO_RET_IB));

    }


    writeCliente(datasetDetallesFactProv);
  }

  private IDataSet getDataSetDetallesFactProv() {
    IDataSet dataset = new TDataSet();
    dataset.create("TConceptosCompro");
    dataset.fieldDef(new Field("oid",Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_conc_fact_prov", Field.INTEGER, 0));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("orden", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_conc_imp_iva", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_conc_imp_perc_iva", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_conc_imp_perc_ib", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_conc_imp_internos", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_conc_imp_ret_iva", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_conc_imp_ret_gan", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_conc_imp_ret_ib", Field.INTEGER, 0));
    return dataset;
  }

  private void cargarRegistroDetalleFactProv(IDataSet dataset,
                                             Integer oid,
                                             ConcFactProv concFactProv,
                                             ConcFactProvImp concImpuIVA,
                                             ConcFactProvImp concImpuPercIVA,
                                             ConcFactProvImp concImpuPercIB,
                                             ConcFactProvImp concImpuInternos,
                                             ConcFactProvImp concImpuRetIVA,
                                             ConcFactProvImp concImpuRetGan,
                                             ConcFactProvImp concImpuRetIB)
                                             throws BaseException {

    dataset.append();
    dataset.fieldValue("oid",oid);
    dataset.fieldValue("oid_conc_fact_prov", concFactProv.getOIDInteger());
    dataset.fieldValue("descripcion", concFactProv.getDescripcion());
    dataset.fieldValue("activo", concFactProv.isActivo());
    dataset.fieldValue("orden", concFactProv.getOrden());
    if (concImpuIVA!=null)
      dataset.fieldValue("oid_conc_imp_iva", concImpuIVA.getConcImpuesto().getOID());
    else
      dataset.fieldValue("oid_conc_imp_iva", 0);
    if (concImpuPercIVA!=null)
      dataset.fieldValue("oid_conc_imp_perc_iva", concImpuPercIVA.getConcImpuesto().getOID());
    else
      dataset.fieldValue("oid_conc_imp_perc_iva", 0);
    if (concImpuPercIB!=null)
      dataset.fieldValue("oid_conc_imp_perc_ib", concImpuPercIB.getConcImpuesto().getOID());
    else
      dataset.fieldValue("oid_conc_imp_perc_ib", 0);
    if (concImpuInternos!=null)
       dataset.fieldValue("oid_conc_imp_internos", concImpuInternos.getConcImpuesto().getOID());
    else
       dataset.fieldValue("oid_conc_imp_internos", 0);
    if (concImpuRetIVA!=null)
       dataset.fieldValue("oid_conc_imp_ret_iva", concImpuRetIVA.getConcImpuesto().getOIDInteger());
    else
       dataset.fieldValue("oid_conc_imp_ret_iva", 0);

    if (concImpuRetGan!=null)
       dataset.fieldValue("oid_conc_imp_ret_gan", concImpuRetGan.getConcImpuesto().getOID());
    else
       dataset.fieldValue("oid_conc_imp_ret_gan", 0);
    if (concImpuRetIB!=null)
       dataset.fieldValue("oid_conc_imp_ret_ib", concImpuRetIB.getConcImpuesto().getOIDInteger());
    else
       dataset.fieldValue("oid_conc_imp_ret_ib", 0);
  }




}
