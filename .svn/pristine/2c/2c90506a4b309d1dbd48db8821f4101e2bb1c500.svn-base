package com.srn.erp.impuestos.da;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import com.srn.erp.compras.bm.RequisicionCab;
import com.srn.erp.general.bm.Talonario;
import com.srn.erp.impuestos.bm.ListadoIVA;
import com.srn.erp.impuestos.bm.ListadoIVACab;
import com.srn.erp.impuestos.bm.SujetoImpositivo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;

public class DBListadoIVACab extends DBObjetoPersistente {

	public static final String OID_LISTADO_IVA = "oid_listado_iva";
	public static final String OID_CCO = "oid_cco";
	public static final String RAZON_SOCIAL = "razon_social";
	public static final String OID_CAT_IVA = "oid_cat_iva";
	public static final String CUIT = "cuit";
	public static final String NETO_GRAVADO = "neto_gravado";
	public static final String NETO_NO_GRAVADO = "neto_no_gravado";
	public static final String TOTAL = "total";
	public static final String TIPO_LISTADO = "tipo_listado";
	public static final String OID_SUJ_IMP = "oid_suj_imp";

	public static final int SELECT_BY_FECHA_DESDE_HASTA = 100;
	public static final int SELECT_BY_TALONARIO_FECHAS = 101;

	public DBListadoIVACab() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_LISTADO_IVA = 1;
		final int OID_CCO = 2;
		final int RAZON_SOCIAL = 3;
		final int OID_CAT_IVA = 4;
		final int CUIT = 5;
		final int NETO_GRAVADO = 6;
		final int NETO_NO_GRAVADO = 7;
		final int TOTAL = 8;
		final int TIPO_LISTADO = 9;
		final int OID_SUJ_IMP = 10;

		ListadoIVACab pers = (ListadoIVACab) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into imListadoIVACab " + " ( " + "OID_LISTADO_IVA," + "OID_CCO," + "RAZON_SOCIAL," + "OID_CAT_IVA,"
				+ "CUIT," + "NETO_GRAVADO," + "NETO_NO_GRAVADO," + "TOTAL," + "TIPO_LISTADO,OID_SUJ_IMP)" + " values " + "(" + "?," + "?,"
				+ "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_LISTADO_IVA, pers.getOID());
		qInsert.setInt(OID_CCO, pers.getComprobante().getOID());
		qInsert.setString(RAZON_SOCIAL, pers.getRazon_social());
		qInsert.setInt(OID_CAT_IVA, pers.getCategoria_iva().getOID());
		qInsert.setString(CUIT, pers.getCuit());
		if (pers.getNeto_gravado() != null)
			qInsert.setDouble(NETO_GRAVADO, pers.getNeto_gravado().doubleValue());
		else
			qInsert.setNull(NETO_GRAVADO, Types.DOUBLE);
		if (pers.getNeto_no_gravado() != null)
			qInsert.setDouble(NETO_NO_GRAVADO, pers.getNeto_no_gravado().doubleValue());
		else
			qInsert.setNull(NETO_NO_GRAVADO, Types.DOUBLE);
		if (pers.getTotal() != null)
			qInsert.setDouble(TOTAL, pers.getTotal().doubleValue());
		else
			qInsert.setNull(TOTAL, Types.DOUBLE);
		qInsert.setString(TIPO_LISTADO, pers.getTipo_listado());
		qInsert.setInt(OID_SUJ_IMP, pers.getSujetoImpositivo().getOID());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_CCO = 1;
		final int RAZON_SOCIAL = 2;
		final int OID_CAT_IVA = 3;
		final int CUIT = 4;
		final int NETO_GRAVADO = 5;
		final int NETO_NO_GRAVADO = 6;
		final int TOTAL = 7;
		final int TIPO_LISTADO = 8;
		final int OID_SUJ_IMP = 9;
		final int OID_LISTADO_IVA = 10;

		ListadoIVACab pers = (ListadoIVACab) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update imListadoIVACab set " + "oid_cco=?" + ",razon_social=?" + ",oid_cat_iva=?" + ",cuit=?"
				+ ",neto_gravado=?" + ",neto_no_gravado=?" + ",total=?" + ",tipo_listado=?" + ",oid_suj_imp=?" + " where "
				+ " oid_listado_iva=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_LISTADO_IVA, pers.getOID());
		qUpdate.setInt(OID_CCO, pers.getComprobante().getOID());
		qUpdate.setString(RAZON_SOCIAL, pers.getRazon_social());
		qUpdate.setInt(OID_CAT_IVA, pers.getCategoria_iva().getOID());
		qUpdate.setString(CUIT, pers.getCuit());
		qUpdate.setDouble(NETO_GRAVADO, pers.getNeto_gravado().doubleValue());
		qUpdate.setDouble(NETO_NO_GRAVADO, pers.getNeto_no_gravado().doubleValue());
		qUpdate.setDouble(TOTAL, pers.getTotal().doubleValue());
		qUpdate.setString(TIPO_LISTADO, pers.getTipo_listado());
		qUpdate.setInt(OID_SUJ_IMP, pers.getSujetoImpositivo().getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_LISTADO_IVA = 1;
		ListadoIVACab pers = (ListadoIVACab) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update imListadoIVACab " + " set activo=0 " + " where " + " oid_listado_iva=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_LISTADO_IVA, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_LISTADO_IVA = 1;
		ListadoIVACab pers = (ListadoIVACab) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update imListadoIVACab " + " set activo=1 " + " where " + " oid_listado_iva=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_LISTADO_IVA, pers.getOID());
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
		case SELECT_BY_FECHA_DESDE_HASTA: {
			ps = this.selectByFecDesdeHasta(aCondiciones);
			break;
		}
		case SELECT_BY_TALONARIO_FECHAS: {
			ps = this.selectByListadoIVAporTalonarioFechas(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_LISTADO_IVA = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  imListadoIVACab ");
		textSQL.append(" WHERE oid_listado_iva = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_LISTADO_IVA, oid);
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  imListadoIVACab ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_listado_iva oid, codigo,  descripcion ,activo ");
		textSQL.append(" from imListadoIVACab");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	private PreparedStatement selectByFecDesdeHasta(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append(" select ");
		textSQL.append("  a.* ");
		textSQL.append(" from ");
		textSQL.append("  imListadoIVACab a, ");
		textSQL.append("  geComproCab b ");
		textSQL.append(" where ");
		textSQL.append("  a.oid_cco = b.oid_cco and b.imputac>=? and b.imputac<=? and a.tipo_listado = ? ");

		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		java.util.Date fechaDesde = (java.util.Date) condiciones.get("FECHA_DESDE");
		java.util.Date fechaHasta = (java.util.Date) condiciones.get("FECHA_HASTA");
		String tipo = (String) condiciones.get("TIPO");
		if (condiciones.get(SujetoImpositivo.NICKNAME) != null) {
			SujetoImpositivo sujetoImpositivo = (SujetoImpositivo) condiciones.get(SujetoImpositivo.NICKNAME);
			textSQL.append("  and a.oid_suj_imp=" + sujetoImpositivo.getOIDInteger().toString());
		}
		
		textSQL.append("  order by b.imputac, b.oid_talonario, b.nro_ext ");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		querySelect.setDate(1, new Date(fechaDesde.getTime()));
		querySelect.setDate(2, new Date(fechaHasta.getTime()));
		querySelect.setString(3, tipo);
		return querySelect;
	}

	public static List getLibroIVACompras(java.util.Date fechaDesde, java.util.Date fechaHasta, SujetoImpositivo sujetoImpositivo,
			ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put("FECHA_DESDE", fechaDesde);
		condiciones.put("FECHA_HASTA", fechaHasta);
		condiciones.put("TIPO", ListadoIVA.LIBRO_IVA_COMPRAS);
		if (sujetoImpositivo != null)
			condiciones.put(SujetoImpositivo.NICKNAME, sujetoImpositivo);
		return (List) ObjetoLogico.getObjects(ListadoIVACab.NICKNAME, DBListadoIVACab.SELECT_BY_FECHA_DESDE_HASTA, condiciones,
				new ListObserver(), aSesion);
	}

	public static List getLibroIVAVentas(java.util.Date fechaDesde, java.util.Date fechaHasta, SujetoImpositivo sujetoImpositivo,
			ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put("FECHA_DESDE", fechaDesde);
		condiciones.put("FECHA_HASTA", fechaHasta);
		condiciones.put("TIPO", ListadoIVA.LIBRO_IVA_VENTAS);
		if (sujetoImpositivo != null)
			condiciones.put(SujetoImpositivo.NICKNAME, sujetoImpositivo);
		return (List) ObjetoLogico.getObjects(ListadoIVACab.NICKNAME, DBListadoIVACab.SELECT_BY_FECHA_DESDE_HASTA, condiciones,
				new ListObserver(), aSesion);
	}
	
	public static int getMaxNroExtDeTalonarioEnFechas(ISesion aSesion, Talonario talonario, java.util.Date fecDesde, java.util.Date fecHasta)
	throws BaseException {

	try {

		StringBuffer textSQL = new StringBuffer();		
		textSQL.append(" select ");
		textSQL.append(" 	Max(c.nro_ext) nro_ext ");
		textSQL.append(" from ");
		textSQL.append(" 	imListadoIVACab a , ");
		textSQL.append("	veFacturasCab b , ");
		textSQL.append("	geComproCab c ");
		textSQL.append(" where ");
		textSQL.append("	a.oid_cco = b.oid_cco_fact and ");
		textSQL.append("	c.oid_cco = b.oid_cco_fact and ");
		textSQL.append("	a.tipo_listado = 'IVA_VENTAS' and ");
		textSQL.append("	c.oid_talonario = ? and ");
		textSQL.append("    c.imputac>=? and ");
		textSQL.append("    c.imputac<=? ");
		
		PreparedStatement querySelect = aSesion.getConexionBD().prepareStatement(textSQL.toString());
		querySelect.setInt(1, talonario.getOID());
		querySelect.setDate(2, new java.sql.Date(fecDesde.getTime()));
		querySelect.setDate(3, new java.sql.Date(fecHasta.getTime()));		
		
		ResultSet rs = querySelect.executeQuery();
		int nro = 0;
		if (rs.next())
			nro = rs.getInt(1);
		rs.close();
		querySelect.close();

	return nro;
	
	} catch (Exception e) {
		throw new BaseException(null, e.getMessage());
	}
	}
	
	public static int getMinNroExtDeTalonarioEnFechas(ISesion aSesion, Talonario talonario, java.util.Date fecDesde, java.util.Date fecHasta)
	throws BaseException {

	try {

		StringBuffer textSQL = new StringBuffer();		
		textSQL.append(" select ");
		textSQL.append(" 	Min(c.nro_ext) nro_ext ");
		textSQL.append(" from ");
		textSQL.append(" 	imListadoIVACab a , ");
		textSQL.append("	veFacturasCab b , ");
		textSQL.append("	geComproCab c ");
		textSQL.append(" where ");
		textSQL.append("	a.oid_cco = b.oid_cco_fact and ");
		textSQL.append("	c.oid_cco = b.oid_cco_fact and ");
		textSQL.append("	a.tipo_listado = 'IVA_VENTAS' and ");
		textSQL.append("	c.oid_talonario = ? and ");
		textSQL.append("    c.imputac>=? and ");
		textSQL.append("    c.imputac<=? ");
		
		PreparedStatement querySelect = aSesion.getConexionBD().prepareStatement(textSQL.toString());
		querySelect.setInt(1, talonario.getOID());
		querySelect.setDate(2, new java.sql.Date(fecDesde.getTime()));
		querySelect.setDate(3, new java.sql.Date(fecHasta.getTime()));		
		
		ResultSet rs = querySelect.executeQuery();
		int nro = 0;
		if (rs.next())
			nro = rs.getInt(1);
		rs.close();
		querySelect.close();

	return nro;
	
	} catch (Exception e) {
		throw new BaseException(null, e.getMessage());
	}
	}
	
	

	private PreparedStatement selectByListadoIVAporTalonarioFechas(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();
		textSQL.append(" select ");
		textSQL.append(" 	a.* ");
		textSQL.append(" from ");
		textSQL.append(" 	imListadoIVACab a , ");
		textSQL.append("	veFacturasCab b , ");
		textSQL.append("	geComproCab c ");
		textSQL.append(" where ");
		textSQL.append("	a.oid_cco = b.oid_cco_fact and ");
		textSQL.append("	c.oid_cco = b.oid_cco_fact and ");
		textSQL.append("	a.tipo_listado = 'IVA_VENTAS' and ");
		textSQL.append("	c.oid_talonario = ? and ");
		textSQL.append("    c.imputac>=? and ");
		textSQL.append("    c.imputac<=? ");

		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		Talonario talonario = (Talonario) condiciones.get(Talonario.NICKNAME);
		java.util.Date fecDesde = (java.util.Date) condiciones.get("FEC_DESDE");
		java.util.Date fecHasta = (java.util.Date) condiciones.get("FEC_HASTA");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		querySelect.setInt(1, talonario.getOID());
		querySelect.setDate(2, new java.sql.Date(fecDesde.getTime()));
		querySelect.setDate(3, new java.sql.Date(fecHasta.getTime()));
		return querySelect;
	}
	
	public static List getLibroIVAVentasByTalonarioFecDesdeHasta(
			java.util.Date fechaDesde, 
			java.util.Date fechaHasta, 
			Talonario talonario,
			ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put("FEC_DESDE", fechaDesde);
		condiciones.put("FEC_HASTA", fechaHasta);
		condiciones.put(Talonario.NICKNAME, talonario);
		return (List) ObjetoLogico.getObjects(
				ListadoIVACab.NICKNAME, 
				DBListadoIVACab.SELECT_BY_TALONARIO_FECHAS, 
				condiciones,
				new ListObserver(), aSesion);
	}
	

}
