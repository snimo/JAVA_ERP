package com.srn.erp.tesoreria.op;

import com.srn.erp.tesoreria.bm.ConceptoLiqTarjeta;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerConceptoLiqTarjeta extends Operation {

	public TraerConceptoLiqTarjeta() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		IDataSet ds = this.getDataSetConceptoLiqTarjeta();
		ConceptoLiqTarjeta concepto = ConceptoLiqTarjeta.findByOidProxy(mapaDatos.getInteger("oid"), this.getSesion());
		cargarRegistroConceptoLiqTarjeta(ds, concepto);
		writeCliente(ds);

	}

	private IDataSet getDataSetConceptoLiqTarjeta() {
		IDataSet dataset = new TDataSet();
		dataset.create("TConceptoLiqTarjeta");
		dataset.fieldDef(new Field("oid_conc_liq_tc", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 50));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
		dataset.fieldDef(new Field("oid_ana_con", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_ana_con", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_ana_con", Field.STRING, 100));
		dataset.fieldDef(new Field("comportamiento", Field.STRING, 50));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("oid_tipo_valor", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("cod_tipo_valor", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("desc_tipo_valor", Field.BOOLEAN, 0));
		return dataset;
	}

	private void cargarRegistroConceptoLiqTarjeta(IDataSet dataset, ConceptoLiqTarjeta conceptoLiquidacion) throws BaseException {
		dataset.append();

		dataset.fieldValue("oid_conc_liq_tc", conceptoLiquidacion.getOIDInteger());
		dataset.fieldValue("codigo", conceptoLiquidacion.getCodigo());
		dataset.fieldValue("descripcion", conceptoLiquidacion.getDescripcion());
		if (conceptoLiquidacion.getCuenta()!=null) {
			dataset.fieldValue("oid_ana_con", conceptoLiquidacion.getCuenta().getOIDInteger());
			dataset.fieldValue("cod_ana_con", conceptoLiquidacion.getCuenta().getCodigo());
			dataset.fieldValue("desc_ana_con", conceptoLiquidacion.getCuenta().getDescripcion());
		} else {
			dataset.fieldValue("oid_ana_con", "");
			dataset.fieldValue("cod_ana_con", "");
			dataset.fieldValue("desc_ana_con", "");
		}
		dataset.fieldValue("comportamiento", conceptoLiquidacion.getComportamiento());
		dataset.fieldValue("activo", conceptoLiquidacion.isActivo());
		if (conceptoLiquidacion.getTipoValor()!=null) {
			dataset.fieldValue("oid_tipo_valor", conceptoLiquidacion.getTipoValor().getOIDInteger());
			dataset.fieldValue("cod_tipo_valor", conceptoLiquidacion.getTipoValor().getCodigo());
			dataset.fieldValue("desc_tipo_valor", conceptoLiquidacion.getTipoValor().getDescripcion());
		} else {
			dataset.fieldValue("oid_tipo_valor", "");
			dataset.fieldValue("cod_tipo_valor", "");
			dataset.fieldValue("desc_tipo_valor", "");
		}
		
	}

}
