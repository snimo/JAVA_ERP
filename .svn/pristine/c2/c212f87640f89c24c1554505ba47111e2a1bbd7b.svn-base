package com.srn.erp.stock.da;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.srn.erp.stock.bm.Deposito;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.bm.StockDia;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBStockDia extends DBObjetoPersistente {

	public static final String OID_STK_DIA = "oid_stk_dia";

	public static final String OID_DEPOSITO = "oid_deposito";

	public static final String OID_PRODUCTO = "oid_producto";

	public static final String OID_UM_STK = "oid_um_stk";

	public static final String ENTRADAS = "entradas";

	public static final String SALIDAS = "salidas";

	public static final String FECHA = "fecha";

	public static final int SELECT_BY_PROD_DEPO_FECHA = 100;

	public DBStockDia() {
	}

	protected void insert(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {

		final int OID_STK_DIA = 1;
		final int OID_DEPOSITO = 2;
		final int OID_PRODUCTO = 3;
		final int OID_UM_STK = 4;
		final int ENTRADAS = 5;
		final int SALIDAS = 6;
		final int FECHA = 7;

		StockDia pers = (StockDia) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into skStockDia " + " ( " + "OID_STK_DIA,"
				+ "OID_DEPOSITO," + "OID_PRODUCTO," + "OID_UM_STK,"
				+ "ENTRADAS," + "SALIDAS," + "FECHA)" + " values " + "(" + "?,"
				+ "?," + "?," + "?," + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD()
				.prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_STK_DIA, pers.getOID());
		qInsert.setInt(OID_DEPOSITO, pers.getDeposito().getOID());
		qInsert.setInt(OID_PRODUCTO, pers.getProducto().getOID());
		qInsert.setInt(OID_UM_STK, pers.getUni_med().getOID());
		qInsert.setDouble(ENTRADAS, pers.getEntradas().doubleValue());
		qInsert.setDouble(SALIDAS, pers.getSalidas().doubleValue());
		qInsert.setDate(FECHA, new Date(pers.getFecha().getTime()));
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {

		final int ENTRADAS = 1;
		final int SALIDAS = 2;
		final int OID_STK_DIA = 3;

		StockDia pers = (StockDia) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update skStockDia set entradas=entradas+?"
				+ ",salidas=salidas+? where " + " oid_stk_dia=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_STK_DIA, pers.getOID());
		qUpdate.setDouble(ENTRADAS, pers.getEntradas().doubleValue());
		qUpdate.setDouble(SALIDAS, pers.getSalidas().doubleValue());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {
		final int OID_STK_DIA = 1;
		StockDia pers = (StockDia) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update skStockDia " + " set activo=0 " + " where "
				+ " oid_stk_dia=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_STK_DIA, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {
		final int OID_STK_DIA = 1;
		StockDia pers = (StockDia) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update skStockDia " + " set activo=1 " + " where "
				+ " oid_stk_dia=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_STK_DIA, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	public PreparedStatement prepararSelect(int aSelect, Object aCondiciones)
			throws BaseException, SQLException {
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
		case SELECT_BY_PROD_DEPO_FECHA: {
			ps = this.selectByProdDepoFecha(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones)
			throws BaseException, SQLException {

		final int OID_STK_DIA = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  skStockDia ");
		textSQL.append(" WHERE oid_stk_dia = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_STK_DIA, oid);
		return querySelect;
	}

	private PreparedStatement selectByProdDepoFecha(Object aCondiciones)
			throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  skStockDia ");
		textSQL
				.append(" WHERE oid_producto = ? and oid_deposito = ? and fecha = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		Deposito deposito = (Deposito) condiciones.get(Deposito.NICKNAME);
		Producto producto = (Producto) condiciones.get(Producto.NICKNAME);
		java.util.Date fecha = (java.util.Date) condiciones.get("FECHA");
		querySelect.setInt(1, producto.getOID());
		querySelect.setInt(2, deposito.getOID());
		querySelect.setDate(3, new java.sql.Date(fecha.getTime()));
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones)
			throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  skStockDia ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones)
			throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_stk_dia oid, codigo,  descripcion ,activo ");
		textSQL.append(" from skStockDia");

		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static StockDia getStockDia(Producto producto,
									   Deposito deposito,
									   java.util.Date fecha,
			ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(Producto.NICKNAME,producto);
		condiciones.put(Deposito.NICKNAME,deposito);
		condiciones.put("FECHA",fecha);
		return (StockDia) ObjetoLogico.getObjects(StockDia.NICKNAME,
				DBStockDia.SELECT_BY_PROD_DEPO_FECHA, condiciones,
				new ObjetoObservado(), aSesion);
	}

}
