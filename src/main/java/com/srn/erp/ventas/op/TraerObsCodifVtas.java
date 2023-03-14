package com.srn.erp.ventas.op;

import java.util.Iterator;

import com.srn.erp.ventas.bm.ObsCodifVtas;
import com.srn.erp.ventas.bm.ObsCodifVtasIdioma;
import com.srn.erp.ventas.bm.ObsCodifVtasSucursal;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerObsCodifVtas extends Operation {

	public TraerObsCodifVtas() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		ObsCodifVtas obscodifvtas = null;
		if (mapaDatos.containsKey("oid")) {
			Integer oid = mapaDatos.getInteger("oid");
			obscodifvtas = ObsCodifVtas.findByOid(oid, getSesion());
		} else {
			String codigo = mapaDatos.getString("codigo");
			obscodifvtas = ObsCodifVtas.findByCodigo(codigo, getSesion());
		}

		IDataSet datasetObsCodifVtas = getDataSetObsCodifVtas();
		IDataSet datasetObsIdioma = getDataSetObsCodifVtasIdioma();
		IDataSet datasetObsSucursal = getDataSetObsCodifVtasSucursal();

		if (obscodifvtas != null) {

			cargarRegistroObsCodifVtas(datasetObsCodifVtas, obscodifvtas.getOIDInteger(), obscodifvtas.getCodigo(), obscodifvtas
					.getDescripcion(), obscodifvtas.isIncluir(), obscodifvtas.isActivo(), obscodifvtas.getTipo(), obscodifvtas.getOrden());

			Iterator iterObsIdioma = obscodifvtas.getObservacionesIdioma().iterator();
			while (iterObsIdioma.hasNext()) {
				ObsCodifVtasIdioma obsCodifIdioma = (ObsCodifVtasIdioma) iterObsIdioma.next();
				if (!obsCodifIdioma.isActivo()) continue;
				cargarRegistroObsCodifVtasIdioma(datasetObsIdioma, obsCodifIdioma);
			}
			
			Iterator iterObsSucursal = 
				obscodifvtas.getObservacionesSucursal().iterator();
			while (iterObsSucursal.hasNext()) {
				ObsCodifVtasSucursal obscodSucursal = (ObsCodifVtasSucursal) iterObsSucursal.next();
				if (!obscodSucursal.isActivo()) continue;
				cargarRegistroObsCodifVtasSucursal(datasetObsSucursal, obscodSucursal);
			}

		}

		writeCliente(datasetObsCodifVtas);
		writeCliente(datasetObsIdioma);
		writeCliente(datasetObsSucursal);

	}

	private IDataSet getDataSetObsCodifVtas() {
		IDataSet dataset = new TDataSet();
		dataset.create("TObsCodifVtas");
		dataset.fieldDef(new Field("oid_obs_cod", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 50));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 5000));
		dataset.fieldDef(new Field("incluir", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("tipo", Field.STRING, 50));
		dataset.fieldDef(new Field("orden", Field.INTEGER, 0));
		return dataset;
	}

	private void cargarRegistroObsCodifVtas(IDataSet dataset, Integer oid_obs_cod, String codigo, String descripcion, Boolean incluir,
			Boolean activo, String tipo, Integer orden) {
		dataset.append();
		dataset.fieldValue("oid_obs_cod", oid_obs_cod);
		dataset.fieldValue("codigo", codigo);
		dataset.fieldValue("descripcion", descripcion);
		dataset.fieldValue("incluir", incluir);
		dataset.fieldValue("activo", activo);
		dataset.fieldValue("tipo", tipo);
		dataset.fieldValue("orden", orden);
	}

	private IDataSet getDataSetObsCodifVtasIdioma() {
		IDataSet dataset = new TDataSet();
		dataset.create("TObsCodifVtasIdioma");
		dataset.fieldDef(new Field("oid_obs_idioma", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_obs_cod", Field.INTEGER, 0));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 5000));
		dataset.fieldDef(new Field("oid_idioma", Field.STRING, 0));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private void cargarRegistroObsCodifVtasIdioma(IDataSet dataset, ObsCodifVtasIdioma obsCodifIdioma) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_obs_idioma", obsCodifIdioma.getOIDInteger());
		dataset.fieldValue("oid_obs_cod", obsCodifIdioma.getCodigo_observacion().getOIDInteger());
		dataset.fieldValue("descripcion", obsCodifIdioma.getDescripcion());
		dataset.fieldValue("oid_idioma", obsCodifIdioma.getIdioma().getOIDInteger());
		dataset.fieldValue("activo", obsCodifIdioma.isActivo());
	}

	private IDataSet getDataSetObsCodifVtasSucursal() {
		IDataSet dataset = new TDataSet();
		dataset.create("TObsCodifVtasSucursal");
		dataset.fieldDef(new Field("oid_obs_cod_uo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_obs_cod", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_sucursal", Field.INTEGER, 0));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private void cargarRegistroObsCodifVtasSucursal(IDataSet dataset, ObsCodifVtasSucursal obsCodifVtasSuc) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_obs_cod_uo", obsCodifVtasSuc.getOIDInteger());
		dataset.fieldValue("oid_obs_cod", obsCodifVtasSuc.getCodigo_observacion().getOIDInteger());
		dataset.fieldValue("oid_sucursal", obsCodifVtasSuc.getSucursal().getOIDInteger());
		dataset.fieldValue("activo", obsCodifVtasSuc.isActivo());
	}

}
