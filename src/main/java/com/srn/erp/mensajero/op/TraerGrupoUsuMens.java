package com.srn.erp.mensajero.op;

import java.util.Iterator;

import com.srn.erp.mensajero.bm.GruDetUsuMens;
import com.srn.erp.mensajero.bm.GrupoUsuMens;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerGrupoUsuMens extends Operation {

	public TraerGrupoUsuMens() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		GrupoUsuMens grupousumens = null;
		if (mapaDatos.containsKey("oid")) {
			Integer oid = mapaDatos.getInteger("oid");
			grupousumens = GrupoUsuMens.findByOid(oid, getSesion());
		} else {
			String codigo = mapaDatos.getString("codigo");
			grupousumens = GrupoUsuMens.findByCodigo(codigo, getSesion());
		}

		IDataSet datasetGrupoUsuMens = getDataSetGrupoUsuMens();
		IDataSet datasetDetGrupoUsuMens = getDataSetDetGrupoUsuMens();

		if (grupousumens != null) {
			cargarRegistroGrupoUsuMens(datasetGrupoUsuMens, grupousumens);
			Iterator iterDetUsuGrupo = grupousumens.getDetUsuGrupo().iterator();
			while (iterDetUsuGrupo.hasNext()) {
				GruDetUsuMens gruDetUsuMens = (GruDetUsuMens) iterDetUsuGrupo.next();
				cargarRegistroDetGrupoUsuMens(datasetDetGrupoUsuMens, gruDetUsuMens);
			}
		}
		writeCliente(datasetGrupoUsuMens);
		writeCliente(datasetDetGrupoUsuMens);
	}

	private IDataSet getDataSetGrupoUsuMens() {
		IDataSet dataset = new TDataSet();
		dataset.create("TGrupoUsuMens");
		dataset.fieldDef(new Field("oid_grupo_dest_cab", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nombre", Field.STRING, 100));
		dataset.fieldDef(new Field("scope", Field.STRING, 1));
		dataset.fieldDef(new Field("oid_usu_priv", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_usu_priv", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_usu_priv", Field.STRING, 255));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private IDataSet getDataSetDetGrupoUsuMens() {
		IDataSet dataset = new TDataSet();
		dataset.create("TDetGrupoUsuMens");
		dataset.fieldDef(new Field("oid_grupo_dest_det", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_grupo_dest_cab", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_usuario", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 50));
		dataset.fieldDef(new Field("ape_y_nom", Field.STRING, 255));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private void cargarRegistroGrupoUsuMens(IDataSet dataset, GrupoUsuMens grupoUsuMens) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_grupo_dest_cab", grupoUsuMens.getOIDInteger());
		dataset.fieldValue("nombre", grupoUsuMens.getNombre());
		dataset.fieldValue("scope", grupoUsuMens.getScope());
		if (grupoUsuMens.getUsuario_priveado() != null) {
			dataset.fieldValue("oid_usu_priv", grupoUsuMens.getUsuario_priveado().getOIDInteger());
			dataset.fieldValue("cod_usu_priv", grupoUsuMens.getUsuario_priveado().getLogin());
			dataset.fieldValue("desc_usu_priv", grupoUsuMens.getUsuario_priveado().getApellidoyNombre());
		} else {
			dataset.fieldValue("oid_usu_priv", "");
			dataset.fieldValue("cod_usu_priv", "");
			dataset.fieldValue("desc_usu_priv", "");
		}
		dataset.fieldValue("activo", grupoUsuMens.isActivo());
	}

	private void cargarRegistroDetGrupoUsuMens(IDataSet dataset, GruDetUsuMens aGruDetUsuMens) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_grupo_dest_det", aGruDetUsuMens.getOIDInteger());
		dataset.fieldValue("oid_grupo_dest_cab", aGruDetUsuMens.getGrupo_dest_cab().getOIDInteger());
		dataset.fieldValue("oid_usuario", aGruDetUsuMens.getUsuario().getOIDInteger());
		dataset.fieldValue("codigo", aGruDetUsuMens.getUsuario().getCodigo());
		dataset.fieldValue("ape_y_nom", aGruDetUsuMens.getUsuario().getApellidoyNombre());
		dataset.fieldValue("activo", aGruDetUsuMens.isActivo());
		
		
		
	}

}
