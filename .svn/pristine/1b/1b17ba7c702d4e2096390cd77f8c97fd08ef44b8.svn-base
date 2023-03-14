package com.srn.erp.rrhh.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.rrhh.bm.CondMinSancion;
import com.srn.erp.rrhh.bm.RankearCab;
import com.srn.erp.rrhh.bm.SancionesRRHH;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBCondMinSancion extends DBObjetoPersistente {

	public static final String OID_COND_MIN_SANC = "oid_cond_min_sanc";
	public static final String NRO_NOVEDAD = "nro_novedad";
	public static final String OID_RANKEAR = "oid_rankear";
	public static final String OID_MOT_SANCION = "oid_mot_sancion";
	public static final String ACTIVO = "activo";

	public static final int SELECT_BY_RANKEAR = 100;
	public static final int SELECT_BY_RANK_SANCION_NOV = 101;

	public DBCondMinSancion() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_COND_MIN_SANC = 1;
		final int NRO_NOVEDAD = 2;
		final int OID_RANKEAR = 3;
		final int OID_MOT_SANCION = 4;
		final int ACTIVO = 5;

		CondMinSancion pers = (CondMinSancion) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into rhCondMinSanc " + " ( " + "OID_COND_MIN_SANC," + "NRO_NOVEDAD," + "OID_RANKEAR," + "OID_MOT_SANCION," + "ACTIVO)" + " values " + "(" + "?," + "?," + "?," + "?,"
				+ "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_COND_MIN_SANC, pers.getOID());
		qInsert.setInt(NRO_NOVEDAD, pers.getNro_novedad().intValue());
		qInsert.setInt(OID_RANKEAR, pers.getRankear().getOID());
		qInsert.setInt(OID_MOT_SANCION, pers.getOid_mot_sancion().getOID());
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int NRO_NOVEDAD = 1;
		final int OID_RANKEAR = 2;
		final int OID_MOT_SANCION = 3;
		final int ACTIVO = 4;
		final int OID_COND_MIN_SANC = 5;

		CondMinSancion pers = (CondMinSancion) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update rhCondMinSanc set " + "nro_novedad=?" + ",oid_rankear=?" + ",oid_mot_sancion=?" + ",activo=?" + " where " + " oid_cond_min_sanc=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_COND_MIN_SANC, pers.getOID());
		qUpdate.setInt(NRO_NOVEDAD, pers.getNro_novedad().intValue());
		qUpdate.setInt(OID_RANKEAR, pers.getRankear().getOID());
		qUpdate.setInt(OID_MOT_SANCION, pers.getOid_mot_sancion().getOID());
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_COND_MIN_SANC = 1;
		CondMinSancion pers = (CondMinSancion) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update rhCondMinSanc " + " set activo=0 " + " where " + " oid_cond_min_sanc=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_COND_MIN_SANC, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_COND_MIN_SANC = 1;
		CondMinSancion pers = (CondMinSancion) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update rhCondMinSanc " + " set activo=1 " + " where " + " oid_cond_min_sanc=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_COND_MIN_SANC, pers.getOID());
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
		case SELECT_BY_RANKEAR: {
			ps = this.selectByRankear(aCondiciones);
			break;
		}
		case SELECT_BY_RANK_SANCION_NOV: {
			ps = this.selectByRankSancionNov(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_COND_MIN_SANC = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  rhCondMinSanc ");
		textSQL.append(" WHERE oid_cond_min_sanc = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_COND_MIN_SANC, oid);
		return querySelect;
	}

	private PreparedStatement selectByRankear(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  rhCondMinSanc ");
		textSQL.append(" WHERE oid_rankear = ? and activo = 1 ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		RankearCab rankear = (RankearCab) aCondiciones;
		querySelect.setInt(1, rankear.getOID());
		return querySelect;
	}

	private PreparedStatement selectByRankSancionNov(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  rhCondMinSanc ");
		textSQL.append(" WHERE oid_rankear = ? and oid_mot_sancion = ? and nro_novedad = ? ");
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		RankearCab rankear = (RankearCab) condiciones.get(RankearCab.NICKNAME);
		SancionesRRHH sancion = (SancionesRRHH) condiciones.get(SancionesRRHH.NICKNAME);
		Integer nroNovedad = (Integer) condiciones.get("NRO_NOVEDAD");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		
		querySelect.setInt(1, rankear.getOID());
		querySelect.setInt(2, sancion.getOID());
		querySelect.setInt(3, nroNovedad.intValue());
		
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  rhCondMinSanc ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_cond_min_sanc oid, codigo,  descripcion ,activo ");
		textSQL.append(" from rhCondMinSanc");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static List getCondMinSanciones(RankearCab rankear, ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(CondMinSancion.NICKNAME, DBCondMinSancion.SELECT_BY_RANKEAR, rankear, new ListObserver(), aSesion);
	}

	public static CondMinSancion getCondMinSancion(Integer nroNovedad,RankearCab rankear, SancionesRRHH sancion, ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(RankearCab.NICKNAME, rankear);
		condiciones.put(SancionesRRHH.NICKNAME, sancion);
		condiciones.put("NRO_NOVEDAD", nroNovedad);

		return (CondMinSancion) ObjetoLogico.getObjects(CondMinSancion.NICKNAME, DBCondMinSancion.SELECT_BY_RANK_SANCION_NOV, condiciones, new ObjetoObservado(), aSesion);
	}

}
