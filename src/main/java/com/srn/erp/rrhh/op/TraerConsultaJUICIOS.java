package com.srn.erp.rrhh.op;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.cip.bm.UtilCIP;
import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.legales.bm.Abogado;
import com.srn.erp.legales.bm.EmpresaJuicio;
import com.srn.erp.legales.bm.EstadoJuicio;
import com.srn.erp.legales.bm.EstadoProcesal;
import com.srn.erp.legales.bm.Fuero;
import com.srn.erp.legales.bm.Juicio;
import com.srn.erp.legales.bm.Juzgado;
import com.srn.erp.legales.bm.ResultadoJuicio;
import com.srn.erp.legales.bm.TipoReclamoLeg;
import com.srn.erp.sueldos.bm.Legajo;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bm.Varios.CalculadorMoney;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerConsultaJUICIOS extends Operation {

	ClasificadorEntidad clasifEmpresa = null;
	ClasificadorEntidad clasifSector = null;
	ClasificadorEntidad clasifPuesto = null;
	ClasificadorEntidad clasifEstado = null;

	public TraerConsultaJUICIOS() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		IDataSet dsInput = mapaDatos.getDataSet("Tinput");
		IDataSet dsJuzgado = mapaDatos.getDataSet("TJuzgado");
		IDataSet dsEstadosProcesales = mapaDatos.getDataSet("TEstadosProcesales");
		IDataSet dsResulProbJuicio = mapaDatos.getDataSet("TResulProbJuicio");
		IDataSet dsTipoReclamo = mapaDatos.getDataSet("TSelTipoReclamo");
		IDataSet dsAbogados = mapaDatos.getDataSet("TAbogados");
		IDataSet dsResulJuicio = mapaDatos.getDataSet("TResultadoJuicio");
		IDataSet dsEstadoJuicio = mapaDatos.getDataSet("TEstadoJuicio");
		IDataSet dsLegajos = mapaDatos.getDataSet("TSelLegajos");
		IDataSet dsEmpresas = mapaDatos.getDataSet("TSelEmpresas");
		IDataSet dsSector = mapaDatos.getDataSet("TSelSector");
		IDataSet dsPuesto = mapaDatos.getDataSet("TSelPuesto");
		IDataSet dsEstado = mapaDatos.getDataSet("TSelEstado");
		IDataSet dsFuero = mapaDatos.getDataSet("TFuero");

		java.util.Date fecActual = Fecha.getFechaTruncada(UtilCIP.getFechaHoraActual(this.getSesion()));

		traerDatos(fecActual, dsInput, dsJuzgado, dsEstadosProcesales, dsResulProbJuicio, dsTipoReclamo, dsAbogados, dsResulJuicio, dsEstadoJuicio, dsLegajos, dsEmpresas, dsSector, dsPuesto,
				dsEstado, dsFuero);

	}

	private void traerDatos(java.util.Date fecActual, IDataSet dsInput, IDataSet dsJuzgado, IDataSet dsEstadosProcesales, IDataSet dsResultProbJuicio, IDataSet dsTipoReclamos, IDataSet dsAbogados,
			IDataSet dsResulJuicio, IDataSet dsEstadoJuicio, IDataSet dsLegajos, IDataSet dsEmpresas, IDataSet dsSectores, IDataSet dsPuestos, IDataSet dsEstados, IDataSet dsFuero)
			throws BaseException {

		clasifEmpresa = TraerLeyendasRepEval.getClasificadorEmpresa(this.getSesion());
		clasifSector = TraerLeyendasRepEval.getClasificadorSector(this.getSesion());
		clasifPuesto = TraerLeyendasRepEval.getClasificadorPuesto(this.getSesion());
		clasifEstado = TraerLeyendasRepEval.getClasificadorEstado(this.getSesion());

		java.util.Date fecDesde = null;
		java.util.Date fecHasta = null;
		Money montoDesde = null;
		Money montoHasta = null;
		String codigoInterno = null;

		boolean soloCondAudPend = false;
		boolean soloConsPrevFinan = false;
		boolean soloConEmbargos = false;

		List juzgados = new ArrayList();
		List estadosProcesales = new ArrayList();
		List resulProbJuicio = new ArrayList();
		List tiposReclamos = new ArrayList();
		List abogados = new ArrayList();
		List resulJuicios = new ArrayList();
		List estadoJuicios = new ArrayList();
		List legajos = new ArrayList();
		List empresas = new ArrayList();
		List sectores = new ArrayList();
		List puestos = new ArrayList();
		List estados = new ArrayList();
		List fueros = new ArrayList();

		dsInput.first();
		while (!dsInput.EOF()) {
			fecDesde = dsInput.getDate("fec_rec_desde");
			fecHasta = dsInput.getDate("fec_rec_hasta");
			montoDesde = dsInput.getMoney("monto_desde");
			montoHasta = dsInput.getMoney("monto_hasta");
			codigoInterno = dsInput.getString("codigo_interno");
			if (dsInput.getBoolean("solo_con_aud_pend") != null)
				soloCondAudPend = dsInput.getBoolean("solo_con_aud_pend");

			if (dsInput.getBoolean("solo_con_prev_finan") != null)
				soloConsPrevFinan = dsInput.getBoolean("solo_con_prev_finan");

			if (dsInput.getBoolean("solo_con_embargos") != null)
				soloConEmbargos = dsInput.getBoolean("solo_con_embargos");

			dsInput.next();
		}

		dsJuzgado.first();
		while (!dsJuzgado.EOF()) {
			if (dsJuzgado.getBoolean("sel")) {
				Juzgado juzgado = Juzgado.findByOidProxy(dsJuzgado.getInteger("oid"), this.getSesion());
				juzgados.add(juzgado);
			}
			dsJuzgado.next();
		}

		dsEstadosProcesales.first();
		while (!dsEstadosProcesales.EOF()) {
			if (dsEstadosProcesales.getBoolean("sel")) {
				EstadoProcesal estadoProcesal = EstadoProcesal.findByOidProxy(dsEstadosProcesales.getInteger("oid"), this.getSesion());
				estadosProcesales.add(estadoProcesal);
			}
			dsEstadosProcesales.next();
		}

		dsFuero.first();
		while (!dsFuero.EOF()) {
			if (dsFuero.getBoolean("sel")) {
				Fuero fuero = Fuero.findByOidProxy(dsFuero.getInteger("oid_fuero"), this.getSesion());
				fueros.add(fuero);
			}
			dsFuero.next();
		}

		dsResultProbJuicio.first();
		while (!dsResultProbJuicio.EOF()) {
			if (dsResultProbJuicio.getBoolean("sel")) {
				String codigoResProbJuicio = dsResultProbJuicio.getString("codigo");
				resulProbJuicio.add(codigoResProbJuicio);
			}
			dsResultProbJuicio.next();
		}

		dsTipoReclamos.first();
		while (!dsTipoReclamos.EOF()) {
			if (dsTipoReclamos.getBoolean("sel")) {
				TipoReclamoLeg tipoReclamo = TipoReclamoLeg.findByOidProxy(dsTipoReclamos.getInteger("oid_tipo_reclamo"), this.getSesion());
				tiposReclamos.add(tipoReclamo);
			}
			dsTipoReclamos.next();
		}

		dsAbogados.first();
		while (!dsAbogados.EOF()) {
			if (dsAbogados.getBoolean("sel")) {
				Abogado abogado = Abogado.findByOidProxy(dsAbogados.getInteger("oid_abogado"), this.getSesion());
				abogados.add(abogado);
			}
			dsAbogados.next();
		}

		dsResulJuicio.first();
		while (!dsResulJuicio.EOF()) {
			if (dsResulJuicio.getBoolean("sel")) {
				ResultadoJuicio resultadoJuicio = ResultadoJuicio.findByOidProxy(dsResulJuicio.getInteger("oid"), this.getSesion());
				resulJuicios.add(resultadoJuicio);
			}
			dsResulJuicio.next();
		}

		dsEstadoJuicio.first();
		while (!dsEstadoJuicio.EOF()) {
			if (dsEstadoJuicio.getBoolean("sel")) {
				EstadoJuicio estadoJuicio = EstadoJuicio.findByOidProxy(dsEstadoJuicio.getInteger("oid"), this.getSesion());
				estadoJuicios.add(estadoJuicio);
			}
			dsEstadoJuicio.next();
		}

		dsLegajos.first();
		while (!dsLegajos.EOF()) {
			if (dsLegajos.getBoolean("sel")) {
				Legajo legajo = Legajo.findByOidProxy(dsLegajos.getInteger("oid_legajo"), this.getSesion());
				legajos.add(legajo);
			}
			dsLegajos.next();
		}

		dsEmpresas.first();
		while (!dsEmpresas.EOF()) {
			if (dsEmpresas.getBoolean("sel")) {
				EmpresaJuicio empresaJuicio = EmpresaJuicio.findByOidProxy(dsEmpresas.getInteger("oid_empresa"), this.getSesion());
				empresas.add(empresaJuicio);
			}
			dsEmpresas.next();
		}

		dsSectores.first();
		while (!dsSectores.EOF()) {
			if (dsSectores.getBoolean("sel")) {
				ValorClasificadorEntidad sector = ValorClasificadorEntidad.findByOidProxy(dsSectores.getInteger("oid_sector"), this.getSesion());
				sectores.add(sector);
			}
			dsSectores.next();
		}

		dsPuestos.first();
		while (!dsPuestos.EOF()) {
			if (dsPuestos.getBoolean("sel")) {
				ValorClasificadorEntidad puesto = ValorClasificadorEntidad.findByOidProxy(dsPuestos.getInteger("oid_puesto"), this.getSesion());
				puestos.add(puesto);
			}
			dsPuestos.next();
		}

		dsEstados.first();
		while (!dsEstados.EOF()) {
			if (dsEstados.getBoolean("sel")) {
				ValorClasificadorEntidad estado = ValorClasificadorEntidad.findByOidProxy(dsEstados.getInteger("oid_estado"), this.getSesion());
				estados.add(estado);
			}
			dsEstados.next();
		}

		IDataSet ds = getDataSetConsJUICIO();

		Iterator iterJuicios = Juicio.getJuicios(fecDesde, fecHasta, montoDesde, montoHasta, codigoInterno, soloCondAudPend, soloConsPrevFinan, soloConEmbargos, juzgados, estadosProcesales,
				resulProbJuicio, tiposReclamos, abogados, resulJuicios, estadoJuicios, legajos, empresas, sectores, puestos, estados, fueros , this.getSesion()).iterator();

		while (iterJuicios.hasNext()) {

			Juicio juicio = (Juicio) iterJuicios.next();

			if (juicio.getLegajo() != null)
				juicio.getLegajo().supportRefresh();

			ValorClasificadorEntidad valorClasifEmp = null;
			if (juicio.getLegajo() != null)
				valorClasifEmp = juicio.getLegajo().getValorClasifEnt(clasifEmpresa);
			String empresa = "";
			if (valorClasifEmp != null)
				empresa = valorClasifEmp.getDescripcion();

			ValorClasificadorEntidad valorClasifPue = null;
			if (juicio.getLegajo() != null)
				valorClasifPue = juicio.getLegajo().getValorClasifEnt(clasifPuesto);
			String puesto = "";
			if (valorClasifPue != null)
				puesto = valorClasifPue.getDescripcion();

			ValorClasificadorEntidad valorClasifSec = null;
			if (juicio.getLegajo() != null)
				valorClasifSec = juicio.getLegajo().getValorClasifEnt(clasifSector);
			String sector = "";
			if (valorClasifSec != null)
				sector = valorClasifSec.getDescripcion();

			cargaConsJuicio(fecActual, ds, juicio, clasifEmpresa, clasifPuesto, clasifSector);

		}

		writeCliente(ds);

	}

	private IDataSet getDataSetConsJUICIO() {
		IDataSet dataset = new TDataSet();
		dataset.create("TConsJUICIO");
		dataset.fieldDef(new Field("codigo_interno", Field.STRING, 50));
		dataset.fieldDef(new Field("legajo", Field.STRING, 50));
		dataset.fieldDef(new Field("ape_y_nom", Field.STRING, 255));
		dataset.fieldDef(new Field("procedencia", Field.STRING, 1000));
		dataset.fieldDef(new Field("requerido", Field.MEMO, 0));
		dataset.fieldDef(new Field("puesto", Field.STRING, 255));
		dataset.fieldDef(new Field("seco", Field.STRING, 255));
		dataset.fieldDef(new Field("fec_ant_reco", Field.DATE, 0));
		dataset.fieldDef(new Field("fec_ing_real", Field.DATE, 0));
		dataset.fieldDef(new Field("fec_egreso", Field.DATE, 0));
		dataset.fieldDef(new Field("tipo_reclamo", Field.STRING, 100));
		dataset.fieldDef(new Field("observaciones", Field.MEMO, 0));
		dataset.fieldDef(new Field("fec_recepcion", Field.DATE, 0));
		dataset.fieldDef(new Field("monto_reclamo", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("monto_acuerdo", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("monto_interes", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("hono_letrado", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("hono_conciliador", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("hono_perito", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("hono_justicia", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("pagado", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("audiencias", Field.MEMO, 0));
		dataset.fieldDef(new Field("docu_enviada", Field.MEMO, 0));
		dataset.fieldDef(new Field("pagos_realizados", Field.MEMO, 0));
		dataset.fieldDef(new Field("motivo_egreso", Field.STRING, 100));
		dataset.fieldDef(new Field("etapa_procesal", Field.STRING, 100));
		dataset.fieldDef(new Field("juzgado", Field.MEMO, 0));
		dataset.fieldDef(new Field("fec_novedad", Field.DATE, 0));
		dataset.fieldDef(new Field("resultado_juicio", Field.STRING, 50));
		dataset.fieldDef(new Field("porc_prevision", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("estimado", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("rubros_condena", Field.MEMO, 0));
		dataset.fieldDef(new Field("nro_expediente", Field.STRING, 100));
		dataset.fieldDef(new Field("abogado", Field.STRING, 255));
		dataset.fieldDef(new Field("estado_juicio", Field.STRING, 100));
		dataset.fieldDef(new Field("periodo", Field.STRING, 10));
		dataset.fieldDef(new Field("prev_finanzas", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("seguimiento", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("embargo", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("tipo_pericia", Field.STRING, 100));
		dataset.fieldDef(new Field("oid_fuero", Field.STRING, 100));
		dataset.fieldDef(new Field("fuero", Field.STRING, 100));
		dataset.fieldDef(new Field("rubro_reclamo", Field.MEMO, 0));
		dataset.fieldDef(new Field("oid_comp_seg_cau", Field.INTEGER, 0));
		dataset.fieldDef(new Field("desc_comp_seg_cau", Field.STRING, 100));
		dataset.fieldDef(new Field("caratula", Field.STRING, 250));
		dataset.fieldDef(new Field("porc_incapacidad", Field.DOUBLE, 0));
		dataset.fieldDef(new Field("primera_instancia", Field.MEMO, 0));
		dataset.fieldDef(new Field("segunda_instancia", Field.MEMO, 0));
		
		
		
		return dataset;
	}

	private void cargaConsJuicio(java.util.Date fecActual, IDataSet dsConsJuicio, Juicio juicio, ClasificadorEntidad clasifEmpresa, ClasificadorEntidad clasifPuesto, ClasificadorEntidad clasifSector)
			throws BaseException {

		if (juicio.getLegajo() == null)
			return;

		dsConsJuicio.append();
		dsConsJuicio.fieldValue("codigo_interno", juicio.getCodigoInterno());
		dsConsJuicio.fieldValue("legajo", juicio.getLegajo().getNro_legajo());
		dsConsJuicio.fieldValue("ape_y_nom", juicio.getLegajo().getApellidoyNombre());

		ValorClasificadorEntidad valorClasifEmp = juicio.getLegajo().getValorClasifEnt(clasifEmpresa);
		String empresa = "";
		if (valorClasifEmp != null)
			empresa = valorClasifEmp.getDescripcion();

		dsConsJuicio.fieldValue("procedencia", empresa);

		ValorClasificadorEntidad valorClasifPue = juicio.getLegajo().getValorClasifEnt(clasifPuesto);
		String puesto = "";
		if (valorClasifPue != null)
			puesto = valorClasifPue.getDescripcion();

		ValorClasificadorEntidad valorClasifSec = juicio.getLegajo().getValorClasifEnt(clasifSector);
		String sector = "";
		if (valorClasifSec != null)
			sector = valorClasifSec.getDescripcion();

		dsConsJuicio.fieldValue("requerido", juicio.getStringRequeridos());
		dsConsJuicio.fieldValue("puesto", puesto);
		dsConsJuicio.fieldValue("seco", sector);

		dsConsJuicio.fieldValue("fec_ant_reco", juicio.getLegajo().getFecAntReconocimiento());
		dsConsJuicio.fieldValue("fec_ing_real", juicio.getLegajo().getFecIngreso());
		dsConsJuicio.fieldValue("fec_egreso", juicio.getLegajo().getFecRetiro());
		if (juicio.getTipo_reclamo() != null)
			dsConsJuicio.fieldValue("tipo_reclamo", juicio.getTipo_reclamo().getDescripcion());
		else
			dsConsJuicio.fieldValue("tipo_reclamo", "");
		dsConsJuicio.fieldValue("observaciones", juicio.getObservaciones());
		dsConsJuicio.fieldValue("fec_recepcion", juicio.getFec_rec_dem());
		dsConsJuicio.fieldValue("monto_reclamo", juicio.getMonto_reclamo());

		CalculadorMoney calcTotal = new CalculadorMoney(new Money(0));
		Money montoAcuerdo = juicio.getMontoAcuerdo();
		Money montoInteres = juicio.getMontoIntereses();
		Money honorarioLetra = juicio.getMontoLetrado();
		Money montoConciliador = juicio.getMontoConciliador();
		Money montoPerito = juicio.getMontoPerito();
		Money montoJusticia = juicio.getMontoTasaJusticia();

		if (montoAcuerdo != null)
			calcTotal.sumar(montoAcuerdo);
		if (montoInteres != null)
			calcTotal.sumar(montoInteres);		
		if (honorarioLetra != null)
			calcTotal.sumar(honorarioLetra);
		if (montoConciliador != null)
			calcTotal.sumar(montoConciliador);
		if (montoPerito != null)
			calcTotal.sumar(montoPerito);
		if (montoJusticia != null)
			calcTotal.sumar(montoJusticia);

		dsConsJuicio.fieldValue("monto_acuerdo", montoAcuerdo);
		dsConsJuicio.fieldValue("monto_interes", montoInteres);
		dsConsJuicio.fieldValue("hono_letrado", honorarioLetra);
		dsConsJuicio.fieldValue("hono_conciliador", montoConciliador);
		dsConsJuicio.fieldValue("hono_perito", montoPerito);
		dsConsJuicio.fieldValue("hono_justicia", montoJusticia);

		dsConsJuicio.fieldValue("pagado", calcTotal.getResultMoney());
		dsConsJuicio.fieldValue("audiencias", juicio.getLeyendasAudiencias(fecActual));
		dsConsJuicio.fieldValue("docu_enviada", juicio.getLeyendasDocEnviada());
		dsConsJuicio.fieldValue("pagos_realizados", juicio.getLeyendasPagosRealizados());

		String motivoEgreso = "";
		if (juicio.getLegajo().getMotivoEgresoEmp() != null)
			motivoEgreso = juicio.getLegajo().getMotivoEgresoEmp().getDescripcion();

		dsConsJuicio.fieldValue("motivo_egreso", motivoEgreso);

		String etapaProcesal = null;
		if (juicio.getEstado_procesal() != null)
			etapaProcesal = juicio.getEstado_procesal().getDescripcion();

		String juzgado = null;
		if (juicio.getJuzgado() != null)
			juzgado = juicio.getJuzgado().getDescripcion();
		dsConsJuicio.fieldValue("etapa_procesal", etapaProcesal);
		dsConsJuicio.fieldValue("juzgado", juzgado);
		dsConsJuicio.fieldValue("fec_novedad", juicio.getFecNovedad());

		String resultadoJuicio = null;
		if (juicio.getResultadoJuicio() != null)
			resultadoJuicio = juicio.getResultadoJuicio().getDescripcion();
		dsConsJuicio.fieldValue("resultado_juicio", resultadoJuicio);

		dsConsJuicio.fieldValue("porc_prevision", juicio.getPorc_prevision());
		dsConsJuicio.fieldValue("estimado", juicio.getEstimado());
		dsConsJuicio.fieldValue("rubros_condena", juicio.getLeyendasRubrosCondena());
		dsConsJuicio.fieldValue("nro_expediente", juicio.getNro_expediente());
		if (juicio.getAbogado() != null)
			dsConsJuicio.fieldValue("abogado", juicio.getAbogado().getApeyNom());
		else
			dsConsJuicio.fieldValue("abogado", "");
		if (juicio.getEstado_juicio() != null)
			dsConsJuicio.fieldValue("estado_juicio", juicio.getEstado_juicio().getDescripcion());
		else
			dsConsJuicio.fieldValue("estado_juicio", "");

		if (juicio.getPeriodo_mensual() != null)
			dsConsJuicio.fieldValue("periodo", juicio.getPeriodo_mensual().getCodigo());
		else
			dsConsJuicio.fieldValue("periodo", "");
		dsConsJuicio.fieldValue("prev_finanzas", juicio.getPrevision());
		dsConsJuicio.fieldValue("seguimiento", juicio.getLegajo().isSeguiLegales());
		dsConsJuicio.fieldValue("embargo", juicio.getEmbargo());
		if (juicio.getTipoPericia() != null)
			dsConsJuicio.fieldValue("tipo_pericia", juicio.getTipoPericia().getDescripcion());
		else
			dsConsJuicio.fieldValue("tipo_pericia", "");
		
		if (juicio.getFuero() != null) {
			dsConsJuicio.fieldValue("oid_fuero", juicio.getFuero().getOIDInteger());
			dsConsJuicio.fieldValue("fuero", juicio.getFuero().getDescripcion());
		}
		else {
			dsConsJuicio.fieldValue("oid_fuero", "");
			dsConsJuicio.fieldValue("fuero", "");
		}
		
		dsConsJuicio.fieldValue("rubro_reclamo", juicio.getLeyendaRubroReclamo());
		if (juicio.getCompaniaSeguroCaucion()!=null) {
			dsConsJuicio.fieldValue("oid_comp_seg_cau", juicio.getCompaniaSeguroCaucion().getOIDInteger());
			dsConsJuicio.fieldValue("desc_comp_seg_cau", juicio.getCompaniaSeguroCaucion().getDescripcion());
		} else {
			dsConsJuicio.fieldValue("oid_comp_seg_cau", "");
			dsConsJuicio.fieldValue("desc_comp_seg_cau", "");			
		}
		
		dsConsJuicio.fieldValue("caratula", juicio.getCaratula());
		dsConsJuicio.fieldValue("porc_incapacidad", juicio.getPorcIncapacidad());
		dsConsJuicio.fieldValue("primera_instancia", juicio.getPrimeraInstancia());
		dsConsJuicio.fieldValue("segunda_instancia", juicio.getSegundaInstancia());
		
		

	}

}
