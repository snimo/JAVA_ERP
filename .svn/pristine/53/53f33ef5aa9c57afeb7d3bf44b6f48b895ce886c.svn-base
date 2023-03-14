package com.srn.erp.excluidos.da;

import java.sql.*;
import java.util.List;

import com.srn.erp.excluidos.bm.*;
import com.srn.erp.general.bm.PeriodoInc;
import com.srn.erp.general.bm.PeriodoIncDet;
import com.srn.erp.general.da.DBPeriodoIncDet;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.*;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.*;

public class DBMotivoNovedadExcluido extends DBObjetoPersistente {

	public static final String OID_MOTIVO = "oid_motivo";
	public static final String CODIGO = "codigo";
	public static final String DESCRIPCION = "descripcion";
	public static final String ACTIVO = "activo";

	public DBMotivoNovedadExcluido() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_MOTIVO = 1;
		final int CODIGO = 2;
		final int DESCRIPCION = 3;
		final int ACTIVO = 4;

		MotivoNovedadExcluido pers = (MotivoNovedadExcluido) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into excMotiNov " + " ( " + "OID_MOTIVO," + "CODIGO," + "DESCRIPCION," + "ACTIVO)" + " values " + "("
				+ "?," + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_MOTIVO, pers.getOID());
		qInsert.setString(CODIGO, pers.getCodigo());
		qInsert.setString(DESCRIPCION, pers.getDescripcion());
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int CODIGO = 1;
		final int DESCRIPCION = 2;
		final int ACTIVO = 3;
		final int OID_MOTIVO = 4;

		MotivoNovedadExcluido pers = (MotivoNovedadExcluido) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update excMotiNov set " + "codigo=?" + ",descripcion=?" + ",activo=?" + " where " + " oid_motivo=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_MOTIVO, pers.getOID());
		qUpdate.setString(CODIGO, pers.getCodigo());
		qUpdate.setString(DESCRIPCION, pers.getDescripcion());
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_MOTIVO = 1;
		MotivoNovedadExcluido pers = (MotivoNovedadExcluido) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update excMotiNov " + " set activo=0 " + " where " + " oid_motivo=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_MOTIVO, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_MOTIVO = 1;
		MotivoNovedadExcluido pers = (MotivoNovedadExcluido) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update excMotiNov " + " set activo=1 " + " where " + " oid_motivo=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_MOTIVO, pers.getOID());
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
		case IDBObjetoPersistente.SELECT_ALL_ACTIVOS: {
			ps = this.selectAllActivos(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_MOTIVO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  excMotiNov ");
		textSQL.append(" WHERE oid_motivo = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_MOTIVO, oid);
		return querySelect;
	}

	private PreparedStatement selectAllActivos(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  excMotiNov ");
		textSQL.append(" WHERE activo = 1 ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  excMotiNov ");
		textSQL.append(" WHERE codigo = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_motivo oid, codigo,  descripcion ,activo ");
		textSQL.append(" from excMotiNov");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static List getAllActivos(ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(MotivoNovedadExcluido.NICKNAME, DBMotivoNovedadExcluido.SELECT_ALL_ACTIVOS, null,
				new ListObserver(), aSesion);
	}

}
