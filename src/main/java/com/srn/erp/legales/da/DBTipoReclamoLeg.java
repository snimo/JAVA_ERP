package com.srn.erp.legales.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.legales.bm.TipoReclamoLeg;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ObjetoObservado;

public class DBTipoReclamoLeg extends DBObjetoPersistente {

	public static final String OID_TIPO_RECLAMO = "oid_tipo_reclamo";
	public static final String DESCRIPCION = "descripcion";
	public static final String ACTIVO = "activo";

	public static final int SELECT_BY_DESCRIPCION = 100;

	public DBTipoReclamoLeg() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_TIPO_RECLAMO = 1;
		final int DESCRIPCION = 2;
		final int ACTIVO = 3;

		TipoReclamoLeg pers = (TipoReclamoLeg) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into legTipoReclamos " + " ( " + "OID_TIPO_RECLAMO," + "DESCRIPCION," + "ACTIVO)" + " values " + "(" + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_TIPO_RECLAMO, pers.getOID());
		qInsert.setString(DESCRIPCION, pers.getDescripcion());
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int DESCRIPCION = 1;
		final int ACTIVO = 2;
		final int OID_TIPO_RECLAMO = 3;

		TipoReclamoLeg pers = (TipoReclamoLeg) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update legTipoReclamos set " + "descripcion=?" + ",activo=?" + " where " + " oid_tipo_reclamo=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_TIPO_RECLAMO, pers.getOID());
		qUpdate.setString(DESCRIPCION, pers.getDescripcion());
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_TIPO_RECLAMO = 1;
		TipoReclamoLeg pers = (TipoReclamoLeg) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update legTipoReclamos " + " set activo=0 " + " where " + " oid_tipo_reclamo=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_TIPO_RECLAMO, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_TIPO_RECLAMO = 1;
		TipoReclamoLeg pers = (TipoReclamoLeg) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update legTipoReclamos " + " set activo=1 " + " where " + " oid_tipo_reclamo=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_TIPO_RECLAMO, pers.getOID());
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
		case SELECT_BY_DESCRIPCION: {
			ps = this.selectByDescripcion(aCondiciones);
			break;
		}
		case SELECT_ALL: {
			ps = this.selectAll(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_TIPO_RECLAMO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  legTipoReclamos ");
		textSQL.append(" WHERE oid_tipo_reclamo = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_TIPO_RECLAMO, oid);
		return querySelect;
	}

	private PreparedStatement selectAll(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  legTipoReclamos ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	private PreparedStatement selectByDescripcion(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  legTipoReclamos ");
		textSQL.append(" WHERE descripcion  = ? and activo = 1 ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(1, codigo);
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  legTipoReclamos ");
		textSQL.append(" WHERE descripcion  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_tipo_reclamo oid, descripcion codigo, descripcion descripcion ,activo ");
		textSQL.append(" from legTipoReclamos");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static TipoReclamoLeg getTipoReclamoLeg(String descripcion, ISesion aSesion) throws BaseException {
		return (TipoReclamoLeg) ObjetoLogico.getObjects(TipoReclamoLeg.NICKNAME, DBTipoReclamoLeg.SELECT_BY_DESCRIPCION, descripcion, new ObjetoObservado(), aSesion);
	}

	public static List getAllTiposReclamos(ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(TipoReclamoLeg.NICKNAME, DBTipoReclamoLeg.SELECT_ALL, null, new ListObserver(), aSesion);
	}

}
