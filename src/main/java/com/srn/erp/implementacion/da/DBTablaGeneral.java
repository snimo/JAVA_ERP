package com.srn.erp.implementacion.da;

import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.srn.erp.general.bm.CampoTablaGeneral;
import com.srn.erp.implementacion.bm.TablaGeneral;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ObjetoObservado;

public class DBTablaGeneral extends DBObjetoPersistente {

	public static final int SELECT_BORRAR_TABLA = 100;
	public static final int SELECT_EJECUTAR_SQL = 101;
	public static final int SELECT_METADATA_TABLA = 102;
	public static final int SELECT_EJECUTAR_SELECT = 103;
	public static final int DROP_TABLA = 104;

	public DBTablaGeneral() {
	}

	protected void insert(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {

	}

	protected void update(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {

	}

	private void selectBorrarTabla(Object aCondiciones) throws BaseException,
			SQLException {
		String nombre = (String) aCondiciones;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("delete from " + nombre);
		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.executeUpdate();
		qUpdate.close();
	}
	
	private void dropTabla(Object aCondiciones) throws BaseException,
		SQLException {
		String nombre = (String) aCondiciones;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("drop table " + nombre);
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.executeUpdate();
		qUpdate.close();
	}	

	private List selectMetaDataTabla(Object aCondiciones) throws BaseException,
			SQLException {

		List campos = new ArrayList();
		String sql = (String) aCondiciones;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(sql);
		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		ResultSetMetaData rsmd = qUpdate.getMetaData();

		int numberOfColumns = rsmd.getColumnCount();
		for (int i = 1; i <= numberOfColumns; i++) {

			String colName = rsmd.getColumnName(i);
			String tableName = rsmd.getTableName(i);
			int tipo = rsmd.getColumnType(i);
			int size = rsmd.getColumnDisplaySize(i);

			CampoTablaGeneral campoTablaGeneral = new CampoTablaGeneral();
			campoTablaGeneral.setNombreCampo(colName);
			campoTablaGeneral.setNombreTabla(tableName);
			campoTablaGeneral.setTipo(tipo);
			campoTablaGeneral.setSize(size);

		}
		qUpdate.close();

		return campos;
	}

	private void selectEjecutarSQL(Object aCondiciones) throws BaseException,
			SQLException {
		String sql = (String) aCondiciones;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(sql);
		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.executeUpdate();
		
		qUpdate.close();
	}

	private PreparedStatement selectEjecutarSelect(Object aCondiciones)
			throws BaseException, SQLException {

		String sql = (String) aCondiciones;
		StringBuffer sqlSelect = new StringBuffer();
		sqlSelect.append(sql);
		PreparedStatement qSelect = getSesion().getConexionBD()
				.prepareStatement(sqlSelect.toString());
		return qSelect;

	}

	protected void delete(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {
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
		case SELECT_BORRAR_TABLA: {
			this.selectBorrarTabla(aCondiciones);
			break;
		}
		case DROP_TABLA: {
			this.dropTabla(aCondiciones);
			break;
		}		
		case SELECT_EJECUTAR_SQL: {
			this.selectEjecutarSQL(aCondiciones);
			break;
		}
		case SELECT_EJECUTAR_SELECT: {
			ps = this.selectEjecutarSelect(aCondiciones);
			break;
		}
		case SELECT_METADATA_TABLA: {
			this.selectMetaDataTabla(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones)
			throws BaseException, SQLException {
		return null;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones)
			throws BaseException, SQLException {

		return null;

	}

	public static void borrarTabla(String aBorrarTabla, ISesion aSesion)
			throws BaseException {
		ObjetoLogico.getObjects(TablaGeneral.NICKNAME,
				DBTablaGeneral.SELECT_BORRAR_TABLA, aBorrarTabla,
				new ObjetoObservado(), aSesion);
	}
	
	public static void dropTabla(String aBorrarTabla, ISesion aSesion)
	throws BaseException {
		ObjetoLogico.getObjects(TablaGeneral.NICKNAME,
		DBTablaGeneral.DROP_TABLA, aBorrarTabla,
		new ObjetoObservado(), aSesion);
	}	

	public static void ejecutarSQL(String aSQL, ISesion aSesion)
			throws BaseException {
		ObjetoLogico.getObjects(TablaGeneral.NICKNAME,
				DBTablaGeneral.SELECT_EJECUTAR_SQL, aSQL,
				new ObjetoObservado(), aSesion);
	}

	public static List getMetaData(String aSQL, ISesion aSesion)
			throws BaseException {
		return ObjetoLogico.getMetaData(TablaGeneral.NICKNAME,
				DBTablaGeneral.SELECT_EJECUTAR_SELECT, aSQL, aSesion);
	}
	
	public static PreparedStatement getPreparedStatement(String aSQL, ISesion aSesion)
	throws BaseException {
		return ObjetoLogico.getPreparedStatment(TablaGeneral.NICKNAME,
		DBTablaGeneral.SELECT_EJECUTAR_SELECT, aSQL, aSesion);
	}
	

}
