package com.srn.erp.reclutamiento.op;

import java.util.Iterator;

import com.srn.erp.reclutamiento.bm.RecluPermisosOper;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerRecluPermisosOper extends Operation {

	public TraerRecluPermisosOper() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		
		IDataSet ds = this.getDataSetPermisosHabilitados();
		Iterator iterClaves = 
				RecluPermisosOper.getPermisos().keySet().iterator();
		while (iterClaves.hasNext()) {
			String clave = (String) iterClaves.next();
			String descripcion = (String)RecluPermisosOper.getPermisos().get(clave);
			cargarRegistro(ds, clave, descripcion);
		}
		writeCliente(ds);
		
	}

	private IDataSet getDataSetPermisosHabilitados() {
		IDataSet dataset = new TDataSet();
		dataset.create("TPermisosOperaciones");
		dataset.fieldDef(new Field("codigo", Field.STRING, 50));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
		return dataset;
	}

	private void cargarRegistro(IDataSet dataset, String codigo , String descripcion) throws BaseException {
		dataset.append();
		dataset.fieldValue("codigo", codigo);
		dataset.fieldValue("descripcion", descripcion);
	}

}
