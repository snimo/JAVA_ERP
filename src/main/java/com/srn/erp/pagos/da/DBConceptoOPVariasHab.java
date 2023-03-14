package com.srn.erp.pagos.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.general.bm.PeriodoIncDet;
import com.srn.erp.general.bm.UnidadOrganizativa;
import com.srn.erp.general.da.DBPeriodoIncDet;
import com.srn.erp.pagos.bm.ConceptoOPVarias;
import com.srn.erp.pagos.bm.ConceptoOPVariasHab;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBConceptoOPVariasHab extends DBObjetoPersistente {

	public static final String	OID_CONC_PV_HAB						= "oid_conc_pv_hab";

	public static final String	OID_CONC_PV								= "oid_conc_pv";

	public static final String	OID_UNI_ORG								= "oid_uni_org";

	public static final String	ACTIVO										= "activo";

	public static final int			SELECT_BY_CONC_OP_VARIAS	= 100;

	public DBConceptoOPVariasHab() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_CONC_PV_HAB = 1;
		final int OID_CONC_PV = 2;
		final int OID_UNI_ORG = 3;
		final int ACTIVO = 4;

		ConceptoOPVariasHab pers = (ConceptoOPVariasHab) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into opConcPVHab " + " ( " + "OID_CONC_PV_HAB," + "OID_CONC_PV," + "OID_UNI_ORG,"
				+ "ACTIVO)" + " values " + "(" + "?," + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_CONC_PV_HAB, pers.getOID());
		qInsert.setInt(OID_CONC_PV, pers.getConcepto_pv().getOID());
		qInsert.setInt(OID_UNI_ORG, pers.getUnidad_organizativa().getOID());
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_CONC_PV = 1;
		final int OID_UNI_ORG = 2;
		final int ACTIVO = 3;
		final int OID_CONC_PV_HAB = 4;

		ConceptoOPVariasHab pers = (ConceptoOPVariasHab) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update opConcPVHab set " + "oid_conc_pv=?" + ",oid_uni_org=?" + ",activo=?" + " where "
				+ " oid_conc_pv_hab=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_CONC_PV_HAB, pers.getOID());
		qUpdate.setInt(OID_CONC_PV, pers.getConcepto_pv().getOID());
		qUpdate.setInt(OID_UNI_ORG, pers.getUnidad_organizativa().getOID());
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_CONC_PV_HAB = 1;
		ConceptoOPVariasHab pers = (ConceptoOPVariasHab) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("delete from opConcPVHab " +" where " + " oid_conc_pv_hab=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_CONC_PV_HAB, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_CONC_PV_HAB = 1;
		ConceptoOPVariasHab pers = (ConceptoOPVariasHab) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update opConcPVHab " + " set activo=1 " + " where " + " oid_conc_pv_hab=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_CONC_PV_HAB, pers.getOID());
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
		case SELECT_BY_CONC_OP_VARIAS: {
			ps = this.selectByConcOPVarias(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByConcOPVarias(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  opConcPVHab ");
		textSQL.append(" WHERE oid_conc_pv = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		ConceptoOPVarias concepto = ((ConceptoOPVarias) aCondiciones);
		querySelect.setInt(1, concepto.getOID());
		return querySelect;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_CONC_PV_HAB = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  opConcPVHab ");
		textSQL.append(" WHERE oid_conc_pv_hab = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_CONC_PV_HAB, oid);
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  opConcPVHab ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_conc_pv_hab oid, codigo,  descripcion ,activo ");
		textSQL.append(" from opConcPVHab");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static List getUnidadesOrganizativas(ConceptoOPVarias concepto, ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(ConceptoOPVariasHab.NICKNAME, DBConceptoOPVariasHab.SELECT_BY_CONC_OP_VARIAS,
				concepto, new ListObserver(), aSesion);
	}

}
