package com.srn.erp.ventas.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.ventas.bm.PedidoCabAnulacion;
import com.srn.erp.ventas.bm.PedidoDetAnulacion;
import com.srn.erp.ventas.bm.RemitoDetAnulacion;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBPedidoDetAnulacion extends DBObjetoPersistente {

	public static final String	OID_PED_DET_ANU			= "oid_ped_det_anu";

	public static final String	OID_PED_CAB_ANU			= "oid_ped_cab_anu";

	public static final String	OID_PEDIDO_DET			= "oid_ped_det";

	public static final int			SELECT_BY_DETALLES	= 100;

	public DBPedidoDetAnulacion() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_PED_DET_ANU = 1;
		final int OID_PED_CAB_ANU = 2;
		final int OID_PEDIDO_DET = 3;

		PedidoDetAnulacion pers = (PedidoDetAnulacion) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into vePedDetAnu " + " ( " + "OID_PED_DET_ANU," + "OID_PED_CAB_ANU," + "OID_PED_DET)"
				+ " values " + "(" + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_PED_DET_ANU, pers.getOID());
		qInsert.setInt(OID_PED_CAB_ANU, pers.getPedido_cab_anu().getOID());
		qInsert.setInt(OID_PEDIDO_DET, pers.getPedido_det().getOID());
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
		final int OID_PED_DET_ANU = 1;
		PedidoDetAnulacion pers = (PedidoDetAnulacion) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update vePedDetAnu " + " set activo=0 " + " where " + " oid_ped_det_anu=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_PED_DET_ANU, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_PED_DET_ANU = 1;
		PedidoDetAnulacion pers = (PedidoDetAnulacion) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update vePedDetAnu " + " set activo=1 " + " where " + " oid_ped_det_anu=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_PED_DET_ANU, pers.getOID());
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

		final int OID_PED_DET_ANU = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  vePedDetAnu ");
		textSQL.append(" WHERE oid_ped_det_anu = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_PED_DET_ANU, oid);
		return querySelect;
	}

	private PreparedStatement selectByDetalles(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  vePedDetAnu ");
		textSQL.append(" WHERE oid_ped_cab_anu = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		PedidoCabAnulacion pedidoCabAnulacion = ((PedidoCabAnulacion) aCondiciones);
		querySelect.setInt(1, pedidoCabAnulacion.getOID());
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  vePedDetAnu ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_ped_det_anu oid, codigo,  descripcion ,activo ");
		textSQL.append(" from vePedDetAnu");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static List getDetalles(PedidoCabAnulacion pedidoCabAnulacion, ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(PedidoDetAnulacion.NICKNAME, DBPedidoDetAnulacion.SELECT_BY_DETALLES,
				pedidoCabAnulacion, new ListObserver(), aSesion);
	}

}
