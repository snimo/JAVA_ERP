package com.srn.erp.rrhh.op;

import com.srn.erp.rrhh.bm.MesCronoDesa;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerMesesDesarrollo extends Operation {

	public TraerMesesDesarrollo() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		IDataSet ds = this.getDataSetMeses();
		
		
		cargarRegistroMeses(ds,MesCronoDesa.ENERO, "Enero");
		cargarRegistroMeses(ds,MesCronoDesa.FEBRERO, "Febrero");
		cargarRegistroMeses(ds,MesCronoDesa.MARZO, "Marzo");
		cargarRegistroMeses(ds,MesCronoDesa.ABRIL, "Abril");
		cargarRegistroMeses(ds,MesCronoDesa.MAYO, "Mayo");
		cargarRegistroMeses(ds,MesCronoDesa.JUNIO, "Junio");
		cargarRegistroMeses(ds,MesCronoDesa.JULIO, "Julio");
		cargarRegistroMeses(ds,MesCronoDesa.AGOSTO, "Agosto");
		cargarRegistroMeses(ds,MesCronoDesa.SEPTIEMBRE, "Septiembre");
		cargarRegistroMeses(ds,MesCronoDesa.OCTUBRE, "Octubre");
		cargarRegistroMeses(ds,MesCronoDesa.NOVIEMBRE, "Noviembre");
		cargarRegistroMeses(ds,MesCronoDesa.DICIEMBRE, "Diciembre");
		
		
		writeCliente(ds);
		
	}

	private IDataSet getDataSetMeses() {
		IDataSet dataset = new TDataSet();
		dataset.create("TMesesDesarrollo");
		dataset.fieldDef(new Field("mes", Field.STRING, 50));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
		return dataset;
	}

	private void cargarRegistroMeses(IDataSet dataset, String mes, String descripcion) throws BaseException {
		dataset.append();
		dataset.fieldValue("mes", mes);
		dataset.fieldValue("descripcion", descripcion);
	}

}
