package com.srn.erp.cashflow.op;

import com.srn.erp.cashflow.bm.ConceptoCashFlow;
import com.srn.erp.cashflow.bm.ConfProgConcCF;
import com.srn.erp.cashflow.bm.EsceConceptoCFHab;
import com.srn.erp.cashflow.bm.EscenarioCashFlow;
import com.srn.erp.cashflow.bm.GrupoConceptoCF;
import com.srn.erp.general.bm.Moneda;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveConceptoCashFlow extends Operation { 

  public SaveConceptoCashFlow() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TConceptoCashFlow"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        ConceptoCashFlow conceptocashflow = ConceptoCashFlow.findByOid(dataset.getInteger("oid_concepto"),getSesion());
        conceptocashflow.setOID(dataset.getInteger("oid_concepto"));
        conceptocashflow.setCodigo(dataset.getString("codigo"));
        conceptocashflow.setDescripcion(dataset.getString("descripcion"));
        conceptocashflow.setActivo(dataset.getBoolean("activo"));
        conceptocashflow.setGrupo_concepto(GrupoConceptoCF.findByOidProxy(dataset.getInteger("oid_grupo_concepto"), this.getSesion()));
        
        IDataSet dsConfProgConc = dataset.getDataSet("TConfProgConc");
        dsConfProgConc.first();
        while (!dsConfProgConc.EOF()) {
        	ConfProgConcCF confProgConcCF = 
        		ConfProgConcCF.findByOid(dsConfProgConc.getInteger("oid_prog_conc"), this.getSesion());
        	confProgConcCF.setConcepto(ConceptoCashFlow.findByOidProxy(dsConfProgConc.getInteger("oid_concepto"), this.getSesion()));
        	confProgConcCF.setNro_mes(dsConfProgConc.getInteger("nro_mes"));
        	confProgConcCF.setDia(dsConfProgConc.getInteger("dia"));
        	confProgConcCF.setMonto(dsConfProgConc.getDouble("monto"));
        	confProgConcCF.setMoneda(Moneda.findByOidProxy(dsConfProgConc.getInteger("oid_moneda"), this.getSesion()));
        	confProgConcCF.setActivo(dsConfProgConc.getBoolean("activo"));
        	conceptocashflow.addConfProgConc(confProgConcCF);
        	
        	dsConfProgConc.next();	
        }
        
        IDataSet dsEscenariosHab = dataset.getDataSet("TEscenarioConcepto");
        dsEscenariosHab.first();
        while (!dsEscenariosHab.EOF()) {
        	EsceConceptoCFHab esceConcCFHab =
        		EsceConceptoCFHab.findByOid(dsEscenariosHab.getInteger("oid_esce_conc"), this.getSesion());
        	esceConcCFHab.setConcepto_cf(conceptocashflow);
        	esceConcCFHab.setEscenario_cf(EscenarioCashFlow.findByOidProxy(dsEscenariosHab.getInteger("oid_escenario"), this.getSesion()));
        	esceConcCFHab.setActivo(dsEscenariosHab.getBoolean("activo"));
        	conceptocashflow.addEscenarioHabilitado(esceConcCFHab);
        	
        	dsEscenariosHab.next();
        }
        
        
        
        addTransaccion(conceptocashflow);
        dataset.next();
    }
  }
  
}
