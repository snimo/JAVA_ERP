package com.srn.erp.ventas.da;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import com.srn.erp.stock.bm.Producto;
import com.srn.erp.ventas.bm.PedidoCab;
import com.srn.erp.ventas.bm.PedidoDet;
import com.srn.erp.ventas.bm.ReservaPedidoDet;
import com.srn.erp.ventas.bm.Sujeto;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBReservaPedidoDet extends DBObjetoPersistente {

	public static final String	OID_PED_DET							= "OID_PED_DET";

	public static final String	CANT_UM_ORI_RES					= "CANT_UM_ORI_RES";


	public DBReservaPedidoDet() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		
		final int CANT_UM_ORI_RES = 1;
		final int OID_CCO_PED_DET = 2;

		ReservaPedidoDet pers = (ReservaPedidoDet) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update VEPEDIDOSDET set CANT_UM_ORI_RES=? where oid_ped_det=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setDouble(CANT_UM_ORI_RES, pers.getCant_um_ori_res().doubleValue());
		qUpdate.setInt(OID_CCO_PED_DET, pers.getOID());
		
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_PED_DET = 1;
		PedidoDet pers = (PedidoDet) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update VEPEDIDOSDET " + " set anulado=1 " + " where " + " oid_ped_det=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_PED_DET, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_PED_DET = 1;
		PedidoDet pers = (PedidoDet) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update VEPEDIDOSDET " + " set activo=1 " + " where " + " oid_ped_det=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_PED_DET, pers.getOID());
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
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_PED_DET = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  VEPEDIDOSDET ");
		textSQL.append(" WHERE oid_ped_det = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_PED_DET, oid);
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  VEPEDIDOSDET ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}


}
