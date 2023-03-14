package com.srn.erp.cip.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.srn.erp.cip.bm.PrepararStatus;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ObjetoObservado;

public class DBPrepararStatus extends DBObjetoPersistente {

	public static final String OID_PUERTA = "oid_puerta";
	public static final String FEC_ULT_STATUS = "fec_ult_status";
	public static final String HORA_ULT_STATUS = "hora_ult_status";
	public static final String ACTIVO = "activo";

	public static final int SELECT_BY_IDENTIF_PUERTA = 100;

	public DBPrepararStatus() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int FEC_ULT_STATUS = 1;
		final int HORA_ULT_STATUS = 2;
		final int OID_PUERTA = 3;
		
		PrepararStatus pers = (PrepararStatus) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update cipPuerta set fec_ult_status=?,hora_ult_status=? "+
				" where " + " oid_puerta=? ");
		
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_PUERTA, pers.getOID());
		
		if (pers.getFecha_ultStatus()!=null)
			qUpdate.setDate(FEC_ULT_STATUS, new java.sql.Date(pers.getFecha_ultStatus().getTime()));
		else
			qUpdate.setNull(FEC_ULT_STATUS, java.sql.Types.DATE);
		
		if (pers.getHora_ultStatus()!=null)
			qUpdate.setString(HORA_ULT_STATUS, pers.getHora_ultStatus());
		else
			qUpdate.setNull(HORA_ULT_STATUS, java.sql.Types.VARCHAR);
		
		qUpdate.executeUpdate();
		qUpdate.close();
		
		
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
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
		case SELECT_BY_IDENTIF_PUERTA: {
			ps = this.selectByIdentifPuerta(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_PREP_LB = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cipPrepararLB ");
		textSQL.append(" WHERE oid_prep_lb = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_PREP_LB, oid);
		return querySelect;
	}

	private PreparedStatement selectByIdentifPuerta(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cipPuerta ");
		textSQL.append(" WHERE identif_puerta = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String identifPuerta = (String) aCondiciones;
		querySelect.setString(1, identifPuerta);
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cipPrepararLB ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
		
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_prep_lb oid, codigo,  descripcion ,activo ");
		textSQL.append(" from cipPuerta");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}
	
	public static PrepararStatus getPuertaByIdentif(String identif, ISesion aSesion) throws BaseException {
		return (PrepararStatus) ObjetoLogico.getObjects(PrepararStatus.NICKNAME, DBPrepararStatus.SELECT_BY_IDENTIF_PUERTA, identif, new ObjetoObservado(), aSesion);
	}
	

}
