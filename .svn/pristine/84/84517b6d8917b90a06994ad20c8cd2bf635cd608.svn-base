package com.srn.erp.rrhh.op;

import java.util.Iterator;

import com.srn.erp.rrhh.bm.MotivoTipoNov;
import com.srn.erp.rrhh.bm.TipoNovedad;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerTipoNovedad extends Operation {

	public TraerTipoNovedad() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		TipoNovedad tiponovedad = null;
		if (mapaDatos.containsKey("oid")) {
			Integer oid = mapaDatos.getInteger("oid");
			tiponovedad = TipoNovedad.findByOid(oid, getSesion());
		} else {
			String codigo = mapaDatos.getString("codigo");
			tiponovedad = TipoNovedad.findByCodigo(codigo, getSesion());
		}

		IDataSet datasetTipoNovedad = getDataSetTipoNovedad();
		IDataSet datasetMotivo = getDataSetMotivoTipoNovedad();
		
		if (tiponovedad != null) {
			cargarRegistroTipoNovedad(datasetTipoNovedad, 
									  tiponovedad.getOIDInteger(), 
									  tiponovedad.getCodigo(), 
									  tiponovedad.getDescripcion(), 
									  tiponovedad.isActivo());
			
			Iterator iterMotivos = tiponovedad.getMotivos().iterator();
			while (iterMotivos.hasNext()) {
				MotivoTipoNov motivoTipoNov = (MotivoTipoNov) iterMotivos.next();
				cargarRegistroMotivoTipoNovedad(datasetMotivo,motivoTipoNov);
			}
			
		}
		
		writeCliente(datasetTipoNovedad);
		writeCliente(datasetMotivo);
	}

	private IDataSet getDataSetTipoNovedad() {
		IDataSet dataset = new TDataSet();
		dataset.create("TTipoNovedad");
		dataset.fieldDef(new Field("oid_tipo_novedad", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 50));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}
	
	private IDataSet getDataSetMotivoTipoNovedad() {
		IDataSet dataset = new TDataSet();
		dataset.create("TMotivoTipoNov");
		dataset.fieldDef(new Field("oid_mot_tipo_nov", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_tipo_nov", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 50));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}
	

	private void cargarRegistroTipoNovedad(IDataSet dataset, Integer oid_tipo_novedad, String codigo, String descripcion, Boolean activo) {
		dataset.append();
		dataset.fieldValue("oid_tipo_novedad", oid_tipo_novedad);
		dataset.fieldValue("codigo", codigo);
		dataset.fieldValue("descripcion", descripcion);
		dataset.fieldValue("activo", activo);
	}
	
	private void cargarRegistroMotivoTipoNovedad(IDataSet dataset, MotivoTipoNov motivo) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_mot_tipo_nov", motivo.getOIDInteger());
		dataset.fieldValue("oid_tipo_nov", motivo.getTipo_novedad().getOIDInteger());
		dataset.fieldValue("codigo", motivo.getCodigo());
		dataset.fieldValue("descripcion", motivo.getDescripcion());
		dataset.fieldValue("activo", motivo.isActivo());
	}
	
	
}
