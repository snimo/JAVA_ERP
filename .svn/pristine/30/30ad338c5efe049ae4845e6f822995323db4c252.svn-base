package com.srn.erp.stock.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.stock.bm.Deposito;
import com.srn.erp.stock.bm.EstadoStock;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.bm.StockMovimiento;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;

public class DBStockMovimiento extends DBObjetoPersistente {

	public static final String OID_STOCK_MOV = "oid_stock_mov";

	public static final String OID_PRODUCTO = "oid_producto";

	public static final String OID_UBI_DEPO = "oid_ubi_depo";

	public static final String FECHA = "fecha";

	public static final String SIGNO = "signo";

	public static final String CANTIDAD = "cantidad";

	public static final String OID_CCO = "oid_cco";

	public static final String OID_UM_STK = "oid_um_stk";

	public static final String AFECTA_STK_FISICO = "afecta_stk_fisico";

	public static final String OID_PARTIDA = "oid_partida";

	public static final String OID_SERIE = "oid_serie";

	public static final String FECHA_ARRIVO = "fecha_arrivo";

	public static final String CANT_RECIBIDA = "cant_recibida";

	public static final String OID_DEPOSITO = "oid_deposito";

	public static final String OID_ESTADO_STOCK = "oid_estado_stock";

	public static final String PEND_ARRIVO = "pend_arrivo";

	public static final String ACTIVO = "activo";
	
	public static final String OID_CCO_DET = "oid_cco_det";
	
	public static final String OID_CCO_DEST = "oid_cco_dest";
	
	public static final String OID_CCO_DET_DEST = "oid_cco_det_dest";
	
	public static final int SELECT_BY_DEPOSITO_PRODUCTO_FEC_DESDE_FEC_HASTA = 100;

	public static final int SELECT_BY_OID_COMPRO = 101;
	
	public static final int SELECT_BY_PROD_DEPO_ESTADO_COMPRO_DEST = 102;
	
	public static final int SELECT_BY_PROD_ESTADO_COMPRO_DEST = 103;
	
	public static final int SELECT_BY_FEC_DESDE_HASTA_MOV_FIS_ENT = 104;

	public DBStockMovimiento() {
	}

	protected void insert(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {

		final int OID_STOCK_MOV = 1;
		final int OID_PRODUCTO = 2;
		final int OID_UBI_DEPO = 3;
		final int FECHA = 4;
		final int SIGNO = 5;
		final int CANTIDAD = 6;
		final int OID_CCO = 7;
		final int OID_UM_STK = 8;
		final int AFECTA_STK_FISICO = 9;
		final int OID_PARTIDA = 10;
		final int OID_SERIE = 11;
		final int FECHA_ARRIVO = 12;
		final int CANT_RECIBIDA = 13;
		final int OID_DEPOSITO = 14;
		final int OID_ESTADO_STOCK = 15;
		final int PEND_ARRIVO = 16;
		final int ACTIVO = 17;
		final int OID_CCO_DET = 18;
		final int OID_CCO_DEST = 19;
		final int OID_CCO_DET_DEST = 20;

		StockMovimiento pers = (StockMovimiento) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert
				.append(" insert into skStockMov " + " ( " + "OID_STOCK_MOV,"
						+ "OID_PRODUCTO," + "OID_UBI_DEPO," + "FECHA,"
						+ "SIGNO," + "CANTIDAD," + "OID_CCO," + "OID_UM_STK,"
						+ "AFECTA_STK_FISICO," + "OID_PARTIDA," + "OID_SERIE,"
						+ "FECHA_ARRIVO," + "CANT_RECIBIDA," + "OID_DEPOSITO,"
						+ "OID_ESTADO_STOCK," + "PEND_ARRIVO," + "ACTIVO , OID_CCO_DET,OID_CCO_DEST,OID_CCO_DET_DEST)"
						+ " values " + "(" + "?," + "?," + "?," + "?," + "?,"
						+ "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?,"
						+ "?," + "?," + "?,"+ "?,"+ "?,"+ "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD()
				.prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_STOCK_MOV, pers.getOID());
		qInsert.setInt(OID_PRODUCTO, pers.getProducto().getOID());
		qInsert.setInt(OID_UBI_DEPO, pers.getUbicacion_deposito().getOID());
		qInsert.setDate(FECHA, new java.sql.Date(pers.getFecha().getTime()));
		qInsert.setInt(SIGNO, pers.getSigno().intValue());
		qInsert.setDouble(CANTIDAD, pers.getCantidad().doubleValue());
		qInsert.setInt(OID_CCO, pers.getComprobante().getOID());
		qInsert.setInt(OID_UM_STK, pers.getUnidad_medida().getOID());
		qInsert.setBoolean(AFECTA_STK_FISICO, pers.isAfecta_stk_fisico()
				.booleanValue());
		if (pers.getPartida() != null)
			qInsert.setInt(OID_PARTIDA, pers.getPartida().getOID());
		else
			qInsert.setNull(OID_PARTIDA, java.sql.Types.INTEGER);
		if (pers.getSerie() != null)
			qInsert.setInt(OID_SERIE, pers.getSerie().getOID());
		else
			qInsert.setNull(OID_SERIE, java.sql.Types.INTEGER);
		if (pers.getFecha_arrivo() != null)
			qInsert.setDate(FECHA_ARRIVO, new java.sql.Date(pers
					.getFecha_arrivo().getTime()));
		else
			qInsert.setNull(FECHA_ARRIVO, java.sql.Types.INTEGER);

		if (pers.getCant_recibida() != null)
			qInsert.setDouble(CANT_RECIBIDA, pers.getCant_recibida()
					.doubleValue());
		else
			qInsert.setDouble(CANT_RECIBIDA, 0);

		qInsert.setInt(OID_DEPOSITO, pers.getDeposito().getOID());
		qInsert.setInt(OID_ESTADO_STOCK, pers.getEstado_stock().getOID());
		if (pers.isPend_arrivo() != null)
			qInsert
					.setBoolean(PEND_ARRIVO, pers.isPend_arrivo()
							.booleanValue());
		else
			qInsert.setBoolean(PEND_ARRIVO, false);
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		
		if (pers.getOidComproDet()!=null)
			qInsert.setInt(OID_CCO_DET, pers.getOidComproDet().intValue());
		else
			qInsert.setNull(OID_CCO_DET, java.sql.Types.INTEGER);
		
		if (pers.getComprobanteDestino()!=null)
			qInsert.setInt(OID_CCO_DEST, pers.getComprobanteDestino().getOID());
		else
			qInsert.setNull(OID_CCO_DEST, java.sql.Types.INTEGER);
		
		if (pers.getOidComproDestinoDet()!=null)
			qInsert.setInt(OID_CCO_DET_DEST, pers.getOidComproDestinoDet().intValue());
		else
			qInsert.setNull(OID_CCO_DET_DEST, java.sql.Types.INTEGER);
		
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {

		final int OID_PRODUCTO = 1;
		final int OID_UBI_DEPO = 2;
		final int FECHA = 3;
		final int SIGNO = 4;
		final int CANTIDAD = 5;
		final int OID_CCO = 6;
		final int OID_UM_STK = 7;
		final int AFECTA_STK_FISICO = 8;
		final int OID_PARTIDA = 9;
		final int OID_SERIE = 10;
		final int FECHA_ARRIVO = 11;
		final int CANT_RECIBIDA = 12;
		final int OID_DEPOSITO = 13;
		final int OID_ESTADO_STOCK = 14;
		final int PEND_ARRIVO = 15;
		final int ACTIVO = 16;
		final int OID_CCO_DET = 17;
		final int OID_CCO_DEST = 18;
		final int OID_CCO_DET_DEST = 19;
		final int OID_STOCK_MOV = 20;

		StockMovimiento pers = (StockMovimiento) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update skStockMov set " + "oid_producto=?"
				+ ",oid_ubi_depo=?" + ",fecha=?" + ",signo=?" + ",cantidad=?"
				+ ",oid_cco=?" + ",oid_um_stk=?" + ",afecta_stk_fisico=?"
				+ ",oid_partida=?" + ",oid_serie=?" + ",fecha_arrivo=?"
				+ ",cant_recibida=?" + ",oid_deposito=?"
				+ ",oid_estado_stock=?" + ",pend_arrivo=?" + ",activo=?"
				+ ",oid_cco_det=?,oid_cco_dest=?,oid_cco_det_dest=? "
				+ " where " + " oid_stock_mov=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_STOCK_MOV, pers.getOID());
		qUpdate.setInt(OID_PRODUCTO, pers.getProducto().getOID());
		qUpdate.setInt(OID_UBI_DEPO, pers.getUbicacion_deposito().getOID());
		qUpdate.setDate(FECHA, new java.sql.Date(pers.getFecha().getTime()));
		qUpdate.setInt(SIGNO, pers.getSigno().intValue());
		qUpdate.setDouble(CANTIDAD, pers.getCantidad().doubleValue());
		qUpdate.setInt(OID_CCO, pers.getComprobante().getOID());
		qUpdate.setInt(OID_UM_STK, pers.getUnidad_medida().getOID());
		qUpdate.setBoolean(AFECTA_STK_FISICO, pers.isAfecta_stk_fisico()
				.booleanValue());
		if (pers.getPartida() != null)
			qUpdate.setInt(OID_PARTIDA, pers.getPartida().getOID());
		else
			qUpdate.setNull(OID_PARTIDA, java.sql.Types.INTEGER);
		if (pers.getSerie() != null)
			qUpdate.setInt(OID_SERIE, pers.getSerie().getOID());
		else
			qUpdate.setNull(OID_SERIE, java.sql.Types.INTEGER);
		if (pers.getFecha_arrivo() != null)
			qUpdate.setDate(FECHA_ARRIVO, new java.sql.Date(pers
					.getFecha_arrivo().getTime()));
		else
			qUpdate.setNull(FECHA_ARRIVO, java.sql.Types.INTEGER);

		if (pers.getCant_recibida() != null)
			qUpdate.setDouble(CANT_RECIBIDA, pers.getCant_recibida()
					.doubleValue());
		else
			qUpdate.setDouble(CANT_RECIBIDA, 0);
		qUpdate.setInt(OID_DEPOSITO, pers.getDeposito().getOID());
		qUpdate.setInt(OID_ESTADO_STOCK, pers.getEstado_stock().getOID());
		qUpdate.setBoolean(PEND_ARRIVO, pers.isPend_arrivo().booleanValue());
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		if (pers.getOidComproDet()!=null)
			qUpdate.setInt(OID_CCO_DET, pers.getOidComproDet().intValue());
		else
			qUpdate.setNull(OID_CCO_DET, java.sql.Types.INTEGER);
		
		if (pers.getComprobanteDestino()!=null)
			qUpdate.setInt(OID_CCO_DEST, pers.getComprobanteDestino().getOID());
		else
			qUpdate.setNull(OID_CCO_DEST, java.sql.Types.INTEGER);
		
		if (pers.getOidComproDestinoDet()!=null)
			qUpdate.setInt(OID_CCO_DET_DEST, pers.getOidComproDestinoDet().intValue());
		else
			qUpdate.setNull(OID_CCO_DET_DEST, java.sql.Types.INTEGER);
			
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {
		final int OID_STOCK_MOV = 1;
		StockMovimiento pers = (StockMovimiento) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update skStockMov " + " set activo=0 " + " where "
				+ " oid_stock_mov=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_STOCK_MOV, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {
		final int OID_STOCK_MOV = 1;
		StockMovimiento pers = (StockMovimiento) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update skStockMov " + " set activo=1 " + " where "
				+ " oid_stock_mov=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_STOCK_MOV, pers.getOID());
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
		case IDBObjetoPersistente.SELECT_ALL: {
			ps = this.selectAllMovStock(aCondiciones);
			break;
		}		
		case IDBObjetoPersistente.SELECT_ALL_HELP: {
			ps = this.selectAllHelp(aCondiciones);
			break;
		}
		case SELECT_BY_DEPOSITO_PRODUCTO_FEC_DESDE_FEC_HASTA: {
			ps = this
					.selectByDepositoProductoFechaDesdeFechaHasta(aCondiciones);
			break;
		}
		case SELECT_BY_OID_COMPRO: {
			ps = this.selectByComprobante(aCondiciones);
			break;
		}
		case SELECT_BY_PROD_DEPO_ESTADO_COMPRO_DEST: {
			ps = this.selectByProdDepoEstadoComproDest(aCondiciones);
			break;			
		}
		case SELECT_BY_PROD_ESTADO_COMPRO_DEST: {
			ps = this.selectByProdEstadoComproDest(aCondiciones);
			break;			
		}
		case SELECT_BY_FEC_DESDE_HASTA_MOV_FIS_ENT: {
			ps = this.selectByFecDesdeHastaIngresoFisico(aCondiciones);
			break;			
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones)
			throws BaseException, SQLException {

		final int OID_STOCK_MOV = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  skStockMov ");
		textSQL.append(" WHERE oid_stock_mov = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_STOCK_MOV, oid);
		return querySelect;
	}
	
	private PreparedStatement selectByFecDesdeHastaIngresoFisico(
			Object aCondiciones) throws BaseException, SQLException {
		
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		java.util.Date fecDesde = (java.util.Date) condiciones.get("FEC_DESDE");
		java.util.Date fecHasta = (java.util.Date) condiciones.get("FEC_HASTA");
		
		
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  skStockMov ");
		textSQL.append(" WHERE ");
		textSQL.append(" fecha>=? and fecha<=? and signo = 1 and afecta_stk_fisico = 1 ");
		
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		querySelect.setDate(1, new java.sql.Date(fecDesde.getTime()));
		querySelect.setDate(2, new java.sql.Date(fecHasta.getTime()));
		
		return querySelect;
	}
	
	private PreparedStatement selectByProdEstadoComproDest(
			Object aCondiciones) throws BaseException, SQLException {
		
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		Producto producto = (Producto) condiciones.get(Producto.NICKNAME);
		EstadoStock estadoStock = (EstadoStock) condiciones.get(EstadoStock.NICKNAME);
		Integer oidComproDestino = (Integer) condiciones.get("OID_CCO_DEST");
		Integer oidComproDestinoDet = (Integer) condiciones.get("OID_CCO_DEST_DET");
		
		
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  skStockMov ");
		textSQL.append(" WHERE ");
		textSQL.append(" oid_producto = ? and ");
		textSQL.append(" oid_estado_stock = ? and ");
		textSQL.append(" oid_cco_dest = ? and ");
		textSQL.append(" oid_cco_det_dest = ?  ");
		
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		querySelect.setInt(1, producto.getOID());
		querySelect.setInt(2, estadoStock.getOID());
		querySelect.setInt(3, oidComproDestino);
		querySelect.setInt(4, oidComproDestinoDet);
		
		return querySelect;
	}
	
	
	private PreparedStatement selectByProdDepoEstadoComproDest(
			Object aCondiciones) throws BaseException, SQLException {
		
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		Producto producto = (Producto) condiciones.get(Producto.NICKNAME);
		Deposito deposito = (Deposito) condiciones.get(Deposito.NICKNAME);
		EstadoStock estadoStock = (EstadoStock) condiciones.get(EstadoStock.NICKNAME);
		Integer oidComproDestino = (Integer) condiciones.get("OID_CCO_DEST");
		Integer oidComproDestinoDet = (Integer) condiciones.get("OID_CCO_DEST_DET");
		
		
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  skStockMov ");
		textSQL.append(" WHERE ");
		textSQL.append(" oid_producto = ? and ");
		textSQL.append(" oid_deposito = ? and ");
		textSQL.append(" oid_estado_stock = ? and ");
		textSQL.append(" oid_cco_dest = ? and ");
		textSQL.append(" oid_cco_det_dest = ?  ");
		
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		querySelect.setInt(1, producto.getOID());
		querySelect.setInt(2, deposito.getOID());
		querySelect.setInt(3, estadoStock.getOID());
		querySelect.setInt(4, oidComproDestino);
		querySelect.setInt(5, oidComproDestinoDet);
		
		return querySelect;
	}
	
	private PreparedStatement selectByDepositoProductoFechaDesdeFechaHasta(
			Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  skStockMov ");
		textSQL
				.append(" WHERE oid_deposito = ? and oid_producto = ? and fecha>=? and fecha<=? order by fecha , oid_stock_mov  ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		Deposito deposito = (Deposito) condiciones.get(Deposito.NICKNAME);
		Producto producto = (Producto) condiciones.get(Producto.NICKNAME);
		Date fechaDesde = (Date) condiciones.get("FECHA_DESDE");
		Date fechaHasta = (Date) condiciones.get("FECHA_HASTA");
		querySelect.setInt(1, deposito.getOID());
		querySelect.setInt(2, producto.getOID());
		querySelect.setDate(3, new java.sql.Date(fechaDesde.getTime()));
		querySelect.setDate(4, new java.sql.Date(fechaHasta.getTime()));
		return querySelect;
	}

	private PreparedStatement selectByComprobante(Object aCondiciones)
			throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  skStockMov ");
		textSQL.append(" WHERE oid_cco = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		ComproCab comproCab = (ComproCab) aCondiciones;
		querySelect.setInt(1, comproCab.getOID());
		return querySelect;
	}
	
	private PreparedStatement selectAllMovStock(Object aCondiciones)
		throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  skStockMov ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}
	
	private PreparedStatement selectByCodigo(Object aCondiciones)
			throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  skStockMov ");
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

		textSQL
				.append("SELECT oid_stock_mov oid, codigo,  descripcion ,activo ");
		textSQL.append(" from skStockMov");

		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static List getMovByDepoProduFecDesdeFecHasta(Deposito deposito,
			Producto producto, Date aFechaDesde, Date aFechaHasta,
			ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(Deposito.NICKNAME, deposito);
		condiciones.put(Producto.NICKNAME, producto);
		condiciones.put("FECHA_DESDE", aFechaDesde);
		condiciones.put("FECHA_HASTA", aFechaHasta);
		return (List) ObjetoLogico
				.getObjects(
						StockMovimiento.NICKNAME,
						DBStockMovimiento.SELECT_BY_DEPOSITO_PRODUCTO_FEC_DESDE_FEC_HASTA,
						condiciones, new ListObserver(), aSesion);
	}
	
	public static List getMovByComprobante(ComproCab comproCab,ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(
						StockMovimiento.NICKNAME,
						DBStockMovimiento.SELECT_BY_OID_COMPRO,
						comproCab, new ListObserver(), aSesion);
	}
	
	public static List getAllMovimientosStock(ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(
						StockMovimiento.NICKNAME,
						DBStockMovimiento.SELECT_ALL,
						null, 
						new ListObserver(), 
						aSesion);
	}
	
	public static List getMovByDepoProdEstadoComproDestino(ISesion aSesion,
			Producto producto,
			Deposito deposito,
			EstadoStock estado,
			Integer oidComproDestino,
			Integer oidComproDestinoDet
			) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(Producto.NICKNAME,producto);
		condiciones.put(Deposito.NICKNAME,deposito);
		condiciones.put(EstadoStock.NICKNAME,estado);
		condiciones.put("OID_CCO_DEST", oidComproDestino);
		condiciones.put("OID_CCO_DEST_DET", oidComproDestinoDet);
				
		
		return (List) ObjetoLogico.getObjects(
						StockMovimiento.NICKNAME,
						DBStockMovimiento.SELECT_BY_PROD_DEPO_ESTADO_COMPRO_DEST,
						condiciones, 
						new ListObserver(), 
						aSesion);
	}
	
	public static List getMovByProdEstadoComproDestino(ISesion aSesion,
			Producto producto,
			EstadoStock estado,
			Integer oidComproDestino,
			Integer oidComproDestinoDet
			) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(Producto.NICKNAME,producto);
		condiciones.put(EstadoStock.NICKNAME,estado);
		condiciones.put("OID_CCO_DEST", oidComproDestino);
		condiciones.put("OID_CCO_DEST_DET", oidComproDestinoDet);
				
		
		return (List) ObjetoLogico.getObjects(
						StockMovimiento.NICKNAME,
						DBStockMovimiento.SELECT_BY_PROD_ESTADO_COMPRO_DEST,
						condiciones, 
						new ListObserver(), 
						aSesion);
	}	
	
	
	public static List getMovimientosIngresoFisico(ISesion aSesion,
			java.util.Date fecDesde,
			java.util.Date fecHasta
			) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put("FEC_DESDE",fecDesde);
		condiciones.put("FEC_HASTA",fecHasta);
		
		return (List) ObjetoLogico.getObjects(
						StockMovimiento.NICKNAME,
						DBStockMovimiento.SELECT_BY_FEC_DESDE_HASTA_MOV_FIS_ENT,
						condiciones, 
						new ListObserver(), 
						aSesion);
	}	
	
	

}
