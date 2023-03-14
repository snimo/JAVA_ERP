package com.srn.erp.general.da;

import java.sql.*;
import java.util.List;

import com.srn.erp.general.bm.*;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.*;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.*;

public class DBComentarioGeneral extends DBObjetoPersistente {

	public static final String	OID_COMEN_GRAL				= "oid_comen_gral";

	public static final String	OID_OBJETO						= "oid";

	public static final String	CLAVE									= "clave";

	public static final String	SECU									= "secu";

	public static final String	COMENTARIO						= "comentario";

	public static final int			SELECT_BY_CLAVE_Y_OID	= 100;

	public static final int			DELETE_BY_CLAVE_Y_OID	= 101;
	
	public static final int			INSERT_COMEN_BY_CLAVE_Y_OID	= 102;
	
	

	public DBComentarioGeneral() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_COMEN_GRAL = 1;
		final int OID = 2;
		final int CLAVE = 3;
		final int SECU = 4;
		final int COMENTARIO = 5;

		ComentarioGeneral pers = (ComentarioGeneral) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into geComenGenerales " + " ( " + "OID_COMEN_GRAL," + "OID," + "CLAVE," + "SECU,"
				+ "COMENTARIO)" + " values " + "(" + "?," + "?," + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_COMEN_GRAL, pers.getOID());
		qInsert.setInt(OID, pers.getOidObjeto().intValue());
		qInsert.setString(CLAVE, pers.getClave());
		qInsert.setInt(SECU, pers.getSecu().intValue());
		qInsert.setString(COMENTARIO, pers.getComentario());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID = 1;
		final int CLAVE = 2;
		final int SECU = 3;
		final int COMENTARIO = 4;
		final int OID_COMEN_GRAL = 5;

		ComentarioGeneral pers = (ComentarioGeneral) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update geComenGenerales set " + "oid=?" + ",clave=?" + ",secu=?" + ",comentario=?" + " where "
				+ " oid_comen_gral=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_COMEN_GRAL, pers.getOID());
		qUpdate.setInt(OID, pers.getOidObjeto().intValue());
		qUpdate.setString(CLAVE, pers.getClave());
		qUpdate.setInt(SECU, pers.getSecu().intValue());
		qUpdate.setString(COMENTARIO, pers.getComentario());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_COMEN_GRAL = 1;
		ComentarioGeneral pers = (ComentarioGeneral) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update geComenGenerales " + " set activo=0 " + " where " + " oid_comen_gral=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_COMEN_GRAL, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_COMEN_GRAL = 1;
		ComentarioGeneral pers = (ComentarioGeneral) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update geComenGenerales " + " set activo=1 " + " where " + " oid_comen_gral=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_COMEN_GRAL, pers.getOID());
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
		case SELECT_BY_CLAVE_Y_OID: {
			ps = this.selectByClaveyOid(aCondiciones);
			break;
		}
		case DELETE_BY_CLAVE_Y_OID: {
			ps = this.deleteByClaveyOid(aCondiciones);
			break;
		}
		case INSERT_COMEN_BY_CLAVE_Y_OID: {
			ps = this.insertComenByClaveyOid(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_COMEN_GRAL = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  geComenGenerales ");
		textSQL.append(" WHERE oid_comen_gral = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_COMEN_GRAL, oid);
		return querySelect;
	}

	private PreparedStatement selectByClaveyOid(Object aCondiciones) throws BaseException, SQLException {

		final int OID = 1;
		final int CLAVE = 2;

		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		Integer oid = (Integer) condiciones.get("OID");
		String clave = (String) condiciones.get("CLAVE");

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  geComenGenerales ");
		textSQL.append(" WHERE oid = ? and clave = ? order by secu ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		querySelect.setInt(OID, oid.intValue());
		querySelect.setString(CLAVE, clave);
		return querySelect;

	}
	
	
	
	private PreparedStatement insertComenByClaveyOid(Object aCondiciones) throws BaseException, SQLException {

		final int OID = 1;
		final int CLAVE = 2;

		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		Integer oid = (Integer) condiciones.get("OID");
		String clave = (String) condiciones.get("CLAVE");
		String comentario = (String) condiciones.get("COMENTARIO"); 

		
		
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("DELETE FROM  geComenGenerales ");
		textSQL.append(" WHERE oid = ? and clave = ?  ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		querySelect.setInt(OID, oid.intValue());
		querySelect.setString(CLAVE, clave);
		return querySelect;

	}
	

	private PreparedStatement deleteByClaveyOid(Object aCondiciones) throws BaseException, SQLException {

		final int OID = 1;
		final int CLAVE = 2;

		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		Integer oid = (Integer) condiciones.get("OID");
		String clave = (String) condiciones.get("CLAVE");

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("DELETE FROM  geComenGenerales ");
		textSQL.append(" WHERE oid = ? and clave = ?  ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		querySelect.setInt(OID, oid.intValue());
		querySelect.setString(CLAVE, clave);
		return querySelect;

	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  geComenGenerales ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_comen_gral oid, codigo,  descripcion ,activo ");
		textSQL.append(" from geComenGenerales");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static List getComentariosGeneral(Integer oid, String clave, ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put("OID", oid);
		condiciones.put("CLAVE", clave);
		return (List) ObjetoLogico.getObjects(ComentarioGeneral.NICKNAME, DBComentarioGeneral.SELECT_BY_CLAVE_Y_OID,
				condiciones, new ListObserver(), aSesion);
	}

	public static void borrarComentario(Integer oid, String clave, ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put("OID", oid);
		condiciones.put("CLAVE", clave);
		ObjetoLogico.executeQuery(ComentarioGeneral.NICKNAME, DBComentarioGeneral.DELETE_BY_CLAVE_Y_OID,condiciones, aSesion);
	}
	
	public static void agregarNuevoComentario(Integer oid, String clave, String comentario,ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put("OID", oid);
		condiciones.put("CLAVE", clave);
		condiciones.put("COMENTARIO", comentario);
		ObjetoLogico.getObjects(ComentarioGeneral.NICKNAME, 
				                    DBComentarioGeneral.INSERT_COMEN_BY_CLAVE_Y_OID,
				                    condiciones, 
				                    null, aSesion);
	}
	
	
	

}
