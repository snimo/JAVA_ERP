package com.srn.erp.cip.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.cip.bm.AlgoCacheoClasif;
import com.srn.erp.cip.bm.AlgoritmoCacheo;
import com.srn.erp.general.da.DBPeriodoIncDet;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBAlgoCacheoClasif extends DBObjetoPersistente {

	public static final String OID_CACHE_CLASIF = "oid_cache_clasif";
	public static final String OID_ALGO_CACHEO = "oid_algo_cacheo";
	public static final String OID_CLASIFICADOR = "oid_clasificador";
	public static final String OID_VAL_CLASIF = "oid_val_clasif";
	public static final String INC_EXC = "inc_exc";
	public static final String ACTIVO = "activo";
	
	public static final int SELECT_BY_ALGO_CACHEO = 100;
	public static final int SELECT_BY_INCLUSION   = 101;
	public static final int SELECT_BY_EXCLUSION   = 102;
	

	public DBAlgoCacheoClasif() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_CACHE_CLASIF = 1;
		final int OID_ALGO_CACHEO = 2;
		final int OID_CLASIFICADOR = 3;
		final int OID_VAL_CLASIF = 4;
		final int INC_EXC = 5;
		final int ACTIVO = 6;

		AlgoCacheoClasif pers = (AlgoCacheoClasif) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into cipAlgoCacheClasif " + " ( " + "OID_CACHE_CLASIF," + "OID_ALGO_CACHEO," + "OID_CLASIFICADOR,"
				+ "OID_VAL_CLASIF," + "INC_EXC," + "ACTIVO)" + " values " + "(" + "?," + "?," + "?," + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_CACHE_CLASIF, pers.getOID());
		qInsert.setInt(OID_ALGO_CACHEO, pers.getAlgoritmo_cacheo().getOID());
		qInsert.setInt(OID_CLASIFICADOR, pers.getClasificador().getOID());
		if (pers.getValor_clasif() != null)
			qInsert.setInt(OID_VAL_CLASIF, pers.getValor_clasif().getOID());
		else
			qInsert.setNull(OID_VAL_CLASIF, java.sql.Types.INTEGER);
		qInsert.setString(INC_EXC, pers.getInc_exc());
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_ALGO_CACHEO = 1;
		final int OID_CLASIFICADOR = 2;
		final int OID_VAL_CLASIF = 3;
		final int INC_EXC = 4;
		final int ACTIVO = 5;
		final int OID_CACHE_CLASIF = 6;

		AlgoCacheoClasif pers = (AlgoCacheoClasif) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update cipAlgoCacheClasif set " + "oid_algo_cacheo=?" + ",oid_clasificador=?" + ",oid_val_clasif=?"
				+ ",inc_exc=?" + ",activo=?" + " where " + " oid_cache_clasif=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_CACHE_CLASIF, pers.getOID());
		qUpdate.setInt(OID_ALGO_CACHEO, pers.getAlgoritmo_cacheo().getOID());
		qUpdate.setInt(OID_CLASIFICADOR, pers.getClasificador().getOID());
		if (pers.getValor_clasif() != null)
			qUpdate.setInt(OID_VAL_CLASIF, pers.getValor_clasif().getOID());
		else
			qUpdate.setNull(OID_VAL_CLASIF, java.sql.Types.INTEGER);
		qUpdate.setString(INC_EXC, pers.getInc_exc());
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_CACHE_CLASIF = 1;
		AlgoCacheoClasif pers = (AlgoCacheoClasif) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cipAlgoCacheClasif " + " set activo=0 " + " where " + " oid_cache_clasif=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_CACHE_CLASIF, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_CACHE_CLASIF = 1;
		AlgoCacheoClasif pers = (AlgoCacheoClasif) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cipAlgoCacheClasif " + " set activo=1 " + " where " + " oid_cache_clasif=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_CACHE_CLASIF, pers.getOID());
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
		case SELECT_BY_ALGO_CACHEO: {
			ps = this.selectByAlgoCacheo(aCondiciones);
			break;
		}
		case SELECT_BY_INCLUSION: {
			ps = this.selectByInclusion(aCondiciones);
			break;			
		}
		case SELECT_BY_EXCLUSION: {
			ps = this.selectByExclusion(aCondiciones);
			break;			
		}		
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_CACHE_CLASIF = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cipAlgoCacheClasif ");
		textSQL.append(" WHERE oid_cache_clasif = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_CACHE_CLASIF, oid);
		return querySelect;
	}

	private PreparedStatement selectByInclusion(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cipAlgoCacheClasif ");
		textSQL.append(" WHERE oid_algo_cacheo = ? and activo = 1 and inc_exc='I' ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		AlgoritmoCacheo algoritmo = (AlgoritmoCacheo) aCondiciones;
		querySelect.setInt(1, algoritmo.getOID());
		return querySelect;
	}	
	
	private PreparedStatement selectByExclusion(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cipAlgoCacheClasif ");
		textSQL.append(" WHERE oid_algo_cacheo = ? and activo = 1 and inc_exc='E' ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		AlgoritmoCacheo algoritmo = (AlgoritmoCacheo) aCondiciones;
		querySelect.setInt(1, algoritmo.getOID());
		return querySelect;
	}
	
	private PreparedStatement selectByAlgoCacheo(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cipAlgoCacheClasif ");
		textSQL.append(" WHERE oid_algo_cacheo = ? and activo = 1 ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		AlgoritmoCacheo algoritmo = (AlgoritmoCacheo) aCondiciones;
		querySelect.setInt(1, algoritmo.getOID());
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cipAlgoCacheClasif ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_cache_clasif oid, codigo,  descripcion ,activo ");
		textSQL.append(" from cipAlgoCacheClasif");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static List getAlgoCacheoClasif(AlgoritmoCacheo algoritmo, ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(AlgoCacheoClasif.NICKNAME, DBAlgoCacheoClasif.SELECT_BY_ALGO_CACHEO, algoritmo,
				new ListObserver(), aSesion);
	}
	
	public static List getAlgoCacheoClasifIncluidos(AlgoritmoCacheo algoritmo, ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(AlgoCacheoClasif.NICKNAME, DBAlgoCacheoClasif.SELECT_BY_INCLUSION, algoritmo,
				new ListObserver(), aSesion);
	}	
	
	public static List getAlgoCacheoClasifExcluidos(AlgoritmoCacheo algoritmo, ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(AlgoCacheoClasif.NICKNAME, DBAlgoCacheoClasif.SELECT_BY_EXCLUSION, algoritmo,
				new ListObserver(), aSesion);
	}	

}
