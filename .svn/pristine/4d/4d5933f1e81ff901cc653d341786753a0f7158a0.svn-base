package com.srn.erp.excluidos.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.excluidos.bm.TipoCabelloExcluido;
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

public class DBTipoCabelloExcluido extends DBObjetoPersistente {

	public static final String OID_TIPO_CABELLO = "oid_tipo_cabello";
	public static final String CODIGO = "codigo";
	public static final String DESCRIPCION = "descripcion";
	public static final String ACTIVO = "activo";

	public DBTipoCabelloExcluido() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_TIPO_CABELLO = 1;
		final int CODIGO = 2;
		final int DESCRIPCION = 3;
		final int ACTIVO = 4;

		TipoCabelloExcluido pers = (TipoCabelloExcluido) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into excTipoCabello " + " ( " + "OID_TIPO_CABELLO," + "CODIGO," + "DESCRIPCION," + "ACTIVO)" + " values "
				+ "(" + "?," + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_TIPO_CABELLO, pers.getOID());
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
		final int OID_TIPO_CABELLO = 4;

		TipoCabelloExcluido pers = (TipoCabelloExcluido) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update excTipoCabello set " + "codigo=?" + ",descripcion=?" + ",activo=?" + " where " + " oid_tipo_cabello=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_TIPO_CABELLO, pers.getOID());
		qUpdate.setString(CODIGO, pers.getCodigo());
		qUpdate.setString(DESCRIPCION, pers.getDescripcion());
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_TIPO_CABELLO = 1;
		TipoCabelloExcluido pers = (TipoCabelloExcluido) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update excTipoCabello " + " set activo=0 " + " where " + " oid_tipo_cabello=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_TIPO_CABELLO, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_TIPO_CABELLO = 1;
		TipoCabelloExcluido pers = (TipoCabelloExcluido) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update excTipoCabello " + " set activo=1 " + " where " + " oid_tipo_cabello=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_TIPO_CABELLO, pers.getOID());
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

		final int OID_TIPO_CABELLO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  excTipoCabello ");
		textSQL.append(" WHERE oid_tipo_cabello = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_TIPO_CABELLO, oid);
		return querySelect;
	}

	private PreparedStatement selectAllActivos(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  excTipoCabello ");
		textSQL.append(" WHERE activo=1 ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}
	
	
	
	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  excTipoCabello ");
		textSQL.append(" WHERE codigo = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_tipo_cabello oid,codigo codigo, descripcion descripcion ,activo ");
		textSQL.append(" from excTipoCabello");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}
	
	  public static List getAllActivos(ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(TipoCabelloExcluido.NICKNAME, DBTipoCabelloExcluido.SELECT_ALL_ACTIVOS, null,
				new ListObserver(), aSesion);
	}
	

}
