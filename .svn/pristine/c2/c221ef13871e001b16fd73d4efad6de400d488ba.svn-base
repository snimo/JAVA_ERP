package com.srn.erp.cip.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.cip.bm.AvisoCIPMaquina;
import com.srn.erp.cip.bm.AvisoCIPUsuario;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;

public class DBAvisoCIPMaquina extends DBObjetoPersistente {

	public static final String OID_AVI_CAC_MAQ = "oid_avi_maq";
	public static final String OID_MAQUINA = "oid_maquina";
	public static final String OID_OBJ_NEG = "oid_obj_neg";
	public static final String CIRCUITO = "circuito";
	
	public static final int SELECT_OBJ_NEG_Y_CIC = 100;

	public DBAvisoCIPMaquina() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_AVI_CAC_MAQ = 1;
		final int OID_MAQUINA = 2;
		final int OID_OBJ_NEG = 3;
		final int CIRCUITO = 4;

		AvisoCIPMaquina pers = (AvisoCIPMaquina) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into cipAviMaq " + " ( " + "OID_AVI_MAQ," + "OID_MAQUINA," + "OID_OBJ_NEG," + "CIRCUITO)"
				+ " values " + "(" + "?," + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_AVI_CAC_MAQ, pers.getOID());
		qInsert.setInt(OID_MAQUINA, pers.getMaquina().getOID());
		qInsert.setInt(OID_OBJ_NEG, pers.getOid_obj_neg().intValue());
		qInsert.setString(CIRCUITO, pers.getCircuito());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_MAQUINA = 1;
		final int OID_OBJ_NEG = 2;
		final int CIRCUITO = 3;
		final int OID_AVI_CAC_MAQ = 4;

		AvisoCIPMaquina pers = (AvisoCIPMaquina) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update cipAviMaq set " + "oid_maquina=?" + ",oid_obj_neg=?" + ",circuito=?" + " where " + " oid_avi_maq=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_AVI_CAC_MAQ, pers.getOID());
		qUpdate.setInt(OID_MAQUINA, pers.getMaquina().getOID());
		qUpdate.setInt(OID_OBJ_NEG, pers.getOid_obj_neg().intValue());
		qUpdate.setString(CIRCUITO, pers.getCircuito());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_AVI_CAC_MAQ = 1;
		AvisoCIPMaquina pers = (AvisoCIPMaquina) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("delete from cipAviMaq where " + " oid_avi_maq=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_AVI_CAC_MAQ, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_AVI_CAC_MAQ = 1;
		AvisoCIPMaquina pers = (AvisoCIPMaquina) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cipAviMaq " + " set activo=1 " + " where " + " oid_avi_maq=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_AVI_CAC_MAQ, pers.getOID());
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

		final int OID_AVI_CAC_MAQ = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cipAviMaq ");
		textSQL.append(" WHERE oid_avi_maq = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_AVI_CAC_MAQ, oid);
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cipAviMaq ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_avi_maq oid, codigo,  descripcion ,activo ");
		textSQL.append(" from cipAviMaq");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}
	
	private PreparedStatement selectByObjNegCircuito(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cipAviMaq ");
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
		return (List) ObjetoLogico.getObjects(AvisoCIPMaquina.NICKNAME,
                 DBAvisoCIPMaquina.SELECT_OBJ_NEG_Y_CIC,
                 condiciones,
                 new ListObserver(),
                 aSesion);
	}	
	
	

}
