package com.srn.erp.rrhh.op;

import java.util.Iterator;

import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.general.bm.ValorClasificadorEntidad;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerCategoriasLegajo extends Operation {

	public TraerCategoriasLegajo() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		IDataSet ds = this.getDataSetCategorias();
		
		ClasificadorEntidad clasifPuesto = TraerLeyendasRepEval.getClasificadorPuesto(this.getSesion());
		Iterator iterPuestos = clasifPuesto.getValoresClasificador().iterator();
		while (iterPuestos.hasNext()) {
			ValorClasificadorEntidad valorClasificadorEntidad = (ValorClasificadorEntidad) iterPuestos.next();
			cargarRegistroCategoria(ds, valorClasificadorEntidad);
		}
		
		writeCliente(ds);

	}

	private IDataSet getDataSetCategorias() {
		IDataSet dataset = new TDataSet();
		dataset.create("TCategorias");
		dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 50));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
		return dataset;
	}

	private void cargarRegistroCategoria(IDataSet dataset, ValorClasificadorEntidad valorClasifEnt) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid", valorClasifEnt.getOIDInteger());
		dataset.fieldValue("codigo", valorClasifEnt.getCodigo());
		dataset.fieldValue("descripcion", valorClasifEnt.getDescripcion());
	}

}
