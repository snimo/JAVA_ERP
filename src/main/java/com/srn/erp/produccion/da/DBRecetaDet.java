package com.srn.erp.produccion.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.general.bm.PeriodoIncDet;
import com.srn.erp.produccion.bm.RecetaCab;
import com.srn.erp.produccion.bm.RecetaDet;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBRecetaDet extends DBObjetoPersistente {

	public static final String	OID_REC_DET						= "oid_rec_det";

	public static final String	OID_REC_CAB						= "oid_rec_cab";

	public static final String	OID_PRODUCTO					= "oid_producto";

	public static final String	OID_UM								= "oid_um";

	public static final String	CANTIDAD							= "cantidad";

	public static final String	DESCARTE							= "descarte";

	public static final String	ACTIVO								= "activo";
	
	public static final String	ORDEN								= "orden";

	public static final int			SELECT_BY_RECETA_CAB	= 100;

	public DBRecetaDet() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_REC_DET = 1;
		final int OID_REC_CAB = 2;
		final int OID_PRODUCTO = 3;
		final int OID_UM = 4;
		final int CANTIDAD = 5;
		final int DESCARTE = 6;
		final int ACTIVO = 7;
		final int ORDEN = 8;

		RecetaDet pers = (RecetaDet) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into prRecDet " + " ( " + "OID_REC_DET," + "OID_REC_CAB," + "OID_PRODUCTO," + "OID_UM,"
				+ "CANTIDAD," + "DESCARTE," + "ACTIVO , ORDEN)" + " values " + "(" + "?," + "?," + "?," + "?," + "?," + "?,"+ "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_REC_DET, pers.getOID());
		qInsert.setInt(OID_REC_CAB, pers.getReceta_cab().getOID());
		qInsert.setInt(OID_PRODUCTO, pers.getProducto().getOID());
		qInsert.setInt(OID_UM, pers.getOid_um().getOID());
		qInsert.setDouble(CANTIDAD, pers.getCantidad().doubleValue());
		if (pers.getDescarte()!=null)
			qInsert.setDouble(DESCARTE, pers.getDescarte().doubleValue());
		else
			qInsert.setDouble(DESCARTE, 0);
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qInsert.setInt(ORDEN, pers.getOrden().intValue());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_REC_CAB = 1;
		final int OID_PRODUCTO = 2;
		final int OID_UM = 3;
		final int CANTIDAD = 4;
		final int DESCARTE = 5;
		final int ACTIVO = 6;
		final int ORDEN = 7;
		final int OID_REC_DET = 8;
		

		RecetaDet pers = (RecetaDet) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update prRecDet set " + "oid_rec_cab=?" + ",oid_producto=?" + ",oid_um=?" + ",cantidad=?"
				+ ",descarte=?" + ",activo=? , orden = ? " + " where " + " oid_rec_det=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_REC_DET, pers.getOID());
		qUpdate.setInt(OID_REC_CAB, pers.getReceta_cab().getOID());
		qUpdate.setInt(OID_PRODUCTO, pers.getProducto().getOID());
		qUpdate.setInt(OID_UM, pers.getOid_um().getOID());
		qUpdate.setDouble(CANTIDAD, pers.getCantidad().doubleValue());
		if (pers.getDescarte()!=null)
			qUpdate.setDouble(DESCARTE, pers.getDescarte().doubleValue());
		else
			qUpdate.setDouble(DESCARTE, 0);
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qUpdate.setInt(ORDEN, pers.getOrden().intValue());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_REC_DET = 1;
		RecetaDet pers = (RecetaDet) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update prRecDet " + " set activo=0 " + " where " + " oid_rec_det=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_REC_DET, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_REC_DET = 1;
		RecetaDet pers = (RecetaDet) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update prRecDet " + " set activo=1 " + " where " + " oid_rec_det=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_REC_DET, pers.getOID());
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
		case SELECT_BY_RECETA_CAB: {
			ps = this.selectByRecetaCab(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_REC_DET = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  prRecDet ");
		textSQL.append(" WHERE oid_rec_det = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_REC_DET, oid);
		return querySelect;
	}

	private PreparedStatement selectByRecetaCab(Object aCondiciones) throws BaseException, SQLException {
		RecetaCab recetaCab = (RecetaCab) aCondiciones;
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  prRecDet ");
		textSQL.append(" WHERE oid_rec_cab = ? and activo = 1 ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		querySelect.setInt(1, recetaCab.getOID());
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  prRecDet ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_rec_det oid, codigo,  descripcion ,activo ");
		textSQL.append(" from prRecDet");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static List getRecetasDet(RecetaCab recetaCab, ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(RecetaDet.NICKNAME, DBRecetaDet.SELECT_BY_RECETA_CAB, recetaCab,
				new ListObserver(), aSesion);
	}

}
