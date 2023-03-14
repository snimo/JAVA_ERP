package com.srn.erp.ventas.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.ventas.bm.IngStockDevVtasDet;
import com.srn.erp.ventas.bm.IngresoDevolucionStockCab;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBIngStockDevVtasDet extends DBObjetoPersistente {

	public static final String OID_ING_STK_DET = "oid_ing_stk_det";
	public static final String OID_ING_DEV_STK = "oid_ing_dev_stk";
	public static final String OID_DEV_DET = "oid_dev_det";
	public static final String CANTIDAD = "cantidad";
	public static final String OID_UM = "oid_um";
	public static final String OID_MOV_STOCK = "oid_mov_stock";
	
	public static final int SELECT_BY_ING_DEV_STOCK = 100;

	public DBIngStockDevVtasDet() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_ING_STK_DET = 1;
		final int OID_ING_DEV_STK = 2;
		final int OID_DEV_DET = 3;
		final int CANTIDAD = 4;
		final int OID_UM = 5;
		final int OID_MOV_STOCK = 6;

		IngStockDevVtasDet pers = (IngStockDevVtasDet) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into veIngDevStkDet " + " ( " + "OID_ING_STK_DET," + "OID_ING_DEV_STK," + "OID_DEV_DET," + "CANTIDAD,"
				+ "OID_UM," + "OID_MOV_STOCK)" + " values " + "(" + "?," + "?," + "?," + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_ING_STK_DET, pers.getOID());
		qInsert.setInt(OID_ING_DEV_STK, pers.getIngresodevolucionstockcab().getOID());
		qInsert.setInt(OID_DEV_DET, pers.getDevolucion_det().getOID());
		qInsert.setDouble(CANTIDAD, pers.getCantidad().doubleValue());
		qInsert.setInt(OID_UM, pers.getUnidad_medida().getOID());
		qInsert.setInt(OID_MOV_STOCK, pers.getMovimiento_stock().getOID());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_ING_DEV_STK = 1;
		final int OID_DEV_DET = 2;
		final int CANTIDAD = 3;
		final int OID_UM = 4;
		final int OID_MOV_STOCK = 5;
		final int OID_ING_STK_DET = 6;

		IngStockDevVtasDet pers = (IngStockDevVtasDet) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update veIngDevStkDet set " + "oid_ing_dev_stk=?" + ",oid_dev_det=?" + ",cantidad=?" + ",oid_um=?"
				+ ",oid_mov_stock=?" + " where " + " oid_ing_stk_det=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_ING_STK_DET, pers.getOID());
		qUpdate.setInt(OID_ING_DEV_STK, pers.getIngresodevolucionstockcab().getOID());
		qUpdate.setInt(OID_DEV_DET, pers.getDevolucion_det().getOID());
		qUpdate.setDouble(CANTIDAD, pers.getCantidad().doubleValue());
		qUpdate.setInt(OID_UM, pers.getUnidad_medida().getOID());
		qUpdate.setInt(OID_MOV_STOCK, pers.getMovimiento_stock().getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_ING_STK_DET = 1;
		IngStockDevVtasDet pers = (IngStockDevVtasDet) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update veIngDevStkDet " + " set activo=0 " + " where " + " oid_ing_stk_det=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_ING_STK_DET, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_ING_STK_DET = 1;
		IngStockDevVtasDet pers = (IngStockDevVtasDet) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update veIngDevStkDet " + " set activo=1 " + " where " + " oid_ing_stk_det=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_ING_STK_DET, pers.getOID());
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
		case SELECT_BY_ING_DEV_STOCK: {
			ps = this.selectByIngDevStock(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_ING_STK_DET = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  veIngDevStkDet ");
		textSQL.append(" WHERE oid_ing_stk_det = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_ING_STK_DET, oid);
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  veIngDevStkDet ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}
	
	private PreparedStatement selectByIngDevStock(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  veIngDevStkDet ");
		textSQL.append(" WHERE oid_ing_dev_stk = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		IngresoDevolucionStockCab ingresoDevolucionStock = (IngresoDevolucionStockCab) aCondiciones;
		querySelect.setInt(1, ingresoDevolucionStock.getOID());
		return querySelect;
		
	}
	
	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_ing_stk_det oid, codigo,  descripcion ,activo ");
		textSQL.append(" from veIngDevStkDet");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}
	
	  public static List getIngresoDevolucionesDet(IngresoDevolucionStockCab ingresoDevolucion, ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(IngStockDevVtasDet.NICKNAME, DBIngStockDevVtasDet.SELECT_BY_ING_DEV_STOCK, ingresoDevolucion,
				new ListObserver(), aSesion);
	}
	

}
