package com.srn.erp.rrhh.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import com.srn.erp.rrhh.bm.MotivoTipoNov;
import com.srn.erp.rrhh.bm.NovedadLegajo;
import com.srn.erp.rrhh.bm.RankearCab;
import com.srn.erp.rrhh.bm.TipoNovedad;
import com.srn.erp.sueldos.bm.Legajo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;

public class DBNovedadLegajo extends DBObjetoPersistente {

	public static final String OID_NOVEDAD = "oid_novedad";
	public static final String NRO_EXT = "nro_ext";
	public static final String OID_TIPO_NOVEDAD = "oid_tipo_novedad";
	public static final String OID_MOT_TIPO_NOV = "oid_mot_tipo_nov";
	public static final String FECHA = "fecha";
	public static final String HORA_DESDE = "hora_desde";
	public static final String HORA_HASTA = "hora_hasta";
	public static final String ACTIVO = "activo";
	public static final String OBSERVACION = "observacion";
	public static final String OID_LEGAJO = "oid_legajo";
	public static final String NRO_ORDEN = "nro_orden";

	public static final int SELECT_BY_LEGAJO = 100;
	public static final int SELECT_BY_TIPO_MOT_LEGAJO_ACT_FECHAS = 101;
	public static final int SELECT_BY_LEG_FEC_DES_HAS = 102;
	public static final int SELECT_BY_LEG_RANK_FEC_DES_HAS = 103;
	public static final int SELECT_BY_LEG_FEC = 104;

	public DBNovedadLegajo() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_NOVEDAD = 1;
		final int NRO_EXT = 2;
		final int OID_TIPO_NOVEDAD = 3;
		final int OID_MOT_TIPO_NOV = 4;
		final int FECHA = 5;
		final int HORA_DESDE = 6;
		final int HORA_HASTA = 7;
		final int ACTIVO = 8;
		final int OBSERVACION = 9;
		final int OID_LEGAJO = 10;
		final int NRO_ORDEN = 11;

		NovedadLegajo pers = (NovedadLegajo) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into legNovedades " + " ( " + "OID_NOVEDAD," + "NRO_EXT," + "OID_TIPO_NOVEDAD," + "OID_MOT_TIPO_NOV," + "FECHA," + "HORA_DESDE," + "HORA_HASTA," + "ACTIVO,"
				+ "OBSERVACION," + "OID_LEGAJO , NRO_ORDEN)" + " values " + "(" + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_NOVEDAD, pers.getOID());
		if (pers.getNro_ext() != null)
			qInsert.setInt(NRO_EXT, pers.getNro_ext().intValue());
		else
			qInsert.setNull(NRO_EXT, Types.INTEGER);
		if (pers.getOid_tipo_novedad() != null)
			qInsert.setInt(OID_TIPO_NOVEDAD, pers.getOid_tipo_novedad().getOID());
		else
			qInsert.setNull(OID_TIPO_NOVEDAD, Types.INTEGER);
		if (pers.getMotivo_tipo_nov() != null)
			qInsert.setInt(OID_MOT_TIPO_NOV, pers.getMotivo_tipo_nov().getOID());
		else
			qInsert.setNull(OID_MOT_TIPO_NOV, Types.INTEGER);
		if (pers.getFecha() != null)
			qInsert.setDate(FECHA, new java.sql.Date(pers.getFecha().getTime()));
		else
			qInsert.setNull(FECHA, Types.DATE);
		qInsert.setString(HORA_DESDE, pers.getHora_desde());
		qInsert.setString(HORA_HASTA, pers.getHora_hasta());
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qInsert.setString(OBSERVACION, pers.getObservacion());
		qInsert.setInt(OID_LEGAJO, pers.getOid_legajo().getOID());
		if (pers.getNroOrden() != null)
			qInsert.setInt(NRO_ORDEN, pers.getNroOrden());
		else
			qInsert.setNull(NRO_ORDEN, Types.INTEGER);
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int NRO_EXT = 1;
		final int OID_TIPO_NOVEDAD = 2;
		final int OID_MOT_TIPO_NOV = 3;
		final int FECHA = 4;
		final int HORA_DESDE = 5;
		final int HORA_HASTA = 6;
		final int ACTIVO = 7;
		final int OBSERVACION = 8;
		final int OID_LEGAJO = 9;
		final int NRO_ORDEN = 10;
		final int OID_NOVEDAD = 11;

		NovedadLegajo pers = (NovedadLegajo) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update legNovedades set " + "nro_ext=?" + ",oid_tipo_novedad=?" + ",oid_mot_tipo_nov=?" + ",fecha=?" + ",hora_desde=?" + ",hora_hasta=?" + ",activo=?" + ",observacion=?"
				+ ",oid_legajo=? , nro_orden = ? " + " where " + " oid_novedad=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_NOVEDAD, pers.getOID());
		if (pers.getNro_ext() != null)
			qUpdate.setInt(NRO_EXT, pers.getNro_ext().intValue());
		else
			qUpdate.setNull(NRO_EXT, Types.DATE);
		if (pers.getOid_tipo_novedad() != null)
			qUpdate.setInt(OID_TIPO_NOVEDAD, pers.getOid_tipo_novedad().getOID());
		else
			qUpdate.setNull(OID_TIPO_NOVEDAD, Types.INTEGER);
		if (pers.getMotivo_tipo_nov() != null)
			qUpdate.setInt(OID_MOT_TIPO_NOV, pers.getMotivo_tipo_nov().getOID());
		else
			qUpdate.setNull(OID_MOT_TIPO_NOV, Types.INTEGER);
		if (pers.getFecha() != null)
			qUpdate.setDate(FECHA, new java.sql.Date(pers.getFecha().getTime()));
		else
			qUpdate.setNull(FECHA, Types.DATE);
		qUpdate.setString(HORA_DESDE, pers.getHora_desde());
		qUpdate.setString(HORA_HASTA, pers.getHora_hasta());
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qUpdate.setString(OBSERVACION, pers.getObservacion());
		qUpdate.setInt(OID_LEGAJO, pers.getOid_legajo().getOID());
		if (pers.getNroOrden() != null)
			qUpdate.setInt(NRO_ORDEN, pers.getNroOrden());
		else
			qUpdate.setNull(NRO_ORDEN, Types.INTEGER);
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_NOVEDAD = 1;
		NovedadLegajo pers = (NovedadLegajo) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update legNovedades " + " set activo=0 " + " where " + " oid_novedad=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_NOVEDAD, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_NOVEDAD = 1;
		NovedadLegajo pers = (NovedadLegajo) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update legNovedades " + " set activo=1 " + " where " + " oid_novedad=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_NOVEDAD, pers.getOID());
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
		case SELECT_BY_TIPO_MOT_LEGAJO_ACT_FECHAS: {
			ps = this.selectByMotLegActFechas(aCondiciones);
			break;
		}
		case SELECT_BY_LEG_FEC_DES_HAS: {
			ps = this.selectByLegFecDesHas(aCondiciones);
			break;
		}
		case SELECT_BY_LEG_FEC: {
			ps = this.selectByLegFec(aCondiciones);
			break;			
		}
		case SELECT_BY_LEG_RANK_FEC_DES_HAS: {
			ps = this.selectByLegRankFecDesHas(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_NOVEDAD = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  legNovedades ");
		textSQL.append(" WHERE oid_novedad = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_NOVEDAD, oid);
		return querySelect;
	}

	private PreparedStatement selectByLegRankFecDesHas(Object aCondiciones) throws BaseException, SQLException {
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		StringBuffer textSQL = new StringBuffer();
		
		textSQL.append(" select "); 
		textSQL.append("  b.* "); 
		textSQL.append(" from "); 
		textSQL.append("  rhCondMinRank a, "); 
		textSQL.append("  legNovedades b "); 
		textSQL.append(" where "); 
		textSQL.append("  b.OID_TIPO_NOVEDAD = a.OID_TIPO_NOV  and ");
		textSQL.append("  b.OID_MOT_TIPO_NOV = a.OID_MOTIVO and ");
		textSQL.append("  b.oid_legajo = ? and ");
		textSQL.append("  a.oid_rankear = ? and ");
		textSQL.append("  a.activo = 1 and ");
		textSQL.append("  b.fecha>=? and "); 
		textSQL.append("  b.fecha<=? and ");
		textSQL.append("  b.activo = 1 and a.nro_novedad = ?");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		Legajo legajo = (Legajo) condiciones.get(Legajo.NICKNAME);
		RankearCab rankear = (RankearCab) condiciones.get(RankearCab.NICKNAME);
		java.util.Date fecDesde = (java.util.Date) condiciones.get("FECHA_DESDE");
		java.util.Date fecHasta = (java.util.Date) condiciones.get("FECHA_HASTA");
		Integer nroNovedad = (Integer) condiciones.get("NRO_NOVEDAD");
		querySelect.setInt(1, legajo.getOID());
		querySelect.setInt(2, rankear.getOID());
		querySelect.setDate(3, new java.sql.Date(fecDesde.getTime()));
		querySelect.setDate(4, new java.sql.Date(fecHasta.getTime()));
		querySelect.setInt(5, nroNovedad.intValue());
		return querySelect;
	}
	
	
	private PreparedStatement selectByLegFec(Object aCondiciones) throws BaseException, SQLException {
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  legNovedades ");
		textSQL.append(" WHERE oid_legajo = ? and fecha=? and activo = 1 ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		Legajo legajo = (Legajo) condiciones.get(Legajo.NICKNAME);
		java.util.Date fecha = (java.util.Date) condiciones.get("FECHA");
		querySelect.setInt(1, legajo.getOID());
		querySelect.setDate(2, new java.sql.Date(fecha.getTime()));
		return querySelect;
	}	
	
	private PreparedStatement selectByLegFecDesHas(Object aCondiciones) throws BaseException, SQLException {
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  legNovedades ");
		textSQL.append(" WHERE oid_legajo = ? and fecha>=? and fecha<=? and activo = 1 ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		Legajo legajo = (Legajo) condiciones.get(Legajo.NICKNAME);
		java.util.Date fecDesde = (java.util.Date) condiciones.get("FECHA_DESDE");
		java.util.Date fecHasta = (java.util.Date) condiciones.get("FECHA_HASTA");
		querySelect.setInt(1, legajo.getOID());
		querySelect.setDate(2, new java.sql.Date(fecDesde.getTime()));
		querySelect.setDate(3, new java.sql.Date(fecHasta.getTime()));
		return querySelect;
	}
	
	private PreparedStatement selectByMotLegActFechas(Object aCondiciones) throws BaseException, SQLException {
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  legNovedades ");
		textSQL.append(" WHERE oid_legajo = ? and activo = 1 and oid_tipo_novedad = ? and oid_mot_tipo_nov = ? and fecha>=? and fecha<=?  ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		Legajo legajo = (Legajo) condiciones.get(Legajo.NICKNAME);
		TipoNovedad tipoNov = (TipoNovedad) condiciones.get(TipoNovedad.NICKNAME);
		MotivoTipoNov motTipoNov = (MotivoTipoNov) condiciones.get(MotivoTipoNov.NICKNAME);
		java.util.Date fecDesde = (java.util.Date) condiciones.get("FECHA_DESDE");
		java.util.Date fecHasta = (java.util.Date) condiciones.get("FECHA_HASTA");
		querySelect.setInt(1, legajo.getOID());
		querySelect.setInt(2, tipoNov.getOID());
		querySelect.setInt(3, motTipoNov.getOID());
		querySelect.setDate(4, new java.sql.Date(fecDesde.getTime()));
		querySelect.setDate(5, new java.sql.Date(fecHasta.getTime()));
		return querySelect;
	}

	private PreparedStatement selectByLegajo(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  legNovedades ");
		textSQL.append(" WHERE oid_legajo = ? and activo = 1 order by nro_ext");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		Legajo legajo = (Legajo) aCondiciones;
		querySelect.setInt(1, legajo.getOID());
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  legNovedades ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(1, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_novedad oid, codigo,  descripcion ,activo ");
		textSQL.append(" from legNovedades");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static List getNovedadesLegajo(Legajo aLegajo, ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(NovedadLegajo.NICKNAME, DBNovedadLegajo.SELECT_BY_LEGAJO, aLegajo, new ListObserver(), aSesion);
	}
	
	public static List getNovedadesLegajo(Legajo aLegajo, 
										  TipoNovedad tipoNovedad,
										  MotivoTipoNov motivo,
										  java.util.Date fecDesde,
										  java.util.Date fecHasta,
										  ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(Legajo.NICKNAME, aLegajo);
		condiciones.put(TipoNovedad.NICKNAME, tipoNovedad);
		condiciones.put(MotivoTipoNov.NICKNAME, motivo);
		condiciones.put("FECHA_DESDE", fecDesde);
		condiciones.put("FECHA_HASTA", fecHasta);
		return (List) ObjetoLogico.getObjects(
				NovedadLegajo.NICKNAME, 
				DBNovedadLegajo.SELECT_BY_TIPO_MOT_LEGAJO_ACT_FECHAS, 
				condiciones, 
				new ListObserver(), aSesion);
	}
	
	
	public static List getNovedadesLegajo(Legajo aLegajo, 
										  java.util.Date fecDesde,
										  java.util.Date fecHasta,
										  ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(Legajo.NICKNAME, aLegajo);
		condiciones.put("FECHA_DESDE", fecDesde);
		condiciones.put("FECHA_HASTA", fecHasta);
		return (List) ObjetoLogico.getObjects(
				NovedadLegajo.NICKNAME, 
				DBNovedadLegajo.SELECT_BY_LEG_FEC_DES_HAS, 
				condiciones, 
				new ListObserver(), aSesion);
	}
	
	public static List getNovedadesLegajoFecha(Legajo aLegajo, 
			  java.util.Date fecha,
			  ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(Legajo.NICKNAME, aLegajo);
		condiciones.put("FECHA", fecha);
		return (List) ObjetoLogico.getObjects(
				NovedadLegajo.NICKNAME, 
				DBNovedadLegajo.SELECT_BY_LEG_FEC, 
				condiciones, 
				new ListObserver(), aSesion);
	}	
	
	public static List getNovedadesLegajo(
			  Legajo aLegajo,
			  RankearCab rankearCab,
			  java.util.Date fecDesde,
			  java.util.Date fecHasta,
			  Integer nroNovedad,
			  ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(Legajo.NICKNAME, aLegajo);
		condiciones.put(RankearCab.NICKNAME, rankearCab);
		condiciones.put("FECHA_DESDE", fecDesde);
		condiciones.put("FECHA_HASTA", fecHasta);
		condiciones.put("NRO_NOVEDAD", nroNovedad);
		return (List) ObjetoLogico.getObjects(
				NovedadLegajo.NICKNAME, 
				DBNovedadLegajo.SELECT_BY_LEG_RANK_FEC_DES_HAS, 
				condiciones, 
				new ListObserver(), aSesion);
	}

}
