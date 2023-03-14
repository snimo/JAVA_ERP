package com.srn.erp.rrhh.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import com.srn.erp.rrhh.bm.AccCronoDesa;
import com.srn.erp.rrhh.bm.CronogramaDesa;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBAccCronoDesa extends DBObjetoPersistente {

	public static final int SELECT_BY_CRONOGRAMA = 100;

	public static final String OID_ACCION_CRO = "oid_accion_cro";
	public static final String OID_CRONOGRAMA = "oid_cronograma";
	public static final String ORDEN = "orden";
	public static final String ACCION = "accion";
	public static final String REVISION = "revision";
	public static final String OBSERVACIONES = "Observaciones";
	public static final String ACTIVO = "activo";
	public static final String OID_CATEG_POSIBLE = "oid_categ_posible";
	public static final String OID_RANKEAR = "oid_rankear";
	public static final String SECTOR = "sector";
	public static final String PARAMETROS = "parametros";

	public DBAccCronoDesa() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_ACCION_CRO = 1;
		final int OID_CRONOGRAMA = 2;
		final int ORDEN = 3;
		final int ACCION = 4;
		final int REVISION = 5;
		final int OBSERVACIONES = 6;
		final int ACTIVO = 7;
		final int OID_CATEG_POSIBLE = 8;
		final int OID_RANKEAR = 9;
		final int SECTOR = 10;
		final int PARAMETROS = 11;

		AccCronoDesa pers = (AccCronoDesa) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into rhAccionesCro " + " ( " + "OID_ACCION_CRO," + "OID_CRONOGRAMA," + "ORDEN," + "ACCION," + "REVISION," + "OBSERVACIONES,"
				+ "ACTIVO , OID_CATEG_POSIBLE , OID_RANKEAR , SECTOR , PARAMETROS)" + " values " + "(" + "?,"+ "?,"+ "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_ACCION_CRO, pers.getOID());
		qInsert.setInt(OID_CRONOGRAMA, pers.getCronograma().getOID());
		qInsert.setInt(ORDEN, pers.getOrden().intValue());
		qInsert.setString(ACCION, pers.getAccion());
		qInsert.setString(REVISION, pers.getRevision());
		qInsert.setString(OBSERVACIONES, pers.getObservaciones());
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		if (pers.getCategoriaPosible() != null)
			qInsert.setInt(OID_CATEG_POSIBLE, pers.getCategoriaPosible().getOID());
		else
			qInsert.setNull(OID_CATEG_POSIBLE, Types.INTEGER);
		if (pers.getRankear() != null)
			qInsert.setInt(OID_RANKEAR, pers.getRankear().getOID());
		else
			qInsert.setNull(OID_RANKEAR, Types.INTEGER);
		if (pers.getSector()!=null)
			qInsert.setString(SECTOR, pers.getSector());
		else
			qInsert.setNull(SECTOR, Types.VARCHAR);
		if (pers.getParametros()!=null)
			qInsert.setString(PARAMETROS, pers.getParametros());
		else
			qInsert.setNull(PARAMETROS, Types.VARCHAR);
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_CRONOGRAMA = 1;
		final int ORDEN = 2;
		final int ACCION = 3;
		final int REVISION = 4;
		final int OBSERVACIONES = 5;
		final int ACTIVO = 6;
		final int OID_CATEG_POSIBLE = 7;
		final int OID_RANKEAR = 8;
		final int SECTOR = 9;
		final int PARAMETROS = 10;
		final int OID_ACCION_CRO = 11;

		AccCronoDesa pers = (AccCronoDesa) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update rhAccionesCro set " + "oid_cronograma=?" + ",orden=?" + ",accion=?" + ",revision=?" + ",Observaciones=?" + ",activo=? , oid_categ_posible = ? , oid_rankear = ? , sector = ? , parametros = ? "
				+ " where " + " oid_accion_cro=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_ACCION_CRO, pers.getOID());
		qUpdate.setInt(OID_CRONOGRAMA, pers.getCronograma().getOID());
		qUpdate.setInt(ORDEN, pers.getOrden().intValue());
		qUpdate.setString(ACCION, pers.getAccion());
		qUpdate.setString(REVISION, pers.getRevision());
		qUpdate.setString(OBSERVACIONES, pers.getObservaciones());
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		if (pers.getCategoriaPosible() != null)
			qUpdate.setInt(OID_CATEG_POSIBLE, pers.getCategoriaPosible().getOID());
		else
			qUpdate.setNull(OID_CATEG_POSIBLE, Types.INTEGER);
		if (pers.getRankear() != null)
			qUpdate.setInt(OID_RANKEAR, pers.getRankear().getOID());
		else
			qUpdate.setNull(OID_RANKEAR, Types.INTEGER);
		if (pers.getSector()!=null)
			qUpdate.setString(SECTOR, pers.getSector());
		else
			qUpdate.setNull(SECTOR, Types.VARCHAR);
		if (pers.getParametros()!=null)
			qUpdate.setString(PARAMETROS, pers.getParametros());
		else
			qUpdate.setNull(PARAMETROS, Types.VARCHAR);
		
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_ACCION_CRO = 1;
		AccCronoDesa pers = (AccCronoDesa) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update rhAccionesCro " + " set activo=0 " + " where " + " oid_accion_cro=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_ACCION_CRO, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_ACCION_CRO = 1;
		AccCronoDesa pers = (AccCronoDesa) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update rhAccionesCro " + " set activo=1 " + " where " + " oid_accion_cro=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_ACCION_CRO, pers.getOID());
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
		case SELECT_BY_CRONOGRAMA: {
			ps = this.selectByCronograma(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_ACCION_CRO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  rhAccionesCro ");
		textSQL.append(" WHERE oid_accion_cro = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_ACCION_CRO, oid);
		return querySelect;
	}

	private PreparedStatement selectByCronograma(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  rhAccionesCro ");
		textSQL.append(" WHERE oid_cronograma = ? and activo = 1 ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		CronogramaDesa cronograma = (CronogramaDesa) aCondiciones;
		querySelect.setInt(1, cronograma.getOID());
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  rhAccionesCro ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_accion_cro oid, codigo,  descripcion ,activo ");
		textSQL.append(" from rhAccionesCro");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static List getAccionesCrono(CronogramaDesa cronograma, ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(AccCronoDesa.NICKNAME, DBAccCronoDesa.SELECT_BY_CRONOGRAMA, cronograma, new ListObserver(), aSesion);
	}

}
