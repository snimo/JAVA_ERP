package com.srn.erp.pagos.op;

import java.util.Iterator;

import com.srn.erp.pagos.bm.RendicionFFUniOrg;
import com.srn.erp.pagos.bm.RendicionFFUniOrgCta;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerConfCtasFondoFijo extends Operation {

  public TraerConfCtasFondoFijo() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
  	
  	IDataSet dsUniOrgFF = this.getDSFondoFijoUniOrg();
  	IDataSet dsUniOrgFFCta = this.getDSFondoFijoUniOrgCta();
  	
  	Iterator iterRendFFUniOrg = 
  		RendicionFFUniOrg.getAllUniOrgRendFF(this.getSesion()).iterator();
  	while (iterRendFFUniOrg.hasNext()) {
  		RendicionFFUniOrg rendFFUniOrg = (RendicionFFUniOrg) iterRendFFUniOrg.next();
  		cargarRegistroFondoFijoUniOrg(dsUniOrgFF,rendFFUniOrg);
  		
  		Iterator iterCtasRendFF = rendFFUniOrg.getCtasRendFondoFijo().iterator();
  		while (iterCtasRendFF.hasNext()) {
  			RendicionFFUniOrgCta rendCtaFF = (RendicionFFUniOrgCta) iterCtasRendFF.next();
  			cargarRegistroFondoFijoUniOrgCta(dsUniOrgFFCta,rendCtaFF);
  		}
  		
  	}
  	
  	writeCliente(dsUniOrgFF);
  	writeCliente(dsUniOrgFFCta);
  	
  	
  }

  private IDataSet getDSFondoFijoUniOrg() {
    IDataSet dataset = new TDataSet();
    dataset.create("TUniOrgFF");
    dataset.fieldDef(new Field("oid_uni_org_ff", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_uni_org", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_uni_org", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_uni_org", Field.STRING, 255));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    return dataset;
  }
  
  private IDataSet getDSFondoFijoUniOrgCta() {
    IDataSet dataset = new TDataSet();
    dataset.create("TUniOrgFFCta");
    dataset.fieldDef(new Field("oid_ff_cta", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_uni_org_ff", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_ana_con", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_ana_con", Field.STRING, 100));
    dataset.fieldDef(new Field("desc_ana_con", Field.STRING, 255));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    return dataset;
  }
  

  private void cargarRegistroFondoFijoUniOrg(
  		 IDataSet dataset,
  		 RendicionFFUniOrg rendicionFFUniOrg) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid_uni_org_ff", rendicionFFUniOrg.getOIDInteger());
    dataset.fieldValue("oid_uni_org", rendicionFFUniOrg.getUnidad_organizativa().getOIDInteger());
    dataset.fieldValue("cod_uni_org", rendicionFFUniOrg.getUnidad_organizativa().getCodigo());
    dataset.fieldValue("desc_uni_org", rendicionFFUniOrg.getUnidad_organizativa().getDescripcion());
    dataset.fieldValue("activo", rendicionFFUniOrg.isActivo());
  }
  
  private void cargarRegistroFondoFijoUniOrgCta(
 		 IDataSet dataset,
 		 RendicionFFUniOrgCta rendicionFFUniOrgCta) throws BaseException {
   dataset.append();
   dataset.fieldValue("oid_ff_cta", rendicionFFUniOrgCta.getOIDInteger());
   dataset.fieldValue("oid_uni_org_ff", rendicionFFUniOrgCta.getUnidad_organizativa_ff().getOIDInteger());
   dataset.fieldValue("oid_ana_con", rendicionFFUniOrgCta.getCuenta().getOIDInteger());
   dataset.fieldValue("cod_ana_con", rendicionFFUniOrgCta.getCuenta().getCodigo());
   dataset.fieldValue("desc_ana_con", rendicionFFUniOrgCta.getCuenta().getDescripcion());
   dataset.fieldValue("activo", rendicionFFUniOrgCta.isActivo());
 }
  
  
}
