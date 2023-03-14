package com.srn.erp.pagos.op;

import com.srn.erp.contabilidad.bm.CuentaImputable;
import com.srn.erp.general.bm.UnidadOrganizativa;
import com.srn.erp.pagos.bm.ConceptoOPVarias;
import com.srn.erp.pagos.bm.ConceptoOPVariasHab;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveConceptoOPVarias extends Operation { 

  public SaveConceptoOPVarias() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TConceptoOPVarias"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        ConceptoOPVarias conceptoopvarias = ConceptoOPVarias.findByOid(dataset.getInteger("oid_conc_pv"),getSesion());
        conceptoopvarias.setOID(dataset.getInteger("oid_conc_pv"));
        conceptoopvarias.setCodigo(dataset.getString("codigo"));
        conceptoopvarias.setDescripcion(dataset.getString("descripcion"));
        conceptoopvarias.setCuenta_imputable(CuentaImputable.findByOidProxy(dataset.getInteger("oid_ai"),this.getSesion()));
        conceptoopvarias.setActivo(dataset.getBoolean("activo"));
        
        IDataSet dsUniOrg = dataset.getDataSet("TConceptoOPVariasHab");
        dsUniOrg.first();
        while (!dsUniOrg.EOF()) {
        	ConceptoOPVariasHab conceptoOPvariasHab = ConceptoOPVariasHab.findByOid(dsUniOrg.getInteger("oid_conc_pv_hab"),getSesion());
        	conceptoOPvariasHab.setConcepto_pv(conceptoopvarias);
        	conceptoOPvariasHab.setUnidad_organizativa(UnidadOrganizativa.findByOidProxy(dsUniOrg.getInteger("oid_uni_org"),this.getSesion()));
        	conceptoOPvariasHab.setActivo(dsUniOrg.getBoolean("activo"));
        	if (conceptoOPvariasHab.isActivo().booleanValue()==false)        		
        		conceptoOPvariasHab.delete();
        	
        	conceptoopvarias.addUnidadOrganizativa(conceptoOPvariasHab);
        	dsUniOrg.next();
        }
        
        
        
        
        
        addTransaccion(conceptoopvarias);
        dataset.next();
    }
  }
  
}
