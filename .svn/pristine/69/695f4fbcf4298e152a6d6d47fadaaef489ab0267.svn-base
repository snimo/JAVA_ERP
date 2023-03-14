package com.srn.erp.proveedoresMaterials.op;

import com.srn.erp.proveedoresMaterials.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.IDataSet;

public class SaveGrupoProveedor extends Operation {

	public SaveGrupoProveedor() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		IDataSet dataset = mapaDatos.getDataSet("TGrupoProveedor");
		procesarRegistros(dataset);
	}

	private void procesarRegistros(IDataSet dataset) throws BaseException {
		dataset.first();
		while (!dataset.EOF()) {
			GrupoProveedor grupoproveedor = GrupoProveedor.findByOid(dataset.getInteger("oid_grupo_proveedor"), getSesion());
			grupoproveedor.setOID(dataset.getInteger("oid_grupo_proveedor"));
			grupoproveedor.setCodigo(dataset.getString("codigo"));
			grupoproveedor.setDescripcion(dataset.getString("descripcion"));
			grupoproveedor.setGrupoute(dataset.getInteger("oid_grupo_ute"));
			grupoproveedor.setGrupobinbaires(dataset.getInteger("oid_grupo_binbaires"));
			grupoproveedor.setGrupoalavera(dataset.getInteger("oid_grupo_alavera"));
			grupoproveedor.setGrupomagic(dataset.getInteger("oid_grupo_magic"));
			grupoproveedor.setActivo(dataset.getBoolean("activo"));
			addTransaccion(grupoproveedor);
			dataset.next();
		}
	}

}
