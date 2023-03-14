package com.srn.erp.compras.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.compras.bm.InformeControlCalidadDet;
import com.srn.erp.compras.bm.MotivoRechazoInfCC;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBMotivoRechazoInfCC extends DBObjetoPersistente {

	public static final String OID_MOT_RECH_CC = "oid_mot_rech_cc";

	public static final String OID_CC_DET = "oid_cc_det";

	public static final String CANT_MAL_UC = "cant_mal_uc";

	public static final String CANT_MAL_US = "cant_mal_us";

	public static final String ACTIVO = "activo";

	public static final String OID_MOTIVO = "oid_motivo";

	public static final int SELECT_BY_INF_CC_DET = 100;

	public DBMotivoRechazoInfCC() {
	}

	protected void insert(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {

		final int OID_MOT_RECH_CC = 1;
		final int OID_CC_DET = 2;
		final int CANT_MAL_UC = 3;
		final int CANT_MAL_US = 4;
		final int ACTIVO = 5;
		final int OID_MOTIVO = 6;

		MotivoRechazoInfCC pers = (MotivoRechazoInfCC) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into cpMotRecInfCC " + " ( "
				+ "OID_MOT_RECH_CC," + "OID_CC_DET," + "CANT_MAL_UC,"
				+ "CANT_MAL_US," + "ACTIVO," + "OID_MOTIVO)" + " values " + "("
				+ "?," + "?," + "?," + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD()
				.prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_MOT_RECH_CC, pers.getOID());
		qInsert.setInt(OID_CC_DET, pers.getInf_cc_det().getOID());
		qInsert.setDouble(CANT_MAL_UC, pers.getCant_mal_uc().doubleValue());
		qInsert.setDouble(CANT_MAL_US, pers.getCant_mal_us().doubleValue());
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qInsert.setInt(OID_MOTIVO, pers.getMotivoRechazoCC().getOID());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {

		final int OID_CC_DET = 1;
		final int CANT_MAL_UC = 2;
		final int CANT_MAL_US = 3;
		final int ACTIVO = 4;
		final int OID_MOTIVO = 5;
		final int OID_MOT_RECH_CC = 5;

		MotivoRechazoInfCC pers = (MotivoRechazoInfCC) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update cpMotRecInfCC set " + "oid_cc_det=?"
				+ ",cant_mal_uc=?" + ",cant_mal_us=?" + ",activo=?"
				+ ",oid_motivo=?" + " where " + " oid_mot_rech_cc=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_MOT_RECH_CC, pers.getOID());
		qUpdate.setInt(OID_CC_DET, pers.getInf_cc_det().getOID());
		qUpdate.setDouble(CANT_MAL_UC, pers.getCant_mal_uc().doubleValue());
		qUpdate.setDouble(CANT_MAL_US, pers.getCant_mal_us().doubleValue());
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qUpdate.setInt(OID_MOTIVO, pers.getMotivoRechazoCC().getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {
		final int OID_MOT_RECH_CC = 1;
		MotivoRechazoInfCC pers = (MotivoRechazoInfCC) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cpMotRecInfCC " + " set activo=0 " + " where "
				+ " oid_mot_rech_cc=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_MOT_RECH_CC, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {
		final int OID_MOT_RECH_CC = 1;
		MotivoRechazoInfCC pers = (MotivoRechazoInfCC) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cpMotRecInfCC " + " set activo=1 " + " where "
				+ " oid_mot_rech_cc=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_MOT_RECH_CC, pers.getOID());
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
		case SELECT_BY_INF_CC_DET: {
			ps = this.selectByInfCCDet(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones)
			throws BaseException, SQLException {

		final int OID_MOT_RECH_CC = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cpMotRecInfCC ");
		textSQL.append(" WHERE oid_mot_rech_cc = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_MOT_RECH_CC, oid);
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones)
			throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cpMotRecInfCC ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectByInfCCDet(Object aCondiciones)
			throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cpMotRecInfCC ");
		textSQL.append(" WHERE oid_cc_det = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		InformeControlCalidadDet infCCDet = (InformeControlCalidadDet) aCondiciones;
		querySelect.setInt(1, infCCDet.getOID());
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones)
			throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL
				.append("SELECT oid_mot_rech_cc oid, codigo,  descripcion ,activo ");
		textSQL.append(" from cpMotRecInfCC");

		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		return querySelect;
	}
	
	public static List getMotivosRechazoInfCCDet(InformeControlCalidadDet aInfCCDet,
			ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(MotivoRechazoInfCC.NICKNAME,
				DBMotivoRechazoInfCC.SELECT_BY_INF_CC_DET, aInfCCDet,
				new ListObserver(), aSesion);
	}
	

}
