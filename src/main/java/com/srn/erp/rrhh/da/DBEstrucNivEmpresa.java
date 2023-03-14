package com.srn.erp.rrhh.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.general.bm.Periodo;
import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.general.da.DBPeriodo;
import com.srn.erp.rrhh.bm.EstrucNivEmpresa;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ObjetoObservado;

public class DBEstrucNivEmpresa extends DBObjetoPersistente {

	public static final String OID_ESTRUC_EMP = "oid_estruc_emp";
	public static final String OID_VAL_CLASIF_EMP = "oid_val_clasif_emp";
	public static final String ACTIVO = "activo";
	
	public static final int SELECT_BY_VAL_CLASIF_EMP = 100;

	public DBEstrucNivEmpresa() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_ESTRUC_EMP = 1;
		final int OID_VAL_CLASIF_EMP = 2;
		final int ACTIVO = 3;

		EstrucNivEmpresa pers = (EstrucNivEmpresa) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into rhEstrucNivEmp " + " ( " + "OID_ESTRUC_EMP," + "OID_VAL_CLASIF_EMP," + "ACTIVO)" + " values " + "(" + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_ESTRUC_EMP, pers.getOID());
		qInsert.setInt(OID_VAL_CLASIF_EMP, pers.getValor_clasif_empresa().getOID());
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_VAL_CLASIF_EMP = 1;
		final int ACTIVO = 2;
		final int OID_ESTRUC_EMP = 3;

		EstrucNivEmpresa pers = (EstrucNivEmpresa) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update rhEstrucNivEmp set " + "oid_val_clasif_emp=?" + ",activo=?" + " where " + " oid_estruc_emp=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_ESTRUC_EMP, pers.getOID());
		qUpdate.setInt(OID_VAL_CLASIF_EMP, pers.getValor_clasif_empresa().getOID());
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_ESTRUC_EMP = 1;
		EstrucNivEmpresa pers = (EstrucNivEmpresa) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update rhEstrucNivEmp " + " set activo=0 " + " where " + " oid_estruc_emp=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_ESTRUC_EMP, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_ESTRUC_EMP = 1;
		EstrucNivEmpresa pers = (EstrucNivEmpresa) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update rhEstrucNivEmp " + " set activo=1 " + " where " + " oid_estruc_emp=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_ESTRUC_EMP, pers.getOID());
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
		case IDBObjetoPersistente.SELECT_ALL: {
			ps = this.selectAll(aCondiciones);
			break;
		}		
		case SELECT_BY_VAL_CLASIF_EMP: {
			ps = this.selectByValClasifEmp(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_ESTRUC_EMP = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  rhEstrucNivEmp ");
		textSQL.append(" WHERE oid_estruc_emp = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_ESTRUC_EMP, oid);
		return querySelect;
	}

	private PreparedStatement selectAllActivos(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  rhEstrucNivEmp ");
		textSQL.append(" WHERE  activo = 1 ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}
	
	private PreparedStatement selectAll(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  rhEstrucNivEmp ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}	


	private PreparedStatement selectByValClasifEmp(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  rhEstrucNivEmp ");
		textSQL.append(" WHERE oid_val_clasif_emp = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		ValorClasificadorEntidad valor = (ValorClasificadorEntidad) aCondiciones;
		querySelect.setInt(1, valor.getOID());
		return querySelect;
	}
	
	
	
	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  rhEstrucNivEmp ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_estruc_emp oid, codigo,  descripcion ,activo ");
		textSQL.append(" from rhEstrucNivEmp");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static List getEmpresasActivas(ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(EstrucNivEmpresa.NICKNAME, DBEstrucNivEmpresa.SELECT_ALL_ACTIVOS, null, new ListObserver(), aSesion);
	}
	
	public static List getEmpresas(ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(EstrucNivEmpresa.NICKNAME, DBEstrucNivEmpresa.SELECT_ALL, null, new ListObserver(), aSesion);
	}	
	
	public static EstrucNivEmpresa getEstrucNivEmpresa(
			  ValorClasificadorEntidad valorClasifEntEmp,
	          ISesion aSesion)
	          throws BaseException {
		  return (EstrucNivEmpresa) ObjetoLogico.getObjects(EstrucNivEmpresa.NICKNAME,
				  				DBEstrucNivEmpresa.SELECT_BY_VAL_CLASIF_EMP,
				  				valorClasifEntEmp,
				  				new ObjetoObservado(),
				  				aSesion);
	}
	

}
