package com.srn.erp.stock.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.stock.bm.Deposito;
import com.srn.erp.stock.bm.EstadoDeposito;
import com.srn.erp.stock.bm.EstadoStock;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBEstadoDeposito extends DBObjetoPersistente {

	public static final String OID_ESTADO_DEPO = "oid_estado_depo";

	public static final String OID_DEPOSITO = "oid_deposito";

	public static final String OID_ESTADO_STOCK = "oid_estado_stock";

	public static final String ALLOW_SALDO_NEG = "allow_saldo_neg";

	public static final String AGRUPADOR_ESTADO_STOCK = "oid_agrup_estado";

	public static final int SELECT_BY_DEPOSITO = 100;

	public static final int SELECT_BY_DEPOSITO_ESTADO = 101;

	public DBEstadoDeposito() {
	}

	protected void insert(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {

		final int OID_ESTADO_DEPO = 1;
		final int OID_DEPOSITO = 2;
		final int OID_ESTADO_STOCK = 3;
		final int ALLOW_SALDO_NEG = 4;
		final int OID_AGRUP_ESTADO = 5;

		EstadoDeposito pers = (EstadoDeposito) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into skEstadosDepo " + " ( "
				+ "OID_ESTADO_DEPO," + "OID_DEPOSITO," + "OID_ESTADO_STOCK,"
				+ "ALLOW_SALDO_NEG," + "OID_AGRUP_ESTADO)" + " values " + "("
				+ "?," + "?," + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD()
				.prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_ESTADO_DEPO, pers.getOID());
		qInsert.setInt(OID_DEPOSITO, pers.getDeposito().getOID());
		qInsert.setInt(OID_ESTADO_STOCK, pers.getEstado_stock().getOID());
		qInsert.setBoolean(ALLOW_SALDO_NEG, pers.isAllow_saldo_neg()
				.booleanValue());
		qInsert.setInt(OID_AGRUP_ESTADO, pers.getAgrupadorEstadoStock()
				.getOID());

		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {

		final int OID_DEPOSITO = 1;
		final int OID_ESTADO_STOCK = 2;
		final int ALLOW_SALDO_NEG = 3;
		final int OID_AGRUP_ESTADO = 4;
		final int OID_ESTADO_DEPO = 5;

		EstadoDeposito pers = (EstadoDeposito) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update skEstadosDepo set " + "oid_deposito=?"
				+ ",oid_estado_stock=?" + ",allow_saldo_neg=?"
				+ ",oid_agrup_estado=?" + " where " + " oid_estado_depo=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_ESTADO_DEPO, pers.getOID());
		qUpdate.setInt(OID_DEPOSITO, pers.getDeposito().getOID());
		qUpdate.setInt(OID_ESTADO_STOCK, pers.getEstado_stock().getOID());
		qUpdate.setBoolean(ALLOW_SALDO_NEG, pers.isAllow_saldo_neg()
				.booleanValue());
		qUpdate.setInt(OID_AGRUP_ESTADO, pers.getAgrupadorEstadoStock()
				.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {
		final int OID_ESTADO_DEPO = 1;
		EstadoDeposito pers = (EstadoDeposito) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("delete from skEstadosDepo " + " where "
				+ " oid_estado_depo=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_ESTADO_DEPO, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {
		final int OID_ESTADO_DEPO = 1;
		EstadoDeposito pers = (EstadoDeposito) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update skEstadosDepo " + " set activo=1 " + " where "
				+ " oid_estado_depo=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_ESTADO_DEPO, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	public PreparedStatement prepararSelect(int aSelect, Object aCondiciones)
			throws BaseException, SQLException {
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
		case SELECT_BY_DEPOSITO: {
			ps = this.selectByDeposito(aCondiciones);
			break;
		}
		case SELECT_BY_DEPOSITO_ESTADO: {
			ps = this.selectByDepositoEstado(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones)
			throws BaseException, SQLException {

		final int OID_ESTADO_DEPO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  skEstadosDepo ");
		textSQL.append(" WHERE oid_estado_depo = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_ESTADO_DEPO, oid);
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones)
			throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  skEstadosDepo ");
		textSQL.append(" WHERE oid_deposito = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectByDeposito(Object aCondiciones)
			throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  skEstadosDepo ");
		textSQL.append(" WHERE oid_deposito = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		Deposito deposito = (Deposito) aCondiciones;
		querySelect.setInt(1, deposito.getOID());
		return querySelect;
	}

	private PreparedStatement selectByDepositoEstado(Object aCondiciones)
			throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		Deposito deposito = (Deposito) condiciones.get(Deposito.NICKNAME);
		EstadoStock estadoStock = (EstadoStock) condiciones.get(EstadoStock.NICKNAME);
		textSQL.append("SELECT * FROM  skEstadosDepo ");
		textSQL.append(" WHERE oid_deposito = ? and oid_estado_stock = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		querySelect.setInt(1, deposito.getOID());
		querySelect.setInt(2, estadoStock.getOID());
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones)
			throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL
				.append("SELECT oid_estado_depo oid,oid_deposito codigo, oid_estado_stock descripcion ,activo ");
		textSQL.append(" from skEstadosDepo");

		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static List getEstadosDeposito(Deposito deposito, ISesion aSesion)
			throws BaseException {
		return (List) ObjetoLogico.getObjects(EstadoDeposito.NICKNAME,
				DBEstadoDeposito.SELECT_BY_DEPOSITO, deposito,
				new ListObserver(), aSesion);
	}

	public static EstadoDeposito getEstadoDeposito(Deposito deposito,
									EstadoStock estadoStock,
									ISesion aSesion)
			throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(Deposito.NICKNAME,deposito);
		condiciones.put(EstadoStock.NICKNAME,estadoStock);
		return (EstadoDeposito) ObjetoLogico.getObjects(EstadoDeposito.NICKNAME,
				DBEstadoDeposito.SELECT_BY_DEPOSITO_ESTADO, condiciones,
				new ObjetoObservado(), aSesion);
	}

}
