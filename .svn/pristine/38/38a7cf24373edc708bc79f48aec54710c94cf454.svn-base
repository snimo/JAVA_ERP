package com.srn.erp.cip.op;

import com.srn.erp.cip.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Tablas.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.*;

public class TraerPlanifDiaCacheo extends Operation {

	public TraerPlanifDiaCacheo() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		
		PlanifDiaCacheo planifdiacacheo = null;
		if (PlanifDiaCacheo.getListaPlanifDiaCacheo(this.getSesion()).size() == 0)
			planifdiacacheo = (PlanifDiaCacheo)PlanifDiaCacheo.getNew(PlanifDiaCacheo.NICKNAME, this.getSesion());
		else  {
			planifdiacacheo = (PlanifDiaCacheo)PlanifDiaCacheo.getListaPlanifDiaCacheo(this.getSesion()).get(0);
		}
		
		IDataSet datasetPlanifDiaCacheo = getDataSetPlanifDiaCacheo();
		
		if (planifdiacacheo != null) {
			cargarRegistroPlanifDiaCacheo(datasetPlanifDiaCacheo, planifdiacacheo.getOIDInteger(), planifdiacacheo.getLunes_entrada(),
					planifdiacacheo.getLunes_salida(), planifdiacacheo.getMartes_entrada(), planifdiacacheo.getMartes_salida(),
					planifdiacacheo.getMiercoles_entrada(), planifdiacacheo.getMiercoles_salida(), planifdiacacheo.getJueves_entrada(),
					planifdiacacheo.getJueves_salida(), planifdiacacheo.getViernes_entrada(), planifdiacacheo.getViermes_salida(),
					planifdiacacheo.getSabado_entrada(), planifdiacacheo.getSabado_salida(), planifdiacacheo.getDomingo_entrada(),
					planifdiacacheo.getDomingo_salida());
		}
		writeCliente(datasetPlanifDiaCacheo);
	}

	private IDataSet getDataSetPlanifDiaCacheo() {
		IDataSet dataset = new TDataSet();
		dataset.create("TDefPuertas");
		dataset.fieldDef(new Field("oid_planif_dia", Field.INTEGER, 0));
		
		dataset.fieldDef(new Field("oid_lun_ent", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_lun_ent", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_lun_ent", Field.STRING, 100));
		
		dataset.fieldDef(new Field("oid_lun_sal", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_lun_sal", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_lun_sal", Field.STRING, 100));
		
		dataset.fieldDef(new Field("oid_mar_ent", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_mar_ent", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_mar_ent", Field.STRING, 100));
		
		dataset.fieldDef(new Field("oid_mar_sal", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_mar_sal", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_mar_sal", Field.STRING, 100));
		
		dataset.fieldDef(new Field("oid_mie_ent", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_mie_ent", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_mie_ent", Field.STRING, 100));
		
		dataset.fieldDef(new Field("oid_mie_sal", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_mie_sal", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_mie_sal", Field.STRING, 100));
		
		dataset.fieldDef(new Field("oid_jue_ent", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_jue_ent", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_jue_ent", Field.STRING, 100));
		
		dataset.fieldDef(new Field("oid_jue_sal", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_jue_sal", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_jue_sal", Field.STRING, 100));
		
		dataset.fieldDef(new Field("oid_vie_ent", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_vie_ent", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_vie_ent", Field.STRING, 100));
		
		dataset.fieldDef(new Field("oid_vie_sal", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_vie_sal", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_vie_sal", Field.STRING, 100));
		
		dataset.fieldDef(new Field("oid_sab_ent", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_sab_ent", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_sab_ent", Field.STRING, 100));
		
		dataset.fieldDef(new Field("oid_sab_sal", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_sab_sal", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_sab_sal", Field.STRING, 100));
		
		dataset.fieldDef(new Field("oid_dom_ent", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_dom_ent", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_dom_ent", Field.STRING, 100));
		
		dataset.fieldDef(new Field("oid_dom_sal", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_dom_sal", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_dom_sal", Field.STRING, 100));
				
		return dataset;
	}

	private void cargarRegistroPlanifDiaCacheo(IDataSet dataset, Integer oid_planif_dia, GrupoPuerta oid_lun_ent, GrupoPuerta oid_lun_sal,
			GrupoPuerta oid_mar_ent, GrupoPuerta oid_mar_sal, GrupoPuerta oid_mie_ent, GrupoPuerta oid_mie_sal, GrupoPuerta oid_jue_ent,
			GrupoPuerta oid_jue_sal, GrupoPuerta oid_vie_ent, GrupoPuerta oid_vie_sal, GrupoPuerta oid_sab_ent, GrupoPuerta oid_sab_sal,
			GrupoPuerta oid_dom_ent, GrupoPuerta oid_dom_sal) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_planif_dia", oid_planif_dia);
		if (oid_lun_ent!=null) {
			dataset.fieldValue("oid_lun_ent", oid_lun_ent.getOIDInteger());
			dataset.fieldValue("cod_lun_ent", oid_lun_ent.getCodigo());
			dataset.fieldValue("desc_lun_ent", oid_lun_ent.getDescripcion());
		}
		else {
			dataset.fieldValue("oid_lun_ent", "");
			dataset.fieldValue("cod_lun_ent", "");
			dataset.fieldValue("desc_lun_ent", "");
		}
		if (oid_lun_sal!=null) {
			dataset.fieldValue("oid_lun_sal", oid_lun_sal.getOIDInteger());
			dataset.fieldValue("cod_lun_sal", oid_lun_sal.getCodigo());
			dataset.fieldValue("desc_lun_sal", oid_lun_sal.getDescripcion());
		}
		else {
			dataset.fieldValue("oid_lun_sal", "");
			dataset.fieldValue("cod_lun_sal", "");
			dataset.fieldValue("desc_lun_sal", "");
		}
		if (oid_mar_ent!=null) {
			dataset.fieldValue("oid_mar_ent", oid_mar_ent.getOIDInteger());
			dataset.fieldValue("cod_mar_ent", oid_mar_ent.getCodigo());
			dataset.fieldValue("desc_mar_ent", oid_mar_ent.getDescripcion());
		}
		else {
			dataset.fieldValue("oid_mar_ent", "");
			dataset.fieldValue("cod_mar_ent", "");
			dataset.fieldValue("desc_mar_ent", "");
		}
		if (oid_mar_sal!=null) {
			dataset.fieldValue("oid_mar_sal", oid_mar_sal.getOIDInteger());
			dataset.fieldValue("cod_mar_sal", oid_mar_sal.getCodigo());
			dataset.fieldValue("desc_mar_sal", oid_mar_sal.getDescripcion());
		}
		else {
			dataset.fieldValue("oid_mar_sal", "");
			dataset.fieldValue("cod_mar_sal", "");
			dataset.fieldValue("desc_mar_sal", "");
		}
		if (oid_mie_ent!=null) {
			dataset.fieldValue("oid_mie_ent", oid_mie_ent.getOIDInteger());
			dataset.fieldValue("cod_mie_ent", oid_mie_ent.getCodigo());
			dataset.fieldValue("desc_mie_ent", oid_mie_ent.getDescripcion());
		}
		else {
			dataset.fieldValue("oid_mie_ent", "");
			dataset.fieldValue("cod_mie_ent", "");
			dataset.fieldValue("desc_mie_ent", "");
		}
		if (oid_mie_sal!=null) {
			dataset.fieldValue("oid_mie_sal", oid_mie_sal.getOIDInteger());
			dataset.fieldValue("cod_mie_sal", oid_mie_sal.getCodigo());
			dataset.fieldValue("desc_mie_sal", oid_mie_sal.getDescripcion());
		}
		else {
			dataset.fieldValue("oid_mie_sal", "");
			dataset.fieldValue("cod_mie_sal", "");
			dataset.fieldValue("desc_mie_sal", "");
		}
		if (oid_jue_ent!=null) {
			dataset.fieldValue("oid_jue_ent", oid_jue_ent.getOIDInteger());
			dataset.fieldValue("cod_jue_ent", oid_jue_ent.getCodigo());
			dataset.fieldValue("desc_jue_ent", oid_jue_ent.getDescripcion());
		}
		else {
			dataset.fieldValue("oid_jue_ent", "");
			dataset.fieldValue("cod_jue_ent", "");
			dataset.fieldValue("desc_jue_ent", "");
		}
		if (oid_jue_sal!=null) {
			dataset.fieldValue("oid_jue_sal", oid_jue_sal.getOIDInteger());
			dataset.fieldValue("cod_jue_sal", oid_jue_sal.getCodigo());
			dataset.fieldValue("desc_jue_sal", oid_jue_sal.getDescripcion());
		}
		else {
			dataset.fieldValue("oid_jue_sal", "");
			dataset.fieldValue("cod_jue_sal", "");
			dataset.fieldValue("desc_jue_sal", "");
		}
		if (oid_vie_ent!=null) {
			dataset.fieldValue("oid_vie_ent", oid_vie_ent.getOIDInteger());
			dataset.fieldValue("cod_vie_ent", oid_vie_ent.getCodigo());
			dataset.fieldValue("desc_vie_ent", oid_vie_ent.getDescripcion());
		}
		else {
			dataset.fieldValue("oid_vie_ent", "");
			dataset.fieldValue("cod_vie_ent", "");
			dataset.fieldValue("desc_vie_ent", "");
		}
		if (oid_vie_sal!=null) {
			dataset.fieldValue("oid_vie_sal", oid_vie_sal.getOIDInteger());
			dataset.fieldValue("cod_vie_sal", oid_vie_sal.getCodigo());
			dataset.fieldValue("desc_vie_sal", oid_vie_sal.getDescripcion());
		}
		else {
			dataset.fieldValue("oid_vie_sal", "");
			dataset.fieldValue("cod_vie_sal", "");
			dataset.fieldValue("desc_vie_sal", "");
		}
		if (oid_sab_ent!=null) {
			dataset.fieldValue("oid_sab_ent", oid_sab_ent.getOIDInteger());
			dataset.fieldValue("cod_sab_ent", oid_sab_ent.getCodigo());
			dataset.fieldValue("desc_sab_ent", oid_sab_ent.getDescripcion());
		}
		else {
			dataset.fieldValue("oid_sab_ent", "");
			dataset.fieldValue("cod_sab_ent", "");
			dataset.fieldValue("desc_sab_ent", "");
		}
		if (oid_sab_sal!=null) {
			dataset.fieldValue("oid_sab_sal", oid_sab_sal.getOIDInteger());
			dataset.fieldValue("cod_sab_sal", oid_sab_sal.getCodigo());
			dataset.fieldValue("desc_sab_sal", oid_sab_sal.getDescripcion());
		}
		else {
			dataset.fieldValue("oid_sab_sal", "");
			dataset.fieldValue("cod_sab_sal", "");
			dataset.fieldValue("desc_sab_sal", "");
		}
		if (oid_dom_ent!=null) {
			dataset.fieldValue("oid_dom_ent", oid_dom_ent.getOIDInteger());
			dataset.fieldValue("cod_dom_ent", oid_dom_ent.getCodigo());
			dataset.fieldValue("desc_dom_ent", oid_dom_ent.getDescripcion());
		}
		else {
			dataset.fieldValue("oid_dom_ent", "");
			dataset.fieldValue("cod_dom_ent", "");
			dataset.fieldValue("desc_dom_ent", "");
		}
		if (oid_dom_sal!=null) {
			dataset.fieldValue("oid_dom_sal", oid_dom_sal.getOIDInteger());
			dataset.fieldValue("cod_dom_sal", oid_dom_sal.getCodigo());
			dataset.fieldValue("desc_dom_sal", oid_dom_sal.getDescripcion());
		}
		else {
			dataset.fieldValue("oid_dom_sal", "");
			dataset.fieldValue("cod_dom_sal", "");
			dataset.fieldValue("desc_dom_sal", "");
		}
	}
}
