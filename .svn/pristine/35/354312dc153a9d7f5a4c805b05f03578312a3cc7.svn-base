package com.srn.erp.ctasAPagar.op;

import java.util.List;

import com.srn.erp.contabilidad.bm.Cuenta;
import com.srn.erp.ctasAPagar.bm.ConcFactProv;
import com.srn.erp.ctasAPagar.bm.EsqCuentaConcFactProv;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerCtasConFactProvDef extends Operation {

  public TraerCtasConFactProvDef() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	  
    ConcFactProv concfactprov = ConcFactProv.findByOidProxy(mapaDatos.getInteger("oid_conc_fact"), this.getSesion());
    
    List listaCuentas = concfactprov.getCuentasConcFactProv();
    
    IDataSet ds = this.getDataSetCtasConcFactProv();
    
    if (listaCuentas.size()==1) {
    	EsqCuentaConcFactProv esqCtaConcFactProv = (EsqCuentaConcFactProv) listaCuentas.get(0);
    	if (esqCtaConcFactProv.getCuenta_contable().getEstructura() == null)
    		cargarRegistroConcFactProv(ds, esqCtaConcFactProv.getCuenta_contable());
    }

    writeCliente(ds);
    
  }

  private IDataSet getDataSetCtasConcFactProv() {
    IDataSet dataset = new TDataSet();
    dataset.create("TCtasConcFactProvDefault");
    dataset.fieldDef(new Field("oid_ana_con", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 50));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
    return dataset;
  }
  

  private void cargarRegistroConcFactProv(
		  IDataSet dataset,
		  Cuenta cuenta
          ) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid_ana_con", cuenta.getOIDInteger());
    dataset.fieldValue("codigo", cuenta.getCodigo());
    dataset.fieldValue("descripcion", cuenta.getDescripcion());
  }



}
