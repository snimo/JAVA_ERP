package com.srn.erp.excluidos.op;

import com.srn.erp.excluidos.bm.VehiculoExcluido;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerDatosVehiculo extends Operation {

	public TraerDatosVehiculo() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		IDataSet dsVehiculo = this.getDataSetDatosVehiculo();
		VehiculoExcluido vehiculo = VehiculoExcluido.getVehiculoExcluido(mapaDatos.getString("dominio"), this.getSesion());
		if (vehiculo!=null)
			cargarRegistroVehiculo(dsVehiculo, vehiculo);
		writeCliente(dsVehiculo);
	}

	private IDataSet getDataSetDatosVehiculo() {
		IDataSet dataset = new TDataSet();
		dataset.create("TDatosVehiculo");
		dataset.fieldDef(new Field("oid_vehiculo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("dominio", Field.STRING, 50));
		dataset.fieldDef(new Field("modelo", Field.STRING, 100));
		dataset.fieldDef(new Field("marca", Field.STRING, 100));
		dataset.fieldDef(new Field("oid_color", Field.INTEGER, 0));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private void cargarRegistroVehiculo(IDataSet dataset, VehiculoExcluido vehiculo) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_vehiculo", vehiculo.getOIDInteger());
		dataset.fieldValue("dominio", vehiculo.getDominio());
		dataset.fieldValue("modelo", vehiculo.getModelo());
		dataset.fieldValue("marca", vehiculo.getMarca());
		if (vehiculo.getColor()!=null)
			dataset.fieldValue("oid_color", vehiculo.getColor().getOIDInteger());
		else
			dataset.fieldValue("oid_color", "");
		dataset.fieldValue("activo", true);
	}
}
