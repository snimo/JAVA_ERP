package com.srn.erp.cashflow.op;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.cashflow.bm.EscenarioCashFlow;
import com.srn.erp.cashflow.bm.GrupoConceptoCF;
import com.srn.erp.cashflow.bm.RangoFechasCF;
import com.srn.erp.cashflow.bm.VistaCashFlow;
import com.srn.erp.ctasACobrar.bm.TranClieVto;
import com.srn.erp.ctasAPagar.bm.TranProvVto;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.tesoreria.bm.Valor;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bm.Varios.CalculadorMoney;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class AltaConceptoPermanenteCF extends Operation {

	java.util.Date fecDesde = null;
	java.util.Date fecHasta = null;
	List rangosPeriodos = new ArrayList();

	public AltaConceptoPermanenteCF() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		if (mapaDatos.getString("operacion").equals("ALTA"))
			altaConcepto(mapaDatos);
		else if (mapaDatos.getString("operacion").equals("BAJA"))
			bajaConcepto(mapaDatos);
		else if (mapaDatos.getString("operacion").equals("CAMBIAR_FEC_VTO_E_IMPORTE"))
			cambiarFecVtoEImporte(mapaDatos);

	}

	private void cambiarFecVtoEImporteConcPlanif(MapDatos mapaDatos) throws BaseException {

		String vista = mapaDatos.getString("vista");
		Integer dias = mapaDatos.getInteger("dias");
		EscenarioCashFlow escenario = EscenarioCashFlow.findByOidProxy(mapaDatos.getInteger("oid_escenario"), this.getSesion());
		fecDesde = mapaDatos.getDate("fec_desde");
		fecHasta = mapaDatos.getDate("fec_hasta");
		Money importe = mapaDatos.getMoney("importe");
		java.util.Date fecOri = null;

		VistaCashFlow vistaCF = VistaCashFlow.findByOid(mapaDatos.getInteger("oid_fuente"), this.getSesion());
		if (vistaCF == null)
			throw new ExceptionValidation(null, "No se pudo encontrar el concepto seleccionado.");

		java.util.Date fecha = mapaDatos.getDate("fecha");
		boolean seModificoFecha = false;
		if (!vistaCF.getFecha().equals(fecha))
			seModificoFecha = true;

		boolean seModificoImporte = false;
		if (vistaCF.getImporte().doubleValue() != importe.doubleValue())
			seModificoImporte = true;

		if (seModificoFecha || seModificoImporte) {

			IDataSet ds = getDataSetVistaCF();
			IDataSet dsAltaConcepto = getDataOidAltaConcepto();

			fecOri = vistaCF.getFecha();

			enviarInfoBaja(ds, vistaCF, vista, dias, fecOri, escenario, importe);

			vistaCF.setFecha(fecha);
			vistaCF.setImporte(importe.doubleValue());
			vistaCF.save();

			// Hacer la Baja del Concepto

			altaConcepto(ds, vista, fecha, vistaCF, dias, escenario, mapaDatos.getString("tipo"), TraerVistaCF.FUENTE_CONC_PLANIF, importe);
			cargarRegistroConcepto(dsAltaConcepto, vistaCF.getOIDInteger());

			writeCliente(dsAltaConcepto);
			writeCliente(ds);

		}

	}

	private void cambiarFecVtoEImporteDeudaFinanClie(MapDatos mapaDatos) throws BaseException {

		String vista = mapaDatos.getString("vista");
		Integer dias = mapaDatos.getInteger("dias");
		EscenarioCashFlow escenario = EscenarioCashFlow.findByOidProxy(mapaDatos.getInteger("oid_escenario"), this.getSesion());
		fecDesde = mapaDatos.getDate("fec_desde");
		fecHasta = mapaDatos.getDate("fec_hasta");
		Money importe = mapaDatos.getMoney("importe");
		java.util.Date fecOri = mapaDatos.getDate("fec_ori");

		Valor valor = Valor.findByOid(mapaDatos.getInteger("oid_fuente"), this.getSesion());
		if (valor == null)
			throw new ExceptionValidation(null, "No se pudo encontrar el Valor Seleccionado.");

		java.util.Date fecha = mapaDatos.getDate("fecha");
		boolean seModificoFecha = false;
		if (!valor.getFechaCF().equals(fecha))
			seModificoFecha = true;

		if (seModificoFecha) {

			IDataSet ds = getDataSetVistaCF();
			IDataSet dsAltaConcepto = getDataOidAltaConcepto();

			enviarInfoBaja(ds, valor, vista, dias, fecOri, escenario, importe);

			valor.cambiarNuevaFecVto(valor, fecha, this.getSesion());

			// Hacer la Baja del Concepto

			altaConcepto(ds, vista, fecha, valor, dias, escenario, mapaDatos.getString("tipo"), TraerVistaCF.FUENTE_DEU_FIN_CLI, importe);
			cargarRegistroConcepto(dsAltaConcepto, valor.getOIDInteger());

			writeCliente(dsAltaConcepto);
			writeCliente(ds);

		}

	}
	
	private void cambiarFecVtoEImporteDeudaFinanProv(MapDatos mapaDatos) throws BaseException {

		String vista = mapaDatos.getString("vista");
		Integer dias = mapaDatos.getInteger("dias");
		EscenarioCashFlow escenario = EscenarioCashFlow.findByOidProxy(mapaDatos.getInteger("oid_escenario"), this.getSesion());
		fecDesde = mapaDatos.getDate("fec_desde");
		fecHasta = mapaDatos.getDate("fec_hasta");
		Money importe = mapaDatos.getMoney("importe");
		java.util.Date fecOri = mapaDatos.getDate("fec_ori");

		Valor valor = Valor.findByOid(mapaDatos.getInteger("oid_fuente"), this.getSesion());
		if (valor == null)
			throw new ExceptionValidation(null, "No se pudo encontrar el Valor Seleccionado.");

		java.util.Date fecha = mapaDatos.getDate("fecha");
		boolean seModificoFecha = false;
		if (!valor.getFechaCF().equals(fecha))
			seModificoFecha = true;

		if (seModificoFecha) {

			IDataSet ds = getDataSetVistaCF();
			IDataSet dsAltaConcepto = getDataOidAltaConcepto();

			enviarInfoBaja(ds, valor, vista, dias, fecOri, escenario, importe);

			valor.cambiarNuevaFecVto(valor, fecha, this.getSesion());

			// Hacer la Baja del Concepto

			altaConcepto(ds, vista, fecha, valor, dias, escenario, mapaDatos.getString("tipo"), TraerVistaCF.FUENTE_DEU_FIN_PRO, importe);
			cargarRegistroConcepto(dsAltaConcepto, valor.getOIDInteger());

			writeCliente(dsAltaConcepto);
			writeCliente(ds);

		}

	}
	

	private void cambiarFecVtoEImporteCtaCteCliente(MapDatos mapaDatos) throws BaseException {

		String vista = mapaDatos.getString("vista");
		Integer dias = mapaDatos.getInteger("dias");
		EscenarioCashFlow escenario = EscenarioCashFlow.findByOidProxy(mapaDatos.getInteger("oid_escenario"), this.getSesion());
		fecDesde = mapaDatos.getDate("fec_desde");
		fecHasta = mapaDatos.getDate("fec_hasta");
		Money importe = mapaDatos.getMoney("importe");
		java.util.Date fecOri = mapaDatos.getDate("fec_ori");

		TranClieVto tranClieVto = TranClieVto.findByOid(mapaDatos.getInteger("oid_fuente"), this.getSesion());
		if (tranClieVto == null)
			throw new ExceptionValidation(null, "No se pudo encontrar la Factura Seleccionada.");

		java.util.Date fecha = mapaDatos.getDate("fecha");
		boolean seModificoFecha = false;
		if (!tranClieVto.getFechaCF().equals(fecha))
			seModificoFecha = true;

		if (seModificoFecha) {

			IDataSet ds = getDataSetVistaCF();
			IDataSet dsAltaConcepto = getDataOidAltaConcepto();

			enviarInfoBaja(ds, tranClieVto, vista, dias, fecOri, escenario, importe);

			tranClieVto.cambiarFechaConfirmacionCobro(fecha, this.getSesion());

			// Hacer la Baja del Concepto

			altaConcepto(ds, vista, fecha, tranClieVto, dias, escenario, mapaDatos.getString("tipo"), TraerVistaCF.FUENTE_CTA_CTE_CLI,
					importe);
			cargarRegistroConcepto(dsAltaConcepto, tranClieVto.getOIDInteger());

			writeCliente(dsAltaConcepto);
			writeCliente(ds);

		}

	}

	private void cambiarFecVtoEImporteCtaCteProveedor(MapDatos mapaDatos) throws BaseException {

		String vista = mapaDatos.getString("vista");
		Integer dias = mapaDatos.getInteger("dias");
		EscenarioCashFlow escenario = EscenarioCashFlow.findByOidProxy(mapaDatos.getInteger("oid_escenario"), this.getSesion());
		fecDesde = mapaDatos.getDate("fec_desde");
		fecHasta = mapaDatos.getDate("fec_hasta");
		Money importe = mapaDatos.getMoney("importe");
		java.util.Date fecOri = mapaDatos.getDate("fec_ori");

		TranProvVto tranProvVto = TranProvVto.findByOid(mapaDatos.getInteger("oid_fuente"), this.getSesion());
		if (tranProvVto == null)
			throw new ExceptionValidation(null, "No se pudo encontrar el Comprobante del Proveedor.");

		java.util.Date fecha = mapaDatos.getDate("fecha");
		boolean seModificoFecha = false;
		if (!tranProvVto.getFechaCF().equals(fecha))
			seModificoFecha = true;

		if (seModificoFecha) {

			IDataSet ds = getDataSetVistaCF();
			IDataSet dsAltaConcepto = getDataOidAltaConcepto();

			enviarInfoBaja(ds, tranProvVto, vista, dias, fecOri, escenario, importe);

			tranProvVto.cambiarFechaConfirmacionPago(tranProvVto,fecha, this.getSesion());

			// Hacer la Baja del Concepto

			altaConcepto(ds, vista, fecha, tranProvVto, dias, escenario, mapaDatos.getString("tipo"), TraerVistaCF.FUENTE_CTA_CTE_PROV,
					importe);
			cargarRegistroConcepto(dsAltaConcepto, tranProvVto.getOIDInteger());

			writeCliente(dsAltaConcepto);
			writeCliente(ds);

		}

	}

	public void cambiarFecVtoEImporte(MapDatos mapaDatos) throws BaseException {

		boolean validadorOk = false;
		validarCambioImporte(mapaDatos);
		if (mapaDatos.getString("fuente").equals(TraerVistaCF.FUENTE_CONC_PLANIF)) {
			cambiarFecVtoEImporteConcPlanif(mapaDatos);
			validadorOk = true;
		} else if (mapaDatos.getString("fuente").equals(TraerVistaCF.FUENTE_CTA_CTE_CLI)) {
			cambiarFecVtoEImporteCtaCteCliente(mapaDatos);
			validadorOk = true;
		} else if (mapaDatos.getString("fuente").equals(TraerVistaCF.FUENTE_CTA_CTE_PROV)) {
			cambiarFecVtoEImporteCtaCteProveedor(mapaDatos);
			validadorOk = true;
		}
		else if (mapaDatos.getString("fuente").equals(TraerVistaCF.FUENTE_DEU_FIN_CLI)) {
			cambiarFecVtoEImporteDeudaFinanClie(mapaDatos);
			validadorOk = true;
		}
		else if (mapaDatos.getString("fuente").equals(TraerVistaCF.FUENTE_DEU_FIN_PRO)) {
			cambiarFecVtoEImporteDeudaFinanProv(mapaDatos);
			validadorOk = true;
		}		
		if (!validadorOk)
			throw new ExceptionValidation(null, "El concepto seleccionado no puede ser Modificado.");

	}
	
	private void validarCambioImporte(MapDatos mapaDatos) throws BaseException {
		if (!mapaDatos.getString("fuente").equals(TraerVistaCF.FUENTE_CONC_PLANIF)) {
			if (mapaDatos.getDouble("importe").doubleValue()!=mapaDatos.getDouble("importe_ori").doubleValue())
				throw new ExceptionValidation(null,"No puede modificarse el Importe");
		}
			
	}

	private void enviarInfoBaja(IDataSet ds, Object objCF, String vista, Integer dias, java.util.Date fecha, EscenarioCashFlow escenario,
			Money importeConcepto) throws BaseException {

		java.util.Date fechaRangoDesde = fecDesde;
		java.util.Date fecHastaMas1 = Fecha.getFechaDiaPosterior(fecHasta);

		if (vista.equals("RANGO"))
			armarPeriodosRangos(fechaRangoDesde, fecHastaMas1, dias);

		java.util.Date fechaAConsiderar = null;
		String tipo = null;
		if (fecha.before(fecDesde)) {
			tipo = TraerVistaCF.SI_PERI;
			fechaAConsiderar = Fecha.getFechaDiaAnterior(fecDesde);
		} else if (fecha.after(fecHasta)) {
			tipo = TraerVistaCF.SF_PERI;
			fechaAConsiderar = Fecha.getFechaDiaPosterior(fecHasta);
		} else {
			tipo = TraerVistaCF.PERI;
			fechaAConsiderar = fecha;
		}

		java.util.Date mostrarFecha = fechaAConsiderar;
		if ((fechaAConsiderar.before(fecDesde)) || (fechaAConsiderar.after(fecHasta)))
			mostrarFecha = null;

		Money importe = new Money(0);
		GrupoConceptoCF grupo = null;
		String fuente = "";

		if (objCF instanceof VistaCashFlow) {
			importe = new Money(((VistaCashFlow) (objCF)).getImporte());
			grupo = ((VistaCashFlow) (objCF)).getGrupo_concepto();
			fuente = TraerVistaCF.FUENTE_CONC_PLANIF;
		} else if (objCF instanceof TranClieVto) {
			importe = importeConcepto;
			grupo = null;
			fuente = TraerVistaCF.FUENTE_CTA_CTE_CLI;
		} else if (objCF instanceof TranProvVto) {
			importe = importeConcepto;
			grupo = null;
			fuente = TraerVistaCF.FUENTE_CTA_CTE_PROV;
		} else if (objCF instanceof Valor) {
			importe = importeConcepto;
			grupo = null;
			fuente = TraerVistaCF.FUENTE_DEU_FIN_CLI;
		}

		// Cambiar signo del Importe
		CalculadorMoney cambioSigno = new CalculadorMoney(importe);
		cambioSigno.multiplicarPor(new Money(-1));

		enviarSaldosAnteriores(ds, vista, fechaAConsiderar, mostrarFecha, fecha, cambioSigno.getResultMoney(), escenario, grupo, tipo,
				fuente);

	}

	public void bajaConcepto(MapDatos mapaDatos) throws BaseException {

		if (!mapaDatos.getString("fuente").equals(TraerVistaCF.FUENTE_CONC_PLANIF))
			throw new ExceptionValidation(null, "El concepto seleccionado no puede ser eliminado.");

		VistaCashFlow vistaCF = VistaCashFlow.findByOid(mapaDatos.getInteger("oid_fuente"), this.getSesion());
		if (vistaCF == null)
			throw new ExceptionValidation(null, "No se pudo encontrar el concepto seleccionado.");

		if (!vistaCF.isActivo())
			throw new ExceptionValidation(null, "El concepto seleccionado ya se encuentra dado de baja.");

		String vista = mapaDatos.getString("vista");
		fecDesde = mapaDatos.getDate("fec_desde");
		fecHasta = mapaDatos.getDate("fec_hasta");
		Integer dias = mapaDatos.getInteger("dias");
		java.util.Date fecha = mapaDatos.getDate("fecha");
		Money importe = mapaDatos.getMoney("importe");
		GrupoConceptoCF grupo = GrupoConceptoCF.findByOidProxy(mapaDatos.getInteger("oid_grupo_conc"), this.getSesion());
		EscenarioCashFlow escenario = EscenarioCashFlow.findByOidProxy(mapaDatos.getInteger("oid_escenario"), this.getSesion());

		vistaCF.setActivo(false);
		vistaCF.delete();
		vistaCF.save();

		IDataSet ds = getDataSetVistaCF();
		enviarInfoBaja(ds, vistaCF, vista, dias, fecha, escenario, importe);
		writeCliente(ds);

	}

	private void altaConcepto(IDataSet ds, String vista, java.util.Date fecha, Object objCF, Integer dias, EscenarioCashFlow escenario,
			String mapaDatosTipo, String fuente, Money importeConcepto) throws BaseException {

		java.util.Date fechaRangoDesde = fecDesde;
		java.util.Date fecHastaMas1 = Fecha.getFechaDiaPosterior(fecHasta);

		if (vista.equals("RANGO"))
			armarPeriodosRangos(fechaRangoDesde, fecHastaMas1, dias);

		java.util.Date fechaAConsiderar = null;
		String tipo = null;
		if (fecha.before(fecDesde)) {
			tipo = TraerVistaCF.SI_PERI;
			fechaAConsiderar = Fecha.getFechaDiaAnterior(fecDesde);
		} else if (fecha.after(fecHasta)) {
			tipo = TraerVistaCF.SF_PERI;
			fechaAConsiderar = Fecha.getFechaDiaPosterior(fecHasta);
		} else {
			tipo = TraerVistaCF.PERI;
			fechaAConsiderar = fecha;
		}

		java.util.Date mostrarFecha = fechaAConsiderar;
		if ((fechaAConsiderar.before(fecDesde)) || (fechaAConsiderar.after(fecHasta)))
			mostrarFecha = null;

		String labelGrupo = "";
		String descGrupoConcepto = "";
		String descConcepto = "";
		Money importe = new Money(0);
		Integer oidGrupoConcepto = new Integer(0);
		Integer oidFuente = new Integer(0);
		GrupoConceptoCF grupo = null;

		if (objCF instanceof VistaCashFlow) {
			if (((VistaCashFlow) (objCF)).getGrupo_concepto().isIngreso())
				labelGrupo = TraerVistaCF.INGRESOS;
			else if (((VistaCashFlow) (objCF)).getGrupo_concepto().isEgreso())
				labelGrupo = TraerVistaCF.EGRESOS;
			else if (((VistaCashFlow) (objCF)).getGrupo_concepto().isSaldoInicial())
				labelGrupo = TraerVistaCF.SALDO_INICIAL;
			descGrupoConcepto = ((VistaCashFlow) (objCF)).getGrupo_concepto().getDescripcion();
			descConcepto = ((VistaCashFlow) (objCF)).getDescripcion();
			importe = new Money(((VistaCashFlow) (objCF)).getImporte());
			oidGrupoConcepto = ((VistaCashFlow) (objCF)).getGrupo_concepto().getOIDInteger();
			oidFuente = ((VistaCashFlow) (objCF)).getOIDInteger();
			grupo = ((VistaCashFlow) (objCF)).getGrupo_concepto();
		} else if (objCF instanceof TranClieVto) {
			labelGrupo = TraerVistaCF.INGRESOS;
			descGrupoConcepto = TraerVistaCF.CTA_CTE_CLI;
			descConcepto = ((TranClieVto) (objCF)).getDescripcion();
			importe = importeConcepto;
			oidFuente = ((TranClieVto) (objCF)).getOIDInteger();
		} else if (objCF instanceof TranProvVto) {
			labelGrupo = TraerVistaCF.EGRESOS;
			descGrupoConcepto = TraerVistaCF.CTA_CTE_PROV;
			descConcepto = ((TranProvVto) (objCF)).getDescripcion();
			importe = importeConcepto;
			oidFuente = ((TranProvVto) (objCF)).getOIDInteger();
		}  		
		else if (objCF instanceof Valor) {
			
			if (fuente.equals(TraerVistaCF.FUENTE_DEU_FIN_CLI)) {
				labelGrupo = TraerVistaCF.INGRESOS;
				descGrupoConcepto = TraerVistaCF.DEU_FIN_CLI;
				descConcepto = ((Valor) (objCF)).getDescripcion();
				importe = importeConcepto;
				oidFuente = ((Valor) (objCF)).getOIDInteger();
			} else if (fuente.equals(TraerVistaCF.FUENTE_DEU_FIN_PRO)) {
						labelGrupo = TraerVistaCF.EGRESOS;
						descGrupoConcepto = TraerVistaCF.VAL_EMITIDOS;
						descConcepto = ((Valor) (objCF)).getDescripcion();
						importe = importeConcepto;
						oidFuente = ((Valor) (objCF)).getOIDInteger();
				} 
			
		}

		cargarRegistroConcepto(ds, labelGrupo, descGrupoConcepto, descConcepto, mostrarFecha, importe, tipo, getPeriodo(mostrarFecha),
				mapaDatosTipo, oidGrupoConcepto, escenario.getMoneda().getOIDInteger(), fuente, oidFuente);

		enviarSaldosAnteriores(ds, vista, fechaAConsiderar, mostrarFecha, fecha, importe, escenario, grupo, tipo, fuente);

	}

	public void altaConcepto(MapDatos mapaDatos) throws BaseException {

		// Tomar los parametros principales
		String descripcion = mapaDatos.getString("descripcion");
		Money importe = mapaDatos.getMoney("importe");
		java.util.Date fecha = mapaDatos.getDate("fecha");
		GrupoConceptoCF grupo = GrupoConceptoCF.findByOidProxy(mapaDatos.getInteger("oid_grupo_conc"), this.getSesion());
		Integer orden = mapaDatos.getInteger("orden");
		EscenarioCashFlow escenario = EscenarioCashFlow.findByOidProxy(mapaDatos.getInteger("oid_escenario"), this.getSesion());
		Moneda moneda = Moneda.findByOidProxy(mapaDatos.getInteger("oid_moneda"), this.getSesion());
		String vista = mapaDatos.getString("vista");
		Integer dias = mapaDatos.getInteger("dias");

		fecDesde = mapaDatos.getDate("fec_desde");
		fecHasta = mapaDatos.getDate("fec_hasta");

		// Alta del concepto
		VistaCashFlow vistaCF = (VistaCashFlow) VistaCashFlow.getNew(VistaCashFlow.NICKNAME, this.getSesion());
		vistaCF.setProg_cf(null);
		vistaCF.setConcepto_cf(null);
		vistaCF.setFecha(fecha);
		vistaCF.setFecha_original(fecha);
		vistaCF.setImporte(importe.doubleValue());
		vistaCF.setMoneda(moneda);
		vistaCF.setGrupo_concepto(grupo);
		vistaCF.setEscenario_cf(escenario);
		vistaCF.setDescripcion(descripcion);
		vistaCF.setActivo(true);
		if (mapaDatos.getString("tipo").equals("PER"))
			vistaCF.save();
		else {
			// Se asume que es provisorio (No Grabar)
		}

		IDataSet ds = getDataSetVistaCF();
		altaConcepto(ds, vista, fecha, vistaCF, dias, escenario, mapaDatos.getString("tipo"), mapaDatos.getString("fuente"), importe);
		writeCliente(ds);

	}

	private void enviarSaldosAnteriores(IDataSet ds, String vista, java.util.Date fechaAConsiderar, java.util.Date mostrarFecha,
			java.util.Date fecha, Money importe, EscenarioCashFlow escenario, GrupoConceptoCF grupo, String tipo, String fuente)
			throws BaseException {

		if (vista.equals("DIA")) {

			// Agregar a las fechas posteriores en el saldo inicial el importe
			// del Movimiento
			java.util.Date proxFecha = Fecha.getFechaDiaPosterior(fechaAConsiderar);
			java.util.Date fecHastaMas2 = Fecha.getFechaMasDias(fecHasta, 2);
			while (proxFecha.before(fecHastaMas2)) {
				String tipoPeri = null;
				if (proxFecha.before(fecDesde)) {
					tipoPeri = TraerVistaCF.SI_PERI;
					proxFecha = Fecha.getFechaDiaAnterior(fecDesde);
					mostrarFecha = null;
				} else if (proxFecha.after(fecHasta)) {
					tipoPeri = TraerVistaCF.SF_PERI;
					proxFecha = Fecha.getFechaDiaPosterior(fecHasta);
					mostrarFecha = null;
				} else {
					tipoPeri = TraerVistaCF.PERI;
					mostrarFecha = proxFecha;
				}

				Integer oidGrupoConcepto = new Integer(0);
				if (grupo != null)
					oidGrupoConcepto = grupo.getOIDInteger();

				cargarRegistroConcepto(ds, TraerVistaCF.SALDO_PERI_ANT, "", "", mostrarFecha, importe, tipoPeri, getPeriodo(mostrarFecha),
						"", oidGrupoConcepto, escenario.getMoneda().getOIDInteger(), fuente, new Integer(0));

				proxFecha = Fecha.getFechaDiaPosterior(proxFecha);
			}
		} else {

			Integer oidGrupoConcepto = new Integer(0);
			if (grupo!=null)
				oidGrupoConcepto = grupo.getOIDInteger();

			// Rango
			Iterator iterPeriodos = rangosPeriodos.iterator();
			while (iterPeriodos.hasNext()) {
				RangoFechasCF rango = (RangoFechasCF) iterPeriodos.next();
				if (rango.getFecDesde().after(fecha)) {
					cargarRegistroConcepto(ds, TraerVistaCF.SALDO_PERI_ANT, "", "", rango.getFecDesde(), importe, TraerVistaCF.PERI,
							getPeriodo(rango.getFecDesde()), "", oidGrupoConcepto, escenario.getMoneda().getOIDInteger(), fuente,
							new Integer(0));
				}

			}

			// Agregar el saldo Final
			if (!tipo.equals(TraerVistaCF.SF_PERI)) {
				cargarRegistroConcepto(ds, TraerVistaCF.SALDO_PERI_ANT, "", "", null, importe, TraerVistaCF.SF_PERI, "", "", oidGrupoConcepto, escenario.getMoneda().getOIDInteger(), fuente, new Integer(0));
			}

		}

	}

	private void armarPeriodosRangos(java.util.Date fechaRangoDesde, java.util.Date fecHastaMas1, Integer dias) throws BaseException {

		rangosPeriodos.clear();

		if (dias.intValue() <= 0)
			throw new ExceptionValidation(null, "Debe ingresar la cantidad de días");

		while (fechaRangoDesde.before(fecHastaMas1)) {

			java.util.Date fechaRangoHasta = Fecha.getFechaMasDias(fechaRangoDesde, dias.intValue() - 1);
			if (!(fechaRangoHasta.before(fecHastaMas1)))
				fechaRangoHasta = Fecha.getFechaDiaAnterior(fecHastaMas1);
			RangoFechasCF rangoFechas = new RangoFechasCF();
			rangoFechas.setFecDesde(fechaRangoDesde);
			rangoFechas.setFecHasta(fechaRangoHasta);
			rangosPeriodos.add(rangoFechas);

			fechaRangoDesde = Fecha.getFechaDiaPosterior(fechaRangoHasta);
		}

	}

	private IDataSet getDataSetVistaCF() {
		IDataSet dataset = new TDataSet();
		dataset.create("TAgregarVistaCF");
		dataset.fieldDef(new Field("grupo", Field.STRING, 100));
		dataset.fieldDef(new Field("subgrupo", Field.STRING, 100));
		dataset.fieldDef(new Field("concepto", Field.STRING, 100));
		dataset.fieldDef(new Field("fecha", Field.DATE, 0));
		dataset.fieldDef(new Field("importe", Field.DATE, 0));
		dataset.fieldDef(new Field("tipo_si_per_sf", Field.STRING, 20));
		dataset.fieldDef(new Field("rango", Field.STRING, 50));
		dataset.fieldDef(new Field("tipo_concepto", Field.STRING, 20));
		dataset.fieldDef(new Field("oid_grupo_conc", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_moneda", Field.INTEGER, 0));
		dataset.fieldDef(new Field("fuente", Field.STRING, 100));
		dataset.fieldDef(new Field("oid_fuente", Field.INTEGER, 0));
		dataset.fieldDef(new Field("fec_ori", Field.DATE, 0));
		dataset.fieldDef(new Field("importe_ori", Field.CURRENCY, 0));

		return dataset;
	}

	private IDataSet getDataOidAltaConcepto() {
		IDataSet dataset = new TDataSet();
		dataset.create("TOidAltaConcepto");
		dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
		return dataset;
	}

	private void cargarRegistroConcepto(IDataSet dataset, Integer oidAltaConcepto) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid", oidAltaConcepto);
	}

	private void cargarRegistroConcepto(IDataSet dataset, String grupo, String subgrupo, String concepto, java.util.Date fecha,
			Money importe, String saldoIniPeriFinal, String rango, String tipoConcepto, Integer oidGrupoConcepto, Integer oidMoneda,
			String fuente, Integer oidFuente) throws BaseException {

		dataset.append();
		dataset.fieldValue("grupo", grupo);
		dataset.fieldValue("subgrupo", subgrupo);
		dataset.fieldValue("concepto", concepto);
		dataset.fieldValue("fecha", fecha);
		dataset.fieldValue("importe", importe);
		dataset.fieldValue("tipo_si_per_sf", saldoIniPeriFinal);
		dataset.fieldValue("rango", rango);
		dataset.fieldValue("tipo_concepto", tipoConcepto);
		if (oidGrupoConcepto != null)
			dataset.fieldValue("oid_grupo_conc", oidGrupoConcepto);
		else
			dataset.fieldValue("oid_grupo_conc", 0);
		dataset.fieldValue("oid_moneda", oidMoneda);
		dataset.fieldValue("fuente", fuente);
		dataset.fieldValue("oid_fuente", oidFuente);
		dataset.fieldValue("fec_ori", fecha);
		dataset.fieldValue("importe_ori", importe);

	}

	private String getPeriodo(java.util.Date fecha) throws BaseException {
		if (fecha == null)
			return "";
		Iterator iterPeriodos = rangosPeriodos.iterator();
		while (iterPeriodos.hasNext()) {
			RangoFechasCF rango = (RangoFechasCF) iterPeriodos.next();
			if ((fecha.after(Fecha.getFechaDiaAnterior(rango.getFecDesde())))
					&& (fecha.before(Fecha.getFechaDiaPosterior(rango.getFecHasta()))))
				return rango.getDescripcion();
		}
		return "";
	}

}
