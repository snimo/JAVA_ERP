package com.srn.erp.stock.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.stock.bm.ProdHabUbiDepo;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.bm.UbicacionDeposito;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBProdHabUbiDepo extends DBObjetoPersistente {

	public static final String OID_UM_UBI_DEPO = "oid_um_ubi_depo";

	public static final String OID_UBI_DEPO = "oid_ubi_depo";

	public static final String OID_PRODUCTO = "oid_producto";

	public static final int SELECT_BY_UBI_DEPOSITO = 100;

	public static final int SELECT_BY_UBIDEPO_PRODUCTO = 101;

	public DBProdHabUbiDepo() {
	}

	protected void insert(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {

		final int OID_UM_UBI_DEPO = 1;
		final int OID_UBI_DEPO = 2;
		final int OID_PRODUCTO = 3;

		ProdHabUbiDepo pers = (ProdHabUbiDepo) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into skProdHabUbiDepo " + " ( "
				+ "OID_UM_UBI_DEPO," + "OID_UBI_DEPO," + "OID_PRODUCTO)"
				+ " values " + "(" + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD()
				.prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_UM_UBI_DEPO, pers.getOID());
		qInsert.setInt(OID_UBI_DEPO, pers.getUbicacion_deposito().getOID());
		qInsert.setInt(OID_PRODUCTO, pers.getProducto().getOID());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {

		final int OID_UBI_DEPO = 1;
		final int OID_PRODUCTO = 2;
		final int OID_UM_UBI_DEPO = 3;

		ProdHabUbiDepo pers = (ProdHabUbiDepo) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update skProdHabUbiDepo set " + "oid_ubi_depo=?"
				+ ",oid_producto=?" + " where " + " oid_um_ubi_depo=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_UM_UBI_DEPO, pers.getOID());
		qUpdate.setInt(OID_UBI_DEPO, pers.getUbicacion_deposito().getOID());
		qUpdate.setInt(OID_PRODUCTO, pers.getProducto().getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {
		final int OID_UM_UBI_DEPO = 1;
		ProdHabUbiDepo pers = (ProdHabUbiDepo) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("delete from skProdHabUbiDepo " + " where "
				+ " oid_um_ubi_depo=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_UM_UBI_DEPO, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {
		final int OID_UM_UBI_DEPO = 1;
		ProdHabUbiDepo pers = (ProdHabUbiDepo) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update skProdHabUbiDepo " + " set activo=1 "
				+ " where " + " oid_um_ubi_depo=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_UM_UBI_DEPO, pers.getOID());
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
		case SELECT_BY_UBI_DEPOSITO: {
			ps = this.selectByUbicacionDeposito(aCondiciones);
			break;
		}
		case SELECT_BY_UBIDEPO_PRODUCTO: {
			ps = this.selectByUbiDepoProducto(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones)
			throws BaseException, SQLException {

		final int OID_UM_UBI_DEPO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  skProdHabUbiDepo ");
		textSQL.append(" WHERE oid_um_ubi_depo = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_UM_UBI_DEPO, oid);
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones)
			throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  skProdHabUbiDepo ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectByUbicacionDeposito(Object aCondiciones)
			throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  skProdHabUbiDepo ");
		textSQL.append(" WHERE  OID_UBI_DEPO = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		UbicacionDeposito ubicacionDeposito = (UbicacionDeposito) aCondiciones;
		querySelect.setInt(1, ubicacionDeposito.getOID());
		return querySelect;
	}

	private PreparedStatement selectByUbiDepoProducto(Object aCondiciones)
			throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  skProdHabUbiDepo ");
		textSQL.append(" WHERE  OID_UBI_DEPO = ? and oid_producto = ? ");
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		UbicacionDeposito ubiDepo = (UbicacionDeposito) condiciones
				.get(UbicacionDeposito.NICKNAME);
		Producto producto = (Producto) condiciones.get(Producto.NICKNAME);
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		querySelect.setInt(1, ubiDepo.getOID());
		querySelect.setInt(2, producto.getOID());
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones)
			throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL
				.append("SELECT oid_um_ubi_depo oid, codigo,  descripcion ,activo ");
		textSQL.append(" from skProdHabUbiDepo");

		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static List getProductosHabilitados(
			UbicacionDeposito ubicacionDeposito, ISesion aSesion)
			throws BaseException {
		return (List) ObjetoLogico.getObjects(ProdHabUbiDepo.NICKNAME,
				DBProdHabUbiDepo.SELECT_BY_UBI_DEPOSITO, ubicacionDeposito,
				new ListObserver(), aSesion);
	}

	public static ProdHabUbiDepo getProdHab(UbicacionDeposito ubicacionDeposito,
											Producto producto,	
											ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(UbicacionDeposito.NICKNAME,ubicacionDeposito);
		condiciones.put(Producto.NICKNAME,producto);
		return (ProdHabUbiDepo) ObjetoLogico.getObjects(ProdHabUbiDepo.NICKNAME,
														DBProdHabUbiDepo.SELECT_BY_UBIDEPO_PRODUCTO, 
														condiciones,
														new ObjetoObservado(), aSesion);
	}

}
