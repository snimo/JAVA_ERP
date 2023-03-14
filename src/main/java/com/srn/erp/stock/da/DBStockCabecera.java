package com.srn.erp.stock.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.stock.bm.StockCabecera;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ObjetoObservado;

public class DBStockCabecera extends DBObjetoPersistente {

	public static final String OID_STOCK_CAB = "oid_stock_cab";

	public static final String OID_CCO = "oid_cco";

	public static final int SELECT_BY_OID_COMPRO = 100;

	public DBStockCabecera() {
	}

	protected void insert(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {

		final int OID_STOCK_CAB = 1;
		final int OID_CCO = 2;

		StockCabecera pers = (StockCabecera) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into skStockCab " + " ( " + "OID_STOCK_CAB,"
				+ "OID_CCO)" + " values " + "(" + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD()
				.prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_STOCK_CAB, pers.getOID());
		qInsert.setInt(OID_CCO, pers.getComprobante().getOID());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {

		final int OID_CCO = 1;
		final int OID_STOCK_CAB = 2;

		StockCabecera pers = (StockCabecera) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update skStockCab set " + "oid_cco=?" + " where "
				+ " oid_stock_cab=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_STOCK_CAB, pers.getOID());
		qUpdate.setInt(OID_CCO, pers.getComprobante().getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {
		final int OID_STOCK_CAB = 1;
		StockCabecera pers = (StockCabecera) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update skStockCab " + " set activo=0 " + " where "
				+ " oid_stock_cab=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_STOCK_CAB, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {
		final int OID_STOCK_CAB = 1;
		StockCabecera pers = (StockCabecera) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update skStockCab " + " set activo=1 " + " where "
				+ " oid_stock_cab=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_STOCK_CAB, pers.getOID());
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
		case SELECT_BY_OID_COMPRO: {
			ps = this.selectByOidCompro(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOidCompro(Object aCondiciones)
			throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  skStockCab ");
		textSQL.append(" WHERE oid_cco = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		ComproCab comproCab = (ComproCab) aCondiciones;
		querySelect.setInt(1, comproCab.getOID());
		return querySelect;
	}

	private PreparedStatement selectByOID(Object aCondiciones)
			throws BaseException, SQLException {

		final int OID_STOCK_CAB = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  skStockCab ");
		textSQL.append(" WHERE oid_stock_cab = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_STOCK_CAB, oid);
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones)
			throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  skStockCab ");
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
				.append("SELECT oid_stock_cab oid, codigo,  descripcion ,activo ");
		textSQL.append(" from skStockCab");

		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static StockCabecera getStockCabecera(ComproCab comproCab,
			ISesion aSesion) throws BaseException {
		return (StockCabecera) ObjetoLogico.getObjects(StockCabecera.NICKNAME,
				DBStockCabecera.SELECT_BY_OID_COMPRO, comproCab,
				new ObjetoObservado(), aSesion);
	}

}
