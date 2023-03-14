package com.srn.erp.compras.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.compras.bm.SectorCompra;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;

public class DBSectorCompra extends DBObjetoPersistente {

	public static final String OID = "oid_sector_compra";

	public static final String CODIGO = "codigo";

	public static final String DESCRIPCION = "descripcion";

	public static final String ACTIVO = "activo";

	public static final String OID_SUCURSAL = "oid_sucursal";

	public static final int SELECT_BY_USUARIO = 100;

	public DBSectorCompra() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID = 1;
		final int CODIGO = 2;
		final int DESCRIPCION = 3;
		final int ACTIVO = 4;
		final int OID_SUCURSAL = 5;

		SectorCompra pers = (SectorCompra) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into cpSectorCompras " + " ( " + "OID_SECTOR_COMPRA," + "CODIGO," + "DESCRIPCION," + "ACTIVO,"
				+ "OID_SUCURSAL)" + " values " + "(" + "?," + "?," + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID, pers.getOID());
		qInsert.setString(CODIGO, pers.getCodigo());
		qInsert.setString(DESCRIPCION, pers.getDescripcion());
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qInsert.setInt(OID_SUCURSAL, pers.getSucursal().getOID());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int CODIGO = 1;
		final int DESCRIPCION = 2;
		final int ACTIVO = 3;
		final int OID_SUCURSAL = 4;
		final int OID = 5;

		SectorCompra pers = (SectorCompra) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update cpSectorCompras set " + "codigo=?" + ",descripcion=?" + ",activo=?" + ",oid_sucursal=?" + " where "
				+ " oid_sector_compra=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID, pers.getOID());
		qUpdate.setString(CODIGO, pers.getCodigo());
		qUpdate.setString(DESCRIPCION, pers.getDescripcion());
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qUpdate.setInt(OID_SUCURSAL, pers.getSucursal().getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID = 1;
		SectorCompra pers = (SectorCompra) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cpSectorCompras " + " set activo=0 " + " where " + " oid_sector_compra=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID = 1;
		SectorCompra pers = (SectorCompra) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cpSectorCompras " + " set activo=1 " + " where " + " oid_sector_compra=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID, pers.getOID());
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

		case IDBObjetoPersistente.SELECT_ALL: {
			ps = this.selectByAll(aCondiciones);
			break;
		}
		case IDBObjetoPersistente.SELECT_ALL_HELP: {
			ps = this.selectAllHelp(aCondiciones);
			break;
		}
		case SELECT_BY_USUARIO: {
			ps = this.selectByUsuario(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cpSectorCompras ");
		textSQL.append(" WHERE oid_sector_compra = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID, oid);
		return querySelect;
	}

	private PreparedStatement selectByUsuario(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cpSectorCompras ");
		textSQL.append(" WHERE oid_sector_compra in (select oid_sector_compra from cpUsuHabReq where oid_usuario = ? )");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		Usuario usuario = (Usuario) aCondiciones;
		querySelect.setInt(1, usuario.getOID());
		return querySelect;
	}

	private PreparedStatement selectByAll(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cpSectorCompras ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cpSectorCompras ");
		textSQL.append(" WHERE codigo = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_sector_compra oid,codigo codigo, descripcion descripcion ,activo ");
		textSQL.append(" from cpSectorCompras");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static List getSectoresCompras(Usuario usuario, ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico
				.getObjects(SectorCompra.NICKNAME, DBSectorCompra.SELECT_BY_USUARIO, usuario, new ListObserver(), aSesion);
	}
	
	public static List getSectoresCompras(ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico
				.getObjects(SectorCompra.NICKNAME, DBSectorCompra.SELECT_ALL, null, new ListObserver(), aSesion);
	}
	

}
