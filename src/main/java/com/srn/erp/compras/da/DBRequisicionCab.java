package com.srn.erp.compras.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.compras.bm.RequisicionCab;
import com.srn.erp.compras.bm.SectorCompra;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;

public class DBRequisicionCab extends DBObjetoPersistente {

	public static final String OID_CCO_REQUI = "oid_cco_requi";

	public static final String OID_USUARIO = "oid_usuario";

	public static final String SECTOR_COMPRA = "oid_Sector_compra";

	public static final int SELECT_BY_HELP_REQUISICIONES = 100;

	public DBRequisicionCab() {
	}

	protected void insert(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {

		final int OID_CCO_REQUI = 1;
		final int OID_USUARIO = 2;
		final int SECTOR_COMPRA = 3;

		RequisicionCab pers = (RequisicionCab) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into cpRequiCab " + " ( " + "OID_CCO_REQUI,"
				+ "OID_USUARIO," + "OID_SECTOR_COMPRA)" + " values " + "("
				+ "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD()
				.prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_CCO_REQUI, pers.getOID());
		qInsert.setInt(OID_USUARIO, pers.getUsuario().getOID());
		qInsert.setInt(SECTOR_COMPRA, pers.getSectorCompra().getOID());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {

		final int OID_USUARIO = 1;
		final int SECTOR_COMPRA = 2;
		final int OID_CCO_REQUI = 3;

		RequisicionCab pers = (RequisicionCab) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update cpRequiCab set " + "oid_usuario=?"
				+ ",oid_sector_compra=?" + " where " + " oid_cco_requi=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_CCO_REQUI, pers.getOID());
		qUpdate.setInt(OID_USUARIO, pers.getUsuario().getOID());
		qUpdate.setInt(SECTOR_COMPRA, pers.getSectorCompra().getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {
		final int OID_CCO_REQUI = 1;
		RequisicionCab pers = (RequisicionCab) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update geComproCab " + " set activo=0 " + " where "
				+ " oid_cco=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_CCO_REQUI, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {
		final int OID_CCO_REQUI = 1;
		RequisicionCab pers = (RequisicionCab) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cpRequiCab " + " set activo=1 " + " where "
				+ " oid_cco_requi=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_CCO_REQUI, pers.getOID());
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
		case SELECT_BY_HELP_REQUISICIONES: {
			ps = this.selectByHelpRequisiciones(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones)
			throws BaseException, SQLException {

		final int OID_CCO_REQUI = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT a.*,b.* FROM  cpRequiCab a, geComproCab b ");
		textSQL.append(" WHERE  a.oid_cco_requi = b.oid_cco ");
		textSQL.append(" and a.oid_cco_requi = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_CCO_REQUI, oid);
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones)
			throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cpRequiCab ");
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
				.append("SELECT oid_cco_requi oid, codigo,  descripcion ,activo ");
		textSQL.append(" from cpRequiCab");

		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		return querySelect;
	}

	private PreparedStatement selectByHelpRequisiciones(Object aCondiciones)
			throws BaseException, SQLException {

		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		int nroParam = 0;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT a.*,b.* FROM  cpRequiCab a, geComproCab b ");
		textSQL.append(" WHERE  a.oid_cco_requi = b.oid_cco ");

		if (condiciones.containsKey(Usuario.NICKNAME)) {
			Usuario usuario = (Usuario) condiciones.get(Usuario.NICKNAME);
			textSQL.append(" and a.oid_usuario = "
					+ usuario.getOIDInteger().toString());
		}

		if (condiciones.containsKey(SectorCompra.NICKNAME)) {
			SectorCompra sectorCompra = (SectorCompra) condiciones
					.get(SectorCompra.NICKNAME);
			textSQL.append(" and a.oid_sector_compra = "
					+ sectorCompra.getOIDInteger().toString());
		}

		if (condiciones.containsKey("nro_desde")) {
			Integer nroDesde = (Integer) condiciones.get("nro_desde");
			textSQL.append(" and b.nro_Ext >= " + nroDesde.toString());
		}

		if (condiciones.containsKey("nro_hasta")) {
			Integer nroHasta = (Integer) condiciones.get("nro_hasta");
			textSQL.append(" and b.nro_Ext <= " + nroHasta.toString());
		}

		if (condiciones.containsKey("fec_desde"))
			textSQL.append(" and b.emision >= ? ");

		if (condiciones.containsKey("fec_hasta"))
			textSQL.append(" and b.emision <= ? ");

		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		if (condiciones.containsKey("fec_desde")) {
			java.util.Date fecDesde = (java.util.Date) condiciones
					.get("fec_desde");
			++nroParam;
			querySelect
					.setDate(nroParam, new java.sql.Date(fecDesde.getTime()));
		}
		if (condiciones.containsKey("fec_hasta")) {
			java.util.Date fecHasta = (java.util.Date) condiciones
					.get("fec_hasta");
			++nroParam;
			querySelect
					.setDate(nroParam, new java.sql.Date(fecHasta.getTime()));
		}
		return querySelect;
	}

	public static List getRequisicionesCab(Integer nroExtDesde,
			Integer nroExtHasta, java.util.Date fecDesde,
			java.util.Date fecHasta, Usuario usuario,
			SectorCompra sectorCompra, ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		if (nroExtDesde != null)
			condiciones.put("nro_desde", nroExtDesde);
		if (nroExtHasta != null)
			condiciones.put("nro_hasta", nroExtHasta);
		if (fecDesde != null)
			condiciones.put("fec_desde", fecDesde);
		if (fecHasta != null)
			condiciones.put("fec_hasta", fecHasta);
		if (usuario != null)
			condiciones.put(Usuario.NICKNAME, usuario);
		if (sectorCompra != null)
			condiciones.put(SectorCompra.NICKNAME, sectorCompra);
		return (List) ObjetoLogico.getObjects(RequisicionCab.NICKNAME,
				DBRequisicionCab.SELECT_BY_HELP_REQUISICIONES, condiciones,
				new ListObserver(), aSesion);
	}

}
