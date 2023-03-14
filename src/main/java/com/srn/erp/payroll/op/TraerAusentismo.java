package com.srn.erp.payroll.op;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.Ausentismo.bm.GrupoRRHHDetalle;
import com.srn.erp.payroll.bm.PayConsultaAusentismo;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionParameterNotFound;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerAusentismo extends Operation {

	public TraerAusentismo() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		IDataSet dsTInput = mapaDatos.getDataSet("TInput");
		if (dsTInput.getCount() == 0) {
			throw new ExceptionValidation(null, "Seleccione una Empresa y un dia o un rango de dias");
		}
		dsTInput.first();
		if (dsTInput.getDate("fec_desde") == null && dsTInput.getDate("fec_hasta") == null && dsTInput.getBoolean("hoy") == false) {
			throw new ExceptionValidation(null, "Seleccione un dia o un rango de dias");
		}
		if ("".equals(dsTInput.getString("nombre"))) {
			throw new ExceptionValidation(null, "Seleccione una Empresa");
		}
		List<Date> fechas = new ArrayList<Date>();

		if (dsTInput.getBoolean("hoy")) {
			fechas.add(new Date());
		} else {
			Date fechaDesde = dsTInput.getDate("fec_desde");
			Date fechaHasta = dsTInput.getDate("fec_hasta");
			GregorianCalendar workingDate = new GregorianCalendar();
			int diferencia = 0;
			if (fechaDesde != null && fechaHasta != null) {
				diferencia = diferenciaEnDias(fechaHasta, fechaDesde);
				if (diferencia > 18) {
					throw new ExceptionValidation(null, "Seleccione un rango de fechas no mayor a 17 dias");
				}
				workingDate.setTime(fechaDesde);
				fechas = calcularDias(workingDate, diferencia, true);
			} else if (fechaDesde != null) {
				diferencia = 15;
				workingDate.setTime(fechaDesde);
				fechas = calcularDias(workingDate, diferencia, true);
			} else if (fechaHasta != null) {
				diferencia = 15;
				workingDate.setTime(fechaHasta);
				fechas = calcularDias(workingDate, diferencia, false);
			}
		}
		if (mapaDatos.containsKey("estructura_dataset_fechas")) {
			IDataSet datasetFechas = getDataSetFechas();
			cargarRegistroFechas(datasetFechas, fechas);
			writeCliente(datasetFechas);
		} else if (mapaDatos.containsKey("datos_dataset_ausencias")) {
			IDataSet dsTSectores = mapaDatos.getDataSet("TSectores");
			IDataSet dsTTurnos = mapaDatos.getDataSet("TTurnos");
			IDataSet dsTAusencias = mapaDatos.getDataSet("TAusencias");
			List<PayConsultaAusentismo> ausentismos = new ArrayList<PayConsultaAusentismo>();
			Hashtable<String, Object> hashTable = crearHashTable(dsTInput, dsTSectores, dsTTurnos, dsTAusencias);
			ausentismos = PayConsultaAusentismo.findByFiltros(hashTable, getSesion());
			IDataSet datasetConsulta = getDataSetAusentismo(fechas);
			cargarRegistroAusentismo(datasetConsulta, ausentismos, fechas);
			writeCliente(datasetConsulta);
		}
	}

	private Hashtable<String, Object> crearHashTable(IDataSet dsTInput, IDataSet dsTSectores, IDataSet dsTTurnos, IDataSet dsTAusencias) throws ExceptionParameterNotFound, BaseException {
		Hashtable<String, Object> hashTable = new Hashtable<String, Object>();

		if (dsTInput.getBoolean("hoy")) {
			hashTable.put("fec_desde", new Date());
			hashTable.put("fec_hasta", new Date());
		}else{
			if (dsTInput.getDate("fec_desde") != null && dsTInput.getDate("fec_hasta") != null) {
				hashTable.put("fec_desde", dsTInput.getDate("fec_desde"));
				hashTable.put("fec_hasta", dsTInput.getDate("fec_hasta"));
			}else if (dsTInput.getDate("fec_desde") != null) {
				Date fechaDesde = (Date) dsTInput.getDate("fec_desde");
				GregorianCalendar fechaHastaCalendar = new GregorianCalendar();
				fechaHastaCalendar.setTime((Date) dsTInput.getDate("fec_desde"));
				fechaHastaCalendar.add(Calendar.DAY_OF_MONTH, +15);
				Date fechaHasta = fechaHastaCalendar.getTime();
				hashTable.put("fec_desde", fechaDesde);
				hashTable.put("fec_hasta", fechaHasta);
			}else if (dsTInput.getDate("fec_hasta") != null) {
				Date fechaHasta = (Date) hashTable.get("fec_hasta");
				GregorianCalendar fechaDesdeCalendar = new GregorianCalendar();
				fechaDesdeCalendar.setTime((Date) hashTable.get("fec_hasta"));
				fechaDesdeCalendar.add(Calendar.DAY_OF_MONTH, -15);
				Date fechaDesde = fechaDesdeCalendar.getTime();
				hashTable.put("fec_desde", fechaDesde);
				hashTable.put("fec_hasta", fechaHasta);
			}
		}
		if (dsTInput.getString("empresa") != null) {
			hashTable.put("empresa", dsTInput.getString("empresa"));
		}

		dsTSectores.first();
		List<Integer> sectores = new ArrayList<Integer>();
		while (!dsTSectores.EOF()) {
			if (dsTSectores.getBoolean("seleccionado")) {
				sectores.add(dsTSectores.getInteger("codigo"));
			}
			dsTSectores.next();
		}
		hashTable.put("sectores", sectores);

		dsTTurnos.first();
		List<GrupoRRHHDetalle> turnos = new ArrayList<GrupoRRHHDetalle>();
		while (!dsTTurnos.EOF()) {
			if (dsTTurnos.getBoolean("seleccionado")) {
				turnos.addAll(GrupoRRHHDetalle.getSelectByOidGrupo(this.getSesion(), dsTTurnos.getInteger("oid_grupo")));
			}
			dsTTurnos.next();
		}
		if (turnos.isEmpty()) {
			dsTTurnos.first();
			while (!dsTTurnos.EOF()) {
				turnos.addAll(GrupoRRHHDetalle.getSelectByOidGrupo(this.getSesion(), dsTTurnos.getInteger("oid_grupo")));
				dsTTurnos.next();
			}
		}
		hashTable.put("turnos", turnos);

		dsTAusencias.first();
		List<Integer> tAusCodigos = new ArrayList<Integer>();
		List<Integer> tAusCotabs = new ArrayList<Integer>();
		while (!dsTAusencias.EOF()) {
			if (dsTAusencias.getBoolean("seleccionado")) {
				tAusCodigos.add(dsTAusencias.getInteger("codigo"));
				tAusCotabs.add(dsTAusencias.getInteger("cotab"));
			}
			dsTAusencias.next();
		}
		if (tAusCodigos.isEmpty()) {
			dsTAusencias.first();
			while (!dsTAusencias.EOF()) {
				tAusCodigos.add(dsTAusencias.getInteger("codigo"));
				tAusCotabs.add(dsTAusencias.getInteger("cotab"));
				dsTAusencias.next();
			}
		}

		hashTable.put("ausenciasCodigos", tAusCodigos);
		hashTable.put("ausenciasCotabs", tAusCotabs);

		return hashTable;
	}

	private IDataSet getDataSetFechas() {
		IDataSet dataset = new TDataSet();
		dataset.create("TColumnasFechas");
		dataset.fieldDef(new Field("fecha", Field.STRING, 15));
		return dataset;
	}

	@SuppressWarnings("rawtypes")
	private void cargarRegistroFechas(IDataSet dataset, List<Date> fechas) throws BaseException {
		Iterator itFechas = fechas.iterator();
		while (itFechas.hasNext()) {
			Date fecha = (Date) itFechas.next();
			
			dataset.append();
			dataset.fieldValue("fecha", Fecha.getddmmyyyy(fecha));
		}
	}

	private List<Date> calcularDias(GregorianCalendar fechaDesde, Integer diferencia, Boolean positivo) {
		List<Date> lista = new ArrayList<Date>();
		if (positivo) {
			lista.add(fechaDesde.getTime());
			for (int i = 0; i < diferencia; i++) {
				fechaDesde.add(Calendar.DAY_OF_MONTH, +1);
				Date myDate = fechaDesde.getTime();
				lista.add(myDate);
			}
		} else {
			lista.add(fechaDesde.getTime());
			for (int i = 0; i < diferencia; i++) {
				fechaDesde.add(Calendar.DAY_OF_MONTH, -1);
				Date myDate = fechaDesde.getTime();
				lista.add(myDate);
			}
			Collections.sort(lista);
		}
		return lista;
	}

	public static int diferenciaEnDias(Date fechaMayor, Date fechaMenor) {
		long diferenciaEn_ms = fechaMayor.getTime() - fechaMenor.getTime();
		long dias = diferenciaEn_ms / (1000 * 60 * 60 * 24);
		return (int) dias;
	}

	private IDataSet getDataSetAusentismo(List<Date> fechas) {
		IDataSet dataset = new TDataSet();
		dataset.create("TAusentismo");
		dataset.fieldDef(new Field("legajo", Field.STRING, 500));
		dataset.fieldDef(new Field("nombre", Field.STRING, 500));
		dataset.fieldDef(new Field("sector", Field.STRING, 500));
		dataset.fieldDef(new Field("puesto", Field.STRING, 500));
		dataset.fieldDef(new Field("fecha_inicio_lic", Field.STRING, 50));

		for (Date date : fechas) {
			dataset.fieldDef(new Field("col_" + Fecha.getddmmyyyy(date), Field.STRING, 4000));
		}
		return dataset;
	}

	private void cargarRegistroAusentismo(IDataSet dataset, List<PayConsultaAusentismo> ausentismos, List<Date> fechas) throws BaseException {
		if (!ausentismos.isEmpty()) {
			Boolean primero = true;
			List<PayConsultaAusentismo> ausentismosEmpleado = new ArrayList<PayConsultaAusentismo>();
			String legajoAnteriro = "0";
			int size = 0;
			for (PayConsultaAusentismo payConsultaAusentismo : ausentismos) {
				size++;
				if (primero) {
					primero = false;
					legajoAnteriro = payConsultaAusentismo.getLejago();
					ausentismosEmpleado.add(payConsultaAusentismo);
				} else if (legajoAnteriro.equals(payConsultaAusentismo.getLejago())) {
					ausentismosEmpleado.add(payConsultaAusentismo);
					if (ausentismos.size() == size) {
						cargarDelMismoLegajo(dataset, ausentismosEmpleado, fechas);
					}
				} else if (!legajoAnteriro.equals(payConsultaAusentismo.getLejago())) {
					cargarDelMismoLegajo(dataset, ausentismosEmpleado, fechas);
					legajoAnteriro = payConsultaAusentismo.getLejago();
					ausentismosEmpleado.clear();
					ausentismosEmpleado.add(payConsultaAusentismo);
				}
			}
		}
	}

	private void cargarDelMismoLegajo(IDataSet dataset, List<PayConsultaAusentismo> ausentismos, List<Date> fechas) throws BaseException {
		List<Date> fechasFaltadas = new ArrayList<Date>();
		Boolean primero = true;
		dataset.append();
		dataset.fieldValue("legajo", "");
		dataset.fieldValue("nombre", "");
		dataset.fieldValue("sector", "");
		dataset.fieldValue("puesto", "");
		dataset.fieldValue("fecha_inicio_lic", "");
		for (Date date : fechas) {
			dataset.fieldValue("col_" + Fecha.getddmmyyyy(date), "   ");
		}
		for (PayConsultaAusentismo payConsultaAusentismo : ausentismos) {
			if (primero) {
				dataset.fieldValue("legajo", payConsultaAusentismo.getLejago().trim());
				dataset.fieldValue("nombre", payConsultaAusentismo.getNombre().trim());
				dataset.fieldValue("sector", payConsultaAusentismo.getSector().trim());
				dataset.fieldValue("puesto", payConsultaAusentismo.getPuesto().trim());
				dataset.fieldValue("fecha_inicio_lic", payConsultaAusentismo.getFechaIniLicencia().toString());
				primero = false;
			}
			if (payConsultaAusentismo.gettAusencia().trim().equals("Ausente SIN aviso") || payConsultaAusentismo.gettAusencia().trim().equals("Ausente CON aviso")) {
				fechasFaltadas.add(payConsultaAusentismo.getFechaAusensia());
				if(faltoTresvecesSeguidas(fechasFaltadas)){
					String campoDeLaFecha = payConsultaAusentismo.gettAusencia().trim() + " - " + payConsultaAusentismo.getObservacion().trim();
					campoDeLaFecha = convertTextDelphiToHTML(campoDeLaFecha).replaceAll("\r", " ").replaceAll("\b", " ").replaceAll("\n", " ").replaceAll("\t", " ");
					campoDeLaFecha = "XXX - " + campoDeLaFecha;
					dataset.fieldValue("col_" + Fecha.getddmmyyyy(payConsultaAusentismo.getFechaAusensia()), campoDeLaFecha);
				}else{
					String campoDeLaFecha = payConsultaAusentismo.gettAusencia().trim() + " - " + payConsultaAusentismo.getObservacion().trim();
					campoDeLaFecha = convertTextDelphiToHTML(campoDeLaFecha).replaceAll("\r", " ").replaceAll("\b", " ").replaceAll("\n", " ").replaceAll("\t", " ");
					dataset.fieldValue("col_" + Fecha.getddmmyyyy(payConsultaAusentismo.getFechaAusensia()), campoDeLaFecha);
				}
			} else {
				String campoDeLaFecha = payConsultaAusentismo.gettAusencia().trim() + " - " + payConsultaAusentismo.getObservacion().trim();
				campoDeLaFecha = convertTextDelphiToHTML(campoDeLaFecha).replaceAll("\r", " ").replaceAll("\b", " ").replaceAll("\n", " ").replaceAll("\t", " ");
				dataset.fieldValue("col_" + Fecha.getddmmyyyy(payConsultaAusentismo.getFechaAusensia()), campoDeLaFecha);
			}
		}
	}

	private boolean faltoTresvecesSeguidas(List<Date> fechas){
		int i = fechas.size();
		if(i >= 3){
			Date ultimaFecha = fechas.get(i-1);
			GregorianCalendar calendar = new GregorianCalendar();
			calendar.setTime(ultimaFecha);
			calendar.add(Calendar.DAY_OF_MONTH, -1);
			if(calendar.getTime().equals(fechas.get(i-2))){
				calendar.add(Calendar.DAY_OF_MONTH, -1);
				if(calendar.getTime().equals(fechas.get(i-3))){
					return true;
				}
			}
		}
		return false;
	}
	
	  public static String convertTextDelphiToHTML(String texto) {
			if (texto!=null)
				return texto.replaceAll("¬c¬n", "").replaceAll("¬t", "").replaceAll("¬c","");
			else
				return "";
		}
	
}
