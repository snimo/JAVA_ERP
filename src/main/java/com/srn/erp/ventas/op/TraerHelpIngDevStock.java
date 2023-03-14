package com.srn.erp.ventas.op;

import java.util.Iterator;

import com.srn.erp.general.bm.Talonario;
import com.srn.erp.ventas.bm.IngresoDevolucionStockCab;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerHelpIngDevStock extends Operation {

	public TraerHelpIngDevStock() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		IDataSet ds = this.getDataSetIngDev();

		Integer nroExtDesde = null;
		Integer nroExtHasta = null;
		java.util.Date fecDesde = null;
		java.util.Date fecHasta = null;
		Talonario talonario = null;
		Integer nroIngDev = null;

		if (mapaDatos.containsKey("nro_ext_desde"))
			nroExtDesde = mapaDatos.getInteger("nro_ext_desde");

		if (mapaDatos.containsKey("nro_ext_hasta"))
			nroExtDesde = mapaDatos.getInteger("nro_ext_hasta");

		if (mapaDatos.containsKey("fec_desde"))
			fecDesde = mapaDatos.getDate("fec_desde");

		if (mapaDatos.containsKey("fec_hasta"))
			fecHasta = mapaDatos.getDate("fec_hasta");

		if (mapaDatos.containsKey("oid_talonario"))
			talonario = Talonario.findByOidProxy(mapaDatos.getInteger("oid_talonario"), this.getSesion());

		if (mapaDatos.containsKey("nro_ext_ing_dev"))
			nroIngDev = mapaDatos.getInteger("nro_ext_ing_dev");

		Iterator iterIngDevStkCab = IngresoDevolucionStockCab.getHelpIngDevStock(nroExtDesde, nroExtHasta, fecDesde, fecHasta, talonario,
				nroIngDev, this.getSesion()).iterator();
		while (iterIngDevStkCab.hasNext()) {
			IngresoDevolucionStockCab ingresoDevolucion = (IngresoDevolucionStockCab) iterIngDevStkCab.next();
			cargarRegistro(ds, 
					ingresoDevolucion.getOIDInteger(), 
					ingresoDevolucion.getEmision(), 
					ingresoDevolucion.getCodigo(),
					ingresoDevolucion.getNroExt(), 
					ingresoDevolucion.isActivo());
		}

		writeCliente(ds);

	}

	private IDataSet getDataSetIngDev() {
		IDataSet dataset = new TDataSet();
		dataset.create("THelpIngDevoluciones");
		dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_cco", Field.INTEGER, 0));
		dataset.fieldDef(new Field("fec_emision", Field.DATE, 0));
		dataset.fieldDef(new Field("comprobante", Field.STRING, 50));
		dataset.fieldDef(new Field("nro_ext", Field.INTEGER, 0));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		
		return dataset;
	}

	private void cargarRegistro(IDataSet dataset, Integer oid, java.util.Date fecEmision, String comprobante , Integer nroExt , boolean activo) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid", oid);
		dataset.fieldValue("oid_cco", oid);
		dataset.fieldValue("fec_emision", fecEmision);
		dataset.fieldValue("comprobante", comprobante);
		dataset.fieldValue("nro_ext", nroExt);
		dataset.fieldValue("activo", activo);
	}

}
