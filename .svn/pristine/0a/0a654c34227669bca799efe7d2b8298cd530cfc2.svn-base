package com.srn.erp.compras.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

import com.srn.erp.compras.bm.AcuerdoLP;
import com.srn.erp.compras.bm.PrecioCompraPorClasifArt;
import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.general.bm.IValorClasificadorEntidad;
import com.srn.erp.general.bm.Periodo;
import com.srn.erp.general.bm.ValorClasifEntProdGen;
import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.general.da.DBPeriodo;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.bm.ProductoProveedor;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBPrecioCompraPorClasifArt extends DBObjetoPersistente {

	public static final String OID_PRECIO_CLASIF = "oid_precio_clasif";
	public static final String OID_ACUERDO_LP = "oid_acuerdo_lp";
	public static final String OID_VAL_CLASIF_ART = "oid_val_clasif_art";
	public static final String OID_CLASIFICADOR = "oid_clasificador";
	public static final String OID_UM = "oid_um";
	public static final String CANTIDAD = "cantidad";
	public static final String PRECIO = "precio";
	public static final String OID_MONEDA = "oid_moneda";
	public static final String ACTIVO = "activo";
	public static final String FEC_VIGENCIA = "fec_vigencia";
	public static final String PRODUCTO_PROVEEDOR = "oid_prod_prov";

	public static final int SELECT_BY_ACUERDO_LP = 100;
	public static final int SELECT_BY_ACUERDO_CLASIF_VAL_CLASIF = 101;
	public static final int SELECT_BY_ACUERDO_PROD_PRECIO_VIG = 102;
	public static final int SELECT_BY_ACUERDO_PROD_FECHA = 103;
	public static final int SELECT_BY_PROX_PRECIO_COMPRA_A_FEC = 104;
	public static final int SELECT_BY_PRECIO_VIG_A_FECHA = 105;
	public static final int SELECT_BY_PRECIO_VIG_LP = 106;
	public static final int SELECT_BY_VAL_CLASIF_ACT = 107;
	public static final int SELECT_BY_ULT_PROD_VIG_ACT = 108;
	public static final int SELECT_BY_PRECIO_VIG_A_FECHA_DE_PRODGRAL = 109;
	public static final int SELECT_BY_PROD_PROV_ACTIVO = 110;
	public static final int SELECT_BY_ALL_ACTIVOS = 111;

	public DBPrecioCompraPorClasifArt() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_PRECIO_CLASIF = 1;
		final int OID_ACUERDO_LP = 2;
		final int OID_VAL_CLASIF_ART = 3;
		final int OID_CLASIFICADOR = 4;
		final int OID_UM = 5;
		final int CANTIDAD = 6;
		final int PRECIO = 7;
		final int OID_MONEDA = 8;
		final int ACTIVO = 9;
		final int FEC_VIGENCIA = 10;
		final int OID_PROD_PROVEEDOR = 11;

		PrecioCompraPorClasifArt pers = (PrecioCompraPorClasifArt) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into cpPrecPorClasifArt " + " ( " + "OID_PRECIO_CLASIF," + "OID_ACUERDO_LP," + "OID_VAL_CLASIF_ART,"
				+ "OID_CLASIFICADOR," + "OID_UM," + "CANTIDAD," + "PRECIO," + "OID_MONEDA," + "ACTIVO , FEC_VIGENCIA , OID_PROD_PROV)"
				+ " values " + "(" + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_PRECIO_CLASIF, pers.getOID());
		qInsert.setInt(OID_ACUERDO_LP, pers.getAcuerdo_lp().getOID());
		qInsert.setInt(OID_VAL_CLASIF_ART, pers.getValor_clasif_art().getOID());
		qInsert.setInt(OID_CLASIFICADOR, pers.getClasificador().getOID());
		qInsert.setInt(OID_UM, pers.getUnidad_medida().getOID());
		qInsert.setDouble(CANTIDAD, pers.getCantidad().doubleValue());
		qInsert.setDouble(PRECIO, pers.getPrecio().doubleValue());
		qInsert.setInt(OID_MONEDA, pers.getMoneda().getOID());
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qInsert.setDate(FEC_VIGENCIA, new java.sql.Date(pers.getFechaVigencia().getTime()));
		if (pers.getProductoProveedor() != null)
			qInsert.setInt(OID_PROD_PROVEEDOR, pers.getProductoProveedor().getOID());
		else
			qInsert.setNull(OID_PROD_PROVEEDOR, java.sql.Types.INTEGER);
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_ACUERDO_LP = 1;
		final int OID_VAL_CLASIF_ART = 2;
		final int OID_CLASIFICADOR = 3;
		final int OID_UM = 4;
		final int CANTIDAD = 5;
		final int PRECIO = 6;
		final int OID_MONEDA = 7;
		final int ACTIVO = 8;
		final int FEC_VIGENCIA = 9;
		final int OID_PROD_PROVEEDOR = 10;
		final int OID_PRECIO_CLASIF = 11;

		PrecioCompraPorClasifArt pers = (PrecioCompraPorClasifArt) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update cpPrecPorClasifArt set " + "oid_acuerdo_lp=?" + ",oid_val_clasif_art=?" + ",oid_clasificador=?"
				+ ",oid_um=?" + ",cantidad=?" + ",precio=?" + ",oid_moneda=?" + ",activo=? , fec_vigencia = ? , oid_prod_prov = ? "
				+ " where " + " oid_precio_clasif=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_PRECIO_CLASIF, pers.getOID());
		qUpdate.setInt(OID_ACUERDO_LP, pers.getAcuerdo_lp().getOID());
		qUpdate.setInt(OID_VAL_CLASIF_ART, pers.getValor_clasif_art().getOID());
		qUpdate.setInt(OID_CLASIFICADOR, pers.getClasificador().getOID());
		qUpdate.setInt(OID_UM, pers.getUnidad_medida().getOID());
		qUpdate.setDouble(CANTIDAD, pers.getCantidad().doubleValue());
		qUpdate.setDouble(PRECIO, pers.getPrecio().doubleValue());
		qUpdate.setInt(OID_MONEDA, pers.getMoneda().getOID());
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qUpdate.setDate(FEC_VIGENCIA, new java.sql.Date(pers.getFechaVigencia().getTime()));
		if (pers.getProductoProveedor() != null)
			qUpdate.setInt(OID_PROD_PROVEEDOR, pers.getProductoProveedor().getOID());
		else
			qUpdate.setNull(OID_PROD_PROVEEDOR, java.sql.Types.INTEGER);
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_PRECIO_CLASIF = 1;
		PrecioCompraPorClasifArt pers = (PrecioCompraPorClasifArt) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cpPrecPorClasifArt " + " set activo=0 " + " where " + " oid_precio_clasif=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_PRECIO_CLASIF, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_PRECIO_CLASIF = 1;
		PrecioCompraPorClasifArt pers = (PrecioCompraPorClasifArt) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cpPrecPorClasifArt " + " set activo=1 " + " where " + " oid_precio_clasif=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_PRECIO_CLASIF, pers.getOID());
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
		case SELECT_BY_ACUERDO_LP: {
			ps = this.selectByAcuerdoLP(aCondiciones);
			break;
		}
		case SELECT_BY_ACUERDO_PROD_FECHA: {
			ps = this.selectByAcuerdoProductoFecha(aCondiciones);
			break;
		}
		case SELECT_BY_ACUERDO_CLASIF_VAL_CLASIF: {
			ps = this.selectByAcuerdoClasifValClasif(aCondiciones);
			break;
		}
		case SELECT_BY_PROX_PRECIO_COMPRA_A_FEC: {
			ps = this.selectByProxPrecioCompra(aCondiciones);
			break;
		}
		case SELECT_BY_ACUERDO_PROD_PRECIO_VIG: {
			ps = this.selectByAcuerdoPrecioVigAFecha(aCondiciones);
			break;
		}
		case SELECT_BY_PRECIO_VIG_A_FECHA: {
			ps = this.selectByPreciosVigentesAFecha(aCondiciones);
			break;
		}
		case SELECT_BY_PRECIO_VIG_LP: {
			ps = this.selectByPrecioVigenteLP(aCondiciones);
			break;
		}
		case SELECT_BY_VAL_CLASIF_ACT: {
			ps = this.selectByValClasifActivos(aCondiciones);
			break;
		}
		case SELECT_BY_ULT_PROD_VIG_ACT: {
			ps = this.selectByUltProdVigAct(aCondiciones);
			break;
		}
		case SELECT_BY_PRECIO_VIG_A_FECHA_DE_PRODGRAL: {
			ps = this.selectByPreciosVigentesAFecha(aCondiciones);
			break;
		}
		case SELECT_BY_PROD_PROV_ACTIVO: {
			ps = this.selectByProductoProveedorActivo(aCondiciones);
			break;
		}
		case SELECT_BY_ALL_ACTIVOS: {
			ps = this.selectByAllActivos(aCondiciones);
			break;
		}
		}

		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_PRECIO_CLASIF = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cpPrecPorClasifArt ");
		textSQL.append(" WHERE oid_precio_clasif = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_PRECIO_CLASIF, oid);
		return querySelect;
	}

	private PreparedStatement selectByAcuerdoProductoFecha(Object aCondiciones) throws BaseException, SQLException {

		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		Integer oidAcuerdoLP = (Integer) condiciones.get("oid_acuerdo_lp");

		ClasificadorEntidad clasifEnt = (ClasificadorEntidad) condiciones.get(ClasificadorEntidad.NICKNAME);
		ValorClasificadorEntidad valClasifEnt = (ValorClasificadorEntidad) condiciones.get(ValorClasificadorEntidad.NICKNAME);
		java.util.Date fecha = (java.util.Date) condiciones.get("FECHA");

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cpPrecPorClasifArt ");
		textSQL
				.append(" WHERE oid_acuerdo_lp = ? and oid_clasificador = ? and oid_val_clasif_art = ? and activo = 1 and fec_vigencia = ?  ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		querySelect.setInt(1, oidAcuerdoLP);
		querySelect.setInt(2, clasifEnt.getOID());
		querySelect.setInt(3, valClasifEnt.getOID());
		querySelect.setDate(4, new java.sql.Date(fecha.getTime()));

		return querySelect;
	}

	private PreparedStatement selectByPrecioVigenteLP(Object aCondiciones) throws BaseException, SQLException {

		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		String tipoAcuerdo = null;
		if (condiciones.containsKey("TIPO_ACUERDO"))
		tipoAcuerdo = (String) condiciones.get("TIPO_ACUERDO");
		Proveedor proveedor = (Proveedor) condiciones.get(Proveedor.NICKNAME);
		ValorClasificadorEntidad valClasifEnt = (ValorClasificadorEntidad) condiciones.get(ValorClasificadorEntidad.NICKNAME);
		java.util.Date fecVigencia = (java.util.Date) condiciones.get("FEC_VIGENCIA");

		StringBuffer textSQL = new StringBuffer();
		textSQL.append(" SELECT ");
		textSQL.append("   a.* ");
		textSQL.append(" FROM  ");
		textSQL.append("   cpPrecPorClasifArt a, cpAcuerdosLP b , cpTiposAcuerdos c , stProdProveedor d ");
		textSQL.append(" WHERE ");
		textSQL.append("   a.oid_acuerdo_lp = b.oid_acuerdo_lp and b.activo = 1 ");
		textSQL.append("   and b.oid_tipo_acuerdo = c.oid_tipo_acuerdo and a.activo = 1 and a.oid_prod_prov = d.oid_prod_prov and d.prioridad<>0  ");
		if (tipoAcuerdo !=null)
			textSQL.append("   and c.tipo_acuerdo = ? ");
		if (proveedor != null)
			textSQL.append("   and b.oid_proveedor = " + proveedor.getOIDInteger());
		textSQL.append("   and a.oid_clasificador = ? and a.oid_val_clasif_art = ?  ");
		textSQL.append("   and a.fec_vigencia <= ? and a.fec_vigencia = ");

		textSQL.append(" (SELECT ");
		textSQL.append("   max(a1.fec_vigencia) ");
		textSQL.append(" FROM  ");
		textSQL.append("   cpPrecPorClasifArt a1, cpAcuerdosLP b1 , cpTiposAcuerdos c1 , stProdProveedor d1  ");
		textSQL.append(" WHERE ");
		textSQL.append("   a1.oid_acuerdo_lp = b1.oid_acuerdo_lp and b1.activo = 1 ");
		textSQL.append("   and b1.oid_tipo_acuerdo = c1.oid_tipo_acuerdo and a1.activo = 1 and a1.oid_prod_prov = d1.oid_prod_prov and d1.prioridad<>0   ");
		if (tipoAcuerdo !=null)
			textSQL.append("   and c1.tipo_acuerdo = ? ");
		if (proveedor != null)
			textSQL.append("   and b1.oid_proveedor = " + proveedor.getOIDInteger());
		textSQL.append("   and a1.oid_clasificador = ? and a1.oid_val_clasif_art = ?  ");
		textSQL.append("   and a1.fec_vigencia <= ?) ");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int nroParam = 1;
		if (tipoAcuerdo !=null) {
			querySelect.setString(nroParam, tipoAcuerdo);
			++nroParam;
		}
		querySelect.setInt(nroParam, valClasifEnt.getClasificador_entidad().getOID());
		++nroParam;
		querySelect.setInt(nroParam, valClasifEnt.getOID());
		++nroParam;
		querySelect.setDate(nroParam, new java.sql.Date(fecVigencia.getTime()));
		++nroParam;

		if (tipoAcuerdo !=null) {
			querySelect.setString(nroParam, tipoAcuerdo);
			++nroParam;
		}
		querySelect.setInt(nroParam, valClasifEnt.getClasificador_entidad().getOID());
		++nroParam;
		querySelect.setInt(nroParam, valClasifEnt.getOID());
		++nroParam;
		querySelect.setDate(nroParam, new java.sql.Date(fecVigencia.getTime()));

		return querySelect;
	}

	private PreparedStatement selectByUltProdVigAct(Object aCondiciones) throws BaseException, SQLException {

		ValorClasificadorEntidad valorClasifEnt = (ValorClasificadorEntidad) aCondiciones;
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT a.* FROM  cpPrecPorClasifArt a ");
		textSQL.append(" WHERE a.oid_val_clasif_art = ? and a.activo = 1 and exist (select * from ) ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		querySelect.setInt(1, valorClasifEnt.getOID());
		return querySelect;
	}

	private PreparedStatement selectByAllActivos(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cpPrecPorClasifArt ");
		textSQL.append(" WHERE activo = 1 ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}
	
	

	private PreparedStatement selectByValClasifActivos(Object aCondiciones) throws BaseException, SQLException {

		ValorClasificadorEntidad valorClasifEnt = (ValorClasificadorEntidad) aCondiciones;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cpPrecPorClasifArt ");
		textSQL.append(" WHERE oid_val_clasif_art = ? and activo = 1 ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		querySelect.setInt(1, valorClasifEnt.getOID());
		return querySelect;
	}

	private PreparedStatement selectByAcuerdoPrecioVigAFecha(Object aCondiciones) throws BaseException, SQLException {

		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		Integer oidAcuerdoLP = (Integer) condiciones.get("oid_acuerdo_lp");

		ClasificadorEntidad clasifEnt = (ClasificadorEntidad) condiciones.get(ClasificadorEntidad.NICKNAME);
		ValorClasificadorEntidad valClasifEnt = (ValorClasificadorEntidad) condiciones.get(ValorClasificadorEntidad.NICKNAME);
		java.util.Date fecha = (java.util.Date) condiciones.get("FECHA");

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cpPrecPorClasifArt ");
		textSQL
				.append(" WHERE oid_acuerdo_lp = ? and oid_clasificador = ? and oid_val_clasif_art = ? and activo = 1 and fec_vigencia <= ? order by fec_vigencia desc ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		querySelect.setInt(1, oidAcuerdoLP);
		querySelect.setInt(2, clasifEnt.getOID());
		querySelect.setInt(3, valClasifEnt.getOID());
		querySelect.setDate(4, new java.sql.Date(fecha.getTime()));

		return querySelect;
	}

	private PreparedStatement selectByProxPrecioCompra(Object aCondiciones) throws BaseException, SQLException {

		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		Integer oidAcuerdoLP = (Integer) condiciones.get("oid_acuerdo_lp");

		ClasificadorEntidad clasifEnt = (ClasificadorEntidad) condiciones.get(ClasificadorEntidad.NICKNAME);
		ValorClasificadorEntidad valClasifEnt = (ValorClasificadorEntidad) condiciones.get(ValorClasificadorEntidad.NICKNAME);
		java.util.Date fecha = (java.util.Date) condiciones.get("FECHA");

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cpPrecPorClasifArt ");
		textSQL
				.append(" WHERE oid_acuerdo_lp = ? and oid_clasificador = ? and oid_val_clasif_art = ? and activo = 1 and fec_vigencia > ? order by fec_vigencia  ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		querySelect.setInt(1, oidAcuerdoLP);
		querySelect.setInt(2, clasifEnt.getOID());
		querySelect.setInt(3, valClasifEnt.getOID());
		querySelect.setDate(4, new java.sql.Date(fecha.getTime()));

		return querySelect;
	}

	private PreparedStatement selectByAcuerdoClasifValClasif(Object aCondiciones) throws BaseException, SQLException {

		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		Integer oidAcuerdoLP = (Integer) condiciones.get("oid_acuerdo_lp");

		ClasificadorEntidad clasifEnt = (ClasificadorEntidad) condiciones.get(ClasificadorEntidad.NICKNAME);
		ValorClasificadorEntidad valClasifEnt = (ValorClasificadorEntidad) condiciones.get(ValorClasificadorEntidad.NICKNAME);

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cpPrecPorClasifArt ");
		textSQL.append(" WHERE oid_acuerdo_lp = ? and oid_clasificador = ? and oid_val_clasif_art = ? and activo = 1");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		querySelect.setInt(1, oidAcuerdoLP);
		querySelect.setInt(2, clasifEnt.getOID());
		querySelect.setInt(3, valClasifEnt.getOID());

		return querySelect;
	}

	private PreparedStatement selectByAcuerdoLP(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cpPrecPorClasifArt ");
		textSQL.append(" WHERE oid_acuerdo_lp = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		AcuerdoLP acuerdoLP = (AcuerdoLP) aCondiciones;
		querySelect.setInt(1, acuerdoLP.getOID());
		return querySelect;
	}

	private PreparedStatement selectByProductoProveedorActivo(Object aCondiciones) throws BaseException, SQLException {

		ProductoProveedor productoProveedor = (ProductoProveedor) aCondiciones;
		StringBuffer textSQL = new StringBuffer();
		textSQL.append(" SELECT * FROM  cpPrecPorClasifArt WHERE oid_prod_prov=? and activo=1 ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		querySelect.setInt(1, productoProveedor.getOID());
		return querySelect;

	}

	private PreparedStatement selectByPreciosVigentesAFecha(Object aCondiciones) throws BaseException, SQLException {

		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		AcuerdoLP acuerdo = (AcuerdoLP) condiciones.get(AcuerdoLP.NICKNAME);
		java.util.Date fecha = (java.util.Date) condiciones.get("FECHA");
		String descripcion = (String) condiciones.get("DESCRIPCION");
		String codigo = (String) condiciones.get("CODIGO");

		StringBuffer textSQL = new StringBuffer();
		textSQL.append(" SELECT a.* FROM  cpPrecPorClasifArt a ");
		textSQL.append(" WHERE a.oid_acuerdo_lp = ? and a.fec_vigencia<=? and a.activo=1");
		textSQL.append(" and a.fec_vigencia = ");
		textSQL.append(" (select max(b.fec_vigencia) from cpPrecPorClasifArt b ");
		textSQL.append(" where b.oid_acuerdo_lp = ? and b.fec_vigencia<=? and b.activo=1 ");
		textSQL.append(" and a.oid_clasificador = b.oid_clasificador and a.oid_val_clasif_art = b.oid_val_clasif_art ) ");

		if (condiciones.get(ValorClasifEntProdGen.NICKNAME) != null) {
			ValorClasifEntProdGen clasifEntProdGral = (ValorClasifEntProdGen) condiciones.get(ValorClasifEntProdGen.NICKNAME);
			textSQL.append(" and oid_val_clasif_art = " + clasifEntProdGral.getOIDInteger().toString() + " ");
		}

		if (descripcion != null) {
			textSQL.append(" and oid_val_clasif_art in (");
			textSQL.append("    select oid_val_clasif_ent from geValClasifEnt h where 1=1 and oid_clasif_ent = "
					+ Producto.getClasifProductoGeneral(this.getSesion()).getOIDInteger());
			StringTokenizer st = new StringTokenizer(descripcion, " ");
			while (st.hasMoreTokens()) {
				String next = st.nextToken().toUpperCase();
				textSQL.append(" and h.descripcion like '%" + next + "%' ");
			}
			textSQL.append(") ");
		}

		if (codigo != null) {
			textSQL.append(" and oid_val_clasif_art in (");
			textSQL.append("    select oid_val_clasif_ent from geValClasifEnt i where 1=1 and oid_clasif_ent = "
					+ Producto.getClasifProductoGeneral(this.getSesion()).getOIDInteger());
			StringTokenizer st = new StringTokenizer(codigo, " ");
			while (st.hasMoreTokens()) {
				String next = st.nextToken().toUpperCase();
				textSQL.append(" and i.codigo like '%" + next + "%' ");
			}
			textSQL.append(") ");
		}

		if (condiciones.containsKey("LISTA_VAL_CLASIF")) {

			textSQL.append(" and oid_val_clasif_art in (");
			textSQL.append(" select j.oid_val_clasif_ent from stExtensionPG j where 1=1  ");

			HashTableDatos listaValClasif = (HashTableDatos) condiciones.get("LISTA_VAL_CLASIF");
			Iterator iterValoresClasif = listaValClasif.keySet().iterator();
			while (iterValoresClasif.hasNext()) {
				ClasificadorEntidad clasifEnt = (ClasificadorEntidad) iterValoresClasif.next();
				IValorClasificadorEntidad valor = (IValorClasificadorEntidad) listaValClasif.get(clasifEnt);
				textSQL.append(" and j." + clasifEnt.getCampoFisico() + "=" + valor.getOID());
			}

			textSQL.append(" ) ");

		}

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		querySelect.setInt(1, acuerdo.getOID());
		querySelect.setDate(2, new java.sql.Date(fecha.getTime()));
		querySelect.setInt(3, acuerdo.getOID());
		querySelect.setDate(4, new java.sql.Date(fecha.getTime()));

		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cpPrecPorClasifArt ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_precio_clasif oid, codigo,  descripcion ,activo ");
		textSQL.append(" from cpPrecPorClasifArt");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static List getPreciosClasifArt(AcuerdoLP acuerdoLP, ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(PrecioCompraPorClasifArt.NICKNAME, DBPrecioCompraPorClasifArt.SELECT_BY_ACUERDO_LP,
				acuerdoLP, new ListObserver(), aSesion);
	}

	public static PrecioCompraPorClasifArt getPreciosClasifArtVigentesAFecha(AcuerdoLP acuerdoLP,
			ValorClasifEntProdGen valorClasifEntProdGen, ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(AcuerdoLP.NICKNAME, acuerdoLP);
		condiciones.put("FECHA", Fecha.getFechaActual());
		condiciones.put(ValorClasifEntProdGen.NICKNAME, valorClasifEntProdGen);

		List lista = (List) ObjetoLogico.getObjects(PrecioCompraPorClasifArt.NICKNAME,
				DBPrecioCompraPorClasifArt.SELECT_BY_PRECIO_VIG_A_FECHA_DE_PRODGRAL, condiciones, new ListObserver(), aSesion);

		if (lista.size() > 0)
			return (PrecioCompraPorClasifArt) lista.get(0);
		else
			return null;
	}

	public static List getPreciosClasifArtVigentesAFecha(AcuerdoLP acuerdoLP, java.util.Date fecha, String descripcion, String codigo,
			ValorClasifEntProdGen valorClasifEntProdGen, HashTableDatos listaValoresClasif, ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(AcuerdoLP.NICKNAME, acuerdoLP);
		condiciones.put("FECHA", fecha);
		if (descripcion != null)
			condiciones.put("DESCRIPCION", descripcion);
		if (codigo != null)
			condiciones.put("CODIGO", codigo);
		if (valorClasifEntProdGen != null)
			condiciones.put(ValorClasifEntProdGen.NICKNAME, valorClasifEntProdGen);

		if (listaValoresClasif != null) {
			if (listaValoresClasif.size() > 0)
				condiciones.put("LISTA_VAL_CLASIF", listaValoresClasif);
		}
		return (List) ObjetoLogico.getObjects(PrecioCompraPorClasifArt.NICKNAME, DBPrecioCompraPorClasifArt.SELECT_BY_PRECIO_VIG_A_FECHA,
				condiciones, new ListObserver(), aSesion);
	}

	public static List getPrecioCompraPorClasifArt(Integer oidAcuerdo, ClasificadorEntidad clasifEnt,
			ValorClasificadorEntidad valClasifEnt, ISesion aSesion) throws BaseException {

		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put("oid_acuerdo_lp", oidAcuerdo);
		condiciones.put(ClasificadorEntidad.NICKNAME, clasifEnt);
		condiciones.put(ValorClasificadorEntidad.NICKNAME, valClasifEnt);

		return (List) ObjetoLogico.getObjects(PrecioCompraPorClasifArt.NICKNAME,
				DBPrecioCompraPorClasifArt.SELECT_BY_ACUERDO_CLASIF_VAL_CLASIF, condiciones, new ListObserver(), aSesion);
	}

	public static PrecioCompraPorClasifArt getPrecioCompraVigenteAFecha(Integer oidAcuerdo, ValorClasificadorEntidad valClasifEnt,
			java.util.Date fecha, ISesion aSesion) throws BaseException {

		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put("oid_acuerdo_lp", oidAcuerdo);
		condiciones.put(ClasificadorEntidad.NICKNAME, valClasifEnt.getClasificador_entidad());
		condiciones.put(ValorClasificadorEntidad.NICKNAME, valClasifEnt);
		condiciones.put("FECHA", fecha);

		PrecioCompraPorClasifArt precioCompra = null;

		List preciosCompra = (List) ObjetoLogico.getObjects(PrecioCompraPorClasifArt.NICKNAME,
				DBPrecioCompraPorClasifArt.SELECT_BY_ACUERDO_PROD_PRECIO_VIG, condiciones, new ListObserver(), aSesion);

		if (preciosCompra.size() > 0)
			precioCompra = (PrecioCompraPorClasifArt) preciosCompra.get(0);

		return precioCompra;

	}

	public static List getProximoPrecioCompraPostAFecha(Integer oidAcuerdo, ValorClasificadorEntidad valClasifEnt, java.util.Date fecha,
			ISesion aSesion) throws BaseException {

		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put("oid_acuerdo_lp", oidAcuerdo);
		condiciones.put(ClasificadorEntidad.NICKNAME, valClasifEnt.getClasificador_entidad());
		condiciones.put(ValorClasificadorEntidad.NICKNAME, valClasifEnt);
		condiciones.put("FECHA", fecha);

		return (List) ObjetoLogico.getObjects(PrecioCompraPorClasifArt.NICKNAME,
				DBPrecioCompraPorClasifArt.SELECT_BY_PROX_PRECIO_COMPRA_A_FEC, condiciones, new ListObserver(), aSesion);
	}

	public static PrecioCompraPorClasifArt getPrecioCompraAFecha(Integer oidAcuerdo, ValorClasificadorEntidad valClasifEnt,
			java.util.Date fecha, ISesion aSesion) throws BaseException {

		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put("oid_acuerdo_lp", oidAcuerdo);
		condiciones.put(ClasificadorEntidad.NICKNAME, valClasifEnt.getClasificador_entidad());
		condiciones.put(ValorClasificadorEntidad.NICKNAME, valClasifEnt);
		condiciones.put("FECHA", fecha);

		return (PrecioCompraPorClasifArt) ObjetoLogico.getObjects(PrecioCompraPorClasifArt.NICKNAME,
				DBPrecioCompraPorClasifArt.SELECT_BY_ACUERDO_PROD_FECHA, condiciones, new ObjetoObservado(), aSesion);
	}

	public static PrecioCompraPorClasifArt getPrecioCompraVigAFecha(ValorClasificadorEntidad valClasifEnt, Proveedor proveedor,
			java.util.Date fecha, String tipoAcuerdo, ISesion aSesion) throws BaseException {

		HashTableDatos condiciones = new HashTableDatos();
		if (tipoAcuerdo!=null)
			condiciones.put("TIPO_ACUERDO", tipoAcuerdo);
		condiciones.put(ValorClasificadorEntidad.NICKNAME, valClasifEnt);
		if (proveedor != null)
			condiciones.put(Proveedor.NICKNAME, proveedor);
		condiciones.put("FEC_VIGENCIA", fecha);

		return (PrecioCompraPorClasifArt) ObjetoLogico.getObjects(PrecioCompraPorClasifArt.NICKNAME,
				DBPrecioCompraPorClasifArt.SELECT_BY_PRECIO_VIG_LP, condiciones, new ObjetoObservado(), aSesion);
	}

	public static List getPreciosDeCompraByValClasif(ValorClasificadorEntidad valClasifEnt, ISesion aSesion) throws BaseException {

		return (List) ObjetoLogico.getObjects(PrecioCompraPorClasifArt.NICKNAME, DBPrecioCompraPorClasifArt.SELECT_BY_VAL_CLASIF_ACT,
				valClasifEnt, new ListObserver(), aSesion);
	}

	public static List getUltimosPreciosDeCompraByValClasif(ValorClasificadorEntidad valClasifEnt, ISesion aSesion) throws BaseException {

		return (List) ObjetoLogico.getObjects(PrecioCompraPorClasifArt.NICKNAME, DBPrecioCompraPorClasifArt.SELECT_BY_ULT_PROD_VIG_ACT,
				valClasifEnt, new ListObserver(), aSesion);
	}

	public static PrecioCompraPorClasifArt getPrecioCompraPorClasifArt(ProductoProveedor productoProveedor, ISesion aSesion)
			throws BaseException {
		return (PrecioCompraPorClasifArt) ObjetoLogico.getObjects(
				PrecioCompraPorClasifArt.NICKNAME, 
				DBPrecioCompraPorClasifArt.SELECT_BY_PROD_PROV_ACTIVO,
				productoProveedor, 
				new ObjetoObservado(), 
				aSesion);
	}
	
	public static List getAllActivos(ISesion aSesion) throws BaseException {

		return (List) ObjetoLogico.getObjects(PrecioCompraPorClasifArt.NICKNAME, DBPrecioCompraPorClasifArt.SELECT_BY_ALL_ACTIVOS,
				null, new ListObserver(), aSesion);
	}
	

}
