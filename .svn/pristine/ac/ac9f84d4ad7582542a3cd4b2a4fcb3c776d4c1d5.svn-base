package com.srn.erp.payroll.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Hashtable;
import java.util.List;

import com.srn.erp.payroll.bm.PayEmpresa;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.applicarionServer.bm.Parametros.ValorParametro;
import framework.request.bl.Utils.BaseException;

public class DBPayEmpresa extends DBObjetoPersistente {

	public static final String NOMBRE = "nombre";
	public static final String EMPRESA = "empresa";

	private static final int SELECT_ALL_EMPRESA = 100;
	private static final int SELECT_BY_NOMBRE = 101;

	public DBPayEmpresa() {
	}

	public PreparedStatement prepararSelect(int aSelect, Object aCondiciones) throws BaseException, SQLException {
		PreparedStatement ps = null;
		switch (aSelect) {
		case DBPayEmpresa.SELECT_ALL_EMPRESA: {
			ps = this.selectAllEmpresas(aCondiciones);
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
		}
		return ps;
	}

	@SuppressWarnings("unchecked")
	private PreparedStatement selectAllEmpresas(Object aCondiciones) throws BaseException, SQLException {

		String esquema = ValorParametro.findByCodigoParametro("USU_PAYROLL_PROD", this.getSesion()).getValorCadena();
		if (!("").equals(esquema) && esquema != null) {
			esquema = esquema + ".";
		}
		else
		{
			esquema = "";
		}
		String dbLlink = ValorParametro.findByCodigoParametro("DATABASE_LINK_PAYROLL", this.getSesion()).getValorCadena();
		if (!("").equals(dbLlink) && dbLlink != null) {
			dbLlink = "@" + dbLlink;
		}
		else
		{
			dbLlink = "";
		}

		Hashtable<String, Object> hashTable = (Hashtable<String, Object>) aCondiciones;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT empresa, nombre ");
		textSQL.append("FROM " + esquema + "rempresa" + dbLlink + "");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		String esquema = ValorParametro.findByCodigoParametro("USU_PAYROLL_PROD", this.getSesion()).getValorCadena();
		if (!("").equals(esquema) && esquema != null) {
			esquema = esquema + ".";
		}
		else
		{
			esquema = "";
		}
		String dbLlink = ValorParametro.findByCodigoParametro("DATABASE_LINK_PAYROLL", this.getSesion()).getValorCadena();
		if (!("").equals(dbLlink) && dbLlink != null) {
			dbLlink = "@" + dbLlink;
		}
		else
		{
			dbLlink = "";
		}

		final int CODIGO = 1;
		String codigo = (String) aCondiciones;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT emp.empresa, emp.nombre FROM " + esquema + "rempresa" + dbLlink + " emp");
		textSQL.append(" WHERE emp.empresa = " + codigo);
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		String esquema = ValorParametro.findByCodigoParametro("USU_PAYROLL_PROD", this.getSesion()).getValorCadena();
		if (!("").equals(esquema) && esquema != null) {
			esquema = esquema + ".";
		}
		else
		{
			esquema = "";
		}
		String dbLlink = ValorParametro.findByCodigoParametro("DATABASE_LINK_PAYROLL", this.getSesion()).getValorCadena();
		if (!("").equals(dbLlink) && dbLlink != null) {
			dbLlink = "@" + dbLlink;
		}
		else
		{
			dbLlink = "";
		}

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT  1 oid, emp.empresa codigo, emp.nombre descripcion ,1 activo ");
		textSQL.append(" from " + esquema + "rempresa" + dbLlink + " emp");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	@Override
	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
	}

	@Override
	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
	}

	@Override
	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
	}

	@Override
	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
	}

	@SuppressWarnings("rawtypes")
	public static List getObjectAllEmpresas(ISesion aSesion, Hashtable<String, Object> hashTable) throws BaseException {
		return (List) ObjetoLogico.getObjects(PayEmpresa.NICKNAME, DBPayEmpresa.SELECT_ALL_EMPRESA, hashTable, new ListObserver(), aSesion);
	}

	@SuppressWarnings("rawtypes")
	public static List getObjectByNombre(ISesion aSesion, Hashtable<String, Object> hashTable) throws BaseException {
		return (List) ObjetoLogico.getObjects(PayEmpresa.NICKNAME, DBPayEmpresa.SELECT_BY_NOMBRE, hashTable, new ListObserver(), aSesion);
	}

}