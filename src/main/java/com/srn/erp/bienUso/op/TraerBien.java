package com.srn.erp.bienUso.op;

import java.util.Iterator;

import com.srn.erp.bienUso.bm.Bien;
import com.srn.erp.bienUso.bm.BienImputacion;
import com.srn.erp.bienUso.bm.SistemaValuacion;
import com.srn.erp.bienUso.bm.SubBien;
import com.srn.erp.bienUso.bm.SubBienVidaUtil;
import com.srn.erp.bienUso.bm.VidaUtilGrupo;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerBien extends Operation {

	public TraerBien() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		Bien bien = null;
		if (mapaDatos.containsKey("oid")) {
			Integer oid = mapaDatos.getInteger("oid");
			bien = Bien.findByOid(oid, getSesion());
		}
		else {
			String codigo = mapaDatos.getString("codigo");
			bien = Bien.findByCodigo(codigo, getSesion());
		}

		IDataSet datasetBien = getDataSetBien();
		IDataSet datasetBienImputacion = getDataSetBienImputacion();
		IDataSet datasetSubBien = getDataSetSubBien();
		IDataSet datasetSubBienUtil = getDataSetSubBienesVidaUtil();
		IDataSet datasetCompoVO = getDataSetComposicionValorOrigen();

		if (bien != null) {
			cargarRegistroBien(datasetBien, bien);
			// Cargar Imputaciones
			Iterator iterBienesImputaciones = bien.getBienesImputaciones().iterator();
			while (iterBienesImputaciones.hasNext()) {
				BienImputacion bienImputacion = (BienImputacion) iterBienesImputaciones.next();
				cargarRegistroBienImputacion(datasetBienImputacion, bien, bienImputacion);
			}

			// Cargar SubBienes
			Iterator iterSubBienes = bien.getSubBienes().iterator();
			while (iterSubBienes.hasNext()) {
				SubBien subBien = (SubBien) iterSubBienes.next();
				cargarRegistroSubBien(datasetSubBien, bien, subBien);

				// Traer la información para cada uno de los Sistemas de Amortizacion
				Iterator iterSistVal = SistemaValuacion.getSistemasDeValuacion(getSesion()).iterator();
				while (iterSistVal.hasNext()) {
					SistemaValuacion sistemaValuacion = (SistemaValuacion) iterSistVal.next();
					SubBienVidaUtil subBienVidaUtil = subBien.getSubBienVidaUtil(sistemaValuacion);
					cargarRegistroSubBienVidaUtil(datasetSubBienUtil, sistemaValuacion, subBien, subBienVidaUtil);
				}
			}
		}
		writeCliente(datasetBien);
		writeCliente(datasetBienImputacion);
		writeCliente(datasetSubBien);
		writeCliente(datasetSubBienUtil);
		writeCliente(datasetCompoVO);
	}

	private IDataSet getDataSetBien() {
		IDataSet dataset = new TDataSet();
		dataset.create("TBien");
		dataset.fieldDef(new Field("oid_bien_uso", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 30));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 255));
		dataset.fieldDef(new Field("amortizable", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("estado", Field.STRING, 20));
		dataset.fieldDef(new Field("fec_alta", Field.DATE, 0));
		dataset.fieldDef(new Field("oid_grupo_bien_uso", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_grupo", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_grupo", Field.STRING, 100));
		dataset.fieldDef(new Field("oid_ai_vo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_ai_vo", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_ai_vo", Field.STRING, 100));
		dataset.fieldDef(new Field("oid_ai_aa", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_ai_aa", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_ai_aa", Field.STRING, 100));
		dataset.fieldDef(new Field("oid_ai_rvo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_ai_rvo", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_ai_rvo", Field.STRING, 100));
		dataset.fieldDef(new Field("oid_ai_raa", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_ai_raa", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_ai_raa", Field.STRING, 100));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private void cargarRegistroBien(IDataSet dataset, Bien bien) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_bien_uso", bien.getOIDInteger());
		dataset.fieldValue("codigo", bien.getCodigo());
		dataset.fieldValue("descripcion", bien.getDescripcion());
		dataset.fieldValue("amortizable", bien.isAmortizable());
		dataset.fieldValue("estado", bien.getEstado());
		dataset.fieldValue("fec_alta", Fecha.getddmmyyyy(bien.getFec_alta()));
		dataset.fieldValue("oid_grupo_bien_uso", bien.getGrupo_bien_uso().getOIDInteger());
		dataset.fieldValue("cod_grupo", bien.getGrupo_bien_uso().getCodigo());
		dataset.fieldValue("desc_grupo", bien.getGrupo_bien_uso().getDescripcion());
		dataset.fieldValue("oid_ai_vo", bien.getAi_vo().getOIDInteger());
		dataset.fieldValue("cod_ai_vo", bien.getAi_vo().getCodigoCuentaMasCodigosValCompo());
		dataset.fieldValue("desc_ai_vo", bien.getAi_vo().getDescCuentaMasDescValCompo());
		dataset.fieldValue("oid_ai_aa", bien.getAi_aa().getOIDInteger());
		dataset.fieldValue("cod_ai_aa", bien.getAi_aa().getCodigoCuentaMasCodigosValCompo());
		dataset.fieldValue("desc_ai_aa", bien.getAi_aa().getDescCuentaMasDescValCompo());
		dataset.fieldValue("oid_ai_rvo", bien.getAi_rvo().getOIDInteger());
		dataset.fieldValue("cod_ai_rvo", bien.getAi_rvo().getCodigoCuentaMasCodigosValCompo());
		dataset.fieldValue("desc_ai_rvo", bien.getAi_rvo().getDescCuentaMasDescValCompo());
		dataset.fieldValue("oid_ai_raa", bien.getAi_raa().getOIDInteger());
		dataset.fieldValue("cod_ai_raa", bien.getAi_raa().getCodigoCuentaMasCodigosValCompo());
		dataset.fieldValue("desc_ai_raa", bien.getAi_raa().getDescCuentaMasDescValCompo());
		dataset.fieldValue("activo", bien.isActivo());
	}

	private IDataSet getDataSetBienImputacion() {
		IDataSet dataset = new TDataSet();
		dataset.create("TBienImputacion");
		dataset.fieldDef(new Field("oid_bien_impu", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_bien_uso", Field.INTEGER, 0));
		dataset.fieldDef(new Field("vigencia_desde", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_ai", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_ai", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_ai", Field.STRING, 100));
		dataset.fieldDef(new Field("porc", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private void cargarRegistroBienImputacion(IDataSet dataset, Bien bien, BienImputacion bienImputacion)
			throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_bien_impu", bienImputacion.getOIDInteger());
		dataset.fieldValue("oid_bien_uso", bien.getOIDInteger());
		dataset.fieldValue("vigencia_desde", Fecha.getddmmyyyy(bienImputacion.getVigencia_desde()));
		dataset.fieldValue("oid_ai", bienImputacion.getCuenta_imputable().getOIDInteger());
		dataset.fieldValue("cod_ai", bienImputacion.getCuenta_imputable().getCodigoCuentaMasCodigosValCompo());
		dataset.fieldValue("desc_ai", bienImputacion.getCuenta_imputable().getDescCuentaMasDescValCompo());
		dataset.fieldValue("porc", bienImputacion.getPorc());
		dataset.fieldValue("activo", bienImputacion.isActivo());
	}

	private IDataSet getDataSetSubBien() {
		IDataSet dataset = new TDataSet();
		dataset.create("TSubBien");
		dataset.fieldDef(new Field("oid_bien_alta", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_bien_uso", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nro_alta", Field.INTEGER, 0));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 255));
		dataset.fieldDef(new Field("sigue_bien_ppal", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("oid_peri_ini_amort", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("cod_peri_ini_amort", Field.STRING, 50));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private void cargarRegistroSubBien(IDataSet dataset, Bien bien, SubBien subBien) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_bien_alta", subBien.getOIDInteger());
		dataset.fieldValue("oid_bien_uso", bien.getOIDInteger());
		dataset.fieldValue("nro_alta", subBien.getNro_alta());
		dataset.fieldValue("descripcion", subBien.getDescripcion());
		dataset.fieldValue("sigue_bien_ppal", subBien.isSigue_bien_ppal());
		dataset.fieldValue("oid_peri_ini_amort", subBien.getPeri_ini_amort().getOIDInteger());
		dataset.fieldValue("cod_peri_ini_amort", subBien.getPeri_ini_amort().getCodigo());
		dataset.fieldValue("activo", subBien.isActivo());
	}

	private IDataSet getDataSetSubBienesVidaUtil() {
		IDataSet dataset = new TDataSet();
		dataset.create("TSubBienesVidaUtil");
		dataset.fieldDef(new Field("oid_bien_vu", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_bien_alta", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_sist_val", Field.INTEGER, 0));
		dataset.fieldDef(new Field("desc_sist_val", Field.STRING, 100));
		dataset.fieldDef(new Field("vida_util", Field.INTEGER, 0));
		dataset.fieldDef(new Field("valor_origen", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("meses_amortizados", Field.INTEGER, 0));
		dataset.fieldDef(new Field("ult_peri_amort", Field.STRING, 20));
		dataset.fieldDef(new Field("fec_ult_amort", Field.DATE, 0));
		dataset.fieldDef(new Field("oid_mon_sist_val", Field.INTEGER, 0));
		return dataset;
	}

	private void cargarRegistroSubBienVidaUtil(IDataSet dataset, SistemaValuacion sistVal, SubBien subBien,
			SubBienVidaUtil subBienVidaUtil) throws BaseException {

		dataset.append();
		if (subBienVidaUtil != null) {
			dataset.fieldValue("oid_bien_vu", subBienVidaUtil.getOIDInteger());
			dataset.fieldValue("oid_bien_alta", subBien.getOIDInteger());
			dataset.fieldValue("oid_sist_val", subBienVidaUtil.getSistema_valuacion().getOIDInteger());
			dataset.fieldValue("desc_sist_val", subBienVidaUtil.getSistema_valuacion().getDescripcion() + " ("
					+ subBienVidaUtil.getSistema_valuacion().getMoneda().getCodigo() + ")");
			if (subBienVidaUtil.getVidal_util().doubleValue() != 0)
				dataset.fieldValue("vida_util", subBienVidaUtil.getVidal_util());
			else if (subBien.getVidaUtil(sistVal) != null)
				dataset.fieldValue("vida_util", subBien.getVidaUtil(sistVal));
			else
				dataset.fieldValue("vida_util", new Double(0));
			dataset.fieldValue("valor_origen", subBienVidaUtil.getValorOrigen());
			dataset.fieldValue("meses_amortizados", subBienVidaUtil.getMeses_amort());
			if (subBienVidaUtil.getUlt_peri_amort() != null)
				dataset.fieldValue("ult_peri_amort", subBienVidaUtil.getUlt_peri_amort().getCodigo());
			else
				dataset.fieldValue("ult_peri_amort", "");
			dataset.fieldValue("fec_ult_amort", Fecha.getddmmyyyy(subBienVidaUtil.getFec_ult_amort()));
			dataset.fieldValue("oid_mon_sist_val", sistVal.getMoneda().getOIDInteger());
		}
		else {
			dataset.fieldValue("oid_bien_vu", new Integer(-1));
			dataset.fieldValue("oid_bien_alta", subBien.getOIDInteger());
			dataset.fieldValue("oid_sist_val", sistVal.getOIDInteger());
			dataset.fieldValue("desc_sist_val", sistVal.getDescripcion() + " (" + sistVal.getMoneda().getCodigo() + ")");
			if (subBien != null) {
				VidaUtilGrupo vidaUtilGrupo = subBien.getBien_uso().getGrupo_bien_uso().getVidaUtilGrupo(sistVal);
				if (vidaUtilGrupo != null)
					dataset.fieldValue("vida_util", vidaUtilGrupo.getVida_util());
				else
					dataset.fieldValue("vida_util", new Integer(0));
			}
			else
				dataset.fieldValue("vida_util", new Integer(0));
			dataset.fieldValue("valor_origen", 0);
			dataset.fieldValue("meses_amortizados", new Integer(0));
			dataset.fieldValue("ult_peri_amort", "");
			dataset.fieldValue("fec_ult_amort", Fecha.FECHA_NULA());
			dataset.fieldValue("oid_mon_sist_val", sistVal.getMoneda().getOIDInteger());
		}
	}

	private IDataSet getDataSetComposicionValorOrigen() {
		IDataSet dataset = new TDataSet();
		dataset.create("TBuComproVO");
		dataset.fieldDef(new Field("oid_comp_vo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_dco", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_bien_vu", Field.INTEGER, 0));
		dataset.fieldDef(new Field("porc", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("impo_valor", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("oid_moneda", Field.INTEGER, 0));
		return dataset;
	}

}
