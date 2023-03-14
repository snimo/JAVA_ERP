package com.srn.erp.compras.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.compras.bm.RolAutorizadorCompras;
import com.srn.erp.compras.bm.UsuarioRolAutorizadorCompras;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBUsuarioRolAutorizadorCompras extends DBObjetoPersistente {

	public static final String OID_USU_AUTORIZ = "oid_usu_autoriz";

	public static final String OID_ROL_AUTORIZ = "oid_rol_autoriz";

	public static final String OID_USUARIO = "oid_usuario";

	public static final int SELECT_BY_ROL_AUTORIZ = 100;
	public static final int SELECT_BY_ROL_USUARIO = 101;

	public DBUsuarioRolAutorizadorCompras() {
	}

	protected void insert(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {

		final int OID_USU_AUTORIZ = 1;
		final int OID_ROL_AUTORIZ = 2;
		final int OID_USUARIO = 3;

		UsuarioRolAutorizadorCompras pers = (UsuarioRolAutorizadorCompras) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into cpUsuRolAutoriz " + " ( "
				+ "OID_USU_AUTORIZ," + "OID_ROL_AUTORIZ," + "OID_USUARIO)"
				+ " values " + "(" + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD()
				.prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_USU_AUTORIZ, pers.getOID());
		qInsert.setInt(OID_ROL_AUTORIZ, pers.getRol_autorizador().getOID());
		qInsert.setInt(OID_USUARIO, pers.getUsuario().getOID());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {

		final int OID_ROL_AUTORIZ = 1;
		final int OID_USUARIO = 2;
		final int OID_USU_AUTORIZ = 3;

		UsuarioRolAutorizadorCompras pers = (UsuarioRolAutorizadorCompras) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update cpUsuRolAutoriz set " + "oid_rol_autoriz=?"
				+ ",oid_usuario=?" + " where " + " oid_usu_autoriz=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_USU_AUTORIZ, pers.getOID());
		qUpdate.setInt(OID_ROL_AUTORIZ, pers.getRol_autorizador().getOID());
		qUpdate.setInt(OID_USUARIO, pers.getUsuario().getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {
		final int OID_USU_AUTORIZ = 1;
		UsuarioRolAutorizadorCompras pers = (UsuarioRolAutorizadorCompras) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("delete from cpUsuRolAutoriz "
				+ " where " + " oid_usu_autoriz=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_USU_AUTORIZ, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {
		final int OID_USU_AUTORIZ = 1;
		UsuarioRolAutorizadorCompras pers = (UsuarioRolAutorizadorCompras) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cpUsuRolAutoriz " + " set activo=1 "
				+ " where " + " oid_usu_autoriz=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_USU_AUTORIZ, pers.getOID());
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
		case SELECT_BY_ROL_AUTORIZ: {
			ps = this.selectByRolAutoriz(aCondiciones);
			break;
		}
		case SELECT_BY_ROL_USUARIO: {
			ps = this.selectByRolUsuario(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones)
			throws BaseException, SQLException {

		final int OID_USU_AUTORIZ = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cpUsuRolAutoriz ");
		textSQL.append(" WHERE oid_usu_autoriz = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_USU_AUTORIZ, oid);
		return querySelect;
	}

	private PreparedStatement selectByRolAutoriz(Object aCondiciones)
			throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cpUsuRolAutoriz ");
		textSQL.append(" WHERE oid_rol_autoriz  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		RolAutorizadorCompras rolAutorizadorCompras = (RolAutorizadorCompras) aCondiciones;
		querySelect.setInt(1, rolAutorizadorCompras.getOID());
		return querySelect;
	}
	
	private PreparedStatement selectByRolUsuario(Object aCondiciones)
	throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cpUsuRolAutoriz ");
		textSQL.append(" WHERE oid_usuario  = ?  and oid_rol_autoriz = ? ");
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		Usuario usuario = (Usuario)condiciones.get(Usuario.NICKNAME);
		RolAutorizadorCompras rol = (RolAutorizadorCompras) condiciones.get(RolAutorizadorCompras.NICKNAME);
		PreparedStatement querySelect = getSesion().getConexionBD()
		.prepareStatement(textSQL.toString());
		querySelect.setInt(1, usuario.getOID());
		querySelect.setInt(2, rol.getOID());
		return querySelect;
	}	

	private PreparedStatement selectByCodigo(Object aCondiciones)
			throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cpUsuRolAutoriz ");
		textSQL.append(" WHERE  = ? ");
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
				.append("SELECT oid_usu_autoriz oid, codigo,  descripcion ,activo ");
		textSQL.append(" from cpUsuRolAutoriz");

		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static List getUsuariosRol(RolAutorizadorCompras rolAutorizador, ISesion aSesion)
			throws BaseException {
		return (List) ObjetoLogico.getObjects(UsuarioRolAutorizadorCompras.NICKNAME,
				DBUsuarioRolAutorizadorCompras.SELECT_BY_ROL_AUTORIZ, rolAutorizador,
				new ListObserver(), aSesion);
	}
	
	public static UsuarioRolAutorizadorCompras getUsuarioRol(Usuario usuario,RolAutorizadorCompras rol,
              	ISesion aSesion)
              	throws BaseException {
		  HashTableDatos condiciones = new HashTableDatos();
		  condiciones.put(Usuario.NICKNAME,usuario);
		  condiciones.put(RolAutorizadorCompras.NICKNAME,rol);
		  return (UsuarioRolAutorizadorCompras) ObjetoLogico.getObjects(UsuarioRolAutorizadorCompras.NICKNAME,
				  DBUsuarioRolAutorizadorCompras.SELECT_BY_ROL_USUARIO,
				  condiciones,
				  new ObjetoObservado(),
				  aSesion);
   }	

}
