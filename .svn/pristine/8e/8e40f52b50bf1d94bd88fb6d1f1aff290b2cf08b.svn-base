package com.srn.erp.excluidos.op;

import com.srn.erp.excluidos.bm.EstadoExcluido;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class ValidarCargaNroEstado extends Operation {

	public ValidarCargaNroEstado() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		
		EstadoExcluido estadoexcluido = EstadoExcluido.findByOid(mapaDatos.getInteger("oid_estado"), this.getSesion());
		IDataSet ds = this.getDataSetValNroActa();
		if (estadoexcluido.isNroActaObligatorio())
			cargarRegistro(ds, true);
		else
			cargarRegistro(ds, false);
		writeCliente(ds);
		
	}
	
	private IDataSet getDataSetValNroActa() {
		IDataSet dataset = new TDataSet();
		dataset.create("TValNroActa");
		dataset.fieldDef(new Field("debe_cargar_nro_acta", Field.BOOLEAN, 0));
		return dataset;
	}

	private void cargarRegistro(
			IDataSet dataset, boolean cargarNroActa) throws BaseException {
		dataset.append();
		dataset.fieldValue("debe_cargar_nro_acta", cargarNroActa);
	}	


}
