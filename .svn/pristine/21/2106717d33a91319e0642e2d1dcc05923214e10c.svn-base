package com.srn.erp.cip.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

import com.srn.erp.cip.bm.TarjetaCIP;
import com.srn.erp.cip.bm.Visita;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ObjetoObservado;

public class DBTarjetaCIP extends DBObjetoPersistente {

	public static final String OID_TARJETA = "oid_tarjeta";
	public static final String TIPO_TARJETA = "tipo_tarjeta";
	public static final String NRO_TARJETA = "nro_tarjeta";
	public static final String OID_GRUPO_TAR = "oid_grupo_tar";
	public static final String TIENE_VIG = "tiene_vig";
	public static final String VIG_DESDE = "vig_desde";
	public static final String VIG_HASTA = "vig_hasta";
	public static final String HORA_DESDE = "hora_desde";
	public static final String HORA_HASTA = "hora_hasta";
	public static final String ESTADO_TARJETA = "estado_tarjeta";
	public static final String ACTIVO = "activo";
	public static final String OID_MOT_BAJ_TAR = "oid_mot_baj_tar";
	public static final String OID_LEGAJO = "oid_legajo";
	public static final String OID_VISITA = "oid_visita";
	public static final String OID_CLIENTE = "oid_cliente";
	public static final String FEC_ASIG = "fec_asig";
	public static final String HORA_ASIG = "hora_asig";
	public static final String VISITA = "visita";
	public static final String OID_GRU_P_ING_VI = "oid_gru_p_ing_vi";
	public static final String OID_GRU_P_EGR_VI = "oid_gru_p_egr_vi";
	public static final String OID_CATEG_ACC_VI = "oid_categ_acc_vis";
	public static final String TOLE_ING_VIS_MIN = "tole_ing_vis_min";
	public static final String TIPO_VISITA = "tipo_visita";
	public static final String OID_PLANIF_SEM_VIS = "oid_planif_sem_vis";
	public static final String ANTI_PASSBACK = "anti_passback";
	
	

	public static final int SELECT_BY_NRO_TARJETA = 100;
	public static final int SELECT_BY_VISITA_ACTIVO = 101;
	public static final int SELECT_BY_HELP_TARJVIS_NOASIG = 102;
	public static final int SELECT_BY_NRO_TARJETA_ACTIVA = 103;
	public static final int SELECT_ALL_HELP_ACTIVOS_VIS = 104;
	
	public DBTarjetaCIP() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_TARJETA = 1;
		final int TIPO_TARJETA = 2;
		final int NRO_TARJETA = 3;
		final int OID_GRUPO_TAR = 4;
		final int TIENE_VIG = 5;
		final int VIG_DESDE = 6;
		final int VIG_HASTA = 7;
		final int HORA_DESDE = 8;
		final int HORA_HASTA = 9;
		final int ESTADO_TARJETA = 10;
		final int ACTIVO = 11;
		final int OID_MOT_BAJ_TAR = 12;
		final int OID_LEGAJO = 13;
		final int OID_VISITA = 14;
		final int OID_CLIENTE = 15;
		final int FEC_ASIG = 16;
		final int HORA_ASIG = 17;
		final int VISITA = 18;
		final int OID_GRU_P_ING_VI = 19;
		final int OID_GRU_P_EGR_VI = 20;
		final int OID_CATEG_ACC_VI = 21;
		final int TOLE_ING_VIS_MIN = 22;
		final int TIPO_VISITA = 23;
		final int OID_PLANIF_SEM_VIS = 24;
		final int ANTI_PASSBACK = 25;

		TarjetaCIP pers = (TarjetaCIP) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into cipTarjetas " + " ( " + "OID_TARJETA," + "TIPO_TARJETA," + "NRO_TARJETA," + "OID_GRUPO_TAR,"
				+ "TIENE_VIG," + "VIG_DESDE," + "VIG_HASTA," + "HORA_DESDE," + "HORA_HASTA," + "ESTADO_TARJETA," + "ACTIVO,"
				+ "OID_MOT_BAJ_TAR," + "OID_LEGAJO," + "OID_VISITA," + "OID_CLIENTE," + "FEC_ASIG," + "HORA_ASIG , VISITA , OID_GRU_P_ING_VI , OID_GRU_P_EGR_VI , OID_CATEG_ACC_VIS , TOLE_ING_VIS_MIN , TIPO_VISITA , OID_PLANIF_SEM_VIS, ANTI_PASSBACK)" + " values " + "("
				+ "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?,"+ "?," + "?,"  + "?," + "?,"+ "?,"+ "?,"+ "?," + "?," + "?," + "?,"+ "?,"+ "?,"+ "?,"+ "?," + "?,"
				+ "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_TARJETA, pers.getOID());
		qInsert.setString(TIPO_TARJETA, pers.getTipo_tarjeta());
		qInsert.setString(NRO_TARJETA, pers.getNro_tarjeta());
		qInsert.setInt(OID_GRUPO_TAR, pers.getGrupo_tarjeta().getOID());
		qInsert.setBoolean(TIENE_VIG, pers.isTiene_vig().booleanValue());
		if (pers.getVig_desde() != null)
			qInsert.setDate(VIG_DESDE, new java.sql.Date(pers.getVig_desde().getTime()));
		else
			qInsert.setNull(VIG_DESDE, java.sql.Types.DATE);
		if (pers.getVig_hasta() != null)
			qInsert.setDate(VIG_HASTA, new java.sql.Date(pers.getVig_hasta().getTime()));
		else
			qInsert.setNull(VIG_HASTA, java.sql.Types.DATE);
		qInsert.setString(HORA_DESDE, pers.getHora_desde());
		qInsert.setString(HORA_HASTA, pers.getHora_hasta());
		qInsert.setString(ESTADO_TARJETA, pers.getEstado_tarjeta());
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		if (pers.getMotivo_baja_tarjeta() != null)
			qInsert.setInt(OID_MOT_BAJ_TAR, pers.getMotivo_baja_tarjeta().getOID());
		else
			qInsert.setNull(OID_MOT_BAJ_TAR, java.sql.Types.INTEGER);
		if (pers.getLegajo() != null)
			qInsert.setInt(OID_LEGAJO, pers.getLegajo().getOID());
		else
			qInsert.setNull(OID_LEGAJO, java.sql.Types.INTEGER);
		if (pers.getVisita() != null)
			qInsert.setInt(OID_VISITA, pers.getVisita().getOID());
		else
			qInsert.setNull(OID_VISITA, java.sql.Types.INTEGER);
		if (pers.getCliente() != null)
			qInsert.setInt(OID_CLIENTE, pers.getCliente().getOID());
		else
			qInsert.setNull(OID_CLIENTE, java.sql.Types.INTEGER);
		if (pers.getFec_asig() != null)
			qInsert.setDate(FEC_ASIG, new java.sql.Date(pers.getFec_asig().getTime()));
		else
			qInsert.setNull(FEC_ASIG, java.sql.Types.DATE);
		
		if (pers.getGrupoPueAccVisita() != null)
			qInsert.setInt(OID_GRU_P_ING_VI, pers.getGrupoPueAccVisita().getOID());
		else
			qInsert.setNull(OID_GRU_P_ING_VI, java.sql.Types.INTEGER);
		
		if (pers.getGrupoPueEgrVisita() != null)
			qInsert.setInt(OID_GRU_P_EGR_VI, pers.getGrupoPueEgrVisita().getOID());
		else
			qInsert.setNull(OID_GRU_P_EGR_VI, java.sql.Types.INTEGER);
		
		qInsert.setString(HORA_ASIG, pers.getHora_asig());
		qInsert.setBoolean(VISITA, pers.isParaVisita());
		if (pers.getCategAccesoVisita()!=null)
			qInsert.setInt(OID_CATEG_ACC_VI, pers.getCategAccesoVisita().getOID());
		else
			qInsert.setNull(OID_CATEG_ACC_VI, Types.INTEGER);
		if (pers.getToleranciaIngVisMin()!=null)
			qInsert.setInt(TOLE_ING_VIS_MIN, pers.getToleranciaIngVisMin());
		else
			qInsert.setNull(TOLE_ING_VIS_MIN, Types.INTEGER);
		if (pers.getTipoVisita()!=null)
			qInsert.setString(TIPO_VISITA, pers.getTipoVisita());
		else
			qInsert.setNull(TIPO_VISITA, Types.VARCHAR);
		if (pers.getPermisoSemanal()!=null)
			qInsert.setInt(OID_PLANIF_SEM_VIS, pers.getPermisoSemanal().getOIDInteger());
		else
			qInsert.setNull(OID_PLANIF_SEM_VIS, Types.INTEGER);
		qInsert.setBoolean(ANTI_PASSBACK, pers.isControlarAntiPassBack());
		
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int TIPO_TARJETA = 1;
		final int NRO_TARJETA = 2;
		final int OID_GRUPO_TAR = 3;
		final int TIENE_VIG = 4;
		final int VIG_DESDE = 5;
		final int VIG_HASTA = 6;
		final int HORA_DESDE = 7;
		final int HORA_HASTA = 8;
		final int ESTADO_TARJETA = 9;
		final int ACTIVO = 10;
		final int OID_MOT_BAJ_TAR = 11;
		final int OID_LEGAJO = 12;
		final int OID_VISITA = 13;
		final int OID_CLIENTE = 14;
		final int FEC_ASIG = 15;
		final int HORA_ASIG = 16;
		final int VISITA = 17;
		final int OID_GRU_P_ING_VI = 18;
		final int OID_GRU_P_EGR_VI = 19;
		final int OID_CATEG_ACC_VI = 20;
		final int TOLE_ING_VIS_MIN = 21;
		final int TIPO_VISITA = 22;
		final int OID_PLANIF_SEM_VIS = 23;
		final int CONTROLAR_ANTIPASS = 24;
		final int OID_TARJETA = 25;

		TarjetaCIP pers = (TarjetaCIP) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update cipTarjetas set " + "tipo_tarjeta=?" + ",nro_tarjeta=?" + ",oid_grupo_tar=?" + ",tiene_vig=?"
				+ ",vig_desde=?" + ",vig_hasta=?" + ",hora_desde=?" + ",hora_hasta=?" + ",estado_tarjeta=?" + ",activo=?"
				+ ",oid_mot_baj_tar=?" + ",oid_legajo=?" + ",oid_visita=?" + ",oid_cliente=?" + ",fec_asig=?" + ",hora_asig=? , visita = ?  , OID_GRU_P_ING_VI = ? , OID_GRU_P_EGR_VI = ? , OID_CATEG_ACC_VIS = ? , tole_ing_vis_min = ? , tipo_visita = ? , OID_PLANIF_SEM_VIS = ? , anti_passback = ?  " + " where "
				+ " oid_tarjeta=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_TARJETA, pers.getOID());
		qUpdate.setString(TIPO_TARJETA, pers.getTipo_tarjeta());
		qUpdate.setString(NRO_TARJETA, pers.getNro_tarjeta());
		qUpdate.setInt(OID_GRUPO_TAR, pers.getGrupo_tarjeta().getOID());
		qUpdate.setBoolean(TIENE_VIG, pers.isTiene_vig().booleanValue());
		if (pers.getVig_desde() != null)
			qUpdate.setDate(VIG_DESDE, new java.sql.Date(pers.getVig_desde().getTime()));
		else
			qUpdate.setNull(VIG_DESDE, java.sql.Types.DATE);
		if (pers.getVig_hasta() != null)
			qUpdate.setDate(VIG_HASTA, new java.sql.Date(pers.getVig_hasta().getTime()));
		else
			qUpdate.setNull(VIG_HASTA, java.sql.Types.DATE);
		qUpdate.setString(HORA_DESDE, pers.getHora_desde());
		qUpdate.setString(HORA_HASTA, pers.getHora_hasta());
		qUpdate.setString(ESTADO_TARJETA, pers.getEstado_tarjeta());
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		if (pers.getMotivo_baja_tarjeta() != null)
			qUpdate.setInt(OID_MOT_BAJ_TAR, pers.getMotivo_baja_tarjeta().getOID());
		else
			qUpdate.setNull(OID_MOT_BAJ_TAR, java.sql.Types.INTEGER);
		if (pers.getLegajo() != null)
			qUpdate.setInt(OID_LEGAJO, pers.getLegajo().getOID());
		else
			qUpdate.setNull(OID_LEGAJO, java.sql.Types.INTEGER);
		if (pers.getVisita() != null)
			qUpdate.setInt(OID_VISITA, pers.getVisita().getOID());
		else
			qUpdate.setNull(OID_VISITA, java.sql.Types.INTEGER);
		if (pers.getCliente() != null)
			qUpdate.setInt(OID_CLIENTE, pers.getCliente().getOID());
		else
			qUpdate.setNull(OID_CLIENTE, java.sql.Types.INTEGER);
		if (pers.getFec_asig() != null)
			qUpdate.setDate(FEC_ASIG, new java.sql.Date(pers.getFec_asig().getTime()));
		else
			qUpdate.setNull(FEC_ASIG, java.sql.Types.DATE);
		qUpdate.setString(HORA_ASIG, pers.getHora_asig());
		qUpdate.setBoolean(VISITA, pers.isParaVisita());
		if (pers.getGrupoPueAccVisita() != null)
			qUpdate.setInt(OID_GRU_P_ING_VI, pers.getGrupoPueAccVisita().getOID());
		else
			qUpdate.setNull(OID_GRU_P_ING_VI, java.sql.Types.INTEGER);
		
		if (pers.getGrupoPueEgrVisita() != null)
			qUpdate.setInt(OID_GRU_P_EGR_VI, pers.getGrupoPueEgrVisita().getOID());
		else
			qUpdate.setNull(OID_GRU_P_EGR_VI, java.sql.Types.INTEGER);
		if (pers.getCategAccesoVisita()!=null)
			qUpdate.setInt(OID_CATEG_ACC_VI, pers.getCategAccesoVisita().getOID());
		else
			qUpdate.setNull(OID_CATEG_ACC_VI, Types.INTEGER);
		
		if (pers.getToleranciaIngVisMin()!=null)
			qUpdate.setInt(TOLE_ING_VIS_MIN, pers.getToleranciaIngVisMin());
		else
			qUpdate.setNull(TOLE_ING_VIS_MIN, Types.INTEGER);
		if (pers.getTipoVisita()!=null)
			qUpdate.setString(TIPO_VISITA, pers.getTipoVisita());
		else
			qUpdate.setNull(TIPO_VISITA, Types.VARCHAR);
		if (pers.getPermisoSemanal()!=null)
			qUpdate.setInt(OID_PLANIF_SEM_VIS, pers.getPermisoSemanal().getOIDInteger());
		else
			qUpdate.setNull(OID_PLANIF_SEM_VIS, Types.INTEGER);
		qUpdate.setBoolean(CONTROLAR_ANTIPASS, pers.isControlarAntiPassBack());
		
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_TARJETA = 1;
		TarjetaCIP pers = (TarjetaCIP) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cipTarjetas " + " set activo=0 " + " where " + " oid_tarjeta=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_TARJETA, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_TARJETA = 1;
		TarjetaCIP pers = (TarjetaCIP) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cipTarjetas " + " set activo=1 " + " where " + " oid_tarjeta=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_TARJETA, pers.getOID());
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
		case SELECT_BY_NRO_TARJETA: {
			ps = this.selectByNroTarjeta(aCondiciones);
			break;			
		}
		case SELECT_BY_VISITA_ACTIVO: {
			ps = this.selectByVisitaActivo(aCondiciones);
			break;
		}
		case SELECT_BY_HELP_TARJVIS_NOASIG: {
			ps = this.selectByTarjVisNoAsig(aCondiciones);
			break;
		}
		case SELECT_BY_NRO_TARJETA_ACTIVA: {
			ps = this.selectByNroTarjetaActiva(aCondiciones);
			break;			
		}
		case SELECT_ALL_HELP_ACTIVOS_VIS: {
			ps = this.selectAllHelpActivosVis(aCondiciones);
			break;			
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_TARJETA = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cipTarjetas ");
		textSQL.append(" WHERE oid_tarjeta = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_TARJETA, oid);
		return querySelect;
	}

	private PreparedStatement selectByNroTarjetaActiva(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cipTarjetas ");
		textSQL.append(" WHERE nro_tarjeta  = ? and activo = 1 ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(1, codigo);
		return querySelect;
	}
	
	
	
	private PreparedStatement selectByNroTarjeta(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cipTarjetas ");
		textSQL.append(" WHERE nro_tarjeta  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(1, codigo);
		return querySelect;
	}
	

	private PreparedStatement selectByVisitaActivo(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cipTarjetas ");
		textSQL.append(" WHERE oid_visita  = ? and activo = 1 ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		Visita visita = (Visita) aCondiciones;
		querySelect.setInt(1, visita.getOID());
		return querySelect;
	}
	
	
	
	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cipTarjetas ");
		textSQL.append(" WHERE nro_tarjeta  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectByTarjVisNoAsig(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append(" SELECT oid_tarjeta oid, nro_tarjeta codigo, tipo_tarjeta descripcion ,activo ");
		textSQL.append(" from cipTarjetas ");
		textSQL.append(" where ");
		textSQL.append(" visita=1 and activo = 1 and oid_cliente is null and oid_visita is null and oid_legajo is null and nro_tarjeta not in (select nro_tarjeta from cipTarjetaLegajo where activo=1 and (oid_legajo is not null or oid_visita is not null)) ");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	private PreparedStatement selectAllHelpActivosVis(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT oid_tarjeta oid, nro_tarjeta codigo,  tipo_tarjeta descripcion ,activo ");
		textSQL.append(" from cipTarjetas where activo = 1 and visita = 1");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}
	
	
	
	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_tarjeta oid, tipo_tarjeta codigo,  nro_tarjeta descripcion ,activo ");
		textSQL.append(" from cipTarjetas");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}
	
	  public static TarjetaCIP getTarjetaCIP(String nroTarjeta,
	          ISesion aSesion)
	          throws BaseException {
		  return (TarjetaCIP) ObjetoLogico.getObjects(TarjetaCIP.NICKNAME,
				  				DBTarjetaCIP.SELECT_BY_NRO_TARJETA,
				  				nroTarjeta,
				  				new ObjetoObservado(),
				  				aSesion);
	  }

	  
	  public static TarjetaCIP getTarjetaCIPActiva(String nroTarjeta,
	          ISesion aSesion)
	          throws BaseException {
		  return (TarjetaCIP) ObjetoLogico.getObjects(TarjetaCIP.NICKNAME,
				  				DBTarjetaCIP.SELECT_BY_NRO_TARJETA_ACTIVA,
				  				nroTarjeta,
				  				new ObjetoObservado(),
				  				aSesion);
	  }
	  
	  public static TarjetaCIP getTarjetaCIP(Visita visita,
	          ISesion aSesion)
	          throws BaseException {
		  return (TarjetaCIP) ObjetoLogico.getObjects(TarjetaCIP.NICKNAME,
				  				DBTarjetaCIP.SELECT_BY_VISITA_ACTIVO,
				  				visita,
				  				new ObjetoObservado(),
				  				aSesion);
	  }
	
	

}
