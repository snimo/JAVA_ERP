package com.srn.erp.contabilidad.op;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.contabilidad.bm.Cuenta;
import com.srn.erp.contabilidad.bm.CuentaImputable;
import com.srn.erp.contabilidad.bm.Ejercicio;
import com.srn.erp.contabilidad.bm.ReporteContable;
import com.srn.erp.contabilidad.bm.ReporteContableDet;
import com.srn.erp.contabilidad.da.DBConsultasContables;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.general.bm.Periodo;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class ConsultaBalance extends Operation {

	private ReporteContable reporteContable = null;
	private java.util.Date fecImpuDesde;
	private java.util.Date fecImpuHasta;
	private final String SALDO_INICIAL = "Saldo Inicial";
	private final String MOVIMIENTOS_DEBE = "Mov. Debe";
	private final String MOVIMIENTOS_HABER = "Mov. Haber";
	private final String SALDO_FINAL = "Saldo Final";
	private IDataSet datasetConsBalance;
	private IDataSet dataSetFiltro = getDataSetFiltro();
	private String monedaCursoLegal = null;
	private String monedaAjustada = null;
	private String monedaExt1 = null;
	private String monedaExt2 = null;
	private boolean isMonedaLocHist = false;
	private boolean isMonedaLocAju = false;
	private boolean isMonedaExt1 = false;
	private boolean isMonedaExt2 = false;
	private HashTableDatos repDetPorAnaImp = new HashTableDatos(); 

	StringBuffer filtro;
	boolean incluirAsiCie = false;

	public ConsultaBalance() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		if (mapaDatos.containsKey("incluir_asi_cierre"))
			incluirAsiCie = true;
		
		ReporteContable reporteContable = null;
		if (mapaDatos.containsKey("oid_reporte")) {
			Integer oid = mapaDatos.getInteger("oid_reporte");
			reporteContable = ReporteContable.findByOid(oid, getSesion());
			procesarReporteContable(reporteContable);
		}

		init();
		try {
			tratarParametros(mapaDatos);
			traerSaldoInicial(fecImpuDesde,incluirAsiCie);
			traerMovimientosCuenta(fecImpuDesde, fecImpuHasta , incluirAsiCie);
			traerSaldoFinal(fecImpuHasta, SALDO_FINAL, false,incluirAsiCie);
		} catch (Exception ex) {
			throw new BaseException(null, ex.getMessage());
		}

		enviarDataSets();

	}

	public void init() throws BaseException {
		monedaCursoLegal = Moneda.getMonedaCursoLegal(getSesion())
				.getDescripcion();
		monedaAjustada = Moneda.getMonedaCursoLegal(getSesion())
				.getDescripcion()
				+ " (Aju)";
		monedaExt1 = Moneda.getMonedaExt1(getSesion()).getDescripcion();
		monedaExt2 = Moneda.getMonedaExt2(getSesion()).getDescripcion();
	}

	private void tratarParametros(MapDatos mapaDatos) throws BaseException {

		Moneda moneda = Moneda.findByOid(mapaDatos.getInteger("oid_moneda"),
				this.getSesion());
		if (moneda.isMonedaCursoLegal())
			isMonedaLocHist = true;
		else if (moneda.isMonedaExt1())
			isMonedaExt1 = true;
		else if (moneda.isMonedaExt2())
			isMonedaExt2 = true;

		if (mapaDatos.getInteger("oid_reporte").intValue() != 0)
			reporteContable = ReporteContable.findByOid(mapaDatos
					.getInteger("oid_reporte"), getSesion());

		fecImpuDesde = mapaDatos.getDate("fecDesde");
		fecImpuHasta = mapaDatos.getDate("fecHasta");

		filtro = new StringBuffer();
		if (reporteContable!=null)
			filtro.append(reporteContable.getDescripcion());
		else
			filtro.append("Balance de sumas y saldos");
		filtro.append(" del " + Fecha.getddmmyyyy(fecImpuDesde) + " al "
				+ Fecha.getddmmyyyy(fecImpuHasta) + "  ");

		cargarRegistroFiltro(dataSetFiltro, filtro.toString());
		datasetConsBalance = getDataSetConsultaBalance();
	}

	private MapDatos getCondicionesQuery() throws BaseException {
		MapDatos condiciones = new HashTableDatos();
		condiciones.put("fecImputacDesde", fecImpuDesde);
		condiciones.put("fecImputacHasta", fecImpuHasta);
		return condiciones;
	}

	private void traerSaldoInicial(java.util.Date aFecha, boolean incluirAsiCierre) throws BaseException {
		java.util.Date fechaDiaAnt = Fecha.getFechaDiaAnterior(aFecha);
		Ejercicio ejer = Ejercicio.getEjercicioByFecha(aFecha, getSesion());
		if (ejer == null)
			throw new ExceptionValidation(null,
					"Falta configurar el período contable para la fecha "
							+ Fecha.getddmmyyyy(aFecha));
		try {
			if (aFecha.getTime() == ejer.getFechadesde().getTime())
				traerSaldoFinal(fechaDiaAnt, SALDO_INICIAL, true , incluirAsiCierre);
			else
				traerSaldoFinal(fechaDiaAnt, SALDO_INICIAL, false , incluirAsiCierre);
		} catch (SQLException ex) {
		} catch (BaseException ex) {
		}
	}

	private void traerSaldoFinal(
			java.util.Date aFecha, 
			String tipoMov,
			boolean soloCtasPatrimoniales , 
			boolean incluirAsiCierre) throws BaseException, SQLException {

		java.sql.ResultSet rs = null;
		DBConsultasContables consultasContables = new DBConsultasContables();
		consultasContables.setSesion(getSesion());

		Periodo periodoFecha = Periodo.getPeriodoByFechaDelEjercicio(aFecha,
				getSesion());
		if (periodoFecha == null)
			throw new ExceptionValidation(null,
					"No existe Ejercicio configurado para la Fecha "
							+ Fecha.getddmmyyyy(aFecha));
		MapDatos condiciones = null;
		condiciones = new HashTableDatos();
		condiciones.put("fecha", aFecha);

		PreparedStatement psConsSI = null;

		if (soloCtasPatrimoniales == false) {
			// Cuentas de resultado de incio del Ejercicio al final de Periodo
			// anterior a la fecha Ingresada
			
			//SELECT_BY_SALDO_FIN_DESDE_INI_EJER_A_FIN_PERI_ALL_RESULT_SIN_ASI_CIE;
			if (incluirAsiCierre)
				psConsSI = consultasContables
					.prepararSelect(
							DBConsultasContables.SELECT_BY_SALDO_FIN_DESDE_INI_EJER_A_FIN_PERI_ALL_RESULT,
							condiciones);
			else
				psConsSI = consultasContables
				.prepararSelect(
						DBConsultasContables.SELECT_BY_SALDO_FIN_DESDE_INI_EJER_A_FIN_PERI_ALL_RESULT_SIN_ASI_CIE,
						condiciones);				
			rs = psConsSI.executeQuery();
			while (rs.next()) {

				// Moneda Curso Legal Historicos
				if (isMonedaLocHist)
					cargarRegistroConsultaBalance(datasetConsBalance, rs
							.getInt("oid_ai"), rs.getInt("oid_ana_con"),
							tipoMov, monedaCursoLegal, rs
									.getDouble("impo_loc_his"));

				// Moneda Curso Legal Ajustado
				else if (isMonedaLocAju)
					cargarRegistroConsultaBalance(datasetConsBalance, rs
							.getInt("oid_ai"), rs.getInt("oid_ana_con"),
							tipoMov, monedaAjustada, rs.getDouble("impo_loc_aju"));
			

				// Moneda Extranjera 1
				else if (isMonedaExt1)
					cargarRegistroConsultaBalance(datasetConsBalance, rs
							.getInt("oid_ai"), rs.getInt("oid_ana_con"),
							tipoMov, monedaExt1, rs.getDouble("impo_mon_ext_1"));

				// Moneda Extranjera 2
				else if (isMonedaExt2)
					cargarRegistroConsultaBalance(datasetConsBalance, rs
							.getInt("oid_ai"), rs.getInt("oid_ana_con"),
							tipoMov, monedaExt2, rs.getDouble("impo_mon_ext_2"));
			}

			rs.close();
			psConsSI.close();
		}

		// Cuentas de resultado de incio del Ejercicio al final de Periodo
		// anterior a la fecha Ingresada
		
		if (incluirAsiCierre==true)
			psConsSI = consultasContables.prepararSelect(DBConsultasContables.SELECT_BY_SALDO_FIN_DESDE_INI_CONTA_A_FIN_PERI_ALL_PATRI,condiciones);
		else
			psConsSI = consultasContables.prepararSelect(DBConsultasContables.SELECT_BY_SALDO_FIN_DESDE_INI_CONTA_A_FIN_PERI_ALL_PATRI_SIN_ASI_CIE,condiciones);
		
		rs = psConsSI.executeQuery();
		while (rs.next()) {

			// Moneda Curso Legal Historicos
			if (isMonedaLocHist)
				cargarRegistroConsultaBalance(datasetConsBalance, rs
						.getInt("oid_ai"), rs.getInt("oid_ana_con"), tipoMov,
						monedaCursoLegal, rs.getDouble("impo_loc_his"));

			// Moneda Curso Legal Ajustado
			else if (isMonedaLocAju)
				cargarRegistroConsultaBalance(datasetConsBalance, rs
						.getInt("oid_ai"), rs.getInt("oid_ana_con"), tipoMov,
						monedaAjustada, rs.getDouble("impo_loc_aju"));

			// Moneda Extranjera 1
			else if (isMonedaExt1)
				cargarRegistroConsultaBalance(datasetConsBalance, rs
						.getInt("oid_ai"), rs.getInt("oid_ana_con"), tipoMov,
						monedaExt1, rs.getDouble("impo_mon_ext_1"));

			// Moneda Extranjera 2
			else if (isMonedaExt2)
				cargarRegistroConsultaBalance(datasetConsBalance, rs
						.getInt("oid_ai"), rs.getInt("oid_ana_con"), tipoMov,
						monedaExt2, rs.getDouble("impo_mon_ext_2"));
		}

		rs.close();
		psConsSI.close();

		// Saldo desde inicio Periodo de Fecha ingresada hasta la fecha
		// Ingresada
		if (periodoFecha.getFechahasta().getTime() == aFecha.getTime())
			return;

		if (soloCtasPatrimoniales == false) {
			if (incluirAsiCierre)
				psConsSI = consultasContables.prepararSelect(
						DBConsultasContables.SELECT_BY_SALDO_FIN_DESDE_INICIO_PERI_A_FECHA_ING_ALL_RESULT,
						condiciones);
			else
				psConsSI = consultasContables.prepararSelect(
						DBConsultasContables.SELECT_BY_SALDO_FIN_DESDE_INICIO_PERI_A_FECHA_ING_ALL_RESULT_SIN_CIE,
						condiciones);				
				
			rs = psConsSI.executeQuery();
			while (rs.next()) {

				// Moneda Curso Legal Historicos
				if (isMonedaLocHist)
					cargarRegistroConsultaBalance(datasetConsBalance, rs
							.getInt("oid_ai"), rs.getInt("oid_ana_con"),
							tipoMov, monedaCursoLegal, rs
									.getDouble("impo_loc_his"));

				// Moneda Curso Legal Ajustado
				else if (isMonedaLocAju)
					cargarRegistroConsultaBalance(datasetConsBalance, rs
							.getInt("oid_ai"), rs.getInt("oid_ana_con"),
							tipoMov, monedaAjustada, rs.getDouble("impo_loc_aju"));

				// Moneda Extranjera 1
				else if (isMonedaExt1)
					cargarRegistroConsultaBalance(datasetConsBalance, rs
							.getInt("oid_ai"), rs.getInt("oid_ana_con"),
							tipoMov, monedaExt1, rs.getDouble("impo_mon_ext_1"));

				// Moneda Extranjera 2
				else if (isMonedaExt2)
					cargarRegistroConsultaBalance(datasetConsBalance, rs
							.getInt("oid_ai"), rs.getInt("oid_ana_con"),
							tipoMov, monedaExt2, rs.getDouble("impo_mon_ext_2"));
			}

			rs.close();
			psConsSI.close();
		}

		
		
			if (incluirAsiCierre)
				psConsSI = consultasContables.prepararSelect(
							DBConsultasContables.SELECT_BY_SALDO_FIN_DESDE_INICIO_PERI_A_FECHA_ING_ALL_PATRI,
							condiciones);
			else
				psConsSI = consultasContables.prepararSelect(
						DBConsultasContables.SELECT_BY_SALDO_FIN_DESDE_INICIO_PERI_A_FECHA_ING_ALL_PATRI_SIN_CIE,
						condiciones);			
			
			rs = psConsSI.executeQuery();
			while (rs.next()) {
				
				// 	Moneda Curso Legal Historicos
				if (isMonedaLocHist)
					cargarRegistroConsultaBalance(datasetConsBalance, rs
						.getInt("oid_ai"), rs.getInt("oid_ana_con"), tipoMov,
						monedaCursoLegal, rs.getDouble("impo_loc_his"));

				// Moneda Curso Legal Ajustado
				else if (isMonedaLocAju)
				cargarRegistroConsultaBalance(datasetConsBalance, rs
						.getInt("oid_ai"), rs.getInt("oid_ana_con"), tipoMov,
						monedaAjustada, rs.getDouble("impo_loc_aju"));

				// Moneda Extranjera 1
				else if (isMonedaExt1)
				cargarRegistroConsultaBalance(datasetConsBalance, rs
						.getInt("oid_ai"), rs.getInt("oid_ana_con"), tipoMov,
						monedaExt1, rs.getDouble("impo_mon_ext_1"));

				// Moneda Extranjera 2
				else if (isMonedaExt2)
				cargarRegistroConsultaBalance(datasetConsBalance, rs
						.getInt("oid_ai"), rs.getInt("oid_ana_con"), tipoMov,
						monedaExt2, rs.getDouble("impo_mon_ext_2"));
			}

			rs.close();
			psConsSI.close();
		

	}

	private void traerMovimientosCuenta(java.util.Date aFechaDesde,
			java.util.Date aFechaHasta , boolean incluirAsiCie) throws BaseException, SQLException {

		java.sql.ResultSet rs = null;
		DBConsultasContables consultasContables = new DBConsultasContables();
		consultasContables.setSesion(getSesion());

		// Cuentas de resultado de incio del Ejercicio al final de Periodo
		// anterior a la fecha Ingresada
		MapDatos condiciones = new HashTableDatos();
		condiciones.put("fechaDesde", aFechaDesde);
		condiciones.put("fechaHasta", aFechaHasta);
		PreparedStatement psConsMov = null;
		
		if (incluirAsiCie)
			psConsMov =	consultasContables.prepararSelect(
						DBConsultasContables.SELECT_BY_MOV_FEC_DESDE_HASTA_ALL_DEBITOS,
						condiciones);
		else
			psConsMov =	consultasContables.prepararSelect(
						DBConsultasContables.SELECT_BY_MOV_FEC_DESDE_HASTA_ALL_DEBITOS_SIN_ASI_CIE,
						condiciones);
		
		rs = psConsMov.executeQuery();
		while (rs.next()) {

			// Moneda Curso Legal Historicos
			if (isMonedaLocHist)
				cargarRegistroConsultaBalance(datasetConsBalance, rs
						.getInt("oid_ai"), rs.getInt("oid_ana_con"),
						MOVIMIENTOS_DEBE, monedaCursoLegal, rs
								.getDouble("impo_loc_his"));

			// Moneda Curso Legal Ajustado
			else if (isMonedaLocAju)
				cargarRegistroConsultaBalance(datasetConsBalance, rs
						.getInt("oid_ai"), rs.getInt("oid_ana_con"),
						MOVIMIENTOS_DEBE, monedaAjustada, rs
								.getDouble("impo_loc_aju"));

			// Moneda Extranjera 1
			else if (isMonedaExt1)
				cargarRegistroConsultaBalance(datasetConsBalance, rs
						.getInt("oid_ai"), rs.getInt("oid_ana_con"),
						MOVIMIENTOS_DEBE, monedaExt1, rs
								.getDouble("impo_mon_ext_1"));

			// Moneda Extranjera 2
			else if (isMonedaExt2)
				cargarRegistroConsultaBalance(datasetConsBalance, rs
						.getInt("oid_ai"), rs.getInt("oid_ana_con"),
						MOVIMIENTOS_DEBE, monedaExt2, rs
								.getDouble("impo_mon_ext_2"));
		}

		rs.close();
		psConsMov.close();

		// Cuentas de resultado de incio del Ejercicio al final de Periodo
		// anterior a la fecha Ingresada
		if (incluirAsiCie)
			psConsMov = consultasContables.prepararSelect(
						DBConsultasContables.SELECT_BY_MOV_FEC_DESDE_HASTA_ALL_CREDITOS,
						condiciones);
		else
			psConsMov = consultasContables.prepararSelect(
					DBConsultasContables.SELECT_BY_MOV_FEC_DESDE_HASTA_ALL_CREDITOS_SIN_ASI_CIE,
					condiciones);			
		
		rs = psConsMov.executeQuery();
		while (rs.next()) {

			// Moneda Curso Legal Historicos
			if (isMonedaLocHist)
				cargarRegistroConsultaBalance(datasetConsBalance, rs
						.getInt("oid_ai"), rs.getInt("oid_ana_con"),
						MOVIMIENTOS_HABER, monedaCursoLegal, rs
								.getDouble("impo_loc_his"));

			// Moneda Curso Legal Ajustado
			else if (isMonedaLocAju)
				cargarRegistroConsultaBalance(datasetConsBalance, rs
						.getInt("oid_ai"), rs.getInt("oid_ana_con"),
						MOVIMIENTOS_HABER, monedaAjustada, rs
								.getDouble("impo_loc_aju"));

			// Moneda Extranjera 1
			else if (isMonedaExt1)
				cargarRegistroConsultaBalance(datasetConsBalance, rs
						.getInt("oid_ai"), rs.getInt("oid_ana_con"),
						MOVIMIENTOS_HABER, monedaExt1, rs
								.getDouble("impo_mon_ext_1"));

			// Moneda Extranjera 2
			else if (isMonedaExt2)
				cargarRegistroConsultaBalance(datasetConsBalance, rs
						.getInt("oid_ai"), rs.getInt("oid_ana_con"),
						MOVIMIENTOS_HABER, monedaExt2, rs
								.getDouble("impo_mon_ext_2"));
		}

		rs.close();
		psConsMov.close();

	}

	private IDataSet getDataSetConsultaBalance() throws BaseException {
		IDataSet dataset = new TDataSet();
		dataset.create("TConsultaBalance");
		dataset.fieldDef(new Field("oid_ai", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_ana_con", Field.INTEGER, 0));
		dataset.fieldDef(new Field("tipo_mov", Field.STRING, 30));
		dataset.fieldDef(new Field("moneda", Field.STRING, 30));
		dataset.fieldDef(new Field("importe", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("oid_reporte_det", Field.STRING, 50));
		return dataset;
	}

	private IDataSet getDataSetFiltro() {
		IDataSet dataset = new TDataSet();
		dataset.create("TFiltro");
		dataset.fieldDef(new Field("filtro", Field.STRING, 255));
		return dataset;
	}

	private void cargarRegistroFiltro(IDataSet dataset, String filtro)
			throws BaseException {
		dataset.append();
		dataset.fieldValue("filtro", filtro);
	}

	private void cargarRegistroConsultaBalance(IDataSet dataset, int oidAnaImp,
			int oidAna, String tipoMov, String moneda, double importe)
			throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_ai", oidAnaImp);
		dataset.fieldValue("oid_ana_con", oidAna);
		dataset.fieldValue("tipo_mov", tipoMov);
		dataset.fieldValue("moneda", moneda);
		dataset.fieldValue("importe", importe);
		dataset.fieldValue("oid_reporte_det", getOidRepDet(oidAnaImp));

	}

	private void enviarDataSets() throws BaseException {
		writeCliente(datasetConsBalance);
		writeCliente(dataSetFiltro);
	}

	private void tratarCuentaSola(IDataSet ds, ReporteContableDet repContaDet)
			throws BaseException {
		
		String oidRepDet = 
			new Integer(repContaDet.getOidtitulo()
					.intValue()
					* -1).toString();
		
		
		String descTitulo = null;
		
		if ((repContaDet.getDesctitulo()!=null) && (repContaDet.getDesctitulo().length()>0))
			descTitulo = repContaDet.getDesctitulo();
		else
			descTitulo = repContaDet.getCuenta().getCodigo()+" - "+repContaDet.getCuenta().getDescripcion();
			
		
		cargarDataSetReporteContable(ds,  
				oidRepDet , 
				new Integer(repContaDet.getOidtitulopadre().intValue()* -1).toString(), 
				descTitulo);
		
		
		traerInfoCuenta(ds, repContaDet, oidRepDet);
	}

	private void tratarRangoCuentas(IDataSet ds, ReporteContableDet repContaDet)
			throws BaseException {

		String oidRepDet = 
			new Integer(repContaDet.getOidtitulo()
					.intValue()
					* -1).toString();
		
		
		String descTitulo = null;
		
		if ((repContaDet.getDesctitulo()!=null) && (repContaDet.getDesctitulo().length()>0))
			descTitulo = repContaDet.getDesctitulo();
		else
			descTitulo = "Rango Cuentas: ("+repContaDet.getCodigodesde()+"-"+repContaDet.getCodigohasta()+")";
			
		
		cargarDataSetReporteContable(ds,  
				oidRepDet , 
				new Integer(repContaDet.getOidtitulopadre().intValue()* -1).toString(), 
				descTitulo);
		
		
		
		List listaCuentas = Cuenta.getCuentas(repContaDet.getCodigodesde(),
				repContaDet.getCodigohasta(), getSesion());
		Iterator iterCuentas = listaCuentas.iterator();
		while (iterCuentas.hasNext()) {
			Cuenta cuenta = (Cuenta) iterCuentas.next();
			
			Iterator iterCtasImputables = cuenta.getImputables().iterator();

			while (iterCtasImputables.hasNext()) {
				CuentaImputable cuentaImputable = (CuentaImputable) iterCtasImputables
						.next();
				repDetPorAnaImp.put(cuentaImputable.getOIDInteger(), oidRepDet);
			}			
			
		}
	}

	private void tratarCuentaSinCompo(IDataSet ds,
			ReporteContableDet repContaDet) throws BaseException {

		String oidRepDet = new Integer(repContaDet.getOidtitulo().intValue()* -1).toString(); 
		
		String desc = null;
		
		if ((repContaDet.getDesctitulo()!=null) && (repContaDet.getDesctitulo().length()>0))
			desc = repContaDet.getDesctitulo();
		else
			desc = repContaDet.getCuenta().getCodigo()+" - "+repContaDet.getCuenta().getDescripcion();
		
		cargarDataSetReporteContable(ds, oidRepDet, new Integer(repContaDet.getOidtitulopadre()
				.intValue()
				* -1).toString(), desc);
		
		HashTableDatos listaValoresComponentes = repContaDet
				.getValoresComponentes();
		Iterator iterCtasImputables = repContaDet.getCuenta()
				.getImputablesByNotInValoresCompo(listaValoresComponentes)
				.iterator();
		while (iterCtasImputables.hasNext()) {
			CuentaImputable cuentaImputable = (CuentaImputable) iterCtasImputables
					.next();
			repDetPorAnaImp.put(cuentaImputable.getOIDInteger(), oidRepDet);
		}
	}

	private void tratarTitulo(IDataSet ds, ReporteContableDet repContaDet)
			throws BaseException {
		cargarDataSetReporteContable(ds, new Integer(repContaDet.getOidtitulo()
				.intValue()
				* -1).toString(), new Integer(repContaDet.getOidtitulopadre()
				.intValue()
				* -1).toString(), repContaDet.getDesctitulo());
	}

	private void tratarCuentaConComponentes(IDataSet ds,
			ReporteContableDet repContaDet) throws BaseException {
		
		String oidRepDet = new Integer(repContaDet.getOidtitulo().intValue()* -1).toString(); 
		
		String desc = null;
		
		if ((repContaDet.getDesctitulo()!=null) && (repContaDet.getDesctitulo().length()>0))
			desc = repContaDet.getDesctitulo();
		else
			desc = repContaDet.getCuenta().getCodigo()+" - "+repContaDet.getCuenta().getDescripcion();
		
		cargarDataSetReporteContable(ds, oidRepDet, new Integer(repContaDet.getOidtitulopadre()
				.intValue()
				* -1).toString(), desc);
		
		HashTableDatos listaValoresComponentes = repContaDet
				.getValoresComponentes();
		Iterator iterCtasImputables = repContaDet.getCuenta()
				.getImputablesByValoresCompo(listaValoresComponentes)
				.iterator();
		while (iterCtasImputables.hasNext()) {
			CuentaImputable cuentaImputable = (CuentaImputable) iterCtasImputables
					.next();
			
			repDetPorAnaImp.put(cuentaImputable.getOIDInteger(), oidRepDet);
			
		}
	}

	private String getClave(Cuenta cuenta, Integer oidTituPadre)
			throws BaseException {
		String claveOidTituRamaPadreyCuenta = "OID_PADRE_"
				+ oidTituPadre.toString() + "_CTA_"
				+ cuenta.getOIDInteger().toString();
		return claveOidTituRamaPadreyCuenta;
	}

	private void traerInfoCuenta(IDataSet dataSetReporteConta,
			ReporteContableDet reporteContaDet, String oidRepDet) throws BaseException {

		// Devolver la lista de Imputables
		Iterator iterCtasImputables = reporteContaDet.getCuenta().getImputables().iterator();

		while (iterCtasImputables.hasNext()) {
			CuentaImputable cuentaImputable = (CuentaImputable) iterCtasImputables
					.next();
			repDetPorAnaImp.put(cuentaImputable.getOIDInteger(), oidRepDet);
		}

		/*
		 * String clave = getClave(cuenta,oidTituPadre); if
		 * (tituloRamaPadreyCuenta.get(clave)==null) {
		 * tituloRamaPadreyCuenta.put(clave,clave);
		 * cargarDataSetReporteContable(dataSetReporteConta, clave,
		 * oidTituPadre.toString(), cuenta.getDescripcion()); } while
		 * (iterCtasImputables.hasNext()) { CuentaImputable cuentaImputable =
		 * (CuentaImputable) iterCtasImputables.next();
		 * cargarDataSetReporteContable(dataSetReporteConta, new
		 * Integer(cuentaImputable.getOID()).toString(), clave,
		 * cuentaImputable.getDescCuentaMasDescValCompo()); }
		 */
	}

	private IDataSet getDataReporteContable() {
		IDataSet dataset = new TDataSet();
		dataset.create("TReporteConta");
		dataset.fieldDef(new Field("oid", Field.STRING, 50));
		dataset.fieldDef(new Field("oid_padre", Field.STRING, 50));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
		return dataset;
	}

	private void cargarDataSetReporteContable(IDataSet dataset, String oid,
			String oidPadre, String descripcion) {
		dataset.append();
		dataset.fieldValue("oid", oid);
		dataset.fieldValue("oid_padre", oidPadre);
		dataset.fieldValue("descripcion", descripcion);
	}
	
	private void procesarReporteContable(ReporteContable reporteContable) throws BaseException {
		
		if (reporteContable == null) {
			IDataSet dataSetReporteConta = getDataReporteContable();
			writeCliente(dataSetReporteConta);
			return;
		}
		
		IDataSet dataSetReporteConta = getDataReporteContable();

	    Iterator iterReportes = reporteContable.getItemsReporte().iterator();
	    while (iterReportes.hasNext()) {
	      ReporteContableDet repContaDet = (ReporteContableDet) iterReportes.next();

	      // Si es un titulo
	      if (repContaDet.isTitulo())
	        tratarTitulo(dataSetReporteConta,repContaDet);
	        else // Si es una cuenta con Componentes
	      if (repContaDet.isCuentaConComponentes())
	        tratarCuentaConComponentes(dataSetReporteConta,repContaDet);
	      else // Trartar Rango de Cuentas
	      if (repContaDet.isRangoCuentas())
	        tratarRangoCuentas(dataSetReporteConta,repContaDet);
	      else // Si es una cuenta que se quiere exluir los componentes
	      if (repContaDet.isCuentaSinComponentes())
	        tratarCuentaSinCompo(dataSetReporteConta,repContaDet);
	      else // Si es una cuenta sola
	      if (repContaDet.isCuenta())
	        tratarCuentaSola(dataSetReporteConta,repContaDet);
	    }
	    
	    writeCliente(dataSetReporteConta);
		
	}
	
	private String getOidRepDet(Integer oidAnaImp) throws BaseException {
		String oidRepDet = (String)repDetPorAnaImp.get(oidAnaImp);
		if (oidRepDet!=null)
			return oidRepDet;
		else
			return "";
		
	}

}
