package com.srn.erp.stock.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.stock.bm.AgrupadorDeposito;
import com.srn.erp.stock.bm.Deposito;
import com.srn.erp.stock.bm.EstadoStock;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.bm.SaldoStkProdPorEstado;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBSaldoStkProdPorEstado extends DBObjetoPersistente {

	public static final String	OID_SALDO_STK_EST								= "oid_Saldo_stk_est";

	public static final String	OID_PRODUCTO										= "oid_producto";

	public static final String	OID_UM_STK											= "oid_um_stk";

	public static final String	OID_DEPOSITO										= "oid_deposito";

	public static final String	OID_ESTADO_STOCK								= "oid_estado_stock";

	public static final String	SALDO														= "saldo";

	public static final int			SELECT_BY_DEPO_PROD							= 100;

	public static final int			SELECT_PRODUCTO_DEPOSITO_ESTADO	= 101;
	
	public static final int			SELECT_BY_DEPOSITOS_ESTADOS			= 102;
	
	public static final int			SELECT_PRODUCTO_GRUPO_DEPO_ESTADO	= 103;

	public DBSaldoStkProdPorEstado() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_SALDO_STK_EST = 1;
		final int OID_PRODUCTO = 2;
		final int OID_UM_STK = 3;
		final int OID_DEPOSITO = 4;
		final int OID_ESTADO_STOCK = 5;
		final int SALDO = 6;

		SaldoStkProdPorEstado pers = (SaldoStkProdPorEstado) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into skStockSaldoEstado " + " ( " + "OID_SALDO_STK_EST," + "OID_PRODUCTO,"
				+ "OID_UM_STK," + "OID_DEPOSITO," + "OID_ESTADO_STOCK," + "SALDO)" + " values " + "(" + "?," + "?," + "?,"
				+ "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_SALDO_STK_EST, pers.getOID());
		qInsert.setInt(OID_PRODUCTO, pers.getProducto().getOID());
		qInsert.setInt(OID_UM_STK, pers.getUnidad_medida().getOID());
		qInsert.setInt(OID_DEPOSITO, pers.getDeposito().getOID());
		qInsert.setInt(OID_ESTADO_STOCK, pers.getEstado_stock().getOID());
		qInsert.setDouble(SALDO, pers.getSaldo().doubleValue());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		SaldoStkProdPorEstado pers = (SaldoStkProdPorEstado) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update skStockSaldoEstado set " + " saldo=saldo+?" + " where " + " oid_saldo_stk_est=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setDouble(1, pers.getMovimiento().doubleValue());
		qUpdate.setInt(2, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_SALDO_STK_EST = 1;
		SaldoStkProdPorEstado pers = (SaldoStkProdPorEstado) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update skStockSaldoEstado " + " set activo=0 " + " where " + " oid_saldo_stk_est=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_SALDO_STK_EST, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_SALDO_STK_EST = 1;
		SaldoStkProdPorEstado pers = (SaldoStkProdPorEstado) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update skStockSaldoEstado " + " set activo=1 " + " where " + " oid_saldo_stk_est=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_SALDO_STK_EST, pers.getOID());
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
		case SELECT_PRODUCTO_DEPOSITO_ESTADO: {
			ps = this.selectByProductoEstadoDeposito(aCondiciones);
			break;
		}
		case SELECT_BY_DEPO_PROD: {
			ps = this.selectByProductoDeposito(aCondiciones);
			break;
		}
		case SELECT_BY_DEPOSITOS_ESTADOS: {
			ps = this.selectByDepositosEstados(aCondiciones);
			break;
		}
		case SELECT_PRODUCTO_GRUPO_DEPO_ESTADO: {
			ps = this.selectByProductoGrupoDepoEstado(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_SALDO_STK_EST = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  skStockSaldoEstado ");
		textSQL.append(" WHERE oid_saldo_stk_est = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_SALDO_STK_EST, oid);
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  skStockSaldoEstado ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectByProductoEstadoDeposito(Object aCondiciones) throws BaseException, SQLException {
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  skStockSaldoEstado ");
		textSQL.append(" WHERE oid_producto = ? and oid_deposito = ? and oid_estado_stock = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		Producto producto = (Producto) condiciones.get(Producto.NICKNAME);
		Deposito deposito = (Deposito) condiciones.get(Deposito.NICKNAME);
		EstadoStock estadoStock = (EstadoStock) condiciones.get(EstadoStock.NICKNAME);
		querySelect.setInt(1, producto.getOID());
		querySelect.setInt(2, deposito.getOID());
		querySelect.setInt(3, estadoStock.getOID());
		return querySelect;
	}

	private PreparedStatement selectByProductoDeposito(Object aCondiciones) throws BaseException, SQLException {
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  skStockSaldoEstado ");
		textSQL.append(" WHERE oid_producto = ? and oid_deposito = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		Producto producto = (Producto) condiciones.get(Producto.NICKNAME);
		Deposito deposito = (Deposito) condiciones.get(Deposito.NICKNAME);
		querySelect.setInt(1, producto.getOID());
		querySelect.setInt(2, deposito.getOID());
		return querySelect;
	}
	
	private PreparedStatement selectByProductoGrupoDepoEstado(Object aCondiciones) throws BaseException, SQLException {

		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  skStockSaldoEstado ");
		textSQL.append(" WHERE oid_producto = ? and oid_estado_stock = ? and oid_deposito in (select oid_deposito from skAgrupadorDepDet where oid_agrupador_depo = ?) ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		Producto producto = (Producto) condiciones.get(Producto.NICKNAME);
		AgrupadorDeposito agrupadorDeposito = (AgrupadorDeposito) condiciones.get(AgrupadorDeposito.NICKNAME);
		EstadoStock estadoStock = (EstadoStock) condiciones.get(EstadoStock.NICKNAME);
		querySelect.setInt(1, producto.getOID());
		querySelect.setInt(2, estadoStock.getOID());
		querySelect.setInt(3, agrupadorDeposito.getOID());
		return querySelect;
	}
	
	
	

	private PreparedStatement selectByDepositosEstados(Object aCondiciones) throws BaseException, SQLException {

		HashTableDatos condiciones = (HashTableDatos) aCondiciones;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  skStockSaldoEstado ");
		textSQL.append(" WHERE 1=1 ");

		// Agregar a la condicion los Depositos
		StringBuffer condDepo = new StringBuffer("");
		List listaDepositos = (List) condiciones.get("DEPOSITOS");
		if (listaDepositos != null) {
			Iterator iterDepositos = listaDepositos.iterator();
			boolean primeraIteracion = true;
			while (iterDepositos.hasNext()) {
				Deposito deposito = (Deposito) iterDepositos.next();
				if (primeraIteracion == true) {
					condDepo.append("and oid_deposito in (");
					primeraIteracion = false;
				}
				else
					condDepo.append(",");
				condDepo.append(deposito.getOIDInteger());
			}
			if (condDepo.length() > 0) {
				condDepo.append(") ");
				textSQL.append(condDepo);
			}
		}
		
		// Agregar a la condicion de Estados de Stock
		StringBuffer condEstado = new StringBuffer("");
		List listaEstados = (List) condiciones.get("ESTADOS");
		if (listaEstados != null) {
			Iterator iterEstados = listaEstados.iterator();
			boolean primeraIteracion = true;
			while (iterEstados.hasNext()) {
				EstadoStock estadoStock = (EstadoStock) iterEstados.next();
				if (primeraIteracion == true) {
					condEstado.append("and oid_estado_stock in (");
					primeraIteracion = false;
				}
				else
					condEstado.append(",");
				condEstado.append(estadoStock.getOIDInteger());
			}
			if (condEstado.length() > 0) {
				condEstado.append(") ");
				textSQL.append(condEstado);
			}
		}
		

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_Saldo_stk_est oid, codigo,  descripcion ,activo ");
		textSQL.append(" from skStockSaldoEstado");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static SaldoStkProdPorEstado getSaldoStkProdPorEstado(Producto producto, Deposito deposito,
			EstadoStock estadoStock, ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(Producto.NICKNAME, producto);
		condiciones.put(Deposito.NICKNAME, deposito);
		condiciones.put(EstadoStock.NICKNAME, estadoStock);

		return (SaldoStkProdPorEstado) ObjetoLogico.getObjects(SaldoStkProdPorEstado.NICKNAME,
				DBSaldoStkProdPorEstado.SELECT_PRODUCTO_DEPOSITO_ESTADO, condiciones, new ObjetoObservado(), aSesion);
	}
	
	public static List getSaldosPorEstados(Producto producto, Deposito deposito, ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(Producto.NICKNAME, producto);
		condiciones.put(Deposito.NICKNAME, deposito);
		return (List) ObjetoLogico.getObjects(SaldoStkProdPorEstado.NICKNAME, DBSaldoStkProdPorEstado.SELECT_BY_DEPO_PROD,
				condiciones, new ListObserver(), aSesion);
	}
	
	public static List getSaldosPorEstados(Producto producto, AgrupadorDeposito agrupadorDeposito, EstadoStock estadoStock, ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(Producto.NICKNAME, producto);
		condiciones.put(AgrupadorDeposito.NICKNAME, agrupadorDeposito);
		condiciones.put(EstadoStock.NICKNAME, estadoStock);
		return (List) ObjetoLogico.getObjects(SaldoStkProdPorEstado.NICKNAME, DBSaldoStkProdPorEstado.SELECT_PRODUCTO_GRUPO_DEPO_ESTADO,
				condiciones, new ListObserver(), aSesion);
	}
	
	
	
	
	public static List getSaldosPorEstados(List listaDepositos, List listaEstados, ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put("DEPOSITOS", listaDepositos);
		condiciones.put("ESTADOS", listaEstados);
		return (List) ObjetoLogico.getObjects(
				SaldoStkProdPorEstado.NICKNAME, 
				DBSaldoStkProdPorEstado.SELECT_BY_DEPOSITOS_ESTADOS,
				condiciones, 
				new ListObserver(), 
				aSesion);
	}
	

}
