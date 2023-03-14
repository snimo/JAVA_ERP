package com.srn.erp.rrhh.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.rrhh.bm.AccCronoDesa;
import com.srn.erp.rrhh.bm.MesCronoDesa;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBMesCronoDesa extends DBObjetoPersistente {

	public static final String OID_MES_A_EVAL = "oid_mes_a_eval";
	public static final String OID_ACCION_CRO = "oid_accion_cro";
	public static final String MES = "mes";
	public static final String ACTIVO = "activo";

	public static final int SELECT_BY_ACCION = 100;
	public static final int SELECT_BY_ACCION_MES = 101;
	
	public DBMesCronoDesa() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_MES_A_EVAL = 1;
		final int OID_ACCION_CRO = 2;
		final int MES = 3;
		final int ACTIVO = 4;

		MesCronoDesa pers = (MesCronoDesa) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into rhMesesAEvalDes " + " ( " + "OID_MES_A_EVAL," + "OID_ACCION_CRO," + "MES," + "ACTIVO)" + " values " + "(" + "?," + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_MES_A_EVAL, pers.getOID());
		qInsert.setInt(OID_ACCION_CRO, pers.getAccion().getOID());
		qInsert.setString(MES, pers.getMes());
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_ACCION_CRO = 1;
		final int MES = 2;
		final int ACTIVO = 3;
		final int OID_MES_A_EVAL = 4;

		MesCronoDesa pers = (MesCronoDesa) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update rhMesesAEvalDes set " + "oid_accion_cro=?" + ",mes=?" + ",activo=?" + " where " + " oid_mes_a_eval=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_MES_A_EVAL, pers.getOID());
		qUpdate.setInt(OID_ACCION_CRO, pers.getAccion().getOID());
		qUpdate.setString(MES, pers.getMes());
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_MES_A_EVAL = 1;
		MesCronoDesa pers = (MesCronoDesa) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update rhMesesAEvalDes " + " set activo=0 " + " where " + " oid_mes_a_eval=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_MES_A_EVAL, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_MES_A_EVAL = 1;
		MesCronoDesa pers = (MesCronoDesa) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update rhMesesAEvalDes " + " set activo=1 " + " where " + " oid_mes_a_eval=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_MES_A_EVAL, pers.getOID());
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
		case SELECT_BY_ACCION: {
			ps = this.selectByAccion(aCondiciones);
			break;
		}
		case SELECT_BY_ACCION_MES: {
			ps = this.selectByAccionMes(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_MES_A_EVAL = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  rhMesesAEvalDes ");
		textSQL.append(" WHERE oid_mes_a_eval = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_MES_A_EVAL, oid);
		return querySelect;
	}

	private PreparedStatement selectByAccionMes(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  rhMesesAEvalDes ");
		textSQL.append(" WHERE oid_accion_cro = ? and activo = 1 and mes = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		AccCronoDesa accCronoDesa = (AccCronoDesa) condiciones.get(AccCronoDesa.NICKNAME);
		String mes = (String) condiciones.get("MES");
		querySelect.setInt(1, accCronoDesa.getOID());
		querySelect.setString(2, mes);
		return querySelect;
	}

	private PreparedStatement selectByAccion(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  rhMesesAEvalDes ");
		textSQL.append(" WHERE oid_accion_cro = ? and activo = 1 ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		AccCronoDesa accCronoDesa = (AccCronoDesa) aCondiciones;
		querySelect.setInt(1, accCronoDesa.getOID());
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  rhMesesAEvalDes ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_mes_a_eval oid, codigo,  descripcion ,activo ");
		textSQL.append(" from rhMesesAEvalDes");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static List getMesesCronoDesa(AccCronoDesa aAccCronoDesa, ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(MesCronoDesa.NICKNAME, DBMesCronoDesa.SELECT_BY_ACCION, aAccCronoDesa, new ListObserver(), aSesion);
	}

	public static MesCronoDesa getMesCronoDesa(AccCronoDesa accCronoDesa, String mes, ISesion aSesion) throws BaseException {

		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(AccCronoDesa.NICKNAME, accCronoDesa);
		condiciones.put("MES", mes);
		return (MesCronoDesa) ObjetoLogico.getObjects(MesCronoDesa.NICKNAME, DBMesCronoDesa.SELECT_BY_ACCION_MES, condiciones, new ObjetoObservado(), aSesion);
	}

}
