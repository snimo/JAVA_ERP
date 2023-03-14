package com.srn.erp.cip.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.cip.bm.EquivalenciaEstadoCIP;
import com.srn.erp.cip.bm.EstadoCIP;
import com.srn.erp.general.bm.PeriodoInc;
import com.srn.erp.general.bm.PeriodoIncDet;
import com.srn.erp.general.da.DBPeriodoIncDet;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBEquivalenciaEstadoCIP extends DBObjetoPersistente {

	public static final String OID_EQUIV_ESTADO = "oid_equiv_estado";
	public static final String OID_ESTADO = "oid_estado";
	public static final String CODIGO_EXTERNO = "codigo_externo";
	public static final String ACTIVO = "activo";

	public static final int SELECT_BY_ESTADO = 100;

	public DBEquivalenciaEstadoCIP() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_EQUIV_ESTADO = 1;
		final int OID_ESTADO = 2;
		final int CODIGO_EXTERNO = 3;
		final int ACTIVO = 4;

		EquivalenciaEstadoCIP pers = (EquivalenciaEstadoCIP) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into cipEquivEstadosCIP " + " ( " + "OID_EQUIV_ESTADO," + "OID_ESTADO," + "CODIGO_EXTERNO," + "ACTIVO)"
				+ " values " + "(" + "?," + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_EQUIV_ESTADO, pers.getOID());
		qInsert.setInt(OID_ESTADO, pers.getEstado().getOID());
		qInsert.setString(CODIGO_EXTERNO, pers.getCodigo_externo());
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_ESTADO = 1;
		final int CODIGO_EXTERNO = 2;
		final int ACTIVO = 3;
		final int OID_EQUIV_ESTADO = 4;

		EquivalenciaEstadoCIP pers = (EquivalenciaEstadoCIP) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update cipEquivEstadosCIP set " + "oid_estado=?" + ",codigo_externo=?" + ",activo=?" + " where "
				+ " oid_equiv_estado=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_EQUIV_ESTADO, pers.getOID());
		qUpdate.setInt(OID_ESTADO, pers.getEstado().getOID());
		qUpdate.setString(CODIGO_EXTERNO, pers.getCodigo_externo());
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_EQUIV_ESTADO = 1;
		EquivalenciaEstadoCIP pers = (EquivalenciaEstadoCIP) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cipEquivEstadosCIP " + " set activo=0 " + " where " + " oid_equiv_estado=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_EQUIV_ESTADO, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_EQUIV_ESTADO = 1;
		EquivalenciaEstadoCIP pers = (EquivalenciaEstadoCIP) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cipEquivEstadosCIP " + " set activo=1 " + " where " + " oid_equiv_estado=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_EQUIV_ESTADO, pers.getOID());
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
		case SELECT_BY_ESTADO: {
			ps = this.selectByEstado(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_EQUIV_ESTADO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cipEquivEstadosCIP ");
		textSQL.append(" WHERE oid_equiv_estado = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_EQUIV_ESTADO, oid);
		return querySelect;
	}

	private PreparedStatement selectByEstado(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cipEquivEstadosCIP ");
		textSQL.append(" WHERE oid_estado = ? and activo=1 ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		EstadoCIP estado = (EstadoCIP) aCondiciones;
		querySelect.setInt(1, estado.getOID());
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cipEquivEstadosCIP ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_equiv_estado oid, codigo, activo descripcion ,activo ");
		textSQL.append(" from cipEquivEstadosCIP");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static List getEquivalenciasEstado(EstadoCIP estado, ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(EquivalenciaEstadoCIP.NICKNAME, DBEquivalenciaEstadoCIP.SELECT_BY_ESTADO, estado,
				new ListObserver(), aSesion);
	}

}
