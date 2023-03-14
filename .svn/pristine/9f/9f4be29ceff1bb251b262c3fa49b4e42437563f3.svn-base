package com.srn.erp.turnos.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.turnos.bm.TableroEntidadTurnos;
import com.srn.erp.turnos.bm.TableroHorarioTurnos;
import com.srn.erp.turnos.bm.TableroTurnos;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBTableroHorarioTurnos extends DBObjetoPersistente {

	public static final String OID_TABLERO_HORARIO = "oid_tablero_horario";
	public static final String OID_TABLERO_CAB = "oid_tablero_cab";
	public static final String HORARIO = "horario";
	public static final String OID_TABLERO_ENTIDAD = "oid_tablero_entidad";

	public static final String HORA_DESDE_EN_MIN = "hora_desde_en_min";
	public static final String HORA_HASTA_EN_MIN = "hora_hasta_en_min";

	public static final int SELECT_BY_TABLERO_ENTIDAD = 100;
	public static final int SELECT_BY_TABLERO_ENTIDAD_HORARIO = 101;
	public static final int SELECT_BY_TABLERO_ENTIDAD_LIBRE = 102;
	public static final int SELECT_BY_TABLERO_ENTIDAD_HOR_ACT = 103;
	public static final int SELECT_BY_PROX_HORARIO = 104;

	public DBTableroHorarioTurnos() {
	}

	protected void insert(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {

		final int OID_TABLERO_HORARIO = 1;
		final int OID_TABLERO_CAB = 2;
		final int HORARIO = 3;
		final int OID_TABLERO_ENTIDAD = 4;
		final int HORA_DESDE_EN_MIN = 5;
		final int HORA_HASTA_EN_MIN = 6;

		TableroHorarioTurnos pers = (TableroHorarioTurnos) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into tuTableroHorario " + " ( "
				+ "OID_TABLERO_HORARIO," + "OID_TABLERO_CAB," + "HORARIO,"
				+ "OID_TABLERO_ENTIDAD,HORA_DESDE_EN_MIN,HORA_HASTA_EN_MIN)"
				+ " values " + "(" + "?," + "?," + "?," + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD()
				.prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_TABLERO_HORARIO, pers.getOID());
		qInsert.setInt(OID_TABLERO_CAB, pers.getTablero().getOID());
		qInsert.setString(HORARIO, pers.getHorario());
		qInsert.setInt(OID_TABLERO_ENTIDAD, pers.getEntidad_tablero().getOID());
		qInsert.setInt(HORA_DESDE_EN_MIN, pers.getHoraDesdeEnMinutos());
		qInsert.setInt(HORA_HASTA_EN_MIN, pers.getHoraHastaEnMinutos());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {

		final int OID_TABLERO_CAB = 1;
		final int HORARIO = 2;
		final int OID_TABLERO_ENTIDAD = 3;
		final int HORA_DESDE_EN_MIN = 4;
		final int HORA_HASTA_EN_MIN = 5;
		final int OID_TABLERO_HORARIO = 6;

		TableroHorarioTurnos pers = (TableroHorarioTurnos) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update tuTableroHorario set " + "oid_tablero_cab=?"
				+ ",horario=?" + ",oid_tablero_entidad=?"
				+ ",hora_desde_en_min=?" + ",hora_hasta_en_min=?" + " where "
				+ " oid_tablero_horario=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_TABLERO_HORARIO, pers.getOID());
		qUpdate.setInt(OID_TABLERO_CAB, pers.getTablero().getOID());
		qUpdate.setString(HORARIO, pers.getHorario());
		qUpdate.setInt(OID_TABLERO_ENTIDAD, pers.getEntidad_tablero().getOID());
		qUpdate.setInt(HORA_DESDE_EN_MIN, pers.getHoraDesdeEnMinutos());
		qUpdate.setInt(HORA_HASTA_EN_MIN, pers.getHoraHastaEnMinutos());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {
		final int OID_TABLERO_HORARIO = 1;
		TableroHorarioTurnos pers = (TableroHorarioTurnos) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("delete from tuTableroHorario "
				+ " where " + " oid_tablero_horario=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_TABLERO_HORARIO, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {
		final int OID_TABLERO_HORARIO = 1;
		TableroHorarioTurnos pers = (TableroHorarioTurnos) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update tuTableroHorario " + " set activo=1 "
				+ " where " + " oid_tablero_horario=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_TABLERO_HORARIO, pers.getOID());
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
		case SELECT_BY_TABLERO_ENTIDAD: {
			ps = this.selectByTableroEntidad(aCondiciones);
			break;
		}
		case SELECT_BY_TABLERO_ENTIDAD_HORARIO: {
			ps = this.selectByTableroEntidadHorario(aCondiciones);
			break;
		}
		case SELECT_BY_TABLERO_ENTIDAD_LIBRE: {
			ps = this.selectByTableroEntidadLibre(aCondiciones);
			break;
		}
		case SELECT_BY_TABLERO_ENTIDAD_HOR_ACT: {
			ps = this.selectByTableroEntidadHorActivos(aCondiciones);
			break;
		}
		case SELECT_BY_PROX_HORARIO: {
			ps = this.selectByProxHorario(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones)
			throws BaseException, SQLException {

		final int OID_TABLERO_HORARIO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  tuTableroHorario ");
		textSQL.append(" WHERE oid_tablero_horario = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_TABLERO_HORARIO, oid);
		return querySelect;
	}

	private PreparedStatement selectByTableroEntidad(Object aCondiciones)
			throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  tuTableroHorario ");
		textSQL
				.append(" WHERE oid_tablero_cab = ? and oid_tablero_entidad = ? order by horario");

		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		TableroTurnos tablero = (TableroTurnos) condiciones
				.get(TableroTurnos.NICKNAME);
		TableroEntidadTurnos tableroEntidad = (TableroEntidadTurnos) condiciones
				.get(TableroEntidadTurnos.NICKNAME);
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		querySelect.setInt(1, tablero.getOID());
		querySelect.setInt(2, tableroEntidad.getOID());

		return querySelect;
	}
	
	
	
	private PreparedStatement selectByTableroEntidadHorActivos(Object aCondiciones)
	throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  tuTableroHorario ");
		textSQL.append(" WHERE oid_tablero_cab = ? and oid_tablero_entidad = ? ");
		int horaActualEnMinutos = (Fecha.getHora()*60)+Fecha.getMinutos();
		textSQL.append(" and hora_hasta_en_min>"+horaActualEnMinutos+ " order by horario");
		

		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		TableroTurnos tablero = (TableroTurnos) condiciones.get(TableroTurnos.NICKNAME);
		TableroEntidadTurnos tableroEntidad = (TableroEntidadTurnos) condiciones.get(TableroEntidadTurnos.NICKNAME);
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		querySelect.setInt(1, tablero.getOID());
		querySelect.setInt(2, tableroEntidad.getOID());
		
		return querySelect;
	}
	
	
	
	private PreparedStatement selectByProxHorario(Object aCondiciones)
	throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  tuTableroHorario ");
		textSQL.append(" WHERE oid_tablero_cab = ? and oid_tablero_entidad = ? and hora_desde_en_min=? ");


		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		TableroTurnos tablero = (TableroTurnos) condiciones.get(TableroTurnos.NICKNAME);
		TableroEntidadTurnos tableroEntidad = (TableroEntidadTurnos) condiciones.get(TableroEntidadTurnos.NICKNAME);
		Integer horaDesdeEnMin = (Integer) condiciones.get("HORA_DESDE_EN_MIN");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		querySelect.setInt(1, tablero.getOID());
		querySelect.setInt(2, tableroEntidad.getOID());
		querySelect.setInt(3, horaDesdeEnMin.intValue());

		return querySelect;
	}
	

	private PreparedStatement selectByTableroEntidadLibre(Object aCondiciones)
			throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  tuTableroHorario ");
		textSQL.append(" WHERE oid_tablero_cab = ? and oid_tablero_entidad = ? ");
		int horaActualEnMinutos = (Fecha.getHora()*60)+Fecha.getMinutos();
		textSQL.append(" and hora_hasta_en_min>"+horaActualEnMinutos+"  ");
		textSQL.append(" and oid_tablero_horario not in (select oid_tablero_horario from tuReservaTablero where oid_tablero_cab = ? and oid_tablero_entidad = ?) order by horario");
		

		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		TableroTurnos tablero = (TableroTurnos) condiciones.get(TableroTurnos.NICKNAME);
		TableroEntidadTurnos tableroEntidad = (TableroEntidadTurnos) condiciones.get(TableroEntidadTurnos.NICKNAME);
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		querySelect.setInt(1, tablero.getOID());
		querySelect.setInt(2, tableroEntidad.getOID());
		querySelect.setInt(3, tablero.getOID());
		querySelect.setInt(4, tableroEntidad.getOID());		

		return querySelect;
	}

	private PreparedStatement selectByTableroEntidadHorario(Object aCondiciones)
			throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  tuTableroHorario ");
		textSQL
				.append(" WHERE oid_tablero_cab = ? and oid_tablero_entidad = ? and horario = ? order by horario");

		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		TableroTurnos tablero = (TableroTurnos) condiciones
				.get(TableroTurnos.NICKNAME);
		TableroEntidadTurnos tableroEntidad = (TableroEntidadTurnos) condiciones
				.get(TableroEntidadTurnos.NICKNAME);
		String horario = (String) condiciones.get("HORARIO");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		querySelect.setInt(1, tablero.getOID());
		querySelect.setInt(2, tableroEntidad.getOID());
		querySelect.setString(3, horario);

		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones)
			throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  tuTableroHorario ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones)
			throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL
				.append("SELECT oid_tablero_horario oid, codigo,  descripcion ,activo ");
		textSQL.append(" from tuTableroHorario");

		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static List getHorarios(TableroTurnos tablero,
			TableroEntidadTurnos tableroEntidad, ISesion aSesion)
			throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(TableroTurnos.NICKNAME, tablero);
		condiciones.put(TableroEntidadTurnos.NICKNAME, tableroEntidad);

		return (List) ObjetoLogico.getObjects(TableroHorarioTurnos.NICKNAME,
				DBTableroHorarioTurnos.SELECT_BY_TABLERO_ENTIDAD, condiciones,
				new ListObserver(), aSesion);
	}
	
	public static List getHorariosLibres(TableroTurnos tablero,
			TableroEntidadTurnos tableroEntidad, ISesion aSesion)
			throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(TableroTurnos.NICKNAME, tablero);
		condiciones.put(TableroEntidadTurnos.NICKNAME, tableroEntidad);

		return (List) ObjetoLogico.getObjects(TableroHorarioTurnos.NICKNAME,
				DBTableroHorarioTurnos.SELECT_BY_TABLERO_ENTIDAD_LIBRE, condiciones,
				new ListObserver(), aSesion);
	}
	
	public static List getHorariosActivos(TableroTurnos tablero,
			TableroEntidadTurnos tableroEntidad, ISesion aSesion)
			throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(TableroTurnos.NICKNAME, tablero);
		condiciones.put(TableroEntidadTurnos.NICKNAME, tableroEntidad);

		return (List) ObjetoLogico.getObjects(TableroHorarioTurnos.NICKNAME,
				DBTableroHorarioTurnos.SELECT_BY_TABLERO_ENTIDAD_HOR_ACT, condiciones,
				new ListObserver(), aSesion);
	}
	
	

	public static TableroHorarioTurnos getHorario(TableroTurnos tablero,
			TableroEntidadTurnos entidadTurno, String horario, ISesion aSesion)
			throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(TableroTurnos.NICKNAME, tablero);
		condiciones.put(TableroEntidadTurnos.NICKNAME, entidadTurno);
		condiciones.put("HORARIO", horario);
		return (TableroHorarioTurnos) ObjetoLogico.getObjects(
				TableroHorarioTurnos.NICKNAME,
				DBTableroHorarioTurnos.SELECT_BY_TABLERO_ENTIDAD_HORARIO,
				condiciones, new ObjetoObservado(), aSesion);
	}
	
	public static TableroHorarioTurnos getProximoHorario(
			TableroTurnos tablero,
			TableroEntidadTurnos entidadTurno, 
			Integer horaDesdeEnMin, ISesion aSesion)
			throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(TableroTurnos.NICKNAME, tablero);
		condiciones.put(TableroEntidadTurnos.NICKNAME, entidadTurno);
		condiciones.put("HORA_DESDE_EN_MIN", horaDesdeEnMin);
		return (TableroHorarioTurnos) ObjetoLogico.getObjects(
				TableroHorarioTurnos.NICKNAME,
				DBTableroHorarioTurnos.SELECT_BY_PROX_HORARIO,
				condiciones, new ObjetoObservado(), aSesion);
	}
	

}
