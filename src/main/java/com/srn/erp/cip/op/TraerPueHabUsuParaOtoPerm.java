package com.srn.erp.cip.op;

import java.util.Iterator;

import com.srn.erp.cip.bm.GrupoPuerta;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerPueHabUsuParaOtoPerm extends Operation {

	public TraerPueHabUsuParaOtoPerm() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		
		String accion = mapaDatos.getString("accion");
		String habilitar = mapaDatos.getString("habilitar");
		
		IDataSet ds = this.getDataSetGrupoPuerta();
		
		Iterator iterGrupoPuerta = 
			GrupoPuerta.getGrupoPuertasHabPermisosUsu(accion,habilitar,this.getSesion()).iterator();
		while (iterGrupoPuerta.hasNext()) {
			GrupoPuerta grupoPuerta = (GrupoPuerta) iterGrupoPuerta.next();
			cargarRegistroGrupoPuerta(ds, grupoPuerta);
		}
		
		writeCliente(ds);
				
		
	}
	

	private IDataSet getDataSetGrupoPuerta() {
		IDataSet dataset = new TDataSet();
		dataset.create("TGrupoPuerto");
		dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 50));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
		dataset.fieldDef(new Field("hora", Field.STRING, 5));
		return dataset;
	}

	private void cargarRegistroGrupoPuerta(
			IDataSet dataset, 
			GrupoPuerta grupoPuerta) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid", grupoPuerta.getOIDInteger());
		dataset.fieldValue("codigo", grupoPuerta.getCodigo());
		dataset.fieldValue("descripcion", grupoPuerta.getDescripcion());
		dataset.fieldValue("hora", Fecha.getHoraActual());
	}

}
