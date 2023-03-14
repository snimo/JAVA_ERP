package com.srn.erp.excluidos.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.excluidos.bm.IndividuoExcluido;
import com.srn.erp.excluidos.bm.VehiculoExcluido;
import com.srn.erp.general.bm.Periodo;
import com.srn.erp.general.bm.PeriodoInc;
import com.srn.erp.general.bm.PeriodoIncDet;
import com.srn.erp.general.da.DBPeriodo;
import com.srn.erp.general.da.DBPeriodoIncDet;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ObjetoObservado;

public class DBVehiculoExcluido extends DBObjetoPersistente {

	public static final String OID_VEHICULO = "oid_vehiculo";
	public static final String MODELO = "modelo";
	public static final String DOMINIO = "dominio";
	public static final String OID_COLOR = "oid_color";
	public static final String ACTIVO = "activo";
	public static final String MARCA = "marca";
	public static final String OID_PREDIO = "oid_predio";

	public static final int SELECT_BY_INDIVIDUO = 100;
	public static final int SELECT_BY_DOMINIO = 101;

	public DBVehiculoExcluido() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_VEHICULO = 1;
		final int MODELO = 2;
		final int DOMINIO = 3;
		final int OID_COLOR = 4;
		final int ACTIVO = 5;
		final int MARCA = 6;
		final int OID_PREDIO = 7;

		VehiculoExcluido pers = (VehiculoExcluido) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into excVehiculos " + " ( " + "OID_VEHICULO," + "MODELO," + "DOMINIO," + "OID_COLOR," + "ACTIVO , MARCA , OID_PREDIO)"
				+ " values " + "(" + "?," + "?," + "?," + "?,?,"+ "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_VEHICULO, pers.getOID());
		if (pers.getModelo() != null)
			qInsert.setString(MODELO, pers.getModelo());
		else
			qInsert.setString(MODELO, "");
		if (pers.getDominio() != null)
			qInsert.setString(DOMINIO, pers.getDominio());
		else
			qInsert.setString(DOMINIO, "");
		if (pers.getColor() != null)
			qInsert.setInt(OID_COLOR, pers.getColor().getOID());
		else
			qInsert.setNull(OID_COLOR, java.sql.Types.INTEGER);
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		if (pers.getMarca()!=null)
			qInsert.setString(MARCA, pers.getMarca());
		else
			qInsert.setNull(MARCA, java.sql.Types.VARCHAR);
		if (pers.getPredio()!=null)
			qInsert.setInt(OID_PREDIO, pers.getPredio().getOIDInteger());
		else
			qInsert.setNull(OID_PREDIO, java.sql.Types.INTEGER);		
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int MODELO = 1;
		final int DOMINIO = 2;
		final int OID_COLOR = 3;
		final int ACTIVO = 4;
		final int MARCA = 5;
		final int OID_VEHICULO = 6;

		VehiculoExcluido pers = (VehiculoExcluido) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update excVehiculos set " + "modelo=?" + ",dominio=?" + ",oid_color=?" + ",activo=? , marca=? " + " where "
				+ " oid_vehiculo=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_VEHICULO, pers.getOID());
		if (pers.getModelo() != null)
			qUpdate.setString(MODELO, pers.getModelo());
		else
			qUpdate.setString(MODELO, "");
		if (pers.getDominio() != null)
			qUpdate.setString(DOMINIO, pers.getDominio());
		else
			qUpdate.setString(DOMINIO, "");
		if (pers.getColor() != null)
			qUpdate.setInt(OID_COLOR, pers.getColor().getOID());
		else
			qUpdate.setNull(OID_COLOR, java.sql.Types.INTEGER);
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		if (pers.getMarca()!=null)
			qUpdate.setString(MARCA, pers.getMarca());
		else
			qUpdate.setNull(MARCA, java.sql.Types.VARCHAR);
		
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_VEHICULO = 1;
		VehiculoExcluido pers = (VehiculoExcluido) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update excVehiculos " + " set activo=0 " + " where " + " oid_vehiculo=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_VEHICULO, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_VEHICULO = 1;
		VehiculoExcluido pers = (VehiculoExcluido) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update excVehiculos " + " set activo=1 " + " where " + " oid_vehiculo=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_VEHICULO, pers.getOID());
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
		case SELECT_BY_DOMINIO: {
			ps = this.selectByDominio(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_VEHICULO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  excVehiculos ");
		textSQL.append(" WHERE oid_vehiculo = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_VEHICULO, oid);
		return querySelect;
	}

	private PreparedStatement selectByDominio(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  excVehiculos ");
		textSQL.append(" WHERE dominio = ? and activo=1 ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String dominio = (String) aCondiciones;
		querySelect.setString(1, dominio);
		return querySelect;
	}

	private PreparedStatement selectByIndividuo(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  excVehiculos ");
		textSQL.append(" WHERE oid_individuo = ? and activo=1 ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		IndividuoExcluido individuo = (IndividuoExcluido) aCondiciones;
		querySelect.setInt(1, individuo.getOID());
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  excVehiculos ");
		textSQL.append(" WHERE oid_individuo = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_vehiculo oid,oid_individuo codigo,  descripcion ,activo ");
		textSQL.append(" from excVehiculos");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static List getVehiculos(IndividuoExcluido aIndividuo, ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(VehiculoExcluido.NICKNAME, DBVehiculoExcluido.SELECT_BY_INDIVIDUO, aIndividuo,
				new ListObserver(), aSesion);
	}

	public static VehiculoExcluido getVehiculoExcluido(String dominio, ISesion aSesion) throws BaseException {
		return (VehiculoExcluido) ObjetoLogico.getObjects(VehiculoExcluido.NICKNAME, DBVehiculoExcluido.SELECT_BY_DOMINIO, dominio,
				new ObjetoObservado(), aSesion);
	}

}
