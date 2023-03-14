package com.srn.erp.excluidos.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.excluidos.bm.IndividuoExcluido;
import com.srn.erp.excluidos.bm.ReferenciaArchivoExcluido;
import com.srn.erp.general.bm.PeriodoInc;
import com.srn.erp.general.bm.PeriodoIncDet;
import com.srn.erp.general.da.DBPeriodoIncDet;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBReferenciaArchivoExcluido extends DBObjetoPersistente {

	public static final String OID_REF_ARCHIVO = "oid_ref_archivo";
	public static final String OID_INDIVIDUO = "oid_individuo";
	public static final String FECHA = "fecha";
	public static final String TITULO = "titulo";
	public static final String ACTIVO = "activo";
	
	public static final int SELECT_BY_INDIVIDUO = 100;

	public DBReferenciaArchivoExcluido() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_REF_ARCHIVO = 1;
		final int OID_INDIVIDUO = 2;
		final int FECHA = 3;
		final int TITULO = 4;
		final int ACTIVO = 5;

		ReferenciaArchivoExcluido pers = (ReferenciaArchivoExcluido) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into excRefArchivos " + " ( " + "OID_REF_ARCHIVO," + "OID_INDIVIDUO," + "FECHA," + "TITULO," + "ACTIVO)"
				+ " values " + "(" + "?," + "?," + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_REF_ARCHIVO, pers.getOID());
		qInsert.setInt(OID_INDIVIDUO, pers.getIndividuo().getOID());
		if (pers.getFecha() != null)
			qInsert.setDate(FECHA, new java.sql.Date(pers.getFecha().getTime()));
		else
			qInsert.setNull(FECHA, java.sql.Types.DATE);
		qInsert.setString(TITULO, pers.getTitulo());
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_INDIVIDUO = 1;
		final int FECHA = 2;
		final int TITULO = 3;
		final int ACTIVO = 4;
		final int OID_REF_ARCHIVO = 5;

		ReferenciaArchivoExcluido pers = (ReferenciaArchivoExcluido) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update excRefArchivos set " + "oid_individuo=?" + ",fecha=?" + ",titulo=?" + ",activo=?" + " where "
				+ " oid_ref_archivo=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_REF_ARCHIVO, pers.getOID());
		qUpdate.setInt(OID_INDIVIDUO, pers.getIndividuo().getOID());
		if (pers.getFecha() != null)
			qUpdate.setDate(FECHA,new java.sql.Date(pers.getFecha().getTime()));
		else
			qUpdate.setNull(FECHA, java.sql.Types.DATE);
		qUpdate.setString(TITULO, pers.getTitulo());
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_REF_ARCHIVO = 1;
		ReferenciaArchivoExcluido pers = (ReferenciaArchivoExcluido) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update excRefArchivos " + " set activo=0 " + " where " + " oid_ref_archivo=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_REF_ARCHIVO, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_REF_ARCHIVO = 1;
		ReferenciaArchivoExcluido pers = (ReferenciaArchivoExcluido) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update excRefArchivos " + " set activo=1 " + " where " + " oid_ref_archivo=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_REF_ARCHIVO, pers.getOID());
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
		case SELECT_BY_INDIVIDUO: {
			ps = this.selectByIndividuo(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_REF_ARCHIVO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  excRefArchivos ");
		textSQL.append(" WHERE oid_ref_archivo = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_REF_ARCHIVO, oid);
		return querySelect;
	}

	private PreparedStatement selectByIndividuo(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  excRefArchivos ");
		textSQL.append(" WHERE oid_individuo = ? and activo=1 ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		IndividuoExcluido individuo = (IndividuoExcluido) aCondiciones;
		querySelect.setInt(1, individuo.getOID());
		return querySelect;
	}
	
	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  excRefArchivos ");
		textSQL.append(" WHERE oid_individuo = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_ref_archivo oid,oid_individuo codigo,  descripcion ,activo ");
		textSQL.append(" from excRefArchivos");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}
	
	  public static List getReferenciasArchivos(IndividuoExcluido individuo, ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(ReferenciaArchivoExcluido.NICKNAME, DBReferenciaArchivoExcluido.SELECT_BY_INDIVIDUO,
				individuo, new ListObserver(), aSesion);
	}
	

}
