package com.srn.erp.stock.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.stock.bm.ConversionUMProducto;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.bm.UnidadMedida;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBConversionUMProducto extends DBObjetoPersistente {

	public static final String OID_EQUIV_PROD = "oid_equiv_prod";

	public static final String OID_PRODUCTO = "oid_producto";

	public static final String OID_UM_ORIGEN = "oid_um_origen";

	public static final String OID_UM_DESTINO = "oid_um_destino";

	public static final String FACT_CONV = "fact_conv";

	public static final int SELECT_BY_PRODUCTO = 100;

	public static final int SELECT_BY_UM_ORI_UM_DEST = 101;

	public static final int SELECT_BY_UNI_ORI_UNI_DEST = 102;

	public DBConversionUMProducto() {
	}

	protected void insert(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {

		final int OID_EQUIV_PROD = 1;
		final int OID_PRODUCTO = 2;
		final int OID_UM_ORIGEN = 3;
		final int OID_UM_DESTINO = 4;
		final int FACT_CONV = 5;

		ConversionUMProducto pers = (ConversionUMProducto) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into stEquivUMProd " + " ( "
				+ "OID_EQUIV_PROD," + "OID_PRODUCTO," + "OID_UM_ORIGEN,"
				+ "OID_UM_DESTINO," + "FACT_CONV)" + " values " + "(" + "?,"
				+ "?," + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD()
				.prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_EQUIV_PROD, pers.getOID());
		qInsert.setInt(OID_PRODUCTO, pers.getProducto().getOID());
		qInsert.setInt(OID_UM_ORIGEN, pers.getUnidad_medida_origen().getOID());
		qInsert.setInt(OID_UM_DESTINO, pers.getUnidad_medida_dest().getOID());
		qInsert.setDouble(FACT_CONV, pers.getFact_conv().doubleValue());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {

		final int OID_PRODUCTO = 1;
		final int OID_UM_ORIGEN = 2;
		final int OID_UM_DESTINO = 3;
		final int FACT_CONV = 4;
		final int OID_EQUIV_PROD = 5;

		ConversionUMProducto pers = (ConversionUMProducto) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update stEquivUMProd set " + "oid_producto=?"
				+ ",oid_um_origen=?" + ",oid_um_destino=?" + ",fact_conv=?"
				+ " where " + " oid_equiv_prod=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_EQUIV_PROD, pers.getOID());
		qUpdate.setInt(OID_PRODUCTO, pers.getProducto().getOID());
		qUpdate.setInt(OID_UM_ORIGEN, pers.getUnidad_medida_origen().getOID());
		qUpdate.setInt(OID_UM_DESTINO, pers.getUnidad_medida_dest().getOID());
		qUpdate.setDouble(FACT_CONV, pers.getFact_conv().doubleValue());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {
		final int OID_EQUIV_PROD = 1;
		ConversionUMProducto pers = (ConversionUMProducto) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("delete from stEquivUMProd  where "
				+ " oid_equiv_prod=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_EQUIV_PROD, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {
		final int OID_EQUIV_PROD = 1;
		ConversionUMProducto pers = (ConversionUMProducto) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update stEquivUMProd " + " set activo=1 " + " where "
				+ " oid_equiv_prod=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_EQUIV_PROD, pers.getOID());
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
		case SELECT_BY_PRODUCTO: {
			ps = this.selectByProducto(aCondiciones);
			break;
		}
		case SELECT_BY_UM_ORI_UM_DEST: {
			ps = this.selectByProductoUMOriUMDest(aCondiciones);
			break;
		}
		case SELECT_BY_UNI_ORI_UNI_DEST: {
			ps = this.selectByUniMedOriUniMedDest(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByUniMedOriUniMedDest(Object aCondiciones)
			throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  stEquivUMProd ");
		textSQL.append(" WHERE oid_um_origen = ? and oid_um_destino = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		UnidadMedida uniMedOri  = (UnidadMedida) condiciones.get("UNI_MED_ORI");
		UnidadMedida uniMedDest = (UnidadMedida) condiciones.get("UNI_MED_DEST");
		querySelect.setInt(1, uniMedOri.getOID());
		querySelect.setInt(2, uniMedDest.getOID());
		return querySelect;
	}

	private PreparedStatement selectByOID(Object aCondiciones)
			throws BaseException, SQLException {

		final int OID_EQUIV_PROD = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  stEquivUMProd ");
		textSQL.append(" WHERE oid_equiv_prod = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_EQUIV_PROD, oid);
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones)
			throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  stEquivUMProd ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectByProducto(Object aCondiciones)
			throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  stEquivUMProd ");
		textSQL.append(" WHERE oid_producto = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		Producto producto = (Producto) aCondiciones;
		querySelect.setInt(CODIGO, producto.getOID());
		return querySelect;
	}

	private PreparedStatement selectByProductoUMOriUMDest(Object aCondiciones)
			throws BaseException, SQLException {

		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  stEquivUMProd ");
		textSQL
				.append(" WHERE oid_producto = ? and oid_um_origen = ? and oid_um_destino = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		Producto producto = (Producto) condiciones.get(Producto.NICKNAME);
		UnidadMedida umOriOri = (UnidadMedida) condiciones.get("um_ori");
		UnidadMedida umOriDest = (UnidadMedida) condiciones.get("um_dest");
		querySelect.setInt(1, producto.getOID());
		querySelect.setInt(2, umOriOri.getOID());
		querySelect.setInt(3, umOriDest.getOID());
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones)
			throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL
				.append("SELECT oid_equiv_prod oid, codigo,  descripcion ,activo ");
		textSQL.append(" from stEquivUMProd");

		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static ConversionUMProducto getByProductoUMOriUMDest(
			Producto producto, UnidadMedida unidadMedidaOri,
			UnidadMedida unidadMedidaDest, ISesion aSesion)
			throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(Producto.NICKNAME, producto);
		condiciones.put("um_ori", unidadMedidaOri);
		condiciones.put("um_dest", unidadMedidaDest);

		return (ConversionUMProducto) ObjetoLogico.getObjects(
				ConversionUMProducto.NICKNAME,
				DBConversionUMProducto.SELECT_BY_UM_ORI_UM_DEST, condiciones,
				new ObjetoObservado(), aSesion);
	}

	public static List getConversionesUM(Producto aProducto, ISesion aSesion)
			throws BaseException {
		return (List) ObjetoLogico.getObjects(ConversionUMProducto.NICKNAME,
				DBConversionUMProducto.SELECT_BY_PRODUCTO, aProducto,
				new ListObserver(), aSesion);
	}
	
    public static ConversionUMProducto getConversionUMProducto(UnidadMedida unidadMedidaOri,
    											               UnidadMedida unidadMedidaDes, 	
	          ISesion aSesion)
	          throws BaseException {
    	  HashTableDatos condiciones = new HashTableDatos();
    	  condiciones.put("UNI_MED_ORI",unidadMedidaOri);
    	  condiciones.put("UNI_MED_DEST",unidadMedidaDes);
		  return (ConversionUMProducto) ObjetoLogico.getObjects(ConversionUMProducto.NICKNAME,
				  				DBConversionUMProducto.SELECT_BY_UNI_ORI_UNI_DEST,
				  				condiciones,
				  				new ObjetoObservado(),
				  				aSesion);
	}
	

}
