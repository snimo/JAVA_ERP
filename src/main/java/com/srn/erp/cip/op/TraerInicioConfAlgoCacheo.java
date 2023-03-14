package com.srn.erp.cip.op;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerInicioConfAlgoCacheo extends Operation {

	public TraerInicioConfAlgoCacheo() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		
		IDataSet dsFiltroLegajo = this.getDataSetFiltroLegajo();
		IDataSet dsPoblacionLeg = this.getDataSetPoblacionLegajo();
		IDataSet dsFiltrosEstados = getDataSetFiltrosEstados();
		
		cargarRegistroFiltroLegajo(dsFiltroLegajo, "NO", "Sin Filtro");
		cargarRegistroFiltroLegajo(dsFiltroLegajo, "SI", "Según valores de clasificadores");
		
		cargarRegistroPoblacionLegajo(dsPoblacionLeg, "TODOS", "Todos los legajos");
		cargarRegistroPoblacionLegajo(dsPoblacionLeg, "PLANIF", "Los que tengan planificación");
		
		cargarRegistroFiltroEstado(dsFiltrosEstados,"SI","Si");
		cargarRegistroFiltroEstado(dsFiltrosEstados,"NO","No");
		
		writeCliente(dsPoblacionLeg);
		writeCliente(dsFiltroLegajo);
		writeCliente(dsFiltrosEstados);
	}

	private IDataSet getDataSetFiltroLegajo() {
		IDataSet dataset = new TDataSet();
		dataset.create("TFiltrosLegajo");
		dataset.fieldDef(new Field("codigo", Field.STRING, 50));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
		return dataset;
	}
	
	private IDataSet getDataSetPoblacionLegajo() {
		IDataSet dataset = new TDataSet();
		dataset.create("TPoblacionLegajo");
		dataset.fieldDef(new Field("codigo", Field.STRING, 50));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
		return dataset;
	}
	
	private IDataSet getDataSetFiltrosEstados() {
		IDataSet dataset = new TDataSet();
		dataset.create("TFiltrosEstados");
		dataset.fieldDef(new Field("codigo", Field.STRING, 50));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
		return dataset;
	}	
	
	
	private void cargarRegistroFiltroEstado(IDataSet dataset, String codigo, String descripcion) {
		dataset.append();
		dataset.fieldValue("codigo", codigo);
		dataset.fieldValue("descripcion", descripcion);
	}
	

	private void cargarRegistroFiltroLegajo(IDataSet dataset, String codigo, String descripcion) {
		dataset.append();
		dataset.fieldValue("codigo", codigo);
		dataset.fieldValue("descripcion", descripcion);
	}
	
	private void cargarRegistroPoblacionLegajo(IDataSet dataset, String codigo, String descripcion) {
		dataset.append();
		dataset.fieldValue("codigo", codigo);
		dataset.fieldValue("descripcion", descripcion);
	}	

}
