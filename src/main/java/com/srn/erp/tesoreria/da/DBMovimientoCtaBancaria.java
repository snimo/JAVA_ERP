package com.srn.erp.tesoreria.da;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import com.srn.erp.tesoreria.bm.CuentaBancaria;
import com.srn.erp.tesoreria.bm.MovimientoCtaBancaria;
import com.srn.erp.tesoreria.bm.Valor;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBMovimientoCtaBancaria extends DBObjetoPersistente {

	public static final String OID_MOV_CTA_BCO = "oid_mov_cta_bco";

	public static final String OID_CTA_BANCARIA = "oid_cta_bancaria";

	public static final String NRO_VALOR = "nro_valor";

	public static final String TIPO_MOV = "tipo_mov";

	public static final String FECHA_CONTABLE = "Fecha_Contable";

	public static final String FECHA_EMISION = "Fecha_Emision";

	public static final String FECHA_VTO = "Fecha_Vto";

	public static final String SIGNO = "signo";

	public static final String IMPORTE = "importe";

	public static final String OID_CCO = "oid_cco";

	public static final String ACTIVO = "activo";

	public static final String IMPORTE_HIST = "importe_hist";

	public static final String IMPORTE_AJU = "importe_aju";

	public static final String IMPORTE_EXT1 = "importe_ext1";

	public static final String IMPORTE_EXT2 = "importe_ext2";

	public static final String COTIZ_MON_ORI = "cotiz_mon_ori";

	public static final String COTIZ_MON_EXT1 = "cotiz_mon_ext1";

	public static final String COTIZ_MON_EXT2 = "cotiz_mon_ext2";

	public static final String COTIZ_MON_ORI_CON = "cotiz_mon_ori_con";

	public static final String COTIZ_MON_EXT1_CON = "cotiz_mon_ext1_con";

	public static final String COTIZ_MON_EXT2_CON = "cotiz_mon_ext2_con";

	public static final String FECHA_OPER = "fecha_oper";

	public static final String OID_VALOR = "oid_valor";

	public static final String OID_AI = "oid_ai";

	public static final String OID_TIPO_VALOR = "oid_tipo_valor";

	public static final String CONCILIADO = "conciliado";

	public static final String OID_CONCI_BCO = "oid_conci_bco";

	public static final int SELECT_BY_TIPO_CTA_TIPO_SALDO_CONTA = 100;
	public static final int SELECT_BY_TIPO_CTA_TIPO_SALDO_OPER = 101;
	public static final int SELECT_MOV_CTA_NO_CONCILIADOS = 102;
	public static final int SELECT_BY_CTA_BCO_VALOR_SALIDA = 103;
	public static final int SELECT_BY_TIPO_CTA_SIGNO_VALOR = 104;

	public DBMovimientoCtaBancaria() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_MOV_CTA_BCO = 1;
		final int OID_CTA_BANCARIA = 2;
		final int NRO_VALOR = 3;
		final int TIPO_MOV = 4;
		final int FECHA_CONTABLE = 5;
		final int FECHA_EMISION = 6;
		final int FECHA_VTO = 7;
		final int SIGNO = 8;
		final int IMPORTE = 9;
		final int OID_CCO = 10;
		final int ACTIVO = 11;
		final int IMPORTE_HIST = 12;
		final int IMPORTE_AJU = 13;
		final int IMPORTE_EXT1 = 14;
		final int IMPORTE_EXT2 = 15;
		final int COTIZ_MON_ORI = 16;
		final int COTIZ_MON_EXT1 = 17;
		final int COTIZ_MON_EXT2 = 18;
		final int COTIZ_MON_ORI_CON = 19;
		final int COTIZ_MON_EXT1_CON = 20;
		final int COTIZ_MON_EXT2_CON = 21;
		final int FECHA_OPER = 22;
		final int OID_VALOR = 23;
		final int OID_AI = 24;
		final int OID_TIPO_VALOR = 25;
		final int CONCILIADO = 26;
		final int OID_CONCI_BCO = 27;

		MovimientoCtaBancaria pers = (MovimientoCtaBancaria) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into VAMOVIMBANCO " + " ( " + "OID_MOV_CTA_BCO," + "OID_CTA_BANCARIA," + "NRO_VALOR," + "TIPO_MOV,"
				+ "FECHA_CONTABLE," + "FECHA_EMISION," + "FECHA_VTO," + "SIGNO," + "IMPORTE," + "OID_CCO," + "ACTIVO," + "IMPORTE_HIST,"
				+ "IMPORTE_AJU," + "IMPORTE_EXT1," + "IMPORTE_EXT2," + "cotiz_mon_ori," + "cotiz_mon_ext1," + "cotiz_mon_ext2,"
				+ "cotiz_mon_ori_con," + "cotiz_mon_ext1_con,"
				+ "cotiz_mon_ext2_con,fecha_oper , oid_valor , oid_ai , oid_tipo_valor , conciliado , oid_conci_bco " + ")" + " values "
				+ "(" + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?,"
				+ "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_MOV_CTA_BCO, pers.getOID());
		qInsert.setInt(OID_CTA_BANCARIA, pers.getCtabancaria().getOID());
		if (pers.getNrovalor() != null)
			qInsert.setInt(NRO_VALOR, pers.getNrovalor().intValue());
		else
			qInsert.setNull(NRO_VALOR, Types.INTEGER);
		qInsert.setString(TIPO_MOV, pers.getTipomov());
		qInsert.setDate(FECHA_CONTABLE, new java.sql.Date(pers.getFechacontable().getTime()));
		qInsert.setDate(FECHA_EMISION, new java.sql.Date(pers.getFechaemision().getTime()));
		if (pers.getFechavto() != null)
			qInsert.setDate(FECHA_VTO, new java.sql.Date(pers.getFechavto().getTime()));
		else
			qInsert.setNull(FECHA_VTO, Types.DATE);
		qInsert.setInt(SIGNO, pers.getSigno().intValue());
		qInsert.setDouble(IMPORTE, pers.getImporte().doubleValue());
		qInsert.setInt(OID_CCO, pers.getComprobante().getOID());
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qInsert.setDouble(IMPORTE_HIST, pers.getImportehist().doubleValue());
		qInsert.setDouble(IMPORTE_AJU, pers.getImporteaju().doubleValue());
		qInsert.setDouble(IMPORTE_EXT1, pers.getImporteext1().doubleValue());
		qInsert.setDouble(IMPORTE_EXT2, pers.getImporteext2().doubleValue());
		qInsert.setDouble(COTIZ_MON_ORI, pers.getCotizMonOri().doubleValue());
		qInsert.setDouble(COTIZ_MON_EXT1, pers.getCotizMonExt1().doubleValue());
		qInsert.setDouble(COTIZ_MON_EXT2, pers.getCotizMonExt2().doubleValue());
		qInsert.setDouble(COTIZ_MON_ORI_CON, pers.getCotizMonOriCon().doubleValue());
		qInsert.setDouble(COTIZ_MON_EXT1_CON, pers.getCotizMonExt1Con().doubleValue());
		qInsert.setDouble(COTIZ_MON_EXT2_CON, pers.getCotizMonExt2Con().doubleValue());
		if (pers.getFechaOperativa() != null)
			qInsert.setDate(FECHA_OPER, new java.sql.Date(pers.getFechaOperativa().getTime()));
		else {
			if ((pers.isConciliado() != null) && (pers.isConciliado()))
				qInsert.setDate(FECHA_OPER, new java.sql.Date(pers.getFechacontable().getTime()));
			else
				qInsert.setNull(FECHA_OPER, Types.DATE);
		}

		if (pers.getValor() != null)
			qInsert.setInt(OID_VALOR, pers.getValor().getOID());
		else
			qInsert.setNull(OID_VALOR, Types.INTEGER);

		if (pers.getCuenta() != null)
			qInsert.setInt(OID_AI, pers.getCuenta().getOID());
		else
			qInsert.setNull(OID_AI, Types.INTEGER);

		if (pers.getTipoValor() != null)
			qInsert.setInt(OID_TIPO_VALOR, pers.getTipoValor().getOID());
		else
			qInsert.setNull(OID_TIPO_VALOR, Types.INTEGER);

		if (pers.isConciliado() != null)
			qInsert.setBoolean(CONCILIADO, pers.isConciliado().booleanValue());
		else
			qInsert.setBoolean(CONCILIADO, false);

		if (pers.getConciliacionCab() != null)
			qInsert.setInt(OID_CONCI_BCO, pers.getConciliacionCab().getOID());
		else
			qInsert.setNull(OID_CONCI_BCO, java.sql.Types.INTEGER);

		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_CTA_BANCARIA = 1;
		final int NRO_VALOR = 2;
		final int TIPO_MOV = 3;
		final int FECHA_CONTABLE = 4;
		final int FECHA_EMISION = 5;
		final int FECHA_VTO = 6;
		final int SIGNO = 7;
		final int IMPORTE = 8;
		final int OID_CCO = 9;
		final int ACTIVO = 10;
		final int IMPORTE_HIST = 11;
		final int IMPORTE_AJU = 12;
		final int IMPORTE_EXT1 = 13;
		final int IMPORTE_EXT2 = 14;
		final int COTIZ_MON_ORI = 15;
		final int COTIZ_MON_EXT1 = 16;
		final int COTIZ_MON_EXT2 = 17;
		final int COTIZ_MON_ORI_CON = 18;
		final int COTIZ_MON_EXT1_CON = 19;
		final int COTIZ_MON_EXT2_CON = 20;
		final int FECHA_OPER = 21;
		final int OID_VALOR = 22;
		final int OID_AI = 23;
		final int OID_TIPO_VALOR = 24;
		final int CONCILIADO = 25;
		final int OID_CONCI_BCO = 26;
		final int OID_MOV_CTA_BCO = 27;

		MovimientoCtaBancaria pers = (MovimientoCtaBancaria) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update  VAMOVIMBANCO set " + "oid_cta_bancaria=?" + ",nro_valor=?" + ",tipo_mov=?" + ",Fecha_Contable=?"
				+ ",Fecha_Emision=?" + ",Fecha_Vto=?" + ",signo=?" + ",importe=?" + ",oid_cco=?" + ",activo=?" + ",importe_hist=?"
				+ ",importe_aju=?" + ",importe_ext1=?" + ",importe_ext2=?" + ",cotiz_mon_ori=?" + ",cotiz_mon_ext1=?" + ",cotiz_mon_ext2=?"
				+ ",cotiz_mon_ori_con=?" + ",cotiz_mon_ext1_con=?" + ",cotiz_mon_ext2_con=?" + ",fecha_oper=?"
				+ ",oid_valor=?,oid_ai=? , oid_tipo_valor = ? , conciliado = ? , oid_conci_bco = ?  where " + " oid_mov_cta_bco=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_MOV_CTA_BCO, pers.getOID());
		qUpdate.setInt(OID_CTA_BANCARIA, pers.getCtabancaria().getOID());
		qUpdate.setInt(NRO_VALOR, pers.getNrovalor().intValue());
		qUpdate.setString(TIPO_MOV, pers.getTipomov());
		qUpdate.setDate(FECHA_CONTABLE, new java.sql.Date(pers.getFechacontable().getTime()));
		qUpdate.setDate(FECHA_EMISION, new java.sql.Date(pers.getFechaemision().getTime()));
		if (pers.getFechavto() != null)
			qUpdate.setDate(FECHA_VTO, new java.sql.Date(pers.getFechavto().getTime()));
		else
			qUpdate.setNull(FECHA_VTO, java.sql.Types.DATE);
		qUpdate.setInt(SIGNO, pers.getSigno().intValue());
		qUpdate.setDouble(IMPORTE, pers.getImporte().doubleValue());
		qUpdate.setInt(OID_CCO, pers.getComprobante().getOID());
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qUpdate.setDouble(IMPORTE_HIST, pers.getImportehist().doubleValue());
		qUpdate.setDouble(IMPORTE_AJU, pers.getImporteaju().doubleValue());
		qUpdate.setDouble(IMPORTE_EXT1, pers.getImporteext1().doubleValue());
		qUpdate.setDouble(IMPORTE_EXT2, pers.getImporteext2().doubleValue());
		qUpdate.setDouble(COTIZ_MON_ORI, pers.getCotizMonOri().doubleValue());
		qUpdate.setDouble(COTIZ_MON_EXT1, pers.getCotizMonExt1().doubleValue());
		qUpdate.setDouble(COTIZ_MON_EXT2, pers.getCotizMonExt2().doubleValue());
		qUpdate.setDouble(COTIZ_MON_ORI_CON, pers.getCotizMonOriCon().doubleValue());
		qUpdate.setDouble(COTIZ_MON_EXT1_CON, pers.getCotizMonExt1Con().doubleValue());
		qUpdate.setDouble(COTIZ_MON_EXT2_CON, pers.getCotizMonExt2Con().doubleValue());

		if (pers.getFechaOperativa() != null)
			qUpdate.setDate(FECHA_OPER, new java.sql.Date(pers.getFechaOperativa().getTime()));
		else {
			if ((pers.isConciliado() != null) && (pers.isConciliado()))
				qUpdate.setDate(FECHA_OPER, new java.sql.Date(pers.getFechacontable().getTime()));
			else
				qUpdate.setNull(FECHA_OPER, Types.DATE);
		}

		if (pers.getValor() != null)
			qUpdate.setInt(OID_VALOR, pers.getValor().getOID());
		else
			qUpdate.setNull(OID_VALOR, Types.INTEGER);

		if (pers.getCuenta() != null)
			qUpdate.setInt(OID_AI, pers.getCuenta().getOID());
		else
			qUpdate.setNull(OID_AI, Types.INTEGER);

		if (pers.getTipoValor() != null)
			qUpdate.setInt(OID_TIPO_VALOR, pers.getTipoValor().getOID());
		else
			qUpdate.setNull(OID_TIPO_VALOR, Types.INTEGER);

		if (pers.isConciliado() != null)
			qUpdate.setBoolean(CONCILIADO, pers.isConciliado().booleanValue());
		else
			qUpdate.setBoolean(CONCILIADO, false);

		if (pers.getConciliacionCab() != null)
			qUpdate.setInt(OID_CONCI_BCO, pers.getConciliacionCab().getOID());
		else
			qUpdate.setNull(OID_CONCI_BCO, java.sql.Types.INTEGER);

		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_MOV_CTA_BCO = 1;
		MovimientoCtaBancaria pers = (MovimientoCtaBancaria) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update  VAMOVIMBANCO " + " set activo=0 " + " where " + " oid_mov_cta_bco=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_MOV_CTA_BCO, pers.getOID());

		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_MOV_CTA_BCO = 1;
		MovimientoCtaBancaria pers = (MovimientoCtaBancaria) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update VAMOVIMBANCO " + " set activo=1 " + " where " + " oid_mov_cta_bco=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_MOV_CTA_BCO, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	public PreparedStatement prepararSelect(int aSelect, Object aCondiciones) throws BaseException, SQLException {
		PreparedStatement ps = null;
		switch (aSelect) {
		case IDBObjetoPersistente.SELECT_BY_OID: {
			ps = this.selectByOID(aCondiciones);
			break;
		}
		case IDBObjetoPersistente.SELECT_BY_CODIGO: {
			ps = this.selectByCodigo(aCondiciones);
			break;
		}
		case IDBObjetoPersistente.SELECT_ALL_HELP: {
			ps = this.selectAllHelp(aCondiciones);
			break;
		}
		case SELECT_MOV_CTA_NO_CONCILIADOS: {
			ps = this.selectMovCtaNoConciliados(aCondiciones);
			break;
		}
		case SELECT_BY_TIPO_CTA_TIPO_SALDO_CONTA: {
			ps = this.selectByTipoCtaTipoSaldoConta(aCondiciones);
			break;
		}
		case SELECT_BY_TIPO_CTA_TIPO_SALDO_OPER: {
			ps = this.selectByTipoCtaTipoSaldoOper(aCondiciones);
			break;
		}
		case SELECT_BY_CTA_BCO_VALOR_SALIDA: {
			ps = this.selectByCtaBancoValorSalida(aCondiciones);
			break;
		}
		case SELECT_BY_TIPO_CTA_SIGNO_VALOR: {
			ps = this.selectByTipoCtaSignoValor(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_MOV_CTA_BCO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM VAMOVIMBANCO  ");
		textSQL.append(" WHERE oid_mov_cta_bco = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_MOV_CTA_BCO, oid);
		return querySelect;
	}

	private PreparedStatement selectByTipoCtaTipoSaldoConta(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  VAMOVIMBANCO ");
		textSQL.append(" WHERE oid_cta_bancaria = ? and Fecha_Contable>=? and Fecha_Contable<=? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		CuentaBancaria cuentaBancaria = (CuentaBancaria) condiciones.get(CuentaBancaria.NICKNAME);
		java.util.Date fechaDesde = (java.util.Date) condiciones.get("FECHA_DESDE");
		java.util.Date fechaHasta = (java.util.Date) condiciones.get("FECHA_HASTA");
		querySelect.setInt(1, cuentaBancaria.getOID());
		querySelect.setDate(2, new Date(fechaDesde.getTime()));
		querySelect.setDate(3, new Date(fechaHasta.getTime()));
		return querySelect;
	}

	private PreparedStatement selectByCtaBancoValorSalida(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  VAMOVIMBANCO ");
		textSQL.append(" WHERE oid_cta_bancaria = ? and signo=-1 and oid_valor = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		CuentaBancaria cuentaBancaria = (CuentaBancaria) condiciones.get(CuentaBancaria.NICKNAME);
		Valor valor = (Valor) condiciones.get(Valor.NICKNAME);
		querySelect.setInt(1, cuentaBancaria.getOID());
		querySelect.setInt(2, valor.getOID());
		return querySelect;
	}

	private PreparedStatement selectByTipoCtaTipoSaldoOper(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  VAMOVIMBANCO ");
		textSQL.append(" WHERE oid_cta_bancaria = ? and Fecha_Oper>=? and Fecha_Oper<=? and conciliado=1 ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		CuentaBancaria cuentaBancaria = (CuentaBancaria) condiciones.get(CuentaBancaria.NICKNAME);
		java.util.Date fechaDesde = (java.util.Date) condiciones.get("FECHA_DESDE");
		java.util.Date fechaHasta = (java.util.Date) condiciones.get("FECHA_HASTA");
		querySelect.setInt(1, cuentaBancaria.getOID());
		querySelect.setDate(2, new Date(fechaDesde.getTime()));
		querySelect.setDate(3, new Date(fechaHasta.getTime()));
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  VAMOVIMBANCO ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectMovCtaNoConciliados(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  VAMOVIMBANCO ");
		textSQL.append(" WHERE oid_cta_bancaria = ? and conciliado = 0");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		CuentaBancaria ctaBco = (CuentaBancaria) condiciones.get(CuentaBancaria.NICKNAME);
		querySelect.setInt(1, ctaBco.getOID());
		return querySelect;
	}

	private PreparedStatement selectByTipoCtaSignoValor(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  VAMOVIMBANCO ");
		textSQL.append(" WHERE oid_cta_bancaria = ? and signo=? and oid_valor=?");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		CuentaBancaria ctaBco = (CuentaBancaria) condiciones.get(CuentaBancaria.NICKNAME);
		Integer signo = (Integer) condiciones.get("SIGNO");
		Valor valor = (Valor) condiciones.get(Valor.NICKNAME);
		querySelect.setInt(1, ctaBco.getOID());
		querySelect.setInt(2, signo.intValue());
		querySelect.setInt(3, valor.getOID());
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_mov_cta_bco oid, codigo,  descripcion ,activo ");
		textSQL.append(" from VAMOVIMBANCO ");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static List getMovCtaBancoContable(CuentaBancaria cuentaBancaria, java.util.Date fechaDesde, java.util.Date fechaHasta,
			ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(CuentaBancaria.NICKNAME, cuentaBancaria);
		condiciones.put("FECHA_DESDE", fechaDesde);
		condiciones.put("FECHA_HASTA", fechaHasta);
		return (List) ObjetoLogico.getObjects(MovimientoCtaBancaria.NICKNAME, DBMovimientoCtaBancaria.SELECT_BY_TIPO_CTA_TIPO_SALDO_CONTA,
				condiciones, new ListObserver(), aSesion);
	}

	public static List getMovCtaBancoOperativo(CuentaBancaria cuentaBancaria, java.util.Date fechaDesde, java.util.Date fechaHasta,
			ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(CuentaBancaria.NICKNAME, cuentaBancaria);
		condiciones.put("FECHA_DESDE", fechaDesde);
		condiciones.put("FECHA_HASTA", fechaHasta);
		return (List) ObjetoLogico.getObjects(MovimientoCtaBancaria.NICKNAME, DBMovimientoCtaBancaria.SELECT_BY_TIPO_CTA_TIPO_SALDO_OPER,
				condiciones, new ListObserver(), aSesion);
	}

	public static List getMovCtaBancoNoConciliados(CuentaBancaria cuentaBancaria, ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(CuentaBancaria.NICKNAME, cuentaBancaria);
		return (List) ObjetoLogico.getObjects(MovimientoCtaBancaria.NICKNAME, DBMovimientoCtaBancaria.SELECT_MOV_CTA_NO_CONCILIADOS,
				condiciones, new ListObserver(), aSesion);
	}

	public static MovimientoCtaBancaria getMovCuentaByCuentaValorSalida(CuentaBancaria cuentaBancaria, Valor valor, ISesion aSesion)
			throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(CuentaBancaria.NICKNAME, cuentaBancaria);
		condiciones.put(Valor.NICKNAME, valor);
		return (MovimientoCtaBancaria) ObjetoLogico.getObjects(MovimientoCtaBancaria.NICKNAME,
				DBMovimientoCtaBancaria.SELECT_BY_CTA_BCO_VALOR_SALIDA, condiciones, new ObjetoObservado(), aSesion);
	}

	public static MovimientoCtaBancaria getMovByCuentaSignoValor(CuentaBancaria cuentaBancaria, Integer signo, Valor valor, ISesion aSesion)
			throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(CuentaBancaria.NICKNAME, cuentaBancaria);
		condiciones.put("SIGNO", signo);
		condiciones.put(Valor.NICKNAME, valor);
		return (MovimientoCtaBancaria) ObjetoLogico.getObjects(MovimientoCtaBancaria.NICKNAME,
				DBMovimientoCtaBancaria.SELECT_BY_TIPO_CTA_SIGNO_VALOR, condiciones, new ObjetoObservado(), aSesion);
	}

}
