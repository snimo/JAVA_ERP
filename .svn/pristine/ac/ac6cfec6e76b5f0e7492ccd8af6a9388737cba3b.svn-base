package com.srn.erp.ventas.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.general.bm.PeriodoInc;
import com.srn.erp.general.bm.PeriodoIncDet;
import com.srn.erp.general.bm.Talonario;
import com.srn.erp.general.da.DBPeriodoIncDet;
import com.srn.erp.ventas.bm.DevolucionVtasCab;
import com.srn.erp.ventas.bm.IngresoDevolucionStockCab;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;

public class DBIngresoDevolucionStockCab extends DBObjetoPersistente {

	public static final String OID_ING_DEV_STK = "oid_ing_dev_stk";
	public static final String OID_TALONARIO_ORIGEN = "oid_tal_origen";

	private static final int SELECT_BY_HELP_ING_DEV_STOCK = 100;

	public DBIngresoDevolucionStockCab() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_ING_DEV_STK = 1;
		final int OID_TAL_ORIGEN = 2;

		IngresoDevolucionStockCab pers = (IngresoDevolucionStockCab) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into veIngDevStk " + " ( " + "OID_ING_DEV_STK,OID_TAL_ORIGEN)" + " values " + "(" + "?,?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_ING_DEV_STK, pers.getOID());
		qInsert.setInt(OID_TAL_ORIGEN, pers.getTalonarioOrigen().getOID());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_TAL_ORIGEN = 1;
		final int OID_ING_DEV_STK = 2;

		IngresoDevolucionStockCab pers = (IngresoDevolucionStockCab) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update veIngDevStk set " + "oid_tal_origen=? " + " where " + " oid_ing_dev_stk=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_ING_DEV_STK, pers.getOID());
		qUpdate.setInt(OID_TAL_ORIGEN, pers.getTalonarioOrigen().getOID());
		qUpdate.executeUpdate();
		qUpdate.close();

	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_DEV_CAB = 1;
		IngresoDevolucionStockCab pers = (IngresoDevolucionStockCab) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update geComproCab " + " set activo=0 " + " where "
				+ " oid_cco=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_DEV_CAB, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_DEV_CAB = 1;
		IngresoDevolucionStockCab pers = (IngresoDevolucionStockCab) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update veDevolucionCab " + " set activo=1 " + " where " + " oid_dev_cab=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_DEV_CAB, pers.getOID());
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
		case SELECT_BY_HELP_ING_DEV_STOCK: {
			ps = selectByHelpIngDev(aCondiciones);
			break;
		}

		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_DEV_CAB = 1;

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT a.* , b.* FROM  veIngDevStk a  , geComproCab b ");
		textSQL.append(" WHERE a.oid_ing_dev_stk = b.oid_cco and a.oid_ing_dev_stk = ? ");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_DEV_CAB, oid);
		return querySelect;
	}

	private PreparedStatement selectByHelpIngDev(Object aCondiciones) throws BaseException, SQLException {

		HashTableDatos condiciones = (HashTableDatos) aCondiciones;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  veIngDevStk a , geComproCab b ");

		textSQL.append(" WHERE  a.oid_ing_dev_stk = b.oid_cco ");

		if ((condiciones.containsKey(Talonario.NICKNAME)) || (condiciones.containsKey("NRO_EXT_ING_DEV"))) {
			textSQL.append(" and a.oid_ing_dev_stk in (select z1.oid_ing_dev_stk from veIngDevStkDet z1 , veDevolucionDet z2 , geComproCab z3 where z1.oid_dev_det = z2.oid_dev_det and z3.oid_cco = z2.oid_dev_cab ");

			if (condiciones.containsKey(Talonario.NICKNAME)) {
				Talonario talonario = (Talonario) condiciones.get(Talonario.NICKNAME);
				textSQL.append(" and z3.oid_talonario = " + talonario.getOIDInteger());
			}

			if (condiciones.containsKey("NRO_EXT_ING_DEV")) {
				Integer nroExtIngDev = condiciones.getInteger("NRO_EXT_ING_DEV");
				textSQL.append(" and z3.nro_ext = " + nroExtIngDev);
			}

			textSQL.append(" ) ");
			


		}

		if (condiciones.containsKey("NRO_EXT_DESDE")) {
			Integer nroExtDesde = condiciones.getInteger("NRO_EXT_DESDE");
			textSQL.append(" and b.nro_ext>=" + nroExtDesde.toString());
		}

		if (condiciones.containsKey("NRO_EXT_HASTA")) {
			Integer nroExtHasta = condiciones.getInteger("NRO_EXT_HASTA");
			textSQL.append(" and b.nro_ext<=" + nroExtHasta.toString());
		}

		if (condiciones.containsKey("FEC_DESDE")) {
			textSQL.append(" and b.emision>=? ");
		}

		if (condiciones.containsKey("FEC_HASTA")) {
			textSQL.append(" and b.emision<=? ");
		}

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());

		int nroParam = 0;

		if (condiciones.containsKey("FEC_DESDE")) {
			++nroParam;
			java.util.Date fecDesde = (java.util.Date) condiciones.get("FEC_DESDE");
			querySelect.setDate(nroParam, new java.sql.Date(fecDesde.getTime()));
		}

		if (condiciones.containsKey("FEC_HASTA")) {
			++nroParam;
			java.util.Date fecHasta = (java.util.Date) condiciones.get("FEC_HASTA");
			querySelect.setDate(nroParam, new java.sql.Date(fecHasta.getTime()));
		}

		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  veIngDevStk ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_ing_dev_stk oid, codigo,  descripcion ,activo ");
		textSQL.append(" from veIngDevStk");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}
	
	  public static List getHelpIngDevStock(
			  Integer nroExtDesde,
			  Integer nroExtHasta,
			  java.util.Date fecDesde,
			  java.util.Date fecHasta,
			  Talonario talonario,
			  Integer nroIngDev,
              ISesion aSesion) throws BaseException {
		  HashTableDatos condiciones = new HashTableDatos();
		  if (nroExtDesde!=null)
			  condiciones.put("NRO_EXT_DESDE", nroExtDesde);
		  if (nroExtHasta!=null)
			  condiciones.put("NRO_EXT_HASTA", nroExtHasta);
		  if (fecDesde!=null)
			  condiciones.put("FEC_DESDE", fecDesde);
		  if (fecHasta!=null)
			  condiciones.put("FEC_HASTA", fecHasta);
		  if (nroIngDev!=null)
			  condiciones.put("NRO_EXT_ING_DEV", nroIngDev);
		  if (talonario!=null)
			  condiciones.put(Talonario.NICKNAME, talonario);
		  
		  return (List) ObjetoLogico.getObjects(IngresoDevolucionStockCab.NICKNAME,
                 DBIngresoDevolucionStockCab.SELECT_BY_HELP_ING_DEV_STOCK,
                 condiciones,
                 new ListObserver(),
                 aSesion);
	  }
	

}
