package com.srn.erp.compras.da;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import com.srn.erp.compras.bm.RequisicionDet;
import com.srn.erp.compras.bm.RequisicionDetAutorizacion;
import com.srn.erp.compras.bm.RolAutorizadorCompras;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBRequisicionDetAutorizacion extends DBObjetoPersistente {

	public static final String OID_REQ_AUTORIZ = "oid_req_autoriz";

	public static final String OID_REQ_DET = "oid_req_det";

	public static final String OID_USUARIO = "oid_usuario";

	public static final String DECISION_AUTORIZ = "decision_autoriz";

	public static final String FEC_DECISION = "fec_decision";

	public static final String COMENTARIO = "comentario";

	public static final String TIPO_AUTORIZACION = "tipo_autorizacion";

	public static final String OID_ROL_AUTORIZ = "oid_rol_autoriz";

	public static final int SELECT_BY_OID_REQ_DET = 100;
	public static final int SELECT_BY_REQ_DET_ROL_AUTORIZ = 101;

	public DBRequisicionDetAutorizacion() {
	}

	protected void insert(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {

		final int OID_REQ_AUTORIZ = 1;
		final int OID_REQ_DET = 2;
		final int OID_USUARIO = 3;
		final int DECISION_AUTORIZ = 4;
		final int FEC_DECISION = 5;
		final int COMENTARIO = 6;
		final int TIPO_AUTORIZACION = 7;
		final int OID_ROL_AUTORIZ = 8;

		RequisicionDetAutorizacion pers = (RequisicionDetAutorizacion) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into cpRequiDetAutoriz " + " ( "
				+ "OID_REQ_AUTORIZ," + "OID_REQ_DET," + "OID_USUARIO,"
				+ "DECISION_AUTORIZ," + "FEC_DECISION," + "COMENTARIO,"
				+ "TIPO_AUTORIZACION," + "OID_ROL_AUTORIZ)" + " values " + "("
				+ "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD()
				.prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_REQ_AUTORIZ, pers.getOID());
		qInsert.setInt(OID_REQ_DET, pers.getRequesicion_detalle().getOID());
		if (pers.getUsuario()!=null)
		  qInsert.setInt(OID_USUARIO, pers.getUsuario().getOID());
		else
		  qInsert.setNull(OID_USUARIO, Types.INTEGER);
		qInsert.setInt(DECISION_AUTORIZ, pers.getDecision_autoriz().intValue());
		if (pers.getFec_decision() != null)
			qInsert.setDate(FEC_DECISION, new java.sql.Date(pers
					.getFec_decision().getTime()));
		else
			qInsert.setNull(FEC_DECISION, java.sql.Types.DATE);
		qInsert.setString(COMENTARIO, pers.getComentario());
		qInsert.setString(TIPO_AUTORIZACION, pers.getTipo_autorizacion());
		qInsert.setInt(OID_ROL_AUTORIZ, pers.getRolAutorizadorCompras()
				.getOID());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {

		final int OID_REQ_DET = 1;
		final int OID_USUARIO = 2;
		final int DECISION_AUTORIZ = 3;
		final int FEC_DECISION = 4;
		final int COMENTARIO = 5;
		final int TIPO_AUTORIZACION = 6;
		final int OID_ROL_AUTORIZ = 7;
		final int OID_REQ_AUTORIZ = 8;

		RequisicionDetAutorizacion pers = (RequisicionDetAutorizacion) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update cpRequiDetAutoriz set " + "oid_req_det=?"
				+ ",oid_usuario=?" + ",decision_autoriz=?" + ",fec_decision=?"
				+ ",comentario=?" + ",tipo_autorizacion=?"
				+ ",oid_rol_autoriz=?" + " where " + " oid_req_autoriz=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_REQ_AUTORIZ, pers.getOID());
		qUpdate.setInt(OID_REQ_DET, pers.getRequesicion_detalle().getOID());
		
		
		if (pers.getUsuario()!=null)
			qUpdate.setInt(OID_USUARIO, pers.getUsuario().getOID());
		else
			qUpdate.setNull(OID_USUARIO, Types.INTEGER);		
		qUpdate.setInt(DECISION_AUTORIZ, pers.getDecision_autoriz().intValue());
		if (pers.getFec_decision() != null)
			qUpdate.setDate(FEC_DECISION, new Date(pers.getFec_decision()
					.getTime()));
		else
			qUpdate.setNull(FEC_DECISION, java.sql.Types.DATE);
		qUpdate.setString(COMENTARIO, pers.getComentario());
		qUpdate.setInt(OID_ROL_AUTORIZ, pers.getRolAutorizadorCompras()
				.getOID());
		qUpdate.setString(TIPO_AUTORIZACION, pers.getTipo_autorizacion());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {
		final int OID_REQ_AUTORIZ = 1;
		RequisicionDetAutorizacion pers = (RequisicionDetAutorizacion) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("delete from cpRequiDetAutoriz "  
				+ " where " + " oid_req_autoriz=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_REQ_AUTORIZ, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {
		final int OID_REQ_AUTORIZ = 1;
		RequisicionDetAutorizacion pers = (RequisicionDetAutorizacion) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cpRequiDetAutoriz " + " set activo=1 "
				+ " where " + " oid_req_autoriz=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_REQ_AUTORIZ, pers.getOID());
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
		case SELECT_BY_OID_REQ_DET: {
			ps = this.selectByReqDet(aCondiciones);
			break;
		}
		case SELECT_BY_REQ_DET_ROL_AUTORIZ: {
			ps = this.selectByReqDetRolAutoriz(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones)
			throws BaseException, SQLException {

		final int OID_REQ_AUTORIZ = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cpRequiDetAutoriz ");
		textSQL.append(" WHERE oid_req_autoriz = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_REQ_AUTORIZ, oid);
		return querySelect;
	}

	private PreparedStatement selectByReqDet(Object aCondiciones)
			throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cpRequiDetAutoriz ");
		textSQL.append(" WHERE oid_req_det = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		RequisicionDet requisicionDet = (RequisicionDet) aCondiciones;
		querySelect.setInt(1, requisicionDet.getOID());
		return querySelect;
	}
	
	private PreparedStatement selectByReqDetRolAutoriz(Object aCondiciones)
	throws BaseException, SQLException {
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		RequisicionDet requiDet = (RequisicionDet) condiciones.get(RequisicionDet.NICKNAME);
		RolAutorizadorCompras rolAutorizCompras = (RolAutorizadorCompras) condiciones.get(RolAutorizadorCompras.NICKNAME);
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cpRequiDetAutoriz ");
		textSQL.append(" WHERE oid_req_det = ? and oid_rol_autoriz=? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		querySelect.setInt(1, requiDet.getOID());
		querySelect.setInt(2, rolAutorizCompras.getOID());
		return querySelect;
	}
	
	
	private PreparedStatement selectByCodigo(Object aCondiciones)
			throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cpRequiDetAutoriz ");
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
				.append("SELECT oid_req_autoriz oid, codigo,  descripcion ,activo ");
		textSQL.append(" from cpRequiDetAutoriz");

		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		return querySelect;
	}
	
	public static List getAutorizadoresRequisicionDet(
			RequisicionDet requisicionDet,
			ISesion aSesion)
			throws BaseException {		
		return (List) ObjetoLogico.getObjects(RequisicionDetAutorizacion.NICKNAME,
				DBRequisicionDetAutorizacion.SELECT_BY_OID_REQ_DET,
				requisicionDet, new ListObserver(), aSesion);
	}
	
	public static RequisicionDetAutorizacion getAutorizadorRequisicionDet(
			RequisicionDet requisicionDet,
			RolAutorizadorCompras rolAutorizCompras,
			ISesion aSesion)
			throws BaseException {		
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(RequisicionDet.NICKNAME, requisicionDet);
		condiciones.put(RolAutorizadorCompras.NICKNAME, rolAutorizCompras);
		
		return (RequisicionDetAutorizacion) ObjetoLogico.getObjects(RequisicionDetAutorizacion.NICKNAME,
				DBRequisicionDetAutorizacion.SELECT_BY_REQ_DET_ROL_AUTORIZ,
				condiciones, new ObjetoObservado(), aSesion);
	}	
	

}
