package com.srn.erp.cip.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.cip.bm.GrupoPuerta;
import com.srn.erp.cip.bm.GrupoPuertaDet;
import com.srn.erp.cip.bm.Puerta;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBGrupoPuertaDet extends DBObjetoPersistente {

	public static final String OID_GRUPO_DET = "oid_grupo_det";
	public static final String OID_GRUPO_PUERTA = "oid_grupo_puerta";
	public static final String OID_PUERTA = "oid_puerta";
	public static final String ACTIVO = "activo";

	public static final int SELECT_BY_GRUPO_PUERTA = 100;
	public static final int SELECT_BY_GRUPO_PUERA_Y_PUERTA = 101;

	public DBGrupoPuertaDet() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_GRUPO_DET = 1;
		final int OID_GRUPO_PUERTA = 2;
		final int OID_PUERTA = 3;
		final int ACTIVO = 4;

		GrupoPuertaDet pers = (GrupoPuertaDet) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into cipGrupoPuertasDet " + " ( " + "OID_GRUPO_DET," + "OID_GRUPO_PUERTA," + "OID_PUERTA," + "ACTIVO)"
				+ " values " + "(" + "?," + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_GRUPO_DET, pers.getOID());
		qInsert.setInt(OID_GRUPO_PUERTA, pers.getGrupo_puertas().getOID());
		qInsert.setInt(OID_PUERTA, pers.getPuerta().getOID());
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_GRUPO_PUERTA = 1;
		final int OID_PUERTA = 2;
		final int ACTIVO = 3;
		final int OID_GRUPO_DET = 4;

		GrupoPuertaDet pers = (GrupoPuertaDet) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update cipGrupoPuertasDet set " + "oid_grupo_puerta=?" + ",oid_puerta=?" + ",activo=?" + " where "
				+ " oid_grupo_det=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_GRUPO_DET, pers.getOID());
		qUpdate.setInt(OID_GRUPO_PUERTA, pers.getGrupo_puertas().getOID());
		qUpdate.setInt(OID_PUERTA, pers.getPuerta().getOID());
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_GRUPO_DET = 1;
		GrupoPuertaDet pers = (GrupoPuertaDet) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cipGrupoPuertasDet " + " set activo=0 " + " where " + " oid_grupo_det=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_GRUPO_DET, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_GRUPO_DET = 1;
		GrupoPuertaDet pers = (GrupoPuertaDet) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cipGrupoPuertasDet " + " set activo=1 " + " where " + " oid_grupo_det=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_GRUPO_DET, pers.getOID());
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
		case SELECT_BY_GRUPO_PUERTA: {
			ps = this.selectByGrupoPuertaDet(aCondiciones);
			break;
		}
		case SELECT_BY_GRUPO_PUERA_Y_PUERTA: {
			ps = this.selectByGrupoPuertayPuerta(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_GRUPO_DET = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cipGrupoPuertasDet ");
		textSQL.append(" WHERE oid_grupo_det = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_GRUPO_DET, oid);
		return querySelect;
	}

	private PreparedStatement selectByGrupoPuertayPuerta(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cipGrupoPuertasDet ");
		textSQL.append(" WHERE oid_grupo_puerta = ? and oid_puerta=? and activo=1 ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());

		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		GrupoPuerta grupoPuerta = (GrupoPuerta) condiciones.get(GrupoPuerta.NICKNAME);
		Puerta puerta = (Puerta) condiciones.get(Puerta.NICKNAME);
		querySelect.setInt(1, grupoPuerta.getOID());
		querySelect.setInt(2, puerta.getOID());
		return querySelect;
	}

	private PreparedStatement selectByGrupoPuertaDet(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cipGrupoPuertasDet ");
		textSQL.append(" WHERE oid_grupo_puerta = ? and activo=1 ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		GrupoPuerta grupoPuerta = (GrupoPuerta) aCondiciones;
		querySelect.setInt(1, grupoPuerta.getOID());
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cipGrupoPuertasDet ");
		textSQL.append(" WHERE oid_grupo_puerta = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_grupo_det oid,oid_grupo_puerta codigo, oid_puerta descripcion ,activo ");
		textSQL.append(" from cipGrupoPuertasDet");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static List getGrupoPuertasDet(GrupoPuerta grupoPuerta, ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(GrupoPuertaDet.NICKNAME, DBGrupoPuertaDet.SELECT_BY_GRUPO_PUERTA, grupoPuerta,
				new ListObserver(), aSesion);
	}

	public static GrupoPuertaDet getGrupoPuertaDet(GrupoPuerta grupoPuerta, Puerta puerta, ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(GrupoPuerta.NICKNAME, grupoPuerta);
		condiciones.put(Puerta.NICKNAME, puerta);
		return (GrupoPuertaDet) ObjetoLogico.getObjects(GrupoPuertaDet.NICKNAME, DBGrupoPuertaDet.SELECT_BY_GRUPO_PUERA_Y_PUERTA,
				condiciones, new ObjetoObservado(), aSesion);
	}

}
