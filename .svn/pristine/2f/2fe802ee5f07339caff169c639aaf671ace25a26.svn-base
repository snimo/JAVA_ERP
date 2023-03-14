package com.srn.erp.cip.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

import com.srn.erp.cip.bm.MotivosNovCIP;

import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class DBMotivosNovCIP extends DBObjetoPersistente {

	public static final String OID_MOTIVO = "oid_motivo";
	public static final String CODIGO = "codigo";
	public static final String DESCRIPCION = "descripcion";
	public static final String ACTIVO = "activo";
	public static final String HAB_PARA_INGRESOS = "hab_para_ingresos";
	public static final String HAB_PARA_EGRESOS = "hab_para_egresos";
	public static final String COMPO_EXT_ING = "compo_ext_ing";
	public static final String COMPO_EXT_EGR = "compo_ext_egr";
	public static final String MIN_ENT_ANT = "min_ent_ant";
	public static final String MIN_ENT_DES = "min_ent_des";
	public static final String ANULA_ROTA_DEL_DIA = "anula_rota_del_dia";
	public static final String HORA_DESDE_ING = "hora_desde_ing";
	public static final String HORA_HASTA_ING = "hora_hasta_ing";
	public static final String HORA_DESDE_EGR = "hora_desde_egr";
	public static final String HORA_HASTA_EGR = "hora_hasta_egr";
	public static final String HORA_DESDE_ING_MIN = "hora_desde_ing_min";
	public static final String HORA_HASTA_ING_MIN = "hora_hasta_ing_min";
	public static final String HORA_DESDE_EGR_MIN = "hora_desde_egr_min";
	public static final String HORA_HASTA_EGR_MIN = "hora_hasta_egr_min";
	

	public static final int SELECT_HELP_BY_HAB_PARA_INGRESOS = 100;
	public static final int SELECT_HELP_BY_HAB_PARA_EGRESOS = 101;

	public DBMotivosNovCIP() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_MOTIVO = 1;
		final int CODIGO = 2;
		final int DESCRIPCION = 3;
		final int ACTIVO = 4;
		final int HAB_PARA_INGRESOS = 5;
		final int HAB_PARA_EGRESOS = 6;
		final int COMPO_EXT_ING = 7;
		final int COMPO_EXT_EGR = 8;
		final int MIN_ENT_ANT = 9;
		final int MIN_ENT_DES = 10;
		final int ANULA_ROTA_DEL_DIA = 11;
		final int HORA_DESDE_ING = 12;
		final int HORA_HASTA_ING = 13;
		final int HORA_DESDE_EGR = 14;
		final int HORA_HASTA_EGR = 15;
		final int HORA_DESDE_ING_MIN = 16;
		final int HORA_HASTA_ING_MIN = 17;
		final int HORA_DESDE_EGR_MIN = 18;
		final int HORA_HASTA_EGR_MIN = 19;
		

		MotivosNovCIP pers = (MotivosNovCIP) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into cipMotivosNov " + " ( " + "OID_MOTIVO," + "CODIGO," + "DESCRIPCION,"
				+ "ACTIVO,HAB_PARA_INGRESOS,HAB_PARA_EGRESOS , COMPO_EXT_ING , COMPO_EXT_EGR , MIN_ENT_ANT , MIN_ENT_DES , ANULA_ROTA_DEL_DIA , hora_desde_ing , hora_hasta_ing , hora_desde_egr , hora_hasta_egr , HORA_DESDE_ING_MIN , HORA_HASTA_ING_MIN, HORA_DESDE_EGR_MIN , HORA_HASTA_EGR_MIN)" + " values " + "(" + "?,"+ "?,"+ "?,"+ "?,"+ "?," + "?,"+ "?,"+ "?,"+ "?,"+ "?,"+ "?,"+ "?,"+ "?," + "?," + "?," + "?,"+ "?,"+ "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_MOTIVO, pers.getOID());
		qInsert.setString(CODIGO, pers.getCodigo());
		qInsert.setString(DESCRIPCION, pers.getDescripcion());
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());

		if (pers.isHabilitadoParaIngresos() != null)
			qInsert.setBoolean(HAB_PARA_INGRESOS, pers.isHabilitadoParaIngresos().booleanValue());
		else
			qInsert.setBoolean(HAB_PARA_INGRESOS, false);
		if (pers.isHabilitadoParaEgresos() != null)
			qInsert.setBoolean(HAB_PARA_EGRESOS, pers.isHabilitadoParaEgresos().booleanValue());
		else
			qInsert.setBoolean(HAB_PARA_EGRESOS, false);
		
		if (pers.getCompoExtIngreso() != null)
			qInsert.setString(COMPO_EXT_ING, pers.getCompoExtIngreso());
		else
			qInsert.setNull(COMPO_EXT_ING, java.sql.Types.VARCHAR);		
		
		if (pers.getCompoExtEgreso() != null)
			qInsert.setString(COMPO_EXT_EGR, pers.getCompoExtEgreso());
		else
			qInsert.setNull(COMPO_EXT_EGR, java.sql.Types.VARCHAR);
		
		if (pers.getMinEntAnt()!=null)
			qInsert.setInt(MIN_ENT_ANT, pers.getMinEntAnt());
		else
			qInsert.setNull(MIN_ENT_ANT, Types.INTEGER);
		
		if (pers.getMinEntDes()!=null)
			qInsert.setInt(MIN_ENT_DES, pers.getMinEntDes());
		else
			qInsert.setNull(MIN_ENT_DES, Types.INTEGER);
		qInsert.setBoolean(ANULA_ROTA_DEL_DIA, pers.isAnulaRotaDelDia());
		
		if (pers.getHoraDesdeIng()!=null)
			qInsert.setString(HORA_DESDE_ING , pers.getHoraDesdeIng());
		else
			qInsert.setNull(HORA_DESDE_ING , Types.VARCHAR);
		if (pers.getHoraHastaIng()!=null)
			qInsert.setString(HORA_HASTA_ING , pers.getHoraHastaIng());
		else
			qInsert.setNull(HORA_HASTA_ING , Types.VARCHAR);
		if (pers.getHoraDesdeEgr()!=null)
			qInsert.setString(HORA_DESDE_EGR , pers.getHoraDesdeEgr());
		else
			qInsert.setNull(HORA_DESDE_EGR , Types.VARCHAR);
		if (pers.getHoraHastaEgr()!=null)
			qInsert.setString(HORA_HASTA_EGR , pers.getHoraHastaEgr());
		else
			qInsert.setNull(HORA_HASTA_EGR , Types.VARCHAR);
		
		qInsert.setInt(HORA_DESDE_ING_MIN , pers.getHoraDesdeIngMin());
		qInsert.setInt(HORA_HASTA_ING_MIN , pers.getHoraHastaIngMin());
		qInsert.setInt(HORA_DESDE_EGR_MIN , pers.getHoraDesdeEgrMin());
		qInsert.setInt(HORA_HASTA_EGR_MIN , pers.getHoraHastaEgrMin());

		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int CODIGO = 1;
		final int DESCRIPCION = 2;
		final int ACTIVO = 3;
		final int HAB_PARA_INGRESOS = 4;
		final int HAB_PARA_EGRESOS = 5;
		final int COMPO_EXT_ING = 6;
		final int COMPO_EXT_EGR = 7;
		final int MIN_ENT_ANT = 8;
		final int MIN_ENT_DES = 9;
		final int ANULA_ROTA_DEL_DIA = 10;
		final int HORA_DESDE_ING = 11;
		final int HORA_HASTA_ING = 12;
		final int HORA_DESDE_EGR = 13;
		final int HORA_HASTA_EGR = 14;
		final int HORA_DESDE_ING_MIN = 15;
		final int HORA_HASTA_ING_MIN = 16;
		final int HORA_DESDE_EGR_MIN = 17;
		final int HORA_HASTA_EGR_MIN = 18;
		final int OID_MOTIVO = 19;

		MotivosNovCIP pers = (MotivosNovCIP) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update cipMotivosNov set " + "codigo=?" + ",descripcion=?" + ",activo=?" + ",hab_para_ingresos=?"
				+ ",hab_para_egresos=? , COMPO_EXT_ING=?, COMPO_EXT_EGR=? , MIN_ENT_ANT = ? , MIN_ENT_DES = ? , ANULA_ROTA_DEL_DIA = ? , hora_desde_ing = ? , hora_hasta_ing = ? , hora_desde_egr = ? , hora_hasta_egr = ? , HORA_DESDE_ING_MIN = ? , HORA_HASTA_ING_MIN = ? , HORA_DESDE_EGR_MIN = ? , HORA_HASTA_EGR_MIN = ? " + " where " + " oid_motivo=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_MOTIVO, pers.getOID());
		qUpdate.setString(CODIGO, pers.getCodigo());
		qUpdate.setString(DESCRIPCION, pers.getDescripcion());
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());

		if (pers.isHabilitadoParaIngresos() != null)
			qUpdate.setBoolean(HAB_PARA_INGRESOS, pers.isHabilitadoParaIngresos().booleanValue());
		else
			qUpdate.setBoolean(HAB_PARA_INGRESOS, false);
		if (pers.isHabilitadoParaEgresos() != null)
			qUpdate.setBoolean(HAB_PARA_EGRESOS, pers.isHabilitadoParaEgresos().booleanValue());
		else
			qUpdate.setBoolean(HAB_PARA_EGRESOS, false);
		
		if (pers.getCompoExtIngreso() != null)
			qUpdate.setString(COMPO_EXT_ING, pers.getCompoExtIngreso());
		else
			qUpdate.setNull(COMPO_EXT_ING, java.sql.Types.VARCHAR);		
		
		if (pers.getCompoExtEgreso() != null)
			qUpdate.setString(COMPO_EXT_EGR, pers.getCompoExtEgreso());
		else
			qUpdate.setNull(COMPO_EXT_EGR, java.sql.Types.VARCHAR);		
		
		if (pers.getMinEntAnt()!=null)
			qUpdate.setInt(MIN_ENT_ANT, pers.getMinEntAnt());
		else
			qUpdate.setNull(MIN_ENT_ANT, Types.INTEGER);
		
		if (pers.getMinEntDes()!=null)
			qUpdate.setInt(MIN_ENT_DES, pers.getMinEntDes());
		else
			qUpdate.setNull(MIN_ENT_DES, Types.INTEGER);
		
		qUpdate.setBoolean(ANULA_ROTA_DEL_DIA, pers.isAnulaRotaDelDia());
		
		if (pers.getHoraDesdeIng()!=null)
			qUpdate.setString(HORA_DESDE_ING , pers.getHoraDesdeIng());
		else
			qUpdate.setNull(HORA_DESDE_ING , Types.VARCHAR);
		
		if (pers.getHoraHastaIng()!=null)
			qUpdate.setString(HORA_HASTA_ING , pers.getHoraHastaIng());
		else
			qUpdate.setNull(HORA_HASTA_ING , Types.VARCHAR);
		
		if (pers.getHoraDesdeEgr()!=null)
			qUpdate.setString(HORA_DESDE_EGR , pers.getHoraDesdeEgr());
		else
			qUpdate.setNull(HORA_DESDE_EGR , Types.VARCHAR);
		
		if (pers.getHoraHastaEgr()!=null)
			qUpdate.setString(HORA_HASTA_EGR , pers.getHoraHastaEgr());
		else
			qUpdate.setNull(HORA_HASTA_EGR , Types.VARCHAR);
		
		qUpdate.setInt(HORA_DESDE_ING_MIN , pers.getHoraDesdeIngMin());
		qUpdate.setInt(HORA_HASTA_ING_MIN , pers.getHoraHastaIngMin());
		qUpdate.setInt(HORA_DESDE_EGR_MIN , pers.getHoraDesdeEgrMin());
		qUpdate.setInt(HORA_HASTA_EGR_MIN , pers.getHoraHastaEgrMin());
		
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_MOTIVO = 1;
		MotivosNovCIP pers = (MotivosNovCIP) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cipMotivosNov " + " set activo=0 " + " where " + " oid_motivo=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_MOTIVO, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_MOTIVO = 1;
		MotivosNovCIP pers = (MotivosNovCIP) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cipMotivosNov " + " set activo=1 " + " where " + " oid_motivo=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_MOTIVO, pers.getOID());
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
		case SELECT_HELP_BY_HAB_PARA_INGRESOS: {
			ps = this.selectHabParaIngresos(aCondiciones);
			break;
		}
		case SELECT_HELP_BY_HAB_PARA_EGRESOS: {
			ps = this.selectHabParaEgresos(aCondiciones);
			break;
		}
		
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_MOTIVO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cipMotivosNov ");
		textSQL.append(" WHERE oid_motivo = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_MOTIVO, oid);
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cipMotivosNov ");
		textSQL.append(" WHERE codigo = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectHabParaIngresos(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_motivo oid, codigo,  descripcion ,activo ");
		textSQL.append(" from cipMotivosNov where hab_para_ingresos=1 and activo=1 ");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}
	
	private PreparedStatement selectHabParaEgresos(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_motivo oid, codigo,  descripcion ,activo ");
		textSQL.append(" from cipMotivosNov where hab_para_egresos=1 and activo=1 ");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}
	

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_motivo oid, codigo,  descripcion ,activo ");
		textSQL.append(" from cipMotivosNov");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

}
