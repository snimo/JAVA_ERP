package com.srn.erp.rrhh.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import com.srn.erp.general.bm.PeriodoInc;
import com.srn.erp.general.bm.PeriodoIncDet;
import com.srn.erp.general.da.DBPeriodoIncDet;
import com.srn.erp.rrhh.bm.RankearCab;
import com.srn.erp.rrhh.bm.SancionRankear;
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

public class DBSancionRankear extends DBObjetoPersistente {

	public static final String OID_SANCION_RANK = "oid_sancion_rank";
	public static final String OID_MOT_SANCION = "oid_mot_sancion";
	public static final String ACTIVO = "activo";
	public static final String APLICAR = "aplicar";
	public static final String SUMA_O_RESTA = "suma_o_resta";
	public static final String CALIF_EN_PUNTOS = "calif_en_puntos";
	public static final String OID_RANKEAR = "oid_rankear";
	public static final String ANALIZAR_ULT_MESES = "analizar_ult_meses";
	public static final String PONDERACION = "ponderacion";

	public static final int SELECT_BY_RANKEAR_MOTSANCION = 100;
	public static final int SELECT_BY_RANKEAR_APLICAR = 101;

	public DBSancionRankear() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_SANCION_RANK = 1;
		final int OID_MOT_SANCION = 2;
		final int ACTIVO = 3;
		final int APLICAR = 4;
		final int SUMA_O_RESTA = 5;
		final int CALIF_EN_PUNTOS = 6;
		final int OID_RANKEAR = 7;
		final int ANALIZAR_ULT_MESES = 8;
		final int PONDERACION = 9;

		SancionRankear pers = (SancionRankear) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into rhSancionRank " + " ( " + "OID_SANCION_RANK," + "OID_MOT_SANCION," + "ACTIVO," + "APLICAR," + "SUMA_O_RESTA," + "CALIF_EN_PUNTOS," + "OID_RANKEAR,"
				+ "ANALIZAR_ULT_MESES," + "PONDERACION)" + " values " + "(" + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_SANCION_RANK, pers.getOID());
		if (pers.getMotivo_sancion() != null)
			qInsert.setInt(OID_MOT_SANCION, pers.getMotivo_sancion().getOID());
		else
			qInsert.setNull(OID_MOT_SANCION, java.sql.Types.INTEGER);
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		if (pers.isAplicar() != null)
			qInsert.setBoolean(APLICAR, pers.isAplicar().booleanValue());
		else
			qInsert.setBoolean(APLICAR, false);
		qInsert.setString(SUMA_O_RESTA, pers.getSuma_o_resta());
		if (pers.getCalif_en_puntos() != null)
			qInsert.setDouble(CALIF_EN_PUNTOS, pers.getCalif_en_puntos().doubleValue());
		else
			qInsert.setNull(CALIF_EN_PUNTOS, java.sql.Types.DOUBLE);
		qInsert.setInt(OID_RANKEAR, pers.getOid_rankear().getOID());
		if (pers.getAnalizar_ult_meses()!=null)
			qInsert.setInt(ANALIZAR_ULT_MESES, pers.getAnalizar_ult_meses().intValue());
		else
			qInsert.setNull(ANALIZAR_ULT_MESES, Types.INTEGER);
		if (pers.getPonderacion() != null)
			qInsert.setDouble(PONDERACION, pers.getPonderacion().doubleValue());
		else
			qInsert.setNull(PONDERACION, Types.DOUBLE);
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_MOT_SANCION = 1;
		final int ACTIVO = 2;
		final int APLICAR = 3;
		final int SUMA_O_RESTA = 4;
		final int CALIF_EN_PUNTOS = 5;
		final int OID_RANKEAR = 6;
		final int ANALIZAR_ULT_MESES = 7;
		final int PONDERACION = 8;
		final int OID_SANCION_RANK = 9;

		SancionRankear pers = (SancionRankear) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update rhSancionRank set " + "oid_mot_sancion=?" + ",activo=?" + ",aplicar=?" + ",suma_o_resta=?" + ",calif_en_puntos=?" + ",oid_rankear=?" + ",analizar_ult_meses=?"
				+ ",ponderacion=?" + " where " + " oid_sancion_rank=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_SANCION_RANK, pers.getOID());
		if (pers.getMotivo_sancion() != null)
			qUpdate.setInt(OID_MOT_SANCION, pers.getMotivo_sancion().getOID());
		else
			qUpdate.setNull(OID_MOT_SANCION, java.sql.Types.INTEGER);
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		if (pers.isAplicar() != null)
			qUpdate.setBoolean(APLICAR, pers.isAplicar().booleanValue());
		else
			qUpdate.setBoolean(APLICAR, false);
		qUpdate.setString(SUMA_O_RESTA, pers.getSuma_o_resta());
		if (pers.getCalif_en_puntos() != null)
			qUpdate.setDouble(CALIF_EN_PUNTOS, pers.getCalif_en_puntos().doubleValue());
		else
			qUpdate.setNull(CALIF_EN_PUNTOS, java.sql.Types.INTEGER);
		qUpdate.setInt(OID_RANKEAR, pers.getOid_rankear().getOID());
		if (pers.getAnalizar_ult_meses() != null)
			qUpdate.setInt(ANALIZAR_ULT_MESES, pers.getAnalizar_ult_meses().intValue());
		else
			qUpdate.setNull(ANALIZAR_ULT_MESES, Types.INTEGER);
		if (pers.getPonderacion() != null)
			qUpdate.setDouble(PONDERACION, pers.getPonderacion().doubleValue());
		else
			qUpdate.setNull(PONDERACION, Types.DOUBLE);
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_SANCION_RANK = 1;
		SancionRankear pers = (SancionRankear) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update rhSancionRank " + " set activo=0 " + " where " + " oid_sancion_rank=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_SANCION_RANK, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_SANCION_RANK = 1;
		SancionRankear pers = (SancionRankear) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update rhSancionRank " + " set activo=1 " + " where " + " oid_sancion_rank=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_SANCION_RANK, pers.getOID());
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
		case SELECT_BY_RANKEAR_MOTSANCION: {
			ps = this.selectByRankearSancion(aCondiciones);
			break;
		}
		case SELECT_BY_RANKEAR_APLICAR: {
			ps = this.selectByRankearAplicar(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_SANCION_RANK = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  rhSancionRank ");
		textSQL.append(" WHERE oid_sancion_rank = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_SANCION_RANK, oid);
		return querySelect;
	}

	private PreparedStatement selectByRankearAplicar(Object aCondiciones) throws BaseException, SQLException {

		RankearCab rankear = (RankearCab)  aCondiciones;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  rhSancionRank ");
		textSQL.append(" WHERE oid_rankear = ? and aplicar = 1 and activo=1 ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		querySelect.setInt(1, rankear.getOID());
		return querySelect;
		
	}

	private PreparedStatement selectByRankearSancion(Object aCondiciones) throws BaseException, SQLException {

		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		RankearCab rankear = (RankearCab) condiciones.get(RankearCab.NICKNAME);
		SancionesRRHH sancion = (SancionesRRHH) condiciones.get(SancionesRRHH.NICKNAME);

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  rhSancionRank ");
		textSQL.append(" WHERE oid_rankear = ? and oid_mot_sancion = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		querySelect.setInt(1, rankear.getOID());
		querySelect.setInt(2, sancion.getOID());

		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  rhSancionRank ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_sancion_rank oid, codigo,  descripcion ,activo ");
		textSQL.append(" from rhSancionRank");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static SancionRankear getSancionRankear(RankearCab rankear, SancionesRRHH sancion, ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(RankearCab.NICKNAME, rankear);
		condiciones.put(SancionesRRHH.NICKNAME, sancion);
		return (SancionRankear) ObjetoLogico.getObjects(SancionRankear.NICKNAME, DBSancionRankear.SELECT_BY_RANKEAR_MOTSANCION, condiciones, new ObjetoObservado(), aSesion);
	}
	
	public static List getSancionesRankear(
			  RankearCab rankear,
              ISesion aSesion) throws BaseException {
		  return (List) ObjetoLogico.getObjects(SancionRankear.NICKNAME,
                 DBSancionRankear.SELECT_BY_RANKEAR_APLICAR,
                 rankear,
                 new ListObserver(),
                 aSesion);
	}
	

}
