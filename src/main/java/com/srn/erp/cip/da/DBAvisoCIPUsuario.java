package com.srn.erp.cip.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.cip.bm.AvisoCIPUsuario;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;

public class DBAvisoCIPUsuario extends DBObjetoPersistente {

	public static final String OID_AVI_CAC_USU = "oid_avi_usu";
	public static final String OID_USUARIO = "oid_usuario";
	public static final String OID_OBJ_NEG = "oid_obj_neg";
	public static final String CIRCUITO = "circuito";
	
	public static final int SELECT_OBJ_NEG_Y_CIC = 100;

	public DBAvisoCIPUsuario() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_AVI_CAC_USU = 1;
		final int OID_USUARIO = 2;
		final int OID_OBJ_NEG = 3;
		final int CIRCUITO = 4;

		AvisoCIPUsuario pers = (AvisoCIPUsuario) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into cipAviUsu " + " ( " + "OID_AVI_USU," + "OID_USUARIO," + "OID_OBJ_NEG," + "CIRCUITO)"
				+ " values " + "(" + "?," + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_AVI_CAC_USU, pers.getOID());
		qInsert.setInt(OID_USUARIO, pers.getUsuario().getOID());
		qInsert.setInt(OID_OBJ_NEG, pers.getOid_obj_neg().intValue());
		qInsert.setString(CIRCUITO, pers.getCircuito());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_USUARIO = 1;
		final int OID_OBJ_NEG = 2;
		final int CIRCUITO = 3;
		final int OID_AVI_CAC_USU = 4;

		AvisoCIPUsuario pers = (AvisoCIPUsuario) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update cipAviUsu set " + "oid_usuario=?" + ",oid_obj_neg=?" + ",circuito=?" + " where " + " oid_avi_usu=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_AVI_CAC_USU, pers.getOID());
		qUpdate.setInt(OID_USUARIO, pers.getUsuario().getOID());
		qUpdate.setInt(OID_OBJ_NEG, pers.getOid_obj_neg().intValue());
		qUpdate.setString(CIRCUITO, pers.getCircuito());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_AVI_CAC_USU = 1;
		AvisoCIPUsuario pers = (AvisoCIPUsuario) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("delete from cipAviUsu where " + " oid_avi_usu=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_AVI_CAC_USU, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_AVI_CAC_USU = 1;
		AvisoCIPUsuario pers = (AvisoCIPUsuario) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cipAviUsu " + " set activo=1 " + " where " + " oid_avi_usu=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_AVI_CAC_USU, pers.getOID());
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
		case SELECT_OBJ_NEG_Y_CIC: {
			ps = this.selectByObjNegCircuito(aCondiciones);
			break;
		}		
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_AVI_CAC_USU = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cipAviUsu ");
		textSQL.append(" WHERE oid_avi_usu = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_AVI_CAC_USU, oid);
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cipAviUsu ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_avi_usu oid, codigo,  descripcion ,activo ");
		textSQL.append(" from cipAviUsu");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}
	
	private PreparedStatement selectByObjNegCircuito(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cipAviUsu ");
		textSQL.append(" WHERE oid_obj_neg = ? and circuito = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		Integer oidObjNeg = (Integer) condiciones.get("OID_OBJ_NEG");
		String circuito = (String) condiciones.get("CIRCUITO");
		querySelect.setInt(1, oidObjNeg.intValue());
		querySelect.setString(2, circuito);
		return querySelect;
	}
	

	public static List getAvisos(Integer oidObjNeg,String circuito,ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put("OID_OBJ_NEG", oidObjNeg);
		condiciones.put("CIRCUITO", circuito);
		return (List) ObjetoLogico.getObjects(AvisoCIPUsuario.NICKNAME,
                 DBAvisoCIPUsuario.SELECT_OBJ_NEG_Y_CIC,
                 condiciones,
                 new ListObserver(),
                 aSesion);
	}	
	
}
