package com.srn.erp.cip.da;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.srn.erp.cip.bm.NovedadPermisoCIP;
import com.srn.erp.cip.bm.Rota;
import com.srn.erp.sueldos.bm.Legajo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;

public class DBNovedadPermisoCIP extends DBObjetoPersistente {

	public static final String OID_NOV_PERMISO = "oid_nov_permiso";
	public static final String OID_MOTIVO = "oid_motivo";
	public static final String FECHA = "fecha";
	public static final String OID_LEGAJO = "oid_legajo";
	public static final String HORA_DESDE = "hora_desde";
	public static final String HORA_HASTA = "hora_hasta";
	public static final String HORA_DESDE_EN_MIN = "hora_desde_en_min";
	public static final String HORA_HASTA_EN_MIN = "hora_hasta_en_min";
	public static final String OID_GRUPO_PUERTA = "oid_grupo_puerta";
	public static final String OBSERVACION = "observacion";
	public static final String ACTIVO = "activo";
	public static final String PERMISO_INGRESO = "permiso_ingreso";
	public static final String PERMISO_EGRESO = "permiso_egreso";
	public static final String FEC_USU_ASIG_PERM = "fec_usu_asig_perm";
	public static final String OID_USU_ASIG_PERM = "oid_usu_asig_perm";
	public static final String HOR_USU_ASIG_PERM = "hor_usu_asig_perm";
	public static final String ES_NOV_EXT = "es_nov_ext";
	public static final String IDENTIF_NOV_EXT = "identif_nov_ext";
	public static final String PESO_NOVEDAD = "peso_novedad";
	
	
	

	public static final int SELECT_BY_NOV_LEGAJO_A_FECHA = 100;
	public static final int SELECT_BY_LEG_FEC_ANUROTA = 101;
	public static final int SELECT_BY_LEG_FECDESDE_FECHASTA = 102;
	public static final int SELECT_BY_FECDESDE_FECHASTA = 103;

	public DBNovedadPermisoCIP() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_NOV_PERMISO = 1;
		final int OID_MOTIVO = 2;
		final int FECHA = 3;
		final int OID_LEGAJO = 4;
		final int HORA_DESDE = 5;
		final int HORA_HASTA = 6;
		final int HORA_DESDE_EN_MIN = 7;
		final int HORA_HASTA_EN_MIN = 8;
		final int OID_GRUPO_PUERTA = 9;
		final int OBSERVACION = 10;
		final int ACTIVO = 11;
		final int PERMISO_INGRESO = 12;
		final int PERMISO_EGRESO = 13;
		final int FEC_USU_ASIG_PERM = 14;
		final int OID_USU_ASIG_PERM = 15;
		final int HOR_USU_ASIG_PERM = 16;
		final int ES_NOV_EXT = 17;
		final int IDENTIF_NOV_EXT = 18;
		final int PESO_NOVEDAD = 19;

		NovedadPermisoCIP pers = (NovedadPermisoCIP) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into cipNovPermisos " + " ( " + "OID_NOV_PERMISO," + "OID_MOTIVO," + "FECHA," + "OID_LEGAJO,"
				+ "HORA_DESDE," + "HORA_HASTA," + "HORA_DESDE_EN_MIN," + "HORA_HASTA_EN_MIN," + "OID_GRUPO_PUERTA," + "OBSERVACION,"
				+ "ACTIVO," + "PERMISO_INGRESO," + "PERMISO_EGRESO," + "FEC_USU_ASIG_PERM," + "OID_USU_ASIG_PERM," + "HOR_USU_ASIG_PERM , ES_NOV_EXT , IDENTIF_NOV_EXT , PESO_NOVEDAD  )"
				+ " values " + "(" + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?,"+ "?,"+ "?," + "?,"+ "?,"
				+ "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_NOV_PERMISO, pers.getOID());
		qInsert.setInt(OID_MOTIVO, pers.getMotivo().getOID());
		qInsert.setDate(FECHA, new java.sql.Date(pers.getFecha().getTime()));
		qInsert.setInt(OID_LEGAJO, pers.getLegajo().getOID());
		qInsert.setString(HORA_DESDE, pers.getHora_desde());
		qInsert.setString(HORA_HASTA, pers.getHora_hasta());
		qInsert.setInt(HORA_DESDE_EN_MIN, pers.getHora_desde_en_min().intValue());
		qInsert.setInt(HORA_HASTA_EN_MIN, pers.getHora_hasta_en_min().intValue());
		qInsert.setInt(OID_GRUPO_PUERTA, pers.getGrupo_puerta().getOID());
		qInsert.setString(OBSERVACION, pers.getObservacion());
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qInsert.setString(PERMISO_INGRESO, pers.getPermisoIngreso());
		qInsert.setString(PERMISO_EGRESO, pers.getPermisoEgreso());
		qInsert.setDate(FEC_USU_ASIG_PERM, new java.sql.Date(pers.getFec_usu_asig_perm().getTime()));
		qInsert.setInt(OID_USU_ASIG_PERM, pers.getUsu_asig_permiso().getOID());
		qInsert.setString(HOR_USU_ASIG_PERM, pers.getHor_usu_asig_perm());
		if (pers.isNovedadExterna()!=null)
			qInsert.setBoolean(ES_NOV_EXT, pers.isNovedadExterna().booleanValue());
		else
			qInsert.setBoolean(ES_NOV_EXT, false);
		if (pers.getIdentifNovExt()!=null)
			qInsert.setString(IDENTIF_NOV_EXT, pers.getIdentifNovExt());
		else
			qInsert.setString(IDENTIF_NOV_EXT, "");		
		
		if (pers.getPesoNovedad()!=null)
			qInsert.setInt(PESO_NOVEDAD, pers.getPesoNovedad().intValue());
		else
			qInsert.setInt(PESO_NOVEDAD, 0);		
		
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_MOTIVO = 1;
		final int FECHA = 2;
		final int OID_LEGAJO = 3;
		final int HORA_DESDE = 4;
		final int HORA_HASTA = 5;
		final int HORA_DESDE_EN_MIN = 6;
		final int HORA_HASTA_EN_MIN = 7;
		final int OID_GRUPO_PUERTA = 8;
		final int OBSERVACION = 9;
		final int ACTIVO = 10;
		final int PERMISO_INGRESO = 11;
		final int PERMISO_EGRESO = 12;
		final int FEC_USU_ASIG_PERM = 13;
		final int OID_USU_ASIG_PERM = 14;
		final int HOR_USU_ASIG_PERM = 15;
		final int ES_NOV_EXT = 16;
		final int IDENTIF_NOV_EXT = 17;
		final int PESO_NOVEDAD = 18;
		final int OID_NOV_PERMISO = 19;

		NovedadPermisoCIP pers = (NovedadPermisoCIP) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update cipNovPermisos set " + "oid_motivo=?" + ",fecha=?" + ",oid_legajo=?" + ",hora_desde=?" + ",hora_hasta=?"
				+ ",hora_desde_en_min=?" + ",hora_hasta_en_min=?" + ",oid_grupo_puerta=?" + ",observacion=?" + ",activo=?"
				+ ",permiso_ingreso=?" + ",permiso_egreso=?" + ",fec_usu_asig_perm=?" + ",oid_usu_asig_perm=?" + ",hor_usu_asig_perm=? , es_nov_ext=? , identif_nov_ext=?  , peso_novedad = ? "
				+ " where " + " oid_nov_permiso=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_NOV_PERMISO, pers.getOID());
		qUpdate.setInt(OID_MOTIVO, pers.getMotivo().getOID());
		qUpdate.setDate(FECHA, new java.sql.Date(pers.getFecha().getTime()));
		qUpdate.setInt(OID_LEGAJO, pers.getLegajo().getOID());
		qUpdate.setString(HORA_DESDE, pers.getHora_desde());
		qUpdate.setString(HORA_HASTA, pers.getHora_hasta());
		qUpdate.setInt(HORA_DESDE_EN_MIN, pers.getHora_desde_en_min().intValue());
		qUpdate.setInt(HORA_HASTA_EN_MIN, pers.getHora_hasta_en_min().intValue());
		qUpdate.setInt(OID_GRUPO_PUERTA, pers.getGrupo_puerta().getOID());
		qUpdate.setString(OBSERVACION, pers.getObservacion());
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qUpdate.setString(PERMISO_INGRESO, pers.getPermisoIngreso());
		qUpdate.setString(PERMISO_EGRESO, pers.getPermisoEgreso());
		qUpdate.setDate(FEC_USU_ASIG_PERM, new java.sql.Date(pers.getFec_usu_asig_perm().getTime()));
		qUpdate.setInt(OID_USU_ASIG_PERM, pers.getUsu_asig_permiso().getOID());
		qUpdate.setString(HOR_USU_ASIG_PERM, pers.getHor_usu_asig_perm());
		if (pers.isNovedadExterna()!=null)
			qUpdate.setBoolean(ES_NOV_EXT, pers.isNovedadExterna().booleanValue());
		else
			qUpdate.setBoolean(ES_NOV_EXT, false);
		if (pers.getIdentifNovExt()!=null)
			qUpdate.setString(IDENTIF_NOV_EXT, pers.getIdentifNovExt());
		else
			qUpdate.setString(IDENTIF_NOV_EXT, "");
		
		if (pers.getPesoNovedad()!=null)
			qUpdate.setInt(PESO_NOVEDAD, pers.getPesoNovedad().intValue());
		else
			qUpdate.setInt(PESO_NOVEDAD, 0);		
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_NOV_PERMISO = 1;
		NovedadPermisoCIP pers = (NovedadPermisoCIP) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cipNovPermisos " + " set activo=0 " + " where " + " oid_nov_permiso=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_NOV_PERMISO, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_NOV_PERMISO = 1;
		NovedadPermisoCIP pers = (NovedadPermisoCIP) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cipNovPermisos " + " set activo=1 " + " where " + " oid_nov_permiso=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_NOV_PERMISO, pers.getOID());
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
		case SELECT_BY_NOV_LEGAJO_A_FECHA: {
			ps = this.selectByNovLegAFecha(aCondiciones);
			break;
		}
		case SELECT_BY_LEG_FEC_ANUROTA: {
			ps = this.selectByLegAFechaAnuRota(aCondiciones);
			break;
		}
		case SELECT_BY_LEG_FECDESDE_FECHASTA: {
			ps = this.selectByLegFecDesdeFecHasta(aCondiciones);
			break;
		}
		case SELECT_BY_FECDESDE_FECHASTA: {
			ps = this.selectByFecDesdeFecHasta(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByFecDesdeFecHasta(Object aCondiciones) throws SQLException, BaseException {
		HashTableDatos cond = (HashTableDatos) aCondiciones;
		Date fecDesde = (Date) cond.get("FECDESDE");	
		Date fecHasta = (Date) cond.get("FECHASTA");
		
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cipNovPermisos ");
		textSQL.append(" WHERE activo = 1 and fecha >= ? and fecha<= ? order by fecha desc");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		querySelect.setDate(1, new java.sql.Date(fecDesde.getTime()));
		querySelect.setDate(2, new java.sql.Date(fecHasta.getTime()));
		
		return querySelect;
	}

	private PreparedStatement selectByLegFecDesdeFecHasta(Object aCondiciones) throws SQLException, BaseException {
		HashTableDatos cond = (HashTableDatos) aCondiciones;
		Legajo legajo = (Legajo) cond.get(Legajo.NICKNAME);
		Date fecDesde = (Date) cond.get("FECDESDE");	
		Date fecHasta = (Date) cond.get("FECHASTA");	
		
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cipNovPermisos ");
		textSQL.append(" WHERE activo=1 and oid_legajo = ? and fecha >= ? and fecha<= ? order by oid_legajo desc, fecha desc ");
		
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		querySelect.setInt(1, legajo.getOID());
		querySelect.setDate(2, new java.sql.Date(fecDesde.getTime()));
		querySelect.setDate(3, new java.sql.Date(fecHasta.getTime()));
		
		return querySelect;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_NOV_PERMISO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cipNovPermisos ");
		textSQL.append(" WHERE oid_nov_permiso = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_NOV_PERMISO, oid);
		return querySelect;
	}

	private PreparedStatement selectByNovLegAFecha(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cipNovPermisos ");
		textSQL.append(" WHERE oid_legajo = ? and activo=1 and fecha=? order by peso_novedad desc,oid_nov_permiso desc ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		HashTableDatos cond = (HashTableDatos) aCondiciones;
		Legajo legajo = (Legajo) cond.get(Legajo.NICKNAME);
		java.util.Date fecha = (java.util.Date) cond.get("FECHA");		
		querySelect.setInt(1, legajo.getOID());
		querySelect.setDate(2, new java.sql.Date(fecha.getTime()));
		return querySelect;
	}
	
	public static int getMaximoMinEntAntes(
			java.util.Date fecha,
			Legajo legajo,
			ISesion aSesion) throws BaseException {

		try {
			
			StringBuffer textSQL = new StringBuffer();
			textSQL.append("SELECT nvl(max(b.min_ent_ant),0) min_ent_ant FROM  cipNovPermisos a , cipMotivosNov b ");
			textSQL.append(" WHERE a.oid_motivo=b.oid_motivo and  a.oid_legajo = ? and a.activo=1 and a.fecha=? ");
			PreparedStatement querySelect = aSesion.getConexionBD().prepareStatement(textSQL.toString());
			querySelect.setInt(1, legajo.getOID());
			querySelect.setDate(2, new java.sql.Date(fecha.getTime()));
			ResultSet rs = querySelect.executeQuery();
			int cant = 0;
			if (rs.next())
				cant = rs.getInt(1);
			rs.close();
			querySelect.close();

			return cant;
		}
		catch (Exception e) {
			throw new BaseException(null, e.getMessage());
		}
	}
	
	public static int getMaximoMinEntDespues(
			java.util.Date fecha,
			Legajo legajo,
			ISesion aSesion) throws BaseException {

		try {
			
			StringBuffer textSQL = new StringBuffer();
			textSQL.append("SELECT nvl(max(b.min_ent_des),0) min_ent_des FROM  cipNovPermisos a , cipMotivosNov b ");
			textSQL.append(" WHERE a.oid_motivo=b.oid_motivo and  a.oid_legajo = ? and a.activo=1 and a.fecha=? ");
			PreparedStatement querySelect = aSesion.getConexionBD().prepareStatement(textSQL.toString());
			querySelect.setInt(1, legajo.getOID());
			querySelect.setDate(2, new java.sql.Date(fecha.getTime()));
			ResultSet rs = querySelect.executeQuery();
			int cant = 0;
			if (rs.next())
				cant = rs.getInt(1);
			rs.close();
			querySelect.close();

			return cant;
		}
		catch (Exception e) {
			throw new BaseException(null, e.getMessage());
		}
	}
	
	
	
	private PreparedStatement selectByLegAFechaAnuRota(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT a.* FROM  cipNovPermisos a , cipMotivosNov b ");
		textSQL.append(" WHERE a.oid_motivo=b.oid_motivo and  a.oid_legajo = ? and a.activo=1 and a.fecha=? and b.anula_rota_del_dia=1 ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		HashTableDatos cond = (HashTableDatos) aCondiciones;
		Legajo legajo = (Legajo) cond.get(Legajo.NICKNAME);
		java.util.Date fecha = (java.util.Date) cond.get("FECHA");		
		querySelect.setInt(1, legajo.getOID());
		querySelect.setDate(2, new java.sql.Date(fecha.getTime()));
		return querySelect;
	}
	
	
		
	
	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cipNovPermisos ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_nov_permiso oid, codigo,  descripcion ,activo ");
		textSQL.append(" from cipNovPermisos");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}
	
	public static List getNovedadesPermisosCIP(
			  Legajo legajo,
			  java.util.Date fecha,
              ISesion aSesion) throws BaseException {
		  HashTableDatos condiciones = new HashTableDatos();
		  condiciones.put(Legajo.NICKNAME, legajo);
		  condiciones.put("FECHA", fecha);
		  return (List) ObjetoLogico.getObjects(NovedadPermisoCIP.NICKNAME,
                 DBNovedadPermisoCIP.SELECT_BY_NOV_LEGAJO_A_FECHA,
                 condiciones,
                 new ListObserver(),
                 aSesion);
	}
	
	public static List getNovedadesPermisosCIPAnuRota(
			  Legajo legajo,
			  java.util.Date fecha,
            ISesion aSesion) throws BaseException {
		  HashTableDatos condiciones = new HashTableDatos();
		  condiciones.put(Legajo.NICKNAME, legajo);
		  condiciones.put("FECHA", fecha);
		  return (List) ObjetoLogico.getObjects(NovedadPermisoCIP.NICKNAME,
               DBNovedadPermisoCIP.SELECT_BY_LEG_FEC_ANUROTA,
               condiciones,
               new ListObserver(),
               aSesion);
	}

	public static List<NovedadPermisoCIP> getNovedadesByFechaDesdeFechaHasta(Date fecDesde, Date fecHasta, ISesion sesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put("FECDESDE", fecDesde);
		condiciones.put("FECHASTA", fecHasta);

		return (List<NovedadPermisoCIP>) ObjetoLogico.getObjects(NovedadPermisoCIP.NICKNAME, DBNovedadPermisoCIP.SELECT_BY_FECDESDE_FECHASTA, condiciones, new ListObserver(), sesion);
	}

	public static List<NovedadPermisoCIP> getNovedadesByLegFechaDesdeFechaHasta(Legajo legajo, Date fecDesde, Date fecHasta, ISesion sesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(Legajo.NICKNAME, legajo);
		condiciones.put("FECDESDE", fecDesde);
		condiciones.put("FECHASTA", fecHasta);

		return (List<NovedadPermisoCIP>) ObjetoLogico.getObjects(NovedadPermisoCIP.NICKNAME, DBNovedadPermisoCIP.SELECT_BY_LEG_FECDESDE_FECHASTA, condiciones, new ListObserver(), sesion);
	}

}
