package com.srn.erp.excluidos.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.excluidos.bm.EstadosExcluidosUltNroActa;
import com.srn.erp.excluidos.bm.EstadosExcluidosUltNroActaRev;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBEstadosExcluidosUltNroActaRev extends DBObjetoPersistente {

	public static final String OID_ESTADO = "oid_estado";
	public static final String DESCRIPCION = "descripcion";
	public static final String ULT_NRO = "ult_nro";

	public DBEstadosExcluidosUltNroActaRev() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_ESTADO = 1;
		final int DESCRIPCION = 2;
		final int ULT_NRO = 3;

		EstadosExcluidosUltNroActa pers = (EstadosExcluidosUltNroActa) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into aaaa " + " ( " + "OID_ESTADO," + "DESCRIPCION," + "ULT_NRO)" + " values " + "(" + "?," + "?,"
				+ "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_ESTADO, pers.getOID());
		qInsert.setString(DESCRIPCION, pers.getDescripcion());
		qInsert.setInt(ULT_NRO, pers.getUlt_nro().intValue());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int DESCRIPCION = 1;
		final int ULT_NRO = 2;
		final int OID_ESTADO = 3;

		EstadosExcluidosUltNroActa pers = (EstadosExcluidosUltNroActa) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update aaaa set " + "descripcion=?" + ",ult_nro=?" + " where " + " oid_estado=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_ESTADO, pers.getOID());
		qUpdate.setString(DESCRIPCION, pers.getDescripcion());
		qUpdate.setInt(ULT_NRO, pers.getUlt_nro().intValue());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_ESTADO = 1;
		EstadosExcluidosUltNroActa pers = (EstadosExcluidosUltNroActa) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update aaaa " + " set activo=0 " + " where " + " oid_estado=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_ESTADO, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_ESTADO = 1;
		EstadosExcluidosUltNroActa pers = (EstadosExcluidosUltNroActa) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update aaaa " + " set activo=1 " + " where " + " oid_estado=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_ESTADO, pers.getOID());
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
		case IDBObjetoPersistente.SELECT_ALL: {
			ps = this.selectAll(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_ESTADO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  aaaa ");
		textSQL.append(" WHERE oid_estado = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_ESTADO, oid);
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  aaaa ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAll(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT a.oid_estado,b.descripcion,max(NRO_REVOCAMIENTO) ult_nro ");
		textSQL.append(" FROM excNovedades a , excEstados b , excindividuo c  where a.oid_estado=b.oid_estado and a.activo=1 ");
		textSQL.append(" AND c.oid_individuo = a.oid_individuo AND c.activo=1 ");
		textSQL.append(" group by a.oid_estado,b.descripcion ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_estado oid, codigo, descripcion descripcion ,activo ");
		textSQL.append(" from aaaa");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static List getAllUltNrosEstados(ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(EstadosExcluidosUltNroActaRev.NICKNAME, DBEstadosExcluidosUltNroActaRev.SELECT_ALL, null,
				new ListObserver(), aSesion);
	}

}
