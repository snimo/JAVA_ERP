package com.srn.erp.tesoreria.op;

import java.util.Iterator;

import com.srn.erp.general.bm.Talonario;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerTalonariosLiquidaciones extends Operation {

	public TraerTalonariosLiquidaciones() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		IDataSet ds = getDataSetTalonarios();
		Iterator iterTalonariosLiq = 
			Talonario.getTalonariosLiquidacionesTarjetas(this.getSesion()).iterator();
		while (iterTalonariosLiq.hasNext()) {
			Talonario talonario = (Talonario) iterTalonariosLiq.next();
			cargarRegistroTalonario(ds, talonario);
		}
		writeCliente(ds);
		
	}

	private IDataSet getDataSetTalonarios() {
		IDataSet dataset = new TDataSet();
		dataset.create("TTalonarios");
		dataset.fieldDef(new Field("oid_talonario", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 30));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
		dataset.fieldDef(new Field("tipo_imp_asoc", Field.STRING, 15));
		dataset.fieldDef(new Field("oid_imp_fiscal", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_imp_comun", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_tc", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_tc", Field.STRING, 39));
		dataset.fieldDef(new Field("letra", Field.STRING, 1));
		dataset.fieldDef(new Field("oid_lug_emi", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nro_lug_emi", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nom_arch_imp", Field.STRING, 100));
		dataset.fieldDef(new Field("primer_nro", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nro_actual", Field.INTEGER, 0));
		dataset.fieldDef(new Field("ultimo_nro", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nro_automatica", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("fec_vto", Field.STRING, 10));
		dataset.fieldDef(new Field("cai", Field.STRING, 100));
		dataset.fieldDef(new Field("oid_uni_org", Field.INTEGER, 0));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("cant_copias", Field.INTEGER, 0));
		dataset.fieldDef(new Field("intercalar", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("orientacion", Field.STRING, 20));
		dataset.fieldDef(new Field("generar_archivo", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("tipo_archivo", Field.STRING, 20));
		dataset.fieldDef(new Field("impresora_fiscal", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("driver", Field.STRING, 20));
		dataset.fieldDef(new Field("puerto", Field.INTEGER, 0));
		dataset.fieldDef(new Field("baudios", Field.INTEGER, 0));
		return dataset;
	}

	private void cargarRegistroTalonario(IDataSet dataset, Talonario talonario) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_talonario", talonario.getOIDInteger());
		dataset.fieldValue("codigo", talonario.getCodigo());
		dataset.fieldValue("descripcion", talonario.getDescripcion());
		if (talonario.getImpo_imp_asoc() != null)
			dataset.fieldValue("tipo_imp_asoc", talonario.getImpo_imp_asoc());
		else
			dataset.fieldValue("tipo_imp_asoc", "");
		if (talonario.getImpresora_fiscal() != null)
			dataset.fieldValue("oid_imp_fiscal", talonario.getImpresora_fiscal().getOID());
		else
			dataset.fieldValue("oid_imp_fiscal", 0);
		if (talonario.getImpresora_comun() != null)
			dataset.fieldValue("oid_imp_comun", talonario.getImpresora_comun().getOIDInteger());
		else
			dataset.fieldValue("oid_imp_comun", 0);
		dataset.fieldValue("oid_tc", talonario.getTipo_comprobante().getOIDInteger());
		dataset.fieldValue("cod_tc", talonario.getTipo_comprobante().getCodigo());
		dataset.fieldValue("letra", talonario.getLetra());
		dataset.fieldValue("oid_lug_emi", talonario.getLugar_emision().getOIDInteger());
		dataset.fieldValue("nro_lug_emi", talonario.getLugar_emision().getLugemi());
		if (talonario.getNombre_archivo_impresion() != null)
			dataset.fieldValue("nom_arch_imp", talonario.getNombre_archivo_impresion());
		else
			dataset.fieldValue("nom_arch_imp", "");
		dataset.fieldValue("primer_nro", talonario.getPrimer_nro());
		dataset.fieldValue("nro_actual", talonario.getNro_actual());
		dataset.fieldValue("ultimo_nro", talonario.getUltimo_nro());
		dataset.fieldValue("nro_automatica", talonario.isNro_automatica());
		if (talonario.getFec_vto() != null)
			dataset.fieldValue("fec_vto", Fecha.getddmmyyyy(talonario.getFec_vto()));
		else
			dataset.fieldValue("fec_vto", "");
		if (talonario.getCai() != null)
			dataset.fieldValue("cai", talonario.getCai());
		else
			dataset.fieldValue("cai", "");
		if (talonario.getUnidad_organizativa() != null)
			dataset.fieldValue("oid_uni_org", talonario.getUnidad_organizativa().getOIDInteger());
		else
			dataset.fieldValue("oid_uni_org", Fecha.FECHA_NULA());
		dataset.fieldValue("activo", talonario.isActivo());
		dataset.fieldValue("cant_copias", talonario.getCantCopias());
		dataset.fieldValue("intercalar", talonario.isIntercalar());
		dataset.fieldValue("orientacion", talonario.getOrientacion());
		dataset.fieldValue("generar_archivo", talonario.isGenerararchivo());
		dataset.fieldValue("tipo_archivo", talonario.getTipoArchivo());

		if (talonario.getImpo_imp_asoc() != null) {
			if (talonario.getImpo_imp_asoc().equals("Fiscal"))
				dataset.fieldValue("impresora_fiscal", new Boolean(true));
			else
				dataset.fieldValue("impresora_fiscal", new Boolean(false));
			if (talonario.getImpresora_fiscal() != null) {
				dataset.fieldValue("driver", talonario.getImpresora_fiscal().getDriver());
				dataset.fieldValue("puerto", talonario.getImpresora_fiscal().getPuerto());
				dataset.fieldValue("baudios", talonario.getImpresora_fiscal().getBaudios());
			} else {
				dataset.fieldValue("driver", "");
				dataset.fieldValue("puerto", new Integer(1));
				dataset.fieldValue("baudios", new Integer(9600));
			}
		} else {
			dataset.fieldValue("impresora_fiscal", "");
			dataset.fieldValue("driver", "");
			dataset.fieldValue("puerto", new Integer(1));
			dataset.fieldValue("baudios", new Integer(9600));
		}

	}

}
