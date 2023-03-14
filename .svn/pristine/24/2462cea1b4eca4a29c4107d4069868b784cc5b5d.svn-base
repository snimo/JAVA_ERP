package com.srn.erp.cip.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.cip.bm.Puerta;
import com.srn.erp.cip.bm.TarjetaLegajo;
import com.srn.erp.sueldos.bm.Legajo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBTarjetaLegajo extends DBObjetoPersistente {

	public static final String OID_TAR_LEG = "oid_tar_leg";
	public static final String TIPO_TARJETA = "tipo_tarjeta";
	public static final String NRO_TARJETA = "nro_tarjeta";
	public static final String OID_LEGAJO = "oid_legajo";
	public static final String ACTIVO = "activo";
	public static final String ORDEN = "orden";

	public static final int SELECT_BY_LEGAJO = 100;
	public static final int SELECT_BY_NRO_TARJETA = 101;
	public static final int SELECT_BY_ALL_TARJETAS_ACT = 102;
	public static final int SELECT_BY_LEGAJO_TAR_ORDEN_1 = 103;

	public DBTarjetaLegajo() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_TAR_LEG = 1;
		final int TIPO_TARJETA = 2;
		final int NRO_TARJETA = 3;
		final int OID_LEGAJO = 4;
		final int ACTIVO = 5;
		final int ORDEN = 6;

		TarjetaLegajo pers = (TarjetaLegajo) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into cipTarjetaLegajo " + " ( " + "OID_TAR_LEG," + "TIPO_TARJETA," + "NRO_TARJETA," + "OID_LEGAJO,"
				+ "ACTIVO,ORDEN)" + " values " + "(" + "?," + "?," + "?," + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_TAR_LEG, pers.getOID());
		qInsert.setString(TIPO_TARJETA, pers.getTipo_tarjeta());
		qInsert.setString(NRO_TARJETA, pers.getNro_tarjeta());
		qInsert.setInt(OID_LEGAJO, pers.getLegajo().getOID());
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qInsert.setInt(ORDEN, pers.getOrden().intValue());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int TIPO_TARJETA = 1;
		final int NRO_TARJETA = 2;
		final int OID_LEGAJO = 3;
		final int ACTIVO = 4;
		final int ORDEN = 5;
		final int OID_TAR_LEG = 6;

		TarjetaLegajo pers = (TarjetaLegajo) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update cipTarjetaLegajo set " + "tipo_tarjeta=?" + ",nro_tarjeta=?" + ",oid_legajo=?" + ",activo=?" + ",orden=?"
				+ " where " + " oid_tar_leg=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_TAR_LEG, pers.getOID());
		qUpdate.setString(TIPO_TARJETA, pers.getTipo_tarjeta());
		qUpdate.setString(NRO_TARJETA, pers.getNro_tarjeta());
		qUpdate.setInt(OID_LEGAJO, pers.getLegajo().getOID());
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qUpdate.setInt(ORDEN, pers.getOrden().intValue());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_TAR_LEG = 1;
		TarjetaLegajo pers = (TarjetaLegajo) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cipTarjetaLegajo " + " set activo=0 " + " where " + " oid_tar_leg=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_TAR_LEG, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_TAR_LEG = 1;
		TarjetaLegajo pers = (TarjetaLegajo) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cipTarjetaLegajo " + " set activo=1 " + " where " + " oid_tar_leg=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_TAR_LEG, pers.getOID());
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
		case SELECT_BY_LEGAJO: {
			ps = this.selectByLegajosActivos(aCondiciones);
			break;
		}
		case SELECT_BY_NRO_TARJETA: {
			ps = this.selectByNroTarjeta(aCondiciones);
			break;
		}
		case SELECT_BY_ALL_TARJETAS_ACT: {
			ps = this.selectByTarjetasActivas(aCondiciones);
			break;
		}
		case SELECT_BY_LEGAJO_TAR_ORDEN_1: {
			ps = this.selectByTarjetaOrden1(aCondiciones);
			break;
		}

		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_TAR_LEG = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cipTarjetaLegajo ");
		textSQL.append(" WHERE oid_tar_leg = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_TAR_LEG, oid);
		return querySelect;
	}

	private PreparedStatement selectByLegajosActivos(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cipTarjetaLegajo ");
		textSQL.append(" WHERE oid_legajo  = ? and activo=1 ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		Legajo legajo = (Legajo) aCondiciones;
		querySelect.setInt(1, legajo.getOID());
		return querySelect;
	}
	
	private PreparedStatement selectByTarjetaOrden1(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT a.* FROM  cipTarjetaLegajo a ");
		textSQL.append(" WHERE a.oid_legajo = ? and a.activo=1 and a.orden=1 ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		Legajo legajo = (Legajo) aCondiciones;
		querySelect.setInt(1, legajo.getOID());
		return querySelect;
	}

	
	private PreparedStatement selectByTarjetasActivas(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT a.* FROM  cipTarjetaLegajo a, suLegajo b ");
		textSQL.append(" WHERE a.oid_legajo = b.oid_legajo and a.activo=1 and b.activo=1 ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}
	

	private PreparedStatement selectByNroTarjeta(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cipTarjetaLegajo ");
		textSQL.append(" WHERE nro_tarjeta = ? and activo=1 ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String nroTarjeta = (String) aCondiciones;
		querySelect.setString(1, nroTarjeta);
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cipTarjetaLegajo ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_tar_leg oid, codigo,  descripcion ,activo ");
		textSQL.append(" from cipTarjetaLegajo");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static List getTarjetasLegajo(Legajo legajo, ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico
				.getObjects(TarjetaLegajo.NICKNAME, DBTarjetaLegajo.SELECT_BY_LEGAJO, legajo, new ListObserver(), aSesion);
	}
	
	public static List getTarjetasActivas(ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(TarjetaLegajo.NICKNAME, DBTarjetaLegajo.SELECT_BY_ALL_TARJETAS_ACT, null, new ListObserver(), aSesion);
	}
	
	public static TarjetaLegajo getTarjetaLegajo(String nroTarjeta, ISesion aSesion) throws BaseException {
		return (TarjetaLegajo) ObjetoLogico
				.getObjects(TarjetaLegajo.NICKNAME, DBTarjetaLegajo.SELECT_BY_NRO_TARJETA, nroTarjeta, new ObjetoObservado(), aSesion);
	}
	
	public static TarjetaLegajo getTarjetaLegajo(Legajo legajo, ISesion aSesion) throws BaseException {
		return (TarjetaLegajo) ObjetoLogico
				.getObjects(TarjetaLegajo.NICKNAME, DBTarjetaLegajo.SELECT_BY_LEGAJO_TAR_ORDEN_1, legajo, new ObjetoObservado(), aSesion);
	}
	
	
	public static void borrarListaBlanca(Puerta puerta,ISesion aSesion) throws BaseException {

		java.util.Date fecha = null;
		try {

			StringBuffer textSQL = new StringBuffer();
			textSQL.append("DELETE FROM cipListaBlanca where oid_puerta=? ");
			PreparedStatement querySelect = aSesion.getConexionBD().prepareStatement(textSQL.toString());
			querySelect.setInt(1, puerta.getOID());
			querySelect.executeUpdate();
			querySelect.close();
		} catch (Exception e) {
			throw new BaseException(null, e.getMessage());
		}

	}
	


}
