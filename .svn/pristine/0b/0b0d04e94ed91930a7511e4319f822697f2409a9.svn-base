package com.srn.erp.mensajero.da;

import java.sql.*;
import java.util.List;

import com.srn.erp.general.bm.PeriodoInc;
import com.srn.erp.general.bm.PeriodoIncDet;
import com.srn.erp.general.da.DBPeriodoIncDet;
import com.srn.erp.mensajero.bm.*;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.*;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.*;

public class DBDestinoMens extends DBObjetoPersistente {

	public static final String OID_MENS_DEST = "oid_mens_dest";
	public static final String OID_MENS_CAB = "oid_mens_cab";
	public static final String OID_GRUPO_DEST_CAB = "oid_grupo_dest_cab";
	public static final String OID_GRUPO_MAQ = "oid_grupo_maq";
	public static final String OID_MAQUINA = "oid_maquina";
	public static final String OID_USUARIO = "oid_usuario";
	public static final String MAIL = "mail";
	public static final String ACTIVO = "activo";

	public static final int SELECT_BY_MENS_CAB = 100;

	public DBDestinoMens() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_MENS_DEST = 1;
		final int OID_MENS_CAB = 2;
		final int OID_GRUPO_DEST_CAB = 3;
		final int OID_GRUPO_MAQ = 4;
		final int OID_MAQUINA = 5;
		final int OID_USUARIO = 6;
		final int MAIL = 7;
		final int ACTIVO = 8;

		DestinoMens pers = (DestinoMens) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into meMensajeDest " + " ( " + "OID_MENS_DEST," + "OID_MENS_CAB," + "OID_GRUPO_DEST_CAB,"
				+ "OID_GRUPO_MAQ," + "OID_MAQUINA," + "OID_USUARIO," + "MAIL," + "ACTIVO)" + " values " + "(" + "?," + "?," + "?," + "?,"
				+ "?," + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_MENS_DEST, pers.getOID());
		if (pers.getMensaje() != null)
			qInsert.setInt(OID_MENS_CAB, pers.getMensaje().getOID());
		else
			qInsert.setNull(OID_MENS_CAB, java.sql.Types.INTEGER);
		if (pers.getGrupo_dest_cab() != null)
			qInsert.setInt(OID_GRUPO_DEST_CAB, pers.getGrupo_dest_cab().getOID());
		else
			qInsert.setNull(OID_GRUPO_DEST_CAB, java.sql.Types.INTEGER);
		if (pers.getGrupo_maquina() != null)
			qInsert.setInt(OID_GRUPO_MAQ, pers.getGrupo_maquina().getOID());
		else
			qInsert.setNull(OID_GRUPO_MAQ, java.sql.Types.INTEGER);
		if (pers.getMaquina() != null)
			qInsert.setInt(OID_MAQUINA, pers.getMaquina().getOID());
		else
			qInsert.setNull(OID_MAQUINA, java.sql.Types.INTEGER);
		if (pers.getUsuario() != null)
			qInsert.setInt(OID_USUARIO, pers.getUsuario().getOID());
		else
			qInsert.setNull(OID_USUARIO, java.sql.Types.INTEGER);
		qInsert.setString(MAIL, pers.getMail());
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_MENS_CAB = 1;
		final int OID_GRUPO_DEST_CAB = 2;
		final int OID_GRUPO_MAQ = 3;
		final int OID_MAQUINA = 4;
		final int OID_USUARIO = 5;
		final int MAIL = 6;
		final int ACTIVO = 7;
		final int OID_MENS_DEST = 8;

		DestinoMens pers = (DestinoMens) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update meMensajeDest set " + "oid_mens_cab=?" + ",oid_grupo_dest_cab=?" + ",oid_grupo_maq=?" + ",oid_maquina=?"
				+ ",oid_usuario=?" + ",mail=?" + ",activo=?" + " where " + " oid_mens_dest=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_MENS_DEST, pers.getOID());
		if (pers.getMensaje() != null)
			qUpdate.setInt(OID_MENS_CAB, pers.getMensaje().getOID());
		else
			qUpdate.setNull(OID_MENS_CAB, java.sql.Types.INTEGER);
		if (pers.getGrupo_dest_cab() != null)
			qUpdate.setInt(OID_GRUPO_DEST_CAB, pers.getGrupo_dest_cab().getOID());
		else
			qUpdate.setNull(OID_GRUPO_DEST_CAB, java.sql.Types.INTEGER);
		if (pers.getGrupo_maquina() != null)
			qUpdate.setInt(OID_GRUPO_MAQ, pers.getGrupo_maquina().getOID());
		else
			qUpdate.setNull(OID_GRUPO_MAQ, java.sql.Types.INTEGER);
		if (pers.getMaquina() != null)
			qUpdate.setInt(OID_MAQUINA, pers.getMaquina().getOID());
		else
			qUpdate.setNull(OID_MAQUINA, java.sql.Types.INTEGER);
		if (pers.getUsuario() != null)
			qUpdate.setInt(OID_USUARIO, pers.getUsuario().getOID());
		else
			qUpdate.setNull(OID_USUARIO, java.sql.Types.INTEGER);
		qUpdate.setString(MAIL, pers.getMail());
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_MENS_DEST = 1;
		DestinoMens pers = (DestinoMens) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update meMensajeDest " + " set activo=0 " + " where " + " oid_mens_dest=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_MENS_DEST, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_MENS_DEST = 1;
		DestinoMens pers = (DestinoMens) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update meMensajeDest " + " set activo=1 " + " where " + " oid_mens_dest=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_MENS_DEST, pers.getOID());
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
		case SELECT_BY_MENS_CAB: {
			ps = this.selectByMensCab(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_MENS_DEST = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  meMensajeDest ");
		textSQL.append(" WHERE oid_mens_dest = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_MENS_DEST, oid);
		return querySelect;
	}

	private PreparedStatement selectByMensCab(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  meMensajeDest ");
		textSQL.append(" WHERE  oid_mens_cab = ? and activo=1 ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		MensajeCab mensaje = (MensajeCab) aCondiciones;
		querySelect.setInt(1, mensaje.getOID());
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  meMensajeDest ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_mens_dest oid, codigo,  descripcion ,activo ");
		textSQL.append(" from meMensajeDest");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static List getDestinatariosMens(MensajeCab mensaje, ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(DestinoMens.NICKNAME, DBDestinoMens.SELECT_BY_MENS_CAB, mensaje, new ListObserver(), aSesion);
	}

}
