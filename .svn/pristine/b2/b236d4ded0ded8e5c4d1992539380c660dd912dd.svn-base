package com.srn.erp.cip.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.cip.bm.MotivosEquivCIP;
import com.srn.erp.cip.bm.MotivosNovCIP;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBMotivosEquivCIP extends DBObjetoPersistente {

	public static final String OID_MOT_EQUIV = "oid_mot_equiv";
	public static final String OID_MOTIVO = "oid_motivo";
	public static final String CODIGO_EXTERNO = "codigo_externo";
	public static final String ACTIVO = "activo";

	public static final int SELECT_BY_MOTIVO = 100;

	public DBMotivosEquivCIP() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_MOT_EQUIV = 1;
		final int OID_MOTIVO = 2;
		final int CODIGO_EXTERNO = 3;
		final int ACTIVO = 4;

		MotivosEquivCIP pers = (MotivosEquivCIP) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into cipMotivosEquiv " + " ( " + "OID_MOT_EQUIV," + "OID_MOTIVO," + "CODIGO_EXTERNO," + "ACTIVO)"
				+ " values " + "(" + "?," + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_MOT_EQUIV, pers.getOID());
		qInsert.setInt(OID_MOTIVO, pers.getMotivo().getOID());
		qInsert.setString(CODIGO_EXTERNO, pers.getCodigo_externo());
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_MOTIVO = 1;
		final int CODIGO_EXTERNO = 2;
		final int ACTIVO = 3;
		final int OID_MOT_EQUIV = 4;

		MotivosEquivCIP pers = (MotivosEquivCIP) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update cipMotivosEquiv set " + "oid_motivo=?" + ",codigo_externo=?" + ",activo=?" + " where "
				+ " oid_mot_equiv=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_MOT_EQUIV, pers.getOID());
		qUpdate.setInt(OID_MOTIVO, pers.getMotivo().getOID());
		qUpdate.setString(CODIGO_EXTERNO, pers.getCodigo_externo());
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_MOT_EQUIV = 1;
		MotivosEquivCIP pers = (MotivosEquivCIP) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cipMotivosEquiv " + " set activo=0 " + " where " + " oid_mot_equiv=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_MOT_EQUIV, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_MOT_EQUIV = 1;
		MotivosEquivCIP pers = (MotivosEquivCIP) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cipMotivosEquiv " + " set activo=1 " + " where " + " oid_mot_equiv=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_MOT_EQUIV, pers.getOID());
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
		case SELECT_BY_MOTIVO: {
			ps = this.selectByMotivo(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_MOT_EQUIV = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cipMotivosEquiv ");
		textSQL.append(" WHERE oid_mot_equiv = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_MOT_EQUIV, oid);
		return querySelect;
	}

	private PreparedStatement selectByMotivo(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cipMotivosEquiv ");
		textSQL.append(" WHERE oid_motivo = ? and activo=1 ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		MotivosNovCIP motivo = (MotivosNovCIP) aCondiciones;
		querySelect.setInt(1, motivo.getOID());
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cipMotivosEquiv ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_mot_equiv oid, codigo,  descripcion ,activo ");
		textSQL.append(" from cipMotivosEquiv");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static List getEquivMotivos(MotivosNovCIP motivo, ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(MotivosEquivCIP.NICKNAME, DBMotivosEquivCIP.SELECT_BY_MOTIVO, motivo, new ListObserver(),
				aSesion);
	}

}
