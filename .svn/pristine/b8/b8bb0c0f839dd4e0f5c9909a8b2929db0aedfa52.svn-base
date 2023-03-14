package com.srn.erp.stock.da;

import java.sql.*;
import java.util.List;

import com.srn.erp.compras.bm.RequisicionCab;
import com.srn.erp.compras.bm.SectorCompra;
import com.srn.erp.compras.da.DBRequisicionCab;
import com.srn.erp.stock.bm.*;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.*;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.*;

public class DBPedMercDep extends DBObjetoPersistente {

	public static final String OID_PED_MERC = "oid_ped_merc";
	public static final String OID_SOL_PED_MERC = "oid_sol_ped_merc";
	public static final String OID_DEPO_ENT = "oid_depo_ent";
	
	public static final int SELECT_BY_HELP_PEDIDOS_PARA_DEPO = 100;

	public DBPedMercDep() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_PED_MERC = 1;
		final int OID_SOL_PED_MERC = 2;
		final int OID_DEPO_ENT = 3;

		PedMercDep pers = (PedMercDep) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into vePedMercDepo " + " ( " + "OID_PED_MERC," + "OID_SOL_PED_MERC," + "OID_DEPO_ENT)" + " values " + "("
				+ "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_PED_MERC, pers.getOID());
		qInsert.setInt(OID_SOL_PED_MERC, pers.getSolicitar_a().getOID());
		qInsert.setInt(OID_DEPO_ENT, pers.getDeposito_entrega().getOID());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_SOL_PED_MERC = 1;
		final int OID_DEPO_ENT = 2;
		final int OID_PED_MERC = 3;

		PedMercDep pers = (PedMercDep) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update vePedMercDepo set " + "oid_sol_ped_merc=?" + ",oid_depo_ent=?" + " where " + " oid_ped_merc=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_PED_MERC, pers.getOID());
		qUpdate.setInt(OID_SOL_PED_MERC, pers.getSolicitar_a().getOID());
		qUpdate.setInt(OID_DEPO_ENT, pers.getDeposito_entrega().getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_PED_MERC = 1;
		PedMercDep pers = (PedMercDep) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update geComproCab " + " set activo=0 " + " where " + " oid_cco=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_PED_MERC, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_PED_MERC = 1;
		PedMercDep pers = (PedMercDep) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update vePedMercDepo " + " set activo=1 " + " where " + " oid_ped_merc=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_PED_MERC, pers.getOID());
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
		case SELECT_BY_HELP_PEDIDOS_PARA_DEPO: {
			ps = this.selectByHelpPedidosDeposito(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_PED_MERC = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  vePedMercDepo a, gecomprocab b ");
		textSQL.append(" WHERE a.oid_ped_merc = b.oid_cco and a.oid_ped_merc = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_PED_MERC, oid);
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  vePedMercDepo ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectByHelpPedidosDeposito(Object aCondiciones) throws BaseException, SQLException {

		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		int nroParam = 0;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT a.*,b.* FROM  vePedMercDepo a, geComproCab b ");
		textSQL.append(" WHERE  a.oid_ped_merc = b.oid_cco ");

		if (condiciones.containsKey(SolicitarAPedMerc.NICKNAME)) {
			SolicitarAPedMerc solicitarA = (SolicitarAPedMerc) condiciones.get(SolicitarAPedMerc.NICKNAME);
			textSQL.append(" and a.oid_sol_ped_merc = " + solicitarA.getOIDInteger().toString());
		}

		if (condiciones.containsKey(Deposito.NICKNAME)) {
			Deposito deposito = (Deposito) condiciones.get(Deposito.NICKNAME);
			textSQL.append(" and a.oid_depo_ent = " + deposito.getOIDInteger().toString());
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

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		if (condiciones.containsKey("fec_desde")) {
			java.util.Date fecDesde = (java.util.Date) condiciones.get("fec_desde");
			++nroParam;
			querySelect.setDate(nroParam, new java.sql.Date(fecDesde.getTime()));
		}
		if (condiciones.containsKey("fec_hasta")) {
			java.util.Date fecHasta = (java.util.Date) condiciones.get("fec_hasta");
			++nroParam;
			querySelect.setDate(nroParam, new java.sql.Date(fecHasta.getTime()));
		}
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_ped_merc oid, codigo,  descripcion ,activo ");
		textSQL.append(" from vePedMercDepo");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}
	
	public static List getPedidosParaDeposito(
			Integer nroExtDesde,
			Integer nroExtHasta, 
			java.util.Date fecDesde,
			java.util.Date fecHasta, 
			SolicitarAPedMerc solicitarA,
			Deposito deposito, ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		if (nroExtDesde != null)
			condiciones.put("nro_desde", nroExtDesde);
		if (nroExtHasta != null)
			condiciones.put("nro_hasta", nroExtHasta);
		if (fecDesde != null)
			condiciones.put("fec_desde", fecDesde);
		if (fecHasta != null)
			condiciones.put("fec_hasta", fecHasta);
		if (solicitarA != null)
			condiciones.put(SolicitarAPedMerc.NICKNAME, solicitarA);
		if (deposito != null)
			condiciones.put(Deposito.NICKNAME, deposito);
		return (List) ObjetoLogico.getObjects(PedMercDep.NICKNAME,
				DBPedMercDep.SELECT_BY_HELP_PEDIDOS_PARA_DEPO, condiciones,
				new ListObserver(), aSesion);
	}
	

}
