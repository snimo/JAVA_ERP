package com.srn.erp.ventas.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.ventas.bm.CotizacionCabAnulacion;
import com.srn.erp.ventas.bm.CotizacionDetAnulacion;
import com.srn.erp.ventas.bm.PedidoCabAnulacion;
import com.srn.erp.ventas.bm.PedidoDetAnulacion;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBCotizacionDetAnulacion extends DBObjetoPersistente {

	public static final String	OID_COT_DET_ANU			= "oid_cot_det_anu";

	public static final String	OID_COT_CAB_ANU			= "oid_cot_cab_anu";

	public static final String	OID_COTIZACION_DET			= "oid_presu_det";

	public static final int			SELECT_BY_DETALLES	= 100;

	public DBCotizacionDetAnulacion() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_COT_DET_ANU = 1;
		final int OID_COT_CAB_ANU = 2;
		final int OID_COTIZACION_DET = 3;

		CotizacionDetAnulacion pers = (CotizacionDetAnulacion) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into veCotDetAnu " + " ( " + "OID_COT_DET_ANU," + "OID_COT_CAB_ANU," + "OID_PRESU_DET)"
				+ " values " + "(" + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_COT_DET_ANU, pers.getOID());
		qInsert.setInt(OID_COT_CAB_ANU, pers.getCotizacion_cab_anu().getOID());
		qInsert.setInt(OID_COTIZACION_DET, pers.getCotizacion_det().getOID());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_COT_CAB_ANU = 1;
		final int OID_COTIZACION_DET = 2;
		final int OID_COT_DET_ANU = 3;

		CotizacionDetAnulacion pers = (CotizacionDetAnulacion) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update veCotDetAnu set " + "oid_cot_cab_anu=?" + ",oid_presu_det=?" + " where "
				+ " oid_cot_det_anu=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_COT_DET_ANU, pers.getOID());
		qUpdate.setInt(OID_COT_CAB_ANU, pers.getCotizacion_cab_anu().getOID());
		qUpdate.setInt(OID_COTIZACION_DET, pers.getCotizacion_det().getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_COT_DET_ANU = 1;
		CotizacionDetAnulacion pers = (CotizacionDetAnulacion) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update veCotDetAnu " + " set activo=0 " + " where " + " oid_cot_det_anu=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_COT_DET_ANU, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_COT_DET_ANU = 1;
		CotizacionDetAnulacion pers = (CotizacionDetAnulacion) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update veCotDetAnu " + " set activo=1 " + " where " + " oid_cot_det_anu=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_COT_DET_ANU, pers.getOID());
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

		final int OID_COT_DET_ANU = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  veCotDetAnu ");
		textSQL.append(" WHERE oid_cot_det_anu = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_COT_DET_ANU, oid);
		return querySelect;
	}

	private PreparedStatement selectByDetalles(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  veCotDetAnu ");
		textSQL.append(" WHERE oid_cot_cab_anu = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		CotizacionCabAnulacion cotizacionCabAnulacion = ((CotizacionCabAnulacion) aCondiciones);
		querySelect.setInt(1, cotizacionCabAnulacion.getOID());
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  veCotDetAnu ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_ped_det_anu oid, codigo,  descripcion ,activo ");
		textSQL.append(" from veCotDetAnu");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static List getDetalles(CotizacionCabAnulacion cotizacionCabAnulacion, ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(CotizacionDetAnulacion.NICKNAME, DBCotizacionDetAnulacion.SELECT_BY_DETALLES,
				cotizacionCabAnulacion, new ListObserver(), aSesion);
	}

}
