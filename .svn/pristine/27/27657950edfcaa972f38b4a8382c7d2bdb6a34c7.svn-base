package com.srn.erp.legales.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.srn.erp.legales.bm.TipoPericia;

import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class DBTipoPericia extends DBObjetoPersistente {

	public static final String OID_TIPO_PERICIA = "oid_tipo_pericia";
	public static final String DESCRIPCION = "descripcion";
	public static final String ACTIVO = "activo";

	public DBTipoPericia() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_TIPO_PERICIA = 1;
		final int DESCRIPCION = 2;
		final int ACTIVO = 3;

		TipoPericia pers = (TipoPericia) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into legTipoPericia " + " ( " + "OID_TIPO_PERICIA," + "DESCRIPCION," + "ACTIVO)" + " values " + "(" + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_TIPO_PERICIA, pers.getOID());
		qInsert.setString(DESCRIPCION, pers.getDescripcion());
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int DESCRIPCION = 1;
		final int ACTIVO = 2;
		final int OID_TIPO_PERICIA = 3;

		TipoPericia pers = (TipoPericia) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update legTipoPericia set " + "descripcion=?" + ",activo=?" + " where " + " oid_tipo_pericia=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_TIPO_PERICIA, pers.getOID());
		qUpdate.setString(DESCRIPCION, pers.getDescripcion());
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_TIPO_PERICIA = 1;
		TipoPericia pers = (TipoPericia) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update legTipoPericia " + " set activo=0 " + " where " + " oid_tipo_pericia=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_TIPO_PERICIA, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_TIPO_PERICIA = 1;
		TipoPericia pers = (TipoPericia) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update legTipoPericia " + " set activo=1 " + " where " + " oid_tipo_pericia=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_TIPO_PERICIA, pers.getOID());
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
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_TIPO_PERICIA = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  legTipoPericia ");
		textSQL.append(" WHERE oid_tipo_pericia = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_TIPO_PERICIA, oid);
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  legTipoPericia ");
		textSQL.append(" WHERE descripcion = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_tipo_pericia oid, '' codigo, descripcion descripcion ,activo ");
		textSQL.append(" from legTipoPericia");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

}
