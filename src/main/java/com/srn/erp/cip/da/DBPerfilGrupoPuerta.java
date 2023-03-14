package com.srn.erp.cip.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.cip.bm.GrupoPuerta;
import com.srn.erp.cip.bm.PerfilGrupoPuerta;
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

public class DBPerfilGrupoPuerta extends DBObjetoPersistente {

	public static final String OID_PER_GRU_PUE = "oid_per_gru_pue";
	public static final String OID_GRUPO_PUERTA = "oid_grupo_puerta";
	public static final String OID_PERFIL_FUNC = "oid_perfil_func";
	public static final String HAB_ING = "hab_ing";
	public static final String HAB_EGR = "hab_egr";
	public static final String HAB_AMBOS = "hab_ambos";
	public static final String DEN_ING = "den_ing";
	public static final String DEN_EGR = "den_egr";
	public static final String DEN_AMBOS = "den_ambos";
	public static final String ACTIVO = "activo";
	
	public static final int SELECT_BY_GRUPO_PUERTA = 100;

	public DBPerfilGrupoPuerta() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_PER_GRU_PUE = 1;
		final int OID_GRUPO_PUERTA = 2;
		final int OID_PERFIL_FUNC = 3;
		final int HAB_ING = 4;
		final int HAB_EGR = 5;
		final int HAB_AMBOS = 6;
		final int DEN_ING = 7;
		final int DEN_EGR = 8;
		final int DEN_AMBOS = 9;
		final int ACTIVO = 10;

		PerfilGrupoPuerta pers = (PerfilGrupoPuerta) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into CIPPerfilGrupoPue " + " ( " + "OID_PER_GRU_PUE," + "OID_GRUPO_PUERTA," + "OID_PERFIL_FUNC," + "HAB_ING," + "HAB_EGR," + "HAB_AMBOS," + "DEN_ING," + "DEN_EGR,"
				+ "DEN_AMBOS," + "ACTIVO)" + " values " + "(" + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_PER_GRU_PUE, pers.getOID());
		qInsert.setInt(OID_GRUPO_PUERTA, pers.getGrupo_puerta().getOID());
		qInsert.setInt(OID_PERFIL_FUNC, pers.getPerfil_funcional().getOID());
		qInsert.setBoolean(HAB_ING, pers.isHab_ing().booleanValue());
		qInsert.setBoolean(HAB_EGR, pers.isHab_egr().booleanValue());
		qInsert.setBoolean(HAB_AMBOS, pers.isHab_ambos().booleanValue());
		qInsert.setBoolean(DEN_ING, pers.isDen_ing().booleanValue());
		qInsert.setBoolean(DEN_EGR, pers.isDen_egr().booleanValue());
		qInsert.setBoolean(DEN_AMBOS, pers.isDen_ambos().booleanValue());
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_GRUPO_PUERTA = 1;
		final int OID_PERFIL_FUNC = 2;
		final int HAB_ING = 3;
		final int HAB_EGR = 4;
		final int HAB_AMBOS = 5;
		final int DEN_ING = 6;
		final int DEN_EGR = 7;
		final int DEN_AMBOS = 8;
		final int ACTIVO = 9;
		final int OID_PER_GRU_PUE = 10;

		PerfilGrupoPuerta pers = (PerfilGrupoPuerta) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update CIPPerfilGrupoPue set " + "oid_grupo_puerta=?" + ",oid_perfil_func=?" + ",hab_ing=?" + ",hab_egr=?" + ",hab_ambos=?" + ",den_ing=?" + ",den_egr=?" + ",den_ambos=?"
				+ ",activo=?" + " where " + " oid_per_gru_pue=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_PER_GRU_PUE, pers.getOID());
		qUpdate.setInt(OID_GRUPO_PUERTA, pers.getGrupo_puerta().getOID());
		qUpdate.setInt(OID_PERFIL_FUNC, pers.getPerfil_funcional().getOID());
		qUpdate.setBoolean(HAB_ING, pers.isHab_ing().booleanValue());
		qUpdate.setBoolean(HAB_EGR, pers.isHab_egr().booleanValue());
		qUpdate.setBoolean(HAB_AMBOS, pers.isHab_ambos().booleanValue());
		qUpdate.setBoolean(DEN_ING, pers.isDen_ing().booleanValue());
		qUpdate.setBoolean(DEN_EGR, pers.isDen_egr().booleanValue());
		qUpdate.setBoolean(DEN_AMBOS, pers.isDen_ambos().booleanValue());
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_PER_GRU_PUE = 1;
		PerfilGrupoPuerta pers = (PerfilGrupoPuerta) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update CIPPerfilGrupoPue " + " set activo=0 " + " where " + " oid_per_gru_pue=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_PER_GRU_PUE, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_PER_GRU_PUE = 1;
		PerfilGrupoPuerta pers = (PerfilGrupoPuerta) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update CIPPerfilGrupoPue " + " set activo=1 " + " where " + " oid_per_gru_pue=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_PER_GRU_PUE, pers.getOID());
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
		case SELECT_BY_GRUPO_PUERTA: {
			ps = this.selecByGrupoPuerta(aCondiciones);
			break;			
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_PER_GRU_PUE = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  CIPPerfilGrupoPue ");
		textSQL.append(" WHERE oid_per_gru_pue = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_PER_GRU_PUE, oid);
		return querySelect;
	}

	
	private PreparedStatement selecByGrupoPuerta(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  CIPPerfilGrupoPue ");
		textSQL.append(" WHERE oid_grupo_puerta = ? and activo = 1 ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		GrupoPuerta grupoPuerta = (GrupoPuerta) aCondiciones;
		querySelect.setInt(1, grupoPuerta.getOID());
		return querySelect;
	}	
	
	
	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  CIPPerfilGrupoPue ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_per_gru_pue oid, codigo,  descripcion ,activo ");
		textSQL.append(" from CIPPerfilGrupoPue");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}
	
	public static List getPerfilGrupoPuerta(
			  GrupoPuerta grupoPuerta,
              ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(PerfilGrupoPuerta.NICKNAME,
                 DBPerfilGrupoPuerta.SELECT_BY_GRUPO_PUERTA,
                 grupoPuerta,
                 new ListObserver(),
                 aSesion);
	}	

}
