package com.srn.erp.excluidos.op;


import java.util.Iterator;

import com.srn.erp.cip.bm.UtilCIP;
import com.srn.erp.excluidos.bm.ArchAdjExc;
import com.srn.erp.excluidos.bm.DifImporteExcluido;
import com.srn.erp.excluidos.bm.ImagenesExcluido;
import com.srn.erp.excluidos.bm.IndividuoExcluido;
import com.srn.erp.excluidos.bm.NovedadExcluido;
import com.srn.erp.excluidos.bm.ObsGeneralesExcluido;
import com.srn.erp.excluidos.bm.PredioExcluido;
import com.srn.erp.excluidos.bm.RelacionExcluido;
import com.srn.erp.excluidos.bm.VehiAsigExcluido;
import com.srn.erp.general.bm.FuncEspSegERP;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bm.Seguridad.AltaFuncEspSeg;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerIndividuoExcluido extends Operation {

	public TraerIndividuoExcluido() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		IndividuoExcluido individuoexcluido = null;
		if (mapaDatos.containsKey("oid")) {
			Integer oid = mapaDatos.getInteger("oid");
			individuoexcluido = IndividuoExcluido.findByOid(oid, getSesion());
		} else {
			String codigo = mapaDatos.getString("codigo");
			individuoexcluido = IndividuoExcluido.findByCodigo(codigo, getSesion());
		}

		IDataSet datasetIndividuoExcluido = getDataSetIndividuoExcluido();
		IDataSet datasetDifImpPagos = getDataSetDifImpPagos();
		IDataSet datasetVehiculos = getDataSetVehiculos();
		IDataSet datasetObsGen = getDataSetObsGenerales();
		IDataSet datasetNovExc = getDataSetNovedadExcluido();

		if (individuoexcluido != null) {

			cargarRegistroIndividuoExcluido(datasetIndividuoExcluido, individuoexcluido);

			Iterator iterDifImportes = individuoexcluido.getDifImportes().iterator();
			while (iterDifImportes.hasNext()) {
				DifImporteExcluido difImporte = (DifImporteExcluido) iterDifImportes.next();
				cargarRegistroDifMot(datasetDifImpPagos, difImporte);
			}

			Iterator iterVehiIndi = individuoexcluido.getVehiculos().iterator();
			while (iterVehiIndi.hasNext()) {
				VehiAsigExcluido vehiAsigExc = (VehiAsigExcluido) iterVehiIndi.next();
				cargarRegistroVehiculo(datasetVehiculos, vehiAsigExc);
			}

			Iterator iterObsGen = individuoexcluido.getObservacionesGenerales().iterator();
			while (iterObsGen.hasNext()) {
				ObsGeneralesExcluido obsGenExc = (ObsGeneralesExcluido) iterObsGen.next();
				cargarRegObsGeneral(datasetObsGen, obsGenExc);
			}

			int orden = 0;
			Iterator iterNovedades = individuoexcluido.getNovedades().iterator();
			while (iterNovedades.hasNext()) {
				++orden;
				NovedadExcluido novedad = (NovedadExcluido) iterNovedades.next();
				cargarRegistroNovedad(datasetNovExc, novedad, orden);
			}

		}

		writeCliente(datasetIndividuoExcluido);
		writeCliente(datasetDifImpPagos);
		writeCliente(datasetVehiculos);
		writeCliente(datasetObsGen);
		writeCliente(datasetNovExc);

	}

	private IDataSet getDataSetDifImpPagos() throws BaseException {
		IDataSet dataset = new TDataSet();
		dataset.create("TDifImporteExcluido");
		dataset.fieldDef(new Field("oid_dif_importe", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_individuo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("fecha", Field.DATE, 0));
		dataset.fieldDef(new Field("oid_mot_dif_imp", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_moneda", Field.INTEGER, 0));
		dataset.fieldDef(new Field("monto", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("observacion", Field.STRING, 255));
		dataset.fieldDef(new Field("orden", Field.INTEGER, 0));
		dataset.fieldDef(new Field("activo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_predio", Field.INTEGER, 0));
		dataset.fieldDef(new Field("read_only", Field.BOOLEAN, 0));
		return dataset;
	}

	private IDataSet getDataSetVehiculos() throws BaseException {
		IDataSet dataset = new TDataSet();
		dataset.create("TVehiculos");
		dataset.fieldDef(new Field("oid_vehiculo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_predio", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_individuo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("dominio", Field.STRING, 12));
		dataset.fieldDef(new Field("modelo", Field.STRING, 50));
		dataset.fieldDef(new Field("marca", Field.STRING, 50));
		dataset.fieldDef(new Field("oid_color", Field.INTEGER, 0));
		dataset.fieldDef(new Field("activo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("read_only", Field.BOOLEAN, 0));
		return dataset;
	}

	private IDataSet getDataSetObsGenerales() throws BaseException {
		IDataSet dataset = new TDataSet();
		dataset.create("TObsGenerales");
		dataset.fieldDef(new Field("oid_obs_grales", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_individuo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("fecha", Field.DATE, 0));
		dataset.fieldDef(new Field("observacion", Field.STRING, 5000));
		dataset.fieldDef(new Field("activo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_predio", Field.INTEGER, 0));
		dataset.fieldDef(new Field("read_only", Field.BOOLEAN, 0));
		return dataset;
	}

	private IDataSet getDataSetNovedadExcluido() {
		IDataSet dataset = new TDataSet();
		dataset.create("TNovedadExcluido");
		dataset.fieldDef(new Field("oid_novedad", Field.INTEGER, 0));
		dataset.fieldDef(new Field("fecha", Field.DATE, 0));
		dataset.fieldDef(new Field("hora", Field.STRING, 5));
		dataset.fieldDef(new Field("oid_estado", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_lugar_hecho", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_se_retira", Field.INTEGER, 0));
		dataset.fieldDef(new Field("hora_desde", Field.STRING, 5));
		dataset.fieldDef(new Field("oid_motivo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_turno", Field.INTEGER, 0));
		dataset.fieldDef(new Field("hora_hasta", Field.STRING, 5));
		dataset.fieldDef(new Field("oid_supervisor", Field.INTEGER, 0));
		dataset.fieldDef(new Field("observacion", Field.MEMO, 0));
		dataset.fieldDef(new Field("vig_desde", Field.DATE, 0));
		dataset.fieldDef(new Field("vig_hasta", Field.DATE, 0));
		dataset.fieldDef(new Field("dejar_sin_efecto", Field.INTEGER, 0));
		dataset.fieldDef(new Field("orden", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_individuo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("nro_acta", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nro_revocamiento", Field.INTEGER, 0));
		dataset.fieldDef(new Field("fec_rev", Field.DATE, 0));
		dataset.fieldDef(new Field("read_only", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("oid_gerente", Field.INTEGER, 0));
		dataset.fieldDef(new Field("condicion", Field.STRING, 100));
		dataset.fieldDef(new Field("irrevocable", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("oid_predio", Field.INTEGER, 0));
		dataset.fieldDef(new Field("restriccion_acceso", Field.BOOLEAN, 0));
		return dataset;
	}

	private IDataSet getDataSetIndividuoExcluido() {
		IDataSet dataset = new TDataSet();
		dataset.create("TIndividuoExcluido");
		dataset.fieldDef(new Field("oid_individuo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_predio", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_predio", Field.INTEGER, 0));
		dataset.fieldDef(new Field("tipo", Field.STRING, 20));
		dataset.fieldDef(new Field("apellido", Field.STRING, 50));
		dataset.fieldDef(new Field("nombre", Field.STRING, 50));
		dataset.fieldDef(new Field("oid_tipo_documento", Field.STRING, 0));
		dataset.fieldDef(new Field("nro_documento", Field.STRING, 50));
		dataset.fieldDef(new Field("apodo", Field.STRING, 50));
		dataset.fieldDef(new Field("oid_nacionalidad", Field.STRING, 0));
		dataset.fieldDef(new Field("legajo", Field.STRING, 50));
		dataset.fieldDef(new Field("oid_sector", Field.STRING, 0));
		dataset.fieldDef(new Field("oid_cargo", Field.STRING, 0));
		dataset.fieldDef(new Field("tipo_condicion", Field.STRING, 20));
		dataset.fieldDef(new Field("sexo", Field.STRING, 1));
		dataset.fieldDef(new Field("oid_raza", Field.STRING, 0));
		dataset.fieldDef(new Field("oid_altura", Field.STRING, 0));
		dataset.fieldDef(new Field("oid_complexion", Field.STRING, 0));
		dataset.fieldDef(new Field("oid_edad", Field.STRING, 0));
		dataset.fieldDef(new Field("oid_color", Field.STRING, 0));
		dataset.fieldDef(new Field("oid_tipo_barba", Field.STRING, 0));
		dataset.fieldDef(new Field("oid_tipo_cabello", Field.STRING, 0));
		dataset.fieldDef(new Field("oid_tipo_nariz", Field.STRING, 0));
		dataset.fieldDef(new Field("anteojos", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("marcas", Field.STRING, 50));
		dataset.fieldDef(new Field("rasgos", Field.STRING, 50));
		dataset.fieldDef(new Field("oid_estado", Field.STRING, 0));
		dataset.fieldDef(new Field("oid_estado_ant", Field.STRING, 0));
		dataset.fieldDef(new Field("fec_estado", Field.STRING, 0));
		dataset.fieldDef(new Field("fec_estado_ant", Field.STRING, 0));
		dataset.fieldDef(new Field("oid_legajo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("comen_foto_2", Field.STRING, 50));
		dataset.fieldDef(new Field("oid_predio_foto_2", Field.INTEGER, 0));
		dataset.fieldDef(new Field("fecha_date_foto_2", Field.DATE, 0));
		dataset.fieldDef(new Field("comen_foto_3", Field.STRING, 50));
		dataset.fieldDef(new Field("oid_predio_foto_3", Field.INTEGER, 0));
		dataset.fieldDef(new Field("fecha_date_foto_3", Field.DATE, 0));
		
		dataset.fieldDef(new Field("nro_ver_foto_1", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nro_ver_foto_2", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nro_ver_foto_3", Field.INTEGER, 0));
		
		

		dataset.fieldDef(new Field("oid_ind_rel_1", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nro_rel_ind_1", Field.INTEGER, 0));
		dataset.fieldDef(new Field("ape_y_nom_rel_1", Field.STRING, 100));
		dataset.fieldDef(new Field("estado_rel_1", Field.INTEGER, 0));
		dataset.fieldDef(new Field("obs_rel_1", Field.STRING, 255));
		dataset.fieldDef(new Field("oid_predio_rel_1", Field.INTEGER, 0));

		dataset.fieldDef(new Field("oid_ind_rel_2", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nro_rel_ind_2", Field.INTEGER, 0));
		dataset.fieldDef(new Field("ape_y_nom_rel_2", Field.STRING, 100));
		dataset.fieldDef(new Field("estado_rel_2", Field.INTEGER, 0));
		dataset.fieldDef(new Field("obs_rel_2", Field.STRING, 255));
		dataset.fieldDef(new Field("oid_predio_rel_2", Field.INTEGER, 0));

		dataset.fieldDef(new Field("oid_ind_rel_3", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nro_rel_ind_3", Field.INTEGER, 0));
		dataset.fieldDef(new Field("ape_y_nom_rel_3", Field.STRING, 100));
		dataset.fieldDef(new Field("estado_rel_3", Field.INTEGER, 0));
		dataset.fieldDef(new Field("obs_rel_3", Field.STRING, 255));
		dataset.fieldDef(new Field("oid_predio_rel_3", Field.INTEGER, 0));

		dataset.fieldDef(new Field("oid_ind_rel_4", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nro_rel_ind_4", Field.INTEGER, 0));
		dataset.fieldDef(new Field("ape_y_nom_rel_4", Field.STRING, 100));
		dataset.fieldDef(new Field("estado_rel_4", Field.INTEGER, 0));
		dataset.fieldDef(new Field("obs_rel_4", Field.STRING, 255));
		dataset.fieldDef(new Field("oid_predio_rel_4", Field.INTEGER, 0));

		dataset.fieldDef(new Field("oid_ind_rel_5", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nro_rel_ind_5", Field.INTEGER, 0));
		dataset.fieldDef(new Field("ape_y_nom_rel_5", Field.STRING, 100));
		dataset.fieldDef(new Field("estado_rel_5", Field.INTEGER, 0));
		dataset.fieldDef(new Field("obs_rel_5", Field.STRING, 255));

		dataset.fieldDef(new Field("oid_ind_rel_6", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nro_rel_ind_6", Field.INTEGER, 0));
		dataset.fieldDef(new Field("ape_y_nom_rel_6", Field.STRING, 100));
		dataset.fieldDef(new Field("estado_rel_6", Field.INTEGER, 0));
		dataset.fieldDef(new Field("obs_rel_6", Field.STRING, 255));

		dataset.fieldDef(new Field("oid_ind_rel_7", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nro_rel_ind_7", Field.INTEGER, 0));
		dataset.fieldDef(new Field("ape_y_nom_rel_7", Field.STRING, 100));
		dataset.fieldDef(new Field("estado_rel_7", Field.INTEGER, 0));
		dataset.fieldDef(new Field("obs_rel_7", Field.STRING, 255));

		dataset.fieldDef(new Field("oid_ind_rel_8", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nro_rel_ind_8", Field.INTEGER, 0));
		dataset.fieldDef(new Field("ape_y_nom_rel_8", Field.STRING, 100));
		dataset.fieldDef(new Field("estado_rel_8", Field.INTEGER, 0));
		dataset.fieldDef(new Field("obs_rel_8", Field.STRING, 255));

		dataset.fieldDef(new Field("act_aut_est_ind", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("obs_principal", Field.STRING, 100));
		dataset.fieldDef(new Field("oid_caracter", Field.INTEGER, 0));

		dataset.fieldDef(new Field("desc_estado_actual", Field.STRING, 50));

		dataset.fieldDef(new Field("arch_adj_titulo_1", Field.STRING, 100));
		dataset.fieldDef(new Field("arch_adj_nombre_1", Field.STRING, 100));
		dataset.fieldDef(new Field("arch_adj_fecha_1", Field.DATE, 0));
		dataset.fieldDef(new Field("arch_adj_id_1", Field.INTEGER, 0));
		dataset.fieldDef(new Field("arch_adj_oper_1", Field.STRING, 10));
		dataset.fieldDef(new Field("arch_adj_path_file_1", Field.STRING, 100));
		dataset.fieldDef(new Field("oid_predio_arch_adj_1", Field.INTEGER, 0));

		dataset.fieldDef(new Field("arch_adj_titulo_2", Field.STRING, 100));
		dataset.fieldDef(new Field("arch_adj_nombre_2", Field.STRING, 100));
		dataset.fieldDef(new Field("arch_adj_fecha_2", Field.DATE, 0));
		dataset.fieldDef(new Field("arch_adj_id_2", Field.INTEGER, 0));
		dataset.fieldDef(new Field("arch_adj_oper_2", Field.STRING, 10));
		dataset.fieldDef(new Field("arch_adj_path_file_2", Field.STRING, 100));
		dataset.fieldDef(new Field("oid_predio_arch_adj_2", Field.INTEGER, 0));

		dataset.fieldDef(new Field("arch_adj_titulo_3", Field.STRING, 100));
		dataset.fieldDef(new Field("arch_adj_nombre_3", Field.STRING, 100));
		dataset.fieldDef(new Field("arch_adj_fecha_3", Field.DATE, 0));
		dataset.fieldDef(new Field("arch_adj_id_3", Field.INTEGER, 0));
		dataset.fieldDef(new Field("arch_adj_oper_3", Field.STRING, 10));
		dataset.fieldDef(new Field("arch_adj_path_file_3", Field.STRING, 100));
		dataset.fieldDef(new Field("oid_predio_arch_adj_3", Field.INTEGER, 0));

		dataset.fieldDef(new Field("arch_adj_titulo_4", Field.STRING, 100));
		dataset.fieldDef(new Field("arch_adj_nombre_4", Field.STRING, 100));
		dataset.fieldDef(new Field("arch_adj_fecha_4", Field.DATE, 0));
		dataset.fieldDef(new Field("arch_adj_id_4", Field.INTEGER, 0));
		dataset.fieldDef(new Field("arch_adj_oper_4", Field.STRING, 10));
		dataset.fieldDef(new Field("arch_adj_path_file_4", Field.STRING, 100));
		dataset.fieldDef(new Field("oid_predio_arch_adj_4", Field.INTEGER, 0));
		

		dataset.fieldDef(new Field("arch_adj_titulo_5", Field.STRING, 100));
		dataset.fieldDef(new Field("arch_adj_nombre_5", Field.STRING, 100));
		dataset.fieldDef(new Field("arch_adj_fecha_5", Field.DATE, 0));
		dataset.fieldDef(new Field("arch_adj_id_5", Field.INTEGER, 0));
		dataset.fieldDef(new Field("arch_adj_oper_5", Field.STRING, 10));
		dataset.fieldDef(new Field("arch_adj_path_file_5", Field.STRING, 100));
		dataset.fieldDef(new Field("oid_predio_arch_adj_5", Field.INTEGER, 0));

		dataset.fieldDef(new Field("nro_registro", Field.STRING, 50));
		dataset.fieldDef(new Field("fec_actual", Field.STRING, 100));
		dataset.fieldDef(new Field("oid_anteojo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_marca", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_rasgo", Field.INTEGER, 0));

		dataset.fieldDef(new Field("irrevocable", Field.STRING, 50));
		dataset.fieldDef(new Field("foto_principal", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_predio_foto_1", Field.INTEGER, 0));

		dataset.fieldDef(new Field("oid_peligrosidad", Field.INTEGER, 0));
		
		
		

		return dataset;
	}

	private void cargarRegistroNovedad(IDataSet dataset, NovedadExcluido novedad, Integer orden) throws BaseException {

		dataset.append();
		dataset.fieldValue("oid_novedad", novedad.getOIDInteger());
		dataset.fieldValue("fecha", novedad.getFecha());
		dataset.fieldValue("hora", novedad.getHora());
		if (novedad.getEstado() != null)
			dataset.fieldValue("oid_estado", novedad.getEstado().getOIDInteger());
		else
			dataset.fieldValue("oid_estado", "");
		if (novedad.getLugar_del_hecho() != null)
			dataset.fieldValue("oid_lugar_hecho", novedad.getLugar_del_hecho().getOIDInteger());
		else
			dataset.fieldValue("oid_lugar_hecho", "");
		if (novedad.getSe_retira_en() != null)
			dataset.fieldValue("oid_se_retira", novedad.getSe_retira_en().getOIDInteger());
		else
			dataset.fieldValue("oid_se_retira", "");
		dataset.fieldValue("hora_desde", novedad.getHora_desde());
		if (novedad.getMotivo() != null)
			dataset.fieldValue("oid_motivo", novedad.getMotivo().getOIDInteger());
		else
			dataset.fieldValue("oid_motivo", "");
		if (novedad.getTurno() != null)
			dataset.fieldValue("oid_turno", novedad.getTurno().getOIDInteger());
		else
			dataset.fieldValue("oid_turno", "");
		dataset.fieldValue("hora_hasta", novedad.getHora_hasta());
		if (novedad.getSupervisor() != null)
			dataset.fieldValue("oid_supervisor", novedad.getSupervisor().getOIDInteger());
		else
			dataset.fieldValue("oid_supervisor", "");
		dataset.fieldValue("observacion", novedad.getObservacion());
		dataset.fieldValue("vig_desde", novedad.getVig_desde());
		dataset.fieldValue("vig_hasta", novedad.getVig_hasta());

		if (novedad.isDejar_sin_efecto())
			dataset.fieldValue("dejar_sin_efecto", 1);
		else
			dataset.fieldValue("dejar_sin_efecto", 0);

		dataset.fieldValue("orden", orden);
		dataset.fieldValue("oid_individuo", novedad.getIndividuoExcluido().getOIDInteger());
		if (novedad.isActivo())
			dataset.fieldValue("activo", 1);
		else
			dataset.fieldValue("activo", 0);

		dataset.fieldValue("nro_acta", novedad.getnroActa());
		dataset.fieldValue("nro_revocamiento", novedad.getnroRevocamiento());
		dataset.fieldValue("fec_rev", novedad.getFecRevocamiento());

		boolean habilitada = AltaFuncEspSeg.isFuncEspSegHabilitada(FuncEspSegERP.SEG_1119, "", false, this.getSesion());

		if (!habilitada)
			dataset.fieldValue("read_only", true);
		else
			dataset.fieldValue("read_only", false);

		if (novedad.getGerenteExcluido() != null)
			dataset.fieldValue("oid_gerente", novedad.getGerenteExcluido().getOID());
		else
			dataset.fieldValue("oid_gerente", "");
		dataset.fieldValue("condicion", novedad.getCondicion());
		dataset.fieldValue("irrevocable", novedad.isIrrevocable());
		if (novedad.getPredio() != null)
			dataset.fieldValue("oid_predio", novedad.getPredio().getOIDInteger());
		else
			dataset.fieldValue("oid_predio", PredioExcluido.getPredioDefaultExcluido(this.getSesion()).getOIDInteger());
		dataset.fieldValue("restriccion_acceso", novedad.isRestriccionAcceso());
	}

	private void cargarRegObsGeneral(IDataSet dataset, ObsGeneralesExcluido obsGenExc) throws BaseException {

		dataset.append();
		dataset.fieldValue("oid_obs_grales", obsGenExc.getOIDInteger());
		dataset.fieldValue("oid_individuo", obsGenExc.getIndividuo().getOIDInteger());
		dataset.fieldValue("fecha", obsGenExc.getFecha());
		dataset.fieldValue("observacion", obsGenExc.getObservacion()); // obsGenExc.getObservacion());
		if (obsGenExc.isActivo())
			dataset.fieldValue("activo", 1);
		else
			dataset.fieldValue("activo", 2);

		boolean habilitada = AltaFuncEspSeg.isFuncEspSegHabilitada(FuncEspSegERP.SEG_1116, "", false, this.getSesion());

		if (obsGenExc.getPredioExcluido() != null)
			dataset.fieldValue("oid_predio", obsGenExc.getPredioExcluido().getOID());
		else
			dataset.fieldValue("oid_predio", PredioExcluido.getPredioDefaultExcluido(this.getSesion()).getOIDInteger());

		if (!habilitada)
			dataset.fieldValue("read_only", true);
		else
			dataset.fieldValue("read_only", false);

	}

	private void cargarRegistroDifMot(IDataSet dataset, DifImporteExcluido difImporteExcluido) throws BaseException {

		dataset.append();
		dataset.fieldValue("oid_dif_importe", difImporteExcluido.getOIDInteger());
		dataset.fieldValue("oid_individuo", difImporteExcluido.getIndividuo().getOIDInteger());
		dataset.fieldValue("fecha", difImporteExcluido.getFecha());
		if (difImporteExcluido.getMotivo() != null)
			dataset.fieldValue("oid_mot_dif_imp", difImporteExcluido.getMotivo().getOIDInteger());
		else
			dataset.fieldValue("oid_mot_dif_imp", "");
		if (difImporteExcluido.getMoneda() != null)
			dataset.fieldValue("oid_moneda", difImporteExcluido.getMoneda().getOIDInteger());
		else
			dataset.fieldValue("oid_moneda", "");
		dataset.fieldValue("monto", difImporteExcluido.getMonto());
		dataset.fieldValue("observacion", difImporteExcluido.getObservacion());
		dataset.fieldValue("orden", difImporteExcluido.getOrden());
		if (difImporteExcluido.isActivo())
			dataset.fieldValue("activo", 1);
		else
			dataset.fieldValue("activo", 2);

		boolean habilitada = AltaFuncEspSeg.isFuncEspSegHabilitada(FuncEspSegERP.SEG_1110, "", false, this.getSesion());

		if (difImporteExcluido.getPredioExcluido() != null)
			dataset.fieldValue("oid_predio", difImporteExcluido.getPredioExcluido().getOID());
		else
			dataset.fieldValue("oid_predio", PredioExcluido.getPredioDefaultExcluido(this.getSesion()).getOIDInteger());
		if (!habilitada)
			dataset.fieldValue("read_only", true);
		else
			dataset.fieldValue("read_only", false);

	}

	private void cargarRegistroVehiculo(IDataSet dataset, VehiAsigExcluido vehiculo) throws BaseException {

		dataset.append();
		dataset.fieldValue("oid_vehiculo", vehiculo.getOIDInteger());
		if (vehiculo.getPredioExcluido() != null)
			dataset.fieldValue("oid_predio", vehiculo.getPredioExcluido().getOIDInteger());
		else
			dataset.fieldValue("oid_predio", PredioExcluido.getPredioDefaultExcluido(this.getSesion()).getOIDInteger());

		dataset.fieldValue("oid_individuo", vehiculo.getIndividuo().getOIDInteger());
		if (vehiculo.getVehiculo() != null) {
			dataset.fieldValue("dominio", vehiculo.getVehiculo().getDominio());
			dataset.fieldValue("modelo", vehiculo.getVehiculo().getModelo());
			dataset.fieldValue("marca", vehiculo.getVehiculo().getMarca());
			if (vehiculo.getVehiculo().getColor() != null)
				dataset.fieldValue("oid_color", vehiculo.getVehiculo().getColor().getOIDInteger());
			else
				dataset.fieldValue("oid_color", "");
			if (vehiculo.getVehiculo().isActivo())
				dataset.fieldValue("activo", 1);
			else
				dataset.fieldValue("activo", 2);

			boolean habilitada = AltaFuncEspSeg.isFuncEspSegHabilitada(FuncEspSegERP.SEG_1113, "", false, this.getSesion());

			if (!habilitada)
				dataset.fieldValue("read_only", true);
			else
				dataset.fieldValue("read_only", false);

		} else {
			dataset.fieldValue("dominio", "");
			dataset.fieldValue("modelo", "");
			dataset.fieldValue("marca", "");
			dataset.fieldValue("oid_color", "");
			dataset.fieldValue("activo", 1);

			boolean habilitada = AltaFuncEspSeg.isFuncEspSegHabilitada(FuncEspSegERP.SEG_1113, "", false, this.getSesion());

			if (!habilitada)
				dataset.fieldValue("read_only", true);
			else
				dataset.fieldValue("read_only", false);

		}

	}

	private void cargarRegistroIndividuoExcluido(IDataSet dataset, IndividuoExcluido individuo) throws BaseException {

		dataset.append();
		dataset.fieldValue("oid_individuo", individuo.getOIDInteger());
		if (individuo.getPredioExcluido() != null)
			dataset.fieldValue("oid_predio", individuo.getPredioExcluido().getOIDInteger());
		else
			dataset.fieldValue("oid_predio", PredioExcluido.getPredioDefaultExcluido(this.getSesion()).getOIDInteger());

		dataset.fieldValue("tipo", individuo.getTipo());
		dataset.fieldValue("apellido", individuo.getApellido());
		dataset.fieldValue("nombre", individuo.getNombre());
		if (individuo.getTipo_documento() != null)
			dataset.fieldValue("oid_tipo_documento", individuo.getTipo_documento().getOIDInteger());
		else
			dataset.fieldValue("oid_tipo_documento", "");
		dataset.fieldValue("nro_documento", individuo.getNro_documento());
		dataset.fieldValue("apodo", individuo.getApodo());
		if (individuo.getNacionalidad() != null)
			dataset.fieldValue("oid_nacionalidad", individuo.getNacionalidad().getOIDInteger());
		else
			dataset.fieldValue("oid_nacionalidad", "");
		dataset.fieldValue("legajo", individuo.getNro_legajo());
		if (individuo.getSector() != null)
			dataset.fieldValue("oid_sector", individuo.getSector().getOIDInteger());
		else
			dataset.fieldValue("oid_sector", "");
		if (individuo.getCargo() != null)
			dataset.fieldValue("oid_cargo", individuo.getCargo().getOIDInteger());
		else
			dataset.fieldValue("oid_cargo", "");
		if (individuo != null)
			dataset.fieldValue("tipo_condicion", individuo.getTipo_condicion());
		else
			dataset.fieldValue("tipo_condicion", "");
		dataset.fieldValue("sexo", individuo.getSexo());
		if (individuo.getRaza() != null)
			dataset.fieldValue("oid_raza", individuo.getRaza().getOIDInteger());
		else
			dataset.fieldValue("oid_raza", "");
		if (individuo.getAltura() != null)
			dataset.fieldValue("oid_altura", individuo.getAltura().getOIDInteger());
		else
			dataset.fieldValue("oid_altura", "");
		if (individuo.getComplexion() != null)
			dataset.fieldValue("oid_complexion", individuo.getComplexion().getOIDInteger());
		else
			dataset.fieldValue("oid_complexion", "");
		if (individuo.getEdad() != null)
			dataset.fieldValue("oid_edad", individuo.getEdad().getOIDInteger());
		else
			dataset.fieldValue("oid_edad", "");
		if (individuo.getColor() != null)
			dataset.fieldValue("oid_color", individuo.getColor().getOIDInteger());
		else
			dataset.fieldValue("oid_color", "");
		if (individuo.getTipo_barba() != null)
			dataset.fieldValue("oid_tipo_barba", individuo.getTipo_barba().getOIDInteger());
		else
			dataset.fieldValue("oid_tipo_barba", "");
		if (individuo.getTipo_cabello() != null)
			dataset.fieldValue("oid_tipo_cabello", individuo.getTipo_cabello().getOIDInteger());
		else
			dataset.fieldValue("oid_tipo_cabello", "");
		if (individuo.getTipo_nariz() != null)
			dataset.fieldValue("oid_tipo_nariz", individuo.getTipo_nariz().getOIDInteger());
		else
			dataset.fieldValue("oid_tipo_nariz", "");
		if (individuo.isAnteojos())
			dataset.fieldValue("anteojos", 1);
		else
			dataset.fieldValue("anteojos", 0);
		dataset.fieldValue("marcas", individuo.getMarcas());
		dataset.fieldValue("rasgos", individuo.getRasgos());
		if (individuo.getEstado() != null)
			dataset.fieldValue("oid_estado", individuo.getEstado().getOIDInteger());
		else
			dataset.fieldValue("oid_estado", "");
		if (individuo.getEstado_anterior() != null)
			dataset.fieldValue("oid_estado_ant", individuo.getEstado_anterior().getOID());
		else
			dataset.fieldValue("oid_estado_ant", "");
		dataset.fieldValue("fec_estado", individuo.getFec_estado());
		dataset.fieldValue("fec_estado_ant", individuo.getFec_estado_ant());
		if (individuo.getLegajo() != null)
			dataset.fieldValue("oid_legajo", individuo.getLegajo().getOIDInteger());
		else
			dataset.fieldValue("oid_legajo", "");
		dataset.fieldValue("activo", individuo.isActivo());

		ImagenesExcluido imagenExc1 = individuo.getImagenExcluido(1);
		if (imagenExc1 != null) {
			dataset.fieldValue("comen_foto_2", imagenExc1.getComentario());
			if (imagenExc1.getPredio() != null)
				dataset.fieldValue("oid_predio_foto_2", imagenExc1.getPredio().getOID());
			else
				dataset.fieldValue("oid_predio_foto_2", PredioExcluido.getPredioDefaultExcluido(this.getSesion()).getOIDInteger());
			dataset.fieldValue("fecha_date_foto_2", imagenExc1.getFecha());
		} else {
			dataset.fieldValue("comen_foto_2", "");
			dataset.fieldValue("oid_predio_foto_2", PredioExcluido.getPredioDefaultExcluido(this.getSesion()).getOIDInteger());
			dataset.fieldValue("fecha_date_foto_2", "");
		}

		ImagenesExcluido imagenExc2 = individuo.getImagenExcluido(2);
		if (imagenExc2 != null) {
			dataset.fieldValue("comen_foto_3", imagenExc2.getComentario());
			if (imagenExc2.getPredio() != null)
				dataset.fieldValue("oid_predio_foto_3", imagenExc2.getPredio().getOID());
			else
				dataset.fieldValue("oid_predio_foto_3", PredioExcluido.getPredioDefaultExcluido(this.getSesion()).getOIDInteger());
			dataset.fieldValue("fecha_date_foto_3", imagenExc2.getFecha());
		} else {
			dataset.fieldValue("comen_foto_3", "");
			dataset.fieldValue("oid_predio_foto_3", PredioExcluido.getPredioDefaultExcluido(this.getSesion()).getOIDInteger());
			dataset.fieldValue("fecha_date_foto_3", "");
		}
		
		dataset.fieldValue("nro_ver_foto_1" , individuo.getNroVersionFoto1());
		dataset.fieldValue("nro_ver_foto_2" , individuo.getNroVersionFoto2());
		dataset.fieldValue("nro_ver_foto_3" , individuo.getNroVersionFoto3());
		
		RelacionExcluido relacionExcluido = RelacionExcluido.getRelacionExcluido(individuo, 1, this.getSesion());
		if (relacionExcluido != null) {
			if (relacionExcluido.getIndividuo_rel() != null) {
				dataset.fieldValue("oid_ind_rel_1", relacionExcluido.getIndividuo_rel().getOIDInteger());
				dataset.fieldValue("nro_rel_ind_1", relacionExcluido.getIndividuo_rel().getOIDInteger());
				dataset.fieldValue("ape_y_nom_rel_1", relacionExcluido.getIndividuo_rel().getApeyNom());
			} else {
				dataset.fieldValue("oid_ind_rel_1", "");
				dataset.fieldValue("nro_rel_ind_1", "");
				dataset.fieldValue("ape_y_nom_rel_1", "");
			}
			if ((relacionExcluido.getIndividuo_rel() != null) && (relacionExcluido.getIndividuo_rel().getEstado() != null))
				dataset.fieldValue("estado_rel_1", relacionExcluido.getIndividuo_rel().getNroPrincipal1());
			else
				dataset.fieldValue("estado_rel_1", "");
			dataset.fieldValue("obs_rel_1", relacionExcluido.getComentario());
			if (relacionExcluido.getPredio()!=null)
				dataset.fieldValue("oid_predio_rel_1", relacionExcluido.getPredio().getOIDInteger());
			else
				dataset.fieldValue("oid_predio_rel_1", PredioExcluido.getPredioDefaultExcluido(this.getSesion()).getOIDInteger());
		} else {
			dataset.fieldValue("oid_ind_rel_1", "");
			dataset.fieldValue("nro_rel_ind_1", "");
			dataset.fieldValue("ape_y_nom_rel_1", "");
			dataset.fieldValue("estado_rel_1", "");
			dataset.fieldValue("obs_rel_1", "");
			dataset.fieldValue("oid_predio_rel_1", PredioExcluido.getPredioDefaultExcluido(this.getSesion()).getOIDInteger());
		}

		relacionExcluido = RelacionExcluido.getRelacionExcluido(individuo, 2, this.getSesion());
		if (relacionExcluido != null) {
			if (relacionExcluido.getIndividuo_rel() != null) {
				dataset.fieldValue("oid_ind_rel_2", relacionExcluido.getIndividuo_rel().getOIDInteger());
				dataset.fieldValue("nro_rel_ind_2", relacionExcluido.getIndividuo_rel().getOIDInteger());
				dataset.fieldValue("ape_y_nom_rel_2", relacionExcluido.getIndividuo_rel().getApeyNom());
			} else {
				dataset.fieldValue("oid_ind_rel_2", "");
				dataset.fieldValue("nro_rel_ind_2", "");
				dataset.fieldValue("ape_y_nom_rel_2", "");
			}
			if ((relacionExcluido.getIndividuo_rel() != null) && (relacionExcluido.getIndividuo_rel().getEstado() != null))
				dataset.fieldValue("estado_rel_2", relacionExcluido.getIndividuo_rel().getNroPrincipal1());
			else
				dataset.fieldValue("estado_rel_2", "");
			dataset.fieldValue("obs_rel_2", relacionExcluido.getComentario());
			if (relacionExcluido.getPredio()!=null)
				dataset.fieldValue("oid_predio_rel_2", relacionExcluido.getPredio().getOIDInteger());
			else
				dataset.fieldValue("oid_predio_rel_2", PredioExcluido.getPredioDefaultExcluido(this.getSesion()).getOIDInteger());
		} else {
			dataset.fieldValue("oid_ind_rel_2", "");
			dataset.fieldValue("nro_rel_ind_2", "");
			dataset.fieldValue("ape_y_nom_rel_2", "");
			dataset.fieldValue("estado_rel_2", "");
			dataset.fieldValue("obs_rel_2", "");
			dataset.fieldValue("oid_predio_rel_2", PredioExcluido.getPredioDefaultExcluido(this.getSesion()).getOIDInteger());
		}

		relacionExcluido = RelacionExcluido.getRelacionExcluido(individuo, 3, this.getSesion());
		if (relacionExcluido != null) {
			if (relacionExcluido.getIndividuo_rel() != null) {
				dataset.fieldValue("oid_ind_rel_3", relacionExcluido.getIndividuo_rel().getOIDInteger());
				dataset.fieldValue("nro_rel_ind_3", relacionExcluido.getIndividuo_rel().getOIDInteger());
				dataset.fieldValue("ape_y_nom_rel_3", relacionExcluido.getIndividuo_rel().getApeyNom());
			} else {
				dataset.fieldValue("oid_ind_rel_3", "");
				dataset.fieldValue("nro_rel_ind_3", "");
				dataset.fieldValue("ape_y_nom_rel_3", "");
			}
			if ((relacionExcluido.getIndividuo_rel() != null) && (relacionExcluido.getIndividuo_rel().getEstado() != null))
				dataset.fieldValue("estado_rel_3", relacionExcluido.getIndividuo_rel().getNroPrincipal1());
			else
				dataset.fieldValue("estado_rel_3", "");
			dataset.fieldValue("obs_rel_3", relacionExcluido.getComentario());
			if (relacionExcluido.getPredio()!=null)
				dataset.fieldValue("oid_predio_rel_3", relacionExcluido.getPredio().getOIDInteger());
			else
				dataset.fieldValue("oid_predio_rel_3", PredioExcluido.getPredioDefaultExcluido(this.getSesion()).getOIDInteger());
		} else {
			dataset.fieldValue("oid_ind_rel_3", "");
			dataset.fieldValue("nro_rel_ind_3", "");
			dataset.fieldValue("ape_y_nom_rel_3", "");
			dataset.fieldValue("estado_rel_3", "");
			dataset.fieldValue("obs_rel_3", "");
			dataset.fieldValue("oid_predio_rel_3", PredioExcluido.getPredioDefaultExcluido(this.getSesion()).getOIDInteger());
		}

		relacionExcluido = RelacionExcluido.getRelacionExcluido(individuo, 4, this.getSesion());
		if (relacionExcluido != null) {
			if (relacionExcluido.getIndividuo_rel() != null) {
				dataset.fieldValue("oid_ind_rel_4", relacionExcluido.getIndividuo_rel().getOIDInteger());
				dataset.fieldValue("nro_rel_ind_4", relacionExcluido.getIndividuo_rel().getOIDInteger());
				dataset.fieldValue("ape_y_nom_rel_4", relacionExcluido.getIndividuo_rel().getApeyNom());
			} else {
				dataset.fieldValue("oid_ind_rel_4", "");
				dataset.fieldValue("nro_rel_ind_4", "");
				dataset.fieldValue("ape_y_nom_rel_4", "");
			}
			if ((relacionExcluido.getIndividuo_rel() != null) && (relacionExcluido.getIndividuo_rel().getEstado() != null))
				dataset.fieldValue("estado_rel_4", relacionExcluido.getIndividuo_rel().getNroPrincipal1());
			else
				dataset.fieldValue("estado_rel_4", "");
			dataset.fieldValue("obs_rel_4", relacionExcluido.getComentario());
			if (relacionExcluido.getPredio()!=null)
				dataset.fieldValue("oid_predio_rel_4", relacionExcluido.getPredio().getOIDInteger());
			else
				dataset.fieldValue("oid_predio_rel_4", PredioExcluido.getPredioDefaultExcluido(this.getSesion()).getOIDInteger());
		} else {
			dataset.fieldValue("oid_ind_rel_4", "");
			dataset.fieldValue("nro_rel_ind_4", "");
			dataset.fieldValue("ape_y_nom_rel_4", "");
			dataset.fieldValue("estado_rel_4", "");
			dataset.fieldValue("obs_rel_4", "");
			dataset.fieldValue("oid_predio_rel_4", PredioExcluido.getPredioDefaultExcluido(this.getSesion()).getOIDInteger());
		}

		RelacionExcluido relExc5 = null;
		RelacionExcluido relExc6 = null;
		RelacionExcluido relExc7 = null;
		RelacionExcluido relExc8 = null;

		int contExc = 1;
		Iterator iterRelIndi = RelacionExcluido.getRelacionesIndividuales(individuo, this.getSesion()).iterator();
		while (iterRelIndi.hasNext()) {
			RelacionExcluido relExcTemp = (RelacionExcluido) iterRelIndi.next();
			if (contExc == 1)
				relExc5 = relExcTemp;
			else if (contExc == 2)
				relExc6 = relExcTemp;
			else if (contExc == 3)
				relExc7 = relExcTemp;
			else if (contExc == 4)
				relExc8 = relExcTemp;
			++contExc;
		}

		if (relExc5 == null) {
			dataset.fieldValue("oid_ind_rel_5", "");
			dataset.fieldValue("nro_rel_ind_5", "");
			dataset.fieldValue("ape_y_nom_rel_5", "");
			dataset.fieldValue("estado_rel_5", "");
			dataset.fieldValue("obs_rel_5", "");
		} else {
			dataset.fieldValue("oid_ind_rel_5", relExc5.getOIDInteger());
			dataset.fieldValue("nro_rel_ind_5", relExc5.getIndividuo().getOIDInteger());
			dataset.fieldValue("ape_y_nom_rel_5", relExc5.getIndividuo().getApeyNom());
			if (relExc5.getIndividuo().getEstado() != null)
				dataset.fieldValue("estado_rel_5", relExc5.getIndividuo().getNroPrincipal1());
			else
				dataset.fieldValue("estado_rel_5", "");
			dataset.fieldValue("obs_rel_5", relExc5.getComentario());
		}

		if (relExc6 == null) {
			dataset.fieldValue("oid_ind_rel_6", "");
			dataset.fieldValue("nro_rel_ind_6", "");
			dataset.fieldValue("ape_y_nom_rel_6", "");
			dataset.fieldValue("estado_rel_6", "");
			dataset.fieldValue("obs_rel_6", "");
		} else {
			dataset.fieldValue("oid_ind_rel_6", relExc6.getOIDInteger());
			dataset.fieldValue("nro_rel_ind_6", relExc6.getIndividuo().getOIDInteger());
			dataset.fieldValue("ape_y_nom_rel_6", relExc6.getIndividuo().getApeyNom());
			if (relExc6.getIndividuo().getEstado() != null)
				dataset.fieldValue("estado_rel_6", relExc6.getIndividuo().getNroPrincipal1());
			else
				dataset.fieldValue("estado_rel_6", "");
			dataset.fieldValue("obs_rel_6", relExc6.getComentario());
		}

		if (relExc7 == null) {
			dataset.fieldValue("oid_ind_rel_7", "");
			dataset.fieldValue("nro_rel_ind_7", "");
			dataset.fieldValue("ape_y_nom_rel_7", "");
			dataset.fieldValue("estado_rel_7", "");
			dataset.fieldValue("obs_rel_7", "");
		} else {
			dataset.fieldValue("oid_ind_rel_7", relExc7.getOIDInteger());
			dataset.fieldValue("nro_rel_ind_7", relExc7.getIndividuo().getOIDInteger());
			dataset.fieldValue("ape_y_nom_rel_7", relExc7.getIndividuo().getApeyNom());
			if (relExc7.getIndividuo().getEstado() != null)
				dataset.fieldValue("estado_rel_7", relExc7.getIndividuo().getNroPrincipal1());
			else
				dataset.fieldValue("estado_rel_7", "");
			dataset.fieldValue("obs_rel_7", relExc7.getComentario());
		}

		if (relExc8 == null) {
			dataset.fieldValue("oid_ind_rel_8", "");
			dataset.fieldValue("nro_rel_ind_8", "");
			dataset.fieldValue("ape_y_nom_rel_8", "");
			dataset.fieldValue("estado_rel_8", "");
			dataset.fieldValue("obs_rel_8", "");
		} else {
			dataset.fieldValue("oid_ind_rel_8", relExc8.getOIDInteger());
			dataset.fieldValue("nro_rel_ind_8", relExc8.getIndividuo().getOIDInteger());
			dataset.fieldValue("ape_y_nom_rel_8", relExc8.getIndividuo().getApeyNom());
			if (relExc8.getIndividuo().getEstado() != null)
				dataset.fieldValue("estado_rel_8", relExc8.getIndividuo().getNroPrincipal1());
			else
				dataset.fieldValue("estado_rel_8", "");
			dataset.fieldValue("obs_rel_8", relExc8.getComentario());
		}

		dataset.fieldValue("act_aut_est_ind", individuo.isActuAutoEstInd());
		dataset.fieldValue("obs_principal", individuo.getObsPrincipal());
		if (individuo.getCaracter() != null)
			dataset.fieldValue("oid_caracter", individuo.getCaracter().getOIDInteger());
		else
			dataset.fieldValue("oid_caracter", "");

		if (individuo.getEstado() != null)
			dataset.fieldValue("desc_estado_actual", individuo.getEstado().getDescripcion());
		else
			dataset.fieldValue("desc_estado_actual", "");

		ArchAdjExc archAdjExc1 = ArchAdjExc.getArchivoAdjExc(individuo, 1, this.getSesion());
		if (archAdjExc1 != null) {
			dataset.fieldValue("arch_adj_titulo_1", archAdjExc1.getTitulo());
			dataset.fieldValue("arch_adj_nombre_1", archAdjExc1.getNombre());
			dataset.fieldValue("arch_adj_fecha_1", archAdjExc1.getFecha());
			dataset.fieldValue("arch_adj_id_1", archAdjExc1.getOIDInteger());
			dataset.fieldValue("arch_adj_oper_1", "G");
			dataset.fieldValue("arch_adj_path_file_1", "");
			if (archAdjExc1.getPredio()!=null)
				dataset.fieldValue("oid_predio_arch_adj_1", archAdjExc1.getPredio().getOIDInteger());
			else
				dataset.fieldValue("oid_predio_arch_adj_1", PredioExcluido.getPredioDefaultExcluido(this.getSesion()).getOIDInteger());
		} else {
			dataset.fieldValue("arch_adj_titulo_1", "");
			dataset.fieldValue("arch_adj_nombre_1", "");
			dataset.fieldValue("arch_adj_fecha_1", Fecha.FECHA_NULA());
			dataset.fieldValue("arch_adj_id_1", "");
			dataset.fieldValue("arch_adj_oper_1", "G");
			dataset.fieldValue("arch_adj_path_file_1", "");
			dataset.fieldValue("oid_predio_arch_adj_1", PredioExcluido.getPredioDefaultExcluido(this.getSesion()).getOIDInteger());
		}

		ArchAdjExc archAdjExc2 = ArchAdjExc.getArchivoAdjExc(individuo, 2, this.getSesion());
		if (archAdjExc2 != null) {
			dataset.fieldValue("arch_adj_titulo_2", archAdjExc2.getTitulo());
			dataset.fieldValue("arch_adj_nombre_2", archAdjExc2.getNombre());
			dataset.fieldValue("arch_adj_fecha_2", archAdjExc2.getFecha());
			dataset.fieldValue("arch_adj_id_2", archAdjExc2.getOIDInteger());
			dataset.fieldValue("arch_adj_oper_2", "G");
			dataset.fieldValue("arch_adj_path_file_2", "");
			if (archAdjExc2.getPredio()!=null)
				dataset.fieldValue("oid_predio_arch_adj_2", archAdjExc2.getPredio().getOIDInteger());
			else
				dataset.fieldValue("oid_predio_arch_adj_2", PredioExcluido.getPredioDefaultExcluido(this.getSesion()).getOIDInteger());
		} else {
			dataset.fieldValue("arch_adj_titulo_2", "");
			dataset.fieldValue("arch_adj_nombre_2", "");
			dataset.fieldValue("arch_adj_fecha_2", Fecha.FECHA_NULA());
			dataset.fieldValue("arch_adj_id_2", "");
			dataset.fieldValue("arch_adj_oper_2", "G");
			dataset.fieldValue("arch_adj_path_file_2", "");
			dataset.fieldValue("oid_predio_arch_adj_2", PredioExcluido.getPredioDefaultExcluido(this.getSesion()).getOIDInteger());
		}

		ArchAdjExc archAdjExc3 = ArchAdjExc.getArchivoAdjExc(individuo, 3, this.getSesion());
		if (archAdjExc3 != null) {
			dataset.fieldValue("arch_adj_titulo_3", archAdjExc3.getTitulo());
			dataset.fieldValue("arch_adj_nombre_3", archAdjExc3.getNombre());
			dataset.fieldValue("arch_adj_fecha_3", archAdjExc3.getFecha());
			dataset.fieldValue("arch_adj_id_3", archAdjExc3.getOIDInteger());
			dataset.fieldValue("arch_adj_oper_3", "G");
			dataset.fieldValue("arch_adj_path_file_3", "");
			if (archAdjExc3.getPredio()!=null)
				dataset.fieldValue("oid_predio_arch_adj_3", archAdjExc3.getPredio().getOIDInteger());
			else
				dataset.fieldValue("oid_predio_arch_adj_3", PredioExcluido.getPredioDefaultExcluido(this.getSesion()).getOIDInteger());
		} else {
			dataset.fieldValue("arch_adj_titulo_3", "");
			dataset.fieldValue("arch_adj_nombre_3", "");
			dataset.fieldValue("arch_adj_fecha_3", Fecha.FECHA_NULA());
			dataset.fieldValue("arch_adj_id_3", "");
			dataset.fieldValue("arch_adj_oper_3", "G");
			dataset.fieldValue("arch_adj_path_file_3", "");
			dataset.fieldValue("oid_predio_arch_adj_3", PredioExcluido.getPredioDefaultExcluido(this.getSesion()).getOIDInteger());
		}

		ArchAdjExc archAdjExc4 = ArchAdjExc.getArchivoAdjExc(individuo, 4, this.getSesion());
		if (archAdjExc4 != null) {
			dataset.fieldValue("arch_adj_titulo_4", archAdjExc4.getTitulo());
			dataset.fieldValue("arch_adj_nombre_4", archAdjExc4.getNombre());
			dataset.fieldValue("arch_adj_fecha_4", archAdjExc4.getFecha());
			dataset.fieldValue("arch_adj_id_4", archAdjExc4.getOIDInteger());
			dataset.fieldValue("arch_adj_oper_4", "G");
			dataset.fieldValue("arch_adj_path_file_4", "");
			if (archAdjExc4.getPredio()!=null)
				dataset.fieldValue("oid_predio_arch_adj_4", archAdjExc4.getPredio().getOIDInteger());
			else
				dataset.fieldValue("oid_predio_arch_adj_4", PredioExcluido.getPredioDefaultExcluido(this.getSesion()).getOIDInteger());
		} else {
			dataset.fieldValue("arch_adj_titulo_4", "");
			dataset.fieldValue("arch_adj_nombre_4", "");
			dataset.fieldValue("arch_adj_fecha_4", Fecha.FECHA_NULA());
			dataset.fieldValue("arch_adj_id_4", "");
			dataset.fieldValue("arch_adj_oper_4", "G");
			dataset.fieldValue("arch_adj_path_file_4", "");
			dataset.fieldValue("oid_predio_arch_adj_4", PredioExcluido.getPredioDefaultExcluido(this.getSesion()).getOIDInteger());
		}

		ArchAdjExc archAdjExc5 = ArchAdjExc.getArchivoAdjExc(individuo, 5, this.getSesion());
		if (archAdjExc5 != null) {
			dataset.fieldValue("arch_adj_titulo_5", archAdjExc5.getTitulo());
			dataset.fieldValue("arch_adj_nombre_5", archAdjExc5.getNombre());
			dataset.fieldValue("arch_adj_fecha_5", archAdjExc5.getFecha());
			dataset.fieldValue("arch_adj_id_5", archAdjExc5.getOIDInteger());
			dataset.fieldValue("arch_adj_oper_5", "G");
			dataset.fieldValue("arch_adj_path_file_5", "");
			if (archAdjExc5.getPredio()!=null)
				dataset.fieldValue("oid_predio_arch_adj_5", archAdjExc5.getPredio().getOIDInteger());
			else
				dataset.fieldValue("oid_predio_arch_adj_5", PredioExcluido.getPredioDefaultExcluido(this.getSesion()).getOIDInteger());
		} else {
			dataset.fieldValue("arch_adj_titulo_5", "");
			dataset.fieldValue("arch_adj_nombre_5", "");
			dataset.fieldValue("arch_adj_fecha_5", Fecha.FECHA_NULA());
			dataset.fieldValue("arch_adj_id_5", "");
			dataset.fieldValue("arch_adj_oper_5", "G");
			dataset.fieldValue("arch_adj_path_file_5", "");
			dataset.fieldValue("oid_predio_arch_adj_5", PredioExcluido.getPredioDefaultExcluido(this.getSesion()).getOIDInteger());
		}

		dataset.fieldValue("nro_registro", individuo.getNroPrincipal());
		dataset.fieldValue("fec_actual", Fecha.getddmmyyyy(UtilCIP.getFechaHoraActual(this.getSesion())));
		if (individuo.getAnteojo() != null)
			dataset.fieldValue("oid_anteojo", individuo.getAnteojo().getOIDInteger());
		else
			dataset.fieldValue("oid_anteojo", "");

		if (individuo.getMarca() != null)
			dataset.fieldValue("oid_marca", individuo.getMarca().getOIDInteger());
		else
			dataset.fieldValue("oid_marca", "");

		if (individuo.getRasgo() != null)
			dataset.fieldValue("oid_rasgo", individuo.getRasgo().getOIDInteger());
		else
			dataset.fieldValue("oid_rasgo", "");

		if ((individuo.getNovedadExcluido() != null) && (individuo.getNovedadExcluido().isIrrevocable()))
			dataset.fieldValue("irrevocable", "IRREVOCABLE");
		else
			dataset.fieldValue("irrevocable", "");
		dataset.fieldValue("foto_principal", individuo.getFotoPrincipal());
		if (individuo.getPredioFoto1() != null)
			dataset.fieldValue("oid_predio_foto_1", individuo.getPredioFoto1().getOID());
		else
			dataset.fieldValue("oid_predio_foto_1", PredioExcluido.getPredioDefaultExcluido(this.getSesion()).getOIDInteger());
		if (individuo.getPeligrosidad() != null)
			dataset.fieldValue("oid_peligrosidad", individuo.getPeligrosidad().getOIDInteger());
		else
			dataset.fieldValue("oid_peligrosidad", "");

	}
}
