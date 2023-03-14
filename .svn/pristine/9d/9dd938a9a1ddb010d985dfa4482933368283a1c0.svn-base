package com.srn.erp.cip.op;

import java.util.Iterator;

import com.srn.erp.cip.bm.EquivMotEntIntermedias;
import com.srn.erp.cip.bm.MotivoEntIntermedias;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerMotivoEntIntermedias extends Operation {

	public TraerMotivoEntIntermedias() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		MotivoEntIntermedias motivoentintermedias = null;
		if (mapaDatos.containsKey("oid")) {
			Integer oid = mapaDatos.getInteger("oid");
			motivoentintermedias = MotivoEntIntermedias.findByOid(oid, getSesion());
		} else {
			String codigo = mapaDatos.getString("codigo");
			motivoentintermedias = MotivoEntIntermedias.findByCodigo(codigo, getSesion());
		}

		IDataSet datasetMotivoEntIntermedias = getDataSetMotivoEntIntermedias();
		IDataSet dsEquivalencias = getDataSetEquivMotEntIntermedias();
		
		if (motivoentintermedias != null) {
			
			cargarRegistroMotivoEntIntermedias(
					datasetMotivoEntIntermedias, 
					motivoentintermedias.getOIDInteger(), 
					motivoentintermedias.getCodigo(), 
					motivoentintermedias.getDescripcion(), 
					motivoentintermedias.isActivo());
			
			Iterator iterEquiv = 
				motivoentintermedias.getEquivalencias().iterator();
			while (iterEquiv.hasNext()) {
				EquivMotEntIntermedias equivMotEntIntermedias = (EquivMotEntIntermedias) iterEquiv.next();
				cargarRegistroEquivMotEntIntermedias(dsEquivalencias, equivMotEntIntermedias.getOIDInteger(), equivMotEntIntermedias.getCodigo(),motivoentintermedias, motivoentintermedias.isActivo());
			}
			
		}
		
		writeCliente(datasetMotivoEntIntermedias);
		writeCliente(dsEquivalencias);
		
	}

	private IDataSet getDataSetMotivoEntIntermedias() {
		IDataSet dataset = new TDataSet();
		dataset.create("TMotivoEntIntermedias");
		dataset.fieldDef(new Field("oid_motivo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 50));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private void cargarRegistroMotivoEntIntermedias(IDataSet dataset, Integer oid_motivo, String codigo, String descripcion, Boolean activo) {
		dataset.append();
		dataset.fieldValue("oid_motivo", oid_motivo);
		dataset.fieldValue("codigo", codigo);
		dataset.fieldValue("descripcion", descripcion);
		dataset.fieldValue("activo", activo);
	}

	private IDataSet getDataSetEquivMotEntIntermedias() {
		IDataSet dataset = new TDataSet();
		dataset.create("TEquivMotEntIntermedias");
		dataset.fieldDef(new Field("oid_equiv_mot", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 50));
		dataset.fieldDef(new Field("oid_motivo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private void cargarRegistroEquivMotEntIntermedias(IDataSet dataset, Integer oid_equiv_mot, String codigo,
			MotivoEntIntermedias motivo, Boolean activo) {
		dataset.append();
		dataset.fieldValue("oid_equiv_mot", oid_equiv_mot);
		dataset.fieldValue("codigo", codigo);
		dataset.fieldValue("oid_motivo", motivo.getOID());
		dataset.fieldValue("activo", activo);
	}
}
