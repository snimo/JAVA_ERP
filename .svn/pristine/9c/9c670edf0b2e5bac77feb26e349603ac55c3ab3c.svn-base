package com.srn.erp.compras.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.compras.bm.AplicRequiDet;
import com.srn.erp.compras.bm.OrdenDeCompraDet;
import com.srn.erp.compras.bm.RequisicionDet;
import com.srn.erp.general.bm.PeriodoIncDet;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBAplicRequiDet extends DBObjetoPersistente {

	public static final String OID_DET_OC_REQUI = "oid_det_oc_requi";

	public static final String OID_REQ_DET = "oid_req_det";

	public static final String OID_DET_OC = "oid_det_oc";

	public static final String CANT_COMPRADA = "cant_comprada";

	public static final String ACTIVO = "activo";

	public static final int SELECT_BY_REQUI_DET = 100;

	public static final int SELECT_BY_OC_DET = 101;

	public DBAplicRequiDet() {
	}

	protected void insert(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {

		final int OID_DET_OC_REQUI = 1;
		final int OID_REQ_DET = 2;
		final int OID_DET_OC = 3;
		final int CANT_COMPRADA = 4;
		final int ACTIVO = 5;

		AplicRequiDet pers = (AplicRequiDet) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into cpRequiDetOcDet " + " ( "
				+ "OID_DET_OC_REQUI," + "OID_REQ_DET," + "OID_DET_OC,"
				+ "CANT_COMPRADA," + "ACTIVO)" + " values " + "(" + "?," + "?,"
				+ "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD()
				.prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_DET_OC_REQUI, pers.getOID());
		qInsert.setInt(OID_REQ_DET, pers.getRequisicion_det().getOID());
		qInsert.setInt(OID_DET_OC, pers.getDetalle_oc().getOID());
		qInsert.setDouble(CANT_COMPRADA, pers.getCant_comprada().doubleValue());
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {

		final int OID_REQ_DET = 1;
		final int OID_DET_OC = 2;
		final int CANT_COMPRADA = 3;
		final int ACTIVO = 4;
		final int OID_DET_OC_REQUI = 5;

		AplicRequiDet pers = (AplicRequiDet) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update cpRequiDetOcDet set " + "oid_req_det=?"
				+ ",oid_det_oc=?" + ",cant_comprada=?" + ",activo=?"
				+ " where " + " oid_det_oc_requi=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_DET_OC_REQUI, pers.getOID());
		qUpdate.setInt(OID_REQ_DET, pers.getRequisicion_det().getOID());
		qUpdate.setInt(OID_DET_OC, pers.getDetalle_oc().getOID());
		qUpdate.setDouble(CANT_COMPRADA, pers.getCant_comprada().doubleValue());
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {
		final int OID_DET_OC_REQUI = 1;
		AplicRequiDet pers = (AplicRequiDet) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cpRequiDetOcDet " + " set activo=0 "
				+ " where " + " oid_det_oc_requi=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_DET_OC_REQUI, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {
		final int OID_DET_OC_REQUI = 1;
		AplicRequiDet pers = (AplicRequiDet) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cpRequiDetOcDet " + " set activo=1 "
				+ " where " + " oid_det_oc_requi=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_DET_OC_REQUI, pers.getOID());
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
		case SELECT_BY_REQUI_DET: {
			ps = this.selectByRequiDet(aCondiciones);
			break;
		}
		case SELECT_BY_OC_DET: {
			ps = this.selectByOCDet(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones)
			throws BaseException, SQLException {

		final int OID_DET_OC_REQUI = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cpRequiDetOcDet ");
		textSQL.append(" WHERE oid_det_oc_requi = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_DET_OC_REQUI, oid);
		return querySelect;
	}

	private PreparedStatement selectByOCDet(Object aCondiciones)
			throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cpRequiDetOcDet ");
		textSQL.append(" WHERE oid_det_oc = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		OrdenDeCompraDet ocDet = (OrdenDeCompraDet) aCondiciones;
		querySelect.setInt(1, ocDet.getOID());
		return querySelect;
	}

	private PreparedStatement selectByRequiDet(Object aCondiciones)
			throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cpRequiDetOcDet ");
		textSQL.append(" WHERE oid_req_det = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		RequisicionDet requisicionDet = (RequisicionDet) aCondiciones;
		querySelect.setInt(1, requisicionDet.getOID());
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones)
			throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cpRequiDetOcDet ");
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
				.append("SELECT oid_det_oc_requi oid, codigo,  descripcion ,activo ");
		textSQL.append(" from cpRequiDetOcDet");

		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static List getAplicOCDet(RequisicionDet requisicionDet,
			ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(PeriodoIncDet.NICKNAME,
				DBAplicRequiDet.SELECT_BY_REQUI_DET, requisicionDet,
				new ListObserver(), aSesion);
	}
	
	public static List getAplicOCDet(OrdenDeCompraDet ocDet,
			ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(AplicRequiDet.NICKNAME,
				DBAplicRequiDet.SELECT_BY_OC_DET, ocDet,
				new ListObserver(), aSesion);
	}	
	
			

}
