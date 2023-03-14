package com.srn.erp.ctasAPagar.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.ctasAPagar.bm.EsquemaAutorizFactMonto;
import com.srn.erp.ctasAPagar.bm.EsquemaAutorizFactProv;
import com.srn.erp.general.bm.Periodo;
import com.srn.erp.general.da.DBPeriodo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBEsquemaAutorizFactMonto extends DBObjetoPersistente {

	public static final String	OID_ESQ_AUT_MON							= "oid_esq_aut_mon";

	public static final String	OID_ESQ_AUT_FACT						= "oid_esq_aut_fact";

	public static final String	ORDEN												= "orden";

	public static final String	MONTO_DESDE									= "monto_desde";

	public static final String	MONTO_HASTA									= "monto_hasta";

	public static final int			SELECT_BY_ESQ_AUTORIZ_FACT	= 100;

	public static final int			SELECT_BY_MONTO							= 101;

	public DBEsquemaAutorizFactMonto() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_ESQ_AUT_MON = 1;
		final int OID_ESQ_AUT_FACT = 2;
		final int ORDEN = 3;
		final int MONTO_DESDE = 4;
		final int MONTO_HASTA = 5;

		EsquemaAutorizFactMonto pers = (EsquemaAutorizFactMonto) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into cpEsqAutFactMon " + " ( " + "OID_ESQ_AUT_MON," + "OID_ESQ_AUT_FACT," + "ORDEN,"
				+ "MONTO_DESDE," + "MONTO_HASTA)" + " values " + "(" + "?," + "?," + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_ESQ_AUT_MON, pers.getOID());
		qInsert.setInt(OID_ESQ_AUT_FACT, pers.getEsquema_autoriz_factura().getOID());
		qInsert.setInt(ORDEN, pers.getOrden().intValue());
		qInsert.setDouble(MONTO_HASTA, pers.getMonto_hasta().doubleValue());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_ESQ_AUT_FACT = 1;
		final int ORDEN = 2;
		final int MONTO_DESDE = 3;
		final int MONTO_HASTA = 4;
		final int OID_ESQ_AUT_MON = 5;

		EsquemaAutorizFactMonto pers = (EsquemaAutorizFactMonto) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update cpEsqAutFactMon set " + "oid_esq_aut_fact=?" + ",orden=?" + ",monto_desde=?"
				+ ",monto_hasta=?" + " where " + " oid_esq_aut_mon=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_ESQ_AUT_MON, pers.getOID());
		qUpdate.setInt(OID_ESQ_AUT_FACT, pers.getEsquema_autoriz_factura().getOID());
		qUpdate.setInt(ORDEN, pers.getOrden().intValue());
		qUpdate.setDouble(MONTO_DESDE, pers.getMonto_desde().doubleValue());
		qUpdate.setDouble(MONTO_HASTA, pers.getMonto_hasta().doubleValue());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_ESQ_AUT_MON = 1;
		EsquemaAutorizFactMonto pers = (EsquemaAutorizFactMonto) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("delete from cpEsqAutFactMon where " + " oid_esq_aut_mon=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_ESQ_AUT_MON, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_ESQ_AUT_MON = 1;
		EsquemaAutorizFactMonto pers = (EsquemaAutorizFactMonto) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cpEsqAutFactMon " + " set activo=1 " + " where " + " oid_esq_aut_mon=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_ESQ_AUT_MON, pers.getOID());
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
		case SELECT_BY_ESQ_AUTORIZ_FACT: {
			ps = this.selectByEsqAutorizFact(aCondiciones);
			break;
		}
		case SELECT_BY_MONTO: {
			ps = this.selectByMonto(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_ESQ_AUT_MON = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cpEsqAutFactMon ");
		textSQL.append(" WHERE oid_esq_aut_mon = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_ESQ_AUT_MON, oid);
		return querySelect;
	}

	private PreparedStatement selectByMonto(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cpEsqAutFactMon ");
		textSQL.append(" WHERE monto_desde <= ? and monto_hasta>=? and oid_esq_aut_fact=? ");

		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		Money monto = (Money) condiciones.get("MONTO");
		EsquemaAutorizFactProv esqAutorizFactProv = (EsquemaAutorizFactProv) condiciones
				.get(EsquemaAutorizFactProv.NICKNAME);

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		querySelect.setDouble(1, monto.doubleValue());
		querySelect.setDouble(2, monto.doubleValue());
		querySelect.setInt(3, esqAutorizFactProv.getOID());

		return querySelect;
	}

	private PreparedStatement selectByEsqAutorizFact(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cpEsqAutFactMon ");
		textSQL.append(" WHERE oid_esq_aut_fact = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		EsquemaAutorizFactProv esqAutorizFactProv = (EsquemaAutorizFactProv) aCondiciones;
		querySelect.setInt(1, esqAutorizFactProv.getOID());
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cpEsqAutFactMon ");
		textSQL.append(" WHERE oid_esq_aut_fact = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_esq_aut_mon oid,oid_esq_aut_fact codigo, orden descripcion ,activo ");
		textSQL.append(" from cpEsqAutFactMon");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static List getEsqAutorizMontos(EsquemaAutorizFactProv aEsquemaAutorizFactProv, ISesion aSesion)
			throws BaseException {
		return (List) ObjetoLogico.getObjects(EsquemaAutorizFactMonto.NICKNAME,
				DBEsquemaAutorizFactMonto.SELECT_BY_ESQ_AUTORIZ_FACT, aEsquemaAutorizFactProv, new ListObserver(), aSesion);
	}

	public static EsquemaAutorizFactMonto getEsqAutorizFactMonto(Money monto, EsquemaAutorizFactProv esquemaAutoriz,
			ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put("MONTO", monto);
		condiciones.put(EsquemaAutorizFactProv.NICKNAME, esquemaAutoriz);
		return (EsquemaAutorizFactMonto) ObjetoLogico.getObjects(EsquemaAutorizFactMonto.NICKNAME,
				DBEsquemaAutorizFactMonto.SELECT_BY_MONTO, condiciones, new ObjetoObservado(), aSesion);
	}

}
