package com.srn.erp.ventas.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.stock.bm.Producto;
import com.srn.erp.ventas.bm.DevolucionVtasCab;
import com.srn.erp.ventas.bm.FacturaCab;
import com.srn.erp.ventas.bm.PedidoCab;
import com.srn.erp.ventas.bm.RemitoCab;
import com.srn.erp.ventas.bm.Sujeto;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;

public class DBDevolucionVtasCab extends DBObjetoPersistente {

	public static final String OID_DEV_CAB = "oid_dev_cab";
	public static final String OID_SUJETO = "oid_sujeto";
	public static final String TIPO_DEVOLUCION = "tipo_devolucion";
	public static final String OID_CCO_FACT = "oid_cco_fact";
	public static final String OID_CCO_PED = "oid_cco_ped";
	public static final String OID_CCO_RTO = "oid_cco_rto";
	public static final String TIPO_OPER = "tipo_oper";

	private static final int SELECT_BY_CLIE_FEC_NRO = 100;

	public DBDevolucionVtasCab() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_DEV_CAB = 1;
		final int OID_SUJETO = 2;
		final int TIPO_DEVOLUCION = 3;
		final int OID_CCO_FACT = 4;
		final int OID_CCO_PED = 5;
		final int OID_CCO_RTO = 6;
		final int TIPO_OPER = 7;

		DevolucionVtasCab pers = (DevolucionVtasCab) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into veDevolucionCab " + " ( " + "OID_DEV_CAB,"
				+ "OID_SUJETO,TIPO_DEVOLUCION,OID_CCO_FACT,OID_CCO_PED,OID_CCO_RTO,TIPO_OPER)" + " values " + "(" + "?," + "?," + "?,"
				+ "?," + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_DEV_CAB, pers.getOID());
		if (pers.getSujeto() != null)
			qInsert.setInt(OID_SUJETO, pers.getSujeto().getOID());
		else
			qInsert.setNull(OID_SUJETO, java.sql.Types.INTEGER);
		qInsert.setString(TIPO_DEVOLUCION, pers.getTipoDevolucion());

		if (pers.getFacturaCab() != null)
			qInsert.setInt(OID_CCO_FACT, pers.getFacturaCab().getOIDInteger());
		else
			qInsert.setNull(OID_CCO_FACT, java.sql.Types.INTEGER);
		if (pers.getPedidoCab() != null)
			qInsert.setInt(OID_CCO_PED, pers.getPedidoCab().getOIDInteger());
		else
			qInsert.setNull(OID_CCO_PED, java.sql.Types.INTEGER);
		if (pers.getRemitoCab() != null)
			qInsert.setInt(OID_CCO_RTO, pers.getRemitoCab().getOIDInteger());
		else
			qInsert.setNull(OID_CCO_RTO, java.sql.Types.INTEGER);
		if (pers.getTipoOperacion() != null)
			qInsert.setString(TIPO_OPER, pers.getTipoOperacion());
		else
			qInsert.setNull(TIPO_OPER, java.sql.Types.VARCHAR);

		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_SUJETO = 1;
		final int TIPO_DEVOLUCION = 2;
		final int OID_CCO_FACT = 3;
		final int OID_CCO_PED = 4;
		final int OID_CCO_RTO = 5;
		final int TIPO_OPER = 6;
		final int OID_DEV_CAB = 7;

		DevolucionVtasCab pers = (DevolucionVtasCab) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update veDevolucionCab set " + "oid_sujeto=?,"
				+ "tipo_devolucion=?,oid_cco_fact=?,oid_cco_ped=?,oid_cco_rto=? , tipo_oper = ? " + " where " + " oid_dev_cab=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_DEV_CAB, pers.getOID());

		qUpdate.setString(TIPO_DEVOLUCION, pers.getTipoDevolucion());
		if (pers.getSujeto() != null)
			qUpdate.setInt(OID_SUJETO, pers.getSujeto().getOID());
		else
			qUpdate.setNull(OID_SUJETO, java.sql.Types.INTEGER);

		if (pers.getFacturaCab() != null)
			qUpdate.setInt(OID_CCO_FACT, pers.getFacturaCab().getOIDInteger());
		else
			qUpdate.setNull(OID_CCO_FACT, java.sql.Types.INTEGER);
		if (pers.getPedidoCab() != null)
			qUpdate.setInt(OID_CCO_PED, pers.getPedidoCab().getOIDInteger());
		else
			qUpdate.setNull(OID_CCO_PED, java.sql.Types.INTEGER);
		if (pers.getRemitoCab() != null)
			qUpdate.setInt(OID_CCO_RTO, pers.getRemitoCab().getOIDInteger());
		else
			qUpdate.setNull(OID_CCO_RTO, java.sql.Types.INTEGER);
		if (pers.getTipoOperacion() != null)
			qUpdate.setString(TIPO_OPER, pers.getTipoOperacion());
		else
			qUpdate.setNull(TIPO_OPER, java.sql.Types.VARCHAR);

		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_DEV_CAB = 1;
		DevolucionVtasCab pers = (DevolucionVtasCab) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update geComproCab " + " set activo=0 " + " where "
				+ " oid_cco=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_DEV_CAB, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_DEV_CAB = 1;
		DevolucionVtasCab pers = (DevolucionVtasCab) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update veDevolucionCab " + " set activo=1 " + " where " + " oid_dev_cab=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_DEV_CAB, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	private PreparedStatement selectByClieFecNro(Object aCondiciones) throws BaseException, SQLException {

		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		int nroParam = 0;

		Producto producto = null;
		if (condiciones.containsKey(Producto.NICKNAME))
			producto = (Producto) condiciones.get(Producto.NICKNAME);

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT a.*,b.* FROM  veDevolucionCab a, geComproCab b ");

		if (producto != null)
			textSQL.append(" , veDevolucionDet c ");

		textSQL.append(" WHERE  a.oid_dev_cab = b.oid_cco ");

		if (producto != null)
			textSQL.append(" and a.oid_dev_cab = c.oid_dev_cab and c.oid_producto = " + producto.getOIDInteger() + " ");

		if (condiciones.containsKey(Sujeto.NICKNAME)) {
			Sujeto sujeto = (Sujeto) condiciones.get(Sujeto.NICKNAME);
			textSQL.append(" and a.oid_sujeto = " + sujeto.getOIDInteger().toString());
		}

		if (condiciones.containsKey(FacturaCab.NICKNAME)) {
			FacturaCab factura = (FacturaCab) condiciones.get(FacturaCab.NICKNAME);
			textSQL.append(" and a.oid_cco_fact = " + factura.getOIDInteger().toString());
		}

		if (condiciones.containsKey(RemitoCab.NICKNAME)) {
			RemitoCab remito = (RemitoCab) condiciones.get(RemitoCab.NICKNAME);
			textSQL.append(" and a.oid_cco_rto = " + remito.getOIDInteger().toString());
		}

		if (condiciones.containsKey(PedidoCab.NICKNAME)) {
			PedidoCab pedido = (PedidoCab) condiciones.get(PedidoCab.NICKNAME);
			textSQL.append(" and a.oid_cco_ped = " + pedido.getOIDInteger().toString());
		}

		if (condiciones.containsKey("nro_desde")) {
			Integer nroDesde = (Integer) condiciones.get("nro_desde");
			textSQL.append(" and b.nro_Ext >= " + nroDesde.toString());
		}

		if (condiciones.containsKey("nro_hasta")) {
			Integer nroHasta = (Integer) condiciones.get("nro_hasta");
			textSQL.append(" and b.nro_Ext <= " + nroHasta.toString());
		}

		if (condiciones.containsKey("fec_desde"))
			textSQL.append(" and b.emision >= ? ");

		if (condiciones.containsKey("fec_hasta"))
			textSQL.append(" and b.emision <= ? ");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		if (condiciones.containsKey("fec_desde")) {
			java.util.Date fecDesde = (java.util.Date) condiciones.get("fec_desde");
			++nroParam;
			querySelect.setDate(nroParam, new java.sql.Date(fecDesde.getTime()));
		}
		if (condiciones.containsKey("fec_hasta")) {
			java.util.Date fecHasta = (java.util.Date) condiciones.get("fec_hasta");
			++nroParam;
			querySelect.setDate(nroParam, new java.sql.Date(fecHasta.getTime()));
		}
		return querySelect;
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
		case SELECT_BY_CLIE_FEC_NRO: {
			ps = this.selectByClieFecNro(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_DEV_CAB = 1;

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT a.* , b.* FROM  veDevolucionCab a  , geComproCab b ");
		textSQL.append(" WHERE a.oid_dev_cab = b.oid_cco and a.oid_dev_cab = ? ");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_DEV_CAB, oid);
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  veDevolucionCab ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_dev_cab oid, codigo,  descripcion ,activo ");
		textSQL.append(" from veDevolucionCab");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static List getDevolucionesCab(Integer nroExtDesde, Integer nroExtHasta, java.util.Date fecDesde, java.util.Date fecHasta,
			Sujeto sujeto, Producto producto, FacturaCab factura, PedidoCab pedido, RemitoCab remito, ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		if (nroExtDesde != null)
			condiciones.put("nro_desde", nroExtDesde);
		if (nroExtHasta != null)
			condiciones.put("nro_hasta", nroExtHasta);
		if (fecDesde != null)
			condiciones.put("fec_desde", fecDesde);
		if (fecHasta != null)
			condiciones.put("fec_hasta", fecHasta);
		if (sujeto != null)
			condiciones.put(Sujeto.NICKNAME, sujeto);
		if (producto != null)
			condiciones.put(Producto.NICKNAME, producto);
		if (factura != null)
			condiciones.put(FacturaCab.NICKNAME, factura);
		if (pedido != null)
			condiciones.put(PedidoCab.NICKNAME, pedido);
		if (remito != null)
			condiciones.put(RemitoCab.NICKNAME, remito);

		return (List) ObjetoLogico.getObjects(DevolucionVtasCab.NICKNAME, DBDevolucionVtasCab.SELECT_BY_CLIE_FEC_NRO, condiciones,
				new ListObserver(), aSesion);
	}

}
