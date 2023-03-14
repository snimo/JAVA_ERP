package com.srn.erp.presupuesto.op;

import java.util.Iterator;

import com.srn.erp.presupuesto.bm.CompoPresupuestario;
import com.srn.erp.presupuesto.bm.TipoPeriodo;
import com.srn.erp.presupuesto.bm.VarEscenarioCab;
import com.srn.erp.presupuesto.bm.VarEscenarioDet;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerDefVarEscenario extends Operation {

	public TraerDefVarEscenario() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		VarEscenarioCab varescenariocab = null;
		if (mapaDatos.containsKey("oid")) {
			Integer oid = mapaDatos.getInteger("oid");
			varescenariocab = VarEscenarioCab.findByOid(oid, getSesion());
		}
		else {
			String codigo = mapaDatos.getString("codigo");
			varescenariocab = VarEscenarioCab.findByCodigo(codigo, getSesion());
		}

		IDataSet datasetVarEscenarioCab = getDataSetVarEscenarioCab();
		IDataSet datasetVarEscenarioDet = getDataSetVarEscenarioDet();

		if (varescenariocab != null) {
			cargarRegistroVarEscenarioCab(datasetVarEscenarioCab, varescenariocab.getOIDInteger(), varescenariocab
					.getCodigo(), varescenariocab.getDescripcion(), varescenariocab.getTipo_periodo(), 
					varescenariocab.isActivo());

			Iterator iterVatEscDet = varescenariocab.getVariablesEscenarioDet().iterator();
			while (iterVatEscDet.hasNext()) {
				VarEscenarioDet varEscDet = (VarEscenarioDet) iterVatEscDet.next();
				cargarRegistroVarEscenarioDet(datasetVarEscenarioDet, varEscDet.getOIDInteger(), varEscDet.getSecu(),
						varescenariocab, varEscDet.getCompo_presu(), varEscDet.isActivo());
			}

		}

		writeCliente(datasetVarEscenarioCab);
		writeCliente(datasetVarEscenarioDet);
	}

	private IDataSet getDataSetVarEscenarioCab() {
		IDataSet dataset = new TDataSet();
		dataset.create("TVarEscenarioCab");
		dataset.fieldDef(new Field("oid_var_esc_cab", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 20));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
		dataset.fieldDef(new Field("oid_tipo_peri", Field.INTEGER, 0));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private IDataSet getDataSetVarEscenarioDet() {
		IDataSet dataset = new TDataSet();
		dataset.create("TVarEscenarioDet");
		dataset.fieldDef(new Field("oid_var_esc_det", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_var_esc_cab", Field.INTEGER, 0));
		dataset.fieldDef(new Field("secu", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_compo_presu", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_compo_presu", Field.STRING, 30));
		dataset.fieldDef(new Field("desc_compo_presu", Field.STRING, 100));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private void cargarRegistroVarEscenarioDet(IDataSet dataset, Integer oid_var_esc_det, Integer secu,
			VarEscenarioCab varEscenarioCab, CompoPresupuestario compoPresupuestario, Boolean activo) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_var_esc_det", oid_var_esc_det);
		dataset.fieldValue("oid_var_esc_cab", varEscenarioCab.getOIDInteger());
		dataset.fieldValue("secu", secu);
		dataset.fieldValue("oid_compo_presu", compoPresupuestario.getOIDInteger());
		dataset.fieldValue("cod_compo_presu", compoPresupuestario.getCodigo());
		dataset.fieldValue("desc_compo_presu", compoPresupuestario.getDescripcion());
		dataset.fieldValue("activo", compoPresupuestario.isActivo());

	}

	private void cargarRegistroVarEscenarioCab(IDataSet dataset, Integer oid_var_esc_cab, String codigo,
			String descripcion, TipoPeriodo oid_tipo_peri, Boolean activo) {
		dataset.append();
		dataset.fieldValue("oid_var_esc_cab", oid_var_esc_cab);
		dataset.fieldValue("codigo", codigo);
		dataset.fieldValue("descripcion", descripcion);
		if (oid_tipo_peri != null)
			dataset.fieldValue("oid_tipo_peri", oid_tipo_peri.getOIDInteger());
		else
			dataset.fieldValue("oid_tipo_peri", "");
		dataset.fieldValue("activo", activo);
	}

}
