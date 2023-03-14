package com.srn.erp.compras.da;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import com.srn.erp.compras.bm.AcuerdoLP;
import com.srn.erp.compras.bm.AcuerdoLPDetalle;
import com.srn.erp.stock.bm.Producto;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;

public class DBAcuerdoLPDetalle extends DBObjetoPersistente {

	public static final String OID_ACU_LP_DET = "oid_acu_lp_det";

	public static final String OID_ACUERDO_LP = "oid_acuerdo_lp";

	public static final String OID_PRODUCTO = "oid_producto";

	public static final String CANTIDAD = "cantidad";

	public static final String OID_UM = "oid_um";

	public static final String OID_MONEDA = "oid_moneda";

	public static final String PRECIO = "precio";

	public static final String COMENTARIO = "comentario";

	public static final String ACTIVO = "activo";
	
	public static final String COD_PROD_PROV = "cod_prod_prov";
	
	public static final String DESC_PROD_PROV = "desc_prod_prov";

	public static final int SELECT_BY_ACUERDO_LP = 100;
	
	public static final int SELECT_BY_ACUERDO_LP_PRODUCTO_FECHA = 101;

	public DBAcuerdoLPDetalle() {
	}

	protected void insert(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {

		final int OID_ACU_LP_DET = 1;
		final int OID_ACUERDO_LP = 2;
		final int OID_PRODUCTO = 3;
		final int CANTIDAD = 4;
		final int OID_UM = 5;
		final int OID_MONEDA = 6;
		final int PRECIO = 7;
		final int COMENTARIO = 8;
		final int ACTIVO = 9;
		final int COD_PROD_PROV = 10;
		final int DESC_PROD_PROV = 11;

		AcuerdoLPDetalle pers = (AcuerdoLPDetalle) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into cpAcuLPDet " + " ( " + "OID_ACU_LP_DET,"
				+ "OID_ACUERDO_LP," + "OID_PRODUCTO," + 
				"CANTIDAD," + "OID_UM," + "OID_MONEDA,"
				+ "PRECIO," + "COMENTARIO," + "ACTIVO , COD_PROD_PROV , DESC_PROD_PROV)" + " values " + "("
				+ "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?,"
				+ "?," +"?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD()
				.prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_ACU_LP_DET, pers.getOID());
		qInsert.setInt(OID_ACUERDO_LP, pers.getAcuerdo_lp().getOID());
		if (pers.getProducto()!=null)
		  qInsert.setInt(OID_PRODUCTO, pers.getProducto().getOID());
		else
		  qInsert.setNull(OID_PRODUCTO, Types.INTEGER);	
			
		qInsert.setDouble(CANTIDAD, pers.getCantidad().doubleValue());
		qInsert.setInt(OID_UM, pers.getUnidad_medida().getOID());
		qInsert.setInt(OID_MONEDA, pers.getMoneda().getOID());
		qInsert.setDouble(PRECIO, pers.getPrecio().doubleValue());
		if (pers.getComentario() != null)
			qInsert.setString(COMENTARIO, pers.getComentario());
		else
			qInsert.setNull(COMENTARIO, Types.VARCHAR);
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qInsert.setString(COD_PROD_PROV,pers.getCodProdProv());
		if (pers.getDescProdProv()!=null)
				qInsert.setString(DESC_PROD_PROV,pers.getDescProdProv());
			else
				qInsert.setNull(DESC_PROD_PROV,Types.VARCHAR);		
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {

		final int OID_ACUERDO_LP = 1;
		final int OID_PRODUCTO = 2;
		final int CANTIDAD = 3;
		final int OID_UM = 4;
		final int OID_MONEDA = 5;
		final int PRECIO = 6;
		final int COMENTARIO = 7;
		final int ACTIVO = 8;
		final int COD_PROD_PROV = 9;
		final int DESC_PROD_PROV = 10;
		final int OID_ACU_LP_DET = 11;
		

		AcuerdoLPDetalle pers = (AcuerdoLPDetalle) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update cpAcuLPDet set " + "oid_acuerdo_lp=?"
				+ ",oid_producto=?" 
				+ ",cantidad=?" + ",oid_um=?" + ",oid_moneda=?" + ",precio=?"
				+ ",comentario=?" + ",activo=?,cod_prod_prov = ?, desc_prod_prov = ?" + " where "
				+ " oid_acu_lp_det=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_ACU_LP_DET, pers.getOID());
		qUpdate.setInt(OID_ACUERDO_LP, pers.getAcuerdo_lp().getOID());

		if (pers.getProducto()!=null)
			qUpdate.setInt(OID_PRODUCTO, pers.getProducto().getOID());
			else
			qUpdate.setNull(OID_PRODUCTO, Types.INTEGER);		
		
		qUpdate.setDouble(CANTIDAD, pers.getCantidad().doubleValue());
		qUpdate.setInt(OID_UM, pers.getUnidad_medida().getOID());
		qUpdate.setInt(OID_MONEDA, pers.getMoneda().getOID());
		qUpdate.setDouble(PRECIO, pers.getPrecio().doubleValue());
		if (pers.getComentario() != null)
			qUpdate.setString(COMENTARIO, pers.getComentario());
		else
			qUpdate.setNull(COMENTARIO, Types.VARCHAR);
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qUpdate.setString(COD_PROD_PROV,pers.getCodProdProv());
		if (pers.getDescProdProv()!=null)
		  qUpdate.setString(DESC_PROD_PROV,pers.getDescProdProv());
		else
		  qUpdate.setNull(DESC_PROD_PROV,Types.VARCHAR);
			
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {
		final int OID_ACU_LP_DET = 1;
		AcuerdoLPDetalle pers = (AcuerdoLPDetalle) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cpAcuLPDet " 
				+ " set activo=0 where oid_acu_lp_det=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_ACU_LP_DET, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {
		final int OID_ACU_LP_DET = 1;
		AcuerdoLPDetalle pers = (AcuerdoLPDetalle) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cpAcuLPDet " + " set activo=1 " + " where "
				+ " oid_acu_lp_det=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_ACU_LP_DET, pers.getOID());
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
		case SELECT_BY_ACUERDO_LP: {
			ps = this.selectByAcuerdoLP(aCondiciones);
			break;
		}
		case SELECT_BY_ACUERDO_LP_PRODUCTO_FECHA: {
			ps = this.selectByAcuerdoLPProductoFecha(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones)
			throws BaseException, SQLException {

		final int OID_ACU_LP_DET = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cpAcuLPDet ");
		textSQL.append(" WHERE oid_acu_lp_det = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_ACU_LP_DET, oid);
		return querySelect;
	}
	
	private PreparedStatement selectByAcuerdoLPProductoFecha(Object aCondiciones)
			throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append(" SELECT * FROM  cpAcuLPDet ");
		textSQL.append(" WHERE oid_acuerdo_lp = ? ");
		textSQL.append(" and oid_producto = ? ");
		
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		AcuerdoLP acuerdoLP = (AcuerdoLP) condiciones.get(AcuerdoLP.NICKNAME);
		Producto producto = (Producto) condiciones.get(Producto.NICKNAME);
		
		querySelect.setInt(1, acuerdoLP.getOID());
		querySelect.setInt(2, producto.getOID());
		
		return querySelect;
	}

	private PreparedStatement selectByAcuerdoLP(Object aCondiciones)
			throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cpAcuLPDet ");
		textSQL.append(" WHERE oid_acuerdo_lp = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		AcuerdoLP acuerdoLP = (AcuerdoLP) aCondiciones;
		querySelect.setInt(1, acuerdoLP.getOID());
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones)
			throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cpAcuLPDet ");
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
				.append("SELECT oid_acu_lp_det oid, codigo,  descripcion ,activo ");
		textSQL.append(" from cpAcuLPDet");

		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static List getAcuerdosLPDetalles(AcuerdoLP acuerdoLP,
			ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(AcuerdoLPDetalle.NICKNAME,
				DBAcuerdoLPDetalle.SELECT_BY_ACUERDO_LP, acuerdoLP,
				new ListObserver(), aSesion);
	}
	
	public static List getAcuerdosLPDetalles(AcuerdoLP acuerdoLP,
											 Producto producto,
											 
			ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(AcuerdoLP.NICKNAME,acuerdoLP);
		condiciones.put(Producto.NICKNAME,producto);
		return (List) ObjetoLogico.getObjects(AcuerdoLPDetalle.NICKNAME,
				DBAcuerdoLPDetalle.SELECT_BY_ACUERDO_LP_PRODUCTO_FECHA, condiciones,
				new ListObserver(), aSesion);
	}
	

}
