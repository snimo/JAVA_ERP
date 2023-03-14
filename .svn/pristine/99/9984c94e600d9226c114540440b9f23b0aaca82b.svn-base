package com.srn.erp.cip.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.cip.bm.EstadoCIP;
import com.srn.erp.cip.bm.MotEntInterEst;
import com.srn.erp.cip.bm.MotivoEntIntermedias;
import com.srn.erp.general.bm.PeriodoInc;
import com.srn.erp.general.bm.PeriodoIncDet;
import com.srn.erp.general.da.DBPeriodoIncDet;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBMotEntInterEst extends DBObjetoPersistente {

	public static final String OID_MOT_EST_INT = "oid_mot_est_int";
	public static final String OID_MOTIVO = "oid_motivo";
	public static final String OID_ESTADO = "oid_estado";
	public static final String ACTIVO = "activo";
	
	public static final int SELECT_BY_MOTIVO_ESTADO = 100;
	public static final int SELECT_BY_ESTADO = 101;

	public DBMotEntInterEst() {
	}

	protected void insert(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {

		final int OID_MOT_EST_INT = 1;
		final int OID_MOTIVO = 2;
		final int OID_ESTADO = 3;
		final int ACTIVO = 4;

		MotEntInterEst pers = (MotEntInterEst) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into cipMotEntIntEst " + " ( "
				+ "OID_MOT_EST_INT," + "OID_MOTIVO," + "OID_ESTADO,"
				+ "ACTIVO)" + " values " + "(" + "?," + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD()
				.prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_MOT_EST_INT, pers.getOID());
		qInsert.setInt(OID_MOTIVO, pers.getMotivo().getOID());
		qInsert.setInt(OID_ESTADO, pers.getEstado().getOID());
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {

		final int OID_MOTIVO = 1;
		final int OID_ESTADO = 2;
		final int ACTIVO = 3;
		final int OID_MOT_EST_INT = 4;

		MotEntInterEst pers = (MotEntInterEst) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update cipMotEntIntEst set " + "oid_motivo=?"
				+ ",oid_estado=?" + ",activo=?" + " where "
				+ " oid_mot_est_int=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_MOT_EST_INT, pers.getOID());
		qUpdate.setInt(OID_MOTIVO, pers.getMotivo().getOID());
		qUpdate.setInt(OID_ESTADO, pers.getEstado().getOID());
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {
		final int OID_MOT_EST_INT = 1;
		MotEntInterEst pers = (MotEntInterEst) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cipMotEntIntEst " + " set activo=0 "
				+ " where " + " oid_mot_est_int=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_MOT_EST_INT, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {
		final int OID_MOT_EST_INT = 1;
		MotEntInterEst pers = (MotEntInterEst) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cipMotEntIntEst " + " set activo=1 "
				+ " where " + " oid_mot_est_int=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_MOT_EST_INT, pers.getOID());
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
		case SELECT_BY_MOTIVO_ESTADO: {
			ps = this.selectByMotivoEstado(aCondiciones);
			break;
		}
		case SELECT_BY_ESTADO: {
			ps = this.selectByEstado(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones)
			throws BaseException, SQLException {

		final int OID_MOT_EST_INT = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cipMotEntIntEst ");
		textSQL.append(" WHERE oid_mot_est_int = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_MOT_EST_INT, oid);
		return querySelect;
	}

	private PreparedStatement selectByEstado(Object aCondiciones)
		throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cipMotEntIntEst ");
		textSQL.append(" WHERE oid_estado = ? and activo = 1 ");
		EstadoCIP estadoCIP = (EstadoCIP) aCondiciones;
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		querySelect.setInt(1, estadoCIP.getOID());
		return querySelect;
	}
	
	private PreparedStatement selectByMotivoEstado(Object aCondiciones)
		throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cipMotEntIntEst ");
		textSQL.append(" WHERE oid_motivo = ? and oid_estado = ? and activo = 1 ");
		
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		MotivoEntIntermedias motivo = (MotivoEntIntermedias) condiciones.get(MotivoEntIntermedias.NICKNAME);
		EstadoCIP estadoCIP = (EstadoCIP) condiciones.get(EstadoCIP.NICKNAME);
		
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		querySelect.setInt(1, motivo.getOID());
		querySelect.setInt(2, estadoCIP.getOID());
		
		return querySelect;
	}
	
	
	private PreparedStatement selectByCodigo(Object aCondiciones)
			throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cipMotEntIntEst ");
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
				.append("SELECT oid_mot_est_int oid, codigo,  descripcion ,activo ");
		textSQL.append(" from cipMotEntIntEst");

		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		return querySelect;
	}
	
	  public static MotEntInterEst getMotEntInterEstado(MotivoEntIntermedias motivo, EstadoCIP estado,
	          ISesion aSesion)
	          throws BaseException {
		  HashTableDatos condiciones = new HashTableDatos();
		  condiciones.put(MotivoEntIntermedias.NICKNAME, motivo);
		  condiciones.put(EstadoCIP.NICKNAME, estado);
		  
		  return (MotEntInterEst) ObjetoLogico.getObjects(MotEntInterEst.NICKNAME,
				  				DBMotEntInterEst.SELECT_BY_MOTIVO_ESTADO,
				  				condiciones,
				  				new ObjetoObservado(),
				  				aSesion);
	  }
	  
	  public static List getMotEntInterEst(EstadoCIP estado,
              ISesion aSesion) throws BaseException {
		  return (List) ObjetoLogico.getObjects(MotEntInterEst.NICKNAME,
                 DBMotEntInterEst.SELECT_BY_ESTADO,
                 estado,
                 new ListObserver(),
                 aSesion);
	  }
	  
	

}
