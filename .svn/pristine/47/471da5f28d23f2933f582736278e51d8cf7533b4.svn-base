package com.srn.erp.rrhh.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.general.bm.Periodo;
import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.general.da.DBPeriodo;
import com.srn.erp.rrhh.bm.EstrucNivPuesto;
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

public class DBEstrucNivPuesto extends DBObjetoPersistente {

	public static final String OID_ESTRUC_PUE = "oid_estruc_pue";
	public static final String OID_ESTRUC_SEC = "oid_estruc_sec";
	public static final String OID_VAL_CLASIF_PUE = "oid_val_clasif_pue";
	public static final String ACTIVO = "activo";

	public static final int SELECT_BY_ESTRUC_SECTOR = 100;
	public static final int SELECT_BY_SECTOR_PUESTO = 101;
	public static final int SELECT_BY_ESTRUC_SECTOR_ALL = 102;

	public DBEstrucNivPuesto() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_ESTRUC_PUE = 1;
		final int OID_ESTRUC_SEC = 2;
		final int OID_VAL_CLASIF_PUE = 3;
		final int ACTIVO = 4;

		EstrucNivPuesto pers = (EstrucNivPuesto) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into rhEstrucNivPue " + " ( " + "OID_ESTRUC_PUE," + "OID_ESTRUC_SEC," + "OID_VAL_CLASIF_PUE," + "ACTIVO)" + " values " + "(" + "?," + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_ESTRUC_PUE, pers.getOID());
		qInsert.setInt(OID_ESTRUC_SEC, pers.getOid_estruc_sector().getOID());
		qInsert.setInt(OID_VAL_CLASIF_PUE, pers.getValor_clasif_puesto().getOID());
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_ESTRUC_SEC = 1;
		final int OID_VAL_CLASIF_PUE = 2;
		final int ACTIVO = 3;
		final int OID_ESTRUC_PUE = 4;

		EstrucNivPuesto pers = (EstrucNivPuesto) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update rhEstrucNivPue set " + "oid_estruc_sec=?" + ",oid_val_clasif_pue=?" + ",activo=?" + " where " + " oid_estruc_pue=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_ESTRUC_PUE, pers.getOID());
		qUpdate.setInt(OID_ESTRUC_SEC, pers.getOid_estruc_sector().getOID());
		qUpdate.setInt(OID_VAL_CLASIF_PUE, pers.getValor_clasif_puesto().getOID());
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_ESTRUC_PUE = 1;
		EstrucNivPuesto pers = (EstrucNivPuesto) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update rhEstrucNivPue " + " set activo=0 " + " where " + " oid_estruc_pue=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_ESTRUC_PUE, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_ESTRUC_PUE = 1;
		EstrucNivPuesto pers = (EstrucNivPuesto) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update rhEstrucNivPue " + " set activo=1 " + " where " + " oid_estruc_pue=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_ESTRUC_PUE, pers.getOID());
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
		case SELECT_BY_ESTRUC_SECTOR: {
			ps = this.selectByEstrucSector(aCondiciones);
			break;
		}
		case SELECT_BY_SECTOR_PUESTO: {
			ps = this.selectByEstrucSectorPuesto(aCondiciones);
			break;
		}
		case SELECT_BY_ESTRUC_SECTOR_ALL: {
			ps = this.selectByEstrucSectorAll(aCondiciones);
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_ESTRUC_PUE = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  rhEstrucNivPue ");
		textSQL.append(" WHERE oid_estruc_pue = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_ESTRUC_PUE, oid);
		return querySelect;
	}

	private PreparedStatement selectByEstrucSectorPuesto(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  rhEstrucNivPue ");
		textSQL.append(" WHERE oid_estruc_sec = ? and oid_val_clasif_pue = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		EstrucNivSector estrucNivSector = (EstrucNivSector) condiciones.get(EstrucNivSector.NICKNAME);
		ValorClasificadorEntidad valClasifEnt = (ValorClasificadorEntidad) condiciones.get(ValorClasificadorEntidad.NICKNAME);
		querySelect.setInt(1, estrucNivSector.getOID());
		querySelect.setInt(2, valClasifEnt.getOID());
		return querySelect;
	}
	
	
	
	private PreparedStatement selectByEstrucSector(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  rhEstrucNivPue ");
		textSQL.append(" WHERE oid_estruc_sec = ? and activo = 1 ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		EstrucNivSector estrucNivSector = (EstrucNivSector) aCondiciones;
		querySelect.setInt(1, estrucNivSector.getOID());
		return querySelect;
	}
	
	private PreparedStatement selectByEstrucSectorAll(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  rhEstrucNivPue ");
		textSQL.append(" WHERE oid_estruc_sec = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		EstrucNivSector estrucNivSector = (EstrucNivSector) aCondiciones;
		querySelect.setInt(1, estrucNivSector.getOID());
		return querySelect;
	}	

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  rhEstrucNivPue ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_estruc_pue oid, codigo,  descripcion ,activo ");
		textSQL.append(" from rhEstrucNivPue");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static List getPuestosActivos(EstrucNivSector estrucNivSector, ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(EstrucNivPuesto.NICKNAME, DBEstrucNivPuesto.SELECT_BY_ESTRUC_SECTOR, estrucNivSector, new ListObserver(), aSesion);
	}
	
	public static List getPuestos(EstrucNivSector estrucNivSector, ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(EstrucNivPuesto.NICKNAME, DBEstrucNivPuesto.SELECT_BY_ESTRUC_SECTOR_ALL, estrucNivSector, new ListObserver(), aSesion);
	}	
	
	public static EstrucNivPuesto getEstrucNivPuesto(
			  EstrucNivSector aEstrucNivSector,
			  ValorClasificadorEntidad valClasifEnt,
	          ISesion aSesion)
	          throws BaseException {
		  HashTableDatos condiciones = new HashTableDatos();
		  condiciones.put(EstrucNivSector.NICKNAME, aEstrucNivSector);
		  condiciones.put(ValorClasificadorEntidad.NICKNAME, valClasifEnt);
		  return (EstrucNivPuesto) ObjetoLogico.getObjects(EstrucNivPuesto.NICKNAME,
				  				DBEstrucNivPuesto.SELECT_BY_SECTOR_PUESTO,
				  				condiciones,
				  				new ObjetoObservado(),
				  				aSesion);
	}
	

}
