package com.srn.erp.cip.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.cip.bm.PermisoInternoEmpresa;
import com.srn.erp.cip.bm.ReglasPermisosInt;
import com.srn.erp.general.bm.Periodo;
import com.srn.erp.general.bm.PeriodoInc;
import com.srn.erp.general.bm.PeriodoIncDet;
import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.general.da.DBPeriodo;
import com.srn.erp.general.da.DBPeriodoIncDet;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBPermisoInternoEmpresa extends DBObjetoPersistente {

	public static final String OID_PERM_INT_EMP = "oid_perm_int_emp";
	public static final String OID_REGLA_PERMISO = "oid_regla_permiso";
	public static final String OID_VAL_CLASIF_EMP = "oid_val_clasif_emp";
	public static final String ACTIVO = "activo";
	
	public static final int SELECT_BY_REGLA_VALOR_ACTIVO = 100;
	public static final int SELECT_BY_REGLA = 101;

	public DBPermisoInternoEmpresa() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_PERM_INT_EMP = 1;
		final int OID_REGLA_PERMISO = 2;
		final int OID_VAL_CLASIF_EMP = 3;
		final int ACTIVO = 4;

		PermisoInternoEmpresa pers = (PermisoInternoEmpresa) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into cipPermIntEmp " + " ( " + "OID_PERM_INT_EMP," + "OID_REGLA_PERMISO," + "OID_VAL_CLASIF_EMP," + "ACTIVO)" + " values " + "(" + "?," + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_PERM_INT_EMP, pers.getOID());
		qInsert.setInt(OID_REGLA_PERMISO, pers.getRegla_permiso().getOID());
		qInsert.setInt(OID_VAL_CLASIF_EMP, pers.getVal_clasif_empresa().getOID());
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_REGLA_PERMISO = 1;
		final int OID_VAL_CLASIF_EMP = 2;
		final int ACTIVO = 3;
		final int OID_PERM_INT_EMP = 4;

		PermisoInternoEmpresa pers = (PermisoInternoEmpresa) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update cipPermIntEmp set " + "oid_regla_permiso=?" + ",oid_val_clasif_emp=?" + ",activo=?" + " where " + " oid_perm_int_emp=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_PERM_INT_EMP, pers.getOID());
		qUpdate.setInt(OID_REGLA_PERMISO, pers.getRegla_permiso().getOID());
		qUpdate.setInt(OID_VAL_CLASIF_EMP, pers.getVal_clasif_empresa().getOID());
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_PERM_INT_EMP = 1;
		PermisoInternoEmpresa pers = (PermisoInternoEmpresa) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cipPermIntEmp " + " set activo=0 " + " where " + " oid_perm_int_emp=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_PERM_INT_EMP, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_PERM_INT_EMP = 1;
		PermisoInternoEmpresa pers = (PermisoInternoEmpresa) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cipPermIntEmp " + " set activo=1 " + " where " + " oid_perm_int_emp=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_PERM_INT_EMP, pers.getOID());
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
		case SELECT_BY_REGLA_VALOR_ACTIVO: {
			ps = this.selectByReglaValorActivo(aCondiciones);
			break;			
		}
		case SELECT_BY_REGLA: {
			ps = this.selectByRegla(aCondiciones);
			break;			
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_PERM_INT_EMP = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cipPermIntEmp ");
		textSQL.append(" WHERE oid_perm_int_emp = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_PERM_INT_EMP, oid);
		return querySelect;
	}

	private PreparedStatement selectByReglaValorActivo(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cipPermIntEmp ");
		textSQL.append(" WHERE oid_regla_permiso = ? and oid_val_clasif_emp= ? and activo = 1 ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		ReglasPermisosInt reglaPermisoInt = (ReglasPermisosInt) condiciones.get(ReglasPermisosInt.NICKNAME);
		ValorClasificadorEntidad valorClasifEnt = (ValorClasificadorEntidad) condiciones.get(ValorClasificadorEntidad.NICKNAME);
		
		querySelect.setInt(1, reglaPermisoInt.getOID());
		querySelect.setInt(2, valorClasifEnt.getOID());
		
		return querySelect;
	}	
	
	
	private PreparedStatement selectByRegla(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cipPermIntEmp ");
		textSQL.append(" WHERE oid_regla_permiso = ? and activo=1 ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		ReglasPermisosInt regla = (ReglasPermisosInt) aCondiciones;
		querySelect.setInt(1, regla.getOIDInteger());
		return querySelect;
	}	
	
	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cipPermIntEmp ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_perm_int_emp oid, codigo,  descripcion ,activo ");
		textSQL.append(" from cipPermIntEmp");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}
	
	  public static PermisoInternoEmpresa getPermisoInternoEmpresa(
			  ReglasPermisosInt reglaPermiso,
			  ValorClasificadorEntidad valor,
	          ISesion aSesion)
	          throws BaseException {
		  HashTableDatos condiciones = new HashTableDatos();
		  condiciones.put(ReglasPermisosInt.NICKNAME, reglaPermiso);
		  condiciones.put(ValorClasificadorEntidad.NICKNAME,valor);
		  
		  return (PermisoInternoEmpresa) ObjetoLogico.getObjects(PermisoInternoEmpresa.NICKNAME,
				  				DBPermisoInternoEmpresa.SELECT_BY_REGLA_VALOR_ACTIVO,
				  				condiciones,
				  				new ObjetoObservado(),
				  				aSesion);
	  }
	  
	  public static List getPermisosIntEmpresa(ReglasPermisosInt regla,
              ISesion aSesion) throws BaseException {
		  return (List) ObjetoLogico.getObjects(PermisoInternoEmpresa.NICKNAME,
                 DBPermisoInternoEmpresa.SELECT_BY_REGLA,
                 regla,
                 new ListObserver(),
                 aSesion);
	  }
	  

}
