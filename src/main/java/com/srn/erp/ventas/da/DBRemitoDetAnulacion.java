package com.srn.erp.ventas.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.ventas.bm.RemitoCabAnulacion;
import com.srn.erp.ventas.bm.RemitoDetAnulacion;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBRemitoDetAnulacion extends DBObjetoPersistente {

	public static final String	OID_RTO_DET_ANU			= "oid_rto_det_anu";

	public static final String	OID_RTO_CAB_ANU			= "oid_rto_cab_anu";

	public static final String	OID_REMITO_DET			= "oid_remito_det";

	public static final int			SELECT_BY_DETALLES	= 100;

	public DBRemitoDetAnulacion() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_RTO_DET_ANU = 1;
		final int OID_RTO_CAB_ANU = 2;
		final int OID_REMITO_DET = 3;

		RemitoDetAnulacion pers = (RemitoDetAnulacion) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into veRtoDetAnu " + " ( " + "OID_RTO_DET_ANU," + "OID_RTO_CAB_ANU," + "OID_REMITO_DET)"
				+ " values " + "(" + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_RTO_DET_ANU, pers.getOID());
		qInsert.setInt(OID_RTO_CAB_ANU, pers.getRemito_cab_anu().getOID());
		qInsert.setInt(OID_REMITO_DET, pers.getRemito_det().getOID());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_RTO_CAB_ANU = 1;
		final int OID_REMITO_DET = 2;
		final int OID_RTO_DET_ANU = 3;

		RemitoDetAnulacion pers = (RemitoDetAnulacion) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update veRtoDetAnu set " + "oid_rto_cab_anu=?" + ",oid_remito_det=?" + " where "
				+ " oid_rto_det_anu=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_RTO_DET_ANU, pers.getOID());
		qUpdate.setInt(OID_RTO_CAB_ANU, pers.getRemito_cab_anu().getOID());
		qUpdate.setInt(OID_REMITO_DET, pers.getRemito_det().getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_RTO_DET_ANU = 1;
		RemitoDetAnulacion pers = (RemitoDetAnulacion) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update veRtoDetAnu " + " set activo=0 " + " where " + " oid_rto_det_anu=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_RTO_DET_ANU, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_RTO_DET_ANU = 1;
		RemitoDetAnulacion pers = (RemitoDetAnulacion) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update veRtoDetAnu " + " set activo=1 " + " where " + " oid_rto_det_anu=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_RTO_DET_ANU, pers.getOID());
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
		case SELECT_BY_DETALLES: {
			ps = this.selectByDetalles(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_RTO_DET_ANU = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  veRtoDetAnu ");
		textSQL.append(" WHERE oid_rto_det_anu = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_RTO_DET_ANU, oid);
		return querySelect;
	}

	private PreparedStatement selectByDetalles(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  veRtoDetAnu ");
		textSQL.append(" WHERE oid_rto_cab_anu = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		RemitoCabAnulacion remitoCabAnulacion = ((RemitoCabAnulacion) aCondiciones);
		querySelect.setInt(1, remitoCabAnulacion.getOID());
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  veRtoDetAnu ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_rto_det_anu oid, codigo,  descripcion ,activo ");
		textSQL.append(" from veRtoDetAnu");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static List getDetalles(RemitoCabAnulacion remitoCabAnulacion, ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(RemitoDetAnulacion.NICKNAME, DBRemitoDetAnulacion.SELECT_BY_DETALLES,
				remitoCabAnulacion, new ListObserver(), aSesion);
	}

}
