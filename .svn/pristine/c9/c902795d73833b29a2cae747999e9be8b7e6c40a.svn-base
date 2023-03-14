package com.srn.erp.legales.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import com.srn.erp.legales.bm.RequeridoSeclo;
import com.srn.erp.legales.bm.Seclo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBRequeridoSeclo extends DBObjetoPersistente {

	public static final String OID_SECLO_REQUE = "oid_seclo_reque";
	public static final String OID_SECLO = "oid_seclo";
	public static final String OID_VAL_CLASIF_EMP = "oid_val_clasif_emp";
	public static final String ACTIVO = "activo";
	
	public static final int SELECT_BY_SECLO = 100;

	public DBRequeridoSeclo() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_SECLO_REQUE = 1;
		final int OID_SECLO = 2;
		final int OID_VAL_CLASIF_EMP = 3;
		final int ACTIVO = 4;

		RequeridoSeclo pers = (RequeridoSeclo) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into legSeclosReq " + " ( " + "OID_SECLO_REQUE," + "OID_SECLO," + "OID_VAL_CLASIF_EMP," + "ACTIVO)" + " values " + "(" + "?," + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_SECLO_REQUE, pers.getOID());
		qInsert.setInt(OID_SECLO, pers.getSeclo().getOID());
		if (pers.getValor_clasif_empresa()!=null)
			qInsert.setInt(OID_VAL_CLASIF_EMP, pers.getValor_clasif_empresa().getOID());
		else
			qInsert.setNull(OID_VAL_CLASIF_EMP, Types.INTEGER);
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_SECLO = 1;
		final int OID_VAL_CLASIF_EMP = 2;
		final int ACTIVO = 3;
		final int OID_SECLO_REQUE = 4;

		RequeridoSeclo pers = (RequeridoSeclo) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update legSeclosReq set " + "oid_seclo=?" + ",oid_val_clasif_emp=?" + ",activo=?" + " where " + " oid_seclo_reque=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_SECLO_REQUE, pers.getOID());
		qUpdate.setInt(OID_SECLO, pers.getSeclo().getOID());
		if (pers.getValor_clasif_empresa()!=null)
			qUpdate.setInt(OID_VAL_CLASIF_EMP, pers.getValor_clasif_empresa().getOID());
		else
			qUpdate.setNull(OID_VAL_CLASIF_EMP, Types.INTEGER);
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_SECLO_REQUE = 1;
		RequeridoSeclo pers = (RequeridoSeclo) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update legSeclosReq " + " set activo=0 " + " where " + " oid_seclo_reque=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_SECLO_REQUE, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_SECLO_REQUE = 1;
		RequeridoSeclo pers = (RequeridoSeclo) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update legSeclosReq " + " set activo=1 " + " where " + " oid_seclo_reque=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_SECLO_REQUE, pers.getOID());
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
		case SELECT_BY_SECLO: {
			ps = this.selectBySeclo(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_SECLO_REQUE = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  legSeclosReq ");
		textSQL.append(" WHERE oid_seclo_reque = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_SECLO_REQUE, oid);
		return querySelect;
	}


	private PreparedStatement selectBySeclo(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  legSeclosReq ");
		textSQL.append(" WHERE oid_seclo  = ? and activo = 1 ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		Seclo seclo = (Seclo) aCondiciones;
		querySelect.setInt(1, seclo.getOID());
		return querySelect;
	}
	
	
	
	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  legSeclosReq ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_seclo_reque oid, codigo,  descripcion ,activo ");
		textSQL.append(" from legSeclosReq");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}
	
	public static List getRequeridos(Seclo aSeclo,
            ISesion aSesion) throws BaseException {
		  return (List) ObjetoLogico.getObjects(RequeridoSeclo.NICKNAME,
               DBRequeridoSeclo.SELECT_BY_SECLO,
               aSeclo,
               new ListObserver(),
               aSesion);
	}
	

}
