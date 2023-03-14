package com.srn.erp.excluidos.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.excluidos.bm.IndividuoExcluido;
import com.srn.erp.excluidos.bm.RelacionExcluido;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBRelacionExcluido extends DBObjetoPersistente {

	public static final String OID_REL_INDI = "oid_rel_indi";
	public static final String OID_INDIVIDUO = "oid_individuo";
	public static final String OID_IND_RELACIONADO = "oid_ind_rela";
	public static final String SECU = "secu";
	public static final String COMENTARIO = "comentario";
	public static final String ACTIVO = "activo";
	public static final String OID_PREDIO = "oid_predio";
	

	public static final int SELECT_BY_INDIVIDUO = 100;
	public static final int SELECT_BY_IND_IND_REL = 101;
	public static final int SELECT_BY_IND_SECU = 102;
	public static final int SELECT_BY_IND_REL = 103;

	public DBRelacionExcluido() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_REL_INDI = 1;
		final int OID_INDIVIDUO = 2;
		final int OID_IND_RELACIONADO = 3;
		final int SECU = 4;
		final int COMENTARIO = 5;
		final int ACTIVO = 6;
		final int OID_PREDIO = 7;

		RelacionExcluido pers = (RelacionExcluido) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into excRelIndi " + " ( " + "OID_REL_INDI," + "OID_INDIVIDUO," + "OID_IND_RELA," + "SECU,"
				+ "COMENTARIO," + "ACTIVO , OID_PREDIO)" + " values " + "(" + "?,?," + "?," + "?," + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_REL_INDI, pers.getOID());
		qInsert.setInt(OID_INDIVIDUO, pers.getIndividuo().getOID());
		if (pers.getIndividuo_rel() != null)
			qInsert.setInt(OID_IND_RELACIONADO, pers.getIndividuo_rel().getOID());
		else
			qInsert.setNull(OID_IND_RELACIONADO, java.sql.Types.INTEGER);
		qInsert.setInt(SECU, pers.getSecu().intValue());
		if (pers.getComentario() != null)
			qInsert.setString(COMENTARIO, pers.getComentario().replaceAll("Â", ""));
		else
			qInsert.setNull(COMENTARIO, java.sql.Types.VARCHAR);
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		if (pers.getPredio() != null)
			qInsert.setInt(OID_PREDIO, pers.getPredio().getOID());
		else
			qInsert.setNull(OID_PREDIO, java.sql.Types.INTEGER);
		
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_INDIVIDUO = 1;
		final int OID_IND_RELACIONADO = 2;
		final int SECU = 3;
		final int COMENTARIO = 4;
		final int ACTIVO = 5;
		final int OID_PREDIO = 6;
		final int OID_REL_INDI = 7;

		RelacionExcluido pers = (RelacionExcluido) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update excRelIndi set " + "oid_individuo=?" + ",oid_ind_rela=?" + ",secu=?" + ",comentario=?" + ",activo=? , oid_predio=? "
				+ " where " + " oid_rel_indi=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_REL_INDI, pers.getOID());
		qUpdate.setInt(OID_INDIVIDUO, pers.getIndividuo().getOID());
		if (pers.getIndividuo_rel() != null)
			qUpdate.setInt(OID_IND_RELACIONADO, pers.getIndividuo_rel().getOID());
		else
			qUpdate.setNull(OID_IND_RELACIONADO, java.sql.Types.INTEGER);
		qUpdate.setInt(SECU, pers.getSecu().intValue());
		if (pers.getComentario() != null)
			qUpdate.setString(COMENTARIO, pers.getComentario().replaceAll("Â", ""));
		else
			qUpdate.setNull(COMENTARIO, java.sql.Types.VARCHAR);
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		
		if (pers.getPredio() != null)
			qUpdate.setInt(OID_PREDIO, pers.getPredio().getOID());
		else
			qUpdate.setNull(OID_PREDIO, java.sql.Types.INTEGER);
		
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_REL_INDI = 1;
		RelacionExcluido pers = (RelacionExcluido) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update excRelIndi " + " set activo=0 " + " where " + " oid_rel_indi=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_REL_INDI, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_REL_INDI = 1;
		RelacionExcluido pers = (RelacionExcluido) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update excRelIndi " + " set activo=1 " + " where " + " oid_rel_indi=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_REL_INDI, pers.getOID());
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
		case SELECT_BY_IND_IND_REL: {
			ps = this.selectByIndividuoRelIndi(aCondiciones);
			break;
		}
		case SELECT_BY_IND_SECU: {
			ps = this.selectByIndividuoSecu(aCondiciones);
			break;
		}
		case SELECT_BY_IND_REL: {
			ps = this.selectByIndRel(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_REL_INDI = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  excRelIndi ");
		textSQL.append(" WHERE oid_rel_indi = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_REL_INDI, oid);
		return querySelect;
	}

	private PreparedStatement selectByIndRel(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  excRelIndi ");
		textSQL.append(" WHERE oid_ind_rela=? and activo=1 ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		IndividuoExcluido individuo = (IndividuoExcluido) aCondiciones;
		querySelect.setInt(1, individuo.getOID());
		return querySelect;
	}

	private PreparedStatement selectByIndividuoSecu(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  excRelIndi ");
		textSQL.append(" WHERE oid_individuo = ? and secu=? and activo=1 ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		IndividuoExcluido individuo = (IndividuoExcluido) condiciones.get(IndividuoExcluido.NICKNAME);
		Integer secu = (Integer) condiciones.get("SECU");
		querySelect.setInt(1, individuo.getOID());
		querySelect.setInt(2, secu.intValue());
		return querySelect;
	}

	private PreparedStatement selectByIndividuoRelIndi(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  excRelIndi ");
		textSQL.append(" WHERE oid_individuo = ? and oid_ind_rela=? and activo=1 ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		IndividuoExcluido individuo = (IndividuoExcluido) condiciones.get("INDIVIDUO");
		IndividuoExcluido individuoRelacionado = (IndividuoExcluido) condiciones.get("INDI_RELA");
		if (individuo != null)
			querySelect.setInt(1, individuo.getOID());
		else
			querySelect.setInt(1, -1);
		if (individuoRelacionado != null)
			querySelect.setInt(2, individuoRelacionado.getOID());
		else
			querySelect.setInt(2, -1);
		return querySelect;
	}

	private PreparedStatement selectByIndividuo(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  excRelIndi ");
		textSQL.append(" WHERE oid_individuo = ? and activo=1 ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		IndividuoExcluido individuo = (IndividuoExcluido) aCondiciones;
		querySelect.setInt(1, individuo.getOID());
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  excRelIndi ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_rel_indi oid, codigo,  descripcion ,activo ");
		textSQL.append(" from excRelIndi");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static List getRelacionesExcluidos(IndividuoExcluido aIndividuo, ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(RelacionExcluido.NICKNAME, DBRelacionExcluido.SELECT_BY_INDIVIDUO, aIndividuo,
				new ListObserver(), aSesion);
	}

	public static RelacionExcluido getRelacionExcluido(IndividuoExcluido individuo, IndividuoExcluido indiRela, ISesion aSesion)
			throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		if (individuo != null)
			condiciones.put("INDIVIDUO", individuo);
		if (indiRela != null)
			condiciones.put("INDI_RELA", indiRela);
		return (RelacionExcluido) ObjetoLogico.getObjects(RelacionExcluido.NICKNAME, DBRelacionExcluido.SELECT_BY_IND_IND_REL, condiciones,
				new ObjetoObservado(), aSesion);
	}

	public static RelacionExcluido getRelacionExcluido(IndividuoExcluido individuo, Integer secu, ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(IndividuoExcluido.NICKNAME, individuo);
		condiciones.put("SECU", secu);
		return (RelacionExcluido) ObjetoLogico.getObjects(RelacionExcluido.NICKNAME, DBRelacionExcluido.SELECT_BY_IND_SECU, condiciones,
				new ObjetoObservado(), aSesion);
	}

	public static List getRelacionesIndividuales(IndividuoExcluido aIndividuo, ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(RelacionExcluido.NICKNAME, DBRelacionExcluido.SELECT_BY_IND_REL, aIndividuo,
				new ListObserver(), aSesion);
	}

}
