package com.srn.erp.excluidos.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import com.srn.erp.excluidos.bm.ArchAdjExc;
import com.srn.erp.excluidos.bm.IndividuoExcluido;
import com.srn.erp.general.bm.Periodo;
import com.srn.erp.general.da.DBPeriodo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBArchAdjExc extends DBObjetoPersistente {

	public static final String OID_ARCH_ADJ = "oid_arch_adj";
	public static final String FECHA = "fecha";
	public static final String NOMBRE = "nombre";
	public static final String TITULO = "titulo";
	public static final String ACTIVO = "activo";
	public static final String OID_INDIVIDUO = "oid_individuo";
	public static final String ORDEN = "orden";
	public static final String OID_PREDIO = "oid_predio";

	public static final int SELECT_BY_INDIVIDUO = 100;
	public static final int SELECT_BY_ORDEN_IND = 101;

	public DBArchAdjExc() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_ARCH_ADJ = 1;
		final int FECHA = 2;
		final int NOMBRE = 3;
		final int TITULO = 4;
		final int ACTIVO = 5;
		final int OID_INDIVIDUO = 6;
		final int ORDEN = 7;
		final int OID_PREDIO = 8;

		ArchAdjExc pers = (ArchAdjExc) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into excArchAdj " + " ( " + "OID_ARCH_ADJ," + "FECHA," + "NOMBRE," + "TITULO,"
				+ "ACTIVO , OID_INDIVIDUO , ORDEN , OID_PREDIO)" + " values " + "(" + "?,?," + "?," + "?," + "?," + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_ARCH_ADJ, pers.getOID());
		if (pers.getFecha()!=null)
			qInsert.setDate(FECHA, new java.sql.Date(pers.getFecha().getTime()));
		else
			qInsert.setNull(FECHA, java.sql.Types.DATE);
		qInsert.setString(NOMBRE, pers.getNombre());
		qInsert.setString(TITULO, pers.getTitulo());
		if (pers.isActivo()==null)
			qInsert.setBoolean(ACTIVO, true);
		else
			qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qInsert.setInt(OID_INDIVIDUO, pers.getIndividuo().getOID());
		qInsert.setInt(ORDEN, pers.getOrden().intValue());
		if (pers.getPredio()!=null)
			qInsert.setInt(OID_PREDIO, pers.getPredio().getOID());
		else
			qInsert.setNull(OID_PREDIO, Types.INTEGER);
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int FECHA = 1;
		final int NOMBRE = 2;
		final int TITULO = 3;
		final int ACTIVO = 4;
		final int OID_INDIVIDUO = 5;
		final int ORDEN = 6;
		final int OID_PREDIO = 7;
		final int OID_ARCH_ADJ = 8;

		ArchAdjExc pers = (ArchAdjExc) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update excArchAdj set " + "fecha=?" + ",nombre=?" + ",titulo=?" + ",activo=? , oid_individuo=? , orden=? , oid_predio = ? "
				+ " where " + " oid_arch_adj=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_ARCH_ADJ, pers.getOID());
		if (pers.getFecha()!=null)
			qUpdate.setDate(FECHA, new java.sql.Date(pers.getFecha().getTime()));
		else
			qUpdate.setNull(FECHA, java.sql.Types.DATE);
		qUpdate.setString(NOMBRE, pers.getNombre());
		qUpdate.setString(TITULO, pers.getTitulo());
		if (pers.isActivo()==null)
			qUpdate.setBoolean(ACTIVO, true);
		else
			qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qUpdate.setInt(OID_INDIVIDUO, pers.getIndividuo().getOID());
		qUpdate.setInt(ORDEN, pers.getOrden().intValue());
		if (pers.getPredio()!=null)
			qUpdate.setInt(OID_PREDIO, pers.getPredio().getOID());
		else
			qUpdate.setNull(OID_PREDIO, Types.INTEGER);	
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_ARCH_ADJ = 1;
		ArchAdjExc pers = (ArchAdjExc) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update excArchAdj " + " set activo=0 " + " where " + " oid_arch_adj=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_ARCH_ADJ, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_ARCH_ADJ = 1;
		ArchAdjExc pers = (ArchAdjExc) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update excArchAdj " + " set activo=1 " + " where " + " oid_arch_adj=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_ARCH_ADJ, pers.getOID());
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
		case SELECT_BY_ORDEN_IND: {
			ps = this.selectByOrdenIndividuo(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_ARCH_ADJ = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  excArchAdj ");
		textSQL.append(" WHERE oid_arch_adj = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_ARCH_ADJ, oid);
		return querySelect;
	}

	private PreparedStatement selectByOrdenIndividuo(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  excArchAdj ");
		textSQL.append(" WHERE oid_individuo = ? and orden=? and activo=1 ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		IndividuoExcluido individuo = (IndividuoExcluido) condiciones.get(IndividuoExcluido.NICKNAME);
		Integer orden = (Integer) condiciones.get("ORDEN");
		querySelect.setInt(1, individuo.getOID());
		querySelect.setInt(2, orden.intValue());
		return querySelect;
	}

	private PreparedStatement selectByIndividuo(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  excArchAdj ");
		textSQL.append(" WHERE oid_individuo = ? and activo=1 ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		IndividuoExcluido individuo = (IndividuoExcluido) aCondiciones;
		querySelect.setInt(1, individuo.getOID());
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  excArchAdj ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_arch_adj oid, codigo,  descripcion ,activo ");
		textSQL.append(" from excArchAdj");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static List getArchAdjInd(ISesion aSesion, IndividuoExcluido individuo) throws BaseException {
		return (List) ObjetoLogico
				.getObjects(ArchAdjExc.NICKNAME, DBArchAdjExc.SELECT_BY_INDIVIDUO, individuo, new ListObserver(), aSesion);
	}

	public static ArchAdjExc getArchivoAdjExc(IndividuoExcluido individuo, Integer orden, ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(IndividuoExcluido.NICKNAME, individuo);
		condiciones.put("ORDEN", orden);

		return (ArchAdjExc) ObjetoLogico.getObjects(ArchAdjExc.NICKNAME, DBArchAdjExc.SELECT_BY_ORDEN_IND, condiciones,
				new ObjetoObservado(), aSesion);
	}

}
