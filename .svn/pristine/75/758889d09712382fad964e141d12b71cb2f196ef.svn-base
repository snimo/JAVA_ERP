package com.srn.erp.ventas.da;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import com.srn.erp.ventas.bm.EsquemaBonifProdDet;
import com.srn.erp.ventas.bm.EsquemaBonificacionProducto;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBEsquemaBonifProdDet extends DBObjetoPersistente {

	public static final String OID_ESQ_BON_DET = "oid_esq_bon_det";

	public static final String OID_ESQ_BONIF_PROD = "oid_esq_bonif_prod";

	public static final String FEC_DESDE = "fec_desde";

	public static final String FEC_HASTA = "fec_hasta";

	public static final String PORC_BONIF_1 = "porc_bonif_1";

	public static final String PORC_BONIF_2 = "porc_bonif_2";

	public static final String PORC_BONIF_3 = "porc_bonif_3";

	public static final String PORC_BONIF_4 = "porc_bonif_4";

	public static final String PORC_BONIF_5 = "porc_bonif_5";

	public static final String EN_CASCADA = "en_cascada";

	public static final String ACTIVO = "activo";

	public static final int SELECT_BY_ESQUEMA_BONIF_PRODUCTO = 100;

	public static final int SELECT_BY_ESQ_BONIF_FEC_VIG = 101;

	public DBEsquemaBonifProdDet() {
	}

	protected void insert(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {

		final int OID_ESQ_BON_DET = 1;
		final int OID_ESQ_BONIF_PROD = 2;
		final int FEC_DESDE = 3;
		final int FEC_HASTA = 4;
		final int PORC_BONIF_1 = 5;
		final int PORC_BONIF_2 = 6;
		final int PORC_BONIF_3 = 7;
		final int PORC_BONIF_4 = 8;
		final int PORC_BONIF_5 = 9;
		final int EN_CASCADA = 10;
		final int ACTIVO = 11;

		EsquemaBonifProdDet pers = (EsquemaBonifProdDet) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert
				.append(" insert into veEsqBonifProdDet " + " ( "
						+ "OID_ESQ_BON_DET," + "OID_ESQ_BONIF_PROD,"
						+ "FEC_DESDE," + "FEC_HASTA," + "PORC_BONIF_1,"
						+ "PORC_BONIF_2," + "PORC_BONIF_3," + "PORC_BONIF_4,"
						+ "PORC_BONIF_5," + "EN_CASCADA," + "ACTIVO)"
						+ " values " + "(" + "?," + "?," + "?," + "?," + "?,"
						+ "?," + "?," + "?," + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD()
				.prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_ESQ_BON_DET, pers.getOID());
		qInsert.setInt(OID_ESQ_BONIF_PROD, pers.getEsquema_bonif_producto()
				.getOID());
		qInsert.setDate(FEC_DESDE, new Date(pers.getFec_desde().getTime()));
		qInsert.setDate(FEC_HASTA, new Date(pers.getFec_hasta().getTime()));
		if (pers.getPorc_bonif_1() != null)
			qInsert.setDouble(PORC_BONIF_1, pers.getPorc_bonif_1()
					.doubleValue());
		else
			qInsert.setNull(PORC_BONIF_1, Types.DOUBLE);
		if (pers.getPorc_bonif_2() != null)
			qInsert.setDouble(PORC_BONIF_2, pers.getPorc_bonif_2()
					.doubleValue());
		else
			qInsert.setNull(PORC_BONIF_2, Types.DOUBLE);
		if (pers.getPorc_bonif_3() != null)
			qInsert.setDouble(PORC_BONIF_3, pers.getPorc_bonif_3()
					.doubleValue());
		else
			qInsert.setNull(PORC_BONIF_3, Types.DOUBLE);
		if (pers.getPorc_bonif_4() != null)
			qInsert.setDouble(PORC_BONIF_4, pers.getPorc_bonif_4()
					.doubleValue());
		else
			qInsert.setNull(PORC_BONIF_4, Types.DOUBLE);
		if (pers.getPorc_bonif_5() != null)
			qInsert.setDouble(PORC_BONIF_5, pers.getPorc_bonif_5()
					.doubleValue());
		else
			qInsert.setNull(PORC_BONIF_5, Types.DOUBLE);
		qInsert.setBoolean(EN_CASCADA, pers.isEn_cascada().booleanValue());
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {

		final int OID_ESQ_BONIF_PROD = 1;
		final int FEC_DESDE = 2;
		final int FEC_HASTA = 3;
		final int PORC_BONIF_1 = 4;
		final int PORC_BONIF_2 = 5;
		final int PORC_BONIF_3 = 6;
		final int PORC_BONIF_4 = 7;
		final int PORC_BONIF_5 = 8;
		final int EN_CASCADA = 9;
		final int ACTIVO = 10;
		final int OID_ESQ_BON_DET = 11;

		EsquemaBonifProdDet pers = (EsquemaBonifProdDet) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update veEsqBonifProdDet set "
				+ "oid_esq_bonif_prod=?" + ",fec_desde=?" + ",fec_hasta=?"
				+ ",porc_bonif_1=?" + ",porc_bonif_2=?" + ",porc_bonif_3=?"
				+ ",porc_bonif_4=?" + ",porc_bonif_5=?" + ",en_cascada=?"
				+ ",activo=?" + " where " + " oid_esq_bon_det=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_ESQ_BON_DET, pers.getOID());
		qUpdate.setInt(OID_ESQ_BONIF_PROD, pers.getEsquema_bonif_producto()
				.getOID());
		qUpdate.setDate(FEC_DESDE, new Date(pers.getFec_desde().getTime()));
		if (pers.getPorc_bonif_1() != null)
			qUpdate.setDouble(PORC_BONIF_1, pers.getPorc_bonif_1()
					.doubleValue());
		else
			qUpdate.setNull(PORC_BONIF_1, Types.DOUBLE);
		if (pers.getPorc_bonif_2() != null)
			qUpdate.setDouble(PORC_BONIF_2, pers.getPorc_bonif_2()
					.doubleValue());
		else
			qUpdate.setNull(PORC_BONIF_2, Types.DOUBLE);
		if (pers.getPorc_bonif_3() != null)
			qUpdate.setDouble(PORC_BONIF_3, pers.getPorc_bonif_3()
					.doubleValue());
		else
			qUpdate.setNull(PORC_BONIF_3, Types.DOUBLE);
		if (pers.getPorc_bonif_4() != null)
			qUpdate.setDouble(PORC_BONIF_4, pers.getPorc_bonif_4()
					.doubleValue());
		else
			qUpdate.setNull(PORC_BONIF_4, Types.DOUBLE);
		if (pers.getPorc_bonif_5() != null)
			qUpdate.setDouble(PORC_BONIF_5, pers.getPorc_bonif_5()
					.doubleValue());
		else
			qUpdate.setNull(PORC_BONIF_5, Types.DOUBLE);
		qUpdate.setDate(FEC_HASTA, new Date(pers.getFec_hasta().getTime()));
		qUpdate.setBoolean(EN_CASCADA, pers.isEn_cascada().booleanValue());
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {
		final int OID_ESQ_BON_DET = 1;
		EsquemaBonifProdDet pers = (EsquemaBonifProdDet) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update veEsqBonifProdDet " + " set activo=0 "
				+ " where " + " oid_esq_bon_det=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_ESQ_BON_DET, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {
		final int OID_ESQ_BON_DET = 1;
		EsquemaBonifProdDet pers = (EsquemaBonifProdDet) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update veEsqBonifProdDet " + " set activo=1 "
				+ " where " + " oid_esq_bon_det=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_ESQ_BON_DET, pers.getOID());
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
		case SELECT_BY_ESQUEMA_BONIF_PRODUCTO: {
			ps = this.selectByEsquemaBonifProducto(aCondiciones);
			break;
		}
		case SELECT_BY_ESQ_BONIF_FEC_VIG: {
			ps = this.selectByEsqBonifFecVig(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByEsqBonifFecVig(Object aCondiciones)
			throws BaseException, SQLException {
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		EsquemaBonificacionProducto esqBonifProd = (EsquemaBonificacionProducto) condiciones
				.get(EsquemaBonificacionProducto.NICKNAME);
		java.util.Date fecha = (java.util.Date) condiciones.get("FECHA");
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  veEsqBonifProdDet ");
		textSQL
				.append(" WHERE oid_esq_bonif_prod = ? and fec_desde<=? and fec_hasta>=? and activo=1 ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		querySelect.setInt(1, esqBonifProd.getOID());
		querySelect.setDate(2, new Date(fecha.getTime()));
		querySelect.setDate(3, new Date(fecha.getTime()));
		return querySelect;
	}

	private PreparedStatement selectByOID(Object aCondiciones)
			throws BaseException, SQLException {

		final int OID_ESQ_BON_DET = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  veEsqBonifProdDet ");
		textSQL.append(" WHERE oid_esq_bon_det = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_ESQ_BON_DET, oid);
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones)
			throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  veEsqBonifProdDet ");
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
				.append("SELECT oid_esq_bon_det oid, codigo,  descripcion ,activo ");
		textSQL.append(" from veEsqBonifProdDet");

		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		return querySelect;
	}

	private PreparedStatement selectByEsquemaBonifProducto(Object aCondiciones)
			throws BaseException, SQLException {

		EsquemaBonificacionProducto esquemaBonificacionProducto = (EsquemaBonificacionProducto) aCondiciones;

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT * ");
		textSQL.append(" from veEsqBonifProdDet where oid_esq_bonif_prod = ? ");

		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		querySelect.setInt(1, esquemaBonificacionProducto.getOID());

		return querySelect;
	}

	public static List getEsquemasBonifProdDet(
			EsquemaBonificacionProducto esquemaBonificacionProducto,
			ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(EsquemaBonifProdDet.NICKNAME,
				DBEsquemaBonifProdDet.SELECT_BY_ESQUEMA_BONIF_PRODUCTO,
				esquemaBonificacionProducto, new ListObserver(), aSesion);
	}

	public static EsquemaBonifProdDet getEsquemasBonifProdDet(
			EsquemaBonificacionProducto esquemaBonificacionProducto,
			java.util.Date fecha, ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(EsquemaBonificacionProducto.NICKNAME,
				esquemaBonificacionProducto);
		condiciones.put("FECHA", fecha);
		return (EsquemaBonifProdDet) ObjetoLogico.getObjects(
				EsquemaBonifProdDet.NICKNAME,
				DBEsquemaBonifProdDet.SELECT_BY_ESQ_BONIF_FEC_VIG, condiciones,
				new ObjetoObservado(), aSesion);
	}

}
