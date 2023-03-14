package com.srn.erp.pagos.op;

import java.util.Iterator;

import com.srn.erp.pagos.bm.ConceptoOPVarias;
import com.srn.erp.pagos.bm.ConceptoOPVariasHab;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerConceptoOPVarias extends Operation { 

  public TraerConceptoOPVarias() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    ConceptoOPVarias conceptoopvarias = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       conceptoopvarias = ConceptoOPVarias.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       conceptoopvarias = ConceptoOPVarias.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetConceptoOPVarias = getDataSetConceptoOPVarias();
    IDataSet datasetConceptoOPVariasHab = getDataSetConceptoOPVariasHab();
    
    if (conceptoopvarias != null) { 
        cargarRegistroConceptoOPVarias(datasetConceptoOPVarias, 
                         conceptoopvarias);
        
        Iterator iterUniOrg =
        	conceptoopvarias.getUnidadesOrganizativas().iterator();
        while (iterUniOrg.hasNext()) {
        	ConceptoOPVariasHab concOPVarHab = 
        		(ConceptoOPVariasHab) iterUniOrg.next();
          cargarRegistroConceptoOPVariasHab(
          		datasetConceptoOPVariasHab, 
          		concOPVarHab);
        }
        
        
    }
    
    writeCliente(datasetConceptoOPVarias);
    writeCliente(datasetConceptoOPVariasHab);
    
  }

  private IDataSet getDataSetConceptoOPVarias() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TConceptoOPVarias");
    dataset.fieldDef(new Field("oid_conc_pv", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 50)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100)); 
    dataset.fieldDef(new Field("oid_ai", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo_ai", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_ai", Field.STRING, 255));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistroConceptoOPVarias(IDataSet dataset, 
  		ConceptoOPVarias concepto) throws BaseException {
    dataset.append(); 
    dataset.fieldValue("oid_conc_pv", concepto.getOIDInteger());
    dataset.fieldValue("codigo", concepto.getCodigo());
    dataset.fieldValue("descripcion", concepto.getDescripcion());
    dataset.fieldValue("oid_ai", concepto.getCuenta_imputable().getOIDInteger());
    dataset.fieldValue("codigo_ai", concepto.getCuenta_imputable().getCodigoCuentaMasCodigosValCompo());
    dataset.fieldValue("desc_ai", concepto.getCuenta_imputable().getDescCuentaMasDescValCompo());
    dataset.fieldValue("activo", concepto.isActivo());
  }
  
  private IDataSet getDataSetConceptoOPVariasHab() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TConceptoOPVariasHab");
    dataset.fieldDef(new Field("oid_conc_pv_hab", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_conc_pv", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_uni_org", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_uni_org", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_uni_org", Field.STRING, 100));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }
  
  private void cargarRegistroConceptoOPVariasHab(IDataSet dataset, 
  		ConceptoOPVariasHab conceptoHab) throws BaseException {
    dataset.append(); 
    dataset.fieldValue("oid_conc_pv_hab", conceptoHab.getOIDInteger()); 
    dataset.fieldValue("oid_conc_pv", conceptoHab.getConcepto_pv().getOIDInteger());
    dataset.fieldValue("oid_uni_org", conceptoHab.getUnidad_organizativa().getOIDInteger());
    dataset.fieldValue("cod_uni_org", conceptoHab.getUnidad_organizativa().getCodigo());
    dataset.fieldValue("desc_uni_org", conceptoHab.getUnidad_organizativa().getDescripcion());
    dataset.fieldValue("activo", conceptoHab.isActivo());
  }
  
  
}
