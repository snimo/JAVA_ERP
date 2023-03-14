package com.srn.erp.cip.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.cip.bm.AlgoritmoCacheo;
import com.srn.erp.cip.bm.FechaExclusionCacheo;
import com.srn.erp.general.bm.Periodo;
import com.srn.erp.general.da.DBPeriodo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBFechaExclusionCacheo extends DBObjetoPersistente {

	public static final String OID_EXC_FEC = "oid_exc_fec";
	public static final String OID_ALGO_CACHEO = "oid_algo_cacheo";
	public static final String FECHA = "fecha";
	public static final String ACTIVO = "activo";

	public static final int SELECT_BY_CACHEO = 100;
	public static final int SELECT_BY_CACHEO_FECHA = 101;

	public DBFechaExclusionCacheo() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_EXC_FEC = 1;
		final int OID_ALGO_CACHEO = 2;
		final int FECHA = 3;
		final int ACTIVO = 4;

		FechaExclusionCacheo pers = (FechaExclusionCacheo) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into cipExcFecCacheo " + " ( " + "OID_EXC_FEC," + "OID_ALGO_CACHEO," + "FECHA," + "ACTIVO)" + " values "
				+ "(" + "?," + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_EXC_FEC, pers.getOID());
		qInsert.setInt(OID_ALGO_CACHEO, pers.getAlgoritmo().getOID());
		qInsert.setDate(FECHA, new java.sql.Date(pers.getFecha().getTime()));
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_ALGO_CACHEO = 1;
		final int FECHA = 2;
		final int ACTIVO = 3;
		final int OID_EXC_FEC = 4;

		FechaExclusionCacheo pers = (FechaExclusionCacheo) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update cipExcFecCacheo set " + "oid_algo_cacheo=?" + ",fecha=?" + ",activo=?" + " where " + " oid_exc_fec=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_EXC_FEC, pers.getOID());
		qUpdate.setInt(OID_ALGO_CACHEO, pers.getAlgoritmo().getOID());
		qUpdate.setDate(FECHA, new java.sql.Date(pers.getFecha().getTime()));
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_EXC_FEC = 1;
		FechaExclusionCacheo pers = (FechaExclusionCacheo) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cipExcFecCacheo " + " set activo=0 " + " where " + " oid_exc_fec=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_EXC_FEC, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_EXC_FEC = 1;
		FechaExclusionCacheo pers = (FechaExclusionCacheo) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cipExcFecCacheo " + " set activo=1 " + " where " + " oid_exc_fec=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_EXC_FEC, pers.getOID());
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
		case SELECT_BY_CACHEO: {
			ps = this.selectByCacheo(aCondiciones);
			break;
		}
		case SELECT_BY_CACHEO_FECHA: {
			ps = this.selectByCacheoFecha(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_EXC_FEC = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cipExcFecCacheo ");
		textSQL.append(" WHERE oid_exc_fec = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_EXC_FEC, oid);
		return querySelect;
	}

	private PreparedStatement selectByCacheoFecha(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cipExcFecCacheo ");
		textSQL.append(" WHERE oid_algo_cacheo = ? and fecha=? and activo=1 ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		AlgoritmoCacheo algoritmo = (AlgoritmoCacheo) condiciones.get(AlgoritmoCacheo.NICKNAME);
		java.util.Date fecha = (java.util.Date) condiciones.get("FECHA");
		querySelect.setInt(1, algoritmo.getOID());
		querySelect.setDate(2, new java.sql.Date(fecha.getTime()));
		return querySelect;
	}

	private PreparedStatement selectByCacheo(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cipExcFecCacheo ");
		textSQL.append(" WHERE oid_algo_cacheo = ? and activo=1 ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		AlgoritmoCacheo algoritmo = (AlgoritmoCacheo) aCondiciones;
		querySelect.setInt(1, algoritmo.getOID());
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cipExcFecCacheo ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_exc_fec oid, codigo,  descripcion ,activo ");
		textSQL.append(" from cipExcFecCacheo");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static List getFechasExclusionCacheo(AlgoritmoCacheo algoritmo, ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(FechaExclusionCacheo.NICKNAME, DBFechaExclusionCacheo.SELECT_BY_CACHEO, algoritmo,
				new ListObserver(), aSesion);
	}

	public static FechaExclusionCacheo getFechaExclusionCacheo(AlgoritmoCacheo algoritmo, java.util.Date fecha, ISesion aSesion)
			throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(AlgoritmoCacheo.NICKNAME, algoritmo);
		condiciones.put("FECHA", fecha);
		return (FechaExclusionCacheo) ObjetoLogico.getObjects(FechaExclusionCacheo.NICKNAME, DBFechaExclusionCacheo.SELECT_BY_CACHEO_FECHA,
				condiciones, new ObjetoObservado(), aSesion);
	}

}
