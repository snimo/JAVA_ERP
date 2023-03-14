package com.srn.erp.compras.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.compras.bm.AutorizadorRequisicion;
import com.srn.erp.compras.bm.EsquemaAutorizCompras;
import com.srn.erp.compras.bm.SectorCompra;
import com.srn.erp.general.bm.IValorClasificadorEntidad;
import com.srn.erp.general.bm.ValorClasificadorEntidad;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;

public class DBAutorizadorRequisicion extends DBObjetoPersistente {

	public static final String OID_AUTORIZ_REQ = "oid_autoriz_req";

	public static final String OID_ESQ_AUTORIZ = "oid_esq_autoriz";

	public static final String OID_SECTOR_EMISOR = "oid_sector_emisor";

	public static final String OID_ROL_AUTORIZ = "oid_rol_autoriz";

	public static final String OID_VAL_CLASIF_ENT = "oid_val_clasif_ent";

	public static final String TIPO_AUTORIZ = "tipo_autoriz";

	public static final int SELECT_BY_ESQ_AUTORIZ = 100;

	public static final int SELECT_BY_ESQ_SECTOR_VALCLASIF = 101;

	public DBAutorizadorRequisicion() {
	}

	protected void insert(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {

		final int OID_AUTORIZ_REQ = 1;
		final int OID_ESQ_AUTORIZ = 2;
		final int OID_SECTOR_EMISOR = 3;
		final int OID_ROL_AUTORIZ = 4;
		final int OID_VAL_CLASIF_ENT = 5;
		final int TIPO_AUTORIZ = 6;

		AutorizadorRequisicion pers = (AutorizadorRequisicion) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into cpAutorizReq " + " ( "
				+ "OID_AUTORIZ_REQ," + "OID_ESQ_AUTORIZ,"
				+ "OID_SECTOR_EMISOR," + "OID_ROL_AUTORIZ,"
				+ "OID_VAL_CLASIF_ENT," + "TIPO_AUTORIZ)" + " values " + "("
				+ "?," + "?," + "?," + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD()
				.prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_AUTORIZ_REQ, pers.getOID());
		qInsert
				.setInt(OID_ESQ_AUTORIZ, pers.getEsquema_autorizacion()
						.getOID());
		qInsert.setInt(OID_SECTOR_EMISOR, pers.getSector_emisor().getOID());
		qInsert.setInt(OID_ROL_AUTORIZ, pers.getRol_autorizador().getOID());
		qInsert.setInt(OID_VAL_CLASIF_ENT, pers.getValor_clasificador()
				.getOID());
		qInsert.setString(TIPO_AUTORIZ, pers.getTipoAutoriz());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {

		final int OID_ESQ_AUTORIZ = 1;
		final int OID_SECTOR_EMISOR = 2;
		final int OID_ROL_AUTORIZ = 3;
		final int OID_VAL_CLASIF_ENT = 4;
		final int TIPO_AUTORIZ = 5;
		final int OID_AUTORIZ_REQ = 6;

		AutorizadorRequisicion pers = (AutorizadorRequisicion) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update cpAutorizReq set " + "oid_esq_autoriz=?"
				+ ",oid_sector_emisor=?" + ",oid_rol_autoriz=?"
				+ ",oid_val_clasif_ent=?" + ",tipo_autoriz=?" + " where "
				+ " oid_autoriz_req=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_AUTORIZ_REQ, pers.getOID());
		qUpdate
				.setInt(OID_ESQ_AUTORIZ, pers.getEsquema_autorizacion()
						.getOID());
		qUpdate.setInt(OID_SECTOR_EMISOR, pers.getSector_emisor().getOID());
		qUpdate.setInt(OID_ROL_AUTORIZ, pers.getRol_autorizador().getOID());
		qUpdate.setString(TIPO_AUTORIZ, pers.getTipoAutoriz());
		qUpdate.setInt(OID_VAL_CLASIF_ENT, pers.getValor_clasificador()
				.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {
		final int OID_AUTORIZ_REQ = 1;
		AutorizadorRequisicion pers = (AutorizadorRequisicion) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("delete from cpAutorizReq " + " where "
				+ " oid_autoriz_req=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_AUTORIZ_REQ, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {
		final int OID_AUTORIZ_REQ = 1;
		AutorizadorRequisicion pers = (AutorizadorRequisicion) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cpAutorizReq " + " set activo=1 " + " where "
				+ " oid_autoriz_req=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_AUTORIZ_REQ, pers.getOID());
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
		case SELECT_BY_ESQ_AUTORIZ: {
			ps = this.selectByEsqAutoriz(aCondiciones);
			break;
		}
		case SELECT_BY_ESQ_SECTOR_VALCLASIF: {
			ps = this.selectByEsqSectorValClasif(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones)
			throws BaseException, SQLException {

		final int OID_AUTORIZ_REQ = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cpAutorizReq ");
		textSQL.append(" WHERE oid_autoriz_req = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_AUTORIZ_REQ, oid);
		return querySelect;
	}

	private PreparedStatement selectByEsqSectorValClasif(Object aCondiciones)
			throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cpAutorizReq ");
		textSQL
				.append(" WHERE oid_esq_autoriz = ? and oid_sector_emisor = ? and oid_val_clasif_ent = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		EsquemaAutorizCompras esqAutorizCompras = (EsquemaAutorizCompras) condiciones
				.get(EsquemaAutorizCompras.NICKNAME);
		SectorCompra sectorCompra = (SectorCompra) condiciones
				.get(SectorCompra.NICKNAME);
		IValorClasificadorEntidad valClasifEnt = (IValorClasificadorEntidad) condiciones
				.get(ValorClasificadorEntidad.NICKNAME);
		querySelect.setInt(1, esqAutorizCompras.getOID());
		querySelect.setInt(2, sectorCompra.getOID());
		querySelect.setInt(3, valClasifEnt.getOID());
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones)
			throws BaseException, SQLException {
		final int CODIGO = 1;
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cpAutorizReq ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectByEsqAutoriz(Object aCondiciones)
			throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cpAutorizReq ");
		textSQL.append(" WHERE oid_esq_autoriz = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		EsquemaAutorizCompras esqAutoriz = (EsquemaAutorizCompras) aCondiciones;
		querySelect.setInt(1, esqAutoriz.getOID());
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones)
			throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL
				.append("SELECT oid_autoriz_req oid, codigo,  descripcion ,activo ");
		textSQL.append(" from cpAutorizReq");

		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static List getAutorizadoresRequisicion(
			EsquemaAutorizCompras esquemaAutorizCompras, ISesion aSesion)
			throws BaseException {
		return (List) ObjetoLogico.getObjects(AutorizadorRequisicion.NICKNAME,
				DBAutorizadorRequisicion.SELECT_BY_ESQ_AUTORIZ,
				esquemaAutorizCompras, new ListObserver(), aSesion);
	}

	public static List getAutorizadoresRequisicion(
			EsquemaAutorizCompras esquemaAutorizCompras, 
			SectorCompra sectorEmisor,
			IValorClasificadorEntidad valClasifEnt,
			ISesion aSesion)
			throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(EsquemaAutorizCompras.NICKNAME,esquemaAutorizCompras);
		condiciones.put(SectorCompra.NICKNAME,sectorEmisor);
		condiciones.put(ValorClasificadorEntidad.NICKNAME,valClasifEnt);
		return (List) ObjetoLogico.getObjects(AutorizadorRequisicion.NICKNAME,
				DBAutorizadorRequisicion.SELECT_BY_ESQ_SECTOR_VALCLASIF,
				condiciones, new ListObserver(), aSesion);
	}

}
