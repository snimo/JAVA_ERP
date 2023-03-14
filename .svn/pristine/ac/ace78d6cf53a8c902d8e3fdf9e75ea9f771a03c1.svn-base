package com.srn.erp.ventas.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.ventas.bm.CondicionPago;
import com.srn.erp.ventas.bm.ListaPrecioCondPago;
import com.srn.erp.ventas.bm.ListaPrecios;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBListaPrecioCondPago extends DBObjetoPersistente {

	public static final String	OID_LP_CP								= "oid_lp_cp";

	public static final String	OID_COND_PAGO						= "oid_cond_pago";

	public static final String	OID_PRECIO_CAB					= "oid_precio_cab";

	public static final int			SELECT_BY_COND_PAGO	= 100;

	public DBListaPrecioCondPago() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_LP_CP = 1;
		final int OID_COND_PAGO = 2;
		final int OID_PRECIO_CAB = 3;

		ListaPrecioCondPago pers = (ListaPrecioCondPago) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into veListaPrecioCP " + " ( " + "OID_LP_CP," + "OID_COND_PAGO," + "OID_PRECIO_CAB)"
				+ " values " + "(" + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_LP_CP, pers.getOID());
		qInsert.setInt(OID_COND_PAGO, pers.getCondicionpago().getOID());
		qInsert.setInt(OID_PRECIO_CAB, pers.getListaprecio().getOID());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_COND_PAGO = 1;
		final int OID_PRECIO_CAB = 2;
		final int OID_LP_CP = 3;

		ListaPrecioCondPago pers = (ListaPrecioCondPago) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update veListaPrecioCP set " + "oid_cond_pago=?" + ",oid_precio_cab=?" + " where "
				+ " oid_lp_cp=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_LP_CP, pers.getOID());
		qUpdate.setInt(OID_COND_PAGO, pers.getCondicionpago().getOID());
		qUpdate.setInt(OID_PRECIO_CAB, pers.getListaprecio().getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_LP_CP = 1;
		ListaPrecioCondPago pers = (ListaPrecioCondPago) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("delete from veListaPrecioCP " + "where " + " oid_lp_cp=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_LP_CP, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_LP_CP = 1;
		ListaPrecioCondPago pers = (ListaPrecioCondPago) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update veListaPrecioCP " + " set activo=1 " + " where " + " oid_lp_cp=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_LP_CP, pers.getOID());
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
		case SELECT_BY_COND_PAGO: {
			ps = this.selectByCondPago(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_LP_CP = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  veListaPrecioCP ");
		textSQL.append(" WHERE oid_lp_cp = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_LP_CP, oid);
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  veListaPrecioCP ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectByCondPago(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  veListaPrecioCP ");
		textSQL.append(" WHERE oid_cond_pago = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		CondicionPago condPago = (CondicionPago) aCondiciones;
		querySelect.setInt(1, condPago.getOID());
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_lp_cp oid, codigo,  descripcion ,activo ");
		textSQL.append(" from veListaPrecioCP ");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static List getDetallesListaPreciosCondPago(CondicionPago condPago, ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(ListaPrecioCondPago.NICKNAME, DBListaPrecioCondPago.SELECT_BY_COND_PAGO,
				condPago, new ListObserver(), aSesion);
	}

}
