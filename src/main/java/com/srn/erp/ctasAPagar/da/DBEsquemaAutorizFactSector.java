package com.srn.erp.ctasAPagar.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.compras.bm.SectorCompra;
import com.srn.erp.ctasAPagar.bm.EsquemaAutorizFactMonto;
import com.srn.erp.ctasAPagar.bm.EsquemaAutorizFactSector;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.HashTableDatos;

public class DBEsquemaAutorizFactSector extends DBObjetoPersistente {

	public static final String	OID_ESQ_AUT_SEC					= "oid_esq_aut_sec";

	public static final String	OID_ESQ_AUT_MON					= "oid_esq_aut_mon";

	public static final String	OID_SECTOR_COMPRA				= "oid_sector_compra";

	public static final String	OID_ROL_AUTORIZ					= "oid_rol_autoriz";

	public static final String	TIPO_AUTORIZ						= "tipo_autoriz";

	public static final int			SELECT_BY_ESQ_AUT_MONTO	= 100;
	public static final int     SELECT_BY_ESQ_AUT_MON_SECTOR = 101;

	public DBEsquemaAutorizFactSector() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_ESQ_AUT_SEC = 1;
		final int OID_ESQ_AUT_MON = 2;
		final int OID_SECTOR_COMPRA = 3;
		final int OID_ROL_AUTORIZ = 4;
		final int TIPO_AUTORIZ = 5;

		EsquemaAutorizFactSector pers = (EsquemaAutorizFactSector) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into cpEsqAutFactSec " + " ( " + "OID_ESQ_AUT_SEC," + "OID_ESQ_AUT_MON,"
				+ "OID_SECTOR_COMPRA," + "OID_ROL_AUTORIZ," + "TIPO_AUTORIZ)" + " values " + "(" + "?," + "?," + "?," + "?,"
				+ "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_ESQ_AUT_SEC, pers.getOID());
		qInsert.setInt(OID_ESQ_AUT_MON, pers.getEsquema_autoriz_factura_monto().getOID());
		qInsert.setInt(OID_SECTOR_COMPRA, pers.getSector_compra().getOID());
		qInsert.setInt(OID_ROL_AUTORIZ, pers.getRol_autotizador().getOID());
		qInsert.setString(TIPO_AUTORIZ, pers.getTipo_autoriz());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_ESQ_AUT_MON = 1;
		final int OID_SECTOR_COMPRA = 2;
		final int OID_ROL_AUTORIZ = 3;
		final int TIPO_AUTORIZ = 4;
		final int OID_ESQ_AUT_SEC = 5;

		EsquemaAutorizFactSector pers = (EsquemaAutorizFactSector) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update cpEsqAutFactSec set " + "oid_esq_aut_mon=?" + ",oid_sector_compra=?"
				+ ",oid_rol_autoriz=?" + ",tipo_autoriz=?" + " where " + " oid_esq_aut_sec=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_ESQ_AUT_SEC, pers.getOID());
		qUpdate.setInt(OID_ESQ_AUT_MON, pers.getEsquema_autoriz_factura_monto().getOID());
		qUpdate.setInt(OID_SECTOR_COMPRA, pers.getSector_compra().getOID());
		qUpdate.setInt(OID_ROL_AUTORIZ, pers.getRol_autotizador().getOID());
		qUpdate.setString(TIPO_AUTORIZ, pers.getTipo_autoriz());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_ESQ_AUT_SEC = 1;
		EsquemaAutorizFactSector pers = (EsquemaAutorizFactSector) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("delete from cpEsqAutFactSec where " + " oid_esq_aut_sec=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_ESQ_AUT_SEC, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_ESQ_AUT_SEC = 1;
		EsquemaAutorizFactSector pers = (EsquemaAutorizFactSector) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cpEsqAutFactSec " + " set activo=1 " + " where " + " oid_esq_aut_sec=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_ESQ_AUT_SEC, pers.getOID());
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
		case SELECT_BY_ESQ_AUT_MONTO: {
			ps = this.selectByEsqAutMonto(aCondiciones);
			break;
		}
		case SELECT_BY_ESQ_AUT_MON_SECTOR: {
			ps = this.selectByEsqAutMontoSector(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_ESQ_AUT_SEC = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cpEsqAutFactSec ");
		textSQL.append(" WHERE oid_esq_aut_sec = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_ESQ_AUT_SEC, oid);
		return querySelect;
	}

	private PreparedStatement selectByEsqAutMonto(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cpEsqAutFactSec ");
		textSQL.append(" WHERE oid_esq_aut_mon = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		EsquemaAutorizFactMonto esqAutorizFactMonto = ((EsquemaAutorizFactMonto) aCondiciones);
		querySelect.setInt(1, esqAutorizFactMonto.getOID());
		return querySelect;
	}
	
	private PreparedStatement selectByEsqAutMontoSector(Object aCondiciones) throws BaseException, SQLException {
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		EsquemaAutorizFactMonto esqAutorizFactMonto = (EsquemaAutorizFactMonto) condiciones.get(EsquemaAutorizFactMonto.NICKNAME);
		SectorCompra sectorCompra = (SectorCompra) condiciones.get(SectorCompra.NICKNAME);
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cpEsqAutFactSec ");
		textSQL.append(" WHERE oid_esq_aut_mon = ? and oid_sector_compra=? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		querySelect.setInt(1, esqAutorizFactMonto.getOID());
		querySelect.setInt(2, sectorCompra.getOID());
		return querySelect;
	}
	
	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cpEsqAutFactSec ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_esq_aut_sec oid, codigo,  descripcion ,activo ");
		textSQL.append(" from cpEsqAutFactSec");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static List getEsquemasAutorizFactSector(EsquemaAutorizFactMonto esquemaAutorizFactMonto, ISesion aSesion)
			throws BaseException {
		return (List) ObjetoLogico.getObjects(EsquemaAutorizFactSector.NICKNAME,
				DBEsquemaAutorizFactSector.SELECT_BY_ESQ_AUT_MONTO, esquemaAutorizFactMonto, new ListObserver(), aSesion);
	}
	
	public static List getEsquemasAutorizFactSector(EsquemaAutorizFactMonto esquemaAutorizFactMonto, SectorCompra sector,ISesion aSesion)
	throws BaseException {
		if (sector == null)
			throw new ExceptionValidation(null,"Debe ingresar el Sector");
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(EsquemaAutorizFactMonto.NICKNAME,esquemaAutorizFactMonto);
		condiciones.put(SectorCompra.NICKNAME,sector);
		return (List) ObjetoLogico.getObjects(EsquemaAutorizFactSector.NICKNAME,
		DBEsquemaAutorizFactSector.SELECT_BY_ESQ_AUT_MON_SECTOR, condiciones, new ListObserver(), aSesion);
	}
	
	
	

}
