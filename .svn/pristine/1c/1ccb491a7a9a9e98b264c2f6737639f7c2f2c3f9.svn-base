package com.srn.erp.legales.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.legales.bm.Juicio;
import com.srn.erp.legales.bm.JuicioRubroCondena;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBJuicioRubroCondena extends DBObjetoPersistente {

	public static final String OID_JUI_RUB_COND = "oid_jui_rub_cond";
	public static final String OID_JUICIO = "oid_juicio";
	public static final String OID_RUBRO_CONDENA = "oid_rubro_condena";
	public static final String ACTIVO = "activo";

	public static final int SELECT_BY_JUICIO = 100;

	public DBJuicioRubroCondena() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_JUI_RUB_COND = 1;
		final int OID_JUICIO = 2;
		final int OID_RUBRO_CONDENA = 3;
		final int ACTIVO = 4;

		JuicioRubroCondena pers = (JuicioRubroCondena) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into legJuiRubroCond " + " ( " + "OID_JUI_RUB_COND," + "OID_JUICIO," + "OID_RUBRO_CONDENA," + "ACTIVO)" + " values " + "(" + "?," + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_JUI_RUB_COND, pers.getOID());
		qInsert.setInt(OID_JUICIO, pers.getJuicio().getOID());
		qInsert.setInt(OID_RUBRO_CONDENA, pers.getRubro_condena().getOID());
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_JUICIO = 1;
		final int OID_RUBRO_CONDENA = 2;
		final int ACTIVO = 3;
		final int OID_JUI_RUB_COND = 4;

		JuicioRubroCondena pers = (JuicioRubroCondena) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update legJuiRubroCond set " + "oid_juicio=?" + ",oid_rubro_condena=?" + ",activo=?" + " where " + " oid_jui_rub_cond=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_JUI_RUB_COND, pers.getOID());
		qUpdate.setInt(OID_JUICIO, pers.getJuicio().getOID());
		qUpdate.setInt(OID_RUBRO_CONDENA, pers.getRubro_condena().getOID());
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_JUI_RUB_COND = 1;
		JuicioRubroCondena pers = (JuicioRubroCondena) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update legJuiRubroCond " + " set activo=0 " + " where " + " oid_jui_rub_cond=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_JUI_RUB_COND, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_JUI_RUB_COND = 1;
		JuicioRubroCondena pers = (JuicioRubroCondena) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update legJuiRubroCond " + " set activo=1 " + " where " + " oid_jui_rub_cond=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_JUI_RUB_COND, pers.getOID());
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

		final int OID_JUI_RUB_COND = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  legJuiRubroCond ");
		textSQL.append(" WHERE oid_jui_rub_cond = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_JUI_RUB_COND, oid);
		return querySelect;
	}

	private PreparedStatement selectByJuicio(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  legJuiRubroCond ");
		textSQL.append(" WHERE oid_juicio  = ? and activo = 1 ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		Juicio juicio = (Juicio) aCondiciones;
		querySelect.setInt(1, juicio.getOID());
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  legJuiRubroCond ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_jui_rub_cond oid, codigo,  descripcion ,activo ");
		textSQL.append(" from legJuiRubroCond");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static List getJuiciosRubroCondena(Juicio juicio, ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(JuicioRubroCondena.NICKNAME, DBJuicioRubroCondena.SELECT_BY_JUICIO, juicio, new ListObserver(), aSesion);
	}

}
