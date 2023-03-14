package com.srn.erp.general.op;

import java.util.Iterator;

import com.srn.erp.general.bm.DefinicionAtributoEntidad;
import com.srn.erp.general.bm.TiposEntidades;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerDefinicionAtributoEntidad extends Operation {

	public TraerDefinicionAtributoEntidad() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		
		TiposEntidades tiposEntidades = new TiposEntidades();
		String codigo = mapaDatos.getString("codigo");
		String descripcion = tiposEntidades.getDescripcion(codigo);
		
		IDataSet datasetEntidad = getDataSetEntidad();
		IDataSet datasetDefinicionAtributoEntidad = getDataSetDefinicionAtributoEntidad();
		cargarRegistroEntidad(datasetEntidad,new Integer(1),codigo,descripcion);
		
		Iterator iterAtributos = DefinicionAtributoEntidad.getAtributosByNickName(codigo,getSesion()).iterator();
		while (iterAtributos.hasNext()) {
			DefinicionAtributoEntidad defAtriEnt = (DefinicionAtributoEntidad) iterAtributos.next();
			cargarRegistroDefinicionAtributoEntidad(datasetDefinicionAtributoEntidad,defAtriEnt);
		}
		
		writeCliente(datasetEntidad);
		writeCliente(datasetDefinicionAtributoEntidad);
	}

	private IDataSet getDataSetDefinicionAtributoEntidad() {
		IDataSet dataset = new TDataSet();
		dataset.create("TDefinicionAtributoEntidad");
		dataset.fieldDef(new Field("oid_atri_ent", Field.INTEGER, 0));
		dataset.fieldDef(new Field("entidad", Field.STRING, 50));
		dataset.fieldDef(new Field("nombre_logico", Field.STRING, 50));
		dataset.fieldDef(new Field("signature", Field.STRING, 255));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("nickname", Field.STRING, 50));
		return dataset;
	}

	private IDataSet getDataSetEntidad() {
		IDataSet dataset = new TDataSet();
		dataset.create("TEntidad");
		dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
		dataset.fieldDef(new Field("entidad", Field.STRING, 50));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
		return dataset;
	}

	private void cargarRegistroDefinicionAtributoEntidad(IDataSet dataset,
			DefinicionAtributoEntidad defAtriEnt) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_atri_ent", defAtriEnt.getOID());
		dataset.fieldValue("entidad", defAtriEnt.getEntidad());
		dataset.fieldValue("nombre_logico", defAtriEnt.getNombre_logico());
		dataset.fieldValue("signature", defAtriEnt.getSignature());
		dataset.fieldValue("activo", defAtriEnt.isActivo());
		dataset.fieldValue("nickname",defAtriEnt.getNombeNickName());
		
	}

	private void cargarRegistroEntidad(IDataSet dataset, Integer oid,
			String entidad, String descripcion) {
		dataset.append();
		dataset.fieldValue("oid", oid);
		dataset.fieldValue("entidad", entidad);
		dataset.fieldValue("descripcion", descripcion);
	}

}
