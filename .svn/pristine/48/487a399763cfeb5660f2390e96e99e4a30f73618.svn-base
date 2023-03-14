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

public class TraerImpuestosConcepto extends Operation {
	
  	

  public TraerImpuestosConcepto() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {

	  Hashtable impuestos = new Hashtable();
	  Integer oidConcImpu = mapaDatos.getInteger("oid_conc_imp");
	  ConcFactProv concfactprov = ConcFactProv.findByOid(oidConcImpu, this.getSesion());
	  
      Iterator iterConcImpuestos =
    	  concfactprov.getConceptosImpuestos().iterator();
      while (iterConcImpuestos.hasNext()) {
        ConcFactProvImp concFactProvImp =
            (ConcFactProvImp) iterConcImpuestos.next();
        if (concFactProvImp.isActivo().booleanValue())
           impuestos.put(concFactProvImp.getConcImpuesto().getImpuesto().getCompo(),
                         concFactProvImp);
      }
      
      IDataSet ds = this.getDataSetConcFactProv();
      cargarRegistroConcFactProv(
    		  ds, 
    		  concfactprov, 
    		  (ConcFactProvImp)impuestos.get(Impuesto.CODIGO_IVA_C), 
    		  (ConcFactProvImp)impuestos.get(Impuesto.CODIGO_PERC_IVA_C),
    		  (ConcFactProvImp)impuestos.get(Impuesto.CODIGO_IMP_INT_C),
    		  (ConcFactProvImp)impuestos.get(Impuesto.CODIGO_PERC_IB_C));
      writeCliente(ds);

    
  }

  private IDataSet getDataSetConcFactProv() {
    IDataSet dataset = new TDataSet();
    dataset.create("TImpuestosConcepto");
    dataset.fieldDef(new Field("oid_conc_fact_prov", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_impu_iva", Field.STRING, 0));
    dataset.fieldDef(new Field("oid_impu_perc_iva", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_impu_int", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_impu_perc_ib", Field.INTEGER, 0));
    return dataset;
  }

  private void cargarRegistroConcFactProv(IDataSet dataset,
                         				  ConcFactProv concFactProv,
                         				  ConcFactProvImp concImpuIVA,
                         				  ConcFactProvImp concImpuPercIVA,
                         				  ConcFactProvImp concImpuInt,
                         				  ConcFactProvImp concImpuPercIB) throws BaseException {
                         				  
    dataset.append();
    dataset.fieldValue("oid_conc_fact_prov", concFactProv.getOIDInteger());
    if ((concImpuIVA!=null) && (concImpuIVA.getConcImpuesto()!=null))
    	dataset.fieldValue("oid_impu_iva", concImpuIVA.getConcImpuesto().getOIDInteger());
    else
    	dataset.fieldValue("oid_impu_iva", 0);
    if ((concImpuPercIVA!=null) && (concImpuPercIVA.getConcImpuesto()!=null))
    	dataset.fieldValue("oid_impu_perc_iva", concImpuPercIVA.getConcImpuesto().getOIDInteger());
    else
    	dataset.fieldValue("oid_impu_perc_iva", 0);
    if ((concImpuInt!=null) && (concImpuInt.getConcImpuesto()!=null))
    	dataset.fieldValue("oid_impu_int", concImpuInt.getConcImpuesto().getOIDInteger());
    else
    	dataset.fieldValue("oid_impu_int", 0);
    if ((concImpuPercIB!=null) && (concImpuPercIB.getConcImpuesto()!=null))
    	dataset.fieldValue("oid_impu_perc_ib", concImpuPercIB.getConcImpuesto().getOIDInteger());
    else
    	dataset.fieldValue("oid_impu_perc_ib", 0);
  }



}
