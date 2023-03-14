package com.srn.erp.proveedoresMaterials.op;

import java.util.Iterator;
import java.util.List;

import com.srn.erp.proveedoresMaterials.bm.GrupoProveedor;
import com.srn.erp.proveedoresMaterials.bm.GrupoProveedorBase;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerGrupoProveedor extends Operation {

	public TraerGrupoProveedor() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		GrupoProveedor grupoproveedor = null;
		List<GrupoProveedorBase> grupoProveedorUte = null;
		List<GrupoProveedorBase> grupoProveedorBinbaires = null;
		List<GrupoProveedorBase> grupoProveedorAlavera = null;
		List<GrupoProveedorBase> grupoProveedorMagci = null;
		if (mapaDatos.containsKey("oid")) {
			Integer oid = mapaDatos.getInteger("oid");
			grupoproveedor = GrupoProveedor.findByOid(oid, getSesion());
		} else {
			String codigo = mapaDatos.getString("codigo");
			grupoproveedor = GrupoProveedor.findByCodigo(codigo, getSesion());
		}

		IDataSet datasetGrupoProveedor = getDataSetGrupoProveedor();
		if (grupoproveedor != null) {
			cargarRegistroGrupoProveedor(datasetGrupoProveedor, grupoproveedor);
		}

		grupoProveedorUte = GrupoProveedorBase.findAllUte(getSesion());
		grupoProveedorBinbaires = GrupoProveedorBase.findAllBinbaires(getSesion());
		grupoProveedorAlavera = GrupoProveedorBase.findAllAlavera(getSesion());
		grupoProveedorMagci = GrupoProveedorBase.findAllMagic(getSesion());

		IDataSet datasetGrupoProveedorUte = getDataSetGrupoProveedorUte();
		IDataSet datasetGrupoProveedorBinbaires = getDataSetGrupoProveedorBinbaires();
		IDataSet datasetGrupoProveedorAlavaera = getDataSetGrupoProveedorAlavera();
		IDataSet datasetGrupoProveedorMagic = getDataSetGrupoProveedorMagic();

		if (grupoProveedorUte != null) {
			cargarRegistroGrupoProveedorUte(datasetGrupoProveedorUte, grupoProveedorUte);
		}
		if (grupoProveedorBinbaires != null) {
			cargarRegistroGrupoProveedorBinbaires(datasetGrupoProveedorBinbaires, grupoProveedorBinbaires);
		}
		if (grupoProveedorAlavera != null) {
			cargarRegistroGrupoProveedorAlavera(datasetGrupoProveedorAlavaera, grupoProveedorAlavera);
		}
		if (grupoProveedorMagci != null) {
			cargarRegistroGrupoProveedorMagic(datasetGrupoProveedorMagic, grupoProveedorMagci);
		}

		writeCliente(datasetGrupoProveedorUte);
		writeCliente(datasetGrupoProveedorBinbaires);
		writeCliente(datasetGrupoProveedorAlavaera);
		writeCliente(datasetGrupoProveedorMagic);
		writeCliente(datasetGrupoProveedor);
	}

	private IDataSet getDataSetGrupoProveedor() {
		IDataSet dataset = new TDataSet();
		dataset.create("TGrupoProveedor");
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

	private void cargarRegistroGrupoProveedor(IDataSet dataset, GrupoProveedor grupoproveedor) throws BaseException {
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
	
	private IDataSet getDataSetGrupoProveedorUte() {
		IDataSet dataset = new TDataSet();
		dataset.create("TGrupoUte");
		dataset.fieldDef(new Field("oid_grupo_ute", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nombre", Field.STRING, 200));
		return dataset;
	}

	private IDataSet getDataSetGrupoProveedorBinbaires() {
		IDataSet dataset = new TDataSet();
		dataset.create("TGrupoBinbaires");
		dataset.fieldDef(new Field("oid_grupo_binbaires", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nombre", Field.STRING, 200));
		return dataset;
	}

	private IDataSet getDataSetGrupoProveedorAlavera() {
		IDataSet dataset = new TDataSet();
		dataset.create("TGrupoAlavera");
		dataset.fieldDef(new Field("oid_grupo_alavera", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nombre", Field.STRING, 200));
		return dataset;
	}

	private IDataSet getDataSetGrupoProveedorMagic() {
		IDataSet dataset = new TDataSet();
		dataset.create("TGrupoMagic");
		dataset.fieldDef(new Field("oid_grupo_magic", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nombre", Field.STRING, 200));
		return dataset;
	}

	private void cargarRegistroGrupoProveedorUte(IDataSet dataset, List<GrupoProveedorBase> grupoProveedor) throws BaseException {
		Iterator itGrupo = grupoProveedor.iterator();
		while (itGrupo.hasNext()) {
			GrupoProveedorBase grupo = (GrupoProveedorBase) itGrupo.next();
			dataset.append();
			dataset.fieldValue("oid_grupo_ute", grupo.getOID());
			dataset.fieldValue("nombre", grupo.getNombre());
		}
	}
	
	private void cargarRegistroGrupoProveedorBinbaires(IDataSet dataset, List<GrupoProveedorBase> grupoProveedor) throws BaseException {
		Iterator itGrupo = grupoProveedor.iterator();
		while (itGrupo.hasNext()) {
			GrupoProveedorBase grupo = (GrupoProveedorBase) itGrupo.next();
			dataset.append();
			dataset.fieldValue("oid_grupo_binbaires", grupo.getOID());
			dataset.fieldValue("nombre", grupo.getNombre());
		}
	}
	
	private void cargarRegistroGrupoProveedorAlavera(IDataSet dataset, List<GrupoProveedorBase> grupoProveedor) throws BaseException {
		Iterator itGrupo = grupoProveedor.iterator();
		while (itGrupo.hasNext()) {
			GrupoProveedorBase grupo = (GrupoProveedorBase) itGrupo.next();
			dataset.append();
			dataset.fieldValue("oid_grupo_alavera", grupo.getOID());
			dataset.fieldValue("nombre", grupo.getNombre());
		}
	}
	
	private void cargarRegistroGrupoProveedorMagic(IDataSet dataset, List<GrupoProveedorBase> grupoProveedor) throws BaseException {
		Iterator itGrupo = grupoProveedor.iterator();
		while (itGrupo.hasNext()) {
			GrupoProveedorBase grupo = (GrupoProveedorBase) itGrupo.next();
			dataset.append();
			dataset.fieldValue("oid_grupo_magic", grupo.getOID());
			dataset.fieldValue("nombre", grupo.getNombre());
		}
	}
}
