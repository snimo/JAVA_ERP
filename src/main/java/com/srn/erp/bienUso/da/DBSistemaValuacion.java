package com.srn.erp.bienUso.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.bienUso.bm.SistemaValuacion;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBSistemaValuacion extends DBObjetoPersistente {

	public static final String OID_SIST_VAL = "oid_sist_val";

	public static final String CODIGO = "codigo";

	public static final String DESCRIPCION = "descripcion";

	public static final String TIPO_AMORT = "tipo_amort";

	public static final String CONTABLE = "contable";

	public static final String AJU_INF = "aju_inf";

	public static final String OID_MONEDA = "oid_moneda";

	public static final String OID_INDICE = "oid_indice";

	public static final String ACTIVO = "activo";

	public DBSistemaValuacion() {
	}

	protected void insert(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {

		final int OID_SIST_VAL = 1;
		final int CODIGO = 2;
		final int DESCRIPCION = 3;
		final int TIPO_AMORT = 4;
		final int CONTABLE = 5;
		final int AJU_INF = 6;
		final int OID_MONEDA = 7;
		final int OID_INDICE = 8;
		final int ACTIVO = 9;

		SistemaValuacion pers = (SistemaValuacion) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into buSistVal " + " ( " + "OID_SIST_VAL,"
				+ "CODIGO," + "DESCRIPCION," + "TIPO_AMORT," + "CONTABLE,"
				+ "AJU_INF," + "OID_MONEDA," + "OID_INDICE," + "ACTIVO)"
				+ " values " + "(" + "?," + "?," + "?," + "?," + "?," + "?,"
				+ "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD()
				.prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_SIST_VAL, pers.getOID());
		qInsert.setString(CODIGO, pers.getCodigo());
		qInsert.setString(DESCRIPCION, pers.getDescripcion());
		qInsert.setString(TIPO_AMORT, pers.getTipo_amort());
		qInsert.setBoolean(CONTABLE, pers.isContable().booleanValue());
		qInsert.setBoolean(AJU_INF, pers.isAju_inf().booleanValue());
		qInsert.setInt(OID_MONEDA, pers.getMoneda().getOID());
		if (pers.getIndice() != null)
			qInsert.setInt(OID_INDICE, pers.getIndice().getOID());
		else
			qInsert.setNull(OID_INDICE, java.sql.Types.INTEGER);
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {

		final int CODIGO = 1;
		final int DESCRIPCION = 2;
		final int TIPO_AMORT = 3;
		final int CONTABLE = 4;
		final int AJU_INF = 5;
		final int OID_MONEDA = 6;
		final int OID_INDICE = 7;
		final int ACTIVO = 8;
		final int OID_SIST_VAL = 9;

		SistemaValuacion pers = (SistemaValuacion) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update buSistVal set " + "codigo=?"
				+ ",descripcion=?" + ",tipo_amort=?" + ",contable=?"
				+ ",aju_inf=?" + ",oid_moneda=?" + ",oid_indice=?"
				+ ",activo=?" + " where " + " oid_sist_val=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_SIST_VAL, pers.getOID());
		qUpdate.setString(CODIGO, pers.getCodigo());
		qUpdate.setString(DESCRIPCION, pers.getDescripcion());
		qUpdate.setString(TIPO_AMORT, pers.getTipo_amort());
		qUpdate.setBoolean(CONTABLE, pers.isContable().booleanValue());
		qUpdate.setBoolean(AJU_INF, pers.isAju_inf().booleanValue());
		qUpdate.setInt(OID_MONEDA, pers.getMoneda().getOID());
		if (pers.getIndice() != null)
			qUpdate.setInt(OID_INDICE, pers.getIndice().getOID());
		else
			qUpdate.setNull(OID_INDICE, java.sql.Types.INTEGER);
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {
		final int OID_SIST_VAL = 1;
		SistemaValuacion pers = (SistemaValuacion) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update buSistVal " + " set activo=0 " + " where "
				+ " oid_sist_val=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_SIST_VAL, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {
		final int OID_SIST_VAL = 1;
		SistemaValuacion pers = (SistemaValuacion) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update buSistVal " + " set activo=1 " + " where "
				+ " oid_sist_val=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_SIST_VAL, pers.getOID());
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
		case IDBObjetoPersistente.SELECT_ALL: {
			ps = this.selectAll(aCondiciones);
			break;
		}
		case SELECT_ALL_ACTIVOS: {
			ps = this.selectAllActivos(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones)
			throws BaseException, SQLException {

		final int OID_SIST_VAL = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  buSistVal ");
		textSQL.append(" WHERE oid_sist_val = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_SIST_VAL, oid);
		return querySelect;
	}

	private PreparedStatement selectAll(Object aCondiciones)
			throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  buSistVal ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		return querySelect;
	}

	private PreparedStatement selectAllActivos(Object aCondiciones)
			throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  buSistVal ");
		textSQL.append(" WHERE activo = 1 ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones)
			throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  buSistVal ");
		textSQL.append(" WHERE codigo = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones)
			throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL
				.append("SELECT oid_sist_val oid,codigo codigo,  descripcion ,activo ");
		textSQL.append(" from buSistVal");

		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static List getSistemasDeValuacion(ISesion aSesion)
			throws BaseException {
		return (List) ObjetoLogico.getObjects(SistemaValuacion.NICKNAME,
				DBSistemaValuacion.SELECT_ALL, null, new ListObserver(),
				aSesion);
	}

	public static List getSistemasDeValuacionActivos(ISesion aSesion)
			throws BaseException {
		return (List) ObjetoLogico.getObjects(SistemaValuacion.NICKNAME,
				DBSistemaValuacion.SELECT_ALL_ACTIVOS, null, new ListObserver(),
				aSesion);
	}
}
