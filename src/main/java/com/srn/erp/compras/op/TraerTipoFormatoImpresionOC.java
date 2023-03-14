package com.srn.erp.compras.op;

import framework.applicarionServer.bm.Parametros.ValorParametro;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerTipoFormatoImpresionOC extends Operation {

	HashTableDatos preciosCompraClasif = new HashTableDatos();

	public TraerTipoFormatoImpresionOC() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		
		IDataSet ds = this.getDataSet();
		
		ValorParametro valorParametroOC1 =
			ValorParametro.findByCodigoParametro("LABEL_FORMATO_IMP_OC_1", this.getSesion());
		
		ValorParametro valorParametroOC2 =
			ValorParametro.findByCodigoParametro("LABEL_FORMATO_IMP_OC_2", this.getSesion());		
		
		cargarRegistro(ds, "1",valorParametroOC1.getValorCadena());
		cargarRegistro(ds, "2",valorParametroOC2.getValorCadena());
		
		writeCliente(ds);
	}


	private IDataSet getDataSet() {
		IDataSet dataset = new TDataSet();
		dataset.create("TFormatoImpresion");
		dataset.fieldDef(new Field("codigo", Field.STRING, 50));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
		return dataset;
	}

	private void cargarRegistro(IDataSet dataset,
			String codigo,
			String descripcion) {
		dataset.append();
		dataset.fieldValue("codigo", codigo);
		dataset.fieldValue("descripcion", descripcion);
	}

}
