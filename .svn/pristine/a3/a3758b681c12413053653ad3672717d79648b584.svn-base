package com.srn.erp.stock.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.srn.erp.stock.bm.Deposito;
import com.srn.erp.stock.bm.EstadoStock;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.bm.StockEstadoDia;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBStockEstadoDia extends DBObjetoPersistente {

	public static final String OID_STOCK_EST_DIA = "oid_stock_est_dia";

	public static final String FECHA = "fecha";

	public static final String OID_DEPOSITO = "oid_deposito";

	public static final String OID_PRODUCTO = "oid_producto";

	public static final String OID_ESTADO_STOCK = "oid_estado_stock";

	public static final String OID_UM_STK = "oid_um_stk";

	public static final String ENTRADAS = "entradas";

	public static final String SALIDAS = "salidas";

	public static final int SELECT_BY_DEPO_PROD_ESTADO_FECHA = 100;

	public static final int SELECT_SALDO_INICIAL_A_FECHA = 101;

	public DBStockEstadoDia() {
	}

	protected void insert(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {

		final int OID_STOCK_EST_DIA = 1;
		final int FECHA = 2;
		final int OID_DEPOSITO = 3;
		final int OID_PRODUCTO = 4;
		final int OID_ESTADO_STOCK = 5;
		final int OID_UM_STK = 6;
		final int ENTRADAS = 7;
		final int SALIDAS = 8;

		StockEstadoDia pers = (StockEstadoDia) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into skStockEstadoDia " + " ( "
				+ "OID_STOCK_EST_DIA," + "FECHA," + "OID_DEPOSITO,"
				+ "OID_PRODUCTO," + "OID_ESTADO_STOCK," + "OID_UM_STK,"
				+ "ENTRADAS," + "SALIDAS)" + " values " + "(" + "?," + "?,"
				+ "?," + "?," + "?," + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD()
				.prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_STOCK_EST_DIA, pers.getOID());
		qInsert.setDate(FECHA, new java.sql.Date(pers.getFecha().getTime()));
		qInsert.setInt(OID_DEPOSITO, pers.getDeposito().getOID());
		qInsert.setInt(OID_PRODUCTO, pers.getProducto().getOID());
		qInsert.setInt(OID_ESTADO_STOCK, pers.getEstado_stock().getOID());
		qInsert.setInt(OID_UM_STK, pers.getUnidad_medida().getOID());
		qInsert.setDouble(ENTRADAS, pers.getEntradas().doubleValue());
		qInsert.setDouble(SALIDAS, pers.getSalidas().doubleValue());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {

		final int ENTRADAS = 1;
		final int SALIDAS = 2;
		final int OID_STOCK_EST_DIA = 3;

		StockEstadoDia pers = (StockEstadoDia) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate
				.append(" update skStockEstadoDia set entradas=entradas+?,salidas=salidas+?"
						+ " where " + " oid_stock_est_dia=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_STOCK_EST_DIA, pers.getOID());
		qUpdate.setDouble(ENTRADAS, pers.getEntradas().doubleValue());
		qUpdate.setDouble(SALIDAS, pers.getSalidas().doubleValue());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {
		final int OID = 1;
		StockEstadoDia pers = (StockEstadoDia) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update skStockEstadoDia " + " set activo=0 "
				+ " where " + " oid=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {
		final int OID = 1;
		StockEstadoDia pers = (StockEstadoDia) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update skStockEstadoDia " + " set activo=1 "
				+ " where " + " oid=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID, pers.getOID());
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
		case SELECT_BY_DEPO_PROD_ESTADO_FECHA: {
			ps = this.selectByDepoProdEstadoFecha(aCondiciones);
			break;
		}
		case SELECT_SALDO_INICIAL_A_FECHA: {
			ps = this.selectSaldoInicialAFecha(aCondiciones);
			break;
		}

		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones)
			throws BaseException, SQLException {

		final int OID = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  skStockEstadoDia ");
		textSQL.append(" WHERE oid = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID, oid);
		return querySelect;
	}

	private PreparedStatement selectByDepoProdEstadoFecha(Object aCondiciones)
			throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  skStockEstadoDia ");
		textSQL
				.append(" WHERE oid_producto = ? and oid_deposito = ? and oid_estado_stock = ? and fecha = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		Producto producto = (Producto) condiciones.get(Producto.NICKNAME);
		Deposito deposito = (Deposito) condiciones.get(Deposito.NICKNAME);
		EstadoStock estadoStock = (EstadoStock) condiciones
				.get(EstadoStock.NICKNAME);
		java.util.Date fecha = (Date) condiciones.get("FECHA");

		querySelect.setInt(1, producto.getOID());
		querySelect.setInt(2, deposito.getOID());
		querySelect.setInt(3, estadoStock.getOID());
		querySelect.setDate(4, new java.sql.Date(fecha.getTime()));
		return querySelect;
	}

	private PreparedStatement selectSaldoInicialAFecha(Object aCondiciones)
			throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();
		
		textSQL.append(" select "); 
		textSQL.append("  max(1) oid_stock_est_dia , ");
		textSQL.append("  max(fecha) fecha, ");
		textSQL.append("  sum(entradas) entradas, ");
		textSQL.append("  sum(salidas) salidas, ");
		textSQL.append("  oid_deposito, "); 
		textSQL.append("  oid_producto, ");
		textSQL.append("  oid_estado_stock, ");
		textSQL.append("  oid_um_stk  "); 
		textSQL.append(" from "); 
		textSQL.append("  skStockEstadoDia ");  
		textSQL.append(" where ");
		textSQL.append("  oid_deposito = ? and ");
		textSQL.append("  oid_producto = ? and ");
		textSQL.append("  fecha < ? ");
		textSQL.append(" group by "); 
		textSQL.append("  oid_deposito, ");
		textSQL.append("  oid_producto, ");
		textSQL.append("  oid_estado_stock, ");
		textSQL.append("  oid_um_stk ");		
	
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		Producto producto = (Producto) condiciones.get(Producto.NICKNAME);
		Deposito deposito = (Deposito) condiciones.get(Deposito.NICKNAME);
		java.util.Date fecha = (Date) condiciones.get("FECHA");

		querySelect.setInt(1, deposito.getOID());
		querySelect.setInt(2, producto.getOID());
		querySelect.setDate(3, new java.sql.Date(fecha.getTime()));
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones)
			throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  skStockEstadoDia ");
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

		textSQL.append("SELECT oid oid, codigo,  descripcion ,activo ");
		textSQL.append(" from skStockEstadoDia");

		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static StockEstadoDia getStockEstadoDia(Producto producto,
			Deposito deposito, EstadoStock estadoStock, Date fecha,
			ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(Producto.NICKNAME, producto);
		condiciones.put(Deposito.NICKNAME, deposito);
		condiciones.put(EstadoStock.NICKNAME, estadoStock);
		condiciones.put("FECHA", fecha);
		return (StockEstadoDia) ObjetoLogico.getObjects(
				StockEstadoDia.NICKNAME,
				DBStockEstadoDia.SELECT_BY_DEPO_PROD_ESTADO_FECHA, condiciones,
				new ObjetoObservado(), aSesion);
	}
	
	public static List getSaldosInicialesPorEstados(Deposito deposito,
			                                Producto producto,
			                                Date fecha,
			                                ISesion aSesion) throws BaseException {
		  HashTableDatos condiciones = new HashTableDatos();
		  condiciones.put(Deposito.NICKNAME,deposito);
		  condiciones.put(Producto.NICKNAME,producto);
		  condiciones.put("FECHA",fecha);
		  return (List) ObjetoLogico.getObjects(StockEstadoDia.NICKNAME,
                 DBStockEstadoDia.SELECT_SALDO_INICIAL_A_FECHA,
                 condiciones,
                 new ListObserver(),
                 aSesion);
    }
	

}
