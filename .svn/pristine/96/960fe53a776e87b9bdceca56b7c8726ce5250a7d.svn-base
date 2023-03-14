package com.srn.erp.rrhh.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.general.bm.Periodo;
import com.srn.erp.general.da.DBPeriodo;
import com.srn.erp.rrhh.bm.ObsLegajo;
import com.srn.erp.rrhh.bm.TipoObsLeg;
import com.srn.erp.sueldos.bm.Legajo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBObsLegajo extends DBObjetoPersistente {

	public static final String OID_OBS_LEG = "oid_obs_leg";
	public static final String OID_LEGAJO = "oid_legajo";
	public static final String OID_TIPO_OBS_LEG = "oid_tipo_obs_leg";
	public static final String FECHA = "fecha";
	public static final String FEC_CARGA = "fec_carga";
	public static final String OID_USU_CARGA = "oid_usu_carga";
	public static final String OBSERVACION = "observacion";
	public static final String ACTIVO = "activo";
	public static final String POS_NEG_NEU = "pos_neg_neu";

	public static final int SELECT_BY_LEGAJO = 100;
	public static final int SELECT_BY_LEG_TIPOOBS_ENTFECHAS = 101;

	public DBObsLegajo() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_OBS_LEG = 1;
		final int OID_LEGAJO = 2;
		final int OID_TIPO_OBS_LEG = 3;
		final int FECHA = 4;
		final int FEC_CARGA = 5;
		final int OID_USU_CARGA = 6;
		final int OBSERVACION = 7;
		final int ACTIVO = 8;
		final int POS_NEG_NEU = 9;

		ObsLegajo pers = (ObsLegajo) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into rhObsLeg " + " ( " + "OID_OBS_LEG," + "OID_LEGAJO," + "OID_TIPO_OBS_LEG," + "FECHA," + "FEC_CARGA," + "OID_USU_CARGA," + "OBSERVACION,"
				+ "ACTIVO , POS_NEG_NEU)" + " values " + "(" + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_OBS_LEG, pers.getOID());
		qInsert.setInt(OID_LEGAJO, pers.getLegajo().getOID());
		qInsert.setInt(OID_TIPO_OBS_LEG, pers.getTipo_obs_leg().getOID());
		qInsert.setDate(FECHA, new java.sql.Date(pers.getFecha().getTime()));
		qInsert.setDate(FEC_CARGA, new java.sql.Date(pers.getFec_carga().getTime()));
		qInsert.setInt(OID_USU_CARGA, pers.getUsuario_carga().getOID());
		qInsert.setString(OBSERVACION, pers.getObservacion());
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		if (pers.getPosNegNeu() != null)
			qInsert.setString(POS_NEG_NEU, pers.getPosNegNeu());
		else
			qInsert.setString(POS_NEG_NEU, "");
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_LEGAJO = 1;
		final int OID_TIPO_OBS_LEG = 2;
		final int FECHA = 3;
		final int FEC_CARGA = 4;
		final int OID_USU_CARGA = 5;
		final int OBSERVACION = 6;
		final int ACTIVO = 7;
		final int POS_NEG_NEU = 8;
		final int OID_OBS_LEG = 9;

		ObsLegajo pers = (ObsLegajo) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update rhObsLeg set " + "oid_legajo=?" + ",oid_tipo_obs_leg=?" + ",fecha=?" + ",fec_carga=?" + ",oid_usu_carga=?" + ",observacion=?" + ",activo=? , pos_neg_neu = ? "
				+ " where " + " oid_obs_leg=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_OBS_LEG, pers.getOID());
		qUpdate.setInt(OID_LEGAJO, pers.getLegajo().getOID());
		qUpdate.setInt(OID_TIPO_OBS_LEG, pers.getTipo_obs_leg().getOID());
		qUpdate.setDate(FECHA, new java.sql.Date(pers.getFecha().getTime()));
		qUpdate.setDate(FEC_CARGA, new java.sql.Date(pers.getFec_carga().getTime()));
		qUpdate.setInt(OID_USU_CARGA, pers.getUsuario_carga().getOID());
		qUpdate.setString(OBSERVACION, pers.getObservacion());
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		if (pers.getPosNegNeu() != null)
			qUpdate.setString(POS_NEG_NEU, pers.getPosNegNeu());
		else
			qUpdate.setString(POS_NEG_NEU, "");
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_OBS_LEG = 1;
		ObsLegajo pers = (ObsLegajo) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update rhObsLeg " + " set activo=0 " + " where " + " oid_obs_leg=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_OBS_LEG, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_OBS_LEG = 1;
		ObsLegajo pers = (ObsLegajo) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update rhObsLeg " + " set activo=1 " + " where " + " oid_obs_leg=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_OBS_LEG, pers.getOID());
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
		case SELECT_BY_LEGAJO: {
			ps = this.selectByLegajo(aCondiciones);
			break;
		}
		case SELECT_BY_LEG_TIPOOBS_ENTFECHAS: {
			ps = this.selectByLegTipoObsEntreFechas(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_OBS_LEG = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  rhObsLeg ");
		textSQL.append(" WHERE oid_obs_leg = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_OBS_LEG, oid);
		return querySelect;
	}

	private PreparedStatement selectByLegTipoObsEntreFechas(Object aCondiciones) throws BaseException, SQLException {
		
		StringBuffer textSQL = new StringBuffer();

		textSQL.append(" select ");
		textSQL.append("  * ");
		textSQL.append(" from ");
		textSQL.append("  rhObsLeg ");
		textSQL.append(" where ");
		textSQL.append("  oid_legajo = ? and ");
		textSQL.append("  oid_tipo_obs_leg = ? and ");
		textSQL.append("  activo = 1 and ");
		textSQL.append("  fecha >= ? and ");
		textSQL.append("  fecha <= ? and ");
		textSQL.append("  fecha = (select max(fecha) from rhObsLeg where  oid_legajo = ? and ");
		textSQL.append("  oid_tipo_obs_leg = ? and activo = 1 and fecha>=? and fecha<=?) order by oid_obs_leg  ");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		Legajo legajo = (Legajo) condiciones.get(Legajo.NICKNAME);
		TipoObsLeg tipoObs = (TipoObsLeg) condiciones.get(TipoObsLeg.NICKNAME);
		java.util.Date fecDesde = (java.util.Date) condiciones.get("FEC_DESDE");
		java.util.Date fecHasta = (java.util.Date) condiciones.get("FEC_HASTA");
		
		querySelect.setInt(1, legajo.getOID());
		querySelect.setInt(2, tipoObs.getOID());
		querySelect.setDate(3, new java.sql.Date(fecDesde.getTime()));
		querySelect.setDate(4, new java.sql.Date(fecHasta.getTime()));
		querySelect.setInt(5, legajo.getOID());
		querySelect.setInt(6, tipoObs.getOID());
		querySelect.setDate(7, new java.sql.Date(fecDesde.getTime()));
		querySelect.setDate(8, new java.sql.Date(fecHasta.getTime()));		
		
		return querySelect;
	}

	private PreparedStatement selectByLegajo(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  rhObsLeg ");
		textSQL.append(" WHERE oid_legajo = ? and activo = 1");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		Legajo legajo = (Legajo) aCondiciones;
		querySelect.setInt(1, legajo.getOID());
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  rhObsLeg ");
		textSQL.append(" WHERE oid_legajo = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_obs_leg oid,oid_legajo codigo, oid_tipo_obs_leg descripcion ,activo ");
		textSQL.append(" from rhObsLeg");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static List getObsLegajo(Legajo legajo, ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(ObsLegajo.NICKNAME, DBObsLegajo.SELECT_BY_LEGAJO, legajo, new ListObserver(), aSesion);
	}
	
	public static ObsLegajo getObsLegajo(
			  Legajo legajo,
			  TipoObsLeg aTipoObsLeg,
			  java.util.Date fecDesde,
			  java.util.Date fecHasta,
	          ISesion aSesion)
	          throws BaseException {
		  HashTableDatos condiciones = new HashTableDatos();
		  condiciones.put(Legajo.NICKNAME, legajo);
		  condiciones.put(TipoObsLeg.NICKNAME, aTipoObsLeg);
		  condiciones.put("FEC_DESDE" , fecDesde);
		  condiciones.put("FEC_HASTA" , fecHasta);
		  
		  return (ObsLegajo) ObjetoLogico.getObjects(ObsLegajo.NICKNAME,
				  				DBObsLegajo.SELECT_BY_LEG_TIPOOBS_ENTFECHAS,
				  				condiciones,
				  				new ObjetoObservado(),
				  				aSesion);
	}	

}
