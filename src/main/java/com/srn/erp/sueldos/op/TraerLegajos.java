package com.srn.erp.sueldos.op;

import java.util.Iterator;
import java.util.List;

import com.srn.erp.cip.bm.CategAccesoCIP;
import com.srn.erp.cip.bm.CategAccesoLegajo;
import com.srn.erp.cip.bm.EstadoCIP;
import com.srn.erp.cip.bm.GrupoPuerta;
import com.srn.erp.cip.bm.LegajoRotaFecha;
import com.srn.erp.cip.bm.MotEntInterLeg;
import com.srn.erp.cip.bm.MotivoEntIntermedias;
import com.srn.erp.cip.bm.PermisoSemanalCIP;
import com.srn.erp.cip.bm.TarjetaLegajo;
import com.srn.erp.cip.bm.UtilCIP;
import com.srn.erp.cip.bm.ZonaCIP;
import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.legales.bm.AudienciaJuicio;
import com.srn.erp.legales.bm.AudienciaSeclo;
import com.srn.erp.legales.bm.CartasDocRemLega;
import com.srn.erp.legales.bm.DocEnvSeclo;
import com.srn.erp.legales.bm.DocuEnvJuicio;
import com.srn.erp.legales.bm.Juicio;
import com.srn.erp.legales.bm.JuicioCalcInt;
import com.srn.erp.legales.bm.JuicioEmpresa;
import com.srn.erp.legales.bm.JuicioRubroCondena;
import com.srn.erp.legales.bm.NegociacionLegales;
import com.srn.erp.legales.bm.PagoJuicio;
import com.srn.erp.legales.bm.PagoSeclo;
import com.srn.erp.legales.bm.RequeridoSeclo;
import com.srn.erp.legales.bm.RubroCondenaJuicio;
import com.srn.erp.legales.bm.RubroReclamoSeclo;
import com.srn.erp.legales.bm.Seclo;
import com.srn.erp.rrhh.bm.CategPosibleLeg;
import com.srn.erp.rrhh.bm.Competencia;
import com.srn.erp.rrhh.bm.EvalCargaResul;
import com.srn.erp.rrhh.bm.EvalValClasifLeg;
import com.srn.erp.rrhh.bm.EvaluacionLegajoCab;
import com.srn.erp.rrhh.bm.HistoricoPuesto;
import com.srn.erp.rrhh.bm.NovedadLegajo;
import com.srn.erp.rrhh.bm.ObsLegajo;
import com.srn.erp.rrhh.bm.SancionesLegajo;
import com.srn.erp.rrhh.bm.ServicioMedicoRRHH;
import com.srn.erp.rrhh.bm.TareaDesempeneada;
import com.srn.erp.rrhh.op.TraerLeyendasRepEval;
import com.srn.erp.sueldos.bm.Legajo;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bm.Varios.CalculadorMoney;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerLegajos extends Operation {

	public TraerLegajos() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		if (mapaDatos.containsKey("inicializarClasificadores")) {
			inicializarClasif(mapaDatos);
			return;
		}

		Legajo legajo = null;
		if (mapaDatos.containsKey("oid")) {
			Integer oid = mapaDatos.getInteger("oid");
			legajo = Legajo.findByOid(oid, getSesion());
		} else {
			String codigo = mapaDatos.getString("codigo");
			legajo = Legajo.findByCodigo(codigo, getSesion());
		}

		IDataSet datasetLegajos = getDataSetLegajos();
		IDataSet datasetValoresClasif = getDataSetValClasif();
		IDataSet datasetTarjetas = getDataSetTarjetaLegajo();
		IDataSet datasetMotivosLeg = getDataSetMotAccesosIntermedios();
		IDataSet datasetMotAccInternos = getDataSetMotAccesosInternos();
		IDataSet datasetPlanifRota = getDataSetPlanifFechaRota();
		IDataSet datasetHistPues = getDataSetHistPuestos();
		IDataSet datasetSanciones = this.getDataSetSanciones();
		IDataSet datasetPedMed = getDataSetPedMed();
		IDataSet datasetAteMed = getDataSetAteMed();
		IDataSet datasetEnfFam = getDataSetEnfFam();
		IDataSet datasetAccLab = getDataSetAccLab();
		IDataSet datasetLabelCompe = getDataSetLabelCompetencias();
		IDataSet datasetEvaluaciones = getDataSetEvaluaciones();
		IDataSet datasetCarRemLega = getDataSetCartasDocRemitidas();
		IDataSet datasetSeclo = getDataSetSeclo();
		IDataSet dsAudiencias = getDataSetAudienciaSeclo();
		IDataSet dsDocEnvSeclo = getDataSetDocEnvSeclo();
		IDataSet dsPagos = getDataSetPagoSeclo();
		IDataSet dsPagoJuicios = getDataSetPagoJuicio();
		IDataSet dsRequeridos = getDataSetRequeridos();
		IDataSet dsNovedad = getDataSetNovedad();
		IDataSet dsCategPosibles = getDataSetCategPosibleLeg();
		IDataSet dsJuicio = getDataSetJuicio();
		IDataSet dsDocuEnvJuicio = getDataSetDocuEnvJuicio();
		IDataSet dsEmpresaJuicio = getDataSetJuicioEmpresa();
		IDataSet dsAudiJuicio = getDataSerAudJuicios();
		IDataSet dsObs = getDataSetObservaciones();
		IDataSet dsJuicioRubroCondena = getDataSetJuicioRubroCondena();
		IDataSet dsNegociacion  = this.getDataSetNegociacionLegales();
		IDataSet dsJuicioRubroReclamo = getDataSetJuicioRubroReclamo();
		IDataSet dsRubroReclamoSeclo = getDataSetRubroReclamoSeclo();
		IDataSet dsCalcInteresJuicio = getDataSetCalcInteres();

		if (legajo != null) {

			cargarRegistroLegajos(datasetLegajos, legajo.getOIDInteger(), legajo.getNro_legajo(), legajo.getNombre(), legajo.getApellido(), legajo.isActivo(), legajo.getFecIngreso(), legajo
					.getFecRetiro(), legajo.getIDIdentificacion(), legajo.getGrupoPuertaIngreso(), legajo.getGrupoPuertaEgreso(), legajo.getEstadoCIP(), legajo.getPermisoSemanal(), legajo
					.isActivarAntiPassBack(), legajo.getFecUltPaso(), legajo.getHoraUltPaso(), legajo.getSentidoPaso(), legajo.isIgnorarProxAntiPassBack(), legajo.isCircuitoCacheo(), legajo
					.getZonaActual(), legajo.isLiberarIngAlPredio(), legajo.isProhibirAcceso(), legajo , legajo.getTareaDesempeneada());

			Iterator iterTarLegAct = legajo.getTarjetasLegajoActivas().iterator();
			while (iterTarLegAct.hasNext()) {
				TarjetaLegajo tarjetaLegajo = (TarjetaLegajo) iterTarLegAct.next();
				traerTarjetaLegajo(datasetTarjetas, tarjetaLegajo);
			}

			java.util.Date fecha = Fecha.getFechaTruncada(Fecha.getFechaDiaAnterior(UtilCIP.getFechaHoraActual(this.getSesion())));
			Iterator iterLegRotFech = legajo.getLegajoRotaFechasMayoIgual(fecha).iterator();
			while (iterLegRotFech.hasNext()) {
				LegajoRotaFecha legajoRotaFecha = (LegajoRotaFecha) iterLegRotFech.next();
				traerLegajoRotaFecha(datasetPlanifRota, legajoRotaFecha);
			}

			traerObs(dsObs, legajo);
			traerValoresDatosClasif(datasetValoresClasif, legajo);
			traerMotivosAccesosIntermedios(datasetMotivosLeg, legajo);
			traerCategAccesosInternos(datasetMotAccInternos, legajo);
			traerHistPuestosIDataSet(datasetHistPues, legajo);
			traerSancionesLegajo(datasetSanciones, legajo);
			traerPedidosMedicos(datasetPedMed, legajo);
			traerAtencionMedica(datasetAteMed, legajo);
			traerEnfermedadFamiliar(datasetEnfFam, legajo);
			traerAccidentesLab(datasetAccLab, legajo);
			traerEvaluaciones(datasetLabelCompe, datasetEvaluaciones, legajo);
			traerCartasRemitidasLeg(datasetCarRemLega, legajo);
			traerSeclo(datasetSeclo, dsAudiencias, dsDocEnvSeclo, dsPagos, dsRequeridos, legajo , dsRubroReclamoSeclo);
			traerNovedades(dsNovedad, legajo);
			traerNegociaciones(dsNegociacion, legajo);
			traerCategPosibles(dsCategPosibles, legajo);
			traerJuicio(dsJuicio, dsPagoJuicios, dsJuicioRubroCondena , dsDocuEnvJuicio, dsEmpresaJuicio, dsAudiJuicio, legajo , dsJuicioRubroReclamo,dsCalcInteresJuicio );
			
			

		}

		writeCliente(datasetLegajos);
		writeCliente(datasetValoresClasif);
		writeCliente(datasetTarjetas);
		writeCliente(datasetMotivosLeg);
		writeCliente(datasetMotAccInternos);
		writeCliente(datasetPlanifRota);
		writeCliente(datasetHistPues);
		writeCliente(datasetSanciones);
		writeCliente(datasetPedMed);
		writeCliente(datasetAteMed);
		writeCliente(datasetEnfFam);
		writeCliente(datasetAccLab);
		writeCliente(datasetLabelCompe);
		writeCliente(datasetEvaluaciones);
		writeCliente(datasetCarRemLega);
		writeCliente(datasetSeclo);
		writeCliente(dsAudiencias);
		writeCliente(dsDocEnvSeclo);
		writeCliente(dsPagos);
		writeCliente(dsPagoJuicios);

		writeCliente(dsRequeridos);
		writeCliente(dsNovedad);
		writeCliente(dsCategPosibles);
		writeCliente(dsJuicio);
		writeCliente(dsDocuEnvJuicio);
		writeCliente(dsEmpresaJuicio);
		writeCliente(dsAudiJuicio);
		writeCliente(dsObs);
		writeCliente(dsJuicioRubroCondena);
		writeCliente(dsNegociacion);
		writeCliente(dsJuicioRubroReclamo);
		writeCliente(dsRubroReclamoSeclo);
		writeCliente(dsCalcInteresJuicio);

	}

	private void traerAudiencias(IDataSet dsAudiencias, Seclo aSeclo) throws BaseException {
		Iterator iterAudiencias = aSeclo.getAudiencias().iterator();
		while (iterAudiencias.hasNext()) {
			AudienciaSeclo audiencia = (AudienciaSeclo) iterAudiencias.next();
			cargarAudiencia(dsAudiencias, audiencia);
		}

	}

	private void traerJuicio(IDataSet dsJuicio, IDataSet dsPagoJuicio, IDataSet dsJuicioRubroCondena, IDataSet dsEnvDocuJuicio, IDataSet dsEmpresaJuicio, IDataSet dsAudiJuicios, Legajo legajo , IDataSet dsJuicioRubroReclamo , IDataSet dsCalcInteresJuicio) throws BaseException {

		Iterator iterJuicios = legajo.getJuicios().iterator();
		while (iterJuicios.hasNext()) {
			Juicio juicio = (Juicio) iterJuicios.next();
			cargarRegJuicio(dsJuicio, juicio);

			Iterator iterDocuEnv = juicio.getDocuEnviados().iterator();
			while (iterDocuEnv.hasNext()) {
				DocuEnvJuicio docuEnvJuicio = (DocuEnvJuicio) iterDocuEnv.next();
				cargarDocuEnvJuicio(dsEnvDocuJuicio, docuEnvJuicio);
			}

			Iterator iterEmpJuicio = juicio.getEmpresas().iterator();
			while (iterEmpJuicio.hasNext()) {
				JuicioEmpresa juicioEmpresa = (JuicioEmpresa) iterEmpJuicio.next();
				cargarRegistroJuicioEmpresa(dsEmpresaJuicio, juicioEmpresa);
			}

			Iterator iterAudiJuicios = juicio.getAudiencias().iterator();
			while (iterAudiJuicios.hasNext()) {
				AudienciaJuicio audienciaJuicio = (AudienciaJuicio) iterAudiJuicios.next();
				cargarRegistroAudJuicio(dsAudiJuicios, audienciaJuicio);
			}
			
			Iterator iterPagosJuicios = juicio.getPagosJuicios().iterator();
			while (iterPagosJuicios.hasNext()) {
				PagoJuicio pagoJuicio = (PagoJuicio) iterPagosJuicios.next();
				cargarRegistroPagoJuicio(dsPagoJuicio, pagoJuicio);
			}			
			
			Iterator iterRubroCondenas = juicio.getRubrosCondenas().iterator();
			while (iterRubroCondenas.hasNext()) {
				JuicioRubroCondena juicioRubroCondena = (JuicioRubroCondena) iterRubroCondenas.next();
				cargarRegistroJuicioRubroCondena(dsJuicioRubroCondena, juicioRubroCondena);
			}			
			
			Iterator iterRubroReclamos = juicio.getRubrosReclamos().iterator();
			while (iterRubroReclamos.hasNext()) {
				RubroCondenaJuicio rubroCondenaJuicio = (RubroCondenaJuicio) iterRubroReclamos.next();
				cargarRegistroJuicioRubroReclamo(dsJuicioRubroReclamo, rubroCondenaJuicio);
			}
			
			Iterator iterCalcInteres = juicio.getCalcInteres().iterator();
			while (iterCalcInteres.hasNext()) {
				JuicioCalcInt juicioCalcInt = (JuicioCalcInt) iterCalcInteres.next();
				cargarCalcIntJuicio(dsCalcInteresJuicio, juicioCalcInt);
			}			

		}
	}

	private void traerSeclo(IDataSet datasetSeclo, IDataSet dsAudiencias, IDataSet dsDocEnvSeclo, IDataSet dsPagos, IDataSet dsRequeridos, Legajo legajo , IDataSet dsSeclo) throws BaseException {
		Iterator iterSeclos = legajo.getSeclos().iterator();
		while (iterSeclos.hasNext()) {
			Seclo seclo = (Seclo) iterSeclos.next();
			cargarRegSeclo(datasetSeclo, seclo);
			traerAudiencias(dsAudiencias, seclo);
			traerDocEnvSeclo(dsDocEnvSeclo, seclo);
			traerPagos(dsPagos, seclo);
			traerRequeridos(dsRequeridos, seclo);
			traerRubroReclamos(dsSeclo, seclo);
		}
	}
	
	private void traerRubroReclamos(IDataSet dsSeclo, Seclo seclo) throws BaseException {
		Iterator iterRubrosReclamos = seclo.getRubrosReclamos().iterator();
		while (iterRubrosReclamos.hasNext()) {
			RubroReclamoSeclo rubroReclamoSeclo = (RubroReclamoSeclo) iterRubrosReclamos.next();
			cargarRubroReclamoSeclo(dsSeclo, rubroReclamoSeclo);
		}		
	}
	
	
	private void cargarRubroReclamoSeclo(IDataSet dataset, 
              RubroReclamoSeclo rubroReclamoSeclo) throws BaseException {
		  dataset.append(); 
		  dataset.fieldValue("oid_rub_rec_seclo", rubroReclamoSeclo.getOIDInteger());
		  dataset.fieldValue("oid_rubro_condena", rubroReclamoSeclo.getRubro_condena().getOIDInteger());
		  dataset.fieldValue("oid_seclo", rubroReclamoSeclo.getSeclo().getOIDInteger());
		  dataset.fieldValue("activo", rubroReclamoSeclo.isActivo());
	}	

	private void traerPagos(IDataSet dsPagos, Seclo aSeclo) throws BaseException {
		Iterator iterPagos = aSeclo.getPagosSeclo().iterator();
		while (iterPagos.hasNext()) {
			PagoSeclo pagoSeclo = (PagoSeclo) iterPagos.next();
			cargarPago(dsPagos, pagoSeclo);
		}
	}

	private void traerRequeridos(IDataSet dsRequerido, Seclo aSeclo) throws BaseException {
		Iterator iterRequeridos = aSeclo.getRequeridos().iterator();
		while (iterRequeridos.hasNext()) {
			RequeridoSeclo requerido = (RequeridoSeclo) iterRequeridos.next();
			cargarRequerido(dsRequerido, requerido);
		}
	}

	private void traerDocEnvSeclo(IDataSet dsDocEnvSeclo, Seclo aSeclo) throws BaseException {
		Iterator iterDocEnviados = aSeclo.getDocEnviados().iterator();
		while (iterDocEnviados.hasNext()) {
			DocEnvSeclo docEnvSeclo = (DocEnvSeclo) iterDocEnviados.next();
			cargarDocEnv(dsDocEnvSeclo, docEnvSeclo);
		}
	}

	private void cargarRequerido(IDataSet dsRequerido, RequeridoSeclo aRequeridoSeclo) throws BaseException {
		dsRequerido.append();
		dsRequerido.fieldValue("oid_seclo_reque", aRequeridoSeclo.getOID());
		dsRequerido.fieldValue("oid_seclo", aRequeridoSeclo.getSeclo().getOIDInteger());
		if (aRequeridoSeclo.getValor_clasif_empresa() != null) {
			dsRequerido.fieldValue("oid_val_clasif_emp", aRequeridoSeclo.getValor_clasif_empresa().getOIDInteger());
			dsRequerido.fieldValue("cod_val_clasif_emp", aRequeridoSeclo.getValor_clasif_empresa().getCodigo());
			dsRequerido.fieldValue("desc_val_clasif_emp", aRequeridoSeclo.getValor_clasif_empresa().getDescripcion());
		} else {
			dsRequerido.fieldValue("oid_val_clasif_emp", "");
			dsRequerido.fieldValue("cod_val_clasif_emp", "");
			dsRequerido.fieldValue("desc_val_clasif_emp", "");
		}
		dsRequerido.fieldValue("activo", aRequeridoSeclo.isActivo());
	}

	private void cargarPago(IDataSet dsPago, PagoSeclo aPagoSeclo) throws BaseException {
		dsPago.append();
		dsPago.fieldValue("oid_pago_seclo", aPagoSeclo.getOID());
		dsPago.fieldValue("oid_seclo", aPagoSeclo.getSeclo().getOIDInteger());
		dsPago.fieldValue("fec_pago", aPagoSeclo.getFec_pago());
		dsPago.fieldValue("observacion", aPagoSeclo.getObservacion());
		dsPago.fieldValue("pago_acuerdo", aPagoSeclo.getPago_acuerdo());
		dsPago.fieldValue("activo", aPagoSeclo.isActivo());
		dsPago.fieldValue("pago_letrado", aPagoSeclo.getPago_letrado());
		if (aPagoSeclo.getConc_pago() != null)
			dsPago.fieldValue("oid_conc_pago_seclo", aPagoSeclo.getConc_pago().getOIDInteger());
		else
			dsPago.fieldValue("oid_conc_pago_seclo", "");
		dsPago.fieldValue("pago_conciliador", aPagoSeclo.getPago_conciliador());
		dsPago.fieldValue("pago_otros", aPagoSeclo.getPago_otros());

		// Calcular total a pagar
	}

	private void traerDocuEnvJuicio(IDataSet dsDocuEnvJuicio, Legajo legajo) throws BaseException {

	}

	private void cargarDocEnv(IDataSet dsDocEnvSeclo, DocEnvSeclo aDocEnvSeclo) throws BaseException {
		dsDocEnvSeclo.append();
		dsDocEnvSeclo.fieldValue("oid_doc_env_sec", aDocEnvSeclo.getOID());
		dsDocEnvSeclo.fieldValue("oid_seclo", aDocEnvSeclo.getSeclo().getOIDInteger());
		dsDocEnvSeclo.fieldValue("fecha_envio", aDocEnvSeclo.getFecha_envio());
		dsDocEnvSeclo.fieldValue("documentacion", aDocEnvSeclo.getDocumentacion());
		dsDocEnvSeclo.fieldValue("activo", aDocEnvSeclo.isActivo());
	}

	private void traerCartasRemitidasLeg(IDataSet datasetCarRemLega, Legajo legajo) throws BaseException {
		Iterator iterCartasRemitidasLega = legajo.getCartasRemitidasLegales().iterator();
		while (iterCartasRemitidasLega.hasNext()) {
			CartasDocRemLega cartasDocRemLega = (CartasDocRemLega) iterCartasRemitidasLega.next();
			cargarRegCarRemLeg(datasetCarRemLega, cartasDocRemLega);
		}
	}

	private void cargarRegCarRemLeg(IDataSet dsCartaRemitoLeg, CartasDocRemLega cartasDocRemLega) throws BaseException {
		dsCartaRemitoLeg.append();
		dsCartaRemitoLeg.fieldValue("oid_carta_remitida", cartasDocRemLega.getOIDInteger());
		dsCartaRemitoLeg.fieldValue("nro_orden", cartasDocRemLega.getNro_orden());
		dsCartaRemitoLeg.fieldValue("oid_legajo", cartasDocRemLega.getLegajo().getOIDInteger());
		dsCartaRemitoLeg.fieldValue("nro_carta_doc", cartasDocRemLega.getNro_carta_doc());
		dsCartaRemitoLeg.fieldValue("fecha", cartasDocRemLega.getFecha());
		if (cartasDocRemLega.getTipocausa() != null)
			dsCartaRemitoLeg.fieldValue("oid_tipo_causa", cartasDocRemLega.getTipocausa().getOIDInteger());
		else
			dsCartaRemitoLeg.fieldValue("oid_tipo_causa", "");
		dsCartaRemitoLeg.fieldValue("causa", cartasDocRemLega.getCausa());
		dsCartaRemitoLeg.fieldValue("recibido", cartasDocRemLega.getRecibido());
		dsCartaRemitoLeg.fieldValue("observaciones", cartasDocRemLega.getObservaciones());
		dsCartaRemitoLeg.fieldValue("activo", cartasDocRemLega.isActivo());

	}

	private void traerEvaluaciones(IDataSet datasetLabelCompe, IDataSet datasetEvaluaciones, Legajo legajo) throws BaseException {

		HashTableDatos listaCompetencias = new HashTableDatos();
		HashTableDatos listaPosiCompe = new HashTableDatos();

		int secu = 0;

		Iterator iterEvalLegCab = legajo.getEvaluacionesByLegajo().iterator();
		while (iterEvalLegCab.hasNext()) {
			EvaluacionLegajoCab evaluacionLegajoCab = (EvaluacionLegajoCab) iterEvalLegCab.next();
			Iterator iterResulCompe = evaluacionLegajoCab.getResultadosCompe().iterator();
			while (iterResulCompe.hasNext()) {

				EvalCargaResul evalCargaResul = (EvalCargaResul) iterResulCompe.next();

				Integer oidCompeBuscar = (Integer) listaCompetencias.get(evalCargaResul.getCompetencia().getOIDInteger());
				if (oidCompeBuscar == null) {
					++secu;
					listaCompetencias.put(evalCargaResul.getCompetencia().getOIDInteger(), secu);
					listaPosiCompe.put(secu, evalCargaResul.getCompetencia().getOIDInteger());
				}

			}
		}

		// Devolver label de Etiquetas
		Iterator iterNrosCompe = listaCompetencias.keySet().iterator();
		while (iterNrosCompe.hasNext()) {
			Integer oidCompetencia = (Integer) iterNrosCompe.next();
			secu = (Integer) listaCompetencias.get(oidCompetencia);
			Competencia compe = Competencia.findByOid(oidCompetencia, this.getSesion());
			datasetLabelCompe.append();
			datasetLabelCompe.fieldValue("nro", secu);
			datasetLabelCompe.fieldValue("descripcion", compe.getDescAbrev());

		}

		ClasificadorEntidad clasifEmpresa = TraerLeyendasRepEval.getClasificadorEmpresa(this.getSesion());
		ClasificadorEntidad clasifSector = TraerLeyendasRepEval.getClasificadorSector(this.getSesion());
		ClasificadorEntidad clasifPuesto = TraerLeyendasRepEval.getClasificadorPuesto(this.getSesion());
		ClasificadorEntidad clasifEstado = TraerLeyendasRepEval.getClasificadorEstado(this.getSesion());

		iterEvalLegCab = legajo.getEvaluacionesByLegajo().iterator();
		while (iterEvalLegCab.hasNext()) {
			EvaluacionLegajoCab evaluacion = (EvaluacionLegajoCab) iterEvalLegCab.next();

			datasetEvaluaciones.append();
			datasetEvaluaciones.fieldValue("oid_evaluacion", evaluacion.getOIDInteger());
			datasetEvaluaciones.fieldValue("oid_legajo", legajo.getOIDInteger());

			ValorClasificadorEntidad valorClasifEmpresa = null;
			ValorClasificadorEntidad valorClasifSector = null;
			ValorClasificadorEntidad valorClasifPuesto = null;
			ValorClasificadorEntidad valorClasifEstado = null;

			EvalValClasifLeg evalValClasifLegEmp = evaluacion.getEvalValClasifLeg(clasifEmpresa);
			EvalValClasifLeg evalValClasifLegSec = evaluacion.getEvalValClasifLeg(clasifSector);
			EvalValClasifLeg evalValClasifLegPue = evaluacion.getEvalValClasifLeg(clasifPuesto);
			EvalValClasifLeg evalValClasifLegEst = evaluacion.getEvalValClasifLeg(clasifEstado);

			if (evalValClasifLegEmp != null)
				valorClasifEmpresa = evalValClasifLegEmp.getValor_clasificador();
			if (evalValClasifLegSec != null)
				valorClasifSector = evalValClasifLegSec.getValor_clasificador();
			if (evalValClasifLegPue != null)
				valorClasifPuesto = evalValClasifLegPue.getValor_clasificador();
			if (evalValClasifLegEst != null)
				valorClasifEstado = evalValClasifLegEst.getValor_clasificador();

			datasetEvaluaciones.fieldValue("desc_evaluacion", evaluacion.getCondModEvalCab().getModelo_eval_cab().getDesc_abreviada());
			if (valorClasifEmpresa != null)
				datasetEvaluaciones.fieldValue("empresa", valorClasifEmpresa.getDescripcion());
			else
				datasetEvaluaciones.fieldValue("empresa", "");
			if (valorClasifSector != null)
				datasetEvaluaciones.fieldValue("sector", valorClasifSector.getDescripcion());
			else
				datasetEvaluaciones.fieldValue("sector", "");
			if (valorClasifPuesto != null)
				datasetEvaluaciones.fieldValue("puesto", valorClasifPuesto.getDescripcion());
			else
				datasetEvaluaciones.fieldValue("puesto", "");

			datasetEvaluaciones.fieldValue("fec_desde", evaluacion.getModelo_eval_cab().getFec_desde());
			datasetEvaluaciones.fieldValue("fec_hasta", evaluacion.getModelo_eval_cab().getFec_hasta());
			datasetEvaluaciones.fieldValue("fec_evaluacion", evaluacion.getFec_eval());
			if (evaluacion.isVigente())
				datasetEvaluaciones.fieldValue("vigente", "Si");
			else
				datasetEvaluaciones.fieldValue("vigente", "No");
			datasetEvaluaciones.fieldValue("puntaje", evaluacion.getPuntajeEntero());

			// Obtener los porcentajes de las competencias
			HashTableDatos porcCompetencias = new HashTableDatos();
			Iterator iterResulCompe = evaluacion.getResultadosCompe().iterator();
			while (iterResulCompe.hasNext()) {
				EvalCargaResul resulCompe = (EvalCargaResul) iterResulCompe.next();
				Money porcCumpli = new Money(0);
				if (resulCompe.getPorc_cumpli() != null)
					porcCumpli = resulCompe.getPorc_cumpli();
				porcCompetencias.put(resulCompe.getCompetencia().getOIDInteger(), porcCumpli);
			}

			for (int i = 1; i <= 50; ++i) {

				Integer oidCompetencia = (Integer) listaPosiCompe.get(i);
				if (oidCompetencia == null)
					datasetEvaluaciones.fieldValue("compe_" + i, "");
				else {
					Money porcCumpli = (Money) porcCompetencias.get(oidCompetencia);
					if (porcCumpli != null)
						datasetEvaluaciones.fieldValue("compe_" + i, porcCumpli.doubleValue());
					else
						datasetEvaluaciones.fieldValue("compe_" + i, "");
				}

			}

		}

	}

	private void traerPedidosMedicos(IDataSet datasetPedMed, Legajo legajo) throws BaseException {
		Iterator iterPedidosMedicos = legajo.getPedidosMedicos().iterator();
		while (iterPedidosMedicos.hasNext()) {
			ServicioMedicoRRHH servicioPedMed = (ServicioMedicoRRHH) iterPedidosMedicos.next();
			cargarRegPedMed(datasetPedMed, servicioPedMed);
		}

	}

	private void traerAtencionMedica(IDataSet datasetAteMed, Legajo legajo) throws BaseException {
		Iterator iterAtencionMedica = legajo.getAtencionesMedicas().iterator();
		while (iterAtencionMedica.hasNext()) {
			ServicioMedicoRRHH servicioPedMed = (ServicioMedicoRRHH) iterAtencionMedica.next();
			cargarRegAteMed(datasetAteMed, servicioPedMed);
		}

	}

	private void traerAccidentesLab(IDataSet datasetAccLab, Legajo legajo) throws BaseException {
		Iterator iterAccLab = legajo.getAccidentesLaborales().iterator();
		while (iterAccLab.hasNext()) {
			ServicioMedicoRRHH servicioPedMed = (ServicioMedicoRRHH) iterAccLab.next();
			cargarRegAccLab(datasetAccLab, servicioPedMed);
		}
	}

	private void traerEnfermedadFamiliar(IDataSet datasetAteMed, Legajo legajo) throws BaseException {
		Iterator iterEnfermedadFamiliar = legajo.getEnfermedadesFam().iterator();
		while (iterEnfermedadFamiliar.hasNext()) {
			ServicioMedicoRRHH servicioPedMed = (ServicioMedicoRRHH) iterEnfermedadFamiliar.next();
			cargarRegEnfFam(datasetAteMed, servicioPedMed);
		}

	}

	private void traerSancionesLegajo(IDataSet datasetSanciones, Legajo legajo) throws BaseException {
		Iterator iterSanciones = legajo.getSancionesLegajos().iterator();
		while (iterSanciones.hasNext()) {
			SancionesLegajo sancionesLegajo = (SancionesLegajo) iterSanciones.next();
			cargarSanciones(datasetSanciones, sancionesLegajo);
		}

	}

	private void traerNegociaciones(IDataSet dsNegociaciones, Legajo legajo) throws BaseException {
		int i = 0;
		Iterator iterNegociaciones = legajo.getNegociaciones().iterator();
		while (iterNegociaciones.hasNext()) {
			NegociacionLegales negociacion = (NegociacionLegales) iterNegociaciones.next();
			cargarRegistroNegociacionLegales(dsNegociaciones, negociacion);
		}
	}	
	
	private void traerNovedades(IDataSet dsNovedades, Legajo legajo) throws BaseException {
		int i = 0;
		Iterator iterNovedades = legajo.getNovedades().iterator();
		while (iterNovedades.hasNext()) {
			NovedadLegajo novedad = (NovedadLegajo) iterNovedades.next();
			cargarRegNovedad(dsNovedades, novedad);
		}
	}

	private void traerHistPuestosIDataSet(IDataSet datasetHistPue, Legajo legajo) throws BaseException {
		int i = 0;
		java.util.Date fecAnt = null;

		List listaHistPuestos = legajo.getHistoricoPuestos();
		int cantPuestos = listaHistPuestos.size();
		boolean ultPuestos = false;

		int numerarPuestos = 0;
		Iterator iterHistPue = listaHistPuestos.iterator();
		while (iterHistPue.hasNext()) {
			HistoricoPuesto historicoPuesto = (HistoricoPuesto) iterHistPue.next();
			++numerarPuestos;
			if (numerarPuestos == cantPuestos)
				ultPuestos = true;
			else
				ultPuestos = false;
			cargarRegHistPuesto(datasetHistPue, legajo, historicoPuesto, fecAnt, ultPuestos);
			fecAnt = historicoPuesto.getFec_desde();
			++i;
		}
	}

	private void traerCategAccesosInternos(IDataSet datasetMotAccInternos, Legajo legajo) throws BaseException {
		int secu = 1;
		boolean activo = true;

		Iterator iterCategAccesoCIP = CategAccesoCIP.getAllActivos(this.getSesion()).iterator();
		while (iterCategAccesoCIP.hasNext()) {
			CategAccesoCIP categAccesoCIP = (CategAccesoCIP) iterCategAccesoCIP.next();

			CategAccesoLegajo categAccesoLegajo = CategAccesoLegajo.getCategAccesoLegajo(categAccesoCIP, legajo, this.getSesion());

			if (categAccesoLegajo != null)
				activo = true;
			else
				activo = false;

			cargarRegistroCategAccInternos(datasetMotAccInternos, secu, categAccesoCIP, legajo.getOIDInteger(), activo);

			++secu;
		}
	}

	private void traerObs(IDataSet dsObs, Legajo legajo) throws BaseException {
		int secu = 1;

		Iterator iterObsLeg = ObsLegajo.getObsLegajo(legajo, this.getSesion()).iterator();
		while (iterObsLeg.hasNext()) {
			ObsLegajo obsLegajo = (ObsLegajo) iterObsLeg.next();
			cargarRegistroObservacion(dsObs, obsLegajo);
		}
	}

	private void traerMotivosAccesosIntermedios(IDataSet datasetMotivosLeg, Legajo legajo) throws BaseException {
		int secu = 1;

		Iterator iterMotivoEntIntermedias = MotivoEntIntermedias.getMotivoEntIntermedias(this.getSesion()).iterator();
		while (iterMotivoEntIntermedias.hasNext()) {
			MotivoEntIntermedias motivoEntIntermedias = (MotivoEntIntermedias) iterMotivoEntIntermedias.next();
			++secu;
			datasetMotivosLeg.append();
			datasetMotivosLeg.fieldValue("secu", secu);
			datasetMotivosLeg.fieldValue("oid_legajo", legajo.getOID());
			MotEntInterLeg motEntInterLeg = MotEntInterLeg.getMotEntInterLeg(legajo, motivoEntIntermedias, this.getSesion());

			if (motEntInterLeg != null)
				datasetMotivosLeg.fieldValue("habilitado", true);
			else
				datasetMotivosLeg.fieldValue("habilitado", false);

			datasetMotivosLeg.fieldValue("oid_motivo", motivoEntIntermedias.getOIDInteger());
			datasetMotivosLeg.fieldValue("desc_motivo", motivoEntIntermedias.getDescripcion());
		}
	}

	private void traerLegajoRotaFecha(IDataSet datasetPlanifRota, LegajoRotaFecha legajoRotaFecha) throws BaseException {
		datasetPlanifRota.append();
		datasetPlanifRota.fieldValue("oid_fecha_rota", legajoRotaFecha.getOIDInteger());
		datasetPlanifRota.fieldValue("oid_legajo", legajoRotaFecha.getLegajo().getOIDInteger());
		datasetPlanifRota.fieldValue("fecha", legajoRotaFecha.getFecha());
		datasetPlanifRota.fieldValue("oid_rota", legajoRotaFecha.getRota().getOIDInteger());
		datasetPlanifRota.fieldValue("cod_rota", legajoRotaFecha.getRota().getCodigo());
		datasetPlanifRota.fieldValue("desc_rota", legajoRotaFecha.getRota().getDescripcion());
		datasetPlanifRota.fieldValue("activo", legajoRotaFecha.isActivo());
	}

	private IDataSet getDataSetMotAccesosIntermedios() {
		IDataSet dataset = new TDataSet();
		dataset.create("TMotAccesosIntermedios");
		dataset.fieldDef(new Field("secu", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_legajo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("habilitado", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("oid_motivo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("desc_motivo", Field.STRING, 100));
		return dataset;
	}

	private IDataSet getDataSetPlanifFechaRota() {
		IDataSet dataset = new TDataSet();
		dataset.create("TFechaRota");
		dataset.fieldDef(new Field("oid_fecha_rota", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_legajo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("fecha", Field.DATE, 0));
		dataset.fieldDef(new Field("oid_rota", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_rota", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_rota", Field.STRING, 100));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}
	
	private IDataSet getDataSetJuicioRubroReclamo() {
	    IDataSet dataset = new TDataSet(); 
	    dataset.create("TRubroCondenaJuicio");
	    dataset.fieldDef(new Field("oid_rub_cond_jui", Field.INTEGER, 0)); 
	    dataset.fieldDef(new Field("oid_rubro_condena", Field.INTEGER, 0)); 
	    dataset.fieldDef(new Field("oid_juicio", Field.INTEGER, 0)); 
	    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
	    return dataset;		
	}

	private void cargarRegHistPuesto(IDataSet ds, Legajo legajo, HistoricoPuesto histPuesto, java.util.Date fecAnt, boolean ultPuesto) throws BaseException {
		ds.append();
		ds.fieldValue("oid_hist_puesto", histPuesto.getOIDInteger());
		ds.fieldValue("oid_val_clasif_pue", histPuesto.getVal_clasif_pue().getOIDInteger());
		ds.fieldValue("cod_val_clasif_pue", histPuesto.getVal_clasif_pue().getCodigo());
		ds.fieldValue("desc_val_clasif_pue", histPuesto.getVal_clasif_pue().getDescripcion());
		ds.fieldValue("fec_desde", histPuesto.getFec_desde());

		int anio = Fecha.getAnio(histPuesto.getFec_desde());
		int mes = Fecha.getMes(histPuesto.getFec_desde());
		java.util.Date fecAsumio = Fecha.getFecha(1, mes, anio);

		if (ultPuesto) {
			java.util.Date fecAntParaDesa = legajo.getFecAntParaDesa();
			if (fecAntParaDesa != null) {
				int anioFecAntParaDesa = Fecha.getAnio(fecAntParaDesa);
				int mesFecAntParaDesa = Fecha.getMes(fecAntParaDesa);
				if ((anio == anioFecAntParaDesa) && (mes == mesFecAntParaDesa)) {
					fecAsumio = fecAntParaDesa;
				}
			}

		}

		if (fecAnt == null) {

			ds.fieldValue("ant_fec_desde", Fecha.getLabelAntiguedad(fecAsumio));

		} else {

			anio = Fecha.getAnio(fecAnt);
			mes = Fecha.getMes(fecAnt);

			java.util.Date nuevaFecHasta = Fecha.getFechaDiaAnterior(Fecha.getFecha(1, mes, anio));
			ds.fieldValue("ant_fec_desde", Fecha.getLabelAntiguedad(fecAsumio, nuevaFecHasta));

		}
		ds.fieldValue("oid_legajo", histPuesto.getLegajo().getOIDInteger());
		ds.fieldValue("activo", histPuesto.isActivo());
		if (histPuesto.getVal_clasif_emp() != null) {
			ds.fieldValue("oid_val_clasif_emp", histPuesto.getVal_clasif_emp().getOIDInteger());
			ds.fieldValue("cod_val_clasif_emp", histPuesto.getVal_clasif_emp().getCodigo());
			ds.fieldValue("desc_val_clasif_emp", histPuesto.getVal_clasif_emp().getDescripcion());
		} else {
			ds.fieldValue("oid_val_clasif_emp", "");
			ds.fieldValue("cod_val_clasif_emp", "");
			ds.fieldValue("desc_val_clasif_emp", "");
		}
		if (histPuesto.getVal_clasif_sec() != null) {
			ds.fieldValue("oid_val_clasif_sec", histPuesto.getVal_clasif_sec().getOIDInteger());
			ds.fieldValue("cod_val_clasif_sec", histPuesto.getVal_clasif_sec().getCodigo());
			ds.fieldValue("desc_val_clasif_sec", histPuesto.getVal_clasif_sec().getDescripcion());
		} else {
			ds.fieldValue("oid_val_clasif_sec", "");
			ds.fieldValue("cod_val_clasif_sec", "");
			ds.fieldValue("desc_val_clasif_sec", "");
		}
	}

	private IDataSet getDataSetHistPuestos() {
		IDataSet dataset = new TDataSet();
		dataset.create("THistPuestos");
		dataset.fieldDef(new Field("oid_hist_puesto", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_val_clasif_pue", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_val_clasif_pue", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_val_clasif_pue", Field.STRING, 100));
		dataset.fieldDef(new Field("fec_desde", Field.DATE, 0));
		dataset.fieldDef(new Field("ant_fec_desde", Field.STRING, 100));
		dataset.fieldDef(new Field("oid_legajo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("oid_val_clasif_emp", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_val_clasif_emp", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_val_clasif_emp", Field.STRING, 100));
		dataset.fieldDef(new Field("oid_val_clasif_sec", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_val_clasif_sec", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_val_clasif_sec", Field.STRING, 100));
		return dataset;
	}

	private IDataSet getDataSetCartasDocRemitidas() {
		IDataSet dataset = new TDataSet();
		dataset.create("TCartasDocRemitidas");
		dataset.fieldDef(new Field("oid_carta_remitida", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nro_orden", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_legajo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nro_carta_doc", Field.STRING, 50));
		dataset.fieldDef(new Field("fecha", Field.DATE, 0));
		dataset.fieldDef(new Field("oid_tipo_causa", Field.INTEGER, 0));
		dataset.fieldDef(new Field("causa", Field.MEMO, 0));
		dataset.fieldDef(new Field("recibido", Field.DATE, 0));
		dataset.fieldDef(new Field("observaciones", Field.MEMO, 0));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private IDataSet getDataSetMotAccesosInternos() {
		IDataSet dataset = new TDataSet();
		dataset.create("TCatAccInternos");
		dataset.fieldDef(new Field("OID_CAT_ACC_LEG", Field.INTEGER, 0));
		dataset.fieldDef(new Field("OID_CATEG_ACCESO", Field.INTEGER, 0));
		dataset.fieldDef(new Field("DESC_CATEG_ACCESO", Field.STRING, 100));
		dataset.fieldDef(new Field("OID_LEGAJO", Field.INTEGER, 0));
		dataset.fieldDef(new Field("ACTIVO", Field.BOOLEAN, 0));
		return dataset;
	}

	private void cargarRegistroCategAccInternos(IDataSet ds, Integer oidCategAccesoLeg, CategAccesoCIP categoria, Integer oidLegajo, boolean activo) throws BaseException {

		ds.append();
		ds.fieldValue("OID_CAT_ACC_LEG", oidCategAccesoLeg);
		ds.fieldValue("OID_CATEG_ACCESO", categoria.getOIDInteger());
		ds.fieldValue("DESC_CATEG_ACCESO", categoria.getDescripcion());
		ds.fieldValue("OID_LEGAJO", oidLegajo);
		ds.fieldValue("ACTIVO", activo);
	}

	private IDataSet getDataSetLabelCompetencias() {
		IDataSet dataset = new TDataSet();
		dataset.create("TLabelCompetencias");
		dataset.fieldDef(new Field("nro", Field.INTEGER, 0));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 20));
		return dataset;
	}

	private IDataSet getDataSetEvaluaciones() {
		IDataSet dataset = new TDataSet();
		dataset.create("TEvaluaciones");
		dataset.fieldDef(new Field("oid_evaluacion", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_legajo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("desc_evaluacion", Field.STRING, 100));
		dataset.fieldDef(new Field("empresa", Field.STRING, 100));
		dataset.fieldDef(new Field("sector", Field.STRING, 100));
		dataset.fieldDef(new Field("puesto", Field.STRING, 100));
		dataset.fieldDef(new Field("fec_desde", Field.DATE, 0));
		dataset.fieldDef(new Field("fec_hasta", Field.DATE, 0));
		dataset.fieldDef(new Field("fec_evaluacion", Field.DATE, 0));
		dataset.fieldDef(new Field("vigente", Field.STRING, 2));
		dataset.fieldDef(new Field("puntaje", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("compe_1", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("compe_2", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("compe_3", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("compe_4", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("compe_5", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("compe_6", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("compe_7", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("compe_8", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("compe_9", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("compe_10", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("compe_11", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("compe_12", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("compe_13", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("compe_14", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("compe_15", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("compe_16", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("compe_17", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("compe_18", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("compe_19", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("compe_20", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("compe_21", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("compe_22", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("compe_23", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("compe_24", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("compe_25", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("compe_26", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("compe_27", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("compe_28", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("compe_29", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("compe_30", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("compe_31", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("compe_32", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("compe_33", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("compe_34", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("compe_35", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("compe_36", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("compe_37", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("compe_38", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("compe_39", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("compe_40", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("compe_41", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("compe_42", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("compe_43", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("compe_44", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("compe_45", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("compe_46", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("compe_47", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("compe_48", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("compe_49", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("compe_50", Field.CURRENCY, 0));
		return dataset;
	}
	
	private void cargarCalcIntJuicio(IDataSet dataset, JuicioCalcInt juicioCalcInt) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_calc_int", juicioCalcInt.getOIDInteger());
		dataset.fieldValue("oid_juicio", juicioCalcInt.getJuicio().getOIDInteger());
		dataset.fieldValue("fec_desde", juicioCalcInt.getFec_desde());
		dataset.fieldValue("fec_hasta", juicioCalcInt.getFec_hasta());
		dataset.fieldValue("tipo_tasa", juicioCalcInt.getTipo_tasa());
		dataset.fieldValue("porc", juicioCalcInt.getPorc());
		dataset.fieldValue("interes", juicioCalcInt.getInteres());
		dataset.fieldValue("activo", juicioCalcInt.isActivo());
		
	}
	
	private IDataSet getDataSetCalcInteres() {
		IDataSet dataset = new TDataSet();
		dataset.create("TCalcInteres");
		dataset.fieldDef(new Field("oid_calc_int", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_juicio", Field.INTEGER, 0));
		dataset.fieldDef(new Field("fec_desde", Field.DATE, 0));
		dataset.fieldDef(new Field("fec_hasta", Field.DATE, 0));
		dataset.fieldDef(new Field("tipo_tasa", Field.STRING, 10));
		dataset.fieldDef(new Field("porc", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("interes", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private IDataSet getDataSetJuicio() {
		IDataSet dataset = new TDataSet();
		dataset.create("TJuicio");
		dataset.fieldDef(new Field("oid_juicio", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_tipo_reclamo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("fec_rec_dem", Field.DATE, 0));
		dataset.fieldDef(new Field("oid_juzgado", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nro_juzgado", Field.STRING, 50));
		dataset.fieldDef(new Field("nombre_juzgado", Field.STRING, 255));
		dataset.fieldDef(new Field("nro_expediente", Field.STRING, 50));
		dataset.fieldDef(new Field("monto_reclamo", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("monto_interes", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("prob_resultado", Field.STRING, 10));
		dataset.fieldDef(new Field("porc_prevision", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("oid_est_procesal", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_est_juicio", Field.INTEGER, 0));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("monto_acuerdo", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("monto_letrado", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("monto_honorario", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("monto_perito", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("tasa_justicia", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("total", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("pagado", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("saldo", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("fec_pago", Field.DATE, 0));
		dataset.fieldDef(new Field("observaciones", Field.STRING, 4000));
		dataset.fieldDef(new Field("oid_peri_mens_prev", Field.INTEGER, 0));
		dataset.fieldDef(new Field("prevision", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("oid_abogado", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_legajo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("abogado", Field.STRING, 100));
		dataset.fieldDef(new Field("periodo", Field.STRING, 7));
		dataset.fieldDef(new Field("cbu", Field.STRING, 50));
		dataset.fieldDef(new Field("embargo", Field.DOUBLE, 0));
		dataset.fieldDef(new Field("estimado", Field.DOUBLE, 0));
		dataset.fieldDef(new Field("oid_resul_juicio", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo_interno", Field.STRING, 50));
		dataset.fieldDef(new Field("fec_novedad", Field.DATE, 0));
		dataset.fieldDef(new Field("oid_tipo_pericia", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_fuero", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_comp_seg_cau", Field.INTEGER, 0));
		dataset.fieldDef(new Field("caratula", Field.STRING, 250));
		dataset.fieldDef(new Field("porc_incapacidad", Field.DOUBLE, 0));
		dataset.fieldDef(new Field("porc_letrado", Field.DOUBLE, 0));
		dataset.fieldDef(new Field("porc_perito", Field.DOUBLE, 0));
		dataset.fieldDef(new Field("porc_tasa_just", Field.DOUBLE, 0));
		dataset.fieldDef(new Field("primera_instancia", Field.STRING, 4000));
		dataset.fieldDef(new Field("segunda_instancia", Field.STRING, 4000));
		return dataset;
	}

	private IDataSet getDataSetLegajos() {
		IDataSet dataset = new TDataSet();
		dataset.create("TLegajos");
		dataset.fieldDef(new Field("oid_legajo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nro_legajo", Field.STRING, 50));
		dataset.fieldDef(new Field("nombre", Field.STRING, 50));
		dataset.fieldDef(new Field("apellido", Field.STRING, 50));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("fec_ingreso", Field.DATE, 0));
		dataset.fieldDef(new Field("ant_fec_ingreso", Field.STRING, 100));
		dataset.fieldDef(new Field("fec_retiro", Field.DATE, 0));
		dataset.fieldDef(new Field("ant_fec_retiro", Field.STRING, 100));
		dataset.fieldDef(new Field("id_identificacion", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_grupo_puerta_ingreso", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_grupo_puerta_ingreso", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_grupo_puerta_ingreso", Field.STRING, 100));
		dataset.fieldDef(new Field("oid_grupo_puerta_egreso", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_grupo_puerta_egreso", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_grupo_puerta_egreso", Field.STRING, 100));
		dataset.fieldDef(new Field("oid_estado", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_estado", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_estado", Field.STRING, 100));
		dataset.fieldDef(new Field("oid_perm_semenal", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_perm_semenal", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_perm_semenal", Field.STRING, 100));
		dataset.fieldDef(new Field("act_anti_pass_back", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("fec_ult_paso", Field.DATE, 0));
		dataset.fieldDef(new Field("hor_ult_paso", Field.STRING, 5));
		dataset.fieldDef(new Field("sentido_paso", Field.STRING, 1));
		dataset.fieldDef(new Field("ignorar_prox_apb", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("circuito_chequeo", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("oid_zona_actual", Field.INTEGER, 0));
		dataset.fieldDef(new Field("desc_zona_actual", Field.STRING, 100));
		dataset.fieldDef(new Field("lib_ing_al_predio", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("prohibir_acceso", Field.BOOLEAN, 0));

		dataset.fieldDef(new Field("CUIL", Field.STRING, 50));
		dataset.fieldDef(new Field("SEXO", Field.STRING, 1));
		dataset.fieldDef(new Field("oid_estado_civil", Field.INTEGER, 0));
		dataset.fieldDef(new Field("fec_nacimiento", Field.DATE, 0));
		dataset.fieldDef(new Field("edad", Field.STRING, 100));
		dataset.fieldDef(new Field("oid_tipo_docu", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nro_documento", Field.STRING, 50));
		dataset.fieldDef(new Field("telefono", Field.STRING, 50));
		dataset.fieldDef(new Field("telefono_celular", Field.STRING, 50));
		dataset.fieldDef(new Field("oid_clase_sind", Field.INTEGER, 0));
		dataset.fieldDef(new Field("fec_ant_rec", Field.DATE, 0));
		dataset.fieldDef(new Field("ant_fec_ant_rec", Field.STRING, 100));
		dataset.fieldDef(new Field("oid_mot_egreso", Field.INTEGER, 0));
		dataset.fieldDef(new Field("fec_venc_prot", Field.DATE, 0));
		dataset.fieldDef(new Field("fec_ing_ute", Field.DATE, 0));
		dataset.fieldDef(new Field("ant_fec_ing_ute", Field.STRING, 100));
		dataset.fieldDef(new Field("direccion", Field.STRING, 100));
		dataset.fieldDef(new Field("oid_grado_legajo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_grado_leg", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_grado_leg", Field.STRING, 100));
		dataset.fieldDef(new Field("oid_est_desa", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_est_desa", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_est_desa", Field.STRING, 100));
		dataset.fieldDef(new Field("segui_legales", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("segui_cartas_docu", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("oid_tarea_desemp", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_tarea_desemp", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_tarea_desemp", Field.STRING, 100));

		return dataset;
	}

	private void cargarRegNovedad(IDataSet dataset, NovedadLegajo aNovedad) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_novedad", aNovedad.getOIDInteger());
		dataset.fieldValue("nro_ext", aNovedad.getNro_ext());
		if (aNovedad.getOid_tipo_novedad() != null)
			dataset.fieldValue("oid_tipo_novedad", aNovedad.getOid_tipo_novedad().getOIDInteger());
		else
			dataset.fieldValue("oid_tipo_novedad", "");
		if (aNovedad.getMotivo_tipo_nov() != null)
			dataset.fieldValue("oid_mot_tipo_nov", aNovedad.getMotivo_tipo_nov().getOIDInteger());
		else
			dataset.fieldValue("oid_mot_tipo_nov", "");
		if (aNovedad.getFecha()!=null)
			dataset.fieldValue("fecha", aNovedad.getFecha());
		else
			dataset.fieldValue("fecha", Fecha.FECHA_NULA());
		dataset.fieldValue("hora_desde", aNovedad.getHora_desde());
		dataset.fieldValue("hora_hasta", aNovedad.getHora_hasta());
		dataset.fieldValue("activo", aNovedad.isActivo());
		
		if (aNovedad.getObservacion()!=null)
			dataset.fieldValue("observacion", aNovedad.getObservacion().replace("\n", " ").replace("\r", " "));
		else
			dataset.fieldValue("observacion", "");
		if (aNovedad.getOid_legajo()!=null)
			dataset.fieldValue("oid_legajo", aNovedad.getOid_legajo().getOID());
		else
			dataset.fieldValue("oid_legajo", "");
		if (aNovedad.getMotivo_tipo_nov() != null) {
			dataset.fieldValue("cod_mot_tipo_nov", aNovedad.getMotivo_tipo_nov().getCodigo());
			dataset.fieldValue("desc_mot_tipo_nov", aNovedad.getMotivo_tipo_nov().getDescripcion());
		} else {
			dataset.fieldValue("cod_mot_tipo_nov", "");
			dataset.fieldValue("desc_mot_tipo_nov", "");
		}
		
	}

	private void cargarRegJuicio(IDataSet ds, Juicio juicio) throws BaseException {
		ds.append();
		ds.fieldValue("oid_juicio", juicio.getOIDInteger());
		if (juicio.getTipo_reclamo() != null)
			ds.fieldValue("oid_tipo_reclamo", juicio.getTipo_reclamo().getOIDInteger());
		else
			ds.fieldValue("oid_tipo_reclamo", "");
		ds.fieldValue("fec_rec_dem", juicio.getFec_rec_dem());
		if (juicio.getJuzgado() != null) {
			ds.fieldValue("oid_juzgado", juicio.getJuzgado().getOIDInteger());
			ds.fieldValue("nro_juzgado", juicio.getJuzgado().getNro());
			ds.fieldValue("nombre_juzgado", juicio.getJuzgado().getDireccion());
		} else {
			ds.fieldValue("oid_juzgado", "");
			ds.fieldValue("nro_juzgado", "");
			ds.fieldValue("nombre_juzgado", "");
		}
		ds.fieldValue("nro_expediente", juicio.getNro_expediente());
		ds.fieldValue("monto_reclamo", juicio.getMonto_reclamo());
		ds.fieldValue("monto_interes", juicio.getMontoIntereses());
		ds.fieldValue("prob_resultado", juicio.getProb_resultado());
		ds.fieldValue("porc_prevision", juicio.getPorc_prevision());
		if (juicio.getEstado_procesal() != null)
			ds.fieldValue("oid_est_procesal", juicio.getEstado_procesal().getOIDInteger());
		else
			ds.fieldValue("oid_est_procesal", "");
		if (juicio.getEstado_juicio() != null)
			ds.fieldValue("oid_est_juicio", juicio.getEstado_juicio().getOIDInteger());
		else
			ds.fieldValue("oid_est_juicio", "");
		ds.fieldValue("activo", juicio.isActivo());
		ds.fieldValue("monto_acuerdo", juicio.getMontoAcuerdo());
		ds.fieldValue("monto_letrado", juicio.getMontoLetrado());
		ds.fieldValue("monto_honorario", juicio.getMontoConciliador());
		ds.fieldValue("monto_perito", juicio.getMontoPerito());
		ds.fieldValue("tasa_justicia", juicio.getMontoTasaJusticia());
		
		Money total = juicio.getTotalAPagar();
		Money pagado = juicio.getTotalPagado();
		
		CalculadorMoney calcSaldo = new CalculadorMoney(total);
		calcSaldo.restar(pagado);
		
		ds.fieldValue("total", total);
		ds.fieldValue("pagado", pagado);
		ds.fieldValue("saldo", calcSaldo.getResultMoney());
		
		ds.fieldValue("fec_pago", juicio.getFec_pago());
		ds.fieldValue("observaciones", juicio.getObservaciones());
		if (juicio.getPeriodo_mensual() != null)
			ds.fieldValue("oid_peri_mens_prev", juicio.getPeriodo_mensual().getOID());
		else
			ds.fieldValue("oid_peri_mens_prev", "");
		ds.fieldValue("prevision", juicio.getPrevision());
		if (juicio.getAbogado() != null)
			ds.fieldValue("oid_abogado", juicio.getAbogado().getOIDInteger());
		else
			ds.fieldValue("oid_abogado", "");
		if (juicio.getLegajo() != null)
			ds.fieldValue("oid_legajo", juicio.getLegajo().getOIDInteger());
		else
			ds.fieldValue("oid_legajo", "");
		if (juicio.getAbogado() != null)
			ds.fieldValue("abogado", juicio.getAbogado().getApeyNom());
		else
			ds.fieldValue("abogado", "");
		if (juicio.getPeriodo_mensual() != null)
			ds.fieldValue("periodo", juicio.getPeriodo_mensual().getCodigo());
		else
			ds.fieldValue("periodo", "");
		ds.fieldValue("cbu", juicio.getCBU());
		ds.fieldValue("embargo", juicio.getEmbargo());
		ds.fieldValue("estimado", juicio.getEstimado());
		if (juicio.getResultadoJuicio() != null)
			ds.fieldValue("oid_resul_juicio", juicio.getResultadoJuicio().getOIDInteger());
		else
			ds.fieldValue("oid_resul_juicio", "");
		ds.fieldValue("codigo_interno", juicio.getCodigoInterno());
		ds.fieldValue("fec_novedad", juicio.getFecNovedad());
		if (juicio.getTipoPericia()!=null)
			ds.fieldValue("oid_tipo_pericia", juicio.getTipoPericia().getOIDInteger());
		else
			ds.fieldValue("oid_tipo_pericia", "");
		if (juicio.getFuero()!=null)
			ds.fieldValue("oid_fuero", juicio.getFuero().getOIDInteger());
		else
			ds.fieldValue("oid_fuero", "");
		
		if (juicio.getCompaniaSeguroCaucion()!=null)
			ds.fieldValue("oid_comp_seg_cau", juicio.getCompaniaSeguroCaucion().getOIDInteger());
		else
			ds.fieldValue("oid_comp_seg_cau", "");
		
		ds.fieldValue("caratula", juicio.getCaratula());
		ds.fieldValue("porc_incapacidad", juicio.getPorcIncapacidad());
		ds.fieldValue("porc_letrado", juicio.getPorcLetrado());
		ds.fieldValue("porc_perito", juicio.getPorcPerito());
		ds.fieldValue("porc_tasa_just", juicio.getPorcTasaJusticia());
		
		ds.fieldValue("primera_instancia", juicio.getPrimeraInstancia());
		ds.fieldValue("segunda_instancia", juicio.getSegundaInstancia());
		
		

	}

	private void cargarRegPedMed(IDataSet dataset, ServicioMedicoRRHH pedidoMedico) throws BaseException {

		dataset.append();
		dataset.fieldValue("oid_serv_medico", pedidoMedico.getOIDInteger());
		if (pedidoMedico.getLegajo() != null)
			dataset.fieldValue("oid_legajo", pedidoMedico.getLegajo().getOIDInteger());
		else
			dataset.fieldValue("oid_legajo", "");
		dataset.fieldValue("tipo_serv_med", pedidoMedico.getTipo_serv_med());
		dataset.fieldValue("nro_nov_sist_ext", pedidoMedico.getNro_nov_sist_ext());
		dataset.fieldValue("fec_inicio", pedidoMedico.getFec_inicio());
		dataset.fieldValue("fec_final", pedidoMedico.getFec_final());
		dataset.fieldValue("dias", pedidoMedico.getDias());
		if (pedidoMedico.getMotivo_visita_fallo() != null)
			dataset.fieldValue("oid_mot_vis_fall", pedidoMedico.getMotivo_visita_fallo().getOIDInteger());
		else
			dataset.fieldValue("oid_mot_vis_fall", "");
		if (pedidoMedico.getAparato() != null)
			dataset.fieldValue("oid_aparato", pedidoMedico.getAparato().getOIDInteger());
		else
			dataset.fieldValue("oid_aparato", "");
		if (pedidoMedico.getEnfermedad() != null)
			dataset.fieldValue("oid_enfermedad", pedidoMedico.getEnfermedad().getOIDInteger());
		else
			dataset.fieldValue("oid_enfermedad", "");
		if (pedidoMedico.getPrestador_medico() != null)
			dataset.fieldValue("oid_prest_med", pedidoMedico.getPrestador_medico().getOIDInteger());
		else
			dataset.fieldValue("oid_prest_med", "");
		dataset.fieldValue("sintoma", pedidoMedico.getSintoma());
		dataset.fieldValue("observacion", pedidoMedico.getObservacion());
		dataset.fieldValue("justifica", pedidoMedico.isJustifica());
		dataset.fieldValue("activo", pedidoMedico.isActivo());
		dataset.fieldValue("fec_control", pedidoMedico.getFecControl());

	}

	private void cargarRegistroLegajos(IDataSet dataset, Integer oidLegajo, String nroLegajo, String nombre, String apellido, Boolean activo, java.util.Date fecIngreso, java.util.Date fecRetiro,
			Integer idIdentificacion, GrupoPuerta grupoPuertaIngreso, GrupoPuerta grupoPuertaEgreso, EstadoCIP estado, PermisoSemanalCIP permisoSemanal, Boolean actAntiPassBack,
			java.util.Date fecUltPaso, String horUltPaso, String sentidoPaso, Boolean ignorarProxAntiPassBack, Boolean circuitoChequeo, ZonaCIP zonaActual, boolean libIngAlPredio,
			boolean prohibirAcceso, Legajo legajo , TareaDesempeneada tareaDesemp) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_legajo", oidLegajo);
		dataset.fieldValue("nro_legajo", nroLegajo);
		dataset.fieldValue("nombre", nombre);
		dataset.fieldValue("apellido", apellido);
		dataset.fieldValue("activo", activo);
		dataset.fieldValue("fec_ingreso", fecIngreso);
		dataset.fieldValue("ant_fec_ingreso", Fecha.getLabelAntiguedad(fecIngreso));
		dataset.fieldValue("fec_retiro", fecRetiro);
		dataset.fieldValue("ant_fec_retiro", Fecha.getLabelAntiguedad(fecRetiro));
		dataset.fieldValue("id_identificacion", idIdentificacion);
		if (grupoPuertaIngreso != null) {
			dataset.fieldValue("oid_grupo_puerta_ingreso", grupoPuertaIngreso.getOIDInteger());
			dataset.fieldValue("cod_grupo_puerta_ingreso", grupoPuertaIngreso.getCodigo());
			dataset.fieldValue("desc_grupo_puerta_ingreso", grupoPuertaIngreso.getDescripcion());
		} else {
			dataset.fieldValue("oid_grupo_puerta_ingreso", "");
			dataset.fieldValue("cod_grupo_puerta_ingreso", "");
			dataset.fieldValue("desc_grupo_puerta_ingreso", "");
		}

		if (grupoPuertaEgreso != null) {
			dataset.fieldValue("oid_grupo_puerta_egreso", grupoPuertaEgreso.getOIDInteger());
			dataset.fieldValue("cod_grupo_puerta_egreso", grupoPuertaEgreso.getCodigo());
			dataset.fieldValue("desc_grupo_puerta_egreso", grupoPuertaEgreso.getDescripcion());
		} else {
			dataset.fieldValue("oid_grupo_puerta_egreso", "");
			dataset.fieldValue("cod_grupo_puerta_egreso", "");
			dataset.fieldValue("desc_grupo_puerta_egreso", "");
		}

		if (estado != null) {
			dataset.fieldValue("oid_estado", estado.getOIDInteger());
			dataset.fieldValue("cod_estado", estado.getCodigo());
			dataset.fieldValue("desc_estado", estado.getDescripcion());
		} else {
			dataset.fieldValue("oid_estado", "");
			dataset.fieldValue("cod_estado", "");
			dataset.fieldValue("desc_estado", "");
		}

		if (permisoSemanal != null) {
			dataset.fieldValue("oid_perm_semenal", permisoSemanal.getOIDInteger());
			dataset.fieldValue("cod_perm_semenal", permisoSemanal.getCodigo());
			dataset.fieldValue("desc_perm_semenal", permisoSemanal.getDescripcion());
		} else {
			dataset.fieldValue("oid_perm_semenal", "");
			dataset.fieldValue("cod_perm_semenal", "");
			dataset.fieldValue("desc_perm_semenal", "");
		}

		dataset.fieldValue("act_anti_pass_back", actAntiPassBack);
		dataset.fieldValue("fec_ult_paso", fecUltPaso);
		dataset.fieldValue("hor_ult_paso", horUltPaso);
		dataset.fieldValue("sentido_paso", sentidoPaso);
		dataset.fieldValue("ignorar_prox_apb", ignorarProxAntiPassBack);

		dataset.fieldValue("circuito_chequeo", circuitoChequeo);

		if (zonaActual != null) {
			dataset.fieldValue("oid_zona_actual", zonaActual.getOIDInteger());
			dataset.fieldValue("desc_zona_actual", zonaActual.getDescripcion());
		} else {
			dataset.fieldValue("oid_zona_actual", "");
			dataset.fieldValue("desc_zona_actual", "");
		}

		dataset.fieldValue("lib_ing_al_predio", libIngAlPredio);
		dataset.fieldValue("prohibir_acceso", prohibirAcceso);

		dataset.fieldValue("CUIL", legajo.getCUIT());
		dataset.fieldValue("SEXO", legajo.getSEXO());
		if (legajo.getEstadoCivil() != null)
			dataset.fieldValue("oid_estado_civil", legajo.getEstadoCivil().getOIDInteger());
		else
			dataset.fieldValue("oid_estado_civil", "");
		dataset.fieldValue("fec_nacimiento", legajo.getFecNacimiento());
		dataset.fieldValue("edad", Fecha.getLabelAntiguedad(legajo.getFecNacimiento()));
		if (legajo.getTipoDocumento() != null)
			dataset.fieldValue("oid_tipo_docu", legajo.getTipoDocumento().getOIDInteger());
		else
			dataset.fieldValue("oid_tipo_docu", "");
		dataset.fieldValue("nro_documento", legajo.getNroDocumento());
		dataset.fieldValue("telefono", legajo.getTelefono());
		dataset.fieldValue("telefono_celular", legajo.getTelefonoCelular());
		if (legajo.getClaseSindicato() != null)
			dataset.fieldValue("oid_clase_sind", legajo.getClaseSindicato().getOIDInteger());
		else
			dataset.fieldValue("oid_clase_sind", "");
		dataset.fieldValue("fec_ant_rec", legajo.getFecAntReconocimiento());
		dataset.fieldValue("ant_fec_ant_rec", Fecha.getLabelAntiguedad(legajo.getFecAntReconocimiento()));
		if (legajo.getMotivoEgresoEmp() != null)
			dataset.fieldValue("oid_mot_egreso", legajo.getMotivoEgresoEmp().getOIDInteger());
		else
			dataset.fieldValue("oid_mot_egreso", "");
		dataset.fieldValue("fec_venc_prot", legajo.getFecVencProteccion());
		dataset.fieldValue("fec_ing_ute", legajo.getIngresoUTE());
		dataset.fieldValue("ant_fec_ing_ute", Fecha.getLabelAntiguedad(legajo.getIngresoUTE()));
		dataset.fieldValue("direccion", legajo.getDireccion());
		if (legajo.getGradoLegajo() != null) {
			dataset.fieldValue("oid_grado_legajo", legajo.getGradoLegajo().getOIDInteger());
			dataset.fieldValue("cod_grado_leg", legajo.getGradoLegajo().getCodigo());
			dataset.fieldValue("desc_grado_leg", legajo.getGradoLegajo().getDescripcion());
		} else {
			dataset.fieldValue("oid_grado_legajo", "");
			dataset.fieldValue("cod_grado_leg", "");
			dataset.fieldValue("desc_grado_leg", "");
		}

		if (legajo.getEstadoDesarrollo() != null) {
			dataset.fieldValue("oid_est_desa", legajo.getEstadoDesarrollo().getOIDInteger());
			dataset.fieldValue("cod_est_desa", legajo.getEstadoDesarrollo().getCodigo());
			dataset.fieldValue("desc_est_desa", legajo.getEstadoDesarrollo().getDescripcion());
		} else {
			dataset.fieldValue("oid_est_desa", "");
			dataset.fieldValue("cod_est_desa", "");
			dataset.fieldValue("desc_est_desa", "");
		}
		
		dataset.fieldValue("segui_legales" , legajo.isSeguiLegales());
		dataset.fieldValue("segui_cartas_docu" , legajo.isSeguiCartasDocu());
		
		if (tareaDesemp!=null) {
			dataset.fieldValue("oid_tarea_desemp", tareaDesemp.getOIDInteger());
			dataset.fieldValue("cod_tarea_desemp", tareaDesemp.getCodigo());
			dataset.fieldValue("desc_tarea_desemp", tareaDesemp.getDescripcion());
		} else {
			dataset.fieldValue("oid_tarea_desemp", "");
			dataset.fieldValue("cod_tarea_desemp", "");
			dataset.fieldValue("desc_tarea_desemp", "");			
		}

	}

	private IDataSet getDataSetSanciones() throws BaseException {

		IDataSet dataset = new TDataSet();
		dataset.create("TSancionesLegajo");
		dataset.fieldDef(new Field("oid_sanc_leg", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_legajo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_mot_falta", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_mot_sancion", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nro_sancion", Field.INTEGER, 0));
		dataset.fieldDef(new Field("fecha", Field.DATE, 0));
		dataset.fieldDef(new Field("fec_susp_desde", Field.DATE, 0));
		dataset.fieldDef(new Field("fec_reintegro", Field.DATE, 0));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}
	
	private IDataSet getDataSetNegociacionLegales() { 
		    IDataSet dataset = new TDataSet(); 
		    dataset.create("TNegociaciones");
		    dataset.fieldDef(new Field("oid_negociacion", Field.INTEGER, 0)); 
		    dataset.fieldDef(new Field("oid_legajo", Field.INTEGER, 0)); 
		    dataset.fieldDef(new Field("fecha", Field.INTEGER, 0)); 
		    dataset.fieldDef(new Field("observacion", Field.STRING, 0)); 
		    dataset.fieldDef(new Field("monto", Field.STRING, 0)); 
		    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
		    return dataset;
	}
	
	private void cargarRegistroNegociacionLegales(IDataSet dataset,
			  NegociacionLegales negociacion) throws BaseException {
			dataset.append(); 
			dataset.fieldValue("oid_negociacion", negociacion.getOIDInteger());
			dataset.fieldValue("oid_legajo", negociacion.getLegajo().getOIDInteger());
			dataset.fieldValue("fecha", negociacion.getFecha());
			dataset.fieldValue("observacion", negociacion.getObservacion());
			dataset.fieldValue("monto", negociacion.getMonto());
			dataset.fieldValue("activo", negociacion.isActivo());
	}	

	private void cargarSanciones(IDataSet dsSanciones, SancionesLegajo sancionLegajo) throws BaseException {
		dsSanciones.append();
		dsSanciones.fieldValue("oid_sanc_leg", sancionLegajo.getOIDInteger());
		dsSanciones.fieldValue("oid_legajo", sancionLegajo.getLegajo().getOIDInteger());
		if (sancionLegajo.getMotivo_falta() != null)
			dsSanciones.fieldValue("oid_mot_falta", sancionLegajo.getMotivo_falta().getOIDInteger());
		else
			dsSanciones.fieldValue("oid_mot_falta", "");
		if (sancionLegajo.getMotivo_sancion() != null)
			dsSanciones.fieldValue("oid_mot_sancion", sancionLegajo.getMotivo_sancion().getOIDInteger());
		else
			dsSanciones.fieldValue("oid_mot_sancion", "");
		dsSanciones.fieldValue("nro_sancion", sancionLegajo.getNro_sancion());
		dsSanciones.fieldValue("fecha", sancionLegajo.getFecha());
		dsSanciones.fieldValue("fec_susp_desde", sancionLegajo.getFec_susp_desde());
		dsSanciones.fieldValue("fec_reintegro", sancionLegajo.getFec_reintegro());
		dsSanciones.fieldValue("activo", sancionLegajo.isActivo());
	}

	private IDataSet getDataSetPedMed() {
		IDataSet dataset = new TDataSet();
		dataset.create("TPedidosMedicos");
		dataset.fieldDef(new Field("oid_serv_medico", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_legajo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("tipo_serv_med", Field.STRING, 20));
		dataset.fieldDef(new Field("nro_nov_sist_ext", Field.INTEGER, 0));
		dataset.fieldDef(new Field("fec_inicio", Field.DATE, 0));
		dataset.fieldDef(new Field("fec_final", Field.DATE, 0));
		dataset.fieldDef(new Field("dias", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_mot_vis_fall", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_aparato", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_enfermedad", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_prest_med", Field.INTEGER, 0));
		dataset.fieldDef(new Field("sintoma", Field.STRING, 5000));
		dataset.fieldDef(new Field("observacion", Field.MEMO, 0));
		dataset.fieldDef(new Field("justifica", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("fec_control", Field.DATE, 0));
		return dataset;
	}

	private void cargarRegAteMed(IDataSet dataset, ServicioMedicoRRHH pedidoMedico) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_ate_med", pedidoMedico.getOIDInteger());
		if (pedidoMedico.getLegajo() != null)
			dataset.fieldValue("oid_legajo", pedidoMedico.getLegajo().getOIDInteger());
		else
			dataset.fieldValue("oid_legajo", "");
		dataset.fieldValue("tipo_serv_med", pedidoMedico.getTipo_serv_med());
		dataset.fieldValue("nro_nov_sist_ext", pedidoMedico.getNro_nov_sist_ext());
		dataset.fieldValue("fec_inicio", pedidoMedico.getFec_inicio());
		dataset.fieldValue("fec_final", pedidoMedico.getFec_final());
		dataset.fieldValue("dias", pedidoMedico.getDias());
		if (pedidoMedico.getAparato() != null)
			dataset.fieldValue("oid_aparato", pedidoMedico.getAparato().getOIDInteger());
		else
			dataset.fieldValue("oid_aparato", "");
		if (pedidoMedico.getEnfermedad() != null)
			dataset.fieldValue("oid_enfermedad", pedidoMedico.getEnfermedad().getOIDInteger());
		else
			dataset.fieldValue("oid_enfermedad", "");
		dataset.fieldValue("sintoma", pedidoMedico.getSintoma());
		dataset.fieldValue("observacion", pedidoMedico.getObservacion());
		dataset.fieldValue("activo", pedidoMedico.isActivo());
		dataset.fieldValue("fec_ate_med", pedidoMedico.getFecAteMed());
		if (pedidoMedico.getMedico() != null)
			dataset.fieldValue("oid_medico", pedidoMedico.getMedico().getOIDInteger());
		else
			dataset.fieldValue("oid_medico", "");
		dataset.fieldValue("fec_control", pedidoMedico.getFecControl());
	}

	private void cargarRegSeclo(IDataSet dsSeclo, Seclo aSeclo) throws BaseException {

		dsSeclo.append();
		dsSeclo.fieldValue("oid_seclo", aSeclo.getOIDInteger());
		dsSeclo.fieldValue("oid_legajo", aSeclo.getLegajo().getOIDInteger());
		dsSeclo.fieldValue("fec_recepcion", aSeclo.getFec_recepcion());
		if (aSeclo.getTipo_reclamo() != null)
			dsSeclo.fieldValue("oid_tipo_reclamo", aSeclo.getTipo_reclamo().getOIDInteger());
		else
			dsSeclo.fieldValue("oid_tipo_reclamo", "");
		dsSeclo.fieldValue("monto_reclamo", aSeclo.getMonto_reclamo());
		dsSeclo.fieldValue("observaciones", aSeclo.getObservaciones());
		dsSeclo.fieldValue("activo", aSeclo.isActivo());
		if (aSeclo.getEstado_seclo() != null)
			dsSeclo.fieldValue("oid_estado_seclo", aSeclo.getEstado_seclo().getOIDInteger());
		else
			dsSeclo.fieldValue("oid_estado_seclo", "");

		CalculadorMoney totAPagar = new CalculadorMoney(new Money(0));
		if (aSeclo.getMonto_acuerdo() != null)
			totAPagar.sumar(aSeclo.getMonto_acuerdo());
		if (aSeclo.getHono_letrado() != null)
			totAPagar.sumar(aSeclo.getHono_letrado());
		if (aSeclo.getHono_conciliado() != null)
			totAPagar.sumar(aSeclo.getHono_conciliado());
		if (aSeclo.getOtros_hono() != null)
			totAPagar.sumar(aSeclo.getOtros_hono());
		dsSeclo.fieldValue("monto_acuerdo", aSeclo.getMonto_acuerdo());
		dsSeclo.fieldValue("hono_letrado", aSeclo.getHono_letrado());
		dsSeclo.fieldValue("hono_conciliado", aSeclo.getHono_conciliado());
		dsSeclo.fieldValue("otros_hono", aSeclo.getOtros_hono());
		dsSeclo.fieldValue("pagado", aSeclo.getPagado());
		dsSeclo.fieldValue("saldado", aSeclo.isSaldado());
		dsSeclo.fieldValue("a_pagar", totAPagar.getResult());
		dsSeclo.fieldValue("codigo_interno", aSeclo.getCodigoInterno());
		dsSeclo.fieldValue("tipo" , aSeclo.getTipo());
		if (aSeclo.getFormaExtincion()!=null)
			dsSeclo.fieldValue("oid_forma_exti", aSeclo.getFormaExtincion().getOIDInteger());
		else
			dsSeclo.fieldValue("oid_forma_exti", "");
		
		dsSeclo.fieldValue("fec_novedad", aSeclo.getFechaNovedad());
		dsSeclo.fieldValue("causal_acuerdo", aSeclo.getCausaAcuerdo());	
		

	}

	private void cargarRegAccLab(IDataSet dataset, ServicioMedicoRRHH pedidoMedico) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_acc_lab", pedidoMedico.getOIDInteger());
		if (pedidoMedico.getLegajo() != null)
			dataset.fieldValue("oid_legajo", pedidoMedico.getLegajo().getOIDInteger());
		else
			dataset.fieldValue("oid_legajo", "");
		dataset.fieldValue("tipo_serv_med", pedidoMedico.getTipo_serv_med());
		dataset.fieldValue("nro_nov_sist_ext", pedidoMedico.getNro_nov_sist_ext());
		dataset.fieldValue("fec_inicio", pedidoMedico.getFec_inicio());
		dataset.fieldValue("fec_final", pedidoMedico.getFec_final());
		dataset.fieldValue("dias", pedidoMedico.getDias());

		dataset.fieldValue("fec_accidente", pedidoMedico.getFecAccidente());
		dataset.fieldValue("desc_accidente", pedidoMedico.getDescAccidente());

		if (pedidoMedico.getAparato() != null)
			dataset.fieldValue("oid_aparato", pedidoMedico.getAparato().getOIDInteger());
		else
			dataset.fieldValue("oid_aparato", "");
		if (pedidoMedico.getEnfermedad() != null)
			dataset.fieldValue("oid_enfermedad", pedidoMedico.getEnfermedad().getOIDInteger());
		else
			dataset.fieldValue("oid_enfermedad", "");

		dataset.fieldValue("sintoma", pedidoMedico.getSintoma());
		dataset.fieldValue("observacion", pedidoMedico.getObservacion());
		dataset.fieldValue("activo", pedidoMedico.isActivo());
		dataset.fieldValue("fec_control", pedidoMedico.getFecControl());
	}

	private void cargarRegEnfFam(IDataSet dataset, ServicioMedicoRRHH pedidoMedico) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_enf_fam", pedidoMedico.getOIDInteger());
		if (pedidoMedico.getLegajo() != null)
			dataset.fieldValue("oid_legajo", pedidoMedico.getLegajo().getOIDInteger());
		else
			dataset.fieldValue("oid_legajo", "");
		dataset.fieldValue("tipo_serv_med", pedidoMedico.getTipo_serv_med());
		dataset.fieldValue("nro_nov_sist_ext", pedidoMedico.getNro_nov_sist_ext());
		dataset.fieldValue("fec_inicio", pedidoMedico.getFec_inicio());
		dataset.fieldValue("fec_final", pedidoMedico.getFec_final());
		dataset.fieldValue("dias", pedidoMedico.getDias());
		if (pedidoMedico.getAparato() != null)
			dataset.fieldValue("oid_aparato", pedidoMedico.getAparato().getOIDInteger());
		else
			dataset.fieldValue("oid_aparato", "");
		if (pedidoMedico.getEnfermedad() != null)
			dataset.fieldValue("oid_enfermedad", pedidoMedico.getEnfermedad().getOIDInteger());
		else
			dataset.fieldValue("oid_enfermedad", "");
		if (pedidoMedico.getFamiliar() != null)
			dataset.fieldValue("oid_familiar", pedidoMedico.getFamiliar().getOIDInteger());
		else
			dataset.fieldValue("oid_familiar", "");

		dataset.fieldValue("sintoma", pedidoMedico.getSintoma());
		dataset.fieldValue("observacion", pedidoMedico.getObservacion());
		dataset.fieldValue("activo", pedidoMedico.isActivo());
		dataset.fieldValue("justifica", pedidoMedico.isJustifica());
	}

	private IDataSet getDataSetEnfFam() {
		IDataSet dataset = new TDataSet();
		dataset.create("TEnfermedadesFam");
		dataset.fieldDef(new Field("oid_enf_fam", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_legajo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("tipo_serv_med", Field.STRING, 20));
		dataset.fieldDef(new Field("nro_nov_sist_ext", Field.INTEGER, 0));
		dataset.fieldDef(new Field("fec_inicio", Field.DATE, 0));
		dataset.fieldDef(new Field("fec_final", Field.DATE, 0));
		dataset.fieldDef(new Field("dias", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_aparato", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_enfermedad", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_familiar", Field.INTEGER, 0));
		dataset.fieldDef(new Field("sintoma", Field.STRING, 5000));
		dataset.fieldDef(new Field("observacion", Field.STRING, 5000));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("justifica", Field.BOOLEAN, 0));
		return dataset;
	}

	private IDataSet getDataSetAccLab() {
		IDataSet dataset = new TDataSet();
		dataset.create("TAccidenteLaboral");
		dataset.fieldDef(new Field("oid_acc_lab", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_legajo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("tipo_serv_med", Field.STRING, 20));
		dataset.fieldDef(new Field("nro_nov_sist_ext", Field.INTEGER, 0));
		dataset.fieldDef(new Field("fec_inicio", Field.DATE, 0));
		dataset.fieldDef(new Field("fec_final", Field.DATE, 0));
		dataset.fieldDef(new Field("dias", Field.INTEGER, 0));
		dataset.fieldDef(new Field("fec_accidente", Field.DATE, 0));
		dataset.fieldDef(new Field("desc_accidente", Field.STRING, 4000));
		dataset.fieldDef(new Field("oid_aparato", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_enfermedad", Field.INTEGER, 0));
		dataset.fieldDef(new Field("sintoma", Field.STRING, 5000));
		dataset.fieldDef(new Field("observacion", Field.STRING, 5000));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("fec_control", Field.DATE, 0));
		return dataset;
	}

	private IDataSet getDataSetAteMed() {
		IDataSet dataset = new TDataSet();
		dataset.create("TAtencionMedica");
		dataset.fieldDef(new Field("oid_ate_med", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_legajo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("tipo_serv_med", Field.STRING, 20));
		dataset.fieldDef(new Field("nro_nov_sist_ext", Field.INTEGER, 0));
		dataset.fieldDef(new Field("fec_inicio", Field.DATE, 0));
		dataset.fieldDef(new Field("fec_final", Field.DATE, 0));
		dataset.fieldDef(new Field("dias", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_aparato", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_enfermedad", Field.INTEGER, 0));
		dataset.fieldDef(new Field("sintoma", Field.STRING, 5000));
		dataset.fieldDef(new Field("observacion", Field.STRING, 5000));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("fec_ate_med", Field.DATE, 0));
		dataset.fieldDef(new Field("oid_medico", Field.INTEGER, 0));
		dataset.fieldDef(new Field("fec_control", Field.INTEGER, 0));
		return dataset;
	}

	private IDataSet getDataSetObservaciones() {
		IDataSet dataset = new TDataSet();
		dataset.create("TObservaciones");
		dataset.fieldDef(new Field("oid_obs_leg", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_legajo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_tipo_obs_leg", Field.INTEGER, 0));
		dataset.fieldDef(new Field("fecha", Field.DATE, 0));
		dataset.fieldDef(new Field("fec_carga", Field.DATE, 0));
		dataset.fieldDef(new Field("oid_usu_carga", Field.INTEGER, 0));
		dataset.fieldDef(new Field("observacion", Field.STRING, 1000));
		dataset.fieldDef(new Field("usu_alta", Field.STRING, 50));
		dataset.fieldDef(new Field("pos_neg_neu", Field.STRING, 50));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private IDataSet getDataSetRequeridos() {
		IDataSet dataset = new TDataSet();
		dataset.create("TRequeridos");
		dataset.fieldDef(new Field("oid_seclo_reque", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_seclo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_val_clasif_emp", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_val_clasif_emp", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_val_clasif_emp", Field.STRING, 100));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private IDataSet getDataSerAudJuicios() throws BaseException {
		IDataSet dataset = new TDataSet();
		dataset.create("TAudienciaJuicio");
		dataset.fieldDef(new Field("oid_aud_juicio", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_juicio", Field.INTEGER, 0));
		dataset.fieldDef(new Field("fecha", Field.DATE, 0));
		dataset.fieldDef(new Field("hora", Field.STRING, 5));
		dataset.fieldDef(new Field("persona", Field.STRING, 100));
		dataset.fieldDef(new Field("oid_tipo_aud", Field.INTEGER, 0));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}
	
	private IDataSet getDataSetJuicioRubroCondena() {
		IDataSet dataset = new TDataSet();
		dataset.create("TJuicioRubroCondena");
		dataset.fieldDef(new Field("oid_jui_rub_cond", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_juicio", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_rubro_condena", Field.INTEGER, 0));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}	

	private IDataSet getDataSetValClasif() {
		IDataSet dataset = new TDataSet();
		dataset.create("TValoresClasificadores");
		dataset.fieldDef(new Field("oid_valor_clasif", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_legajo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_clasif_ent", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_val_clasif_ent", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nro_clasif", Field.INTEGER, 0));
		dataset.fieldDef(new Field("desc_grupo_clasif", Field.STRING, 100));
		dataset.fieldDef(new Field("cod_valor", Field.STRING, 30));
		dataset.fieldDef(new Field("desc_valor", Field.STRING, 100));
		dataset.fieldDef(new Field("nickname", Field.STRING, 100));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("desc_clasificador", Field.STRING, 100));

		return dataset;
	}

	private void cargarDSValClasif(IDataSet dataset, Integer oidValorClasif, Integer oidLegajo, Integer oidClasifEnt, Integer oidValClasifEnt, Integer nroClasif, String descGrupoClasif,
			String codValor, String descValor, String nickname, Boolean activo, String descClasificador) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_valor_clasif", oidValorClasif);
		dataset.fieldValue("oid_legajo", oidLegajo);
		dataset.fieldValue("oid_clasif_ent", oidClasifEnt);
		dataset.fieldValue("oid_val_clasif_ent", oidValClasifEnt);
		dataset.fieldValue("nro_clasif", nroClasif);
		dataset.fieldValue("desc_grupo_clasif", descGrupoClasif);
		dataset.fieldValue("cod_valor", codValor);
		dataset.fieldValue("desc_valor", descValor);
		dataset.fieldValue("nickname", nickname);
		dataset.fieldValue("activo", activo);
		dataset.fieldValue("desc_clasificador", descClasificador);
	}

	private void traerValoresDatosClasif(IDataSet ds, Legajo aLegajo) throws BaseException {
		int oid = 0;
		Iterator iterClasifEnt = aLegajo.getClasifEntidadesActivas().iterator();
		while (iterClasifEnt.hasNext()) {
			ClasificadorEntidad clasifEnt = (ClasificadorEntidad) iterClasifEnt.next();
			ValorClasificadorEntidad valClasifEntidad = aLegajo.getValorClasifEnt(clasifEnt);
			if (valClasifEntidad != null)
				cargarDSValClasif(ds, new Integer(++oid), aLegajo.getOIDInteger(), clasifEnt.getOIDInteger(), valClasifEntidad.getOIDInteger(), clasifEnt.getNroClasif(), clasifEnt.getGrupo()
						.getDescripcion(), valClasifEntidad.getCodigo(), valClasifEntidad.getDescripcion(), clasifEnt.getNickname(), new Boolean(true), clasifEnt.getDescripcion());
			else
				cargarDSValClasif(ds, new Integer(++oid), aLegajo.getOIDInteger(), clasifEnt.getOIDInteger(), new Integer(-1), clasifEnt.getNroClasif(), clasifEnt.getGrupo().getDescripcion(), "", "",
						clasifEnt.getNickname(), new Boolean(true), clasifEnt.getDescripcion());
		}

	}

	private IDataSet getDataSetClasificadorEntidad() {
		IDataSet dataset = new TDataSet();
		dataset.create("TClasificadorEntidad");
		dataset.fieldDef(new Field("oid_clasif_ent", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 20));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
		dataset.fieldDef(new Field("nickname", Field.STRING, 30));
		dataset.fieldDef(new Field("obligatorio", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("nro_clasif", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_grupo_clasif", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_grupo_clasif", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_grupo_clasif", Field.STRING, 100));
		return dataset;
	}

	private void inicializarClasif(MapDatos mapaDatos) throws BaseException {
		IDataSet dsClasifEnt = getDataSetClasificadorEntidad();
		Iterator iterClasifEnt = Legajo.getClasificadoresEntidadActivos(getSesion()).iterator();
		while (iterClasifEnt.hasNext()) {
			ClasificadorEntidad clasifEnt = (ClasificadorEntidad) iterClasifEnt.next();
			cargarRegistroClasificadorEntidad(dsClasifEnt, clasifEnt);
		}
		writeCliente(dsClasifEnt);
	}

	private void cargarRegistroClasificadorEntidad(IDataSet dataset, ClasificadorEntidad clasifEnt) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_clasif_ent", clasifEnt.getOIDInteger());
		dataset.fieldValue("codigo", clasifEnt.getCodigo());
		dataset.fieldValue("descripcion", clasifEnt.getDescripcion());
		dataset.fieldValue("nickname", clasifEnt.getNickname());
		dataset.fieldValue("obligatorio", clasifEnt.isObligatorio());
		dataset.fieldValue("activo", clasifEnt.isActivo());
		dataset.fieldValue("nro_clasif", clasifEnt.getNroClasif());
		dataset.fieldValue("oid_grupo_clasif", clasifEnt.getGrupo().getOIDInteger());
		dataset.fieldValue("cod_grupo_clasif", clasifEnt.getGrupo().getCodigo());
		dataset.fieldValue("desc_grupo_clasif", clasifEnt.getGrupo().getDescripcion());

	}

	private IDataSet getDataSetTarjetaLegajo() {
		IDataSet dataset = new TDataSet();
		dataset.create("TTarjetaLegajo");
		dataset.fieldDef(new Field("oid_tar_leg", Field.INTEGER, 0));
		dataset.fieldDef(new Field("tipo_tarjeta", Field.STRING, 10));
		dataset.fieldDef(new Field("nro_tarjeta", Field.STRING, 50));
		dataset.fieldDef(new Field("oid_legajo", Field.STRING, 0));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("orden", Field.INTEGER, 0));
		return dataset;
	}

	private void traerTarjetaLegajo(IDataSet dsTarjetaLegajo, TarjetaLegajo tarjetaLegajo) throws BaseException {
		dsTarjetaLegajo.append();
		dsTarjetaLegajo.fieldValue("oid_tar_leg", tarjetaLegajo.getOIDInteger());
		dsTarjetaLegajo.fieldValue("tipo_tarjeta", tarjetaLegajo.getTipo_tarjeta());
		dsTarjetaLegajo.fieldValue("nro_tarjeta", tarjetaLegajo.getNro_tarjeta());
		dsTarjetaLegajo.fieldValue("oid_legajo", tarjetaLegajo.getLegajo().getOIDInteger());
		dsTarjetaLegajo.fieldValue("activo", tarjetaLegajo.isActivo());
		dsTarjetaLegajo.fieldValue("orden", tarjetaLegajo.getOrden());

	}

	private IDataSet getDataSetSeclo() {
		IDataSet dataset = new TDataSet();
		dataset.create("TSeclos");
		dataset.fieldDef(new Field("oid_seclo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_legajo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("fec_recepcion", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_tipo_reclamo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("monto_reclamo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("observaciones", Field.STRING, 4000));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("oid_estado_seclo", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("monto_acuerdo", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("hono_letrado", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("hono_conciliado", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("otros_hono", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("pagado", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("saldado", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("a_pagar", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("codigo_interno", Field.STRING, 50));
		dataset.fieldDef(new Field("tipo", Field.STRING, 10));
		dataset.fieldDef(new Field("oid_forma_exti", Field.INTEGER, 0));
		dataset.fieldDef(new Field("fec_novedad", Field.DATE, 0));
		dataset.fieldDef(new Field("causal_acuerdo", Field.STRING, 1000));
		
		return dataset;
	}

	private IDataSet getDataSetAudienciaSeclo() {
		IDataSet dataset = new TDataSet();
		dataset.create("TAudienciaSeclo");
		dataset.fieldDef(new Field("oid_audiencia", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_seclo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("fecha", Field.INTEGER, 0));
		dataset.fieldDef(new Field("Hora", Field.STRING, 0));
		dataset.fieldDef(new Field("direccion", Field.STRING, 100));
		dataset.fieldDef(new Field("conciliador", Field.STRING, 100));
		dataset.fieldDef(new Field("telefonos", Field.STRING, 100));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private IDataSet getDataSetDocEnvSeclo() {
		IDataSet dataset = new TDataSet();
		dataset.create("TDocEnvSec");
		dataset.fieldDef(new Field("oid_doc_env_sec", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_seclo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("fecha_envio", Field.DATE, 0));
		dataset.fieldDef(new Field("documentacion", Field.STRING, 4000));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private IDataSet getDataSetPagoSeclo() {
		IDataSet dataset = new TDataSet();
		dataset.create("TPagoSeclo");
		dataset.fieldDef(new Field("oid_pago_seclo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_seclo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("fec_pago", Field.DATE, 0));
		dataset.fieldDef(new Field("observacion", Field.STRING, 4000));
		dataset.fieldDef(new Field("pago_acuerdo", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("pago_letrado", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("oid_conc_pago_seclo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("pago_conciliador", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("pago_otros", Field.CURRENCY, 0));
		return dataset;
	}
	
	private void cargarRegistroJuicioRubroCondena(IDataSet ds, JuicioRubroCondena aJuicioRubroCondena) throws BaseException {
		ds.append();
		ds.fieldValue("oid_jui_rub_cond", aJuicioRubroCondena.getOIDInteger());
		ds.fieldValue("oid_juicio", aJuicioRubroCondena.getJuicio().getOIDInteger());
		ds.fieldValue("oid_rubro_condena", aJuicioRubroCondena.getRubro_condena().getOIDInteger());
		ds.fieldValue("activo", aJuicioRubroCondena.isActivo());
	}	
	
	private void cargarRegistroJuicioRubroReclamo(IDataSet ds, RubroCondenaJuicio aRubroCondenaJuicio) throws BaseException {
		ds.append(); 
		ds.fieldValue("oid_rub_cond_jui", aRubroCondenaJuicio.getOIDInteger());
		ds.fieldValue("oid_rubro_condena", aRubroCondenaJuicio.getRubro_condena().getOIDInteger());
		ds.fieldValue("oid_juicio", aRubroCondenaJuicio.getJuicio().getOIDInteger());
		ds.fieldValue("activo", aRubroCondenaJuicio.isActivo());
	}	
	
	
	private void cargarRegistroPagoJuicio(IDataSet ds, PagoJuicio pagoJuicio) throws BaseException {
		ds.append();
		ds.fieldValue("oid_pago_juicio", pagoJuicio.getOID());
		ds.fieldValue("fec_pago" , pagoJuicio.getFec_pago());
		ds.fieldValue("observacion" , pagoJuicio.getObservacion());
		if (pagoJuicio.getConcepto_pago_seclo()!=null)
			ds.fieldValue("oid_conc_pago_seclo" , pagoJuicio.getConcepto_pago_seclo().getOIDInteger());
		else
			ds.fieldValue("oid_conc_pago_seclo" , "");
		ds.fieldValue("pago_acuerdo", pagoJuicio.getPago_acuerdo());
		ds.fieldValue("pago_honorario", pagoJuicio.getPago_horario());
		ds.fieldValue("pago_perito" , pagoJuicio.getPago_perito());
		ds.fieldValue("pago_tasa_just", pagoJuicio.getPago_tasa_just());
		ds.fieldValue("activo", pagoJuicio.isActivo());
		ds.fieldValue("oid_juicio" , pagoJuicio.getJuicio().getOIDInteger());
		ds.fieldValue("pago_letrado", pagoJuicio.getPagoLetrado());

	}

	private IDataSet getDataSetPagoJuicio() {
		IDataSet dataset = new TDataSet();
		dataset.create("TPagoJuicio");
		dataset.fieldDef(new Field("oid_pago_juicio", Field.INTEGER, 0));
		dataset.fieldDef(new Field("fec_pago", Field.DATE, 0));
		dataset.fieldDef(new Field("observacion", Field.STRING, 4000));
		dataset.fieldDef(new Field("oid_conc_pago_seclo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("pago_acuerdo", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("pago_honorario", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("pago_perito", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("pago_tasa_just", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("oid_juicio", Field.INTEGER, 0));
		dataset.fieldDef(new Field("pago_letrado", Field.CURRENCY, 0));
		return dataset;
	}

	private IDataSet getDataSetNovedad() {
		IDataSet dataset = new TDataSet();
		dataset.create("TNovedadLegajo");
		dataset.fieldDef(new Field("oid_novedad", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nro_ext", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_tipo_novedad", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_mot_tipo_nov", Field.INTEGER, 0));
		dataset.fieldDef(new Field("fecha", Field.DATE, 0));
		dataset.fieldDef(new Field("hora_desde", Field.STRING, 5));
		dataset.fieldDef(new Field("hora_hasta", Field.STRING, 5));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("observacion", Field.STRING, 500));
		dataset.fieldDef(new Field("oid_legajo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_mot_tipo_nov", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_mot_tipo_nov", Field.STRING, 100));
		return dataset;
	}

	private IDataSet getDataSetDocuEnvJuicio() {
		IDataSet dataset = new TDataSet();
		dataset.create("TDocuEnvJuicio");
		dataset.fieldDef(new Field("oid_doc_env_juicio", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_juicio", Field.INTEGER, 0));
		dataset.fieldDef(new Field("fecha_envio", Field.DATE, 0));
		dataset.fieldDef(new Field("documentacion", Field.STRING, 4000));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private void cargarDocuEnvJuicio(IDataSet ds, DocuEnvJuicio docuEnvJuicio) throws BaseException {
		ds.append();
		ds.fieldValue("oid_doc_env_juicio", docuEnvJuicio.getOIDInteger());
		ds.fieldValue("oid_juicio", docuEnvJuicio.getJuicio().getOID());
		ds.fieldValue("fecha_envio", docuEnvJuicio.getFecha_envio());
		ds.fieldValue("documentacion", docuEnvJuicio.getDocumentacion());
		ds.fieldValue("activo", docuEnvJuicio.isActivo());
	}

	private void cargarAudiencia(IDataSet dataset, AudienciaSeclo audiencia) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_audiencia", audiencia.getOIDInteger());
		dataset.fieldValue("oid_seclo", audiencia.getSeclo().getOIDInteger());
		dataset.fieldValue("fecha", audiencia.getFecha());
		dataset.fieldValue("Hora", audiencia.getHora());
		dataset.fieldValue("direccion", audiencia.getDireccion());
		dataset.fieldValue("conciliador", audiencia.getConciliador());
		dataset.fieldValue("telefonos", audiencia.getTelefonos());
		dataset.fieldValue("activo", audiencia.isActivo());
	}

	private IDataSet getDataSetCategPosibleLeg() {
		IDataSet dataset = new TDataSet();
		dataset.create("TCategPosibleLeg");
		dataset.fieldDef(new Field("oid_categ_pos_leg", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_legajo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_categ_posible", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_categ_posible", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_categ_posible", Field.STRING, 100));
		dataset.fieldDef(new Field("fec_desde", Field.INTEGER, 0));
		dataset.fieldDef(new Field("fec_hasta", Field.INTEGER, 0));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("oid_rankear", Field.INTEGER, 0));
		return dataset;
	}

	private void cargarRegistroAudJuicio(IDataSet ds, AudienciaJuicio audienciaJuicio) throws BaseException {
		ds.append();
		ds.fieldValue("oid_aud_juicio", audienciaJuicio.getOID());
		ds.fieldValue("oid_juicio", audienciaJuicio.getJuicio().getOIDInteger());
		ds.fieldValue("fecha", audienciaJuicio.getFecha());
		ds.fieldValue("hora", audienciaJuicio.getHora());
		ds.fieldValue("persona", audienciaJuicio.getPersona());
		if (audienciaJuicio.getTipo_audiencia() != null)
			ds.fieldValue("oid_tipo_aud", audienciaJuicio.getTipo_audiencia().getOIDInteger());
		else
			ds.fieldValue("oid_tipo_aud", "");
		ds.fieldValue("activo", audienciaJuicio.isActivo());

	}

	private void traerCategPosibles(IDataSet dataset, Legajo aLegajo) throws BaseException {
		Iterator iterCategPosibles = aLegajo.getCategPosibles().iterator();
		while (iterCategPosibles.hasNext()) {
			CategPosibleLeg categPosibleLeg = (CategPosibleLeg) iterCategPosibles.next();
			dataset.append();
			dataset.fieldValue("oid_categ_pos_leg", categPosibleLeg.getOIDInteger());
			dataset.fieldValue("oid_legajo", categPosibleLeg.getLegajo().getOIDInteger());
			if (categPosibleLeg.getCateg_posible() != null) {
				dataset.fieldValue("oid_categ_posible", categPosibleLeg.getCateg_posible().getOIDInteger());
				dataset.fieldValue("cod_categ_posible", categPosibleLeg.getCateg_posible().getCodigo());
				dataset.fieldValue("desc_categ_posible", categPosibleLeg.getCateg_posible().getDescripcion());
			} else {
				dataset.fieldValue("oid_categ_posible", "");
				dataset.fieldValue("cod_categ_posible", "");
				dataset.fieldValue("desc_categ_posible", "");
			}
			dataset.fieldValue("fec_desde", categPosibleLeg.getFec_desde());
			dataset.fieldValue("fec_hasta", categPosibleLeg.getFec_hasta());
			dataset.fieldValue("activo", categPosibleLeg.isActivo());
			if (categPosibleLeg.getRankearCab() != null)
				dataset.fieldValue("oid_rankear", categPosibleLeg.getRankearCab().getOIDInteger());
			else
				dataset.fieldValue("oid_rankear", "");
		}
	}

	private void cargarRegistroCategPosibleLeg(IDataSet dataset, CategPosibleLeg aCategPosibleLeg) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_categ_pos_leg", aCategPosibleLeg.getOIDInteger());
		dataset.fieldValue("oid_legajo", aCategPosibleLeg.getLegajo().getOIDInteger());
		if (aCategPosibleLeg.getCateg_posible() != null) {
			dataset.fieldValue("oid_categ_posible", aCategPosibleLeg.getCateg_posible().getOIDInteger());
			dataset.fieldValue("cod_categ_posible", aCategPosibleLeg.getCateg_posible().getCodigo());
			dataset.fieldValue("desc_categ_posible", aCategPosibleLeg.getCateg_posible().getDescripcion());
		} else {
			dataset.fieldValue("oid_categ_posible", "");
			dataset.fieldValue("cod_categ_posible", "");
			dataset.fieldValue("desc_categ_posible", "");
		}
		dataset.fieldValue("fec_desde", aCategPosibleLeg.getFec_desde());
		dataset.fieldValue("fec_hasta", aCategPosibleLeg.getFec_hasta());
		dataset.fieldValue("activo", aCategPosibleLeg.isActivo());
	}

	private IDataSet getDataSetJuicioEmpresa() {
		IDataSet dataset = new TDataSet();
		dataset.create("TJuicioEmpresa");
		dataset.fieldDef(new Field("oid_jui_emp", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_juicio", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_val_clasif_emp", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_val_clasif_emp", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_val_clasif_emp", Field.STRING, 100));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private void cargarRegistroJuicioEmpresa(IDataSet dataset, JuicioEmpresa jucioEmpre) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_jui_emp", jucioEmpre.getOID());
		dataset.fieldValue("oid_juicio", jucioEmpre.getJuicio().getOIDInteger());
		if (jucioEmpre.getEmpresaJuicio()!=null) {
			dataset.fieldValue("oid_val_clasif_emp", jucioEmpre.getEmpresaJuicio().getOIDInteger());
			dataset.fieldValue("cod_val_clasif_emp", jucioEmpre.getEmpresaJuicio().getCodigo());
			dataset.fieldValue("desc_val_clasif_emp", jucioEmpre.getEmpresaJuicio().getDescripcion());
		} else {
			dataset.fieldValue("oid_val_clasif_emp", "");
			dataset.fieldValue("cod_val_clasif_emp", "");
			dataset.fieldValue("desc_val_clasif_emp", "");			
		}
		dataset.fieldValue("activo", jucioEmpre.isActivo());
	}

	private void cargarRegistroObservacion(IDataSet dataset, ObsLegajo obsLegajo) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_obs_leg", obsLegajo.getOID());
		dataset.fieldValue("oid_legajo", obsLegajo.getLegajo().getOIDInteger());
		dataset.fieldValue("oid_tipo_obs_leg", obsLegajo.getTipo_obs_leg().getOIDInteger());
		dataset.fieldValue("fecha", obsLegajo.getFecha());
		dataset.fieldValue("fec_carga", obsLegajo.getFec_carga());
		dataset.fieldValue("oid_usu_carga", obsLegajo.getUsuario_carga().getOIDInteger());
		dataset.fieldValue("observacion", obsLegajo.getObservacion());
		dataset.fieldValue("usu_alta", obsLegajo.getUsuario_carga().getLogin());
		dataset.fieldValue("pos_neg_neu", obsLegajo.getPosNegNeu());
		dataset.fieldValue("activo", obsLegajo.isActivo());
	}
	
	  private IDataSet getDataSetRubroReclamoSeclo() { 
		    IDataSet dataset = new TDataSet(); 
		    dataset.create("TRubroReclamoSeclo");
		    dataset.fieldDef(new Field("oid_rub_rec_seclo", Field.INTEGER, 0)); 
		    dataset.fieldDef(new Field("oid_rubro_condena", Field.INTEGER, 0)); 
		    dataset.fieldDef(new Field("oid_seclo", Field.INTEGER, 0)); 
		    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
		    return dataset;
		  }	

}
