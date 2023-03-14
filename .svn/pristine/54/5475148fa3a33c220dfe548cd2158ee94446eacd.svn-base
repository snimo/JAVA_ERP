package com.srn.erp.turnos.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.general.bm.PeriodoInc;
import com.srn.erp.general.bm.PeriodoIncDet;
import com.srn.erp.general.da.DBPeriodoIncDet;
import com.srn.erp.turnos.bm.EntidadTurno;
import com.srn.erp.turnos.bm.TableroEntidadTurnos;
import com.srn.erp.turnos.bm.TableroTurnos;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBTableroEntidadTurnos extends DBObjetoPersistente {

	public static final String OID_TABLERO_ENTIDAD = "oid_tablero_entidad";
	public static final String OID_TABLERO_CAB = "oid_tablero_cab";
	public static final String SECU = "secu";
	public static final String OID_ENTIDAD_TURNO = "oid_entidad_turno";
	public static final String CAM_HOR_PON_TURNO = "cam_hor_al_pon_tur";
	public static final String MINUTOS_1_SUJ = "minu_1_suj";
	public static final String MINUTOS_2_SUJ = "minu_2_suj";
	public static final String MINUTOS_3_SUJ = "minu_3_suj";
	public static final String MINUTOS_4_SUJ = "minu_4_suj";
	

	public static final int SELECT_BY_TABLERO = 100;
	public static final int SELECT_BY_TABLERO_ENTIDAD = 101;

	public DBTableroEntidadTurnos() {
	}

	protected void insert(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {

		final int OID_TABLERO_ENTIDAD = 1;
		final int OID_TABLERO_CAB = 2;
		final int SECU = 3;
		final int OID_ENTIDAD_TURNO = 4;
	    final int CAM_HOR_PON_TUR = 5;
	    final int MINU_1_JUG = 6;
	    final int MINU_2_JUG = 7;
	    final int MINU_3_JUG = 8;
	    final int MINU_4_JUG = 9;
		

		TableroEntidadTurnos pers = (TableroEntidadTurnos) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into tuTableroEntidad " + " ( "
				+ "OID_TABLERO_ENTIDAD," + "OID_TABLERO_CAB," + "SECU,"
				+ "OID_ENTIDAD_TURNO," +
                "CAM_HOR_AL_PON_TUR,"+
                "MINU_1_SUJ,"+
                "MINU_2_SUJ,"+
                "MINU_3_SUJ,"+
                "MINU_4_SUJ) "+
				
				" values " + "(" + "?," + "?," + "?,"+ "?,"+ "?,"+ "?,"+ "?,"+ "?,"
				+ "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD()
				.prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_TABLERO_ENTIDAD, pers.getOID());
		qInsert.setInt(OID_TABLERO_CAB, pers.getTablero().getOID());
		qInsert.setInt(SECU, pers.getSecu().intValue());
		qInsert.setInt(OID_ENTIDAD_TURNO, pers.getEntidad_turno().getOID());
	    qInsert.setBoolean(CAM_HOR_PON_TUR,pers.isCambiarHorarioAlPonerTurno().booleanValue());
	    qInsert.setInt(MINU_1_JUG, pers.getMinutosTur1Suj());
	    qInsert.setInt(MINU_2_JUG, pers.getMinutosTur2Suj());
	    qInsert.setInt(MINU_3_JUG, pers.getMinutosTur3Suj());
	    qInsert.setInt(MINU_4_JUG, pers.getMinutosTur4Suj());
		
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {

		final int OID_TABLERO_CAB = 1;
		final int SECU = 2;
		final int OID_ENTIDAD_TURNO = 3;
	    final int CAM_HOR_PON_TUR = 4;
	    final int MINU_1_JUG = 5;
	    final int MINU_2_JUG = 6;
	    final int MINU_3_JUG = 7;
	    final int MINU_4_JUG = 8;
		final int OID_TABLERO_ENTIDAD = 9;

		TableroEntidadTurnos pers = (TableroEntidadTurnos) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update tuTableroEntidad set " + "oid_tablero_cab=?"
				+ ",secu=?" + ",oid_entidad_turno=?,"+
	              ",cam_hor_al_pon_tur=?"+
	              ",minu_1_suj=?"+
	              ",minu_2_suj=?"+
	              ",minu_3_suj=?"+
	              ",minu_4_suj=? "
				+ " where "
				+ " oid_tablero_entidad=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_TABLERO_ENTIDAD, pers.getOID());
		qUpdate.setInt(OID_TABLERO_CAB, pers.getTablero().getOID());
		qUpdate.setInt(SECU, pers.getSecu().intValue());
		qUpdate.setInt(OID_ENTIDAD_TURNO, pers.getEntidad_turno().getOID());
	    qUpdate.setBoolean(CAM_HOR_PON_TUR,pers.isCambiarHorarioAlPonerTurno().booleanValue());
	    qUpdate.setInt(MINU_1_JUG, pers.getMinutosTur1Suj());
	    qUpdate.setInt(MINU_2_JUG, pers.getMinutosTur2Suj());
	    qUpdate.setInt(MINU_3_JUG, pers.getMinutosTur3Suj());
	    qUpdate.setInt(MINU_4_JUG, pers.getMinutosTur4Suj());    
		
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {
		final int OID_TABLERO_ENTIDAD = 1;
		TableroEntidadTurnos pers = (TableroEntidadTurnos) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update tuTableroEntidad " + " set activo=0 "
				+ " where " + " oid_tablero_entidad=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_TABLERO_ENTIDAD, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {
		final int OID_TABLERO_ENTIDAD = 1;
		TableroEntidadTurnos pers = (TableroEntidadTurnos) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update tuTableroEntidad " + " set activo=1 "
				+ " where " + " oid_tablero_entidad=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_TABLERO_ENTIDAD, pers.getOID());
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
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones)
			throws BaseException, SQLException {

		final int OID_TABLERO_ENTIDAD = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  tuTableroEntidad ");
		textSQL.append(" WHERE oid_tablero_entidad = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_TABLERO_ENTIDAD, oid);
		return querySelect;
	}

	private PreparedStatement selectByTablero(Object aCondiciones)
			throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  tuTableroEntidad ");
		textSQL.append(" WHERE oid_tablero_cab = ? order by secu ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		TableroTurnos tablero = (TableroTurnos) aCondiciones;
		querySelect.setInt(1, tablero.getOID());
		return querySelect;

	}
	
	private PreparedStatement selectByTableroEntidad(Object aCondiciones)
		throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  tuTableroEntidad ");
		textSQL.append(" WHERE oid_tablero_cab = ? and oid_entidad_turno = ? ");
		
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		TableroTurnos tablero = (TableroTurnos) condiciones.get(TableroTurnos.NICKNAME);
		EntidadTurno entidadTurno = (EntidadTurno) condiciones.get(EntidadTurno.NICKNAME);
		
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		querySelect.setInt(1, tablero.getOID());
		querySelect.setInt(2, entidadTurno.getOID());
		
		return querySelect;

	}
	
	
	private PreparedStatement selectByCodigo(Object aCondiciones)
			throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  tuTableroEntidad ");
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
				.append("SELECT oid_tablero_entidad oid, codigo, oid_tablero_cab descripcion ,activo ");
		textSQL.append(" from tuTableroEntidad");

		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		return querySelect;
	}
	
	  public static List getEntidadesTablero(TableroTurnos tablero,
              ISesion aSesion) throws BaseException {
		  return (List) ObjetoLogico.getObjects(TableroEntidadTurnos.NICKNAME,
                 DBTableroEntidadTurnos.SELECT_BY_TABLERO,
                 tablero,
                 new ListObserver(),
                 aSesion);
	  }
	  
	  public static TableroEntidadTurnos getEntidadTablero(
			  TableroTurnos tablero, 
			  EntidadTurno entidadTurno,
              ISesion aSesion) throws BaseException {
		  HashTableDatos condiciones = new HashTableDatos();
		  condiciones.put(TableroTurnos.NICKNAME, tablero);
		  condiciones.put(EntidadTurno.NICKNAME, entidadTurno);
		  
		  return (TableroEntidadTurnos) ObjetoLogico.getObjects(TableroEntidadTurnos.NICKNAME,
                 DBTableroEntidadTurnos.SELECT_BY_TABLERO_ENTIDAD,
                 condiciones,
                 new ObjetoObservado(),
                 aSesion);
	  }
	  
	

}
