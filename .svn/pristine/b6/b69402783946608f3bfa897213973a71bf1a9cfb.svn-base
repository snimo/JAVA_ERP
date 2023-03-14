package com.srn.erp.rrhh.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import com.srn.erp.rrhh.bm.MotivoTipoNov;
import com.srn.erp.rrhh.bm.RankearCab;
import com.srn.erp.rrhh.bm.RankearNovedad;
import com.srn.erp.rrhh.bm.TipoNovedad;
import com.srn.erp.sueldos.bm.Legajo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBRankearNovedad extends DBObjetoPersistente {

	public static final String OID_RANKEAR_NOV = "oid_rankear_nov";
	public static final String OID_RANKEAR = "oid_rankear";
	public static final String OID_TIPO_NOV = "oid_tipo_nov";
	public static final String ACTIVO = "activo";
	public static final String OID_MOTIVO = "oid_motivo";
	public static final String APLICAR = "aplicar";
	public static final String SUMA_O_RESTA = "suma_o_resta";
	public static final String CALIF_EN_PUNTOS = "calif_en_puntos";
	public static final String ANALIZAR_ULT_MESES = "analizar_ult_meses";
	public static final String PONDERACION = "ponderacion";

	public static final int SELECT_BY_RANKEAR = 100;
	public static final int SELECT_BY_NOVEDAD_MOTIVO = 101;
	public static final int SELECT_BY_RANK_NOV_MOT = 102;
	public static final int SELECT_BY_RANK_RANKEAR = 103;
	public static final int SELECT_BY_LEGAJO_RANKEAR = 104;

	public DBRankearNovedad() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_RANKEAR_NOV = 1;
		final int OID_RANKEAR = 2;
		final int OID_TIPO_NOV = 3;
		final int ACTIVO = 4;
		final int OID_MOTIVO = 5;
		final int APLICAR = 6;
		final int SUMA_O_RESTA = 7;
		final int CALIF_EN_PUNTOS = 8;
		final int ANALIZAR_ULT_MESES = 9;
		final int PONDERACION = 10;

		RankearNovedad pers = (RankearNovedad) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into rhRankearNov " + " ( " + "OID_RANKEAR_NOV," + "OID_RANKEAR," + "OID_TIPO_NOV," + "ACTIVO," + "OID_MOTIVO," + "APLICAR," + "SUMA_O_RESTA," + "CALIF_EN_PUNTOS,"
				+ "ANALIZAR_ULT_MESES," + "PONDERACION)" + " values " + "(" + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_RANKEAR_NOV, pers.getOID());
		qInsert.setInt(OID_RANKEAR, pers.getRankear().getOID());
		if (pers.getTipo_novedad() != null)
			qInsert.setInt(OID_TIPO_NOV, pers.getTipo_novedad().getOID());
		else
			qInsert.setNull(OID_TIPO_NOV, java.sql.Types.INTEGER);
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		if (pers.getMotivo() != null)
			qInsert.setInt(OID_MOTIVO, pers.getMotivo().getOID());
		else
			qInsert.setNull(OID_MOTIVO, java.sql.Types.INTEGER);
		if (pers.isAplicar() != null)
			qInsert.setBoolean(APLICAR, pers.isAplicar().booleanValue());
		else
			qInsert.setBoolean(APLICAR, false);
		if (pers.getSuma_o_resta() != null)
			qInsert.setString(SUMA_O_RESTA, pers.getSuma_o_resta());
		else
			qInsert.setNull(SUMA_O_RESTA, Types.VARCHAR);
		if (pers.getCalif_en_puntos() != null)
			qInsert.setDouble(CALIF_EN_PUNTOS, pers.getCalif_en_puntos().doubleValue());
		else
			qInsert.setNull(CALIF_EN_PUNTOS, java.sql.Types.DOUBLE);
		if (pers.getAnalizar_ult_meses() != null)
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

		final int OID_RANKEAR = 1;
		final int OID_TIPO_NOV = 2;
		final int ACTIVO = 3;
		final int OID_MOTIVO = 4;
		final int APLICAR = 5;
		final int SUMA_O_RESTA = 6;
		final int CALIF_EN_PUNTOS = 7;
		final int ANALIZAR_ULT_MESES = 8;
		final int PONDERACION = 9;
		final int OID_RANKEAR_NOV = 10;

		RankearNovedad pers = (RankearNovedad) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update rhRankearNov set " + "oid_rankear=?" + ",oid_tipo_nov=?" + ",activo=?" + ",oid_motivo=?" + ",aplicar=?" + ",suma_o_resta=?" + ",calif_en_puntos=?"
				+ ",analizar_ult_meses=?" + ",ponderacion=?" + " where " + " oid_rankear_nov=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_RANKEAR_NOV, pers.getOID());
		qUpdate.setInt(OID_RANKEAR, pers.getRankear().getOID());
		if (pers.getTipo_novedad() != null)
			qUpdate.setInt(OID_TIPO_NOV, pers.getTipo_novedad().getOID());
		else
			qUpdate.setNull(OID_TIPO_NOV, java.sql.Types.INTEGER);
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		if (pers.getMotivo() != null)
			qUpdate.setInt(OID_MOTIVO, pers.getMotivo().getOID());
		else
			qUpdate.setNull(OID_MOTIVO, java.sql.Types.INTEGER);
		if (pers.isAplicar() != null)
			qUpdate.setBoolean(APLICAR, pers.isAplicar().booleanValue());
		else
			qUpdate.setBoolean(APLICAR, false);
		if (pers.getSuma_o_resta() != null)
			qUpdate.setString(SUMA_O_RESTA, pers.getSuma_o_resta());
		else
			qUpdate.setNull(SUMA_O_RESTA, Types.VARCHAR);
		if (pers.getCalif_en_puntos() != null)
			qUpdate.setDouble(CALIF_EN_PUNTOS, pers.getCalif_en_puntos().doubleValue());
		else
			qUpdate.setNull(CALIF_EN_PUNTOS, java.sql.Types.DOUBLE);
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
		final int OID_RANKEAR_NOV = 1;
		RankearNovedad pers = (RankearNovedad) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update rhRankearNov " + " set activo=0 " + " where " + " oid_rankear_nov=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_RANKEAR_NOV, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_RANKEAR_NOV = 1;
		RankearNovedad pers = (RankearNovedad) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update rhRankearNov " + " set activo=1 " + " where " + " oid_rankear_nov=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_RANKEAR_NOV, pers.getOID());
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
		case SELECT_BY_NOVEDAD_MOTIVO: {
			ps = this.selectByNovedadMotivo(aCondiciones);
			break;
		}
		case SELECT_BY_RANK_RANKEAR: {
			ps = this.selectByRankRankear(aCondiciones);
			break;
		}
		case SELECT_BY_LEGAJO_RANKEAR: {
			ps = this.selectByLegajoRankear(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_RANKEAR_NOV = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  rhRankearNov ");
		textSQL.append(" WHERE oid_rankear_nov = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_RANKEAR_NOV, oid);
		return querySelect;
	}

	private PreparedStatement selectByRankNovMot(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  rhRankearNov ");
		textSQL.append(" WHERE oid_rankear = ? and oid_tipo_nov = ? and oid_motivo = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		RankearCab rankearCab = (RankearCab) condiciones.get(RankearCab.NICKNAME);
		TipoNovedad tipoNovedad = (TipoNovedad) condiciones.get(TipoNovedad.NICKNAME);
		MotivoTipoNov motivo = (MotivoTipoNov) condiciones.get(MotivoTipoNov.NICKNAME);
		querySelect.setInt(1, rankearCab.getOID());
		querySelect.setInt(2, tipoNovedad.getOID());
		querySelect.setInt(3, motivo.getOID());
		return querySelect;
	}

	private PreparedStatement selectByLegajoRankear(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();

		textSQL.append(" select ");
		textSQL.append("  a.* ");
		textSQL.append(" from ");
		textSQL.append("  rhRankearNov a, ");
		textSQL.append("  legNovedades b ");
		textSQL.append(" where ");
		textSQL.append("  b.OID_TIPO_NOVEDAD = a.OID_TIPO_NOV  and ");
		textSQL.append("  b.OID_MOT_TIPO_NOV = a.OID_MOTIVO and ");
		textSQL.append("  b.oid_legajo = ? and ");
		textSQL.append("  a.oid_rankear = ? and ");
		textSQL.append("  a.aplicar = 1 and a.activo = 1 ");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		Legajo legajo = (Legajo) condiciones.get(Legajo.NICKNAME);
		RankearCab rankear = (RankearCab) condiciones.get(RankearCab.NICKNAME);

		querySelect.setInt(1, legajo.getOID());
		querySelect.setInt(2, rankear.getOID());
		
		return querySelect;
	}

	private PreparedStatement selectByRankRankear(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  rhRankearNov ");
		textSQL.append(" WHERE oid_rankear = ? and activo = 1 and aplicar = 1 ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		RankearCab rankear = (RankearCab) aCondiciones;
		querySelect.setInt(1, rankear.getOID());
		return querySelect;
	}

	private PreparedStatement selectByRankear(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  rhRankearNov ");
		textSQL.append(" WHERE oid_rankear = ? and activo = 1 ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		RankearCab rankear = (RankearCab) aCondiciones;
		querySelect.setInt(1, rankear.getOID());
		return querySelect;
	}

	private PreparedStatement selectByNovedadMotivo(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  rhRankearNov ");
		textSQL.append(" WHERE oid_rankear = ? and oid_tipo_nov = ? and oid_motivo = ? and activo = 1 ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		RankearCab rankear = (RankearCab) condiciones.get(RankearCab.NICKNAME);
		TipoNovedad tipoNovedad = (TipoNovedad) condiciones.get(TipoNovedad.NICKNAME);
		MotivoTipoNov motivo = (MotivoTipoNov) condiciones.get(MotivoTipoNov.NICKNAME);
		querySelect.setInt(1, rankear.getOID());
		querySelect.setInt(2, tipoNovedad.getOID());
		querySelect.setInt(3, motivo.getOID());
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  rhRankearNov ");
		textSQL.append(" WHERE oid_rankear = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_rankear_nov oid,oid_rankear codigo, oid_tipo_nov descripcion ,activo ");
		textSQL.append(" from rhRankearNov");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static List getRankearNovedades(RankearCab rankearCab, ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(RankearNovedad.NICKNAME, DBRankearNovedad.SELECT_BY_RANKEAR, rankearCab, new ListObserver(), aSesion);
	}

	public static List getRankearNovedadesAplic(RankearCab rankearCab, ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(RankearNovedad.NICKNAME, DBRankearNovedad.SELECT_BY_RANK_RANKEAR, rankearCab, new ListObserver(), aSesion);
	}
	
	public static List getRankearNovedadesAplic(RankearCab rankearCab, Legajo legajo,ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(RankearCab.NICKNAME, rankearCab);
		condiciones.put(Legajo.NICKNAME, legajo);
		return (List) ObjetoLogico.getObjects(
				RankearNovedad.NICKNAME, 
				DBRankearNovedad.SELECT_BY_LEGAJO_RANKEAR, 
				condiciones, 
				new ListObserver(), aSesion);
	}
	

	public static RankearNovedad getRankearNovedad(RankearCab rankearCab, TipoNovedad tipoNovedad, MotivoTipoNov motivo, ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(RankearCab.NICKNAME, rankearCab);
		condiciones.put(TipoNovedad.NICKNAME, tipoNovedad);
		condiciones.put(MotivoTipoNov.NICKNAME, motivo);
		return (RankearNovedad) ObjetoLogico.getObjects(RankearNovedad.NICKNAME, DBRankearNovedad.SELECT_BY_NOVEDAD_MOTIVO, condiciones, new ObjetoObservado(), aSesion);
	}

}
