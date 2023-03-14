package com.srn.erp.mensajero.da;

import java.sql.*;
import com.srn.erp.mensajero.bm.*;
import framework.applicarionServer.bl.Persistencia.*;
import framework.request.bl.Utils.*;

public class DBMensajeCab extends DBObjetoPersistente {

	public static final String OID_MENS_CAB = "oid_mens_cab";
	public static final String IDENTIFICADOR = "identificador";
	public static final String ASUNTO = "asunto";
	public static final String CUERPO = "cuerpo";
	public static final String OID_USUARIO = "oid_usuario";
	public static final String FEC_ENVIO = "fec_envio";
	public static final String HOR_ENVIO = "hor_envio";
	public static final String ENVIAR_MAIL = "enviar_mail";
	public static final String IMPORTANCIA = "importancia";
	public static final String SOLICITAR_CONF_LEC = "solicitar_conf_lec";
	public static final String ACTIVO = "activo";
	public static final String ENVIAR_POP_UP = "enviar_pop_up";
	public static final String DUR_SEG_POP_UP = "dur_seg_pop_up";
	public static final String ENVIAR_MENS_INT = "enviar_mens_int";
	public static final String ENVIAR_CHAT = "enviar_chat";
	public static final String SEND_TO_ALL_CONNEC = "send_to_all_connec";

	public DBMensajeCab() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_MENS_CAB = 1;
		final int IDENTIFICADOR = 2;
		final int ASUNTO = 3;
		final int CUERPO = 4;
		final int OID_USUARIO = 5;
		final int FEC_ENVIO = 6;
		final int HOR_ENVIO = 7;
		final int ENVIAR_MAIL = 8;
		final int IMPORTANCIA = 9;
		final int SOLICITAR_CONF_LEC = 10;
		final int ACTIVO = 11;
		final int ENVIAR_POP_UP = 12;
		final int DUR_SEG_POP_UP = 13;
		final int ENVIAR_MENS_INT = 14;
		final int ENVIAR_CHAT = 15;
		final int SEND_TO_ALL_CONNEC = 16;

		MensajeCab pers = (MensajeCab) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into meMensajeCab " + " ( " + "OID_MENS_CAB," + "IDENTIFICADOR," + "ASUNTO," + "CUERPO," + "OID_USUARIO,"
				+ "FEC_ENVIO," + "HOR_ENVIO," + "ENVIAR_MAIL," + "IMPORTANCIA," + "SOLICITAR_CONF_LEC," + "ACTIVO," + "ENVIAR_POP_UP,"
				+ "DUR_SEG_POP_UP," + "ENVIAR_MENS_INT," + "ENVIAR_CHAT," + "SEND_TO_ALL_CONNEC)" + " values " + "(" + "?," + "?," + "?,"
				+ "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_MENS_CAB, pers.getOID());
		qInsert.setString(IDENTIFICADOR, pers.getIdentificador());
		qInsert.setString(ASUNTO, pers.getAsunto());
		qInsert.setString(CUERPO, pers.getCuerpo());
		if (pers.getUsuario() != null)
			qInsert.setInt(OID_USUARIO, pers.getUsuario().getOID());
		else
			qInsert.setNull(OID_USUARIO, java.sql.Types.INTEGER);
		qInsert.setDate(FEC_ENVIO,new java.sql.Date(pers.getFec_envio().getTime()));
		qInsert.setString(HOR_ENVIO, pers.getHor_envio());
		qInsert.setBoolean(ENVIAR_MAIL, pers.isEnviar_mail().booleanValue());
		qInsert.setString(IMPORTANCIA, pers.getImportancia());
		qInsert.setBoolean(SOLICITAR_CONF_LEC, pers.isSolicitar_conf_lec().booleanValue());
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qInsert.setBoolean(ENVIAR_POP_UP, pers.isEnviar_pop_up().booleanValue());
		qInsert.setInt(DUR_SEG_POP_UP, pers.getDur_seg_pop_up().intValue());
		qInsert.setBoolean(ENVIAR_MENS_INT, pers.isEnviar_mens_int().booleanValue());
		qInsert.setBoolean(ENVIAR_CHAT, pers.isEnviar_chat().booleanValue());
		qInsert.setBoolean(SEND_TO_ALL_CONNEC, pers.isSend_to_all_connec().booleanValue());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int IDENTIFICADOR = 1;
		final int ASUNTO = 2;
		final int CUERPO = 3;
		final int OID_USUARIO = 4;
		final int FEC_ENVIO = 5;
		final int HOR_ENVIO = 6;
		final int ENVIAR_MAIL = 7;
		final int IMPORTANCIA = 8;
		final int SOLICITAR_CONF_LEC = 9;
		final int ACTIVO = 10;
		final int ENVIAR_POP_UP = 11;
		final int DUR_SEG_POP_UP = 12;
		final int ENVIAR_MENS_INT = 13;
		final int ENVIAR_CHAT = 14;
		final int SEND_TO_ALL_CONNEC = 15;
		final int OID_MENS_CAB = 16;

		MensajeCab pers = (MensajeCab) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update meMensajeCab set " + "identificador=?" + ",asunto=?" + ",cuerpo=?" + ",oid_usuario=?" + ",fec_envio=?"
				+ ",hor_envio=?" + ",enviar_mail=?" + ",importancia=?" + ",solicitar_conf_lec=?" + ",activo=?" + ",enviar_pop_up=?"
				+ ",dur_seg_pop_up=?" + ",enviar_mens_int=?" + ",enviar_chat=?" + ",send_to_all_connec=?" + " where " + " oid_mens_cab=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_MENS_CAB, pers.getOID());
		qUpdate.setString(IDENTIFICADOR, pers.getIdentificador());
		qUpdate.setString(ASUNTO, pers.getAsunto());
		qUpdate.setString(CUERPO, pers.getCuerpo());
		if (pers.getUsuario() != null)
			qUpdate.setInt(OID_USUARIO, pers.getUsuario().getOID());
		else
			qUpdate.setNull(OID_USUARIO, java.sql.Types.INTEGER);
		qUpdate.setDate(FEC_ENVIO, new java.sql.Date(pers.getFec_envio().getTime()));
		qUpdate.setString(HOR_ENVIO, pers.getHor_envio());
		qUpdate.setBoolean(ENVIAR_MAIL, pers.isEnviar_mail().booleanValue());
		qUpdate.setString(IMPORTANCIA, pers.getImportancia());
		qUpdate.setBoolean(SOLICITAR_CONF_LEC, pers.isSolicitar_conf_lec().booleanValue());
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qUpdate.setBoolean(ENVIAR_POP_UP, pers.isEnviar_pop_up().booleanValue());
		qUpdate.setInt(DUR_SEG_POP_UP, pers.getDur_seg_pop_up().intValue());
		qUpdate.setBoolean(ENVIAR_MENS_INT, pers.isEnviar_mens_int().booleanValue());
		qUpdate.setBoolean(ENVIAR_CHAT, pers.isEnviar_chat().booleanValue());
		qUpdate.setBoolean(SEND_TO_ALL_CONNEC, pers.isSend_to_all_connec().booleanValue());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_MENS_CAB = 1;
		MensajeCab pers = (MensajeCab) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update meMensajeCab " + " set activo=0 " + " where " + " oid_mens_cab=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_MENS_CAB, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_MENS_CAB = 1;
		MensajeCab pers = (MensajeCab) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update meMensajeCab " + " set activo=1 " + " where " + " oid_mens_cab=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_MENS_CAB, pers.getOID());
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

		final int OID_MENS_CAB = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  meMensajeCab ");
		textSQL.append(" WHERE oid_mens_cab = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_MENS_CAB, oid);
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  meMensajeCab ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_mens_cab oid, codigo,  descripcion ,activo ");
		textSQL.append(" from meMensajeCab");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

}
