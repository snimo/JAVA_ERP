package com.srn.erp.cip.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.srn.erp.cip.bm.AlgoritmoCacheo;

import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class DBAlgoritmoCacheo extends DBObjetoPersistente {

	public static final String OID_ALGO_CACHEO = "oid_algo_cacheo";
	public static final String FILTRO_LEGAJO = "filtro_legajo";
	public static final String TIPO_PLANIF = "tipo_planif";
	public static final String PORC_ENT = "porc_ent";
	public static final String ACTIVO = "activo";
	public static final String PROB_CACH_ENT = "prob_cach_ent";
	public static final String PORC_SAL = "porc_sal";
	public static final String PROB_CACH_SAL = "prob_cach_sal";
	public static final String FILTRO_ESTADOS = "filtro_estados";
	public static final String CODIGO = "codigo";
	public static final String DESCRIPCION = "descripcion";
	public static final String LUNES = "lunes";
	public static final String MARTES = "martes";
	public static final String MIERCOLES = "miercoles";
	public static final String JUEVES = "jueves";
	public static final String VIERNES = "viernes";
	public static final String SABADO = "sabado";
	public static final String DOMINGO = "domingo";
	

	public DBAlgoritmoCacheo() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_ALGO_CACHEO = 1;
		final int FILTRO_LEGAJO = 2;
		final int TIPO_PLANIF = 3;
		final int PORC_ENT = 4;
		final int ACTIVO = 5;
		final int PROB_CACH_ENT = 6;
		final int PORC_SAL = 7;
		final int PROB_CACH_SAL = 8;
		final int FILTRO_ESTADOS = 9;
		final int CODIGO = 10;
		final int DESCRIPCION = 11;
		final int LUNES = 12;
		final int MARTES = 13;
		final int MIERCOLES = 14;
		final int JUEVES = 15;
		final int VIERNES = 16;
		final int SABADO = 17;
		final int DOMINGO = 18;
		

		AlgoritmoCacheo pers = (AlgoritmoCacheo) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into cipAlgoCacheo " + " ( " + "OID_ALGO_CACHEO," + "FILTRO_LEGAJO," + "TIPO_PLANIF," + "PORC_ENT,"
				+ "ACTIVO," + "PROB_CACH_ENT," + "PORC_SAL," + "PROB_CACH_SAL , FILTRO_ESTADOS , CODIGO , DESCRIPCION , LUNES , MARTES , MIERCOLES , JUEVES , VIERNES , SABADO , DOMINGO)" + " values " + "(" + "?," + "?," + "?," + "?," + "?,"
				+ "?,"+"?,"+"?,"+"?,"+"?,"+"?,"+"?,"+"?,"+ "?,"+ "?," + "?,"+ "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_ALGO_CACHEO, pers.getOID());
		qInsert.setString(FILTRO_LEGAJO, pers.getFiltro_legajo());
		qInsert.setString(TIPO_PLANIF, pers.getTipo_planif());
		if (pers.getPorc_ent()!=null)
			qInsert.setDouble(PORC_ENT, pers.getPorc_ent().doubleValue());
		else
			qInsert.setDouble(PORC_ENT, 0);
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		if (pers.getProb_cach_ent()!=null)
			qInsert.setDouble(PROB_CACH_ENT, pers.getProb_cach_ent().doubleValue());
		else
			qInsert.setDouble(PROB_CACH_ENT, 0);
		if (pers.getPorc_sal()!=null)
			qInsert.setDouble(PORC_SAL, pers.getPorc_sal().doubleValue());
		else
			qInsert.setDouble(PORC_SAL, 0);
		if (pers.getProb_cach_sal()!=null)
			qInsert.setDouble(PROB_CACH_SAL, pers.getProb_cach_sal().doubleValue());
		else
			qInsert.setDouble(PROB_CACH_SAL, 0);
		qInsert.setString(FILTRO_ESTADOS, pers.getFiltro_estados());
		qInsert.setString(CODIGO , pers.getCodigo());
		qInsert.setString(DESCRIPCION , pers.getDescripcion());
		qInsert.setBoolean(LUNES, pers.isLunes());
		qInsert.setBoolean(MARTES, pers.isMartes());
		qInsert.setBoolean(MIERCOLES, pers.isMiercoles());
		qInsert.setBoolean(JUEVES, pers.isJueves());
		qInsert.setBoolean(VIERNES, pers.isViernes());
		qInsert.setBoolean(SABADO, pers.isSabado());
		qInsert.setBoolean(DOMINGO, pers.isDomingo());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int FILTRO_LEGAJO = 1;
		final int TIPO_PLANIF = 2;
		final int PORC_ENT = 3;
		final int ACTIVO = 4;
		final int PROB_CACH_ENT = 5;
		final int PORC_SAL = 6;
		final int PROB_CACH_SAL = 7;
		final int FILTRO_ESTADOS = 8;
		final int CODIGO = 9;
		final int DESCRIPCION = 10;
		final int LUNES = 11;
		final int MARTES = 12;
		final int MIERCOLES = 13;
		final int JUEVES = 14;
		final int VIERNES = 15;
		final int SABADO = 16;
		final int DOMINGO = 17;
		final int OID_ALGO_CACHEO = 18;

		AlgoritmoCacheo pers = (AlgoritmoCacheo) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update cipAlgoCacheo set " + "filtro_legajo=?" + ",tipo_planif=?" + ",porc_ent=?" + ",activo=?"
				+ ",prob_cach_ent=?" + ",porc_sal=?" + ",prob_cach_sal=? , filtro_estados = ? , codigo = ? , descripcion = ? " +
				", lunes = ? , martes = ? , miercoles = ? , jueves = ? , viernes = ? , sabado = ? , domingo = ? "+
				" where " + " oid_algo_cacheo=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_ALGO_CACHEO, pers.getOID());
		qUpdate.setString(FILTRO_LEGAJO, pers.getFiltro_legajo());
		qUpdate.setString(TIPO_PLANIF, pers.getTipo_planif());
		if (pers.getPorc_ent()!=null)
			qUpdate.setDouble(PORC_ENT, pers.getPorc_ent().doubleValue());
		else
			qUpdate.setDouble(PORC_ENT, 0);
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		if (pers.getProb_cach_ent()!=null)
			qUpdate.setDouble(PROB_CACH_ENT, pers.getProb_cach_ent().doubleValue());
		else
			qUpdate.setDouble(PROB_CACH_ENT, 0);
		if (pers.getPorc_sal()!=null)
			qUpdate.setDouble(PORC_SAL, pers.getPorc_sal().doubleValue());
		else
			qUpdate.setDouble(PORC_SAL, 0);
		if (pers.getProb_cach_sal()!=null)
			qUpdate.setDouble(PROB_CACH_SAL, pers.getProb_cach_sal().doubleValue());
		else
			qUpdate.setDouble(PROB_CACH_SAL, 0);
		qUpdate.setString(FILTRO_ESTADOS, pers.getFiltro_estados());
		qUpdate.setString(CODIGO , pers.getCodigo());
		qUpdate.setString(DESCRIPCION , pers.getDescripcion());
		qUpdate.setBoolean(LUNES, pers.isLunes());
		qUpdate.setBoolean(MARTES, pers.isMartes());
		qUpdate.setBoolean(MIERCOLES, pers.isMiercoles());
		qUpdate.setBoolean(JUEVES, pers.isJueves());
		qUpdate.setBoolean(VIERNES, pers.isViernes());
		qUpdate.setBoolean(SABADO, pers.isSabado());
		qUpdate.setBoolean(DOMINGO, pers.isDomingo());
		
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_ALGO_CACHEO = 1;
		AlgoritmoCacheo pers = (AlgoritmoCacheo) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cipAlgoCacheo " + " set activo=0 " + " where " + " oid_algo_cacheo=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_ALGO_CACHEO, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_ALGO_CACHEO = 1;
		AlgoritmoCacheo pers = (AlgoritmoCacheo) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cipAlgoCacheo " + " set activo=1 " + " where " + " oid_algo_cacheo=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_ALGO_CACHEO, pers.getOID());
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
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_ALGO_CACHEO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cipAlgoCacheo ");
		textSQL.append(" WHERE oid_algo_cacheo = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_ALGO_CACHEO, oid);
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cipAlgoCacheo ");
		textSQL.append(" WHERE codigo = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_algo_cacheo oid, codigo,  descripcion ,activo ");
		textSQL.append(" from cipAlgoCacheo");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

}
