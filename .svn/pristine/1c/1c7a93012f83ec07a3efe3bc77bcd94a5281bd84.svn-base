package com.srn.erp.produccion.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.produccion.bm.OrdenFabricacion;
import com.srn.erp.stock.bm.Producto;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;

public class DBOrdenFabricacion extends DBObjetoPersistente {

	public static final String OID_ORDEN_FAB = "oid_orden_fab";
	public static final String OID_PRODUCTO = "oid_producto";
	public static final String CANTIDAD = "cantidad";
	public static final String OID_UM = "oid_um";
	public static final String OID_USU_APROB = "oid_usu_aprob";
	public static final String FEC_APROB = "fec_aprob";
	public static final String FEC_INI_EST = "fec_ini_est";
	public static final String FEC_FIN_EST = "fec_fin_est";
	public static final String OBS_ORD_FAB = "obs_ord_fab";
	public static final String OID_PLANTA = "oid_planta";
	public static final String OID_ALTER_FABRI = "oid_alter_fabri";
	public static final String CANT_PRODUCIDA = "cant_producida";
	public static final String CERRADA = "cerrada";
	public static final String PEND_PRODUCIR = "pend_producir";
	public static final String ESTADO_APROBACION = "estado_aprobacion";
	public static final String TIPO_ORDEN = "tipo_orden";

	public static final int SELECT_BY_CONDICIONES = 100;

	public DBOrdenFabricacion() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_ORDEN_FAB = 1;
		final int OID_PRODUCTO = 2;
		final int CANTIDAD = 3;
		final int OID_UM = 4;
		final int OID_USU_APROB = 5;
		final int FEC_APROB = 6;
		final int FEC_INI_EST = 7;
		final int FEC_FIN_EST = 8;
		final int OBS_ORD_FAB = 9;
		final int OID_PLANTA = 10;
		final int OID_ALTER_FABRI = 11;
		final int CANT_PRODUCIDA = 12;
		final int CERRADA = 13;
		final int PEND_PRODUCIR = 14;
		final int ESTADO_APROBACION = 15;
		final int TIPO_ORDEN = 16;

		OrdenFabricacion pers = (OrdenFabricacion) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into prOrdenFab " + " ( " + "OID_ORDEN_FAB," + "OID_PRODUCTO," + "CANTIDAD," + "OID_UM,"
				+ "OID_USU_APROB," + "FEC_APROB," + "FEC_INI_EST," + "FEC_FIN_EST," + "OBS_ORD_FAB," + "OID_PLANTA," + "OID_ALTER_FABRI,"
				+ "CANT_PRODUCIDA," + "CERRADA," + "PEND_PRODUCIR," + "ESTADO_APROBACION,TIPO_ORDEN)" + " values " + "(" + "?," + "?,"
				+ "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_ORDEN_FAB, pers.getOID());
		qInsert.setInt(OID_PRODUCTO, pers.getProducto().getOID());
		qInsert.setDouble(CANTIDAD, pers.getCantidad().doubleValue());
		qInsert.setInt(OID_UM, pers.getUnidad_medida().getOID());
		if (pers.getUsuario_aprobacion() != null)
			qInsert.setInt(OID_USU_APROB, pers.getUsuario_aprobacion().getOID());
		else
			qInsert.setNull(OID_USU_APROB, java.sql.Types.INTEGER);
		qInsert.setDate(FEC_APROB, new java.sql.Date(pers.getFecha_aprobacion().getTime()));
		qInsert.setDate(FEC_INI_EST, new java.sql.Date(pers.getFec_ini_est().getTime()));
		qInsert.setDate(FEC_FIN_EST, new java.sql.Date(pers.getFec_fin_est().getTime()));
		qInsert.setString(OBS_ORD_FAB, pers.getObs_ord_fab());
		qInsert.setInt(OID_PLANTA, pers.getPlanta().getOID());
		qInsert.setInt(OID_ALTER_FABRI, pers.getAlternativa_fabricacion().getOID());
		qInsert.setDouble(CANT_PRODUCIDA, pers.getCant_producida().doubleValue());
		qInsert.setBoolean(CERRADA, pers.isCerrada().booleanValue());
		qInsert.setBoolean(PEND_PRODUCIR, pers.isPend_producir().booleanValue());
		qInsert.setBoolean(ESTADO_APROBACION, pers.isEstado_aprobacion().booleanValue());
		qInsert.setString(TIPO_ORDEN, pers.getTipoOrden());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_PRODUCTO = 1;
		final int CANTIDAD = 2;
		final int OID_UM = 3;
		final int OID_USU_APROB = 4;
		final int FEC_APROB = 5;
		final int FEC_INI_EST = 6;
		final int FEC_FIN_EST = 7;
		final int OBS_ORD_FAB = 8;
		final int OID_PLANTA = 9;
		final int OID_ALTER_FABRI = 10;
		final int CANT_PRODUCIDA = 11;
		final int CERRADA = 12;
		final int PEND_PRODUCIR = 13;
		final int ESTADO_APROBACION = 14;
		final int TIPO_ORDEN = 15;
		final int OID_ORDEN_FAB = 16;

		OrdenFabricacion pers = (OrdenFabricacion) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update prOrdenFab set " + "oid_producto=?" + ",cantidad=?" + ",oid_um=?" + ",oid_usu_aprob=?" + ",fec_aprob=?"
				+ ",fec_ini_est=?" + ",fec_fin_est=?" + ",obs_ord_fab=?" + ",oid_planta=?" + ",oid_alter_fabri=?" + ",cant_producida=?"
				+ ",cerrada=?" + ",pend_producir=?" + ",estado_aprobacion=?" + ",tipo_orden-=?" + " where " + " oid_orden_fab=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_ORDEN_FAB, pers.getOID());
		qUpdate.setInt(OID_PRODUCTO, pers.getProducto().getOID());
		qUpdate.setDouble(CANTIDAD, pers.getCantidad().doubleValue());
		qUpdate.setInt(OID_UM, pers.getUnidad_medida().getOID());
		if (pers.getUsuario_aprobacion() != null)
			qUpdate.setInt(OID_USU_APROB, pers.getUsuario_aprobacion().getOID());
		else
			qUpdate.setNull(OID_USU_APROB, java.sql.Types.INTEGER);
		qUpdate.setDate(FEC_APROB, new java.sql.Date(pers.getFecha_aprobacion().getTime()));
		qUpdate.setDate(FEC_INI_EST, new java.sql.Date(pers.getFec_ini_est().getTime()));
		qUpdate.setDate(FEC_FIN_EST, new java.sql.Date(pers.getFec_fin_est().getTime()));
		qUpdate.setString(OBS_ORD_FAB, pers.getObs_ord_fab());
		qUpdate.setInt(OID_PLANTA, pers.getPlanta().getOID());
		qUpdate.setInt(OID_ALTER_FABRI, pers.getAlternativa_fabricacion().getOID());
		qUpdate.setDouble(CANT_PRODUCIDA, pers.getCant_producida().doubleValue());
		qUpdate.setBoolean(CERRADA, pers.isCerrada().booleanValue());
		qUpdate.setBoolean(PEND_PRODUCIR, pers.isPend_producir().booleanValue());
		qUpdate.setBoolean(ESTADO_APROBACION, pers.isEstado_aprobacion().booleanValue());
		qUpdate.setString(TIPO_ORDEN, pers.getTipoOrden());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_CCO_PED = 1;
		OrdenFabricacion pers = (OrdenFabricacion) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update geComproCab " + " set activo=0 " + " where " + " oid_cco=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_CCO_PED, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_ORDEN_FAB = 1;
		OrdenFabricacion pers = (OrdenFabricacion) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update prOrdenFab " + " set activo=1 " + " where " + " oid_orden_fab=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_ORDEN_FAB, pers.getOID());
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
		case SELECT_BY_CONDICIONES: {
			ps = this.selectByCondiciones(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_ORDEN_FAB = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  prOrdenFab a,geComproCab b ");
		textSQL.append(" WHERE a.oid_orden_fab = b.oid_cco and a.oid_orden_fab=?  ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_ORDEN_FAB, oid);
		return querySelect;
	}
	
	private PreparedStatement selectByCondiciones(Object aCondiciones) throws BaseException, SQLException {

		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		
		
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  prOrdenFab a, geComproCab b ");
		textSQL.append(" WHERE  b.oid_cco = a.oid_orden_fab ");
		
		if (condiciones.containsKey("NRO_EXT_DESDE")) {
			Integer nroExtDesde = (Integer)condiciones.get("NRO_EXT_DESDE");
			textSQL.append(" and b.nro_ext>="+nroExtDesde.toString());
		}
		
		if (condiciones.containsKey("NRO_EXT_HASTA")) {
			Integer nroExtHasta = (Integer)condiciones.get("NRO_EXT_HASTA");
			textSQL.append(" and b.nro_ext<="+nroExtHasta.toString());
		}
		
		if (condiciones.containsKey("FEC_DESDE")) {
			java.util.Date fecDesde = (java.util.Date)condiciones.get("FEC_DESDE");
			textSQL.append(" and b.emision>=?");
		}
		
		if (condiciones.containsKey("FEC_HASTA")) {
			java.util.Date fecHasta = (java.util.Date)condiciones.get("FEC_HASTA");
			textSQL.append(" and b.emision<=?");
		}
		
		if (condiciones.containsKey(Producto.NICKNAME)) {
			Producto producto = (Producto)condiciones.get(Producto.NICKNAME);
			textSQL.append(" and a.oid_producto="+producto.getOIDInteger());
		}

		if (condiciones.containsKey("FEC_INI_DESDE")) {
			java.util.Date fecIniDesde = (java.util.Date)condiciones.get("FEC_INI_DESDE");
			textSQL.append(" and a.fec_ini_est>=?");
		}
		
		if (condiciones.containsKey("FEC_INI_HASTA")) {
			java.util.Date fecIniDesde = (java.util.Date)condiciones.get("FEC_INI_HASTA");
			textSQL.append(" and a.fec_ini_est<=?");
		}
		
		if (condiciones.containsKey("FEC_FIN_DESDE")) {
			java.util.Date fecFinDesde = (java.util.Date)condiciones.get("FEC_FIN_DESDE");
			textSQL.append(" and a.fec_fin_est>=?");
		}
		
		if (condiciones.containsKey("FEC_FIN_HASTA")) {
			java.util.Date fecFinHasta = (java.util.Date)condiciones.get("FEC_FIN_HASTA");
			textSQL.append(" and a.fec_fin_est<=?");
		}
		
		if (condiciones.containsKey("TIPO_ORDEN")) {
			String tipoOrden = (String)condiciones.get("TIPO_ORDEN");
			textSQL.append(" and a.tipo_orden='"+tipoOrden+"'");
		}
		
		if (condiciones.containsKey("SOLO_ABIERTAS")) {
			textSQL.append(" and a.cerrada = 0 ");
		}
		
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		
		// Cambiar a la fecha desde
		int nroParam = 0;
		if (condiciones.containsKey("FEC_DESDE")) {
			++nroParam;
			java.util.Date fecDesde = (java.util.Date)condiciones.get("FEC_DESDE");
			querySelect.setDate(nroParam, new java.sql.Date(fecDesde.getTime()));
		}
		
		if (condiciones.containsKey("FEC_HASTA")) {
			++nroParam;
			java.util.Date fecHasta = (java.util.Date)condiciones.get("FEC_HASTA");
			querySelect.setDate(nroParam, new java.sql.Date(fecHasta.getTime()));
		}
		
		if (condiciones.containsKey("FEC_INI_DESDE")) {
			++nroParam;
			java.util.Date fecIniDesde = (java.util.Date)condiciones.get("FEC_INI_DESDE");
			querySelect.setDate(nroParam, new java.sql.Date(fecIniDesde.getTime()));
		}
		
		if (condiciones.containsKey("FEC_INI_HASTA")) {
			++nroParam;
			java.util.Date fecIniHasta = (java.util.Date)condiciones.get("FEC_INI_HASTA");
			querySelect.setDate(nroParam, new java.sql.Date(fecIniHasta.getTime()));
		}
		
		if (condiciones.containsKey("FEC_FIN_DESDE")) {
			++nroParam;
			java.util.Date fecFinDesde = (java.util.Date)condiciones.get("FEC_FIN_DESDE");
			querySelect.setDate(nroParam, new java.sql.Date(fecFinDesde.getTime()));
		}
		
		if (condiciones.containsKey("FEC_FIN_HASTA")) {
			++nroParam;
			java.util.Date fecFinHasta = (java.util.Date)condiciones.get("FEC_FIN_HASTA");
			querySelect.setDate(nroParam, new java.sql.Date(fecFinHasta.getTime()));
		}
		
		
		
		return querySelect;
	}
	
	
	

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  prOrdenFab ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_orden_fab oid, codigo,  descripcion ,activo ");
		textSQL.append(" from prOrdenFab");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static List getOrdenes(Integer nroExtDesde, Integer nroExtHasta, java.util.Date fecDesde, java.util.Date fecHasta,
			Producto producto, java.util.Date fecIniDesde, java.util.Date fecIniHasta, java.util.Date fecFinDesde,
			java.util.Date fecFinHasta, String tipoOrden, Boolean soloProdAbiertas, ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		if (nroExtDesde != null)
			condiciones.put("NRO_EXT_DESDE", nroExtDesde);
		if (nroExtHasta != null)
			condiciones.put("NRO_EXT_HASTA", nroExtHasta);
		if (fecDesde != null)
			condiciones.put("FEC_DESDE", fecDesde);
		if (fecHasta != null)
			condiciones.put("FEC_HASTA", fecHasta);
		if (producto != null)
			condiciones.put(Producto.NICKNAME, producto);
		if (fecIniDesde != null)
			condiciones.put("FEC_INI_DESDE", fecIniDesde);
		if (fecIniHasta != null)
			condiciones.put("FEC_INI_HASTA", fecIniHasta);
		if (fecFinDesde != null)
			condiciones.put("FEC_FIN_DESDE", fecFinDesde);
		if (fecFinHasta != null)
			condiciones.put("FEC_FIN_HASTA", fecFinHasta);
		if (tipoOrden != null)
			condiciones.put("TIPO_ORDEN", tipoOrden);
		if (soloProdAbiertas != null)
			condiciones.put("SOLO_ABIERTAS", soloProdAbiertas);

		return (List) ObjetoLogico.getObjects(OrdenFabricacion.NICKNAME, DBOrdenFabricacion.SELECT_BY_CONDICIONES, condiciones,
				new ListObserver(), aSesion);
	}
}
