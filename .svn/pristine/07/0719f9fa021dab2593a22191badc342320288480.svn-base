package com.srn.erp.contabilidad.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.contabilidad.bm.GenerarValorCompoCriImpu;
import com.srn.erp.contabilidad.bm.ValoresAtriCriterioImpu;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBGenerarValorCompoCriImpu extends DBObjetoPersistente {

	public static final String OID_GEN_VAL_COMPO = "oid_gen_val_compo";

	public static final String OID_VAL_ATRI_ENT = "oid_val_atri_ent";

	public static final String OID_ATRI_ENT = "oid_atri_ent";

	public static final String OID_COMPO = "oid_compo";

	public static final int SELECT_BY_VALORES_ATRI_ENT = 100;

	public DBGenerarValorCompoCriImpu() {
	}

	protected void insert(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {

		final int OID_GEN_VAL_COMPO = 1;
		final int OID_VAL_ATRI_ENT = 2;
		final int OID_ATRI_ENT = 3;
		final int OID_COMPO = 4;

		GenerarValorCompoCriImpu pers = (GenerarValorCompoCriImpu) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into cgGenValCompoCI " + " ( "
				+ "OID_GEN_VAL_COMPO," + "OID_VAL_ATRI_ENT," + "OID_ATRI_ENT,"
				+ "OID_COMPO)" + " values " + "(" + "?," + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD()
				.prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_GEN_VAL_COMPO, pers.getOID());
		qInsert.setInt(OID_VAL_ATRI_ENT, pers
				.getValoresatricriterioimputacion().getOID());
		qInsert.setInt(OID_ATRI_ENT, pers.getAtributo_entidad().getOID());
		qInsert.setInt(OID_COMPO, pers.getComponente().getOID());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {

		final int OID_VAL_ATRI_ENT = 1;
		final int OID_ATRI_ENT = 2;
		final int OID_COMPO = 3;
		final int OID_GEN_VAL_COMPO = 4;

		GenerarValorCompoCriImpu pers = (GenerarValorCompoCriImpu) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update cgGenValCompoCI set " + "oid_val_atri_ent=?"
				+ ",oid_atri_ent=?" + ",oid_compo=?" + " where "
				+ " oid_gen_val_compo=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_GEN_VAL_COMPO, pers.getOID());
		qUpdate.setInt(OID_VAL_ATRI_ENT, pers
				.getValoresatricriterioimputacion().getOID());
		qUpdate.setInt(OID_ATRI_ENT, pers.getAtributo_entidad().getOID());
		qUpdate.setInt(OID_COMPO, pers.getComponente().getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {
		final int OID_GEN_VAL_COMPO = 1;
		GenerarValorCompoCriImpu pers = (GenerarValorCompoCriImpu) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("delete from cgGenValCompoCI "
				+ " where " + " oid_gen_val_compo=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_GEN_VAL_COMPO, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {
		final int OID_GEN_VAL_COMPO = 1;
		GenerarValorCompoCriImpu pers = (GenerarValorCompoCriImpu) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cgGenValCompoCI " + " set activo=1 "
				+ " where " + " oid_gen_val_compo=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_GEN_VAL_COMPO, pers.getOID());
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
		case SELECT_BY_VALORES_ATRI_ENT: {
			ps = this.selectByValoresAtriEnt(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones)
			throws BaseException, SQLException {

		final int OID_GEN_VAL_COMPO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cgGenValCompoCI ");
		textSQL.append(" WHERE oid_gen_val_compo = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_GEN_VAL_COMPO, oid);
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones)
			throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cgGenValCompoCI ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectByValoresAtriEnt(Object aCondiciones)
			throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cgGenValCompoCI ");
		textSQL.append(" WHERE oid_val_atri_ent = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		ValoresAtriCriterioImpu valAtriCriImpu = ((ValoresAtriCriterioImpu) aCondiciones);
		querySelect.setInt(1, valAtriCriImpu.getOID());
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones)
			throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL
				.append("SELECT oid_gen_val_compo oid, codigo,  descripcion ,activo ");
		textSQL.append(" from cgGenValCompoCI");

		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static List getGenerarValoresCompo(
			ValoresAtriCriterioImpu valAtriCriImpu, ISesion aSesion)
			throws BaseException {
		return (List) ObjetoLogico.getObjects(
				GenerarValorCompoCriImpu.NICKNAME,
				DBGenerarValorCompoCriImpu.SELECT_BY_VALORES_ATRI_ENT,
				valAtriCriImpu, new ListObserver(), aSesion);
	}

}
