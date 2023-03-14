package com.srn.erp.tesoreria.op;

import com.srn.erp.contabilidad.bm.CuentaImputable;
import com.srn.erp.general.bm.MotivoTC;
import com.srn.erp.general.bm.UnidadOrganizativa;
import com.srn.erp.tesoreria.bm.CuentaImputableIngVar;
import com.srn.erp.tesoreria.bm.MotivoHabIngVar;
import com.srn.erp.tesoreria.bm.UniOrgCtasIngVar;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveMotHabIngVar extends Operation {

  public SaveMotHabIngVar() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet dataset = mapaDatos.getDataSet("TMotHabIngVar");
    procesarRegistros(dataset);
  }

  private void procesarRegistros(IDataSet dataset) throws BaseException {
    dataset.first();
      while (!dataset.EOF()) {
      	MotivoHabIngVar motivoHabIngVar =
      		MotivoHabIngVar.getMotivoHabIngVar(MotivoTC.findByOid(dataset.getInteger("oid_motivo_tc"),getSesion()),this.getSesion());
      	
      	if (motivoHabIngVar == null)
      		motivoHabIngVar = (MotivoHabIngVar)MotivoHabIngVar.getNew(MotivoHabIngVar.NICKNAME,this.getSesion()); 
      		
      	
      	motivoHabIngVar.setMotivo_tc(MotivoTC.findByOid(dataset.getInteger("oid_motivo_tc"),getSesion()));
      	motivoHabIngVar.setHabilitado(dataset.getBoolean("habilitado"));
        
      	IDataSet dsCtasHabIngVar = dataset.getDataSet("TCtasIngVar");
      	dsCtasHabIngVar.first();
      	while (!dsCtasHabIngVar.EOF()) {
      		
      		CuentaImputableIngVar ctaImpIngVar 
      		   = CuentaImputableIngVar.findByOid(dsCtasHabIngVar.getInteger("oid_cta_int_iv"),this.getSesion());
      		ctaImpIngVar.setMotivo_hab_ing_var(motivoHabIngVar);
      		ctaImpIngVar.setCuenta_imputable(CuentaImputable.findByOidProxy(dsCtasHabIngVar.getInteger("oid_ai"),this.getSesion()));
      		ctaImpIngVar.setActivo(dsCtasHabIngVar.getBoolean("activo"));
      		
      		motivoHabIngVar.addCuentaHabIngVar(ctaImpIngVar);
      		
      		// Grabar las Unidades Organizativas
      		IDataSet dsUniOrg = dsCtasHabIngVar.getDataSet("TIngVarUniOrg");
      		dsUniOrg.first();
      		while (!dsUniOrg.EOF()) {
      			UniOrgCtasIngVar uniOrgCtasIngVar = UniOrgCtasIngVar.findByOid(dsUniOrg.getInteger("oid_uni_org_iv"),this.getSesion());
      			uniOrgCtasIngVar.setCuenta_iv(ctaImpIngVar);
      			uniOrgCtasIngVar.setUnidad_organizativa(UnidadOrganizativa.findByOid(dsUniOrg.getInteger("oid_uni_org"),this.getSesion()));
      			if (dsUniOrg.getBoolean("habilitado").booleanValue()==false)
      				uniOrgCtasIngVar.delete();
      			
      			ctaImpIngVar.addUniOrgCtaIngVar(uniOrgCtasIngVar);
      			
      			dsUniOrg.next();
      		}
      		
      		
      		dsCtasHabIngVar.next();
      	}
      	
        
        addTransaccion(motivoHabIngVar);
        dataset.next();
    }
  }

}
