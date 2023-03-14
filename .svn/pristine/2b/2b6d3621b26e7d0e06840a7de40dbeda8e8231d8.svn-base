package com.srn.erp.rrhh.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.general.bm.PeriodoInc;
import com.srn.erp.general.bm.PeriodoIncDet;
import com.srn.erp.general.da.DBPeriodoIncDet;
import com.srn.erp.rrhh.bm.GrabarConsRotasCab;
import com.srn.erp.rrhh.bm.GrabarConsRotasDet;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;

public class DBGrabarConsRotasDet extends DBObjetoPersistente {

	public static final String OID_GRAB_CONS_DET = "oid_grab_cons_det";
	public static final String OID_GRAB_CONS_ROTA = "oid_grab_cons_rota";
	public static final String OID_LEGAJO = "oid_legajo";
	public static final String FECHA = "fecha";
	public static final String ROTA = "rota";
	public static final String OID_ROTA = "oid_rota";
	public static final String ACTIVO = "activo";
	
	public static final int SELECT_BY_CABECERA = 100;
	public static final int SELECT_BY_FECHA_ACTIVOS_USUARIO = 101;

	public DBGrabarConsRotasDet() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_GRAB_CONS_DET = 1;
		final int OID_GRAB_CONS_ROTA = 2;
		final int OID_LEGAJO = 3;
		final int FECHA = 4;
		final int ROTA = 5;
		final int OID_ROTA = 6;
		final int ACTIVO = 7;

		GrabarConsRotasDet pers = (GrabarConsRotasDet) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into dmGrabConsRotasDet " + " ( " + "OID_GRAB_CONS_DET," + "OID_GRAB_CONS_ROTA," + "OID_LEGAJO," + "FECHA," + "ROTA," + "OID_ROTA," + "ACTIVO)" + " values " + "("
				+ "?," + "?," + "?," + "?," + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_GRAB_CONS_DET, pers.getOID());
		qInsert.setInt(OID_GRAB_CONS_ROTA, pers.getGrab_cons_rota().getOID());
		qInsert.setInt(OID_LEGAJO, pers.getLegajo().getOID());
		qInsert.setDate(FECHA, new java.sql.Date(pers.getFecha().getTime()));
		qInsert.setString(ROTA, pers.getRota());
		if (pers.getTurno() != null)
			qInsert.setInt(OID_ROTA, pers.getTurno().getOID());
		else
			qInsert.setNull(OID_ROTA, java.sql.Types.INTEGER);
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_GRAB_CONS_ROTA = 1;
		final int OID_LEGAJO = 2;
		final int FECHA = 3;
		final int ROTA = 4;
		final int OID_ROTA = 5;
		final int ACTIVO = 6;
		final int OID_GRAB_CONS_DET = 7;

		GrabarConsRotasDet pers = (GrabarConsRotasDet) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update dmGrabConsRotasDet set " + "oid_grab_cons_rota=?" + ",oid_legajo=?" + ",fecha=?" + ",rota=?" + ",oid_rota=?" + ",activo=?" + " where " + " oid_grab_cons_det=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_GRAB_CONS_DET, pers.getOID());
		qUpdate.setInt(OID_GRAB_CONS_ROTA, pers.getGrab_cons_rota().getOID());
		qUpdate.setInt(OID_LEGAJO, pers.getLegajo().getOID());
		qUpdate.setDate(FECHA, new java.sql.Date(pers.getFecha().getTime()));
		qUpdate.setString(ROTA, pers.getRota());
		if (pers.getTurno() != null)
			qUpdate.setInt(OID_ROTA, pers.getTurno().getOID());
		else
			qUpdate.setNull(OID_ROTA, java.sql.Types.INTEGER);
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_GRAB_CONS_DET = 1;
		GrabarConsRotasDet pers = (GrabarConsRotasDet) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update dmGrabConsRotasDet " + " set activo=0 " + " where " + " oid_grab_cons_det=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_GRAB_CONS_DET, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_GRAB_CONS_DET = 1;
		GrabarConsRotasDet pers = (GrabarConsRotasDet) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update dmGrabConsRotasDet " + " set activo=1 " + " where " + " oid_grab_cons_det=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_GRAB_CONS_DET, pers.getOID());
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
		case SELECT_BY_CABECERA: {
			ps = this.selectByCabecera(aCondiciones);
			break;			
		}
		case SELECT_BY_FECHA_ACTIVOS_USUARIO: {
			ps = this.selectByFechaActivosUsuario(aCondiciones);
			break;			
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_GRAB_CONS_DET = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  dmGrabConsRotasDet ");
		textSQL.append(" WHERE oid_grab_cons_det = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_GRAB_CONS_DET, oid);
		return querySelect;
	}

	
	private PreparedStatement selectByCabecera(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  dmGrabConsRotasDet ");
		textSQL.append(" WHERE oid_grab_cons_rota  = ? and activo = 1  ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		GrabarConsRotasCab grabarConsRotasCab = (GrabarConsRotasCab) aCondiciones;
		querySelect.setInt(1, grabarConsRotasCab.getOID());
		return querySelect;
	}

	private PreparedStatement selectByFechaActivosUsuario(Object aCondiciones) throws BaseException, SQLException {

		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		Usuario usuario = (Usuario) condiciones.get(Usuario.NICKNAME);
		java.util.Date fecha = (java.util.Date) condiciones.get("FECHA");
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT a.* FROM  dmGrabConsRotasDet a , dmGRABCONSROTAS b ");
		textSQL.append(" WHERE  a.oid_grab_cons_rota = b.oid_grab_cons_rota and a.activo=1 and b.activo=1 and b.oid_usuario=? and b.fecha_grab=?");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		querySelect.setInt(1, usuario.getOID());
		querySelect.setDate(2, new java.sql.Date(fecha.getTime()));
		return querySelect;
	}	
	
	
	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  dmGrabConsRotasDet ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_grab_cons_det oid, codigo,  descripcion ,activo ");
		textSQL.append(" from dmGrabConsRotasDet");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}
	
	public static List getConsRotasDet(GrabarConsRotasCab grabarConsRotasCab,
              ISesion aSesion) throws BaseException {
		  return (List) ObjetoLogico.getObjects(GrabarConsRotasDet.NICKNAME,
                 DBGrabarConsRotasDet.SELECT_BY_CABECERA,
                 grabarConsRotasCab,
                 new ListObserver(),
                 aSesion);
	}
	
	public static List getConsRotasDetByUsuFecha(Usuario usuario,
												 java.util.Date fecha,
												 ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(Usuario.NICKNAME, usuario);
		condiciones.put("FECHA", fecha);
		return (List) ObjetoLogico.getObjects(GrabarConsRotasDet.NICKNAME,
                 DBGrabarConsRotasDet.SELECT_BY_FECHA_ACTIVOS_USUARIO,
                 condiciones,
                 new ListObserver(),
                 aSesion);
	}	

}
