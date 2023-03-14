package com.srn.erp.contabilidad.op;

import java.util.Iterator;

import com.srn.erp.contabilidad.bm.Subdiario;
import com.srn.erp.contabilidad.bm.SubdiarioDet;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerSubdiario extends Operation {

	public TraerSubdiario() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		Subdiario subdiario = null;
		if (mapaDatos.containsKey("oid")) {
			Integer oid = mapaDatos.getInteger("oid");
			subdiario = Subdiario.findByOid(oid, getSesion());
		} else {
			String codigo = mapaDatos.getString("codigo");
			subdiario = Subdiario.findByCodigo(codigo, getSesion());
		}

		IDataSet datasetSubdiario = getDataSetSubdiario();
		IDataSet datasetSubdiarioDet = getDataSetSubdiarioDet();
		
		if (subdiario != null) {
			cargarRegistroSubdiario(datasetSubdiario, subdiario.getOIDInteger(), subdiario.getCodigo(), subdiario.getDescripcion(),
					subdiario.isActivo());
			
			Iterator iterSubDiariosDet = 
				subdiario.getSubdiariosDet().iterator();
			while (iterSubDiariosDet.hasNext()) {
				SubdiarioDet subDiarioDet = (SubdiarioDet) iterSubDiariosDet.next();
				if (subDiarioDet.isActivo())
					cargarRegistroSubdiarioDet(datasetSubdiarioDet, subDiarioDet);
			}
		}
		writeCliente(datasetSubdiario);
		writeCliente(datasetSubdiarioDet);
	}

	private IDataSet getDataSetSubdiario() {
		IDataSet dataset = new TDataSet();
		dataset.create("TSubdiario");
		dataset.fieldDef(new Field("oid_subdiario", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 20));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private void cargarRegistroSubdiario(IDataSet dataset, Integer oid_subdiario, String codigo, String descripcion, Boolean activo) {
		dataset.append();
		dataset.fieldValue("oid_subdiario", oid_subdiario);
		dataset.fieldValue("codigo", codigo);
		dataset.fieldValue("descripcion", descripcion);
		dataset.fieldValue("activo", activo);
	}

	private IDataSet getDataSetSubdiarioDet() {
		IDataSet dataset = new TDataSet();
		dataset.create("TSubdiarioDet");
		dataset.fieldDef(new Field("oid_subdiario_det", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_subdiario", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_ana_con", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_ana_con", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_ana_con", Field.STRING, 100));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private void cargarRegistroSubdiarioDet(IDataSet dataset, SubdiarioDet subdiarioDet) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_subdiario_det", subdiarioDet.getOIDInteger());
		dataset.fieldValue("oid_subdiario", subdiarioDet.getSubdiario().getOIDInteger());
		dataset.fieldValue("oid_ana_con", subdiarioDet.getCuenta().getOIDInteger());
		dataset.fieldValue("cod_ana_con", subdiarioDet.getCuenta().getCodigo());
		dataset.fieldValue("desc_ana_con", subdiarioDet.getCuenta().getDescripcion());
		dataset.fieldValue("activo", subdiarioDet.isActivo());
	}

}
