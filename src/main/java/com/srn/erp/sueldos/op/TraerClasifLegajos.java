package com.srn.erp.sueldos.op;

import java.util.Iterator;

import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.sueldos.bm.Legajo;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerClasifLegajos extends Operation {

	public TraerClasifLegajos() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		inicializarClasif(mapaDatos);
	}

	private IDataSet getDataSetClasificadorEntidad() {
		IDataSet dataset = new TDataSet();
		dataset.create("TClasificadoresLegajo");
		dataset.fieldDef(new Field("oid_clasif_ent", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 20));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
		dataset.fieldDef(new Field("nickname", Field.STRING, 30));
		dataset.fieldDef(new Field("obligatorio", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("nro_clasif", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_grupo_clasif", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_grupo_clasif", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_grupo_clasif", Field.STRING, 100));
		return dataset;
	}

	private void inicializarClasif(MapDatos mapaDatos) throws BaseException {
		IDataSet dsClasifEnt = getDataSetClasificadorEntidad();
		Iterator iterClasifEnt = Legajo.getClasificadoresEntidadActivos(getSesion()).iterator();
		while (iterClasifEnt.hasNext()) {
			ClasificadorEntidad clasifEnt = (ClasificadorEntidad) iterClasifEnt.next();
			cargarRegistroClasificadorEntidad(dsClasifEnt, clasifEnt);
		}
		writeCliente(dsClasifEnt);
	}

	private void cargarRegistroClasificadorEntidad(IDataSet dataset, ClasificadorEntidad clasifEnt) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_clasif_ent", clasifEnt.getOIDInteger());
		dataset.fieldValue("codigo", clasifEnt.getCodigo());
		dataset.fieldValue("descripcion", clasifEnt.getDescripcion());
		dataset.fieldValue("nickname", clasifEnt.getNickname());
		dataset.fieldValue("obligatorio", clasifEnt.isObligatorio());
		dataset.fieldValue("activo", clasifEnt.isActivo());
		dataset.fieldValue("nro_clasif", clasifEnt.getNroClasif());
		dataset.fieldValue("oid_grupo_clasif", clasifEnt.getGrupo().getOIDInteger());
		dataset.fieldValue("cod_grupo_clasif", clasifEnt.getGrupo().getCodigo());
		dataset.fieldValue("desc_grupo_clasif", clasifEnt.getGrupo().getDescripcion());

	}

}
