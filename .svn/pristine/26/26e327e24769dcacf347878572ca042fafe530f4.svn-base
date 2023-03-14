package com.srn.erp.tesoreria.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.general.bm.PeriodoInc;
import com.srn.erp.general.bm.PeriodoIncDet;
import com.srn.erp.general.bm.UnidadOrganizativa;
import com.srn.erp.general.da.DBPeriodoIncDet;
import com.srn.erp.tesoreria.bm.CuentaSistemaBanco;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBCuentaSistemaBanco extends DBObjetoPersistente {

	public static final String	OID_CTA_HAB_BCO		= "oid_cta_hab_bco";

	public static final String	OID_AI						= "oid_ai";

	public static final String	ACTIVO						= "activo";

	public static final String	UNI_ORG						= "oid_uni_org";

	public static final int			SELECT_BY_UNI_ORG	= 100;

	public DBCuentaSistemaBanco() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_CTA_HAB_BCO = 1;
		final int OID_AI = 2;
		final int ACTIVO = 3;
		final int OID_UNI_ORG = 4;

		CuentaSistemaBanco pers = (CuentaSistemaBanco) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into vaCtasHabBancos " + " ( " + "OID_CTA_HAB_BCO," + "OID_AI," + "ACTIVO,OID_UNI_ORG)"
				+ " values " + "(" + "?," + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_CTA_HAB_BCO, pers.getOID());
		qInsert.setInt(OID_AI, pers.getCuenta().getOID());
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qInsert.setInt(OID_UNI_ORG, pers.getUniOrg().getOID());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_AI = 1;
		final int ACTIVO = 2;
		final int OID_UNI_ORG = 3;
		final int OID_CTA_HAB_BCO = 4;

		CuentaSistemaBanco pers = (CuentaSistemaBanco) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update vaCtasHabBancos set " + "oid_ai=?" + ",activo=?" + ",oid_uni_org=?" + " where "
				+ " oid_cta_hab_bco=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_CTA_HAB_BCO, pers.getOID());
		qUpdate.setInt(OID_AI, pers.getCuenta().getOID());
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qUpdate.setInt(OID_UNI_ORG, pers.getUniOrg().getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_CTA_HAB_BCO = 1;
		CuentaSistemaBanco pers = (CuentaSistemaBanco) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update vaCtasHabBancos " + " set activo=0 " + " where " + " oid_cta_hab_bco=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_CTA_HAB_BCO, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_CTA_HAB_BCO = 1;
		CuentaSistemaBanco pers = (CuentaSistemaBanco) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update vaCtasHabBancos " + " set activo=1 " + " where " + " oid_cta_hab_bco=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_CTA_HAB_BCO, pers.getOID());
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
		case IDBObjetoPersistente.SELECT_ALL: {
			ps = this.selectAll(aCondiciones);
			break;
		}
		case SELECT_BY_UNI_ORG: {
			ps = this.selectByUniOrg(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_CTA_HAB_BCO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  vaCtasHabBancos ");
		textSQL.append(" WHERE oid_cta_hab_bco = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_CTA_HAB_BCO, oid);
		return querySelect;
	}

	private PreparedStatement selectByUniOrg(Object aCondiciones) throws BaseException, SQLException {

		final int OID_UNI_ORG = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  vaCtasHabBancos ");
		textSQL.append(" WHERE oid_uni_org = ? and activo = 1 ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		UnidadOrganizativa uniOrg = (UnidadOrganizativa) aCondiciones;
		querySelect.setInt(OID_UNI_ORG, uniOrg.getOID());
		return querySelect;
	}

	private PreparedStatement selectAll(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  vaCtasHabBancos ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  vaCtasHabBancos ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_cta_hab_bco oid, codigo,  descripcion ,activo ");
		textSQL.append(" from vaCtasHabBancos");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static List getAll(ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(CuentaSistemaBanco.NICKNAME, DBCuentaSistemaBanco.SELECT_ALL, null,
				new ListObserver(), aSesion);
	}
	
  public static List getCuentasByUniOrg(UnidadOrganizativa uniOrg,
      ISesion aSesion) throws BaseException {
  	return (List) ObjetoLogico.getObjects(CuentaSistemaBanco.NICKNAME,
         DBCuentaSistemaBanco.SELECT_BY_UNI_ORG,
         uniOrg,
         new ListObserver(),
         aSesion);
  }

	

}
