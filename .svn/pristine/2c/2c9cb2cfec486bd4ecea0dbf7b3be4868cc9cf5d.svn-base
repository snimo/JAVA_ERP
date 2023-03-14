package com.srn.erp.impuestos.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.impuestos.bm.ListadoIVACab;
import com.srn.erp.impuestos.bm.ListadoIVAConcImpu;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBListadoIVAConcImpu extends DBObjetoPersistente {

	public static final String OID_IMPU_IVA = "oid_impu_iva";

	public static final String OID_LISTADO_IVA = "oid_listado_iva";

	public static final String OID_CONC_IMPU = "oid_conc_impu";

	public static final String IMPORTE = "importe";

	public static final int SELECT_BY_LISTADO_IVA = 100;

	public DBListadoIVAConcImpu() {
	}

	protected void insert(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {

		final int OID_IMPU_IVA = 1;
		final int OID_LISTADO_IVA = 2;
		final int OID_CONC_IMPU = 3;
		final int IMPORTE = 4;

		ListadoIVAConcImpu pers = (ListadoIVAConcImpu) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into imListadoIVAImpu " + " ( "
				+ "OID_IMPU_IVA," + "OID_LISTADO_IVA," + "OID_CONC_IMPU,"
				+ "IMPORTE)" + " values " + "(" + "?," + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD()
				.prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_IMPU_IVA, pers.getOID());
		qInsert.setInt(OID_LISTADO_IVA, pers.getListado_iva().getOID());
		qInsert.setInt(OID_CONC_IMPU, pers.getConcepto_impuesto().getOID());
		qInsert.setDouble(IMPORTE, pers.getImporte().doubleValue());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {

		final int OID_LISTADO_IVA = 1;
		final int OID_CONC_IMPU = 2;
		final int IMPORTE = 3;
		final int OID_IMPU_IVA = 4;

		ListadoIVAConcImpu pers = (ListadoIVAConcImpu) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update imListadoIVAImpu set " + "oid_listado_iva=?"
				+ ",oid_conc_impu=?" + ",importe=?" + " where "
				+ " oid_impu_iva=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_IMPU_IVA, pers.getOID());
		qUpdate.setInt(OID_LISTADO_IVA, pers.getListado_iva().getOID());
		qUpdate.setInt(OID_CONC_IMPU, pers.getConcepto_impuesto().getOID());
		qUpdate.setDouble(IMPORTE, pers.getImporte().doubleValue());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {
		final int OID_IMPU_IVA = 1;
		ListadoIVAConcImpu pers = (ListadoIVAConcImpu) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update imListadoIVAImpu " + " set activo=0 "
				+ " where " + " oid_impu_iva=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_IMPU_IVA, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {
		final int OID_IMPU_IVA = 1;
		ListadoIVAConcImpu pers = (ListadoIVAConcImpu) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update imListadoIVAImpu " + " set activo=1 "
				+ " where " + " oid_impu_iva=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_IMPU_IVA, pers.getOID());
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
		case SELECT_BY_LISTADO_IVA: {
			ps = this.selectByListadoIVA(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones)
			throws BaseException, SQLException {

		final int OID_IMPU_IVA = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  imListadoIVAImpu ");
		textSQL.append(" WHERE oid_impu_iva = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_IMPU_IVA, oid);
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones)
			throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  imListadoIVAImpu ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectByListadoIVA(Object aCondiciones)
			throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT * ");
		textSQL.append(" from imListadoIVAImpu where oid_listado_iva = ? ");

		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		ListadoIVACab listadoIVACab = (ListadoIVACab) aCondiciones;
		querySelect.setInt(1, listadoIVACab.getOID());
		return querySelect;

	}

	private PreparedStatement selectAllHelp(Object aCondiciones)
			throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL
				.append("SELECT oid_impu_iva oid, codigo,  descripcion ,activo ");
		textSQL.append(" from imListadoIVAImpu");

		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static List getConcImpuestos(ListadoIVACab listadoIVACab,
			ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(ListadoIVAConcImpu.NICKNAME,
				DBListadoIVAConcImpu.SELECT_BY_LISTADO_IVA, listadoIVACab,
				new ListObserver(), aSesion);
	}

}
