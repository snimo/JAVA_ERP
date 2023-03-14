package com.srn.erp.legales.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.legales.bm.AudienciaSeclo;
import com.srn.erp.legales.bm.Seclo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBAudienciaSeclo extends DBObjetoPersistente {

	public static final String OID_AUDIENCIA = "oid_audiencia";
	public static final String OID_SECLO = "oid_seclo";
	public static final String FECHA = "fecha";
	public static final String HORA = "Hora";
	public static final String DIRECCION = "direccion";
	public static final String CONCILIADOR = "conciliador";
	public static final String TELEFONOS = "telefonos";
	public static final String ACTIVO = "activo";

	public static final int SELECT_BY_SECLO = 100;

	public DBAudienciaSeclo() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_AUDIENCIA = 1;
		final int OID_SECLO = 2;
		final int FECHA = 3;
		final int HORA = 4;
		final int DIRECCION = 5;
		final int CONCILIADOR = 6;
		final int TELEFONOS = 7;
		final int ACTIVO = 8;

		AudienciaSeclo pers = (AudienciaSeclo) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into legAudiencias " + " ( " + "OID_AUDIENCIA," + "OID_SECLO," + "FECHA," + "HORA," + "DIRECCION," + "CONCILIADOR," + "TELEFONOS," + "ACTIVO)" + " values " + "("
				+ "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_AUDIENCIA, pers.getOID());
		qInsert.setInt(OID_SECLO, pers.getSeclo().getOID());
		qInsert.setDate(FECHA, new java.sql.Date(pers.getFecha().getTime()));
		qInsert.setString(HORA, pers.getHora());
		qInsert.setString(DIRECCION, pers.getDireccion());
		qInsert.setString(CONCILIADOR, pers.getConciliador());
		qInsert.setString(TELEFONOS, pers.getTelefonos());
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_SECLO = 1;
		final int FECHA = 2;
		final int HORA = 3;
		final int DIRECCION = 4;
		final int CONCILIADOR = 5;
		final int TELEFONOS = 6;
		final int ACTIVO = 7;
		final int OID_AUDIENCIA = 8;

		AudienciaSeclo pers = (AudienciaSeclo) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update legAudiencias set " + "oid_seclo=?" + ",fecha=?" + ",Hora=?" + ",direccion=?" + ",conciliador=?" + ",telefonos=?" + ",activo=?" + " where " + " oid_audiencia=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_AUDIENCIA, pers.getOID());
		qUpdate.setInt(OID_SECLO, pers.getSeclo().getOID());
		qUpdate.setDate(FECHA, new java.sql.Date(pers.getFecha().getTime()));
		qUpdate.setString(HORA, pers.getHora());
		qUpdate.setString(DIRECCION, pers.getDireccion());
		qUpdate.setString(CONCILIADOR, pers.getConciliador());
		qUpdate.setString(TELEFONOS, pers.getTelefonos());
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_AUDIENCIA = 1;
		AudienciaSeclo pers = (AudienciaSeclo) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update legAudiencias " + " set activo=0 " + " where " + " oid_audiencia=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_AUDIENCIA, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_AUDIENCIA = 1;
		AudienciaSeclo pers = (AudienciaSeclo) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update legAudiencias " + " set activo=1 " + " where " + " oid_audiencia=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_AUDIENCIA, pers.getOID());
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
		case SELECT_BY_SECLO: {
			ps = this.selectByLegajo(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_AUDIENCIA = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  legAudiencias ");
		textSQL.append(" WHERE oid_audiencia = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_AUDIENCIA, oid);
		return querySelect;
	}

	private PreparedStatement selectByLegajo(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  legAudiencias ");
		textSQL.append(" WHERE oid_seclo = ? and activo = 1 order by fecha desc ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		Seclo seclo = (Seclo) aCondiciones;
		querySelect.setInt(1, seclo.getOID());
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  legAudiencias ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_audiencia oid, codigo,  descripcion ,activo ");
		textSQL.append(" from legAudiencias");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static List getAudiencias(Seclo aSeclo, ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(AudienciaSeclo.NICKNAME, DBAudienciaSeclo.SELECT_BY_SECLO, aSeclo, new ListObserver(), aSesion);
	}

}
