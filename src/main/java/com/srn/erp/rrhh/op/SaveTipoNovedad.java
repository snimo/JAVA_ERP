package com.srn.erp.rrhh.op;

import com.srn.erp.rrhh.bm.MotivoTipoNov;
import com.srn.erp.rrhh.bm.TipoNovedad;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveTipoNovedad extends Operation {

	public SaveTipoNovedad() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		IDataSet dataset = mapaDatos.getDataSet("TTipoNovedad");
		procesarRegistros(dataset);
	}

	private void procesarRegistros(IDataSet dataset) throws BaseException {
		dataset.first();
		while (!dataset.EOF()) {
			TipoNovedad tiponovedad = TipoNovedad.findByOid(dataset.getInteger("oid_tipo_novedad"), getSesion());
			tiponovedad.setOID(dataset.getInteger("oid_tipo_novedad"));
			tiponovedad.setCodigo(dataset.getString("codigo"));
			tiponovedad.setDescripcion(dataset.getString("descripcion"));
			tiponovedad.setActivo(dataset.getBoolean("activo"));
			
			IDataSet dsMotivo = dataset.getDataSet("TMotivoTipoNov");
			dsMotivo.first();
			while (!dsMotivo.EOF()) {
				MotivoTipoNov motivo = MotivoTipoNov.findByOid(dsMotivo.getInteger("oid_mot_tipo_nov"), this.getSesion());
				motivo.setTipo_novedad(tiponovedad);
				motivo.setCodigo(dsMotivo.getString("codigo"));
				motivo.setDescripcion(dsMotivo.getString("descripcion"));
				motivo.setActivo(dsMotivo.getBoolean("activo"));
				
				tiponovedad.addMotivo(motivo);
				
				dsMotivo.next();
			}
			
			
			addTransaccion(tiponovedad);
			dataset.next();
		}
	}

}
