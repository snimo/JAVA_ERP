package com.srn.erp.legales.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import com.srn.erp.legales.bm.Abogado;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBAbogado extends DBObjetoPersistente {

	public static final String OID_ABOGADO = "oid_abogado";
	public static final String APELLIDO = "apellido";
	public static final String NOMBRE = "nombre";
	public static final String TELEFONOS = "telefonos";
	public static final String MAIL = "mail";
	public static final String DIRECCION = "direccion";
	public static final String ESTUDIO = "estudio";
	public static final String ACTIVO = "activo";
	public static final String CUIT = "cuit";

	public static final int SELECT_BY_APELLIDO_NOMBRE = 100;

	public DBAbogado() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_ABOGADO = 1;
		final int APELLIDO = 2;
		final int NOMBRE = 3;
		final int TELEFONOS = 4;
		final int MAIL = 5;
		final int DIRECCION = 6;
		final int ESTUDIO = 7;
		final int ACTIVO = 8;
		final int CUIT = 9;

		Abogado pers = (Abogado) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into legAbogado " + " ( " + "OID_ABOGADO," + "APELLIDO," + "NOMBRE," + "TELEFONOS," + "MAIL," + "DIRECCION," + "ESTUDIO," + "ACTIVO , CUIT)" + " values " + "("
				+ "?," + "?," + "?," + "?," + "?," + "?," + "?," + "? , ?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_ABOGADO, pers.getOID());
		if (pers.getApellido() != null)
			qInsert.setString(APELLIDO, pers.getApellido());
		else
			qInsert.setNull(APELLIDO, Types.VARCHAR);
		if (pers.getNombre() != null)
			qInsert.setString(NOMBRE, pers.getNombre());
		else
			qInsert.setNull(NOMBRE, Types.VARCHAR);
		if (pers.getTelefonos() != null)
			qInsert.setString(TELEFONOS, pers.getTelefonos());
		else
			qInsert.setNull(TELEFONOS, Types.VARCHAR);
		if (pers.getMail() != null)
			qInsert.setString(MAIL, pers.getMail());
		else
			qInsert.setNull(MAIL, Types.VARCHAR);
		if (pers.getDireccion() != null)
			qInsert.setString(DIRECCION, pers.getDireccion());
		else
			qInsert.setNull(DIRECCION, Types.VARCHAR);
		if (pers.getEstudio() != null)
			qInsert.setString(ESTUDIO, pers.getEstudio());
		else
			qInsert.setNull(ESTUDIO, Types.VARCHAR);
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		if (pers.getCUIT() != null)
			qInsert.setString(CUIT, pers.getCUIT());
		else
			qInsert.setNull(CUIT, Types.VARCHAR);
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int APELLIDO = 1;
		final int NOMBRE = 2;
		final int TELEFONOS = 3;
		final int MAIL = 4;
		final int DIRECCION = 5;
		final int ESTUDIO = 6;
		final int ACTIVO = 7;
		final int CUIT = 8;
		final int OID_ABOGADO = 9;

		Abogado pers = (Abogado) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update legAbogado set " + "apellido=?" + ",nombre=?" + ",telefonos=?" + ",mail=?" + ",direccion=?" + ",estudio=?" + ",activo=? , cuit = ? " + " where " + " oid_abogado=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_ABOGADO, pers.getOID());
		if (pers.getApellido() != null)
			qUpdate.setString(APELLIDO, pers.getApellido());
		else
			qUpdate.setNull(APELLIDO, Types.VARCHAR);
		if (pers.getNombre() != null)
			qUpdate.setString(NOMBRE, pers.getNombre());
		else
			qUpdate.setNull(NOMBRE, Types.VARCHAR);
		if (pers.getTelefonos() != null)
			qUpdate.setString(TELEFONOS, pers.getTelefonos());
		else
			qUpdate.setNull(TELEFONOS, Types.VARCHAR);
		if (pers.getMail() != null)
			qUpdate.setString(MAIL, pers.getMail());
		else
			qUpdate.setNull(MAIL, Types.VARCHAR);
		if (pers.getDireccion() != null)
			qUpdate.setString(DIRECCION, pers.getDireccion());
		else
			qUpdate.setNull(DIRECCION, Types.VARCHAR);
		if (pers.getEstudio() != null)
			qUpdate.setString(ESTUDIO, pers.getEstudio());
		else
			qUpdate.setNull(ESTUDIO, Types.VARCHAR);
		if (pers.getCUIT() != null)
			qUpdate.setString(CUIT, pers.getCUIT());
		else
			qUpdate.setNull(CUIT, Types.VARCHAR);
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_ABOGADO = 1;
		Abogado pers = (Abogado) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update legAbogado " + " set activo=0 " + " where " + " oid_abogado=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_ABOGADO, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_ABOGADO = 1;
		Abogado pers = (Abogado) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update legAbogado " + " set activo=1 " + " where " + " oid_abogado=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_ABOGADO, pers.getOID());
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
		case SELECT_BY_APELLIDO_NOMBRE: {
			ps = this.selectByApellidoNombre(aCondiciones);
			break;
		}
		case SELECT_ALL: {
			ps = this.selectAll(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_ABOGADO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  legAbogado ");
		textSQL.append(" WHERE oid_abogado = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_ABOGADO, oid);
		return querySelect;
	}

	private PreparedStatement selectAll(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  legAbogado ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	private PreparedStatement selectByApellidoNombre(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  legAbogado ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append(" select * from legabogado where apellido||' '||nombre = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(1, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_abogado oid, apellido||' '||nombre descripcion , ' ' codigo , activo ");
		textSQL.append(" from legAbogado");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static List getAll(ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(Abogado.NICKNAME, DBAbogado.SELECT_ALL, null, new ListObserver(), aSesion);
	}

}
