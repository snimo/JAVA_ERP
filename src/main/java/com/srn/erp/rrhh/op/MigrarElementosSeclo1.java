package com.srn.erp.rrhh.op;

import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.legales.bm.ConcPagoSeclo;
import com.srn.erp.legales.bm.EmpresaJuicio;
import com.srn.erp.legales.bm.EstadoJuicio;
import com.srn.erp.legales.bm.EstadoProcesal;
import com.srn.erp.legales.bm.Juicio;
import com.srn.erp.legales.bm.JuicioEmpresa;
import com.srn.erp.legales.bm.Juzgado;
import com.srn.erp.legales.bm.PagoJuicio;
import com.srn.erp.legales.bm.TipoReclamoLeg;
import com.srn.erp.sueldos.bm.Legajo;

import framework.applicarionServer.bm.Varios.CalculadorMoney;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class MigrarElementosSeclo1 extends Operation {

	public MigrarElementosSeclo1() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		IDataSet dataset = mapaDatos.getDataSet("TJuicios");
		boolean soloValidar = false;
		if (mapaDatos.containsKey("solo_validar"))
			soloValidar = true;
		procesarRegistros(dataset, soloValidar);

	}

	private void procesarRegistros(IDataSet dataset, boolean soloValidar) throws BaseException {

		IDataSet dsLegNoEnc = getDataSetLegNoEnc();
		IDataSet dsErroresEnc = getDataSetErroresEnc();
		IDataSet dsRegNoMig = getDataSetRegNoMigrados();
		IDataSet dsMigOK = getDataSetMigradosOK();

		ClasificadorEntidad clasifEmpresa = TraerLeyendasRepEval.getClasificadorEmpresa(this.getSesion());

		dataset.first();
		while (!dataset.EOF()) {

			// Buscar Legajo
			String codigoLegajo = dataset.getString("legajo").trim().toUpperCase();

			try {
				// Verificar si es numerico
				int elNumero = new Integer(codigoLegajo);
				String numeriString = elNumero + "";
				if (numeriString.length() == 3)
					codigoLegajo = "0" + codigoLegajo;
			} catch (Exception e) {

			}

			Legajo legajo = Legajo.findByCodigo(codigoLegajo, this.getSesion());

			if (legajo == null) {
				cargarRegistroLegNoEnc(dsLegNoEnc, dataset.getString("legajo"), dataset.getString("ape_y_nom"));
				cargarRegistroNoMigrados(dsRegNoMig, dataset.getString("codigo_interno"), "Sin legajo en Base.");
				dataset.next();
				continue;
			}

			// Valor clasificador entidad
			ValorClasificadorEntidad valorClasifReq = null;
			EmpresaJuicio empresaJuicio = null;
			EmpresaJuicio empresaJuicio1 = null;
			EmpresaJuicio empresaJuicio2 = null;
			EmpresaJuicio empresaJuicio3 = null;
			EmpresaJuicio empresaJuicio4 = null;

			if ((dataset.getString("empresa") != null) && (dataset.getString("empresa").trim() != "")) {
				valorClasifReq = clasifEmpresa.getValorClasifEnt(dataset.getString("empresa"));
				if (valorClasifReq == null) {
					cargarRegistroError(dsErroresEnc, dataset.getString("codigo_interno"), "No se encontro el codigo de Empresa " + dataset.getString("empresa"));
					cargarRegistroNoMigrados(dsRegNoMig, dataset.getString("codigo_interno"), "No se encontro el codigo de Empresa " + dataset.getString("empresa"));
				}

				// Con la procedencia buscar la empresa juicio
				empresaJuicio = EmpresaJuicio.findByCodigo(valorClasifReq.getCodigo(), this.getSesion());

				if (empresaJuicio == null) {
					cargarRegistroError(dsErroresEnc, dataset.getString("codigo_interno"), "No se encontro el codigo de Empresa Juicio " + dataset.getString("empresa"));
					cargarRegistroNoMigrados(dsRegNoMig, dataset.getString("codigo_interno"), "No se encontro el codigo de Empresa Juicio " + dataset.getString("empresa"));
				}

			}

			String d1 = dataset.getString("D1");
			String d2 = dataset.getString("D2");
			String d3 = dataset.getString("D3");
			String d4 = dataset.getString("D4");

			if ((d1 != null) && (d1.trim() != "")) {
				empresaJuicio1 = EmpresaJuicio.getEmpresaJuicio(d1, this.getSesion());
				if (empresaJuicio1 == null) {
					cargarRegistroError(dsErroresEnc, dataset.getString("codigo_interno"), "No se encontro la Empresa Juicio con descripción " + dataset.getString("D1"));
					cargarRegistroNoMigrados(dsRegNoMig, dataset.getString("codigo_interno"), "No se encontro la Empresa Juicio con descripción " + dataset.getString("D1"));
				}
			}

			if ((d2 != null) && (d2.trim() != "")) {
				empresaJuicio2 = EmpresaJuicio.getEmpresaJuicio(d2, this.getSesion());
				if (empresaJuicio2 == null) {
					cargarRegistroError(dsErroresEnc, dataset.getString("codigo_interno"), "No se encontro la Empresa Juicio con descripción " + dataset.getString("D2"));
					cargarRegistroNoMigrados(dsRegNoMig, dataset.getString("codigo_interno"), "No se encontro la Empresa Juicio con descripción " + dataset.getString("D2"));
				}
			}

			if ((d3 != null) && (d3.trim() != "")) {
				empresaJuicio3 = EmpresaJuicio.getEmpresaJuicio(d3, this.getSesion());
				if (empresaJuicio3 == null) {
					cargarRegistroError(dsErroresEnc, dataset.getString("codigo_interno"), "No se encontro la Empresa Juicio con descripción " + dataset.getString("D3"));
					cargarRegistroNoMigrados(dsRegNoMig, dataset.getString("codigo_interno"), "No se encontro la Empresa Juicio con descripción " + dataset.getString("D3"));
				}
			}

			if ((d4 != null) && (d4.trim() != "")) {
				empresaJuicio4 = EmpresaJuicio.getEmpresaJuicio(d4, this.getSesion());
				if (empresaJuicio4 == null) {
					cargarRegistroError(dsErroresEnc, dataset.getString("codigo_interno"), "No se encontro la Empresa Juicio con descripción " + dataset.getString("D4"));
					cargarRegistroNoMigrados(dsRegNoMig, dataset.getString("codigo_interno"), "No se encontro la Empresa Juicio con descripción " + dataset.getString("D4"));
				}
			}

			// El cuasal ditracto corresponde al motivo de egreso

			// Obtener el tipo de reclamo
			TipoReclamoLeg tipoReclamoLeg = null;

			if ((dataset.getString("tipo_reclamo") != null) && (dataset.getString("tipo_reclamo").trim() != "")) {
				tipoReclamoLeg = TipoReclamoLeg.getTipoReclamoLeg(dataset.getString("tipo_reclamo"), this.getSesion());
				if (tipoReclamoLeg == null) {
					cargarRegistroError(dsErroresEnc, dataset.getString("codigo_interno"), "No se encontro el tipo de reclamo con descripción " + dataset.getString("tipo_reclamo"));
					cargarRegistroNoMigrados(dsRegNoMig, dataset.getString("codigo_interno"), "No se encontro el tipo de reclamo con descripción " + dataset.getString("tipo_reclamo"));
				}
			}

			EstadoJuicio estadoJuicio = null;

			if ((dataset.getString("estado_juicio") != null) && (dataset.getString("estado_juicio").trim() != "")) {
				estadoJuicio = EstadoJuicio.getEstadoJuicio(dataset.getString("estado_juicio"), this.getSesion());
				if (estadoJuicio == null) {
					cargarRegistroError(dsErroresEnc, dataset.getString("codigo_interno"), "No se encontro el estado de Juicio " + dataset.getString("estado_juicio"));
					cargarRegistroNoMigrados(dsRegNoMig, dataset.getString("codigo_interno"), "No se encontro el estado de Juicio " + dataset.getString("estado_juicio"));
				}
			}

			Money montoReclamo = dataset.getMoney("monto_reclamo");
			String resultado = dataset.getString("resultado");

			Money prevision = dataset.getMoney("prevision");
			Money estimado = dataset.getMoney("estimado");

			EstadoProcesal estadoProcesal = null;
			if ((dataset.getString("etapa_procesal") != null) && (dataset.getString("etapa_procesal").trim() != "")) {
				estadoProcesal = EstadoProcesal.getEstadoProcesal(dataset.getString("etapa_procesal"), this.getSesion());
				if (estadoProcesal == null) {
					cargarRegistroError(dsErroresEnc, dataset.getString("codigo_interno"), "No se encontro la etapa procesal con descripción " + dataset.getString("etapa_procesal"));
					cargarRegistroNoMigrados(dsRegNoMig, dataset.getString("codigo_interno"), "No se encontro la etapa procesal con descripción " + dataset.getString("etapa_procesal"));
				}
			}

			java.util.Date fecRecepcion = dataset.getDate("fec_recepcion");

			String nroExpediente = dataset.getString("nro_expediente");

			Juzgado juzgado = null;
			String nroJuzgado = dataset.getString("nro_juzgado");
			if ((nroJuzgado != null) && (nroJuzgado.trim() != "")) {
				juzgado = Juzgado.findByCodigo(nroJuzgado, this.getSesion());
				if (juzgado == null) {
					cargarRegistroError(dsErroresEnc, dataset.getString("codigo_interno"), "No se encontro el nro. de Juzgado " + dataset.getString("nro_juzgado"));
					cargarRegistroNoMigrados(dsRegNoMig, dataset.getString("codigo_interno"), "No se encontro el nro. de Juzgado " + dataset.getString("nro_juzgado"));
				}
			}

			Money montoAcuerdoCapitla = dataset.getMoney("monto_acuerdo_capital");
			Money montoHonorarioLetrado = dataset.getMoney("monto_honorarios_letrado");
			Money montoHonorarioPerito = dataset.getMoney("monto_honorarios_perito");
			Money montoConcialiado = dataset.getMoney("monto_conciliado");
			Money tasaJusticia = dataset.getMoney("tasa_justicia");

			String observaciones = dataset.getString("observaciones");

			String codigoRubroCadena = dataset.getString("rubros_condena");

			java.util.Date fecNovedad = dataset.getDate("fec_novedad");

			// Grabar el SECLO
			Juicio juicio = (Juicio) Juicio.getNew(Juicio.NICKNAME, this.getSesion());
			juicio.setTipo_reclamo(tipoReclamoLeg);
			juicio.setFec_rec_dem(fecRecepcion);
			juicio.setJuzgado(juzgado);
			juicio.setNro_expediente(nroExpediente);
			juicio.setMonto_reclamo(montoReclamo);
			juicio.setActivo(true);

			if ((resultado != null) && (resultado.trim() != "")) {
				if (resultado.toUpperCase().contains("PROBABLE"))
					juicio.setProb_resultado("PROBABLE");
				else if (resultado.toUpperCase().contains("INCIERTA"))
					juicio.setProb_resultado("INCIERTA");
				else if (resultado.toUpperCase().contains("REMOTA"))
					juicio.setProb_resultado("REMOTA");
			}

			if (prevision != null) {
				CalculadorMoney calcPorcPrev = new CalculadorMoney(prevision);
				calcPorcPrev.multiplicarPor(new Money(100));
				juicio.setPorc_prevision(calcPorcPrev.getResultMoney());
			}

			juicio.setEstimado(estimado);
			juicio.setEstado_procesal(estadoProcesal);
			juicio.setEstado_juicio(estadoJuicio);

			// Armar la Parte de Pagos
			if (((montoAcuerdoCapitla != null) && (montoAcuerdoCapitla.doubleValue() != 0)) || ((montoHonorarioLetrado != null) && (montoHonorarioLetrado.doubleValue() != 0))
					|| ((montoHonorarioPerito != null) && (montoHonorarioPerito.doubleValue() != 0)) || ((montoConcialiado != null) && (montoConcialiado.doubleValue() != 0))
					|| ((tasaJusticia != null) && (tasaJusticia.doubleValue() != 0))) {

				// Armar una lista de Pago
				PagoJuicio pagoJuicio = (PagoJuicio) PagoJuicio.getNew(PagoJuicio.NICKNAME, this.getSesion());
				pagoJuicio.setFec_pago(fecNovedad);
				pagoJuicio.setObservacion("");
				ConcPagoSeclo conceptoPAgo = null;
				try {
					conceptoPAgo = ConcPagoSeclo.findByOid(3001, this.getSesion());
				} catch (Exception e) {
					conceptoPAgo = ConcPagoSeclo.findByOid(10001, this.getSesion());
				}
				pagoJuicio.setConcepto_pago_seclo(conceptoPAgo);
				pagoJuicio.setJuicio(juicio);
				pagoJuicio.setActivo(true);
				pagoJuicio.setPago_acuerdo(montoAcuerdoCapitla);
				pagoJuicio.setPago_horario(montoConcialiado);
				pagoJuicio.setPago_perito(montoHonorarioPerito);
				pagoJuicio.setPagoLetrado(montoHonorarioLetrado);
				pagoJuicio.setPago_tasa_just(tasaJusticia);

				juicio.addPagoJuicio(pagoJuicio);

			}

			// Armar la parte de empresas demandadas

			if (empresaJuicio != null) {
				JuicioEmpresa juicioEmpresa = (JuicioEmpresa) JuicioEmpresa.getNew(JuicioEmpresa.NICKNAME, this.getSesion());
				juicioEmpresa.setEmpresaJuicio(empresaJuicio);
				juicioEmpresa.setJuicio(juicio);
				juicioEmpresa.setActivo(true);
				juicio.addEmpresa(juicioEmpresa);
			}

			if (empresaJuicio1 != null) {
				JuicioEmpresa juicioEmpresa = (JuicioEmpresa) JuicioEmpresa.getNew(JuicioEmpresa.NICKNAME, this.getSesion());
				juicioEmpresa.setEmpresaJuicio(empresaJuicio1);
				juicioEmpresa.setJuicio(juicio);
				juicioEmpresa.setActivo(true);
				juicio.addEmpresa(juicioEmpresa);
			}

			if (empresaJuicio2 != null) {
				JuicioEmpresa juicioEmpresa = (JuicioEmpresa) JuicioEmpresa.getNew(JuicioEmpresa.NICKNAME, this.getSesion());
				juicioEmpresa.setEmpresaJuicio(empresaJuicio2);
				juicioEmpresa.setJuicio(juicio);
				juicioEmpresa.setActivo(true);
				juicio.addEmpresa(juicioEmpresa);
			}

			if (empresaJuicio3 != null) {
				JuicioEmpresa juicioEmpresa = (JuicioEmpresa) JuicioEmpresa.getNew(JuicioEmpresa.NICKNAME, this.getSesion());
				juicioEmpresa.setEmpresaJuicio(empresaJuicio3);
				juicioEmpresa.setJuicio(juicio);
				juicioEmpresa.setActivo(true);
				juicio.addEmpresa(juicioEmpresa);
			}

			if (empresaJuicio4 != null) {
				JuicioEmpresa juicioEmpresa = (JuicioEmpresa) JuicioEmpresa.getNew(JuicioEmpresa.NICKNAME, this.getSesion());
				juicioEmpresa.setEmpresaJuicio(empresaJuicio4);
				juicioEmpresa.setJuicio(juicio);
				juicioEmpresa.setActivo(true);
				juicio.addEmpresa(juicioEmpresa);
			}

			juicio.setCodigoInterno(dataset.getString("codigo_interno"));
			juicio.setFecNovedad(fecNovedad);
			juicio.setPeriodo_mensual(null);
			juicio.setPrevision(null);
			juicio.setAbogado(null);
			juicio.setObservaciones(dataset.getString("observaciones"));
			juicio.setCBU(null);
			juicio.setEmbargo(null);
			juicio.setResultadoJuicio(null);
			juicio.setLegajo(legajo);
			

			if (soloValidar != true) {
				try {
				juicio.save();
				} catch (Exception e) {
					System.out.println("Error:"+e.getMessage()+" "+dataset.getString("codigo_interno"));
				}
			}

			dataset.next();
		}

		writeCliente(dsLegNoEnc);
		writeCliente(dsErroresEnc);
		writeCliente(dsRegNoMig);
		writeCliente(dsMigOK);

	}

	private IDataSet getDataSetLegNoEnc() {
		IDataSet dataset = new TDataSet();
		dataset.create("TLegajosNoEnco");
		dataset.fieldDef(new Field("codigo", Field.STRING, 50));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
		return dataset;
	}

	private IDataSet getDataSetRegNoMigrados() {
		IDataSet dataset = new TDataSet();
		dataset.create("TRegNoMigrados");
		dataset.fieldDef(new Field("codigo", Field.STRING, 50));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
		return dataset;
	}

	private void cargarRegistroNoMigrados(IDataSet dataset, String codigo, String descripcion) {
		dataset.append();
		dataset.fieldValue("codigo", codigo);
		dataset.fieldValue("descripcion", descripcion);
	}

	private void cargarRegistroMigradosOK(IDataSet dataset, String codigo, String descripcion) {
		dataset.append();
		dataset.fieldValue("codigo", codigo);
		dataset.fieldValue("descripcion", descripcion);
	}

	private IDataSet getDataSetErroresEnc() {
		IDataSet dataset = new TDataSet();
		dataset.create("TErroresEnc");
		dataset.fieldDef(new Field("nro_linea", Field.STRING, 50));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 255));
		return dataset;
	}

	private IDataSet getDataSetMigradosOK() {
		IDataSet dataset = new TDataSet();
		dataset.create("TMigradosOK");
		dataset.fieldDef(new Field("codigo", Field.STRING, 50));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 255));
		return dataset;
	}

	private void cargarRegistroError(IDataSet dataset, String nroLinea, String descripcion) {
		dataset.append();
		dataset.fieldValue("nro_linea", nroLinea);
		dataset.fieldValue("descripcion", descripcion);
	}

	private void cargarRegistroLegNoEnc(IDataSet dataset, String codigo, String descripcion) {
		dataset.append();
		dataset.fieldValue("codigo", codigo);
		dataset.fieldValue("descripcion", descripcion);
	}

}
