package com.srn.erp.rrhh.op;

import java.util.Iterator;

import com.srn.erp.rrhh.bm.MotivoTipoNov;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerMotivosNovLeg extends Operation {

	public TraerMotivosNovLeg() {

	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		IDataSet ds = this.getDataSetMotVisFalRRHH();
		Iterator iterMot = MotivoTipoNov.getAll(this.getSesion()).iterator();
		while (iterMot.hasNext()) {
			MotivoTipoNov motivoTipoNov = (MotivoTipoNov) iterMot.next();
			cargarRegistro(ds, motivoTipoNov);
		}
		writeCliente(ds);

	}

	private IDataSet getDataSetMotVisFalRRHH() {
		IDataSet dataset = new TDataSet();
		dataset.create("TMotivosNov");
		dataset.fieldDef(new Field("oid_tipo_nov", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 50));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private void cargarRegistro(IDataSet dataset, MotivoTipoNov aMotivo) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_tipo_nov", aMotivo.getTipo_novedad().getOIDInteger());
		dataset.fieldValue("oid", aMotivo.getOIDInteger());
		dataset.fieldValue("codigo", aMotivo.getCodigo());
		dataset.fieldValue("descripcion", aMotivo.getDescripcion());
		dataset.fieldValue("activo", aMotivo.isActivo());
	}
}
