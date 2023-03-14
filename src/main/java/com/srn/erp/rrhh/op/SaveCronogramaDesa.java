package com.srn.erp.rrhh.op;

import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.rrhh.bm.AccCronoDesa;
import com.srn.erp.rrhh.bm.CronogramaDesa;
import com.srn.erp.rrhh.bm.EstadoAccCroDesa;
import com.srn.erp.rrhh.bm.JerarquiaDesa;
import com.srn.erp.rrhh.bm.MesCronoDesa;
import com.srn.erp.rrhh.bm.RankearCab;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveCronogramaDesa extends Operation {

	public SaveCronogramaDesa() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		IDataSet dataset = mapaDatos.getDataSet("TCronogramaDesa");
		procesarRegistros(dataset);
	}

	private void procesarRegistros(IDataSet dataset) throws BaseException {
		dataset.first();
		while (!dataset.EOF()) {
			CronogramaDesa cronogramadesa = CronogramaDesa.findByOid(dataset.getInteger("oid_crono_desa"), getSesion());
			cronogramadesa.setOID(dataset.getInteger("oid_crono_desa"));
			cronogramadesa.setCodigo(dataset.getString("codigo"));
			cronogramadesa.setDescripcion(dataset.getString("descripcion"));
			cronogramadesa.setObservaciones(dataset.getString("observaciones"));
			cronogramadesa.setActivo(dataset.getBoolean("activo"));

			IDataSet dsAcciones = dataset.getDataSet("TAccCronoDesa");
			dsAcciones.first();
			while (!dsAcciones.EOF()) {
				AccCronoDesa accCronoDesa = AccCronoDesa.findByOid(dsAcciones.getInteger("oid_accion_cro"), this.getSesion());
				accCronoDesa.setCronograma(cronogramadesa);
				accCronoDesa.setOrden(dsAcciones.getInteger("orden"));
				accCronoDesa.setAccion(dsAcciones.getString("accion"));
				accCronoDesa.setRevision(dsAcciones.getString("revision"));
				accCronoDesa.setObservaciones(dsAcciones.getString("Observaciones"));
				accCronoDesa.setActivo(dsAcciones.getBoolean("activo"));				
				accCronoDesa.setCategoriaPosible(ValorClasificadorEntidad.findByOidProxy(dsAcciones.getInteger("oid_categ_posible"), this.getSesion()));
				accCronoDesa.setRankear(RankearCab.findByOidProxy(dsAcciones.getInteger("oid_rankear"), this.getSesion()));
				accCronoDesa.setSector(dsAcciones.getString("sector"));
				accCronoDesa.setParametros(dsAcciones.getString("parametros"));
				

				cronogramadesa.addAccion(accCronoDesa);

				// Actualizar los Estados
				IDataSet dsEstados = dsAcciones.getDataSet("TEstados");
				dsEstados.first();
				while (!dsEstados.EOF()) {
					ValorClasificadorEntidad valClasifEst = ValorClasificadorEntidad.findByOidProxy(dsEstados.getInteger("oid_val_clasif_est"), this.getSesion());
					EstadoAccCroDesa estadoAccCroDesa = EstadoAccCroDesa.getEstadoAccCroDesa(accCronoDesa, valClasifEst, this.getSesion());
					if (estadoAccCroDesa != null) {
						estadoAccCroDesa.supportRefresh();
						estadoAccCroDesa.setActivo(dsEstados.getBoolean("activo"));
						accCronoDesa.addEstado(estadoAccCroDesa);
					} else {
						if (dsEstados.getBoolean("activo").booleanValue()) {
							EstadoAccCroDesa newEstadoAccCroDesa = (EstadoAccCroDesa) EstadoAccCroDesa.getNew(EstadoAccCroDesa.NICKNAME, this.getSesion());
							newEstadoAccCroDesa.setAccion(accCronoDesa);
							newEstadoAccCroDesa.setValor_clasif_estado(ValorClasificadorEntidad.findByOidProxy(dsEstados.getInteger("oid_val_clasif_est"), this.getSesion()));
							newEstadoAccCroDesa.setActivo(true);
							accCronoDesa.addEstado(newEstadoAccCroDesa);
						}
					}

					dsEstados.next();
				}
				
				// Segmentacion
				IDataSet dsSegmentacion = dsAcciones.getDataSet("TSegmentacion");
				dsSegmentacion.first();
				while (!dsSegmentacion.EOF()) {
					
					ValorClasificadorEntidad valClasifEntEmp = null;
					ValorClasificadorEntidad valClasifEntSec = null;
					ValorClasificadorEntidad valClasifEntPue = null;
					
					Integer oidValClasifEmp = dsSegmentacion.getInteger("oid_val_clasif_emp");
					Integer oidValClasifSec = dsSegmentacion.getInteger("oid_val_clasif_sec");
					Integer oidValClasifPue = dsSegmentacion.getInteger("oid_val_clasif_pue");
					
					if ((oidValClasifEmp!=null) && (oidValClasifEmp.intValue()>0)) 
						valClasifEntEmp = ValorClasificadorEntidad.findByOidProxy(oidValClasifEmp, this.getSesion());
					
					if ((oidValClasifSec!=null) && (oidValClasifSec.intValue()>0)) 
						valClasifEntSec = ValorClasificadorEntidad.findByOidProxy(oidValClasifSec, this.getSesion());
					
					if ((oidValClasifPue!=null) && (oidValClasifPue.intValue()>0)) 
						valClasifEntPue = ValorClasificadorEntidad.findByOidProxy(oidValClasifPue, this.getSesion());
					
					if ((valClasifEntEmp!=null) && (valClasifEntSec!=null) && (valClasifEntPue!=null)) {
						JerarquiaDesa jerarquiaDesa = JerarquiaDesa.getJerarquiaDesa(accCronoDesa,valClasifEntEmp,valClasifEntSec,valClasifEntPue,this.getSesion());
						if (jerarquiaDesa!=null) {
							jerarquiaDesa.supportRefresh();
							jerarquiaDesa.setActivo(dsSegmentacion.getBoolean("habilitado"));
							jerarquiaDesa.setOrden(dsSegmentacion.getInteger("orden"));
							jerarquiaDesa.setCategPosible(ValorClasificadorEntidad.findByOidProxy(dsSegmentacion.getInteger("oid_categ_posible"), this.getSesion()));
							jerarquiaDesa.setCantAniosPuesto(dsSegmentacion.getInteger("cant_anios_puesto"));
							jerarquiaDesa.setCantMesesPuesto(dsSegmentacion.getInteger("cant_meses_puesto"));
							jerarquiaDesa.setRankearCab(RankearCab.findByOidProxy(dsSegmentacion.getInteger("oid_rankear_cab"), this.getSesion()));
							jerarquiaDesa.setPuntosMinEval(dsSegmentacion.getMoney("ptos_min_eval"));
							jerarquiaDesa.setPuntosMinCalifGen(dsSegmentacion.getMoney("ptos_min_calif_gen"));
							jerarquiaDesa.setCantMinJuegosA(dsSegmentacion.getInteger("cant_min_juegos_a"));
							jerarquiaDesa.setCantAniosHC(dsSegmentacion.getInteger("cant_anios_hc"));
							jerarquiaDesa.setCantMesesHC(dsSegmentacion.getInteger("cant_meses_hc"));
							jerarquiaDesa.setUltMesesEvalPot(dsSegmentacion.getInteger("ult_meses_eval_pot"));
							jerarquiaDesa.setPendEvalSiFaltaEvalDesemp(dsSegmentacion.getBoolean("eval_pend_sin_eval"));
							jerarquiaDesa.setPendEvalSiFaltaJuegos(dsSegmentacion.getBoolean("eval_pend_sin_jue"));
							jerarquiaDesa.setEvalPendSinIRL(dsSegmentacion.getBoolean("eval_pend_sin_irl"));
							jerarquiaDesa.setUltMesesIRL(dsSegmentacion.getInteger("ult_meses_irl"));
							jerarquiaDesa.setEvalPendSinPot(dsSegmentacion.getBoolean("eval_pend_sin_pot"));
							
							
							accCronoDesa.addJerarquiaDesa(jerarquiaDesa);
						} else {
							JerarquiaDesa newJerarquiaDesa = (JerarquiaDesa) JerarquiaDesa.getNew(JerarquiaDesa.NICKNAME, this.getSesion());
							newJerarquiaDesa.setAccion(accCronoDesa);
							newJerarquiaDesa.setVal_clasif_empresa(valClasifEntEmp);
							newJerarquiaDesa.setVal_clasif_sector(valClasifEntSec);
							newJerarquiaDesa.setVal_clasif_puesto(valClasifEntPue);
							newJerarquiaDesa.setOrden(dsSegmentacion.getInteger("orden"));
							newJerarquiaDesa.setActivo(dsSegmentacion.getBoolean("habilitado"));
							newJerarquiaDesa.setCategPosible(ValorClasificadorEntidad.findByOidProxy(dsSegmentacion.getInteger("oid_categ_posible"), this.getSesion()));
							newJerarquiaDesa.setCantAniosPuesto(dsSegmentacion.getInteger("cant_anios_puesto"));
							newJerarquiaDesa.setCantMesesPuesto(dsSegmentacion.getInteger("cant_meses_puesto"));
							newJerarquiaDesa.setRankearCab(RankearCab.findByOidProxy(dsSegmentacion.getInteger("oid_rankear_cab"), this.getSesion()));
							newJerarquiaDesa.setPuntosMinEval(dsSegmentacion.getMoney("ptos_min_eval"));
							newJerarquiaDesa.setPuntosMinCalifGen(dsSegmentacion.getMoney("ptos_min_calif_gen"));
							newJerarquiaDesa.setCantMinJuegosA(dsSegmentacion.getInteger("cant_min_juegos_a"));
							newJerarquiaDesa.setCantAniosHC(dsSegmentacion.getInteger("cant_anios_hc"));
							newJerarquiaDesa.setCantMesesHC(dsSegmentacion.getInteger("cant_meses_hc"));
							newJerarquiaDesa.setUltMesesEvalPot(dsSegmentacion.getInteger("ult_meses_eval_pot"));
							newJerarquiaDesa.setPendEvalSiFaltaEvalDesemp(dsSegmentacion.getBoolean("eval_pend_sin_eval"));
							newJerarquiaDesa.setPendEvalSiFaltaJuegos(dsSegmentacion.getBoolean("eval_pend_sin_jue"));
							newJerarquiaDesa.setEvalPendSinIRL(dsSegmentacion.getBoolean("eval_pend_sin_irl"));
							newJerarquiaDesa.setUltMesesIRL(dsSegmentacion.getInteger("ult_meses_irl"));
							newJerarquiaDesa.setEvalPendSinPot(dsSegmentacion.getBoolean("eval_pend_sin_pot"));
							
							
							accCronoDesa.addJerarquiaDesa(newJerarquiaDesa);
						}
					}
					
					
					dsSegmentacion.next();
				}
				
				

				// Actualizar los Meses a Evaluar
				IDataSet dsMesesAEval = dsAcciones.getDataSet("TMesesAEvaluar");
				dsMesesAEval.first();
				while (!dsMesesAEval.EOF()) {

					// Determinar si se activa o no
					String mes = dsMesesAEval.getString("mes");
					boolean activo = dsMesesAEval.getBoolean("activo");

					MesCronoDesa mesCronoDesa = MesCronoDesa.getMesCronoDesa(accCronoDesa, mes, this.getSesion());
					if (mesCronoDesa != null) {
						mesCronoDesa.supportRefresh();
						mesCronoDesa.setActivo(activo);
						accCronoDesa.addMesAEvaluar(mesCronoDesa);
					} else {
						if (dsMesesAEval.getBoolean("activo")) {
							MesCronoDesa newMesCronoDesa = (MesCronoDesa) MesCronoDesa.getNew(MesCronoDesa.NICKNAME, this.getSesion());
							newMesCronoDesa.setAccion(accCronoDesa);
							newMesCronoDesa.setMes(mes);
							newMesCronoDesa.setActivo(true);
							accCronoDesa.addMesAEvaluar(newMesCronoDesa);
						}
					}

					dsMesesAEval.next();
				}

				dsAcciones.next();
			}

			addTransaccion(cronogramadesa);
			dataset.next();
		}
	}

}
