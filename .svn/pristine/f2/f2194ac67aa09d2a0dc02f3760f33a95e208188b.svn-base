package com.srn.erp.cip.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.cip.bm.PlanoCIP;
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

public class DBPlanoCIP extends DBObjetoPersistente {

	public static final String OID_PLANO = "oid_plano";
	public static final String CODIGO = "codigo";
	public static final String DESCRIPCION = "descripcion";
	public static final String OID_AGRUP_PLANO = "oid_agrup_plano";
	public static final String ORDEN = "orden";
	public static final String ACTIVO = "activo";
	
	public DBPlanoCIP() {
	}

	protected void insert(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {

		final int OID_PLANO = 1;
		final int CODIGO = 2;
		final int DESCRIPCION = 3;
		final int OID_AGRUP_PLANO = 4;
		final int ORDEN = 5;
		final int ACTIVO = 6;

		PlanoCIP pers = (PlanoCIP) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into cipPlano " + " ( "
				+ "OID_PLANO," + "CODIGO," + "DESCRIPCION,"
				+ "OID_AGRUP_PLANO," + "ORDEN," + "ACTIVO)" + " values " + "("
				+ "?," + "?," + "?," + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD()
				.prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_PLANO, pers.getOID());
		qInsert.setString(CODIGO, pers.getCodigo());
		qInsert.setString(DESCRIPCION, pers.getDescripcion());
		qInsert.setInt(OID_AGRUP_PLANO, pers.getGrupo_plano().getOID());
		qInsert.setInt(ORDEN, pers.getOrden().intValue());
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {

		final int CODIGO = 1;
		final int DESCRIPCION = 2;
		final int OID_AGRUP_PLANO = 3;
		final int ORDEN = 4;
		final int ACTIVO = 5;
		final int OID_PLANO = 6;

		PlanoCIP pers = (PlanoCIP) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update cipPlano set " + "codigo=?"
				+ ",descripcion=?" + ",oid_agrup_plano=?" + ",orden=?"
				+ ",activo=?" + " where " + " oid_plano=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_PLANO, pers.getOID());
		qUpdate.setString(CODIGO, pers.getCodigo());
		qUpdate.setString(DESCRIPCION, pers.getDescripcion());
		qUpdate.setInt(OID_AGRUP_PLANO, pers.getGrupo_plano().getOID());
		qUpdate.setInt(ORDEN, pers.getOrden().intValue());
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {
		final int OID_PLANO = 1;
		PlanoCIP pers = (PlanoCIP) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cipPlano " + " set activo=0 "
				+ " where " + " oid_plano=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_PLANO, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {
		final int OID_PLANO = 1;
		PlanoCIP pers = (PlanoCIP) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cipPlano " + " set activo=1 "
				+ " where " + " oid_plano=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_PLANO, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	public PreparedStatement prepararSelect(int aSelect, Object aCondiciones)
			throws BaseException, SQLException {
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
		case IDBObjetoPersistente.SELECT_ALL_ACTIVOS: {
			ps = this.selectAllActivos(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones)
			throws BaseException, SQLException {

		final int OID_PLANO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cipPlano ");
		textSQL.append(" WHERE oid_plano = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_PLANO, oid);
		return querySelect;
	}

	private PreparedStatement selectAllActivos(Object aCondiciones)
		throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cipPlano ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}
	
	private PreparedStatement selectByCodigo(Object aCondiciones)
			throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cipPlano ");
		textSQL.append(" WHERE codigo = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones)
			throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL
				.append("SELECT oid_plano oid,codigo codigo, descripcion descripcion ,activo ");
		textSQL.append(" from cipPlano");

		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		return querySelect;
	}
	
	  public static List getAllPlanos(ISesion aSesion) throws BaseException {
		  return (List) ObjetoLogico.getObjects(PlanoCIP.NICKNAME,
                 DBPlanoCIP.SELECT_ALL_ACTIVOS,
                 null,
                 new ListObserver(),
                 aSesion);
	  }

	

}
