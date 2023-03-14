package com.srn.erp.rrhh.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.rrhh.bm.HistoricoPuesto;
import com.srn.erp.sueldos.bm.Legajo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBHistoricoPuesto extends DBObjetoPersistente {

	public static final String OID_HIST_PUESTO = "oid_hist_puesto";
	public static final String OID_VAL_CLASIF_PUE = "oid_val_clasif_pue";
	public static final String FEC_DESDE = "fec_desde";
	public static final String OID_LEGAJO = "oid_legajo";
	public static final String ACTIVO = "activo";
	public static final String OID_VAL_CLASIF_EMP = "oid_val_clasif_emp";
	public static final String OID_VAL_CLASIF_SEC = "oid_val_clasif_sec";
	

	public static final int SELECT_BY_LEGAJO = 100;
	public static final int TRUNCATE_TABLE_HISTPUE = 101;
	public static final int SELECT_BY_LEGAJO_PUESTO_ULTFEC = 102;
	public static final int SELECT_BY_ULT_PUE = 103;

	public DBHistoricoPuesto() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_HIST_PUESTO = 1;
		final int OID_VAL_CLASIF_PUE = 2;
		final int FEC_DESDE = 3;
		final int OID_LEGAJO = 4;
		final int ACTIVO = 5;
		final int OID_VAL_CLASIF_EMP = 6;
		final int OID_VAL_CLASIF_SEC = 7;

		HistoricoPuesto pers = (HistoricoPuesto) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into rhHistPuestos " + " ( " + "OID_HIST_PUESTO," + "OID_VAL_CLASIF_PUE," + "FEC_DESDE," + "OID_LEGAJO," + "ACTIVO , OID_VAL_CLASIF_EMP , OID_VAL_CLASIF_SEC)" + " values " + "(" + "?," + "?," + "?,"+ "?," + "?," + "?,"
				+ "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_HIST_PUESTO, pers.getOID());
		qInsert.setInt(OID_VAL_CLASIF_PUE, pers.getVal_clasif_pue().getOID());
		qInsert.setDate(FEC_DESDE, new java.sql.Date(pers.getFec_desde().getTime()));
		qInsert.setInt(OID_LEGAJO, pers.getLegajo().getOID());
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qInsert.setInt(OID_VAL_CLASIF_EMP, pers.getVal_clasif_emp().getOID());
		qInsert.setInt(OID_VAL_CLASIF_SEC, pers.getVal_clasif_sec().getOID());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_VAL_CLASIF_PUE = 1;
		final int FEC_DESDE = 2;
		final int OID_LEGAJO = 3;
		final int ACTIVO = 4;
		final int OID_VAL_CLASIF_EMP = 5;
		final int OID_VAL_CLASIF_SEC = 6;
		final int OID_HIST_PUESTO = 7;

		HistoricoPuesto pers = (HistoricoPuesto) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update rhHistPuestos set " + "oid_val_clasif_pue=?" + ",fec_desde=?" + ",oid_legajo=?" + ",activo=? , oid_val_clasif_emp = ? , oid_val_clasif_sec = ?" + " where " + " oid_hist_puesto=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_HIST_PUESTO, pers.getOID());
		qUpdate.setInt(OID_VAL_CLASIF_PUE, pers.getVal_clasif_pue().getOID());
		qUpdate.setDate(FEC_DESDE, new java.sql.Date(pers.getFec_desde().getTime()));
		qUpdate.setInt(OID_LEGAJO, pers.getLegajo().getOID());
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qUpdate.setInt(OID_VAL_CLASIF_EMP, pers.getVal_clasif_emp().getOID());
		qUpdate.setInt(OID_VAL_CLASIF_SEC, pers.getVal_clasif_sec().getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_HIST_PUESTO = 1;
		HistoricoPuesto pers = (HistoricoPuesto) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update rhHistPuestos " + " set activo=0 " + " where " + " oid_hist_puesto=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_HIST_PUESTO, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_HIST_PUESTO = 1;
		HistoricoPuesto pers = (HistoricoPuesto) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update rhHistPuestos " + " set activo=1 " + " where " + " oid_hist_puesto=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_HIST_PUESTO, pers.getOID());
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
		case SELECT_BY_LEGAJO: {
			ps = this.selectByLegajo(aCondiciones);
			break;
		}
		case TRUNCATE_TABLE_HISTPUE: {
			ps = this.truncarTablaPayHistPuestos(aCondiciones);
			break;

		}
		case SELECT_BY_LEGAJO_PUESTO_ULTFEC: {
			ps = this.selectByLegajoPueUltFec(aCondiciones);
			break;
		}
		case SELECT_BY_ULT_PUE: {
			ps = this.selectByUtlPuesto(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_HIST_PUESTO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  rhHistPuestos ");
		textSQL.append(" WHERE oid_hist_puesto = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_HIST_PUESTO, oid);
		return querySelect;
	}

	private PreparedStatement selectByUtlPuesto(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  rhHistPuestos ");
		textSQL.append(" WHERE oid_legajo = ? and activo = 1 order by fec_desde desc ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		Legajo legajo = (Legajo) aCondiciones;
		querySelect.setInt(1, legajo.getOID());
		return querySelect;
	}

	private PreparedStatement selectByLegajoPueUltFec(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  rhHistPuestos ");
		textSQL.append(" WHERE oid_legajo = ? and oid_val_clasif_pue = ? and activo = 1 order by fec_desde desc ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		Legajo legajo = (Legajo) condiciones.get(Legajo.NICKNAME);
		ValorClasificadorEntidad valClasifPuesto = (ValorClasificadorEntidad) condiciones.get(ValorClasificadorEntidad.NICKNAME);
		querySelect.setInt(1, legajo.getOID());
		querySelect.setInt(2, valClasifPuesto.getOID());
		return querySelect;
	}

	private PreparedStatement selectByLegajo(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  rhHistPuestos ");
		textSQL.append(" WHERE oid_legajo = ? and activo = 1 order by fec_desde desc ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		Legajo legajo = (Legajo) aCondiciones;
		querySelect.setInt(1, legajo.getOID());
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  rhHistPuestos ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_hist_puesto oid, codigo,  descripcion ,activo ");
		textSQL.append(" from rhHistPuestos");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static List getHistoricoPuestos(Legajo aLegajo, ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(HistoricoPuesto.NICKNAME, DBHistoricoPuesto.SELECT_BY_LEGAJO, aLegajo, new ListObserver(), aSesion);
	}

	private PreparedStatement truncarTablaPayHistPuestos(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("truncate table payHistPuestos ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.executeUpdate();
		qUpdate.close();
		return null;

	}

	public static void truncarTablaHistoricoPuesto(ISesion aSesion) throws BaseException {
		ObjetoLogico.getObjects(HistoricoPuesto.NICKNAME, DBHistoricoPuesto.TRUNCATE_TABLE_HISTPUE, null, null, aSesion);
	}

	public static HistoricoPuesto getHistoricoPuesto(Legajo aLegajo, ValorClasificadorEntidad puesto, ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(Legajo.NICKNAME, aLegajo);
		condiciones.put(ValorClasificadorEntidad.NICKNAME, puesto);
		return (HistoricoPuesto) ObjetoLogico.getObjects(HistoricoPuesto.NICKNAME, DBHistoricoPuesto.SELECT_BY_LEGAJO_PUESTO_ULTFEC, condiciones, new ObjetoObservado(), aSesion);
	}

	public static HistoricoPuesto getHistoricoPuesto(Legajo aLegajo, ISesion aSesion) throws BaseException {
		return (HistoricoPuesto) ObjetoLogico.getObjects(HistoricoPuesto.NICKNAME, DBHistoricoPuesto.SELECT_BY_ULT_PUE, aLegajo, new ObjetoObservado(), aSesion);
	}

}
