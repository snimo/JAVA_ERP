package com.srn.erp.turnos.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.turnos.bm.ReservaTableroTurno;
import com.srn.erp.turnos.bm.TableroEntidadTurnos;
import com.srn.erp.turnos.bm.TableroHorarioTurnos;
import com.srn.erp.turnos.bm.TableroTurnos;
import com.srn.erp.ventas.bm.Sujeto;

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

public class DBReservaTableroTurno extends DBObjetoPersistente {

	public static final String OID_RESERVA = "oid_reserva";
	public static final String OID_TABLERO_CAB = "oid_tablero_cab";
	public static final String OID_TABLERO_ENTIDAD = "oid_tablero_entidad";
	public static final String OID_TABLERO_HORARIO = "oid_tablero_horario";
	public static final String OID_MOTIVO = "oid_motivo";
	public static final String OID_SUJETO_1 = "oid_sujeto_1";
	public static final String OID_SUJETO_2 = "oid_sujeto_2";
	public static final String OID_SUJETO_3 = "oid_sujeto_3";
	public static final String OID_SUJETO_4 = "oid_sujeto_4";
	public static final String COMPO_TIPO_RES = "compo_tipo_res";
	public static final String DESC_1 = "desc_1";
	public static final String DESC_2 = "desc_2";
	public static final String DESC_3 = "desc_3";
	public static final String DESC_4 = "desc_4";
	public static final String COMENTARIO = "comentario";
	
	public static final String INVITADO_1 = "invitado_1";
	public static final String INVITADO_2 = "invitado_2";
	public static final String INVITADO_3 = "invitado_3";
	public static final String INVITADO_4 = "invitado_4";
	
	public static final String AUTORIZ_1 = "autoriz_1";
	public static final String AUTORIZ_2 = "autoriz_2";
	public static final String AUTORIZ_3 = "autoriz_3";
	public static final String AUTORIZ_4 = "autoriz_4";
	
	public static final String REGLA_ACT_1 = "regla_act_1";
	public static final String REGLA_ACT_2 = "regla_act_2";
	public static final String REGLA_ACT_3 = "regla_act_3";
	public static final String REGLA_ACT_4 = "regla_act_4";
	

	public static final int SELECT_BY_TABLERO = 100;
	public static final int SELECT_BY_TABLERO_ENTIDAD = 101;
	public static final int SELECT_BY_TABLERO_ENTIDAD_HORARIO = 102;
	public static final int SELECT_BY_RESERVAS_ACTIVAS_SUJETO = 103;
	public static final int SELECT_BY_RES_ACTIVAS_SUJETO_MENOS_RES = 104;
	public static final int SELECT_BY_ESTADISTICA_TURNOS = 105;
	public static final int SELECT_BY_TABLERO_SUJETO = 106;
	

	public DBReservaTableroTurno() {
	}

	protected void insert(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {

		final int OID_RESERVA = 1;
		final int OID_TABLERO_CAB = 2;
		final int OID_TABLERO_ENTIDAD = 3;
		final int OID_TABLERO_HORARIO = 4;
		final int OID_MOTIVO = 5;
		final int OID_SUJETO_1 = 6;
		final int OID_SUJETO_2 = 7;
		final int OID_SUJETO_3 = 8;
		final int OID_SUJETO_4 = 9;
		final int COMPO_TIPO_RES = 10;
		final int DESC_1 = 11;
		final int DESC_2 = 12;
		final int DESC_3 = 13;
		final int DESC_4 = 14;
		final int COMENTARIO = 15;
		final int INVITADO_1 = 16;
		final int INVITADO_2 = 17;
		final int INVITADO_3 = 18;
		final int INVITADO_4 = 19;
		final int AUTORIZ_1 = 20;
		final int AUTORIZ_2 = 21;
		final int AUTORIZ_3 = 22;
		final int AUTORIZ_4 = 23;
		final int REGLA_ACT_1 = 24;
		final int REGLA_ACT_2 = 25;
		final int REGLA_ACT_3 = 26;
		final int REGLA_ACT_4 = 27;

		ReservaTableroTurno pers = (ReservaTableroTurno) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into tuReservaTablero " + " ( "
				+ "OID_RESERVA," + "OID_TABLERO_CAB," + "OID_TABLERO_ENTIDAD,"
				+ "OID_TABLERO_HORARIO," + "OID_MOTIVO," + "OID_SUJETO_1,"
				+ "OID_SUJETO_2," + "OID_SUJETO_3," + "OID_SUJETO_4,"
				+ "COMPO_TIPO_RES," + "DESC_1," + "DESC_2," + "DESC_3,"
				+ "DESC_4," + "COMENTARIO , INVITADO_1,INVITADO_2,INVITADO_3,INVITADO_4," +
				"AUTORIZ_1,AUTORIZ_2,AUTORIZ_3,AUTORIZ_4,REGLA_ACT_1,REGLA_ACT_2,REGLA_ACT_3,REGLA_ACT_4) "+
				" values " + "(" + "?," + "?,"+ "?,"+ "?,"+ "?,"+ "?,"+ "?,"+ "?,"+ "?,"+ "?,"
				+ "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?,"+ "?,"+ "?,"+ "?,"+ "?,"
				+ "?," + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD()
				.prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_RESERVA, pers.getOID());
		qInsert.setInt(OID_TABLERO_CAB, pers.getTablero().getOID());
		qInsert.setInt(OID_TABLERO_ENTIDAD, pers.getEntidad_tablero().getOID());
		qInsert.setInt(OID_TABLERO_HORARIO, pers.getHorario_tablero().getOID());
		if (pers.getMotivo() != null)
			qInsert.setInt(OID_MOTIVO, pers.getMotivo().getOID());
		else
			qInsert.setNull(OID_MOTIVO, java.sql.Types.INTEGER);
		if (pers.getSujeto1() != null)
			qInsert.setInt(OID_SUJETO_1, pers.getSujeto1().getOID());
		else
			qInsert.setNull(OID_SUJETO_1, java.sql.Types.INTEGER);
		if (pers.getSujeto2() != null)
			qInsert.setInt(OID_SUJETO_2, pers.getSujeto2().getOID());
		else
			qInsert.setNull(OID_SUJETO_2, java.sql.Types.INTEGER);
		if (pers.getSujeto3() != null)
			qInsert.setInt(OID_SUJETO_3, pers.getSujeto3().getOID());
		else
			qInsert.setNull(OID_SUJETO_3, java.sql.Types.INTEGER);
		if (pers.getSujeto4() != null)
			qInsert.setInt(OID_SUJETO_4, pers.getSujeto4().getOID());
		else
			qInsert.setNull(OID_SUJETO_4, java.sql.Types.INTEGER);
		qInsert.setString(COMPO_TIPO_RES, pers.getCompo_tipo_res());
		qInsert.setString(DESC_1, pers.getDesc_1());
		qInsert.setString(DESC_2, pers.getDesc_2());
		qInsert.setString(DESC_3, pers.getDesc_3());
		qInsert.setString(DESC_4, pers.getDesc_4());
		qInsert.setString(COMENTARIO, pers.getComentario());
		
		qInsert.setBoolean(INVITADO_1, pers.isInvitado1());
		qInsert.setBoolean(INVITADO_2, pers.isInvitado2());
		qInsert.setBoolean(INVITADO_3, pers.isInvitado3());
		qInsert.setBoolean(INVITADO_4, pers.isInvitado4());
		
		qInsert.setBoolean(AUTORIZ_1, pers.isAutorizado1());
		qInsert.setBoolean(AUTORIZ_2, pers.isAutorizado2());
		qInsert.setBoolean(AUTORIZ_3, pers.isAutorizado3());
		qInsert.setBoolean(AUTORIZ_4, pers.isAutorizado4());
		
		qInsert.setBoolean(REGLA_ACT_1, pers.isReglaAct1());
		qInsert.setBoolean(REGLA_ACT_2, pers.isReglaAct2());
		qInsert.setBoolean(REGLA_ACT_3, pers.isReglaAct3());
		qInsert.setBoolean(REGLA_ACT_4, pers.isReglaAct4());
		
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {

		final int OID_TABLERO_CAB = 1;
		final int OID_TABLERO_ENTIDAD = 2;
		final int OID_TABLERO_HORARIO = 3;
		final int OID_MOTIVO = 4;
		final int OID_SUJETO_1 = 5;
		final int OID_SUJETO_2 = 6;
		final int OID_SUJETO_3 = 7;
		final int OID_SUJETO_4 = 8;
		final int COMPO_TIPO_RES = 9;
		final int DESC_1 = 10;
		final int DESC_2 = 11;
		final int DESC_3 = 12;
		final int DESC_4 = 13;
		final int COMENTARIO = 14;
		
		final int INVITADO_1 = 15;
		final int INVITADO_2 = 16;
		final int INVITADO_3 = 17;
		final int INVITADO_4 = 18;
		
		final int AUTORIZ_1 = 19;
		final int AUTORIZ_2 = 20;
		final int AUTORIZ_3 = 21;
		final int AUTORIZ_4 = 22;
		final int REGLA_ACT_1 = 23;
		final int REGLA_ACT_2 = 24;
		final int REGLA_ACT_3 = 25;
		final int REGLA_ACT_4 = 26;
		
		final int OID_RESERVA = 27;

		ReservaTableroTurno pers = (ReservaTableroTurno) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update tuReservaTablero set " + "oid_tablero_cab=?"
				+ ",oid_tablero_entidad=?" + ",oid_tablero_horario=?"
				+ ",oid_motivo=?" + ",oid_sujeto_1=?" + ",oid_sujeto_2=?"
				+ ",oid_sujeto_3=?" + ",oid_sujeto_4=?" + ",compo_tipo_res=?"
				+ ",desc_1=?" + ",desc_2=?" + ",desc_3=?" + ",desc_4=?"
				+ ",comentario=? , invitado_1 = ? ,invitado_2 = ? , invitado_3 = ? , invitado_4 = ? ,"+
				"autoriz_1=?,autoriz_2=?,autoriz_3=?,autoriz_4=?,regla_act_1=?,regla_act_2=?,regla_act_3=?,regla_act_4=? "
				+ " where " + " oid_reserva=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_RESERVA, pers.getOID());
		qUpdate.setInt(OID_TABLERO_CAB, pers.getTablero().getOID());
		qUpdate.setInt(OID_TABLERO_ENTIDAD, pers.getEntidad_tablero().getOID());
		qUpdate.setInt(OID_TABLERO_HORARIO, pers.getHorario_tablero().getOID());
		if (pers.getMotivo() != null)
			qUpdate.setInt(OID_MOTIVO, pers.getMotivo().getOID());
		else
			qUpdate.setNull(OID_MOTIVO, java.sql.Types.INTEGER);
		if (pers.getSujeto1() != null)
			qUpdate.setInt(OID_SUJETO_1, pers.getSujeto1().getOID());
		else
			qUpdate.setNull(OID_SUJETO_1, java.sql.Types.INTEGER);
		if (pers.getSujeto2() != null)
			qUpdate.setInt(OID_SUJETO_2, pers.getSujeto2().getOID());
		else
			qUpdate.setNull(OID_SUJETO_2, java.sql.Types.INTEGER);
		if (pers.getSujeto3() != null)
			qUpdate.setInt(OID_SUJETO_3, pers.getSujeto3().getOID());
		else
			qUpdate.setNull(OID_SUJETO_3, java.sql.Types.INTEGER);
		if (pers.getSujeto4() != null)
			qUpdate.setInt(OID_SUJETO_4, pers.getSujeto4().getOID());
		else
			qUpdate.setNull(OID_SUJETO_4, java.sql.Types.INTEGER);
		qUpdate.setString(COMPO_TIPO_RES, pers.getCompo_tipo_res());
		qUpdate.setString(DESC_1, pers.getDesc_1());
		qUpdate.setString(DESC_2, pers.getDesc_2());
		qUpdate.setString(DESC_3, pers.getDesc_3());
		qUpdate.setString(DESC_4, pers.getDesc_4());
		qUpdate.setString(COMENTARIO, pers.getComentario());
		
		qUpdate.setBoolean(INVITADO_1, pers.isInvitado1());
		qUpdate.setBoolean(INVITADO_2, pers.isInvitado2());
		qUpdate.setBoolean(INVITADO_3, pers.isInvitado3());
		qUpdate.setBoolean(INVITADO_4, pers.isInvitado4());
		
		qUpdate.setBoolean(AUTORIZ_1, pers.isAutorizado1());
		qUpdate.setBoolean(AUTORIZ_2, pers.isAutorizado2());
		qUpdate.setBoolean(AUTORIZ_3, pers.isAutorizado3());
		qUpdate.setBoolean(AUTORIZ_4, pers.isAutorizado4());
		
		qUpdate.setBoolean(REGLA_ACT_1, pers.isReglaAct1());
		qUpdate.setBoolean(REGLA_ACT_2, pers.isReglaAct2());
		qUpdate.setBoolean(REGLA_ACT_3, pers.isReglaAct3());
		qUpdate.setBoolean(REGLA_ACT_4, pers.isReglaAct4());
		
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {
		final int OID_RESERVA = 1;
		ReservaTableroTurno pers = (ReservaTableroTurno) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("delete from tuReservaTablero " + " where "
				+ " oid_reserva=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		try {
			qUpdate.setInt(OID_RESERVA, pers.getOID());
		}
		catch(Exception e) {
			qUpdate.setInt(OID_RESERVA, -1);
		}
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {
		final int OID_RESERVA = 1;
		ReservaTableroTurno pers = (ReservaTableroTurno) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update tuReservaTablero " + " set activo=1 "
				+ " where " + " oid_reserva=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_RESERVA, pers.getOID());
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
		case SELECT_BY_TABLERO: {
			ps = this.selectByTablero(aCondiciones);
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
		case SELECT_BY_RESERVAS_ACTIVAS_SUJETO: {
			ps = this.selectByReservasActivasSujeto(aCondiciones);
			break;
		}
		case SELECT_BY_RES_ACTIVAS_SUJETO_MENOS_RES: {
			ps = this.selectByReservasActivasSujetoMenosReserva(aCondiciones);
			break;
		}
		case SELECT_BY_ESTADISTICA_TURNOS : {
			ps = this.selectByEstadisticaTurnos(aCondiciones);
			break;
		}
		case SELECT_BY_TABLERO_SUJETO: {
			ps = this.selectByTableroSujeto(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones)
			throws BaseException, SQLException {

		final int OID_RESERVA = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  tuReservaTablero ");
		textSQL.append(" WHERE oid_reserva = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_RESERVA, oid);
		return querySelect;
	}
	
			
	private PreparedStatement selectByEstadisticaTurnos(Object aCondiciones)
			throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  tuReservaTablero ");
		textSQL.append(" WHERE oid_tablero_cab in (select oid_tablero_cab from tuTableroCab where fecha>=? and fecha<=? and comportamiento=?) ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		java.util.Date fechaDesde = (java.util.Date) condiciones.get("FECHA_DESDE");
		java.util.Date fechaHasta = (java.util.Date) condiciones.get("FECHA_HASTA");
		String comportamiento = (String) condiciones.get("COMPORTAMIENTO");
		
		querySelect.setDate(1, new java.sql.Date(fechaDesde.getTime()));
		querySelect.setDate(2, new java.sql.Date(fechaHasta.getTime()));
		querySelect.setString(3, comportamiento);
		
		return querySelect;
	}
	
	private PreparedStatement selectByTableroSujeto(Object aCondiciones)
		throws BaseException, SQLException {
		
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  tuReservaTablero ");
		textSQL.append(" WHERE oid_tablero_cab = ? and (oid_sujeto_1=? or oid_sujeto_2=? or oid_sujeto_3=? or oid_sujeto_4=?)");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		TableroTurnos tablero = (TableroTurnos) condiciones.get(TableroTurnos.NICKNAME);
		Sujeto sujeto = (Sujeto) condiciones.get(Sujeto.NICKNAME);
		querySelect.setInt(1, tablero.getOID());
		querySelect.setInt(2, sujeto.getOID());
		querySelect.setInt(3, sujeto.getOID());
		querySelect.setInt(4, sujeto.getOID());
		querySelect.setInt(5, sujeto.getOID());
		
		return querySelect;
}
	
			

	private PreparedStatement selectByTablero(Object aCondiciones)
			throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  tuReservaTablero ");
		textSQL.append(" WHERE oid_tablero_cab = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		TableroTurnos tablero = (TableroTurnos) aCondiciones;
		querySelect.setInt(1, tablero.getOID());
		return querySelect;
	}

	private PreparedStatement selectByReservasActivasSujeto(Object aCondiciones)
			throws BaseException, SQLException {
		
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		Sujeto sujeto = (Sujeto) condiciones.get(Sujeto.NICKNAME);
		TableroTurnos tablero = (TableroTurnos) condiciones.get(TableroTurnos.NICKNAME);
		
		
		StringBuffer textSQL = new StringBuffer();
		textSQL.append(" SELECT * FROM  tuReservaTablero a , tuTableroHorario b ");
		textSQL.append(" WHERE a.oid_tablero_horario = b.oid_tablero_horario and a.oid_tablero_cab = ?  ");
		textSQL.append(" and ( a.oid_sujeto_1="+sujeto.getOIDInteger()+" or "); 
		textSQL.append(" 	   a.oid_sujeto_2="+sujeto.getOIDInteger()+" or ");
		textSQL.append(" 	   a.oid_sujeto_3="+sujeto.getOIDInteger()+" or ");
		textSQL.append(" 	   a.oid_sujeto_4="+sujeto.getOIDInteger()+" ) ");
		
		int horaActualEnMinutos = (Fecha.getHora()*60)+Fecha.getMinutos();
		textSQL.append(" 	   and b.hora_hasta_en_min>"+horaActualEnMinutos+"  ");
		
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		
		
		querySelect.setInt(1, tablero.getOID());
		return querySelect;
	}
	
	private PreparedStatement selectByReservasActivasSujetoMenosReserva(Object aCondiciones)
	throws BaseException, SQLException {

		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		Sujeto sujeto = (Sujeto) condiciones.get(Sujeto.NICKNAME);
		TableroTurnos tablero = (TableroTurnos) condiciones.get(TableroTurnos.NICKNAME);
		ReservaTableroTurno reserva = (ReservaTableroTurno) condiciones.get(ReservaTableroTurno.NICKNAME);


		StringBuffer textSQL = new StringBuffer();
		textSQL.append(" SELECT * FROM  tuReservaTablero a , tuTableroHorario b ");
		textSQL.append(" WHERE a.oid_tablero_horario = b.oid_tablero_horario and a.oid_tablero_cab = ?  ");
		textSQL.append(" and ( a.oid_sujeto_1="+sujeto.getOIDInteger()+" or "); 
		textSQL.append(" 	   a.oid_sujeto_2="+sujeto.getOIDInteger()+" or ");
		textSQL.append(" 	   a.oid_sujeto_3="+sujeto.getOIDInteger()+" or ");
		textSQL.append(" 	   a.oid_sujeto_4="+sujeto.getOIDInteger()+" ) ");
	
		int horaActualEnMinutos = (Fecha.getHora()*60)+Fecha.getMinutos();
		textSQL.append(" 	   and b.hora_hasta_en_min>"+horaActualEnMinutos+"  ");
		if (reserva!=null)
			textSQL.append(" 	   and a.oid_reserva<>"+reserva.getOIDInteger()+"  ");
		
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		
		
		querySelect.setInt(1, tablero.getOID());
		return querySelect;
}
	
	
	
	private PreparedStatement selectByTableroEntidad(Object aCondiciones)
			throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  tuReservaTablero ");
		textSQL.append(" WHERE oid_tablero_cab = ? and oid_tablero_entidad = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		TableroTurnos tablero = (TableroTurnos) condiciones.get(TableroTurnos.NICKNAME);
		TableroEntidadTurnos tableroEntidad = (TableroEntidadTurnos) condiciones.get(TableroEntidadTurnos.NICKNAME);
		querySelect.setInt(1, tablero.getOID());
		querySelect.setInt(2, tableroEntidad.getOID());
		return querySelect;
	}

	private PreparedStatement selectByTableroEntidadHorario(Object aCondiciones)
			throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  tuReservaTablero ");
		textSQL.append(" WHERE oid_tablero_cab = ? and oid_tablero_entidad = ? and oid_tablero_horario = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		TableroTurnos tablero = (TableroTurnos) condiciones.get(TableroTurnos.NICKNAME);
		TableroEntidadTurnos tableroEntidad = (TableroEntidadTurnos) condiciones.get(TableroEntidadTurnos.NICKNAME);
		TableroHorarioTurnos tableroHorario = (TableroHorarioTurnos) condiciones.get(TableroHorarioTurnos.NICKNAME);

		querySelect.setInt(1, tablero.getOID());
		querySelect.setInt(2, tableroEntidad.getOID());
		querySelect.setInt(3, tableroHorario.getOID());
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones)
			throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  tuReservaTablero ");
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

		textSQL.append("SELECT oid_reserva oid, codigo,  descripcion ,activo ");
		textSQL.append(" from tuReservaTablero");

		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static List getReservasTablero(TableroTurnos tablero, ISesion aSesion)
			throws BaseException {
		return (List) ObjetoLogico.getObjects(ReservaTableroTurno.NICKNAME,
				DBReservaTableroTurno.SELECT_BY_TABLERO, tablero,
				new ListObserver(), aSesion);
	}

	public static List getReservasTableroEnEntidad(TableroTurnos tablero,
			TableroEntidadTurnos tableroEntidad, ISesion aSesion)
			throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(TableroTurnos.NICKNAME, tablero);
		condiciones.put(TableroEntidadTurnos.NICKNAME, tableroEntidad);

		return (List) ObjetoLogico.getObjects(ReservaTableroTurno.NICKNAME,
				DBReservaTableroTurno.SELECT_BY_TABLERO_ENTIDAD, condiciones,
				new ListObserver(), aSesion);
	}
	
	public static List getReservasActivasSujeto(TableroTurnos tablero,
			Sujeto sujeto, ISesion aSesion)
			throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(TableroTurnos.NICKNAME, tablero);
		condiciones.put(Sujeto.NICKNAME, sujeto);

		return (List) ObjetoLogico.getObjects(ReservaTableroTurno.NICKNAME,
				DBReservaTableroTurno.SELECT_BY_RESERVAS_ACTIVAS_SUJETO, 
				condiciones,
				new ListObserver(), aSesion);
	}
	
	public static List getReservasActivasSujetoMenosReserva(TableroTurnos tablero,
			Sujeto sujeto, ReservaTableroTurno reserva, ISesion aSesion)
			throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(TableroTurnos.NICKNAME, tablero);
		condiciones.put(Sujeto.NICKNAME, sujeto);
		if (reserva!=null)
			condiciones.put(ReservaTableroTurno.NICKNAME, reserva);

		return (List) ObjetoLogico.getObjects(ReservaTableroTurno.NICKNAME,
				DBReservaTableroTurno.SELECT_BY_RES_ACTIVAS_SUJETO_MENOS_RES, 
				condiciones,
				new ListObserver(), aSesion);
	}
	
	public static List getEstadisticas(
			java.util.Date fechaDesde,
			java.util.Date fechaHasta,
			String comportamiento, ISesion aSesion)
			throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put("FECHA_DESDE", fechaDesde);
		condiciones.put("FECHA_HASTA", fechaHasta);
		condiciones.put("COMPORTAMIENTO", comportamiento);
		
		return (List) ObjetoLogico.getObjects(ReservaTableroTurno.NICKNAME,
				DBReservaTableroTurno.SELECT_BY_ESTADISTICA_TURNOS, 
				condiciones,
				new ListObserver(), aSesion);
	}
	
	
	

	public static ReservaTableroTurno getReserva(TableroTurnos tablero,
			TableroEntidadTurnos tableroEntidad,
			TableroHorarioTurnos tableroHorarios, ISesion aSesion)
			throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(TableroTurnos.NICKNAME, tablero);
		condiciones.put(TableroEntidadTurnos.NICKNAME, tableroEntidad);
		condiciones.put(TableroHorarioTurnos.NICKNAME, tableroHorarios);

		return (ReservaTableroTurno) ObjetoLogico.getObjects(
				ReservaTableroTurno.NICKNAME,
				DBReservaTableroTurno.SELECT_BY_TABLERO_ENTIDAD_HORARIO,
				condiciones, new ObjetoObservado(), aSesion);
	}
	
	public static List getReservasSujeto(
			TableroTurnos tablero,
			Sujeto sujeto, ISesion aSesion)
			throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(TableroTurnos.NICKNAME, tablero);
		condiciones.put(Sujeto.NICKNAME, sujeto);
		return (List) ObjetoLogico.getObjects(ReservaTableroTurno.NICKNAME,
				DBReservaTableroTurno.SELECT_BY_TABLERO_SUJETO, 
				condiciones,
				new ListObserver(), aSesion);
	}
	

}
