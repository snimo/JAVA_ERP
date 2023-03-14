package com.srn.erp.ctasAPagar.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.ctasAPagar.bm.ComproProvVtoFijo;
import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.general.bm.PeriodoInc;
import com.srn.erp.general.bm.PeriodoIncDet;
import com.srn.erp.general.da.DBPeriodoIncDet;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBComproProvVtoFijo extends DBObjetoPersistente {

	public static final String	OID_CCO_VTOF_FIJO			= "oid_cco_vto_fijo";

	public static final String	OID_CCO								= "oid_cco";

	public static final String	FECHA									= "fecha";

	public static final String	PORC									= "porc";

	public static final String	ACTIVO								= "activo";

	public static final int			SELECT_BY_COMPRO_PROV	= 100;

	public DBComproProvVtoFijo() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_CCO_VTOF_FIJO = 1;
		final int OID_CCO = 2;
		final int FECHA = 3;
		final int PORC = 4;
		final int ACTIVO = 5;

		ComproProvVtoFijo pers = (ComproProvVtoFijo) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into cpComproProvVtoF " + " ( " + "OID_CCO_VTO_FIJO," + "OID_CCO," + "FECHA," + "PORC,"
				+ "ACTIVO)" + " values " + "(" + "?," + "?," + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_CCO_VTOF_FIJO, pers.getOID());
		qInsert.setInt(OID_CCO, pers.getComprobante().getOID());
		qInsert.setDate(FECHA, new java.sql.Date(pers.getFecha().getTime()));
		qInsert.setDouble(PORC, pers.getPorcentaje().doubleValue());
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_CCO = 1;
		final int FECHA = 2;
		final int PORC = 3;
		final int ACTIVO = 4;
		final int OID_CCO_VTOF_FIJO = 5;

		ComproProvVtoFijo pers = (ComproProvVtoFijo) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update cpComproProvVtoF set " + "oid_cco=?" + ",fecha=?" + ",porc=?" + ",activo=?" + " where "
				+ " oid_cco_vto_fijo=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_CCO_VTOF_FIJO, pers.getOID());
		qUpdate.setInt(OID_CCO, pers.getComprobante().getOID());
		qUpdate.setDate(FECHA, new java.sql.Date(pers.getFecha().getTime()));
		qUpdate.setDouble(PORC, pers.getPorcentaje().doubleValue());
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_CCO_VTOF_FIJO = 1;
		ComproProvVtoFijo pers = (ComproProvVtoFijo) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cpComproProvVtoF " + " set activo=0 " + " where " + " oid_cco_vto_fijo=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_CCO_VTOF_FIJO, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_CCO_VTOF_FIJO = 1;
		ComproProvVtoFijo pers = (ComproProvVtoFijo) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cpComproProvVtoF " + " set activo=1 " + " where " + " oid_cco_vto_fijo=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_CCO_VTOF_FIJO, pers.getOID());
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
		case SELECT_BY_COMPRO_PROV: {
			ps = this.selectByComproProv(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByComproProv(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cpComproProvVtoF ");
		textSQL.append(" WHERE oid_cco = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		ComproCab comproCab = ((ComproCab) aCondiciones);
		querySelect.setInt(1, comproCab.getOID());
		return querySelect;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_CCO_VTOF_FIJO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cpComproProvVtoF ");
		textSQL.append(" WHERE oid_cco_vto_fijo = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_CCO_VTOF_FIJO, oid);
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cpComproProvVtoF ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_cco_vto_fijo oid, codigo,  descripcion ,activo ");
		textSQL.append(" from cpComproProvVtoF");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static List getVtosFijos(ComproCab comproCab, ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(ComproProvVtoFijo.NICKNAME, DBComproProvVtoFijo.SELECT_BY_COMPRO_PROV,
				comproCab, new ListObserver(), aSesion);
	}

}
