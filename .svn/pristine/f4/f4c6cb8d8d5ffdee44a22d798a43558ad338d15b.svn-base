package com.srn.erp.proveedoresMaterials.op;

import java.util.Iterator;
import java.util.List;

import com.srn.erp.proveedoresMaterials.bm.GrupoProveedorBase;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerGrupoProveedorBase extends Operation {

	public TraerGrupoProveedorBase() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		List<GrupoProveedorBase> grupoProveedorUte = null;
		List<GrupoProveedorBase> grupoProveedorBinbaires = null;
		List<GrupoProveedorBase> grupoProveedorAlavera = null;
		List<GrupoProveedorBase> grupoProveedorMagci = null;

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
