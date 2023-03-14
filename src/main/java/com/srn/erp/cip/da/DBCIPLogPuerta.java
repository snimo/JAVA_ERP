package com.srn.erp.cip.da;

import java.sql.*;
import java.util.Date;
import java.util.List;

import com.srn.erp.cip.bm.CIPLogPuerta;
import com.srn.erp.cip.bm.Puerta;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.*;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.*;

public class DBCIPLogPuerta extends DBObjetoPersistente {

	public static final String OID_LOG_PUERTA = "oid_log_puerta";
	public static final String OID_PUERTA = "oid_puerta";
	public static final String FEC_HORA = "fec_hora";
	public static final String ESTADO = "estado";
	public static final String ACTIVO = "activo";
	
	private static final int SELECT_ALL_BY_PUERTA_FECHADESDE_FECHAHASTA = 100;

	public DBCIPLogPuerta() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_LOG_PUERTA = 1;
		final int OID_PUERTA = 2;
		final int FEC_HORA = 3;
		final int ESTADO = 4;
		final int ACTIVO = 5;

		CIPLogPuerta pers = (CIPLogPuerta) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into cipLogPuerta " + " ( " + "OID_LOG_PUERTA," + "OID_PUERTA," + "FEC_HORA," + "ESTADO," + "ACTIVO)" + " values " + "(" + "?," + "?," + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_LOG_PUERTA, pers.getOID());
		qInsert.setInt(OID_PUERTA, pers.getPuerta().getOID());
		qInsert.setTimestamp(FEC_HORA, new Timestamp(pers.getFechora().getTime()));
		qInsert.setString(ESTADO, pers.getEstado());
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_PUERTA = 1;
		final int FEC_HORA = 2;
		final int ESTADO = 3;
		final int ACTIVO = 4;
		final int OID_LOG_PUERTA = 5;

		CIPLogPuerta pers = (CIPLogPuerta) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update cipLogPuerta set " + "oid_puerta=?" + ",fec_hora=?" + ",estado=?" + ",activo=?" + " where " + " oid_log_puerta=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_LOG_PUERTA, pers.getOID());
		qUpdate.setInt(OID_PUERTA, pers.getPuerta().getOID());
		qUpdate.setTimestamp(FEC_HORA, new Timestamp(pers.getFechora().getTime()));
		qUpdate.setString(ESTADO, pers.getEstado());
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_LOG_PUERTA = 1;
		CIPLogPuerta pers = (CIPLogPuerta) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cipLogPuerta " + " set activo=0 " + " where " + " oid_log_puerta=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_LOG_PUERTA, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_LOG_PUERTA = 1;
		CIPLogPuerta pers = (CIPLogPuerta) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cipLogPuerta " + " set activo=1 " + " where " + " oid_log_puerta=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_LOG_PUERTA, pers.getOID());
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
		case IDBObjetoPersistente.SELECT_ALL_HELP: {
			ps = this.selectAllHelp(aCondiciones);
			break;
		}
		case SELECT_ALL_BY_PUERTA_FECHADESDE_FECHAHASTA: {
			ps = this.selectAllByPuertaFechaDesdeFechaHasta(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_LOG_PUERTA = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cipLogPuerta ");
		textSQL.append(" WHERE oid_log_puerta = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_LOG_PUERTA, oid);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_log_puerta oid, codigo,  descripcion ,activo ");
		textSQL.append(" from cipLogPuerta");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}
	
	private PreparedStatement selectAllByPuertaFechaDesdeFechaHasta(Object aCondiciones) throws BaseException, SQLException{
	    HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	    Puerta puerta = (Puerta) condiciones.get(Puerta.NICKNAME);
	    Date fechaDesde = (Date) condiciones.get("FECHA_DESDE");
	    Date fechaHasta = (Date) condiciones.get("FECHA_HASTA");
	    
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cipLogPuerta ");
		textSQL.append(" WHERE activo = 1 and oid_puerta = ? and fec_hora >=  ? and  fec_hora <= ? order by fec_hora");
		
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		querySelect.setInt(1, puerta.getOIDInteger());
		querySelect.setDate(2, new java.sql.Date(fechaDesde.getTime()));
		querySelect.setDate(3, new java.sql.Date(fechaHasta.getTime()));
		
		return querySelect;
	}

	public static List<CIPLogPuerta> getRegistrosByPuertaFechaDesdeFechaHasta(Puerta puerta, Date fechaDesde, Date fechaHasta, ISesion sesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(Puerta.NICKNAME, puerta);
		condiciones.put("FECHA_DESDE", fechaDesde);
		condiciones.put("FECHA_HASTA", fechaHasta);
	

		  return (List<CIPLogPuerta>) ObjetoLogico.getObjects(CIPLogPuerta.NICKNAME,
				  	DBCIPLogPuerta.SELECT_ALL_BY_PUERTA_FECHADESDE_FECHAHASTA,
	  				condiciones,
	  				new ListObserver(),
	  				sesion);

	}

}
