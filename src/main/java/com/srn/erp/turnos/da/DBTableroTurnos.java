package com.srn.erp.turnos.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.turnos.bm.TableroTurnos;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBTableroTurnos extends DBObjetoPersistente {

	public static final String OID_TABLERO_CAB = "oid_tablero_cab";
	public static final String DESCRIPCION = "descripcion";
	public static final String FECHA = "fecha";
	public static final String COMPORTAMIENTO = "comportamiento";
	public static final String REGLA_ACTIVO = "regla_activo";
	public static final String LECTOR_ACTIVO = "lector_activo";

	public static final int SELECT_BY_FECHA_COMPORTAMIENTO = 100;
	public static final int DELETE_TABLERO = 101;
	public static final int SELECT_BY_FECHA_DESDE_HASTA_COMPO = 102;

	public DBTableroTurnos() {
	}

	protected void insert(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {

		final int OID_TABLERO_CAB = 1;
		final int DESCRIPCION = 2;
		final int FECHA = 3;
		final int COMPORTAMIENTO = 4;
		final int REGLA_ACTIVO = 5;
		final int LECTOR_ACTIVO = 6;

		TableroTurnos pers = (TableroTurnos) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into tuTableroCab " + " ( "
				+ "OID_TABLERO_CAB," + "DESCRIPCION," + "FECHA,"
				+ "COMPORTAMIENTO , REGLA_ACTIVO , LECTOR_ACTIVO)" + " values " + "(" + "?," +"?," + "?,"+ "?," + "?,"
				+ "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD()
				.prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_TABLERO_CAB, pers.getOID());
		qInsert.setString(DESCRIPCION, pers.getDescripcion());
		qInsert.setDate(FECHA, new java.sql.Date(pers.getFecha().getTime()));
		qInsert.setString(COMPORTAMIENTO, pers.getComportamiento());
		qInsert.setBoolean(REGLA_ACTIVO, pers.isReglamentoActivo());
		if (pers.isLectorActivo()!=null)
			qInsert.setBoolean(LECTOR_ACTIVO, pers.isLectorActivo().booleanValue());
		else
			qInsert.setBoolean(LECTOR_ACTIVO, true);
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {

		final int DESCRIPCION = 1;
		final int FECHA = 2;
		final int COMPORTAMIENTO = 3;
		final int REGLA_ACTIVO = 4;
		final int LECTOR_ACTIVO = 5;
		final int OID_TABLERO_CAB = 6;

		TableroTurnos pers = (TableroTurnos) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update tuTableroCab set " + "descripcion=?"
				+ ",fecha=?" + ",comportamiento=? , regla_activo = ? , lector_activo=? " + " where "
				+ " oid_tablero_cab=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_TABLERO_CAB, pers.getOID());
		qUpdate.setString(DESCRIPCION, pers.getDescripcion());
		qUpdate.setDate(FECHA, new java.sql.Date(pers.getFecha().getTime()));
		qUpdate.setString(COMPORTAMIENTO, pers.getComportamiento());
		qUpdate.setBoolean(REGLA_ACTIVO, pers.isReglamentoActivo());
		if (pers.isLectorActivo()!=null)
			qUpdate.setBoolean(LECTOR_ACTIVO, pers.isLectorActivo().booleanValue());
		else
			qUpdate.setBoolean(LECTOR_ACTIVO, true);
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {
		final int OID_TABLERO_CAB = 1;
		TableroTurnos pers = (TableroTurnos) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update tuTableroCab " + " set activo=0 " + " where "
				+ " oid_tablero_cab=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_TABLERO_CAB, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void deleteTablero(Object objetoPersistente)
			throws BaseException, SQLException {

		final int OID_TABLERO_CAB = 1;
		TableroTurnos pers = (TableroTurnos) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("delete from tuTableroCab " + " where "
				+ " oid_tablero_cab=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_TABLERO_CAB, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();

		StringBuffer sqlUpdate1 = new StringBuffer();
		sqlUpdate1.append("delete from tuTableroEntidad " + " where "
				+ " oid_tablero_cab=? ");
		PreparedStatement qUpdate1 = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate1.toString());
		qUpdate1.setInt(OID_TABLERO_CAB, pers.getOID());
		qUpdate1.executeUpdate();
		qUpdate1.close();

		StringBuffer sqlUpdate2 = new StringBuffer();
		sqlUpdate2.append("delete from tuTableroHorario " + " where "
				+ " oid_tablero_cab=? ");
		PreparedStatement qUpdate2 = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate2.toString());
		qUpdate2.setInt(OID_TABLERO_CAB, pers.getOID());
		qUpdate2.executeUpdate();
		qUpdate2.close();

		StringBuffer sqlUpdate3 = new StringBuffer();
		sqlUpdate3.append("delete from tuReservaTablero " + " where "
				+ " oid_tablero_cab=? ");
		PreparedStatement qUpdate3 = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate3.toString());
		qUpdate3.setInt(OID_TABLERO_CAB, pers.getOID());
		qUpdate3.executeUpdate();
		qUpdate3.close();

	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {
		final int OID_TABLERO_CAB = 1;
		TableroTurnos pers = (TableroTurnos) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update tuTableroCab " + " set activo=1 " + " where "
				+ " oid_tablero_cab=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_TABLERO_CAB, pers.getOID());
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
		case SELECT_BY_FECHA_COMPORTAMIENTO: {
			ps = this.selectByFechaComportamiento(aCondiciones);
			break;
		}
		case DELETE_TABLERO: {
			this.deleteTablero(aCondiciones);
			break;
		}
		case SELECT_BY_FECHA_DESDE_HASTA_COMPO: {
			ps = this.selectByFechaDesdeHastaComportamiento(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones)
			throws BaseException, SQLException {

		final int OID_TABLERO_CAB = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  tuTableroCab ");
		textSQL.append(" WHERE oid_tablero_cab = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_TABLERO_CAB, oid);
		return querySelect;
	}

	private PreparedStatement selectByFechaComportamiento(Object aCondiciones)
			throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  tuTableroCab ");
		textSQL.append(" WHERE fecha = ? and comportamiento = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		java.util.Date fecha = (java.util.Date) condiciones.get("FECHA");
		String comportamiento = (String) condiciones.get("COMPORTAMIENTO");
		querySelect.setDate(1, new java.sql.Date(fecha.getTime()));
		querySelect.setString(2, comportamiento);
		return querySelect;
	}


	private PreparedStatement selectByFechaDesdeHastaComportamiento(
			Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  tuTableroCab ");
		textSQL
				.append(" WHERE fecha >= ? and fecha <= ? and comportamiento = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		java.util.Date fechaDesde = (java.util.Date) condiciones
				.get("FECHA_DESDE");
		java.util.Date fechaHasta = (java.util.Date) condiciones
				.get("FECHA_HASTA");
		String comportamiento = (String) condiciones.get("COMPORTAMIENTO");
		querySelect.setDate(1, new java.sql.Date(fechaDesde.getTime()));
		querySelect.setDate(2, new java.sql.Date(fechaHasta.getTime()));
		querySelect.setString(3, comportamiento);
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones)
			throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  tuTableroCab ");
		textSQL.append(" WHERE  = ? ");
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
				.append("SELECT oid_tablero_cab oid, codigo, descripcion descripcion ,activo ");
		textSQL.append(" from tuTableroCab");

		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static TableroTurnos getTablero(java.util.Date fecha,
			String comportamiento, ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put("FECHA", fecha);
		condiciones.put("COMPORTAMIENTO", comportamiento);

		return (TableroTurnos) ObjetoLogico.getObjects(TableroTurnos.NICKNAME,
				DBTableroTurnos.SELECT_BY_FECHA_COMPORTAMIENTO, condiciones,
				new ObjetoObservado(), aSesion);
	}

	public static List getTableros(java.util.Date fechaDesde,
			java.util.Date fechaHasta, String comportamiento, ISesion aSesion)
			throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put("FECHA_DESDE", fechaDesde);
		condiciones.put("FECHA_HASTA", fechaHasta);
		condiciones.put("COMPORTAMIENTO", comportamiento);

		return (List) ObjetoLogico.getObjects(TableroTurnos.NICKNAME,
				DBTableroTurnos.SELECT_BY_FECHA_DESDE_HASTA_COMPO, condiciones,
				new ListObserver(), aSesion);
	}

	public static void borrarTablero(TableroTurnos tablero, ISesion aSesion)
			throws BaseException {
		ObjetoLogico.getObjects(TableroTurnos.NICKNAME,
				DBTableroTurnos.DELETE_TABLERO, tablero, new ObjetoObservado(),
				aSesion);
	}

}
