package com.srn.erp.general.da;

import java.sql.*;
import java.util.List;

import com.srn.erp.general.bm.*;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.*;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.*;

public class DBEntidad extends DBObjetoPersistente {

	public static final String	OID_ENTIDAD					= "oid_entidad";

	public static final String	CODIGO							= "codigo";

	public static final String	DESCRIPCION					= "descripcion";

	public static final String	NOMBRE_NICKNAME			= "nombre_nickname";

	public static final String	ACTIVO							= "activo";
	
	public static final String	ES_COMPROBANTE		  = "es_comprobante";

	public static final int			SELECT_BY_NICKNAME	= 100;
	public static final int 		SELECT_BY_HELP_ES_COMPRO = 101;

	public DBEntidad() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_ENTIDAD = 1;
		final int CODIGO = 2;
		final int DESCRIPCION = 3;
		final int NOMBRE_NICKNAME = 4;
		final int ACTIVO = 5;
		final int ES_COMPROBANTE = 6;

		Entidad pers = (Entidad) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into geEntidad " + " ( " + "OID_ENTIDAD," + "CODIGO," + "DESCRIPCION,"
				+ "NOMBRE_NICKNAME," + "ACTIVO , ES_COMPROBANTE)" + " values " + "(" + "?,"+ "?," + "?," + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_ENTIDAD, pers.getOID());
		qInsert.setString(CODIGO, pers.getCodigo());
		qInsert.setString(DESCRIPCION, pers.getDescripcion());
		qInsert.setString(NOMBRE_NICKNAME, pers.getNombre_nickname());
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qInsert.setBoolean(ES_COMPROBANTE, pers.isComprobante().booleanValue());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int CODIGO = 1;
		final int DESCRIPCION = 2;
		final int NOMBRE_NICKNAME = 3;
		final int ACTIVO = 4;
		final int ES_COMPROBANTE = 5;
		final int OID_ENTIDAD = 6;

		Entidad pers = (Entidad) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update geEntidad set " + "codigo=?" + ",descripcion=?" + ",nombre_nickname=?" + ",activo=?" + ",es_comprobante=?"
				+ " where " + " oid_entidad=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_ENTIDAD, pers.getOID());
		qUpdate.setString(CODIGO, pers.getCodigo());
		qUpdate.setString(DESCRIPCION, pers.getDescripcion());
		qUpdate.setString(NOMBRE_NICKNAME, pers.getNombre_nickname());
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qUpdate.setBoolean(ES_COMPROBANTE, pers.isComprobante().booleanValue());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_ENTIDAD = 1;
		Entidad pers = (Entidad) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update geEntidad " + " set activo=0 " + " where " + " oid_entidad=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_ENTIDAD, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_ENTIDAD = 1;
		Entidad pers = (Entidad) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update geEntidad " + " set activo=1 " + " where " + " oid_entidad=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_ENTIDAD, pers.getOID());
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
		case SELECT_BY_NICKNAME: {
			ps = this.selectByNickName(aCondiciones);
			break;
		}
		case SELECT_BY_HELP_ES_COMPRO: {
			ps = this.selectByHelpEsComprobante(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_ENTIDAD = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  geEntidad ");
		textSQL.append(" WHERE oid_entidad = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_ENTIDAD, oid);
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  geEntidad ");
		textSQL.append(" WHERE codigo = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}
	
	private PreparedStatement selectByHelpEsComprobante(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT oid_entidad oid,codigo,descripcion, activo FROM  geEntidad ");
		textSQL.append(" WHERE es_comprobante = 1 ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
		
	}
	
	
	

	private PreparedStatement selectByNickName(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  geEntidad ");
		textSQL.append(" WHERE nombre_nickname = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String nombreNickName = (String) aCondiciones;
		querySelect.setString(1, nombreNickName);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_entidad oid,codigo codigo, descripcion descripcion ,activo ");
		textSQL.append(" from geEntidad");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static Entidad getEntidad(String nickName, ISesion aSesion) throws BaseException {
		return (Entidad) ObjetoLogico.getObjects(Entidad.NICKNAME, DBEntidad.SELECT_BY_NICKNAME,nickName,
				new ObjetoObservado(), aSesion);
	}
	
	

}
