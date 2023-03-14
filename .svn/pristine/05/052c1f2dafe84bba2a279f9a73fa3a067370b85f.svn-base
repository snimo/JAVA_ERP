package com.srn.erp.cip.op;

import java.util.Iterator;

import com.srn.erp.cip.bm.CategAccesoCIP;

import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerCategAccParaHabi extends Operation {

	public TraerCategAccParaHabi() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		Usuario usuario = Usuario.findByOidProxy(this.getSesion().getLogin()
				.getUsuario().getOID(), this.getSesion());

		IDataSet ds = getDataSetCategAcceso();
		Iterator iterCategAcceso = CategAccesoCIP.getCategAccPuedeOtorgar(
				usuario, this.getSesion()).iterator();
		while (iterCategAcceso.hasNext()) {
			CategAccesoCIP categoriaAcceso = (CategAccesoCIP) iterCategAcceso
					.next();
			cargarCategPuedeHab(ds, categoriaAcceso);
		}
		writeCliente(ds);

	}

	private IDataSet getDataSetCategAcceso() {
		IDataSet dataset = new TDataSet();
		dataset.create("TCategPuedeHabilitar");
		dataset.fieldDef(new Field("oid_categ_acceso", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_categ_acceso", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_categ_acceso", Field.STRING, 100));
		dataset.fieldDef(new Field("grupo", Field.STRING, 100));
		dataset.fieldDef(new Field("subgrupo", Field.STRING, 100));
		dataset.fieldDef(new Field("habilitar", Field.BOOLEAN, 0));
		return dataset;
	}

	private void cargarCategPuedeHab(IDataSet ds, CategAccesoCIP categoria)
			throws BaseException {
		ds.append();
		ds.fieldValue("oid_categ_acceso", categoria.getOIDInteger());
		ds.fieldValue("cod_categ_acceso", categoria.getCodigo());
		ds.fieldValue("desc_categ_acceso", categoria.getDescripcion());
		ds.fieldValue("grupo", categoria.getSubGrupo()
						.getGrupo_categoria().getOrden()
						+ " "
						+ categoria.getSubGrupo().getGrupo_categoria()
								.getDescripcion());
		ds.fieldValue("subgrupo", categoria.getSubGrupo().getOrden() + " "
				+ categoria.getSubGrupo().getDescripcion());
		ds.fieldValue("habilitar", false);
	}

	private void cargarRegistroAgrupadorPlano(IDataSet dataset,
			Integer oid_agrup_plano, 
			String codigo, String descripcion,
			Integer orden, Boolean activo) {
		dataset.append();
		dataset.fieldValue("oid_agrup_plano", oid_agrup_plano);
		dataset.fieldValue("codigo", codigo);
		dataset.fieldValue("descripcion", descripcion);
		dataset.fieldValue("orden", orden);
		dataset.fieldValue("activo", activo);
	}
}
