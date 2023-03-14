package com.srn.erp.produccion.op;

import java.util.Iterator;

import com.srn.erp.produccion.bm.AlternativaFabricacion;
import com.srn.erp.stock.bm.Producto;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerAlternativasFabProducto extends Operation {

	public TraerAlternativasFabProducto() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		
		Integer oid = mapaDatos.getInteger("oid_producto");
		Producto producto = Producto.findByOid(oid, getSesion());

		IDataSet ds = this.getDataAltFabProducto();
		Iterator iterAlterFab = AlternativaFabricacion.getAlternativasFabricacion(producto, this.getSesion()).iterator();
		while (iterAlterFab.hasNext()) {
			AlternativaFabricacion alterFabricacion = (AlternativaFabricacion) iterAlterFab.next();
			cargarRegistro(ds, alterFabricacion);
		}

		writeCliente(ds);

	}

	private IDataSet getDataAltFabProducto() {
		IDataSet dataset = new TDataSet();
		dataset.create("TAltFabProd");
		dataset.fieldDef(new Field("oid_alter_fabri", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_rec_cab", Field.INTEGER, 0));
		dataset.fieldDef(new Field("alternativa", Field.STRING, 100));
		return dataset;
	}

	private void cargarRegistro(IDataSet dataset, AlternativaFabricacion alterFabricacion) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_alter_fabri", alterFabricacion.getOIDInteger());
		dataset.fieldValue("oid_rec_cab", alterFabricacion.getReceta().getOIDInteger());
		dataset.fieldValue("alternativa", alterFabricacion.getAlternativa());
	}
}
