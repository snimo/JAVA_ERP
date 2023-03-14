package com.srn.erp.conciTarjeta.op;

import java.util.Iterator;

import com.srn.erp.conciTarjeta.bm.CabModeloLiq;
import com.srn.erp.conciTarjeta.bm.DetModeloLiq;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerCabModeloLiq extends Operation {

	public TraerCabModeloLiq() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		CabModeloLiq cabmodeloliq = null;
		if (mapaDatos.containsKey("oid")) {
			Integer oid = mapaDatos.getInteger("oid");
			cabmodeloliq = CabModeloLiq.findByOid(oid, getSesion());
		} else {
			String codigo = mapaDatos.getString("codigo");
			cabmodeloliq = CabModeloLiq.findByCodigo(codigo, getSesion());
		}

		IDataSet datasetCabModeloLiq = getDataSetCabModeloLiq();
		IDataSet datasetDetModeloLiq = getDataSetDetModeloLiq();
		
		if (cabmodeloliq != null) {		
			cargarRegistroCabModeloLiq(
					datasetCabModeloLiq, 
					cabmodeloliq.getOIDInteger(), 
					cabmodeloliq.getCodigo(), 
					cabmodeloliq.getDescripcion(), 
					cabmodeloliq.isActivo(),
					cabmodeloliq.getComenAsiento());
			
			Iterator iterRengCtas =
				cabmodeloliq.getRenglonesCuentas().iterator();
			while (iterRengCtas.hasNext()) {
				DetModeloLiq detModeloLiq = (DetModeloLiq) iterRengCtas.next();
				cargarRegistroDetModeloLiq(datasetDetModeloLiq, detModeloLiq);
			}
			
		}
		
		writeCliente(datasetCabModeloLiq);
		writeCliente(datasetDetModeloLiq);
		
	}

	private IDataSet getDataSetCabModeloLiq() {
		IDataSet dataset = new TDataSet();
		dataset.create("TCabModeloLiq");
		dataset.fieldDef(new Field("oid_modelo_liq", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 20));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("comen_asiento", Field.STRING, 255));
		return dataset;
	}
	
	private IDataSet getDataSetDetModeloLiq() {
		IDataSet dataset = new TDataSet();
		dataset.create("TDetModeloLiq");
		dataset.fieldDef(new Field("oid_modelo_det", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_modelo_liq", Field.INTEGER, 0));
		dataset.fieldDef(new Field("orden", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cuenta", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_cuenta", Field.STRING, 100));
		dataset.fieldDef(new Field("compo1", Field.STRING, 50));
		dataset.fieldDef(new Field("compo2", Field.STRING, 50));
		dataset.fieldDef(new Field("debe", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("haber", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("cod_impuesto", Field.STRING, 50));
		dataset.fieldDef(new Field("porc_imp", Field.DOUBLE, 0));
		return dataset;
	}	
	
	

	private void cargarRegistroCabModeloLiq(IDataSet dataset, Integer oid_modelo_liq, String codigo, String descripcion, Boolean activo , String comenAsiento) {
		dataset.append();
		dataset.fieldValue("oid_modelo_liq", oid_modelo_liq);
		dataset.fieldValue("codigo", codigo);
		dataset.fieldValue("descripcion", descripcion);
		dataset.fieldValue("activo", activo);
		dataset.fieldValue("comen_asiento", comenAsiento);
		
	}
	
	private void cargarRegistroDetModeloLiq(IDataSet dataset, DetModeloLiq detModeloLiq) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_modelo_det", detModeloLiq.getOIDInteger());
		dataset.fieldValue("oid_modelo_liq", detModeloLiq.getModelo().getOIDInteger());
		dataset.fieldValue("orden", detModeloLiq.getOrden());
		dataset.fieldValue("cuenta", detModeloLiq.getCuenta());
		dataset.fieldValue("desc_cuenta", detModeloLiq.getDesc_cuenta());
		dataset.fieldValue("compo1", detModeloLiq.getCompo1());
		dataset.fieldValue("compo2", detModeloLiq.getCompo2());
		dataset.fieldValue("debe", detModeloLiq.getDebe());
		dataset.fieldValue("haber", detModeloLiq.getHaber());
		dataset.fieldValue("activo", detModeloLiq.isActivo());	
		dataset.fieldValue("cod_impuesto", detModeloLiq.getCodImpuesto());
		if (detModeloLiq.getPorcImp()!=null)
			dataset.fieldValue("porc_imp", detModeloLiq.getPorcImp().doubleValue());
		else
			dataset.fieldValue("porc_imp", 0);
	}	
}
