package com.srn.erp.rrhh.op;

import java.util.Iterator;

import com.srn.erp.rrhh.bm.MotivoTipoNov;
import com.srn.erp.rrhh.bm.SancionesRRHH;
import com.srn.erp.rrhh.bm.TipoNovedad;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class AltaRankearCab extends Operation {

	public AltaRankearCab() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		Integer oidRankear = mapaDatos.getInteger("oid_rankear");
		IDataSet dsRankearNov = getDataSetNovRankear();
		IDataSet dsSancionesRank = getDataSetSanRankear();
		IDataSet dsCondMinRank1 = getDataSetCondMinRank1();
		IDataSet dsCondMinRank2 = getDataSetCondMinRank2();
		IDataSet dsCondMinRank3 = getDataSetCondMinRank3();
		IDataSet dsCondMinRank4 = getDataSetCondMinRank4();
		IDataSet dsCondMinRank5 = getDataSetCondMinRank5();
		IDataSet dsCondMinSan1 = getDataSetCondMinSan1();
		IDataSet dsCondMinSan2 = getDataSetCondMinSan2();
		IDataSet dsCondMinSan3 = getDataSetCondMinSan3();
		IDataSet dsCondMinSan4 = getDataSetCondMinSan4();
		IDataSet dsCondMinSan5 = getDataSetCondMinSan5();

		int secu = -1;
		Iterator iterMotTiposNov = MotivoTipoNov.getAllActivos(this.getSesion()).iterator();
		while (iterMotTiposNov.hasNext()) {
			MotivoTipoNov motivoTipoNov = (MotivoTipoNov) iterMotTiposNov.next();
			cargarNovRank(dsRankearNov, secu, oidRankear, motivoTipoNov);
		}

		secu = -1;
		Iterator iterSancionesRRHH = SancionesRRHH.getAllSanciones(this.getSesion()).iterator();
		while (iterSancionesRRHH.hasNext()) {
			SancionesRRHH sancion = (SancionesRRHH) iterSancionesRRHH.next();
			cargarSanRank(dsSancionesRank, secu, oidRankear, sancion);
		}

		cargarRegistroCondMinNov(dsCondMinRank1, oidRankear, 1);
		cargarRegistroCondMinNov(dsCondMinRank2, oidRankear, 2);
		cargarRegistroCondMinNov(dsCondMinRank3, oidRankear, 3);
		cargarRegistroCondMinNov(dsCondMinRank4, oidRankear, 4);
		cargarRegistroCondMinNov(dsCondMinRank5, oidRankear, 5);

		cargarRegistroCondMinSan(dsCondMinSan1, oidRankear, 6);
		cargarRegistroCondMinSan(dsCondMinSan2, oidRankear, 7);
		cargarRegistroCondMinSan(dsCondMinSan3, oidRankear, 8);
		cargarRegistroCondMinSan(dsCondMinSan4, oidRankear, 9);
		cargarRegistroCondMinSan(dsCondMinSan5, oidRankear, 10);

		writeCliente(dsRankearNov);
		writeCliente(dsSancionesRank);
		writeCliente(dsCondMinRank1);
		writeCliente(dsCondMinRank2);
		writeCliente(dsCondMinRank3);
		writeCliente(dsCondMinRank4);
		writeCliente(dsCondMinRank5);
		writeCliente(dsCondMinSan1);
		writeCliente(dsCondMinSan2);
		writeCliente(dsCondMinSan3);
		writeCliente(dsCondMinSan4);
		writeCliente(dsCondMinSan5);

	}

	private IDataSet getDataSetNovRankear() {
		IDataSet dataset = new TDataSet();
		dataset.create("TRankearNovedad");
		dataset.fieldDef(new Field("oid_rankear_nov", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_rankear", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_tipo_nov", Field.INTEGER, 0));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("oid_motivo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("aplicar", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("suma_o_resta", Field.STRING, 20));
		dataset.fieldDef(new Field("calif_en_puntos", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("analizar_ult_meses", Field.INTEGER, 0));
		dataset.fieldDef(new Field("ponderacion", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("desc_tipo_nov", Field.STRING, 100));
		dataset.fieldDef(new Field("desc_motivo", Field.STRING, 100));
		return dataset;
	}

	private IDataSet getDataSetSanRankear() {
		IDataSet dataset = new TDataSet();
		dataset.create("TSancionRank");
		dataset.fieldDef(new Field("oid_sancion_rank", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_mot_sancion", Field.INTEGER, 0));
		dataset.fieldDef(new Field("desc_mot_sancion", Field.STRING, 100));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("aplicar", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("suma_o_resta", Field.STRING, 20));
		dataset.fieldDef(new Field("calif_en_puntos", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("oid_rankear", Field.INTEGER, 0));
		dataset.fieldDef(new Field("analizar_ult_meses", Field.INTEGER, 0));
		dataset.fieldDef(new Field("ponderacion", Field.CURRENCY, 0));
		return dataset;
	}

	private void cargarNovRank(IDataSet dataset, int secu, Integer oidRankearCab, MotivoTipoNov motivo) throws BaseException {

		dataset.append();
		dataset.fieldValue("oid_rankear_nov", secu);
		dataset.fieldValue("oid_rankear", oidRankearCab);
		if (motivo.getTipo_novedad() != null)
			dataset.fieldValue("oid_tipo_nov", motivo.getTipo_novedad().getOIDInteger());
		else
			dataset.fieldValue("oid_tipo_nov", "");
		dataset.fieldValue("activo", true);
		if (motivo != null)
			dataset.fieldValue("oid_motivo", motivo.getOIDInteger());
		else
			dataset.fieldValue("oid_motivo", "");
		dataset.fieldValue("aplicar", false);
		dataset.fieldValue("suma_o_resta", "");
		dataset.fieldValue("calif_en_puntos", "");
		dataset.fieldValue("analizar_ult_meses", "");
		dataset.fieldValue("ponderacion", "");
		if (motivo.getTipo_novedad() != null)
			dataset.fieldValue("desc_tipo_nov", motivo.getTipo_novedad().getDescripcion());
		else
			dataset.fieldValue("desc_tipo_nov", "");
		dataset.fieldValue("desc_motivo", motivo.getDescripcion());

	}

	private void cargarSanRank(IDataSet dataset, int secu, Integer oidRankearCab, SancionesRRHH sancion) throws BaseException {

		dataset.append();
		dataset.fieldValue("oid_sancion_rank", secu);
		dataset.fieldValue("oid_mot_sancion", sancion.getOID());
		dataset.fieldValue("desc_mot_sancion", sancion.getDescripcion());
		dataset.fieldValue("activo", true);
		dataset.fieldValue("aplicar", false);
		dataset.fieldValue("suma_o_resta", "");
		dataset.fieldValue("calif_en_puntos", "");
		dataset.fieldValue("oid_rankear", oidRankearCab);
		dataset.fieldValue("analizar_ult_meses", "");
		dataset.fieldValue("ponderacion", "");

	}

	private IDataSet getDataSetCondMinRank1() {
		IDataSet dataset = new TDataSet();
		dataset.create("TCondMinRank1");
		dataset.fieldDef(new Field("oid_cond_min_rank", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nro_novedad", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_rankear", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_tipo_nov", Field.INTEGER, 0));
		dataset.fieldDef(new Field("tipo_nov", Field.STRING, 100));
		dataset.fieldDef(new Field("oid_motivo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("motivo", Field.STRING, 100));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private IDataSet getDataSetCondMinRank2() {
		IDataSet dataset = new TDataSet();
		dataset.create("TCondMinRank2");
		dataset.fieldDef(new Field("oid_cond_min_rank", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nro_novedad", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_rankear", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_tipo_nov", Field.INTEGER, 0));
		dataset.fieldDef(new Field("tipo_nov", Field.STRING, 100));
		dataset.fieldDef(new Field("oid_motivo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("motivo", Field.STRING, 100));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private IDataSet getDataSetCondMinRank3() {
		IDataSet dataset = new TDataSet();
		dataset.create("TCondMinRank3");
		dataset.fieldDef(new Field("oid_cond_min_rank", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nro_novedad", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_rankear", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_tipo_nov", Field.INTEGER, 0));
		dataset.fieldDef(new Field("tipo_nov", Field.STRING, 100));
		dataset.fieldDef(new Field("oid_motivo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("motivo", Field.STRING, 100));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private IDataSet getDataSetCondMinRank4() {
		IDataSet dataset = new TDataSet();
		dataset.create("TCondMinRank4");
		dataset.fieldDef(new Field("oid_cond_min_rank", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nro_novedad", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_rankear", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_tipo_nov", Field.INTEGER, 0));
		dataset.fieldDef(new Field("tipo_nov", Field.STRING, 100));
		dataset.fieldDef(new Field("oid_motivo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("motivo", Field.STRING, 100));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private IDataSet getDataSetCondMinRank5() {
		IDataSet dataset = new TDataSet();
		dataset.create("TCondMinRank5");
		dataset.fieldDef(new Field("oid_cond_min_rank", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nro_novedad", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_rankear", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_tipo_nov", Field.INTEGER, 0));
		dataset.fieldDef(new Field("tipo_nov", Field.STRING, 100));
		dataset.fieldDef(new Field("oid_motivo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("motivo", Field.STRING, 100));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private void cargarRegistroCondMinNov(IDataSet datasetCondMinNov, Integer oidRankear, Integer nroNovedad) throws BaseException {
		int secu = -1;
		Iterator iterMotivos = MotivoTipoNov.getAllActivos(this.getSesion()).iterator();
		while (iterMotivos.hasNext()) {
			MotivoTipoNov motivoTipoNov = (MotivoTipoNov) iterMotivos.next();
			--secu;
			cargarCondMinRank(datasetCondMinNov, secu, nroNovedad, oidRankear, motivoTipoNov.getTipo_novedad(), motivoTipoNov, false);
		}
	}

	private void cargarCondMinRank(IDataSet ds, Integer oidCondMinRank, Integer nroNovedad, Integer oidRankear, TipoNovedad tipoNov, MotivoTipoNov motivo, boolean activo) throws BaseException {
		ds.append();
		ds.fieldValue("oid_cond_min_rank", oidCondMinRank);
		ds.fieldValue("nro_novedad", nroNovedad);
		ds.fieldValue("oid_rankear", oidRankear);
		if (tipoNov != null) {
			ds.fieldValue("oid_tipo_nov", tipoNov.getOIDInteger());
			ds.fieldValue("tipo_nov", tipoNov.getDescripcion());
		} else {
			ds.fieldValue("oid_tipo_nov", "");
			ds.fieldValue("tipo_nov", "");
		}
		if (motivo != null) {
			ds.fieldValue("oid_motivo", motivo.getOIDInteger());
			ds.fieldValue("motivo", motivo.getDescripcion());
		} else {
			ds.fieldValue("oid_motivo", "");
			ds.fieldValue("motivo", "");
		}

		ds.fieldValue("activo", activo);
	}

	private IDataSet getDataSetCondMinSan1() {
		IDataSet dataset = new TDataSet();
		dataset.create("TCondMinSanc6");
		dataset.fieldDef(new Field("oid_cond_min_sanc", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nro_novedad", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_rankear", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_mot_sancion", Field.INTEGER, 0));
		dataset.fieldDef(new Field("desc_mot_sancion", Field.STRING, 100));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private IDataSet getDataSetCondMinSan2() {
		IDataSet dataset = new TDataSet();
		dataset.create("TCondMinSanc7");
		dataset.fieldDef(new Field("oid_cond_min_sanc", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nro_novedad", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_rankear", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_mot_sancion", Field.INTEGER, 0));
		dataset.fieldDef(new Field("desc_mot_sancion", Field.STRING, 100));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private IDataSet getDataSetCondMinSan3() {
		IDataSet dataset = new TDataSet();
		dataset.create("TCondMinSanc8");
		dataset.fieldDef(new Field("oid_cond_min_sanc", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nro_novedad", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_rankear", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_mot_sancion", Field.INTEGER, 0));
		dataset.fieldDef(new Field("desc_mot_sancion", Field.STRING, 100));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private IDataSet getDataSetCondMinSan4() {
		IDataSet dataset = new TDataSet();
		dataset.create("TCondMinSanc9");
		dataset.fieldDef(new Field("oid_cond_min_sanc", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nro_novedad", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_rankear", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_mot_sancion", Field.INTEGER, 0));
		dataset.fieldDef(new Field("desc_mot_sancion", Field.STRING, 100));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private IDataSet getDataSetCondMinSan5() {
		IDataSet dataset = new TDataSet();
		dataset.create("TCondMinSanc10");
		dataset.fieldDef(new Field("oid_cond_min_sanc", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nro_novedad", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_rankear", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_mot_sancion", Field.INTEGER, 0));
		dataset.fieldDef(new Field("desc_mot_sancion", Field.STRING, 100));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private void cargarRegistroCondMinSan(IDataSet datasetCondMinSan, Integer oidRankear, Integer nroNovedad) throws BaseException {
		int secu = -1;
		Iterator iterSanciones = SancionesRRHH.getAllSanciones(this.getSesion()).iterator();
		while (iterSanciones.hasNext()) {
			SancionesRRHH sancion = (SancionesRRHH) iterSanciones.next();
			--secu;
			cargarCondMinSanc(datasetCondMinSan, secu, nroNovedad, oidRankear, sancion, false);
		}
	}

	private void cargarCondMinSanc(IDataSet ds, Integer oidCondMinSan, Integer nroNovedad, Integer oidRankear, SancionesRRHH sancion, boolean activo) throws BaseException {
		ds.append();
		ds.fieldValue("oid_cond_min_sanc", oidCondMinSan);
		ds.fieldValue("nro_novedad", nroNovedad);
		ds.fieldValue("oid_rankear", oidRankear);
		ds.fieldValue("oid_mot_sancion", sancion.getOIDInteger());
		ds.fieldValue("desc_mot_sancion", sancion.getDescripcion());
		ds.fieldValue("activo", false);
	}

}
