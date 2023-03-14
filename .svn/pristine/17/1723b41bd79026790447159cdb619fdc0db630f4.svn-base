package com.srn.erp.compras.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.compras.bm.SectorCompra;
import com.srn.erp.compras.bm.UsuarioHabilitadoRequisicion;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBUsuarioHabilitadoRequisicion extends DBObjetoPersistente {

	public static final String OID_USU_HAB_REQ = "oid_usu_hab_req";

	public static final String OID_SECTOR_COMPRA = "oid_sector_compra";

	public static final String OID_USUARIO = "oid_usuario";

	public static final int SELECT_BY_SECTOR_COMPRA = 100;

	public DBUsuarioHabilitadoRequisicion() {
	}

	protected void insert(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {

		final int OID_USU_HAB_REQ = 1;
		final int OID_SECTOR_COMPRA = 2;
		final int OID_USUARIO = 3;

		UsuarioHabilitadoRequisicion pers = (UsuarioHabilitadoRequisicion) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into cpUsuHabReq " + " ( "
				+ "OID_USU_HAB_REQ," + "OID_SECTOR_COMPRA," + "OID_USUARIO)"
				+ " values " + "(" + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD()
				.prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_USU_HAB_REQ, pers.getOID());
		qInsert.setInt(OID_SECTOR_COMPRA, pers.getSector_compra().getOID());
		qInsert.setInt(OID_USUARIO, pers.getUsuario().getOID());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {

		final int OID_SECTOR_COMPRA = 1;
		final int OID_USUARIO = 2;
		final int OID_USU_HAB_REQ = 3;

		UsuarioHabilitadoRequisicion pers = (UsuarioHabilitadoRequisicion) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update cpUsuHabReq set " + "oid_sector_compra=?"
				+ ",oid_usuario=?" + " where " + " oid_usu_hab_req=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_USU_HAB_REQ, pers.getOID());
		qUpdate.setInt(OID_SECTOR_COMPRA, pers.getSector_compra().getOID());
		qUpdate.setInt(OID_USUARIO, pers.getUsuario().getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {
		final int OID_USU_HAB_REQ = 1;
		UsuarioHabilitadoRequisicion pers = (UsuarioHabilitadoRequisicion) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("delete from cpUsuHabReq where "
				+ " oid_usu_hab_req=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_USU_HAB_REQ, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {
		final int OID_USU_HAB_REQ = 1;
		UsuarioHabilitadoRequisicion pers = (UsuarioHabilitadoRequisicion) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cpUsuHabReq " + " set activo=1 " + " where "
				+ " oid_usu_hab_req=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_USU_HAB_REQ, pers.getOID());
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
		case SELECT_BY_SECTOR_COMPRA: {
			ps = this.selectBySectorCompra(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones)
			throws BaseException, SQLException {

		final int OID_USU_HAB_REQ = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cpUsuHabReq ");
		textSQL.append(" WHERE oid_usu_hab_req = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_USU_HAB_REQ, oid);
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones)
			throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cpUsuHabReq ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectBySectorCompra(Object aCondiciones)
			throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cpUsuHabReq ");
		textSQL.append(" WHERE oid_sector_compra = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		SectorCompra sectorCompra = (SectorCompra) aCondiciones;
		querySelect.setInt(1, sectorCompra.getOID());
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones)
			throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL
				.append("SELECT oid_usu_hab_req oid, codigo,  descripcion ,activo ");
		textSQL.append(" from cpUsuHabReq");

		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static List getUsuariosHabReq(SectorCompra sectorCompra,
			ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(
				UsuarioHabilitadoRequisicion.NICKNAME,
				DBUsuarioHabilitadoRequisicion.SELECT_BY_SECTOR_COMPRA,
				sectorCompra, new ListObserver(), aSesion);
	}

}
