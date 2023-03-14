package com.srn.erp.cip.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.srn.erp.cip.bm.ZonaCIP;

import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class DBZonaCIP extends DBObjetoPersistente {

	public static final String OID_ZONA = "oid_zona";
	public static final String CODIGO = "codigo";
	public static final String ACTIVO = "activo";
	public static final String COLOR = "color";
	public static final String DESCRIPCION = "descripcion";
	public static final String OID_TIPO_ZONA = "oid_tipo_zona";
	public static final String CAPACIDAD_MAX = "capacidad_max";
	public static final String ALARMA_DE_CAP = "alarma_de_cap";
	public static final String BLOQUEAR_EXC_CAP = "bloquear_exc_cap";
	public static final String ESTADO_ZONA = "estado_zona";
	public static final String UBICACION = "ubicacion";
	public static final String OID_GRUPO_USU_ALAR = "oid_grupo_usu_alar";
	public static final String OID_GRUPO_MAQ_ALAR = "oid_grupo_maq_alar";
	public static final String MENS_ALAR_CAP_MAX = "mens_alar_cap_max";
	public static final String OID_RING_MAX_CAP = "oid_ring_max_cap";
	public static final String ES_EXTERNA = "es_externa";
	public static final String CONTROLA_ANTI_ENT = "controla_anti_ent";
	public static final String CONTROLA_ANTI_SAL = "controla_anti_sal";
	
	public DBZonaCIP() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_ZONA = 1;
		final int CODIGO = 2;
		final int ACTIVO = 3;
		final int COLOR = 4;
		final int DESCRIPCION = 5;
		final int OID_TIPO_ZONA = 6;
		final int CAPACIDAD_MAX = 7;
		final int ALARMA_DE_CAP = 8;
		final int BLOQUEAR_EXC_CAP = 9;
		final int ESTADO_ZONA = 10;
		final int UBICACION = 11;
		final int OID_GRUPO_USU_ALAR = 12;
		final int OID_GRUPO_MAQ_ALAR = 13;
		final int MENS_ALAR_CAP_MAX = 14;
		final int OID_RING_MAX_CAP = 15;
		final int ES_EXTERNA = 16;
		final int CONTROLA_ANTI_ENT = 17;
		final int CONTROLA_ANTI_SAL = 18;
		

		ZonaCIP pers = (ZonaCIP) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into cipZona " + " ( " + "OID_ZONA," + "CODIGO," + "ACTIVO," + "COLOR," + "DESCRIPCION,"
				+ "OID_TIPO_ZONA," + "CAPACIDAD_MAX," + "ALARMA_DE_CAP," + "BLOQUEAR_EXC_CAP," + "ESTADO_ZONA," + "UBICACION,"
				+ "OID_GRUPO_USU_ALAR," + "OID_GRUPO_MAQ_ALAR," + "MENS_ALAR_CAP_MAX," + "OID_RING_MAX_CAP , ES_EXTERNA , CONTROLA_ANTI_ENT , CONTROLA_ANTI_SAL)" + " values " + "(" + "?,"
				+ "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?,"+ "?,"+ "?," + "?," + "?,"+ "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_ZONA, pers.getOID());
		qInsert.setString(CODIGO, pers.getCodigo());
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qInsert.setString(COLOR, pers.getColor());
		qInsert.setString(DESCRIPCION, pers.getDescripcion());
		if (pers.getOid_tipo_zona()!=null)
			qInsert.setInt(OID_TIPO_ZONA, pers.getOid_tipo_zona().getOID());
		else
			qInsert.setNull(OID_TIPO_ZONA, java.sql.Types.INTEGER);
		if (pers.getCapacidad_max()!=null)
			qInsert.setInt(CAPACIDAD_MAX, pers.getCapacidad_max().intValue());
		else
			qInsert.setNull(CAPACIDAD_MAX, java.sql.Types.INTEGER);
		if (pers.getAlarma_de_cap()!=null)
			qInsert.setInt(ALARMA_DE_CAP, pers.getAlarma_de_cap().intValue());
		else
			qInsert.setNull(ALARMA_DE_CAP, java.sql.Types.INTEGER);
		qInsert.setBoolean(BLOQUEAR_EXC_CAP, pers.isBloquear_exc_cap().booleanValue());
		qInsert.setString(ESTADO_ZONA, pers.getEstado_zona());
		qInsert.setString(UBICACION, pers.getUbicacion());
		if (pers.getGrupo_usu_alar() != null)
			qInsert.setInt(OID_GRUPO_USU_ALAR, pers.getGrupo_usu_alar().getOID());
		else
			qInsert.setNull(OID_GRUPO_USU_ALAR, java.sql.Types.INTEGER);
		if (pers.getGrupo_maq_alar() != null)
			qInsert.setInt(OID_GRUPO_MAQ_ALAR, pers.getGrupo_maq_alar().getOID());
		else
			qInsert.setNull(OID_GRUPO_MAQ_ALAR, java.sql.Types.INTEGER);
		qInsert.setString(MENS_ALAR_CAP_MAX, pers.getMens_alar_cap_max());
		if (pers.getRing_max_cap() != null)
			qInsert.setInt(OID_RING_MAX_CAP, pers.getRing_max_cap().getOID());
		else
			qInsert.setNull(OID_RING_MAX_CAP, java.sql.Types.INTEGER);
		qInsert.setBoolean(ES_EXTERNA, pers.esExterna());
		qInsert.setBoolean(CONTROLA_ANTI_ENT, pers.isControlaAntiEnt());
		qInsert.setBoolean(CONTROLA_ANTI_SAL, pers.isControlaAntiSal());
		
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int CODIGO = 1;
		final int ACTIVO = 2;
		final int COLOR = 3;
		final int DESCRIPCION = 4;
		final int OID_TIPO_ZONA = 5;
		final int CAPACIDAD_MAX = 6;
		final int ALARMA_DE_CAP = 7;
		final int BLOQUEAR_EXC_CAP = 8;
		final int ESTADO_ZONA = 9;
		final int UBICACION = 10;
		final int OID_GRUPO_USU_ALAR = 11;
		final int OID_GRUPO_MAQ_ALAR = 12;
		final int MENS_ALAR_CAP_MAX = 13;
		final int OID_RING_MAX_CAP = 14;
		final int ES_EXTERNA = 15;
		final int CONTROLA_ANTI_ENT = 16;
		final int CONTROLA_ANTI_SAL = 17;
		final int OID_ZONA = 18;

		ZonaCIP pers = (ZonaCIP) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update cipZona set " + "codigo=?" + ",activo=?" + ",color=?" + ",descripcion=?" + ",oid_tipo_zona=?"
				+ ",capacidad_max=?" + ",alarma_de_cap=?" + ",bloquear_exc_cap=?" + ",estado_zona=?" + ",ubicacion=?"
				+ ",oid_grupo_usu_alar=?" + ",oid_grupo_maq_alar=?" + ",mens_alar_cap_max=?" + ",oid_ring_max_cap=? , es_externa = ? , controla_anti_ent = ? , controla_anti_sal = ? " + " where "
				+ " oid_zona=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_ZONA, pers.getOID());
		qUpdate.setString(CODIGO, pers.getCodigo());
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qUpdate.setString(COLOR, pers.getColor());
		qUpdate.setString(DESCRIPCION, pers.getDescripcion());
		if (pers.getOid_tipo_zona()!=null)
			qUpdate.setInt(OID_TIPO_ZONA, pers.getOid_tipo_zona().getOID());
		else
			qUpdate.setNull(OID_TIPO_ZONA, java.sql.Types.INTEGER);
		if (pers.getCapacidad_max()!=null)
			qUpdate.setInt(CAPACIDAD_MAX, pers.getCapacidad_max().intValue());
		else
			qUpdate.setNull(CAPACIDAD_MAX, java.sql.Types.INTEGER);
		if (pers.getAlarma_de_cap()!=null)
			qUpdate.setInt(ALARMA_DE_CAP, pers.getAlarma_de_cap().intValue());
		else
			qUpdate.setNull(ALARMA_DE_CAP, java.sql.Types.INTEGER);
		qUpdate.setBoolean(BLOQUEAR_EXC_CAP, pers.isBloquear_exc_cap().booleanValue());
		qUpdate.setString(ESTADO_ZONA, pers.getEstado_zona());
		qUpdate.setString(UBICACION, pers.getUbicacion());
		if (pers.getGrupo_usu_alar() != null)
			qUpdate.setInt(OID_GRUPO_USU_ALAR, pers.getGrupo_usu_alar().getOID());
		else
			qUpdate.setNull(OID_GRUPO_USU_ALAR, java.sql.Types.INTEGER);
		if (pers.getGrupo_maq_alar() != null)
			qUpdate.setInt(OID_GRUPO_MAQ_ALAR, pers.getGrupo_maq_alar().getOID());
		else
			qUpdate.setNull(OID_GRUPO_MAQ_ALAR, java.sql.Types.INTEGER);
		qUpdate.setString(MENS_ALAR_CAP_MAX, pers.getMens_alar_cap_max());
		if (pers.getRing_max_cap() != null)
			qUpdate.setInt(OID_RING_MAX_CAP, pers.getRing_max_cap().getOID());
		else
			qUpdate.setNull(OID_RING_MAX_CAP, java.sql.Types.INTEGER);
		qUpdate.setBoolean(ES_EXTERNA, pers.esExterna());
		qUpdate.setBoolean(CONTROLA_ANTI_ENT, pers.isControlaAntiEnt());
		qUpdate.setBoolean(CONTROLA_ANTI_SAL, pers.isControlaAntiSal());
		
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_ZONA = 1;
		ZonaCIP pers = (ZonaCIP) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cipZona " + " set activo=0 " + " where " + " oid_zona=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_ZONA, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_ZONA = 1;
		ZonaCIP pers = (ZonaCIP) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cipZona " + " set activo=1 " + " where " + " oid_zona=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_ZONA, pers.getOID());
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
		case IDBObjetoPersistente.SELECT_ALL_ACTIVOS_HELP: {
			ps = this.selectAllHelpActivos(aCondiciones);
			break;
		}		
		 
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_ZONA = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cipZona ");
		textSQL.append(" WHERE oid_zona = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_ZONA, oid);
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cipZona ");
		textSQL.append(" WHERE codigo = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelpActivos(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_zona oid,codigo codigo,  descripcion ,activo ");
		textSQL.append(" from cipZona where activo=1 ");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}
	
	
	
	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_zona oid,codigo codigo,  descripcion ,activo ");
		textSQL.append(" from cipZona");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

}
