package com.srn.erp.rrhh.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.rrhh.bm.EstrucNivEmpresa;
import com.srn.erp.rrhh.bm.EstrucNivSector;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBEstrucNivSector extends DBObjetoPersistente {

	public static final String OID_ESTRUC_SEC = "oid_estruc_sec";
	public static final String OID_ESTRUC_EMP = "oid_estruc_emp";
	public static final String OID_VAL_CLASIF_SEC = "oid_val_clasif_sec";
	public static final String ACTIVO = "activo";

	public static final int SELECT_BY_ESTRUC_EMP = 100;
	public static final int SELECT_BY_ESTEMP_SECTOR = 101;
	public static final int SELECT_BY_ESTRUC_EMP_ALL = 102;
	

	public DBEstrucNivSector() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_ESTRUC_SEC = 1;
		final int OID_ESTRUC_EMP = 2;
		final int OID_VAL_CLASIF_SEC = 3;
		final int ACTIVO = 4;

		EstrucNivSector pers = (EstrucNivSector) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into rhEstrucNivSec " + " ( " + "OID_ESTRUC_SEC," + "OID_ESTRUC_EMP," + "OID_VAL_CLASIF_SEC," + "ACTIVO)" + " values " + "(" + "?," + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_ESTRUC_SEC, pers.getOID());
		qInsert.setInt(OID_ESTRUC_EMP, pers.getOid_estruc_emp().getOID());
		qInsert.setInt(OID_VAL_CLASIF_SEC, pers.getValor_clasif_sector().getOID());
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_ESTRUC_EMP = 1;
		final int OID_VAL_CLASIF_SEC = 2;
		final int ACTIVO = 3;
		final int OID_ESTRUC_SEC = 4;

		EstrucNivSector pers = (EstrucNivSector) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update rhEstrucNivSec set " + "oid_estruc_emp=?" + ",oid_val_clasif_sec=?" + ",activo=?" + " where " + " oid_estruc_sec=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_ESTRUC_SEC, pers.getOID());
		qUpdate.setInt(OID_ESTRUC_EMP, pers.getOid_estruc_emp().getOID());
		qUpdate.setInt(OID_VAL_CLASIF_SEC, pers.getValor_clasif_sector().getOID());
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_ESTRUC_SEC = 1;
		EstrucNivSector pers = (EstrucNivSector) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update rhEstrucNivSec " + " set activo=0 " + " where " + " oid_estruc_sec=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_ESTRUC_SEC, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_ESTRUC_SEC = 1;
		EstrucNivSector pers = (EstrucNivSector) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update rhEstrucNivSec " + " set activo=1 " + " where " + " oid_estruc_sec=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_ESTRUC_SEC, pers.getOID());
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
		case SELECT_BY_ESTRUC_EMP: {
			ps = this.selectByEstrucEmp(aCondiciones);
			break;
		}
		case SELECT_BY_ESTRUC_EMP_ALL: {
			ps = this.selectByEstrucEmpAll(aCondiciones);
			break;
		}		
		case SELECT_BY_ESTEMP_SECTOR: {
			ps = this.selectByEstrucEmpSector(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_ESTRUC_SEC = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  rhEstrucNivSec ");
		textSQL.append(" WHERE oid_estruc_sec = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_ESTRUC_SEC, oid);
		return querySelect;
	}

	private PreparedStatement selectByEstrucEmpSector(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  rhEstrucNivSec ");
		textSQL.append(" WHERE oid_estruc_emp = ? and oid_val_clasif_sec = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		EstrucNivEmpresa estrucNivEmpresa = (EstrucNivEmpresa) condiciones.get(EstrucNivEmpresa.NICKNAME);
		ValorClasificadorEntidad valClasifEnt = (ValorClasificadorEntidad) condiciones.get(ValorClasificadorEntidad.NICKNAME);
		querySelect.setInt(1, estrucNivEmpresa.getOID());
		querySelect.setInt(2, valClasifEnt.getOID());
		return querySelect;
	}

	private PreparedStatement selectByEstrucEmp(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  rhEstrucNivSec ");
		textSQL.append(" WHERE oid_estruc_emp = ? and activo = 1 ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		EstrucNivEmpresa nivEmpresa = (EstrucNivEmpresa) aCondiciones;
		querySelect.setInt(1, nivEmpresa.getOID());
		return querySelect;
	}
	
	private PreparedStatement selectByEstrucEmpAll(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  rhEstrucNivSec ");
		textSQL.append(" WHERE oid_estruc_emp = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		EstrucNivEmpresa nivEmpresa = (EstrucNivEmpresa) aCondiciones;
		querySelect.setInt(1, nivEmpresa.getOID());
		return querySelect;
	}	

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  rhEstrucNivSec ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_estruc_sec oid, codigo,  descripcion ,activo ");
		textSQL.append(" from rhEstrucNivSec");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static List getSectoresActivos(EstrucNivEmpresa estrucNivEmpresa, ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(EstrucNivSector.NICKNAME, DBEstrucNivSector.SELECT_BY_ESTRUC_EMP, estrucNivEmpresa, new ListObserver(), aSesion);
	}
	
	public static List getSectoresActivosAll(EstrucNivEmpresa estrucNivEmpresa, ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(EstrucNivSector.NICKNAME, DBEstrucNivSector.SELECT_BY_ESTRUC_EMP_ALL, estrucNivEmpresa, new ListObserver(), aSesion);
	}	

	public static EstrucNivSector getEstrucNivSector(EstrucNivEmpresa estrucNivEmpresa, ValorClasificadorEntidad valClasifSec, ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(EstrucNivEmpresa.NICKNAME, estrucNivEmpresa);
		condiciones.put(ValorClasificadorEntidad.NICKNAME, valClasifSec);
		return (EstrucNivSector) ObjetoLogico.getObjects(EstrucNivSector.NICKNAME, DBEstrucNivSector.SELECT_BY_ESTEMP_SECTOR, condiciones, new ObjetoObservado(), aSesion);
	}

}
