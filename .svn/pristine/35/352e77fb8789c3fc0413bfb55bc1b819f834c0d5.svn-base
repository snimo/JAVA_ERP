package com.srn.erp.cip.da;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.cip.bm.ContadorCacheoLeg;
import com.srn.erp.cip.bm.Rota;
import com.srn.erp.general.bm.Periodo;
import com.srn.erp.general.da.DBPeriodo;
import com.srn.erp.sueldos.bm.Legajo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ObjetoObservado;

public class DBContadorCacheoLeg extends DBObjetoPersistente {

	public static final String OID_CONT_CACHEO = "oid_cont_cacheo";
	public static final String OID_LEGAJO = "oid_legajo";
	public static final String CANTIDAD = "cantidad";
	
	public static final int SELECT_MAXIMO_CACHEOS = 100;
	public static final int SELECT_MAX_FECHA_ROTA = 101;
	public static final int SELECT_BY_LEGAJO = 102;
	
	public DBContadorCacheoLeg() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_CONT_CACHEO = 1;
		final int OID_LEGAJO = 2;
		final int CANTIDAD = 3;

		ContadorCacheoLeg pers = (ContadorCacheoLeg) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into cipContCacheoLeg " + " ( " + "OID_CONT_CACHEO," + "OID_LEGAJO," + "CANTIDAD)" + " values " + "(" + "?,"
				+ "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_CONT_CACHEO, pers.getOID());
		qInsert.setInt(OID_LEGAJO, pers.getLegajo().getOID());
		qInsert.setInt(CANTIDAD, pers.getCantidad().intValue());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_LEGAJO = 1;
		final int CANTIDAD = 2;
		final int OID_CONT_CACHEO = 3;

		ContadorCacheoLeg pers = (ContadorCacheoLeg) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update cipContCacheoLeg set " + "oid_legajo=?" + ",cantidad=?" + " where " + " oid_cont_cacheo=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_CONT_CACHEO, pers.getOID());
		qUpdate.setInt(OID_LEGAJO, pers.getLegajo().getOID());
		qUpdate.setInt(CANTIDAD, pers.getCantidad().intValue());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_CONT_CACHEO = 1;
		ContadorCacheoLeg pers = (ContadorCacheoLeg) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cipContCacheoLeg " + " set activo=0 " + " where " + " oid_cont_cacheo=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_CONT_CACHEO, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_CONT_CACHEO = 1;
		ContadorCacheoLeg pers = (ContadorCacheoLeg) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cipContCacheoLeg " + " set activo=1 " + " where " + " oid_cont_cacheo=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_CONT_CACHEO, pers.getOID());
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
		case SELECT_ALL: {
			ps = this.selectAll(aCondiciones);
			break;
		}
		case SELECT_BY_LEGAJO: {
			ps = this.selectByLegajo(aCondiciones);
			break;			
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_CONT_CACHEO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cipContCacheoLeg ");
		textSQL.append(" WHERE oid_cont_cacheo = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_CONT_CACHEO, oid);
		return querySelect;
	}

	private PreparedStatement selectAll(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM cipContCacheoLeg ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	
	
	public static int getMaximoCacheosLegPorRota(
			java.util.Date fecha,
			Rota rota,
			ISesion aSesion) throws BaseException {

		try {
			
			StringBuffer textSQL = new StringBuffer();
			textSQL.append("SELECT max(a.cantidad) cantidad FROM cipContCacheoLeg a, cipLegRotFec b ");
			textSQL.append(" WHERE a.oid_legajo = b.oid_legajo and b.oid_rota=? and b.fecha=? and b.activo=1 ");
			PreparedStatement querySelect = aSesion.getConexionBD().prepareStatement(textSQL.toString());
			querySelect.setInt(1, rota.getOID());
			querySelect.setDate(2, new java.sql.Date(fecha.getTime()));			
			ResultSet rs = querySelect.executeQuery();
			int cant = 0;
			if (rs.next())
				cant = rs.getInt(1);
			rs.close();
			querySelect.close();

			return cant;
		}
		catch (Exception e) {
			throw new BaseException(null, e.getMessage());
		}
	}
	
	
	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cipContCacheoLeg ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}
	
	private PreparedStatement selectByLegajo(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cipContCacheoLeg ");
		textSQL.append(" WHERE oid_legajo  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		Legajo legajo = (Legajo) aCondiciones;
		querySelect.setInt(1, legajo.getOID());
		return querySelect;
	}
	

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_cont_cacheo oid, codigo,  descripcion ,activo ");
		textSQL.append(" from cipContCacheoLeg");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}
	
	public static int getMaximoCacheosLeg(ISesion aSesion) throws BaseException {

		try {
			StringBuffer textSQL = new StringBuffer();
			textSQL.append("SELECT max(cantidad) cantidad ");
			textSQL.append(" from cipContCacheoLeg ");
			PreparedStatement querySelect = aSesion.getConexionBD().prepareStatement(textSQL.toString());
			
			ResultSet rs = querySelect.executeQuery();
			int cant = 0;
			if (rs.next())
				cant = rs.getInt(1);
			rs.close();
			querySelect.close();

			return cant;
		}
		catch (Exception e) {
			throw new BaseException(null, e.getMessage());
		}
	}
	
	  public static List getAllCacheosLeg(ISesion aSesion) throws BaseException {
		  return (List) ObjetoLogico.getObjects(ContadorCacheoLeg.NICKNAME,
                 DBContadorCacheoLeg.SELECT_ALL,
                 null,
                 new ListObserver(),
                 aSesion);
	  }
	  
	  public static ContadorCacheoLeg getContadorCacheoLeg(Legajo legajo,
	          ISesion aSesion)
	          throws BaseException {
		  return (ContadorCacheoLeg) ObjetoLogico.getObjects(ContadorCacheoLeg.NICKNAME,
				  				DBContadorCacheoLeg.SELECT_BY_LEGAJO,
				  				legajo,
				  				new ObjetoObservado(),
				  				aSesion);
	  }
	  
	
	

}
