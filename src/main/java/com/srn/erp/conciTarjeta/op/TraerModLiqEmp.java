package com.srn.erp.conciTarjeta.op;

import java.util.Iterator;

import com.srn.erp.conciTarjeta.bm.CabModeloLiq;
import com.srn.erp.conciTarjeta.bm.EmpresaConciTar;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerModLiqEmp extends Operation { 

  public TraerModLiqEmp() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException {

	IDataSet ds = this.getDataSetModLiq();
	
	EmpresaConciTar empresa = EmpresaConciTar.findByOidProxy(mapaDatos.getInteger("oid_empresa"), this.getSesion());
	if (empresa == null)
		throw new ExceptionValidation(null,"Debe seleccionar la empresa");
	
	Iterator iterModLiq = 
		empresa.getListaCabModLiq().iterator();
	while (iterModLiq.hasNext()) {
		CabModeloLiq cabModeloLiq = (CabModeloLiq) iterModLiq.next();
		cargarRegModLiq(ds, cabModeloLiq.getOID(), cabModeloLiq.getCodigo() , cabModeloLiq.getDescripcion());
	}
	
	writeCliente(ds);
  }

	private void cargarRegModLiq(
			IDataSet ds,
			Integer oid,
			String codigo,
			String descripcion) throws BaseException {
		ds.append();
		ds.fieldValue("oid", oid);
		ds.fieldValue("codigo", codigo);
		ds.fieldValue("descripcion", descripcion);
	}
	
	private IDataSet getDataSetModLiq() {
		IDataSet dataset = new TDataSet();
		dataset.create("TLiquidaciones");
		dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 50));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
		return dataset;
	}
	
	
}
