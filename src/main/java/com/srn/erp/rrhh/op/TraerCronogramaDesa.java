package com.srn.erp.rrhh.op;

import java.util.Iterator;

import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.rrhh.bm.AccCronoDesa;
import com.srn.erp.rrhh.bm.CronogramaDesa;
import com.srn.erp.rrhh.bm.EstadoAccCroDesa;
import com.srn.erp.rrhh.bm.EstrucNivEmpresa;
import com.srn.erp.rrhh.bm.EstrucNivPuesto;
import com.srn.erp.rrhh.bm.EstrucNivSector;
import com.srn.erp.rrhh.bm.JerarquiaDesa;
import com.srn.erp.rrhh.bm.MesCronoDesa;

import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerCronogramaDesa extends Operation {

	public TraerCronogramaDesa() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		CronogramaDesa cronogramadesa = null;
		if (mapaDatos.containsKey("oid")) {
			Integer oid = mapaDatos.getInteger("oid");
			cronogramadesa = CronogramaDesa.findByOid(oid, getSesion());
		} else {
			String codigo = mapaDatos.getString("codigo");
			cronogramadesa = CronogramaDesa.findByCodigo(codigo, getSesion());
		}

		IDataSet datasetCronogramaDesa = getDataSetCronogramaDesa();
		IDataSet datasetAcciones = getDataSetAccCronoDesa();
		IDataSet datasetEstados = getDataSetEstados();
		IDataSet datasetMesAEval = getDataSetMesesAEvaluar();
		IDataSet datasetSegmentacion = this.getDataSetSegmentacion();

		if (cronogramadesa != null) {

			cargarRegistroCronogramaDesa(datasetCronogramaDesa, cronogramadesa);
			Iterator iterAcciones = cronogramadesa.getAcciones().iterator();
			while (iterAcciones.hasNext()) {
				AccCronoDesa accCronoDesa = (AccCronoDesa) iterAcciones.next();
				cargarRegistroAccCronoDesa(datasetAcciones, accCronoDesa);
				int secuEstados = 0;
				ClasificadorEntidad clasifEstado = TraerLeyendasRepEval.getClasificadorEstado(this.getSesion());
				Iterator iterValClasifEst = ValorClasificadorEntidad.getValoresClasifEntidad(clasifEstado, this.getSesion()).iterator();
				while (iterValClasifEst.hasNext()) {
					ValorClasificadorEntidad valorClasificadorEntidad = (ValorClasificadorEntidad) iterValClasifEst.next();
					++secuEstados;
					EstadoAccCroDesa estadoAccCroDesa = EstadoAccCroDesa.getEstadoAccCroDesa(accCronoDesa, valorClasificadorEntidad, this.getSesion());
					if (estadoAccCroDesa != null)
						cargarRegistroEstado(datasetEstados, secuEstados, accCronoDesa, valorClasificadorEntidad, true);
					else
						cargarRegistroEstado(datasetEstados, secuEstados, accCronoDesa, valorClasificadorEntidad, false);
				}

				MesCronoDesa mesEne = MesCronoDesa.getMesCronoDesa(accCronoDesa, MesCronoDesa.ENERO, this.getSesion());
				MesCronoDesa mesFeb = MesCronoDesa.getMesCronoDesa(accCronoDesa, MesCronoDesa.FEBRERO, this.getSesion());
				MesCronoDesa mesMar = MesCronoDesa.getMesCronoDesa(accCronoDesa, MesCronoDesa.MARZO, this.getSesion());
				MesCronoDesa mesAbr = MesCronoDesa.getMesCronoDesa(accCronoDesa, MesCronoDesa.ABRIL, this.getSesion());
				MesCronoDesa mesMay = MesCronoDesa.getMesCronoDesa(accCronoDesa, MesCronoDesa.MAYO, this.getSesion());
				MesCronoDesa mesJun = MesCronoDesa.getMesCronoDesa(accCronoDesa, MesCronoDesa.JUNIO, this.getSesion());
				MesCronoDesa mesJul = MesCronoDesa.getMesCronoDesa(accCronoDesa, MesCronoDesa.JULIO, this.getSesion());
				MesCronoDesa mesAgo = MesCronoDesa.getMesCronoDesa(accCronoDesa, MesCronoDesa.AGOSTO, this.getSesion());
				MesCronoDesa mesSet = MesCronoDesa.getMesCronoDesa(accCronoDesa, MesCronoDesa.SEPTIEMBRE, this.getSesion());
				MesCronoDesa mesOct = MesCronoDesa.getMesCronoDesa(accCronoDesa, MesCronoDesa.OCTUBRE, this.getSesion());
				MesCronoDesa mesNov = MesCronoDesa.getMesCronoDesa(accCronoDesa, MesCronoDesa.NOVIEMBRE, this.getSesion());
				MesCronoDesa mesDic = MesCronoDesa.getMesCronoDesa(accCronoDesa, MesCronoDesa.DICIEMBRE, this.getSesion());

				cargarRegistroMesAEvaluar(datasetMesAEval, 1, accCronoDesa, MesCronoDesa.ENERO, "Enero", (mesEne != null) ? true : false);
				cargarRegistroMesAEvaluar(datasetMesAEval, 2, accCronoDesa, MesCronoDesa.FEBRERO, "Febrero", (mesFeb != null) ? true : false);
				cargarRegistroMesAEvaluar(datasetMesAEval, 2, accCronoDesa, MesCronoDesa.MARZO, "Marzo", (mesMar != null) ? true : false);
				cargarRegistroMesAEvaluar(datasetMesAEval, 2, accCronoDesa, MesCronoDesa.ABRIL, "Abril", (mesAbr != null) ? true : false);
				cargarRegistroMesAEvaluar(datasetMesAEval, 2, accCronoDesa, MesCronoDesa.MAYO, "Mayo", (mesMay != null) ? true : false);
				cargarRegistroMesAEvaluar(datasetMesAEval, 2, accCronoDesa, MesCronoDesa.JUNIO, "Junio", (mesJun != null) ? true : false);
				cargarRegistroMesAEvaluar(datasetMesAEval, 2, accCronoDesa, MesCronoDesa.JULIO, "Julio", (mesJul != null) ? true : false);
				cargarRegistroMesAEvaluar(datasetMesAEval, 2, accCronoDesa, MesCronoDesa.AGOSTO, "Agosto", (mesAgo != null) ? true : false);
				cargarRegistroMesAEvaluar(datasetMesAEval, 2, accCronoDesa, MesCronoDesa.SEPTIEMBRE, "Septiembre", (mesSet != null) ? true : false);
				cargarRegistroMesAEvaluar(datasetMesAEval, 2, accCronoDesa, MesCronoDesa.OCTUBRE, "Octubre", (mesOct != null) ? true : false);
				cargarRegistroMesAEvaluar(datasetMesAEval, 2, accCronoDesa, MesCronoDesa.NOVIEMBRE, "Noviembre", (mesNov != null) ? true : false);
				cargarRegistroMesAEvaluar(datasetMesAEval, 2, accCronoDesa, MesCronoDesa.DICIEMBRE, "Diciembre", (mesDic != null) ? true : false);

				cargarSegmentacion(datasetSegmentacion, accCronoDesa);

			}

		}

		writeCliente(datasetCronogramaDesa);
		writeCliente(datasetAcciones);
		writeCliente(datasetEstados);
		writeCliente(datasetMesAEval);
		writeCliente(datasetSegmentacion);

	}

	private void cargarSegmentacion(IDataSet datasetSegmentacion, AccCronoDesa accCronoDesa) throws BaseException {
		// Cargar las Empresas

		int oidSegmentacion = 0;

		Iterator iterEmpresas = EstrucNivEmpresa.getEmpresasActivas(this.getSesion()).iterator();
		while (iterEmpresas.hasNext()) {
			EstrucNivEmpresa estrucNivEmpresa = (EstrucNivEmpresa) iterEmpresas.next();

			datasetSegmentacion.append();
			datasetSegmentacion.fieldValue("oid_segmentacion", ++oidSegmentacion);
			datasetSegmentacion.fieldValue("oid_accion_cro", accCronoDesa.getOIDInteger());
			if (estrucNivEmpresa.getValor_clasif_empresa() != null)
				datasetSegmentacion.fieldValue("descripcion", estrucNivEmpresa.getValor_clasif_empresa().getDescripcion());
			else
				datasetSegmentacion.fieldValue("descripcion", "");
			datasetSegmentacion.fieldValue("habilitado", false);
			datasetSegmentacion.fieldValue("secu", "EMP_" + estrucNivEmpresa.getOIDInteger().toString());
			datasetSegmentacion.fieldValue("secu_padre", "BASE");
			if (estrucNivEmpresa.getValor_clasif_empresa() != null)
				datasetSegmentacion.fieldValue("oid_val_clasif_emp", estrucNivEmpresa.getValor_clasif_empresa().getOIDInteger());
			else
				datasetSegmentacion.fieldValue("oid_val_clasif_emp", "");
			datasetSegmentacion.fieldValue("oid_val_clasif_sec", "");
			datasetSegmentacion.fieldValue("oid_val_clasif_pue", "");
			datasetSegmentacion.fieldValue("orden", "");
			datasetSegmentacion.fieldValue("oid_categ_posible", "");

			datasetSegmentacion.fieldValue("cant_anios_puesto", "");
			datasetSegmentacion.fieldValue("cant_meses_puesto", "");
			datasetSegmentacion.fieldValue("oid_rankear_cab", "");
			datasetSegmentacion.fieldValue("ptos_min_eval", "");
			datasetSegmentacion.fieldValue("ptos_min_calif_gen", "");
			datasetSegmentacion.fieldValue("cant_min_juegos_a", "");
			datasetSegmentacion.fieldValue("cant_anios_hc", "");
			datasetSegmentacion.fieldValue("cant_meses_hc", "");
			
			datasetSegmentacion.fieldValue("ult_meses_eval_pot", "");
			datasetSegmentacion.fieldValue("eval_pend_sin_eval", "");
			datasetSegmentacion.fieldValue("eval_pend_sin_jue", "");
			datasetSegmentacion.fieldValue("eval_pend_sin_irl", "");
			datasetSegmentacion.fieldValue("ult_meses_irl" , "");
			datasetSegmentacion.fieldValue("eval_pend_sin_pot" , "");
			
			
			

			// Traer los sectores
			Iterator iterSectores = estrucNivEmpresa.getSectores().iterator();
			while (iterSectores.hasNext()) {
				EstrucNivSector estrucNivSector = (EstrucNivSector) iterSectores.next();
				datasetSegmentacion.append();
				datasetSegmentacion.fieldValue("oid_segmentacion", ++oidSegmentacion);
				datasetSegmentacion.fieldValue("oid_accion_cro", accCronoDesa.getOIDInteger());
				if (estrucNivSector.getValor_clasif_sector() != null)
					datasetSegmentacion.fieldValue("descripcion", "     " + estrucNivSector.getValor_clasif_sector().getDescripcion());
				else
					datasetSegmentacion.fieldValue("descripcion", "");
				datasetSegmentacion.fieldValue("habilitado", false);
				datasetSegmentacion.fieldValue("secu", "SEC_" + estrucNivSector.getOIDInteger().toString());
				datasetSegmentacion.fieldValue("secu_padre", "EMP_" + estrucNivEmpresa.getOIDInteger().toString());
				if (estrucNivEmpresa.getValor_clasif_empresa() != null)
					datasetSegmentacion.fieldValue("oid_val_clasif_emp", estrucNivEmpresa.getValor_clasif_empresa().getOIDInteger());
				else
					datasetSegmentacion.fieldValue("oid_val_clasif_emp", "");
				if (estrucNivSector.getValor_clasif_sector() != null)
					datasetSegmentacion.fieldValue("oid_val_clasif_sec", estrucNivSector.getValor_clasif_sector().getOIDInteger());
				else
					datasetSegmentacion.fieldValue("oid_val_clasif_sec", "");
				datasetSegmentacion.fieldValue("oid_val_clasif_pue", "");
				datasetSegmentacion.fieldValue("orden", "");
				datasetSegmentacion.fieldValue("oid_categ_posible", "");

				datasetSegmentacion.fieldValue("cant_anios_puesto", "");
				datasetSegmentacion.fieldValue("cant_meses_puesto", "");
				datasetSegmentacion.fieldValue("oid_rankear_cab", "");
				datasetSegmentacion.fieldValue("ptos_min_eval", "");
				datasetSegmentacion.fieldValue("ptos_min_calif_gen", "");
				datasetSegmentacion.fieldValue("cant_min_juegos_a", "");
				datasetSegmentacion.fieldValue("cant_anios_hc", "");
				datasetSegmentacion.fieldValue("cant_meses_hc", "");
				
				datasetSegmentacion.fieldValue("ult_meses_eval_pot", "");
				datasetSegmentacion.fieldValue("eval_pend_sin_eval", "");
				datasetSegmentacion.fieldValue("eval_pend_sin_jue", "");
				datasetSegmentacion.fieldValue("eval_pend_sin_irl", "");
				datasetSegmentacion.fieldValue("ult_meses_irl" , "");
				datasetSegmentacion.fieldValue("eval_pend_sin_pot" , "");
				

				HashTableDatos buscarJerDesa = new HashTableDatos();
				Iterator iterJerarDesa = JerarquiaDesa.getJerarquiasDesa(accCronoDesa, this.getSesion()).iterator();
				while (iterJerarDesa.hasNext()) {
					JerarquiaDesa jerarquiaDesa = (JerarquiaDesa) iterJerarDesa.next();
					String clave = 
						jerarquiaDesa.getVal_clasif_puesto().getOID()+"_"+
						jerarquiaDesa.getVal_clasif_sector().getOID()+"_"+
						jerarquiaDesa.getVal_clasif_empresa().getOID();
					buscarJerDesa.put(clave, jerarquiaDesa);
				}

				// Traer los puestos
				Iterator iterPuestos = estrucNivSector.getPuestos().iterator();
				while (iterPuestos.hasNext()) {
					EstrucNivPuesto estrucNivPuesto = (EstrucNivPuesto) iterPuestos.next();

					datasetSegmentacion.append();
					datasetSegmentacion.fieldValue("oid_segmentacion", ++oidSegmentacion);
					datasetSegmentacion.fieldValue("oid_accion_cro", accCronoDesa.getOIDInteger());
					if (estrucNivPuesto.getValor_clasif_puesto() != null)
						datasetSegmentacion.fieldValue("descripcion", "          " + estrucNivPuesto.getValor_clasif_puesto().getDescripcion());
					else
						datasetSegmentacion.fieldValue("descripcion", "");

					boolean habilitado = false;
					Integer oidCategPosible = null;
					Integer cantAniosReq = null;
					Integer cantMesesReq = null;
					Integer oidRankear = null;
					Money puntajeMin = null;
					Money puntajeMinCalifGen = null;
					Integer cantMinJuegosA = null;
					Integer cantAniosHC = null;
					Integer cantMesesHC = null;
					Integer ultMesEvalPot = null; 
					Integer ultMesIRL = null;
					Boolean pendEvalSiFaltaEvalDesemp = null;
					Boolean pendEvalSiFaltaJuegos = null;
					Boolean pendEvalSiFaltaIRL = null;
					Boolean pendEvalSiFaltaPot = null;

					if ((estrucNivEmpresa.getValor_clasif_empresa() != null) && (estrucNivSector.getValor_clasif_sector() != null) && (estrucNivPuesto.getValor_clasif_puesto() != null)) {

						
						String clave = 
							estrucNivPuesto.getValor_clasif_puesto().getOID()+"_"+
							estrucNivSector.getValor_clasif_sector().getOID()+"_"+
							estrucNivEmpresa.getValor_clasif_empresa().getOID();
						
						JerarquiaDesa jerarquia = (JerarquiaDesa) buscarJerDesa.get(clave);
						
						/*JerarquiaDesa jerarquia = JerarquiaDesa.getJerarquiaDesa(
								accCronoDesa, 
								estrucNivEmpresa.getValor_clasif_empresa(), 
								estrucNivSector.getValor_clasif_sector(), 
								estrucNivPuesto.getValor_clasif_puesto(), 
								this.getSesion());*/

						if (jerarquia != null) {
							habilitado = jerarquia.isActivo();
							if (jerarquia.getRankearCab() != null)
								oidRankear = jerarquia.getRankearCab().getOIDInteger();
							if (jerarquia.getPuntosMinEval() != null)
								puntajeMin = jerarquia.getPuntosMinEval();
							if (jerarquia.getPuntosMinCalifGen() != null)
								puntajeMinCalifGen = jerarquia.getPuntosMinCalifGen();
							
							if (jerarquia.getUltMesesEvalPot()!=null)
								ultMesEvalPot = jerarquia.getUltMesesEvalPot();
							
							if (jerarquia.getUltMesesIRL()!=null)
								ultMesIRL = jerarquia.getUltMesesIRL();							
							
							if (jerarquia.isPendEvalSiFaltaEvalDesemp()!=null)
								pendEvalSiFaltaEvalDesemp = jerarquia.isPendEvalSiFaltaEvalDesemp(); 
							
							if (jerarquia.isPendEvalSiFaltaJuegos()!=null)
								pendEvalSiFaltaJuegos = jerarquia.isPendEvalSiFaltaJuegos();
							
							if (jerarquia.isEvalPendSinPot()!=null)
								pendEvalSiFaltaPot = jerarquia.isEvalPendSinPot();							
							
							if (jerarquia.isEvalPendSinIRL()!=null)
								pendEvalSiFaltaIRL = jerarquia.isEvalPendSinIRL();
							
							if (jerarquia.getCategPosible() != null)
								oidCategPosible = jerarquia.getCategPosible().getOIDInteger();
							
							cantAniosReq = jerarquia.getCantAniosPuesto();
							cantMesesReq = jerarquia.getCantMesesPuesto();
							cantMinJuegosA = jerarquia.getCantMinJuegosA();
							cantAniosHC = jerarquia.getCantAniosHC();
							cantMesesHC = jerarquia.getCantMesesHC();
						}

					}

					datasetSegmentacion.fieldValue("habilitado", habilitado);
					datasetSegmentacion.fieldValue("secu", "PUE_" + estrucNivPuesto.getOIDInteger().toString());
					datasetSegmentacion.fieldValue("secu_padre", "SEC_" + estrucNivSector.getOIDInteger().toString());
					if (estrucNivEmpresa.getValor_clasif_empresa() != null)
						datasetSegmentacion.fieldValue("oid_val_clasif_emp", estrucNivEmpresa.getValor_clasif_empresa().getOIDInteger());
					else
						datasetSegmentacion.fieldValue("oid_val_clasif_emp", "");
					if (estrucNivSector.getValor_clasif_sector() != null)
						datasetSegmentacion.fieldValue("oid_val_clasif_sec", estrucNivSector.getValor_clasif_sector().getOIDInteger());
					else
						datasetSegmentacion.fieldValue("oid_val_clasif_sec", "");
					if (estrucNivPuesto.getValor_clasif_puesto() != null)
						datasetSegmentacion.fieldValue("oid_val_clasif_pue", estrucNivPuesto.getValor_clasif_puesto().getOIDInteger());
					else
						datasetSegmentacion.fieldValue("oid_val_clasif_pue", "");
					datasetSegmentacion.fieldValue("orden", "");
					datasetSegmentacion.fieldValue("oid_categ_posible", oidCategPosible);
					if (cantAniosReq != null) {
						if (cantAniosReq.intValue() != 0)
							datasetSegmentacion.fieldValue("cant_anios_puesto", cantAniosReq);
						else
							datasetSegmentacion.fieldValue("cant_anios_puesto", "");
					} else
						datasetSegmentacion.fieldValue("cant_anios_puesto", "");
					if (cantMesesReq != null) {
						if (cantMesesReq.intValue() != 0) {
							datasetSegmentacion.fieldValue("cant_meses_puesto", cantMesesReq);

						} else {
							datasetSegmentacion.fieldValue("cant_meses_puesto", "");

						}
					} else
						datasetSegmentacion.fieldValue("cant_meses_puesto", "");
					datasetSegmentacion.fieldValue("oid_rankear_cab", oidRankear);
					datasetSegmentacion.fieldValue("ptos_min_eval", puntajeMin);
					datasetSegmentacion.fieldValue("ptos_min_calif_gen", puntajeMinCalifGen);
					if (cantMinJuegosA != null) {
						if (cantMinJuegosA.intValue() != 0)
							datasetSegmentacion.fieldValue("cant_min_juegos_a", cantMinJuegosA);
						else
							datasetSegmentacion.fieldValue("cant_min_juegos_a", "");
					} else
						datasetSegmentacion.fieldValue("cant_min_juegos_a", "");

					if (cantAniosHC != null) {
						if (cantAniosHC.intValue() != 0)
							datasetSegmentacion.fieldValue("cant_anios_hc", cantAniosHC);
						else
							datasetSegmentacion.fieldValue("cant_anios_hc", "");
					} else
						datasetSegmentacion.fieldValue("cant_anios_hc", "");
					if (cantMesesHC != null) {
						if (cantMesesHC.intValue() != 0)
							datasetSegmentacion.fieldValue("cant_meses_hc", cantMesesHC);
						else
							datasetSegmentacion.fieldValue("cant_meses_hc", "");
					} else
						datasetSegmentacion.fieldValue("cant_meses_hc", "");
					
					if ((ultMesEvalPot!=null) && (ultMesEvalPot.intValue()!=0))
						datasetSegmentacion.fieldValue("ult_meses_eval_pot", ultMesEvalPot);
					else
						datasetSegmentacion.fieldValue("ult_meses_eval_pot", "");
					datasetSegmentacion.fieldValue("eval_pend_sin_eval", pendEvalSiFaltaEvalDesemp);
					datasetSegmentacion.fieldValue("eval_pend_sin_jue", pendEvalSiFaltaJuegos);
					datasetSegmentacion.fieldValue("eval_pend_sin_irl", pendEvalSiFaltaIRL);
					
					if ((ultMesIRL!=null) && (ultMesIRL.intValue()!=0))
						datasetSegmentacion.fieldValue("ult_meses_irl", ultMesIRL);
					else
						datasetSegmentacion.fieldValue("ult_meses_irl", "");
					
					datasetSegmentacion.fieldValue("eval_pend_sin_pot" , pendEvalSiFaltaPot);
					

				}

			}

		}
	}

	private IDataSet getDataSetCronogramaDesa() {
		IDataSet dataset = new TDataSet();
		dataset.create("TCronogramaDesa");
		dataset.fieldDef(new Field("oid_crono_desa", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 50));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
		dataset.fieldDef(new Field("observaciones", Field.STRING, 4000));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private void cargarRegistroCronogramaDesa(IDataSet dataset, CronogramaDesa cronograma) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_crono_desa", cronograma.getOIDInteger());
		dataset.fieldValue("codigo", cronograma.getCodigo());
		dataset.fieldValue("descripcion", cronograma.getDescripcion());
		dataset.fieldValue("observaciones", cronograma.getObservaciones());
		dataset.fieldValue("activo", cronograma.isActivo());
	}

	private IDataSet getDataSetAccCronoDesa() {
		IDataSet dataset = new TDataSet();
		dataset.create("TAccCronoDesa");
		dataset.fieldDef(new Field("oid_accion_cro", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_cronograma", Field.INTEGER, 0));
		dataset.fieldDef(new Field("orden", Field.INTEGER, 0));
		dataset.fieldDef(new Field("accion", Field.STRING, 500));
		dataset.fieldDef(new Field("revision", Field.STRING, 500));
		dataset.fieldDef(new Field("Observaciones", Field.STRING, 1000));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("oid_categ_posible", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_rankear", Field.INTEGER, 0));
		dataset.fieldDef(new Field("sector", Field.STRING, 1000));
		dataset.fieldDef(new Field("parametros", Field.STRING, 1000));
		return dataset;
	}

	private IDataSet getDataSetSegmentacion() {
		IDataSet dataset = new TDataSet();
		dataset.create("TSegmentacion");
		dataset.fieldDef(new Field("oid_segmentacion", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_accion_cro", Field.INTEGER, 0));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
		dataset.fieldDef(new Field("habilitado", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("secu", Field.STRING, 100));
		dataset.fieldDef(new Field("secu_padre", Field.STRING, 100));
		dataset.fieldDef(new Field("oid_val_clasif_emp", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_val_clasif_sec", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_val_clasif_pue", Field.INTEGER, 0));
		dataset.fieldDef(new Field("orden", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_categ_posible", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cant_anios_puesto", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cant_meses_puesto", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_rankear_cab", Field.INTEGER, 0));
		dataset.fieldDef(new Field("ptos_min_eval", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("ptos_min_calif_gen", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("cant_min_juegos_a", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cant_anios_hc", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cant_meses_hc", Field.INTEGER, 0));
		dataset.fieldDef(new Field("ult_meses_eval_pot", Field.INTEGER, 0));
		dataset.fieldDef(new Field("eval_pend_sin_eval", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("eval_pend_sin_jue", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("eval_pend_sin_irl", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("ult_meses_irl", Field.INTEGER, 0));
		dataset.fieldDef(new Field("eval_pend_sin_pot", Field.BOOLEAN, 0));
		return dataset;
	}

	private IDataSet getDataSetEstados() {
		IDataSet dataset = new TDataSet();
		dataset.create("TEstados");
		dataset.fieldDef(new Field("oid_estado_acc_cro", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_accion_cro", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_val_clasif_est", Field.INTEGER, 0));
		dataset.fieldDef(new Field("desc_val_clasif_est", Field.STRING, 100));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private IDataSet getDataSetMesesAEvaluar() {
		IDataSet dataset = new TDataSet();
		dataset.create("TMesesAEvaluar");
		dataset.fieldDef(new Field("oid_mes_a_eval", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_accion_cro", Field.INTEGER, 0));
		dataset.fieldDef(new Field("mes", Field.STRING, 5));
		dataset.fieldDef(new Field("desc_mes", Field.STRING, 100));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private void cargarRegistroAccCronoDesa(IDataSet dataset, AccCronoDesa aAccCronoDesa) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_accion_cro", aAccCronoDesa.getOIDInteger());
		dataset.fieldValue("oid_cronograma", aAccCronoDesa.getCronograma().getOIDInteger());
		dataset.fieldValue("orden", aAccCronoDesa.getOrden());
		dataset.fieldValue("accion", aAccCronoDesa.getAccion());
		dataset.fieldValue("revision", aAccCronoDesa.getRevision());
		dataset.fieldValue("Observaciones", aAccCronoDesa.getObservaciones());
		dataset.fieldValue("activo", aAccCronoDesa.isActivo());
		if (aAccCronoDesa.getCategoriaPosible() != null)
			dataset.fieldValue("oid_categ_posible", aAccCronoDesa.getCategoriaPosible().getOIDInteger());
		else
			dataset.fieldValue("oid_categ_posible", "");
		if (aAccCronoDesa.getRankear() != null)
			dataset.fieldValue("oid_rankear", aAccCronoDesa.getRankear().getOIDInteger());
		else
			dataset.fieldValue("oid_rankear", "");
		dataset.fieldValue("sector", aAccCronoDesa.getSector());
		dataset.fieldValue("parametros", aAccCronoDesa.getParametros());

	}

	private void cargarRegistroEstado(IDataSet dsEstado, int secu, AccCronoDesa accCronoDesa, ValorClasificadorEntidad valor, boolean activo) throws BaseException {
		dsEstado.append();
		dsEstado.fieldValue("oid_estado_acc_cro", secu);
		dsEstado.fieldValue("oid_accion_cro", accCronoDesa.getOIDInteger());
		dsEstado.fieldValue("oid_val_clasif_est", valor.getOIDInteger());
		dsEstado.fieldValue("desc_val_clasif_est", valor.getDescripcion());
		dsEstado.fieldValue("activo", activo);
	}

	private void cargarRegistroMesAEvaluar(IDataSet dsMesAEvaluar, int secu, AccCronoDesa accCronoDesa, String mes, String descMes, boolean activo) throws BaseException {

		dsMesAEvaluar.append();
		dsMesAEvaluar.fieldValue("oid_mes_a_eval", secu);
		dsMesAEvaluar.fieldValue("oid_accion_cro", accCronoDesa.getOIDInteger());
		dsMesAEvaluar.fieldValue("mes", mes);
		dsMesAEvaluar.fieldValue("desc_mes", descMes);
		dsMesAEvaluar.fieldValue("activo", activo);
	}

}
