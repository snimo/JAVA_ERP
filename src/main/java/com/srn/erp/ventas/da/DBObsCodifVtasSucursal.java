package com.srn.erp.ventas.da;

import java.sql.*;
import java.util.List;

import com.srn.erp.general.bm.PeriodoInc;
import com.srn.erp.general.bm.PeriodoIncDet;
import com.srn.erp.general.da.DBPeriodoIncDet;
import com.srn.erp.ventas.bm.*;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.*;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.*;

public class DBObsCodifVtasSucursal extends DBObjetoPersistente {

	public static final String OID_OBS_COD_UO = "oid_obs_cod_uo";
	public static final String OID_OBS_COD = "oid_obs_cod";
	public static final String OID_SUCURSAL = "oid_sucursal";
	public static final String ACTIVO = "activo";

	public static final int SELECT_BY_COD_OBS = 100;

	public DBObsCodifVtasSucursal() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_OBS_COD_UO = 1;
		final int OID_OBS_COD = 2;
		final int OID_SUCURSAL = 3;
		final int ACTIVO = 4;

		ObsCodifVtasSucursal pers = (ObsCodifVtasSucursal) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into veObsCodVtasSuc " + " ( " + "OID_OBS_COD_UO," + "OID_OBS_COD," + "OID_SUCURSAL," + "ACTIVO)"
				+ " values " + "(" + "?," + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_OBS_COD_UO, pers.getOID());
		qInsert.setInt(OID_OBS_COD, pers.getCodigo_observacion().getOID());
		qInsert.setInt(OID_SUCURSAL, pers.getSucursal().getOID());
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_OBS_COD = 1;
		final int OID_SUCURSAL = 2;
		final int ACTIVO = 3;
		final int OID_OBS_COD_UO = 4;

		ObsCodifVtasSucursal pers = (ObsCodifVtasSucursal) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update veObsCodVtasSuc set " + "oid_obs_cod=?" + ",oid_sucursal=?" + ",activo=?" + " where "
				+ " oid_obs_cod_uo=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_OBS_COD_UO, pers.getOID());
		qUpdate.setInt(OID_OBS_COD, pers.getCodigo_observacion().getOID());
		qUpdate.setInt(OID_SUCURSAL, pers.getSucursal().getOID());
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_OBS_COD_UO = 1;
		ObsCodifVtasSucursal pers = (ObsCodifVtasSucursal) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update veObsCodVtasSuc " + " set activo=0 " + " where " + " oid_obs_cod_uo=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_OBS_COD_UO, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_OBS_COD_UO = 1;
		ObsCodifVtasSucursal pers = (ObsCodifVtasSucursal) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update veObsCodVtasSuc " + " set activo=1 " + " where " + " oid_obs_cod_uo=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_OBS_COD_UO, pers.getOID());
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
		case SELECT_BY_COD_OBS: {
			ps = this.selectByCodObs(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_OBS_COD_UO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  veObsCodVtasSuc ");
		textSQL.append(" WHERE oid_obs_cod_uo = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_OBS_COD_UO, oid);
		return querySelect;
	}

	private PreparedStatement selectByCodObs(Object aCondiciones) throws BaseException, SQLException {

		ObsCodifVtas obsCod = (ObsCodifVtas) aCondiciones;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  veObsCodVtasSuc ");
		textSQL.append(" WHERE oid_obs_cod = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		querySelect.setInt(1, obsCod.getOID());
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  veObsCodVtasSuc ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_obs_cod_uo oid, codigo,  descripcion ,activo ");
		textSQL.append(" from veObsCodVtasSuc");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}
	
	  public static List getObsCodSucursal(ObsCodifVtas obsCod,
              ISesion aSesion) throws BaseException {
		  return (List) ObjetoLogico.getObjects(ObsCodifVtasSucursal.NICKNAME,
                 DBObsCodifVtasSucursal.SELECT_BY_COD_OBS,
                 obsCod,
                 new ListObserver(),
                 aSesion);
	  }
	

}
