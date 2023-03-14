package com.srn.erp.cip.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.cip.bm.AlgoCacheoEstado;
import com.srn.erp.cip.bm.AlgoritmoCacheo;
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

public class DBAlgoCacheoEstado extends DBObjetoPersistente {

	public static final String OID_ALGO_EST = "oid_algo_est";
	public static final String OID_ALGO_CACHEO = "oid_algo_cacheo";
	public static final String OID_ESTADO_CIP = "oid_estado_cip";
	public static final String ACTIVO = "activo";

	public static final int SELECT_BY_ALGO_CACHEO = 100;

	public DBAlgoCacheoEstado() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_ALGO_EST = 1;
		final int OID_ALGO_CACHEO = 2;
		final int OID_ESTADO_CIP = 3;
		final int ACTIVO = 4;

		AlgoCacheoEstado pers = (AlgoCacheoEstado) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into cipAlgoCacheoEst " + " ( " + "OID_ALGO_EST," + "OID_ALGO_CACHEO," + "OID_ESTADO_CIP," + "ACTIVO)"
				+ " values " + "(" + "?," + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_ALGO_EST, pers.getOID());
		qInsert.setInt(OID_ALGO_CACHEO, pers.getAlgoritmo_cacheo().getOID());
		qInsert.setInt(OID_ESTADO_CIP, pers.getEstado().getOID());
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_ALGO_CACHEO = 1;
		final int OID_ESTADO_CIP = 2;
		final int ACTIVO = 3;
		final int OID_ALGO_EST = 4;

		AlgoCacheoEstado pers = (AlgoCacheoEstado) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update cipAlgoCacheoEst set " + "oid_algo_cacheo=?" + ",oid_estado_cip=?" + ",activo=?" + " where "
				+ " oid_algo_est=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_ALGO_EST, pers.getOID());
		qUpdate.setInt(OID_ALGO_CACHEO, pers.getAlgoritmo_cacheo().getOID());
		qUpdate.setInt(OID_ESTADO_CIP, pers.getEstado().getOID());
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_ALGO_EST = 1;
		AlgoCacheoEstado pers = (AlgoCacheoEstado) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cipAlgoCacheoEst " + " set activo=0 " + " where " + " oid_algo_est=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_ALGO_EST, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_ALGO_EST = 1;
		AlgoCacheoEstado pers = (AlgoCacheoEstado) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cipAlgoCacheoEst " + " set activo=1 " + " where " + " oid_algo_est=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_ALGO_EST, pers.getOID());
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
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_ALGO_EST = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cipAlgoCacheoEst ");
		textSQL.append(" WHERE oid_algo_est = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_ALGO_EST, oid);
		return querySelect;
	}

	private PreparedStatement selectByAlgoCacheo(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cipAlgoCacheoEst ");
		textSQL.append(" WHERE oid_algo_cacheo = ? and activo=1 ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		AlgoritmoCacheo algoritmoCacheo = (AlgoritmoCacheo) aCondiciones;
		querySelect.setInt(1, algoritmoCacheo.getOID());
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cipAlgoCacheoEst ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_algo_est oid, codigo,  descripcion ,activo ");
		textSQL.append(" from cipAlgoCacheoEst");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static List getAlgoCacheoEstados(AlgoritmoCacheo algoritmo, ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(AlgoCacheoEstado.NICKNAME, DBAlgoCacheoEstado.SELECT_BY_ALGO_CACHEO, algoritmo,
				new ListObserver(), aSesion);
	}

}
