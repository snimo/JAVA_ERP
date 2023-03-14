package com.srn.erp.excluidos.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import com.srn.erp.excluidos.bm.ImagenesExcluido;
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

public class DBImagenesExcluido extends DBObjetoPersistente {

	public static final String OID_IMAGEN = "oid_imagen";
	public static final String OID_INDIVIDUO = "oid_individuo";
	public static final String FECHA = "fecha";
	public static final String COMENTARIO = "comentario";
	public static final String ORDEN = "orden";
	public static final String ACTIVO = "activo";
	public static final String OID_PREDIO = "oid_predio";
	

	public static final int SELECT_BY_INDIVIDUO = 100;
	public static final int SELECT_BY_INDIVIDUO_ORDEN = 101;

	public DBImagenesExcluido() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_IMAGEN = 1;
		final int OID_INDIVIDUO = 2;
		final int FECHA = 3;
		final int COMENTARIO = 4;
		final int ORDEN = 5;
		final int ACTIVO = 6;
		final int OID_PREDIO = 7;

		ImagenesExcluido pers = (ImagenesExcluido) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into excImagenes " + " ( " + "OID_IMAGEN," + "OID_INDIVIDUO," + "FECHA," + "COMENTARIO," + "ORDEN,"
				+ "ACTIVO , OID_PREDIO)" + " values " + "(" + "?,"+ "?," + "?," + "?," + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_IMAGEN, pers.getOID());
		qInsert.setInt(OID_INDIVIDUO, pers.getIndividuo().getOID());
		if (pers.getFecha() != null)
			qInsert.setDate(FECHA, new java.sql.Date(pers.getFecha().getTime()));
		else
			qInsert.setNull(FECHA, java.sql.Types.DATE);
		qInsert.setString(COMENTARIO, pers.getComentario());
		qInsert.setInt(ORDEN, pers.getOrden().intValue());
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		if (pers.getPredio()!=null) 
			qInsert.setInt(OID_PREDIO, pers.getPredio().getOID());
		else
			qInsert.setNull(OID_PREDIO, Types.INTEGER);
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_INDIVIDUO = 1;
		final int FECHA = 2;
		final int COMENTARIO = 3;
		final int ORDEN = 4;
		final int ACTIVO = 5;
		final int OID_PREDIO = 6;
		final int OID_IMAGEN = 7;

		ImagenesExcluido pers = (ImagenesExcluido) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update excImagenes set " + "oid_individuo=?" + ",fecha=?" + ",comentario=?" + ",orden=?" + ",activo=? , oid_predio=? "
				+ " where " + " oid_imagen=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_IMAGEN, pers.getOID());
		qUpdate.setInt(OID_INDIVIDUO, pers.getIndividuo().getOID());
		if (pers.getFecha() != null)
			qUpdate.setDate(FECHA, new java.sql.Date(pers.getFecha().getTime()));
		else
			qUpdate.setNull(FECHA, java.sql.Types.DATE);
		qUpdate.setString(COMENTARIO, pers.getComentario());
		qUpdate.setInt(ORDEN, pers.getOrden().intValue());
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		if (pers.getPredio()!=null) 
			qUpdate.setInt(OID_PREDIO, pers.getPredio().getOID());
		else
			qUpdate.setNull(OID_PREDIO, Types.INTEGER);		
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_IMAGEN = 1;
		ImagenesExcluido pers = (ImagenesExcluido) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update excImagenes " + " set activo=0 " + " where " + " oid_imagen=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_IMAGEN, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_IMAGEN = 1;
		ImagenesExcluido pers = (ImagenesExcluido) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update excImagenes " + " set activo=1 " + " where " + " oid_imagen=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_IMAGEN, pers.getOID());
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
		case SELECT_BY_INDIVIDUO_ORDEN: {
			ps = this.selectByIndividuoOrden(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_IMAGEN = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  excImagenes ");
		textSQL.append(" WHERE oid_imagen = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_IMAGEN, oid);
		return querySelect;
	}

	private PreparedStatement selectByIndividuo(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();
		textSQL.append(" SELECT * FROM  excImagenes ");
		textSQL.append(" WHERE oid_individuo = ? and activo=1 ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		IndividuoExcluido individuo = (IndividuoExcluido) aCondiciones;
		querySelect.setInt(1, individuo.getOID());
		return querySelect;

	}
	
	private PreparedStatement selectByIndividuoOrden(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();
		textSQL.append(" SELECT * FROM  excImagenes ");
		textSQL.append(" WHERE oid_individuo = ? and orden=? and activo=1 ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		IndividuoExcluido individuo = (IndividuoExcluido) condiciones.get(IndividuoExcluido.NICKNAME);
		Integer orden = (Integer) condiciones.get("ORDEN");
		querySelect.setInt(1, individuo.getOID());
		querySelect.setInt(2, orden.intValue());
		return querySelect;

	}
	

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  excImagenes ");
		textSQL.append(" WHERE oid_individuo = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_imagen oid,oid_individuo codigo,  descripcion ,activo ");
		textSQL.append(" from excImagenes");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static List getImagenesExcluido(IndividuoExcluido individuo, ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(ImagenesExcluido.NICKNAME, DBImagenesExcluido.SELECT_BY_INDIVIDUO, individuo,
				new ListObserver(), aSesion);
	}
	
	  public static ImagenesExcluido getImagenExcluido(ISesion aSesion,
			  IndividuoExcluido individuo,Integer orden)
	          throws BaseException {
		  HashTableDatos condiciones = new HashTableDatos();
		  condiciones.put(IndividuoExcluido.NICKNAME, individuo);
		  condiciones.put("ORDEN", orden);
		  return (ImagenesExcluido) ObjetoLogico.getObjects(ImagenesExcluido.NICKNAME,
				  				DBImagenesExcluido.SELECT_BY_INDIVIDUO_ORDEN,
				  				condiciones,
				  				new ObjetoObservado(),
				  				aSesion);
	  }
	

}
