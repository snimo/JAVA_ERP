package com.srn.erp.proveedoresMaterials.op;

import java.util.Iterator;
import java.util.List;

import com.srn.erp.proveedoresMaterials.bm.GrupoProveedor;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerGruposProveedores extends Operation {

	public TraerGruposProveedores() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		List<GrupoProveedor> grupoproveedor = null;
		
		grupoproveedor = GrupoProveedor.findAll(getSesion());

		IDataSet datasetGrupoProveedor = getDataSetGrupoProveedor();
		if (grupoproveedor != null) {
			cargarRegistroGrupoProveedor(datasetGrupoProveedor, grupoproveedor);
		}

		writeCliente(datasetGrupoProveedor);
	}

	private IDataSet getDataSetGrupoProveedor() {
		IDataSet dataset = new TDataSet();
		dataset.create("TGrupoProveedores");
		dataset.fieldDef(new Field("oid_grupo_proveedor", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 50));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
		dataset.fieldDef(new Field("oid_grupo_ute", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_grupo_binbaires", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_grupo_alavera", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_grupo_magic", Field.INTEGER, 0));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private void cargarRegistroGrupoProveedor(IDataSet dataset, List<GrupoProveedor> grupoProveedores) throws BaseException {
		Iterator itGrupo = grupoProveedores.iterator();
		while (itGrupo.hasNext()) {
			GrupoProveedor grupoproveedor = (GrupoProveedor) itGrupo.next();
			dataset.append();
			dataset.fieldValue("oid_grupo_proveedor", grupoproveedor.getOIDInteger());
			dataset.fieldValue("codigo", grupoproveedor.getCodigo());
			dataset.fieldValue("descripcion", grupoproveedor.getDescripcion());
			dataset.fieldValue("oid_grupo_ute", grupoproveedor.getGrupoute());
			dataset.fieldValue("oid_grupo_binbaires", grupoproveedor.getGrupobinbaires());
			dataset.fieldValue("oid_grupo_alavera", grupoproveedor.getGrupoalavera());
			dataset.fieldValue("oid_grupo_magic", grupoproveedor.getGrupomagic());
			dataset.fieldValue("activo", grupoproveedor.isActivo());
		}
	}
	
}
