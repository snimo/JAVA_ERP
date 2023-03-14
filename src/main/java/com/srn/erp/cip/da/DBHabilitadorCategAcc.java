package com.srn.erp.cip.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.cip.bm.CategAccesoCIP;
import com.srn.erp.cip.bm.HabilitadorCategAcc;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.applicarionServer.bm.Seguridad.PerfilFuncional;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBHabilitadorCategAcc extends DBObjetoPersistente {

	public static final String OID_HAB_CATEG_USU = "oid_hab_categ_usu";
	public static final String OID_PERFIL_FUNC = "oid_perfil_func";
	public static final String OID_CATEG_ACCESO = "oid_categ_acceso";
	public static final String ACTIVO = "activo";

	public static final int SELECT_BY_CATEG_ACCESO_ACTIVO = 100;
	public static final int SELECT_BY_PERFIL_CATEGORIA = 101;

	public DBHabilitadorCategAcc() {
	}

	protected void insert(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {

		final int OID_HAB_CATEG_USU = 1;
		final int OID_PERFIL_FUNC = 2;
		final int OID_CATEG_ACCESO = 3;
		final int ACTIVO = 4;

		HabilitadorCategAcc pers = (HabilitadorCategAcc) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into cipHabAccInternos " + " ( "
				+ "OID_HAB_CATEG_USU," + "OID_PERFIL_FUNC,"
				+ "OID_CATEG_ACCESO," + "ACTIVO)" + " values " + "(" + "?,"
				+ "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD()
				.prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_HAB_CATEG_USU, pers.getOID());
		qInsert.setInt(OID_PERFIL_FUNC, pers.getPerfil_funcional().getOID());
		qInsert.setInt(OID_CATEG_ACCESO, pers.getCategoria_acceso().getOID());
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {

		final int OID_PERFIL_FUNC = 1;
		final int OID_CATEG_ACCESO = 2;
		final int ACTIVO = 3;
		final int OID_HAB_CATEG_USU = 4;

		HabilitadorCategAcc pers = (HabilitadorCategAcc) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update cipHabAccInternos set " + "oid_perfil_func=?"
				+ ",oid_categ_acceso=?" + ",activo=?" + " where "
				+ " oid_hab_categ_usu=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_HAB_CATEG_USU, pers.getOID());
		qUpdate.setInt(OID_PERFIL_FUNC, pers.getPerfil_funcional().getOID());
		qUpdate.setInt(OID_CATEG_ACCESO, pers.getCategoria_acceso().getOID());
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {
		final int OID_HAB_CATEG_USU = 1;
		HabilitadorCategAcc pers = (HabilitadorCategAcc) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cipHabAccInternos " + " set activo=0 "
				+ " where " + " oid_hab_categ_usu=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_HAB_CATEG_USU, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {
		final int OID_HAB_CATEG_USU = 1;
		HabilitadorCategAcc pers = (HabilitadorCategAcc) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cipHabAccInternos " + " set activo=1 "
				+ " where " + " oid_hab_categ_usu=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_HAB_CATEG_USU, pers.getOID());
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
		case SELECT_BY_CATEG_ACCESO_ACTIVO: {
			ps = this.selectByCategAccesoActivo(aCondiciones);
			break;
		}
		case SELECT_BY_PERFIL_CATEGORIA: {
			ps = this.selectByPerfilCategoria(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones)
			throws BaseException, SQLException {

		final int OID_HAB_CATEG_USU = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cipHabAccInternos ");
		textSQL.append(" WHERE oid_hab_categ_usu = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_HAB_CATEG_USU, oid);
		return querySelect;
	}

	private PreparedStatement selectByCategAccesoActivo(Object aCondiciones)
			throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cipHabAccInternos ");
		textSQL.append(" WHERE oid_categ_acceso = ? and activo = 1 ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		CategAccesoCIP categoria = (CategAccesoCIP) aCondiciones;
		querySelect.setInt(1, categoria.getOID());
		return querySelect;
	}

	private PreparedStatement selectByPerfilCategoria(Object aCondiciones)
			throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cipHabAccInternos ");
		textSQL
				.append(" WHERE oid_categ_acceso  = ? and oid_perfil_func = ? and activo = 1 ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		CategAccesoCIP categoria = (CategAccesoCIP) condiciones
				.get(CategAccesoCIP.NICKNAME);
		PerfilFuncional perfil = (PerfilFuncional) condiciones
				.get(PerfilFuncional.NICKNAME);
		querySelect.setInt(1, categoria.getOID());
		querySelect.setInt(2, perfil.getOID());
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones)
			throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cipHabAccInternos ");
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
				.append("SELECT oid_hab_categ_usu oid, codigo,  descripcion ,activo ");
		textSQL.append(" from cipHabAccInternos");

		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static List getHabilitadoresCategAccesoInt(CategAccesoCIP categoria,
			ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(HabilitadorCategAcc.NICKNAME,
				DBHabilitadorCategAcc.SELECT_BY_CATEG_ACCESO_ACTIVO, categoria,
				new ListObserver(), aSesion);
	}

	public static HabilitadorCategAcc getHabilitadorCategAcc(
			CategAccesoCIP categoria, PerfilFuncional perfil, ISesion aSesion)
			throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(CategAccesoCIP.NICKNAME, categoria);
		condiciones.put(PerfilFuncional.NICKNAME, perfil);
		return (HabilitadorCategAcc) ObjetoLogico.getObjects(
				HabilitadorCategAcc.NICKNAME,
				DBHabilitadorCategAcc.SELECT_BY_PERFIL_CATEGORIA, condiciones,
				new ObjetoObservado(), aSesion);
	}

}
