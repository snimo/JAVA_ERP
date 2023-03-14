package com.srn.erp.cip.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.cip.bm.PermisoInternoSector;
import com.srn.erp.cip.bm.ReglasPermisosInt;
import com.srn.erp.general.bm.ValorClasificadorEntidad;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBPermisoInternoSector extends DBObjetoPersistente {

	public static final String OID_PERM_INT_SEC = "oid_perm_int_sec";
	public static final String OID_REGLA_PERMISO = "oid_regla_permiso";
	public static final String OID_VAL_CLASIF_SEC = "oid_val_clasif_sec";
	public static final String ACTIVO = "activo";
	
	public static final int SELECT_BY_REGLA = 100;
	public static final int SELECT_BY_REGLA_VALCLASIF = 101;

	public DBPermisoInternoSector() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_PERM_INT_SEC = 1;
		final int OID_REGLA_PERMISO = 2;
		final int OID_VAL_CLASIF_EMP = 3;
		final int ACTIVO = 4;

		PermisoInternoSector pers = (PermisoInternoSector) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into cipPermIntSec " + " ( " + "OID_PERM_INT_SEC," + "OID_REGLA_PERMISO," + "OID_VAL_CLASIF_SEC," + "ACTIVO)" + " values " + "(" + "?," + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_PERM_INT_SEC, pers.getOID());
		qInsert.setInt(OID_REGLA_PERMISO, pers.getRegla_permiso().getOID());
		qInsert.setInt(OID_VAL_CLASIF_EMP, pers.getVal_clasif_sector().getOID());
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_REGLA_PERMISO = 1;
		final int OID_VAL_CLASIF_EMP = 2;
		final int ACTIVO = 3;
		final int OID_PERM_INT_SEC = 4;

		PermisoInternoSector pers = (PermisoInternoSector) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update cipPermIntSec set " + "oid_regla_permiso=?" + ",oid_val_clasif_sec=?" + ",activo=?" + " where " + " oid_perm_int_sec=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_PERM_INT_SEC, pers.getOID());
		qUpdate.setInt(OID_REGLA_PERMISO, pers.getRegla_permiso().getOID());
		qUpdate.setInt(OID_VAL_CLASIF_EMP, pers.getVal_clasif_sector().getOID());
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_PERM_INT_SEC = 1;
		PermisoInternoSector pers = (PermisoInternoSector) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cipPermIntSec " + " set activo=0 " + " where " + " oid_perm_int_sec=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_PERM_INT_SEC, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_PERM_INT_SEC = 1;
		PermisoInternoSector pers = (PermisoInternoSector) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cipPermIntSec " + " set activo=1 " + " where " + " oid_perm_int_sec=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_PERM_INT_SEC, pers.getOID());
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
		case SELECT_BY_REGLA: {
			ps = this.selectByRegla(aCondiciones);
			break;			
		}
		case SELECT_BY_REGLA_VALCLASIF: {
			ps = this.selectByReglaValClasif(aCondiciones);
			break;			
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_PERM_INT_SEC = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cipPermIntSec ");
		textSQL.append(" WHERE oid_perm_int_sec = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_PERM_INT_SEC, oid);
		return querySelect;
	}

	
	private PreparedStatement selectByRegla(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cipPermIntSec ");
		textSQL.append(" WHERE oid_regla_permiso = ? and activo = 1 ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		ReglasPermisosInt regla = (ReglasPermisosInt) aCondiciones;
		querySelect.setInt(1, regla.getOID());
		return querySelect;
	}
	
	
	private PreparedStatement selectByReglaValClasif(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cipPermIntSec ");
		textSQL.append(" WHERE oid_regla_permiso = ? and oid_val_clasif_sec = ? and activo = 1 "); 
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		ReglasPermisosInt regla = (ReglasPermisosInt) condiciones.get(ReglasPermisosInt.NICKNAME);
		ValorClasificadorEntidad valorClasifEnt = (ValorClasificadorEntidad) condiciones.get(ValorClasificadorEntidad.NICKNAME);
		querySelect.setInt(1, regla.getOID());
		querySelect.setInt(2, valorClasifEnt.getOID());
		return querySelect;
	}	
	
	
	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cipPermIntSec ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_perm_int_sec oid, codigo,  descripcion ,activo ");
		textSQL.append(" from cipPermIntSec");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}
	
	  public static List getPermisosInternosSec(ReglasPermisosInt regla,
              ISesion aSesion) throws BaseException {
		  return (List) ObjetoLogico.getObjects(PermisoInternoSector.NICKNAME,
                 DBPermisoInternoSector.SELECT_BY_REGLA,
                 regla,
                 new ListObserver(),
                 aSesion);
	  }	
	  
	  public static PermisoInternoSector getPermisoInternoSector(
			  ReglasPermisosInt regla,
			  ValorClasificadorEntidad valor,
	          ISesion aSesion)
	          throws BaseException {
		  
		  HashTableDatos condiciones = new HashTableDatos();
		  condiciones.put(ReglasPermisosInt.NICKNAME, regla);
		  condiciones.put(ValorClasificadorEntidad.NICKNAME, valor);
		  
		  return (PermisoInternoSector) ObjetoLogico.getObjects(PermisoInternoSector.NICKNAME,
				  				DBPermisoInternoSector.SELECT_BY_REGLA_VALCLASIF,
				  				condiciones,
				  				new ObjetoObservado(),
				  				aSesion);
	  }	  

}
