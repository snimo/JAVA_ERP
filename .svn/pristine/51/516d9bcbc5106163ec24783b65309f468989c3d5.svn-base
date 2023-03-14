package com.srn.erp.legales.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.legales.bm.RubroReclamoSeclo;
import com.srn.erp.legales.bm.Seclo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBRubroReclamoSeclo extends DBObjetoPersistente {

	public static final String OID_RUB_REC_SECLO = "oid_rub_rec_seclo";
	public static final String OID_RUBRO_CONDENA = "oid_rubro_condena";
	public static final String OID_SECLO = "oid_seclo";
	public static final String ACTIVO = "activo";

	public static final int SELECT_BY_SECLO = 100;

	public DBRubroReclamoSeclo() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_RUB_REC_SECLO = 1;
		final int OID_RUBRO_CONDENA = 2;
		final int OID_SECLO = 3;
		final int ACTIVO = 4;

		RubroReclamoSeclo pers = (RubroReclamoSeclo) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into legRubRecSeclo " + " ( " + "OID_RUB_REC_SECLO," + "OID_RUBRO_CONDENA," + "OID_SECLO," + "ACTIVO)" + " values " + "(" + "?," + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_RUB_REC_SECLO, pers.getOID());
		qInsert.setInt(OID_RUBRO_CONDENA, pers.getRubro_condena().getOID());
		qInsert.setInt(OID_SECLO, pers.getSeclo().getOID());
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_RUBRO_CONDENA = 1;
		final int OID_SECLO = 2;
		final int ACTIVO = 3;
		final int OID_RUB_REC_SECLO = 4;

		RubroReclamoSeclo pers = (RubroReclamoSeclo) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update legRubRecSeclo set " + "oid_rubro_condena=?" + ",oid_seclo=?" + ",activo=?" + " where " + " oid_rub_rec_seclo=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_RUB_REC_SECLO, pers.getOID());
		qUpdate.setInt(OID_RUBRO_CONDENA, pers.getRubro_condena().getOID());
		qUpdate.setInt(OID_SECLO, pers.getSeclo().getOID());
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_RUB_REC_SECLO = 1;
		RubroReclamoSeclo pers = (RubroReclamoSeclo) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update legRubRecSeclo " + " set activo=0 " + " where " + " oid_rub_rec_seclo=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_RUB_REC_SECLO, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_RUB_REC_SECLO = 1;
		RubroReclamoSeclo pers = (RubroReclamoSeclo) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update legRubRecSeclo " + " set activo=1 " + " where " + " oid_rub_rec_seclo=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_RUB_REC_SECLO, pers.getOID());
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
		case SELECT_BY_SECLO: {
			ps = this.selectBySeclo(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_RUB_REC_SECLO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  legRubRecSeclo ");
		textSQL.append(" WHERE oid_rub_rec_seclo = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_RUB_REC_SECLO, oid);
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  legRubRecSeclo ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectBySeclo(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  legRubRecSeclo ");
		textSQL.append(" WHERE oid_seclo = ? and activo = 1 ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		Seclo seclo = (Seclo) aCondiciones;
		querySelect.setInt(1, seclo.getOID());
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_rub_rec_seclo oid, codigo,  descripcion ,activo ");
		textSQL.append(" from legRubRecSeclo");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static List getRubrosReclaSeclos(Seclo aSeclo, ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(RubroReclamoSeclo.NICKNAME, DBRubroReclamoSeclo.SELECT_BY_SECLO, aSeclo, new ListObserver(), aSesion);
	}

}
