package com.srn.erp.stock.da;

import java.sql.*;
import java.util.List;

import com.srn.erp.general.bm.PeriodoInc;
import com.srn.erp.general.bm.PeriodoIncDet;
import com.srn.erp.general.da.DBPeriodoIncDet;
import com.srn.erp.stock.bm.*;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.*;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.*;

public class DBConfConsGenStockFil extends DBObjetoPersistente {

	public static final String OID_FIL_CONF_CONS = "oid_fil_conf_cons";
	public static final String OID_CONF_CONS_STK = "oid_conf_cons_stk";
	public static final String OID_CLASIF_ENT = "oid_clasif_ent";
	public static final String FILTRA_POR_CODIGO = "filtra_por_codigo";
	public static final String FILTRA_POR_DESC = "filtra_por_desc";
	public static final String ACTIVO = "activo";
	public static final String ORDEN_POR_CODIGO = "orden_por_codigo";
	public static final String ORDEN_POR_DESC = "orden_por_desc";

	public static final int SELECT_BY_CONF_CONS_STK = 100;
	public static final int SELECT_BY_FIL_POR_CODIGO = 101;
	public static final int SELECT_BY_FIL_POR_DESC = 102;

	public DBConfConsGenStockFil() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_FIL_CONF_CONS = 1;
		final int OID_CONF_CONS_STK = 2;
		final int OID_CLASIF_ENT = 3;
		final int FILTRA_POR_CODIGO = 4;
		final int FILTRA_POR_DESC = 5;
		final int ACTIVO = 6;
		final int ORDEN_POR_CODIGO = 7;
		final int ORDEN_POR_DESC = 8;

		ConfConsGenStockFil pers = (ConfConsGenStockFil) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into skFilConfConsStk " + " ( " + "OID_FIL_CONF_CONS," + "OID_CONF_CONS_STK," + "OID_CLASIF_ENT,"
				+ "FILTRA_POR_CODIGO," + "FILTRA_POR_DESC," + "ACTIVO,ORDEN_POR_CODIGO,ORDEN_POR_DESC)" + " values " + "(" + "?," + "?,"
				+ "?," + "?," + "?," + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_FIL_CONF_CONS, pers.getOID());
		qInsert.setInt(OID_CONF_CONS_STK, pers.getConf_cons_stock().getOID());
		qInsert.setInt(OID_CLASIF_ENT, pers.getClasificador_entidad().getOID());
		qInsert.setBoolean(FILTRA_POR_CODIGO, pers.isFiltra_por_codigo().booleanValue());
		qInsert.setBoolean(FILTRA_POR_DESC, pers.isFiltra_por_desc().booleanValue());
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		if (pers.getOrdenPorCodigo() != null)
			qInsert.setInt(ORDEN_POR_CODIGO, pers.getOrdenPorCodigo().intValue());
		else
			qInsert.setNull(ORDEN_POR_CODIGO, java.sql.Types.INTEGER);
		if (pers.getOrdenPorDesc() != null)
			qInsert.setInt(ORDEN_POR_DESC, pers.getOrdenPorDesc().intValue());
		else
			qInsert.setNull(ORDEN_POR_DESC, java.sql.Types.INTEGER);

		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_CONF_CONS_STK = 1;
		final int OID_CLASIF_ENT = 2;
		final int FILTRA_POR_CODIGO = 3;
		final int FILTRA_POR_DESC = 4;
		final int ACTIVO = 5;
		final int ORDEN_POR_CODIGO = 6;
		final int ORDEN_POR_DESC = 7;
		final int OID_FIL_CONF_CONS = 8;

		ConfConsGenStockFil pers = (ConfConsGenStockFil) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update skFilConfConsStk set " + "oid_conf_cons_stk=?" + ",oid_clasif_ent=?" + ",filtra_por_codigo=?"
				+ ",filtra_por_desc=?" + ",activo=?" + ",orden_por_codigo=?" + ",orden_por_desc=?" + " where " + " oid_fil_conf_cons=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_FIL_CONF_CONS, pers.getOID());
		qUpdate.setInt(OID_CONF_CONS_STK, pers.getConf_cons_stock().getOID());
		qUpdate.setInt(OID_CLASIF_ENT, pers.getClasificador_entidad().getOID());
		qUpdate.setBoolean(FILTRA_POR_CODIGO, pers.isFiltra_por_codigo().booleanValue());
		qUpdate.setBoolean(FILTRA_POR_DESC, pers.isFiltra_por_desc().booleanValue());
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		if (pers.getOrdenPorCodigo() != null)
			qUpdate.setInt(ORDEN_POR_CODIGO, pers.getOrdenPorCodigo().intValue());
		else
			qUpdate.setNull(ORDEN_POR_CODIGO, java.sql.Types.INTEGER);
		if (pers.getOrdenPorDesc() != null)
			qUpdate.setInt(ORDEN_POR_DESC, pers.getOrdenPorDesc().intValue());
		else
			qUpdate.setNull(ORDEN_POR_DESC, java.sql.Types.INTEGER);

		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_FIL_CONF_CONS = 1;
		ConfConsGenStockFil pers = (ConfConsGenStockFil) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update skFilConfConsStk " + " set activo=0 " + " where " + " oid_fil_conf_cons=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_FIL_CONF_CONS, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_FIL_CONF_CONS = 1;
		ConfConsGenStockFil pers = (ConfConsGenStockFil) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update skFilConfConsStk " + " set activo=1 " + " where " + " oid_fil_conf_cons=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_FIL_CONF_CONS, pers.getOID());
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
		case SELECT_BY_CONF_CONS_STK: {
			ps = this.selectByConfConsStk(aCondiciones);
			break;
		}
		case SELECT_BY_FIL_POR_CODIGO: {
			ps = this.selectByFilPorCodigo(aCondiciones);
			break;
		}
		case SELECT_BY_FIL_POR_DESC: {
			ps = this.selectByFilPorDesc(aCondiciones);
			break;
		}

		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_FIL_CONF_CONS = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  skFilConfConsStk ");
		textSQL.append(" WHERE oid_fil_conf_cons = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_FIL_CONF_CONS, oid);
		return querySelect;
	}

	private PreparedStatement selectByConfConsStk(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  skFilConfConsStk ");
		textSQL.append(" WHERE oid_conf_cons_stk = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		ConfConsGenStock confConsStk = (ConfConsGenStock) aCondiciones;
		querySelect.setInt(1, confConsStk.getOID());
		return querySelect;
	}

	private PreparedStatement selectByFilPorCodigo(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  skFilConfConsStk ");
		textSQL.append(" WHERE oid_conf_cons_stk = ? and filtra_por_codigo = 1 and activo = 1 order by orden_por_codigo ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());

		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		ConfConsGenStock confConsGenStock = (ConfConsGenStock) condiciones.get(ConfConsGenStock.NICKNAME);

		querySelect.setInt(1, confConsGenStock.getOID());
		return querySelect;
	}

	private PreparedStatement selectByFilPorDesc(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  skFilConfConsStk ");
		textSQL.append(" WHERE oid_conf_cons_stk = ? and filtra_por_desc = 1 and activo = 1 order by orden_por_desc");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());

		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		ConfConsGenStock confConsGenStock = (ConfConsGenStock) condiciones.get(ConfConsGenStock.NICKNAME);

		querySelect.setInt(1, confConsGenStock.getOID());
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  skFilConfConsStk ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_fil_conf_cons oid, codigo,  descripcion ,activo ");
		textSQL.append(" from skFilConfConsStk");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static List getConfStockFiltros(ConfConsGenStock confConsStk, ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(ConfConsGenStockFil.NICKNAME, DBConfConsGenStockFil.SELECT_BY_CONF_CONS_STK, confConsStk,
				new ListObserver(), aSesion);
	}

	public static List getConfStockFiltrosPorCodigo(ConfConsGenStock confConsStk, ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(ConfConsGenStock.NICKNAME, confConsStk);
		return (List) ObjetoLogico.getObjects(ConfConsGenStockFil.NICKNAME, DBConfConsGenStockFil.SELECT_BY_FIL_POR_CODIGO, condiciones,
				new ListObserver(), aSesion);
	}
	
	public static List getConfStockFiltrosPorDesc(ConfConsGenStock confConsStk, ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(ConfConsGenStock.NICKNAME, confConsStk);
		return (List) ObjetoLogico.getObjects(ConfConsGenStockFil.NICKNAME, DBConfConsGenStockFil.SELECT_BY_FIL_POR_DESC, condiciones,
				new ListObserver(), aSesion);
	}
	

}
