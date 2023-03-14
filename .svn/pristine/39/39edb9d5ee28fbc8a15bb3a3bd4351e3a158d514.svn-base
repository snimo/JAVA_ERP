package com.srn.erp.compras.op;

import com.srn.erp.compras.bm.Proveedor;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerDireccionProveedor extends Operation {

	public TraerDireccionProveedor() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		Proveedor proveedor = Proveedor.findByOidProxy(mapaDatos.getInteger("oid_proveedor"), getSesion());

		IDataSet ds = getDataSetDireccionProveedor();
		cargarRegistroDireccionProveedor(ds, proveedor);
		writeCliente(ds);

	}

	private IDataSet getDataSetDireccionProveedor() {
		IDataSet dataset = new TDataSet();
		dataset.create("TDireccionProveedor");
		dataset.fieldDef(new Field("oid_proveedor", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_proveedor", Field.STRING, 50));
		dataset.fieldDef(new Field("rs_proveedor", Field.STRING, 100));
		dataset.fieldDef(new Field("calle", Field.STRING, 100));
		dataset.fieldDef(new Field("localidad", Field.STRING, 100));
		dataset.fieldDef(new Field("codigo_postal", Field.STRING, 100));
		dataset.fieldDef(new Field("oid_provincia", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_provincia", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_provincia", Field.STRING, 100));
		dataset.fieldDef(new Field("oid_pais", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_pais", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_pais", Field.STRING, 100));
		return dataset;
	}

	private void cargarRegistroDireccionProveedor(IDataSet dataset, Proveedor proveedor) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_proveedor", proveedor.getOIDInteger());
		dataset.fieldValue("cod_proveedor", proveedor.getCodigo());
		dataset.fieldValue("rs_proveedor", proveedor.getRazonsocial());
		dataset.fieldValue("calle", proveedor.getDireccion());
		dataset.fieldValue("localidad", proveedor.getLocalidad());
		dataset.fieldValue("codigo_postal", proveedor.getCodigopostal());
		if (proveedor.getProvincia() != null) {
			dataset.fieldValue("oid_provincia", proveedor.getProvincia().getOIDInteger());
			dataset.fieldValue("cod_provincia", proveedor.getProvincia().getCodigo());
			dataset.fieldValue("desc_provincia", proveedor.getProvincia().getDescripcion());
		}
		else {
			dataset.fieldValue("oid_provincia", 0);
			dataset.fieldValue("cod_provincia", "");
			dataset.fieldValue("desc_provincia", "");
		}
		if (proveedor.getPais() != null) {
			dataset.fieldValue("oid_pais", proveedor.getPais().getOIDInteger());
			dataset.fieldValue("cod_pais", proveedor.getPais().getCodigo());
			dataset.fieldValue("desc_pais", proveedor.getPais().getDescripcion());
		}
		else {
			dataset.fieldValue("oid_pais", 0);
			dataset.fieldValue("cod_pais", "");
			dataset.fieldValue("desc_pais", "");
		}
	}

}
