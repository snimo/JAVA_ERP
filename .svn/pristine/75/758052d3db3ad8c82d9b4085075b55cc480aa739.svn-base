package com.srn.erp.compras.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.compras.bm.AutorizacionMontoCompra;
import com.srn.erp.compras.bm.RolAutorizadorOC;
import com.srn.erp.compras.bm.SectorCompra;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;

public class DBRolAutorizadorOC extends DBObjetoPersistente {

	public static final String	OID_ROL_AUT_CPRAS									= "oid_rol_aut_cpras";

	public static final String	OID_AUTORIZ_MONTO									= "oid_autoriz_monto";

	public static final String	OID_ROL_AUTORIZ										= "oid_rol_autoriz";

	public static final String	TIPO_AUTORIZ											= "tipo_autoriz";

	public static final String	OID_SECTOR_EMISOR									= "oid_sector_emisor";

	public static final int			SELECT_BY_AUTORIZACION_POR_MONTO	= 100;

	public static final int			SELECT_BY_AUTORIZ_SECTOR					= 101;

	public DBRolAutorizadorOC() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_ROL_AUT_CPRAS = 1;
		final int OID_AUTORIZ_MONTO = 2;
		final int OID_ROL_AUTORIZ = 3;
		final int TIPO_AUTORIZ = 4;
		final int OID_SECTOR_EMISOR = 5;

		RolAutorizadorOC pers = (RolAutorizadorOC) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into cpAutorizadoresOC " + " ( " + "OID_ROL_AUT_CPRAS," + "OID_AUTORIZ_MONTO,"
				+ "OID_ROL_AUTORIZ," + "TIPO_AUTORIZ," + "OID_SECTOR_EMISOR)" + " values " + "(" + "?," + "?," + "?," + "?,"
				+ "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_ROL_AUT_CPRAS, pers.getOID());
		qInsert.setInt(OID_AUTORIZ_MONTO, pers.getAutorizacion_monto().getOID());
		qInsert.setInt(OID_ROL_AUTORIZ, pers.getRol_autorizador().getOID());
		qInsert.setString(TIPO_AUTORIZ, pers.getTipo_autoriz());
		if (pers.getSector_emisor() != null)
			qInsert.setInt(OID_SECTOR_EMISOR, pers.getSector_emisor().getOID());
		else
			qInsert.setNull(OID_SECTOR_EMISOR, java.sql.Types.INTEGER);
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_AUTORIZ_MONTO = 1;
		final int OID_ROL_AUTORIZ = 2;
		final int TIPO_AUTORIZ = 3;
		final int OID_SECTOR_EMISOR = 4;
		final int OID_ROL_AUT_CPRAS = 5;

		RolAutorizadorOC pers = (RolAutorizadorOC) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update cpAutorizadoresOC set " + "oid_autoriz_monto=?" + ",oid_rol_autoriz=?"
				+ ",tipo_autoriz=?" + ",oid_sector_emisor=?" + " where " + " oid_rol_aut_cpras=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_ROL_AUT_CPRAS, pers.getOID());
		qUpdate.setInt(OID_AUTORIZ_MONTO, pers.getAutorizacion_monto().getOID());
		qUpdate.setInt(OID_ROL_AUTORIZ, pers.getRol_autorizador().getOID());
		qUpdate.setString(TIPO_AUTORIZ, pers.getTipo_autoriz());
		if (pers.getSector_emisor() != null)
			qUpdate.setInt(OID_SECTOR_EMISOR, pers.getSector_emisor().getOID());
		else
			qUpdate.setNull(OID_SECTOR_EMISOR, java.sql.Types.INTEGER);
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_ROL_AUT_CPRAS = 1;
		RolAutorizadorOC pers = (RolAutorizadorOC) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("delete from cpAutorizadoresOC where " + " oid_rol_aut_cpras=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_ROL_AUT_CPRAS, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_ROL_AUT_CPRAS = 1;
		RolAutorizadorOC pers = (RolAutorizadorOC) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cpAutorizadoresOC " + " set activo=1 " + " where " + " oid_rol_aut_cpras=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_ROL_AUT_CPRAS, pers.getOID());
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
		case SELECT_BY_AUTORIZACION_POR_MONTO: {
			ps = this.selectAutorizacionPorMonto(aCondiciones);
			break;
		}
		case SELECT_BY_AUTORIZ_SECTOR: {
			ps = this.selectByAutorizacionPorMontoYSector(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_ROL_AUT_CPRAS = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cpAutorizadoresOC ");
		textSQL.append(" WHERE oid_rol_aut_cpras = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_ROL_AUT_CPRAS, oid);
		return querySelect;
	}

	private PreparedStatement selectAutorizacionPorMonto(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cpAutorizadoresOC ");
		textSQL.append(" WHERE oid_autoriz_monto = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		AutorizacionMontoCompra autorizMontoCompra = (AutorizacionMontoCompra) aCondiciones;
		querySelect.setInt(1, autorizMontoCompra.getOID());
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cpAutorizadoresOC ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectByAutorizacionPorMontoYSector(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cpAutorizadoresOC ");
		textSQL.append(" WHERE  oid_autoriz_monto = ? and oid_sector_emisor = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		AutorizacionMontoCompra autMonCompra = (AutorizacionMontoCompra) condiciones.get(AutorizacionMontoCompra.NICKNAME);
		SectorCompra sectorCompra = (SectorCompra) condiciones.get(SectorCompra.NICKNAME);
		querySelect.setInt(1, autMonCompra.getOID());
		querySelect.setInt(2, sectorCompra.getOID());
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_rol_aut_cpras oid, codigo,  descripcion ,activo ");
		textSQL.append(" from cpAutorizadoresOC");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static List getRolesAutorizacionCompras(AutorizacionMontoCompra autorizacionMontoCompra, ISesion aSesion)
			throws BaseException {
		return (List) ObjetoLogico.getObjects(RolAutorizadorOC.NICKNAME,
				DBRolAutorizadorOC.SELECT_BY_AUTORIZACION_POR_MONTO, autorizacionMontoCompra, new ListObserver(), aSesion);
	}

	public static List getRolesAutorizacionCompras(AutorizacionMontoCompra autorizacionMontoCompra,
			SectorCompra sectorEmisor, ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(AutorizacionMontoCompra.NICKNAME,autorizacionMontoCompra);
		condiciones.put(SectorCompra.NICKNAME,sectorEmisor);
		return (List) ObjetoLogico.getObjects(RolAutorizadorOC.NICKNAME,
				DBRolAutorizadorOC.SELECT_BY_AUTORIZ_SECTOR, condiciones, new ListObserver(), aSesion);
	}

}
