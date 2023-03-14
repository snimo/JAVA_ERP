package com.srn.erp.contabilidad.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.contabilidad.bm.ConceptoCtaContable;
import com.srn.erp.contabilidad.bm.CriterioSelCuenta;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBCriterioSelCuenta extends DBObjetoPersistente {

	public static final String OID_CRI_SEL_CTA = "oid_cri_sel_cta";

	public static final String OID_CONC_CTA = "oid_conc_cta";

	public static final String ORDEN = "orden";

	public static final String CRITERIO = "criterio";

	public static final String ACTIVO = "activo";

	public static final int SELECT_BY_CONC_CTA = 100;

	public DBCriterioSelCuenta() {
	}

	protected void insert(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {

		final int OID_CRI_SEL_CTA = 1;
		final int OID_CONC_CTA = 2;
		final int ORDEN = 3;
		final int CRITERIO = 4;
		final int ACTIVO = 5;

		CriterioSelCuenta pers = (CriterioSelCuenta) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into cgCriterioSelCta " + " ( "
				+ "OID_CRI_SEL_CTA," + "OID_CONC_CTA," + "ORDEN,"
				+ "CRITERIO," + "ACTIVO)" + " values " + "(" + "?," + "?,"
				+ "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD()
				.prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_CRI_SEL_CTA, pers.getOID());
		qInsert.setInt(OID_CONC_CTA, pers.getConcepto_cuenta().getOID());
		qInsert.setInt(ORDEN, pers.getOrden().intValue());
		qInsert.setString(CRITERIO, pers.getCriterio());
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {

		final int OID_CONC_CTA = 1;
		final int ORDEN = 2;
		final int CRITERIO = 3;
		final int ACTIVO = 4;
		final int OID_CRI_SEL_CTA = 5;

		CriterioSelCuenta pers = (CriterioSelCuenta) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update cgCriterioSelCta set " + "oid_conc_cta=?"
				+ ",orden=?" + ",criterio=?" + ",activo=?" + " where "
				+ " oid_cri_sel_cta=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_CRI_SEL_CTA, pers.getOID());
		qUpdate.setInt(OID_CONC_CTA, pers.getConcepto_cuenta().getOID());
		qUpdate.setInt(ORDEN, pers.getOrden().intValue());
		qUpdate.setString(CRITERIO, pers.getCriterio());
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {
		final int OID_CRI_SEL_CTA = 1;
		CriterioSelCuenta pers = (CriterioSelCuenta) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cgCriterioSelCta " + " set activo=0 "
				+ " where " + " oid_cri_sel_cta=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_CRI_SEL_CTA, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {
		final int OID_CRI_SEL_CTA = 1;
		CriterioSelCuenta pers = (CriterioSelCuenta) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cgCriterioSelCta " + " set activo=1 "
				+ " where " + " oid_cri_sel_cta=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_CRI_SEL_CTA, pers.getOID());
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
		case SELECT_BY_CONC_CTA: {
			ps = this.selectByConcCta(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones)
			throws BaseException, SQLException {

		final int OID_CRI_SEL_CTA = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cgCriterioSelCta ");
		textSQL.append(" WHERE oid_cri_sel_cta = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_CRI_SEL_CTA, oid);
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones)
			throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cgCriterioSelCta ");
		textSQL.append(" WHERE oid_conc_cta = ? ");
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
				.append("SELECT oid_cri_sel_cta oid,oid_conc_cta codigo,  descripcion ,activo ");
		textSQL.append(" from cgCriterioSelCta");

		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		return querySelect;
	}

	private PreparedStatement selectByConcCta(Object aCondiciones)
			throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append(" SELECT * ");
		textSQL.append(" from cgCriterioSelCta where oid_conc_cta = ? order by orden ");

		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		ConceptoCtaContable concCtaContable = (ConceptoCtaContable) aCondiciones;
		querySelect.setInt(1, concCtaContable.getOID());

		return querySelect;
	}

	public static List getCriteriosByConcCta(
			ConceptoCtaContable conceptoCtaContable, ISesion aSesion)
			throws BaseException {
		return (List) ObjetoLogico.getObjects(CriterioSelCuenta.NICKNAME,
				DBCriterioSelCuenta.SELECT_BY_CONC_CTA, conceptoCtaContable,
				new ListObserver(), aSesion);
	}

}
