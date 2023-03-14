package com.srn.erp.rrhh.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.general.bm.Periodo;
import com.srn.erp.rrhh.bm.RemplazoAcumLeg;
import com.srn.erp.sueldos.bm.Legajo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBRemplazoAcumLeg extends DBObjetoPersistente {

	public static final String OID_REM_TRA_LEG = "oid_rem_tra_leg";
	public static final String OID_LEGAJO = "oid_legajo";
	public static final String PERIODO = "periodo";
	public static final String HORAS_ACUM = "horas_acum";
	public static final String OBSERVACION = "observacion";
	public static final String ACTIVO = "activo";

	public static final int SELECT_BY_LEGAJO_PERI_ACTIVO = 100;
	public static final int SELECT_BY_PERIODO = 101;
	public static final int SELECT_BY_PERIODOS = 102;

	public DBRemplazoAcumLeg() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_REM_TRA_LEG = 1;
		final int OID_LEGAJO = 2;
		final int PERIODO = 3;
		final int HORAS_ACUM = 4;
		final int OBSERVACION = 5;
		final int ACTIVO = 6;

		RemplazoAcumLeg pers = (RemplazoAcumLeg) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into rhRempTransLeg " + " ( " + "OID_REM_TRA_LEG," + "OID_LEGAJO," + "PERIODO," + "HORAS_ACUM," + "OBSERVACION," + "ACTIVO)" + " values " + "(" + "?," + "?," + "?,"
				+ "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_REM_TRA_LEG, pers.getOID());
		if (pers.getLegajo() != null)
			qInsert.setInt(OID_LEGAJO, pers.getLegajo().getOID());
		else
			qInsert.setNull(OID_LEGAJO, Types.INTEGER);
		if (pers.getPeriodo() != null)
			qInsert.setString(PERIODO, pers.getPeriodo());
		else
			qInsert.setNull(PERIODO, Types.VARCHAR);
		if (pers.getHoras_acum() != null)
			qInsert.setInt(HORAS_ACUM, pers.getHoras_acum().intValue());
		else
			qInsert.setInt(HORAS_ACUM, 0);
		if (pers.getObservacion() != null)
			qInsert.setString(OBSERVACION, pers.getObservacion());
		else
			qInsert.setNull(OBSERVACION, Types.VARCHAR);
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_LEGAJO = 1;
		final int PERIODO = 2;
		final int HORAS_ACUM = 3;
		final int OBSERVACION = 4;
		final int ACTIVO = 5;
		final int OID_REM_TRA_LEG = 6;

		RemplazoAcumLeg pers = (RemplazoAcumLeg) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update rhRempTransLeg set " + "oid_legajo=?" + ",periodo=?" + ",horas_acum=?" + ",observacion=?" + ",activo=?" + " where " + " oid_rem_tra_leg=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_REM_TRA_LEG, pers.getOID());
		if (pers.getLegajo() != null)
			qUpdate.setInt(OID_LEGAJO, pers.getLegajo().getOID());
		else
			qUpdate.setNull(OID_LEGAJO, Types.INTEGER);
		if (pers.getPeriodo() != null)
			qUpdate.setString(PERIODO, pers.getPeriodo());
		else
			qUpdate.setNull(PERIODO, Types.VARCHAR);
		if (pers.getHoras_acum() != null)
			qUpdate.setInt(HORAS_ACUM, pers.getHoras_acum().intValue());
		else
			qUpdate.setInt(HORAS_ACUM, 0);
		if (pers.getObservacion() != null)
			qUpdate.setString(OBSERVACION, pers.getObservacion());
		else
			qUpdate.setNull(OBSERVACION, Types.VARCHAR);
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_REM_TRA_LEG = 1;
		RemplazoAcumLeg pers = (RemplazoAcumLeg) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update rhRempTransLeg " + " set activo=0 " + " where " + " oid_rem_tra_leg=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_REM_TRA_LEG, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_REM_TRA_LEG = 1;
		RemplazoAcumLeg pers = (RemplazoAcumLeg) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update rhRempTransLeg " + " set activo=1 " + " where " + " oid_rem_tra_leg=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_REM_TRA_LEG, pers.getOID());
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
		case SELECT_BY_LEGAJO_PERI_ACTIVO: {
			ps = this.selectByLegajoPeriActivo(aCondiciones);
			break;
		}
		case SELECT_BY_PERIODO: {
			ps = this.selectByPeriodo(aCondiciones);
			break;
		}
		case SELECT_BY_PERIODOS: {
			ps = this.selectByPeriodos(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_REM_TRA_LEG = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  rhRempTransLeg ");
		textSQL.append(" WHERE oid_rem_tra_leg = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_REM_TRA_LEG, oid);
		return querySelect;
	}

	private PreparedStatement selectByLegajoPeriActivo(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  rhRempTransLeg ");
		textSQL.append(" WHERE oid_legajo = ? and periodo = ? and activo = 1");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		Legajo legajo = (Legajo) condiciones.get(Legajo.NICKNAME);
		String periodo = (String) condiciones.get("PERIODO");
		querySelect.setInt(1, legajo.getOID());
		querySelect.setString(2, periodo);
		return querySelect;
	}

	private PreparedStatement selectByPeriodos(Object aCondiciones) throws BaseException, SQLException {
		List periodos = (List) aCondiciones;
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  rhRempTransLeg ");
		textSQL.append(" WHERE activo = 1 and periodo in ('-1'");

		Iterator iterPeriodos = periodos.iterator();
		while (iterPeriodos.hasNext()) {
			Periodo periodo = (Periodo) iterPeriodos.next();
			textSQL.append(",'"+periodo.getCodigo()+"'"); 
		}
		textSQL.append(" )");	
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	private PreparedStatement selectByPeriodo(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  rhRempTransLeg ");
		textSQL.append(" WHERE periodo = ? and activo=1 ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String periodo = (String) aCondiciones;
		querySelect.setString(1, periodo);
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  rhRempTransLeg ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_rem_tra_leg oid, codigo,  descripcion ,activo ");
		textSQL.append(" from rhRempTransLeg");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static int eliminarRemplazosPeriodo(String periodo, ISesion aSesion) throws BaseException {

		try {
			StringBuffer textSQL = new StringBuffer();

			textSQL.append("update rhRempTransLeg set activo = 0 where periodo = ? and activo = 1 ");
			PreparedStatement querySelect = aSesion.getConexionBD().prepareStatement(textSQL.toString());
			querySelect.setString(1, periodo);
			return querySelect.executeUpdate();
		} catch (Exception e) {
			throw new BaseException(null, e.getMessage());
		}
	}

	public static RemplazoAcumLeg getRemplazoAcumLeg(Legajo legajo, String periodo, ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(Legajo.NICKNAME, legajo);
		condiciones.put("PERIODO", periodo);
		return (RemplazoAcumLeg) ObjetoLogico.getObjects(RemplazoAcumLeg.NICKNAME, DBRemplazoAcumLeg.SELECT_BY_LEGAJO_PERI_ACTIVO, condiciones, new ObjetoObservado(), aSesion);
	}

	public static List getRemplazosAcumLeg(String periodo, ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(RemplazoAcumLeg.NICKNAME, DBRemplazoAcumLeg.SELECT_BY_PERIODO, periodo, new ListObserver(), aSesion);
	}
	
	public static List getRemplazosAcumEnPeriodos(List periodos, ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(RemplazoAcumLeg.NICKNAME, DBRemplazoAcumLeg.SELECT_BY_PERIODOS, periodos, new ListObserver(), aSesion);
	}	

}
