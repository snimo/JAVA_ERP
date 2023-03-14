package com.srn.erp.tesoreria.da;

import java.sql.*;
import java.util.List;

import com.srn.erp.general.bm.PeriodoInc;
import com.srn.erp.general.bm.PeriodoIncDet;
import com.srn.erp.general.da.DBPeriodoIncDet;
import com.srn.erp.tesoreria.bm.*;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.*;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.*;

public class DBUniOrgCtasIngVar extends DBObjetoPersistente {

	public static final String	OID_UNI_ORG_IV				= "oid_uni_org_iv";

	public static final String	OID_CTA_INT_IV				= "oid_cta_int_iv";

	public static final String	OID_UNI_ORG						= "oid_uni_org";

	public static final int			SELECT_BY_CTA_ING_VAR	= 100;

	public DBUniOrgCtasIngVar() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_UNI_ORG_IV = 1;
		final int OID_CTA_INT_IV = 2;
		final int OID_UNI_ORG = 3;

		UniOrgCtasIngVar pers = (UniOrgCtasIngVar) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into teIngVarUniOrg " + " ( " + "OID_UNI_ORG_IV," + "OID_CTA_INT_IV," + "OID_UNI_ORG)"
				+ " values " + "(" + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_UNI_ORG_IV, pers.getOID());
		qInsert.setInt(OID_CTA_INT_IV, pers.getCuenta_iv().getOID());
		qInsert.setInt(OID_UNI_ORG, pers.getUnidad_organizativa().getOID());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_CTA_INT_IV = 1;
		final int OID_UNI_ORG = 2;
		final int OID_UNI_ORG_IV = 3;

		UniOrgCtasIngVar pers = (UniOrgCtasIngVar) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update teIngVarUniOrg set " + "oid_cta_int_iv=?" + ",oid_uni_org=?" + " where "
				+ " oid_uni_org_iv=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_UNI_ORG_IV, pers.getOID());
		qUpdate.setInt(OID_CTA_INT_IV, pers.getCuenta_iv().getOID());
		qUpdate.setInt(OID_UNI_ORG, pers.getUnidad_organizativa().getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_UNI_ORG_IV = 1;
		UniOrgCtasIngVar pers = (UniOrgCtasIngVar) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("delete from teIngVarUniOrg where " + " oid_uni_org_iv=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_UNI_ORG_IV, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_UNI_ORG_IV = 1;
		UniOrgCtasIngVar pers = (UniOrgCtasIngVar) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update teIngVarUniOrg " + " set activo=1 " + " where " + " oid_uni_org_iv=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_UNI_ORG_IV, pers.getOID());
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
		case SELECT_BY_CTA_ING_VAR: {
			ps = this.selectByCtaIngVar(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_UNI_ORG_IV = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  teIngVarUniOrg ");
		textSQL.append(" WHERE oid_uni_org_iv = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_UNI_ORG_IV, oid);
		return querySelect;
	}

	private PreparedStatement selectByCtaIngVar(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  teIngVarUniOrg ");
		textSQL.append(" WHERE oid_cta_int_iv = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		CuentaImputableIngVar ctaImpuIngVar = (CuentaImputableIngVar) aCondiciones;
		querySelect.setInt(1, ctaImpuIngVar.getOID());
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  teIngVarUniOrg ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_uni_org_iv oid, codigo,  descripcion ,activo ");
		textSQL.append(" from teIngVarUniOrg");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static List getUniOrgCtaIngVar(CuentaImputableIngVar cuentaImputableIngVar, ISesion aSesion)
			throws BaseException {
		return (List) ObjetoLogico.getObjects(UniOrgCtasIngVar.NICKNAME, DBUniOrgCtasIngVar.SELECT_BY_CTA_ING_VAR,
				cuentaImputableIngVar, new ListObserver(), aSesion);
	}

}
