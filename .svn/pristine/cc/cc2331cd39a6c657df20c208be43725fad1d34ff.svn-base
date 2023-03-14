package com.srn.erp.excluidos.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.excluidos.bm.EstadoExcluido;
import com.srn.erp.excluidos.bm.IndividuoExcluido;
import com.srn.erp.excluidos.bm.NovedadExcluido;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;

public class DBNovedadExcluido extends DBObjetoPersistente {

	public static final String OID_NOVEDAD = "oid_novedad";
	public static final String FECHA = "fecha";
	public static final String HORA = "hora";
	public static final String OID_ESTADO = "oid_estado";
	public static final String OID_LUGAR_HECHO = "oid_lugar_hecho";
	public static final String OID_SE_RETIRA = "oid_se_retira";
	public static final String HORA_DESDE = "hora_desde";
	public static final String OID_MOTIVO = "oid_motivo";
	public static final String OID_TURNO = "oid_turno";
	public static final String HORA_HASTA = "hora_hasta";
	public static final String OID_SUPERVISOR = "oid_supervisor";
	public static final String OBSERVACION = "observacion";
	public static final String VIG_DESDE = "vig_desde";
	public static final String ACTIVO = "activo";
	public static final String VIG_HASTA = "vig_hasta";
	public static final String DEJAR_SIN_EFECTO = "dejar_sin_efecto";
	public static final String OID_INDIVIDUO = "oid_individuo";
	public static final String NRO_ACTA = "nro_acta";
	public static final String NRO_REVOCAMIENTO = "nro_revocamiento";
	public static final String FEC_REV = "fec_rev";
	public static final String OID_GERENTE = "oid_gerente";
	public static final String IRREVOCABLE = "irrevocable";
	public static final String OID_PREDIO = "oid_predio";
	public static final String RESTRICCION_ACCESO = "restriccion_acceso";

	public static final int SELECT_BY_INDIVIDUO = 100;
	public static final int SELECT_BY_ESTADO_NRO = 101;
	public static final int SELECT_BY_DISTIND_ESTADO_NRO = 102;
	public static final int SELECT_BY_CONDICIONES = 103;

	public DBNovedadExcluido() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_NOVEDAD = 1;
		final int FECHA = 2;
		final int HORA = 3;
		final int OID_ESTADO = 4;
		final int OID_LUGAR_HECHO = 5;
		final int OID_SE_RETIRA = 6;
		final int HORA_DESDE = 7;
		final int OID_MOTIVO = 8;
		final int OID_TURNO = 9;
		final int HORA_HASTA = 10;
		final int OID_SUPERVISOR = 11;
		final int OBSERVACION = 12;
		final int VIG_DESDE = 13;
		final int ACTIVO = 14;
		final int VIG_HASTA = 15;
		final int DEJAR_SIN_EFECTO = 16;
		final int OID_INDIVIDUO = 17;
		final int NRO_ACTA = 18;
		final int NRO_REVOCAMIENTO = 19;
		final int FEC_REV = 20;
		final int OID_GERENTE = 21;
		final int IRREVOCABLE = 22;
		final int OID_PREDIO = 23;
		final int RESTRICCION_ACCESO = 24;

		NovedadExcluido pers = (NovedadExcluido) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into excNovedades " + " ( " + "OID_NOVEDAD," + "FECHA," + "HORA," + "OID_ESTADO," + "OID_LUGAR_HECHO,"
				+ "OID_SE_RETIRA," + "HORA_DESDE," + "OID_MOTIVO," + "OID_TURNO," + "HORA_HASTA," + "OID_SUPERVISOR," + "OBSERVACION,"
				+ "VIG_DESDE," + "ACTIVO," + "VIG_HASTA,"
				+ "DEJAR_SIN_EFECTO , OID_INDIVIDUO , NRO_ACTA , NRO_REVOCAMIENTO , FEC_REV , OID_GERENTE , IRREVOCABLE , OID_PREDIO, RESTRICCION_ACCESO)" + " values " + "(" + "?,"
				+ "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?,"+ "?," + "?,"+ "?," + "?," + "?," + "?,"
				+ "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_NOVEDAD, pers.getOID());
		if (pers.getFecha() != null)
			qInsert.setDate(FECHA, new java.sql.Date(pers.getFecha().getTime()));
		else
			qInsert.setNull(FECHA, java.sql.Types.DATE);
		qInsert.setString(HORA, pers.getHora());
		qInsert.setInt(OID_ESTADO, pers.getEstado().getOID());
		if (pers.getLugar_del_hecho() != null)
			qInsert.setInt(OID_LUGAR_HECHO, pers.getLugar_del_hecho().getOID());
		else
			qInsert.setNull(OID_LUGAR_HECHO, java.sql.Types.INTEGER);
		if (pers.getSe_retira_en() != null)
			qInsert.setInt(OID_SE_RETIRA, pers.getSe_retira_en().getOID());
		else
			qInsert.setNull(OID_SE_RETIRA, java.sql.Types.INTEGER);
		qInsert.setString(HORA_DESDE, pers.getHora_desde());
		if (pers.getMotivo() != null)
			qInsert.setInt(OID_MOTIVO, pers.getMotivo().getOID());
		else
			qInsert.setNull(OID_MOTIVO, java.sql.Types.INTEGER);
		if (pers.getTurno() != null)
			qInsert.setInt(OID_TURNO, pers.getTurno().getOID());
		else
			qInsert.setNull(OID_TURNO, java.sql.Types.INTEGER);
		qInsert.setString(HORA_HASTA, pers.getHora_hasta());
		if (pers.getSupervisor() != null)
			qInsert.setInt(OID_SUPERVISOR, pers.getSupervisor().getOID());
		else
			qInsert.setNull(OID_SUPERVISOR, java.sql.Types.INTEGER);
		if (pers.getObservacion() != null)
			qInsert.setString(OBSERVACION, pers.getObservacion().replaceAll("Â", ""));
		else
			qInsert.setNull(OBSERVACION, java.sql.Types.VARCHAR);
		if (pers.getVig_desde() != null)
			qInsert.setDate(VIG_DESDE, new java.sql.Date(pers.getVig_desde().getTime()));
		else
			qInsert.setNull(VIG_DESDE, java.sql.Types.INTEGER);
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		if (pers.getVig_hasta() != null)
			qInsert.setDate(VIG_HASTA, new java.sql.Date(pers.getVig_hasta().getTime()));
		else
			qInsert.setNull(VIG_HASTA, java.sql.Types.DATE);
		if (pers.getnroActa() != null)
			qInsert.setInt(NRO_ACTA, pers.getnroActa().intValue());
		else
			qInsert.setNull(NRO_ACTA, java.sql.Types.INTEGER);

		if (pers.getnroRevocamiento() != null)
			qInsert.setInt(NRO_REVOCAMIENTO, pers.getnroRevocamiento().intValue());
		else
			qInsert.setNull(NRO_REVOCAMIENTO, java.sql.Types.INTEGER);

		if (pers.getFecRevocamiento() != null)
			qInsert.setDate(FEC_REV, new java.sql.Date(pers.getFecRevocamiento().getTime()));
		else
			qInsert.setNull(FEC_REV, java.sql.Types.DATE);

		qInsert.setBoolean(DEJAR_SIN_EFECTO, pers.isDejar_sin_efecto().booleanValue());
		qInsert.setInt(OID_INDIVIDUO, pers.getIndividuoExcluido().getOID());
		if (pers.getGerenteExcluido() != null)
			qInsert.setInt(OID_GERENTE, pers.getGerenteExcluido().getOID());
		else
			qInsert.setNull(OID_GERENTE, java.sql.Types.INTEGER);
		qInsert.setBoolean(IRREVOCABLE, pers.isIrrevocable());
		if (pers.getPredio() != null)
			qInsert.setInt(OID_PREDIO, pers.getPredio().getOID());
		else
			qInsert.setNull(OID_PREDIO, java.sql.Types.INTEGER);
		
		if (pers.isRestriccionAcceso()!=null)
			qInsert.setBoolean(RESTRICCION_ACCESO, pers.isRestriccionAcceso());
		else
			qInsert.setBoolean(RESTRICCION_ACCESO, false);
		
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int FECHA = 1;
		final int HORA = 2;
		final int OID_ESTADO = 3;
		final int OID_LUGAR_HECHO = 4;
		final int OID_SE_RETIRA = 5;
		final int HORA_DESDE = 6;
		final int OID_MOTIVO = 7;
		final int OID_TURNO = 8;
		final int HORA_HASTA = 9;
		final int OID_SUPERVISOR = 10;
		final int OBSERVACION = 11;
		final int VIG_DESDE = 12;
		final int ACTIVO = 13;
		final int VIG_HASTA = 14;
		final int DEJAR_SIN_EFECTO = 15;
		final int OID_INDIVIDUO = 16;
		final int NRO_ACTA = 17;
		final int NRO_REVOCAMIENTO = 18;
		final int FEC_REV = 19;
		final int OID_GERENTE = 20;
		final int IRREVOCABLE = 21;
		final int OID_PREDIO = 22;
		final int RESTRICCION_ACCESO = 23;
		final int OID_NOVEDAD = 24;

		NovedadExcluido pers = (NovedadExcluido) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update excNovedades set " + "fecha=?" + ",hora=?" + ",oid_estado=?" + ",oid_lugar_hecho=?" + ",oid_se_retira=?"
				+ ",hora_desde=?" + ",oid_motivo=?" + ",oid_turno=?" + ",hora_hasta=?" + ",oid_supervisor=?" + ",observacion=?"
				+ ",vig_desde=?" + ",activo=?" + ",vig_hasta=?"
				+ ",dejar_sin_efecto=? , oid_individuo=? , nro_acta=? , nro_revocamiento=? , fec_rev=? , oid_gerente=? , irrevocable = ? , oid_predio=?, restriccion_acceso = ? " + " where "
				+ " oid_novedad=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_NOVEDAD, pers.getOID());
		if (pers.getFecha() != null)
			qUpdate.setDate(FECHA, new java.sql.Date(pers.getFecha().getTime()));
		else
			qUpdate.setNull(FECHA, java.sql.Types.INTEGER);
		qUpdate.setString(HORA, pers.getHora());
		qUpdate.setInt(OID_ESTADO, pers.getEstado().getOID());
		if (pers.getLugar_del_hecho() != null)
			qUpdate.setInt(OID_LUGAR_HECHO, pers.getLugar_del_hecho().getOID());
		else
			qUpdate.setNull(OID_LUGAR_HECHO, java.sql.Types.INTEGER);
		if (pers.getSe_retira_en() != null)
			qUpdate.setInt(OID_SE_RETIRA, pers.getSe_retira_en().getOID());
		else
			qUpdate.setNull(OID_SE_RETIRA, java.sql.Types.INTEGER);
		qUpdate.setString(HORA_DESDE, pers.getHora_desde());
		if (pers.getMotivo() != null)
			qUpdate.setInt(OID_MOTIVO, pers.getMotivo().getOID());
		else
			qUpdate.setNull(OID_MOTIVO, java.sql.Types.INTEGER);
		if (pers.getTurno() != null)
			qUpdate.setInt(OID_TURNO, pers.getTurno().getOID());
		else
			qUpdate.setNull(OID_TURNO, java.sql.Types.INTEGER);
		qUpdate.setString(HORA_HASTA, pers.getHora_hasta());
		if (pers.getSupervisor() != null)
			qUpdate.setInt(OID_SUPERVISOR, pers.getSupervisor().getOID());
		else
			qUpdate.setNull(OID_SUPERVISOR, java.sql.Types.INTEGER);

		if (pers.getObservacion() != null)
			qUpdate.setString(OBSERVACION, pers.getObservacion().replaceAll("Â", ""));
		else
			qUpdate.setNull(OBSERVACION, java.sql.Types.VARCHAR);

		if (pers.getVig_desde() != null)
			qUpdate.setDate(VIG_DESDE, new java.sql.Date(pers.getVig_desde().getTime()));
		else
			qUpdate.setNull(VIG_DESDE, java.sql.Types.DATE);
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		if (pers.getVig_hasta() != null)
			qUpdate.setDate(VIG_HASTA, new java.sql.Date(pers.getVig_hasta().getTime()));
		else
			qUpdate.setNull(VIG_HASTA, java.sql.Types.DATE);
		qUpdate.setBoolean(DEJAR_SIN_EFECTO, pers.isDejar_sin_efecto().booleanValue());
		qUpdate.setInt(OID_INDIVIDUO, pers.getIndividuoExcluido().getOID());
		if (pers.getnroActa() != null)
			qUpdate.setInt(NRO_ACTA, pers.getnroActa().intValue());
		else
			qUpdate.setNull(NRO_ACTA, java.sql.Types.INTEGER);

		if (pers.getnroRevocamiento() != null)
			qUpdate.setInt(NRO_REVOCAMIENTO, pers.getnroRevocamiento().intValue());
		else
			qUpdate.setNull(NRO_REVOCAMIENTO, java.sql.Types.INTEGER);

		if (pers.getFecRevocamiento() != null)
			qUpdate.setDate(FEC_REV, new java.sql.Date(pers.getFecRevocamiento().getTime()));
		else
			qUpdate.setNull(FEC_REV, java.sql.Types.DATE);
		if (pers.getGerenteExcluido() != null)
			qUpdate.setInt(OID_GERENTE, pers.getGerenteExcluido().getOID());
		else
			qUpdate.setNull(OID_GERENTE, java.sql.Types.INTEGER);
		qUpdate.setBoolean(IRREVOCABLE, pers.isIrrevocable());
		if (pers.getPredio() != null)
			qUpdate.setInt(OID_PREDIO, pers.getPredio().getOID());
		else
			qUpdate.setNull(OID_PREDIO, java.sql.Types.INTEGER);
		
		if (pers.isRestriccionAcceso()!=null)
			qUpdate.setBoolean(RESTRICCION_ACCESO, pers.isRestriccionAcceso());
		else
			qUpdate.setBoolean(RESTRICCION_ACCESO, false);
		
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_NOVEDAD = 1;
		NovedadExcluido pers = (NovedadExcluido) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update excNovedades " + " set activo=0 " + " where " + " oid_novedad=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_NOVEDAD, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_NOVEDAD = 1;
		NovedadExcluido pers = (NovedadExcluido) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update excNovedades " + " set activo=1 " + " where " + " oid_novedad=? ");
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
		case SELECT_BY_INDIVIDUO: {
			ps = this.selectByIndividuo(aCondiciones);
			break;
		}
		case SELECT_BY_ESTADO_NRO: {
			ps = this.selectByEstadoNro(aCondiciones);
			break;
		}
		case SELECT_BY_DISTIND_ESTADO_NRO: {
			ps = this.selectByDistIndEstNro(aCondiciones);
			break;			
		}
		case SELECT_BY_CONDICIONES: {
			ps = this.selectByCondiciones(aCondiciones);
			break;			
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_NOVEDAD = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  excNovedades ");
		textSQL.append(" WHERE oid_novedad = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_NOVEDAD, oid);
		return querySelect;
	}

	private PreparedStatement selectByCondiciones(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  excNovedades ");
		textSQL.append(" WHERE nro_revocamiento is not null and nro_revocamiento<>0 and  activo = 1  ");
		
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		
		Integer oidEstado  = (Integer) condiciones.get("OID_ESTADO");
		if (oidEstado!=null)
			textSQL.append(" and oid_estado="+oidEstado);
		
		Integer nroActaDesde = (Integer) condiciones.get("NRO_ACTA_DESDE");
		if (nroActaDesde!=null)
			textSQL.append(" and nro_acta>="+nroActaDesde);
		
		Integer nroActaHasta = (Integer) condiciones.get("NRO_ACTA_HASTA");
		if (nroActaHasta!=null)
			textSQL.append(" and nro_acta<="+nroActaHasta);		
		
		Integer nroActaDesdeLev = (Integer) condiciones.get("NRO_ACTA_LEV_DESDE");
		if (nroActaDesdeLev!=null)
			textSQL.append(" and nro_revocamiento>="+nroActaDesdeLev);		
		
		Integer nroActaHastaLev = (Integer) condiciones.get("NRO_ACTA_LEV_HASTA");
		if (nroActaHastaLev!=null)
			textSQL.append(" and nro_revocamiento<="+nroActaHastaLev);		
		
		// Agregar las fechas
		
		java.util.Date fecDesdeEstado = (java.util.Date) condiciones.get("FEC_DESDE_ESTADO");
		java.util.Date fecHastaEstado = (java.util.Date) condiciones.get("FEC_HASTA_ESTADO");
		
		java.util.Date fecLevDesde = (java.util.Date) condiciones.get("FEC_LEV_DESDE");
		java.util.Date fecLevHasta = (java.util.Date) condiciones.get("FEC_LEV_HASTA");
		
		if (fecDesdeEstado!=null)
			textSQL.append(" and fecha>=? ");
		
		if (fecHastaEstado!=null)
			textSQL.append(" and fecha<=? ");
		
		if (fecLevDesde!=null)
			textSQL.append(" and fec_rev>=? ");
		
		if (fecLevHasta!=null)
			textSQL.append(" and fec_rev<=? ");		
		
		
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		
		int param = 0;
		if (fecDesdeEstado!=null) {
			++param;
			querySelect.setDate(param, new java.sql.Date(fecDesdeEstado.getTime()));
		}
		if (fecHastaEstado!=null) {
			++param;
			querySelect.setDate(param, new java.sql.Date(fecHastaEstado.getTime()));
		}		
		if (fecLevDesde!=null) {
			++param;
			querySelect.setDate(param, new java.sql.Date(fecLevDesde.getTime()));
		}		
		if (fecLevHasta!=null) {
			++param;
			querySelect.setDate(param, new java.sql.Date(fecLevHasta.getTime()));
		}		
		
		
		
		return querySelect;
	}
	
	private PreparedStatement selectByDistIndEstNro(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  excNovedades ");
		textSQL.append(" WHERE oid_estado = ? and activo=1 and nro_acta=? and oid_individuo<>?  ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		EstadoExcluido estado = (EstadoExcluido) condiciones.get(EstadoExcluido.NICKNAME);
		Integer oidIndividuo = (Integer) condiciones.get("OID_INDIVIDUO");
		Integer nroActa = (Integer) condiciones.get("NRO_ACTA");
		querySelect.setInt(1, estado.getOID());
		querySelect.setInt(2, nroActa.intValue());
		querySelect.setInt(3, oidIndividuo.intValue());
		return querySelect;
	}
	
	

	private PreparedStatement selectByEstadoNro(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append(" SELECT "); 
		textSQL.append("   a.* "); 
		textSQL.append("   FROM ");  
		textSQL.append("     excNovedades a , excindividuo b "); 
		textSQL.append("   where "); 
		textSQL.append("     a.oid_individuo = b.oid_individuo and "); 
		textSQL.append("     b.activo=1 and "); 
		textSQL.append("     a.oid_estado = ? and "); 
		textSQL.append("     a.activo=1 and "); 
		textSQL.append("     a.nro_acta=? ");		
		
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		EstadoExcluido estado = (EstadoExcluido) condiciones.get(EstadoExcluido.NICKNAME);
		Integer nroActa = (Integer) condiciones.get("NRO_ACTA");
		querySelect.setInt(1, estado.getOID());
		querySelect.setInt(2, nroActa.intValue());
		return querySelect;
	}

	private PreparedStatement selectByIndividuo(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  excNovedades ");
		textSQL.append(" WHERE oid_individuo = ? and activo=1 order by vig_desde, oid_novedad  ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		IndividuoExcluido individuo = (IndividuoExcluido) aCondiciones;
		querySelect.setInt(1, individuo.getOID());
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  excNovedades ");
		textSQL.append(" WHERE fecha = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_novedad oid,fecha codigo,  descripcion ,activo ");
		textSQL.append(" from excNovedades");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static List getNovedadesExcluido(IndividuoExcluido individuo, ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(NovedadExcluido.NICKNAME, DBNovedadExcluido.SELECT_BY_INDIVIDUO, individuo,
				new ListObserver(), aSesion);
	}

	public static List getNovedadesEstadoyNroActa(EstadoExcluido estado, Integer nroActa, ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(EstadoExcluido.NICKNAME, estado);
		condiciones.put("NRO_ACTA", nroActa);
		return (List) ObjetoLogico.getObjects(NovedadExcluido.NICKNAME, DBNovedadExcluido.SELECT_BY_ESTADO_NRO, condiciones,
				new ListObserver(), aSesion);
	}
	
	public static List getNovedadesDistIndEstadoyNroActa(Integer oidIndividuo, EstadoExcluido estado, Integer nroActa, ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(EstadoExcluido.NICKNAME, estado);
		condiciones.put("NRO_ACTA", nroActa);
		condiciones.put("OID_INDIVIDUO", oidIndividuo);
		return (List) ObjetoLogico.getObjects(NovedadExcluido.NICKNAME, DBNovedadExcluido.SELECT_BY_ESTADO_NRO, condiciones,
				new ListObserver(), aSesion);
	}	
	
	public static List getNovedadesByCondiciones(HashTableDatos condiciones, ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(
				NovedadExcluido.NICKNAME, 
				DBNovedadExcluido.SELECT_BY_CONDICIONES, 
				condiciones,
				new ListObserver(), aSesion);
	}	

}
