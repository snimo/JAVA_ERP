package com.srn.erp.cip.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.cip.bm.Cacheo;
import com.srn.erp.cip.bm.GrupoPuerta;
import com.srn.erp.cip.bm.UtilCIP;
import com.srn.erp.general.bm.PeriodoInc;
import com.srn.erp.general.bm.PeriodoIncDet;
import com.srn.erp.general.da.DBPeriodoIncDet;
import com.srn.erp.sueldos.bm.Legajo;
import com.srn.erp.ventas.bm.PedidoCab;
import com.srn.erp.ventas.da.DBPedidoCab;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBCacheo extends DBObjetoPersistente {

	public static final String OID_CACHEO = "oid_cacheo";
	public static final String OID_LEGAJO = "oid_legajo";
	public static final String FEC_PLANIF_CACHEO = "fec_planif_cacheo";
	public static final String FEC_CACHEO = "fec_cacheo";
	public static final String REALIZADO = "realizado";
	public static final String ACTIVO = "activo";
	public static final String OID_USU_CACHEO = "oid_usu_cacheo";
	public static final String HORA_CACHEO = "hora_cacheo";
	public static final String FEC_LEVANTADO = "fec_levantado";
	public static final String LEVANTADO = "levantado";
	public static final String NO_REALIZADO = "no_realizado";
	public static final String OBS_CACHEO = "obs_cacheo";
	public static final String HORA_LEVANTADO = "hora_levantado";
	public static final String ENT_O_SAL = "ent_o_sal";
	public static final String OID_EST_RES_CACHEO = "oid_est_res_cacheo";
	public static final String OID_USU_LEVANTADO = "oid_usu_levantado";
	public static final String OID_CACHEO_PERS = "oid_cacheo_pers";
	public static final String OID_GRUPO_PUERTA = "oid_grupo_puerta";
	public static final String INTENTO_DE_PASE = "intento_de_pase";
	public static final String OID_FEC_PLANIF = "oid_fec_planif";

	public static final int SELECT_BY_FEC_DESDE_HASTA = 100;
	public static final int SELECT_TIENE_CACHEO_PEND = 101;
	public static final int SELECT_TIENE_CACHEO_PEND_COND = 102;
	public static final int MARCAR_INTENTO_DE_PASO = 103;

	public DBCacheo() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_CACHEO = 1;
		final int OID_LEGAJO = 2;
		final int FEC_PLANIF_CACHEO = 3;
		final int FEC_CACHEO = 4;
		final int REALIZADO = 5;
		final int ACTIVO = 6;
		final int OID_USU_CACHEO = 7;
		final int HORA_CACHEO = 8;
		final int FEC_LEVANTADO = 9;
		final int LEVANTADO = 10;
		final int NO_REALIZADO = 11;
		final int OBS_CACHEO = 12;
		final int HORA_LEVANTADO = 13;
		final int ENT_O_SAL = 14;
		final int OID_EST_RES_CACHEO = 15;
		final int OID_USU_LEVANTADO = 16;
		final int OID_CACHEO_PERS = 17;
		final int OID_GRUPO_PUERTA = 18;
		final int INTENTO_DE_PASE = 19;
		final int OID_FEC_PLANIF  =20;

		Cacheo pers = (Cacheo) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into cipCacheo " + " ( " + "OID_CACHEO," + "OID_LEGAJO," + "FEC_PLANIF_CACHEO," + "FEC_CACHEO,"
				+ "REALIZADO," + "ACTIVO," + "OID_USU_CACHEO," + "HORA_CACHEO," + "FEC_LEVANTADO," + "LEVANTADO," + "NO_REALIZADO,"
				+ "OBS_CACHEO," + "HORA_LEVANTADO," + "ENT_O_SAL," + "OID_EST_RES_CACHEO,"
				+ "OID_USU_LEVANTADO , OID_CACHEO_PERS , OID_GRUPO_PUERTA , INTENTO_DE_PASE , OID_FEC_PLANIF)" + " values " + "(" + "?," + "?," + "?,"
				+ "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?,"+ "?," + "?," + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_CACHEO, pers.getOID());
		qInsert.setInt(OID_LEGAJO, pers.getLegajo().getOID());
		qInsert.setDate(FEC_PLANIF_CACHEO, new java.sql.Date(pers.getFec_planif_cacheo().getTime()));
		if (pers.getFec_cacheo() != null)
			qInsert.setDate(FEC_CACHEO, new java.sql.Date(pers.getFec_cacheo().getTime()));
		else
			qInsert.setNull(FEC_CACHEO, java.sql.Types.DATE);
		qInsert.setBoolean(REALIZADO, pers.isRealizado().booleanValue());
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		if (pers.getUsuario_cacheo() != null)
			qInsert.setInt(OID_USU_CACHEO, pers.getUsuario_cacheo().getOID());
		else
			qInsert.setNull(OID_USU_CACHEO, java.sql.Types.INTEGER);
		qInsert.setString(HORA_CACHEO, pers.getHora_cacheo());
		if (pers.getFec_levantado() != null)
			qInsert.setDate(FEC_LEVANTADO, new java.sql.Date(pers.getFec_levantado().getTime()));
		else
			qInsert.setNull(FEC_LEVANTADO, java.sql.Types.DATE);
		qInsert.setBoolean(LEVANTADO, pers.isLevantado().booleanValue());
		qInsert.setBoolean(NO_REALIZADO, pers.isNo_realizado().booleanValue());
		qInsert.setString(OBS_CACHEO, pers.getObs_cacheo());
		qInsert.setString(HORA_LEVANTADO, pers.getHora_levantado());
		qInsert.setString(ENT_O_SAL, pers.getEnt_o_sal());
		if (pers.getEst_res_cacheo() != null)
			qInsert.setInt(OID_EST_RES_CACHEO, pers.getEst_res_cacheo().getOID());
		else
			qInsert.setNull(OID_EST_RES_CACHEO, java.sql.Types.INTEGER);
		if (pers.getUsuario_levanto() != null)
			qInsert.setInt(OID_USU_LEVANTADO, pers.getUsuario_levanto().getOID());
		else
			qInsert.setNull(OID_USU_LEVANTADO, java.sql.Types.INTEGER);
		if (pers.getCacheoPersona() != null)
			qInsert.setInt(OID_CACHEO_PERS, pers.getCacheoPersona().getOID());
		else
			qInsert.setNull(OID_CACHEO_PERS, java.sql.Types.INTEGER);
		qInsert.setInt(OID_GRUPO_PUERTA, pers.getGrupoPuerta().getOID());

		if (pers.isIntentoDePase() != null)
			qInsert.setBoolean(INTENTO_DE_PASE, pers.isIntentoDePase());
		else
			qInsert.setBoolean(INTENTO_DE_PASE, false);

		qInsert.setInt(OID_GRUPO_PUERTA, pers.getGrupoPuerta().getOID());
		if (pers.getFechaPlanifCacheo()!=null)
			qInsert.setInt(OID_FEC_PLANIF, pers.getFechaPlanifCacheo().getOID());
		else
			qInsert.setNull(OID_FEC_PLANIF, java.sql.Types.INTEGER);

		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_LEGAJO = 1;
		final int FEC_PLANIF_CACHEO = 2;
		final int FEC_CACHEO = 3;
		final int REALIZADO = 4;
		final int ACTIVO = 5;
		final int OID_USU_CACHEO = 6;
		final int HORA_CACHEO = 7;
		final int FEC_LEVANTADO = 8;
		final int LEVANTADO = 9;
		final int NO_REALIZADO = 10;
		final int OBS_CACHEO = 11;
		final int HORA_LEVANTADO = 12;
		final int ENT_O_SAL = 13;
		final int OID_EST_RES_CACHEO = 14;
		final int OID_USU_LEVANTADO = 15;
		final int OID_CACHEO_PERS = 16;
		final int OID_GRUPO_PUERTA = 17;
		final int INTENTO_DE_PASE = 18;
		final int OID_FEC_PLANIF  =19;
		final int OID_CACHEO = 20;

		Cacheo pers = (Cacheo) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate
				.append(" update cipCacheo set " + "oid_legajo=?" + ",fec_planif_cacheo=?" + ",fec_cacheo=?" + ",realizado=?" + ",activo=?"
						+ ",oid_usu_cacheo=?" + ",hora_cacheo=?" + ",fec_levantado=?" + ",levantado=?" + ",no_realizado=?"
						+ ",obs_cacheo=?" + ",hora_levantado=?" + ",ent_o_sal=?" + ",oid_est_res_cacheo=?"
						+ ",oid_usu_levantado=? , oid_cacheo_pers = ? , oid_grupo_puerta = ? , intento_de_pase = ? , oid_fec_planif = ? " + " where "
						+ " oid_cacheo=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_CACHEO, pers.getOID());
		qUpdate.setInt(OID_LEGAJO, pers.getLegajo().getOID());
		qUpdate.setDate(FEC_PLANIF_CACHEO, new java.sql.Date(pers.getFec_planif_cacheo().getTime()));
		if (pers.getFec_cacheo() != null)
			qUpdate.setDate(FEC_CACHEO, new java.sql.Date(pers.getFec_cacheo().getTime()));
		else
			qUpdate.setNull(FEC_CACHEO, java.sql.Types.DATE);
		qUpdate.setBoolean(REALIZADO, pers.isRealizado().booleanValue());
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		if (pers.getUsuario_cacheo() != null)
			qUpdate.setInt(OID_USU_CACHEO, pers.getUsuario_cacheo().getOID());
		else
			qUpdate.setNull(OID_USU_CACHEO, java.sql.Types.INTEGER);
		qUpdate.setString(HORA_CACHEO, pers.getHora_cacheo());
		if (pers.getFec_levantado() != null)
			qUpdate.setDate(FEC_LEVANTADO, new java.sql.Date(pers.getFec_levantado().getTime()));
		else
			qUpdate.setNull(FEC_LEVANTADO, java.sql.Types.DATE);
		qUpdate.setBoolean(LEVANTADO, pers.isLevantado().booleanValue());
		qUpdate.setBoolean(NO_REALIZADO, pers.isNo_realizado().booleanValue());
		qUpdate.setString(OBS_CACHEO, pers.getObs_cacheo());
		qUpdate.setString(HORA_LEVANTADO, pers.getHora_levantado());
		qUpdate.setString(ENT_O_SAL, pers.getEnt_o_sal());
		if (pers.getEst_res_cacheo() != null)
			qUpdate.setInt(OID_EST_RES_CACHEO, pers.getEst_res_cacheo().getOID());
		else
			qUpdate.setNull(OID_EST_RES_CACHEO, java.sql.Types.INTEGER);
		if (pers.getUsuario_levanto() != null)
			qUpdate.setInt(OID_USU_LEVANTADO, pers.getUsuario_levanto().getOID());
		else
			qUpdate.setNull(OID_USU_LEVANTADO, java.sql.Types.INTEGER);
		if (pers.getCacheoPersona() != null)
			qUpdate.setInt(OID_CACHEO_PERS, pers.getCacheoPersona().getOID());
		else
			qUpdate.setNull(OID_CACHEO_PERS, java.sql.Types.INTEGER);
		qUpdate.setInt(OID_GRUPO_PUERTA, pers.getGrupoPuerta().getOID());
		if (pers.isIntentoDePase() != null)
			qUpdate.setBoolean(INTENTO_DE_PASE, pers.isIntentoDePase());
		else
			qUpdate.setBoolean(INTENTO_DE_PASE, false);
		if (pers.getFechaPlanifCacheo()!=null)
			qUpdate.setInt(OID_FEC_PLANIF, pers.getFechaPlanifCacheo().getOID());
		else
			qUpdate.setNull(OID_FEC_PLANIF, java.sql.Types.INTEGER);
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_CACHEO = 1;
		Cacheo pers = (Cacheo) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cipCacheo " + " set activo=0 " + " where " + " oid_cacheo=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_CACHEO, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_CACHEO = 1;
		Cacheo pers = (Cacheo) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cipCacheo " + " set activo=1 " + " where " + " oid_cacheo=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_CACHEO, pers.getOID());
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
		case SELECT_BY_FEC_DESDE_HASTA: {
			ps = this.selectByFecDesdeHasta(aCondiciones);
			break;
		}
		case SELECT_TIENE_CACHEO_PEND: {
			ps = this.selectByTieneCacheoPend(aCondiciones);
			break;
		}
		case SELECT_TIENE_CACHEO_PEND_COND: {
			ps = this.selectByCacheoPendCond(aCondiciones);
			break;
		}
		case MARCAR_INTENTO_DE_PASO: {
			ps = this.selectByMarcarIntentoDePaso(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_CACHEO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cipCacheo ");
		textSQL.append(" WHERE oid_cacheo = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_CACHEO, oid);
		return querySelect;
	}

	private PreparedStatement selectByMarcarIntentoDePaso(Object aCondiciones) throws BaseException, SQLException {
		Cacheo cacheo = (Cacheo) aCondiciones;
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("update cipCacheo set intento_de_pase = 1 ");
		textSQL.append(" WHERE oid_cacheo="+cacheo.getOIDInteger()+" and intento_de_pase = 0");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		querySelect.executeUpdate();
		querySelect.close();
		return null;

	}

	private PreparedStatement selectByCacheoPendCond(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cipCacheo ");
		textSQL.append(" WHERE levantado=0 and realizado=0 and no_realizado=1 and activo=1 and fec_planif_cacheo>=? ");

		HashTableDatos condiciones = (HashTableDatos) aCondiciones;

		if (condiciones.containsKey("FEC_HASTA"))
			textSQL.append(" and fec_planif_cacheo<=? ");

		if (condiciones.containsKey(Legajo.NICKNAME)) {
			Legajo legajo = (Legajo) condiciones.get(Legajo.NICKNAME);
			textSQL.append(" and oid_legajo=" + legajo.getOIDInteger());
		}

		if (condiciones.containsKey(GrupoPuerta.NICKNAME)) {
			GrupoPuerta grupoPuerta = (GrupoPuerta) condiciones.get(GrupoPuerta.NICKNAME);
			textSQL.append(" and oid_grupo_puerta=" + grupoPuerta.getOIDInteger());
		}

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());

		querySelect.setDate(1, new java.sql.Date(UtilCIP.getFechaHoraActual(this.getSesion()).getTime()));
		if (condiciones.containsKey("FEC_HASTA")) {
			java.util.Date fecHasta = (java.util.Date) condiciones.get("FEC_HASTA");
			querySelect.setDate(2, new java.sql.Date(fecHasta.getTime()));
		}

		return querySelect;
	}

	private PreparedStatement selectByTieneCacheoPend(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cipCacheo ");
		textSQL.append(" WHERE oid_legajo = ? and fec_planif_cacheo = ? and ent_o_sal=? and levantado=0 and realizado=0 and no_realizado=1 and activo=1 order by intento_de_pase desc ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		Integer oidLegajo = (Integer) condiciones.get("OID_LEGAJO");
		java.util.Date fecha = (java.util.Date) condiciones.get("FECHA");
		String entradaSalida = (String) condiciones.get("ENT_O_SAL");

		querySelect.setInt(1, oidLegajo.intValue());
		querySelect.setDate(2, new java.sql.Date(fecha.getTime()));
		querySelect.setString(3, entradaSalida);

		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cipCacheo ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectByFecDesdeHasta(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cipCacheo ");
		textSQL.append(" WHERE fec_planif_cacheo >= ? and fec_planif_cacheo <= ? and activo=1 ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		java.util.Date fecDesde = (java.util.Date) condiciones.get("FEC_DESDE");
		java.util.Date fecHasta = (java.util.Date) condiciones.get("FEC_HASTA");
		querySelect.setDate(1, new java.sql.Date(fecDesde.getTime()));
		querySelect.setDate(2, new java.sql.Date(fecHasta.getTime()));
		return querySelect;

	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_cacheo oid, codigo,  descripcion ,activo ");
		textSQL.append(" from cipCacheo");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static List getCacheos(java.util.Date fecDesde, java.util.Date fecHasta, ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put("FEC_DESDE", fecDesde);
		condiciones.put("FEC_HASTA", fecHasta);
		return (List) ObjetoLogico
				.getObjects(Cacheo.NICKNAME, DBCacheo.SELECT_BY_FEC_DESDE_HASTA, condiciones, new ListObserver(), aSesion);
	}

	public static Cacheo getCacheoPend(Integer oidLegajo, java.util.Date fecha, String entSal, ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put("OID_LEGAJO", oidLegajo);
		condiciones.put("FECHA", fecha);
		condiciones.put("ENT_O_SAL", entSal);
		return (Cacheo) ObjetoLogico.getObjects(Cacheo.NICKNAME, DBCacheo.SELECT_TIENE_CACHEO_PEND, condiciones, new ObjetoObservado(),
				aSesion);
	}

	public static List getCacheoPendAHoy(Legajo legajo, java.util.Date fechaHasta, GrupoPuerta grupoPuerta, ISesion aSesion)
			throws BaseException {

		HashTableDatos condiciones = new HashTableDatos();
		if (legajo != null)
			condiciones.put(Legajo.NICKNAME, legajo);
		if (fechaHasta != null)
			condiciones.put("FEC_HASTA", fechaHasta);
		if (grupoPuerta != null)
			condiciones.put(GrupoPuerta.NICKNAME, grupoPuerta);
		return (List) ObjetoLogico.getObjects(Cacheo.NICKNAME, DBCacheo.SELECT_TIENE_CACHEO_PEND_COND, condiciones, new ListObserver(),
				aSesion);

	}

	public static void marcarIntentoDePaso(Cacheo cacheo, ISesion aSesion) throws BaseException {
		ObjetoLogico.getObjects(Cacheo.NICKNAME, DBCacheo.MARCAR_INTENTO_DE_PASO, cacheo, new ObjetoObservado(),
				aSesion);
	}

}
