package com.srn.erp.mensajero.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.srn.erp.mensajero.bm.GrupoUsuMens;

import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class DBGrupoUsuMens extends DBObjetoPersistente {

	public static final String OID_GRUPO_DEST_CAB = "oid_grupo_dest_cab";
	public static final String NOMBRE = "nombre";
	public static final String SCOPE = "scope";
	public static final String OID_USU_PRIV = "oid_usu_priv";
	public static final String ACTIVA = "activo";

	public DBGrupoUsuMens() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_GRUPO_DEST_CAB = 1;
		final int NOMBRE = 2;
		final int SCOPE = 3;
		final int OID_USU_PRIV = 4;
		final int ACTIVA = 5;

		GrupoUsuMens pers = (GrupoUsuMens) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into meGrupoDestCab " + " ( " + "OID_GRUPO_DEST_CAB," + "NOMBRE," + "SCOPE," + "OID_USU_PRIV,"
				+ "ACTIVO)" + " values " + "(" + "?," + "?," + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_GRUPO_DEST_CAB, pers.getOID());
		qInsert.setString(NOMBRE, pers.getNombre());
		qInsert.setString(SCOPE, pers.getScope());
		if (pers.getUsuario_priveado()!=null)
			qInsert.setInt(OID_USU_PRIV, pers.getUsuario_priveado().getOID());
		else
			qInsert.setNull(OID_USU_PRIV, java.sql.Types.INTEGER);
		qInsert.setBoolean(ACTIVA, pers.isActivo().booleanValue());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int NOMBRE = 1;
		final int SCOPE = 2;
		final int OID_USU_PRIV = 3;
		final int ACTIVA = 4;
		final int OID_GRUPO_DEST_CAB = 5;

		GrupoUsuMens pers = (GrupoUsuMens) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update meGrupoDestCab set " + "nombre=?" + ",scope=?" + ",oid_usu_priv=?" + ",activo=?" + " where "
				+ " oid_grupo_dest_cab=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_GRUPO_DEST_CAB, pers.getOID());
		qUpdate.setString(NOMBRE, pers.getNombre());
		qUpdate.setString(SCOPE, pers.getScope());
		if (pers.getUsuario_priveado()!=null)
			qUpdate.setInt(OID_USU_PRIV, pers.getUsuario_priveado().getOID());
		else
			qUpdate.setNull(OID_USU_PRIV, java.sql.Types.INTEGER);
		qUpdate.setBoolean(ACTIVA, pers.isActivo().booleanValue());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_GRUPO_DEST_CAB = 1;
		GrupoUsuMens pers = (GrupoUsuMens) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update meGrupoDestCab " + " set activo=0 " + " where " + " oid_grupo_dest_cab=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_GRUPO_DEST_CAB, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_GRUPO_DEST_CAB = 1;
		GrupoUsuMens pers = (GrupoUsuMens) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update meGrupoDestCab " + " set activo=1 " + " where " + " oid_grupo_dest_cab=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_GRUPO_DEST_CAB, pers.getOID());
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
		case IDBObjetoPersistente.SELECT_ALL_ACTIVOS_HELP: {
			ps = this.selectAllHelpActivos(aCondiciones);
			break;
		}		
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_GRUPO_DEST_CAB = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  meGrupoDestCab ");
		textSQL.append(" WHERE oid_grupo_dest_cab = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_GRUPO_DEST_CAB, oid);
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  meGrupoDestCab ");
		textSQL.append(" WHERE nombre = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelpActivos(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_grupo_dest_cab oid, nombre codigo,  nombre descripcion ,activo ");
		textSQL.append(" from meGrupoDestCab where activo=1");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}
	
	
	
	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_grupo_dest_cab oid, nombre codigo,  nombre descripcion ,activo ");
		textSQL.append(" from meGrupoDestCab");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

}
