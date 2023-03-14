package com.srn.erp.legales.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.general.bm.PeriodoInc;
import com.srn.erp.general.bm.PeriodoIncDet;
import com.srn.erp.general.da.DBPeriodoIncDet;
import com.srn.erp.legales.bm.Juicio;
import com.srn.erp.legales.bm.RubroCondenaJuicio;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBRubroCondenaJuicio extends DBObjetoPersistente {

	public static final String OID_RUB_COND_JUI = "oid_rub_cond_jui";
	public static final String OID_RUBRO_CONDENA = "oid_rubro_condena";
	public static final String OID_JUICIO = "oid_juicio";
	public static final String ACTIVO = "activo";

	public static final int SELECT_BY_JUICIO = 100;

	public DBRubroCondenaJuicio() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_RUB_COND_JUI = 1;
		final int OID_RUBRO_CONDENA = 2;
		final int OID_JUICIO = 3;
		final int ACTIVO = 4;

		RubroCondenaJuicio pers = (RubroCondenaJuicio) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into legRubConJui " + " ( " + "OID_RUB_COND_JUI," + "OID_RUBRO_CONDENA," + "OID_JUICIO," + "ACTIVO)" + " values " + "(" + "?," + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_RUB_COND_JUI, pers.getOID());
		qInsert.setInt(OID_RUBRO_CONDENA, pers.getRubro_condena().getOID());
		qInsert.setInt(OID_JUICIO, pers.getJuicio().getOID());
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_RUBRO_CONDENA = 1;
		final int OID_JUICIO = 2;
		final int ACTIVO = 3;
		final int OID_RUB_COND_JUI = 4;

		RubroCondenaJuicio pers = (RubroCondenaJuicio) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update legRubConJui set " + "oid_rubro_condena=?" + ",oid_juicio=?" + ",activo=?" + " where " + " oid_rub_cond_jui=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_RUB_COND_JUI, pers.getOID());
		qUpdate.setInt(OID_RUBRO_CONDENA, pers.getRubro_condena().getOID());
		qUpdate.setInt(OID_JUICIO, pers.getJuicio().getOID());
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_RUB_COND_JUI = 1;
		RubroCondenaJuicio pers = (RubroCondenaJuicio) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update legRubConJui " + " set activo=0 " + " where " + " oid_rub_cond_jui=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_RUB_COND_JUI, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_RUB_COND_JUI = 1;
		RubroCondenaJuicio pers = (RubroCondenaJuicio) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update legRubConJui " + " set activo=1 " + " where " + " oid_rub_cond_jui=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_RUB_COND_JUI, pers.getOID());
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

		final int OID_RUB_COND_JUI = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  legRubConJui ");
		textSQL.append(" WHERE oid_rub_cond_jui = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_RUB_COND_JUI, oid);
		return querySelect;
	}

	private PreparedStatement selectByJuicio(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  legRubConJui ");
		textSQL.append(" WHERE oid_juicio = ? and activo = 1 ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		Juicio juicio = (Juicio) aCondiciones;
		querySelect.setInt(1, juicio.getOID());
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  legRubConJui ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_rub_cond_jui oid, codigo,  descripcion ,activo ");
		textSQL.append(" from legRubConJui");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}
	
	  public static List getRubrosCondenaJuicio(Juicio juicio,
              ISesion aSesion) throws BaseException {
		  return (List) ObjetoLogico.getObjects(RubroCondenaJuicio.NICKNAME,
                 DBRubroCondenaJuicio.SELECT_BY_JUICIO,
                 juicio,
                 new ListObserver(),
                 aSesion);
	  }	

}
