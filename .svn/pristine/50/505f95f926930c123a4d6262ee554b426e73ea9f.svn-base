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

public class DBObsCodifPedidoCab extends DBObjetoPersistente {

	public static final String OID_OBS_CODIF = "oid_obs_codif";
	public static final String OID_CCO_PED = "oid_cco_ped";
	public static final String ORDEN = "orden";
	public static final String OID_OBS_COD = "oid_obs_cod";
	public static final String ACTIVO = "activo";

	public static final int SELECT_BY_PEDIDO = 100;

	public DBObsCodifPedidoCab() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_OBS_CODIF = 1;
		final int OID_CCO_PED = 2;
		final int ORDEN = 3;
		final int OID_OBS_COD = 4;
		final int ACTIVO = 5;

		ObsCodifPedidoCab pers = (ObsCodifPedidoCab) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into veObsCodifPedCab " + " ( " + "OID_OBS_CODIF," + "OID_CCO_PED," + "ORDEN," + "OID_OBS_COD,"
				+ "ACTIVO)" + " values " + "(" + "?," + "?," + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_OBS_CODIF, pers.getOID());
		qInsert.setInt(OID_CCO_PED, pers.getPedido().getOID());
		qInsert.setInt(ORDEN, pers.getOrden().intValue());
		qInsert.setInt(OID_OBS_COD, pers.getObs_codificada().getOID());
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_CCO_PED = 1;
		final int ORDEN = 2;
		final int OID_OBS_COD = 3;
		final int ACTIVO = 4;
		final int OID_OBS_CODIF = 5;

		ObsCodifPedidoCab pers = (ObsCodifPedidoCab) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update veObsCodifPedCab set " + "oid_cco_ped=?" + ",orden=?" + ",oid_obs_cod=?" + ",activo=?" + " where "
				+ " oid_obs_codif=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_OBS_CODIF, pers.getOID());
		qUpdate.setInt(OID_CCO_PED, pers.getPedido().getOID());
		qUpdate.setInt(ORDEN, pers.getOrden().intValue());
		qUpdate.setInt(OID_OBS_COD, pers.getObs_codificada().getOID());
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_OBS_CODIF = 1;
		ObsCodifPedidoCab pers = (ObsCodifPedidoCab) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update veObsCodifPedCab " + " set activo=0 " + " where " + " oid_obs_codif=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_OBS_CODIF, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_OBS_CODIF = 1;
		ObsCodifPedidoCab pers = (ObsCodifPedidoCab) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update veObsCodifPedCab " + " set activo=1 " + " where " + " oid_obs_codif=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_OBS_CODIF, pers.getOID());
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
		case SELECT_BY_PEDIDO: {
			ps = this.selectByPedido(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_OBS_CODIF = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  veObsCodifPedCab ");
		textSQL.append(" WHERE oid_obs_codif = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_OBS_CODIF, oid);
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  veObsCodifPedCab ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectByPedido(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  veObsCodifPedCab ");
		textSQL.append(" WHERE oid_cco_ped = ? order by orden ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		PedidoCab pedido = (PedidoCab) aCondiciones;
		querySelect.setInt(1, pedido.getOID());
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_obs_codif oid, codigo,  descripcion ,activo ");
		textSQL.append(" from veObsCodifPedCab");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}
	
	  public static List getObsCodificasPedido(PedidoCab pedido,
              ISesion aSesion) throws BaseException {
		  return (List) ObjetoLogico.getObjects(ObsCodifPedidoCab.NICKNAME,
                 DBObsCodifPedidoCab.SELECT_BY_PEDIDO,
                 pedido,
                 new ListObserver(),
                 aSesion);
	  }
	

}
