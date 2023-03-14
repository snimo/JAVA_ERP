package com.srn.erp.ventas.op;

import com.srn.erp.ventas.bm.FacturaCab;

import framework.applicarionServer.bm.Parametros.ValorParametro;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerTipoImpresionFact extends Operation {

	public TraerTipoImpresionFact() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		FacturaCab facturaCab = FacturaCab.findByOid(mapaDatos.getInteger("oid_cco"), getSesion());
		String tipoImpresion = "";

		if (facturaCab.getTipoImpresion() != null)
			tipoImpresion = facturaCab.getTipoImpresion();
		else {

			if (facturaCab.getSujeto().getTipoImpresionFact() != null)
				tipoImpresion = facturaCab.getSujeto().getTipoImpresionFact();
			else {

				Integer nroTipoImpresion = 0;
				
				try {
					nroTipoImpresion = ValorParametro.findByCodigoParametro("TIPO_IMP_DEF_FACTURA", this.getSesion()).getValorEntero();
				} catch (Exception e) {}

				if (nroTipoImpresion.intValue() == 1)
					tipoImpresion = "PROD_STOCK";
				else if (nroTipoImpresion.intValue() == 2)
					tipoImpresion = "PROD_GENERAL";

			}
		}

		IDataSet ds = this.getDataSetTipoImpFact();
		cargarRegistro(ds, tipoImpresion);
		writeCliente(ds);

	}

	private IDataSet getDataSetTipoImpFact() {
		IDataSet dataset = new TDataSet();
		dataset.create("TTipoImpDefFact");
		dataset.fieldDef(new Field("tipo_impresion", Field.STRING, 100));
		return dataset;
	}

	private void cargarRegistro(IDataSet dataset, String tipoImpresion) {
		dataset.append();
		dataset.fieldValue("tipo_impresion", tipoImpresion);
	}

}
