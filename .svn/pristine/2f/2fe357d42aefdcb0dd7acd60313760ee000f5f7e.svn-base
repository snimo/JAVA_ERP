package com.srn.erp.rrhh.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.rrhh.bm.ModeloEvalCab;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBModeloEvalCab extends DBObjetoPersistente {

	public static final String OID_MOD_EVAL_CAB = "oid_mod_eval_cab";
	public static final String TITULO = "titulo";
	public static final String DESC_ABREVIADA = "desc_abreviada";
	public static final String FEC_DESDE = "fec_desde";
	public static final String FEC_HASTA = "fec_hasta";
	public static final String VIGENTE = "vigente";
	public static final String ACTIVO = "activo";
	public static final String TIPO = "tipo";
	

	public static final int SELECT_BY_VIGENTE = 100;
	public static final int SELECT_BY_ACTIVOS_BY_FECDESDE = 101;
	public static final int SELECT_BY_VIGENTE_DESEM = 102;
	public static final int SELECT_BY_VIGENTE_POTEN = 103;
	public static final int SELECT_BY_ACTIVOS_BY_FECDESDE_TIPO = 104;

	public DBModeloEvalCab() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_MOD_EVAL_CAB = 1;
		final int TITULO = 2;
		final int DESC_ABREVIADA = 3;
		final int FEC_DESDE = 4;
		final int FEC_HASTA = 5;
		final int VIGENTE = 6;
		final int ACTIVO = 7;
		final int TIPO = 8;

		ModeloEvalCab pers = (ModeloEvalCab) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into rhModEvalCab " + " ( " + "OID_MOD_EVAL_CAB," + "TITULO," + "DESC_ABREVIADA," + "FEC_DESDE," + "FEC_HASTA," + "VIGENTE," + "ACTIVO , TIPO)" + " values " + "(" + "?,"
				+ "?," + "?,"+ "?," + "?," + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_MOD_EVAL_CAB, pers.getOID());
		qInsert.setString(TITULO, pers.getTitulo());
		qInsert.setString(DESC_ABREVIADA, pers.getDesc_abreviada());
		qInsert.setDate(FEC_DESDE, new java.sql.Date(pers.getFec_desde().getTime()));
		qInsert.setDate(FEC_HASTA, new java.sql.Date(pers.getFec_hasta().getTime()));
		qInsert.setBoolean(VIGENTE, pers.isVigente().booleanValue());
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qInsert.setString(TIPO, pers.getTipo());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int TITULO = 1;
		final int DESC_ABREVIADA = 2;
		final int FEC_DESDE = 3;
		final int FEC_HASTA = 4;
		final int VIGENTE = 5;
		final int ACTIVO = 6;
		final int TIPO = 7;
		final int OID_MOD_EVAL_CAB = 8;

		ModeloEvalCab pers = (ModeloEvalCab) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update rhModEvalCab set " + "titulo=?" + ",desc_abreviada=?" + ",fec_desde=?" + ",fec_hasta=?" + ",vigente=?" + ",activo=? , tipo=? " + " where " + " oid_mod_eval_cab=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_MOD_EVAL_CAB, pers.getOID());
		qUpdate.setString(TITULO, pers.getTitulo());
		qUpdate.setString(DESC_ABREVIADA, pers.getDesc_abreviada());
		qUpdate.setDate(FEC_DESDE, new java.sql.Date(pers.getFec_desde().getTime()));
		qUpdate.setDate(FEC_HASTA, new java.sql.Date(pers.getFec_hasta().getTime()));
		qUpdate.setBoolean(VIGENTE, pers.isVigente().booleanValue());
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qUpdate.setString(TIPO, pers.getTipo());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_MOD_EVAL_CAB = 1;
		ModeloEvalCab pers = (ModeloEvalCab) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update rhModEvalCab " + " set activo=0 " + " where " + " oid_mod_eval_cab=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_MOD_EVAL_CAB, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_MOD_EVAL_CAB = 1;
		ModeloEvalCab pers = (ModeloEvalCab) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update rhModEvalCab " + " set activo=1 " + " where " + " oid_mod_eval_cab=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_MOD_EVAL_CAB, pers.getOID());
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
		case SELECT_BY_VIGENTE: {
			ps = this.selectByVigente(aCondiciones);
			break;
		}
		case SELECT_BY_VIGENTE_DESEM: {
			ps = this.selectByVigenteDesem(aCondiciones);
			break;			
		}
		case SELECT_BY_VIGENTE_POTEN: {
			ps = this.selectByVigentePoten(aCondiciones);
			break;			
		}		
		case SELECT_BY_ACTIVOS_BY_FECDESDE: {
			ps = this.selectActivosByFecDesde(aCondiciones);
			break;
		}
		case SELECT_BY_ACTIVOS_BY_FECDESDE_TIPO: {
			ps = this.selectActivosByFecDesdeTipo(aCondiciones);
			break;			
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_MOD_EVAL_CAB = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  rhModEvalCab ");
		textSQL.append(" WHERE oid_mod_eval_cab = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_MOD_EVAL_CAB, oid);
		return querySelect;
	}

	private PreparedStatement selectByVigente(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  rhModEvalCab ");
		textSQL.append(" WHERE vigente = 1 and activo = 1 order by fec_desde desc ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}
	
	private PreparedStatement selectByVigenteDesem(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  rhModEvalCab ");
		textSQL.append(" WHERE vigente = 1 and activo = 1 and tipo='"+ModeloEvalCab.TIPO_DESEN+"' order by fec_desde desc ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}	
	
	private PreparedStatement selectByVigentePoten(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  rhModEvalCab ");
		textSQL.append(" WHERE vigente = 1 and activo = 1 and tipo='"+ModeloEvalCab.TIPO_POTEN+"' order by fec_desde desc ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}	
	
	private PreparedStatement selectActivosByFecDesdeTipo(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  rhModEvalCab ");
		textSQL.append(" WHERE activo = 1 and tipo = ?  order by fec_desde desc ");
		String tipo = (String) aCondiciones;
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		querySelect.setString(1, tipo);
		return querySelect;
	}	
	

	private PreparedStatement selectActivosByFecDesde(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  rhModEvalCab ");
		textSQL.append(" WHERE activo = 1 order by fec_desde desc ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  rhModEvalCab ");
		textSQL.append(" WHERE desc_abreviada = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_mod_eval_cab oid, desc_abreviada codigo, titulo descripcion ,activo ");
		textSQL.append(" from rhModEvalCab");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static List getModelosVigentes(ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(ModeloEvalCab.NICKNAME, DBModeloEvalCab.SELECT_BY_VIGENTE, null, new ListObserver(), aSesion);
	}
	
	public static List getModelosVigentesDesempenio(ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(ModeloEvalCab.NICKNAME, DBModeloEvalCab.SELECT_BY_VIGENTE_DESEM, null, new ListObserver(), aSesion);
	}	
	
	public static List getModelosVigentesPotencial(ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(ModeloEvalCab.NICKNAME, DBModeloEvalCab.SELECT_BY_VIGENTE_POTEN, null, new ListObserver(), aSesion);
	}	

	public static List getModelosActivosOrderByFecDesde(ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(ModeloEvalCab.NICKNAME, DBModeloEvalCab.SELECT_BY_ACTIVOS_BY_FECDESDE, null, new ListObserver(), aSesion);
	}
	
	public static List getModelosActivosOrderByFecDesdeTipo(String tipo,ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(ModeloEvalCab.NICKNAME, DBModeloEvalCab.SELECT_BY_ACTIVOS_BY_FECDESDE_TIPO, tipo, new ListObserver(), aSesion);
	}	

}
