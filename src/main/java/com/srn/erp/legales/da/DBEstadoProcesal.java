package com.srn.erp.legales.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.general.bm.Periodo;
import com.srn.erp.general.da.DBPeriodo;
import com.srn.erp.legales.bm.EstadoProcesal;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ObjetoObservado;

public class DBEstadoProcesal extends DBObjetoPersistente {

	public static final String OID_EST_PROCESAL = "oid_est_procesal";
	public static final String CODIGO = "codigo";
	public static final String DESCRIPCION = "descripcion";
	public static final String ACTIVO = "activo";
	
	public static final int SELECT_BY_DESCRIPCION = 100;

	public DBEstadoProcesal() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_EST_PROCESAL = 1;
		final int CODIGO = 2;
		final int DESCRIPCION = 3;
		final int ACTIVO = 4;

		EstadoProcesal pers = (EstadoProcesal) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into legEstadoProcesal " + " ( " + "OID_EST_PROCESAL," + "CODIGO," + "DESCRIPCION," + "ACTIVO)" + " values " + "(" + "?," + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_EST_PROCESAL, pers.getOID());
		qInsert.setString(CODIGO, pers.getCodigo());
		qInsert.setString(DESCRIPCION, pers.getDescripcion());
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int CODIGO = 1;
		final int DESCRIPCION = 2;
		final int ACTIVO = 3;
		final int OID_EST_PROCESAL = 4;

		EstadoProcesal pers = (EstadoProcesal) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update legEstadoProcesal set " + "codigo=?" + ",descripcion=?" + ",activo=?" + " where " + " oid_est_procesal=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_EST_PROCESAL, pers.getOID());
		qUpdate.setString(CODIGO, pers.getCodigo());
		qUpdate.setString(DESCRIPCION, pers.getDescripcion());
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_EST_PROCESAL = 1;
		EstadoProcesal pers = (EstadoProcesal) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update legEstadoProcesal " + " set activo=0 " + " where " + " oid_est_procesal=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_EST_PROCESAL, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_EST_PROCESAL = 1;
		EstadoProcesal pers = (EstadoProcesal) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update legEstadoProcesal " + " set activo=1 " + " where " + " oid_est_procesal=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_EST_PROCESAL, pers.getOID());
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
		case IDBObjetoPersistente.SELECT_ALL: {
			ps = this.selectAll(aCondiciones);
			break;
		}
		case SELECT_BY_DESCRIPCION: {
			ps = this.selectByDescripcion(aCondiciones);
			break;			
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_EST_PROCESAL = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  legEstadoProcesal ");
		textSQL.append(" WHERE oid_est_procesal = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_EST_PROCESAL, oid);
		return querySelect;
	}

	private PreparedStatement selectAll(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  legEstadoProcesal ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	private PreparedStatement selectByDescripcion(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  legEstadoProcesal ");
		textSQL.append(" WHERE descripcion = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String descripcion = (String) aCondiciones;
		querySelect.setString(1, descripcion);
		return querySelect;
	}	
	
	
	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  legEstadoProcesal ");
		textSQL.append(" WHERE codigo = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_est_procesal oid,codigo codigo, descripcion descripcion ,activo ");
		textSQL.append(" from legEstadoProcesal");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static List getEstadosProcesales(ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(EstadoProcesal.NICKNAME, DBEstadoProcesal.SELECT_ALL, null, new ListObserver(), aSesion);
	}
	
	public static EstadoProcesal getEstadoProcesal(String descripcion,
	          ISesion aSesion)
	          throws BaseException {
		  return (EstadoProcesal) ObjetoLogico.getObjects(EstadoProcesal.NICKNAME,
				  				DBEstadoProcesal.SELECT_BY_DESCRIPCION,
				  				descripcion,
				  				new ObjetoObservado(),
				  				aSesion);
	}	

}
