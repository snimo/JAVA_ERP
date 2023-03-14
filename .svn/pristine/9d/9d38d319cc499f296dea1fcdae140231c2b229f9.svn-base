package com.srn.erp.general.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.general.bm.DefinicionAtributoEntidad;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBDefinicionAtributoEntidad extends DBObjetoPersistente {

	public static final String OID_ATRI_ENT = "oid_atri_ent";

	public static final String ENTIDAD = "entidad";

	public static final String NOMBRE_LOGICO = "nombre_logico";

	public static final String SIGNATURE = "signature";

	public static final String ACTIVO = "activo";
	
	public static final String NOMBRE_NICKNAME = "nickname";

	public static final int SELECT_BY_ENTIDAD = 100;

	public DBDefinicionAtributoEntidad() {
	}

	protected void insert(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {

		final int OID_ATRI_ENT = 1;
		final int ENTIDAD = 2;
		final int NOMBRE_LOGICO = 3;
		final int SIGNATURE = 4;
		final int ACTIVO = 5;
		final int NOMBRE_NICKNAME = 6;

		DefinicionAtributoEntidad pers = (DefinicionAtributoEntidad) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into geAtriEnt " + " ( " + "OID_ATRI_ENT,"
				+ "ENTIDAD," + "NOMBRE_LOGICO," + "SIGNATURE," + "ACTIVO,NICKNAME)"
				+ " values " + "(" + "?," + "?," + "?," + "?," + "?,?) ");

		PreparedStatement qInsert = getSesion().getConexionBD()
				.prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_ATRI_ENT, pers.getOID());
		qInsert.setString(ENTIDAD, pers.getEntidad());
		qInsert.setString(NOMBRE_LOGICO, pers.getNombre_logico());
		qInsert.setString(SIGNATURE, pers.getSignature());
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qInsert.setString(NOMBRE_NICKNAME,pers.getNombeNickName());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {

		final int ENTIDAD = 1;
		final int NOMBRE_LOGICO = 2;
		final int SIGNATURE = 3;
		final int ACTIVO = 4;
		final int NOMBRE_NICKNAME = 5;
		final int OID_ATRI_ENT = 6;

		DefinicionAtributoEntidad pers = (DefinicionAtributoEntidad) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update geAtriEnt set " + "entidad=?"
				+ ",nombre_logico=?" + ",signature=?" + ",activo=?" +",nickname=?"+ " where "
				+ " oid_atri_ent=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_ATRI_ENT, pers.getOID());
		qUpdate.setString(ENTIDAD, pers.getEntidad());
		qUpdate.setString(NOMBRE_LOGICO, pers.getNombre_logico());
		qUpdate.setString(SIGNATURE, pers.getSignature());
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qUpdate.setString(NOMBRE_NICKNAME,pers.getNombeNickName());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {
		final int OID_ATRI_ENT = 1;
		DefinicionAtributoEntidad pers = (DefinicionAtributoEntidad) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("delete from geAtriEnt  where "
				+ " oid_atri_ent=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_ATRI_ENT, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {
		final int OID_ATRI_ENT = 1;
		DefinicionAtributoEntidad pers = (DefinicionAtributoEntidad) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update geAtriEnt " + " set activo=1 " + " where "
				+ " oid_atri_ent=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_ATRI_ENT, pers.getOID());
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
		case SELECT_BY_ENTIDAD: {
			ps = this.selectByEntidad(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones)
			throws BaseException, SQLException {

		final int OID_ATRI_ENT = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  geAtriEnt ");
		textSQL.append(" WHERE oid_atri_ent = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_ATRI_ENT, oid);
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones)
			throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  geAtriEnt ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectByEntidad(Object aCondiciones)
			throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  geAtriEnt ");
		textSQL.append(" WHERE entidad = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		String entidad = (String) aCondiciones;
		querySelect.setString(1, entidad);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones)
			throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL
				.append("SELECT oid_atri_ent oid, codigo,  descripcion ,activo ");
		textSQL.append(" from geAtriEnt");

		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static List getAtributosByEntidad(String entidad, ISesion aSesion)
			throws BaseException {
		return (List) ObjetoLogico.getObjects(
				DefinicionAtributoEntidad.NICKNAME,
				DBDefinicionAtributoEntidad.SELECT_BY_ENTIDAD, entidad,
				new ListObserver(), aSesion);
	}

}
