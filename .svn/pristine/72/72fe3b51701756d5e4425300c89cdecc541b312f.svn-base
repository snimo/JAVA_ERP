package com.srn.erp.excluidos.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import com.srn.erp.excluidos.bm.IndividuoExcluido;
import com.srn.erp.excluidos.bm.VehiAsigExcluido;
import com.srn.erp.excluidos.bm.VehiculoExcluido;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBVehiAsigExcluido extends DBObjetoPersistente {

	public static final String OID_VEHI_INDI = "oid_vehi_indi";
	public static final String OID_INDIVIDUO = "oid_individuo";
	public static final String OID_VEHICULO = "oid_vehiculo";
	public static final String ACTIVO = "activo";
	public static final String OID_PREDIO = "oid_predio";

	public static final int SELECT_BY_INDIVIDUO = 100;
	public static final int SELECT_BY_IND_VEHI = 101;

	public DBVehiAsigExcluido() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_VEHI_INDI = 1;
		final int OID_INDIVIDUO = 2;
		final int OID_VEHICULO = 3;
		final int ACTIVO = 4;
		final int OID_PREDIO = 5;
		

		VehiAsigExcluido pers = (VehiAsigExcluido) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into excVehiIndividuo " + " ( " + "OID_VEHI_INDI," + "OID_INDIVIDUO," + "OID_VEHICULO," + "ACTIVO , OID_PREDIO) "
				+ " values " + "(" + "?," + "?, ? , " + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_VEHI_INDI, pers.getOID());
		qInsert.setInt(OID_INDIVIDUO, pers.getIndividuo().getOID());
		qInsert.setInt(OID_VEHICULO, pers.getVehiculo().getOID());
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		if (pers.getPredioExcluido()!=null)
			qInsert.setInt(OID_PREDIO, pers.getPredioExcluido().getOID());
		else
			qInsert.setNull(OID_PREDIO, Types.INTEGER);
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_INDIVIDUO = 1;
		final int OID_VEHICULO = 2;
		final int ACTIVO = 3;
		final int OID_PREDIO = 4;
		final int OID_VEHI_INDI = 5;

		VehiAsigExcluido pers = (VehiAsigExcluido) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update excVehiIndividuo set " + "oid_individuo=?" + ",oid_vehiculo=?" + ",activo=? , oid_predio=? " + " where "
				+ " oid_vehi_indi=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_VEHI_INDI, pers.getOID());
		qUpdate.setInt(OID_INDIVIDUO, pers.getIndividuo().getOID());
		qUpdate.setInt(OID_VEHICULO, pers.getVehiculo().getOID());
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		
		if (pers.getPredioExcluido()!=null)
			qUpdate.setInt(OID_PREDIO, pers.getPredioExcluido().getOID());
		else
			qUpdate.setNull(OID_PREDIO, Types.INTEGER);		
		
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_VEHI_INDI = 1;
		VehiAsigExcluido pers = (VehiAsigExcluido) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update excVehiIndividuo " + " set activo=0 " + " where " + " oid_vehi_indi=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_VEHI_INDI, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_VEHI_INDI = 1;
		VehiAsigExcluido pers = (VehiAsigExcluido) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update excVehiIndividuo " + " set activo=1 " + " where " + " oid_vehi_indi=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_VEHI_INDI, pers.getOID());
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
		case SELECT_BY_INDIVIDUO: {
			ps = this.selectByIndividuo(aCondiciones);
			break;
		}
		case SELECT_BY_IND_VEHI: {
			ps = this.selectByIndiVehi(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_VEHI_INDI = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  excVehiIndividuo ");
		textSQL.append(" WHERE oid_vehi_indi = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_VEHI_INDI, oid);
		return querySelect;
	}

	private PreparedStatement selectByIndiVehi(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  excVehiIndividuo ");
		textSQL.append(" WHERE oid_individuo  = ? and oid_vehiculo=? and activo=1 ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		IndividuoExcluido indiExc = (IndividuoExcluido) condiciones.get(IndividuoExcluido.NICKNAME);
		VehiculoExcluido vehiculoExcluido = (VehiculoExcluido) condiciones.get(VehiculoExcluido.NICKNAME);
		querySelect.setInt(1, indiExc.getOID());
		querySelect.setInt(2, vehiculoExcluido.getOID());
		return querySelect;
	}

	private PreparedStatement selectByIndividuo(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  excVehiIndividuo ");
		textSQL.append(" WHERE oid_individuo  = ? and activo=1 order by oid_vehi_indi  ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		IndividuoExcluido individuo = (IndividuoExcluido) aCondiciones;
		querySelect.setInt(1, individuo.getOID());
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  excVehiIndividuo ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_vehi_indi oid, codigo,  descripcion ,activo ");
		textSQL.append(" from excVehiIndividuo");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static List getVehiAsigExcluido(IndividuoExcluido individuo, ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(VehiAsigExcluido.NICKNAME, DBVehiAsigExcluido.SELECT_BY_INDIVIDUO, individuo,
				new ListObserver(), aSesion);
	}

	public static VehiAsigExcluido getVehiculoAsigExc(IndividuoExcluido individuo, VehiculoExcluido vehiculoExcluido, ISesion aSesion)
			throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(IndividuoExcluido.NICKNAME, individuo);
		condiciones.put(VehiculoExcluido.NICKNAME, vehiculoExcluido);
		return (VehiAsigExcluido) ObjetoLogico.getObjects(VehiAsigExcluido.NICKNAME, DBVehiAsigExcluido.SELECT_BY_IND_VEHI, condiciones,
				new ObjetoObservado(), aSesion);
	}

}
