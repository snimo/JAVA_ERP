package com.srn.erp.pagos.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.compras.da.DBProveedor;
import com.srn.erp.pagos.bm.RendicionFondoFijo;
import com.srn.erp.ventas.bm.Sujeto;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;

public class DBRendicionFondoFijo extends DBObjetoPersistente {

	public static final String	OID_REND_FONDO	= "oid_rend_fondo";

	public static final String	OID_MONEDA			= "oid_moneda";

	public static final String	COTIZACION			= "cotizacion";

	public static final int			SELECT_BY_HELP	= 100;

	public DBRendicionFondoFijo() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_REND_FONDO = 1;
		final int OID_MONEDA = 2;
		final int COTIZACION = 3;

		RendicionFondoFijo pers = (RendicionFondoFijo) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into opRendFondoFijo " + " ( " + "OID_REND_FONDO," + "OID_MONEDA,COTIZACION)"
				+ " values " + "(" + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_REND_FONDO, pers.getOID());
		qInsert.setInt(OID_MONEDA, pers.getMoneda().getOID());
		qInsert.setDouble(COTIZACION, pers.getCotizacion().doubleValue());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_MONEDA = 1;
		final int COTIZACION = 2;
		final int OID_REND_FONDO = 3;

		RendicionFondoFijo pers = (RendicionFondoFijo) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update opRendFondoFijo set " + "oid_moneda=?,cotizacion=?" + " where " + " oid_rend_fondo=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_REND_FONDO, pers.getOID());
		qUpdate.setDouble(COTIZACION, pers.getCotizacion().doubleValue());
		qUpdate.setInt(OID_MONEDA, pers.getMoneda().getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_REND_FONDO = 1;
		RendicionFondoFijo pers = (RendicionFondoFijo) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update geComproCab " + " set activo=0 " + " where " + " oid_cco=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_REND_FONDO, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_REND_FONDO = 1;
		RendicionFondoFijo pers = (RendicionFondoFijo) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update opRendFondoFijo " + " set activo=1 " + " where " + " oid_rend_fondo=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_REND_FONDO, pers.getOID());
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
		case SELECT_BY_HELP: {
			ps = this.selectByHelp(aCondiciones);
			break;
		}

		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_REND_FONDO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT a.*,b.* FROM  opRendFondoFijo a, geComproCab b ");
		textSQL.append(" WHERE a.oid_rend_fondo = b.oid_cco and a.oid_rend_fondo = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_REND_FONDO, oid);
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  opRendFondoFijo ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_rend_fondo oid, codigo,  descripcion ,activo ");
		textSQL.append(" from opRendFondoFijo");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	private PreparedStatement selectByHelp(Object aCondiciones) throws BaseException, SQLException {

		int nroParam = 0;

		HashTableDatos condiciones = (HashTableDatos) aCondiciones;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT a.*,b.* FROM  opRendFondoFijo a, geComproCab b  ");

		if (condiciones.containsKey(Proveedor.NICKNAME))
			textSQL.append(" , opRendFFCompro c ");

		textSQL.append(" WHERE  a.oid_rend_fondo = b.oid_cco ");

		if (condiciones.containsKey(Proveedor.NICKNAME)) {
			textSQL.append(" and a.oid_rend_fondo = c.oid_rend_fonfo ");
			Proveedor proveedor = (Proveedor) condiciones.get(Proveedor.NICKNAME);
			textSQL.append(" and c.oid_cco_prov = " + proveedor.getOIDInteger().toString());
		}

		if (condiciones.containsKey("NRO_EXT_DESDE"))
			textSQL.append(" and b.nro_ext >= " + condiciones.getInteger("NRO_EXT_DESDE").toString());

		if (condiciones.containsKey("NRO_EXT_HASTA"))
			textSQL.append(" and b.nro_ext <= " + condiciones.getInteger("NRO_EXT_HASTA").toString());

		if (condiciones.containsKey("FEC_DESDE"))
			textSQL.append(" and b.emision >= ? ");

		if (condiciones.containsKey("FEC_HASTA"))
			textSQL.append(" and b.emision <= ? ");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());

		if (condiciones.containsKey("FEC_DESDE")) {
			java.util.Date fecDesde = (java.util.Date) condiciones.get("FEC_DESDE");
			++nroParam;
			querySelect.setDate(nroParam, new java.sql.Date(fecDesde.getTime()));
		}
		if (condiciones.containsKey("FEC_HASTA")) {
			java.util.Date fecHasta = (java.util.Date) condiciones.get("FEC_HASTA");
			++nroParam;
			querySelect.setDate(nroParam, new java.sql.Date(fecHasta.getTime()));
		}

		return querySelect;
	}

	public static List getHelpRendicionFF(
			Integer nroExtDesde, 
			Integer nroExtHasta, 
			Proveedor proveedor, 
			Date fechaDesde,
			Date fechaHasta, 
			ISesion aSesion) throws BaseException {

		HashTableDatos condiciones = new HashTableDatos();
		if (nroExtDesde != null)
			condiciones.put("NRO_EXT_DESDE", nroExtDesde.toString());
		if (nroExtHasta != null)
			condiciones.put("NRO_EXT_HASTA", nroExtHasta.toString());
		if (fechaDesde != null)
			condiciones.put("FEC_DESDE", fechaDesde);
		if (fechaHasta != null)
			condiciones.put("FEC_HASTA", fechaHasta);
		if (proveedor != null)
			condiciones.put(Sujeto.NICKNAME, proveedor);

		return (List) ObjetoLogico.getObjects(RendicionFondoFijo.NICKNAME, 
				                                  DBRendicionFondoFijo.SELECT_BY_HELP, 
				                                  condiciones, new ListObserver(),
				aSesion);
	}

}
