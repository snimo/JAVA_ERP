package com.srn.erp.contabilidad.op;

import java.util.Iterator;

import com.srn.erp.contabilidad.bm.Cuenta;
import com.srn.erp.contabilidad.bm.Estructura;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerCuentasIniFaseDriver extends Operation {

  public TraerCuentasIniFaseDriver() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {

	Integer oidFase = mapaDatos.getInteger("oid_fase");
	int secu = 0;
	
	IDataSet ds = getDataCuentasOri();
	
	Iterator iterCuentas = 
		Cuenta.getAllActivos(this.getSesion()).iterator();
	while (iterCuentas.hasNext()) {
		Cuenta cuenta = (Cuenta) iterCuentas.next();
		cargarCuenta(
				ds, 
				new Integer(++secu), 
				oidFase, 
				cuenta, 
				cuenta.getEstructura(), 
				new Boolean(false));
	}
	
	writeCliente(ds);
	
    
  }

  private IDataSet getDataCuentasOri() {
    IDataSet dataset = new TDataSet();
    dataset.create("TFaseCtaOri");
    dataset.fieldDef(new Field("oid_fase_cta_ori", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_fase", Field.INTEGER, 0));
    dataset.fieldDef(new Field("desc_estruc", Field.STRING, 255));
    dataset.fieldDef(new Field("oid_ana_con",Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_ana_con",Field.STRING, 50));
    dataset.fieldDef(new Field("desc_ana_con",Field.STRING, 100));
    dataset.fieldDef(new Field("activo",Field.BOOLEAN, 0));
    return dataset;
  }
  
  private void cargarCuenta(
		  IDataSet ds,
		  Integer oidFaseCtaOri,
		  Integer oidFase,
		  Cuenta cuenta,
		  Estructura estructura,
		  Boolean activo) throws BaseException {
	  ds.append();
	  ds.fieldValue("oid_fase_cta_ori", oidFaseCtaOri);
	  ds.fieldValue("oid_fase", oidFase);
	  if (estructura!=null)
		  ds.fieldValue("desc_estruc", estructura.getDescripcion());
	  else
		  ds.fieldValue("desc_estruc", "");
	  ds.fieldValue("oid_ana_con",cuenta.getOIDInteger());
	  ds.fieldValue("cod_ana_con",cuenta.getCodigo());
	  ds.fieldValue("desc_ana_con",cuenta.getDescripcion());
	  ds.fieldValue("activo",new Boolean(false));
	  
  }

}
