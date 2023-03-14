package com.srn.erp.sueldos.op;

import com.srn.erp.cip.bm.CategAccesoCIP;
import com.srn.erp.cip.bm.CategAccesoLegajo;
import com.srn.erp.cip.bm.EstadoCIP;
import com.srn.erp.cip.bm.GrupoPuerta;
import com.srn.erp.cip.bm.LegajoRotaFecha;
import com.srn.erp.cip.bm.MotEntInterLeg;
import com.srn.erp.cip.bm.MotivoEntIntermedias;
import com.srn.erp.cip.bm.PermisoSemanalCIP;
import com.srn.erp.cip.bm.Rota;
import com.srn.erp.cip.bm.TarjetaLegajo;
import com.srn.erp.cip.bm.UtilCIP;
import com.srn.erp.general.bm.Periodo;
import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.legales.bm.Abogado;
import com.srn.erp.legales.bm.AudienciaJuicio;
import com.srn.erp.legales.bm.AudienciaSeclo;
import com.srn.erp.legales.bm.CartasDocRemLega;
import com.srn.erp.legales.bm.CompaniaSeguro;
import com.srn.erp.legales.bm.ConcPagoSeclo;
import com.srn.erp.legales.bm.DocEnvSeclo;
import com.srn.erp.legales.bm.DocuEnvJuicio;
import com.srn.erp.legales.bm.EmpresaJuicio;
import com.srn.erp.legales.bm.EstadoJuicio;
import com.srn.erp.legales.bm.EstadoProcesal;
import com.srn.erp.legales.bm.EstadoSeclo;
import com.srn.erp.legales.bm.FormaExtincion;
import com.srn.erp.legales.bm.Fuero;
import com.srn.erp.legales.bm.Juicio;
import com.srn.erp.legales.bm.JuicioCalcInt;
import com.srn.erp.legales.bm.JuicioEmpresa;
import com.srn.erp.legales.bm.JuicioRubroCondena;
import com.srn.erp.legales.bm.Juzgado;
import com.srn.erp.legales.bm.NegociacionLegales;
import com.srn.erp.legales.bm.PagoJuicio;
import com.srn.erp.legales.bm.PagoSeclo;
import com.srn.erp.legales.bm.RequeridoSeclo;
import com.srn.erp.legales.bm.ResultadoJuicio;
import com.srn.erp.legales.bm.RubroCondena;
import com.srn.erp.legales.bm.RubroCondenaJuicio;
import com.srn.erp.legales.bm.RubroReclamoSeclo;
import com.srn.erp.legales.bm.Seclo;
import com.srn.erp.legales.bm.TipoAudiencia;
import com.srn.erp.legales.bm.TipoCausaLegales;
import com.srn.erp.legales.bm.TipoPericia;
import com.srn.erp.legales.bm.TipoReclamoLeg;
import com.srn.erp.rrhh.bm.AparatoRRHH;
import com.srn.erp.rrhh.bm.CategPosibleLeg;
import com.srn.erp.rrhh.bm.ClaseSindicato;
import com.srn.erp.rrhh.bm.EnfermedadRRHH;
import com.srn.erp.rrhh.bm.EstadoDesarrollo;
import com.srn.erp.rrhh.bm.FamiliarRRHH;
import com.srn.erp.rrhh.bm.GradoLegajo;
import com.srn.erp.rrhh.bm.HistoricoPuesto;
import com.srn.erp.rrhh.bm.MedicoRRHH;
import com.srn.erp.rrhh.bm.MotVisFalRRHH;
import com.srn.erp.rrhh.bm.MotivoEgresoEmp;
import com.srn.erp.rrhh.bm.MotivoFaltaRRHH;
import com.srn.erp.rrhh.bm.MotivoTipoNov;
import com.srn.erp.rrhh.bm.NovedadLegajo;
import com.srn.erp.rrhh.bm.ObsLegajo;
import com.srn.erp.rrhh.bm.PrestMedidoRRHH;
import com.srn.erp.rrhh.bm.RankearCab;
import com.srn.erp.rrhh.bm.SancionesLegajo;
import com.srn.erp.rrhh.bm.SancionesRRHH;
import com.srn.erp.rrhh.bm.ServicioMedicoRRHH;
import com.srn.erp.rrhh.bm.TareaDesempeneada;
import com.srn.erp.rrhh.bm.TipoNovedad;
import com.srn.erp.rrhh.bm.TipoObsLeg;
import com.srn.erp.sueldos.bm.Legajo;
import com.srn.erp.ventas.bm.EstadoCivil;
import com.srn.erp.ventas.bm.TipoDocumento;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveLegajos extends Operation {

	public SaveLegajos() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		IDataSet dataset = mapaDatos.getDataSet("TLegajos");
		procesarRegistros(dataset);

	}

	private void procesarRegistros(IDataSet dataset) throws BaseException {
		dataset.first();
		while (!dataset.EOF()) {
			Legajo legajo = Legajo.findByOid(dataset.getInteger("oid_legajo"), getSesion());
			legajo.setNro_legajo(dataset.getString("nro_legajo"));
			legajo.setApellido(dataset.getString("apellido"));
			legajo.setNombre(dataset.getString("nombre"));
			legajo.setActivo(dataset.getBoolean("activo"));
			legajo.setFecIngreso(dataset.getDate("fec_ingreso"));
			legajo.setFecRetiro(dataset.getDate("fec_retiro"));
			legajo.setIDIdentificacion(dataset.getInteger("id_identificacion"));
			legajo.setGrupoPuertaIngreso(GrupoPuerta.findByOidProxy(dataset.getInteger("oid_grupo_puerta_ingreso"), this.getSesion()));
			legajo.setGrupoPuertaEgreso(GrupoPuerta.findByOidProxy(dataset.getInteger("oid_grupo_puerta_egreso"), this.getSesion()));
			legajo.setEstadoCIP(EstadoCIP.findByOidProxy(dataset.getInteger("oid_estado"), this.getSesion()));
			legajo.setPermisoSemanal(PermisoSemanalCIP.findByOidProxy(dataset.getInteger("oid_perm_semenal"), this.getSesion()));
			legajo.setLibIngAlPredio(dataset.getBoolean("lib_ing_al_predio"));
			legajo.setProhibirAcceso(dataset.getBoolean("prohibir_acceso"));

			legajo.setActivarAntiPassBack(dataset.getBoolean("act_anti_pass_back"));
			legajo.setFecUltPaso(dataset.getDate("fec_ult_paso"));
			legajo.setHoraUltPaso(dataset.getString("hor_ult_paso"));
			legajo.setSentidoPaso(dataset.getString("sentido_paso"));
			legajo.setIgnorarProxAntiPassBack(dataset.getBoolean("ignorar_prox_apb"));

			legajo.setCircuitoCacheo(dataset.getBoolean("circuito_chequeo"));
			legajo.setSeguiLegales(dataset.getBoolean("segui_legales"));

			legajo.setCUIT(dataset.getString("CUIL"));
			legajo.setSexo(dataset.getString("SEXO"));
			legajo.setEstadoCivil(EstadoCivil.findByOidProxy(dataset.getInteger("oid_estado_civil"), this.getSesion()));
			legajo.setFecNacimiento(dataset.getDate("fec_nacimiento"));
			legajo.setTipoDocumento(TipoDocumento.findByOidProxy(dataset.getInteger("oid_tipo_docu"), this.getSesion()));
			legajo.setNroDocumento(dataset.getString("nro_documento"));
			legajo.setTelefono(dataset.getString("telefono"));
			legajo.setTelefonoCelular(dataset.getString("telefono_celular"));
			legajo.setClaseSindicato(ClaseSindicato.findByOidProxy(dataset.getInteger("oid_clase_sind"), this.getSesion()));
			legajo.setFecAntReconocimiento(dataset.getDate("fec_ant_rec"));
			legajo.setMotivoEgresoEmp(MotivoEgresoEmp.findByOidProxy(dataset.getInteger("oid_mot_egreso"), this.getSesion()));
			legajo.setFecVencProteccion(dataset.getDate("fec_venc_prot"));
			legajo.setFecIngresoUTE(dataset.getDate("fec_ing_ute"));
			legajo.setDireccion(dataset.getString("direccion"));
			legajo.setGradoLegajo(GradoLegajo.findByOidProxy(dataset.getInteger("oid_grado_legajo"), this.getSesion()));
			legajo.setEstadoDesarrollo(EstadoDesarrollo.findByOidProxy(dataset.getInteger("oid_est_desa"), this.getSesion()));
			legajo.setSeguiCartasDocu(dataset.getBoolean("segui_cartas_docu"));
			legajo.setTareaDempeneada(TareaDesempeneada.findByOidProxy(dataset.getInteger("oid_tarea_desemp"), this.getSesion()));
			

			grabarValoresClasif(legajo, dataset);

			IDataSet dsTarjetas = dataset.getDataSet("TTarjetaLegajo");
			dsTarjetas.first();
			while (!dsTarjetas.EOF()) {
				TarjetaLegajo tarjetaLegajo = TarjetaLegajo.findByOid(dsTarjetas.getInteger("oid_tar_leg"), this.getSesion());
				tarjetaLegajo.setTipo_tarjeta(dsTarjetas.getString("tipo_tarjeta"));
				tarjetaLegajo.setNro_tarjeta(dsTarjetas.getString("nro_tarjeta"));
				tarjetaLegajo.setOrden(dsTarjetas.getInteger("orden"));
				tarjetaLegajo.setLegajo(legajo);
				tarjetaLegajo.setActivo(dsTarjetas.getBoolean("activo"));
				legajo.addTarjetaLegajo(tarjetaLegajo);

				dsTarjetas.next();
			}

			IDataSet dsNegociaciones = dataset.getDataSet("TNegociaciones");
			dsNegociaciones.first();
			while (!dsNegociaciones.EOF()) {
				NegociacionLegales negociacion = NegociacionLegales.findByOid(dsNegociaciones.getInteger("oid_negociacion"), this.getSesion());
				negociacion.setLegajo(legajo);
				negociacion.setFecha(dsNegociaciones.getDate("fecha"));
				negociacion.setObservacion(dsNegociaciones.getString("observacion"));
				negociacion.setMonto(dsNegociaciones.getMoney("monto"));
				negociacion.setActivo(dsNegociaciones.getBoolean("activo"));

				legajo.addNegociacion(negociacion);

				dsNegociaciones.next();
			}

			IDataSet dsHistPuestos = dataset.getDataSet("THistPuestos");
			dsHistPuestos.first();
			while (!dsHistPuestos.EOF()) {
				HistoricoPuesto historicoPuesto = HistoricoPuesto.findByOid(dsHistPuestos.getInteger("oid_hist_puesto"), this.getSesion());
				historicoPuesto.setVal_clasif_pue(ValorClasificadorEntidad.findByOidProxy(dsHistPuestos.getInteger("oid_val_clasif_pue"), this.getSesion()));
				historicoPuesto.setVal_clasif_emp(ValorClasificadorEntidad.findByOidProxy(dsHistPuestos.getInteger("oid_val_clasif_emp"), this.getSesion()));
				historicoPuesto.setVal_clasif_sec(ValorClasificadorEntidad.findByOidProxy(dsHistPuestos.getInteger("oid_val_clasif_sec"), this.getSesion()));
				historicoPuesto.setLegajo(Legajo.findByOidProxy(dsHistPuestos.getInteger("oid_legajo"), this.getSesion()));
				historicoPuesto.setFec_desde(dsHistPuestos.getDate("fec_desde"));
				historicoPuesto.setActivo(dsHistPuestos.getBoolean("activo"));

				legajo.addHistPuesto(historicoPuesto);

				dsHistPuestos.next();
			}

			IDataSet dsNovedades = dataset.getDataSet("TNovedadLegajo");
			dsNovedades.first();
			while (!dsNovedades.EOF()) {
				NovedadLegajo novedad = NovedadLegajo.findByOid(dsNovedades.getInteger("oid_novedad"), this.getSesion());
				novedad.setOid_legajo(legajo);
				novedad.setNro_ext(dsNovedades.getInteger("nro_ext"));
				novedad.setOid_tipo_novedad(TipoNovedad.findByOidProxy(dsNovedades.getInteger("oid_tipo_novedad"), this.getSesion()));
				novedad.setMotivo_tipo_nov(MotivoTipoNov.findByOidProxy(dsNovedades.getInteger("oid_mot_tipo_nov"), this.getSesion()));
				novedad.setFecha(dsNovedades.getDate("fecha"));
				novedad.setHora_desde(dsNovedades.getString("hora_desde"));
				novedad.setHora_hasta(dsNovedades.getString("hora_hasta"));
				novedad.setActivo(dsNovedades.getBoolean("activo"));
				novedad.setObservacion(dsNovedades.getString("observacion"));

				legajo.addNovedadLegajo(novedad);

				dsNovedades.next();
			}

			IDataSet dsJuicio = dataset.getDataSet("TJuicio");
			dsJuicio.first();
			while (!dsJuicio.EOF()) {
				Juicio juicio = Juicio.findByOid(dsJuicio.getInteger("oid_juicio"), this.getSesion());
				juicio.setTipo_reclamo(TipoReclamoLeg.findByOidProxy(dsJuicio.getInteger("oid_tipo_reclamo"), this.getSesion()));
				juicio.setFec_rec_dem(dsJuicio.getDate("fec_rec_dem"));
				juicio.setJuzgado(Juzgado.findByOidProxy(dsJuicio.getInteger("oid_juzgado"), this.getSesion()));
				juicio.setNro_expediente(dsJuicio.getString("nro_expediente"));
				juicio.setMonto_reclamo(dsJuicio.getMoney("monto_reclamo"));
				juicio.setProb_resultado(dsJuicio.getString("prob_resultado"));
				juicio.setPorc_prevision(dsJuicio.getMoney("porc_prevision"));
				juicio.setEstado_procesal(EstadoProcesal.findByOidProxy(dsJuicio.getInteger("oid_est_procesal"), this.getSesion()));
				juicio.setEstado_juicio(EstadoJuicio.findByOidProxy(dsJuicio.getInteger("oid_est_juicio"), this.getSesion()));
				juicio.setActivo(dsJuicio.getBoolean("activo"));
				juicio.setObservaciones(dsJuicio.getString("observaciones"));
				juicio.setPeriodo_mensual(Periodo.findByOidProxy(dsJuicio.getInteger("oid_peri_mens_prev"), this.getSesion()));
				juicio.setPrevision(dsJuicio.getMoney("prevision"));
				juicio.setAbogado(Abogado.findByOidProxy(dsJuicio.getInteger("oid_abogado"), this.getSesion()));
				juicio.setCBU(dsJuicio.getString("cbu"));
				juicio.setEmbargo(dsJuicio.getMoney("embargo"));
				juicio.setEstimado(dsJuicio.getMoney("estimado"));
				juicio.setCodigoInterno(dsJuicio.getString("codigo_interno"));
				juicio.setFecNovedad(dsJuicio.getDate("fec_novedad"));
				juicio.setMontoAcuerdo(dsJuicio.getMoney("monto_acuerdo"));
				juicio.setMontoConciliado(dsJuicio.getMoney("monto_honorario"));
				juicio.setMontoLetrado(dsJuicio.getMoney("monto_letrado"));
				juicio.setMontoPerito(dsJuicio.getMoney("monto_perito"));
				juicio.setMontoTasaJusticia(dsJuicio.getMoney("tasa_justicia"));
				juicio.setCaratula(dsJuicio.getString("caratula"));
				juicio.setPorcIncapacidad(dsJuicio.getMoney("porc_incapacidad"));
				juicio.setMontoIntereses(dsJuicio.getMoney("monto_interes"));
				juicio.setTipoPericia(TipoPericia.findByOidProxy(dsJuicio.getInteger("oid_tipo_pericia"), this.getSesion()));
				juicio.setFuero(Fuero.findByOidProxy(dsJuicio.getInteger("oid_fuero"), this.getSesion()));
				juicio.setCompaniaSeguroCaucion(CompaniaSeguro.findByOidProxy(dsJuicio.getInteger("oid_comp_seg_cau"), this.getSesion()));
				juicio.setPorcLetrado(dsJuicio.getMoney("porc_letrado"));
				juicio.setPorcPerito(dsJuicio.getMoney("porc_perito"));
				juicio.setPorcTasaJusticia(dsJuicio.getMoney("porc_tasa_just"));
				juicio.setPrimeraInstancia(dsJuicio.getString("primera_instancia"));
				juicio.setSegundaInstancia(dsJuicio.getString("segunda_instancia"));
				
				juicio.setResultadoJuicio(ResultadoJuicio.findByOidProxy(dsJuicio.getInteger("oid_resul_juicio"), this.getSesion()));

				juicio.setLegajo(legajo);
				
				IDataSet dsCalcInteres = dsJuicio.getDataSet("TCalcInteres");
				dsCalcInteres.first();
				while (!dsCalcInteres.EOF()) {
					JuicioCalcInt juicioCalcInt = JuicioCalcInt.findByOid(dsCalcInteres.getInteger("oid_calc_int"), this.getSesion());
					juicioCalcInt.setJuicio(juicio);
					juicioCalcInt.setFec_desde(dsCalcInteres.getDate("fec_desde"));
					juicioCalcInt.setFec_hasta(dsCalcInteres.getDate("fec_hasta"));
					juicioCalcInt.setTipo_tasa(dsCalcInteres.getString("tipo_tasa"));
					juicioCalcInt.setPorc(dsCalcInteres.getDouble("porc"));
					juicioCalcInt.setInteres(dsCalcInteres.getMoney("interes"));
					juicioCalcInt.setActivo(dsCalcInteres.getBoolean("activo"));
					dsCalcInteres.next();
					juicio.addCalcInteres(juicioCalcInt);
				}				

				IDataSet dsDocuEnvJuicios = dsJuicio.getDataSet("TDocuEnvJuicio");
				dsDocuEnvJuicios.first();
				while (!dsDocuEnvJuicios.EOF()) {
					DocuEnvJuicio docuEnvJuicio = DocuEnvJuicio.findByOid(dsDocuEnvJuicios.getInteger("oid_doc_env_juicio"), this.getSesion());
					docuEnvJuicio.setJuicio(juicio);
					docuEnvJuicio.setFecha_envio(dsDocuEnvJuicios.getDate("fecha_envio"));
					docuEnvJuicio.setDocumentacion(dsDocuEnvJuicios.getString("documentacion"));
					docuEnvJuicio.setActivo(dsDocuEnvJuicios.getBoolean("activo"));
					dsDocuEnvJuicios.next();
					juicio.addDocuEnviados(docuEnvJuicio);
				}

				IDataSet dsEmpresasJuicio = dsJuicio.getDataSet("TJuicioEmpresa");
				dsEmpresasJuicio.first();
				while (!dsEmpresasJuicio.EOF()) {
					JuicioEmpresa juicioEmpresa = JuicioEmpresa.findByOid(dsEmpresasJuicio.getInteger("oid_jui_emp"), this.getSesion());
					juicioEmpresa.setJuicio(juicio);
					juicioEmpresa.setEmpresaJuicio(EmpresaJuicio.findByOidProxy(dsEmpresasJuicio.getInteger("oid_val_clasif_emp"), this.getSesion()));
					juicioEmpresa.setActivo(dsEmpresasJuicio.getBoolean("activo"));
					dsEmpresasJuicio.next();
					juicio.addEmpresa(juicioEmpresa);
				}

				IDataSet dsJuicioRubrosCondenas = dsJuicio.getDataSet("TJuicioRubroCondena");
				dsJuicioRubrosCondenas.first();
				while (!dsJuicioRubrosCondenas.EOF()) {
					JuicioRubroCondena juicioRubroCondena = JuicioRubroCondena.findByOid(dsJuicioRubrosCondenas.getInteger("oid_jui_rub_cond"), this.getSesion());
					juicioRubroCondena.setJuicio(juicio);
					juicioRubroCondena.setRubro_condena(RubroCondena.findByOidProxy(dsJuicioRubrosCondenas.getInteger("oid_rubro_condena"), this.getSesion()));
					juicioRubroCondena.setActivo(dsJuicioRubrosCondenas.getBoolean("activo"));
					dsJuicioRubrosCondenas.next();
					juicio.addRubroCondena(juicioRubroCondena);
				}

				IDataSet dsAudiJuicios = dsJuicio.getDataSet("TAudienciaJuicio");
				dsAudiJuicios.first();
				while (!dsAudiJuicios.EOF()) {
					AudienciaJuicio audienciaJuicio = AudienciaJuicio.findByOid(dsAudiJuicios.getInteger("oid_aud_juicio"), this.getSesion());
					audienciaJuicio.setJuicio(juicio);
					audienciaJuicio.setFecha(dsAudiJuicios.getDate("fecha"));
					audienciaJuicio.setHora(dsAudiJuicios.getString("hora"));
					audienciaJuicio.setPersona(dsAudiJuicios.getString("persona"));
					audienciaJuicio.setTipo_audiencia(TipoAudiencia.findByOidProxy(dsAudiJuicios.getInteger("oid_tipo_aud"), this.getSesion()));
					audienciaJuicio.setActivo(dsAudiJuicios.getBoolean("activo"));

					juicio.addAudiencia(audienciaJuicio);

					dsAudiJuicios.next();
				}

				IDataSet dsPagosJuicios = dsJuicio.getDataSet("TPagoJuicio");
				dsPagosJuicios.first();
				while (!dsPagosJuicios.EOF()) {
					PagoJuicio pagoJuicio = PagoJuicio.findByOid(dsPagosJuicios.getInteger("oid_pago_juicio"), this.getSesion());
					pagoJuicio.setJuicio(juicio);
					pagoJuicio.setFec_pago(dsPagosJuicios.getDate("fec_pago"));
					pagoJuicio.setObservacion(dsPagosJuicios.getString("observacion"));
					pagoJuicio.setConcepto_pago_seclo(ConcPagoSeclo.findByOidProxy(dsPagosJuicios.getInteger("oid_conc_pago_seclo"), this.getSesion()));
					pagoJuicio.setPago_acuerdo(dsPagosJuicios.getMoney("pago_acuerdo"));
					pagoJuicio.setPago_horario(dsPagosJuicios.getMoney("pago_honorario"));
					pagoJuicio.setPago_perito(dsPagosJuicios.getMoney("pago_perito"));
					pagoJuicio.setPago_tasa_just(dsPagosJuicios.getMoney("pago_tasa_just"));
					pagoJuicio.setActivo(dsPagosJuicios.getBoolean("activo"));
					pagoJuicio.setPagoLetrado(dsPagosJuicios.getMoney("pago_letrado"));

					juicio.addPagoJuicio(pagoJuicio);

					dsPagosJuicios.next();
				}

				IDataSet dsRubroCondenaJuicio = dsJuicio.getDataSet("TRubroCondenaJuicio");
				dsRubroCondenaJuicio.first();
				while (!dsRubroCondenaJuicio.EOF()) {

					RubroCondenaJuicio rubroCondenaJuicio = RubroCondenaJuicio.findByOid(dsRubroCondenaJuicio.getInteger("oid_rub_cond_jui"), this.getSesion());
					rubroCondenaJuicio.setRubro_condena(RubroCondena.findByOidProxy(dsRubroCondenaJuicio.getInteger("oid_rubro_condena"), this.getSesion()));
					rubroCondenaJuicio.setJuicio(juicio);
					rubroCondenaJuicio.setActivo(dsRubroCondenaJuicio.getBoolean("activo"));

					juicio.addRubroReclamo(rubroCondenaJuicio);

					dsRubroCondenaJuicio.next();
				}

				legajo.addJuicio(juicio);

				dsJuicio.next();
			}

			IDataSet dsSancionesLeg = dataset.getDataSet("TSancionesLegajo");
			dsSancionesLeg.first();
			while (!dsSancionesLeg.EOF()) {
				SancionesLegajo sancionesLeg = SancionesLegajo.findByOid(dsSancionesLeg.getInteger("oid_sanc_leg"), this.getSesion());
				sancionesLeg.setLegajo(Legajo.findByOidProxy(dsSancionesLeg.getInteger("oid_legajo"), this.getSesion()));
				sancionesLeg.setMotivo_falta(MotivoFaltaRRHH.findByOidProxy(dsSancionesLeg.getInteger("oid_mot_falta"), this.getSesion()));
				sancionesLeg.setMotivo_sancion(SancionesRRHH.findByOidProxy(dsSancionesLeg.getInteger("oid_mot_sancion"), this.getSesion()));
				sancionesLeg.setNro_sancion(dsSancionesLeg.getInteger("nro_sancion"));
				sancionesLeg.setFecha(dsSancionesLeg.getDate("fecha"));
				sancionesLeg.setFec_susp_desde(dsSancionesLeg.getDate("fec_susp_desde"));
				sancionesLeg.setFec_reintegro(dsSancionesLeg.getDate("fec_reintegro"));
				sancionesLeg.setActivo(dsSancionesLeg.getBoolean("activo"));
				legajo.addSancionLegajo(sancionesLeg);

				dsSancionesLeg.next();
			}

			IDataSet dsObservaciones = dataset.getDataSet("TObservaciones");
			dsObservaciones.first();
			while (!dsObservaciones.EOF()) {
				ObsLegajo obsLegajo = ObsLegajo.findByOid(dsObservaciones.getInteger("oid_obs_leg"), this.getSesion());
				obsLegajo.setLegajo(Legajo.findByOidProxy(dsObservaciones.getInteger("oid_legajo"), this.getSesion()));
				obsLegajo.setTipo_obs_leg(TipoObsLeg.findByOidProxy(dsObservaciones.getInteger("oid_tipo_obs_leg"), this.getSesion()));
				obsLegajo.setFecha(dsObservaciones.getDate("fecha"));
				if (obsLegajo.isNew()) {
					obsLegajo.setFec_carga(Fecha.getFechaTruncada((UtilCIP.getFechaHoraActual(this.getSesion()))));
					obsLegajo.setUsuario_carga(Usuario.findByOidProxy(this.getSesion().getLogin().getUsuario().getOIDInteger(), this.getSesion()));
				}
				obsLegajo.setObservacion(dsObservaciones.getString("observacion"));
				obsLegajo.setActivo(dsObservaciones.getBoolean("activo"));
				obsLegajo.setPosNegNeu(dsObservaciones.getString("pos_neg_neu"));

				legajo.addObservaciones(obsLegajo);

				dsObservaciones.next();
			}

			IDataSet dsCategPosibles = dataset.getDataSet("TCategPosibleLeg");
			dsCategPosibles.first();
			while (!dsCategPosibles.EOF()) {
				CategPosibleLeg categPosibles = CategPosibleLeg.findByOid(dsCategPosibles.getInteger("oid_categ_pos_leg"), this.getSesion());
				categPosibles.setLegajo(legajo);
				categPosibles.setCateg_posible(ValorClasificadorEntidad.findByOidProxy(dsCategPosibles.getInteger("oid_categ_posible"), this.getSesion()));
				categPosibles.setFec_desde(dsCategPosibles.getDate("fec_desde"));
				categPosibles.setFec_hasta(dsCategPosibles.getDate("fec_hasta"));
				categPosibles.setActivo(dsCategPosibles.getBoolean("activo"));
				categPosibles.setRankearCab(RankearCab.findByOidProxy(dsCategPosibles.getInteger("oid_rankear"), this.getSesion()));

				legajo.addCategPosibleLeg(categPosibles);

				dsCategPosibles.next();
			}

			IDataSet dsSeclos = dataset.getDataSet("TSeclos");
			dsSeclos.first();
			while (!dsSeclos.EOF()) {
				Seclo seclo = Seclo.findByOid(dsSeclos.getInteger("oid_seclo"), this.getSesion());
				seclo.setLegajo(Legajo.findByOidProxy(dsSeclos.getInteger("oid_legajo"), this.getSesion()));
				seclo.setFec_recepcion(dsSeclos.getDate("fec_recepcion"));
				seclo.setTipo_reclamo(TipoReclamoLeg.findByOidProxy(dsSeclos.getInteger("oid_tipo_reclamo"), this.getSesion()));
				seclo.setMonto_reclamo(dsSeclos.getMoney("monto_reclamo"));
				seclo.setObservaciones(dsSeclos.getString("observaciones"));
				seclo.setActivo(dsSeclos.getBoolean("activo"));
				seclo.setEstado_seclo(EstadoSeclo.findByOidProxy(dsSeclos.getInteger("oid_estado_seclo"), this.getSesion()));
				seclo.setMonto_acuerdo(dsSeclos.getMoney("monto_acuerdo"));
				seclo.setHono_letrado(dsSeclos.getMoney("hono_letrado"));
				seclo.setHono_conciliado(dsSeclos.getMoney("hono_conciliado"));
				seclo.setOtros_hono(dsSeclos.getMoney("otros_hono"));
				seclo.setcodigoInterno(dsSeclos.getString("codigo_interno"));
				seclo.setTipo(dsSeclos.getString("tipo"));
				seclo.setFormaExtincion(FormaExtincion.findByOidProxy(dsSeclos.getInteger("oid_forma_exti"), this.getSesion()));
				seclo.setFecNovedad(dsSeclos.getDate("fec_novedad"));
				seclo.setCausaAcuerdo(dsSeclos.getString("causal_acuerdo"));

				legajo.addSeclo(seclo);

				IDataSet dsAudiencias = dsSeclos.getDataSet("TAudienciaSeclo");
				dsAudiencias.first();
				while (!dsAudiencias.EOF()) {
					AudienciaSeclo audiencia = AudienciaSeclo.findByOid(dsAudiencias.getInteger("oid_audiencia"), this.getSesion());
					audiencia.setSeclo(seclo);
					audiencia.setFecha(dsAudiencias.getDate("fecha"));
					audiencia.setHora(dsAudiencias.getString("hora"));
					audiencia.setDireccion(dsAudiencias.getString("direccion"));
					audiencia.setConciliador(dsAudiencias.getString("conciliador"));
					audiencia.setTelefonos(dsAudiencias.getString("telefonos"));
					audiencia.setActivo(dsAudiencias.getBoolean("activo"));
					seclo.addAudiencias(audiencia);
					dsAudiencias.next();
				}

				IDataSet dsDocEnvSec = dsSeclos.getDataSet("TDocEnvSec");
				dsDocEnvSec.first();
				while (!dsDocEnvSec.EOF()) {
					DocEnvSeclo docEnvSeclo = DocEnvSeclo.findByOid(dsDocEnvSec.getInteger("oid_doc_env_sec"), this.getSesion());
					docEnvSeclo.setSeclo(seclo);
					docEnvSeclo.setFecha_envio(dsDocEnvSec.getDate("fecha_envio"));
					docEnvSeclo.setDocumentacion(dsDocEnvSec.getString("documentacion"));
					docEnvSeclo.setActivo(dsDocEnvSec.getBoolean("activo"));
					seclo.addDocEnviadas(docEnvSeclo);

					dsDocEnvSec.next();
				}

				IDataSet dsPagos = dsSeclos.getDataSet("TPagoSeclo");
				dsPagos.first();
				while (!dsPagos.EOF()) {
					PagoSeclo pagoSeclo = PagoSeclo.findByOid(dsPagos.getInteger("oid_pago_seclo"), this.getSesion());
					pagoSeclo.setSeclo(seclo);
					pagoSeclo.setFec_pago(dsPagos.getDate("fec_pago"));
					pagoSeclo.setObservacion(dsPagos.getString("observacion"));
					pagoSeclo.setPago_acuerdo(dsPagos.getMoney("pago_acuerdo"));
					pagoSeclo.setActivo(dsPagos.getBoolean("activo"));
					pagoSeclo.setPago_letrado(dsPagos.getMoney("pago_letrado"));
					pagoSeclo.setConc_pago(ConcPagoSeclo.findByOidProxy(dsPagos.getInteger("oid_conc_pago_seclo"), this.getSesion()));
					pagoSeclo.setPago_conciliador(dsPagos.getMoney("pago_conciliador"));
					pagoSeclo.setPago_otros(dsPagos.getMoney("pago_otros"));
					seclo.addPago(pagoSeclo);
					dsPagos.next();
				}

				IDataSet dsRequeridos = dsSeclos.getDataSet("TRequeridos");
				dsRequeridos.first();
				while (!dsRequeridos.EOF()) {
					RequeridoSeclo requerido = RequeridoSeclo.findByOid(dsRequeridos.getInteger("oid_seclo_reque"), this.getSesion());
					requerido.setSeclo(seclo);
					requerido.setValor_clasif_empresa(ValorClasificadorEntidad.findByOidProxy(dsRequeridos.getInteger("oid_val_clasif_emp"), this.getSesion()));
					requerido.setActivo(dsRequeridos.getBoolean("activo"));
					seclo.addRequerido(requerido);
					dsRequeridos.next();
				}

				IDataSet dsRubrosReclamos = dsSeclos.getDataSet("TRubroReclamoSeclo");
				dsRubrosReclamos.first();
				while (!dsRubrosReclamos.EOF()) {
					RubroReclamoSeclo rubroReclamoSeclo = RubroReclamoSeclo.findByOid(dsRubrosReclamos.getInteger("oid_rub_rec_seclo"), this.getSesion());
					rubroReclamoSeclo.setSeclo(seclo);
					rubroReclamoSeclo.setRubro_condena(RubroCondena.findByOidProxy(dsRubrosReclamos.getInteger("oid_rubro_condena"), this.getSesion()));
					rubroReclamoSeclo.setActivo(dsRubrosReclamos.getBoolean("activo"));
					seclo.addRubroReclamo(rubroReclamoSeclo);
					dsRubrosReclamos.next();
				}

				dsSeclos.next();
			}

			IDataSet dsPedMed = dataset.getDataSet("TPedidosMedicos");
			dsPedMed.first();
			while (!dsPedMed.EOF()) {
				ServicioMedicoRRHH servMedicoRRHH1 = ServicioMedicoRRHH.findByOid(dsPedMed.getInteger("oid_serv_medico"), this.getSesion());
				servMedicoRRHH1.setLegajo(Legajo.findByOidProxy(dsPedMed.getInteger("oid_legajo"), this.getSesion()));
				servMedicoRRHH1.setTipo_serv_med(ServicioMedicoRRHH.SM_PEDMED);
				servMedicoRRHH1.setNro_nov_sist_ext(dsPedMed.getInteger("nro_nov_sist_ext"));
				servMedicoRRHH1.setFec_inicio(dsPedMed.getDate("fec_inicio"));
				servMedicoRRHH1.setFec_final(dsPedMed.getDate("fec_final"));
				servMedicoRRHH1.setDias(dsPedMed.getInteger("dias"));
				servMedicoRRHH1.setMotivo_visita_fallo(MotVisFalRRHH.findByOidProxy(dsPedMed.getInteger("oid_mot_vis_fall"), this.getSesion()));
				servMedicoRRHH1.setAparato(AparatoRRHH.findByOidProxy(dsPedMed.getInteger("oid_aparato"), this.getSesion()));
				servMedicoRRHH1.setEnfermedad(EnfermedadRRHH.findByOidProxy(dsPedMed.getInteger("oid_enfermedad"), this.getSesion()));
				servMedicoRRHH1.setPrestador_medico(PrestMedidoRRHH.findByOidProxy(dsPedMed.getInteger("oid_prest_med"), this.getSesion()));
				servMedicoRRHH1.setSintoma(dsPedMed.getString("sintoma"));
				servMedicoRRHH1.setObservacion(dsPedMed.getString("observacion"));
				servMedicoRRHH1.setJustifica(dsPedMed.getBoolean("justifica"));
				servMedicoRRHH1.setActivo(dsPedMed.getBoolean("activo"));
				servMedicoRRHH1.setFecControl(dsPedMed.getDate("fec_control"));

				legajo.addPedidoMedico(servMedicoRRHH1);

				dsPedMed.next();
			}

			IDataSet dsAteMed = dataset.getDataSet("TAtencionMedica");
			dsAteMed.first();
			while (!dsAteMed.EOF()) {

				ServicioMedicoRRHH servMedicoRRHH1 = ServicioMedicoRRHH.findByOid(dsAteMed.getInteger("oid_ate_med"), this.getSesion());
				servMedicoRRHH1.setLegajo(Legajo.findByOidProxy(dsAteMed.getInteger("oid_legajo"), this.getSesion()));
				servMedicoRRHH1.setTipo_serv_med(ServicioMedicoRRHH.SM_ATEMED);
				servMedicoRRHH1.setNro_nov_sist_ext(dsAteMed.getInteger("nro_nov_sist_ext"));
				servMedicoRRHH1.setFec_inicio(dsAteMed.getDate("fec_inicio"));
				servMedicoRRHH1.setFec_final(dsAteMed.getDate("fec_final"));
				servMedicoRRHH1.setDias(dsAteMed.getInteger("dias"));
				servMedicoRRHH1.setMedico(MedicoRRHH.findByOidProxy(dsAteMed.getInteger("oid_medico"), this.getSesion()));
				servMedicoRRHH1.setAparato(AparatoRRHH.findByOidProxy(dsAteMed.getInteger("oid_aparato"), this.getSesion()));
				servMedicoRRHH1.setEnfermedad(EnfermedadRRHH.findByOidProxy(dsAteMed.getInteger("oid_enfermedad"), this.getSesion()));
				servMedicoRRHH1.setSintoma(dsAteMed.getString("sintoma"));
				servMedicoRRHH1.setObservacion(dsAteMed.getString("observacion"));
				servMedicoRRHH1.setFecAteMed(dsAteMed.getDate("fec_ate_med"));
				servMedicoRRHH1.setActivo(dsAteMed.getBoolean("activo"));
				servMedicoRRHH1.setFecControl(dsAteMed.getDate("fec_control"));

				legajo.addAtencionMedica(servMedicoRRHH1);

				dsAteMed.next();
			}

			IDataSet dsEnfFam = dataset.getDataSet("TEnfermedadesFam");
			dsEnfFam.first();
			while (!dsEnfFam.EOF()) {

				ServicioMedicoRRHH servMedicoRRHH1 = ServicioMedicoRRHH.findByOid(dsEnfFam.getInteger("oid_enf_fam"), this.getSesion());
				servMedicoRRHH1.setLegajo(Legajo.findByOidProxy(dsEnfFam.getInteger("oid_legajo"), this.getSesion()));
				servMedicoRRHH1.setTipo_serv_med(ServicioMedicoRRHH.SM_ENFFAM);
				servMedicoRRHH1.setNro_nov_sist_ext(dsEnfFam.getInteger("nro_nov_sist_ext"));
				servMedicoRRHH1.setFec_inicio(dsEnfFam.getDate("fec_inicio"));
				servMedicoRRHH1.setFec_final(dsEnfFam.getDate("fec_final"));
				servMedicoRRHH1.setDias(dsEnfFam.getInteger("dias"));
				servMedicoRRHH1.setFamiliar(FamiliarRRHH.findByOidProxy(dsEnfFam.getInteger("oid_familiar"), this.getSesion()));
				servMedicoRRHH1.setAparato(AparatoRRHH.findByOidProxy(dsEnfFam.getInteger("oid_aparato"), this.getSesion()));
				servMedicoRRHH1.setEnfermedad(EnfermedadRRHH.findByOidProxy(dsEnfFam.getInteger("oid_enfermedad"), this.getSesion()));
				servMedicoRRHH1.setSintoma(dsEnfFam.getString("sintoma"));
				servMedicoRRHH1.setObservacion(dsEnfFam.getString("observacion"));
				servMedicoRRHH1.setActivo(dsEnfFam.getBoolean("activo"));
				servMedicoRRHH1.setJustifica(dsEnfFam.getBoolean("justifica"));

				legajo.addEnfermedadFamiliar(servMedicoRRHH1);

				dsEnfFam.next();
			}

			IDataSet dsCartasRemitidasLega = dataset.getDataSet("TCartasDocRemitidas");
			dsCartasRemitidasLega.first();
			while (!dsCartasRemitidasLega.EOF()) {

				CartasDocRemLega cartasDocRemLega = CartasDocRemLega.findByOid(dsCartasRemitidasLega.getInteger("oid_carta_remitida"), this.getSesion());
				cartasDocRemLega.setNro_orden(dsCartasRemitidasLega.getInteger("nro_orden"));
				cartasDocRemLega.setLegajo(Legajo.findByOidProxy(dsCartasRemitidasLega.getInteger("oid_legajo"), this.getSesion()));
				cartasDocRemLega.setNro_carta_doc(dsCartasRemitidasLega.getString("nro_carta_doc"));
				cartasDocRemLega.setFecha(dsCartasRemitidasLega.getDate("fecha"));
				cartasDocRemLega.setTipocausa(TipoCausaLegales.findByOidProxy(dsCartasRemitidasLega.getInteger("oid_tipo_causa"), this.getSesion()));
				cartasDocRemLega.setCausa(dsCartasRemitidasLega.getString("causa"));
				cartasDocRemLega.setRecibido(dsCartasRemitidasLega.getDate("recibido"));
				cartasDocRemLega.setObservaciones(dsCartasRemitidasLega.getString("observaciones"));
				cartasDocRemLega.setActivo(dsCartasRemitidasLega.getBoolean("activo"));

				legajo.addCartasDocRemLeg(cartasDocRemLega);

				dsCartasRemitidasLega.next();
			}

			IDataSet dsAccLab = dataset.getDataSet("TAccidenteLaboral");
			dsAccLab.first();
			while (!dsAccLab.EOF()) {
				ServicioMedicoRRHH servMedicoRRHH1 = ServicioMedicoRRHH.findByOid(dsAccLab.getInteger("oid_acc_lab"), this.getSesion());
				servMedicoRRHH1.setLegajo(Legajo.findByOidProxy(dsAccLab.getInteger("oid_legajo"), this.getSesion()));
				servMedicoRRHH1.setTipo_serv_med(ServicioMedicoRRHH.SM_ACCLAB);
				servMedicoRRHH1.setNro_nov_sist_ext(dsAccLab.getInteger("nro_nov_sist_ext"));
				servMedicoRRHH1.setFec_inicio(dsAccLab.getDate("fec_inicio"));
				servMedicoRRHH1.setFec_final(dsAccLab.getDate("fec_final"));
				servMedicoRRHH1.setDias(dsAccLab.getInteger("dias"));
				servMedicoRRHH1.setAparato(AparatoRRHH.findByOidProxy(dsAccLab.getInteger("oid_aparato"), this.getSesion()));
				servMedicoRRHH1.setEnfermedad(EnfermedadRRHH.findByOidProxy(dsAccLab.getInteger("oid_enfermedad"), this.getSesion()));
				servMedicoRRHH1.setFecAccidente(dsAccLab.getDate("fec_accidente"));
				servMedicoRRHH1.setDescAccidente(dsAccLab.getString("desc_accidente"));
				servMedicoRRHH1.setSintoma(dsAccLab.getString("sintoma"));
				servMedicoRRHH1.setObservacion(dsAccLab.getString("observacion"));
				servMedicoRRHH1.setActivo(dsAccLab.getBoolean("activo"));
				servMedicoRRHH1.setFecControl(dsAccLab.getDate("fec_control"));

				legajo.addAccidenteLaboral(servMedicoRRHH1);
				dsAccLab.next();
			}

			IDataSet dsPlanifLeg = dataset.getDataSet("TFechaRota");
			dsPlanifLeg.first();
			while (!dsPlanifLeg.EOF()) {
				Rota rota = Rota.findByOidProxy(dsPlanifLeg.getInteger("oid_rota"), this.getSesion());
				java.util.Date fecha = dsPlanifLeg.getDate("fecha");

				if (dsPlanifLeg.getBoolean("activo").booleanValue() == false) {
					LegajoRotaFecha legajoRotaFecha = LegajoRotaFecha.getLegajoFechaRota(fecha, legajo, rota, this.getSesion());
					if (legajoRotaFecha != null) {
						legajoRotaFecha.delete();
						legajo.addPlanifDiaRota(legajoRotaFecha);
					}
				} else {
					LegajoRotaFecha legajoRotaFecha = LegajoRotaFecha.getLegajoFechaRota(fecha, legajo, rota, this.getSesion());
					if (legajoRotaFecha == null) {
						legajoRotaFecha = (LegajoRotaFecha) LegajoRotaFecha.getNew(LegajoRotaFecha.NICKNAME, this.getSesion());
						legajoRotaFecha.setLegajo(legajo);
						legajoRotaFecha.setRota(rota);
						legajoRotaFecha.setFecha(fecha);
						legajoRotaFecha.setActivo(true);
						legajo.addPlanifDiaRota(legajoRotaFecha);
					}

					Integer oidFechaRota = dsPlanifLeg.getInteger("oid_fecha_rota");
					if ((oidFechaRota != null) && (oidFechaRota > 0)) {
						LegajoRotaFecha legajoRotaFechaABorrar = LegajoRotaFecha.findByOid(oidFechaRota, this.getSesion());
						if ((legajoRotaFechaABorrar.getFecha().equals(legajoRotaFecha.getFecha())) && (legajoRotaFechaABorrar.getRota().getOID() == legajoRotaFecha.getRota().getOID())) {
							// Si es igual no hacer nada
						} else {
							legajoRotaFechaABorrar.delete();
							legajo.addPlanifDiaRota(legajoRotaFechaABorrar);
						}
					}

				}

				dsPlanifLeg.next();
			}

			// Procesar los registros de los Motivos
			IDataSet dsMotivos = dataset.getDataSet("TMotAccesosIntermedios");
			dsMotivos.first();
			while (!dsMotivos.EOF()) {
				MotivoEntIntermedias motivo = MotivoEntIntermedias.findByOidProxy(dsMotivos.getInteger("oid_motivo"), this.getSesion());
				if (dsMotivos.getBoolean("habilitado")) {
					MotEntInterLeg motEntInterLeg = MotEntInterLeg.getMotEntInterLeg(legajo, motivo, this.getSesion());
					if (motEntInterLeg == null) {
						MotEntInterLeg motEntInterLegNew = (MotEntInterLeg) MotEntInterLeg.getNew(MotEntInterLeg.NICKNAME, this.getSesion());
						motEntInterLegNew.setLegajo(legajo);
						motEntInterLegNew.setMotivo(motivo);
						motEntInterLegNew.setActivo(true);
						legajo.addMotivoAccesoInter(motEntInterLegNew);
					}

				} else {
					// Deshabilitado
					MotEntInterLeg motEntInterLeg = MotEntInterLeg.getMotEntInterLeg(legajo, motivo, this.getSesion());
					if (motEntInterLeg != null) {
						motEntInterLeg.delete();
						legajo.addMotivoAccesoInter(motEntInterLeg);
					}

				}

				dsMotivos.next();
			}

			// Procesar las categorias de Accesos Internos
			IDataSet dsCategAccesosInternos = dataset.getDataSet("TCatAccInternos");
			dsCategAccesosInternos.first();
			while (!dsCategAccesosInternos.EOF()) {
				CategAccesoCIP categoria = CategAccesoCIP.findByOidProxy(dsCategAccesosInternos.getInteger("OID_CATEG_ACCESO"), this.getSesion());
				if (dsCategAccesosInternos.getBoolean("ACTIVO")) {
					CategAccesoLegajo categAccesoLegajo = CategAccesoLegajo.getCategAccesoLegajo(categoria, legajo, this.getSesion());
					if (categAccesoLegajo == null) {
						CategAccesoLegajo categAccesoLegajoNew = (CategAccesoLegajo) CategAccesoLegajo.getNew(CategAccesoLegajo.NICKNAME, this.getSesion());
						categAccesoLegajoNew.setLegajo(legajo);
						categAccesoLegajoNew.setCategoria(categoria);
						categAccesoLegajoNew.setActivo(true);
						legajo.addCategoriaAccesoInterno(categAccesoLegajoNew);
					}

				} else {
					// Deshabilitado
					CategAccesoLegajo categAccesoLegajo = CategAccesoLegajo.getCategAccesoLegajo(categoria, legajo, this.getSesion());
					if (categAccesoLegajo != null) {
						categAccesoLegajo.delete();
						legajo.addCategoriaAccesoInterno(categAccesoLegajo);
					}

				}

				dsCategAccesosInternos.next();
			}

			addTransaccion(legajo);
			dataset.next();
		}
	}

	private void grabarValoresClasif(Legajo legajo, IDataSet dsSujeto) throws BaseException {
		IDataSet dsValClasif = dsSujeto.getDataSet("TValoresClasificadores");
		dsValClasif.first();
		while (!dsValClasif.EOF()) {
			legajo.addOidValorClasif(dsValClasif.getInteger("nro_clasif"), dsValClasif.getInteger("oid_val_clasif_ent"));
			dsValClasif.next();
		}
	}

}
