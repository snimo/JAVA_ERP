package com.srn.erp.general.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.general.bm.ImpresoraComun;
import com.srn.erp.general.bm.Sucursal;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBImpresoraComun extends DBObjetoPersistente {

	public static final String	OID_IMP_COMUN									= "oid_imp_comun";

	public static final String	CODIGO												= "codigo";

	public static final String	DESCRIPCION										= "descripcion";

	public static final String	IMPRESORA_SISTEMA							= "impresora_sistema";

	public static final String	ACTIVO												= "activo";
	
	public static final String UNI_ORG												= "oid_uni_org";

	public static final int			SELECT_BY_IMPRESORAS_SUCURSAL	= 100;

	public DBImpresoraComun() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_IMP_COMUN = 1;
		final int CODIGO = 2;
		final int DESCRIPCION = 3;
		final int IMPRESORA_SISTEMA = 4;
		final int ACTIVO = 5;
		final int OID_UNI_ORG = 6;

		ImpresoraComun pers = (ImpresoraComun) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into geImpComun " + " ( " + "OID_IMP_COMUN," + "CODIGO," + "DESCRIPCION,"
				+ "IMPRESORA_SISTEMA," + "ACTIVO , OID_UNI_ORG)" + " values " + "(" + "?," +"?," + "?," + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_IMP_COMUN, pers.getOID());
		qInsert.setString(CODIGO, pers.getCodigo());
		qInsert.setString(DESCRIPCION, pers.getDescripcion());
		qInsert.setString(IMPRESORA_SISTEMA, pers.getImpresora_sistema());
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qInsert.setInt(OID_UNI_ORG, pers.getUnidadOrganizativa().getOID());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int CODIGO = 1;
		final int DESCRIPCION = 2;
		final int IMPRESORA_SISTEMA = 3;
		final int ACTIVO = 4;
		final int OID_UNI_ORG = 5;
		final int OID_IMP_COMUN = 6;

		ImpresoraComun pers = (ImpresoraComun) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update geImpComun set " + "codigo=?" + ",descripcion=?" + ",impresora_sistema=?" + ",activo=?"+ ",oid_uni_org=?"
				+ " where " + " oid_imp_comun=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_IMP_COMUN, pers.getOID());
		qUpdate.setString(CODIGO, pers.getCodigo());
		qUpdate.setString(DESCRIPCION, pers.getDescripcion());
		qUpdate.setString(IMPRESORA_SISTEMA, pers.getImpresora_sistema());
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qUpdate.setInt(OID_UNI_ORG, pers.getUnidadOrganizativa().getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_IMP_COMUN = 1;
		ImpresoraComun pers = (ImpresoraComun) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update geImpComun " + " set activo = 0 where " + " oid_imp_comun=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_IMP_COMUN, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_IMP_COMUN = 1;
		ImpresoraComun pers = (ImpresoraComun) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update geImpComun " + " set activo=1 " + " where " + " oid_imp_comun=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_IMP_COMUN, pers.getOID());
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
			ps = this.selectAllImpresoras(aCondiciones);
			break;
		}
		case SELECT_BY_IMPRESORAS_SUCURSAL: {
			ps = this.selectByImpresorasSucursal(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_IMP_COMUN = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  geImpComun ");
		textSQL.append(" WHERE oid_imp_comun = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_IMP_COMUN, oid);
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  geImpComun ");
		textSQL.append(" WHERE codigo = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}
	
	private PreparedStatement selectAllImpresoras(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  geImpComun ");
		textSQL.append(" WHERE activo = 1 ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}
	

	private PreparedStatement selectByImpresorasSucursal(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  geImpComun ");
		textSQL.append(" WHERE oid_uni_org ");
		textSQL.append(" in (select oid_uni_org from geUnidadOrg where oid_sucursal=?) ");
		
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		Sucursal sucursal = (Sucursal) aCondiciones;
		querySelect.setInt(1, sucursal.getOID());
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_imp_comun oid,codigo codigo, descripcion descripcion ,activo ");
		textSQL.append(" from geImpComun");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static List getImpresoras(Sucursal sucursal, ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(ImpresoraComun.NICKNAME, DBImpresoraComun.SELECT_BY_IMPRESORAS_SUCURSAL,
				sucursal, new ListObserver(), aSesion);
	}
	
	public static List getAllImpresoras(ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(ImpresoraComun.NICKNAME, DBImpresoraComun.SELECT_ALL_ACTIVOS,
				null, new ListObserver(), aSesion);
	}
	

}
