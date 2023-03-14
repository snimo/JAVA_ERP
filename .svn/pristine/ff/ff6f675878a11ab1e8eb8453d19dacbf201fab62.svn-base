package com.srn.erp.rrhh.op;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.cip.bm.LegajoRotaFecha;
import com.srn.erp.cip.bm.Rota;
import com.srn.erp.cip.bm.UtilCIP;
import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.rrhh.bm.FiltroLegCab;
import com.srn.erp.rrhh.bm.GrabarConsRotasCab;
import com.srn.erp.rrhh.bm.GrabarConsRotasDet;
import com.srn.erp.rrhh.bm.NovedadLegajo;
import com.srn.erp.rrhh.bm.SancionesLegajo;
import com.srn.erp.rrhh.bm.ServicioMedicoRRHH;
import com.srn.erp.sueldos.bm.Legajo;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerConsPlanifRotasDM extends Operation {

	HashTableDatos planifActual = new HashTableDatos();
	HashTableDatos planifAnterior = new HashTableDatos();
	HashTableDatos diasFechasNovedades = new HashTableDatos();
	private boolean obtenerNovedades = false;
	private boolean soloNovedadesPrimerDia = false;
	private String agrupadorNov = "";
	private int nroConsulta = 0;
	
	public TraerConsPlanifRotasDM() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		if (mapaDatos.containsKey("TRAER_CONS_GRABADA")) {
			traerConsultaGrabada(mapaDatos);
			return;
		} else if (mapaDatos.containsKey("OBTENER_NOVEDADES")) {
					traerConsultaNovedades(mapaDatos);
					obtenerNovedades = true;
					if (mapaDatos.containsKey("SOLO_NOV_PRIMER_DIA"))
						soloNovedadesPrimerDia = true;
				} else {
					
				}
		
		nroConsulta = this.getSesion().getNewOIDByKey("CONS_ROTAS_GEN");

		int cantLegSinNovSinSanc = 0;
		int cantLegConNovSinSanc = 0;
		int cantLegSinNovConSanc = 0;
		int cantLegConNovConSanc = 0;

		HashTableDatos controlesMedicos = new HashTableDatos();

		ClasificadorEntidad clasifEmpresa = TraerLeyendasRepEval.getClasificadorEmpresa(this.getSesion());
		ClasificadorEntidad clasifSector = TraerLeyendasRepEval.getClasificadorSector(this.getSesion());
		ClasificadorEntidad clasifPuesto = TraerLeyendasRepEval.getClasificadorPuesto(this.getSesion());

		boolean tieneNovedad = false;
		boolean tieneSancion = false;
		int dias = 0;

		Integer oidFiltro = null;
		java.util.Date fecDesde = null;
		java.util.Date fecHasta = null;
		Integer oidRota = null;
		Boolean excSiTieneNov = null;
		Boolean excSiTieneSan = null;
		FiltroLegCab filtro = null;
		String juegos = null;
		HashTableDatos legajosProcesados = new HashTableDatos();

		IDataSet dsInput = mapaDatos.getDataSet("TInput");
		dsInput.first();
		while (!dsInput.EOF()) {
			oidFiltro = dsInput.getInteger("oid_filtro");
			fecDesde = dsInput.getDate("fec_desde");
			fecHasta = dsInput.getDate("fec_hasta");
			oidRota = dsInput.getInteger("oid_rota");
			excSiTieneNov = dsInput.getBoolean("exc_si_tiene_nov");
			excSiTieneSan = dsInput.getBoolean("exc_si_tiene_sanc");
			dias = dsInput.getInteger("dias");

			juegos = dsInput.getString("juego");

			dsInput.next();
		}

		if (oidFiltro == null)
			throw new ExceptionValidation(null, "Debe seleccionar el filtro de legajos");

		if (fecDesde == null)
			throw new ExceptionValidation(null, "Debe seleccionar la fecha Desde");

		if (fecHasta == null)
			throw new ExceptionValidation(null, "Debe seleccionar la fecha Hasta");

		int difMes = Fecha.getDifEnMeses(fecDesde, fecHasta);

		if (difMes > 1) {
			throw new ExceptionValidation(null, "La diferencia entre la fecha desde y hasta no puede superar un mes");
		}

		if (dias <= 0)
			throw new ExceptionValidation(null, "Debe Ingresar el Horizonte de días");

		if (excSiTieneNov == null)
			excSiTieneNov = false;

		if (excSiTieneSan == null)
			excSiTieneSan = false;

		Rota rota = Rota.findByOidProxy(oidRota, this.getSesion());
		filtro = FiltroLegCab.findByOid(oidFiltro, this.getSesion());

		IDataSet ds = this.getDataSetConsPlanifRotas();
		IDataSet dsCantidades = getDataSetCantTotales();
		IDataSet dsDiasColumnas = getDataSetDiasColumnas();

		String agrupador = "Nro. (" + nroConsulta+") " +filtro.getDescripcion() + " - Fecha: " + Fecha.getddmmyyyy(fecDesde);

		if (rota != null)
			agrupador = agrupador + " - Rota " + rota.getDescripcion();

		if (excSiTieneNov)
			agrupador = agrupador + " - (Excluir si tiene novedad)";

		java.util.Date fecHorActual = UtilCIP.getFechaHoraActual(this.getSesion());

		agrupador = agrupador + " - Fec/Hora Reporte " + Fecha.getddmmyyyy(fecHorActual) + " " + Fecha.getFormatoHoraMinSeg(fecHorActual);
		

		cargarControlesMedicos(filtro, fecDesde, Fecha.getFechaMasDias(fecDesde, 7), controlesMedicos);

		Iterator iterLegRotFec = LegajoRotaFecha.getConsPlanifDistMesas(fecDesde, fecHasta, rota, filtro, juegos, this.getSesion()).iterator();
		while (iterLegRotFec.hasNext()) {
			LegajoRotaFecha legRotFec = (LegajoRotaFecha) iterLegRotFec.next();
			String juego = "";
			String categoria = "";
			String novedad = " ";
			String sancion = "";

			tieneNovedad = false;

			tieneSancion = false;

			if ((legRotFec.getLegajo() != null)) {

				legRotFec.getLegajo().supportRefresh();

				ValorClasificadorEntidad valClasifPuesto = legRotFec.getLegajo().getValorClasifEnt(clasifPuesto);

				if (valClasifPuesto != null)
					categoria = valClasifPuesto.getDescripcion();

				if (legRotFec.getLegajo().getGradoLegajo() != null)
					juego = legRotFec.getLegajo().getGradoLegajo().getDescripcion();

				if (excSiTieneSan.booleanValue()) {

					boolean tieneSancionExcluyente = false;
					Iterator iterSancLegAFec = legRotFec.getLegajo().getSancionesLegajosALaFecha(legRotFec.getFecha()).iterator();
					while (iterSancLegAFec.hasNext()) {
						SancionesLegajo sancionesLegajo = (SancionesLegajo) iterSancLegAFec.next();

						if ((sancionesLegajo.getMotivo_sancion() != null) && (sancionesLegajo.getMotivo_sancion().isExcluirEnPlanifRotas())) {
							tieneSancionExcluyente = true;
							tieneSancion = true;
						}

						if ((sancionesLegajo.getMotivo_sancion() != null) && (sancionesLegajo.getMotivo_falta() != null))
							sancion = sancion + sancionesLegajo.getMotivo_sancion().getDescripcion() + " - " + sancionesLegajo.getMotivo_falta().getDescripcion();
						else if (sancionesLegajo.getMotivo_sancion() != null)
							sancion = sancion + sancionesLegajo.getMotivo_sancion().getDescripcion();
						else if (sancionesLegajo.getMotivo_falta() != null)
							sancion = sancion + sancionesLegajo.getMotivo_falta().getDescripcion();

						else
							sancion = "";

					}

					if (tieneSancionExcluyente)
						continue;

				} else {
					List listaSanc = legRotFec.getLegajo().getSancionesLegajosALaFecha(legRotFec.getFecha());
					if (listaSanc.size() > 0) {
						Iterator iterSanc = listaSanc.iterator();
						while (iterSanc.hasNext()) {
							SancionesLegajo sancionLegajo = (SancionesLegajo) iterSanc.next();

							if ((sancionLegajo.getMotivo_sancion() != null) && (sancionLegajo.getMotivo_sancion().isExcluirEnPlanifRotas())) {
								tieneSancion = true;
							}

							if ((sancionLegajo.getMotivo_sancion() != null) && (sancionLegajo.getMotivo_falta() != null))
								sancion = sancion + sancionLegajo.getMotivo_sancion().getDescripcion() + " - " + sancionLegajo.getMotivo_falta().getDescripcion();
							else if (sancionLegajo.getMotivo_sancion() != null)
								sancion = sancion + sancionLegajo.getMotivo_sancion().getDescripcion();
							else if (sancionLegajo.getMotivo_falta() != null)
								sancion = sancion + sancionLegajo.getMotivo_falta().getDescripcion();
							else
								sancion = "";

						}
					}
				}

				if (rota == null) {
					novedad = legRotFec.getRota().getCodigo();
				}

				if (excSiTieneNov.booleanValue()) {

					if (legRotFec.getLegajo().getNovedadesLegajoFecha(legRotFec.getFecha()).size() > 0) {
						tieneNovedad = true;
						continue;
					}

				} else {
					List listaNov = legRotFec.getLegajo().getNovedadesLegajoFecha(legRotFec.getFecha());
					if (listaNov.size() > 0) {
						tieneNovedad = true;
						Iterator iterNov = listaNov.iterator();
						while (iterNov.hasNext()) {
							NovedadLegajo novLeg = (NovedadLegajo) iterNov.next();
							novedad = "Novedad";
						}
					}

				}

			}

			// Verificar que si tiene control medido debe figurar como novedad
			if (tieneControlMedico(controlesMedicos, legRotFec.getLegajo(), legRotFec.getFecha())) {
				tieneNovedad = true;
				novedad = "Novedad";

				if (excSiTieneNov.booleanValue())
					continue;

			}

			if ((tieneNovedad) && (tieneSancion))
				++cantLegConNovConSanc;
			else if ((!tieneNovedad) && (tieneSancion))
				++cantLegSinNovConSanc;
			else if ((tieneNovedad) && (!tieneSancion))
				++cantLegConNovSinSanc;
			else
				++cantLegSinNovSinSanc;

			ValorClasificadorEntidad valEmpresa = legRotFec.getLegajo().getValorClasifEnt(clasifEmpresa);
			ValorClasificadorEntidad valSector = legRotFec.getLegajo().getValorClasifEnt(clasifSector);

			String empresa = "";
			String sector = "";

			if (valEmpresa != null)
				empresa = valEmpresa.getDescripcion();

			if (valSector != null)
				sector = valSector.getDescripcion();

			String novDia1 = "";
			String novDia2 = "";
			String novDia3 = "";
			String novDia4 = "";
			String novDia5 = "";
			String novDia6 = "";
			String novDia7 = "";

			// Traer las Novedades de los próximos 7 dias
			java.util.Date fecDesdeNov = Fecha.getFechaMasDias(legRotFec.getFecha(), 1);
			java.util.Date fecHastaNov = Fecha.getFechaMasDias(legRotFec.getFecha(), 7);

			for (int i = 1; i <= 7; ++i) {
				java.util.Date fecProxDias = Fecha.getFechaMasDias(legRotFec.getFecha(), i);
				LegajoRotaFecha legRotFecProxDia = LegajoRotaFecha.getLegajoFechaRota(legRotFec.getLegajo(), fecProxDias, this.getSesion());

				if (i == 1) {
					if (legRotFecProxDia == null)
						novDia1 = "Sin Tramo";
					else if ((rota != null) && (legRotFecProxDia.getRota().getOID() != rota.getOID()))
						novDia1 = legRotFecProxDia.getRota().getCodigo();
					else if (rota == null)
						novDia1 = legRotFecProxDia.getRota().getCodigo();

					if (tieneControlMedico(controlesMedicos, legRotFec.getLegajo(), fecProxDias)) {
						tieneNovedad = true;
						novDia1 = "Novedad";
					}

				} else if (i == 2) {
					if (legRotFecProxDia == null)
						novDia2 = "Sin Tramo";
					else if ((rota != null) && (legRotFecProxDia.getRota().getOID() != rota.getOID()))
						novDia2 = legRotFecProxDia.getRota().getCodigo();
					else if (rota == null)
						novDia2 = legRotFecProxDia.getRota().getCodigo();
					if (tieneControlMedico(controlesMedicos, legRotFec.getLegajo(), fecProxDias)) {
						tieneNovedad = true;
						novDia2 = "Novedad";
					}

				} else if (i == 3) {
					if (legRotFecProxDia == null)
						novDia3 = "Sin Tramo";
					else if ((rota != null) && (legRotFecProxDia.getRota().getOID() != rota.getOID()))
						novDia3 = legRotFecProxDia.getRota().getCodigo();
					else if (rota == null)
						novDia3 = legRotFecProxDia.getRota().getCodigo();
					if (tieneControlMedico(controlesMedicos, legRotFec.getLegajo(), fecProxDias)) {
						tieneNovedad = true;
						novDia3 = "Novedad";
					}
				} else if (i == 4) {
					if (legRotFecProxDia == null)
						novDia4 = "Sin Tramo";
					else if ((rota != null) && (legRotFecProxDia.getRota().getOID() != rota.getOID()))
						novDia4 = legRotFecProxDia.getRota().getCodigo();
					else if (rota == null)
						novDia4 = legRotFecProxDia.getRota().getCodigo();
					if (tieneControlMedico(controlesMedicos, legRotFec.getLegajo(), fecProxDias)) {
						tieneNovedad = true;
						novDia4 = "Novedad";
					}
				} else if (i == 5) {
					if (legRotFecProxDia == null)
						novDia5 = "Sin Tramo";
					else if ((rota != null) && (legRotFecProxDia.getRota().getOID() != rota.getOID()))
						novDia5 = legRotFecProxDia.getRota().getCodigo();
					else if (rota == null)
						novDia5 = legRotFecProxDia.getRota().getCodigo();
					if (tieneControlMedico(controlesMedicos, legRotFec.getLegajo(), fecProxDias)) {
						tieneNovedad = true;
						novDia5 = "Novedad";
					}
				} else if (i == 6) {
					if (legRotFecProxDia == null)
						novDia6 = "Sin Tramo";
					else if ((rota != null) && (legRotFecProxDia.getRota().getOID() != rota.getOID()))
						novDia6 = legRotFecProxDia.getRota().getCodigo();
					else if (rota == null)
						novDia6 = legRotFecProxDia.getRota().getCodigo();
					if (tieneControlMedico(controlesMedicos, legRotFec.getLegajo(), fecProxDias)) {
						tieneNovedad = true;
						novDia6 = "Novedad";
					}
				} else if (i == 7) {
					if (legRotFecProxDia == null)
						novDia7 = "Sin Tramo";
					else if ((rota != null) && (legRotFecProxDia.getRota().getOID() != rota.getOID()))
						novDia7 = legRotFecProxDia.getRota().getCodigo();
					else if (rota == null)
						novDia7 = legRotFecProxDia.getRota().getCodigo();
					if (tieneControlMedico(controlesMedicos, legRotFec.getLegajo(), fecProxDias)) {
						tieneNovedad = true;
						novDia7 = "Novedad";
					}
				}

			}

			if (legRotFec.getLegajo() != null) {
				Iterator iterNovProxSemana = NovedadLegajo.getNovedadesLegajo(legRotFec.getLegajo(), fecDesdeNov, fecHastaNov, this.getSesion()).iterator();
				while (iterNovProxSemana.hasNext()) {

					NovedadLegajo novLegProxDia = (NovedadLegajo) iterNovProxSemana.next();

					if ((novLegProxDia.getFecha().equals(Fecha.getFechaMasDias(legRotFec.getFecha(), 1)))
							|| (tieneControlMedico(controlesMedicos, legRotFec.getLegajo(), Fecha.getFechaMasDias(legRotFec.getFecha(), 1))))
						novDia1 = "Novedad";
					if ((novLegProxDia.getFecha().equals(Fecha.getFechaMasDias(legRotFec.getFecha(), 2)))
							|| (tieneControlMedico(controlesMedicos, legRotFec.getLegajo(), Fecha.getFechaMasDias(legRotFec.getFecha(), 2))))
						novDia2 = "Novedad";
					if ((novLegProxDia.getFecha().equals(Fecha.getFechaMasDias(legRotFec.getFecha(), 3)))
							|| (tieneControlMedico(controlesMedicos, legRotFec.getLegajo(), Fecha.getFechaMasDias(legRotFec.getFecha(), 3))))
						novDia3 = "Novedad";
					if ((novLegProxDia.getFecha().equals(Fecha.getFechaMasDias(legRotFec.getFecha(), 4)))
							|| (tieneControlMedico(controlesMedicos, legRotFec.getLegajo(), Fecha.getFechaMasDias(legRotFec.getFecha(), 4))))
						novDia4 = "Novedad";
					if ((novLegProxDia.getFecha().equals(Fecha.getFechaMasDias(legRotFec.getFecha(), 5)))
							|| (tieneControlMedico(controlesMedicos, legRotFec.getLegajo(), Fecha.getFechaMasDias(legRotFec.getFecha(), 5))))
						novDia5 = "Novedad";
					if ((novLegProxDia.getFecha().equals(Fecha.getFechaMasDias(legRotFec.getFecha(), 6)))
							|| (tieneControlMedico(controlesMedicos, legRotFec.getLegajo(), Fecha.getFechaMasDias(legRotFec.getFecha(), 6))))
						novDia6 = "Novedad";
					if ((novLegProxDia.getFecha().equals(Fecha.getFechaMasDias(legRotFec.getFecha(), 7)))
							|| (tieneControlMedico(controlesMedicos, legRotFec.getLegajo(), Fecha.getFechaMasDias(legRotFec.getFecha(), 7))))
						novDia7 = "Novedad";

				}
			}

			legajosProcesados.put(legRotFec.getLegajo().getOIDInteger(), "");

			cargarConsPlanifRotas(ds, legRotFec.getLegajo().getOIDInteger(), legRotFec.getLegajo().getNro_legajo(), legRotFec.getLegajo().getApellidoyNombre(), oidRota, legRotFec.getRota()
					.getCodigo(), legRotFec.getFecha(), juego, categoria, novedad, sancion, empresa, sector, novDia1, novDia2, novDia3, novDia4, novDia5, novDia6, novDia7, agrupador , nroConsulta);
		}

		if (rota != null) {

			Iterator iterLegajos = Legajo.getLegConsPlanifRotasEntFechas(Fecha.getFechaDiaPosterior(fecDesde), Fecha.getFechaMasDias(fecDesde, 7), rota, filtro, juegos, this.getSesion()).iterator();

			while (iterLegajos.hasNext()) {
				Legajo legajo = (Legajo) iterLegajos.next();
				

				if (legajosProcesados.containsKey(legajo.getOIDInteger()))
					continue;

				String juego = "";
				String categoria = "";
				String sancion = "";

				tieneNovedad = false;

				if (legajo.getGradoLegajo() != null)
					juego = legajo.getGradoLegajo().getDescripcion();

				ValorClasificadorEntidad valClasifPuesto = legajo.getValorClasifEnt(clasifPuesto);

				if (valClasifPuesto != null)
					categoria = valClasifPuesto.getDescripcion();

				String novedad = " ";

				boolean tieneOtraRotaPrimerDia = false;
				LegajoRotaFecha legRotFecPrimerDia = LegajoRotaFecha.getLegajoFechaRota(legajo, fecDesde, this.getSesion());
				if (legRotFecPrimerDia == null) {
					novedad = "Sin Tramo";
					tieneNovedad = true;
				} else if (legRotFecPrimerDia.getRota().getOID() != rota.getOID()) {
					novedad = legRotFecPrimerDia.getRota().getCodigo();
					tieneOtraRotaPrimerDia = true;
				}

				List listaNov = legajo.getNovedadesLegajoFecha(fecDesde);
				if (listaNov.size() > 0) {
					tieneNovedad = true;
					Iterator iterNov = listaNov.iterator();
					while (iterNov.hasNext()) {
						NovedadLegajo novLeg = (NovedadLegajo) iterNov.next();
						novedad = "Novedad";
						tieneNovedad = true;
					}
				}

				if (tieneControlMedico(controlesMedicos, legajo, fecDesde)) {
					tieneNovedad = true;
					novedad = "Novedad";
				}

				if (excSiTieneNov)
					if ((tieneNovedad) || (tieneOtraRotaPrimerDia))
						continue;

				if (tieneNovedad)
					++cantLegConNovSinSanc;
				else {
					if (tieneOtraRotaPrimerDia)
						++cantLegConNovSinSanc;
					else
						++cantLegSinNovSinSanc;
				}

				ValorClasificadorEntidad valEmpresa = legajo.getValorClasifEnt(clasifEmpresa);
				ValorClasificadorEntidad valSector = legajo.getValorClasifEnt(clasifSector);

				String empresa = "";
				String sector = "";

				if (valEmpresa != null)
					empresa = valEmpresa.getDescripcion();

				if (valSector != null)
					sector = valSector.getDescripcion();

				String novDia1 = "";
				String novDia2 = "";
				String novDia3 = "";
				String novDia4 = "";
				String novDia5 = "";
				String novDia6 = "";
				String novDia7 = "";

				for (int i = 1; i <= 7; ++i) {

					java.util.Date fecProxDias = Fecha.getFechaMasDias(fecDesde, i);
					LegajoRotaFecha legRotFecProxDia = LegajoRotaFecha.getLegajoFechaRota(legajo, fecProxDias, this.getSesion());

					if (i == 1) {
						if (legRotFecProxDia == null)
							novDia1 = "Sin Tramo";
						else if ((rota != null) && (legRotFecProxDia.getRota().getOID() != rota.getOID()))
							novDia1 = legRotFecProxDia.getRota().getCodigo();
						else if (rota == null)
							novDia1 = legRotFecProxDia.getRota().getCodigo();

						if ((legRotFecProxDia!=null) && (tieneControlMedico(controlesMedicos, legRotFecProxDia.getLegajo(), fecProxDias))) {
							novDia1 = "Novedad";
						}
						if (!legajo.getNovedadesLegajoFecha(fecProxDias).isEmpty()) {
							novDia1 = "Novedad";
							
						}

					} else if (i == 2) {
						if (legRotFecProxDia == null)
							novDia2 = "Sin Tramo";
						else if ((rota != null) && (legRotFecProxDia.getRota().getOID() != rota.getOID()))
							novDia2 = legRotFecProxDia.getRota().getCodigo();
						else if (rota == null)
							novDia2 = legRotFecProxDia.getRota().getCodigo();
						if (((legRotFecProxDia!=null)) && (tieneControlMedico(controlesMedicos, legRotFecProxDia.getLegajo(), fecProxDias)))
							novDia2 = "Novedad";
						
						if (!legajo.getNovedadesLegajoFecha(fecProxDias).isEmpty())
							novDia2 = "Novedad";						
						
					} else if (i == 3) {
						if (legRotFecProxDia == null)
							novDia3 = "Sin Tramo";
						else if ((rota != null) && (legRotFecProxDia.getRota().getOID() != rota.getOID()))
							novDia3 = legRotFecProxDia.getRota().getCodigo();
						else if (rota == null)
							novDia3 = legRotFecProxDia.getRota().getCodigo();
						if (((legRotFecProxDia!=null)) && (tieneControlMedico(controlesMedicos, legRotFecProxDia.getLegajo(), fecProxDias))) 
							novDia3 = "Novedad";
						if (!legajo.getNovedadesLegajoFecha(fecProxDias).isEmpty())
								novDia3 = "Novedad";							
						
					} else if (i == 4) {
						if (legRotFecProxDia == null)
							novDia4 = "Sin Tramo";
						else if ((rota != null) && (legRotFecProxDia.getRota().getOID() != rota.getOID()))
							novDia4 = legRotFecProxDia.getRota().getCodigo();
						else if (rota == null)
							novDia4 = legRotFecProxDia.getRota().getCodigo();
						if ((legRotFecProxDia!=null) && (tieneControlMedico(controlesMedicos, legRotFecProxDia.getLegajo(), fecProxDias))) 
							novDia4 = "Novedad";
						if (!legajo.getNovedadesLegajoFecha(fecProxDias).isEmpty())
							 novDia4 = "Novedad";							
						
					} else if (i == 5) {
						if (legRotFecProxDia == null)
							novDia5 = "Sin Tramo";
						else if ((rota != null) && (legRotFecProxDia.getRota().getOID() != rota.getOID()))
							novDia5 = legRotFecProxDia.getRota().getCodigo();
						else if (rota == null)
							novDia5 = legRotFecProxDia.getRota().getCodigo();
						if ((legRotFecProxDia!=null)  && (tieneControlMedico(controlesMedicos, legRotFecProxDia.getLegajo(), fecProxDias))) 
							novDia5 = "Novedad";
						if (!legajo.getNovedadesLegajoFecha(fecProxDias).isEmpty())
							novDia5 = "Novedad";							
						
					} else if (i == 6) {
						if (legRotFecProxDia == null)
							novDia6 = "Sin Tramo";
						else if ((rota != null) && (legRotFecProxDia.getRota().getOID() != rota.getOID()))
							novDia6 = legRotFecProxDia.getRota().getCodigo();
						else if (rota == null)
							novDia6 = legRotFecProxDia.getRota().getCodigo();
						if ((legRotFecProxDia!=null) && (tieneControlMedico(controlesMedicos, legRotFecProxDia.getLegajo(), fecProxDias))) 
							novDia6 = "Novedad";
						if (!legajo.getNovedadesLegajoFecha(fecProxDias).isEmpty())
							novDia6 = "Novedad";							
						
					} else if (i == 7) {
						if (legRotFecProxDia == null)
							novDia7 = "Sin Tramo";
						else if ((rota != null) && (legRotFecProxDia.getRota().getOID() != rota.getOID()))
							novDia7 = legRotFecProxDia.getRota().getCodigo();
						else if (rota == null)
							novDia7 = legRotFecProxDia.getRota().getCodigo();
						if ((legRotFecProxDia!=null) && (tieneControlMedico(controlesMedicos, legRotFecProxDia.getLegajo(), fecProxDias))) 
							novDia7 = "Novedad";
						if (!legajo.getNovedadesLegajoFecha(fecProxDias).isEmpty())
							novDia7 = "Novedad";							
						
					}

				}

				cargarConsPlanifRotas(ds, legajo.getOIDInteger(), legajo.getNro_legajo(), legajo.getApellidoyNombre(), rota.getOIDInteger(), rota.getCodigo(), fecDesde, juego, categoria, novedad,
						sancion, empresa, sector, novDia1, novDia2, novDia3, novDia4, novDia5, novDia6, novDia7, agrupador , nroConsulta);

			}

		}

		cargarCantidades(dsCantidades, rota, cantLegSinNovSinSanc, cantLegConNovConSanc, cantLegSinNovConSanc, cantLegConNovSinSanc, Fecha.getFormatoFecHoraMin((UtilCIP.getFechaHoraActual(this
				.getSesion()))));

		cargarDiasColumnas(dsDiasColumnas, fecDesde);

		if (mapaDatos.containsKey("OBTENER_NOVEDADES")) {
			verificarSiHayNovedades(rota);
		} else {
				writeCliente(ds);
				writeCliente(dsCantidades);
				writeCliente(dsDiasColumnas);
		}

	}
	
	private void verificarSiHayNovedades(Rota rota) throws BaseException {
		
		
		HashTableDatos legajosProcesados = new HashTableDatos();
		IDataSet dsNov = getDataSetNovConsRota();
		int oidNovedad = 0;
		java.util.Date fecha1 = (java.util.Date) diasFechasNovedades.get(1);
		java.util.Date fecha2 = (java.util.Date) diasFechasNovedades.get(2);
		java.util.Date fecha3 = (java.util.Date) diasFechasNovedades.get(3);
		java.util.Date fecha4 = (java.util.Date) diasFechasNovedades.get(4);
		java.util.Date fecha5 = (java.util.Date) diasFechasNovedades.get(5);
		java.util.Date fecha6 = (java.util.Date) diasFechasNovedades.get(6);
		java.util.Date fecha7 = (java.util.Date) diasFechasNovedades.get(7);
		java.util.Date fecha8 = (java.util.Date) diasFechasNovedades.get(8);		
		
		// Paso 1: Recorrer los Legajos de la planificación anterior
		Iterator iterPlanifAntLeg  = 
			this.planifAnterior.keySet().iterator();
		while (iterPlanifAntLeg.hasNext()) {
			
			Integer oidLegajo = (Integer) iterPlanifAntLeg.next();
			
			legajosProcesados.put(oidLegajo, "");
			
			HashTableDatos rotasPlanifAnt = (HashTableDatos) this.planifAnterior.get(oidLegajo);
			
			String novAnt = (String)rotasPlanifAnt.get(fecha1);
			String nov1Ant = (String)rotasPlanifAnt.get(fecha2);
			String nov2Ant = (String)rotasPlanifAnt.get(fecha3);
			String nov3Ant = (String)rotasPlanifAnt.get(fecha4);
			String nov4Ant = (String)rotasPlanifAnt.get(fecha5);
			String nov5Ant = (String)rotasPlanifAnt.get(fecha6);
			String nov6Ant = (String)rotasPlanifAnt.get(fecha7);
			String nov7Ant = (String)rotasPlanifAnt.get(fecha8);
			
			String novNue = "";
			String nov1Nue = "";
			String nov2Nue = "";
			String nov3Nue = "";
			String nov4Nue = "";
			String nov5Nue = "";
			String nov6Nue = "";
			String nov7Nue = "";
			
			HashTableDatos rotasPlanifNue = (HashTableDatos)this.planifActual.get(oidLegajo);
			if (rotasPlanifNue!=null) {
				
				novNue = (String)rotasPlanifNue.get(fecha1);
				nov1Nue = (String)rotasPlanifNue.get(fecha2);
				nov2Nue = (String)rotasPlanifNue.get(fecha3);
				nov3Nue = (String)rotasPlanifNue.get(fecha4);
				nov4Nue = (String)rotasPlanifNue.get(fecha5);
				nov5Nue = (String)rotasPlanifNue.get(fecha6);
				nov6Nue = (String)rotasPlanifNue.get(fecha7);
				nov7Nue = (String)rotasPlanifNue.get(fecha8);
				
				if (!getValorRota(novAnt).equals(novNue)) 
					enviarNovedad(dsNov,++oidNovedad,oidLegajo,fecha1,novAnt,novNue,rota,fecha1,agrupadorNov);
				
				if (!getValorRota(nov1Ant).equals(nov1Nue)) 
					enviarNovedad(dsNov,++oidNovedad,oidLegajo,fecha2,nov1Ant,nov1Nue,rota,fecha1,agrupadorNov);				
				
				if (!getValorRota(nov2Ant).equals(nov2Nue)) 
					enviarNovedad(dsNov,++oidNovedad,oidLegajo,fecha3,nov2Ant,nov2Nue,rota,fecha1,agrupadorNov);				
				
				if (!getValorRota(nov3Ant).equals(nov3Nue)) 
					enviarNovedad(dsNov,++oidNovedad,oidLegajo,fecha4,nov3Ant,nov3Nue,rota,fecha1,agrupadorNov);				
				
				if (!getValorRota(nov4Ant).equals(nov4Nue)) 
					enviarNovedad(dsNov,++oidNovedad,oidLegajo,fecha5,nov4Ant,nov4Nue,rota,fecha1,agrupadorNov);				
				
				if (!getValorRota(nov5Ant).equals(nov5Nue)) 
					enviarNovedad(dsNov,++oidNovedad,oidLegajo,fecha6,nov5Ant,nov5Nue,rota,fecha1,agrupadorNov);				
				
				if (!getValorRota(nov6Ant).equals(nov6Nue)) 
					enviarNovedad(dsNov,++oidNovedad,oidLegajo,fecha7,nov6Ant,nov6Nue,rota,fecha1,agrupadorNov);				
				
				if (!getValorRota(nov7Ant).equals(nov7Nue)) 
					enviarNovedad(dsNov,++oidNovedad,oidLegajo,fecha8,nov7Ant,nov7Nue,rota,fecha1,agrupadorNov);				
				
				
			} else {
				// No se encuentra en la Planificación Actual
				
				novNue = "No figura en consulta";
				nov1Nue = "No figura en consulta";
				nov2Nue = "No figura en consulta";
				nov3Nue = "No figura en consulta";
				nov4Nue = "No figura en consulta";
				nov5Nue = "No figura en consulta";
				nov6Nue = "No figura en consulta";
				nov7Nue = "No figura en consulta";
				
				if (!getValorRota(novAnt).equals(novNue)) 
					enviarNovedad(dsNov,++oidNovedad,oidLegajo,fecha1,novAnt,novNue,rota,fecha1,agrupadorNov);
				
				if (!getValorRota(nov1Ant).equals(nov1Nue)) 
					enviarNovedad(dsNov,++oidNovedad,oidLegajo,fecha2,nov1Ant,nov1Nue,rota,fecha1,agrupadorNov);				
				
				if (!getValorRota(nov2Ant).equals(nov2Nue)) 
					enviarNovedad(dsNov,++oidNovedad,oidLegajo,fecha3,nov2Ant,nov2Nue,rota,fecha1,agrupadorNov);				
				
				if (!getValorRota(nov3Ant).equals(nov3Nue)) 
					enviarNovedad(dsNov,++oidNovedad,oidLegajo,fecha4,nov3Ant,nov3Nue,rota,fecha1,agrupadorNov);				
				
				if (!getValorRota(nov4Ant).equals(nov4Nue)) 
					enviarNovedad(dsNov,++oidNovedad,oidLegajo,fecha5,nov4Ant,nov4Nue,rota,fecha1,agrupadorNov);				
				
				if (!getValorRota(nov5Ant).equals(nov5Nue)) 
					enviarNovedad(dsNov,++oidNovedad,oidLegajo,fecha6,nov5Ant,nov5Nue,rota,fecha1,agrupadorNov);				
				
				if (!getValorRota(nov6Ant).equals(nov6Nue)) 
					enviarNovedad(dsNov,++oidNovedad,oidLegajo,fecha7,nov6Ant,nov6Nue,rota,fecha1,agrupadorNov);				
				
				if (!getValorRota(nov7Ant).equals(nov7Nue)) 
					enviarNovedad(dsNov,++oidNovedad,oidLegajo,fecha8,nov7Ant,nov7Nue,rota,fecha1,agrupadorNov);				
				
			}
			
			
		}
		
		Iterator iterLegPlanifActual = 
			this.planifActual.keySet().iterator();
		while (iterLegPlanifActual.hasNext()) {
			Integer oidLegajo = (Integer) iterLegPlanifActual.next();
			
			if (legajosProcesados.get(oidLegajo)!=null) continue;
			
			// Procesar Legajos que figuran en la nueva consulta y no figura en la planificación anterior
			String novNue = (String)planifActual.get(fecha1);
			String nov1Nue = (String)planifActual.get(fecha2);
			String nov2Nue = (String)planifActual.get(fecha3);
			String nov3Nue = (String)planifActual.get(fecha4);
			String nov4Nue = (String)planifActual.get(fecha5);
			String nov5Nue = (String)planifActual.get(fecha6);
			String nov6Nue = (String)planifActual.get(fecha7);
			String nov7Nue = (String)planifActual.get(fecha8);			
			
			enviarNovedad(dsNov,++oidNovedad,oidLegajo,fecha1,"No figura en consulta",novNue,rota,fecha1,agrupadorNov);
			enviarNovedad(dsNov,++oidNovedad,oidLegajo,fecha2,"No figura en consulta",nov1Nue,rota,fecha1,agrupadorNov);
			enviarNovedad(dsNov,++oidNovedad,oidLegajo,fecha3,"No figura en consulta",nov2Nue,rota,fecha1,agrupadorNov);
			enviarNovedad(dsNov,++oidNovedad,oidLegajo,fecha4,"No figura en consulta",nov3Nue,rota,fecha1,agrupadorNov);
			enviarNovedad(dsNov,++oidNovedad,oidLegajo,fecha5,"No figura en consulta",nov4Nue,rota,fecha1,agrupadorNov);
			enviarNovedad(dsNov,++oidNovedad,oidLegajo,fecha6,"No figura en consulta",nov5Nue,rota,fecha1,agrupadorNov);
			enviarNovedad(dsNov,++oidNovedad,oidLegajo,fecha7,"No figura en consulta",nov6Nue,rota,fecha1,agrupadorNov);
			enviarNovedad(dsNov,++oidNovedad,oidLegajo,fecha8,"No figura en consulta",nov7Nue,rota,fecha1,agrupadorNov);
			
			
		}
		
		
		
		writeCliente(dsNov);
		
		//this.planifAnterior;
	}
	
	private String getValorRota(String valor) throws BaseException {
		if (valor==null)
			return "";
		else
			return valor;
	}
	
	private void enviarNovedad(IDataSet dsNov,int oidNovedad,Integer oidLegajo,java.util.Date fecha,String anterior,String nuevo,Rota rota,java.util.Date fecPrimerDia , String agrupador) throws BaseException {

		ClasificadorEntidad clasifEmpresa = TraerLeyendasRepEval.getClasificadorEmpresa(this.getSesion());
		ClasificadorEntidad clasifSector = TraerLeyendasRepEval.getClasificadorSector(this.getSesion());
		ClasificadorEntidad clasifPuesto = TraerLeyendasRepEval.getClasificadorPuesto(this.getSesion());
		
		Legajo legajo = Legajo.findByOid(oidLegajo, this.getSesion());
		ValorClasificadorEntidad valEmpresa = legajo.getValorClasifEnt(clasifEmpresa);
		ValorClasificadorEntidad valSector = legajo.getValorClasifEnt(clasifSector);
		ValorClasificadorEntidad valClasifPuesto = legajo.getValorClasifEnt(clasifPuesto);
		String empresa = "";
		String sector = "";
		String categoria = "";
		String juegos = "";
		if (valEmpresa != null)
			empresa = valEmpresa.getDescripcion();
		if (valSector != null)
			sector = valSector.getDescripcion();	
		if (valClasifPuesto != null)
			categoria = valClasifPuesto.getDescripcion();
		if (legajo.getGradoLegajo() != null)
			juegos = legajo.getGradoLegajo().getDescripcion();			
		cargarNovConsRota(
				dsNov, 
				oidNovedad, 
				oidLegajo, 
				legajo.getNro_legajo(), 
				legajo.getApellidoyNombre(), empresa, sector, categoria, juegos, fecha, anterior, nuevo , rota , fecPrimerDia , agrupador);
		
		
	}

	private void cargarDiasColumnas(IDataSet ds, java.util.Date fecha) throws BaseException {
		int dia = 0;
		int mes = 0;

		dia = Fecha.getDia(fecha);
		mes = Fecha.getMes(fecha);

		String labelHoy = dia + "/" + mes + getDiaSemana(fecha);

		dia = Fecha.getDia(Fecha.getFechaMasDias(fecha, 1));
		mes = Fecha.getMes(Fecha.getFechaMasDias(fecha, 1));
		String label1 = dia + "/" + mes + getDiaSemana(Fecha.getFechaMasDias(fecha, 1));

		dia = Fecha.getDia(Fecha.getFechaMasDias(fecha, 2));
		mes = Fecha.getMes(Fecha.getFechaMasDias(fecha, 2));
		String label2 = dia + "/" + mes + getDiaSemana(Fecha.getFechaMasDias(fecha, 2));

		dia = Fecha.getDia(Fecha.getFechaMasDias(fecha, 3));
		mes = Fecha.getMes(Fecha.getFechaMasDias(fecha, 3));
		String label3 = dia + "/" + mes + getDiaSemana(Fecha.getFechaMasDias(fecha, 3));

		dia = Fecha.getDia(Fecha.getFechaMasDias(fecha, 4));
		mes = Fecha.getMes(Fecha.getFechaMasDias(fecha, 4));
		String label4 = dia + "/" + mes + getDiaSemana(Fecha.getFechaMasDias(fecha, 4));

		dia = Fecha.getDia(Fecha.getFechaMasDias(fecha, 5));
		mes = Fecha.getMes(Fecha.getFechaMasDias(fecha, 5));
		String label5 = dia + "/" + mes + getDiaSemana(Fecha.getFechaMasDias(fecha, 5));

		dia = Fecha.getDia(Fecha.getFechaMasDias(fecha, 6));
		mes = Fecha.getMes(Fecha.getFechaMasDias(fecha, 6));
		String label6 = dia + "/" + mes + getDiaSemana(Fecha.getFechaMasDias(fecha, 6));

		dia = Fecha.getDia(Fecha.getFechaMasDias(fecha, 7));
		mes = Fecha.getMes(Fecha.getFechaMasDias(fecha, 7));
		String label7 = dia + "/" + mes + getDiaSemana(Fecha.getFechaMasDias(fecha, 7));

		cargarDias(ds, 0, labelHoy, label1, label2, label3, label4, label5, label6, label7);

	}

	private IDataSet getDataSetConsPlanifRotas() {
		IDataSet dataset = new TDataSet();
		dataset.create("TConsPlanif");
		dataset.fieldDef(new Field("oid_legajo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nro_legajo", Field.STRING, 50));
		dataset.fieldDef(new Field("ape_y_nom", Field.STRING, 255));
		dataset.fieldDef(new Field("oid_rota", Field.INTEGER, 0));
		dataset.fieldDef(new Field("rota", Field.STRING, 50));
		dataset.fieldDef(new Field("fecha", Field.DATE, 0));
		dataset.fieldDef(new Field("juegos", Field.STRING, 100));
		dataset.fieldDef(new Field("categoria", Field.STRING, 150));
		dataset.fieldDef(new Field("novedad", Field.STRING, 500));
		dataset.fieldDef(new Field("sancion", Field.STRING, 500));
		dataset.fieldDef(new Field("empresa", Field.STRING, 100));
		dataset.fieldDef(new Field("sector", Field.STRING, 100));
		dataset.fieldDef(new Field("nov_dia_1", Field.STRING, 20));
		dataset.fieldDef(new Field("nov_dia_2", Field.STRING, 20));
		dataset.fieldDef(new Field("nov_dia_3", Field.STRING, 20));
		dataset.fieldDef(new Field("nov_dia_4", Field.STRING, 20));
		dataset.fieldDef(new Field("nov_dia_5", Field.STRING, 20));
		dataset.fieldDef(new Field("nov_dia_6", Field.STRING, 20));
		dataset.fieldDef(new Field("nov_dia_7", Field.STRING, 20));
		dataset.fieldDef(new Field("agrupador", Field.STRING, 500));

		dataset.fieldDef(new Field("viene_novedad", Field.INTEGER, 0));
		dataset.fieldDef(new Field("viene_nov_dia_1", Field.INTEGER, 0));
		dataset.fieldDef(new Field("viene_nov_dia_2", Field.INTEGER, 0));
		dataset.fieldDef(new Field("viene_nov_dia_3", Field.INTEGER, 0));
		dataset.fieldDef(new Field("viene_nov_dia_4", Field.INTEGER, 0));
		dataset.fieldDef(new Field("viene_nov_dia_5", Field.INTEGER, 0));
		dataset.fieldDef(new Field("viene_nov_dia_6", Field.INTEGER, 0));
		dataset.fieldDef(new Field("viene_nov_dia_7", Field.INTEGER, 0));

		dataset.fieldDef(new Field("empleados_a_venir", Field.STRING, 100));
		dataset.fieldDef(new Field("nro_consulta", Field.INTEGER, 0));

		return dataset;
	}

	private IDataSet getDataSetCantTotales() {
		IDataSet dataset = new TDataSet();
		dataset.create("TCantidadesTotales");
		dataset.fieldDef(new Field("cant_leg_sinnov_sinsanc", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cant_leg_connov_consanc", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cant_leg_sinnov_consanc", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cant_leg_connov_sinsanc", Field.INTEGER, 0));
		dataset.fieldDef(new Field("fecha_hora", Field.STRING, 50));
		dataset.fieldDef(new Field("cant_leg_connov", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cant_leg_sinnov", Field.INTEGER, 0));
		return dataset;
	}

	private IDataSet getDataSetDiasColumnas() {
		IDataSet dataset = new TDataSet();
		dataset.create("TDiasColumnas");
		dataset.fieldDef(new Field("nro", Field.INTEGER, 0));
		dataset.fieldDef(new Field("dia", Field.STRING, 50));
		dataset.fieldDef(new Field("label1", Field.STRING, 50));
		dataset.fieldDef(new Field("label2", Field.STRING, 50));
		dataset.fieldDef(new Field("label3", Field.STRING, 50));
		dataset.fieldDef(new Field("label4", Field.STRING, 50));
		dataset.fieldDef(new Field("label5", Field.STRING, 50));
		dataset.fieldDef(new Field("label6", Field.STRING, 50));
		dataset.fieldDef(new Field("label7", Field.STRING, 50));
		return dataset;
	}

	private void cargarDias(IDataSet ds, Integer nroOrden, String dia, String label1, String label2, String label3, String label4, String label5, String label6, String label7) throws BaseException {
		ds.append();
		ds.fieldValue("nro", nroOrden);
		ds.fieldValue("dia", dia);
		ds.fieldValue("label1", label1);
		ds.fieldValue("label2", label2);
		ds.fieldValue("label3", label3);
		ds.fieldValue("label4", label4);
		ds.fieldValue("label5", label5);
		ds.fieldValue("label6", label6);
		ds.fieldValue("label7", label7);

	}

	private void cargarCantidades(IDataSet ds, Rota rota, Integer cantLegSinNovSinSanc, Integer cantLegConNovConSanc, Integer cantLegSinNovConSanc, Integer cantLegConNovSinSanc, String fechaHora)
			throws BaseException {

		ds.append();
		if (rota != null) {
			ds.fieldValue("cant_leg_sinnov_sinsanc", cantLegSinNovSinSanc);
			ds.fieldValue("cant_leg_connov_consanc", cantLegConNovConSanc);
			ds.fieldValue("cant_leg_sinnov_consanc", cantLegSinNovConSanc);
			ds.fieldValue("cant_leg_connov_sinsanc", cantLegConNovSinSanc);
		} else {
			ds.fieldValue("cant_leg_sinnov_sinsanc", "");
			ds.fieldValue("cant_leg_connov_consanc", "");
			ds.fieldValue("cant_leg_sinnov_consanc", "");
			ds.fieldValue("cant_leg_connov_sinsanc", "");
		}
		ds.fieldValue("fecha_hora", fechaHora);
		if (rota != null) {
			ds.fieldValue("cant_leg_connov", cantLegConNovSinSanc + cantLegConNovConSanc);
			ds.fieldValue("cant_leg_sinnov", cantLegSinNovSinSanc + cantLegSinNovConSanc);
		} else {
			ds.fieldValue("cant_leg_connov", "");
			ds.fieldValue("cant_leg_sinnov", "");
		}

	}

	private void cargarConsPlanifRotas(IDataSet ds, Integer oidLegajo, String nroLegajo, String apeynom, Integer oidRota, String rota, java.util.Date fecha, String juegos, String categoria,
			String novedad, String sancion, String empresa, String sector, String novDia1, String novDia2, String novDia3, String novDia4, String novDia5, String novDia6, String novDia7,
			String agrupador,Integer nroConsulta) throws BaseException {
		
		
		if (obtenerNovedades) {
			
			HashTableDatos rotas = new HashTableDatos();
			planifActual.put(oidLegajo, rotas);
			
			java.util.Date fecha1 = (java.util.Date) diasFechasNovedades.get(1);
			java.util.Date fecha2 = (java.util.Date) diasFechasNovedades.get(2);
			java.util.Date fecha3 = (java.util.Date) diasFechasNovedades.get(3);
			java.util.Date fecha4 = (java.util.Date) diasFechasNovedades.get(4);
			java.util.Date fecha5 = (java.util.Date) diasFechasNovedades.get(5);
			java.util.Date fecha6 = (java.util.Date) diasFechasNovedades.get(6);
			java.util.Date fecha7 = (java.util.Date) diasFechasNovedades.get(7);
			java.util.Date fecha8 = (java.util.Date) diasFechasNovedades.get(8);
			
			if (novedad!=null)
				rotas.put(fecha1, novedad);
			else
				rotas.put(fecha1, "");
			
			if (novDia1!=null)
				rotas.put(fecha2, novDia1);
			else
				rotas.put(fecha2, "");
			
			if (novDia2!=null)
				rotas.put(fecha3, novDia2);
			else
				rotas.put(fecha3, "");
			
			if (novDia3!=null)
				rotas.put(fecha4, novDia3);
			else
				rotas.put(fecha4, "");			
			
			if (novDia4!=null)
				rotas.put(fecha5, novDia4);
			else
				rotas.put(fecha5, "");			
			
			if (novDia5!=null)
				rotas.put(fecha6, novDia5);
			else
				rotas.put(fecha6, "");			
			
			if (novDia6!=null)
				rotas.put(fecha7, novDia6);
			else
				rotas.put(fecha7, "");			
			
			if (novDia7!=null)
				rotas.put(fecha8, novDia7);
			else
				rotas.put(fecha8, "");			
			
			
			
			
			return;
			
		}

		ds.append();
		ds.fieldValue("oid_legajo", oidLegajo);
		ds.fieldValue("nro_legajo", nroLegajo);
		ds.fieldValue("ape_y_nom", apeynom);
		ds.fieldValue("oid_rota", oidRota);
		ds.fieldValue("rota", rota);
		ds.fieldValue("fecha", fecha);
		ds.fieldValue("juegos", juegos);
		ds.fieldValue("categoria", categoria);
		ds.fieldValue("novedad", novedad);
		ds.fieldValue("sancion", sancion);
		ds.fieldValue("empresa", empresa);
		ds.fieldValue("sector", sector);
		ds.fieldValue("nov_dia_1", novDia1);
		ds.fieldValue("nov_dia_2", novDia2);
		ds.fieldValue("nov_dia_3", novDia3);
		ds.fieldValue("nov_dia_4", novDia4);
		ds.fieldValue("nov_dia_5", novDia5);
		ds.fieldValue("nov_dia_6", novDia6);
		ds.fieldValue("nov_dia_7", novDia7);
		ds.fieldValue("agrupador", agrupador);
		// ds.fieldValue("agrupador", "");

		if ((novedad != null) && (novedad.trim().length() > 0))
			ds.fieldValue("viene_novedad", 0);
		else
			ds.fieldValue("viene_novedad", 1);
		if ((novDia1 != null) && (novDia1.trim().length() > 0))
			ds.fieldValue("viene_nov_dia_1", 0);
		else
			ds.fieldValue("viene_nov_dia_1", 1);
		if ((novDia2 != null) && (novDia2.trim().length() > 0))
			ds.fieldValue("viene_nov_dia_2", 0);
		else
			ds.fieldValue("viene_nov_dia_2", 1);
		if ((novDia3 != null) && (novDia3.trim().length() > 0))
			ds.fieldValue("viene_nov_dia_3", 0);
		else
			ds.fieldValue("viene_nov_dia_3", 1);
		if ((novDia4 != null) && (novDia4.trim().length() > 0))
			ds.fieldValue("viene_nov_dia_4", 0);
		else
			ds.fieldValue("viene_nov_dia_4", 1);
		if ((novDia5 != null) && (novDia5.trim().length() > 0))
			ds.fieldValue("viene_nov_dia_5", 0);
		else
			ds.fieldValue("viene_nov_dia_5", 1);
		if ((novDia6 != null) && (novDia6.trim().length() > 0))
			ds.fieldValue("viene_nov_dia_6", 0);
		else
			ds.fieldValue("viene_nov_dia_6", 1);
		if ((novDia7 != null) && (novDia7.trim().length() > 0))
			ds.fieldValue("viene_nov_dia_7", 0);
		else
			ds.fieldValue("viene_nov_dia_7", 1);

		ds.fieldValue("empleados_a_venir", "");
		ds.fieldValue("nro_consulta" , nroConsulta);

	}

	public static String getDiaSemana(java.util.Date fecha) throws BaseException {
		if (fecha == null)
			return "";
		int dia = Fecha.getDiaSemana(fecha);
		if (dia == 1)
			return "Do";
		else if (dia == 2)
			return "Lu";
		else if (dia == 3)
			return "Ma";
		else if (dia == 4)
			return "Mi";
		else if (dia == 5)
			return "Ju";
		else if (dia == 6)
			return "Vi";
		else if (dia == 7)
			return "Sa";
		else
			return "";
	}

	private void cargarControlesMedicos(FiltroLegCab filtro, java.util.Date fecDesde, java.util.Date fecHasta, HashTableDatos controlesMedicos) throws BaseException {

		Iterator iterControlesMedicos = ServicioMedicoRRHH.getServMedByFiltroFecDesdeFecHasta(filtro, fecDesde, fecHasta, this.getSesion()).iterator();
		while (iterControlesMedicos.hasNext()) {
			ServicioMedicoRRHH servMedico = (ServicioMedicoRRHH) iterControlesMedicos.next();
			String clave = servMedico.getLegajo().getOIDInteger() + "_" + Fecha.getddmmyyyy(servMedico.getFecControl());
			controlesMedicos.put(clave, "");
		}

	}

	private boolean tieneControlMedico(HashTableDatos controlesMedicos, Legajo legajo, java.util.Date fecha) throws BaseException {

		String tieneControl = (String) controlesMedicos.get(legajo.getOIDInteger() + "_" + Fecha.getddmmyyyy(fecha));

		if (tieneControl != null)
			return true;
		else
			return false;

	}

	private void traerConsultaNovedades(MapDatos mapaDatos) throws BaseException {
		
		
		agrupadorNov = mapaDatos.getString("agrupador");
		
		java.util.Date fecha = null;
		IDataSet dsInput = mapaDatos.getDataSet("TInput");
		dsInput.first();
		while (!dsInput.EOF()) {
			fecha = dsInput.getDate("fec_desde");
			dsInput.next();
		}
		
		int i = 1;
		fecha = Fecha.getFechaDiaAnterior(fecha);
		for (i = 1; i <= 8; ++i) {

			fecha = Fecha.getFechaDiaPosterior(fecha);

			diasFechasNovedades.put(new Integer(i), fecha);

		}
		
		IDataSet dsConsPlanif = mapaDatos.getDataSet("TEnviar");
		dsConsPlanif.first();
		while (!dsConsPlanif.EOF()) {
			
			Legajo legajo = Legajo.findByOidProxy(dsConsPlanif.getInteger("oid_legajo"), this.getSesion());
			
			HashTableDatos rotas = new HashTableDatos();
			planifAnterior.put(legajo.getOIDInteger(), rotas);
			
			java.util.Date fecha1 = (java.util.Date) diasFechasNovedades.get(1);
			java.util.Date fecha2 = (java.util.Date) diasFechasNovedades.get(2);
			java.util.Date fecha3 = (java.util.Date) diasFechasNovedades.get(3);
			java.util.Date fecha4 = (java.util.Date) diasFechasNovedades.get(4);
			java.util.Date fecha5 = (java.util.Date) diasFechasNovedades.get(5);
			java.util.Date fecha6 = (java.util.Date) diasFechasNovedades.get(6);
			java.util.Date fecha7 = (java.util.Date) diasFechasNovedades.get(7);
			java.util.Date fecha8 = (java.util.Date) diasFechasNovedades.get(8);
			
			if (dsConsPlanif.getString("novedad")!=null)
				rotas.put(fecha1, dsConsPlanif.getString("novedad"));
			else
				rotas.put(fecha1, "");
			
			if (dsConsPlanif.getString("nov_dia_1")!=null)
				rotas.put(fecha2, dsConsPlanif.getString("nov_dia_1"));
			else
				rotas.put(fecha2, "");			
			
			if (dsConsPlanif.getString("nov_dia_2")!=null)
				rotas.put(fecha3, dsConsPlanif.getString("nov_dia_2"));
			else
				rotas.put(fecha3, "");			
			
			if (dsConsPlanif.getString("nov_dia_3")!=null)
				rotas.put(fecha4, dsConsPlanif.getString("nov_dia_3"));
			else
				rotas.put(fecha4, "");			
			
			if (dsConsPlanif.getString("nov_dia_4")!=null)
				rotas.put(fecha5, dsConsPlanif.getString("nov_dia_4"));
			else
				rotas.put(fecha5, "");			
			
			if (dsConsPlanif.getString("nov_dia_5")!=null)
				rotas.put(fecha6, dsConsPlanif.getString("nov_dia_5"));
			else
				rotas.put(fecha6, "");			
			
			if (dsConsPlanif.getString("nov_dia_6")!=null)
				rotas.put(fecha7, dsConsPlanif.getString("nov_dia_6"));
			else
				rotas.put(fecha7, "");			
			
			if (dsConsPlanif.getString("nov_dia_7")!=null)
				rotas.put(fecha8, dsConsPlanif.getString("nov_dia_7"));
			else
				rotas.put(fecha8, "");			
			
			
			
			dsConsPlanif.next();
		}
		
	}
	
	private void traerConsultaGrabada(MapDatos mapaDatos) throws BaseException {

		IDataSet dsDetCons = getDataSetConsPlanifRotas();
		IDataSet dsInput = getDataSetInput();
		IDataSet dsDiasColumnas = getDataSetDiasColumnas();

		
		
		GrabarConsRotasCab grabarConsRotasCab = GrabarConsRotasCab.findByOid(mapaDatos.getInteger("oid_grab_cons_rota"), this.getSesion());
		
		this.nroConsulta = grabarConsRotasCab.getNroConsulta();

		HashTableDatos diasFechas = new HashTableDatos();

		if (grabarConsRotasCab != null) {

			int i = 1;
			java.util.Date fecha = Fecha.getFechaDiaAnterior(grabarConsRotasCab.getFec_desde());
			for (i = 1; i <= 8; ++i) {

				fecha = Fecha.getFechaDiaPosterior(fecha);

				diasFechas.put(new Integer(i), fecha);

			}

			cargarDataSetInput(dsInput, grabarConsRotasCab.getFiltro().getOIDInteger(), grabarConsRotasCab.getFec_desde(), grabarConsRotasCab.getRota(), grabarConsRotasCab.getJuegos_sep_por_comas(),
					grabarConsRotasCab.getDias(), grabarConsRotasCab.isNo_most_si_franco());

			HashTableDatos legajos = new HashTableDatos();

			Iterator iterConsRotasDet = GrabarConsRotasDet.getConsRotasDet(grabarConsRotasCab, this.getSesion()).iterator();
			while (iterConsRotasDet.hasNext()) {
				GrabarConsRotasDet grabarConsRotasDet = (GrabarConsRotasDet) iterConsRotasDet.next();

				HashTableDatos datosFechas = (HashTableDatos) legajos.get(grabarConsRotasDet.getLegajo().getOIDInteger());
				if (datosFechas == null) {
					datosFechas = new HashTableDatos();
					legajos.put(grabarConsRotasDet.getLegajo().getOIDInteger(), datosFechas);
				}

				datosFechas.put(grabarConsRotasDet.getFecha(), grabarConsRotasDet.getRota());

			}

			ClasificadorEntidad clasifPuesto = TraerLeyendasRepEval.getClasificadorPuesto(this.getSesion());
			ClasificadorEntidad clasifEmpresa = TraerLeyendasRepEval.getClasificadorEmpresa(this.getSesion());
			ClasificadorEntidad clasifSector = TraerLeyendasRepEval.getClasificadorSector(this.getSesion());

			// Enviar los datos al cliente
			Iterator iterLegajos = legajos.keySet().iterator();
			while (iterLegajos.hasNext()) {
				Integer oidLegajo = (Integer) iterLegajos.next();
				Legajo legajo = Legajo.findByOid(oidLegajo, this.getSesion());
				String juego = "";
				String categoria = "";

				ValorClasificadorEntidad valClasifPuesto = legajo.getValorClasifEnt(clasifPuesto);
				ValorClasificadorEntidad valEmpresa = legajo.getValorClasifEnt(clasifEmpresa);
				ValorClasificadorEntidad valSector = legajo.getValorClasifEnt(clasifSector);

				if (valClasifPuesto != null)
					categoria = valClasifPuesto.getDescripcion();

				if (legajo.getGradoLegajo() != null)
					juego = legajo.getGradoLegajo().getDescripcion();

				String empresa = "";
				String sector = "";

				if (valEmpresa != null)
					empresa = valEmpresa.getDescripcion();

				if (valSector != null)
					sector = valSector.getDescripcion();

				
				HashTableDatos fechas = (HashTableDatos)legajos.get(oidLegajo);
				
				
				
				String novedad = (String)fechas.get(diasFechas.get(1));
				String novDia1 = (String)fechas.get(diasFechas.get(2));
				String novDia2 = (String)fechas.get(diasFechas.get(3));
				String novDia3 = (String)fechas.get(diasFechas.get(4));
				String novDia4 = (String)fechas.get(diasFechas.get(5));
				String novDia5 = (String)fechas.get(diasFechas.get(6));
				String novDia6 = (String)fechas.get(diasFechas.get(7));
				String novDia7 = (String)fechas.get(diasFechas.get(8));
				
				if (novedad == null) novedad = "";
				if (novDia1 == null) novDia1 = "";
				if (novDia2 == null) novDia2 = "";
				if (novDia3 == null) novDia3 = "";
				if (novDia4 == null) novDia4 = "";
				if (novDia5 == null) novDia5 = "";
				if (novDia6 == null) novDia6 = "";
				if (novDia7 == null) novDia7 = "";

				cargarConsPlanifRotas(dsDetCons, oidLegajo, legajo.getNro_legajo(), legajo.getApellidoyNombre(), 0, "", new Date(), juego, categoria, novedad, "", empresa, sector, novDia1, novDia2,
						novDia3, novDia4, novDia5, novDia6, novDia7, grabarConsRotasCab.getAgrupador()+ "(Grabada)" , nroConsulta);
			}
			
			cargarDiasColumnas(dsDiasColumnas, grabarConsRotasCab.getFec_desde());

		}

		writeCliente(dsDetCons);
		writeCliente(dsInput);
		writeCliente(dsDiasColumnas);
		

	}

	private IDataSet getDataSetInput() {
		IDataSet dataset = new TDataSet();
		dataset.create("TInput");
		dataset.fieldDef(new Field("oid_filtro", Field.INTEGER, 0));
		dataset.fieldDef(new Field("fec_desde", Field.DATE, 0));
		dataset.fieldDef(new Field("fec_hasta", Field.DATE, 0));
		dataset.fieldDef(new Field("oid_rota", Field.INTEGER, 0));
		dataset.fieldDef(new Field("rota", Field.STRING, 50));
		dataset.fieldDef(new Field("juego", Field.STRING, 100));
		dataset.fieldDef(new Field("dias", Field.INTEGER, 0));
		dataset.fieldDef(new Field("exc_si_tiene_nov", Field.BOOLEAN, 0));
		return dataset;
	}
	
	private IDataSet getDataSetNovConsRota() {
		IDataSet dataset = new TDataSet();
		dataset.create("TNovedadesRotas");
		dataset.fieldDef(new Field("oid_novedad", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_legajo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nro_legajo", Field.STRING, 50));
		dataset.fieldDef(new Field("ape_y_nom_legajo", Field.STRING, 100));
		dataset.fieldDef(new Field("empresa", Field.STRING, 100));
		dataset.fieldDef(new Field("sector", Field.STRING, 100));
		dataset.fieldDef(new Field("categoria", Field.STRING, 100));
		dataset.fieldDef(new Field("juegos", Field.STRING, 100));
		dataset.fieldDef(new Field("fecha_novedad", Field.DATE, 100));
		dataset.fieldDef(new Field("anterior", Field.DATE, 100));
		dataset.fieldDef(new Field("actual", Field.DATE, 100));
		dataset.fieldDef(new Field("viene", Field.INTEGER, 0));
		dataset.fieldDef(new Field("agrupador", Field.STRING, 500));
		dataset.fieldDef(new Field("novedad", Field.STRING, 500));
		
		return dataset;
	}	
	
	private void cargarNovConsRota(
			IDataSet ds,
			Integer oidNovedad,
			Integer oidLegajo,
			String nroLegajo,
			String apeyNom,
			String empresa,
			String sector,
			String categoria,
			String juegos,
			java.util.Date fechaNovedad,
			String anterior,
			String actual,
			Rota rota,
			java.util.Date fecPrimerDia,
			String agrupador) throws BaseException {
		
		if (soloNovedadesPrimerDia) {
			if (!fechaNovedad.equals(fecPrimerDia)) return;
		}
		
		ds.append();
		ds.fieldValue("oid_novedad", oidNovedad);
		ds.fieldValue("oid_legajo", oidLegajo);
		ds.fieldValue("nro_legajo", nroLegajo);
		ds.fieldValue("ape_y_nom_legajo", apeyNom);
		ds.fieldValue("empresa", empresa);
		ds.fieldValue("sector", sector);
		ds.fieldValue("categoria", categoria);
		ds.fieldValue("juegos", juegos);
		ds.fieldValue("fecha_novedad", fechaNovedad);
		
		if (rota!=null) {
			if ((anterior==null) || (anterior.trim().length()==0))
				anterior =  rota.getCodigo();
		}
		
		ds.fieldValue("anterior", anterior);
		
		if (rota!=null) {
			if ((actual==null) || (actual.trim().length()==0))
				actual = rota.getCodigo();
		}		
		
		ds.fieldValue("actual", actual);
		
		if (actual == null)
			actual = "";
		
		if (((actual!=null) && (rota!=null) && (actual.equals(rota.getCodigo()))))
			ds.fieldValue("viene", 1);
		else if (rota == null)
			ds.fieldValue("viene", 3);
		else
			ds.fieldValue("viene", 0);
		ds.fieldValue("agrupador", agrupador);
		ds.fieldValue("novedad", "Ir a la solapa NOVEDADES para ver las diferencias");
				
			
		
	}
			
			

	private void cargarDataSetInput(IDataSet ds, Integer oidFiltro, java.util.Date fecDesde, Rota rota, String juego, Integer dias, boolean excSiTieneNov) throws BaseException {
		ds.append();
		ds.fieldValue("oid_filtro", oidFiltro);
		ds.fieldValue("fec_desde", fecDesde);
		ds.fieldValue("fec_hasta", fecDesde);
		if (rota != null) {
			ds.fieldValue("oid_rota", rota.getOIDInteger());
			ds.fieldValue("rota", rota.getCodigo());
		} else {
			ds.fieldValue("oid_rota", "");
			ds.fieldValue("rota", "");
		}
		ds.fieldValue("juego", juego);
		if (dias != null)
			ds.fieldValue("dias", dias);
		else
			ds.fieldValue("dias", "");
		ds.fieldValue("exc_si_tiene_nov", excSiTieneNov);
	}

}
