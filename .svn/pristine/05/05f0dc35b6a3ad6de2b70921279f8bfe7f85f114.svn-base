package com.srn.erp.tesoreria.op;

import java.util.Iterator;

import com.srn.erp.general.bm.UnidadOrganizativa;
import com.srn.erp.tesoreria.bm.CuentaSistemaBanco;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerCuentaSistemaBanco extends Operation { 

  public TraerCuentaSistemaBanco() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
  	
  	IDataSet dsUniOrg = this.getDataSetUniOrg();
  	IDataSet dsCtas = this.getDataSetCuentaSistemaBanco();
  	
  	Iterator iterUniOrg = 
  		UnidadOrganizativa.getUnidadesOrganizativasSistBancos(this.getSesion()).iterator();
  	while (iterUniOrg.hasNext()) {
  		UnidadOrganizativa uniOrg = (UnidadOrganizativa) iterUniOrg.next();
  		cargarUniOrg(dsUniOrg,uniOrg);
  		enviarCtas(dsCtas,uniOrg);
  	}
  	
    writeCliente(dsUniOrg);
    writeCliente(dsCtas);
    
  }
  
  private void enviarCtas(IDataSet dsCtas,UnidadOrganizativa uniOrg) throws BaseException {
  	Iterator iterCtasHab = uniOrg.getCuentasHabSistBancos().iterator();
  	while (iterCtasHab.hasNext()) {
  		CuentaSistemaBanco ctaSistBanco = (CuentaSistemaBanco) iterCtasHab.next();
  		cargarRegistroCuentaSistemaBanco(dsCtas,ctaSistBanco);
  	}
  }

  private IDataSet getDataSetCuentaSistemaBanco() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TUniOrgCta");
    dataset.fieldDef(new Field("oid_cta_hab_bco", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
    dataset.fieldDef(new Field("secu", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_ai", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo_ai", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_ai", Field.STRING, 255));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    return dataset;
  }

  private void cargarRegistroCuentaSistemaBanco(IDataSet dataset, 
                                                CuentaSistemaBanco cuentaSistBco) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid_cta_hab_bco", cuentaSistBco.getOIDInteger());
    dataset.fieldValue("oid", cuentaSistBco.getUniOrg().getOIDInteger());
    dataset.fieldValue("secu", new Integer(0));
    dataset.fieldValue("oid_ai", cuentaSistBco.getCuenta().getOIDInteger());
    dataset.fieldValue("codigo_ai", cuentaSistBco.getCuenta().getCodigoCuentaMasCodigosValCompo());
    dataset.fieldValue("desc_ai", cuentaSistBco.getCuenta().getDescCuentaMasDescValCompo());
    dataset.fieldValue("activo", cuentaSistBco.isActivo());
  }
  
  private IDataSet getDataSetUniOrg() throws BaseException {
    IDataSet dataset = new TDataSet(); 
    dataset.create("TUniOrg");
    dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_uni_org", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_uni_org", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_uni_org", Field.STRING, 100));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    return dataset;
  }
  
  private void cargarUniOrg(IDataSet ds,UnidadOrganizativa uniOrg) throws BaseException {
  	ds.append();
  	ds.fieldValue("oid", uniOrg.getOIDInteger());
  	ds.fieldValue("oid_uni_org", uniOrg.getOIDInteger());
  	ds.fieldValue("cod_uni_org", uniOrg.getCodigo());
  	ds.fieldValue("desc_uni_org", uniOrg.getDescripcion());
  	ds.fieldValue("activo", new Boolean(true));
  }
  
  
  
}
