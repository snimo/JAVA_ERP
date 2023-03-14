package com.srn.erp.legales.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import com.srn.erp.legales.bm.Juicio;
import com.srn.erp.legales.bm.JuicioEmpresa;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBJuicioEmpresa extends DBObjetoPersistente {

	public static final String OID_JUI_EMP = "oid_jui_emp";
	public static final String OID_JUICIO = "oid_juicio";
	public static final String OID_JUICIO_EMPRESA = "oid_emp_jui";
	public static final String ACTIVO = "activo";

	public static final int SELECT_BY_JUICIO = 100;

	public DBJuicioEmpresa() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_JUI_EMP = 1;
		final int OID_JUICIO = 2;
		final int OID_EMP_JUI = 3;
		final int ACTIVO = 4;

		JuicioEmpresa pers = (JuicioEmpresa) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into legJuiEmp " + " ( " + "OID_JUI_EMP," + "OID_JUICIO," + "oid_emp_jui," + "ACTIVO)" + " values " + "(" + "?," + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_JUI_EMP, pers.getOID());
		qInsert.setInt(OID_JUICIO, pers.getJuicio().getOID());
		if (pers.getEmpresaJuicio()!=null)
			qInsert.setInt(OID_EMP_JUI, pers.getEmpresaJuicio().getOID());
		else
			qInsert.setNull(OID_EMP_JUI, Types.INTEGER);
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_JUICIO = 1;
		final int OID_EMP_JUI = 2;
		final int ACTIVO = 3;
		final int OID_JUI_EMP = 4;

		JuicioEmpresa pers = (JuicioEmpresa) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update legJuiEmp set " + "oid_juicio=?" + ",oid_emp_jui=?" + ",activo=?" + " where " + " oid_jui_emp=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_JUI_EMP, pers.getOID());
		qUpdate.setInt(OID_JUICIO, pers.getJuicio().getOID());
		if (pers.getEmpresaJuicio()!=null)
			qUpdate.setInt(OID_EMP_JUI, pers.getEmpresaJuicio().getOID());
		else
			qUpdate.setNull(OID_EMP_JUI, Types.INTEGER);
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_JUI_EMP = 1;
		JuicioEmpresa pers = (JuicioEmpresa) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update legJuiEmp " + " set activo=0 " + " where " + " oid_jui_emp=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_JUI_EMP, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_JUI_EMP = 1;
		JuicioEmpresa pers = (JuicioEmpresa) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update legJuiEmp " + " set activo=1 " + " where " + " oid_jui_emp=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_JUI_EMP, pers.getOID());
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
		case SELECT_BY_JUICIO: {
			ps = this.selectByJuicio(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_JUI_EMP = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  legJuiEmp ");
		textSQL.append(" WHERE oid_jui_emp = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_JUI_EMP, oid);
		return querySelect;
	}

	private PreparedStatement selectByJuicio(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  legJuiEmp ");
		textSQL.append(" WHERE oid_juicio = ? and activo = 1 ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		Juicio juicio = (Juicio) aCondiciones;
		querySelect.setInt(1, juicio.getOID());
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  legJuiEmp ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_jui_emp oid, codigo,  descripcion ,activo ");
		textSQL.append(" from legJuiEmp");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static List getJuiciosEmpresa(Juicio aJuicio, ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(JuicioEmpresa.NICKNAME, DBJuicioEmpresa.SELECT_BY_JUICIO, aJuicio, new ListObserver(), aSesion);
	}

}
