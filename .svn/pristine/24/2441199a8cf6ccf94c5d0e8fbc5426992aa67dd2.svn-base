package com.srn.erp.contabilidad.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.contabilidad.bm.AtributoEntidadSeleccionado;
import com.srn.erp.contabilidad.bm.CriterioSelCuenta;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBAtributoEntidadSeleccionado extends DBObjetoPersistente {

	public static final String OID_ATRI_ENT_SEL = "oid_atri_ent_sel";

	public static final String OID_CRI_SEL_CTA = "oid_cri_sel_cta";

	public static final String OID_ATRI_ENT = "oid_atri_ent";
	
	public static final String ORDEN = "orden";

	public static final int SELECT_BY_CRITERIO_SEL_CTA = 100;
	

	public DBAtributoEntidadSeleccionado() {
	}

	protected void insert(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {

		final int OID_ATRI_ENT_SEL = 1;
		final int OID_CRI_SEL_CTA = 2;
		final int OID_ATRI_ENT = 3;
		final int ORDEN = 4;

		AtributoEntidadSeleccionado pers = (AtributoEntidadSeleccionado) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into cgAtriEntsel " + " ( "
				+ "OID_ATRI_ENT_SEL," + "OID_CRI_SEL_CTA," + "OID_ATRI_ENT , ORDEN)"
				+ " values " + "(" + "?," + "?," + "?,?) ");

		PreparedStatement qInsert = getSesion().getConexionBD()
				.prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_ATRI_ENT_SEL, pers.getOID());
		qInsert.setInt(OID_CRI_SEL_CTA, pers.getCriterio_seleccion_cta()
				.getOID());
		qInsert.setInt(OID_ATRI_ENT, pers.getAtributo_entidad().getOID());
		qInsert.setInt(ORDEN, pers.getOrden().intValue());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {

		final int OID_CRI_SEL_CTA = 1;
		final int OID_ATRI_ENT = 2;
		final int ORDEN = 3;
		final int OID_ATRI_ENT_SEL = 4;

		AtributoEntidadSeleccionado pers = (AtributoEntidadSeleccionado) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update cgAtriEntsel set " + "oid_cri_sel_cta=?"
				+ ",oid_atri_ent=? , orden=? " + " where " + " oid_atri_ent_sel=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_ATRI_ENT_SEL, pers.getOID());
		qUpdate.setInt(OID_CRI_SEL_CTA, pers.getCriterio_seleccion_cta()
				.getOID());
		qUpdate.setInt(OID_ATRI_ENT, pers.getAtributo_entidad().getOID());
		qUpdate.setInt(ORDEN, pers.getOrden().intValue());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {
		final int OID_ATRI_ENT_SEL = 1;
		AtributoEntidadSeleccionado pers = (AtributoEntidadSeleccionado) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("delete from cgAtriEntsel where "
				+ " oid_atri_ent_sel=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_ATRI_ENT_SEL, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {
		final int OID_ATRI_ENT_SEL = 1;
		AtributoEntidadSeleccionado pers = (AtributoEntidadSeleccionado) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cgAtriEntsel " + " set activo=1 " + " where "
				+ " oid_atri_ent_sel=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_ATRI_ENT_SEL, pers.getOID());
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
		case SELECT_BY_CRITERIO_SEL_CTA: {
			ps = this.selectByCriterioSelCta(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones)
			throws BaseException, SQLException {

		final int OID_ATRI_ENT_SEL = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cgAtriEntsel ");
		textSQL.append(" WHERE oid_atri_ent_sel = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_ATRI_ENT_SEL, oid);
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones)
			throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cgAtriEntsel ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectByCriterioSelCta(Object aCondiciones)
			throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cgAtriEntsel ");
		textSQL.append(" WHERE oid_cri_sel_cta = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		CriterioSelCuenta criterioSelCta = (CriterioSelCuenta) aCondiciones;
		querySelect.setInt(1, criterioSelCta.getOID());
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones)
			throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL
				.append("SELECT oid_atri_ent_sel oid, codigo,  descripcion ,activo ");
		textSQL.append(" from cgAtriEntsel");

		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static List getAtributosSeleccionados(
			CriterioSelCuenta criterioSelCuenta, ISesion aSesion)
			throws BaseException {
		return (List) ObjetoLogico.getObjects(
				AtributoEntidadSeleccionado.NICKNAME,
				DBAtributoEntidadSeleccionado.SELECT_BY_CRITERIO_SEL_CTA,
				criterioSelCuenta, new ListObserver(), aSesion);
	}

}
