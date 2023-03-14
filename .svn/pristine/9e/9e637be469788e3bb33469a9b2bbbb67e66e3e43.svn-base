package com.srn.erp.legales.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.srn.erp.legales.bm.CompaniaSeguro;

import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class DBCompaniaSeguro extends DBObjetoPersistente {

	public static final String ID_COMP_SEG = "id_comp_seg";
	public static final String NOMBRE = "nombre";
	public static final String ES_CAUCION = "es_caucion";
	public static final String ACTIVO = "activo";
	
	public static final int SELECT_HELP_COMPANIAS_CAUCION = 20;

	public DBCompaniaSeguro() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int ID_COMP_SEG = 1;
		final int NOMBRE = 2;
		final int ES_CAUCION = 3;
		final int ACTIVO = 4;

		CompaniaSeguro pers = (CompaniaSeguro) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into legCompSeguro " + " ( " + "ID_COMP_SEG," + "NOMBRE," + "ES_CAUCION," + "ACTIVO)" + " values " + "(" + "?," + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(ID_COMP_SEG, pers.getOID());
		qInsert.setString(NOMBRE, pers.getNombre());
		qInsert.setBoolean(ES_CAUCION, pers.isEs_caucion().booleanValue());
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int NOMBRE = 1;
		final int ES_CAUCION = 2;
		final int ACTIVO = 3;
		final int ID_COMP_SEG = 4;

		CompaniaSeguro pers = (CompaniaSeguro) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update legCompSeguro set " + "nombre=?" + ",es_caucion=?" + ",activo=?" + " where " + " id_comp_seg=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(ID_COMP_SEG, pers.getOID());
		qUpdate.setString(NOMBRE, pers.getNombre());
		qUpdate.setBoolean(ES_CAUCION, pers.isEs_caucion().booleanValue());
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int ID_COMP_SEG = 1;
		CompaniaSeguro pers = (CompaniaSeguro) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update legCompSeguro " + " set activo=0 " + " where " + " id_comp_seg=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(ID_COMP_SEG, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int ID_COMP_SEG = 1;
		CompaniaSeguro pers = (CompaniaSeguro) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update legCompSeguro " + " set activo=1 " + " where " + " id_comp_seg=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(ID_COMP_SEG, pers.getOID());
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
		case SELECT_HELP_COMPANIAS_CAUCION: {
			ps = this.selectCompaniasCaucion(aCondiciones);
			break;			
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int ID_COMP_SEG = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  legCompSeguro ");
		textSQL.append(" WHERE id_comp_seg = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(ID_COMP_SEG, oid);
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  legCompSeguro ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT id_comp_seg oid, nombre codigo, nombre descripcion ,activo ");
		textSQL.append(" from legCompSeguro");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}
	
	private PreparedStatement selectCompaniasCaucion(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT id_comp_seg oid, nombre codigo, nombre descripcion ,activo ");
		textSQL.append(" from legCompSeguro where es_caucion = 1 ");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}	
	
	

}
