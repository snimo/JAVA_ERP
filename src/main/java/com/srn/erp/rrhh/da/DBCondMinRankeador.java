package com.srn.erp.rrhh.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.rrhh.bm.CondMinRankeador;
import com.srn.erp.rrhh.bm.MotivoTipoNov;
import com.srn.erp.rrhh.bm.RankearCab;
import com.srn.erp.rrhh.bm.TipoNovedad;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBCondMinRankeador extends DBObjetoPersistente {

	public static final String OID_COND_MIN_RANK = "oid_cond_min_rank";
	public static final String NRO_NOVEDAD = "nro_novedad";
	public static final String OID_RANKEAR = "oid_rankear";
	public static final String OID_TIPO_NOV = "oid_tipo_nov";
	public static final String OID_MOTIVO = "oid_motivo";
	public static final String ACTIVO = "activo";

	public static final int SELECT_BY_RANKEADOR_NOVEDAD = 100;
	public static final int SELECT_BY_NRO_RANK_NOV_MOT = 101;

	public DBCondMinRankeador() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_COND_MIN_RANK = 1;
		final int NRO_NOVEDAD = 2;
		final int OID_RANKEAR = 3;
		final int OID_TIPO_NOV = 4;
		final int OID_MOTIVO = 5;
		final int ACTIVO = 6;

		CondMinRankeador pers = (CondMinRankeador) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into rhCondMinRank " + " ( " + "OID_COND_MIN_RANK," + "NRO_NOVEDAD," + "OID_RANKEAR," + "OID_TIPO_NOV," + "OID_MOTIVO," + "ACTIVO)" + " values " + "(" + "?," + "?,"
				+ "?," + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_COND_MIN_RANK, pers.getOID());
		qInsert.setInt(NRO_NOVEDAD, pers.getNro_novedad().intValue());
		qInsert.setInt(OID_RANKEAR, pers.getRankear().getOID());
		qInsert.setInt(OID_TIPO_NOV, pers.getTipo_novedad().getOID());
		qInsert.setInt(OID_MOTIVO, pers.getMotivo().getOID());
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int NRO_NOVEDAD = 1;
		final int OID_RANKEAR = 2;
		final int OID_TIPO_NOV = 3;
		final int OID_MOTIVO = 4;
		final int ACTIVO = 5;
		final int OID_COND_MIN_RANK = 6;

		CondMinRankeador pers = (CondMinRankeador) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update rhCondMinRank set " + "nro_novedad=?" + ",oid_rankear=?" + ",oid_tipo_nov=?" + ",oid_motivo=?" + ",activo=?" + " where " + " oid_cond_min_rank=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_COND_MIN_RANK, pers.getOID());
		qUpdate.setInt(NRO_NOVEDAD, pers.getNro_novedad().intValue());
		qUpdate.setInt(OID_RANKEAR, pers.getRankear().getOID());
		qUpdate.setInt(OID_TIPO_NOV, pers.getTipo_novedad().getOID());
		qUpdate.setInt(OID_MOTIVO, pers.getMotivo().getOID());
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_COND_MIN_RANK = 1;
		CondMinRankeador pers = (CondMinRankeador) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update rhCondMinRank " + " set activo=0 " + " where " + " oid_cond_min_rank=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_COND_MIN_RANK, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_COND_MIN_RANK = 1;
		CondMinRankeador pers = (CondMinRankeador) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update rhCondMinRank " + " set activo=1 " + " where " + " oid_cond_min_rank=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_COND_MIN_RANK, pers.getOID());
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
		case SELECT_BY_RANKEADOR_NOVEDAD: {
			ps = this.selectByRankeadorNovedad(aCondiciones);
			break;
		}
		case SELECT_BY_NRO_RANK_NOV_MOT: {
			ps = this.selectByNroRankNovMot(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_COND_MIN_RANK = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  rhCondMinRank ");
		textSQL.append(" WHERE oid_cond_min_rank = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_COND_MIN_RANK, oid);
		return querySelect;
	}

	private PreparedStatement selectByNroRankNovMot(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  rhCondMinRank ");
		textSQL.append(" WHERE oid_rankear = ? and nro_novedad = ? and oid_tipo_nov = ? and oid_motivo = ?");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		RankearCab rankearCab = (RankearCab) condiciones.get(RankearCab.NICKNAME);
		Integer nroNovedad = (Integer) condiciones.get("NRO_NOVEDAD");
		TipoNovedad tipoNovedad = (TipoNovedad) condiciones.get(TipoNovedad.NICKNAME);
		MotivoTipoNov motivo = (MotivoTipoNov) condiciones.get(MotivoTipoNov.NICKNAME);
		querySelect.setInt(1, rankearCab.getOID());
		querySelect.setInt(2, nroNovedad.intValue());
		querySelect.setInt(3, tipoNovedad.getOID());
		querySelect.setInt(4, motivo.getOID());
		return querySelect;

	}

	private PreparedStatement selectByRankeadorNovedad(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  rhCondMinRank ");
		textSQL.append(" WHERE oid_rankear = ? and nro_novedad = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		HashTableDatos condiciones = new HashTableDatos();
		RankearCab rankearCab = (RankearCab) condiciones.get(RankearCab.NICKNAME);
		Integer nroNovedad = (Integer) condiciones.get("NRO_NOVEDAD");
		querySelect.setInt(1, rankearCab.getOID());
		querySelect.setInt(2, nroNovedad.intValue());
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  rhCondMinRank ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_cond_min_rank oid, codigo,  descripcion ,activo ");
		textSQL.append(" from rhCondMinRank");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static List getCondMinRankeador(RankearCab rankear, Integer nroNovedad, ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(RankearCab.NICKNAME, rankear);
		condiciones.put("NRO_NOVEDAD", nroNovedad);
		return (List) ObjetoLogico.getObjects(CondMinRankeador.NICKNAME, DBCondMinRankeador.SELECT_BY_RANKEADOR_NOVEDAD, condiciones, new ListObserver(), aSesion);
	}

	public static CondMinRankeador getCondMinRankeador(Integer nroNovedad, RankearCab rankearCab, TipoNovedad tipoNovedad, MotivoTipoNov motivo, ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put("NRO_NOVEDAD", nroNovedad);
		condiciones.put(RankearCab.NICKNAME, rankearCab);
		condiciones.put(TipoNovedad.NICKNAME, tipoNovedad);
		condiciones.put(MotivoTipoNov.NICKNAME, motivo);

		return (CondMinRankeador) ObjetoLogico.getObjects(CondMinRankeador.NICKNAME, DBCondMinRankeador.SELECT_BY_NRO_RANK_NOV_MOT, condiciones, new ObjetoObservado(), aSesion);
	}

}
