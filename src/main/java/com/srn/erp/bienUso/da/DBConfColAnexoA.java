package com.srn.erp.bienUso.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.bienUso.bm.ConfColAnexoA;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBConfColAnexoA extends DBObjetoPersistente {

	public static final String OID_CONF_ANEXO_A = "oid_conf_anexo_a";

	public static final String CODIGO = "codigo";

	public static final String DESCRIPCION = "descripcion";

	public static final String NRO_COL = "nro_col";

	public static final String TIPO_EJERCICIO = "tipo_ejercicio";

	public static final String ACTIVO = "activo";

	public DBConfColAnexoA() {
	}

	protected void insert(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {

		final int OID_CONF_ANEXO_A = 1;
		final int CODIGO = 2;
		final int DESCRIPCION = 3;
		final int NRO_COL = 4;
		final int TIPO_EJERCICIO = 5;
		final int ACTIVO = 6;

		ConfColAnexoA pers = (ConfColAnexoA) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into buConfAnexoA " + " ( "
				+ "OID_CONF_ANEXO_A," + "CODIGO," + "DESCRIPCION," + "NRO_COL,"
				+ "TIPO_EJERCICIO," + "ACTIVO)" + " values " + "(" + "?,"
				+ "?," + "?," + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD()
				.prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_CONF_ANEXO_A, pers.getOID());
		qInsert.setString(CODIGO, pers.getCodigo());
		qInsert.setString(DESCRIPCION, pers.getDescripcion());
		qInsert.setInt(NRO_COL, pers.getNro_col().intValue());
		qInsert.setString(TIPO_EJERCICIO, pers.getTipo_ejercicio());
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {

		final int CODIGO = 1;
		final int DESCRIPCION = 2;
		final int NRO_COL = 3;
		final int TIPO_EJERCICIO = 4;
		final int ACTIVO = 5;
		final int OID_CONF_ANEXO_A = 6;

		ConfColAnexoA pers = (ConfColAnexoA) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update buConfAnexoA set " + "codigo=?"
				+ ",descripcion=?" + ",nro_col=?" + ",tipo_ejercicio=?"
				+ ",activo=?" + " where " + " oid_conf_anexo_a=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_CONF_ANEXO_A, pers.getOID());
		qUpdate.setString(CODIGO, pers.getCodigo());
		qUpdate.setString(DESCRIPCION, pers.getDescripcion());
		qUpdate.setInt(NRO_COL, pers.getNro_col().intValue());
		qUpdate.setString(TIPO_EJERCICIO, pers.getTipo_ejercicio());
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {
		final int OID_CONF_ANEXO_A = 1;
		ConfColAnexoA pers = (ConfColAnexoA) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update buConfAnexoA " + " set activo=0 " + " where "
				+ " oid_conf_anexo_a=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_CONF_ANEXO_A, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {
		final int OID_CONF_ANEXO_A = 1;
		ConfColAnexoA pers = (ConfColAnexoA) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update buConfAnexoA " + " set activo=1 " + " where "
				+ " oid_conf_anexo_a=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_CONF_ANEXO_A, pers.getOID());
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

		}
		return ps;
	}

	private PreparedStatement selectAll(Object aCondiciones)
			throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  buConfAnexoA ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		return querySelect;
	}

	private PreparedStatement selectByOID(Object aCondiciones)
			throws BaseException, SQLException {

		final int OID_CONF_ANEXO_A = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  buConfAnexoA ");
		textSQL.append(" WHERE oid_conf_anexo_a = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_CONF_ANEXO_A, oid);
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones)
			throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  buConfAnexoA ");
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
				.append("SELECT oid_conf_anexo_a oid,codigo codigo, descripcion descripcion ,activo ");
		textSQL.append(" from buConfAnexoA");

		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		return querySelect;
	}
	
	public static List getConfColAnexoA(ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(ConfColAnexoA.NICKNAME,
        DBConfColAnexoAMov.SELECT_ALL,
        		null,
        		new ListObserver(),
        		aSesion);
	}	

}
