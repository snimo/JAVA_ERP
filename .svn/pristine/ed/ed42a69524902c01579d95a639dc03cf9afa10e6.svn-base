package com.srn.erp.stock.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.stock.bm.FactorConversionProveedor;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.bm.ProductoProveedor;
import com.srn.erp.stock.bm.UnidadMedida;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;

public class DBFactorConversionProveedor extends DBObjetoPersistente {

	public static final String OID_FACT_CONV_PROV = "oid_fact_conv_prov";

	public static final String OID_UM = "oid_um";

	public static final String OID_PROD_PROV = "oid_prod_prov";

	public static final String FACT_CONV = "fact_conv";

	public static final int SELECT_BY_PROD_PROV = 100;
	
	public static final int SELECT_BY_UNI_MED = 101;
	
	public static final int SELECT_BY_UNI_MED_PRODUCTO_PROVEEDOR = 102;

	public DBFactorConversionProveedor() {
	}

	protected void insert(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {

		final int OID_FACT_CONV_PROV = 1;
		final int OID_UM = 2;
		final int OID_PROD_PROV = 3;
		final int FACT_CONV = 4;

		FactorConversionProveedor pers = (FactorConversionProveedor) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into stFactConvProv " + " ( "
				+ "OID_FACT_CONV_PROV," + "OID_UM," + "OID_PROD_PROV,"
				+ "FACT_CONV)" + " values " + "(" + "?," + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD()
				.prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_FACT_CONV_PROV, pers.getOID());
		qInsert.setInt(OID_UM, pers.getUnidad_medida().getOID());
		qInsert.setInt(OID_PROD_PROV, pers.getProducto_proveedor().getOID());
		qInsert.setDouble(FACT_CONV, pers.getFactor_conversion().doubleValue());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {

		final int OID_UM = 1;
		final int OID_PROD_PROV = 2;
		final int FACT_CONV = 3;
		final int OID_FACT_CONV_PROV = 4;

		FactorConversionProveedor pers = (FactorConversionProveedor) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update stFactConvProv set " + "oid_um=?"
				+ ",oid_prod_prov=?" + ",fact_conv=?" + " where "
				+ " oid_fact_conv_prov=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_FACT_CONV_PROV, pers.getOID());
		qUpdate.setInt(OID_UM, pers.getUnidad_medida().getOID());
		qUpdate.setInt(OID_PROD_PROV, pers.getProducto_proveedor().getOID());
		qUpdate.setDouble(FACT_CONV, pers.getFactor_conversion().doubleValue());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {
		final int OID_FACT_CONV_PROV = 1;
		FactorConversionProveedor pers = (FactorConversionProveedor) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("delete from stFactConvProv " + 
				" where oid_fact_conv_prov=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_FACT_CONV_PROV, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {
		final int OID_FACT_CONV_PROV = 1;
		FactorConversionProveedor pers = (FactorConversionProveedor) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update stFactConvProv " + " set activo=1 "
				+ " where " + " oid_fact_conv_prov=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_FACT_CONV_PROV, pers.getOID());
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
		case DBFactorConversionProveedor.SELECT_BY_PROD_PROV: {
			ps = this.selectByProductoProveedor(aCondiciones);
			break;
		}
		case DBFactorConversionProveedor.SELECT_BY_UNI_MED: {
			ps = this.selectByUniMed(aCondiciones);
			break;
		}
		case SELECT_BY_UNI_MED_PRODUCTO_PROVEEDOR: {
			ps = this.selectByUniMedProductoProveedor(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones)
			throws BaseException, SQLException {

		final int OID_FACT_CONV_PROV = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  stFactConvProv ");
		textSQL.append(" WHERE oid_fact_conv_prov = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_FACT_CONV_PROV, oid);
		return querySelect;
	}
	
	private PreparedStatement selectByUniMedProductoProveedor(Object aCondiciones)
			throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  stFactConvProv ");
		textSQL.append(" WHERE oid_um = ? and oid_prod_prov in (select oid_prod_prov from stProdProveedor where oid_producto=? and oid_proveedor = ?) ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		HashTableDatos condiciones = (HashTableDatos)aCondiciones;
		UnidadMedida unidadMedida = (UnidadMedida)condiciones.get(UnidadMedida.NICKNAME);
		Producto producto = (Producto) condiciones.get(Producto.NICKNAME);
		Proveedor proveedor = (Proveedor) condiciones.get(Proveedor.NICKNAME);
		querySelect.setInt(1, unidadMedida.getOID());
		querySelect.setInt(2, producto.getOID());
		querySelect.setInt(3, proveedor.getOID());
		return querySelect;
	}
	
	private PreparedStatement selectByUniMed(Object aCondiciones)
			throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  stFactConvProv ");
		textSQL.append(" WHERE oid_uni_med = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		UnidadMedida unidadMedida = (UnidadMedida) aCondiciones;
		querySelect.setInt(1, unidadMedida.getOID());
		return querySelect;
	}

	private PreparedStatement selectByProductoProveedor(Object aCondiciones)
			throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  stFactConvProv ");
		textSQL.append(" WHERE oid_prod_prov = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		ProductoProveedor productoProveedor = (ProductoProveedor) aCondiciones;
		querySelect.setInt(1, productoProveedor.getOID());
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones)
			throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  stFactConvProv ");
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
				.append("SELECT oid_fact_conv_prov oid, codigo,  descripcion ,activo ");
		textSQL.append(" from stFactConvProv");

		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static List getFactoresConversion(
			ProductoProveedor productoProveedor, ISesion aSesion)
			throws BaseException {
		return (List) ObjetoLogico.getObjects(
				FactorConversionProveedor.NICKNAME,
				DBFactorConversionProveedor.SELECT_BY_PROD_PROV,
				productoProveedor, new ListObserver(), aSesion);
	}

	public static List getFactoresConversion(
			UnidadMedida unidadMedida, ISesion aSesion)
			throws BaseException {
		return (List) ObjetoLogico.getObjects(
				FactorConversionProveedor.NICKNAME,
				DBFactorConversionProveedor.SELECT_BY_UNI_MED,
				unidadMedida, new ListObserver(), aSesion);
	}	
	
	public static List getFactoresConversion(
			UnidadMedida unidadMedida,
			Producto producto,
			Proveedor proveedor,
			ISesion aSesion)
			throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(UnidadMedida.NICKNAME,unidadMedida);
		condiciones.put(Producto.NICKNAME,producto);
		condiciones.put(Proveedor.NICKNAME,proveedor);
		return (List) ObjetoLogico.getObjects(
				FactorConversionProveedor.NICKNAME,
				DBFactorConversionProveedor.SELECT_BY_UNI_MED_PRODUCTO_PROVEEDOR,
				condiciones, new ListObserver(), aSesion);
	}	
	
}
